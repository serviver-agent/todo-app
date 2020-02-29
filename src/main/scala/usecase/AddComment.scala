package usecase

import java.time.{Instant, Clock}
import entity.{TaskId, TaskComment, TaskCommentRepository}

class AddTaskComment(
    taskCommentRepository: TaskCommentRepository,
    clock: Clock
) {

  def execute(taskId: TaskId, body: String, now: Instant): TaskComment = {
    val taskComment = TaskComment.createNewTaskComment(taskId, body, clock.instant())
    taskCommentRepository.insert(taskComment)
    taskComment
  }

}
