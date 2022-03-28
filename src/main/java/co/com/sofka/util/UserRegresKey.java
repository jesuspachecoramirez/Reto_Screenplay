package co.com.sofka.util;

public enum UserRegresKey {
    UPDATE_USER_RESOURCE("/api/users/{id}");
    private final String value;

    UserRegresKey(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

}
