package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.SelectAssert;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.ui.html.asserts.HtmlAssertion;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.MultiSelector;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.asserts.SoftAssert.assertSoft;

public class HtmlSelector extends Selector<HtmlElement> implements Dropdown, MultiSelector {
    public HtmlSelector() { setInitClass(HtmlElement.class); }
    public HtmlSelector(WebElement el) { super(el); setInitClass(HtmlElement.class); }

    public SelectAssert assertThat() {
        return is();
    }
    public SelectAssert has() {
        return is();
    }
    public SelectAssert waitFor() {
        return is();
    }
    public SelectAssert shouldBe() {
        return is();
    }
    public SelectAssert verify() {
        assertSoft();
        return is();
    }
}
