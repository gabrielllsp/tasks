package br.com.tasks.core.domain.data.service

import br.com.tasks.core.domain.model.Task

interface TaskService {
    suspend fun getTasks(): List<Task>
}