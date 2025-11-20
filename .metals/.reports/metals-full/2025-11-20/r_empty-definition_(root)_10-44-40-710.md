file://<WORKSPACE>/zad1/src/main/scala/zad4/zad4.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:
	 -newListBuffer.
	 -newListBuffer#
	 -newListBuffer().
	 -scala/Predef.newListBuffer.
	 -scala/Predef.newListBuffer#
	 -scala/Predef.newListBuffer().
offset: 324
uri: file://<WORKSPACE>/zad1/src/main/scala/zad4/zad4.scala
text:
```scala
package app.zad4
import scala.collection.mutable.ListBuffer

object Zadanie4Controller extends cask.Routes {
  @cask.get("/appendOptional")
  def appendEndpoint(
      list: List[Int],
      appendIndex: Int,
      elementToAdd: Int
  ): Option[ListBuffer[Int]] = {
    this.append(list, appendIndex, elementToAdd)
    newLi@@stBuffer
  }
  def append(
      list: List[Int],
      appendIndex: Int,
      elementToAdd: Int
  ): Option[ListBuffer[Int]] = {
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
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 