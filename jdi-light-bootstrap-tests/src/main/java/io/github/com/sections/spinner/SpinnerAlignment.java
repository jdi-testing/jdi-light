package io.github.com.sections.spinner;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class SpinnerAlignment extends Spinner {

    @UI("//div[@class='border mb-3 p-3']")
    public Spinner spinnerLeft;

    @UI("//div[@class='d-flex justify-content-center border mb-3 p-3']")
    public Spinner flexJustifySpinner;

    @UI("//div[@class='d-flex align-items-center border mb-3 p-3']")
    public Spinner flexAlignCenterSpinner;

    @UI("//div[@class='clearfix border mb-3 p-3']")
    public Spinner clearfixSpinner;

    @UI("//div[@class='text-center mb-3 border p-3']")
    public Spinner textCenterSpinner;

}
