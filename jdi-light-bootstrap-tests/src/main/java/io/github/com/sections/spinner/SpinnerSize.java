package io.github.com.sections.spinner;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class SpinnerSize extends Spinner {

    @UI(".spinner-border-sm")
    public Spinner smallSpinner;

    @UI(".spinner-grow-sm")
    public Spinner smallGrowingSpinner;

    @UI(".spinner-border")
    public Spinner spinner;

    @UI(".spinner-grow")
    public Spinner growingSpinner;

}
