package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import io.github.epam.test.data.SelectDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.selectPage;
import static io.github.com.pages.inputs.SelectPage.ageNameNativeDisabledSelect;
import static io.github.com.pages.inputs.SelectPage.ageNameNativeErrorSelect;
import static io.github.com.pages.inputs.SelectPage.ageNativeHelperSelect;
import static io.github.com.pages.inputs.SelectPage.ageNativeLabelPlaceholderSelect;
import static io.github.com.pages.inputs.SelectPage.ageNativeRequiredSelect;
import static io.github.com.pages.inputs.SelectPage.ageNativeSimpleSelect;
import static io.github.com.pages.inputs.SelectPage.controlledOpenSelect;
import static io.github.com.pages.inputs.SelectPage.disabledSelect;
import static io.github.com.pages.inputs.SelectPage.filledAgeNativeSimpleSelect;
import static io.github.com.pages.inputs.SelectPage.groupedNativeSelect;
import static io.github.com.pages.inputs.SelectPage.groupedSelect;
import static io.github.com.pages.inputs.SelectPage.multipleSelect;
import static io.github.com.pages.inputs.SelectPage.openSelectButton;
import static io.github.com.pages.inputs.SelectPage.outlinedAgeNativeSimpleSelect;
import static io.github.com.pages.inputs.SelectPage.placeholderNativeSelect;
import static io.github.com.pages.inputs.SelectPage.simpleSelect;
import static io.github.com.pages.inputs.SelectPage.uncontrolledNativeSelect;
import static io.github.epam.enums.Colors.RED_500;

public class SelectTests extends TestsInit {

    /**
     * List option for Grouping select
     */
    private static final String[] GROUPED_SELECT_VALUES = {"Category 1", "Option 1", "Option 2", "Category 2", "Option 3", "Option 4"};

    @BeforeMethod
    public void before() {
        selectPage.open();
        selectPage.isOpened();
    }

    @Test
    public void expandSimpleSelectTest() {
        simpleSelect.show();
        simpleSelect.is().collapsed();

        simpleSelect.expand();
        simpleSelect.is().expanded();

        simpleSelect.close();
        simpleSelect.is().collapsed();
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "simpleSelectTestData")
    public void simpleSelectTest(String age) {
        simpleSelect.select(age);
        simpleSelect.has().selected(age);
    }

