package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class FloatingActionButtonPage extends WebPage {

    @UI("//div[@id='basicActionBtns']/button")
    public static List<Button> buttonsBasic;

    @UI("//button[@aria-label='add']")
    public static Button buttonAdd;

    @UI("//button[@aria-label='edit']")
    public static Button buttonEdit;

    @UI("//button[contains(@class,'MuiFab-extended')]")
    public static Button buttonNavigate;

    @UI("//button[@aria-label='like']")
    public static Button buttonLike;

    @UI("//button[contains(@id,'action-tab')]")
    public static List<Tabs> tabSections;

    @UI("//button[@aria-label='Add']")
    public static Button buttonAnimatedAdd;

    @UI("//button[@aria-label='Edit']")
    public static Button buttonAnimatedEdit;

    @UI("//button[@aria-label='Expand']")
    public static Button buttonExpand;

    @UI("#action-tabpanel-0")
    public static Tabs tabItemOne;

    @UI("#action-tabpanel-1")
    public static Tabs tabItemTwo;

    @UI("#action-tabpanel-2")
    public static Tabs tabItemThree;

    @UI("#basicActionBtnsLastClick")
    public static Text labelLastClick;

    @UI("#animatedActionBtnsLastClick")
    public static Text labelAnimatedLastClick;
}
