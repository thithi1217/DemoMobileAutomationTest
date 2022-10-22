package test_data.models;

public class LoginHahaloloData {

    private String email;
    private String password;
    private String displayName;
    private boolean avatar;

    public LoginHahaloloData(String email, String password, String displayName, boolean avatar) {
        this.email = email;
        this.password = password;
        this.displayName = displayName;
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "LoginHahaloloData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + displayName + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
