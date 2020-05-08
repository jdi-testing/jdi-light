package selenium.seleniumPO;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getWebDriverFactory;

public class HomePage {
    private final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private final WebDriverFactory driverFactory = getWebDriverFactory();

    @FindBy(css = ".sidebar-menu [ui=label]")
    List<WebElement> navigation;
    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;
    @FindBy(css = ".profile-photo [ui=label]")
    WebElement userName;

    // TODO fix performance
    @UI("//*[@ui='label']//*[contains(text(),'%s')]")
    public static WebList leftNavigation;
    //@UI("[ui=label][*'%s']") public static WebList leftNavigation;

    public void open() {
        driverFactory.getDriver().navigate().to(url);
    }

    public void navigateTo(int num) {
        try {
            navigation.get(num).click();
        } catch (StaleElementReferenceException ex) {
            driverFactory.getDriver().findElements(By.cssSelector(".sidebar-menu [ui=label]")).get(num).click();
        }
    }

    public void navigateTo(String text) {
        List<WebElement> navigations = driverFactory.getDriver().findElements(By.cssSelector(".sidebar-menu [ui=label]"));
        for (WebElement el : navigations) {
            if (el.getText().equals(text)) {
                el.click();
                return;
            }
        }
    }
}
