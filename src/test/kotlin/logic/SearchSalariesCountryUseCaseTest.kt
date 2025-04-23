package logic

import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import org.example.logic.CitiesRepository
import org.example.logic.SearchSalariesCountryUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.runners.Parameterized
import kotlin.test.Test

class SearchSalariesCountryUseCaseTest {
    private lateinit var citiesRepository: CitiesRepository
    private lateinit var searchSalariesCountryUseCase: SearchSalariesCountryUseCase
    @BeforeEach
    fun setUp() {
        citiesRepository= mockk(relaxed = true)
        searchSalariesCountryUseCase= SearchSalariesCountryUseCase(citiesRepository)
    }
    @Test
    fun `should return cities in searched country when search for a valid country`() {
        // Given
        every { citiesRepository.getAllCities() } returns listOf(
            createCity("Tokyo","Japan",3500f,true),
            createCity("Los Angeles","USA",4500f,true),
            createCity("New York","USA",5000f,true),
            createCity("Berlin","Germany",4000f,true),
        )
        val searchInput = "USA"
            // When
            val result=searchSalariesCountryUseCase.searchCountry(searchInput)

            // Then
            assertThat(result).containsExactly(
                "New York" to 5000f,
                "Los Angeles" to 4500f,
            )
    }
    @Test
    fun `should return cities in searched country without low quality data when search for a valid country`() {
        // Given
        every { citiesRepository.getAllCities() } returns listOf(
            createCity("Tokyo","Japan",3500f,true),
            createCity("Los Angeles","USA",4500f,false),
            createCity("New York","USA",5000f,true),
            createCity("Berlin","Germany",4000f,true),
        )
        val searchInput = "USA"
        // When
        val result=searchSalariesCountryUseCase.searchCountry(searchInput)

        // Then
        assertThat(result).containsExactly(
            "New York" to 5000f,
        )
    }
    @Test
    fun `should return cities in searched country without null salaries data when search for a valid country`() {
        // Given
        every { citiesRepository.getAllCities() } returns listOf(
            createCity("Tokyo","Japan",3500f,true),
            createCity("Los Angeles","USA",4500f,true),
            createCity("New York","USA",null,true),
            createCity("Berlin","Germany",4000f,true),
        )
        val searchInput = "USA"
        // When
        val result=searchSalariesCountryUseCase.searchCountry(searchInput)

        // Then
        assertThat(result).containsExactly(
            "Los Angeles" to 4500f,
            )
    }
    @Test
    fun `should throw exception when search for not available country`() {
        // Given
        every { citiesRepository.getAllCities() } returns listOf(
            createCity("Tokyo","Japan",3500f,true),
            createCity("Los Angeles","USA",4500f,true),
            createCity("New York","USA",null,true),
            createCity("Berlin","Germany",4000f,true),
        )
        val searchInput = "Brazil"

        // When & Then
        assertThrows<Exception> {
            searchSalariesCountryUseCase.searchCountry(searchInput)
        }
    }
    @ParameterizedTest
    @ValueSource(strings =arrayOf("Japan","japan","JAPAN","JaPan"))
    fun `should find correct result in case-insensitive way`(searchInput: String) {
        // Given
        every { citiesRepository.getAllCities() } returns listOf(
            createCity("Tokyo","Japan",3500f,true),
            createCity("Los Angeles","USA",4500f,true),
            createCity("New York","USA",null,true),
            createCity("Berlin","Germany",4000f,true),
        )
        // When
        val result=searchSalariesCountryUseCase.searchCountry(searchInput)

        // Then
        assertThat(result).containsExactly(
            "Tokyo" to 3500f,
        )
    }

}