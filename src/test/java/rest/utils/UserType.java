package rest.utils;

public enum UserType {

    MANAGER("manager"),
    SIMPLE_USER("simpleUser");

    private final String name;

    private UserType(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

}
