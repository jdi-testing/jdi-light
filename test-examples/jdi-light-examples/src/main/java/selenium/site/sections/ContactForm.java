package selenium.site.sections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.site.data.ContactInfo;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContactForm {
    @FindBy(id = "name") WebElement name;
    @FindBy(id = "last-name") WebElement lastName;
    @FindBy(id = "position") WebElement position;
    @FindBy(id = "passport-number") WebElement passportNumber;
    @FindBy(id = "passport-seria") WebElement passportSeria;
    @FindBy(id = "passport") WebElement passport;
    // Dropdown
    @FindBy(id = "gender") WebElement genderExpand;
    @FindBy(id = "gender") List<WebElement> genderList;
    @FindBy(id = "gender") WebElement genderValue;
    // Combobox
    @FindBy(id = "religion") WebElement religion;
    // MultiDropdown
    @FindBy(id = "gender") WebElement weatherExpand;
    @FindBy(id = "gender") List<WebElement> weatherList;
    @FindBy(id = "gender") WebElement weatherValue;

    @FindBy(id = "accept-conditions") WebElement acceptConditions;
    @FindBy(id = "description") WebElement description;

    @FindBy(css = "#contact-form [type=submit]") WebElement submit;

    public void submit(ContactInfo contact) {
        // TextFields
        if (contact.name != null) {
            name.clear();
            name.sendKeys(contact.name);
        }
        if (contact.lastName != null) {
            lastName.clear();
            lastName.sendKeys(contact.lastName);
        }
        if (contact.position != null) {
            position.clear();
            position.sendKeys(contact.position);
        }
        if (contact.passportNumber != null) {
            passportNumber.clear();
            passportNumber.sendKeys(contact.passportNumber.toString());
        }
        if (contact.passportSeria != null) {
            passportSeria.clear();
            passportSeria.sendKeys(contact.passportSeria.toString());
        }
        // Dropdown
        if (contact.gender != null) {
            genderExpand.click();
            for (WebElement value : genderList)
                if (value.getText().equals(contact.gender)) {
                    value.click();
                    break;
                }
        }
        // Combobox
        if (contact.religion != null) {
            religion.clear();
            religion.sendKeys(contact.religion);
        }
        // MultiDropdown
        if (contact.weather != null) {
            weatherExpand.click();
            List<String> split = asList(contact.weather.split(","));
            for (WebElement value : weatherList)
                if (split.contains(value.getText())) {
                    value.click();
                }
        }
        // Checkboxes
        if (contact.passport != null && (
            contact.passport && !passport.isSelected() ||
            !contact.passport && passport.isSelected()))
                passport.click();
        if (contact.acceptConditions != null && (
            contact.acceptConditions && !acceptConditions.isSelected() ||
            !contact.acceptConditions && acceptConditions.isSelected()))
                acceptConditions.click();
        // TextArea
        if (contact.description != null) {
            description.clear();
            description.sendKeys(contact.description);
        }
        submit.click();
    }
    public void check(ContactInfo contact) {
        // TextFields
        if (contact.name != null)
            assertThat(name.getText(), is(contact.name));
        if (contact.lastName != null)
            assertThat(lastName.getText(), is(contact.lastName));
        if (contact.position != null)
            assertThat(position.getText(), is(contact.position));
        if (contact.passportNumber != null)
            assertThat(passportNumber.getText(), is(contact.passportNumber));
        if (contact.passportSeria != null)
            assertThat(passportSeria.getText(), is(contact.passportSeria));
        // Dropdown
        if (contact.gender != null)
            assertThat(genderValue.getText(), is(contact.gender));
        // Combobox
        if (contact.religion != null)
            assertThat(religion.getText(), is(contact.religion));
        // MultiDropdown
        if (contact.weather != null)
            assertThat(weatherValue.getText(), is(contact.weather));
        // Checkboxes
        if (contact.passport != null)
            assertThat(passport.isSelected(), is(contact.passport));
        if (contact.acceptConditions != null)
            assertThat(acceptConditions.isSelected(), is(contact.acceptConditions));
        // TextArea
        if (contact.description != null)
            assertThat(description.getText(), is(contact.description));
    }

}
