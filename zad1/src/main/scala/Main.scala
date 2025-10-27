package app
object MinimalApplication extends cask.MainRoutes:
  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def hello() =
    "Hello World!"
    
  initialize()
