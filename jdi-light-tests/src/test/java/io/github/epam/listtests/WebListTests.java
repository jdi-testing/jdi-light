package io.github.epam.listtests;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.ListTestsInit;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WebListTests extends ListTestsInit {
    @Test
    public void seleniumWebListTest() {
        webList = new WebList(list);
        assertEquals(webList.get(0).getText(), element0Text);
        assertEquals(webList.get(1).getText(), element1Text);
    }

    @Test
    public void jdiWebListTest() {
        webList = new WebList();
        webList.setWebElements(list);
        assertEquals(webList.get(1).getText(), element0Text);
        assertEquals(webList.get(2).getText(), element1Text);
    }

    @Test
    public void jdiWebListWithLocatorTest() {
        webList = new WebList(locator);
        webList.setWebElements(list);
        assertEquals(webList.get(1).getText(), element0Text);
        assertEquals(webList.get(2).getText(), element1Text);
    }

    @Test
    public void jdiWebListWithJdiBaseTest() {
        webList = new WebList(new JDIBase() {
            @Override
            public JDIBase base() {
                return super.base();
            }
        });
        webList.setWebElements(list);
        assertEquals(webList.get(1).getText(), element0Text);
        assertEquals(webList.get(2).getText(), element1Text);
    }

    @Test
    public void jdiWebListWithAllParamsTest() {
        webList = new WebList(new JDIBase() {
            @Override
            public JDIBase base() {
                return super.base();
            }
        }, "locator", "name", new Object());
        webList.setWebElements(list);
        assertEquals(webList.get(1).getText(), element0Text);
        assertEquals(webList.get(2).getText(), element1Text);
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void jdiWebListNullTest() {
        webList = new WebList(locator);
        webList.setWebElements(list);
        webList.get(0);
    }
}
