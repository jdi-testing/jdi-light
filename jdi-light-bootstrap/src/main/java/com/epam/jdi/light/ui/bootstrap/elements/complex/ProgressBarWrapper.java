package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgressBarWrapper extends Section {

    List<Progress> progressBarList;

    public Integer getWrapperHeightValueInPx() {
        String textHeight = uiElement.getAttribute("style");
        int height = Integer.parseInt(textHeight.substring(textHeight.length() - 4, textHeight.length() - 2));
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(textHeight);
//        Integer height = Integer.parseInt(matcher.group());
        return height;
    }
}
