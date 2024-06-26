package dev.joseluisgs.expedientesacademicos

import dev.joseluisgs.expedientesacademicos.di.appModule
import dev.joseluisgs.expedientesacademicos.routes.RoutesManager
import javafx.application.Application
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import java.time.LocalDateTime

class ExpedientesApplication : Application(), KoinComponent {

    init {
        println(LocalDateTime.now().toString())
        // creamos Koin
        startKoin {
            printLogger() // Logger de Koin
            modules(appModule) // Módulos de Koin
        }
    }

    // Cuando se inicia la aplicación
    override fun start(stage: Stage) {
        // Le pasamos la aplicación a la clase RoutesManager
        RoutesManager.apply {
            app = this@ExpedientesApplication
        }.run {
            // Iniciamos la aplicación, podiamos hacerlo con also!!
            initMainStage(stage)
        }

    }

    // Cuando se para la aplicación
    /*
    override fun stop() {
        // No hacemos nada
    }
    */
}

fun main() {
    // No hagas nada a aquí porque abre un hilo de ejecución
    Application.launch(ExpedientesApplication::class.java)


}