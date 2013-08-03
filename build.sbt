libraryDependencies += "org.tmatesoft.svnkit" % "svnkit" % "1.3.3"

parallelExecution in Test := false

resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")

libraryDependencies ++= Seq(
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.0",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.0",
  "org.apache.commons" % "commons-lang3" % "3.1",
  "commons-io" % "commons-io" % "2.4",
  "junit" % "junit" % "4.10",
  "org.specs2" %% "specs2" % "1.10" % "test",
  "org.slf4j" % "slf4j-nop" % "1.7.5",
  "org.slf4j" % "slf4j-api" % "1.7.5"
)

testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")