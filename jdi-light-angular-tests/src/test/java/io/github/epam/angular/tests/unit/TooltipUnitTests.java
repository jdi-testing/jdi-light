package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import io.github.com.pages.AngularPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.TooltipSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class TooltipUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        if(tooltip.isDisplayed())
            AngularPage.refresh();
    }

    @Test
    public void textTooltipTest() {
        String message = "New Test Tooltip Message";
        changeMessageTooltipTextField.setValue(message);
        changeMessageTooltipButton.hover();
        assertEquals(tooltip.text(), message);
    }

    @Test
    public void colorTooltipTest() {
        String color = "rgba(183, 28, 28, 1)";
        colorTooltipButton.hover();
        assertEquals(tooltip.color(), color);
    }

    @Test
    public void positionTooltipTest() {
        Map<String, Tooltip.Position> position = new HashMap<>();
        position.put("after", Tooltip.Position.RIGHT);
        position.put("before", Tooltip.Position.LEFT);
        position.put("above", Tooltip.Position.ABOVE);
        position.put("below", Tooltip.Position.BELOW);
        position.put("left", Tooltip.Position.LEFT);
        position.put("right", Tooltip.Position.RIGHT);

        position.forEach(
                (k,v) -> {
                    positionTooltipSelector.click();
                    (new MaterialSelectorContainer()).select(k);
                    positionTooltipButton.hover();
                    assertEquals(tooltip.position(positionTooltipButton), v);
                }
        );
    }
}
