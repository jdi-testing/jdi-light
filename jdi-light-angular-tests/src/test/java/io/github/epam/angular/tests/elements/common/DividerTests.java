package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.dividerSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.equalTo;

public class DividerTests extends TestsInit {

    private static final String ORIENTATION_ATTRIBUTE = "aria-orientation";
    private static final String HORIZONTAL_VALUE = "horizontal";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void dividerDisplayTest() {
        dividerSection.dividers.has().size(equalTo(2));
        dividerSection.dividers.get(1).is().displayed();
        dividerSection.dividers.get(2).is().displayed();
    }

    @Test
    public void dividerOrientationTest() {
        dividerSection.dividers.get(1).has().attr(ORIENTATION_ATTRIBUTE, HORIZONTAL_VALUE);
        dividerSection.dividers.get(2).has().attr(ORIENTATION_ATTRIBUTE, HORIZONTAL_VALUE);
    }
}
