package org.mytests.uiobjects.example.seleniumPO;

import org.mytests.uiobjects.example.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm {
    @FindBy(css="form #Name")      WebElement userName;
    @FindBy(css="form #Password")  WebElement password;

    @FindBy(css="form [type=submit]") WebElement enter;

    void loginAs(User user) {
        userName.sendKeys(user.userName);
        password.sendKeys(user.password);
        enter.click();
    }
}
