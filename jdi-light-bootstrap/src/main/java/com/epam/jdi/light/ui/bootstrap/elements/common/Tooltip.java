package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * To see an example of Tooltip web element please visit https://getbootstrap.com/docs/4.3/components/tooltips/#examples
 */

public class Tooltip extends Text {
    public Tooltip(IBaseElement element) {
        setCore(Tooltip.class, element.base());
    }
    @Override
    public String getText() {
        boolean hasTooltip = isNotBlank(core().attr("aria-describedby"));
        return hasTooltip ? core().attr("data-original-title") : "";
    }
    @Override
    public boolean isDisplayed() {
        return core().hasAttribute("aria-describedby");
    }
}
