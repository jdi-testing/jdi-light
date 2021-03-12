package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.circularProgressFrame;
import static io.github.com.StaticSite.circularIndeterminatePage;
import static io.github.com.StaticSite.circularDeterminatePage;
import static io.github.com.StaticSite.circularIntegrationPage;
import static io.github.com.StaticSite.circularWithValueLabel;
import static io.github.com.StaticSite.delayingAppearancePage;

public class CircularProgressTests extends TestsInit {
    private final String defaultColor = "rgba(63, 81, 181, 1)";

    @Test
    public void indeterminateCircularTest() {
        circularIndeterminatePage.open();
        circularProgressFrame.circularDefault.is().indeterminate();
    }

    @Test
    public void determinateStagesCircularTest() {
        circularDeterminatePage.open();
        circularProgressFrame.circularDefault.is().determinate();
        circularProgressFrame.circularDefault.has().color(defaultColor);
        circularProgressFrame.circularDefault.has().value(25);
        circularProgressFrame.circularSecond.has().value(50);
        circularProgressFrame.circularDeterminateThreeQ.has().value(75);
        circularProgressFrame.circularDeterminateFull.has().value(100);
    }

    @Test
    public void determinateShrinkCircularTest() {
        circularDeterminatePage.open();
        circularProgressFrame.circularIndeterminateDisableShrink.is().indeterminate();
        circularProgressFrame.circularIndeterminateDisableShrink.has().color(defaultColor);
    }

    @Test
    public void circularIntegrationTest() {
        circularIntegrationPage.open();
        circularProgressFrame.acceptTermsButton.click();
        circularProgressFrame.circularDefault.is().indeterminate();
        circularProgressFrame.circularDefault.base().timer().wait(() -> circularProgressFrame.acceptTermsButton.isEnabled());
        circularProgressFrame.acceptTermsButton.click();
        circularProgressFrame.circularSecond.is().indeterminate();
    }

    @Test
    public void circularLabelTest() {
        circularWithValueLabel.open();
        circularProgressFrame.circularDefault.is().determinate();
        circularProgressFrame.circularTypography.has().styleClass("caption");
    }

    @Test
    public void delayingAppearanceTest() {
        delayingAppearancePage.open();
        circularProgressFrame.loadingButton.click();
        circularProgressFrame.circularDefault.is().indeterminate();
        circularProgressFrame.loadingButton.click();
        circularProgressFrame.circularDefault.is().notVisible();

        circularProgressFrame.simulateLoadButton.click();
        circularProgressFrame.circularDefault.is().indeterminate();
        circularProgressFrame.circularDefault.base().timer().wait(() -> circularProgressFrame.circularDefault.isHidden());
        circularProgressFrame.circularDefault.is().notVisible();
    }
}
