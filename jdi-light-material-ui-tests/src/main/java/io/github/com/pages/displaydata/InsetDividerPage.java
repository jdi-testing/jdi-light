package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;

import java.util.List;

public class InsetDividerPage extends WebPage {

    @UI("li.MuiDivider-root")
    public static List<Divider> insetDivider;

}
