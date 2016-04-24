package by.epam.task5.dao.connectionpoolhelper.service;

import java.util.ResourceBundle;

public class DBResourceManager {

    private static final String BUNDLE = "by.epam.task5.dao.connectionpoolhelper.resource.db";
    private final static DBResourceManager instance = new DBResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
