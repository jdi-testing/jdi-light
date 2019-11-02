package org.mytests.uiobjects.example.entities;


public class Defaults {
    public static User DEFAULT_USER = new User().set(u -> {
        u.name = "Roman"; u.password = "Jdi1234";
    });

    public static MarvelUserInfo SPIDER_MAN = new MarvelUserInfo().set(m -> {
        m.number = "2";
        m.type = "User";
        m.user = "Sergey Ivan";
        m.description = "Spider Man:Dude";
    });
}
