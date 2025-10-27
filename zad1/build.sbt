val scala3Version = "3.3.7"

lazy val root = project
  .in(file("."))
  .settings(
    assembly / mainClass := Some("com.MinimalApplication"),
    name := "zad1",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "com.lihaoyi" %% "cask" % "0.11.3"
    ),
    mainClass := Some("app.MinimalApplication"),

    assembly / mainClass := Some("app.MinimalApplication"),
    assembly / assemblyJarName := "app-assembly.jar",
    assembly / test := {},

    assembly / assemblyMergeStrategy := {
      case PathList("reference.conf") => MergeStrategy.concat
      case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
      case _ => MergeStrategy.first
    }
  )
