package org.mytests.uiobjects.example.entities;

import com.epam.jdi.tools.DataClass;

public class Contacts extends DataClass<Contacts> {
    public String firstName, lastName, acceptConditions, position, passportNumber,
            passportSeria, description, gender, weather;
    public boolean passport;
}
