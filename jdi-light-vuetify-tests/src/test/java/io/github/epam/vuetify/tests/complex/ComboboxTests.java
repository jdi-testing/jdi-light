package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.comboboxPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.BLUE_LIGHTEN_3;
import static io.github.com.enums.Colors.RED_ACCENT_2;
import static io.github.com.enums.Colors.TEAL_LIGHTEN_5;
import static io.github.com.pages.ComboboxPage.advancedCustomOptionsCombobox;
import static io.github.com.pages.ComboboxPage.autofocusCombobox;
import static io.github.com.pages.ComboboxPage.counterCombobox1;
import static io.github.com.pages.ComboboxPage.counterCombobox3;
import static io.github.com.pages.ComboboxPage.customHeightCombobox;
import static io.github.com.pages.ComboboxPage.customStyleCombobox;
import static io.github.com.pages.ComboboxPage.denseCombobox;
import static io.github.com.pages.ComboboxPage.disabledCombobox1;
import static io.github.com.pages.ComboboxPage.errorCombobox1;
import static io.github.com.pages.ComboboxPage.errorMessageCombobox;
import static io.github.com.pages.ComboboxPage.flatCombobox;
import static io.github.com.pages.ComboboxPage.fullWidthCombobox;
import static io.github.com.pages.ComboboxPage.hideDetailsCombobox1;
import static io.github.com.pages.ComboboxPage.hideSelectedCombobox;
import static io.github.com.pages.ComboboxPage.loadingCombobox;
import static io.github.com.pages.ComboboxPage.multipleChipsCombobox;
import static io.github.com.pages.ComboboxPage.multipleReadOnlyCombobox;
import static io.github.com.pages.ComboboxPage.multipleScopedCombobox;
import static io.github.com.pages.ComboboxPage.multipleStringCombobox;
import static io.github.com.pages.ComboboxPage.noDataWithChipsCombobox;
import static io.github.com.pages.ComboboxPage.noFilterCombobox;
import static io.github.com.pages.ComboboxPage.persistentPlaceholderCombobox1;
import static io.github.com.pages.ComboboxPage.placeholderCombobox1;
import static io.github.com.pages.ComboboxPage.prefixSuffixCombobox;
import static io.github.com.pages.ComboboxPage.roundedCombobox;
import static io.github.com.pages.ComboboxPage.shapedCombobox;
import static io.github.com.pages.ComboboxPage.soloCombobox;
import static io.github.com.pages.ComboboxPage.soloInvertedCombobox;
import static io.github.com.pages.ComboboxPage.successCombobox1;

