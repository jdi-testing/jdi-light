package io.github.epam.entities;

import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {
    public String name = "Roman", firstName = "Roman", password = "Jdi1234", lastName,
        acceptConditions, position, passportNumber, passportSeria,
        description, gender, religion, weather;
}
