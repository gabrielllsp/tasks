package br.com.tasks.routes

import br.com.tasks.core.domain.data.service.TaskService
import br.com.tasks.utlis.Constants.TASKS_ROUTE
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.taskRoute(taskService: TaskService) {
    route(TASKS_ROUTE) {
        getTasks(taskService)
    }
}

private fun Route.getTasks(taskService: TaskService) {
    get {
        try {
            val tasks = taskService.getTasks()
            call.respond(HttpStatusCode.OK, tasks)

        } catch (ex: Exception) {
            application.log.error(ex.message)
            call.respond(HttpStatusCode.BadRequest)
        }
    }
}