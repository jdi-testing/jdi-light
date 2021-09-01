package io.github.com.pages.inputs;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;


public class ButtonGroupPage extends WebPage {

    @UI("//*[@id=\"__next\"]/div/div/div[2]/div/div/div/div[1]/div")
    @JDIButtonGroup(list = ".MuiButtonGroup-groupedHorizontal")
    public static ButtonGroup basicButtonGroup;

    @UI("//*[@id=\"__next\"]/div/div/div[2]/div/div/div/div[2]/div")
    @JDIButtonGroup(list = ".MuiButton-root")
    public static ButtonGroup verticalButtonGroup;

    @JDropdown(
            root = "//h2[contains(text(), 'Split button')]/following::div[1]",
            value = "(//span[contains(@class, 'MuiButton-label')])[1]",
            list = "//li[contains(@class, 'MuiListItem-root')]",
            expand = "//button[contains(@aria-label, 'select merge strategy')]"
    )
    public static Dropdown splitButtonGroup;

}