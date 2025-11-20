package app.zad4
import scala.collection.mutable.ListBuffer

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

  initialize()
}
