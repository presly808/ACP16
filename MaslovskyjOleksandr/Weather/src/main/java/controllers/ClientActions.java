package dao;

import client.ServerMessage;
import exceptions.NoServerFoundException;


import java.io.IOException;
import java.io.OutputStream;

public interface ClientActions {

    OutputStream sendRequestToServer() throws NoServerFoundException, IOException;

    void sendGsonMessageToServer(ServerMessage message) throws NoServerFoundException, IOException;

    abstract <T>T getGsonMessageFromServer() throws NoServerFoundException, IOException;

}
