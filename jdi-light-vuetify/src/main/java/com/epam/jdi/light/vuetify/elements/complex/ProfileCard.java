package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.Conditions;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ProfileCardAssert;
import org.openqa.selenium.By;

import static com.epam.jdi.light.vuetify.elements.complex.data.ProfileCardLocator.PROFILE_CARD_LOCATOR;

public class ProfileCard extends UIBaseElement<ProfileCardAssert> {

    public String profileCardLocator = PROFILE_CARD_LOCATOR;
    public String backgroundImageLocator = profileCardLocator.concat("/div/div/div[contains(@class, 'v-image')]");
    public String avatarImageLocator = profileCardLocator.concat("//div[contains(@class, 'v-avatar')]//div[contains(@class, 'image--cover')]");
    public String nameTextFieldLocator = profileCardLocator.concat("//div[@class = 'v-list-item__title text-h6']");
    public String jobFunctionTextFieldLocator = profileCardLocator.concat("//div[@class = 'v-list-item__subtitle']");

    @JDIAction("Does {name} has avatar photo")
    public boolean hasAvatarPhoto() {
        return avatarImage().getAttribute("style").contains("background-image");
    }

    @JDIAction("Does {name} has avatar background photo")
    public boolean hasBackgroundPhoto() {
        return backgroundImage().getAttribute("style").contains("background-image");
    }

    @JDIAction("Does {name} has proper text in 'name' text field")
    public boolean hasProperName(String text) {
        return nameTextField().getText().equals(text);
    }

    @JDIAction("Does {name} has proper text in 'job function' text field")
    public boolean hasProperJobFunction(String text) {
        return jobFunctionTextField().getText().equals(text);
    }

    public void waitUntilImagesAreDisplayed() {
        backgroundImage().waitFor(Conditions.containsAttribute("style", "background-image"));
        avatarImage().waitFor(Conditions.containsAttribute("style", "background-image"));
    }

    public ProfileCardAssert is() {
        return new ProfileCardAssert().set(this);
    }

    public ProfileCardAssert has() {
        return this.is();
    }

    protected UIElement backgroundImage() {
        return new UIElement(By.xpath(backgroundImageLocator));
    }

    protected UIElement avatarImage() {
        return new UIElement(By.xpath(avatarImageLocator));
    }

    protected UIElement nameTextField() {
        return new UIElement(By.xpath(nameTextFieldLocator));
    }

    protected UIElement jobFunctionTextField() {
        return new UIElement(By.xpath(jobFunctionTextFieldLocator));
    }
}
