package io.github.com.entities;


public class Users {
    public static User DEFAULT_USER = new User();

    public static final String defaultName = "Roman";
    public static final String defaultLastName = "Iovlev";
    public static final String defaultPosition = "ChiefQA";
    public static final String defaultPassportNumber = "4321";
    public static final String defaultPassportSeria = "123456";
    public static final String defaultDescription = "JDI - awesome UI automation tool";
    public static final String defaultAcceptConditions = "true";
    public static final String defaultGender = "Female";
    public static final String defaultReligion = "Other";
    public static final String lowerCaseName = defaultName.toLowerCase();

    public static Contacts DEFAULT_CONTACT = new Contacts().set(c -> {
        c.name = defaultName;
        c.lastName = defaultLastName;
        c.position = defaultPosition;
        //c.passport = true;
        c.passportNumber = defaultPassportNumber;
        c.passportSeria = defaultPassportSeria;
        c.description = defaultDescription;
        c.acceptConditions = defaultAcceptConditions;
        c.gender = defaultGender;
        c.religion = defaultReligion;
    });

    public static Contacts LOWER_CASE_NAME_CONTACT = new Contacts().set(c -> {
        c.name = lowerCaseName;
        c.lastName = defaultLastName;
        c.position = defaultPosition;
        c.passportNumber = defaultPassportNumber;
        c.passportSeria = defaultPassportSeria;
        c.description = defaultDescription;
        c.acceptConditions = defaultAcceptConditions;
        c.gender = defaultGender;
        c.religion = defaultReligion;
    });

    public static Contacts ONLY_NAME_FILLED_DEFAULT_CONTACT = new Contacts().set(c -> c.name = defaultName);

    public static Contacts ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT = new Contacts().set(c -> {
        c.lastName = defaultLastName;
        c.position = defaultPosition;
        //c.passport = true;
        c.passportNumber = defaultPassportNumber;
        c.passportSeria = defaultPassportSeria;
        c.description = defaultDescription;
        c.acceptConditions = defaultAcceptConditions;
        c.gender = defaultGender;
        c.religion = defaultReligion;
    });
}
