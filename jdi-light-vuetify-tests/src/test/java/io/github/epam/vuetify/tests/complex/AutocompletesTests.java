package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.autocompletesPage;
import static io.github.com.pages.AutocompletesPage.filterEditButton;
import static io.github.com.pages.AutocompletesPage.filterName;
import static io.github.com.pages.AutocompletesPage.filterStateDropdown;
import static io.github.com.pages.AutocompletesPage.outlinedDenseCombobox;

public class AutocompletesTests extends TestsInit {

    @BeforeSuite
    public void before() {
        autocompletesPage.open();
    }

    @Test
    public void denseAutocompletesTest() {
        List<String> valuesToCheck = new ArrayList<>(Arrays.asList("fizz", "buzz"));
        outlinedDenseCombobox.is().closed();
        outlinedDenseCombobox.expand();
        outlinedDenseCombobox.is().expanded();
//        outlinedDenseCombobox.assertThat().listContainsValues(valuesToCheck);
        outlinedDenseCombobox.select(valuesToCheck);
        outlinedDenseCombobox.is().selected(valuesToCheck);
        outlinedDenseCombobox.unselect(valuesToCheck);
        outlinedDenseCombobox.is().notSelected(valuesToCheck);
        outlinedDenseCombobox.close();
        outlinedDenseCombobox.is().closed();
    }

    @Test
    public void filterAutocompletesTest() {
//        filterStateDropdown.is().disabled();
        filterEditButton.click();
//        filterStateDropdown.is().active();
        filterName.sendKeys("Mary");
        filterStateDropdown.expand();
        filterStateDropdown.is().expanded();
        String valueToSelect = "Florida";
        filterStateDropdown.select(valueToSelect);
        filterStateDropdown.is().selected(valueToSelect);
        filterStateDropdown.select(2);
        filterStateDropdown.is().selected("Georgia");
        filterStateDropdown.is().notSelected("Florida");
    }
}
