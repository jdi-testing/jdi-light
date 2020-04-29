package jdisite.entities;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DefaultData {
    public static User ROMAN = new User().set(u -> {
        u.name = "Roman"; u.password = "Jdi1234";
    });
    public static MarvelUserInfo SPIDER_MAN = new MarvelUserInfo().set(m -> {
        m.number = "2"; m.type = "User"; m.user = "Sergey Ivan";
        m.description = "Spider Man:Dude";
    });
}
