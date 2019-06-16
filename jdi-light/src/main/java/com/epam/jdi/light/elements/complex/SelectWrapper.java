package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class SelectWrapper extends UIBaseElement<UISelectAssert> implements ISelect {

    public boolean isMultiple() {
        return core().select().isMultiple();
    }

    public List<WebElement> getOptions() {
        return core().select().getOptions();
    }

    public List<WebElement> getAllSelectedOptions() {
        return core().select().getAllSelectedOptions();
    }

    public WebElement getFirstSelectedOption() {
        is().notEmpty();
        return core().select().getFirstSelectedOption();
    }

    public void selectByVisibleText(String s) {
        is().notEmpty();
        core().select().selectByVisibleText(s);
    }

    public void selectByIndex(int i) {
        is().size(greaterThanOrEqualTo(i));
        core().select().selectByIndex(i);
    }

    public void selectByValue(String s) {
        is().notEmpty();
        core().select().selectByValue(s);
    }

    public void deselectAll() {
        is().notEmpty();
        core().select().deselectAll();
    }

    public void deselectByValue(String s) {
        is().notEmpty();
        core().select().deselectByValue(s);
    }

    public void deselectByIndex(int i) {
        is().size(greaterThanOrEqualTo(i));
        core().select().deselectByIndex(i);
    }

    public void deselectByVisibleText(String s) {
        is().notEmpty();
        core().select().deselectByVisibleText(s);
    }
}
