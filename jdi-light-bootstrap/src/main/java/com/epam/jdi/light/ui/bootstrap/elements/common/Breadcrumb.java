package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

/**
 * Created by Olga Ivanova on 16.09.2019
 * Email: olga_ivanova@epam.com
 */

public class Breadcrumb extends UIBaseElement<UIAssert>{
    // @FindBy(css = ".breadcrumb-item")
    @Css(".breadcrumb-item") public WebList items;
}