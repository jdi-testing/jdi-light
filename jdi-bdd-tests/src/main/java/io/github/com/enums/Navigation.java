package io.github.com.enums;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public enum Navigation {
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
    Navigation() { value = toString(); }
    Navigation(String value) { this.value = value; }
}
