package usecase

import java.time.Clock
import entity.{Project, ProjectRepository}

class CreateNewProject(
    projectRepository: ProjectRepository,
    clock: Clock
) {

  def execute(projectName: String): Project = {
    val project = Project.createNewProject(projectName, clock.instant())
    projectRepository.insert(project)
    project
  }

}
