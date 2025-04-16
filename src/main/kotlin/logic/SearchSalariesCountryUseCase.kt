package org.example.logic

import org.example.model.City

class SearchSalariesCountryUseCase(
    private val citiesRepository: CitiesRepository
) {

    fun searchCountry(countryName: String): List<Pair<String, Float>> {
        return citiesRepository.getAllCities()
            .filter(::onlyHighQualityData)
            .filter { it.countryName.equals(countryName, ignoreCase = true) }
            .takeIf { it.isNotEmpty() }
            ?.map { currentCity ->
                currentCity.cityName to currentCity.averageMonthlyNetSalaryAfterTax!!
            }?: throw Exception("Country not found")
    }


    private fun onlyHighQualityData(input: City): Boolean {
        return input.isHighQuality
                && input.averageMonthlyNetSalaryAfterTax != null

    }
}