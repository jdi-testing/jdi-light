package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.light.material.elements.inputs.Button;

public class CircularFrame extends Section {

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[1]")
    public ProgressBar circularDefault;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[2]")
    public ProgressBar circularSecond;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[3]")
    public ProgressBar circularDeterminateThreeQ;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[4]")
    public ProgressBar circularDeterminateFull;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[5]")
    public ProgressBar circularDeterminateWithStep10;

    @UI("(//*[contains(@class, 'MuiCircularProgress-root')])[6]")
    public ProgressBar circularIndeterminateDisableShrink;

    @UI(".MuiButton-root")
    public Button acceptTermsButton;

    @UI(".MuiFab-root")
    public Button acceptTermsIconButton;

    @UI(".MuiTypography-root")
    public Typography circularTypography;

    @UI("(//*[contains(@class, 'MuiButton-root')])[1]")
    public Button loadingButton;

    @UI("(//*[contains(@class, 'MuiButton-root')])[2]")
    public Button simulateLoadButton;
}



