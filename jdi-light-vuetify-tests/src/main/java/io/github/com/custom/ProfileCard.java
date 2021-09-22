package io.github.com.custom;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.init.JDITalk.element;

public class ProfileCard extends Section {

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
        return this.finds(".v-image__image--cover").get(1);
    }

    @JDIAction("Get '{name}' avatar image element")
    public UIElement getAvatarImage() {
        return this.finds(".v-image__image--cover").get(2);
    }

    @JDIAction("Does profile card has avatar photo")
    public boolean hasAvatarPhoto() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.getAvatarImage().isDisplayed());
        return getAvatarImage().getAttribute("style").contains("url");
    }

    @JDIAction("Does profile card has background photo")
    public boolean hasBackgroundPhoto() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.getBackgroundImage().isDisplayed());
        return getBackgroundImage().getAttribute("style").contains("url");
    }

    @JDIAction("Does profile card has proper text in 'name' text field")
    public boolean hasProperName(String text) {
        return getNameArea().getText().equals(text);
    }

    @JDIAction("Does profile card has proper text in 'job function' text field")
    public boolean hasProperJobFunction(String text) {
        return getJobFunctionArea().getText().equals(text);
    }

}
