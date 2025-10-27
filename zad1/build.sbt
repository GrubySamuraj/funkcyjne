val scala3Version = "3.7.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "zad1",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "com.lihaoyi" %% "cask" % "0.11.3"
    ),
    mainClass := Some("app.MinimalApplication"),
  )
