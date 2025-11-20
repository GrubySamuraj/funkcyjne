package app.zad3

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
    numOfElements += 1
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
    while (current != null && i < n) {
      returned = returned :+ current.data
      current = current.next
      if (head != null) head.prev = null
      i += 1
      numOfElements -= 1
    }
    returned
  }
}
class Zadanie03 extends cask.Routes {
  @cask.postJson("tail")
  def testTails(list: List[Int]) = {
    var doubleLinkedList = new DoublyLinkedList(list)
    if (list == Nil) {
      Nil
    } else {
      doubleLinkedList
      doubleLinkedList.tail()
    }
  }

  @cask.postJson("drop")
  def dropItems(list: List[Int], n: Int) = {
    var doubleLinkedList = new DoublyLinkedList(list)
    doubleLinkedList.drop(n)
  }
}
