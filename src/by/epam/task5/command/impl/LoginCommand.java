package by.epam.task5.command.impl;

import by.epam.task5.command.Command;
import by.epam.task5.command.exception.CommandException;
import by.epam.task5.controller.PageName;
import by.epam.task5.entity.User;
import by.epam.task5.service.Service;
import by.epam.task5.service.ServiceFactory;
import by.epam.task5.service.ServiceName;
import by.epam.task5.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    private static final Logger LOG = LogManager.getLogger(LoginCommand.class.getName());
    private static final String ERROR_MESSAGE = "ERROR in LoginCommand";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = null;
        Service service = ServiceFactory.getInstance().getService(ServiceName.LOGIN);
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_PASSWORD);
        try {
            user = service.handleQuery(login, password);
            if (user.isRightLogin() && user.isRightPassword()) {
                request.getSession(true).setAttribute(PARAM_LOGIN, user.getLogin());
                return PageName.USER_PAGE;
            } else {
                return PageName.INDEX_PAGE;
            }
        } catch (ServiceException ex) {
            LOG.error(ERROR_MESSAGE);
            throw new CommandException(ERROR_MESSAGE, ex);
        }
    }
}
