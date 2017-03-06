package exceptions;


public class NotAvailableTableException extends Exception {

    public NotAvailableTableException() {
        super("TABLE NOT EXIST");
    }
}
