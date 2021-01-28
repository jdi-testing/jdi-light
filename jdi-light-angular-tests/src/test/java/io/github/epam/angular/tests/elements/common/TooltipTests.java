package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.tools.func.JAction;
import io.github.com.pages.AngularPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.TooltipSection.*;
import static io.github.epam.angular.tests.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TooltipTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        if (tooltip.isDisplayed())
            AngularPage.refresh();
    }

    @Test(enabled = false)
    public void basicTooltipTest() {
        basicTooltipButton.hover();
        tooltip.has().assertTooltipText("Petit a petit, l’oiseau fait son nid");
    }

    @Test(enabled = false)
    public void customPositionTooltipTest() {
        Map<String, Tooltip.Position> position = new HashMap<>();
        position.put("after", Tooltip.Position.RIGHT);
        position.put("before", Tooltip.Position.LEFT);
        position.put("above", Tooltip.Position.ABOVE);
        position.put("below", Tooltip.Position.BELOW);
        position.put("left", Tooltip.Position.LEFT);
        position.put("right", Tooltip.Position.RIGHT);

        position.forEach(
                (k, v) -> {
                    positionTooltipSelector.click();
                    (new MaterialSelectorContainer()).select(k);
                    positionTooltipButton.hover();
                    tooltip.has().assertTooltipPosition(v, positionTooltipButton);
                }
        );
    }

    @Test(enabled = false)
    public void colorTooltipTest() {
        String red = "rgba(183, 28, 28, 1)";
        colorTooltipButton.hover();
        tooltip.has().assertTooltipColor(red);
    }

    @Test(enabled = false)
    public void delayTooltipTest() {
        int show = 3;
        int hide = 5;

        JAction showAction = () -> tooltip.waitFor().displayed();
        JAction hideAction = () -> tooltip.waitFor().hidden();

        showDelayInput.setValue(String.valueOf(show * 1000));
        hideDelayInput.setValue(String.valueOf(hide * 1000));

        delayTooltipButton.hover();
        duration(show, showAction);

        hideDelayInput.hover();
        duration(hide, hideAction);
    }

    @Test(enabled = false)
    public void disabledTooltipTest() {
        disabledCheckbox.click();
        disabledTooltipButton.hover();
        tooltip.is().hidden();

        disabledCheckbox.click();
        disabledTooltipButton.hover();
        tooltip.is().displayed();
    }

    @Test
    public void manualShowHideTooltipTest() {
        showTooltipButton.click();
        tooltip.is().displayed();

        hideTooltipButton.click();
        tooltip.is().hidden();

        toggleTooltipButton.click();
        tooltip.is().displayed();

        toggleTooltipButton.click();
        tooltip.is().hidden();
    }

    @Test
    public void changeMessageTooltipTest() {
        String message = "Test Tooltip Message";

        changeMessageTooltipTextField.setValue(message);

        changeMessageTooltipButton.hover();
        tooltip.has().assertTooltipText(message);
    }

    @Test(enabled = false)
    public void autoHideTooltipTest() {
        autoHideTooltipButton.hover();
        tooltip.is().displayed();

        autoHideTooltipContainer.core()
                .jsExecute("scrollTop=arguments[0].scrollHeight");
        autoHideTooltipButton.core()
                .jsExecute("scrollIntoView()");

        autoHideTooltipButton.is().displayed();
        tooltip.is().hidden();
    }
}