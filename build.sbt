ThisBuild / organization := "com.scalawags"

name := "KeplerDataReader"
version := "1.0"
scalaVersion := "2.13.4"

lazy val kepler = (project in file(".")).settings(
    name := "Kepler Data Reader",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    )