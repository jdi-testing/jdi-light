package io.github.epam.material.tests.surfaces;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.simpleAppBarPage;
import static io.github.com.StaticSite.hideAppBarPage;
import static io.github.com.StaticSite.elevateAppBarPage;
import static io.github.com.StaticSite.backToTopPage;
import static io.github.com.StaticSite.bottomAppBarPage;
import static io.github.com.pages.surfaces.AppBarPage.*;
import static  org.hamcrest.Matchers.containsString;

/**
 * To see an example of App Bar web element please visit
 * https://material-ui.com/components/app-bar/
 */

public class AppBarTests extends TestsInit {
    private final Timer timer = new Timer(2000L);

    @BeforeMethod
    public void setWindowSize(){
        WebDriverFactory.getDriver().manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void simpleAppBarTest() {
        simpleAppBarPage.open();
        simpleAppBarPage.shouldBeOpened();
        simpleMenu.isDisplayed();
        appBarMenu.isDisplayed();
        prominentMenu.isDisplayed();
        simpleText.has().text("News");
        appBarText.has().text("Photos");
        prominentText.has().text("Material-UI");
        simpleButton.is().displayed();
        appBarIcon.is().displayed();
        prominentSearch.is().displayed();
        prominentSecondMenu.is().displayed();
        logoutSwitch.uncheck();
        timer.wait(() -> appBarIcon.isNotVisible());
        logoutSwitch.check();
        timer.wait(() -> appBarIcon.isDisplayed());
        appBarIcon.click();
        timer.wait(() -> appBarIconOptions.get(1).isDisplayed());
        appBarIconOptions.get(1).click();
        timer.wait(() -> {
            appBarIconOptions.get(1).isNotVisible();
            appBarIcon.isVisible();
        });
    }

    @Test
    public void bottomAppBarTest() {
        bottomAppBarPage.open();
        bottomAppBarPage.shouldBeOpened();
        bottomButton.is().displayed();
        bottomMenuButton.is().displayed();
        bottomButtons.forEach(button -> button.is().displayed());
    }

    @Test
    public void hideAppBarTest() {
        hideAppBarPage.open();
        hideAppBarPage.shouldBeOpened();
        topAppBar.is().displayed();
        scrollToBottom();
        timer.wait(() -> topAppBar.isHidden());
    }

    @Test
    public void elevateAppBarTest() {
        elevateAppBarPage.open();
        elevateAppBarPage.shouldBeOpened();
        elevateAppBar.has().classValue(containsString("MuiPaper-elevation0"));
        scrollToBottom();
        timer.wait(() -> elevateAppBar.has().classValue(containsString("MuiPaper-elevation4")));
    }

    @Test
    public void backToTopTest() {
        backToTopPage.open();
        backToTopPage.shouldBeOpened();
        scrollBackText.is().visible();
        scrollBackToTopButton.is().hidden();
        scrollToBottom();
        timer.wait(() -> scrollBackText.isNotVisible());
        scrollBackToTopButton.click();
        timer.wait(() -> {
            scrollBackToTopButton.isHidden();
            scrollBackText.isVisible();
        });
    }
}
