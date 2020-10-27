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
        assertEquals(js("#user-icon").attribute("tagName").getOne().asString(), "IMG");
        assertEquals(js("#user-name").attribute("innerText").getOne().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").attribute("textContent").getOne().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").attribute("innerHTML").getOne().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js("#user-name").invoke("click()");
        js("#name").invoke("value='Roman'");
        js("#password").invoke("value='Jdi1234'");
        js("#login-button").invoke("click()");

        assertEquals(js("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void chainTest() {
        assertEquals(js("#user-icon").attribute("tagName").getOneChain().asString(), "IMG");
        assertEquals(js("#user-name").attribute("innerText").getOneChain().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").attribute("textContent").getOneChain().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").attribute("innerHTML").getOneChain().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js("#user-name").attribute("click()").getOneChain();
        js("#name").attribute("value='Roman'").getOneChain();
        js("#password").attribute("value='Jdi1234'").getOneChain();
        js("#login-button").attribute("click()").getOneChain();

        assertEquals(js("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void multiTest() {
        assertEquals(js("#user-icon").attribute("tagName").getOneMultiSearch().asString(), "IMG");
        assertEquals(js("#user-name").attribute("innerText").getOneMultiSearch().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").attribute("textContent").getOneMultiSearch().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").attribute("innerHTML").getOneMultiSearch().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js("#user-name").attribute("click()").getOneMultiSearch();
        js("#name").attribute("value='Roman'").getOneMultiSearch();
        js("#password").attribute("value='Jdi1234'").getOneMultiSearch();
        js("#login-button").attribute("click()").getOneMultiSearch();

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
        assertEquals(js(withParent("#user-icon")).attribute("tagName").getOne().asString(), "IMG");
        assertEquals(js(withParent("#user-name")).attribute("innerText").getOne().asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).attribute("textContent").getOne().asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).attribute("innerHTML").getOne().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js(withParent("#user-name")).attribute("click()").getOne();
        js(inForm("#name")).attribute("value='Roman'").getOne();
        js(inForm("#password")).attribute("value='Jdi1234'").getOne();
        js(inForm("#login-button")).attribute("click()").getOne();

        assertEquals(js(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void chainFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).attribute("tagName").getOneChain().asString(), "IMG");
        assertEquals(js(withParent("#user-name")).attribute("innerText").getOneChain().asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).attribute("textContent").getOneChain().asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).attribute("innerHTML").getOneChain().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js(withParent("#user-name")).attribute("click()").getOneChain();
        js(inForm("#name")).attribute("value='Roman'").getOneChain();
        js(inForm("#password")).attribute("value='Jdi1234'").getOneChain();
        js(inForm("#login-button")).attribute("click()").getOneChain();

        assertEquals(js(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void multiFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).attribute("tagName").getOneMultiSearch().asString(), "IMG");
        assertEquals(js(withParent("#user-name")).attribute("innerText").getOneMultiSearch().asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).attribute("textContent").getOneMultiSearch().asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).attribute("innerHTML").getOneMultiSearch().asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getStyle("visibility"), "hidden");

        js(withParent("#user-name")).attribute("click()").getOneMultiSearch();
        js(inForm("#name")).attribute("value='Roman'").getOneMultiSearch();
        js(inForm("#password")).attribute("value='Jdi1234'").getOneMultiSearch();
        js(inForm("#login-button")).attribute("click()").getOneMultiSearch();

        assertEquals(js(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void toObjectTests() {
        JsonObject json = js("#user-icon").json("{ \"tag\": element.tagName, \"ref\": element.src }").getOne().asJson();
        Link link = js("#user-icon").json("{ \"tag\": element.tagName, \"ref\": element.src }").getOne().asObject(Link.class);
        assertEquals(link.tag, "IMG");
        assertEquals(link.ref, "https://jdi-testing.github.io/jdi-light/images/icons/user-icon.jpg");
        assertEquals(json.get("ref").getAsString(), link.ref);
    }
    @Test
    public void toObjectAttrTests() {
        JsonObject json = js("#user-icon").attributes("tagName", "src").getOne().asJson();
        LinkHtml link = js("#user-icon").attributes("tagName", "src").getOne().asObject(LinkHtml.class);
        assertEquals(link.tagName, "IMG");
        assertEquals(link.src, "https://jdi-testing.github.io/jdi-light/images/icons/user-icon.jpg");
        assertEquals(json.get("src").getAsString(), link.src);
    }
}
