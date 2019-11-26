package selenium.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.entities.User;

public class LoginForm {
    @FindBy(css="form #name")private  WebElement userName;
    @FindBy(css="form #password")private WebElement password;

    @FindBy(css="form [type=submit]")private WebElement enter;

    public void loginAs(User user) {
        userName.sendKeys(user.userName);
        password.sendKeys(user.password);
        enter.click();
    }
}
