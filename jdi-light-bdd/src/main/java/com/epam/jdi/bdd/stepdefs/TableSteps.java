package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.table.Table;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;

public class TableSteps {
    @When("^(?:I |)set \"([^\"]*)\" value to (\\d+)$")
    public void installTo(String elementName, int value) {
        Table table = getUI(elementName, Table.class);
    }
}
