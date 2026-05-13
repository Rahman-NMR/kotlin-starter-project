package weather.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherResponse(
    val list: List<ForecastItem>
)

@Serializable
data class ForecastItem(
    val dt: Long,
    val main: MainData,
    @SerialName("dt_txt") val dtTxt: String
)

@Serializable
data class MainData(
    val temp: Double
)