package org.example.logic

import org.example.model.City
import org.example.model.FruitAndVegetablesPrice

class GetCitiesHasCheapestGroceryUseCase(
    private val citiesRepository: CitiesRepository
) {
    fun getCitiesNames(): List<String> {
       return citiesRepository.getAllCities()
            .filter(::onlyHighQualityData)
            .sortedBy { getAveragePriceForGrocery(it.fruitAndVegetablesPrice) / it.averageMonthlyNetSalaryAfterTax!! }
            .take(TOP_N)
            .map {
                it.cityName
            }
    }
    private fun onlyHighQualityData(input: City):Boolean{
        return input.isHighQuality
                && input.averageMonthlyNetSalaryAfterTax !=null
                && input.fruitAndVegetablesPrice.onion1kg !=null
                && input.fruitAndVegetablesPrice.apples1kg !=null
                && input.fruitAndVegetablesPrice.banana1kg !=null
                && input.fruitAndVegetablesPrice.potato1kg !=null
                && input.fruitAndVegetablesPrice.tomato1kg !=null
                && input.fruitAndVegetablesPrice.lettuceOneHead !=null
    }
    private fun getAveragePriceForGrocery(input: FruitAndVegetablesPrice):Float{
        return (input.onion1kg!! +
                input.apples1kg!! +
                input.banana1kg!! +
                input.potato1kg!! +
                input.tomato1kg!! +
                input.lettuceOneHead!!) /6.0f
    }
    companion object{
        const val TOP_N = 10
    }
}