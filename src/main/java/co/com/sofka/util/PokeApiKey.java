package co.com.sofka.util;

public enum PokeApiKey {
    TYPE_RESOURCE("/api/v2/type/{NumOrName}");

    private final String value;

    PokeApiKey(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

}
