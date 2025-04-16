package org.example.dependencyInjection

import org.example.logic.GetCitiesHasCheapestGroceryUseCase
import org.example.logic.GetCitiesNamesWithTopSalaryUseCase
import org.example.logic.SearchSalariesCountryUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    single { GetCitiesNamesWithTopSalaryUseCase(get()) }
    single { GetCitiesHasCheapestGroceryUseCase(get()) }
    single { SearchSalariesCountryUseCase(get()) }
}