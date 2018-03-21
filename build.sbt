name := "spark-dummy"
scalaVersion := "2.11.8"
organization := "ilittleangel"

version in ThisBuild := "1.0.0-SNAPSHOT"

resolvers += "repository cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

val sparkVersion = "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

