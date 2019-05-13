package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.ui.html.asserts.TextAreaAssert;

import java.util.List;

public interface TextArea extends TextField {
    void setLines(String... lines);
    List<String> getLines();
    int rows();
    int cols();
    int minlength();
    int maxlength();
    String placeholder();
    void addNewLine(String line);

    TextAreaAssert is();
    TextAreaAssert assertThat();
}
