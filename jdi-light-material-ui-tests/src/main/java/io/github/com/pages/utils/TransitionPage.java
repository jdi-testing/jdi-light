package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

import java.util.List;

public class TransitionPage extends WebPage {

    @UI("//*[contains(@class,'MuiPaper-elevation4 MuiPaper-rounded')]")
    public static List<UIElement> transitions;

    @XPath("//input[contains(@type,'checkbox')]")
    public static List<Checkbox> checkboxes;

  /*  @UI("//*[contains(@type,'checkbox')]")
    public static List<Checkbox> checkboxes;*/

}
