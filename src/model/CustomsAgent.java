package model;

public class CustomsAgent {
    private String user;
    private String password;

    public CustomsAgent() {}

    public CustomsAgent(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateLogin(String user, String password) {
        if (this.user.equals(user) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
