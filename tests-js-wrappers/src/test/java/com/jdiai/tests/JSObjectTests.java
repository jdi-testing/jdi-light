package com.jdiai.tests;

import com.jdiai.TestInit;
import com.jdiai.entities.Header;
import com.jdiai.entities.RawHeader;
import com.jdiai.entities.TextHtml;
import com.jdiai.entities.TextInfo;
import com.jdiai.jsproducer.Json;
import com.jdiai.jswraper.JSElement;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.Pages.DOMAIN;
import static com.jdiai.Pages.SIMPLE_PAGE;
import static com.jdiai.jswraper.JSWrapper.element;
import static com.jdiai.states.States.*;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestNGListener.class)
public class JSObjectTests implements TestInit {
    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
    }

    @Test
    public void entityFromJsonTest() {
        TextInfo jsObject = element(TextInfo.class, "#user-name").getEntity(
        "{ 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void entityFromJsonLocatorListTest() {
        TextInfo jsObject = element(TextInfo.class, withParent("#user-name")).getEntity(
        "{ 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void entityFromAttributesTest() {
        TextHtml jsObject = element(TextHtml.class, "#user-name")
            .getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void entityFromAttributesLocatorListTest() {
        TextHtml jsObject = element(TextHtml.class, withParent("#user-name"))
            .getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void multiEntitiesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Header> headers = element(Header.class, "#furniture-double-hidden th")
            .getEntityList("{ 'text': element.innerText, 'visibility': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).text, "");
        assertEquals(headers.get(4).visibility, "hidden");
        assertEquals(headers.get(4).tag, "TH");

        Header expected = new Header().set(h-> { h.text = "Name"; h.visibility = ""; h.tag = "TH"; });
        assertEquals(headers.get(1), expected);
    }
    @Test
    public void multiEntitiesLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Header> headers = element(Header.class, "#furniture-double-hidden", "th")
            .getEntityList("{ 'text': element.innerText, 'visibility': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).text, "");
        assertEquals(headers.get(4).visibility, "hidden");
        assertEquals(headers.get(4).tag, "TH");

        Header expected = new Header().set(h-> { h.text = "Name"; h.visibility = ""; h.tag = "TH"; });
        assertEquals(headers.get(1), expected);
    }
    @Test
    public void multiEntitiesByAttrTest() {
        loggedInAt(SIMPLE_PAGE);
        List<RawHeader> headers = element(RawHeader.class, "#furniture-double-hidden th")
            .getEntityList(asList("innerText", "className", "tagName"));
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).innerText, "");
        assertEquals(headers.get(4).className, "hidden");
        assertEquals(headers.get(4).tagName, "TH");

        RawHeader expected = new RawHeader().set(h-> { h.innerText = "Name"; h.className = ""; h.tagName = "TH"; });
        assertEquals(headers.get(1), expected);
    }
    @Test
    public void multiEntitiesByAttrLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<RawHeader> headers = element(RawHeader.class, "#furniture-double-hidden", "th")
            .getEntityList(asList("innerText", "className", "tagName"));
        assertEquals(headers.size(), 6);
        assertEquals(headers.get(4).innerText, "");
        assertEquals(headers.get(4).className, "hidden");
        assertEquals(headers.get(4).tagName, "TH");

        RawHeader expected = new RawHeader().set(h-> { h.innerText = "Name"; h.className = ""; h.tagName = "TH"; });
        assertEquals(headers.get(1), expected);
    }

    @Test
    public void doActionTest() {
        element(TextInfo.class, "#user-name").doAction("click()");
        element(TextInfo.class, "#name").doAction("value='Roman'");
        element(TextInfo.class, "#password").doAction("value='Jdi1234'");
        element(TextInfo.class, "#login-button").doAction("click()");
    }
    @Test
    public void doActionLocatorListTest() {
        element(TextInfo.class, withParent("#user-name")).doAction("click()");
        element(TextInfo.class, inForm("#name")).doAction("value='Roman'");
        element(TextInfo.class, inForm("#password")).doAction("value='Jdi1234'");
        element(TextInfo.class, inForm("#login-button")).doAction("click()");
    }
    @Test
    public void attributeTest() {
        assertEquals(element(TextInfo.class, "#user-icon").getAttribute("tagName"), "IMG");

        JSElement userName = element(TextInfo.class, "#user-name");
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void attributeLocatorListTest() {
        assertEquals(element(TextInfo.class, withParent("#user-icon")).getAttribute("tagName"), "IMG");

        JSElement userName = element(TextInfo.class, withParent("#user-name"));
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void valueTest() {
        boolean isVisible = element(TextInfo.class, "#user-icon").getValue(
            "return element && styles.visibility === 'visible' && styles.display !== 'none'")
            .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void valueLocatorListTest() {
        boolean isVisible = element(TextInfo.class, withParent("#user-icon")).getValue(
            "return element && styles.visibility === 'visible' && styles.display !== 'none'")
            .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void attributeListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> headers = element(TextInfo.class, "#products th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesListLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> headers = element(TextInfo.class, "#products", "th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesTest() {
        Json attributes = element(TextInfo.class, "#user-icon").getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void attributesLocatorListTest() {
        Json attributes = element(TextInfo.class, withParent("#user-icon")).getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void multiAttributesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> headers = element(TextInfo.class, "#furniture-double-hidden th").getMultiAttributes("innerText", "className ", "tagName");
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
        loggedInAt(SIMPLE_PAGE);
        List<Json> headers = element(TextInfo.class, "#furniture-double-hidden", "th").getMultiAttributes("innerText", "className", "tagName");
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
        String visibility = element(TextInfo.class, "#user-name").getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = element(TextInfo.class, "#user-name").getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void allStylesTest() {
        Json styles = element("#user-name").getAllStyles();
        assertTrue(styles.size() > 10);
        String visibility = styles.get("visibility");
        assertEquals(visibility, "hidden");
    }
    @Test
    public void styleLocatorListTest() {
        String visibility = element(TextInfo.class, withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = element(TextInfo.class, withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void stylesTest() {
        Json styles = element(TextInfo.class, "#user-icon").getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesLocatorListTest() {
        Json styles = element(TextInfo.class, withParent("#user-icon")).getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> visibility = element(TextInfo.class, "#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        assertEquals(visibility.get(1), "visible");
    }
    @Test
    public void stylesListLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> visibility = element(TextInfo.class, "#furniture-double-hidden", "th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        assertEquals(visibility.get(1), "visible");
    }
    @Test
    public void multiStylesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> visibility = element(TextInfo.class, "#furniture-double-hidden th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0).get("visibility"), "hidden");
        assertEquals(visibility.get(0).get("display"), "none");

        assertEquals(visibility.get(1).get("visibility"), "visible");
        assertEquals(visibility.get(1).get("display"), "table-cell");
    }
    @Test
    public void multiStylesLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> visibility = element(TextInfo.class, "#furniture-double-hidden", "th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0).get("visibility"), "hidden");
        assertEquals(visibility.get(0).get("display"), "none");

        assertEquals(visibility.get(1).get("visibility"), "visible");
        assertEquals(visibility.get(1).get("display"), "table-cell");
    }
}
