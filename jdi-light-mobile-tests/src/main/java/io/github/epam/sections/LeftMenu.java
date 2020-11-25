package io.github.epam.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.app.Button;

public class LeftMenu extends Section {

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(5)")
    public static Button leftMenu;
}
