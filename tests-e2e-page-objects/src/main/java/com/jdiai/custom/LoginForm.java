package com.jdiai.custom;

import com.jdiai.JS;
import com.jdiai.Section;
import com.jdiai.annotations.UI;
import com.jdiai.entities.User;

public class LoginForm extends Section {
    @UI(css = "h1") public JS label;
    @UI(id = "name") public JS userName;
    @UI(id = "password") public JS password;

    @UI(css = "[type=submit]") public JS loginButton;

    public void loginAs(User user) {
        userName.input(user.name);
        password.input(user.password);
        loginButton.click();
    }
}
