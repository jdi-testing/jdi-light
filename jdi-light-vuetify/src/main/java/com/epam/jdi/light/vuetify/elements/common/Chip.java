package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;
import org.openqa.selenium.JavascriptExecutor;
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

    @JDIAction("Check that '{name}' is draggable")
    public boolean isDraggable() {
        return this.attr("draggable").equals("true");
    }

    @JDIAction("Drag '{name}' and drop it to ({0}, {1})")
    public void dragAndDropToElement(UIElement destination) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);",
                this.core().getWebElement(), destination.core().getWebElement());
//        new Actions(getDriver()).dragAndDrop(this.core().getWebElement(), destination.core().getWebElement())
//                .build().perform();
////        Actions actions = new Actions(getDriver());
////        int x = destination.core().getWebElement().getLocation().x;
////        int y = destination.core().getWebElement().getLocation().y;
////        actions.moveToElement(this.core().getWebElement())
////                .pause(Duration.ofSeconds(1))
////                .clickAndHold(this.core().getWebElement())
////                .pause(Duration.ofSeconds(1))
////                .moveByOffset(x, y)
////                .moveToElement(destination)
////                .moveByOffset(x,y)
////                .pause(Duration.ofSeconds(1))
////                .release().build().perform();
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
        return !this.css("border-color").equals(this.css("background-color"))
                && !this.css("border-color").contains("transparent");
    }

    @JDIAction("Click on '{name}'")
    public void click() {
        this.core().click();
    }
}
