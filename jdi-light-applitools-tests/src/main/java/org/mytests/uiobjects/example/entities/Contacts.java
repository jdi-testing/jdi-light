package org.mytests.uiobjects.example.entities;

import com.epam.jdi.tools.DataClass;

public class Contacts extends DataClass<Contacts> {
    public String name, lastName, acceptConditions, position, passportNumber,
                passportSeria, description, gender, religion, weather;
    public boolean passport;
}
