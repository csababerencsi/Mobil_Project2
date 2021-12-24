package hu.inf.unideb.projekt2.feature.details

import hu.inf.unideb.projekt2.model.WeatherData

interface WeatherDataHolder {
    fun getWeatherData(): WeatherData?
}
