package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.common.Title;

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface HasLabel {
    default Title label() {
        return (Title) $("[for="+((UIElement)this).getAttribute("ïd")+"]");
    }
}