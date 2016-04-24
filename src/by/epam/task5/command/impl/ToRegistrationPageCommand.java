package by.epam.task5.command.impl;

import by.epam.task5.command.Command;
import by.epam.task5.command.exception.CommandException;
import by.epam.task5.controller.PageName;

import javax.servlet.http.HttpServletRequest;

public class ToRegistrationPageCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PageName.REGISTRATION_PAGE;
    }

}
