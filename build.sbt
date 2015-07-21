name := """jooq-custom-codegen"""

organization := "triplec1988"

version := "1.0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "io.backchat.inflector" % "scala-inflector_2.11" % "1.3.5",
  "org.jooq" % "jooq-codegen" % "3.6.2",
  "com.typesafe" % "config" % "1.3.0"
)

exportJars := true

libraryDependencies <+= (scalaVersion){ "org.scala-lang" % "scala-reflect" % _ }
