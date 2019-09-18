package io.github.com.entities;


public class Users {
    public static User DEFAULT_USER = new User();

    private static Contacts defaultContact() {
        return new Contacts().set(c -> {
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
    public static Contacts DEFAULT_CONTACT = defaultContact();

    public static Contacts LOWER_CASE_NAME_CONTACT =
        defaultContact().set(c-> c.name = c.name.toLowerCase());
    public static Contacts UPPER_CASE_NAME_CONTACT =
        defaultContact().set(c-> c.name = c.name.toUpperCase());

    public static Contacts ONLY_NAME_FILLED_DEFAULT_CONTACT =
        new Contacts().set(c -> c.name = "Roman");

    public static Contacts ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT =
        defaultContact().set(c -> c.name = null);
}
