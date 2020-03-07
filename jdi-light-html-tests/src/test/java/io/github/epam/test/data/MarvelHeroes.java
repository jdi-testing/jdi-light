package io.github.epam.test.data;

import io.github.com.entities.*;

public class MarvelHeroes {
    public static MarvelUserInfo SPIDER_MAN = new MarvelUserInfo().set(m -> {
        m.number = "2";
        m.type = "User";
        m.user = "Sergey Ivan";
        m.description = "Spider Man:Dude";
    });
    public static MarvelUserSimple SPIDER_MAN_SIMPLE = new MarvelUserSimple().set(m -> {
        m.number = "2";
        m.type = "User";
        m.user = "Sergey Ivan";
        m.description = "Spider Man:Dude";
    });
}
