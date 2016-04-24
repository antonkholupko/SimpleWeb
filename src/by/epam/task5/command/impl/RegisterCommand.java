package by.epam.task5.command.impl;

import by.epam.task5.command.Command;
import by.epam.task5.command.exception.CommandException;
import by.epam.task5.controller.PageName;
import by.epam.task5.entity.User;
import by.epam.task5.service.Service;
import by.epam.task5.service.ServiceFactory;
import by.epam.task5.service.ServiceName;
import by.epam.task5.service.exception.ServiceException;
import by.epam.task5.service.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    private static final Logger LOG = LogManager.getLogger(RegisterCommand.class.getName());
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_CONFIRM_PASSWORD = "confirmPassword";
    private static final String ERROR_MESSAGE = "Error in RegisterCommand";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = null;
        Service service = ServiceFactory.getInstance().getService(ServiceName.REGISTER);
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_PASSWORD);
        String confirmPassword = request.getParameter(PARAM_CONFIRM_PASSWORD);
        user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
        UserService.checkConfirmationPassword(user);
        try {
            if (user.isConfirmedPassword() && user.isRightLogin() && user.isRightPassword() && user.isRightConfirmPassword()) {
                user = service.handleQuery(login, password);
                return checkAdd(user);
            } else {
                return PageName.REGISTRATION_PAGE;
            }
        } catch (ServiceException ex) {
            LOG.error(ERROR_MESSAGE);
            throw new CommandException(ex);
        }
    }

    private String checkAdd(User user) {
        if (user.isAdded()) {
            return PageName.USER_PAGE_AFT_REG;
        } else {
            return PageName.REGISTRATION_PAGE;
        }
    }

}
