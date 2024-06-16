package br.com.tasks.di

import br.com.tasks.core.domain.data.repository.TaskRepository
import br.com.tasks.core.domain.data.service.TaskService
import br.com.tasks.data.repository.TaskRepositoryImpl
import br.com.tasks.data.service.TaskServiceImpl
import br.com.tasks.utlis.Constants.LOCAL_DATABASE_NAME
import br.com.tasks.utlis.Constants.MONGODB_URI_LOCAL
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val databaseModule = module {
    single {
        val client = KMongo.createClient(connectionString = MONGODB_URI_LOCAL).coroutine
        client.getDatabase(LOCAL_DATABASE_NAME)
    }
}

val repositoryModule = module {
    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}

val serviceModule = module{
    single<TaskService>{
        TaskServiceImpl(get())
    }
}