package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.autocompletesPage;
import static io.github.com.pages.AutocompletesPage.asynchronousItemsAutocomplete;
import static io.github.com.pages.AutocompletesPage.clearApiButton;
import static io.github.com.pages.AutocompletesPage.filledDenseAutocomplete;
import static io.github.com.pages.AutocompletesPage.filterEditButton;
import static io.github.com.pages.AutocompletesPage.filterName;
import static io.github.com.pages.AutocompletesPage.filterSaveButton;
import static io.github.com.pages.AutocompletesPage.filterStateAutocomplete;
import static io.github.com.pages.AutocompletesPage.outlinedDenseAutocomplete;
import static io.github.com.pages.AutocompletesPage.publicApiAutocomplete;
import static io.github.com.pages.AutocompletesPage.selectAutocomplete;
import static io.github.com.pages.AutocompletesPage.selectedApiName;

public class AutocompletesTests extends TestsInit {

    @BeforeClass
    public void before() {
        autocompletesPage.open();
    }

    @Test
    public void outlinedDenseAutocompleteTest() {
        List<String> valuesToCheck = Arrays.asList("fizz", "buzz");
        String valueToUnselect = "foo";
        outlinedDenseAutocomplete.is().closed();
        outlinedDenseAutocomplete.expand();
        outlinedDenseAutocomplete.is().expanded();
        outlinedDenseAutocomplete.select(valuesToCheck);
        outlinedDenseAutocomplete.is().selected(valuesToCheck);
        outlinedDenseAutocomplete.unselect(valuesToCheck);
        outlinedDenseAutocomplete.is().notSelected(valuesToCheck);
        outlinedDenseAutocomplete.unselect(valueToUnselect);
        outlinedDenseAutocomplete.is().notSelected(valueToUnselect);
        outlinedDenseAutocomplete.close();
        outlinedDenseAutocomplete.is().closed();
    }

    @Test
    public void filledDenseComboboxTest() {
        String valueToSelect = "foo";
        filledDenseAutocomplete.is().closed();
        filledDenseAutocomplete.expand();
        filledDenseAutocomplete.is().expanded();
        filledDenseAutocomplete.select(valueToSelect);
        filledDenseAutocomplete.is().selected(valueToSelect);
    }

    @Test
    public void filterAutocompletesTest() {
        String valueToSelect = "Florida";
        String valueToSelect2 = "Georgia";
        String name = "Mary";

        filterStateAutocomplete.is().disabled();
        filterEditButton.show();
        filterEditButton.click();
        filterStateAutocomplete.is().active();
        filterName.sendKeys(name);
        filterStateAutocomplete.expand();
        filterStateAutocomplete.is().expanded();
        filterStateAutocomplete.select(valueToSelect);
        filterStateAutocomplete.is().selected(valueToSelect);
        filterStateAutocomplete.expand();
        filterStateAutocomplete.is().expanded();
        filterStateAutocomplete.select(valueToSelect2);
        filterStateAutocomplete.is().selected(valueToSelect2);
        filterStateAutocomplete.is().notSelected(valueToSelect);
        filterSaveButton.click();
        filterStateAutocomplete.is().disabled();
        filterStateAutocomplete.is().selected(valueToSelect2);
    }

    @Test
    public void selectAutocompleteTest() {
        List<String> valuesToSelect = Arrays.asList("Ali Connors", "John Smith");
        selectAutocomplete.is().closed();
        selectAutocomplete.expand();
        selectAutocomplete.is().expanded();
        selectAutocomplete.select(valuesToSelect);
        selectAutocomplete.is().selected(valuesToSelect);
    }

    @Test
    public void publicApiAutocompleteTest() {
        String valueToSelect = "Daily cat facts";
        publicApiAutocomplete.is().closed();
        publicApiAutocomplete.typeText("Test");
        publicApiAutocomplete.clearTextField();
        publicApiAutocomplete.select(valueToSelect);
        publicApiAutocomplete.is().selected("Object");
        selectedApiName.has().text(valueToSelect);
        clearApiButton.click();
    }

    @Test
    public void asynchronousItemsAutocompleteTest() {
        String valueToSelect = "Florida";
        asynchronousItemsAutocomplete.is().closed();
        asynchronousItemsAutocomplete.typeText("Flo");
        asynchronousItemsAutocomplete.clearTextField();
        asynchronousItemsAutocomplete.select(valueToSelect);
        asynchronousItemsAutocomplete.is().selected(valueToSelect);
    }
}
