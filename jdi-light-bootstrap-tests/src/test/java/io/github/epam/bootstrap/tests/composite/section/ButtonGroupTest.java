package io.github.epam.bootstrap.tests.composite.section;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.epam.TestsInit;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.common.WindowsManager.*;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.sections.buttongroup.DefaultButtonGroup.*;
import static io.github.com.sections.buttongroup.DefaultButtonGroup.Option.JDI;
import static io.github.com.sections.buttongroup.DefaultButtonGroup.Option.JDI_DOCUMENTATION;
import static io.github.com.sections.buttongroup.SpecificButtonGroup.cyanButton;
import static io.github.com.sections.buttongroup.SpecificButtonGroup.disabledButton;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Natalia Amelina on 13.09.2019
 * Email: natalia_amelina@epam.com; Skype: nat_amelina
 */
public class ButtonGroupTest extends TestsInit {

    private static final String RED_TEXT = "Red button";
    private static final String GREEN_TEXT = "Green button";
    private static final String CYAN_TEXT = "On Action";
    private static final String DISABLED_TEXT = "Disabled";

    private static final String DOUBLE_ALERT_TEXT = "Double click";
    private static final String CONTEXT_ALERT_TEXT = "Context Click";

    private static final int FIRST_OPTION_INDEX = 1;
    private static final int ADDITIONAL_TAB_INDEX = 2;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    private static Object[][] getTextData() {
        return new Object[][] {
                {redButton, RED_TEXT},
                {greenButton, GREEN_TEXT},
                {cyanButton, CYAN_TEXT},
                {disabledButton, DISABLED_TEXT}
        };
    }

    @Test(dataProvider = "getTextData")
    public void getTextTest(Button button, String expectedText) {
        assertEquals(button.getText(), expectedText);
    }

    @Test(dataProvider = "getTextData")
    public void getValueTest(Button button, String expectedText) {
        assertEquals(button.getValue(), expectedText);
    }

    @Test(dataProvider = "getTextData")
    public void isValidationTest(Button button, String expectedText) {
        button.is().displayed();
        button.is().text(is(expectedText));
        button.is().text(containsString(expectedText));
    }

    @Test(dataProvider = "getTextData")
    public void assertValidationTest(Button button, String expectedText) {
        button.assertThat().text(is(expectedText));
    }

    @Test
    public void availabilityTest() {
        redButton.is().enabled();
        greenButton.is().enabled();
        cyanButton.is().enabled();
        disabledButton.is().disabled();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(redButton);
        baseValidation(greenButton);
        baseValidation(cyanButton);
    }

    @Test
    public void clickTest() {
        redButton.click();
        validateAlert(is(RED_TEXT));
    }

    @Test
    public void doubleClickTest() {
        cyanButton.doubleClick();
        validateAlert(is(DOUBLE_ALERT_TEXT));
    }

    @Test
    public void rightClickTest() {
        cyanButton.rightClick();
        validateAlert(is(CONTEXT_ALERT_TEXT));
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void disableButtonTest() {
        disabledButton.click();
    }

    @Test
    public void expandTest() {
        dropdownButton.expand();
        assertTrue(dropdownButton.isExpanded());
    }

    @DataProvider
    private static Object[][] getOption() {
        return new Object[][] {
                {JDI}, {JDI_DOCUMENTATION}
        };
    }

    @Test(dataProvider = "getOption")
    public void selectTest(Option option) {
        dropdownButton.select(option.getTitle());
        int actualTabAmount = windowsCount();
        switchToWindow(ADDITIONAL_TAB_INDEX);
        closeWindow();
        assertEquals(actualTabAmount, ADDITIONAL_TAB_INDEX);
    }

    @Test
    public void selectByIndexTest() {
        dropdownButton.select(FIRST_OPTION_INDEX);
        int actualTabAmount = windowsCount();
        switchToWindow(ADDITIONAL_TAB_INDEX);
        closeWindow();
        assertEquals(actualTabAmount, ADDITIONAL_TAB_INDEX);
    }

    @Test
    public void isValidationDropDownTest() {
        dropdownButton.is().displayed();
        dropdownButton.is().enabled();
    }

    @Test
    public void valuesTest() {
        assertEquals(dropdownButton.cleanValues(), Option.getValues());
    }
}