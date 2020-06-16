package io.github.epam.data;


import io.github.com.entities.Users;

public class TestData {
    public static Users DEFAULT_USER = new Users().set(c-> {
        c.firstName = "Long"; c.lastName = "Dinh";
        c.address = "259 Tran Hung Dao Street"; c.address2 = "Ward Co Giang, District 1";
        c.city = "Ho Chi Minh"; c.state = "Ho Chi Minh"; c.postalCode = "70000";
    });

}
