package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.Checklist;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.jdiai.tools.LinqUtils.toIntArray;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;

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
    public static void iCheckCheckboxes(String name, DataTable values) {
        checklist(name).check(values.values().toArray(new String[0]));
    }

    @When("^(?:I |)uncheck in \"([^\"]*)\" checklist elements:$")
    public static void iUncheckElements(String name, DataTable values) {
        checklist(name).uncheck(values.values().toArray(new String[0]));
    }

    @When("^(?:I |)uncheck element \"([^\"]*)\" in \"([^\"]*)\" checklist$")
    public static void iUnCheckCheckBox(String value, String name) {
        checklist(name).uncheck(value);
    }

    @When("^(?:I |)check in \"([^\"]*)\" checklist elements by numbers:$")
    public static void iCheckElementsByNumbers(String name, DataTable values) {
        List<Integer> intValues = values.values().stream().map(v -> parseInt(v)).collect(Collectors.toList());
        checklist(name).check(toIntArray(intValues));
    }

    @When("^(?:I |)check in \"([^\"]*)\" checklist element by numbers ([0-9]+)$")
    public static void iCheckElementByNumbers(String name, int value) {
        checklist(name).check(value);
    }

    @When("^(?:I |)uncheck in \"([^\"]*)\" checklist elements by numbers:$")
    public static void iUncheckCheckBoxesByNumbers(String name, DataTable values) {
        List<Integer> intValues = values.values().stream().map(v -> parseInt(v)).collect(Collectors.toList());
        checklist(name).uncheck(toIntArray(intValues));
    }

    @When("^(?:I |)uncheck in \"([^\"]*)\" checklist element by numbers ([0-9]+)$")
    public static void iUncheckCheckBoxesByNumbers(String name, int value) {
        checklist(name).uncheck(value);
    }

    @When("^(?:I |)select elements in \"([^\"]*)\" checklist by numbers:$")
    public static void iSelectCheckBoxesByNumbers(String name, DataTable values) {
        List<Integer> intValues = values.values().stream().map(v -> parseInt(v)).collect(Collectors.toList());
        checklist(name).select(toIntArray(intValues));
    }

    @When("^(?:I |)select element in \"([^\"]*)\" checklist by number ([0-9]+)$")
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

    @Then("^in \"([^\"]*)\" checklist \"([^\"]*)\" is checked$")
    public static void isCheckBoxChecked(String name, String value) {
        checklist(name).is().selected(containsString(value));
    }

    @Then("count of selected elements in {string} checklist is {int}")
    public static void countOfSelectedCheckBoxes(String name, int count) {
        checklist(name).is().checked(hasSize(count));
    }

    @Then("in the \"([^\"]*)\" checklist checked elements are:$")
    public static void isCheckBoxesChecked(String name, DataTable values) {
        checklist(name).is().checked(values.values());
    }

    @Then("the \"([^\"]*)\" checklist value is \"([^\"]*)\"$")
    public static void checkListTextIs(String name, String text) {
        checklist(name).has().text(text);
    }

    @When("^(?:I |)Select fields from \"([^\"]*)\":$")
    public static void multiSelect(String name, DataTable values) {
        checklist(name).select(values.values().toArray(new String[0]));
    }
}
