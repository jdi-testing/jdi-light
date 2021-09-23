package io.github.com.custom;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;
import io.github.com.custom.asserts.ProfileCardAssert;

public class ProfileCard extends UIBaseElement<ProfileCardAssert> {

    private static final String IMAGES_LINK = ".v-image__image--cover";

    @JDIAction("Get '{name}' 'checker' element with name")
    public UIElement getNameArea() {
        return this.find(".v-list-item__title");
    }

    @JDIAction("Get '{name}' element with job function")
    public UIElement getJobFunctionArea() {
        return this.find(".v-list-item__subtitle");
    }

    @JDIAction("Get '{name}' background image element")
    public UIElement getBackgroundImage() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> finds(IMAGES_LINK).get(1).isDisplayed());
        return this.finds(IMAGES_LINK).get(1);
    }

    @JDIAction("Get '{name}' avatar image element")
    public UIElement getAvatarImage() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> finds(IMAGES_LINK).get(2).isDisplayed());
        return this.finds(IMAGES_LINK).get(2);
    }

    @JDIAction("Does profile card has avatar image")
    public boolean hasAvatarImage() {
        new Timer(base().getTimeout() * 1000L)
            .wait(() -> finds(IMAGES_LINK).get(2).isDisplayed());
        return getAvatarImage().getAttribute("style").contains("url");
    }

    @JDIAction("Does profile card has background image")
    public boolean hasBackgroundImage() {
        new Timer(base().getTimeout() * 1000L)
            .wait(() -> finds(IMAGES_LINK).get(1).isDisplayed());
        return getBackgroundImage().getAttribute("style").contains("url");
    }

    @JDIAction("Does profile card has proper text in 'name' text field")
    public String hasProperName() {
        return getNameArea().getText();
    }

    @JDIAction("Does profile card has proper text in 'job function' text field")
    public String hasProperJobFunction() {
        return getJobFunctionArea().getText();
    }

    public void scrollIntoView() {
        new Timer(base().getTimeout() * 2000L)
            .wait(() -> finds(IMAGES_LINK).isDisplayed());
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public ProfileCardAssert is() {
        return new ProfileCardAssert().set(this);
    }

    public ProfileCardAssert has() {
        return this.is();
    }
}
