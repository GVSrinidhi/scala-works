name := "crudoperations"

version := "0.1"

scalaVersion := "2.13.3"


libraryDependencies += "org.typelevel" %% "cats-effect" % "2.1.1" withSources() withJavadoc()
libraryDependencies += "org.http4s" %% "http4s-core" % "0.21.4"
libraryDependencies += "org.http4s" %% "http4s-dsl" % "0.21.4"
libraryDependencies += "io.circe" %% "circe-core" % "0.13.0"
libraryDependencies += "io.circe" %% "circe-generic" % "0.13.0"
libraryDependencies += "org.http4s" %% "http4s-circe" % "0.21.4"
libraryDependencies += "org.http4s" %% "http4s-server" % "0.21.4"
libraryDependencies += "org.http4s" %% "http4s-blaze-server" % "0.21.4"
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"


libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.12.1" % Test


scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds"
)