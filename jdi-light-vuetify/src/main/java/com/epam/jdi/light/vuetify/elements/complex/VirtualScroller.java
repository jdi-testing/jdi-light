package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.VirtualScrollerAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.jdiai.tools.Timer;
import org.openqa.selenium.Point;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * To see an example of Virtual Scroller web element please visit
 * https://vuetifyjs.com/en/components/virtual-scroller/
 */
public class VirtualScroller extends UIBaseElement<VirtualScrollerAssert> implements HasMeasurement {

    protected static final String ITEM_LOCATOR = ".v-virtual-scroll__item .v-list-item";

    @JDIAction("Scroll to {name} item with text {0}")
    public void scrollToElement(String text) {
        scrollToPosition(0);
        int startPosition;
        int currentPosition;
        do {
            startPosition = position();
            List<ListItem> itemsFound = items().stream()
                    .filter(item -> item.text().contains(text))
                    .collect(Collectors.toList());
            if (itemsFound.size() == 0) {
                show(items().get(items().size() - 1));
                currentPosition = position();
            } else {
                show(itemsFound.get(0));
                break;
            }
        } while (currentPosition != startPosition);
    }

    @JDIAction("Scroll {name} to top")
    public void scrollToTop() {
        core().jsExecute("scroll(0,0);");
    }

    @JDIAction("Scroll {name} to position '{0}'")
    public void scrollToPosition(int y) {
        core().jsExecute("scroll(0," + y + ");");
    }

    @JDIAction("Get '{name}' scrolled position")
    public int position() {
        return Integer.parseInt(items().get(1).find("..").css("top").split("px")[0]);
    }

    @JDIAction("Get '{name}'s list items")
    public List<ListItem> items() {
        return finds(ITEM_LOCATOR).stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Focus on '{0}'")
    public void show(ListItem item) {
        item.core().jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
    }

    @JDIAction("Get '{name}' items text")
    public List<String> itemsText() {
        return items().stream()
                .map(item -> item.title().getText())
                .collect(Collectors.toList());
    }

    @Override
    public VirtualScrollerAssert is() {
        return new VirtualScrollerAssert().set(this);
    }
}
