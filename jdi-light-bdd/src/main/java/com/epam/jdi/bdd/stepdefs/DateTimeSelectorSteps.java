package com.epam.jdi.bdd.stepdefs;
import com.epam.jdi.light.ui.html.common.DateTimeSelector;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;
import static io.github.com.pages.HtmlElementsPage.birthDate;
import static io.github.com.pages.HtmlElementsPage.monthDate;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DateTimeSelectorSteps {

    @Then("^\"([^\"]*)\" value is \"([^\"]*)\"$")
    public void valueIs(String element_name, String date){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(dateTimeSelector.value(), date);
    }

    @Then("^\"([^\"]*)\" label is \"([^\"]*)\"$")
    public void labelIs(String element_name, String label_name){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(dateTimeSelector.labelText(), label_name);
    }

    @Then("^\"([^\"]*)\" min is \"([^\"]*)\"$")
    public void minIs(String element_name, String date){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(dateTimeSelector.min(), date);
    }

    @And("^\"([^\"]*)\" max is \"([^\"]*)\"$")
    public void maxIs(String element_name, String date){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(dateTimeSelector.max(), date);
    }

    @Then("^\"([^\"]*)\" date is \"([^\"]*)\"$")
    public void dateIs(String element_name, String date){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.is().date(equalToIgnoringCase(date));
    }

    @And("^\"([^\"]*)\" label ignoring case is \"([^\"]*)\"$")
    public void labelIgnoringCaseIs(String element_name, String label) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.label().is().text(equalToIgnoringCase(label));
    }

    @Then("^\"([^\"]*)\" contains \"([^\"]*)\" value$")
    public void containsValue(String element_name, String value){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.assertThat().date(containsString(value));
    }

    @Then("^I set date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSetDate(String date, String element_name){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.setDateTime(date);
        assertEquals(dateTimeSelector.value(), date);

    }

    @And("^\"([^\"]*)\" is enabled$")
    public void isEnabled(String element_name){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.is().enabled();;
    }

    @Then("^\"([^\"]*)\" label contains \"([^\"]*)\"$")
    public void labelContains(String element_name, String label_part){
        DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.label().is().text(containsString(label_part));
    }
}
