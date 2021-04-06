package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ClickAwayListenerFrame extends Section {
    @UI("#root > div > button")
    public Button openMenuButton;

    @UI("(//div[contains(@class, 'makeStyles-dropdown')])")
    public Text text;

    public void clickAroundTextPopup(int x, int y) {
        text.core().click(x, y);
    }

    public void clickAroundButton(int x, int y) {
        openMenuButton.core().click(x, y);
    }
}
