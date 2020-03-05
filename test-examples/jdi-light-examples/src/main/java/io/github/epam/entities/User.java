package io.github.epam.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String name = "Roman", password = "Jdi1234", lastName,
        acceptConditions, position, passportNumber, passportSeria,
        description, gender, religion, weather;
}
