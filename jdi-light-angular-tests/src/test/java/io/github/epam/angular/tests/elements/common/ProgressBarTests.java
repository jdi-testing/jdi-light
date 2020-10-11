package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.*;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.*;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ProgressBarSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ProgressBarTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyDeterminateProgressBarTest() throws Exception {
        matProgressBarDeterminate.shouldBe().displayed();
        matProgressBarDeterminate.show();
        matProgressBarDeterminate.shouldBe().visible();
        matProgressBarDeterminate.has().mode(DETERMINATE);
        matProgressBarDeterminate.has().value(40);
        matProgressBarDeterminate.has().max(100);
        matProgressBarDeterminate.has().min(0);
        matProgressBarDeterminate.has().color(BLUE);
    }

    @Test
    public void verifyQueryProgressBarTest() {
        matProgressBarQuery.shouldBe().displayed();
        matProgressBarQuery.show();
        matProgressBarQuery.shouldBe().visible();
        matProgressBarQuery.has().mode(QUERY);
        matProgressBarQuery.has().max(100);
        matProgressBarQuery.has().min(0);
        matProgressBarQuery.has().color(BLUE);
    }

    @Test
    public void verifyIndeterminateProgressBarTest() {
        showIndeterminateProgressBarButton.click();
        matProgressBarIndeterminate.shouldBe().displayed();
        matProgressBarIndeterminate.show();
        matProgressBarIndeterminate.shouldBe().visible();
        matProgressBarIndeterminate.has().mode(INDETERMINATE);
        matProgressBarIndeterminate.has().max(100);
        matProgressBarIndeterminate.has().min(0);
        matProgressBarIndeterminate.has().color(BLUE);
        matProgressBarIndeterminate.is().disappear(5);
    }

    @Test
    public void verifyBufferProgressBarTest() throws Exception {
        showBufferProgressBarButton.click();
        matProgressBarBuffer.shouldBe().displayed();
        matProgressBarBuffer.show();
        matProgressBarBuffer.shouldBe().visible();
        matProgressBarBuffer.has().mode(BUFFER);
        matProgressBarBuffer.has().value(0);
        matProgressBarBuffer.has().bufferValue(0.0);
        matProgressBarBuffer.has().max(100);
        matProgressBarBuffer.has().min(0);
        matProgressBarBuffer.has().color(BLUE);
        matProgressBarBuffer.is().disappear(5);
    }

    @Test
    public void verifyBasicConfigurableProgressBarTest() throws Exception {
        matProgressBarConfigurable.shouldBe().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.shouldBe().visible();
        matProgressBarConfigurable.has().mode(DETERMINATE);
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().max(100);
        matProgressBarConfigurable.has().min(0);
        matProgressBarConfigurable.has().color(BLUE);
    }

    @Test
    public void verifyConfigurableProgressBarColorTransformationsTest() {
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsAccentColorRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().color(YELLOW);
        matProgressBarDeterminate.has().color(BLUE);
        matProgressBarQuery.has().color(BLUE);
        progressBarsWarnColorRadio.click();
        matProgressBarConfigurable.has().color(RED);
        progressBarsIndeterminateModeRadio.click();
        matProgressBarConfigurable.has().color(RED);
        progressBarsPrimaryColorRadio.click();
        matProgressBarConfigurable.has().color(BLUE);
        matProgressBarConfigurable.has().mode(INDETERMINATE);
        progressBarsDeterminateModeRadio.click();
    }

    @Test
    public void verifyConfiguredProgressBarModeTransformationsTest() throws Exception {
        matProgressBarConfigurable.has().mode(DETERMINATE);
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsQueryModeRadio.click();
        matProgressBarConfigurable.has().mode(QUERY);
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().color(BLUE);
        matProgressBarDeterminate.has().mode(DETERMINATE);
        matProgressBarQuery.has().mode(QUERY);
        progressBarsIndeterminateModeRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().mode(INDETERMINATE);
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsBufferModeRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.has().mode(BUFFER);
        matProgressBarConfigurable.has().color(BLUE);
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().bufferValue(0.75);
    }

    @Test
    public void verifyDeterminateModeValuesTransformation() throws Exception {
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().max(100);
        matProgressBarConfigurable.has().min(0);
        progressBarsProgressSlider.moveRight();
        matProgressBarConfigurable.has().value(51);
        while (!matProgressBarConfigurable.getValue().equals("100")) {
            progressBarsProgressSlider.moveRight();
        }
        matProgressBarConfigurable.has().value(100);
        while (!matProgressBarConfigurable.getValue().equals("0")) {
            progressBarsProgressSlider.moveLeft();
        }
        matProgressBarConfigurable.has().value(0);
        while (!matProgressBarConfigurable.getValue().equals("50")) {
            progressBarsProgressSlider.moveRight();
        }
    }

    @Test
    public void verifyBufferModeValuesTransformation() throws Exception {
        progressBarsBufferModeRadio.click();
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().bufferValue(0.75);
        matProgressBarConfigurable.has().max(100);
        matProgressBarConfigurable.has().min(0);
        progressBarsProgressSlider.moveRight();
        matProgressBarConfigurable.has().value(51);
        while (!matProgressBarConfigurable.getValue().equals("25")) {
            progressBarsProgressSlider.moveLeft();
        }
        matProgressBarConfigurable.has().value(25);
        while (matProgressBarConfigurable.bufferValue() != 0.95) {
            progressBarsBufferSlider.moveRight();
        }
        matProgressBarConfigurable.has().bufferValue(0.95);
        while (matProgressBarConfigurable.bufferValue() != 0.75) {
            progressBarsBufferSlider.moveLeft();
        }
        matProgressBarConfigurable.has().bufferValue(0.75);
        while (!matProgressBarConfigurable.getValue().equals("50")) {
            progressBarsProgressSlider.moveRight();
        }
        matProgressBarConfigurable.has().value(50);
    }
}
