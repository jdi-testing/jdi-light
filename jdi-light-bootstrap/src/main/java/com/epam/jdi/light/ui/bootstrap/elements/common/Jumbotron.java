package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsJumbotron;

public class Jumbotron extends UIBaseElement<TextAssert>
        implements IsJumbotron {

    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}