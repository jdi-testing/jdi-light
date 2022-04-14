package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class ButtonPage extends WebPage {

    @UI("//h2[text()='Contained buttons']/following-sibling::div[1]/*[contains(@class, 'MuiButton-root')]")
    public static List<Button> containedButtons;

    @UI("#simpleLastClick")
    public static Text simpleLastClick;

    @UI("//h2[text()='Text buttons']/following-sibling::div[1]/*[contains(@class, 'MuiButton-root')]")
    public static List<Button> textButtons;

    @UI("#textLastClick")
    public static Text textLastClick;

    @UI("//h2[text()='Buttons with icons and label']/following-sibling::div[1]/button")
    public static List<Button> iconLabelButtons;

    @UI("//span[contains(@class,'MuiButton-icon')]")
    public static List<Icon> iconLabelIcons;

    @UI("#labeledLastClick")
    public static Text labeledLastClick;

    @UI("//h2[text()='Icon buttons']/following-sibling::div[1]/button")
    public static List<Button> iconButtons;

    @UI("//span[@class='MuiIconButton-label']")
    public static List<Icon> iconButtonIcons;

    @UI("#iconLastClick")
    public static Text iconLastClick;

    @UI("//h2[text()='Customized buttons']/following-sibling::div[1]/button")
    public static List<Button> customizedButtons;

    @UI("#customizedLastClick")
    public static Text customizedLastClick;

    @UI("//h2[text()='Complex buttons']/following-sibling::div/button")
    public static List<Button> complexButtons;

    @UI("#complexLastClick")
    public static Text complexLastClick;
}
