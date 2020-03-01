package infile

import java.nio.file.{Path, Paths, Files}
import scala.jdk.CollectionConverters._

import VersionManager.UnsupportedVersionException
import java.nio.charset.Charset
import java.nio.file.StandardOpenOption

class VersionManager(basePath: Path) {

  val CurrentVersion = 1

  def initialize(): Unit = {
    if (!fileExists()) createFile()
    else if (!isLatestVersion()) {
      migrate()
    }
  }

  private def fileExists(): Boolean = {
    Files.isReadable(basePath)
  }

  private def createFile(): Unit = {
    Files.createDirectory(basePath)
    val versionPath = basePath.resolve(".version")
    Files.createFile(versionPath)
    Files.write(versionPath, List("TODO 1").asJava, Charset.forName("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING)
  }

  @throws[UnsupportedVersionException]
  private def isLatestVersion(): Boolean = {
    val versionPath = basePath.resolve(".version")
    if (!Files.isReadable(versionPath)) throw new UnsupportedVersionException(".version file does not exist.")
    val contents: Iterator[String] = Files.lines(versionPath).iterator().asScala
    if (!contents.hasNext) throw new UnsupportedVersionException(".version file is empty")
    val line                        = contents.next()
    val Array(artifact, versionStr) = line.split(" ", 2)
    if (artifact != "TODO") throw new UnsupportedVersionException(".version file has illegal artifact name")
    val version: Int =
      versionStr.toIntOption.getOrElse(throw new UnsupportedVersionException(".version has illegal version"))
    version == CurrentVersion
  }

  private def migrate(): Unit = {
    println("migrate")
  }

}

object VersionManager {

  class UnsupportedVersionException(message: String) extends RuntimeException(message)

  def defaultBasePath(): Path = {
    val home = System.getProperty("user.home")
    Paths.get(home).resolve("todo")
  }

  def useDefaultBasePath(): VersionManager = {
    new VersionManager(VersionManager.defaultBasePath)
  }

}
