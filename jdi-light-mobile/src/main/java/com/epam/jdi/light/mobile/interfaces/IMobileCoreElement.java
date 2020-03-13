package com.epam.jdi.light.mobile.interfaces;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.mobile.elements.base.MobileElement;

public interface IMobileCoreElement extends ICoreElement {
    @Override
    MobileElement core();
}
