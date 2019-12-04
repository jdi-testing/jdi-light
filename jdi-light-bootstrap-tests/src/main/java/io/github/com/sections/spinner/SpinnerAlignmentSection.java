package io.github.com.sections.spinner;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;

public class SpinnerAlignmentSection extends SpinnerSection {

    @UI("//div[@class='border mb-3 p-3']")
    public Spinner spinnerSectionLeft;

    @UI("//div[@class='d-flex justify-content-center border mb-3 p-3']")
    public Spinner flexJustifySpinnerSection;

    @UI("//div[@class='d-flex align-items-center border mb-3 p-3']")
    public Spinner flexAlignCenterSpinnerSection;

    @UI("//div[@class='clearfix border mb-3 p-3']")
    public Spinner clearfixSpinnerSection;

    @UI("//div[@class='text-center mb-3 border p-3']")
    public Spinner textCenterSpinnerSection;

}
