package by.epam.task5.service.impl;

import by.epam.task5.dao.DAO;
import by.epam.task5.dao.DAOFactory;
import by.epam.task5.dao.DAOName;
import by.epam.task5.dao.exception.DAOException;
import by.epam.task5.entity.User;
import by.epam.task5.service.Service;
import by.epam.task5.service.exception.ServiceException;
import by.epam.task5.service.service.HelperLogin;
import by.epam.task5.service.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginService implements Service {

    private static final Logger LOG = LogManager.getLogger(LoginService.class.getName());
    private static final String ERROR_MESSAGE = "Error in LoginService";

    @Override
    public User handleQuery(String login, String password) throws ServiceException {
        DAO dao = DAOFactory.getInstance().getDAO(DAOName.DAO_LOGIN);
        User user = null;
        try {
            user = dao.operateData(login, password);
            UserService.checkLogin(user, login, password);
        } catch (DAOException ex) {
            LOG.error(ERROR_MESSAGE);
            throw new ServiceException(ERROR_MESSAGE, ex);
        }
        HelperLogin.checkParameters(user, login, password);
        return user;
    }
}
