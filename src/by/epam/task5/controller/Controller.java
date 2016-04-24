package by.epam.task5.controller;

import by.epam.task5.command.Command;
import by.epam.task5.command.exception.CommandException;
import by.epam.task5.controller.helper.CommandHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String PARAMETER = "command";
    private static final Logger LOG = LogManager.getLogger(Controller.class.getName());
    private static final String ERROR_MESSAGE = "Error in Controller";

    public Controller() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = null;
        Command command = null;
        String page = PageName.INDEX_PAGE;

        try {
            if (request.getParameter(PARAMETER) != null) {
                commandName = request.getParameter(PARAMETER);
                command = CommandHelper.getInstance().getCommand(commandName);
                page = command.execute(request);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            } else {
                page = PageName.ERROR_PAGE;
            }
        } catch (CommandException ex) {
            LOG.error(ERROR_MESSAGE);
            page = PageName.ERROR_PAGE;
        }

    }
}