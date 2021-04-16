package io.github.com.entities;


import com.epam.jdi.light.common.Order;
import com.epam.jdi.tools.DataClass;

public class Contacts extends DataClass<Contacts> {
    public String firstName;
    public String lastName;
    public String acceptConditions;
    public String position;
    public String passportNumber;
    public String passportSeria;
    @Order(1)
    public String description;
    @Order(2)
    public String gender;
    public String religion;
    public String weather;
    @Order(3)
    public boolean passport;
}
