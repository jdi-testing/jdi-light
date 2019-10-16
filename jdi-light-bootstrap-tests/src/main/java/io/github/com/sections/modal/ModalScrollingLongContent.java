package io.github.com.sections.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalScrollingLongContent extends Section {

    @UI("div:nth-child(2) > button:nth-child(1)")
    public Button buttonLongScroll;
    @UI("div:nth-child(4) > button:nth-child(1)")
    public Button buttonLongScrollable;

    @UI("#exampleModalLong")
    public Modal modalLong;
    @UI("#exampleModalScrollable")
    public Modal modalScrollable;
}
