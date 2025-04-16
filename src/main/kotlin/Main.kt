package org.example

import org.example.dependencyInjection.appModule
import org.example.dependencyInjection.useCaseModule
import org.example.presentation.CostOFLivingConsoleUI
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin

fun main() {
    startKoin {
        modules(appModule, useCaseModule)
    }
    val ui: CostOFLivingConsoleUI = getKoin().get()
    ui.start()
}
