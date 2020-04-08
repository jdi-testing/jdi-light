package io.github.epam.listtests;

import com.epam.jdi.light.elements.complex.JList;
import io.github.epam.ListTestsInit;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JListTests extends ListTestsInit {
    @Test
    public void seleniumJListTest() {
        jList = new JList(list);
        assertEquals(jList.get(0).core().getText(), element0Text);
        assertEquals(jList.get(1).core().getText(), element1Text);
    }

    @Test
    public void jdiJListTest() {
        jList = new JList();
        jList.list().setWebElements(list);
        assertEquals(jList.get(1).core().getText(), element0Text);
        assertEquals(jList.get(2).core().getText(), element1Text);
    }

    @Test
    public void jdiJListWithLocatorTest() {
        jList = new JList(locator);
        jList.list().setWebElements(list);
        assertEquals(jList.get(1).core().getText(), element0Text);
        assertEquals(jList.get(2).core().getText(), element1Text);
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void jdiJListNullTest() {
        jList = new JList(locator);
        jList.list().setWebElements(list);
        jList.get(0);
    }
}
