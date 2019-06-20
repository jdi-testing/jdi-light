package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.HasUIElement;
import com.epam.jdi.light.elements.base.IListBase;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;

public class JList<T extends IListBase & HasUIElement> extends TListBase<T, UISelectAssert<UISelectAssert, JList<T>>> {
    public JList() {}
    public JList(By locator) { super(locator); }
    public JList(List<WebElement> elements) {
        super(elements);
    }

    public boolean wait(JFunc1<JList<T>, Boolean> condition) {
        return waitCondition(condition, this);
    }
}