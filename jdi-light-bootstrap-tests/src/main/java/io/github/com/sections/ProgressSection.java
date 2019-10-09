package io.github.com.sections;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

import java.util.List;

public class ProgressSection extends Section {

    @UI(".progress-bar")
    List<Progress> progressBarsList;

    public List<Progress> getProgressBarsList() {
        return progressBarsList;
    }

    public Integer getSectionHeightValueInPx() {
        String textHeight = uiElement.getAttribute("style");
        Integer height = Integer.parseInt(textHeight.substring(textHeight.length() - 4, textHeight.length() - 2));
        return height;
    }

}
