package io.github.epam.angular.tests.elements.common;

import com.jdiai.tools.Timer;
import com.jdiai.tools.func.JAction;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ProgressSpinnerModes.DETERMINATE;
import static com.epam.jdi.light.angular.elements.enums.ProgressSpinnerModes.INDETERMINATE;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressSpinnerPage;
import static io.github.com.enums.Colors.*;
import static io.github.com.pages.ProgressSpinnerPage.*;
import static io.github.epam.angular.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.angular.tests.elements.BaseValidationsUtils.duration;

public class ProgressSpinnerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        progressSpinnerPage.open();
        waitCondition(() -> progressSpinnerPage.isOpened());
        progressSpinnerPage.checkOpened();
    }

    @Test(description = "Test checks basic progress spinner")
    public void baseValidationTest() {
        showSpinner.show();
        showSpinner.click();
        baseValidation(basicProgressSpinner);
    }

    @Test(description = "Test checks that basic progress spinner is hidden by default")
    public void checkSpinnerHidden() {
        showSpinner.show();
        basicProgressSpinner.assertThat().hidden();
    }

    @Test(description = "Test checks that progress spinner is displayed after clicking the button and then becomes hidden")
    public void checkSpinnerAppearAndThenDisappear() {
        showSpinner.click();
        basicProgressSpinner.is().displayed();
        waitCondition(() -> basicProgressSpinner.isHidden());
    }

    @Test(description = "Test checks that progress spinner disappears after being displayed")
    public void disappear() {
        showSpinner.click();
        new Timer(6000L).wait(() -> basicProgressSpinner.is().disappear());
    }

    @Test(description = "Test checks an interval during which spinner is displayed")
    public void checkSpinnerDurationTest() {
        refresh();
        showSpinner.show();
        final int DURATION = 5;
        JAction action = () -> {
            basicProgressSpinner.base().timer().wait(() -> basicProgressSpinner.isDisplayed());
            basicProgressSpinner.base().timer().wait(() -> basicProgressSpinner.isHidden());
        };
        showSpinner.click();
        duration(DURATION, 900, action);
    }

    @Test(description = "Test checks configurable progress spinner")
    public void configurableSpinnerBasicTest() throws Exception {
        configuredSpinner.shouldBe().displayed();
        configuredSpinner.show();
        configuredSpinner.shouldBe().visible();
        configuredSpinner.has().mode(DETERMINATE);
        configuredSpinner.has().value(50);
        configuredSpinner.has().color(DEEP_PURPLE_2.value());
        configuredSpinner.has().diameter("100px");
        configuredSpinner.has().strokeWidth("10%");
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
        configuredSpinner.has().color(RED_2.value());
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

    @Test(description = "Test checks progress spinner's values transformation")
    public void checkConfigurableSpinnerValueTest() throws Exception {
        configuredSpinner.has().value(50);
        progressSlider.moveRight();
        configuredSpinner.has().value(51);
        while (configuredSpinner.value() != 100) {
            progressSlider.moveRight();
        }
        configuredSpinner.has().value(100);
        while (configuredSpinner.value() != 0) {
            progressSlider.moveLeft();
        }
        configuredSpinner.has().value(0);
        while (configuredSpinner.value() != 50) {
            progressSlider.moveRight();
        }
    }
}
