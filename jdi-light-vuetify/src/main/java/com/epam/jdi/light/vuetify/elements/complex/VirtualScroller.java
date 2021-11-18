package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.VirtualScrollerAssert;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Virtual Scroller web element please visit https://vuetifyjs.com/en/components/virtual-scroller/
 */
public class VirtualScroller extends UIBaseElement<VirtualScrollerAssert> {

    protected String ITEM_LOCATOR = ".v-virtual-scroll__item";

    @JDIAction("Scroll to position '{0}' in '{name}'")
    public void scrollToPosition(int y) {
        core().jsExecute("scroll(0," + y + ");");
    }

    @JDIAction("Scroll to '{0}' with text {1} in '{name}'")
    public void scrollToElementWithText(String text) {
        scrollToPosition(0);
        int startPosition;
        int currentPosition;
        do {
            startPosition = position();
            List<UIElement> elementsFound = getItems().filter(item ->
                    item.text().contains(text));

            if (elementsFound.size() == 0) {
                show(getItems().last());
                currentPosition = position();
            } else {
                show(elementsFound.get(0));
                break;
            }
        } while (currentPosition != startPosition);
    }

    public VirtualScrollerAssert is() {
        return new VirtualScrollerAssert().set(this);
    }

    @JDIAction(value = "Get '{name}' scrolled position", level = DEBUG)
    public int position() {
        return Integer.parseInt(getItems().get(1).getCssValue("top").split("px")[0]);
    }

    @JDIAction(value = "Get '{name}' items", level = DEBUG)
    public WebList getItems() {
        return finds(ITEM_LOCATOR);
    }

    @JDIAction("Focus on '{1}'")
    public void show(UIElement item) {
        item.iCore().jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
    }
}
