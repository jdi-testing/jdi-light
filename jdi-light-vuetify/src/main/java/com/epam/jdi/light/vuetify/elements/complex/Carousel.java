package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/carousels/
 */

public class Carousel extends UIBaseElement<CarouselAssert> {

    @JDIAction("Get '{name}' delimiters")
    private WebList getDelimiters() {
        return this.finds("div.v-carousel__controls i");
    }

    @JDIAction("Get '{name}' 'next' button")
    private UIElement getNextButton() {
        return this.find(".v-window__next button");
    }

    @JDIAction("Get '{name}' 'previous'")
    private UIElement getPreviousButton() {
        return this.find(".v-window__prev button");
    }

    @JDIAction("Get '{name}' current slide")
    private UIElement getCurrentSlide() {
        return this.find(".v-window-item");
    }

    @JDIAction("Get '{name}' toggle button")
    private UIElement getToggle() {
        return this.find(".v-input--selection-controls__input");
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

    @JDIAction("Get '{name}' 'next' button text")
    public String nextButtonText() {
        return this.getNextButton().getText();
    }

    @JDIAction("Get '{name}' 'previous' button text")
    public String previousButtonText() {
        return this.getPreviousButton().getText();
    }

    @JDIAction("Get '{name}' 'next' button color")
    public String nextButtonColor() {
        return this.getNextButton().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' 'previous' button color")
    public String previousButtonColor() {
        return this.getPreviousButton().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' current slide color")
    public String currentSlideColor() {
        return getCurrentSlide().find(".v-sheet").getCssValue("background-color");
    }

    @JDIAction("Get '{name}' current slide text")
    public String currentSlideText() {
        return getCurrentSlide().find(".text-h2").getText();
    }

    @JDIAction("Get '{name}' current slide background image")
    public String currentSlideBackgroundImage() {
        return getCurrentSlide().find(".v-image__image").getCssValue("background-image");
    }

    @JDIAction("Get '{name}' slide counter")
    public String slideCounter() {
        return this.find("div.justify-space-around").getText();
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

    @JDIAction("Go to slide number {0}")
    public void goToSlide(int slideNumber) {
        getDelimiters().get(slideNumber).click();
    }

    @JDIAction("Click on 'next' button")
    public void clickOnNextButton() {
        getNextButton().click();
    }

    @JDIAction("Click on 'previous' button")
    public void clickOnPreviousButton() {
        getPreviousButton().click();
    }

    @JDIAction("Click on 'previous' button")
    public void checkToggle() throws Exception {
        if(hasToggleUnchecked()) {
            getToggle().click();
        } else throw new Exception("Toggle is already checked");
    }

    @JDIAction("Click on 'previous' button")
    public void uncheckToggle() throws Exception {
        if(hasToggleChecked()) {
            getToggle().click();
        } else throw new Exception("Toggle is already unchecked");
    }

    @JDIAction("Click on 'plus' button")
    public void clickOnPlusButton() {
        this.find("div.justify-space-around button.mdi-plus").click(TOP_LEFT);
    }

    @JDIAction("Click on 'minus' button")
    public void clickOnMinusButton() {
        this.find("div.justify-space-around button.mdi-minus").click(TOP_LEFT);
    }

    public void waitUntilSlideAutomaticallyChangeTo(String text, String color) {
        Timer.waitCondition(() -> this.currentSlideText().equals(text));
        Timer.waitCondition(() -> this.currentSlideColor().equals(color));
    }

    public CarouselAssert is() {
        return new CarouselAssert().set(this);
    }

    public CarouselAssert has() {
        return this.is();
    }
}
