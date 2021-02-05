package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.Checklist;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.LinqUtils.toIntArray;
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

    @When("I check element {string} in {string} checklist")
    @When("check element {string} in {string} checklist")
    public static void iCheckCheckBox(String value, String name) {
        checklist(name).check(value);
    }

    @When("I check elements in {string} checklist:")
    @When("check elements in {string} checklist:")
    public static void iCheckCheckboxes(String name, List<List<String>> values) {
        checklist(name).check(values.get(0).toArray(new String[0]));
    }

    @When("I uncheck in {string} checklist elements:")
    @When("uncheck in {string} checklist elements:")
    public static void iUncheckElements(String name, List<List<String>> values) {
        checklist(name).uncheck(values.get(0).toArray(new String[0]));
    }

    @When("I uncheck element {string} in {string} checklist")
    @When("uncheck element {string} in {string} checklist")
    public static void iUnCheckCheckBox(String value, String name) {
        checklist(name).uncheck(value);
    }

    @When("I check in {string} checklist elements by numbers:")
    @When("check in {string} checklist elements by numbers:")
    public static void iCheckElementsByNumbers(String name, List<List<Integer>> values) {
        checklist(name).check(toIntArray(values.get(0)));
    }

    @When("I check in {string} checklist element by numbers {int}")
    @When("check in {string} checklist element by numbers {int}")
    public static void iCheckElementByNumbers(String name, int value) {
        checklist(name).check(value);
    }

    @When("I uncheck in {string} checklist elements by numbers:")
    @When("uncheck in {string} checklist elements by numbers:")
    public static void iUncheckCheckBoxesByNumbers(String name, List<List<Integer>> values) {
        checklist(name).uncheck(toIntArray(values.get(0)));
    }

    @When("I uncheck in {string} checklist element by numbers {int}")
    @When("uncheck in {string} checklist element by numbers {int}")
    public static void iUncheckCheckBoxesByNumbers(String name, int value) {
        checklist(name).uncheck(value);
    }

    @When("I select elements in {string} checklist by numbers:")
    @When("select elements in {string} checklist by numbers:")
    public static void iSelectCheckBoxesByNumbers(String name, List<List<Integer>> values) {
        checklist(name).select(toIntArray(values.get(0)));
    }

    @When("I select element in {string} checklist by number {int}")
    @When("select element in {string} checklist by number {int}")
    public static void iSelectCheckBoxByNumbers(String name, int value) {
        checklist(name).select(value);
    }

    @When("I check all elements in {string} checklist")
    @When("check all elements in {string} checklist")
    public static void iCheckAllCheckBoxes(String name) {
        checklist(name).checkAll();
    }

    @When("I uncheck all elements in {string} checklist")
    @When("uncheck all elements in {string} checklist")
    public static void iUncheckAllCheckBoxes(String name) {
        checklist(name).uncheckAll();
    }

    @Then("in {string} checklist {string} is checked")
    public static void isCheckBoxChecked(String name, String value) {
        checklist(name).is().selected(containsString(value));
    }

    @Then("count of selected elements in {string} checklist is {int}")
    public static void countOfSelectedCheckBoxes(String name, int count) {
        checklist(name).is().checked(hasSize(count));
    }

    @Then("in the {string} checklist checked elements are:")
    public static void isCheckBoxesChecked(String name, List<List<String>> values) {
        checklist(name).is().checked(values.get(0));
    }

    @Then("the {string} checklist value is {string}")
    public static void checkListTextIs(String name, String text) {
        checklist(name).has().text(text);
    }

    @When("I Select fields from {string}:")
    @When("Select fields from {string}:")
    public static void multiSelect(String name, List<List<String>> values) {
        checklist(name).select(values.get(0).toArray(new String[0]));
    }
}
