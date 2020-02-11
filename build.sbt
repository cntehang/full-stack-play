name := """play-bootstrap4-admin"""

version := "4.1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.1"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"

scalacOptions ++= Seq("-feature", "-deprecation", "-Xfatal-warnings")

// Client side
libraryDependencies += "org.webjars" % "jquery" % "3.4.1"
libraryDependencies += "org.webjars" % "jquery-easing" % "1.4.1"
libraryDependencies += "org.webjars" % "bootstrap" % "4.4.1-1"
libraryDependencies += "org.webjars" % "datatables" % "1.10.20"
libraryDependencies += "org.webjars" % "chartjs" % "2.9.3"
libraryDependencies += "org.webjars" % "font-awesome" % "5.12.0"
