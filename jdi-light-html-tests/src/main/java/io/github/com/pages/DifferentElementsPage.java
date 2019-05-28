package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.*;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.Label;

public class DifferentElementsPage extends WebPage {

    @org.openqa.selenium.support.FindBy(css = "label:nth-child(1) > input[type=checkbox]")
    public Checkbox waterSeleniumFindBy;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "label:nth-child(1) > input[type=checkbox]")
    public Checkbox waterJDIFindByCss;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(text = "Water")
    public Label waterJDIFindByText;

    @org.openqa.selenium.support.FindBys({
            @org.openqa.selenium.support.FindBy(css = "label:nth-child(1)"),
            @org.openqa.selenium.support.FindBy(css = "input[type=checkbox]")
    })
    public Checkbox waterSeleniumFindBys;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBys({
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "label:nth-child(1)"),
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "input[type=checkbox]")
    })
    public Checkbox waterJDIFindBys;

    @org.openqa.selenium.support.FindAll({
            @org.openqa.selenium.support.FindBy(css = "label:nth-child(1) > input"),
            @org.openqa.selenium.support.FindBy(css = "label:nth-child(1) > [type=checkbox]")
    })
    public Checkbox waterSeleniumFindAll;

    /* TBD
    @com.epam.jdi.light.elements.pageobjects.annotations.FindAll({
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "label:nth-child(1) > input"),
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "label:nth-child(1) > [type=checkbox]")
    })
    public Checkbox waterJDIFindAll;*/

    @Css("label:nth-child(1) > input[type=checkbox]")
    public Checkbox waterCss;

    @XPath("(//*[@type='checkbox'])[1]")
    public Checkbox waterXPath;

    @ByText("Water")
    public Label waterByText;

    @WithText("Wat")
    public Label waterWithText;

    @UI("label:nth-child(1) > input[type=checkbox]")
    public Checkbox waterUICss;

    @UI("(//*[@type='checkbox'])[1]")
    public Checkbox waterUIXpath;

    @UI("['Water'] input")
    public Checkbox waterUIHasText;

    @UI("[*'Wat'] input")
    public Checkbox waterUIWithText;

    @UI("[type=checkbox][1]")
    public Checkbox waterUIPosition;

    @UI(".colors<['Water']")
    public Label waterUIMoveUp;
}
