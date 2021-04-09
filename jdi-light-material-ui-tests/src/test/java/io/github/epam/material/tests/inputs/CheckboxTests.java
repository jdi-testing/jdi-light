package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.MaterialNavigator.openSection;

public class CheckboxTests extends TestsInit {

    @BeforeTest()
    private void beforeTest() {
        openSection("Checkbox");
        checkboxPage.shouldBeOpened();
    }

    private void checkboxTestLogic(Checkbox checkbox, String className) {
        if (checkbox.isEnabled()) {
            checkbox.check();
            checkbox.is().checked();
            checkbox.uncheck();
            checkbox.is().unChecked();
        } else
            checkbox.is().disabled();
        checkbox.is().hasClass(className);
    }

    private void textTestLogic(Text text, String expectedText) {
        text.is().text(expectedText);
    }
    //
    private void groupTestLogic(Checkbox firstCheckbox, Checkbox secondCheckbox) {
        firstCheckbox.check();
        firstCheckbox.is().checked();
        secondCheckbox.is().checked();
        firstCheckbox.uncheck();
        firstCheckbox.is().unChecked();
        secondCheckbox.is().unChecked();
    }

    private void groupTestErrorLogic(Checkbox firstCheckbox, Checkbox secondCheckbox, Text errorMessage) {
        firstCheckbox.check();
        hasError(errorMessage);
        secondCheckbox.check();
        hasNoError(errorMessage);
    }

    private void hasError(Text errorMessage) {
        boolean isUnchecked = new Timer(1000L)
                .wait(() -> errorMessage.hasClass("Mui-error"));
        jdiAssert(isUnchecked, Matchers.is(true));
    }

    private void hasNoError(Text errorMessage) {
        boolean isUnchecked = new Timer(1000L)
                .wait(() -> errorMessage.hasClass("Mui-error"));
        jdiAssert(isUnchecked, Matchers.is(false));
    }

    @Test
    public void basicCheckboxTest() {
        for (int i = 1; i < 3; i++)
            checkboxTestLogic(
                    checkboxPage.basicCheckbox.get(i),
                    i != 2 && i != 7 ? "MuiCheckbox-colorSecondary" :
                            i == 2 ? "MuiCheckbox-colorPrimary" : "jss3");
    }

    @Test
    public void formControlLabelTest() {
        String[] expectedTexts = new String[] {"Secondary", "Primary", "Uncontrolled", "Disabled",
                "Disabled", "Indeterminate", "Custom color", "Custom icon", "Custom size"};
        for (int i = 1; i < 3; i++) {
            checkboxTestLogic(
                    checkboxPage.formControlLabelCheckbox.get(i),
                    i != 2 && i != 7 ? "MuiCheckbox-colorSecondary" :
                            i == 2 ? "MuiCheckbox-colorPrimary" : "jss3");
            textTestLogic(checkboxPage.formControlLabelText.get(i), expectedTexts[i - 1]);
        }
    }

    @Test
    public void formGroupTest() {
        String[] expectedTexts = new String[] {"Gilad Gray", "Jason Killian", "Antoine Llorca",
                "Gilad Gray", "Jason Killian", "Antoine Llorca"};
        for (int i = 1; i < 3; i++) {
            int secondCheckboxIndex = (i + 3) / 7 > 0 ? (i + 3) % 7 + 1 : (i + 3) % 7;
            groupTestLogic(
                    checkboxPage.formGroupCheckbox.get(i),
                    checkboxPage.formGroupCheckbox.get(secondCheckboxIndex));
            textTestLogic(checkboxPage.formGroupText.get(i), expectedTexts[i - 1]);
        }
        groupTestErrorLogic(
                checkboxPage.formGroupCheckbox.get(1),
                checkboxPage.formGroupCheckbox.get(2),
                checkboxPage.errorMessage.get(2));
    }

    @Test
    public void labelPlacementTest() {
        String[] expectedText = new String[] {"Top", "Start", "Bottom", "End"};
        for (int i = 1; i < 2; i++) {
            checkboxTestLogic(checkboxPage.labelPlacementCheckbox.get(i), "MuiCheckbox-colorPrimary");
            textTestLogic(checkboxPage.labelPlacementText.get(i), expectedText[i - 1]);
        }
    }
}
