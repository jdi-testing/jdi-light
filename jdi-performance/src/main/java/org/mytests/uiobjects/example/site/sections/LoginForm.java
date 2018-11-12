package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.mytests.uiobjects.example.entities.User;
import org.openqa.selenium.WebElement;

public class LoginForm extends Form<User> {
    @Css("#Name")      WebElement userName;
    @Css("#Password")  WebElement password;

    @Css("[type=submit]") WebElement enter;
}
