package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.PageChecks;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.func.JAction1;

import java.lang.reflect.InvocationTargetException;

public class PageSettings {

    public static class TestLoaded {
        public static void test(String path) {
            java.lang.reflect.Method m = null;
            try {
                m = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[]{String.class});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            m.setAccessible(true);
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            Object test1 = null;
            try {
                test1 = m.invoke(cl, path);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(test1 != null);
        }

    }

    public PageChecks checkPageOpen = PageChecks.NONE;

    static {
        TestLoaded.test("com.epam.jdi.light.elements.composite.WebPage");
    }

    public JAction1<WebPage> beforeNewPage = (x) -> WebPage.beforeNewPage(x);

    static {
        TestLoaded.test("com.epam.jdi.light.elements.composite.WebPage");
    }

    public JAction1<WebPage> beforeEachStep = (x) -> WebPage.beforeThisPage(x);

    static {
        TestLoaded.test("com.epam.jdi.light.elements.composite.WebPage");
    }
}
