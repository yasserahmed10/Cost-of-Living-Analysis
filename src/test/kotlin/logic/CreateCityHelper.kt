package logic

import org.example.model.BeveragesPrice
import org.example.model.CarsPrice
import org.example.model.City
import org.example.model.ClothesPrice
import org.example.model.FoodPrice
import org.example.model.FruitAndVegetablesPrice
import org.example.model.MealsPrice
import org.example.model.RealEstatesPrice
import org.example.model.ServicesPrice
import org.example.model.TransportationsPrice

fun createCity(
    cityName: String,
    countryName: String,
    salary: Float?,
    isHighQuality: Boolean
) = City(
    cityName=cityName,
    countryName=countryName,
    mealsPrices = MealsPrice(null,null,null),
    drinksPrices = BeveragesPrice(null,null,null,null,null),
    fruitAndVegetablesPrice = FruitAndVegetablesPrice(null,null,null,null,null,null,null),
    foodPrice = FoodPrice(null,null,null,null,null,null),
    servicesPrice = ServicesPrice(null,null,null,null,null,null,null,null),
    clothesPrice = ClothesPrice(null,null,null,null),
    transportationsPrice = TransportationsPrice(null,null,null,null,null,null),
    carsPrices = CarsPrice(null,null),
    realEstatesPrices = RealEstatesPrice(null,null,null,null,null,null),
    averageMonthlyNetSalaryAfterTax = salary,
    isHighQuality = isHighQuality
)