package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.SlideGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import org.openqa.selenium.WebElement;

/**
 * To see an example of SlideGroup web element please visit https://v2.vuetifyjs.com/en/components/slide-groups/
 */
public class SlideGroup extends UIBaseElement<SlideGroupAssert> implements HasIcon, HasTheme {

    @JDIAction("Get '{name}'s 'next slides' button")
    public VuetifyButton nextButton() {
        return new VuetifyButton(core().find(".v-slide-group__next"));
    }

    @JDIAction("Get '{name}'s 'previous slides' button")
    public VuetifyButton previousButton() {
        return new VuetifyButton(core().find(".v-slide-group__prev"));
    }

    @JDIAction("Get '{name}' slide by index")
    public Card slideByIndex(int index) {
        return this.slides().get(index).with(Card.class);
    }

    @JDIAction("Get if slide is selected in {name}")
    public boolean slideIsSelected(int index) {
        String cardClass = slideByIndex(index).core().getAttribute("class");
        return cardClass.contains("success") || cardClass.contains("active");
    }

    @JDIAction("Click on 'next slides' button")
    public boolean isNextButtonDisabled() {
        return nextButton().hasClass("v-slide-group__next--disabled");
    }

    @JDIAction("Click on 'next slides' button")
    public boolean isNextButtonActive() {
        return !isNextButtonDisabled();
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean isPreviousButtonDisabled() {
        return previousButton().hasClass("v-slide-group__prev--disabled");
    }

    // @todo #5318 Slides can be not only v-cards, but any element,
    //  we should receive childs for .v-slide-group__content
    //  Check the page from the header, there is an example with buttons
    @JDIAction("Get {name}'s slides")
    public WebList slides() {
        return core().finds(".v-card");
    }

    @JDIAction("Get position of the '{name}'")
    public int position() {
        int index = 0;
        for (WebElement slideCard : slides()) {
            index++;
            if (slideCard.getAttribute("class").contains("active")) {
                return index;
            }
        }
        return -1;
    }

    public SlideGroupAssert is() {
        return new SlideGroupAssert().set(this);
    }

    public SlideGroupAssert has() {
        return this.is();
    }
}
