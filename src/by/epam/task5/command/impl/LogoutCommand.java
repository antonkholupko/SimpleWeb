package by.epam.task5.command.impl;

import by.epam.task5.command.Command;
import by.epam.task5.command.exception.CommandException;
import by.epam.task5.controller.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return PageName.INDEX_PAGE;
    }

}
