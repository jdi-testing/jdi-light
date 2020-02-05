package selenium.site.data;

import com.epam.jdi.tools.DataClass;

public class ContactInfo extends DataClass<ContactInfo> {
    public String name, lastName, position,
                    gender, religion, weather, description;
    public Integer passportNumber, passportSeria;
    public Boolean passport, acceptConditions;
}