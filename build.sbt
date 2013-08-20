libraryDependencies += "org.tmatesoft.svnkit" % "svnkit" % "1.3.3"

parallelExecution in Test := false

resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-lang3" % "3.1",
  "commons-io" % "commons-io" % "2.4",
  "junit" % "junit" % "4.10",
  "org.specs2" %% "specs2" % "1.11" % "test",
  "org.slf4j" % "slf4j-nop" % "1.7.5",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "com.typesafe.akka" % "akka-actor" % "2.0.1"
)

testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")