package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see an example of Banner web element please visit https://jdi-testing.github.io/jdi-light/vuetify/carousels
 *
 * From vuetify docs: "The v-carousel component is used to display large numbers of visual content on a rotating timer."
 */

public class Carousel extends UIBaseElement<CarouselAssert> {

    @JDIAction("Get '{name}' delimiters")
    public WebList getDelimiters() {
        return this.finds("div.v-carousel__controls i");
    }

    @JDIAction("Get '{name}' 'next' button")
    public UIElement getNextButton() {
        return this.find(".v-window__next button");
    }

    @JDIAction("Get '{name}' 'previous'")
    public UIElement getPreviousButton() {
        return this.find(".v-window__prev button");
    }

    @JDIAction("Get '{name}' 'next' button text")
    public String getNextButtonText() {
        return this.getNextButton().getText();
    }

    @JDIAction("Get '{name}' 'previous' button text")
    public String getPreviousButtonText() {
        return this.getPreviousButton().getText();
    }

    @JDIAction("Get '{name}' 'next' button color")
    public String getNextButtonColor() {
        return this.getNextButton().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' 'previous' button color")
    public String getPreviousButtonColor() {
        return this.getPreviousButton().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' current slide")
    public UIElement getCurrentSlide() {
        return this.find(".v-window-item");
    }

    @JDIAction("Get '{name}' current slide color")
    public String getCurrentSlideColor() {
        return getCurrentSlide().find(".v-sheet").getCssValue("background-color");
    }

    @JDIAction("Get '{name}' current slide text")
    public String getCurrentSlideText() {
        return getCurrentSlide().find(".text-h2").getText();
    }

    @JDIAction("Get '{name}' current slide background image")
    public String getCurrentSlideBackgroundImage() {
        return getCurrentSlide().find(".v-image__image").getCssValue("background-image");
    }

    @JDIAction("Get '{name}' toggle button")
    public UIElement getToggle() {
        return this.find(".v-input--selection-controls__input");
    }

    @JDIAction("Get '{name}' minus button")
    public UIElement getMinusButton() {
        return this.find("div.justify-space-around button.mdi-minus");
    }

    @JDIAction("Get '{name}' plus button")
    public UIElement getPlusButton() {
        return this.find("div.justify-space-around button.mdi-plus");
    }

    @JDIAction("Get '{name}' slide counter")
    public String getSlideCounter() {
        return this.find("div.justify-space-around").getText();
    }

    @JDIAction("'{name}' has delimiters icons")
    public boolean hasDelimitersIcons(String iconName) {
        Timer.waitCondition(getDelimiters()::isDisplayed);
        return getDelimiters().stream().allMatch(e -> e.getAttribute("class").contains(iconName));
    }

    @JDIAction("'{name}' has 'next' button visible")
    public boolean hasNextButtonVisible() {
        return getNextButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'previous' button visible")
    public boolean hasPreviousButtonVisible() {
        return getPreviousButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'next' button hidden")
    public boolean hasNextButtonHidden() {
        return getNextButton().isHidden();
    }

    @JDIAction("'{name}' has 'previous' button hidden")
    public boolean hasPreviousButtonHidden() {
        return getPreviousButton().isHidden();
    }

    @JDIAction("'{name}' has number of delimiters")
    public int hasNumberOfDelimiters() {
        return getDelimiters().size();
    }

    @JDIAction("'{name}' has delimiters hidden")
    public boolean hasDelimitersHidden() {
        return getDelimiters().isHidden();
    }

    @JDIAction("'{name}' has toggle button")
    public boolean hasToggle() {
        Timer.waitCondition(getToggle()::isDisplayed);
        return getToggle().isDisplayed();
    }

    @JDIAction("'{name}' has toggle button checked")
    public boolean hasToggleChecked() {
        return getToggle().find("input").getAttribute("aria-checked").equals("true");
    }

    @JDIAction("'{name}' has toggle button unchecked")
    public boolean hasToggleUnchecked() {
        return getToggle().find("input").getAttribute("aria-checked").equals("false");
    }

    @JDIAction("'{name}' has 'minus' button")
    public boolean hasMinusButton() {
        return getMinusButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'plus' button")
    public boolean hasPlusButton() {
        return getPlusButton().isDisplayed();
    }

    public void waitUntilSlideAutomaticallyChangeTo(String text, String color) {
        Timer.waitCondition(() -> this.getCurrentSlideText().equals(text));
        Timer.waitCondition(() -> this.getCurrentSlideColor().equals(color));
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public CarouselAssert is() {
        return new CarouselAssert().set(this);
    }

    public CarouselAssert has() {
        return this.is();
    }
}
