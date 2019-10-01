package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class PopoverTop extends Section {

    @UI("button") public Button popover;
    @UI(".popover fade show bs-popover-top") public Text container;
    @UI(".popover fade show bs-popover-top h3") public Text header;
    @UI(".popover fade show bs-popover-top div") public Text body;

}
