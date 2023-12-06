package com.example.finalassign;

public class WeatherData {
    private String cityName;
    private String temperature;
    private String weatherDescription;
    private String icon;

    public WeatherData(String cityName, String temperature, String weatherDescription, String icon) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
        this.icon = icon;
    }

    // Getters
    public String getCityName() {
        return cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getIcon() {
        return icon;
    }

    // Setters (if needed)
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

