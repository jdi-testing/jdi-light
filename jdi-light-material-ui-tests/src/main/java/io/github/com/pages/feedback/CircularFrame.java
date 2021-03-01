package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.feedback.Circular;
import com.epam.jdi.light.material.elements.inputs.Button;

public class CircularFrame extends Section {

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[1]")
    public Circular circularDefault;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[2]")
    public Circular circularSecond;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[3]")
    public Circular circularDeterminateThreeQ;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[4]")
    public Circular circularDeterminateFull;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[5]")
    public Circular circularDeterminateWithStep10;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[6]")
    public Circular circularIndeterminateDisableShrink;

    @UI(".MuiButton-root")
    public Button acceptTermsButton;

    @UI(".MuiFab-root")
    public Button acceptTermsIconButton;

    @UI(".MuiTypography-root")
    public Typography circularTypography;
}


