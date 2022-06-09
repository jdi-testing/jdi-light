package io.github.com.entities;

public class Users {
    public static User DEFAULT_USER = new User().set(c -> {
        c.firstName = "Long";
        c.lastName = "Dinh";
        c.address = "259 Tran Hung Dao Street";
        c.address2 = "Ward Co Giang, District 1";
        c.city = "Ho Chi Minh";
        c.state = "Ho Chi Minh";
        c.postalCode = "70000";
    });
}
