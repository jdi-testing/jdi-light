package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.DateTimeSelector;
import com.epam.jdi.light.ui.html.common.FileInput;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;
import static io.github.com.pages.HtmlElementsPage.partyTime;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DateTimeSteps {
    @Given("^I see \"([^\"]*)\" input type datetime on the page$")
    public void iSeeFieldOnTheHtmlPage(String name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(name).get(0);
    }
    @And("^I see date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iGetDate(String date, String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(partyTime.value(), date);
    }

    @And("^label of DateTimeSelector is \"([^\"]*)\" in \"([^\"]*)\"$")
    public void labelOfDateTimeSelectorIs(String labelname,  String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(partyTime.labelText(), labelname);
    }

    @And("^I get attribute with name min \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iGetAttributeWithNameMin(String date, String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(partyTime.min(), date);       
    }

    @And("^I get attribute with name max \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iGetGetAttributeWithNameMax(String date, String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(partyTime.max(), date);
    }

    @Then("^I set date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSetDate(String date, String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        partyTime.setDateTime(date);
        partyTime.show();
        assertEquals(partyTime.value(), date);
    }

    @And("^I find label by \"([^\"]*)\" or \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iTestThatLabelOr(String label, String label_lower, String element_name)  {
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        partyTime.label().assertThat().text(is(label));
        partyTime.label().is().text(equalToIgnoringCase(label_lower));
    }

    @And("^I validate date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iValidateDate(String date, String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        partyTime.is().date(equalToIgnoringCase(date));
        partyTime.is().enabled();;
    }
    @And("^I check that date is \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iCheckThatYearIs(String year, String element_name){
        DateTimeSelector partyTime = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        partyTime.assertThat().date(containsString(year));
    }


}
