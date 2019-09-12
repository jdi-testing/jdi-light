package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.DataList;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DataListSteps {

    @Then("^the \"([^\"]*)\" datalist selected value is \"([^\"]*)\"$")
    public void datalistSelectedValue(String name, String value) {
        DataList datalist = getUI(name, DataList.class);
        assertThat(datalist.selected(), is(value));
    }
}
