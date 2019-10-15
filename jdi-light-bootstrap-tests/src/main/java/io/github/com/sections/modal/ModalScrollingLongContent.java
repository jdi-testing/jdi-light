package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Modal;

public class ModalScrollingLongContent extends Modal {

    @UI("button:nth-of-type(1)")
    public Button longScroll;
    @UI("button:nth-of-type(2)")
    public Button longScrollable;

    @UI("#exampleModalLong")
    public Modal modalLong;
    @UI("#exampleModalScrollable")
    public Modal modalScrollable;

}
