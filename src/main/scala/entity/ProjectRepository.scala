package entity

trait ProjectRepository {

  def findAll(): Seq[Project]

  def insert(project: Project): Unit

}
