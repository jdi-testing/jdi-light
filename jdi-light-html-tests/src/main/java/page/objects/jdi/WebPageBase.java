package page.objects.jdi;

import com.epam.jdi.light.elements.composite.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebPageBase extends WebPage {
    @FindBy(id = "login-button") public WebElement enter;
}
