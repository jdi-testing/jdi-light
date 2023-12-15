package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slideTogglePage;
import static io.github.com.pages.SlideTogglePage.*;


public class SlideToggleTests extends TestsInit {

    @BeforeClass
    public void before() {
        slideTogglePage.open();
        waitCondition((() -> slideTogglePage.isOpened()));
        slideTogglePage.checkOpened();
    }

    @Test(description="Test verifies functionality of basic slide toggle")
    public void basicToggleCheckedTest() {
        basicSlideToggle.show();
        basicSlideToggle.check();
        basicSlideToggle.is().selected();
        basicSlideToggle.uncheck();
        basicSlideToggle.is().notSelected();
    }

    @Test(description="Test verifies color of button toggle")
    public void resultToggleColorTest() {
        resultSlideToggle.check();
        primaryRadioButton.click();
        resultSlideToggle.has().cssClass("mat-primary");
        accentRadioButton.click();
        resultSlideToggle.has().cssClass("mat-accent");
        warningRadioButton.click();
        resultSlideToggle.has().cssClass("mat-warn");
    }

    @Test(description="Test verifies functionality of result slide toggle")
    public void resultToggleCheckedTest() {
        resultSlideToggle.uncheck();
        checkedCheckbox.check();
        resultSlideToggle.is().selected();
        checkedCheckbox.uncheck();
        resultSlideToggle.is().notSelected();
    }

    @Test(description="Test verifies feature enabled/disabled for button toggle")
    public void resultToggleDisableTest() {
        disableCheckbox.check();
        resultSlideToggle.is().disabled();
        disableCheckbox.uncheck();
        resultSlideToggle.is().enabled();
    }

    @Test(description = "Test verifies that button toggle label in in before/after position")
    public void labelButtonTogglePositionTest() {
        beforeLabelPositionRadioButton.click();
        resultSlideToggle.has().labelBeforePosition();
        basicSlideToggle.has().labelAfterPosition();
    }

}
