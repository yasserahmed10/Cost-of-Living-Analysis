package org.example.presentation
import org.example.logic.CitiesRepository
import org.example.logic.GetCitiesHasCheapestGroceryUseCase
import org.example.logic.GetCitiesNamesWithTopSalaryUseCase
import org.example.logic.SearchSalariesCountryUseCase

class CostOFLivingConsoleUI(
    private val getCitiesNamesWithTopSalaryUseCase: GetCitiesNamesWithTopSalaryUseCase,
    private val getCitiesHasCheapestGroceryUseCase: GetCitiesHasCheapestGroceryUseCase,
    private val searchSalariesCountryUseCase: SearchSalariesCountryUseCase,
) {
    fun start(){
        showWelcome()
        presentFeatures()
    }
    private fun presentFeatures() {
        showOptions()
        val input = getUserInput()
        when(input) {
            1 -> launchTopSalaries()
            2 -> launchCheapestGrocery()
            3 -> launchSearchSalariesInGrocery()
            else -> { println("Invalid Input") }
        }
        presentFeatures()
    }
    private fun showWelcome() {
        println("Welcome to cost of living app")
    }
    private fun showOptions() {
        println("\n\n=== please enter one of the following numbers ===")
        println("1- get names of cities with the highest salary")
        println("2- get names of cities with the cheapest grocery comparing to salaries")
        println("3- search for salaries, in any country")
        print("here: ")
    }
    private fun launchTopSalaries(){
        print("enter count of cities: ")
        getUserInput()?.let { count ->
            getCitiesNamesWithTopSalaryUseCase.getTopNCitiesNames(count).forEach{
                println(it)
            }
        } ?: println("input is invalid")
    }
    private fun launchCheapestGrocery(){
        getCitiesHasCheapestGroceryUseCase.getCitiesNames().forEach {
            println(it)
        }
    }
    private fun launchSearchSalariesInGrocery(){
        println("enter country name please: ")
        readlnOrNull()?.let { countryName ->
            try {
                searchSalariesCountryUseCase.searchCountry(countryName).forEach {
                    println(it)
                }
            } catch (e: Exception) {
                println("$countryName is not found")
            }
        } ?: println("Please enter valid input")
    }

    private fun getUserInput(): Int? {
        return readlnOrNull()?.toIntOrNull()
    }
}
