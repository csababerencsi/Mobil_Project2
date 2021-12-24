package hu.inf.unideb.projekt2.network


import hu.inf.unideb.projekt2.model.WeatherData
import retrofit2.Call
import retrofit2.http.*

interface WeatherApi {
    @GET("/data/2.5/weather")
    fun getWeather(
        @Query("q") cityName: String?,
        @Query("units") units: String?,
        @Query("appid") appId: String?
    ): Call<WeatherData?>?
}
