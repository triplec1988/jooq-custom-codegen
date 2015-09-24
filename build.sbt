name := """jooq-custom-codegen"""

organization := "triplec1988"

version := "1.1.2"

scalaVersion in GlobalScope := "2.11.7"

crossScalaVersions := Seq("2.9.3", "2.10.4", "2.11.7")

libraryDependencies ++= Seq(
  "io.backchat.inflector" % "scala-inflector_2.11" % "1.3.5",
  "org.jooq" % "jooq-codegen" % "3.6.2",
  "com.typesafe" % "config" % "1.3.0"
)

exportJars := true

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies <+= (scalaVersion){ "org.scala-lang" % "scala-reflect" % _ }
