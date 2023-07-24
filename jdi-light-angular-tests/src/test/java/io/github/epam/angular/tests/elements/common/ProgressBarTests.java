package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.ACCENT;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.BLUE;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.PRIMARY;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.RED;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.WARN;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarColors.YELLOW;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.BUFFER;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.DETERMINATE;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.INDETERMINATE;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.QUERY;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressBarPage;
import static io.github.com.pages.ProgressBarPage.colorRadioButtons;
import static io.github.com.pages.ProgressBarPage.matProgressBarBuffer;
import static io.github.com.pages.ProgressBarPage.matProgressBarConfigurable;
import static io.github.com.pages.ProgressBarPage.matProgressBarDeterminate;
import static io.github.com.pages.ProgressBarPage.matProgressBarIndeterminate;
import static io.github.com.pages.ProgressBarPage.matProgressBarQuery;
import static io.github.com.pages.ProgressBarPage.modeRadioButtons;
import static io.github.com.pages.ProgressBarPage.progressBarsQueryModeRadio;
import static io.github.com.pages.ProgressBarPage.showBufferProgressBarButton;
import static io.github.com.pages.ProgressBarPage.showIndeterminateProgressBarButton;

public class ProgressBarTests extends TestsInit {
    @BeforeMethod
    public void before() {
        progressBarPage.open();
        waitCondition(() -> progressBarPage.isOpened());
        progressBarPage.checkOpened();
    }

    @Test(description = "Test checks color and min/max value in determinate mode")
    public void verifyDeterminateProgressBarTest() {
        matProgressBarDeterminate.shouldBe().displayed();
        matProgressBarDeterminate.show();
        matProgressBarDeterminate.shouldBe().visible();
        matProgressBarDeterminate.has().mode(DETERMINATE);
        matProgressBarDeterminate.has().value(40);
        matProgressBarDeterminate.has().max(100);
        matProgressBarDeterminate.has().min(0);
        matProgressBarDeterminate.has().color(BLUE);
    }

    @Test(description = "Test checks color and min/max value in query mode")
    public void verifyQueryProgressBarTest() {
        matProgressBarQuery.shouldBe().displayed();
        matProgressBarQuery.show();
        matProgressBarQuery.shouldBe().visible();
        matProgressBarQuery.has().mode(QUERY);
        matProgressBarQuery.has().max(100);
        matProgressBarQuery.has().min(0);
        matProgressBarQuery.has().color(BLUE);
    }

    @Test(description = "Test checks color and min/max value in indeterminate mode")
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

    @Test(description = "Test checks color and min/max value in buffer mode")
    public void verifyBufferProgressBarTest()  {
        showBufferProgressBarButton.click();
        matProgressBarBuffer.shouldBe().displayed();
        matProgressBarBuffer.show();
        matProgressBarBuffer.shouldBe().visible();
        matProgressBarBuffer.has().mode(BUFFER);
        matProgressBarBuffer.has().value(0);
        matProgressBarBuffer.has().bufferValue(0);
        matProgressBarBuffer.has().max(100);
        matProgressBarBuffer.has().min(0);
        matProgressBarBuffer.has().color(BLUE);
        matProgressBarBuffer.is().disappear(5);
    }

    @Test(description = "Test checks configurable progress bar")
    public void verifyBasicConfigurableProgressBarTest() {
        matProgressBarConfigurable.shouldBe().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.shouldBe().visible();
        matProgressBarConfigurable.has().mode(DETERMINATE);
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().max(100);
        matProgressBarConfigurable.has().min(0);
        matProgressBarConfigurable.has().color(BLUE);
    }

    @Test(description = "Test checks progress bar's color transformation")
    public void verifyConfigurableProgressBarColorTransformationsTest() {
        matProgressBarConfigurable.has().color(BLUE);
        colorRadioButtons.click(ACCENT.getColor());
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().color(YELLOW);
        matProgressBarDeterminate.has().color(BLUE);
        matProgressBarQuery.has().color(BLUE);
        colorRadioButtons.click(WARN.getColor());
        matProgressBarConfigurable.has().color(RED);
        modeRadioButtons.click(INDETERMINATE.getMode());
        matProgressBarConfigurable.has().color(RED);
        colorRadioButtons.click(PRIMARY.getColor());
        matProgressBarConfigurable.has().color(BLUE);
        matProgressBarConfigurable.has().mode(INDETERMINATE);
        modeRadioButtons.click(DETERMINATE.getMode());
    }

    @Test(description = "Test checks progress bar's mode transformation")
    public void verifyConfiguredProgressBarModeTransformationsTest() {
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
        modeRadioButtons.click(INDETERMINATE.getMode());
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().mode(INDETERMINATE);
        matProgressBarConfigurable.has().color(BLUE);
        modeRadioButtons.click(BUFFER.getMode());
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.has().mode(BUFFER);
        matProgressBarConfigurable.has().color(BLUE);
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().bufferValue(75);
    }

}
