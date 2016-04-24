package by.epam.task5.dao;

import by.epam.task5.dao.impl.LoginDAO;
import by.epam.task5.dao.impl.RegisterDAO;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {
    private Map<DAOName, DAO> daos = new HashMap<>();
    private static volatile DAOFactory instance;

    private DAOFactory() {

        daos.put(DAOName.DAO_LOGIN, new LoginDAO());
        daos.put(DAOName.DAO_REGISTER, new RegisterDAO());
    }

    public DAO getDAO(DAOName daoName) {
        return daos.get(daoName);
    }

    public static DAOFactory getInstance() {
        DAOFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (DAOFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DAOFactory();
                }
            }
        }
        return localInstance;
    }
}
