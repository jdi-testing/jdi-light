package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.tools.func.JAction;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tooltipSection;
import static io.github.epam.angular.tests.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TooltipTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTooltipTest() {
        tooltipSection.basicTooltipButton.hover();
        tooltipSection.tooltip.has().text("Petit a petit, l’oiseau fait son nid");
    }

    @Ignore
    @Test
    public void customPositionTooltipTest() {
        String[] position = {
                "after",
                "before",
                "above",
                "below",
                "left",
                "right"
        };
        for (String p : position) {
            tooltipSection.positionTooltipSelector.select(p);
            tooltipSection.positionTooltipButton.hover();
        }
    }

    @Test
    public void colorTooltipTest() {
        String red = "rgba(183, 28, 28, 1)";

        tooltipSection.colorTooltipButton.hover();
        tooltipSection.tooltip.has().css("background-color", red);
    }

    @Test
    public void delayTooltipTest() {
        int show = 3;
        int hide = 5;

        JAction showAction = () -> tooltipSection.tooltip.waitFor().displayed();
        JAction hideAction = () -> tooltipSection.tooltip.waitFor().hidden();

        tooltipSection.showDelayInput.setValue(String.valueOf(show*1000));
        tooltipSection.hideDelayInput.setValue(String.valueOf(hide*1000));

        tooltipSection.delayTooltipButton.hover();
        duration(show, showAction);

        tooltipSection.hideDelayInput.hover();
        duration(hide, hideAction);
    }

    @Test
    public void disabledTooltipTest() {
        tooltipSection.disabledCheckbox.click();
        tooltipSection.disabledTooltipButton.hover();
        tooltipSection.tooltip.is().hidden();

        tooltipSection.disabledCheckbox.click();
        tooltipSection.disabledTooltipButton.hover();
        tooltipSection.tooltip.is().displayed();
    }

    @Test
    public void manualShowHideTooltipTest() {
        tooltipSection.showTooltipButton.click();
        tooltipSection.tooltip.is().displayed();

        tooltipSection.hideTooltipButton.click();
        tooltipSection.tooltip.is().hidden();

        tooltipSection.toggleTooltipButton.click();
        tooltipSection.tooltip.is().displayed();

        tooltipSection.toggleTooltipButton.click();
        tooltipSection.tooltip.is().hidden();
    }

    @Test
    public void changeMessageTooltipTest() {
        String message = "Test Tooltip Message";

        tooltipSection.changeMessageTooltipTextField.setValue(message);

        tooltipSection.changeMessageTooltipButton.hover();
        tooltipSection.tooltip.has().text(message);
    }

    @Test
    public void autoHideTooltipTest() {
        tooltipSection.autoHideTooltipButton.hover();
        tooltipSection.tooltip.is().displayed();

        tooltipSection.autoHideTooltipContainer.core()
                .jsExecute("scrollTop=500");

        tooltipSection.autoHideTooltipContainer.core()
                .jsExecute("scrollTop=0");

        tooltipSection.autoHideTooltipButton.is().displayed();
        tooltipSection.tooltip.is().hidden();
    }
}
