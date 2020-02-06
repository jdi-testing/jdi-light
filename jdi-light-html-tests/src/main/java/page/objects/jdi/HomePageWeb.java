package page.objects.jdi;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Title;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Url;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.mobile.elements.init.UIFactory.$;

@Url("/index.html") @Title("Home Page")
public class HomePageWeb extends WebPage {
    @FindBy(css="form #name") public WebElement userName;
    public WebElement password = $("form #password");
    @FindBy(id = "login-button") public WebElement enter;

    @UI("form #name") public UIElement userNameUI;
    public UIElement loginButton,
        passwordUI = $("form #password");
}
