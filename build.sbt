name := "CookUp"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

libraryDependencies ++= Seq(
	"com.fasterxml.jackson.core" % "jackson-databind" % "2.3.0",
	"org.mockito" % "mockito-all" % "1.9.5" % "test",
	"junit" % "junit" % "4.11" % "test",
	"org.skyscreamer" % "jsonassert" % "1.2.1" % "test",
	"org.apache.httpcomponents" % "httpclient" % "4.2.5" ,
	"ch.qos.logback" % "logback-core" % "1.0.13",
	"ch.qos.logback" % "logback-classic" % "1.0.13",
	"org.slf4j" % "slf4j-api" % "1.7.5",
	"org.slf4j" % "jcl-over-slf4j" % "1.7.5"
)

play.Project.playJavaSettings
