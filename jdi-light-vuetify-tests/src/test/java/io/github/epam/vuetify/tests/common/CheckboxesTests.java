package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ColorsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.checkboxesPage;
import static io.github.com.enums.Colors.LIGHT_BLUE;
import static io.github.com.enums.Colors.RED_ACCENT_2;
import static io.github.com.pages.CheckboxesPage.colorsCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelArray;
import static io.github.com.pages.CheckboxesPage.modelAsArrayCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelBooleanCheckboxes;
import static io.github.com.pages.CheckboxesPage.statesCheckboxes;
import static io.github.com.pages.CheckboxesPage.variousAttributesCheckboxes;

public class CheckboxesTests extends TestsInit {

    @BeforeClass
    public void before() {
        checkboxesPage.open();
        waitCondition(() -> checkboxesPage.isOpened());
        checkboxesPage.checkOpened();
    }

    @Test(description = "Test checks if checkbox has label or not")
    public void labelCheckboxesTest() {
        statesCheckboxes.get(1).show();
        statesCheckboxes.get(1).has().noLabel();
        colorsCheckboxes.get(1).show();
        colorsCheckboxes.get(1).has().label()
                .and().label("red");
    }

    @Test(description = "Test checks checkbox color", dataProvider = "customColorsTestDataProvider",
            dataProviderClass = ColorsDataProvider.class)
    public void colorsCheckboxesTest(int index, String color) {
        colorsCheckboxes.get(index).show();
        colorsCheckboxes.get(index).has().color(color);
    }

    @Test(description = "Test checks checkbox background color")
    public void backgroundColorCheckboxTest() {
        variousAttributesCheckboxes.get(3).show();
        variousAttributesCheckboxes.get(3)
                .has().backgroundColor(LIGHT_BLUE.value())
                .and().labelColor(RED_ACCENT_2.value());
    }

    @Test(description = "Test checks checkbox labels, and array texts")
    public void modelAsArrayCheckboxesTest() {
        List<String> labels = Arrays.asList("John", "Jacob");
        for (int i = 1; i <= labels.size(); i++) {
            modelAsArrayCheckboxes.get(i).show();
            modelAsArrayCheckboxes.get(i).has().label()
                    .and().label(labels.get(i - 1));
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

    @Test(description = "Test checks that label contains text")
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

    @Test(description = "Test checks if checkbox is indeterminate or not")
    public void indeterminateCheckboxesTest() {
        statesCheckboxes.get(3).show();
        statesCheckboxes.get(3).is().indeterminate();
        statesCheckboxes.get(5).show();
        statesCheckboxes.get(5).is().notIndeterminate();
    }

    @Test(description = "Test checks checkbox theme")
    public void themeCheckboxesTest() {
        colorsCheckboxes.get(1).show();
        colorsCheckboxes.get(1).has().lightTheme();
        modelBooleanCheckboxes.get(1).show();
        modelBooleanCheckboxes.get(1).has().darkTheme();
    }

    @Test(description = "Test checks if checkbox is dense or not : dense(y/n)")
    public void denseCheckboxesTest() {
        variousAttributesCheckboxes.get(3).show();
        variousAttributesCheckboxes.get(3).is().dense();
        variousAttributesCheckboxes.get(1).show();
        variousAttributesCheckboxes.get(1).is().notDense();
    }

    @Test(description = "Test checks if checkbox has error or success : error(y/n), success(y/n), hint(y/n), " +
            "persistent-hint(text)")
    public void errorSuccessMessagesCheckboxesTest() {
        variousAttributesCheckboxes.get(1).show();
        variousAttributesCheckboxes.get(1).is().success()
                .and().notError()
                .and().noErrorMessages();
        variousAttributesCheckboxes.get(3).show();
        variousAttributesCheckboxes.get(3).is().error()
                .and().errorMessage("some hint")
                .and().notSuccess();
    }

    @Test(description = "Test checks if checkbox is readonly or not : readonly(y/n)")
    public void readonlyCheckboxesTest() {
        variousAttributesCheckboxes.get(1).show();
        variousAttributesCheckboxes.get(1).is().readonly();
        variousAttributesCheckboxes.get(3).show();
        variousAttributesCheckboxes.get(3).is().notReadonly();
    }

    @Test(description = "Test checks if checkbox is disabled or not")
    public void disabledCheckboxTest() {
        statesCheckboxes.get(5).show();
        statesCheckboxes.get(5).is().disabled();
        statesCheckboxes.get(3).show();
        statesCheckboxes.get(3).is().enabled();
    }
}
