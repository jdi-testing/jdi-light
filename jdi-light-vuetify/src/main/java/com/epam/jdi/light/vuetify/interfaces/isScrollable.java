package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

public interface isScrollable extends ICoreElement {

    /**
     * Mouse over the element and emulate mouse wheel scroll
     * @param px number of mouse wheel "ticks" to perform. Negative value scrolls up.
     */
    @JDIAction("Scroll over '{name}' '{0}' px")
    default void scroll(int px) {
        ScrollOrigin scrollOrigin = ScrollOrigin.fromElement(core().get());
        Actions actions = new Actions(core().driver());
        actions.scrollFromOrigin(scrollOrigin, 0, px);
        actions.perform();
    }
}
