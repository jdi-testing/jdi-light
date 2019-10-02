package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Popover;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.MediaObject;

public class PopoverWithTitle extends Section {

    @UI("#popover-title")
    public Popover popover;
    @UI("div.bs-popover-right")
    public MediaObject container;
    @UI("div.bs-popover-right h3")
    public Text header;
    @UI("div.bs-popover-right div.popover-body")
    public Text body;

}
