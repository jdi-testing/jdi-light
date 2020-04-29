package jdisite.enums;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public enum MenuOptions {
    Home("Home"),
    ContactForm("Contact form"),
    Support("Support"),
    Dates("Dates"),
    Service("Service"),
    ComplexTable("Complex Table"),
    SimpleTable("Simple Table"),
    UserTable("User Table"),
    TableWithPages("Table with pages"),
    DifferentElements("Different elements"),
    MetalsColors("Metals & Colors"),
    Performance("Performance"),
    ElementsPacks("Elements packs"),
    HTML5("HTML 5"),
    Bootstrap("Bootstrap");

    public String value;
    MenuOptions(String value) { this.value = value; }
}
