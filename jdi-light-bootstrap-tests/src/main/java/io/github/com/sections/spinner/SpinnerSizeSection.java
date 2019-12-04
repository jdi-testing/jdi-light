package io.github.com.sections.spinner;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;

public class SpinnerSizeSection extends Section {

    @UI(".spinner-border-sm")
    public Spinner smallSpinnerSection;

    @UI(".spinner-grow-sm")
    public Spinner smallGrowingSpinnerSection;

    @UI("#spinBorder")
    public Spinner spinnerSection;

    @UI("#spinGrow")
    public Spinner growingSpinnerSection;

}
