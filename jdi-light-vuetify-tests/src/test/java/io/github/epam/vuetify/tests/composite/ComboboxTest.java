package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.comboboxPage;
import static io.github.com.pages.ComboboxPage.*;

public class ComboboxTest extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        comboboxPage.open();
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
        denseCombobox.unselect("Vue");
        denseCombobox.unselect(testValueList);
        denseCombobox.is().notSelected(testValueList);
    }

    @Test
    public void multipleComboboxTest() {
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

//    @Test
//    public void advancedCustomOptionsCombobox() throws InterruptedException {
//        advancedCustomOptionsCombobox.expand();
//        advancedCustomOptionsCombobox.close();
//        System.out.println(advancedCustomOptionsCombobox.listItems().size());
//        for (UIElement element : advancedCustomOptionsCombobox.listItems()) {
//            System.out.println(element.getText());
//        }
//        advancedCustomOptionsCombobox.select("Foo");
//        System.out.println(advancedCustomOptionsCombobox.isSelected("Foo"));
//        Thread.sleep(5000);
//    }
}
