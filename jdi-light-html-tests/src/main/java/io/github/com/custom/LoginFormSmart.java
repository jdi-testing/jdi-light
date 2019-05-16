package io.github.com.custom;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import io.github.com.entities.User;

import static io.github.com.pages.Header.userIcon;

public class LoginFormSmart extends Form<User> {
    TextField name, password;
    Button loginButton;

    public void shouldBeOpened() {
        if (isHidden()) {
            userIcon.click();
        }
    }

    public boolean isHidden() {
        return name.isHidden();
    }
}
