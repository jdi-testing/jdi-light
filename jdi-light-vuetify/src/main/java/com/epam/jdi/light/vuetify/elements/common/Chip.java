package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

/**
 * To see an example of Chip web element please visit https://vuetifyjs.com/en/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> {

    private static final String TEXT = ".v-chip__content";
    private static final String CLOSE_BUTTON = "span button[aria-label='Close']";
    private static final String FILTER = "span .v-chip__filter";
    private static final String ICON = "span .v-icon";
    private static final String IMAGE = "span .v-image__image";

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @JDIAction("Get {name}'s text")
    public String getText() {
        return this.find(TEXT).getText();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        this.find(CLOSE_BUTTON).click();
    }

    @JDIAction("Drag '{name}' and drop it to ({0}, {1})")
    public void dragAndDropToElement(UIElement destination) {
//        Actions actions = new Actions(getDriver());
////        actions.dragAndDrop(this.find(TEXT).core().getWebElement(), destination.core().getWebElement());
////        actions.build().perform();
//        int x = destination.core().getWebElement().getLocation().x;
//        int y = destination.core().getWebElement().getLocation().y;
//        actions.moveToElement(this.core().getWebElement())
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(this.core().getWebElement())
//                .pause(Duration.ofSeconds(1))
//                .moveByOffset(x, y)
//                .moveToElement(destination)
//                .moveByOffset(x,y)
//                .pause(Duration.ofSeconds(1))
//                .release().build().perform();
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasFilter() {
        return this.find(FILTER).isExist();
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasIcon() {
        return this.find(ICON).isExist();
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasImage() {
        return this.find(IMAGE).isExist();
    }

    @JDIAction("Get {name}'s height")
    public String getHeight() {
        return this.css("height");
    }

    @JDIAction("Get {name}'s font size")
    public String getFontSize() {
        return this.css("font-size");
    }

    @JDIAction("Get {name}'s font color")
    public String getFontColor() {
        return this.css("color");
    }

    @JDIAction("Get {name}'s height")
    public String getBackgroundColor() {
        return this.css("background-color");
    }

    @JDIAction("Get {name}'s borderColor")
    public String getBorderColor() {
        return this.css("border-color");
    }

    @JDIAction("Get {name}'s borderColor")
    public boolean hasVisibleBorder() {
        return this.css("border-color") != this.css("background-color")
                && !this.css("border-color").contains("transparent");
    }

    @JDIAction("Click on '{name}'")
    public void click() {
        this.core().click();
    }
}
