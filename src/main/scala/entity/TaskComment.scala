package entity

import java.time.Instant
import java.util.UUID

case class TaskCommentId(value: UUID)

case class TaskComment(
    id: TaskCommentId,
    taskId: TaskId,
    body: String,
    createdAt: Instant
)

object TaskComment {

  def createNewTaskComment(taskId: TaskId, body: String, now: Instant): TaskComment = {
    val id = TaskCommentId(UUID.randomUUID)
    TaskComment(id, taskId, body, now)
  }

}
