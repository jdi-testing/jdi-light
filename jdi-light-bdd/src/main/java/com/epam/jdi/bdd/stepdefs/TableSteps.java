package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.table.Table;
import cucumber.api.java.en.Then;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUIComplex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableSteps {
    @Then("^the \"([^\"]*)\" table columns count equals \"([^\"]*)\"$")
    public void assertColumnsCount(String elementName, int columns) {
        Table table = getUIComplex(elementName, Table.class);
        assertEquals(columns, table.size());
    }

    @Then("^the \"([^\"]*)\" table rows count equals \"([^\"]*)\"$")
    public void assertRowsCount(String elementName, int rows) {
        Table table = getUIComplex(elementName, Table.class);
        assertEquals(rows, table.rows().size());
    }

    @Then("^the \"([^\"]*)\" table header has items:$")
    public void assertHasItems(String elementName, List<String> values) {
        Table table = getUIComplex(elementName, Table.class);
        System.out.println(table.header());
        assertTrue(table.header().containsAll(values));
    }
}
