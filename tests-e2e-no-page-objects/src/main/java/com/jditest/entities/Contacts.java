package com.jditest.entities;

import com.epam.jdi.tools.DataClass;
import com.jditest.annotations.UI;

public class Contacts extends DataClass<Contacts> {
    public static Contacts Triss = new Contacts().set(u -> {
        u.name = "Triss";
        u.lastName = "Merigold";
        u.description = "Triss Merigold of Maribor was a legendary Temerian sorceress of the 13th century. Called Fourteenth of the Hill by her contemporaries because she was erroneously thought to have been killed during the Battle of Sodden Hill, she passed into history as Merigold the Fearless.";
        u.gender = "Female";
        u.religion = "Agnostic";
        u.hasPassport = true;
    });

    @UI("#first-name") public String name;
    @UI public String lastName;
    @UI public String description;
    @UI public String gender;
    @UI("#religion-options") public String religion;
    @UI("#passport") public Boolean hasPassport;

}
