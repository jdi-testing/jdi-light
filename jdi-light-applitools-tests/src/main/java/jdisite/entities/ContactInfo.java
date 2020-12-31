package jdisite.entities;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.tools.DataClass;

public class ContactInfo extends DataClass<ContactInfo> {
    public String firstName; 
    public String lastName;
    public String position;
    public String gender;
    public String religion;
    public String weather;
    public String description;
    public int passportNumber;
    public int passportSeria;
    public boolean passport;
    public boolean acceptConditions;
}
