package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.slideToggleSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SlideToggleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTest() {
        slideToggleSection.basicSlideToggle.is().displayed();
        slideToggleSection.resultSlideToggle.is().displayed();
        slideToggleSection.checkedCheckbox.is().displayed();
        slideToggleSection.disableCheckbox.is().displayed();
        slideToggleSection.colorRadioButtons.is().displayed();
    }

    @Test
    public void basicToggleCheckedTest() {
        slideToggleSection.basicSlideToggle.check();
        slideToggleSection.basicSlideToggle.is().selected();
        slideToggleSection.basicSlideToggle.uncheck();
        slideToggleSection.basicSlideToggle.is().deselected();
    }

    @Test
    public void resultToggleColorTest() {
        slideToggleSection.disableCheckbox.uncheck();
        slideToggleSection.resultSlideToggle.check();
        slideToggleSection.primaryRadioButton.click();
        slideToggleSection.resultSlideToggle.has().cssClass("mat-primary");
        slideToggleSection.accentRadioButton.click();
        slideToggleSection.resultSlideToggle.has().cssClass("mat-accent");
        slideToggleSection.warningRadioButton.click();
        slideToggleSection.resultSlideToggle.has().cssClass("mat-warn");
    }

    @Test
    public void resultToggleCheckedTest() {
        slideToggleSection.resultSlideToggle.uncheck();
        slideToggleSection.checkedCheckbox.check();
        slideToggleSection.resultSlideToggle.is().selected();
        slideToggleSection.checkedCheckbox.uncheck();
        slideToggleSection.resultSlideToggle.is().deselected();
    }

    @Test
    public void resultToggleDisableTest() {
        slideToggleSection.disableCheckbox.check();
        slideToggleSection.resultSlideToggle.is().disabled();
        slideToggleSection.disableCheckbox.uncheck();
        slideToggleSection.resultSlideToggle.is().enabled();
    }
}
