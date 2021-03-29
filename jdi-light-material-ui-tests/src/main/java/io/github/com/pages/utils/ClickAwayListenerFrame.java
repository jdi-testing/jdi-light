package io.github.com.pages.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickAwayListenerFrame extends Section {
    @UI("#root > div > button")
    public UIElement openMenuButton;

    @UI("(//div[contains(@class, 'makeStyles-dropdown')])")
    public UIElement text;
}
