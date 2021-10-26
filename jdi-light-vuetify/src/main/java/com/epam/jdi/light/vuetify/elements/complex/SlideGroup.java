package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.SlideGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.tools.Timer;

/**
 * To see an example of SlideGroup web element please visit https://vuetifyjs.com/en/components/slide-groups/
 */

public class SlideGroup extends UIBaseElement<SlideGroupAssert> {

    @JDIAction("Get '{name}'s 'next slides' button")
    private Button getNextButton() {
        return new Button(find(".v-slide-group__next"));
    }

    @JDIAction("Get '{name}'s 'previous slides' button")
    private Button getPreviousButton() {
        return new Button(find(".v-slide-group__prev"));
    }

    @JDIAction("Get '{name}' position of visible slides")
    public String slidesPosition() {
        return this.find(".v-slide-group__content").getAttribute("style");
    }

    @JDIAction("Get '{name}' slide by index")
    private UIElement getSlideByIndex(int index) {
        return this.finds(".v-card").get(index);
    }

    @JDIAction("Slide is selected")
    public boolean slideIsSelected(int index) {
        return getSlideByIndex(index).getAttribute("class").contains("success")
                || getSlideByIndex(index).getAttribute("class").contains("active");
    }

    @JDIAction("Click on 'slide' {0}")
    public void clickOnSlideByIndex(int index) {
        getSlideByIndex(index).click();
    }

    @JDIAction("Click on 'next slides' button")
    public void clickOnNextButton() {
        getNextButton().click();
    }

    @JDIAction("Click on 'next slides' button")
    public boolean nextButtonIsDisabled() {
        return getNextButton().core().getAttribute("class").contains("disabled");
    }

    @JDIAction("Click on 'next slides' button")
    public boolean nextButtonIsActive() {
        return !nextButtonIsDisabled();
    }

    @JDIAction("Click on 'previous slides' button")
    public void clickOnPreviousButton() {
        getPreviousButton().click();
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean previousButtonIsDisabled() {
        return getPreviousButton().core().getAttribute("class").contains("disabled");
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean previousButtonIsActive() {
        return !previousButtonIsDisabled();
    }

    public void startTest() {
        clickOnNextButton();
        clickOnPreviousButton();
        Timer.waitCondition(() -> slidesPosition().equals("transform: translateX(0px);"));
    }

    public SlideGroupAssert is() {
        return new SlideGroupAssert().set(this);
    }

    public SlideGroupAssert has() {
        return this.is();
    }
}
