package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.ui.bootstrap.asserts.TooltipAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Tooltip extends UIBaseElement<TooltipAssert> implements IsButton {

    @JDIAction(value = "Get '{name}' tooltip text", level = DEBUG)
    public String getTooltipText() {
        return uiElement.attr("data-original-title");
    }

    @JDIAction(value = "Get '{name}' tooltip placement", level = DEBUG)
    public String getTooltipPlacement() {
        return uiElement.attr("data-placement");
    }

    public boolean isTooltipWithHTML() {
        String htmlAttribute = "data-html";
        return core().hasAttribute(htmlAttribute) && core().getAttribute(htmlAttribute).equals("true");
    }

    @Override
    public TooltipAssert is() {
        return new TooltipAssert().set(this);
    }
}
