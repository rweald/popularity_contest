organization := "com.sharethrough"

name := "popularity_contest"

version := "0.9"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-json" % "2.5.1",
  "org.specs2" %% "specs2" % "2.0" % "test",
  "org.codehaus.groovy" % "groovy-all" % "1.8.8" % "test",
  "co.freeside" % "betamax" % "1.1.2" % "test"
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
licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

homepage := Some(url("https://github.com/sharethrough/popularity_contest"))

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:sharethrough/popularity_contest</url>
    <connection>scm:git:git@github.com:sharethrough/popularity_contest</connection>
  </scm>
  <developers>
    <developer>
      <id>rslifka</id>
      <name>Robert Slifka</name>
      <url>http://github.com/rslifka</url>
    </developer>
  </developers>
)

publishArtifact in Test := false

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
