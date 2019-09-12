import sbt.Keys.version

lazy val root = (project in file(".")).
  settings(
    name := "telegram-anti-spam-bot",
    version := "0.4",
    scalaVersion := "2.12.7",
    mainClass in Compile := Some("Server")
  )

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.6.0",
  "org.typelevel" %% "cats-effect" % "1.2.0",
  "com.bot4s" %% "telegram-core" % "4.0.0-RC1",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.2",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe" % "config" % "1.3.4",
  "com.github.pureconfig" %% "pureconfig" % "0.11.1",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
)

javaOptions := Seq("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=36268")