package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class Carousel extends UIBaseElement<CarouselAssert> {

    @JDIAction("Get '{name}' icon")
    public WebList getDelimiters() {
        return this.finds("div.v-carousel__controls i");
    }

    @JDIAction("Get '{name}' icon")
    public UIElement getNextButton() {
        return this.find(".v-window__next button");
    }

    @JDIAction("Get '{name}' icon")
    public UIElement getPreviousButton() {
        return this.find(".v-window__prev button");
    }

    @JDIAction("Get '{name}' icon")
    public UIElement getCurrentSlide() {
        return this.find(".v-window-item");
    }

    @JDIAction("Get '{name}' icon")
    public String getCurrentSlideColor() {
        return getCurrentSlide().find(".v-sheet").getCssValue("background-color");
    }

    @JDIAction("Get '{name}' icon")
    public String getCurrentSlideText() {
        return getCurrentSlide().find(".text-h2").getText();
    }

    @JDIAction("Get '{name}' icon")
    public String getCurrentBackgroundImage() {
        return getCurrentSlide().find(".v-image__image").getCssValue("background-image");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getToggle() {
        return this.find(".v-input--selection-controls__input");
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasDelimitersIcons(String iconName) {
        Timer.waitCondition(getDelimiters()::isDisplayed);
        return getDelimiters().stream().allMatch(e -> e.getAttribute("class").contains(iconName));
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasNextButtonVisible() {
        return getNextButton().isDisplayed();
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasPreviousButtonVisible() {
        return getPreviousButton().isDisplayed();
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasNextButtonHidden() {
        return getNextButton().isHidden();
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasPreviousButtonHidden() {
        return getPreviousButton().isHidden();
    }

    @JDIAction("Get '{name}' icon")
    public int hasNumberOfDelimiters() {
        return getDelimiters().size();
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasToggle() {
        Timer.waitCondition(getToggle()::isDisplayed);
        return getToggle().isDisplayed();
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasToggleChecked() {
        return getToggle().find("input").getAttribute("aria-checked").equals("true");
    }

    @JDIAction("Get '{name}' icon")
    public boolean hasToggleUnchecked() {
        return getToggle().find("input").getAttribute("aria-checked").equals("false");
    }

    public void waitUntilSlideAutomaticallyChangeTo(String text, String color) {
        Timer.waitCondition(() -> this.getCurrentSlideText().equals(text));
        Timer.waitCondition(() -> this.getCurrentSlideColor().equals(color));
    }













    @JDIAction("Get '{name}' text")
    public String getText() {
        return this.find(".v-banner__text").getText();
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getButton() {
        return this.find("button");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getButtons() {
        return this.finds("button");
    }


    @JDIAction("Get '{name}' text field")
    public UIElement getTextField() {
        return this.find(".v-banner__text");
    }

    @JDIAction("{name} has 'checker' element")
    public boolean hasChecker() {
        Timer.waitCondition(getToggle()::isDisplayed);
        return getToggle().isExist();
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String checkerState() {
        return getToggle().find("input").getAttribute("aria-checked");
    }

    @JDIAction("{name} has title")
    public String hasTitle() {
        Timer.waitCondition(getTitle()::isDisplayed);
        return getTitle().text();
    }

    @JDIAction("{name} has button")
    public boolean hasButton() {
        Timer.waitCondition(getButton()::isDisplayed);
        return getButton().isDisplayed();
    }

    @JDIAction("{name} has icon")
    public boolean hasIcon() {
        Timer.waitCondition(getDelimiters()::isDisplayed);
        return getDelimiters().isExist();
    }

    @JDIAction("{name} has alert after clicking on icon")
    public String hasAlertOnIconClick() {
        return this.core().driver().switchTo().alert().getText();
    }

    @JDIAction("{name} has buttons")
    public boolean hasButtons() {
        Timer.waitCondition(getButtons()::isDisplayed);
        return getButtons().size() > 1;
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