public class ComboboxTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        comboboxPage.open();
        waitCondition(() -> comboboxPage.isOpened());
        comboboxPage.checkOpened();
    }

    @Test(description = "Test checks combobox base functionality")
    public void baseFunctionalityTest() {
        List<String> testValueList = Arrays.asList("Programming", "Design", "Vue", "Vuetify");
        denseCombobox.expand();
        denseCombobox.is().expanded();
        denseCombobox.close();
        denseCombobox.is().closed();
        denseCombobox.has().label("Combobox");
        denseCombobox.select("Design");
        denseCombobox.select("Vue");
        denseCombobox.is().selected(testValueList);
        denseCombobox.unselect(testValueList);
        denseCombobox.is().notSelected(testValueList);
    }

    @Test(description = "Test checks if combobox is readonly or not : readonly(y/n)")
    public void readonlyComboboxTest() {
        multipleReadOnlyCombobox.show();
        multipleReadOnlyCombobox.is().readonly();
        multipleScopedCombobox.show();
        multipleScopedCombobox.is().notReadonly();
    }

    @Test(description = "Test checks that max 5 items can be selected")
    public void noDataWithChipsComboboxTest() {
        List<String> list = Arrays.asList("Gaming", "Programming", "Vue");
        String firstTestWord = "Test";
        String secondTestWord = "Not to add";
        noDataWithChipsCombobox.select(list);
        noDataWithChipsCombobox.sendKeys(firstTestWord);
        noDataWithChipsCombobox.sendKeys(secondTestWord);
        noDataWithChipsCombobox.is().notSelected(secondTestWord);
    }

    @Test(description = "Test checks that custom values can be selected")
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

    @Test(description = "Test checks if combobox is clearable or not : clearable(y/n)")
    public void clearableComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().clearable();
        multipleStringCombobox.clearButton().click();
        multipleStringCombobox.is().notClearable();
    }

    @Test(description = "Test checks if combobox is multiple or not")
    public void multipleComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().multiple();
        denseCombobox.show();
        denseCombobox.is().notMultiple();
    }

    @Test(description = "Test checks if combobox is reversed or not : reverse(y/n)")
    public void reverseComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().reversed();
        multipleChipsCombobox.is().notReversed();
    }

    @Test(description = "Test checks if combobox is single-line or not : single-line(y/n)")
    public void singleLineComboboxTest() {
        multipleStringCombobox.show();
        multipleStringCombobox.is().singleLine();
        multipleChipsCombobox.is().notSingleLine();
    }

    @Test(description = "Test checks if combobox is filled or not : filled(y/n)")
    public void filledComboboxTest() {
        multipleChipsCombobox.show();
        multipleChipsCombobox.is().filled();
        multipleStringCombobox.is().notFilled();
    }

    @Test(description = "Test checks if combobox is loading or not")
    public void loadingComboboxTest() {
        loadingCombobox.show();
        loadingCombobox.is().loading();
        soloCombobox.show();
        soloCombobox.is().loaded();
    }

    @Test(description = "Test checks if combobox's messages : hint(y/n), persistent-hint(y/n)")
    public void messagesComboboxTest() {
        errorMessageCombobox.show();
        errorMessageCombobox.has().messagesCount(1)
                .and().errorMessages()
                .and().errorMessage("Error");
    }

    @Test(description = "Test checks if combobox is error or success : error(y/n), success(y/n)")
    public void errorSuccessComboboxTest() {
        errorCombobox1.show();
        errorCombobox1.is().error()
                .and().notSuccess();
        successCombobox1.show();
        successCombobox1.is().success()
                .and().notError();
    }

    @Test(description = "Test checks if combobox is dense or not : dense(y/n)")
    public void denseComboboxTest() {
        denseCombobox.show();
        denseCombobox.is().dense();
        multipleChipsCombobox.show();
        multipleChipsCombobox.is().notDense();
    }

    @Test(description = "Test checks if combobox is outlined or not : outlined(y/n)")
    public void outlinedComboboxTest() {
        denseCombobox.show();
        denseCombobox.is().outlined();
        multipleChipsCombobox.show();
        multipleChipsCombobox.is().notOutlined();
    }

    @Test(description = "Test checks if combobox is solo or not : solo(y/n), solo-inverted(y/n)")
    public void soloComboboxTest() {
        soloCombobox.show();
        soloCombobox.is().solo();
        soloInvertedCombobox.isSoloInverted();
        multipleChipsCombobox.show();
        multipleChipsCombobox.is().notSolo()
                .and().notSoloInverted();
    }

    @Test(description = "Test checks if combobox is full-width or not : full-width(y/n)")
    public void fullWidthComboboxTest() {
        fullWidthCombobox.show();
        fullWidthCombobox.is().fullWidth();
        noFilterCombobox.show();
        noFilterCombobox.is().notFullWidth();
    }

    @Test(description = "Test checks that combobox hides selected options : hide-selected(y/n)")
    public void hideSelectedComboboxTest() {
        String valueToSelect = "Programming";
        hideSelectedCombobox.show();
        hideSelectedCombobox.expand();
        hideSelectedCombobox.list().has().size(4);
        hideSelectedCombobox.select(valueToSelect);
        hideSelectedCombobox.is().selected(valueToSelect);
        hideSelectedCombobox.expand();
        hideSelectedCombobox.list().has().size(3);
        hideSelectedCombobox.close();
    }

    @Test(description = "Test checks if combobox has chips or not : chips(y/n), small-chips(y/n)")
    public void chipsComboboxTest() {
        advancedCustomOptionsCombobox.show();
        advancedCustomOptionsCombobox.has().chips()
                .and().smallChips();
        advancedCustomOptionsCombobox.selectedChips().get(0).is().removable();
        loadingCombobox.show();
        loadingCombobox.has().noChips()
                .and().noSmallChips();
    }

    @Test(description = "Test checks combobox color : background-color(css or material), color(css or material)," +
            "item-color(css or material)")
    public void colorComboboxTest() {
        customStyleCombobox.show();
        customStyleCombobox.has().backgroundColor(TEAL_LIGHTEN_5.value())
                .and().color(BLACK_TRANSPARENT_087.value());
        advancedCustomOptionsCombobox.show();
        advancedCustomOptionsCombobox.select("Foo");
        advancedCustomOptionsCombobox.selectedChips().get(advancedCustomOptionsCombobox.selectedChips().size() - 1)
                .has().backgroundColor(BLUE_LIGHTEN_3.value());
        errorCombobox1.show();
        errorCombobox1.has().color(RED_ACCENT_2.value());
    }

    @Test(description = "Test checks combobox theme : theme(dark/light)")
    public void themeComboboxTest() {
        customStyleCombobox.show();
        customStyleCombobox.has().lightTheme();
    }

    @Test(description = "Test checks if combobox is disabled or not : disabled(y/n)")
    public void disabledComboboxTest() {
        disabledCombobox1.show();
        disabledCombobox1.is().disabled();
        flatCombobox.show();
        flatCombobox.is().enabled();
    }

    @Test(description = "Test checks if combobox is flat or not : flat(y/n)")
    public void flatComboboxTest() {
        flatCombobox.show();
        flatCombobox.is().flat();
        errorCombobox1.show();
        errorCombobox1.is().notFlat();
    }

    @Test(description = "Test checks combobox height : height(0-n)")
    public void heightComboboxTest() {
        customHeightCombobox.show();
        customHeightCombobox.has().height(100);
    }

    @Test(description = "Test checks combobox item text : item-text(text)")
    public void itemTextComboboxTest() {
        refresh();
        customHeightCombobox.show();
        customHeightCombobox.expand();
        customHeightCombobox.list().get(1).has().text("Programming");
        customHeightCombobox.close();
    }

    @Test(description = "Test checks if combobox has no-filter : no-filter(y/n)")
    public void noFilterComboboxTest() {
        String itemText = "Programming";
        noFilterCombobox.show();
        noFilterCombobox.expand();
        noFilterCombobox.sendKeys(itemText);
        noFilterCombobox.list().has().size(4);
        noFilterCombobox.close();
    }

    @Test(description = "Test checks if combobox has placeholder or not : placeholder(y/n), persistent placeholder(y/n)")
    public void placeholderComboboxTest() {
        String placeholderText = "Placeholder";
        placeholderCombobox1.show();
        placeholderCombobox1.expand();
        placeholderCombobox1.has().placeholder();
        placeholderCombobox1.has().placeholder(placeholderText);
        placeholderCombobox1.close();
        persistentPlaceholderCombobox1.show();
        persistentPlaceholderCombobox1.has().placeholder();
        persistentPlaceholderCombobox1.has().placeholder(placeholderText);
        disabledCombobox1.has().noPlaceholder();
    }

    @Test(description = "Test checks if combobox is rounded : rounded(y/n)")
    public void roundedComboboxTest() {
        roundedCombobox.show();
        roundedCombobox.is().rounded();
        shapedCombobox.show();
        shapedCombobox.is().notRounded();
    }

    @Test(description = "Test checks if combobox is shaped : shaped(y/n)")
    public void shapedComboboxTest() {
        shapedCombobox.show();
        shapedCombobox.is().shaped();
        roundedCombobox.show();
        roundedCombobox.is().notShaped();
    }

    @Test(description = "Test checks if combobox is autofocus : autofocus(y/n)")
    public void autofocusComboboxTest() {
        autofocusCombobox.show();
        autofocusCombobox.is().autofocus();
        denseCombobox.show();
        denseCombobox.is().notAutofocus();
    }

    @Test(description = "Test checks if combobox has counter or not : counter(y/n)")
    public void counterComboboxTest() {
        counterCombobox1.show();
        counterCombobox1.has().counter()
                .and().counterValue("0");
        counterCombobox3.has().counter()
                .and().counterValue("0 / 1");
        fullWidthCombobox.show();
        fullWidthCombobox.has().noCounter();
    }

    @Test(description = "Test checks if combobox has details hidden or not : hide details(y/n)")
    public void hideDetailsComboboxTest() {
        hideDetailsCombobox1.show();
        hideDetailsCombobox1.has().detailsHidden();
        counterCombobox1.show();
        counterCombobox1.has().notDetailsHidden();
    }

    @Test(description = "Test checks if combobox has suffix/prefix or not : prefix(string), suffix(string)")
    public void prefixSuffixComboboxTest() {
        prefixSuffixCombobox.show();
        prefixSuffixCombobox.has().prefix()
                .and().prefix("Start")
                .and().suffix()
                .and().suffix("End");
        customStyleCombobox.show();
        customStyleCombobox.has().noPrefix()
                .and().noSuffix();
    }
}
