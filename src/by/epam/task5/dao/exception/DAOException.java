package by.epam.task5.dao.exception;

public class DAOException extends Exception{

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception ex) {
        super(ex);
    }

    public DAOException(String message, Exception ex) {
        super(message, ex);
    }

}
