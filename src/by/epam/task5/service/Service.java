package by.epam.task5.service;

import by.epam.task5.entity.User;
import by.epam.task5.service.exception.ServiceException;

public interface Service {
    public User handleQuery(String login, String password) throws ServiceException;
}
