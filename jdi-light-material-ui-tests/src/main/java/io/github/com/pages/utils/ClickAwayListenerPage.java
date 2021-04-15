package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class ClickAwayListenerPage extends WebPage {

    @UI("//h2[text()='Example']/following-sibling::div[1]/div/button")
    public static Button exampleButton;

    @UI("//h2[text()='Portal']/following-sibling::div[1]/div/button")
    public static Button portalButton;

    @UI("//div[text()='Click me, I will stay visible until you click outside.']")
    public static TextArea text;

    public void clickAroundTextPopup(int x, int y) {
        System.out.println(x + " " + y);
        text.core().click(x, y);
    }

    public void clickAroundButton(int x, int y, int buttonId) {
        if (buttonId == 1)
            exampleButton.core().click(x, y);
        else if (buttonId == 2)
            portalButton.core().click(x, y);
    }

    public void clickButton(int buttonId) {
        if (buttonId == 1)
            exampleButton.click();
        else if (buttonId == 2)
            portalButton.click();
    }
}
