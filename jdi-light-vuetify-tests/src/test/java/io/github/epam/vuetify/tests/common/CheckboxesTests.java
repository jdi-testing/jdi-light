package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.checkboxesPage;
import static io.github.com.StaticSite.vuetifyPage;
import static io.github.com.pages.CheckboxesPage.colorsCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelArray;
import static io.github.com.pages.CheckboxesPage.modelAsArrayCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelBooleanCheckboxes;
import static io.github.com.pages.VuetifyPage.checkboxes;

public class CheckboxesTests extends TestsInit {

    @BeforeSuite
    public void before() {
        vuetifyPage.open();
        vuetifyPage.expandFormInputAndControls();
        checkboxes.click();
    }

    @Test
    public void colorsCheckboxesTest() {
        colorsCheckboxes.stream().forEach(e -> {
            e.is().checked();
            e.check();
            e.is().checked();
            e.uncheck();
            e.is().unchecked();
            e.uncheck();
            e.is().unchecked();
            e.check();
            e.is().checked();
        });
    }

    @Test
    public void modelAsArrayCheckboxesTest() {
        List<String> labels = Arrays.asList("John", "Jacob");
        for (int i = 1; i <= labels.size(); i++) {
            modelAsArrayCheckboxes.get(i).has().label(labels.get(i));
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
        modelBooleanCheckboxes.stream().forEach(e -> {
            e.is().checked();
            e.assertThat().labelContains("true");
        });
        modelBooleanCheckboxes.stream().forEach(e -> {
            e.uncheck();
            e.is().unchecked();
            e.assertThat().labelContains("false");
        });
    }
}
