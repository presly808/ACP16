package com.weather.utils;

import com.google.gson.Gson;
import com.schema.JSonSchema;

public class StringParser {

    private Gson gson;

    public StringParser() {
        this.gson = new Gson();
    }

    public String getWeather(String response){
        return gson.toJson(gson.fromJson(response, JSonSchema.class).getWeather());
    }

    public String getCoordinates(String response){
        return gson.toJson(gson.fromJson(response, JSonSchema.class).getCoord());
    }

    public String getWind(String response){
        return gson.toJson(gson.fromJson(response, JSonSchema.class).getWind());
    }

}
