package org.jdiai.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public static User Roman = new User().set(
        u -> {u.name = "Roman"; u.password = "Jdi1234"; });

    public static User Triss = new User().set(u -> {
        u.name = "Triss";
        u.lastName = "Merigold";
        u.description = "Triss Merigold of Maribor was a legendary Temerian sorceress of the 13th century. Called Fourteenth of the Hill by her contemporaries because she was erroneously thought to have been killed during the Battle of Sodden Hill, she passed into history as Merigold the Fearless.";
        u.gender = "Female";
        u.religion = "Agnostic";
        u.hasPassport = true;
    });

    public String name, password, lastName, description, gender, religion;
    public Boolean hasPassport;

}
