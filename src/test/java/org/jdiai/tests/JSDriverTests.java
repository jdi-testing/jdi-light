package org.jdiai.tests;

import com.google.gson.JsonObject;
import org.jdiai.TestInit;
import org.jdiai.entity.Link;
import org.jdiai.entity.LinkHtml;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSDriverTests extends TestInit {

    @BeforeMethod
    public void logout() {
        driver().manage().deleteAllCookies();
        driver().get(HOME_PAGE);
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
    @Test
    public void toObjectTests() {
        JsonObject json = js("#user-icon").getOneJson("{ \"tag\": element.tagName, \"ref\": element.src }");
        Link link = js("#user-icon").getOne(Link.class, "{ \"tag\": element.tagName, \"ref\": element.src }");
        assertEquals(link.tag, "IMG");
        assertEquals(link.ref, "https://jdi-testing.github.io/jdi-light/images/icons/user-icon.jpg");
        assertEquals(json.get("ref").getAsString(), link.ref);
    }
    @Test
    public void toObjectAttrTests() {
        JsonObject json = js("#user-icon").getOneJson("tagName", "src");
        LinkHtml link = js("#user-icon").getOne(LinkHtml.class, "tagName", "src");
        assertEquals(link.tagName, "IMG");
        assertEquals(link.src, "https://jdi-testing.github.io/jdi-light/images/icons/user-icon.jpg");
        assertEquals(json.get("src").getAsString(), link.src);
    }
}
