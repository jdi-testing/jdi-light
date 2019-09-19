package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.Checklist;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;

import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.PRE_INIT;

public class HtmlSettings {
    public static void init() {
        PRE_INIT.add("HtmlSettings", () -> INTERFACES.add(new Object[][]{
            { IsChecklist.class, Checklist.class },
            { IsCombobox.class, DataListOptions.class }
        }));
    }
}
