package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.autocompletesPage;
import static io.github.com.pages.AutocompletesPage.asynchronousItemsAutocomplete;
import static io.github.com.pages.AutocompletesPage.autoselectAutocomplete;
import static io.github.com.pages.AutocompletesPage.clearApiButton;
import static io.github.com.pages.AutocompletesPage.clearableAutocomplete;
import static io.github.com.pages.AutocompletesPage.darkSoloAutocomplete;
import static io.github.com.pages.AutocompletesPage.darkSoloInvertedAutocomplete;
import static io.github.com.pages.AutocompletesPage.disabledAutocomplete;
import static io.github.com.pages.AutocompletesPage.filterEditButton;
import static io.github.com.pages.AutocompletesPage.filterName;
import static io.github.com.pages.AutocompletesPage.filterSaveButton;
import static io.github.com.pages.AutocompletesPage.filterStateAutocomplete;
import static io.github.com.pages.AutocompletesPage.lightDenseFilledRoundedAutocomplete;
import static io.github.com.pages.AutocompletesPage.lightDenseShapedOutlinedAutocomplete;
import static io.github.com.pages.AutocompletesPage.publicApiAutocomplete;
import static io.github.com.pages.AutocompletesPage.selectAutocomplete;
import static io.github.com.pages.AutocompletesPage.selectedApiName;

public class AutocompletesTests extends TestsInit {

    @BeforeClass
    public void before() {
        autocompletesPage.open();
        waitCondition(() -> autocompletesPage.isOpened());
        autocompletesPage.checkOpened();
    }

    @Test(description = "Test checks appearance of autocompletes and their values")
    public void styleAutocompleteTest() {
        List<String> list = Arrays.asList("foo", "bar", "fizz", "buzz");
        lightDenseShapedOutlinedAutocomplete.is()
                .light()
                .dense()
                .shaped()
                .outlined();
        lightDenseShapedOutlinedAutocomplete.expand();
        lightDenseShapedOutlinedAutocomplete.has().options(list);
        lightDenseShapedOutlinedAutocomplete.close();

        lightDenseFilledRoundedAutocomplete.is()
                .filled()
                .rounded();
        lightDenseFilledRoundedAutocomplete.expand();
        lightDenseFilledRoundedAutocomplete.has().options(list);
        lightDenseFilledRoundedAutocomplete.close();

        darkSoloAutocomplete.is()
                .dark()
                .solo();
        darkSoloAutocomplete.expand();
        darkSoloAutocomplete.has().options(list);
        darkSoloAutocomplete.close();

        darkSoloInvertedAutocomplete.is().dark();
        darkSoloInvertedAutocomplete.expand();
        darkSoloInvertedAutocomplete.has().options(list);
        darkSoloInvertedAutocomplete.close();
    }

    @Test(description = "Test checks selection values from autocomplete and text suggestions")
    public void functionalityAutocompleteTest() {
        disabledAutocomplete.show();
        disabledAutocomplete.is().disabled();

        clearableAutocomplete.expand();
        clearableAutocomplete.select("fizz");
        clearableAutocomplete.clickClear();
        clearableAutocomplete.close();

        autoselectAutocomplete.typeText("f");
        autoselectAutocomplete.has().options(Arrays.asList("foo", "fizz"));
        autoselectAutocomplete.input().sendKeys(Keys.ENTER);
        autoselectAutocomplete.has().selected("foo");
    }

    @Test(description = "Test checks selection values from autocomplete for filter type")
    public void filterAutocompletesTest() {
        String valueToSelect = "Florida";
        String valueToSelect2 = "Georgia";
        String name = "Mary";

        filterStateAutocomplete.show();
        filterStateAutocomplete.is().disabled();
        filterEditButton.click();
        filterStateAutocomplete.is().closed();
        filterName.text(name);
        filterStateAutocomplete.expand();
        filterStateAutocomplete.is().expanded();
        filterStateAutocomplete.select(valueToSelect);
        filterStateAutocomplete.is().selected(valueToSelect);
        filterStateAutocomplete.expand();
        filterStateAutocomplete.is().expanded();
        filterStateAutocomplete.select(valueToSelect2);
        filterStateAutocomplete.is().selected(valueToSelect2)
                .and().notSelected(valueToSelect);
        filterSaveButton.click();
        filterStateAutocomplete.is().disabled()
                .and().selected(valueToSelect2);
    }

    @Test(description = "Test checks multiple selections in autocomplete")
    public void selectAutocompleteTest() {
        List<String> valuesToSelect = Arrays.asList("Ali Connors", "John Smith");
        selectAutocomplete.is().closed();
        selectAutocomplete.expand();
        selectAutocomplete.is().expanded();
        selectAutocomplete.select(valuesToSelect);
        selectAutocomplete.is().selected(valuesToSelect);
    }

    @Test(description = "Test checks correct selection in public api autocomplete")
    public void publicApiAutocompleteTest() {
        String valueToSelect = "One Piece";
        publicApiAutocomplete.show();
        publicApiAutocomplete.is().closed();
        publicApiAutocomplete.typeText(valueToSelect);
        publicApiAutocomplete.select(valueToSelect);
        selectedApiName.has().text(valueToSelect);
        clearApiButton.click();
        publicApiAutocomplete.is().empty();
    }

    @Test(description = "Test checks asynchronous items for autocomplete")
    public void asynchronousItemsAutocompleteTest() {
        String valueToSelect = "Florida";
        asynchronousItemsAutocomplete.is().closed();
        asynchronousItemsAutocomplete.typeText("Flo");
        asynchronousItemsAutocomplete.select(valueToSelect);
        asynchronousItemsAutocomplete.is().selected(valueToSelect);
    }
}
