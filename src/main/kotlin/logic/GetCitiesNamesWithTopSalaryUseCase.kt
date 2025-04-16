package org.example.logic

import org.example.model.City

class GetCitiesNamesWithTopSalaryUseCase(
    private val citiesRepository: CitiesRepository
) {
    fun getTopNCitiesNames(count:Int): List<String> {
        return citiesRepository.getAllCities()
            .filter(::onlyHighQualityData)
            .sortedByDescending { it.averageMonthlyNetSalaryAfterTax }
            .take(count)
            .map { it.cityName }
    }
    private fun onlyHighQualityData(input: City):Boolean{
      return input.isHighQuality && input.averageMonthlyNetSalaryAfterTax !=null
    }
}