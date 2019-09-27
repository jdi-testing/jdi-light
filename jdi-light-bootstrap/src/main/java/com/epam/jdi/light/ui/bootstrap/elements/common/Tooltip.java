package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Tooltip  extends Button {

    @JDIAction(value = "Get '{name}' tooltip text", level = DEBUG)
    public String  getTooltipText(){
        return uiElement.attr("data-original-title");
    }

    @JDIAction(value = "Get '{name}' tooltip placement", level = DEBUG)
    public String getTooltipPlacement(){
        return uiElement.attr("data-placement");
    }

    public boolean isVisible(){
        return core().hasAttribute("aria-describedby");
    }

    public boolean isTooltipWithHTML(){
        String htmlAttribute = "data-html";
        return core().hasAttribute(htmlAttribute) && core().getAttribute(htmlAttribute).equals("true");
    }
}