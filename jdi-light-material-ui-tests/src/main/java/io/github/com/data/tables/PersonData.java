package io.github.com.data.tables;

import com.epam.jdi.tools.DataClass;
import io.github.com.data.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonData extends DataClass {
    public List<Person> persons = new ArrayList<>();

    public void setDefault() {

    }
}
