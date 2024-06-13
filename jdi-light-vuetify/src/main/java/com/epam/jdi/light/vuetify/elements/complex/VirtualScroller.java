package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.VirtualScrollerAssert;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Virtual Scroller web element please visit
 * https://v2.vuetifyjs.com/en/components/virtual-scroller/
 */
public class VirtualScroller extends UIBaseElement<VirtualScrollerAssert> implements HasMeasurement {

    @JDIAction("Scroll to {name} item with text {0}")
    public void scrollToElement(String text) {
        scrollToPosition(0);
        int startPosition;
        int currentPosition;
        do {
            startPosition = position();
            List<UIElement> itemsFound = items().stream()
                    .filter(item -> item.text().contains(text))
                    .collect(Collectors.toList());
            if (itemsFound.isEmpty()) {
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
        scrollToPosition(0);
    }

    @JDIAction("Get '{name}' list items")
    public List<UIElement> items() {
        return core().finds(".v-virtual-scroll__item").stream()
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' item with text {0}")
    public UIElement item(String itemText) {
        return items().stream()
                .filter(item -> item.text().contains(itemText))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no element with text '%s'", itemText)));
    }

    @JDIAction("Get '{name}' items text")
    public List<String> itemsText() {
        return items().stream()
                .map(UIElement::text)
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' item height")
    public int itemHeight() {
        return core().find(".v-virtual-scroll__item").getSize().getHeight();
    }

    @JDIAction("Get '{name}' scrolled position")
    private int position() {
        return Integer.parseInt(core().finds(".v-virtual-scroll__item").css("top").split("px")[0]);
    }

    @JDIAction("Scroll {name} to position '{0}'")
    private void scrollToPosition(int y) {
        core().jsExecute("scroll(0," + y + ");");
    }

    @JDIAction("Show '{name}' '{0}' item")
    private void show(UIElement item) {
        item.core().jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
    }

    @Override
    public VirtualScrollerAssert is() {
        return new VirtualScrollerAssert().set(this);
    }
}
