package logic

import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import org.example.logic.CitiesRepository
import org.example.logic.FindLargestDifferentInRentUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class FindLargestDifferentInRentUseCaseTest {
    private lateinit var citiesRepository: CitiesRepository
    private lateinit var findLargestDifferentInRentUseCase: FindLargestDifferentInRentUseCase

    @BeforeEach
    fun setUp() {
        citiesRepository = mockk(relaxed = true)
        findLargestDifferentInRentUseCase = FindLargestDifferentInRentUseCase(citiesRepository)
    }

    @Test
    fun `should return correct city when having multiple cities vary in rent range`() {
        // Given
        every { citiesRepository.getAllCities() } returns listOf(
            createCityHelper("London", "UK", 2800f, 5500f, 1800f, 3700f, true),
            createCityHelper("Tokyo", "Japan", 2200f, 5000f, 1500f, 3000f, true),
            createCityHelper("New York", "USA", 3500f, 6000f, 2000f, 4000f, true),
            createCityHelper("Paris", "France", 2600f, 5300f, 1700f, 3400f, true),
            createCityHelper("Sydney", "Australia", 2400f, 4900f, 1600f, 3200f, true)
        )
        // When
        val resultCity = findLargestDifferentInRentUseCase.getCity()

        //Then
        assertThat(resultCity.cityName).isEqualTo("New York")
    }

    @Test
    fun `should ignore low quality data when find largest rent different`() {
        every { citiesRepository.getAllCities() } returns listOf(
            createCityHelper("New York", "USA", 3500f, 6000f, 2000f, 4000f, false),
            createCityHelper("London", "UK", 2800f, 5500f, 1800f, 3700f, false),
            createCityHelper("Tokyo", "Japan", 2200f, 5000f, 1500f, 3000f, true),
            createCityHelper("Paris", "France", 2600f, 5300f, 1700f, 3400f, true),
            createCityHelper("Sydney", "Australia", 2400f, 4900f, 1600f, 3200f, true)
        )
        // When
        val resultCity = findLargestDifferentInRentUseCase.getCity()

        //Then
        assertThat(resultCity.cityName).isEqualTo("Paris")
    }

    @Test
    fun `should ignore data has null in large apartment in city center data when find largest rent different`() {
        every { citiesRepository.getAllCities() } returns listOf(
            createCityHelper("New York", "USA", 3500f, null, 2000f, 4000f, true),
            createCityHelper("London", "UK", 2800f, null, 1800f, 3700f, true),
            createCityHelper("Tokyo", "Japan", 2200f, 5000f, 1500f, 3000f, true),
            createCityHelper("Paris", "France", 2600f, 5300f, 1700f, 3400f, true),
            createCityHelper("Sydney", "Australia", 2400f, 4900f, 1600f, 3200f, true)
        )
        // When
        val resultCity = findLargestDifferentInRentUseCase.getCity()

        //Then
        assertThat(resultCity.cityName).isEqualTo("Paris")
    }

    @Test
    fun `should ignore data has null in small apartment in city center data when find largest rent different`() {
        every { citiesRepository.getAllCities() } returns listOf(
            createCityHelper("New York", "USA", null, 6000f, 2000f, 4000f, true),
            createCityHelper("London", "UK", null, 5500f, 1800f, 3700f, true),
            createCityHelper("Tokyo", "Japan", 2200f, 5000f, 1500f, 3000f, true),
            createCityHelper("Paris", "France", 2600f, 5300f, 1700f, 3400f, true),
            createCityHelper("Sydney", "Australia", 2400f, 4900f, 1600f, 3200f, true)
        )
        // When
        val resultCity = findLargestDifferentInRentUseCase.getCity()

        //Then
        assertThat(resultCity.cityName).isEqualTo("Paris")
    }

    @Test
    fun `should ignore data has null in small apartment outside city center data when find largest rent different`() {
        every { citiesRepository.getAllCities() } returns listOf(
            createCityHelper("New York", "USA", 3500f, 6000f, null, 4000f, true),
            createCityHelper("London", "UK", 2800f, 5500f, null, 3700f, true),
            createCityHelper("Tokyo", "Japan", 2200f, 5000f, 1500f, 3000f, true),
            createCityHelper("Paris", "France", 2600f, 5300f, 1700f, 3400f, true),
            createCityHelper("Sydney", "Australia", 2400f, 4900f, 1600f, 3200f, true)
        )
        // When
        val resultCity = findLargestDifferentInRentUseCase.getCity()

        //Then
        assertThat(resultCity.cityName).isEqualTo("Paris")
    }

    @Test
    fun `should ignore data has null in large apartment outside city center data when find largest rent different`() {
        every { citiesRepository.getAllCities() } returns listOf(
            createCityHelper("New York", "USA", 3500f, 6000f, 2000f, null, true),
            createCityHelper("London", "UK", 2800f, 5500f, 1800f, null, true),
            createCityHelper("Tokyo", "Japan", 2200f, 5000f, 1500f, 3000f, true),
            createCityHelper("Paris", "France", 2600f, 5300f, 1700f, 3400f, true),
            createCityHelper("Sydney", "Australia", 2400f, 4900f, 1600f, 3200f, true)
        )
        // When
        val resultCity = findLargestDifferentInRentUseCase.getCity()

        //Then
        assertThat(resultCity.cityName).isEqualTo("Paris")
    }

    @Test
    fun `should throw Exception when there is no cities`() {
        // Given
        every { citiesRepository.getAllCities() } returns emptyList()

        // When & Then
        assertThrows<Exception> {
            findLargestDifferentInRentUseCase.getCity()
        }
    }

}