package by.epam.task5.dao.impl;

import by.epam.task5.dao.DAO;
import by.epam.task5.dao.connectionpoolhelper.exception.ConnectionPoolException;
import by.epam.task5.dao.exception.DAOException;
import by.epam.task5.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO implements DAO {

    private static final Logger LOG = LogManager.getLogger(LoginDAO.class.getName());
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String QUERY = "SELECT login, password FROM users WHERE login='";
    private static final String END_QUERY = "';";
    private static final String ERROR_MESSAGE = "Error in LoginDAO";

    @Override
    public User operateData(String login, String password) throws DAOException {
        String loginhelp = null;
        String passwordhelp = null;
        String query = QUERY + login + END_QUERY;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        User user = new User();
        ConnectionPool conPool = ConnectionPool.getInstance();
        try {
            con = conPool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                loginhelp = rs.getString(PARAM_LOGIN);
                passwordhelp = rs.getString(PARAM_PASSWORD);
            }
            user.setLogin(loginhelp);
            user.setPassword(passwordhelp);
        } catch (SQLException | ConnectionPoolException ex) {
            LOG.error(ERROR_MESSAGE);
            throw new DAOException(ERROR_MESSAGE, ex);
        } finally {
            try {
                conPool.closeConnection(con, st, rs);
            } catch (ConnectionPoolException ex) {
                LOG.error(ERROR_MESSAGE);
                throw new DAOException(ERROR_MESSAGE, ex);
            }
        }
        return user;

    }
}
