package page.objects.jdi;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.init.UIFactory.*;

@Url("/index.html") @Title("Home Page")
public class HomePageWebEx extends WebPageBase {
    @FindBy(css="form #name") public WebElement userName;
    public WebElement password = $("form #password");

    @UI("form #name") public UIElement userNameUI;
    public UIElement loginButton,
            passwordUI = $("form #password");
}
