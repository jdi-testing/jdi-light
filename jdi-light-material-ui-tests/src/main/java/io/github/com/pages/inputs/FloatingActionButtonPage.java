package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.FloatingAnimatedButtonsSection;

public class FloatingActionButtonPage extends WebPage {

    @UI("button[aria-label='add']")
    public static Button buttonAdd;

    @UI("button[aria-label='edit']")
    public static Button buttonEdit;

    @UI("//button[contains(@class,'MuiFab-extended')]")
    public static Button buttonNavigate;

    @UI("button[aria-label='like']")
    public static Button buttonLike;

    @UI("//h2[text()='Animated buttons']/following-sibling::div")
    public static FloatingAnimatedButtonsSection floatingAnimatedButton;

    @UI("#basicActionBtnsLastClick")
    public static Text labelLastClick;

    @UI("#animatedActionBtnsLastClick")
    public static Text labelAnimatedLastClick;
}
