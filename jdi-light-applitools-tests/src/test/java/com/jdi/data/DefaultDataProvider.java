package com.jdi.test.data;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import jdisite.entities.ContactInfo;

public class DefaultDataProvider {
    public static ContactInfo SIMPLE_CONTACT = new ContactInfo().set(c-> {
        c.name = "Roman"; c.lastName = "Iovlev"; c.position = "ChiefQA";
        c.passport = true; c.passportNumber = 4321; c.passportSeria = 123456;
        c.description = "JDI - awesome UI automation tool";
    });
    public static ContactInfo FULL_CONTACT = new ContactInfo().set(c-> {
        c.name = "Roman"; c.lastName = "Iovlev"; c.position = "ChiefQA";
        c.passport = true; c.passportNumber = 4321; c.passportSeria = 123456;
        c.description = "JDI - awesome UI automation tool";
        c.acceptConditions = true; c.gender = "Female";
        c.religion = "Other"; c.weather = "Sun, Rain";
    });
}
