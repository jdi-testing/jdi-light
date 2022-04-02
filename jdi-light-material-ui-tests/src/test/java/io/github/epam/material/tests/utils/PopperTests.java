package io.github.epam.material.tests.utils;

import com.epam.jdi.light.material.elements.utils.enums.Position;
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

        popperButton.get(number).has().text(buttonText);
        popperButton.get(number).click();
        popperButton.get(number).popper().assertThat().displayed();
        popperButton.get(number).popper().assertThat().text("The content of the Popper.");
        popperButton.get(number).popper().assertThat().position(position);
        popperButton.get(number).click();
        popperButton.get(number).popper().assertThat().notVisible();
    }

    @Test
    public static void fakeReferenceObjectTest() {
        fakeReferenceObject.doubleClick();
        popper.assertThat().displayed();
    }
}
