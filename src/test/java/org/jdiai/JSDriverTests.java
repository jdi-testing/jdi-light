package org.jdiai;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSDriverTests extends TestInit {

    @BeforeMethod
    public void logout() {
        DRIVER.manage().deleteAllCookies();
        DRIVER.get(HOME_PAGE);
    }

    @Test
    public void oneTest() {
        assertEquals(js("#user-icon").getOne("tagName"), "IMG");
        assertEquals(js("#user-name").getOne("innerText"), "Roman Iovlev");
        assertEquals(js("#user-name").getOne("textContent"), "Roman Iovlev");
        assertEquals(js("#user-name").getOne("innerHTML"), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js("#user-name").getOne("click()");
        js("#name").getOne("value='Roman'");
        js("#password").getOne("value='Jdi1234'");
        js("#login-button").getOne("click()");

        assertEquals(js("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void chainTest() {
        assertEquals(js("#user-icon").getOneChain("tagName"), "IMG");
        assertEquals(js("#user-name").getOneChain("innerText"), "Roman Iovlev");
        assertEquals(js("#user-name").getOneChain("textContent"), "Roman Iovlev");
        assertEquals(js("#user-name").getOneChain("innerHTML"), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js("#user-name").getOneChain("click()");
        js("#name").getOneChain("value='Roman'");
        js("#password").getOneChain("value='Jdi1234'");
        js("#login-button").getOneChain("click()");

        assertEquals(js("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void multiTest() {
        assertEquals(js("#user-icon").getOneMultiSearch("tagName"), "IMG");
        assertEquals(js("#user-name").getOneMultiSearch("innerText"), "Roman Iovlev");
        assertEquals(js("#user-name").getOneMultiSearch("textContent"), "Roman Iovlev");
        assertEquals(js("#user-name").getOneMultiSearch("innerHTML"), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js("#user-name").getOneMultiSearch("click()");
        js("#name").getOneMultiSearch("value='Roman'");
        js("#password").getOneMultiSearch("value='Jdi1234'");
        js("#login-button").getOneMultiSearch("click()");

        assertEquals(js("#user-name").getStyle("visibility"), "visible");
    }

    private String[] withParent(String locator) {
        return new String[] {".uui-header", ".profile-photo", locator };
    }
    private String[] inForm(String locator) {
        return new String[] {".uui-header", "form", locator };
    }
    @Test
    public void oneFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).getOne("tagName"), "IMG");
        assertEquals(js(withParent("#user-name")).getOne("innerText"), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOne("textContent"), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOne("innerHTML"), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js(withParent("#user-name")).getOne("click()");
        js(inForm("#name")).getOne("value='Roman'");
        js(inForm("#password")).getOne("value='Jdi1234'");
        js(inForm("#login-button")).getOne("click()");

        assertEquals(js(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void chainFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).getOneChain("tagName"), "IMG");
        assertEquals(js(withParent("#user-name")).getOneChain("innerText"), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneChain("textContent"), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneChain("innerHTML"), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js(withParent("#user-name")).getOneChain("click()");
        js(inForm("#name")).getOneChain("value='Roman'");
        js(inForm("#password")).getOneChain("value='Jdi1234'");
        js(inForm("#login-button")).getOneChain("click()");

        assertEquals(js(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void multiFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).getOneMultiSearch("tagName"), "IMG");
        assertEquals(js(withParent("#user-name")).getOneMultiSearch("innerText"), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneMultiSearch("textContent"), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneMultiSearch("innerHTML"), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js(withParent("#user-name")).getOneMultiSearch("click()");
        js(inForm("#name")).getOneMultiSearch("value='Roman'");
        js(inForm("#password")).getOneMultiSearch("value='Jdi1234'");
        js(inForm("#login-button")).getOneMultiSearch("click()");

        assertEquals(js(withParent("#user-name")).getStyle("visibility"), "visible");
    }
}
