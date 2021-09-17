package jdisite.entities;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdiai.tools.DataClass;

public class ContactInfo extends DataClass<ContactInfo> {
    public String firstName, lastName, position, gender, religion, weather, description;
    public int passportNumber, passportSeria;
    public boolean passport, acceptConditions;
}
