package client;


public class Location {

    private CountryAndCityNames countryCode;
    private CountryAndCityNames cityName;

    public Location(CountryAndCityNames countryCode, CountryAndCityNames cityName) {
        this.countryCode = countryCode;
        this.cityName = cityName;
    }

    public CountryAndCityNames getCountryCode() {
        return countryCode;
    }

    public CountryAndCityNames getCityName() {
        return cityName;
    }
}
