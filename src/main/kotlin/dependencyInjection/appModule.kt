package org.example.dependencyInjection

import org.example.data.CitiesCsvParser
import org.example.data.CsvCitiesRepository
import org.example.data.CsvFileReader
import org.example.logic.CitiesRepository
import org.example.presentation.CostOFLivingConsoleUI
import org.koin.dsl.module
import java.io.File

val appModule = module {
   single {File("costOfLiving.csv")}
    single { CsvFileReader(get()) }
   single { CitiesCsvParser() }
   single<CitiesRepository> { CsvCitiesRepository(get(), get()) }



    single { CostOFLivingConsoleUI(get(),get(),get()) }

}