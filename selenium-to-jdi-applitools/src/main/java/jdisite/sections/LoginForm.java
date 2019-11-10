package jdisite.sections;

import jdisite.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm {
    @FindBy(id = "name") WebElement name;
    @FindBy(id = "password") WebElement password;
    @FindBy(id = "login-button") WebElement loginButton;

    public void loginAs(User user) {
        if (user.name != null) {
            this.name.clear();
            this.name.sendKeys(user.name);
        }
        if (user.password != null) {
            this.password.clear();
            this.password.sendKeys(user.password);
        }
        loginButton.click();
    }
    public boolean isHidden() {
        return !name.isDisplayed();
    }
}
