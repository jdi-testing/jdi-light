package io.github.com.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Popover;

public class PopoverPage extends Section {

    @UI("#popover-bottom") public Popover popoverButton;
    public UIElement popoverButton2;
    @UI("#popover-disabled") public Button popoverDisabled1;
    @UI("#popover-dismissible") public Button popoverDismissible1;
    @UI("#popover-left") public Button popoverLeft;
    @UI("#popover-right") public Button popoverRight1;
    @UI("#popover-top") public Button popoverTop1;
    @UI("#popover-title") public Button popoverWithTitle1;
//    public MediaObject container1;
//    public Text body1;

}
