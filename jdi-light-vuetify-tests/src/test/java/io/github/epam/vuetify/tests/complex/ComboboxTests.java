package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.comboboxPage;
import static io.github.com.pages.ComboboxPage.advancedCustomOptionsCombobox;
import static io.github.com.pages.ComboboxPage.denseCombobox;
import static io.github.com.pages.ComboboxPage.loadingCombobox;
import static io.github.com.pages.ComboboxPage.multipleChipsCombobox;
import static io.github.com.pages.ComboboxPage.multipleReadOnlyCombobox;
import static io.github.com.pages.ComboboxPage.multipleScopedCombobox;
import static io.github.com.pages.ComboboxPage.multipleStringCombobox;
import static io.github.com.pages.ComboboxPage.noDataWithChipsCombobox;

public class ComboboxTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        comboboxPage.open();
        waitCondition(() -> comboboxPage.isOpened());
        comboboxPage.checkOpened();
    }

    @Test
    public void baseFunctionalityTest() {
        List<String> testValueList = Arrays.asList("Programming", "Design", "Vue", "Vuetify");

        denseCombobox.expand();
        denseCombobox.is().expanded();
        denseCombobox.close();
        denseCombobox.is().closed();
        denseCombobox.is().label("Combobox");
        denseCombobox.select("Design");
        denseCombobox.select("Vue");
        denseCombobox.is().selected(testValueList);
        denseCombobox.unselect(testValueList);
        denseCombobox.is().notSelected(testValueList);
    }

    @Test
    public void diffMultipleComboboxTest() {
        String testWord = "Test";

        multipleStringCombobox.sendKeys(testWord);
        multipleStringCombobox.is().selected(testWord);
        multipleChipsCombobox.is().selected(testWord);
        multipleScopedCombobox.is().selected(testWord);
        multipleReadOnlyCombobox.is().selected(testWord);
        multipleReadOnlyCombobox.is().disabled();
    }

    @Test
    public void noDataWithChipsComboboxTest() {
        List<String> list = Arrays.asList("Gaming", "Programming", "Vue");
        String message = "Maximum of 5 tags";
        String firstTestWord = "Test";
        String secondTestWord = "Not to add";

        noDataWithChipsCombobox.is().message(message);
        noDataWithChipsCombobox.select(list);
        noDataWithChipsCombobox.sendKeys(firstTestWord);
        noDataWithChipsCombobox.sendKeys(secondTestWord);
        noDataWithChipsCombobox.is().notSelected(secondTestWord);
    }

    @Test
    public void advancedCustomOptionsCombobox() {
        List<String> testValueList = Arrays.asList("Foo", "Bar");

        advancedCustomOptionsCombobox.expand();
        advancedCustomOptionsCombobox.is().expanded();
        advancedCustomOptionsCombobox.close();
        advancedCustomOptionsCombobox.is().closed();
        advancedCustomOptionsCombobox.select("Bar");
        advancedCustomOptionsCombobox.is().selected(testValueList);
        advancedCustomOptionsCombobox.unselect(testValueList);
        advancedCustomOptionsCombobox.is().notSelected(testValueList);
        advancedCustomOptionsCombobox.sendKeys("JDI");
        advancedCustomOptionsCombobox.is().selected("JDI");
        advancedCustomOptionsCombobox.changeTextValue("JDI", "JDI Light");
    }

    @Test
    public void clearableComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().clearable();
    }

    @Test
    public void multipleComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().multiple();
    }

    @Test
    public void reverseComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().reversed();
    }

    @Test
    public void singleLineComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().singleLine();
    }

    @Test
    public void filledComboboxTest() {
        multipleChipsCombobox.show();
        multipleChipsCombobox.is().filled();
    }

    @Test
    public void loadingComboboxTest() {
        loadingCombobox.show();
        loadingCombobox.is().loading();
    }
}
