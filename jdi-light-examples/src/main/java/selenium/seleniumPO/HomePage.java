package selenium.seleniumPO;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class HomePage {
    private String url = "https://jdi-testing.github.io/jdi-light/index.html";
    @FindBy(css = ".profile-photo")protected WebElement profilePhoto;
    @FindBy(css = ".profile-photo [ui=label]")protected WebElement userName;

    public void open() {
        getDriver().navigate().to(url);
    }

    @FindBy(css = ".sidebar-menu [ui=label]")private List<WebElement> navigation;
    public void navigateTo(int num) {
        try {
            navigation.get(num).click();
        } catch (StaleElementReferenceException ex) {
            getDriver().findElements(By.cssSelector(".sidebar-menu [ui=label]")).get(num).click();
        }
    }
    public void navigateTo(String text) {
        List<WebElement> navigations = getDriver().findElements(By.cssSelector(".sidebar-menu [ui=label]"));
        for (WebElement el : navigations) {
            if (el.getText().equals(text)) {
                el.click();
                return;
            }
        }
    }

    // TODO fix performance
    @UI("//*[@ui='label']//*[contains(text(),'%s')]") public static WebList leftNavigation;
    //@UI("[ui=label][*'%s']") public static WebList leftNavigation;
}
