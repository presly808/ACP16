package nativeServer.httpExample;

import java.io.IOException;

public interface HttpRequestInterface {

    ResponseDTO sendGet() throws IOException;

    ResponseDTO sendPost();

    ResponseDTO sendDelete();
}
