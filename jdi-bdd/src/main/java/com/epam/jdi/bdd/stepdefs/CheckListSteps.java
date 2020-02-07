package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.mobile.elements.complex.Checklist;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.mobile.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.LinqUtils.toIntArray;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class CheckListSteps {
    public static Checklist checklist(String name) {
        return getUI(name, Checklist.class);
    }

    @When("^(?:I |)check element \"([^\"]*)\" in \"([^\"]*)\" checklist$")
    public static void iCheckCheckBox(String value, String name) {
        checklist(name).check(value);
    }
    @When("^(?:I |)check elements in \"([^\"]*)\" checklist:$")
    public static void iCheckCheckboxes(String name, List<String> values) {
        checklist(name).check(values.toArray(new String[0]));
    }
    @When("^(?:I |)uncheck in \"([^\"]*)\" checklist elements:$")
    public static void iUncheckElements(String name, List<String> values) {
        checklist(name).uncheck(values.toArray(new String[0]));
    }
    @When("^(?:I |)uncheck element \"([^\"]*)\" in \"([^\"]*)\" checklist$")
    public static void iUnCheckCheckBox(String value, String name) {
        checklist(name).uncheck(value);
    }
    @When("^(?:I |)check in \"([^\"]*)\" checklist elements by numbers:$")
    public static void iCheckElementsByNumbers(String name, List<Integer> values) {
        checklist(name).check(toIntArray(values));
    }
    @When("^(?:I |)check in \"([^\"]*)\" checklist element by numbers (\\d+)$")
    public static void iCheckElementByNumbers(String name, int value) {
        checklist(name).check(value);
    }
    @When("^(?:I |)uncheck in \"([^\"]*)\" checklist elements by numbers:$")
    public static void iUncheckCheckBoxesByNumbers(String name, List<Integer> values) {
        checklist(name).uncheck(toIntArray(values));
    }
    @When("^(?:I |)uncheck in \"([^\"]*)\" checklist element by numbers (\\d+)$")
    public static void iUncheckCheckBoxesByNumbers(String name, int value) {
        checklist(name).uncheck(value);
    }
    @When("^(?:I |)select elements in \"([^\"]*)\" checklist by numbers:$")
    public static void iSelectCheckBoxesByNumbers(String name, List<Integer> values) {
        checklist(name).select(toIntArray(values));
    }
    @When("^(?:I |)select element in \"([^\"]*)\" checklist by number (\\d+)$")
    public static void iSelectCheckBoxByNumbers(String name, int value) {
        checklist(name).select(value);
    }
    @When("^(?:I |)check all elements in \"([^\"]*)\" checklist")
    public static void iCheckAllCheckBoxes(String name) {
        checklist(name).checkAll();
    }
    @When("^(?:I |)uncheck all elements in \"([^\"]*)\" checklist$")
    public static void iUncheckAllCheckBoxes(String name) {
        checklist(name).uncheckAll();
    }
    @Then("^in \"([^\"]*)\" checklist checked element is \"([^\"]*)\"$")
    public static void isCheckBoxChecked(String name, String value) {
        checklist(name).is().selected(value);
    }
    @Then("count of selected elements in \"([^\"]*)\" checklist is (\\d+)")
    public static void countOfSelectedCheckBoxes(String name, int count) {
        checklist(name).is().checked(hasSize(count));
    }
    @Then("in the \"([^\"]*)\" checklist checked elements are:$")
    public static void isCheckBoxesChecked(String name, List<String> values) {
        assertEquals(checklist(name).checked(), values);
    }
    @Then("the \"([^\"]*)\" checklist value is \"([^\"]*)\"$")
    public static void checkListTextIs(String name, String text) {
        assertEquals(checklist(name).getValue(), text);
    }
    @When("^(?:I |)Select fields from \"([^\"]*)\":$")
    public static void multiSelect(String name, List<String> values) {
        checklist(name).select(values.toArray(new String[0]));
    }
}
