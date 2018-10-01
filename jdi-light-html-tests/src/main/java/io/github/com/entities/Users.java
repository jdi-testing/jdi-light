package io.github.com.entities;


public class Users {
    public static User DEFAULT_USER = new User();

    public static Contacts DEFAULT_CONTACT = new Contacts().set(c-> {
        c.lastName = "Iovlev";
        c.position = "ChiefQA";
        c.number = "4321";
        c.seria = "123456";
        c.description = "JDI - awesome UI autoamtion tool";
        c.gender = "Female";
        c.religion = "Other";
        c.wheather = null;//"Sun, Snow";
    });
}
