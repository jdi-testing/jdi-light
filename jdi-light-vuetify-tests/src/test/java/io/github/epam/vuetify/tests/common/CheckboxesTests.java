package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ColorsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.checkboxesPage;
import static io.github.com.pages.CheckboxesPage.colorsCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelAsArrayCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelArray;
import static io.github.com.pages.CheckboxesPage.modelBooleanCheckboxes;
import static io.github.com.pages.CheckboxesPage.statesCheckboxes;
import static io.github.com.pages.CheckboxesPage.inlineTextFieldCheckboxes;
import static io.github.com.pages.CheckboxesPage.inlineTextField;

public class CheckboxesTests extends TestsInit {



    @BeforeClass
    public void before() {
        checkboxesPage.open();
        waitCondition(() -> checkboxesPage.isOpened());
        checkboxesPage.checkOpened();
    }

    @Test(dataProvider = "customColorsTestDataProvider", dataProviderClass = ColorsDataProvider.class)
    public void colorsCheckboxesTest(int index, String color) {
        colorsCheckboxes.get(index).show();
        colorsCheckboxes.get(index).has().color(color);
    }

    @Test
    public void modelAsArrayCheckboxesTest() {
        List<String> labels = Arrays.asList("John", "Jacob");
        for (int i = 1; i <= labels.size(); i++) {
            modelAsArrayCheckboxes.get(i).show();
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
