package by.epam.task5.entity;

public class User {
    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private String confirmPassword;
    private boolean rightLogin;
    private boolean rightPassword;
    private boolean rightConfirmPassword;
    private boolean confirmedPassword;
    private boolean added;
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRightLogin() {
        return rightLogin;
    }

    public void setRightLogin(boolean rightLogin) {
        this.rightLogin = rightLogin;
    }

    public boolean isRightPassword() {
        return rightPassword;
    }

    public void setRightPassword(boolean rightPassword) {
        this.rightPassword = rightPassword;
    }


    public boolean isConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(boolean confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public boolean isRightConfirmPassword() {
        return rightConfirmPassword;
    }

    public void setRightConfirmPassword(boolean rightConfirmPassword) {
        this.rightConfirmPassword = rightConfirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }
}
