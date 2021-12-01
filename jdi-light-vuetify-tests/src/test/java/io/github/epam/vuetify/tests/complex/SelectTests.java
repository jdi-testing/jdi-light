package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.selectsPage;
import static io.github.com.pages.SelectsPage.standardDenseSelect;
import static io.github.com.pages.SelectsPage.leftIconSelect;
import static io.github.com.pages.SelectsPage.menuPropsSelect;
import static io.github.com.pages.SelectsPage.multipleSelect;
import static io.github.com.pages.SelectsPage.disabledSelect;
import static io.github.com.pages.SelectsPage.readonlySelect;
import static io.github.com.pages.SelectsPage.customSelect;
import static io.github.com.pages.SelectsPage.selectionSelect;


public class SelectTests extends TestsInit {

    @BeforeMethod
    public void before() {
        selectsPage.open();
    }

    @Test
    public void basicFunctionalityTest() {
        standardDenseSelect.expand();
        standardDenseSelect.is().expanded();
        standardDenseSelect.close();
        standardDenseSelect.is().collapsed();
        standardDenseSelect.select("Bar");
        standardDenseSelect.is().selected("Bar");
        standardDenseSelect.is().displayed();
    }

    @Test
    public void iconTest() {
        leftIconSelect.icon().is().displayed();
    }

    @Test
    public void labelTest() {
        menuPropsSelect.labelText();
        menuPropsSelect.label().has().text("Label");
    }

    @Test
    public void multiplySelect() {
        multipleSelect.select("Alaska");
        multipleSelect.select("American Samoa");
        multipleSelect.is().selected(Matchers.containsString("Alaska"));
        multipleSelect.is().selected("Alaska,American Samoa");
    }

    @Test
    public void messageTest() {
        multipleSelect.messageText();
        multipleSelect.message().has().text("Pick your favorite states");
    }

    @Test
    public void disableTest() {
        disabledSelect.is().disabled();
    }

    @Test
    public void readOnlyTest() {
        readonlySelect.is().classValue(Matchers.containsString("readonly"));
    }

    @Test
    public void customSelectTest() {
        customSelect.select("Georgia");
        customSelect.is().selected("Georgia");
    }

    @Test
    public void selectionSelectTest() {
        selectionSelect.select("buzz");
        selectionSelect.selection().is().text("(+3 others)");
    }
}
