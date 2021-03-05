package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.light.material.elements.inputs.Button;

public class CircularFrame extends Section {

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[1]")
    public ProgressBar circularDefault;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[2]")
    public ProgressBar circularSecond;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[3]")
    public ProgressBar circularDeterminateThreeQ;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[4]")
    public ProgressBar circularDeterminateFull;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[6]")
    public ProgressBar circularIndeterminateDisableShrink;

    @UI(".MuiButton-root")
    public Button acceptTermsButton;

    @UI(".MuiTypography-root")
    public Typography circularTypography;

    @UI("(//*[contains(@class, 'MuiButton-root')])[1]")
    public Button loadingButton;

    @UI("(//*[contains(@class, 'MuiButton-root')])[2]")
    public Button simulateLoadButton;
}



