package app.zad4
import scala.collection.mutable.ListBuffer
import scala.math.pow
object Zadanie4Controller extends cask.Routes {
  @cask.postJson("/appendOptional")
  def appendEndpoint(
      list: List[Int],
      appendIndex: Int,
      elementToAdd: Int
  ): ujson.Value = {
    var result = this.append(list, appendIndex, elementToAdd)
    result match
      case Some(result) => ujson.Arr.from(result)
      case None         => ujson.Str("Nic")
  }
  def append(
      list: List[Int],
      appendIndex: Int,
      elementToAdd: Int
  ): Option[ListBuffer[Int]] = {
    if (appendIndex < 0 || appendIndex > list.length) return None
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
    Some(newListBuffer)
  }
  @cask.postJson("/makeVarianceOptional")
  def makeVariance(
      list: List[Int]
  ): ujson.Value = {
    var mean = this.makeMean(list)
    mean match
      case Some(mean) => {
        list
          .map(element => pow((element - mean).toDouble, 2))
          .sum / (list.length - 1)
      }
      case None => return ujson.Str("Ni ma elementów w liście")

  }

  def makeMean(list: List[Int]): Option[Float] = {
    if (list.length == 0) {
      return None
    }
    Some((list.sum.toFloat / list.length))
  }
  @cask.postJson("/concatTwoListOptional")
  def concatTwoListController(
      list1: Option[List[Int]],
      list2: Option[List[Int]]
  ): ujson.Value = {
    var result = this.concatTwoList(list1, list2)
    result match
      case Some(result) => ujson.Arr(result)
      case None         => ujson.Str("Jedna z list jest None")

  }
  def concatTwoList(
      list1: Option[List[Int]],
      list2: Option[List[Int]]
  ): Option[List[Int]] = {
    (list1, list2) match {
      case (Some(list1), Some(list2)) => return Some(list1 ::: list2)
      case _                          => return None
    }
  }
  @cask.postJson("/myMap")
  def myMapMethod(
      list1: Option[List[Int]],
      list2: Option[List[Int]]
  ): ujson.Value = {
    val resultOption = this.mojeMap(list1, list2) { (l1, l2) =>
      l1 ++ l2
    }
    resultOption match {
      case Some(list) => ujson.Arr(list)
      case None       => ujson.Str("Nic")
    }
  }

  def mojeMap[A, B, C](a: Option[A], b: Option[B])(
      f: (A, B) => C
  ): Option[C] = {
    a.flatMap(itemA => b.map(itemB => f(itemA, itemB)))
  }

  @cask.postJson("/mean")
  def calcAverageController(list: List[Int]): ujson.Value = {
    val result = calcAverage(list)
    result match
      case Left(value)  => ujson.Str(value)
      case Right(value) => ujson.Arr(value)
  }
  def calcAverage(list: List[Int]): Either[String, Float] = {
    if (list.length == 0) {
      Left("Lista nie ma elementów")
    } else {
      Right((list.sum.toFloat / list.length).toFloat)
    }
  }
  initialize()
}
