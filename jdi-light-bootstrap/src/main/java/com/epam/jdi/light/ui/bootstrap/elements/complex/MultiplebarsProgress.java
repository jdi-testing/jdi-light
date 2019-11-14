package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

public class MultiplebarsProgress extends Progress {

    @UI(".progress-bar")
    public JList<Progress> barsList;
}
