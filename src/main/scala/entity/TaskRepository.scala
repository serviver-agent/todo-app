package entity

trait TaskRepository {

  def findAll(projectId: ProjectId): Seq[Task]

  def insert(task: Task): Unit

}
