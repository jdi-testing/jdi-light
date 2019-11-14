package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MultiplebarsProgress extends Progress {

    @UI(".progress-bar")
    public JList<Progress> barsList;

}
