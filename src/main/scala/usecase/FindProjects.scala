package usecase

import entity.{Project, ProjectRepository}

class FindProjects(
    projectRepository: ProjectRepository
) {

  def execute(): Seq[Project] = {
    projectRepository.findAll()
  }

}
