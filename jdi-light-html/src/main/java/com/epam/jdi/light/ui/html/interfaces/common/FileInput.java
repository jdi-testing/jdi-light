package com.epam.jdi.light.ui.html.interfaces.common;

import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.base.HasLabel;

public interface FileInput extends Text, HasLabel, SetValue {
    @FillValue void uploadFile(String path);
    @VerifyValue String value();
}
