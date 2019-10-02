package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Popover;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.MediaObject;

public class PopoverBottom extends Section {

    @UI("#popover-bottom")
    public Popover popover;
    @UI("div.bs-popover-bottom")
    public MediaObject container;
    @UI("div.bs-popover-bottom div.popover-body")
    public Text body;

}
