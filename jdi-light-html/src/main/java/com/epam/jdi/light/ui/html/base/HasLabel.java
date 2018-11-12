package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface HasLabel {
    UIElement label();
    String labelText();
}