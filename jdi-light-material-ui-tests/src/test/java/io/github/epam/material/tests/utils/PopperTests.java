package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.popperFrame;
import static io.github.com.StaticSite.utilsPositionedPoppersPage;
import static io.github.com.StaticSite.utilsSimplePopperPage;
import static io.github.com.StaticSite.utilsTransitionsPopperPage;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class PopperTests extends TestsInit {

    private final static String POPPER_TEXT = "The content of the Popper.";

    @Test
    public void simplePopperTest() {
        utilsSimplePopperPage.open();
        popperFrame.togglePopperButton.click();
        popperFrame.simplePopper.is().popperDisplayed();
        popperFrame.simplePopper.is().popperPosition(Position.BOTTOM);
        popperFrame.simplePopper.is().popperTextCorrect(POPPER_TEXT);
    }

    @Test
    public void transitionPopperTest() {
        utilsTransitionsPopperPage.open();
        popperFrame.togglePopperButton.click();
        popperFrame.transitionsPopper.is().popperDisplayed();
        popperFrame.transitionsPopper.is().popperPosition(Position.BOTTOM);
        popperFrame.transitionsPopper.is().popperTextCorrect(POPPER_TEXT);
    }

    @Test
    public void positionedPoppersTest() {
        utilsPositionedPoppersPage.open();

        popperFrame.bottomButton.click();
        popperFrame.bottomPopper.is().popperDisplayed();
        popperFrame.bottomPopper.is().popperPosition(Position.BOTTOM);
        popperFrame.bottomPopper.is().popperTextCorrect(POPPER_TEXT);

        popperFrame.leftButton.click();
        popperFrame.leftPopper.is().popperDisplayed();
        popperFrame.leftPopper.is().popperPosition(Position.LEFT);
        popperFrame.leftPopper.is().popperTextCorrect(POPPER_TEXT);

        popperFrame.rightButton.click();
        popperFrame.rightPopper.is().popperDisplayed();
        popperFrame.rightPopper.is().popperPosition(Position.RIGHT);
        popperFrame.rightPopper.is().popperTextCorrect(POPPER_TEXT);

        popperFrame.topButton.click();
        popperFrame.topPopper.is().popperDisplayed();
        popperFrame.topPopper.is().popperPosition(Position.TOP);
        popperFrame.topPopper.is().popperTextCorrect(POPPER_TEXT);

    }
}
