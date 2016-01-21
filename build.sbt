name := """bookshelf"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test

)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "1.1.1"
//libraryDependencies += "com.sandinh" %% "play-hikaricp" % "1.7.1"
// libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1"
//libraryDependencies += "com.typesafe.play" % "play-java-jdbc_2.11" % "2.4.6"
//libraryDependencies += "com.typesafe.play" % "twirl-api_2.11" % "1.1.1"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := false

