package nativeServer.httpExample;


public class ResponseDTO {

    private int statusCode;
    private String responseBody;

    public ResponseDTO() {
    }

    public ResponseDTO(int statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "statusCode=" + statusCode +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
