package com.jdiai.entities;

import com.jdiai.annotations.UI;
import com.jdiai.tools.DataClass;

public class LoginUser extends DataClass<LoginUser> {
    public static LoginUser Roman = new LoginUser().set(
        u -> {u.name = "Roman"; u.password = "Jdi1234"; });

    @UI public String name;
    @UI public String password;

}
