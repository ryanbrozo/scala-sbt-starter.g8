import sbt.Keys._
import sbt._

/**
 * Holds commonly used scala library dependencies
 */
object BuildDependencies {

  //----------------------------------------
  // Resolvers
  //----------------------------------------
  val defaultResolvers = Seq(
    "Spray Repository"      at "http://repo.spray.io",
    "Typesafe Repository"   at "http://repo.typesafe.com/typesafe/releases/"
  )

  //----------------------------------------
  // Commonly used dependencies
  //----------------------------------------
  val SPRAY_VERSION = "1.3.1"

  val sprayRouting =    "io.spray"                  %% "spray-routing"  % SPRAY_VERSION
  val sprayCan =        "io.spray"                  %% "spray-can"      % SPRAY_VERSION
  val sprayIo =         "io.spray"                  %% "spray-io"       % SPRAY_VERSION
  val sprayClient =     "io.spray"                  %% "spray-client"   % SPRAY_VERSION
  val sprayHttp =       "io.spray"                  %% "spray-http"     % SPRAY_VERSION
  val sprayHttpX =      "io.spray"                  %% "spray-httpx"    % SPRAY_VERSION
  val sprayUtil =       "io.spray"                  %% "spray-util"     % SPRAY_VERSION
  val sprayTestKit =    "io.spray"                  %% "spray-testkit"  % SPRAY_VERSION   % "test"
  val scalaXml =        "org.scala-lang.modules"    %% "scala-xml"      % "1.0.2"
  val akkaActor =       "com.typesafe.akka"         %% "akka-actor"     % "2.3.6"
  val specs2 =          "org.specs2"                %% "specs2-core"    % "2.4.13"        % "test"
}

/**
 * Defines project-specific settings
 */
object BuildSettings {
  import BuildDependencies._

  val SCALA_VERSION = "$scalaVersion$"
  val APP_VERSION = "0.1"

  lazy val commonSettings = Seq(
    organization        := "$package$",
    version             := APP_VERSION,
    scalaVersion        := SCALA_VERSION,
    scalacOptions       ++= Seq("-feature", "-deprecation"),
    resolvers           ++= defaultResolvers,
    libraryDependencies ++= Seq(
      specs2
    )
  )
}

object ProjectBuild extends Build {
  import BuildSettings._

  lazy val root = Project(
    id = "$name$",
    base = file(".")
  )
    .settings(commonSettings: _*)
}