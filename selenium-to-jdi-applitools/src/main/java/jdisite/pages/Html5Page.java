package jdisite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static jdisite.utils.DriverUtils.DRIVER;
import static org.testng.Assert.assertEquals;

public class Html5Page {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/html5.html";
    public static final String TITLE = "HTML 5";
    @FindBy(id = "suspend-button")
    public WebElement suspendButton;

    public static void CheckHtmlPageOpened() {
        assertEquals(DRIVER.getCurrentUrl(), Html5Page.URL);
        assertEquals(DRIVER.getTitle(), Html5Page.TITLE);
    }
}
