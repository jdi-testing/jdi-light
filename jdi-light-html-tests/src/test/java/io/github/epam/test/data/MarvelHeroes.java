package io.github.epam.test.data;

import io.github.com.entities.MarvelUserInfo;

public class MarvelHeroes {
    public static MarvelUserInfo SPIDER_MAN = new MarvelUserInfo().set(m -> {
        m.number = "2";
        m.user = "Sergey Ivan";
        m.type = "User";
        m.description = "Spider Man";
    });
}
