package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.pages.inputs.CheckboxPage.basicCheckbox;
import static io.github.com.pages.inputs.CheckboxPage.errorMessage;
import static io.github.com.pages.inputs.CheckboxPage.formControlLabelCheckbox;
import static io.github.com.pages.inputs.CheckboxPage.formControlLabelText;
import static io.github.com.pages.inputs.CheckboxPage.formGroupCheckbox;
import static io.github.com.pages.inputs.CheckboxPage.formGroupText;
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementCheckbox;
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementText;

public class CheckboxTests extends TestsInit {

    @BeforeMethod()
    public void beforeTest() {
        checkboxPage.open();
        checkboxPage.shouldBeOpened();
    }

    private void checkboxTestLogic(Checkbox checkbox, String className) {
        if (checkbox.isEnabled()) {
            checkbox.check();
            checkbox.is().selected();
            checkbox.uncheck();
            checkbox.is().deselected();
        } else
            checkbox.is().disabled();
        checkbox.hasClass(className);
    }

    private void textTestLogic(Text text, String expectedText) {
        text.is().text(expectedText);
    }

    private void groupTestLogic(Checkbox firstCheckbox, Checkbox secondCheckbox) {
        firstCheckbox.check();
        firstCheckbox.is().selected();
        secondCheckbox.is().selected();
        firstCheckbox.uncheck();
        firstCheckbox.is().deselected();
        secondCheckbox.is().deselected();
    }

    private void groupTestErrorLogic(Checkbox firstCheckbox, Checkbox secondCheckbox, Text errorMessage) {
        firstCheckbox.check();
        hasError(errorMessage);
        secondCheckbox.check();
        hasNoError(errorMessage);
    }

    private void hasError(Text errorMessage) {
        boolean isUnchecked = errorMessage.hasClass("Mui-error");
        Timer.waitCondition(() -> isUnchecked);
        jdiAssert(isUnchecked, Matchers.is(true));
        jdiAssert(errorMessage.text().contains("Pick two"), Matchers.is(true));
    }

    private void hasNoError(Text errorMessage) {
        boolean isUnchecked = errorMessage.hasClass("Mui-error");
        Timer.waitCondition(() -> isUnchecked);
        jdiAssert(isUnchecked, Matchers.is(false));
    }

    @Test
    public void basicCheckboxTest() {
        for (int i = 1; i < 3; i++)
            checkboxTestLogic(
                    basicCheckbox.get(i),
                    i != 2 ? "MuiCheckbox-colorSecondary" :
                            "MuiCheckbox-colorPrimary");
    }

    @Test
    public void formControlLabelTest() {
        String[] expectedTexts = new String[]{"Secondary", "Primary", "Uncontrolled", "Disabled",
                "Disabled", "Indeterminate", "Custom color", "Custom icon", "Custom size"};
        for (int i = 1; i < 3; i++) {
            checkboxTestLogic(
                    formControlLabelCheckbox.get(i),
                    i != 2 ? "MuiCheckbox-colorSecondary" :
                            "MuiCheckbox-colorPrimary");
            textTestLogic(formControlLabelText.get(i), expectedTexts[i - 1]);
        }
    }

    @Test
    public void formGroupTest() {
        String[] expectedTexts = new String[]{"Gilad Gray", "Jason Killian", "Antoine Llorca",
                "Gilad Gray", "Jason Killian", "Antoine Llorca"};
        for (int i = 1; i < 3; i++) {
            int secondCheckboxIndex = (i + 3) % 7;
            groupTestLogic(
                    formGroupCheckbox.get(i),
                    formGroupCheckbox.get(secondCheckboxIndex));
            textTestLogic(formGroupText.get(i), expectedTexts[i - 1]);
        }
        groupTestErrorLogic(
                formGroupCheckbox.get(1),
                formGroupCheckbox.get(2),
                errorMessage.get(2));
    }

    @Test
    public void labelPlacementTest() {
        String[] expectedText = new String[]{"Top", "Start", "Bottom", "End"};
        for (int i = 1; i < 2; i++) {
            checkboxTestLogic(labelPlacementCheckbox.get(i), "MuiCheckbox-colorPrimary");
            textTestLogic(labelPlacementText.get(i), expectedText[i - 1]);
        }
    }
}
