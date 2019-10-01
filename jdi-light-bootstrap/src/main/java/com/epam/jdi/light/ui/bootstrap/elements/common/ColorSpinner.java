package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.asserts.SpinnerColorAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorSpinner extends UIBaseElement<SpinnerColorAssert> {

    public String getColor(){
        String str = core().getAttribute("class");
        Pattern pattern = Pattern.compile("text-.+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? str.substring(matcher.start(), matcher.end()) : "";
    }

    @Override
    public SpinnerColorAssert is() {
        return new SpinnerColorAssert().set(this);
    }
}
