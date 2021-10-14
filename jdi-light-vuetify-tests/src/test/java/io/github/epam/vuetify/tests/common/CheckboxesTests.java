package io.github.epam.vuetify.tests.common;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static io.github.com.StaticSite.checkboxesPage;
import static io.github.com.pages.CheckboxesPage.colorsCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelArray;
import static io.github.com.pages.CheckboxesPage.modelAsArrayCheckboxes;
import static io.github.com.pages.CheckboxesPage.modelBooleanCheckboxes;
import static io.github.com.pages.CheckboxesPage.statesCheckboxes;

public class CheckboxesTests extends TestsInit {

    @BeforeClass
    public void before() {
        checkboxesPage.open();
    }

    @Test
    public void colorsCheckboxesTest() {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                colorsCheckboxes.size() != 0);
        colorsCheckboxes.forEach(e -> {
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
            e.is().checked();
            e.assertThat().labelContains("true");
        });
        modelBooleanCheckboxes.forEach(e -> {
            e.uncheck();
            e.is().unchecked();
            e.assertThat().labelContains("false");
        });
    }

    @Test
    public void statesCheckboxesTest() {
        statesCheckboxes.get(1).is().checked();
        statesCheckboxes.get(2).is().unchecked();
        statesCheckboxes.get(3).is().indeterminate();
        statesCheckboxes.get(4).is().checked();
        statesCheckboxes.get(4).is().disabled();
        statesCheckboxes.get(5).is().unchecked();
        statesCheckboxes.get(5).is().disabled();
    }
}
