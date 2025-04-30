package org.example.logic

            import org.example.model.City

            class FindLargestDifferentInRentUseCase(
                private val citiesRepository: CitiesRepository
            ) {
                fun getCity(): City {
                    return citiesRepository.getAllCities()
                        .filter (::isDataAcceptable)
                        .sortedByDescending(::calculateRentDifferentBetweenCityCenterAndOutside)
                        .firstOrNull() ?: throw Exception("No Data found")
                }

                private fun calculateRentDifferentBetweenCityCenterAndOutside(city: City): Float {
                    with(city.realEstatesPrices) {
                        return (apartment3BedroomsInCityCentre!! + apartmentOneBedroomInCityCentre!!) -
                               (apartment3BedroomsOutsideOfCentre!! + apartmentOneBedroomOutsideOfCentre!!)
                    }
                }

                private fun isDataAcceptable(city: City): Boolean {
                    with(city.realEstatesPrices) {
                        return apartment3BedroomsInCityCentre != null
                                && apartmentOneBedroomInCityCentre != null
                                && apartment3BedroomsOutsideOfCentre != null
                                && apartmentOneBedroomOutsideOfCentre != null
                                && city.isHighQuality
                    }
                }
            }