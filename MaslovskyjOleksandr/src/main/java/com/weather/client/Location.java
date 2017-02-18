package com.weather.client;


public class Location {

    private String countryCode;
    private String cityName;

    public Location(String countryCode, String cityName) {
        this.countryCode = countryCode;
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
