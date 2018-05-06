package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import org.mytests.uiobjects.example.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(id="Name")
    public WebElement userName;
    @FindBy(id="Password")
    public WebElement password;

    @FindBy(css="[type=submit]")
    public WebElement enter;
}
