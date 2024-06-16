package br.com.tasks.data.service

import br.com.tasks.core.domain.data.repository.TaskRepository
import br.com.tasks.core.domain.data.service.TaskService
import br.com.tasks.core.domain.model.Task

class TaskServiceImpl constructor(
    private val taskRepository:TaskRepository
): TaskService {

    override suspend fun getTasks(): List<Task> {
        return taskRepository.getTasks()
    }
}