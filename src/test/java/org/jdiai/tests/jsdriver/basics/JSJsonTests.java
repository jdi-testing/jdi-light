package org.jdiai.tests.jsdriver.basics;

import com.google.gson.JsonObject;
import org.jdiai.Json;
import org.jdiai.jswrap.JSElement;
import org.jdiai.tests.jsdriver.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.jdiai.jswrap.JSWrapper.json;
import static org.jdiai.tests.jsdriver.states.Pages.DOMAIN;
import static org.jdiai.tests.jsdriver.states.States.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JSJsonTests extends TestInit {
    
    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
    }

    @Test
    public void jsonTest() {
        JsonObject json = json("#user-icon")
            .getJson("{ 'id': element.id, 'source': element.src, 'tag': element.tagName }");
        assertEquals(json.get("id").getAsString(), "user-icon");
        assertEquals(json.get("source").getAsString(), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(json.get("tag").getAsString(), "IMG");
    }
    @Test
    public void jsonLocatorListTest() {
        JsonObject json = json(withParent("#user-icon"))
            .getJson("{ 'id': element.id, 'source': element.src, 'tag': element.tagName }");
        assertEquals(json.get("id").getAsString(), "user-icon");
        assertEquals(json.get("source").getAsString(), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(json.get("tag").getAsString(), "IMG");
    }
    @Test
    public void jsonMultiTest() {
        atSimplePage();
        List<JsonObject> headers = json("#furniture-double-hidden th")
            .getJsonList("{ 'text': element.innerText, 'class': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).get("text").getAsString(), "");
        assertEquals(headers.get(4).get("class").getAsString(), "hidden");
        assertEquals(headers.get(4).get("tag").getAsString(), "TH");

        assertEquals(headers.get(1).get("text").getAsString(), "Name");
        assertEquals(headers.get(1).get("class").getAsString(), "");
        assertEquals(headers.get(1).get("tag").getAsString(), "TH");
    }
    @Test
    public void jsonMultiLocatorListTest() {
        atSimplePage();
        List<JsonObject> headers = json("#furniture-double-hidden", "th")
            .getJsonList("{ 'text': element.innerText, 'class': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).get("text").getAsString(), "");
        assertEquals(headers.get(4).get("class").getAsString(), "hidden");
        assertEquals(headers.get(4).get("tag").getAsString(), "TH");

        assertEquals(headers.get(1).get("text").getAsString(), "Name");
        assertEquals(headers.get(1).get("class").getAsString(), "");
        assertEquals(headers.get(1).get("tag").getAsString(), "TH");
    }

    @Test
    public void doActionTest() {
        json("#user-name").doAction("click()");
        json("#name").doAction("value='Roman'");
        json("#password").doAction("value='Jdi1234'");
        json("#login-button").doAction("click()");
    }
    @Test
    public void doActionLocatorListTest() {
        json(withParent("#user-name")).doAction("click()");
        json(inForm("#name")).doAction("value='Roman'");
        json(inForm("#password")).doAction("value='Jdi1234'");
        json(inForm("#login-button")).doAction("click()");
    }
    @Test
    public void attributeTest() {
        assertEquals(json("#user-icon").getAttribute("tagName"), "IMG");

        JSElement userName = json("#user-name");
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void attributeLocatorListTest() {
        assertEquals(json(withParent("#user-icon")).getAttribute("tagName"), "IMG");

        JSElement userName = json(withParent("#user-name"));
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void valueTest() {
        boolean isVisible = json("#user-icon").getValue(
                "let styles = getComputedStyle(element);\n" +
                        "return element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
                .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void valueLocatorListTest() {
        boolean isVisible = json(withParent("#user-icon")).getValue(
                "let styles = getComputedStyle(element);\n" +
                        "return element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
                .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void attributeListTest() {
        atSimplePage();
        List<String> headers = json("#products th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesListLocatorListTest() {
        atSimplePage();
        List<String> headers = json("#products", "th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesTest() {
        Json attributes = json("#user-icon").getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void attributesLocatorListTest() {
        Json attributes = json(withParent("#user-icon")).getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void multiAttributesTest() {
        atSimplePage();
        List<Json> headers = json("#furniture-double-hidden th").getMultiAttributes("innerText", "className ", "tagName");
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).get("innerText"), "");
        assertEquals(headers.get(4).get("className "), "hidden");
        assertEquals(headers.get(4).get("tagName"), "TH");

        assertEquals(headers.get(1).get("innerText"), "Name");
        assertEquals(headers.get(1).get("className "), "");
        assertEquals(headers.get(1).get("tagName"), "TH");
    }
    @Test
    public void multiAttributesLocatorListTest() {
        atSimplePage();
        List<Json> headers = json("#furniture-double-hidden", "th").getMultiAttributes("innerText", "className", "tagName");
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).get("innerText"), "");
        assertEquals(headers.get(4).get("className"), "hidden");
        assertEquals(headers.get(4).get("tagName"), "TH");

        assertEquals(headers.get(1).get("innerText"), "Name");
        assertEquals(headers.get(1).get("className"), "");
        assertEquals(headers.get(1).get("tagName"), "TH");
    }

    @Test
    public void styleTest() {
        String visibility = json("#user-name").getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = json("#user-name").getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void allStylesTest() {
        Json styles = json("#user-name").getAllStyles();
        assertEquals(styles.size(), 320);
        String visibility = styles.get("visibility");
        assertEquals(visibility, "hidden");
    }
    @Test
    public void styleLocatorListTest() {
        String visibility = json(withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = json(withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void stylesTest() {
        Json styles = json("#user-icon").getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesLocatorListTest() {
        Json styles = json(withParent("#user-icon")).getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesListTest() {
        atSimplePage();
        List<String> visibility = json("#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        assertEquals(visibility.get(1), "visible");
    }
    @Test
    public void stylesListLocatorListTest() {
        atSimplePage();
        List<String> visibility = json("#furniture-double-hidden", "th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        assertEquals(visibility.get(1), "visible");
    }
    @Test
    public void multiStylesTest() {
        atSimplePage();
        List<Json> visibility = json("#furniture-double-hidden th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0).get("visibility"), "hidden");
        assertEquals(visibility.get(0).get("display"), "none");

        assertEquals(visibility.get(1).get("visibility"), "visible");
        assertEquals(visibility.get(1).get("display"), "table-cell");
    }
    @Test
    public void multiStylesLocatorListTest() {
        atSimplePage();
        List<Json> visibility = json("#furniture-double-hidden", "th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0).get("visibility"), "hidden");
        assertEquals(visibility.get(0).get("display"), "none");

        assertEquals(visibility.get(1).get("visibility"), "visible");
        assertEquals(visibility.get(1).get("display"), "table-cell");
    }
}
