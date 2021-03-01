package io.github.epam.material.tests.tooltip;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.customozedToolTipPage;
import static io.github.com.StaticSite.interactiveToolTipPage;
import static io.github.com.StaticSite.toolTipDefaultPage;
import static io.github.com.StaticSite.toolTipFrame;
import static io.github.com.StaticSite.triggersToolTipPage;

public class ToolTipTests extends TestsInit {

    @Test
    public void defaultToolTipTest() {
        toolTipDefaultPage.shouldBeOpened();

        toolTipFrame.toolTipButton.hoverOn();
        toolTipFrame.toolTipButton.is().isDefaultDisplayed();
        toolTipFrame.toolTipButton.click();
        toolTipFrame.toolTipButton.is().isDefaultDisplayed();

        toolTipFrame.labelButton.hoverOn();
        toolTipFrame.labelButton.is().isDeleteDisplayed();
        toolTipFrame.labelButton.click();
        toolTipFrame.labelButton.is().isDeleteDisplayed();
    }

    @Test
    public void triggerToolTipTest() {
        triggersToolTipPage.shouldBeOpened();

        toolTipFrame.labelButton.click();
        toolTipFrame.labelButton.is().isTriggerDisplayed();
        toolTipFrame.toolTipButton.click();
        toolTipFrame.toolTipButton.is().isTriggerNotDisplayed();
    }

    @Test
    public void interactiveToolTipTest() {
        interactiveToolTipPage.shouldBeOpened();

        toolTipFrame.labelButton.hoverOn();
        toolTipFrame.labelButton.is().isInteractiveDisplayed();
    }

    @Test
    public void customisedToolTipTest() {
        customozedToolTipPage.shouldBeOpened();

        toolTipFrame.toolTipButton.hoverOn();
        toolTipFrame.toolTipButton.is().isPlusDisplayed();
        toolTipFrame.toolTipButton.click();
        toolTipFrame.toolTipButton.is().isPlusDisplayed();

        toolTipFrame.fadeButton.hoverOn();
        toolTipFrame.fadeButton.is().isFadeDisplayed();
        toolTipFrame.fadeButton.click();
        toolTipFrame.fadeButton.is().isFadeDisplayed();

        toolTipFrame.labelButton.hoverOn();
        toolTipFrame.labelButton.is().isCustomosedDisplayed();
        toolTipFrame.labelButton.click();
        toolTipFrame.labelButton.is().isCustomosedDisplayed();
    }
}
