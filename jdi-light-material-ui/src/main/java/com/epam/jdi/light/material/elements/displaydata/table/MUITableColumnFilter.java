package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.material.annotations.JMUITableColumnFilter;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableColumnFilterAssert;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MUITableColumnFilter extends UIBaseElement<MUITableColumnFilterAssert> implements HasAssert<MUITableColumnFilterAssert> {

    private final JMUITableColumnFilter columnFilter;
    private Button deleteButton;
    private Dropdown columnsDropdown;
    private Dropdown operatorsDropdown;
    private TextField valueField;

    public MUITableColumnFilter(JMUITableColumnFilter columnFilter) {
        this.columnFilter = columnFilter;
        base().setLocator(columnFilter.root());
    }

    public Button deleteButton() {
//        if (deleteButton == null) {
//            deleteButton = new Button().setCore(Button.class, core().find(columnFilter.deleteButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(columnFilter.deleteButton()));
    }

    public Dropdown columnsDropdown() {
//        if (columnsDropdown == null) {
//            columnsDropdown = new Dropdown().setCore(Dropdown.class, core().find(columnFilter.columnsSelect()));
//        }
        //html Dropdown seems not working properly by using class field
        return new Dropdown().setCore(Dropdown.class, core().find(columnFilter.columnsSelect()));
    }

    public Dropdown operatorsDropdown() {
//        if (operatorsDropdown == null) {
//            operatorsDropdown = new Dropdown().setCore(Dropdown.class, core().find(columnFilter.operatorsSelect()));
//        }
        //html Dropdown seems not working properly by using class field
        return new Dropdown().setCore(Dropdown.class, core().find(columnFilter.operatorsSelect()));
    }

    public TextField valueField() {
        if (valueField == null) {
            valueField = new TextField() {
                @Override
                @JDIAction("Send text to '{name}' text area")
                public void sendKeys(CharSequence... text) {
                    super.sendKeys(text);
                    try {
                        WebDriverWait webDriverWait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(3));
                        WebElement svg = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(columnFilter.valueField() + "/following-sibling::*[local-name()='svg']")));
                        webDriverWait.until(ExpectedConditions.stalenessOf(svg));
                    } catch (WebDriverException e) {
                        //TODO: Ask, how to log this properly
                    }
                }
            }.setCore(TextField.class, core().find(columnFilter.valueField()));
        }
        return valueField;
    }

    @Override
    public MUITableColumnFilterAssert is() {
        return new MUITableColumnFilterAssert().set(this);
    }

}
