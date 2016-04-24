package by.epam.task5.command.exception;

public class CommandException extends Exception{

    private static final long serialVersionUID = 1L;

    public CommandException(String message) {
        super(message);
    }

    public CommandException(Exception ex) {
        super(ex);
    }

    public CommandException(String message, Exception ex) {
        super(message, ex);
    }
}
