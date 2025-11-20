file://<WORKSPACE>/zad1/src/main/scala/zad4/zad4.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:
	 -ListBuffer.
	 -ListBuffer#
	 -ListBuffer().
	 -scala/Predef.ListBuffer.
	 -scala/Predef.ListBuffer#
	 -scala/Predef.ListBuffer().
offset: 239
uri: file://<WORKSPACE>/zad1/src/main/scala/zad4/zad4.scala
text:
```scala
package app.zad4

object Zadanie4Controller extends cask.Routes {
  @cask.get("/appendOptional")
  def append(
      list: List[Int],
      appendIndex: Int,
      elementToAdd: Int
  ): Option[ListBuffer[Int]] = {
    val newListBuffer = @@ListBuffer[Int]()
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
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 