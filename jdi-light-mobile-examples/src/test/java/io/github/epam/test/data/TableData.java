package io.github.epam.test.data;

import io.github.epam.entities.UserInfo;

public class TableData {

    public static UserInfo GRADY_BROCK = new UserInfo().set(u-> {
        u.name = "Grady Brock";
        u.email = "cursus.et@commodo.org";
        u.phone = "(011307) 16843";
        u.city = "Alcobendas";
    });
}
