package org.example.model

data class City(
    val cityName: String,
    val countryName: String,
    val mealsPrices: MealsPrice,
    val drinksPrices: BeveragesPrice,
    val fruitAndVegetablesPrice: FruitAndVegetablesPrice,
    val foodPrice: FoodPrice,
    val servicesPrice: ServicesPrice,
    val clothesPrice: ClothesPrice,
    val transportationsPrice: TransportationsPrice,
    val carsPrices: CarsPrice,
    val realEstatesPrices: RealEstatesPrice,
    val averageMonthlyNetSalaryAfterTax:Float?,
    val isHighQuality: Boolean
)



