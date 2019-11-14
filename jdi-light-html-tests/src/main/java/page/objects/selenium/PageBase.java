package page.objects.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class PageBase {
    public static String JDI_DOMAIN = "https://jdi-testing.github.io/jdi-light";
    public String url;
    public String title;
    public @FindBy(css = "#login-button") WebElement enter;
    public PageBase(String url, String title) {
        this.url = JDI_DOMAIN + url;
        this.title = title;
        initElements(this);
    }
}
