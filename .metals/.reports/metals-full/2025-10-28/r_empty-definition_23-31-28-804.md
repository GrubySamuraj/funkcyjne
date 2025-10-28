error id: file:///C:/Users/jakub/Desktop/funkcyjne/zad1/src/main/scala/Main.scala:`<none>`.
file:///C:/Users/jakub/Desktop/funkcyjne/zad1/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -`**`.
	 -`**`#
	 -`**`().
	 -scala/Predef.`**`.
	 -scala/Predef.`**`#
	 -scala/Predef.`**`().
offset: 1906
uri: file:///C:/Users/jakub/Desktop/funkcyjne/zad1/src/main/scala/Main.scala
text:
```scala
package app
import scala.collection.mutable.ListBuffer
object MinimalApplication extends cask.MainRoutes:
  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def helloWorld = {
    "Hello world!"
  }

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
    var list3 = list1.zip(list2).map((item1,item2)=> item1**@@2+item2**2)
    list3
  }

  initialize()

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.