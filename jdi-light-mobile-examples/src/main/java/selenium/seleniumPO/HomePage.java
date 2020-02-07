package selenium.seleniumPO;

import com.epam.jdi.mobile.elements.complex.WebList;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;

public class HomePage {
    private String url = "https://jdi-testing.github.io/jdi-light/index.html";
    public void open() {
        getDriver().navigate().to(url);
    }

    @FindBy(css = ".sidebar-menu [ui=label]") List<WebElement> navigation;
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
    @FindBy(css = ".profile-photo") WebElement profilePhoto;
    @FindBy(css = ".profile-photo [ui=label]") WebElement userName;

    // TODO fix performance
    @UI("//*[@ui='label']//*[contains(text(),'%s')]") public static WebList leftNavigation;
    //@UI("[ui=label][*'%s']") public static WebList leftNavigation;
}
