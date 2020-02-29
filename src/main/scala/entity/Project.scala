package entity

import java.time.Instant
import java.util.UUID

case class ProjectId(value: UUID)

case class Project(
    id: ProjectId,
    projectName: String,
    tasks: Seq[Task],
    createdAt: Instant
) {

  def withTask(newTask: Task): Project = {
    copy(tasks = tasks :+ newTask)
  }

}

object Project {

  def createNewProject(projectName: String, now: Instant): Project = {
    val id = ProjectId(UUID.randomUUID())
    Project(id, projectName, Seq.empty, now)
  }

}
