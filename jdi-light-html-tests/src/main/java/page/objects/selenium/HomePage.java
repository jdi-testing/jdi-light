package page.objects.selenium;

import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.UIFactory.$;

public class HomePage {
    public HomePage() {
        initElements(this);
    }
    @FindBy(css="form #name") public WebElement userName;
    public WebElement password = $("form #password");
    @FindBy(id = "login-button") public WebElement enter;

    @UI("form #name") public uiElement userNameUI;
    public uiElement passwordUI = $("form #password");
    @UI("#login-button") public WebElement enterUI;
}
