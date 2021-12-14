package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BoxPage extends WebPage {
    @UI(".MuiButton-contained")
    public static Button buttonContainedBox;

    @UI(".MuiButton-outlined")
    public static Button buttonOutlinedBox;

    @UI(".Mui-disabled")
    public static Button buttonDisabledBox;

    @UI("#lastClickContent")
    public static Text lastClickContent;
}
