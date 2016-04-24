package by.epam.task5.command;

import by.epam.task5.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    public String execute(HttpServletRequest request) throws CommandException;
}
