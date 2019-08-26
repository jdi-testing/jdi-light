package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.Checklist;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.assertEquals;

public class CheckListSteps {

    @When("^I check element \"([^\"]*)\" in \"([^\"]*)\" checklist$")
    public void iCheckCheckBox(String value, String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(value);
    }

    @When("I check elements in \"([^\"]*)\" checklist:$")
    public void iCheckCheckboxes(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(values.toArray(new String[0]));
    }

    @When("I uncheck in \"([^\"]*)\" checklist elements:$")
    public void iUncheckElements(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(values.toArray(new String[0]));
    }

    @When("^I uncheck element \"([^\"]*)\" in \"([^\"]*)\" checklist$")
    public void iUnCheckCheckBox(String value, String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(value);
    }

    @When("^I check in \"([^\"]*)\" checklist elements by numbers:$")
    public void iCheckElementsByNumbers(String name, List<Integer> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(getIntArrayFromIntegerList(values));
    }

    @When("^I check in \"([^\"]*)\" checklist element by numbers (\\d+)$")
    public void iCheckElementByNumbers(String name, int value) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(value);
    }

    @When("^I uncheck in \"([^\"]*)\" checklist elements by numbers:$")
    public void iUncheckCheckBoxesByNumbers(String name, List<Integer> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(getIntArrayFromIntegerList(values));
    }

    @When("^I uncheck in \"([^\"]*)\" checklist element by numbers (\\d+)$")
    public void iUncheckCheckBoxesByNumbers(String name, int value) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(value);
    }

    @When("^I select elements in \"([^\"]*)\" checklist by numbers:$")
    public void iSelectCheckBoxesByNumbers(String name, List<Integer> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(getIntArrayFromIntegerList(values));
    }

    @When("^I select element in \"([^\"]*)\" checklist by number (\\d+)$")
    public void iSelectCheckBoxByNumbers(String name, int value) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(value);
    }

    @When("I check all elements in \"([^\"]*)\" checklist")
    public void iCheckAllCheckBoxes(String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.checkAll();
    }

    @When("^I uncheck all elements in \"([^\"]*)\" checklist$")
    public void iUncheckAllCheckBoxes(String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheckAll();
    }

    @Then("^In \"([^\"]*)\" checklist checked element is \"([^\"]*)\"$")
    public void isCheckBoxChecked(String name, String value) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.is().selected(value);
    }

    @Then("Count of selected elements in \"([^\"]*)\" checklist is (\\d+)")
    public void countOfSelectedCheckBoxes(String name, int count) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.is().selected(hasSize(count));
    }

    @Then("In the \"([^\"]*)\" checklist checked elements are:$")
    public void isCheckBoxesChecked(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        assertEquals(checklist.checked(), values);
    }

    @Then("The \"([^\"]*)\" checklist value is \"([^\"]*)\"$")
    public void checkListTextIs(String name, String text) {
        Checklist checklist = (Checklist) getUI(name);
        assertEquals(checklist.getValue(), text);
    }

    private int[] getIntArrayFromIntegerList(List<Integer> inputList) {
        int[] intBasedArray = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            intBasedArray[i] = inputList.get(i);
        }
        return intBasedArray;
    }
}
