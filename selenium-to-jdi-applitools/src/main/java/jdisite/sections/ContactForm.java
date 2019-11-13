package jdisite.sections;

import jdisite.entities.ContactInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.String.valueOf;
import static org.testng.Assert.assertEquals;

public class ContactForm {
    @FindBy(css ="#contact-form #name") WebElement nameTextField;
    @FindBy(id = "last-name") WebElement lastNameTextField;
    @FindBy(id = "position") WebElement positionTextField;
    @FindBy(id = "passport-number") WebElement passportNumberTextField;
    @FindBy(id = "passport-seria") WebElement passportSeriaTextField;
    // Dropdown
    @FindBy(id = "gender") WebElement gender;
    private Select gender() { return new Select(gender); }
    // Combobox
    @FindBy(id = "religion") WebElement religion;
    // MultiDropdown
    @FindBy(css ="#weather .caret") WebElement weatherExpand;
    @FindBy(css ="#weather label") List<WebElement> weatherList;
    @FindBy(css ="#weather button") WebElement weatherValue;
    @FindBy(css ="#weather ul") WebElement weatherIsExpanded;
    private boolean weatherIsExpanded() {
        return weatherIsExpanded.getAttribute("style").equals("display: block;");
    }
    private void selectWeather(String value) {
        if (!weatherIsExpanded())
            weatherExpand.click();
        String[] values = value.split(", ");
        for (String val : values) {
            for (WebElement listOption : weatherList) {
                if (listOption.getText().trim().equals(val))
                    listOption.click();
            }
        }
    }
    @FindBy(id = "accept-conditions") WebElement acceptConditionsCheckbox;
    @FindBy(id = "passport") WebElement passportCheckbox;
    @FindBy(id = "description") WebElement descriptionText;
    @FindBy(css ="#contact-form [type=submit]") WebElement submitButton;
    public void submit(ContactInfo contact) {
        if (contact.name != null) {
            nameTextField.clear();
            nameTextField.sendKeys(contact.name);
        }
        if (contact.lastName != null) {
            lastNameTextField.clear();
            lastNameTextField.sendKeys(contact.lastName);
        }
        if (contact.position != null) {
            positionTextField.clear();
            positionTextField.sendKeys(contact.position);
        }
        if (contact.passportNumber != -1) {
            passportNumberTextField.clear();
            passportNumberTextField.sendKeys(valueOf(contact.passportNumber));
        }
        if (contact.passportSeria != -1) {
            passportSeriaTextField.clear();
            passportSeriaTextField.sendKeys(valueOf(contact.passportSeria));
        }
        // Dropdown
        if (contact.gender != null) {
            gender().selectByVisibleText(contact.gender);
        }
        // Combobox
        if (contact.religion != null) {
            religion.clear();
            religion.sendKeys(contact.religion);
        }
        // MultiDropdown
        if (contact.weather != null) {
            selectWeather(contact.weather);
        }
        // Checkboxes
        if (contact.passport && !passportCheckbox.isSelected() ||
                !contact.passport && passportCheckbox.isSelected())
            passportCheckbox.click();
        if (contact.acceptConditions && !acceptConditionsCheckbox.isSelected() ||
                !contact.acceptConditions && acceptConditionsCheckbox.isSelected())
            acceptConditionsCheckbox.click();
        // TextArea
        if (contact.description != null) {
            descriptionText.clear();
            descriptionText.sendKeys(contact.description);
        }
        submitButton.click();
    }
    public void check(ContactInfo contact) {
        // TextFields
        if (contact.name != null)
            assertEquals(nameTextField.getAttribute("value"), contact.name);
        if (contact.lastName != null)
            assertEquals(lastNameTextField.getAttribute("value"), contact.lastName);
        if (contact.position != null)
            assertEquals(positionTextField.getAttribute("value"), contact.position);
        if (contact.passportNumber != -1)
            assertEquals(passportNumberTextField.getAttribute("value"), valueOf(contact.passportNumber));
        if (contact.passportSeria != -1)
            assertEquals(passportSeriaTextField.getAttribute("value"), valueOf(contact.passportSeria));
        // Dropdown
        if (contact.gender != null)
            assertEquals(gender().getFirstSelectedOption().getText(), contact.gender);
        // Combobox
        if (contact.religion != null)
            assertEquals(religion.getAttribute("value"), contact.religion);
        // MultiDropdown
        if (contact.weather != null)
            assertEquals(weatherValue.getText(), contact.weather);
        // Checkboxes
        assertEquals(passportCheckbox.isSelected(), contact.passport);
        assertEquals(acceptConditionsCheckbox.isSelected(), contact.acceptConditions);
        // TextArea
        if (contact.description != null)
            assertEquals(descriptionText.getAttribute("value"), contact.description);
    }
}