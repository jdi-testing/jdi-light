package page.objects.selenium;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.UIFactory.$;

public class HomePage {
    @UI("form #name") public UIElement userNameUI;
    @UI("#login-button") public WebElement enterUI;
    @FindBy(css="form #name") public WebElement userName;
    @FindBy(id = "login-button") public WebElement enter;
    public WebElement password = $("form #password");
    public UIElement passwordUI = $("form #password");
    public HomePage() {
        initElements(this);
    }
}
