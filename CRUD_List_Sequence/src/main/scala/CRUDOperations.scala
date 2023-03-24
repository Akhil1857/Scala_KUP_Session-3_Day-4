// It is Generic[A] as well as Abstract Class
abstract class CRUDOperations[A] {
  def create(value: A, list: Seq[A]): Seq[A]

  def read(list: Seq[A]): Seq[A]

  def update(valueAoInsert: A, valueAoUpdate: A, list: Seq[A]): Seq[A]

  def delete(value: A, list: Seq[A]): Seq[A]

}

// CRUD :- C-create R-read U- update D- delete using the List

class CRUDUsingList[A] extends CRUDOperations[A] {
  override def create(value: A, list: Seq[A]): List[A] = {
    value :: list.toList
  }

  override def read(list: Seq[A]): List[A] = {
    list.toList
  }

  override def update(valueAoInsert: A, valueAoUpdate: A, list: Seq[A]): List[A] = {
    try {
      val index = list.indexOf(valueAoUpdate)
      if (index >= 0) {
        val updatedList = list.updated(index, valueAoInsert)
        updatedList.toList
      }
      else {
        list.toList
      }
    } catch {
      case ex: NoSuchElementException => println(s"Error: ${ex.getMessage}")
        list.toList
    }
  }

  override def delete(value: A, list: Seq[A]): List[A] = {
    val updatedList = list.filter(_ != value)
    updatedList.toList
  }
}

// CRUD :- C-create R-read U- update D- delete using the Sequence

class CRUDUsingSequence[A] extends CRUDOperations[A] {
  override def create(value: A, sequence: Seq[A]): Seq[A] = {
    value +: sequence
  }

  override def read(sequence: Seq[A]): Seq[A] = sequence

  override def update(valueAoInsert: A, valueAoUpdate: A, sequence: Seq[A]): Seq[A] = {
    try {
      val index = sequence.indexOf(valueAoUpdate)
      if (index >= 0) {
        sequence.updated(index, valueAoInsert)
      }
      else {
        throw new NoSuchElementException("valueAoUpdate not found")
      }
    } catch {
      case ex: NoSuchElementException => println(s"Error: ${ex.getMessage}")
        sequence
    }
  }

  override def delete(value: A, sequence: Seq[A]): Seq[A] = {
    val updatedList = sequence.filter(_ != value)
    updatedList
  }
}


