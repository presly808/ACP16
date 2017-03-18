package com.weather.client;


public class ServerMessage{

    private String ip;
    private String body;

    public ServerMessage(String ip, String body) {
        this.ip = ip;
        this.body = body;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
