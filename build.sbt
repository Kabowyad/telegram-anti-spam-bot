name := "telegram-anti-spam-bot"

version := "0.1"

scalaVersion := "2.12.8"
scalacOptions += "-Ypartial-unification" // 2.11.9+

libraryDependencies += "com.bot4s" %% "telegram-core" % "4.0.0-RC2"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.2" % Test

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.4.0",
  "org.typelevel" %% "cats-effect" % "1.0.0",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.tpolecat" %% "doobie-core" % "0.6.0"
)