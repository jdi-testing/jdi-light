package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.Conditions;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.By;

public class ProfileCard extends Section {

    public static final String PROFILE_CARD_LOCATOR = "//div[@id = 'profileCard']";
    private static final String BACKGROUND_IMAGE_LOCATOR = PROFILE_CARD_LOCATOR + "/div/div/div[contains(@class, 'v-image')]";
    private static final String AVATAR_IMAGE_LOCATOR = PROFILE_CARD_LOCATOR + "//div[contains(@class, 'v-avatar')]//div[contains(@class, 'image--cover')]";
    private static final String NAME_AREA_LOCATOR = PROFILE_CARD_LOCATOR + "//div[@class = 'v-list-item__title text-h6']";
    private static final String JOB_FUNCTION_AREA_LOCATOR = PROFILE_CARD_LOCATOR + "//div[@class = 'v-list-item__subtitle']";

    @JDIAction("Does profile card has avatar photo")
    public boolean hasAvatarPhoto() {
        return avatarImage().getAttribute("style").contains("background-image");
    }

    @JDIAction("Does profile card has background photo")
    public boolean hasBackgroundPhoto() {
        return backgroundImage().getAttribute("style").contains("background-image");
    }

    @JDIAction("Does profile card has proper text in 'name' text field")
    public boolean hasProperName(String text) {
        return nameArea().getText().equals(text);
    }

    @JDIAction("Does profile card has proper text in 'job function' text field")
    public boolean hasProperJobFunction(String text) {
        return jobFunctionArea().getText().equals(text);
    }

    public void waitUntilImagesAreDisplayed() {
        backgroundImage().waitFor(Conditions.containsAttribute("style", "background-image"));
        avatarImage().waitFor(Conditions.containsAttribute("style", "background-image"));
    }

    protected UIElement nameArea() {
        return new UIElement(By.xpath(NAME_AREA_LOCATOR));
    }

    protected UIElement jobFunctionArea() {
        return new UIElement(By.xpath(JOB_FUNCTION_AREA_LOCATOR));
    }

    protected UIElement backgroundImage() {
        return new UIElement(By.xpath(BACKGROUND_IMAGE_LOCATOR));
    }

    protected UIElement avatarImage() {
        return new UIElement(By.xpath(AVATAR_IMAGE_LOCATOR));
    }
}
