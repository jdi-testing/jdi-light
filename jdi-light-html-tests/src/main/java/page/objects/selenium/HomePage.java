package page.objects.selenium;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;

public class HomePage {
    public HomePage() {
        initElements(getDriver(), this);
    }
    @FindBy(css="form #name") public WebElement userName;
    public WebElement password = $("form #password");
    @FindBy(id = "login-button") public WebElement enter;

    @UI("form #name") public UIElement userNameUI;
    public UIElement passwordUI = $("form #password");
    @UI("#login-button") public WebElement enterUI;
}
