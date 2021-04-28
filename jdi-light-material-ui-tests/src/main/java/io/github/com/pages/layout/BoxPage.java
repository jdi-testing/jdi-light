package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BoxPage extends WebPage {
    @UI("//button[contains(@class,'MuiButton-contained')]")
    public Button containedBox;

    @UI("//button[contains(@class,'MuiButton-outlined')]")
    public Button outlinedBox;

    @UI("//button[contains(@class,'Mui-disabled')]")
    public Button disabledBox;

    @UI("#lastClickContent")
    public Text lastClickContent;
}
