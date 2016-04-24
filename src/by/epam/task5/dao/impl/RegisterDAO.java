package by.epam.task5.dao.impl;

import by.epam.task5.dao.DAO;
import by.epam.task5.dao.connectionpoolhelper.exception.ConnectionPoolException;
import by.epam.task5.dao.exception.DAOException;
import by.epam.task5.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class RegisterDAO implements DAO {

    private static final Logger LOG = LogManager.getLogger(RegisterDAO.class.getName());
    private static final String QUERY = "INSERT INTO users (login, password) VALUES (?, ?);";
    private static final String ERROR_MESSAGE = "Error in RegisterDAO";

    @Override
    public User operateData(String login, String password) throws DAOException {
        User user = new User();
        try {
            Connection con = null;
            PreparedStatement ps  = null;
            ConnectionPool conPool = ConnectionPool.getInstance();
            con = conPool.takeConnection();
            ps = con.prepareStatement(QUERY);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.executeUpdate();

        } catch (SQLException | ConnectionPoolException ex) {
            LOG.error(ERROR_MESSAGE);
            throw new DAOException(ERROR_MESSAGE, ex);
        }
        return user;
    }
}
