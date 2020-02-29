package usecase

import java.time.{Instant, Clock}
import entity.{ProjectId, Task, TaskRepository}

class AddTask(
    taskRepository: TaskRepository,
    clock: Clock
) {

  def execute(projectId: ProjectId, title: String, description: String, deadline: Instant): Task = {
    val task = Task.createNewTask(projectId, title, description, deadline, clock.instant())
    taskRepository.insert(task)
    task
  }

}
