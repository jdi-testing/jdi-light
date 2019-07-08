package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.IListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;
import static org.hamcrest.MatcherAssert.*;

public class JList<T extends IListBase> extends ListBase<T, UISelectAssert<UISelectAssert, JList<T>>> {
    public JList() {}
    public JList(By locator) { super(locator); }
    public JList(List<WebElement> elements) {
        super(elements);
    }

    @Override
    public UISelectAssert<UISelectAssert, JList<T>> is() {
        offCache();
        return new UISelectAssert<>().set(this);
    }
    @JDIAction("Assert that {name} list meet condition")
    public UISelectAssert<UISelectAssert, JList<T>> is(Matcher<? super List<T>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public UISelectAssert<UISelectAssert, JList<T>> assertThat(Matcher<? super List<T>> condition) {
        return is(condition);
    }

    public boolean wait(JFunc1<JList<T>, Boolean> condition) {
        return waitCondition(condition, this);
    }
}