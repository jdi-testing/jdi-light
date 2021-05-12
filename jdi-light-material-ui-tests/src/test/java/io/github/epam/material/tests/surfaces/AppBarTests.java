package io.github.epam.material.tests.surfaces;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.surfaces.AppBarPage.*;

/**
 * To see an example of App Bar web element please visit https://material-ui.com/components/app-bar/
 */
public class AppBarTests extends TestsInit {
    private final Timer timer = new Timer(2000L);

    @Test
    public void simpleAppBarTest() {
        openSection("App Bar", "Simple App Bars");
        simpleMenu.is().enabled();
        appBarMenu.is().enabled();
        prominentMenu.is().enabled();
        simpleText.has().text("News");
        appBarText.has().text("Photos");
        prominentText.has().text("Material-UI");
        simpleButton.is().enabled();
        appBarIcon.is().enabled();
        prominentSearch.is().enabled();
        prominentSecondMenu.is().enabled();

        logoutSwitchButton.click();
        appBarIcon.is().notVisible();
        logoutSwitchButton.click();
        appBarIcon.is().displayed();
        appBarIcon.click();
        appBarIconOptions.get(1).is().displayed();
    }

    @Test
    public void bottomAppBarTest() {
        openSection("App Bar", "Bottom App Bar");
        bottomButton.is().displayed();
        bottomMenuButton.is().displayed();
        bottomSearchButton.is().displayed();
        bottomSecondMenuButton.is().displayed();
    }

    @Test
    public void hideAppBarTest() {
        openSection("App Bar", "Hide App Bar");
        topAppBar.is().displayed();
        appBar.core().jsExecute("scrollIntoView()");
        timer.wait(() -> topAppBar.is().hidden());
    }

    @Test
    public void elevateAppBarTest() {
        openSection("App Bar", "Elevate App Bar");
        elevateAppBar.has().classValue(Matchers.containsString("MuiPaper-elevation0"));
        appBar.core().jsExecute("scrollIntoView()");
        elevateAppBar.has().classValue(Matchers.containsString("MuiPaper-elevation4"));
    }

    @Test
    public void backToTopTest() {
        openSection("App Bar", "Back to top");
        scrollBackText.is().visible();
        scrollBackToTopButton.is().hidden();
        appBar.core().jsExecute("scrollIntoView()");
        scrollBackText.is().notVisible();
        scrollBackToTopButton.click();
        timer.wait(() -> {
            scrollBackToTopButton.is().hidden();
            scrollBackText.is().visible();
        });
    }
}
