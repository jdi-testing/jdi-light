package page.objects.selenium;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.init.UIFactory.$;


public class HomePageEx extends PageBase {
    public HomePageEx() {
        super("/index.html", "Home");
    }

    @FindBy(css = "#name")
    public WebElement userName;
    public WebElement password = $("form #password");

    @UI("#name")
    public UIElement userNameUI;
    public UIElement passwordUI = $("form #password");
    @UI("#login-button")
    public UIElement enterUI;
}
