package io.github.epam.mobile.tests;

import org.testng.annotations.Test;


import static io.github.epam.sections.HtmlMobileElements.htmlMenu;
import static io.github.epam.pages.HtmlMobilePage.*;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MobileWebProgressBarTests extends StaticTestsInit {

    @Test
    public void progressBarGetValue() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        staticProgressBar.is().value(70);
    }

    @Test
    public void progressBarIsDisplayed() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        staticProgressBar.is().displayed();
    }
}
