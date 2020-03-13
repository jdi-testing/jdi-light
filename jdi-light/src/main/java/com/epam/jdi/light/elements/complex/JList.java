package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.*;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JList<T extends ICoreElement> extends ListBase<T, UISelectAssert<UISelectAssert<?,?>, JList<T>>> {
    public JList() {}
    public JList(By locator) { super(locator); }
    public JList(List<WebElement> elements) {
        super(elements);
    }

    @Override
    public UISelectAssert<UISelectAssert<?,?>, JList<T>> is() {
        refresh();
        UISelectAssert<UISelectAssert<?,?>, JList<T>> is = new UISelectAssert<>();
        is.set(this);
        return is;
    }
    @JDIAction("Assert that {name} list meet condition")
    public UISelectAssert<UISelectAssert<?,?>, JList<T>> is(Matcher<? super List<T>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public UISelectAssert<UISelectAssert<?,?>, JList<T>> assertThat(Matcher<? super List<T>> condition) {
        return is(condition);
    }

    public boolean wait(JFunc1<JList<T>, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }
}