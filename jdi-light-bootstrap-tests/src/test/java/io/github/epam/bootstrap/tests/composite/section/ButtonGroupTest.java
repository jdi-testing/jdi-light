package io.github.epam.bootstrap.tests.composite.section;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroup;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by Natalia Amelina on 13.09.2019
 * Email: natalia_amelina@epam.com; Skype: nat_amelina
 */
public class ButtonGroupTest extends TestsInit {

    private static final String DROPDOWN = "Dropdown";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] getTextData() {
        return new Object[][] {
                {buttonGroup.redButton, "Red button"},
                {buttonGroup.greenButton, "Green button"},
//                {buttonGroup.disabledButton, "Disabled"}
        };
    }

//    @Test(dataProvider = "getTextData")
//    public void getTextTest(Button button, String expectedText) {
//        assertEquals(button.getText(), expectedText);
//    }
//
//    @Test(dataProvider = "getTextData")
//    public void getValueTest(Button button, String expectedText) {
//        assertEquals(button.getValue(), expectedText);
//    }
//
//    @Test(dataProvider = "getTextData")
//    public void clickTest(Button button, String expectedText) {
//        button.click();
//        validateAlert(is(expectedText));
//    }
//
//    @Test(dataProvider = "getTextData")
//    public void isValidationTest(Button button, String expectedText) {
//        button.is().displayed();
//        button.is().enabled();
//        button.is().text(is(expectedText));
//        button.is().text(containsString(expectedText));
//    }
//
//    @Test(dataProvider = "getTextData")
//    public void assertValidationTest(Button button, String expectedText) {
//        button.assertThat().text(is(expectedText));
//    }
//
//    @Test(dataProvider = "getTextData")
//    public void baseValidationTest(Button button, String expectedText) {
//        baseValidation(button);
//    }
//
//    //    @Test
////    public void doubleClickTest() {
////        doubleButton.doubleClick();
////        validateAlert(is("Double Click"));
////    }
////
////    @Test
////    public void rightClickTest() {
////        redButton.rightClick();
////        validateAlert(is("Right Click"));
////    }
////
//
    @Test
    public void getTextTest() {
        assertEquals(buttonGroup.dropdownButton.getText(), "Dropdown");
    }

    @Test
    public void getValueTest() {
        assertEquals(buttonGroup.dropdownButton.getValue(), DROPDOWN);
    }

    @Test
    public void selectTest() {
        buttonGroup.dropdownButton.select("JDI");
    }

    @Test
    public void selectByIndexTest() {
        String actualUrl = WebPage.getUrl();
        buttonGroup.dropdownButton.select(2);
        System.out.println("!!! = " + WebPage.getTitle() + "\n");
        assertNotEquals(actualUrl, WebPage.getUrl());
    }

    @Test
    public void isValidationTest() {
        buttonGroup.dropdownButton.is().displayed();
        buttonGroup.dropdownButton.is().enabled();
        buttonGroup.dropdownButton.is().text(is(DROPDOWN));
        buttonGroup.dropdownButton.is().text(containsString(DROPDOWN));
    }
}
