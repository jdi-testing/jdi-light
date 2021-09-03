package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.selectPage;
import static io.github.com.pages.inputs.SelectPage.ageNativeHelperSelect;
import static io.github.com.pages.inputs.SelectPage.ageNativeLabelSelect;
import static io.github.com.pages.inputs.SelectPage.ageNativeSimpleSelect;
import static io.github.com.pages.inputs.SelectPage.controlledSelect;
import static io.github.com.pages.inputs.SelectPage.disabledSelect;
import static io.github.com.pages.inputs.SelectPage.disabledSelectExpand;
import static io.github.com.pages.inputs.SelectPage.errorSelect;
import static io.github.com.pages.inputs.SelectPage.filledSelect;
import static io.github.com.pages.inputs.SelectPage.groupedNativeSelect;
import static io.github.com.pages.inputs.SelectPage.groupedSelectButton;
import static io.github.com.pages.inputs.SelectPage.helperLabels;
import static io.github.com.pages.inputs.SelectPage.multipleSelectButton;
import static io.github.com.pages.inputs.SelectPage.nativeSelectLabels;
import static io.github.com.pages.inputs.SelectPage.openTheSelectButton;
import static io.github.com.pages.inputs.SelectPage.outlinedSelect;
import static io.github.com.pages.inputs.SelectPage.placeholderSelect;
import static io.github.com.pages.inputs.SelectPage.requiredSelect;
import static io.github.com.pages.inputs.SelectPage.selectList;
import static io.github.com.pages.inputs.SelectPage.selectListItems;
import static io.github.com.pages.inputs.SelectPage.simpleSelectExpand;
import static io.github.com.pages.inputs.SelectPage.simpleSelectField;
import static io.github.com.pages.inputs.SelectPage.uncontrolledSelect;
import static io.github.com.pages.inputs.SelectPage.visuallyHiddenLabelSelect;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * To see an example of Select web element please visit
 * https://material-ui.com/components/selects/
 */

public class SelectTests extends TestsInit {

    @BeforeMethod
    public void before() {
        selectPage.open();
    }

    @Test
    public void simpleSelectTest() {
        simpleSelectExpand.click();
        selectList.selectItemByText("Henry");
        simpleSelectField.get(1).is().attr("value", "Henry");
    }

    @Test
    public void disabledSelectTest() {
        disabledSelectExpand.is().classValue(containsString("Mui-disabled"));
        disabledSelectExpand.has().attr("aria-disabled", "true");
        disabledSelectExpand.has().attr("aria-labelledby", "disabled-select");
    }

