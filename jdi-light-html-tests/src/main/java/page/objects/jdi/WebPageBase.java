package page.objects.jdi;

import com.epam.jdi.light.elements.composite.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getUrlFromUri;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;

public class WebPageBase extends WebPage {
    @FindBy(id = "login-button") public WebElement enter;
}
