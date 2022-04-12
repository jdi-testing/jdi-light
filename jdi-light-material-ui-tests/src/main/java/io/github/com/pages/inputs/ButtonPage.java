package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class ButtonPage extends WebPage {

    @UI("//h2[text()='Contained buttons']/parent::div/div[1]/*")
    public static List<Button> containedButtons;

    @UI("#simpleLastClick")
    public static Text simpleLastClick;

    @UI("//h2[text()='Text buttons']/parent::div/div[2]/*")
    public static List<Button> textButtons;

    @UI("#textLastClick")
    public static Text textLastClick;

    @UI("//h2[text()='Buttons with icons and label']/parent::div/div[3]/*")
    public static List<Button> iconLabelButtons;

    @UI("//span[contains(@class,'MuiButton-icon')]")
    public static List<Icon> iconLabelIcons;

    @UI("#labeledLastClick")
    public static Text labeledLastClick;

    @UI("//h2[text()='Icon buttons']/parent::div/div[4]/*")
    public static List<Button> iconButtons;

    @UI("//span[@class='MuiIconButton-label']")
    public static List<Icon> iconButtonIcons;

    @UI("#iconLastClick")
    public static Text iconLastClick;

    @UI("//h2[text()='Customized buttons']/parent::div/div[5]/*")
    public static List<Button> customizedButtons;

    @UI("#customizedLastClick")
    public static Text customizedLastClick;

    @UI("//h2[text()='Complex buttons']/parent::div/div[6]/*")
    public static List<Button> complexButtons;

    @UI("#complexLastClick")
    public static Text complexLastClick;
}
