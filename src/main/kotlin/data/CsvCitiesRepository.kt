package org.example.data
import org.example.logic.CitiesRepository
import org.example.model.City
class CsvCitiesRepository(
    private val csvFileReader: CsvFileReader,
    private val citiesCsvParser: CitiesCsvParser,
): CitiesRepository {
    override fun getAllCities(): List<City> {
        return csvFileReader.readLinesFromFile().map {
           citiesCsvParser.parseOneLine(it)
        }
    }
}
