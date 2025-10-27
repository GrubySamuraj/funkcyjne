package app
object MinimalApplication extends cask.MainRoutes:
  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def hello() =
    "Hello World! 123"

  @cask.postJson("/isSorted")
  def isSorted(method: String, arr: List[Int]) = {
    var isSortedCorrectly: Boolean = false
    if method == "asc" then
      isSortedCorrectly =
        arr.zip(arr.tail).forall { case (previous, next) => previous <= next }
    else if method == "desc" then
      isSortedCorrectly =
        arr.zip(arr.tail).forall { case (previous, next) => previous >= next }
    else isSortedCorrectly = false
    print(isSortedCorrectly)
    ujson.Obj(
      "method" -> method,
      "providedArray" -> arr,
      "isSorted" -> isSortedCorrectly
    )
  }

  initialize()
