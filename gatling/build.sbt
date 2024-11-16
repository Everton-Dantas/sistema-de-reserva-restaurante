
name := "GatlingLoadTest"

version := "1.0"

scalaVersion := "2.13.10"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling" % "gatling-core" % "3.9.5" % Test,
  "io.gatling" % "gatling-http" % "3.9.5" % Test
)

gatlingVersion := "3.9.5"
