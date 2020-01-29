package selenium.seleniumPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.entities.User;

public class LoginForm {
    @FindBy(css="form #name")      WebElement userName;
    @FindBy(css="form #password")  WebElement password;

    @FindBy(css="form [type=submit]") WebElement enter;

    void loginAs(User user) {
        userName.sendKeys(user.userName);
        password.sendKeys(user.password);
        enter.click();
    }
}
