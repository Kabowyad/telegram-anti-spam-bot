import sbt.Keys.version

lazy val root = (project in file(".")).
  settings(
    name := "telegram-anti-spam-bot",
    version := "0.1",
    scalaVersion := "2.12.7",
    mainClass in Compile := Some("Server")
  )

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.6.0",
  "org.typelevel" %% "cats-effect" % "1.2.0",
  "com.bot4s" %% "telegram-core" % "4.0.0-RC1",
  "com.typesafe.slick" %% "slick" % "3.2.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

javaOptions := Seq("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=36268")