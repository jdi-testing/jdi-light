package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Popover extends Section {

    public Button popoverButton;
    public MediaObject container;
    public Text header;
    public Text body;

    @JDIAction(value = "Get '{name}' popover click", level = DEBUG)
    public void getPopover(String locator) {
        popoverButton.core().setLocator(locator);
        popoverButton.click();
        container.core().setLocator(getContainer());
        header.core().setLocator(getHeader());
        body.core().setLocator(getBody());
    }

    @JDIAction(value = "Get '{name}' popover", level = DEBUG)
    private String getPopoverId() {
        return popoverButton.attr("aria-describedby");
    }

    @JDIAction(value = "Get '{name}' popover container", level = DEBUG)
    public String getContainer() {
        return "#" + getPopoverId();
    }

    @JDIAction(value = "Get '{name}' popover container", level = DEBUG)
    public String getHeader() {
        return "#" + getPopoverId() + " .popover-header";
    }

    @JDIAction(value = "Get '{name}' popover body", level = DEBUG)
    public String getBody() {
        return "#" + getPopoverId() + " .popover-body";
    }
}
