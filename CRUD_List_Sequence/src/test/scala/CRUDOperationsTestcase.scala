
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CRUDOperationsTestcase extends AnyFlatSpec with Matchers {
  //CRUD using List

  "A CRUDUsingList" should "create a new list with the value added to it" in {
    val crud = new CRUDUsingList[String]()
    val list = List("Apple", "Mango", "Guava")
    val resultantList = crud.create("Banana", list)
    resultantList should contain("Banana")
  }
  it should "create a new list[Integer] with the value added to it" in {
    val crud = new CRUDUsingList[Int]()
    val list = List(1, 2, 3)
    val resultantList = crud.create(14, list)
    resultantList should contain(14)
  }

  it should "update the element in the list with the updateValue" in {
    val crud = new CRUDUsingList[String]()
    val list = List("Apple", "Mango", "Guava")
    val resultantList = crud.update("Banana", "Apple", list)
    resultantList should equal(List("Banana", "Mango", "Guava"))
    resultantList should not contain ("Apple")
  }
  it should "return the original list if the element to update is not found" in {
    val crud = new CRUDUsingList[String]()
    val list = List("Apple", "Mango", "Guava")
    val resultantList = crud.update("Banana", "Pumpkin", list)
    resultantList should equal(List("Apple", "Mango", "Guava"))
  }

  it should "delete the element from the list" in {
    val crud = new CRUDUsingList[String]()
    val list = List("Apple", "Mango", "Guava")
    val resultantList = crud.delete("Apple", list)
    resultantList should equal(List("Mango", "Guava"))
  }
  it should "return the same list when trying to delete the element which is not present in the list" in {
    val crud = new CRUDUsingList[String]()
    val list = List("Apple", "Mango", "Guava")
    val resultantList = crud.delete("Papaya", list)
    resultantList should equal(List("Apple", "Mango", "Guava"))
  }

  // CRUD using Sequence

  "A CRUDUsingSequence" should "create a new a sequence[String] with the value added to it" in {
    val crud = new CRUDUsingSequence[String]()
    val list = Seq("Apple", "Mango", "Guava")
    val resultantList = crud.create("Papaya", list)
    resultantList should contain("Papaya")
  }
  it should "create a new a sequence[Integer] with the value added to it" in {
    val crud = new CRUDUsingSequence[Int]()
    val list = Seq(101, 201, 301)
    val resultantList = crud.create(401, list)
    resultantList should contain(401)
  }
  it should "update the value[String] in the list with the given updated value " in {
    val crud = new CRUDUsingSequence[String]()
    val list = Seq("Apple", "Mango", "Guava")
    val resultantList = crud.update("Papaya", "Guava", list)
    resultantList should equal(Seq("Apple", "Mango", "Papaya"))
  }
  it should "update the value[Integer] in the list with the given updated value " in {
    val crud = new CRUDUsingSequence[Int]()
    val list = Seq(101, 201, 301)
    val resultantList = crud.update(401, 301, list)
    resultantList should equal(Seq(101, 201, 401))
  }
  it should "return the same list when trying to delete the element which is not present in the list" in {
    val crud = new CRUDUsingSequence[String]()
    val list = Seq("Apple", "Mango", "Guava")
    val resultantList = crud.delete("Papaya", list)
    resultantList should equal(Seq("Apple", "Mango", "Guava"))
  }

}
