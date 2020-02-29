package entity

import java.time.Instant
import java.util.UUID

case class TaskId(value: UUID)

case class Task(
    id: TaskId,
    projectId: ProjectId,
    title: String,
    description: String,
    comments: Seq[TaskComment],
    deadline: Instant,
    status: TaskStatus,
    createdAt: Instant
) {

  def withComment(newComment: TaskComment): Task = {
    copy(comments = comments :+ newComment)
  }

}

object Task {

  def createNewTask(projectId: ProjectId, title: String, description: String, deadline: Instant, now: Instant): Task = {
    val id = TaskId(UUID.randomUUID())
    Task(id, projectId, title, description, Seq.empty, deadline, TaskStatus.Undone, now)
  }

}