    @Test
    public void nativeSelectTest() {
        List<String> selectHelperLabels = Arrays.asList("Some important helper text", "With visually hidden label", "Label + placeholder",
                "Disabled", "Error", "Uncontrolled", "Placeholder", "Required");
        List<String> ageValuesList = Arrays.asList("", "Ten", "Twenty", "Thirty");
        List<String> ageValuesWithNoneList = Arrays.asList("None", "Ten", "Twenty", "Thirty");
        List<String> ageValuesWithoutNoneList = Arrays.asList("Ten", "Twenty", "Thirty");
        List<String> ageValuesWithPlaceholderList = Arrays.asList("Placeholder","Ten", "Twenty", "Thirty");
        List<String> nameValuesList = Arrays.asList("Hai", "Olivier", "Kevin");

        for(Text label: helperLabels) {
            assertTrue(selectHelperLabels.contains(label.getText()));
        }

        nativeSelectLabels.get(1).is().text("Age");
        ageNativeSimpleSelect.select("Ten");
        ageNativeSimpleSelect.is().selected("Ten");
        assertTrue(ageValuesList.containsAll(ageNativeSimpleSelect.values()));

        nativeSelectLabels.get(2).is().text("Age");
        ageNativeHelperSelect.select("Twenty");
        ageNativeHelperSelect.selected("Twenty");
        assertTrue(ageValuesList.containsAll(ageNativeHelperSelect.values()));

        visuallyHiddenLabelSelect.select("Ten");
        visuallyHiddenLabelSelect.selected("Ten");
        assertTrue(ageValuesWithNoneList.containsAll(visuallyHiddenLabelSelect.values()));

        nativeSelectLabels.get(3).is().text("Age");
        ageNativeLabelSelect.select("Thirty");
        ageNativeLabelSelect.selected("Thirty");
        assertTrue(ageValuesWithNoneList.containsAll(ageNativeLabelSelect.values()));

        nativeSelectLabels.get(4).is().text("Name");
        assertTrue(disabledSelect.isDisabled());

        nativeSelectLabels.get(5).is().text("Name");
        errorSelect.select("Hai");
        errorSelect.selected("Hai");
        assertTrue(nameValuesList.containsAll(errorSelect.values()));

        nativeSelectLabels.get(6).is().text("Name");
        uncontrolledSelect.select("Twenty");
        uncontrolledSelect.selected("Twenty");
        assertTrue(ageValuesWithoutNoneList.containsAll(uncontrolledSelect.values()));

        placeholderSelect.select("Ten");
        placeholderSelect.selected("Ten");
        assertTrue(ageValuesWithPlaceholderList.containsAll(placeholderSelect.values()));

        nativeSelectLabels.get(7).is().text("Age *");
        requiredSelect.select("Thirty");
        requiredSelect.selected("Thirty");
        assertTrue(ageValuesList.containsAll(requiredSelect.values()));

        nativeSelectLabels.get(8).is().text("Age");
        outlinedSelect.select("Twenty");
        outlinedSelect.selected("Twenty");
        assertTrue(ageValuesList.containsAll(outlinedSelect.values()));

        nativeSelectLabels.get(9).is().text("Age");
        filledSelect.select("Ten");
        filledSelect.selected("Ten");
        assertTrue(ageValuesList.containsAll(filledSelect.values()));
    }

    @Test
    public void multipleSelect() {
        List<String> listOfMultipleSelect = Arrays.asList("Oliver", "Van", "April", "Ralph", "Omar", "Carlos", "Miriam",
                "Bradley", "Virginia", "Kelly");

        multipleSelectButton.click();
        selectList.multipleSelect(listOfMultipleSelect.subList(0,2));
        selectListItems.get(1).sendKeys(Keys.ESCAPE);
        multipleSelectButton.is().text(listOfMultipleSelect.subList(0,2).toString().replace("[", "").replace("]", ""));

        WebPage.refresh();
        multipleSelectButton.click();
        selectList.multipleSelect(listOfMultipleSelect);
        multipleSelectButton.is().text(listOfMultipleSelect.toString().replace("[", "").replace("]", ""));
    }

    @Test
    public void groupingSelect() {
        List<String> listOfGroupingNativeSelect = Arrays.asList("", "Option 1", "Option 2", "Option 3", "Option 4");
        List<String> listOfGroupingSelect = Arrays.asList("None", "Category 1", "Option 1", "Option 2", "Category 1", "Option 3", "Option 4");

        assertTrue(listOfGroupingNativeSelect.containsAll(groupedNativeSelect.values()));
        groupedNativeSelect.select("Option 3");
        groupedNativeSelect.selected("Option 3");

        groupedSelectButton.click();
        selectListItems.forEach( item ->
                assertTrue(listOfGroupingSelect.contains(item.getText())));
        selectList.selectItemByText("Option 1");
        groupedSelectButton.is().text("Option 1");
    }

    @Test
    public void controlledOpenSelect() {
        List<String> ageValuesList = Arrays.asList("None", "Ten", "Twenty", "Thirty");

        openTheSelectButton.click();
        selectListItems.forEach( item ->
                assertTrue(ageValuesList.contains(item.getText())));
        selectList.selectItemByText("Ten");
        controlledSelect.is().text("Ten");

        controlledSelect.click();
        selectList.selectItemByText("Twenty");
        controlledSelect.is().text("Twenty");
    }
}
