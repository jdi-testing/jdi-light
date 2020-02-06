package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class SelectWrapper extends UIBaseElement<UISelectAssert> implements ISelect {
    private Select getSelect() {
        return core().asSelect();
    }
    public boolean isMultiple() {
        return getSelect().isMultiple();
    }

    public List<WebElement> getOptions() {
        return getSelect().getOptions();
    }

    public List<WebElement> getAllSelectedOptions() {
        return getSelect().getAllSelectedOptions();
    }

    public WebElement getFirstSelectedOption() {
        is().notEmpty();
        return getSelect().getFirstSelectedOption();
    }

    public void selectByVisibleText(String s) {
        is().notEmpty();
        getSelect().selectByVisibleText(s);
    }

    public void selectByIndex(int i) {
        is().size(greaterThanOrEqualTo(i));
        getSelect().selectByIndex(i);
    }

    public void selectByValue(String s) {
        is().notEmpty();
        getSelect().selectByValue(s);
    }

    public void deselectAll() {
        is().notEmpty();
        getSelect().deselectAll();
    }

    public void deselectByValue(String s) {
        is().notEmpty();
        getSelect().deselectByValue(s);
    }

    public void deselectByIndex(int i) {
        is().size(greaterThanOrEqualTo(i));
        getSelect().deselectByIndex(i);
    }

    public void deselectByVisibleText(String s) {
        is().notEmpty();
        getSelect().deselectByVisibleText(s);
    }
}