    @Test
    public void disabledSelectTest() {
        disabledSelect.is().disabled();
        disabledSelect.expand();
        disabledSelect.is().collapsed();
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void ageNativeSimpleTest(String age) {
        ageNativeSimpleSelect.label().has().text("Age");

        ageNativeSimpleSelect.nativeSelect().select(age);
        ageNativeSimpleSelect.nativeSelect().has().selected(age);

        ageNativeHelperSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");
        placeholderNativeSelect.nativeSelect().has().selected(age);
        ageNativeRequiredSelect.nativeSelect().has().selected(age);
        outlinedAgeNativeSimpleSelect.nativeSelect().has().selected(age);
        filledAgeNativeSimpleSelect.nativeSelect().has().selected(age);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void ageNativeHelperTest(String age) {
        ageNativeHelperSelect.label().has().text("Age");
        ageNativeHelperSelect.helperText().has().text("Some important helper text");

        ageNativeHelperSelect.nativeSelect().select(age);
        ageNativeHelperSelect.nativeSelect().has().selected(age);

        ageNativeSimpleSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");
        placeholderNativeSelect.nativeSelect().has().selected(age);
        ageNativeRequiredSelect.nativeSelect().has().selected(age);
        outlinedAgeNativeSimpleSelect.nativeSelect().has().selected(age);
        filledAgeNativeSimpleSelect.nativeSelect().has().selected(age);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void ageNativeLabelPlaceholderTest(String age) {
        ageNativeLabelPlaceholderSelect.label().has().text("Age");
        ageNativeLabelPlaceholderSelect.helperText().has().text("Label + placeholder");

        ageNativeLabelPlaceholderSelect.nativeSelect().select(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);

        ageNativeSimpleSelect.nativeSelect().has().selected(age);
        ageNativeHelperSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");
        placeholderNativeSelect.nativeSelect().has().selected(age);
        ageNativeRequiredSelect.nativeSelect().has().selected(age);
        outlinedAgeNativeSimpleSelect.nativeSelect().has().selected(age);
        filledAgeNativeSimpleSelect.nativeSelect().has().selected(age);
    }

    @Test
    public void disabledNameNativeSelectTest() {
        ageNameNativeDisabledSelect.is().disabled();

        ageNameNativeDisabledSelect.label().has().text("Name");
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeDisabledSelect.helperText().has().text("Disabled");
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "nameNativeErrorSelectTestData")
    public void nameNativeErrorSelectTest(String value) {
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");

        final String errorClass = "Mui-error";
        final String redColor = RED_500.rgba();

        ageNameNativeErrorSelect.label()
                .has().text("Name")
                .has().cssClass(errorClass)
                .has().css("color", redColor);

        ageNameNativeErrorSelect.helperText()
                .has().text("Error")
                .has().cssClass(errorClass)
                .has().css("color", redColor);

        ageNameNativeErrorSelect.nativeSelect().select(value);
        ageNameNativeErrorSelect.nativeSelect().has().selected(value);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void uncontrolledNativeSelectTest(String age) {
        uncontrolledNativeSelect.label().has().text("Name");
        uncontrolledNativeSelect.helperText().has().text("Uncontrolled");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");

        uncontrolledNativeSelect.nativeSelect().select(age);
        uncontrolledNativeSelect.nativeSelect().has().selected(age);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void placeholderNativeSelectTest(String age) {
        placeholderNativeSelect.helperText().has().text("Placeholder");
        placeholderNativeSelect.nativeSelect().has().selected("Placeholder");

        placeholderNativeSelect.nativeSelect().select(age);
        placeholderNativeSelect.nativeSelect().has().selected(age);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void ageNativeRequiredSelectTest(String age) {
        ageNativeRequiredSelect.label().has().text("Age *");
        ageNativeRequiredSelect.helperText().has().text("Required");

        ageNativeRequiredSelect.nativeSelect().select(age);
        ageNativeRequiredSelect.nativeSelect().has().selected(age);

        ageNativeSimpleSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNativeHelperSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");
        placeholderNativeSelect.nativeSelect().has().selected(age);
        outlinedAgeNativeSimpleSelect.nativeSelect().has().selected(age);
        filledAgeNativeSimpleSelect.nativeSelect().has().selected(age);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void outlinedAgeNativeSimpleSelectTest(String age) {
        outlinedAgeNativeSimpleSelect.label().has().text("Age");

        outlinedAgeNativeSimpleSelect.nativeSelect().select(age);
        outlinedAgeNativeSimpleSelect.nativeSelect().has().selected(age);

        ageNativeSimpleSelect.nativeSelect().has().selected(age);
        ageNativeRequiredSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNativeHelperSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");
        placeholderNativeSelect.nativeSelect().has().selected(age);
        filledAgeNativeSimpleSelect.nativeSelect().has().selected(age);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void filledAgeNativeSimpleSelectTest(String age) {
        filledAgeNativeSimpleSelect.label().has().text("Age");

        filledAgeNativeSimpleSelect.nativeSelect().select(age);
        filledAgeNativeSimpleSelect.nativeSelect().has().selected(age);

        ageNativeSimpleSelect.nativeSelect().has().selected(age);
        ageNativeRequiredSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNativeHelperSelect.nativeSelect().has().selected(age);
        ageNativeLabelPlaceholderSelect.nativeSelect().has().selected(age);
        ageNameNativeDisabledSelect.nativeSelect().has().selected("Hai");
        ageNameNativeErrorSelect.nativeSelect().has().selected("Hai");
        uncontrolledNativeSelect.nativeSelect().has().selected("Thirty");
        placeholderNativeSelect.nativeSelect().has().selected(age);
        outlinedAgeNativeSimpleSelect.nativeSelect().has().selected(age);
    }

    @Test
    public void multipleSelectTest() {
        String[] values = {"Oliver", "Omar", "Kelly"};
        String separator = ", ";
        String result = String.join(separator, values);

        multipleSelect.select(values);
        multipleSelect.has().selected(result);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "groupingSelectTestData")
    public void groupedNativeSelectTest(String value) {
        groupedNativeSelect.select(value);
        groupedNativeSelect.has().selected(value);
    }

    @Test
    public void expandGroupedSelectTest() {
        groupedSelect.show();
        groupedSelect.is().collapsed();

        groupedSelect.expand();
        groupedSelect.is().expanded()
                .has().values(GROUPED_SELECT_VALUES);

        groupedSelect.close();
        groupedSelect.is().collapsed();
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "categoryGroupingSelectTestData")
    public void categoryGroupingSelectTest(String categoryValue) {
        groupedSelect.select(categoryValue);
        groupedSelect.has().selected("​");
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "groupingSelectTestData")
    public void groupingSelectTest(String value) {
        groupedSelect.select(value);
        groupedSelect.has().selected(value);
    }

    @Test(dataProviderClass = SelectDataProvider.class, dataProvider = "ageSelectTestData")
    public void controlledOpenSelectTest(String age) {
        controlledOpenSelect.show();
        controlledOpenSelect.is().collapsed();

        openSelectButton.click();
        controlledOpenSelect.is().expanded();

        controlledOpenSelect.select(age);
        controlledOpenSelect.has().selected(age);
    }
}
