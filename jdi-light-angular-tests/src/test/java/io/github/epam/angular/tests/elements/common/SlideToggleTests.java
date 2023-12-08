package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slideTogglePage;
import static io.github.com.pages.SlideTogglePage.*;


public class SlideToggleTests extends TestsInit {

    @BeforeClass(alwaysRun = true)
    public void before() {
        slideTogglePage.open();
        waitCondition((() -> slideTogglePage.isOpened()));
        slideTogglePage.checkOpened();
    }

    @Test
    public void basicToggleCheckedTest() {
        basicSlideToggle.show();
        basicSlideToggle.check();
        basicSlideToggle.is().selected();
        basicSlideToggle.uncheck();
        basicSlideToggle.is().deselected();
    }

    @Test
    public void resultToggleColorTest() {
        disableCheckbox.uncheck();
        resultSlideToggle.check();
        primaryRadioButton.click();
        resultSlideToggle.has().cssClass("mat-primary");
        accentRadioButton.click();
        resultSlideToggle.has().cssClass("mat-accent");
        warningRadioButton.click();
        resultSlideToggle.has().cssClass("mat-warn");
    }

    @Test
    public void resultToggleCheckedTest() {
        resultSlideToggle.uncheck();
        checkedCheckbox.check();
        resultSlideToggle.is().selected();
        checkedCheckbox.uncheck();
        resultSlideToggle.is().deselected();
    }

    @Test
    public void resultToggleDisableTest() {
        disableCheckbox.check();
        resultSlideToggle.is().disabled();
        disableCheckbox.uncheck();
        resultSlideToggle.is().enabled();
    }
}
