package io.github.com.sections.spinner;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;

public class GrowingSpinnersSection extends SpinnerSection {

    @UI(".text-primary")
    public Spinner primarySpinner;

    @UI(".text-secondary")
    public Spinner secondarySpinner;

    @UI(".text-success")
    public Spinner successSpinner;

    @UI(".text-danger")
    public Spinner dangerSpinner;

    @UI(".text-warning")
    public Spinner warningSpinner;

    @UI(".text-info")
    public Spinner infoSpinner;

    @UI(".text-light")
    public Spinner lightSpinner;

    @UI(".text-dark")
    public Spinner darkSpinner;

}
