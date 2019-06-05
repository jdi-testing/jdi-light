package com.epam.jdi.light.elements.base;

import org.openqa.selenium.By;

import java.util.List;

public interface BaseFindElement<T> extends IBaseElement {
    T find(String by);
    T find(By by);
    List<T> finds(String by);
    List<T> finds(By by);
    String css(String prop);
    T firstChild();
    List<T> childs();
}
