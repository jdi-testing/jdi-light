package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorSpinner extends UIBaseElement<UIAssert> {

    public String getColor(){
        String str = core().getAttribute("class");
        Pattern pattern = Pattern.compile("text-.+");
        Matcher matcher = pattern.matcher(str);
        String result;
        if (matcher.find()) {
            result = str.substring(matcher.start(), matcher.end());
        }
        else{
            result = "The color is not set";
        }
        return result;
    }
}