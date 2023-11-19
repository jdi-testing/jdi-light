package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ProgressSpinnerModes.DETERMINATE;
import static com.epam.jdi.light.angular.elements.enums.ProgressSpinnerModes.INDETERMINATE;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressSpinnerPage;
import static io.github.com.enums.Colors.*;
import static io.github.com.pages.ProgressSpinnerPage.*;

public class ProgressSpinnerTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressSpinnerPage.open();
        waitCondition(() -> progressSpinnerPage.isOpened());
        progressSpinnerPage.checkOpened();
    }

    @Test(description = "Test checks basic progress spinner")
    public void baseValidationTest() {
        showSpinner.show();
        showSpinner.click();
        basicProgressSpinner.is().visible();
    }

    @Test(description = "Test checks that basic progress spinner is hidden by default")
    public void checkSpinnerHidden() {
        showSpinner.show();
        basicProgressSpinner.is().hidden();
    }

    @Test(description = "Test checks configurable progress spinner")
    public void configurableSpinnerBasicTest() {
        configuredSpinner.show();
        configuredSpinner.shouldBe().visible();
        configuredSpinner.has().diameter("100px")
                .and().strokeWidth("10%");
    }

    @Test(description = "Test checks progress spinner's color attribute")
    public void checkConfigurableSpinnerColorTest() {
        configuredSpinner.show();
        configuredSpinner.has().color(DEEP_PURPLE_2.value());
        progressSpinnerAccentColorRadio.click();
        configuredSpinner.has().color(AMBER_ACCENT_5.value());
        progressSpinnerWarnColorRadio.click();
        configuredSpinner.has().color(RED_2.value());
        progressSpinnerIndeterminateModeRadio.click();
        configuredSpinner.has().mode(INDETERMINATE);
        progressSpinnerPrimaryColorRadio.click();
        waitCondition(() -> configuredSpinner.color().equals(DEEP_PURPLE_2.value()));
        configuredSpinner.has().color(DEEP_PURPLE_2.value());
        progressSpinnerDeterminateModeRadio.click();
    }

    @Test(description = "Test checks progress spinner's mode attribute")
    public void checkConfigurableSpinnerModeTest() {
        configuredSpinner.show();
        configuredSpinner.has().mode(DETERMINATE);
        progressSpinnerIndeterminateModeRadio.click();
        configuredSpinner.has().mode(INDETERMINATE);
        progressSpinnerDeterminateModeRadio.click();
        configuredSpinner.has().mode(DETERMINATE);
    }

    // TODO Slider moves to unexpected value, should be fixed when slide() method is fixed
    @Test(description = "Test checks progress spinner's values transformation", enabled = false)
    public void checkConfigurableSpinnerValueTest() {
        configuredSpinner.has().value(50);
        progressSlider.slide(1);
        configuredSpinner.has().value(51);
        progressSlider.slide(-1);
        configuredSpinner.has().value(50);
    }
}
