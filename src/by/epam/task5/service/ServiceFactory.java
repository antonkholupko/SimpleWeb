package by.epam.task5.service;

import by.epam.task5.service.impl.LoginService;
import by.epam.task5.service.impl.RegisterService;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private Map<ServiceName, Service> services = new HashMap<>();
    private static volatile ServiceFactory instance;

    private ServiceFactory() {
        services.put(ServiceName.LOGIN, new LoginService());
        services.put(ServiceName.REGISTER, new RegisterService());
    }

    public Service getService(ServiceName serviceName) {
        return services.get(serviceName);
    }

    public static ServiceFactory getInstance() {
        ServiceFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (ServiceFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ServiceFactory();
                }
            }
        }
        return localInstance;
    }
}
