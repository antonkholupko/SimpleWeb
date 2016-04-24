package by.epam.task5.service.service;

import by.epam.task5.entity.User;

public final class UserService {

    public final static void checkLogin(User user, String login, String password) {
        Validator.loginValidator(user, login, password);
    }

    public final static void checkConfirmationPassword(User user) {
        Validator.confirmPasswordValidator(user);
    }

    private static class Validator {
        public static void loginValidator(User user, String login, String password) {
            if (login.isEmpty()) {
                user.setRightLogin(false);
            } else {
                user.setRightLogin(true);
            }
            if (password.isEmpty()) {
                user.setRightPassword(false);
            } else {
                user.setRightPassword(true);
            }
        }

        public static void confirmPasswordValidator(User user) {
            if (user.getLogin().isEmpty()) {
                user.setRightLogin(false);
            } else {
                user.setRightLogin(true);
            }
            if (user.getPassword().isEmpty()) {
                user.setRightPassword(false);
            } else {
                user.setRightPassword(true);
            }
            if (user.getConfirmPassword().isEmpty()) {
                user.setRightConfirmPassword(false);
            } else {
                user.setRightConfirmPassword(true);
            }
            if (user.getPassword().equals(user.getConfirmPassword())) {
                user.setConfirmedPassword(true);
            } else {
                user.setConfirmedPassword(false);
            }
        }
    }
}
