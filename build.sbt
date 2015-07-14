name := """jooq-custom-codegen"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "io.backchat.inflector" % "scala-inflector_2.11" % "1.3.5",
  "org.jooq" % "jooq-codegen" % "3.6.2"
)

libraryDependencies <+= (scalaVersion){ "org.scala-lang" % "scala-reflect" % _ }