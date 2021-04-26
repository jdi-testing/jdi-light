package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;

import java.util.List;

public class FabPage extends WebPage {

    @UI("//h2[text()='Basic buttons']/following-sibling::div[@id='basicActionBtns']/button")
    public static List<Button> basicBtns;

    @UI("//h2[text()='Basic buttons']/following-sibling::div/button[contains(@class,'MuiFab-primary')]")
    public static Button addBtn;

    @UI("//h2[text()='Basic buttons']/following-sibling::div/button[contains(@class,'MuiFab-secondary')]")
    public static Button editBtn;

    @UI("//h2[text()='Basic buttons']/following-sibling::div/button[contains(@class,'MuiFab-extended')]")
    public static Button extendedBtn;

    @UI("//h2[text()='Basic buttons']/following::button[contains(@class,'Mui-disabled')]")
    public static Button disabledBtn;

    @UI("//div[contains(@class,'MuiTabs-scroller')]/descendant::button")
    public static List<Button> scrollBtns;

    @UI("//h2[text()='Animated buttons']/following-sibling::div/div/button[1]")
    public static Button animatedBtn;

    @UI("#action-tabpanel-0")
    public static UIElement itemNameOne;

    @UI("#action-tabpanel-1")
    public static UIElement itemNameTwo;

    @UI("#action-tabpanel-2")
    public static UIElement itemNameThree;

    @UI("#basicActionBtnsLastClick")
    public static Text basicBtnsLastClick;

    @UI("#animatedActionBtnsLastClick")
    public static Text animatedBtnsLastClick;
}
