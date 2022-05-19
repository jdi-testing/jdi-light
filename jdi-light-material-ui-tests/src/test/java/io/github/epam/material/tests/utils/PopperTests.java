package io.github.epam.material.tests.utils;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.com.custom.TooltipButton;
import io.github.epam.TestsInit;
import io.github.epam.test.data.PopperDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.popperPage;
import static io.github.com.pages.utils.PopperPage.fakeReferenceObject;
import static io.github.com.pages.utils.PopperPage.popper;
import static io.github.com.pages.utils.PopperPage.popperButton;

public class PopperTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        popperPage.open();
        popperPage.isOpened();
    }

    @Test(dataProviderClass = PopperDataProvider.class, dataProvider = "positionedPopperDataProvider")
    public void positionedPoppersTest(int number, String buttonText, Position position) {
        TooltipButton tooltipButton =  popperButton.get(number);
        tooltipButton.has().text(buttonText);
        tooltipButton.click();
        tooltipButton.popper().is().displayed().and().has().text("The content of the Popper.").and().has().position(position);
        tooltipButton.click();
        tooltipButton.popper().is().notVisible();
    }

    @Test
    public static void fakeReferenceObjectTest() {
        fakeReferenceObject.doubleClick();
        popper.is().displayed();
    }
}
