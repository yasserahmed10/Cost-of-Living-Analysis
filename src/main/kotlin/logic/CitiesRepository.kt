package org.example.logic

import org.example.model.City

interface CitiesRepository {
    fun getAllCities() : List<City>
}