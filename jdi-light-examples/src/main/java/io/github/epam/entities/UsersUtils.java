package io.github.epam.entities;


public class UsersUtils {
    public static User DEFAULT_USER = new User();

    public static User USER_WITH_CONTACTS = new User().set(u-> {
        //u.passport = "true";
        //u.acceptConditions = "true";
        u.name = "Roman";
        u.lastName = "Iovlev";
        u.position = "ChiefQA";
        u.passportNumber = "4321";
        u.passportSerial = "123456";
        u.description = "JDI - awesome UI automation tool";
        u.gender = "Male";
        //u.religion = "Other";
        //u.weather = "Sun, Snow";
    });
}
