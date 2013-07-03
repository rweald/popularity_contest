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
  Since we're running a proxy server for our integration examples, and only
  one proxy server can be running at a time, let's forgo coordinating that
  complexity and simply run our specs sequentially.
*/
parallelExecution in Test := false

/*
  Per the SBT-to-Sonatype publishing guidelines located here:
    http://www.scala-sbt.org/0.12.3/docs/Community/Using-Sonatype.html
*/
publishMavenStyle := true
publishArtifact in Test := false
publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
pomIncludeRepository := { _ => false }
licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
homepage := Some(url("https://github.com/sharethrough/popularity_contest"))
