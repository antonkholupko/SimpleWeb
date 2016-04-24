package by.epam.task5.service.service;

import by.epam.task5.entity.User;

public final class HelperLogin {

    public final static void checkParameters(User user, String login, String password) {
        if (isLogin(user, login)) {
            user.setRightLogin(true);
        } else {
            user.setRightLogin(false);
        }
        if (isPassword(user, password)) {
            user.setRightPassword(true);
        } else {
            user.setRightPassword(false);
        }
    }

    private static boolean isLogin(User user, String login) {
        if (login.equals(user.getLogin())) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPassword(User user, String password) {
        if (password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
