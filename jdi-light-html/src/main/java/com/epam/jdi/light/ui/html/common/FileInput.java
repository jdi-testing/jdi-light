package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface FileInput extends Text, SetValue, HasLabel {
    void uploadFile(String path);
    String value();
}
