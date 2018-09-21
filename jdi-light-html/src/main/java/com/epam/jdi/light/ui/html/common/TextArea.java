package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.IList;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static java.util.Arrays.asList;

public interface TextArea extends Button, IList<String> {
    String getText();
    default List<String> getLines() { return asList(getText().split("\\n")); }    @JDIAction(level = DEBUG)
    default List<String> elements() { return getLines(); }
}
