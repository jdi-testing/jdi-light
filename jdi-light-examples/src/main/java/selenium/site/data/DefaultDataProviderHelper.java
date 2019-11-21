package selenium.site.data;

public class DefaultDataProviderHelper {
    public static ContactInfo ROMAN_CONTACT = new ContactInfo().set(c -> {
        c.name = "Roman";
        c.lastName = "Full Contact";
        c.position = "ChiefQA";
        c.passportNumber = 4321;
        c.passportSerial = 123456;
        c.description = "JDI - awesome UI automation tool";
        c.gender = "Male";
        c.religion = "Other";
        c.weather = "Sun, Snow";
        c.acceptConditions = true; }
    );
}
