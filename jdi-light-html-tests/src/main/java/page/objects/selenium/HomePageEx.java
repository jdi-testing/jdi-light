package page.objects.selenium;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.init.UIFactory.$;


public class HomePageEx extends PageBase {
    public WebElement password = $("form #password");
    public UIElement passwordUI = $("form #password");
    public HomePageEx() { super("/index.html", "Home");}
    @FindBy(css="form #name") public WebElement userName;

    @UI("form #name") public UIElement userNameUI;
    @UI("#login-button") public UIElement enterUI;
}
