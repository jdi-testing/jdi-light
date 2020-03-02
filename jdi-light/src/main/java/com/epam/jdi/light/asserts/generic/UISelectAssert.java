package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UISelectAssert<A extends UISelectAssert, E extends ISelector> extends UIAssert<A, E>
        implements ITextAssert<A> {
    
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(Matcher<String> condition, String... messages) {
        jdiAssert(element.selected(), condition, messages);
        return (A) this;
    }
    
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(String option, String... messages) {
        jdiAssert(element.selected(option), Matchers.is(true), messages);
        return (A) this;
    }
    
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(int i, String... messages) {
        jdiAssert(element.selected(i), Matchers.is(true), messages);
        return (A) this;
    }
    
    public <TEnum extends Enum> UISelectAssert selected(TEnum option, String... messages) {
        return selected(getEnumValue(option), messages);
    }
    
    public A text(Matcher<String> condition, String... messages) {
        return selected(condition, messages);
    }
    
    public A text(String condition, String... messages) {
        return selected(condition, messages);
    }
    
    public <TEnum extends Enum> UISelectAssert value(TEnum option, String... messages) {
        return selected(option, messages);
    }
    
    @JDIAction("Assert that '{name}' values {0}")
    public A values(Matcher<? super List<String>> condition, String... messages) {
        jdiAssert(element.values(), condition, messages);
        return (A) this;
    }
    
    /**
     * This method to not accept custom error messages.
     * @param values
     * @return
     */
    public A values(String... values) {
        return values(hasItems(values));
    }
    
    @JDIAction("Assert that '{name}' values {0}")
    public A values(TextTypes type, Matcher<? super List<String>> condition, String... messages) {
        jdiAssert(element.values(type), condition, messages);
        return (A) this;
    }
    
    /**
     * This method do not accept custom error messages.
     * @param type
     * @param values
     * @return
     */
    public A values(TextTypes type, String... values) {
        return values(type, hasItems(values));
    }
    
    @JDIAction("Assert that '{name}' enabled items {0}")
    public A enabled(Matcher<? super List<String>> condition, String... messages) {
        jdiAssert(element.listEnabled(), condition, messages);
        return (A) this;
    }
    
    /**
     * This method do not accept custom error messages.
     * @param enabled
     * @return
     */
    public A enabled(String... enabled) {
        return enabled(hasItems(enabled));
    }
    
    @JDIAction("Assert that '{name}' disabled items {0}")
    public A disabled(Matcher<? super List<String>> condition, String... messages) {
        jdiAssert(element.listDisabled(), condition, messages);
        return (A) this;
    }
    
    /**
     * This method do not accept custom error messages.
     * @param disabled
     * @return
     */
    public A disabled(String... disabled) {
        return disabled(hasItems(disabled));
    }
    
    @JDIAction("Assert that '{name}' size {0}")
    public A size(Matcher<Integer> condition, String... messages) {
        jdiAssert(element.size(), condition, messages);
        return (A) this;
    }
    
    /**
     * Check that the list size is given size
     *
     * @param size to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public A size(int size, String... messages) {
        return size(equalTo(size), messages);
    }
    
    @JDIAction("Assert that '{name}' size {0}")
    public A empty(String... messages) {
        return size(0, messages);
    }
    
    @JDIAction("Assert that '{name}' size {0}")
    public A notEmpty(String... messages) {
        return size(greaterThan(0), messages);
    }
    
    @JDIAction("Assert that '{name}' is displayed")
    public A displayed(String... messages) {
        jdiAssert(element.isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"), messages);
        return (A) this;
    }
    
    @JDIAction("Assert that '{name}' is expanded")
    public A expanded(String... messages) {
        jdiAssert(element.list().isDisplayed() ? "expanded" : "hidden", Matchers.is("expanded"), messages);
        return (A) this;
    }
    
    @JDIAction("Assert that '{name}' is collapsed")
    public A collapsed(String... messages) {
        jdiAssert(element.list().isHidden() ? "collapsed" : "expanded", Matchers.is("expanded"), messages);
        return (A) this;
    }
    
    @JDIAction("Assert that '{name}' is disappeared")
    public A disappear(String... messages) {
        jdiAssert(element.isHidden() ? "hidden" : "displayed", Matchers.is("hidden"), messages);
        return (A) this;
    }
    
    @JDIAction("Assert that '{name}' is hidden")
    public A hidden(String... messages) {
        return disappear(messages);
    }
    
    public A notAppear(String... messages) {
        return notAppear(TIMEOUT.get(), messages);
    }
    
    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec, String... messages) {
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> element.isDisplayed());
        jdiAssert(result ? "displayed" : "hidden", Matchers.is("hidden"), messages);
        return (A) this;
    }
    
    public Compare exact(int count, String... messages) {
        return new Compare(count, this, true, messages);
    }
    
    public Compare atLeast(int count, String... messages) {
        return new Compare(count, this, false, messages);
    }
    
    public Compare no(String... messages) {
        return exact(0, messages);
    }
    
    public Compare all(String... messages) {
        return exact(element.size(), messages);
    }
    
    public Compare onlyOne(String... messages) {
        return exact(1, messages);
    }
    
    public class Compare implements JAssert {
        
        public int count;
        public String name;
        public String type;
        UISelectAssert<A, E> dtAssert;
        boolean exact;
        String[] messages;
        
        public JDIBase base() {
            return UISelectAssert.this.base();
        }
        
        private Compare(int count, UISelectAssert<A, E> dtAssert, boolean exact, String... messages) {
            this.count = count;
            this.dtAssert = dtAssert;
            this.exact = exact;
            this.type = exact ? "exactly" : "at least";
            this.name = dtAssert.name;
            this.messages = messages;
        }
        
        @JDIAction("Assert that '{name}' has {type} '{count}' elements that meet expected condition")
        public UISelectAssert<A, E> elements(JFunc1<UIElement, Boolean> condition) {
            jdiAssert(element.list().filter(condition), hasSize(count), messages);
            return dtAssert;
        }
        
        @JDIAction("Assert that '{name}' has {type} '{count}' '{0}'")
        public UISelectAssert<A, E> elements(UIElement data) {
            return elements(d -> d.equals(data));
        }
    }
}
