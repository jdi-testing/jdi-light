package com.jditest.entities;

import com.epam.jdi.tools.DataClass;
import com.jditest.annotations.UI;

public class LoginUser extends DataClass<LoginUser> {
    public static LoginUser Roman = new LoginUser().set(
        u -> {u.name = "Roman"; u.password = "Jdi1234"; });

    @UI public String name;
    @UI public String password;

}
