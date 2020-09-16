package io.github.com.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.User;
import org.openqa.selenium.By;

import static io.github.com.pages.Header.userIcon;

public class LoginForm extends Form<User> {
    protected TextField name;
    protected TextField password;
    protected Button loginButton;

    @Override
    public boolean isHidden() {
        return new UIElement(By.cssSelector(".dropdown.uui-profile-menu.open")).isHidden();
    }

    @Override
    public boolean isDisplayed() {
        return !isHidden();
    }

    public void shouldBeOpened() {
        if (isHidden()) {
            userIcon.click();
        }
    }
}
