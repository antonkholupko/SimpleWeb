package by.epam.task5.service.exception;

public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception ex) {
        super(ex);
    }

    public ServiceException(String message, Exception ex) {
        super(message, ex);
    }

}
