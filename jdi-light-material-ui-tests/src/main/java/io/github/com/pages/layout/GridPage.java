package io.github.com.pages.layout;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class GridPage extends Section {

    @UI(".MuiContainer-root")
    public static UIElement rootGrid;

    @UI("#basicGrid")
    public static UIElement basicGrid;

    @UI("//div[@id='complexGrid']")
    public static UIElement complexGrid;

    @UI(".MuiPaper-root[1]")
    public static Button firstButton;

    @UI(".MuiPaper-root[2]")
    public static Button secondButton;

    @UI(".MuiPaper-root[3]")
    public static Button thirdButton;

    @UI(".MuiPaper-root[4]")
    public static Button fourthButton;

    @UI(".MuiInputBase-input[1]")
    public static TextField firstInput;

    @UI(".MuiInputBase-input[2]")
    public static TextField secondInput;

    @UI(".MuiInputBase-input[3]")
    public static TextField thirdInput;

    @UI(".MuiInputBase-input[4]")
    public static TextField fourthInput;
}
