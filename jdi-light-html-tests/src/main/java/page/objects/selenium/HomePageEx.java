package page.objects.selenium;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.mobile.elements.init.UIFactory.$;


public class HomePageEx extends PageBase {
    public HomePageEx() { super("/index.html", "Home");}
    @FindBy(css="form #name") public WebElement userName;
    public WebElement password = $("form #password");

    @UI("form #name") public UIElement userNameUI;
    public UIElement passwordUI = $("form #password");
    @UI("#login-button") public UIElement enterUI;
}
