package weather.remote

import kotlinx.serialization.json.Json
import weather.model.WeatherResponse
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class WeatherService(private val apiKey: String) {
    private val client = HttpClient.newHttpClient()
    private val json = Json { ignoreUnknownKeys = true }

    fun fetchForecast(
        lat: String? = "-6.1754049",
        lon: String? = "106.827168",
        unit: String? = "metric",
    ): Result<WeatherResponse> {
        return runCatching {
            if (apiKey.isBlank()) throw Exception("API Key undefined on local.properties")

            val url = "https://api.openweathermap.org/data/2.5/forecast?" +
                    "lat=$lat&lon=$lon&appid=$apiKey&units=$unit"
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build()

            val response = client.send(request, HttpResponse.BodyHandlers.ofString())

            if (response.statusCode() != 200) {
                throw Exception("API Error: ${response.statusCode()}")
            }

            json.decodeFromString<WeatherResponse>(response.body())
        }
    }
}