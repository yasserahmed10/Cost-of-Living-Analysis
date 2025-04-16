package org.example.data

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

class CitiesCsvParser{
    fun parseOneLine(line:String): City{
        val cityInfo= line.split(",")
        return City(
            cityName = cityInfo[ColumnIndex.CITY],
            countryName = cityInfo[ColumnIndex.COUNTRY],
            mealsPrices = constructMealPricesFromCityInfo(cityInfo),
            drinksPrices = constructDrinksPricesFromCityInfo(cityInfo),
            fruitAndVegetablesPrice=constructFruitAndVegetablesPricesFromCityInfo(cityInfo),
            foodPrice=constructFoodPricesFromCityInfo(cityInfo),
            servicesPrice=constructServicesPricesFromCityInfo(cityInfo),
            clothesPrice=constructClothesPricesFromCityInfo(cityInfo),
            transportationsPrice=constructTransportationsPricesFromCityInfo(cityInfo),
            carsPrices=constructCarsPricesFromCityInfo(cityInfo),
            realEstatesPrices=constructRealEstatesPricesFromCityInfo(cityInfo),
            averageMonthlyNetSalaryAfterTax=cityInfo[ColumnIndex.AVERAGE_MONTHLY_NET_SALARY_AFTER_TAX].toFloatOrNull(),
            isHighQuality= cityInfo[ColumnIndex.DATA_QUALITY]=="1"
        )


    }
    private fun constructMealPricesFromCityInfo(cityInfo:List<String>): MealsPrice{
        return MealsPrice(
            mealAtMcDonaldS0rEquivalent = cityInfo.getFloat(ColumnIndex.MEAL_AT_MC_DONALD_S_OR_EQUIVALENT),
            mealInexpensiveRestaurant = cityInfo.getFloat(ColumnIndex.MEAL_INEXPENSIVE_RESTAURANT),
            mealFor2PeopleMidRangeRestaurant = cityInfo.getFloat(ColumnIndex.MEAL_FOR_2_PEOPLE_MID_RANGE_RESTAURANT)
        )
    }
    private fun constructDrinksPricesFromCityInfo(cityInfo:List<String>): BeveragesPrice{
        return BeveragesPrice(
            cappuccinoRegularInRestaurants=cityInfo.getFloat(ColumnIndex.CAPPUCCINO_REGULAR_IN_RESTAURANTS),
            cokePepsiAThirdOfLiterBottleInRestaurants=cityInfo.getFloat(ColumnIndex.COKE_PEPSI_A_THIRD_OF_LITER_BOTTLE_IN_RESTAURANTS),
            waterAThirdOfLiterBottleInRestaurants=cityInfo.getFloat(ColumnIndex.WATER_A_THIRD_OF_LITER_BOTTLE_IN_RESTAURANTS),
            milkRegularOneLiter=cityInfo.getFloat(ColumnIndex.MILK_REGULAR_ONE_LITER),
            waterOneAndHalfLiterBottleAtTheMarket=cityInfo.getFloat(ColumnIndex.WATER_ONE_AND_HALF_LITER_BOTTLE_AT_THE_MARKET),
        )
    }
    private fun constructFruitAndVegetablesPricesFromCityInfo(cityInfo:List<String>): FruitAndVegetablesPrice{
        return FruitAndVegetablesPrice(
            apples1kg=cityInfo.getFloat(ColumnIndex.APPLES_1KG),
            banana1kg=cityInfo.getFloat(ColumnIndex.BANANA_1KG),
            oranges1kg=cityInfo.getFloat(ColumnIndex.ORANGES_1KG),
            tomato1kg=cityInfo.getFloat(ColumnIndex.TOMATO_1KG),
            potato1kg=cityInfo.getFloat(ColumnIndex.POTATO_1KG),
            onion1kg=cityInfo.getFloat(ColumnIndex.ONION_1KG),
            lettuceOneHead=cityInfo.getFloat(ColumnIndex.LETTUCE_ONE_HEAD)
        )
    }
    private fun constructFoodPricesFromCityInfo(cityInfo:List<String>): FoodPrice{
        return FoodPrice(
            loafOfFreshWithBreading500g=cityInfo.getFloat(ColumnIndex.LOAF_OF_FRESH_WHITE_BREAD_500G),
            riceWhite1Kg=cityInfo.getFloat(ColumnIndex.RICE_WHITE_1KG),
            eggsRegular12=cityInfo.getFloat(ColumnIndex.EGGS_REGULAR_12),
            localCheese1Kg=cityInfo.getFloat(ColumnIndex.LOCAL_CHEESE_1KG),
            chickenFillets1Kg=cityInfo.getFloat(ColumnIndex.CHICKEN_FILLETS_1KG),
            beefRound1KgOrEquivalentBackLegRedMeat=cityInfo.getFloat(ColumnIndex.CHICKEN_FILLETS_1KG),
        )
    }
    private fun constructServicesPricesFromCityInfo(cityInfo:List<String>): ServicesPrice{
        return ServicesPrice(
            basicElectricityHeatingCoolingWaterGarbageFor85m2Apartment=cityInfo.getFloat(ColumnIndex.BASIC_ELECTRICITY_HEATING_COOLING_WATER_GARBAGE_FOR_85M2_APARTMENT),
            cinemaInternationalReleaseOneSeat=cityInfo.getFloat(ColumnIndex.CINEMA_INTERNATIONAL_RELEASE_ONE_SEAT),
            internet60MbpsOrMoreUnlimitedDataCableAdsl=cityInfo.getFloat(ColumnIndex.INTERNET_60_MBPS_OR_MORE_UNLIMITED_DATA_CABLE_ADSL),
            fitnessClubMonthlyFeeForOneAdult=cityInfo.getFloat(ColumnIndex.FITNESS_CLUB_MONTHLY_FEE_FOR_ONE_ADULT),
            tennisCourtRentOneHourOnWeekend=cityInfo.getFloat(ColumnIndex.TENNIS_COURT_RENT_ONE_HOUR_ON_WEEKEND),
            oneMinOfPrepaidMobileTariffLocalNoDiscountsOrPlans=cityInfo.getFloat(ColumnIndex.ONE_MIN_OF_PREPAID_MOBILE_TARIFF_LOCAL_NO_DISCOUNTS_OR_PLANS),
            internationalPrimarySchoolYearlyForOneChild=cityInfo.getFloat(ColumnIndex.INTERNATIONAL_PRIMARY_SCHOOL_YEARLY_FOR_ONE_CHILD),
            preschoolOrKindergartenFullDayPrivateMonthlyForOneChild=cityInfo.getFloat(ColumnIndex.PRESCHOOL_OR_KINDERGARTEN_FULL_DAY_PRIVATE_MONTHLY_FOR_ONE_CHILD),
        )
    }
    private fun constructClothesPricesFromCityInfo(cityInfo:List<String>): ClothesPrice{
        return ClothesPrice(
            onePairOfJeansLevis50oneOrSimilar=cityInfo.getFloat(ColumnIndex.ONE_PAIR_OF_JEANS_LEVIS_500NE_OR_SIMILAR),
            oneSummerDressInAChainStoreZaraHAndM=cityInfo.getFloat(ColumnIndex.ONE_SUMMER_DRESS_IN_A_CHAIN_STORE_ZARA_H_AND_M),
            onePairOfNikeRunningShoesMidRange=cityInfo.getFloat(ColumnIndex.ONE_PAIR_OF_NIKE_RUNNING_SHOES_MID_RANGE),
            onePairOfMenLeatherBusinessShoes=cityInfo.getFloat(ColumnIndex.ONE_PAIR_OF_MEN_LEATHER_BUSINESS_SHOES),
        )
    }
    private fun constructTransportationsPricesFromCityInfo(cityInfo:List<String>): TransportationsPrice{
        return TransportationsPrice(
            gasolineOneLiter=cityInfo.getFloat(ColumnIndex.GASOLINE_ONE_LITER),
            taxi1hourWaitingNormalTariff=cityInfo.getFloat(ColumnIndex.TAXI_1HOUR_WAITING_NORMAL_TARIFF),
            taxi1kmNormalTariff=cityInfo.getFloat(ColumnIndex.TAXI_1KM_NORMAL_TARIFF),
            monthlyPassRegularPrice=cityInfo.getFloat(ColumnIndex.MONTHLY_PASS_REGULAR_PRICE),
            oneWayTicketLocalTransport=cityInfo.getFloat(ColumnIndex.ONE_WAY_TICKET_LOCAL_TRANSPORT),
            taxiStartNormalTariff=cityInfo.getFloat(ColumnIndex.TAXI_START_NORMAL_TARIFF),
        )
    }
    private fun constructCarsPricesFromCityInfo(cityInfo:List<String>): CarsPrice{
        return CarsPrice(
            volkswagenGolf_1_490kwTrendLineOrEquivalentNewCar=cityInfo.getFloat(ColumnIndex.VOLKSWAGEN_GOLF_1_4_90KW_TREND_LINE_OR_EQUIVALENT_NEW_CAR),
            toyotaCorollaSedan_1_61_97kwComfortOrEquivalentNewCar=cityInfo.getFloat(ColumnIndex.TOYOTA_COROLLA_SEDAN_1_6L_97KW_COMFORT_OR_EQUIVALENT_NEW_CAR),
        )
    }
    private fun constructRealEstatesPricesFromCityInfo(cityInfo:List<String>): RealEstatesPrice{
        return RealEstatesPrice(
            apartmentOneBedroomInCityCentre=cityInfo.getFloat(ColumnIndex.APARTMENT_3_BEDROOMS_IN_CITY_CENTRE),
            apartmentOneBedroomOutsideOfCentre=cityInfo.getFloat(ColumnIndex.APARTMENT_ONE_BEDROOM_OUTSIDE_OF_CENTRE),
            apartment3BedroomsInCityCentre=cityInfo.getFloat(ColumnIndex.APARTMENT_3_BEDROOMS_IN_CITY_CENTRE),
            apartment3BedroomsOutsideOfCentre=cityInfo.getFloat(ColumnIndex.APARTMENT_3_BEDROOMS_OUTSIDE_OF_CENTRE),
            pricePerSquareMeterToBuyApartmentInCityCentre=cityInfo.getFloat(ColumnIndex.PRICE_PER_SQUARE_METER_TO_BUY_APARTMENT_IN_CITY_CENTRE),
            pricePerSquareMeterToBuyApartmentOutsideOfCentre=cityInfo.getFloat(ColumnIndex.PRICE_PER_SQUARE_METER_TO_BUY_APARTMENT_OUTSIDE_OF_CENTRE),
        )
    }
    private fun List<String>.getFloat(index:Int):Float?{
        return this[index].toFloatOrNull()
    }
}
