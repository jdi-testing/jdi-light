package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.popperFrame;
import static io.github.com.StaticSite.utilsPositionedPoppersPage;
import static io.github.com.StaticSite.utilsSimplePopperPage;
import static io.github.com.StaticSite.utilsTransitionsPopperPage;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class PopperTests extends TestsInit {

    @Test
    public void simplePopperTest() {
        utilsSimplePopperPage.open();
        popperFrame.togglePopperButton.click();
        popperFrame.simplePopper.is().popperDisplayed();
        popperFrame.simplePopper.is().popperPosition(Position.BOTTOM);
        popperFrame.simplePopper.is().popperTextCorrect("The content of the Popper.");
    }

    @Test
    public void transactionPopperTest() {
        utilsTransitionsPopperPage.open();
        popperFrame.togglePopperButton.click();
        popperFrame.transitionsPopper.is().popperDisplayed();
        popperFrame.simplePopper.is().popperPosition(Position.BOTTOM);
        popperFrame.transitionsPopper.is().popperTextCorrect("The content of the Popper.");
    }

    @Test
    public void positionedPoppersTest() {
        utilsPositionedPoppersPage.open();

        popperFrame.bottomButton.click();
        popperFrame.bottomPopper.is().popperDisplayed();
        popperFrame.bottomPopper.is().popperPosition(Position.BOTTOM);
        popperFrame.bottomPopper.is().popperTextCorrect("The content of the Popper.");

        popperFrame.leftButton.click();
        popperFrame.leftPopper.is().popperDisplayed();
        popperFrame.leftPopper.is().popperPosition(Position.LEFT);
        popperFrame.leftPopper.is().popperTextCorrect("The content of the Popper.");

        popperFrame.rightButton.click();
        popperFrame.rightPopper.is().popperDisplayed();
        popperFrame.rightPopper.is().popperPosition(Position.RIGHT);
        popperFrame.rightPopper.is().popperTextCorrect("The content of the Popper.");

        popperFrame.topButton.click();
        popperFrame.topPopper.is().popperDisplayed();
        popperFrame.topPopper.is().popperPosition(Position.TOP);
        popperFrame.topPopper.is().popperTextCorrect("The content of the Popper.");

    }
}
