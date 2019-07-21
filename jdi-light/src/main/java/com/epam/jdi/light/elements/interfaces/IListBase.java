package com.epam.jdi.light.elements.interfaces;

public interface IListBase extends HasText, HasClick {
    boolean isSelected();
    String getTagName();
}
