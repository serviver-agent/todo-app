package entity

trait TaskCommentRepository {

  def findAll(taskId: TaskId): Seq[TaskComment]

  def insert(taskComment: TaskComment): Unit

}
