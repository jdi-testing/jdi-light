package io.github.com.sections.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class SectionModalLongScrolling extends Section {

    @UI("div:nth-child(2) > button:nth-child(1)")
    public Button buttonLongScroll;
    @UI("div:nth-child(4) > button:nth-child(1)")
    public Button buttonLongScrollable;

    @UI("#exampleModalLong") @WaitTimeout(2)
    public ModalWithButtons modalLong;
    @UI("#exampleModalScrollable") @WaitTimeout(2)
    public ModalWithButtons modalScrollable;
}
