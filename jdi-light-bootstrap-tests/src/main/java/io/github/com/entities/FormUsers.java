package io.github.com.entities;


public class FormUsers {

    private static FormContacts defaultContact() {
        return new FormContacts().set(c -> {
            c.name = "Dmitrii";
            c.lastName = "Pavlov";
            c.userName = "Delnote";
            c.city = "Saint-Petersburg";
            c.state = "North capital";
            c.zip = "190000";
            c.accept = "true";
        });
    }

    private static FormContacts defaultCheckContact() {
        return new FormContacts().set(c -> {
            c.name = "Mark";
            c.lastName = "Otto";
            c.userName = "";
            c.city = "";
            c.state = "";
            c.zip = "";
            c.accept = "false";
        });
    }

    public static FormContacts DEFAULT_CONTACT = defaultContact();

    public static FormContacts DEFAULT_CHECK = defaultCheckContact();

    public static FormContacts LOWER_CASE_NAME_CONTACT =
            defaultContact().set(c -> c.name = c.name.toLowerCase());
    public static FormContacts UPPER_CASE_NAME_CONTACT =
            defaultContact().set(c -> c.name = c.name.toUpperCase());

    public static FormContacts ONLY_NAME_FILLED_DEFAULT_CONTACT =
            new FormContacts().set(c -> c.name = "Roman");

    public static FormContacts ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT =
            defaultContact().set(c -> c.name = null);
}
