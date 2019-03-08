package com.epam.jdi.light.elements.base;

import org.openqa.selenium.By;

import java.util.List;

public interface BaseFindElement<T> extends BaseElement {
    T find(String by);
    T find(By by);
    List<T> finds(String by);
    List<T> finds(By by);
    T firstChild();
    List<T> childs();
}
