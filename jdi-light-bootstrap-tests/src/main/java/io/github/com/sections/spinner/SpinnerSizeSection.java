package io.github.com.sections.spinner;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;

public class SpinnerSizeSection extends Section {

    @UI(".spinner-border-sm")
    public Spinner smallSpinner;

    @UI(".spinner-grow-sm")
    public Spinner smallGrowingSpinner;

    @UI("#spinBorder")
    public Spinner spinner;

    @UI("#spinGrow")
    public Spinner growingSpinner;

}
