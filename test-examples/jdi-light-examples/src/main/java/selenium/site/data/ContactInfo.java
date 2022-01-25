package selenium.site.data;

import com.jdiai.tools.DataClass;

public class ContactInfo extends DataClass<ContactInfo> {
    public String firstName, lastName, position,
                    gender, religion, weather, description;
    public Integer passportNumber, passportSeria;
    public Boolean passport, acceptConditions;
}