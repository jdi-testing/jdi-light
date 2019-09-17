package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.greenButtonGroup;
import static io.github.com.pages.BootstrapPage.redButtonGroup;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Natalia Amelina on 13.09.2019
 * Email: natalia_amelina@epam.com; Skype: nat_amelina
 */
public class ButtonGroupTest extends TestsInit {

    private static final String text = "Red button";
    private String text1 = "Green button";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    private static Object[][] getButton() {
        return new Object[][] {{redButtonGroup, "Red button"}, {greenButtonGroup, "Green button"}};
    }

    @Test(dataProvider = "getButton")
    public void getTextTest(Button button, String expectedText) {
        assertEquals(button.getText(), expectedText);
    }

    @Test(dataProvider = "getButton")
    public void getValueTest(Button button, String expectedText) {
        assertEquals(button.getValue(), expectedText);
    }

//    @Test
//    public void getTextTest1() {
//        assertEquals(greenButtonGroup.getText(), text1);
//    }
//
//    @Test
//    public void getValueTest1() {
//        assertEquals(greenButtonGroup.getValue(), text1);
//    }
}
