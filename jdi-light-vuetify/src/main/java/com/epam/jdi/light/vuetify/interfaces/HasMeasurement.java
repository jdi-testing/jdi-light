package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * Interface <code>HasMeasurement</code> includes methods to get element measurement (height/width).
 */
public interface HasMeasurement extends ICoreElement {

    /**
     * Get element's height.
     *
     * @return height value
     */

    @JDIAction("Get '{name}' height")
    default int height() {
        return core().getSize().getHeight();
    }

    /**
     * Get element's width.
     *
     * @return width value
     */

    @JDIAction("Get '{name}' width")
    default int width() {
        return core().getSize().getWidth();
    }

    /**
     * Get element's max-height.
     *
     * @return max-height value or -1 if not set in px
     */

    @JDIAction("Get '{name}' max height")
    default int maxHeight() {
        if (css("max-height").equals("none")) {
            return -1;
        }
        return Integer.parseInt(css("max-height").replace("px", ""));
    }

    /**
     * Get element's max-width.
     *
     * @return max-width value or -1 if not set in px
     */

    @JDIAction("Get '{name}' max width")
    default int maxWidth() {
        if (css("max-width").equals("none")) {
            return -1;
        }
        return Integer.parseInt(css("max-width").replace("px", ""));
    }

    /**
     * Get element's max-height.
     *
     * @return max-height value or -1 if not set in px
     */

    @JDIAction("Get '{name}' min height")
    default int minHeight() {
        if (css("min-height").equals("none")) {
            return -1;
        }
        return Integer.parseInt(css("min-height").replace("px", ""));
    }

    /**
     * Get element's min-width.
     *
     * @return min-width value or -1 if not set in px
     */
    @JDIAction("Get '{name}' min width")
    default int minWidth() {
        if (css("min-width").equals("none")) {
            return -1;
        }
        return Integer.parseInt(css("min-width").replace("px", ""));
    }
}
