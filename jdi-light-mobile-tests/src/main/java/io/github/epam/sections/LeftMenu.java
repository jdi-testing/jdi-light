package io.github.epam.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class LeftMenu extends Section {

    //@UI("#mCSB_1_container > ul > li.menu-title.active")
    //  @FindBy(css = "#mCSB_1_container > ul > li.menu-title.active")
    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(5)")
    public static UIElement leftMenu;

}
