package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static io.github.com.StaticSite.autocompletesPage;
import static io.github.com.pages.AutocompletesPage.filterEditButton;
import static io.github.com.pages.AutocompletesPage.filterName;
import static io.github.com.pages.AutocompletesPage.filterStateDropdown;
import static io.github.com.pages.AutocompletesPage.outlinedDenseCombobox;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutocompletesTests extends TestsInit {

    @BeforeSuite
    public void before() {
        autocompletesPage.open();
    }

    @Test
    public void denseAutocompletesTest() {
//        outlinedDenseCombobox.waitFor(displayed);
//        String[] valuesToCheck = new String[] {"fizz", "buzz"};
//        outlinedDenseCombobox.core().click();
//        outlinedDenseCombobox.check(valuesToCheck);
    }

    @Test
    public void filterAutocompletesTest() {
        filterEditButton.click();
        filterName.sendKeys("Mary");
        filterStateDropdown.expand();
        String valueToSelect = "Florida";
        filterStateDropdown.list().select(valueToSelect);
        assertThat(filterStateDropdown.value().getText(), equalTo(valueToSelect));
    }
}
