package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;

public class VerticalDividerPage extends WebPage {

    @UI("hr.MuiDivider-root")
    public static Divider verticalDivider;

}
