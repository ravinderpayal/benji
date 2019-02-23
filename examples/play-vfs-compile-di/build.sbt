name := "benji-vfs-play-demo"

scalaVersion := "2.12.8"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-target:jvm-1.8",
  "-Ywarn-adapted-args",
  "-Ywarn-inaccessible",
  "-Ywarn-nullary-override",
  "-Ywarn-infer-any",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
  "-unchecked",
  "-deprecation",
  "-feature",
  "-g:vars",
  "-Xlint:_",
  "-opt:_"
)

version := "2.0.3"

val playVer = Def.setting[String] {
  if (version.value endsWith "-SNAPSHOT") {
    s"${version.value.dropRight(9)}-play27-SNAPSHOT"
  } else {
    s"${version.value}-play27"
  }
}

resolvers ++= Seq(
  "Entrepot Releases" at "https://raw.githubusercontent.com/zengularity/entrepot/master/releases",
  "Entrepot Snapshots" at "https://raw.githubusercontent.com/zengularity/entrepot/master/snapshots"
)

libraryDependencies ++= Seq(
  "com.zengularity" %% "benji-vfs" % version.value,
  "com.zengularity" %% "benji-play" % playVer.value,
)

lazy val playVfs = (project in file(".")).enablePlugins(PlayScala)
