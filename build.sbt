name := "FizzBuzz"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.7.2" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")

scapegoatVersion := "1.1.0"

coverageEnabled := true
