package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;

import java.util.List;

public class FabPage extends WebPage {

    @UI("//div[@id='basicActionBtns']/button")
    public static List<Button> basicBtns;

    @UI("//button[@aria-label='add']")
    public static Button addBtn;

    @UI("//button[@aria-label='edit']")
    public static Button editBtn;

    @UI("//button[contains(@class,'MuiFab-extended')]")
    public static Button extendedBtn;

    @UI("//button[@aria-label='like']")
    public static Button disabledBtn;

    @UI("//button[contains(@id,'action-tab')]")
    public static List<Button> scrollBtns;

    @UI("//button[@aria-label='Add']")
    public static Button addButton;

    @UI("//button[@aria-label='Edit']")
    public static Button editButton;

    @UI("//button[@aria-label='Expand']")
    public static Button expandButton;

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
