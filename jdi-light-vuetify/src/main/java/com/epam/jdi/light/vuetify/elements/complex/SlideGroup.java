package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.SlideGroupAssert;

/**
 * To see an example of SlideGroup web element please visit https://vuetifyjs.com/en/components/slide-groups/
 */

public class SlideGroup extends UIBaseElement<SlideGroupAssert> {

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
        find(".v-slide-group__next").click();
    }

    @JDIAction("Click on 'previous slides' button")
    public void clickOnPreviousButton() {
        find(".v-slide-group__prev").click();
    }

    public SlideGroupAssert is() {
        return new SlideGroupAssert().set(this);
    }

    public SlideGroupAssert has() {
        return this.is();
    }
}
