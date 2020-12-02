package io.github.epam.enums;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public enum Navigation {
    Home,
    ContactForm("Contact form"),
    Support,
    Dates,
    Service,
    ComplexTable("Complex Table"),
    SimpleTable("Simple Table"),
    UserTable("User Table"),
    TableWithPages("Table with pages"),
    DifferentElements("Different elements"),
    MetalsColors("Metals & Colors");

    public String value;
    Navigation() { value = toString(); }
    Navigation(String value) { this.value = value; }
}
