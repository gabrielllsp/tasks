package br.com.tasks.data.request

data class CreateTaskRequest(
    val title: String = "",
    val description: String = "",
    val priority: String = "",
    val dueDate: String =""
)
