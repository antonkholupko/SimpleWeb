package by.epam.task5.dao;

import by.epam.task5.dao.exception.DAOException;
import by.epam.task5.entity.User;

public interface DAO {
    public User operateData(String login, String password) throws DAOException;
}
