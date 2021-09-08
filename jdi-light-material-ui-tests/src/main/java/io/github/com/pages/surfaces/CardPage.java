package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

import java.util.List;

public class CardPage extends WebPage {

    @UI("//h2[text()='Outlined Card']/following-sibling::div[contains(@class,'MuiPaper-outlined')]")
    public static UIElement outlinedCard;

    @UI("//div[@class='MuiCardContent-root']/p[1]")
    public static List<Text> pTagTexts;

    @UI("//div[@class='MuiCardContent-root']/h2")
    public static List<Text> h2TagTexts;

    @UI("//div[@class='MuiCardActions-root']/button[@aria-label='add to favorites']")
    public static Button complexCardHeartIconButton;

    @UI("//div[@class='MuiCardActions-root']/button[@aria-label='add to favorites']/span/*")
    public static Icon complexCardHeartIcon;

    @UI("//div[@class='MuiCardActions-root']/button[@aria-label='show more']")
    public static Button complexCardSliderDownButton;

    @UI("//div[@class='MuiCardActions-root']/preceding-sibling::div[@title='Paella dish']")
    public static Image complexCardImage;

    @UI("//div[@class='MuiCardActions-root']/following-sibling::div")
    public static TextArea complexCardHiddenTextArea;

    @UI("//div[@class='MuiCardContent-root']/p[contains(@class,'MuiTypography-paragraph')]")
    public static List<Text> complexCardHiddenText;
}
