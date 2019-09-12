package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.DataList;
import cucumber.api.java.en.Then;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DataListSteps {
    public static DataList dataList(String name) { return getUI(name, DataList.class); }

    @Then("^the \"([^\"]*)\" datalist selected value is \"([^\"]*)\"$")
    public void datalistSelectedValue(String name, String value) {
        assertThat(dataList(name).selected(), is(value));
    }
}
