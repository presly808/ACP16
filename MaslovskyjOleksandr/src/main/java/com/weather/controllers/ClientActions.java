package com.weather.controllers;

import com.weather.client.ServerMessage;
import com.weather.exceptions.NoServerFoundException;

import java.io.IOException;
import java.io.OutputStream;

public interface ClientActions {

    OutputStream sendRequestToServer() throws NoServerFoundException, IOException;

    void sendGsonMessageToServer(ServerMessage message) throws NoServerFoundException, IOException;

    void getGsonMessageFromServer() throws NoServerFoundException, IOException;

}
