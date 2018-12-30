package io.github.com.entities;


public class Users {
    public static User DEFAULT_USER = new User();

    public static Contacts DEFAULT_CONTACT = new Contacts().set(c-> {
        c.name = "Roman";
        c.lastName = "Iovlev";
        c.position = "ChiefQA";
        //c.passport = true;
        c.passportNumber = "4321";
        c.passportSeria = "123456";
        c.description = "JDI - awesome UI automation tool";
        c.acceptConditions = "true";
        c.gender = "Female";
        c.religion = "Other";
    });
}
