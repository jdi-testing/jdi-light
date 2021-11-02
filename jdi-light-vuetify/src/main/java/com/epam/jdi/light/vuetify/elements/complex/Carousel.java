package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.tools.Timer;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/carousels/
 */

public class Carousel extends UIBaseElement<CarouselAssert> {

    @JDIAction("Get '{name}'s delimiters")
    private List<Button> getDelimiters() {
        return finds(".v-carousel__controls .v-btn").stream().map(this::castToButton).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}'s 'next' button")
    private Button getNextButton() {
        return castToButton(find(".v-window__next button"));
    }

    @JDIAction("Get '{name}'s 'previous' button")
    public Button getPreviousButton() {
        return castToButton(find(".v-window__prev button"));
    }

    @JDIAction("Get '{name}'s current slide")
    private UIElement getCurrentSlide() {
        return find(".v-window-item");
    }

    @JDIAction("Get '{name}'s switch")
    private Switch getSwitch() {
        return castToSwitch(find(".v-input--selection-controls__input"));
    }

    @JDIAction("'{name}' has delimiters icons")
    public boolean hasDelimitersIcons(String iconName) {
        return getDelimiters().stream().allMatch(e -> e.find("i").getAttribute("class").contains(iconName));
    }

    @JDIAction("'{name}' has 'next' button visible")
    public boolean hasVisibleNextButton() {
        return getNextButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'previous' button visible")
    public boolean hasVisiblePreviousButton() {
        return getPreviousButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'next' button hidden")
    public boolean hasHiddenNextButton() {
        return !getNextButton().core().isClickable();
    }

    @JDIAction("'{name}' has 'previous' button hidden")
    public boolean hasHiddenPreviousButton() {
        return !getPreviousButton().core().isClickable();
    }

    @JDIAction("'{name}' has no control buttons")
    public boolean hasNoControlButtons() {
        return getNextButton().isNotExist() && getPreviousButton().isNotExist();
    }

    @JDIAction("Get '{name}'s 'next' button text")
    public String nextButtonText() {
        return getNextButton().core().getText();
    }

    @JDIAction("Get '{name}'s 'previous' button text")
    public String previousButtonText() {
        return getPreviousButton().core().getText();
    }

    @JDIAction("Get '{name}'s 'next' button color")
    public String nextButtonColor() {
        return getNextButton().core().getCssValue("background-color");
    }

    @JDIAction("Get '{name}'s 'previous' button color")
    public String previousButtonColor() {
        return getPreviousButton().core().getCssValue("background-color");
    }

    @JDIAction("Get '{name}'s current slide color")
    public String currentSlideColor() {
        return getCurrentSlide().find(".v-sheet").getCssValue("background-color");
    }

    @JDIAction("Get '{name}'s current slide text")
    public String currentSlideText() {
        return getCurrentSlide().find(".text-h2").getText();
    }

    @JDIAction("Get '{name}'s current slide background image")
    public String currentSlideBackgroundImage() {
        return getCurrentSlide().find(".v-image__image").getCssValue("background-image");
    }

    @JDIAction("Get '{name}'s slide counter")
    public String slideCounter() {
        return find("div.justify-space-around").getText();
    }

    @JDIAction("'{name}'s has number of delimiters")
    public int hasNumberOfDelimiters() {
        return getDelimiters().size();
    }

    @JDIAction("'{name}' has delimiters hidden")
    public boolean hasHiddenDelimiters() {
        return getDelimiters().stream().allMatch(ICoreElement::isHidden);
    }

    @JDIAction("'{name}' has switch")
    public boolean hasSwitch() {
        return getSwitch().isDisplayed();
    }

    @JDIAction("'{name}' has checked switch")
    public boolean hasCheckedSwitch() {
        return getSwitch().isChecked();
    }

    @JDIAction("'{name}' has unchecked switch")
    public boolean hasUncheckedSwitch() {
        return getSwitch().isNotChecked();
    }

    @JDIAction("Go to slide number {0}")
    public void goToSlide(int slideNumber) {
        getDelimiters().get(slideNumber - 1).click();
    }

    @JDIAction("Click on 'next' button")
    public void clickOnNextButton() {
        getNextButton().click();
    }

    @JDIAction("Click on 'previous' button")
    public void clickOnPreviousButton() {
        getPreviousButton().click();
    }

    @JDIAction("Check switch")
    public void checkSwitch() {
        getSwitch().check();
    }

    @JDIAction("Uncheck switch")
    public void uncheckSwitch() {
        getSwitch().uncheck();
    }

    @JDIAction("Click on 'plus' button")
    public void clickOnPlusButton() {
        castToButton(find("div.justify-space-around button.mdi-plus")).click(TOP_LEFT);
    }

    @JDIAction("Click on 'minus' button")
    public void clickOnMinusButton() {
        castToButton(find("div.justify-space-around button.mdi-minus")).click(TOP_LEFT);
    }

    public void waitUntilSlideAutomaticallyChangeTo(String text, String color) {
        Timer.waitCondition(() -> currentSlideText().equals(text));
        Timer.waitCondition(() -> currentSlideColor().equals(color));
    }

    private Button castToButton(UIElement element) {
        return new Button(element);
    }

    private Switch castToSwitch(UIElement element) {
        return new Switch().setCore(Switch.class, element);
    }

    public CarouselAssert is() {
        return new CarouselAssert().set(this);
    }

    public CarouselAssert has() {
        return this.is();
    }
}
