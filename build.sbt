name := "popularity_contest"

version := "0.0.1"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-json" % "2.5.1",
  "org.specs2" %% "specs2" % "2.0" % "test",
  "org.codehaus.groovy" % "groovy-all" % "1.8.8" % "compile",
  "co.freeside" % "betamax" % "1.1.2" % "compile"
)

/*
  Rather than deal with heinous sync'ing around the use of a proxy server,
  let's just run sequentially.
*/
parallelExecution in Test := false