package weather

import weather.remote.WeatherService
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    val apiKey = System.getProperty("OPENWEATHER_API_KEY")
        ?: System.getenv("OPENWEATHER_API_KEY")
        ?: ""

    val service = WeatherService(apiKey)

    service.fetchForecast().onSuccess { response ->
        println("Weather Forecast Jakarta (5 Days Average):")

        val forecastByDay = response.list.groupBy {
            Instant.ofEpochSecond(it.dt)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
        }

        val dateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", Locale.ENGLISH)

        forecastByDay.entries.sortedBy { it.key }
            .take(5).forEach { (date, items) ->
                val averageTemp = items.map { it.main.temp }.average()
                val formattedDate = date.format(dateFormatter)

                println("$formattedDate: ${String.format("%.2f", averageTemp)}°C")
            }
    }.onFailure { error ->
        println("Failed to fetch weather data: ${error.message}")
    }
}