package by.epam.task5.command.impl;

import by.epam.task5.command.Command;
import by.epam.task5.controller.PageName;

import javax.servlet.http.HttpServletRequest;

public class ToIndexPageCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        return PageName.INDEX_PAGE;
    }
}
