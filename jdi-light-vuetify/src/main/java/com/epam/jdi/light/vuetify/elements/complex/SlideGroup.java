package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.SlideGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * To see an example of SlideGroup web element please visit https://v2.vuetifyjs.com/en/components/slide-groups/
 */

public class SlideGroup extends UIBaseElement<SlideGroupAssert> implements HasIcon, HasTheme {

    @JDIAction("Get '{name}'s 'next slides' button")
    public VuetifyButton getNextButton() {
        return new VuetifyButton(core().find(".v-slide-group__next"));
    }

    @JDIAction("Get '{name}'s 'previous slides' button")
    public VuetifyButton getPreviousButton() {
        return new VuetifyButton(core().find(".v-slide-group__prev"));
    }

    @JDIAction("Get '{name}' slide by index")
    public Card slideByIndex(int index) {
        return this.finds(".v-card").get(index).with(Card.class);
    }

    @JDIAction("Get if slide is selected in {name}")
    public boolean slideIsSelected(int index) {
        String cardClass = slideByIndex(index).core().getAttribute("class");
        return cardClass.contains("success") || cardClass.contains("active");
    }

    @JDIAction("Click on 'next slides' button")
    public void clickOnNextButton() {
        getNextButton().click();
    }

    @JDIAction("Click on 'next slides' button")
    public boolean isNextButtonDisabled() {
        return getNextButton().hasClass("v-slide-group__next--disabled");
    }

    @JDIAction("Click on 'next slides' button")
    public boolean isNextButtonActive() {
        return !isNextButtonDisabled();
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean isPreviousButtonDisabled() {
        return getPreviousButton().hasClass("v-slide-group__prev--disabled");
    }

    public WebList getSlides() {
        return this.finds(".v-card");
    }

    @JDIAction("Get position of the '{name}'")
    public int position() {
        int index = 0;
        for (WebElement slideCard : getSlides()) {
            index++;
            if (slideCard.getAttribute("class").contains("active")) {
                return index;
            }
        }
        return -1;
    }

    public List<WebElement> getAllSlides(By by) {
        return core().findElements(by);
    }

    public SlideGroupAssert is() {
        return new SlideGroupAssert().set(this);
    }

    public SlideGroupAssert has() {
        return this.is();
    }
}
