name := "Lift 3.0-SNAPSHOT starter template"

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.10.1"

resolvers ++= Seq(
  "Java.net Maven2 Repository"     at "http://download.java.net/maven/2/",
  "Sonatype scala-tools repo"      at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype scala-tools releases"  at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype scala-tools snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

seq(webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

{
  val liftVersion = "3.0-SNAPSHOT"
  libraryDependencies ++= Seq(
    "net.liftweb"             %% "lift-webkit"       % liftVersion             % "compile",
    "net.liftweb"             %% "lift-mapper"       % liftVersion             % "compile",
    "ch.qos.logback"          %  "logback-classic"   % "1.0.6",
    "junit"                   %  "junit"             % "4.7"                   % "test",
    "org.specs2"              %% "specs2"            % "1.14"                  % "test",
    "org.pegdown"             %  "pegdown"           % "1.1.0"                 % "test",
    "org.scalatest"           %% "scalatest"         % "2.0.M5b"               % "test",
    "org.eclipse.jetty"       %  "jetty-webapp"      % "8.1.7.v20120910"       %  "container,compile",
    "org.eclipse.jetty.orbit" %  "javax.servlet"     % "3.0.0.v201112011016"   %  "container,compile" artifacts Artifact("javax.servlet", "jar", "jar"),
    "net.liftmodules"         %% "mapperauth_2.5"    % "0.1-SNAPSHOT"          %  "compile" intransitive(),
    "net.liftmodules"         %% "extras_2.5"        % "0.1"                   %  "compile" intransitive(),
    "com.h2database"          %  "h2"                % "1.2.138",
    "net.databinder.dispatch" %% "dispatch-core"     % "0.10.0"
    //"net.liftmodules"         %% "lift-jquery-module_3.0-SNAPSHOT" % "2.4"
  )
}
