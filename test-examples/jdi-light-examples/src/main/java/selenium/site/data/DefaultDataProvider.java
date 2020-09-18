package selenium.site.data;

public class DefaultDataProvider {
    public static ContactInfo ROMAN_CONTACT = new ContactInfo().set(c -> {
        c.firstName = "Roman";
        c.lastName = "Full Contact";
        c.position = "ChiefQA";
        c.passportNumber = 4321;
        c.passportSeria = 123456;
        c.description = "JDI - awesome UI automation tool";

        c.gender = "Female";
        c.religion = "Other";
        c.weather = "Sun, Snow";
        c.acceptConditions = true; }
    );
}
