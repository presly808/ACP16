package ua.artcode.boot_app.dto;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class GeneralResponse {
    public String message;

    public GeneralResponse() {
    }

    public GeneralResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}