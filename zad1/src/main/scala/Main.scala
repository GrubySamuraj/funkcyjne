package app
import scala.collection.mutable.ListBuffer
import zad4.Zadanie4Controller

class Node[T](var data: T, var prev: Node[T] = null, var next: Node[T] = null)
class DoublyLinkedList[T](elements: List[T]) {
  var head: Node[T] = null
  var tailValue: Node[T] = null
  var numOfElements = 0
  for (elem <- elements) {
    val newNode = new Node(elem)
    if (head == null) {
      head = newNode
      tailValue = newNode
    } else {
      tailValue.next = newNode
      newNode.prev = tailValue
      tailValue = newNode
    }
    numOfElements+=1
  }

  def toList(): List[T] = {
    var current = head
    var returned = List[T]()
    while (current != null) {
      returned = returned :+ current.data
      current = current.next
    }
    returned
  }

  def tail(): List[T] = {
    if (head != null) {
      head = head.next
      if (head != null) head.prev = null
      numOfElements -= 1
    }
    toList()
  }

  def drop(n: Int): List[T] = {
    var current = head
    var i = 0
    var returned = List[T]()
    while(current != null && i < n){
      returned = returned :+ current.data
      current = current.next
      if (head != null) head.prev = null
      i+=1
      numOfElements-=1
    }
    returned
  }
}

object MinimalApplication extends cask.MainRoutes{
  override def host: String = "0.0.0.0"
  override def port: Int = 8080
  override def allRoutes = Seq(this, Zadanie4Controller)

  @cask.postJson("/isSorted")
  def isSorted(method: String, arr: List[Int]) = {
    var isSortedCorrectly: Boolean = false
    if method == "asc" then
      for element <- arr.sliding(2) do {
        val previous = element(0)
        val next = element(1)
        if previous > next then isSortedCorrectly = false
      }
      isSortedCorrectly = true
    else isSortedCorrectly = false

    ujson.Obj(
      "method" -> method,
      "providedArray" -> arr,
      "isSorted" -> isSortedCorrectly
    )
  }

  @cask.postJson("/sum")
  def sumRows(list1: List[Int], list2: List[Int], list3: List[Int]) = {
    val list1_2 = list1.zip(list2).map((item1, item2) => item1 + item2)
    val list1_2_3 = list1_2.zip(list3).map((item1, item2) => item1 + item2)
    list1_2_3
  }

  @cask.postJson("setHead")
  def setHead(list: List[Int], element: Int) = {
    val newListBuffer = ListBuffer[Int]()
    newListBuffer.append(element)
    for (lastElement <- list) {
      newListBuffer.append(lastElement)
    }
    newListBuffer
  }

  @cask.postJson("append")
  def append(list: List[Int], appendIndex: Int, elementToAdd: Int) = {
    val newListBuffer = ListBuffer[Int]()
    for ((element, index) <- list.zipWithIndex) {
      if (index == appendIndex) {
        newListBuffer.append(elementToAdd)
      }
      newListBuffer.append(element)
    }

    if (appendIndex == list.length) {
      newListBuffer.append(elementToAdd)
    }

    newListBuffer
  }

  @cask.postJson("squares")
  def makeSquares(list1:List[Int], list2:List[Int]) = {
    var list3 = list1.zip(list2).map((item1, item2)=> item1* item1 + item2*item2)
    list3
  }

  @cask.postJson("tail")
  def testTails(list: List[Int]) = {
    var doubleLinkedList = new DoublyLinkedList(list)
    if (list == Nil){
      Nil
    }
    else{doubleLinkedList
      doubleLinkedList.tail()
    }
  }

  @cask.postJson("drop")
  def dropItems(list: List[Int], n: Int) = {
    var doubleLinkedList = new DoublyLinkedList(list)
    doubleLinkedList.drop(n)
  }

  initialize()
  }

