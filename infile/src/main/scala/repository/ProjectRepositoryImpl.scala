package infile.repository

import entity.{Project, ProjectRepository}
import java.nio.file.Path

class ProjectRepositoryImpl(basePath: Path) extends ProjectRepository {

  override def findAll(): Seq[Project] = {
    ???
  }

  override def insert(project: Project): Unit = ???

}
