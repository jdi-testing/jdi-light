package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ProgressBarWrapper;

import java.util.List;

public class ProgressWrapperSection {

    @UI(".progress")
    private List<ProgressBarWrapper> progressBarWrappersList;

    public List<ProgressBarWrapper> getProgressBarWrappersList() {
        return progressBarWrappersList;
    }

}
