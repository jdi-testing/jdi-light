package org.mytests.tests.test.data;

import org.mytests.uiobjects.example.entities.MarvelUserInfo;

public class MarvelHeroes {
    public static MarvelUserInfo SPIDER_MAN = new MarvelUserInfo().set(m -> {
        m.number = "2";
        m.type = "User";
        m.user = "Sergey Ivan";
        m.description = "Spider Man:Dude";
    });
}
