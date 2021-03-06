package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.circularFrame;
import static io.github.com.StaticSite.circularIndeterminatePage;
import static io.github.com.StaticSite.circularDeterminatePage;
import static io.github.com.StaticSite.circularIntegrationPage;
import static io.github.com.StaticSite.circularWithValueLabel;
import static io.github.com.StaticSite.delayingAppearancePage;

public class CircularTests extends TestsInit {
    private final String defaultColor = "rgba(63, 81, 181, 1)";

    @Test
    public void indeterminateCircularTest() {
        circularIndeterminatePage.open();
        circularFrame.circularDefault.is().indeterminate();
    }

    @Test
    public void determinateStagesCircularTest() {
        circularDeterminatePage.open();
        circularFrame.circularDefault.is().determinate();
        circularFrame.circularDefault.has().color(defaultColor);
        circularFrame.circularDefault.has().value(25);
        circularFrame.circularSecond.has().value(50);
        circularFrame.circularDeterminateThreeQ.has().value(75);
        circularFrame.circularDeterminateFull.has().value(100);
    }

    @Test
    public void determinateShrinkCircularTest() {
        circularDeterminatePage.open();
        circularFrame.circularIndeterminateDisableShrink.is().indeterminate();
        circularFrame.circularIndeterminateDisableShrink.has().color(defaultColor);
    }

    @Test
    public void circularIntegrationTest() {
        circularIntegrationPage.open();
        circularFrame.acceptTermsButton.click();
        circularFrame.circularDefault.is().indeterminate();
        circularFrame.circularDefault.base().timer().wait(() -> circularFrame.acceptTermsButton.isEnabled());
        circularFrame.acceptTermsButton.click();
        circularFrame.circularSecond.is().indeterminate();
    }

    @Test
    public void circularLabelTest() {
        circularWithValueLabel.open();
        circularFrame.circularDefault.is().determinate();
        circularFrame.circularTypography.has().styleClass("caption");
    }

    @Test
    public void delayingAppearanceTest() {
        delayingAppearancePage.open();
        circularFrame.loadingButton.click();
        circularFrame.circularDefault.is().indeterminate();
        circularFrame.loadingButton.click();
        circularFrame.circularDefault.is().notVisible();

        circularFrame.simulateLoadButton.click();
        circularFrame.circularDefault.is().indeterminate();
        circularFrame.circularDefault.base().timer().wait(() -> circularFrame.circularDefault.isHidden());
        circularFrame.circularDefault.is().notVisible();
    }
}
