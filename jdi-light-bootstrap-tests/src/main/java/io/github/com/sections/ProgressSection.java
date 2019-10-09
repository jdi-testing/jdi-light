package io.github.com.sections;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ProgressBarWrapper;

import java.util.List;

public class ProgressSection extends Section {

    @UI(".progress")
    List<ProgressBarWrapper> progressBarWrappersList;

    public List<ProgressBarWrapper> getProgressBarWrappersList() {
        return progressBarWrappersList;
    }



}
