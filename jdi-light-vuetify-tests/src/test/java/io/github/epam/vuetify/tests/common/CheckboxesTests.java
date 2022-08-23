package io.github.epam.vuetify.tests.common;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.checkboxesPage;
import static io.github.com.enums.Colors.*;
import static io.github.com.pages.CheckboxesPage.*;

public class CheckboxesTests extends TestsInit {

    @DataProvider(name = "customColorsCheckboxesTestDataProvider")
    public static Object[][] customColorsCheckboxesTestsData() {
        return new Object[][] {
                {1, RED.value()},
                {2, RED_DARKEN_3.value()},
                {3, INDIGO.value()},
                {4, INDIGO_DARKEN_3.value()},
                {5, ORANGE.value()},
                {6, ORANGE_DARKEN_3.value()},
                {7, BLUE_DARKEN_2.value()},
                {8, GREY_DARKEN_3.value()},
                {9, GREEN.value()},
                {10, BLUE.value()},
                {11, ORANGE_DARKEN_1.value()},
                {12, RED_ACCENT_2.value()},
        };
    }

    @BeforeClass
    public void before() {
        checkboxesPage.open();
        waitCondition(() -> checkboxesPage.isOpened());
        checkboxesPage.checkOpened();
    }

    @Test(dataProvider = "customColorsCheckboxesTestDataProvider")
    public void colorsCheckboxesTest(int index, String color) {
        colorsCheckboxes.get(index).show();
        colorsCheckboxes.get(index).has().color(color);
    }

    @Test
    public void modelAsArrayCheckboxesTest() {
        List<String> labels = Arrays.asList("John", "Jacob");
        for (int i = 1; i <= labels.size(); i++) {
            modelAsArrayCheckboxes.get(i).has().hasLabel();
            modelAsArrayCheckboxes.get(i).has().label(labels.get(i - 1));
        }
        modelAsArrayCheckboxes.get(1).is().checked();
        modelAsArrayCheckboxes.get(2).is().unchecked();
        modelArray.has().text("[ \"" + modelAsArrayCheckboxes.get(1).labelText() + "\" ]");
        modelAsArrayCheckboxes.get(2).check();
        modelArray.has().text("[ \"John\", \"Jacob\" ]");
        modelAsArrayCheckboxes.get(1).uncheck();
        modelArray.has().text("[ \"Jacob\" ]");
        modelAsArrayCheckboxes.get(2).uncheck();
        modelArray.has().text("[]");
    }

    @Test
    public void modelBooleanTest() {
        modelBooleanCheckboxes.get(2).check();
        modelBooleanCheckboxes.forEach(e -> {
            e.show();
            e.is().checked();
            e.assertThat().labelContains("true");
        });
        modelBooleanCheckboxes.forEach(e -> {
            e.show();
            e.uncheck();
            e.is().unchecked();
            e.assertThat().labelContains("false");
        });
    }

    @Test
    public void statesCheckboxesTest() {
        statesCheckboxes.get(1).show();
        statesCheckboxes.get(1).has().hasNoLabel();
        statesCheckboxes.get(1).is().checked();

        statesCheckboxes.get(2).show();
        statesCheckboxes.get(2).has().hasNoLabel();
        statesCheckboxes.get(2).is().unchecked();

        statesCheckboxes.get(3).show();
        statesCheckboxes.get(3).is().indeterminate();
        statesCheckboxes.get(3).has().hasNoLabel();

        statesCheckboxes.get(4).show();
        statesCheckboxes.get(4).has().hasNoLabel();
        statesCheckboxes.get(4).is().checked();
        statesCheckboxes.get(4).is().disabled();

        statesCheckboxes.get(5).show();
        statesCheckboxes.get(5).has().hasNoLabel();
        statesCheckboxes.get(5).is().unchecked();
        statesCheckboxes.get(5).is().disabled();
    }

    @Test
    public void inlineTextFieldTest() {
        inlineTextFieldCheckboxes.get(1).show();
        inlineTextFieldCheckboxes.get(1).is().checked();
        inlineTextField.get(1).is().enabled();
        inlineTextFieldCheckboxes.get(1).uncheck();
        inlineTextFieldCheckboxes.get(1).is().unchecked();
        inlineTextField.get(1).is().enabled();

        inlineTextFieldCheckboxes.get(2).show();
        inlineTextFieldCheckboxes.get(2).is().unchecked();
        inlineTextField.get(2).is().disabled();
        inlineTextFieldCheckboxes.get(2).check();
        inlineTextFieldCheckboxes.get(2).is().checked();
        inlineTextField.get(2).is().enabled();
    }

    @Test
    public void darkLightThemeCheckboxesTest() {
        colorsCheckboxes.get(1).show();
        colorsCheckboxes.get(1).is().theme("light");
    }
}
