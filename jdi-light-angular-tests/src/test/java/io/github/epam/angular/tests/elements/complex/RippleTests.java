package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.rippleContainer;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class RippleTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        rippleContainer.show();
    }

    @Test
    public void displayedTest() {
        rippleContainer.is().displayed();
    }

    @Test
    public void disabledTest() {
        rippleContainer.disable();
        rippleContainer.is().disabled();
        rippleContainer.enable();
        rippleContainer.is().enabled();
    }

    @Test
    public void unboundedTest() {
        rippleContainer.unbound();
        rippleContainer.is().unbounded();
    }

    @Test
    public void centeredTest() {
        rippleContainer.center();
        rippleContainer.is().centered();
    }

    @Test
    public void rippleActionTest() {
        rippleContainer.ripple();
        rippleContainer.is().active();
    }

    @Test
    public void radiusTest() {
        int expectedRadius = 260;
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.has().radius(expectedRadius);
    }

    @Test
    public void rippleRadiusTest() {
        int expectedRadius = 124;
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.is().radius(is(124));
    }

    @Test
    public void rippleCorrectRadiusTest() {
        rippleContainer.setRadius(100);
        rippleContainer.has().correctRadius();
    }

    @Test
    public void rippleNotCorrectRadiusTest() {
        rippleContainer.setRadius(-5);
        rippleContainer.has().incorrectRadius();
    }

    @Test
    public void colorTest() {
        String expectedColor = "BLUE";
        rippleContainer.setColor(expectedColor);
        rippleContainer.is().color(expectedColor.toLowerCase());
    }

    @Test
    public void rippleCorrectColorTest() {
        rippleContainer.setColor("rgba(255, 0, 255, 0.7)");
        rippleContainer.has().correctColor();
    }

    @Test
    public void rippleNotCorrectColorTest() {
        rippleContainer.setColor("custom color");
        rippleContainer.has().incorrectColor();
    }

    @Test
    public void rippleRadiusAndColorTest() {
        String expectedColor = "SALMON";
        int expectedRadius = 219;
        rippleContainer.setColor(expectedColor);
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.is().radius(expectedRadius).and().color(is(expectedColor.toLowerCase()));
    }

    @Test
    public void rippleRadiusAndColorAndCenteredTest() {
        rippleContainer.center();
        String expectedColor = "rgba(28, 140, 16, 0.1)";
        int expectedRadius = 150;
        rippleContainer.setColor(expectedColor);
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.is().radius(expectedRadius).and().color(is(expectedColor.toLowerCase())).and().centered();
    }

    @Test
    public void mouseClickByCoordinatesAndRadiusTest() {
        int x = 0;
        int y = 299;
        int expectedRadius = 300;
        rippleContainer.setRadius(expectedRadius);
        rippleContainer.ripple(x, y);
        rippleContainer.is().rippleCenter(x, y).and().radius(expectedRadius);
    }

    @Test
    public void randomMouseClickCenteredAndUnboundedTest() {
        rippleContainer.unbound();
        rippleContainer.center();
        int x = RandomUtils.nextInt(0, 299);
        int y = RandomUtils.nextInt(0, 299);
        rippleContainer.ripple(x, y);
        rippleContainer.is().unbounded().and().centered();
    }
}
