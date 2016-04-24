package by.epam.task5.service.impl;

import by.epam.task5.dao.DAO;
import by.epam.task5.dao.DAOFactory;
import by.epam.task5.dao.DAOName;
import by.epam.task5.dao.exception.DAOException;
import by.epam.task5.entity.User;
import by.epam.task5.service.Service;
import by.epam.task5.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterService implements Service {

    private static final Logger LOG = LogManager.getLogger(RegisterService.class.getName());
    private static final String ERROR_MESSAGE = "Error in RegisterService";

    @Override
    public User handleQuery(String login, String password) throws ServiceException {
        DAO dao = DAOFactory.getInstance().getDAO(DAOName.DAO_REGISTER);
        DAO helpDAO = DAOFactory.getInstance().getDAO(DAOName.DAO_LOGIN);
        User user = null;
        try {
            user = helpDAO.operateData(login, password);
            if (isAdd(user)) {
                user = dao.operateData(login, password);
                user.setLogin(login);
                user.setPassword(password);
                user.setConfirmedPassword(true);
                user.setRightLogin(true);
                user.setConfirmPassword(password);
                user.setAdded(true);
                user.setRightPassword(true);
                user.setRightConfirmPassword(true);
                return user;
            } else {
                user.setConfirmedPassword(true);
                user.setRightLogin(false);
                user.setRightPassword(true);
                user.setRightConfirmPassword(true);
                return user;
            }
        } catch (DAOException ex) {
            LOG.error(ERROR_MESSAGE);
            throw new ServiceException(ERROR_MESSAGE, ex);
        }
    }

    private boolean isAdd(User user) {
        if (user.getLogin() == null) {
            user.setAdded(true);
            return true;
        } else {
            user.setAdded(false);
            return false;
        }
    }
}
