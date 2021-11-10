package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SelectAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class Select extends Dropdown implements HasLabel {

    protected String messageLocator = ".v-messages__message";
    protected String displayedElement = "//div[@class = 'v-select__selections']//*[text()]";

    public UIElement message() {
        return core().find(messageLocator);
    }

    public String messageText() {
        return message().getText();
    }

    @Override
    public Label label() {
        return new Label().setup(Label.class, j -> j
                .setLocator(By.cssSelector("[for=" + core().find("input").attr("id") + "]"))
                .setName(getName() + " label").setTypeName("Label"));
    }

    @Override
    public String labelText() {
        return label().getText();
    }

    @Override
    public String selected() {
        return setupDone ? value().getAttribute("value") : ds().selected();
    }

    @Override
    public String getText() {
        return setupDone ? value().getAttribute("value") : ds().getText();
    }

    @Override
    public boolean isDisplayed() {
        return core().find(displayedElement).isDisplayed();
    }

//    @Override
//    public void close() {
//        expander().sendKeys(Keys.ESCAPE);
//        //super.close();
//    }

    @Override
    public SelectAssert is() {
        SelectAssert selectAssert = new SelectAssert();
        selectAssert.set(this);
        return selectAssert;
    }
}
