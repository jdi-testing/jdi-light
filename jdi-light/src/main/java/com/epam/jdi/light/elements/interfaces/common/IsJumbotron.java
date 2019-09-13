package com.epam.jdi.light.elements.interfaces.common;

public interface IsJumbotron extends IsText {
    default String getValue() { return getText(); }
}