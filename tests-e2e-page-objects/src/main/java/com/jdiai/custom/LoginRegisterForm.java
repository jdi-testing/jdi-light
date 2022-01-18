package com.jdiai.custom;

import com.jdiai.JS;
import com.jdiai.annotations.UI;
import com.jdiai.entities.User;

public class LoginRegisterForm extends LoginForm {
    @UI(hasText = "Register") public JS registerButton;

    public void register(User user) {
        userName.input(user.name);
        password.input(user.password);
        loginButton.click();
    }
}
