package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgressBarWrapper extends Section {

    public @UI(".progress-bar")
    List<Progress> progressBarList;

    public Integer getWrapperHeightValueInPx() {
        String textHeight = uiElement.getAttribute("style");

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(textHeight);
        Integer height = Integer.parseInt(matcher.group());
        System.out.println(height);
        return height;
    }

    public List<Progress> getProgressBarList() {
        return progressBarList;
    }
}
