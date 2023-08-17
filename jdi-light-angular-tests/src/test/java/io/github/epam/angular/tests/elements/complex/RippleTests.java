package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.common.JDebug;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.ripplePage;
import static io.github.com.pages.RipplePage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RippleTests extends TestsInit {
    @BeforeMethod
    public void before() {
        ripplePage.open();
        waitCondition(() -> ripplePage.isOpened());
        ripplePage.checkOpened();
    }

    @Test(description = "Test checks that ripple container is displayed")
    public void displayedTest() {
        rippleContainer.is().displayed();
    }

    @Test(description = "Test checks that ripple container can be disabled")
    public void disabledTest() {
        rippleContainer.disable();
        rippleContainer.is().disabled();
        rippleContainer.ripple(0, 299);
        rippleContainer.is().notActive();
        rippleContainer.enable();
        rippleContainer.is().enabled();
    }
    @Test(description = "Test checks that when enabled ripple feature is active")
    public void rippleActiveTest() {
        rippleContainer.waitFor().displayed();
        rippleContainer.ripple();
        rippleContainer.is().active();
    }
    @Test(description = "Test checks ripple feature: unbounded")
    public void unboundedTest() {
        rippleContainer.unbound();
        rippleContainer.is().unbounded();
    }

    @JDebug
    @Test(description = "Test checks ripple feature: centered")
    public void centeredTest() {
        rippleContainer.center();
        rippleContainer.ripple();
        rippleContainer.is().centered();
    }

    @Test(description = "Test checks ripple feature: radius")
    public void radiusTest() {
        int expectedRadius = 260;
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.has().radius(expectedRadius);
    }

    @Test(description = "Test checks ripple feature: radius correct value")
    public void rippleRadiusTest() {
        int expectedRadius = 124;
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.is().radius(is(124));
    }

    @Test(description = "Test checks ripple feature: radius attributes(correct number)")
    public void rippleCorrectRadiusTest() {
        rippleContainer.setRadius(100);
        rippleContainer.has().correctRadius();
    }

    @Test(description = "Test checks ripple feature: radius attributes(incorrect number)")
    public void rippleNotCorrectRadiusTest() {
        refresh();
        rippleContainer.setRadius(-5);
        rippleContainer.has().incorrectRadius();
    }

    @Test(description = "Test checks ripple feature: color attributes(correct value)")
    public void rippleCorrectColorTest() {
        rippleContainer.setColor("rgba(255, 0, 255, 0.7)");
        rippleContainer.has().correctColor();
    }

    @Test(description = "Test checks ripple feature: color attributes(incorrect value)")
    public void rippleNotCorrectColorTest() {
        rippleContainer.setColor("custom color");
        rippleContainer.has().incorrectColor();
    }

    @Test(description = "Test checks ripple has correct radius and value")
    public void rippleRadiusAndColorTest() {
        String expectedColor = "SALMON";
        int expectedRadius = 219;
        rippleContainer.setColor(expectedColor);
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.is().radius(is(expectedRadius)).and().color(is(expectedColor.toLowerCase()));
    }

    @Test(description = "Test checks ripple center coordinates and radius value")
    public void mouseClickByCoordinatesAndRadiusTest() {
        int x = 0;
        int y = 299;
        int expectedRadius = 300;
        rippleContainer.setRadius(expectedRadius);

        rippleContainer.ripple(x, y);
        rippleContainer.is().rippleCenter(x,y).and().radius(is(expectedRadius));
    }

}
