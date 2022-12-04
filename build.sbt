ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "DevCycle-Integration-With-Scala"
  )

val devCycleVersion = "1.1.1"

libraryDependencies +=  "com.devcycle" % "java-server-sdk" % devCycleVersion
