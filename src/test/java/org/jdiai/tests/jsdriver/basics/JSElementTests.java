package org.jdiai.tests.jsdriver.basics;

import org.jdiai.Json;
import org.jdiai.jswrap.JSElement;
import org.jdiai.tests.jsdriver.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.jdiai.jswrap.JSWrapper.element;
import static org.jdiai.tests.jsdriver.states.Pages.DOMAIN;
import static org.jdiai.tests.jsdriver.states.States.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JSElementTests extends TestInit {

    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
    }

    @Test
    public void doActionTest() {
        element("#user-name").doAction("click()");
        element("#name").doAction("value='Roman'");
        element("#password").doAction("value='Jdi1234'");
        element("#login-button").doAction("click()");
    }
    @Test
    public void doActionLocatorListTest() {
        element(withParent("#user-name")).doAction("click()");
        element(inForm("#name")).doAction("value='Roman'");
        element(inForm("#password")).doAction("value='Jdi1234'");
        element(inForm("#login-button")).doAction("click()");
    }
    @Test
    public void attributeTest() {
        assertEquals(element("#user-icon").getAttribute("tagName"), "IMG");

        JSElement userName = element("#user-name");
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void attributeLocatorListTest() {
        assertEquals(element(withParent("#user-icon")).getAttribute("tagName"), "IMG");

        JSElement userName = element(withParent("#user-name"));
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void valueTest() {
        boolean isVisible = element("#user-icon").getValue(
    "let styles = getComputedStyle(element);\n" +
            "return element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
                .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void valueLocatorListTest() {
        boolean isVisible = element(withParent("#user-icon")).getValue(
    "let styles = getComputedStyle(element);\n" +
            "return element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
                .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void attributeListTest() {
        atSimplePage();
        List<String> headers = element("#products th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesListLocatorListTest() {
        atSimplePage();
        List<String> headers = element("#products", "th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesTest() {
        Json attributes = element("#user-icon").getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void attributesLocatorListTest() {
        Json attributes = element(withParent("#user-icon")).getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void multiAttributesTest() {
        atSimplePage();
        List<Json> headers = element("#furniture-double-hidden th").getMultiAttributes("innerText", "className ", "tagName");
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
        List<Json> headers = element("#furniture-double-hidden", "th").getMultiAttributes("innerText", "className", "tagName");
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
        String visibility = element("#user-name").getStyle("visibility");
        //String visibility = element("#user-name").getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = element("#user-name").getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void allStylesTest() {
        Json styles = element("#user-name").getAllStyles();
        assertEquals(styles.size(), 320);
        String visibility = styles.get("visibility");
        assertEquals(visibility, "hidden");
    }
    @Test
    public void styleLocatorListTest() {
        String visibility = element(withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = element(withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void stylesTest() {
        Json styles = element("#user-icon").getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesLocatorListTest() {
        Json styles = element(withParent("#user-icon")).getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesListTest() {
        atSimplePage();
        List<String> visibility = element("#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        assertEquals(visibility.get(1), "visible");
    }
    @Test
    public void stylesListLocatorListTest() {
        atSimplePage();
        List<String> visibility = element("#furniture-double-hidden", "th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        assertEquals(visibility.get(1), "visible");
    }
    @Test
    public void multiStylesTest() {
        atSimplePage();
        List<Json> visibility = element("#furniture-double-hidden th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0).get("visibility"), "hidden");
        assertEquals(visibility.get(0).get("display"), "none");

        assertEquals(visibility.get(1).get("visibility"), "visible");
        assertEquals(visibility.get(1).get("display"), "table-cell");
    }
    @Test
    public void multiStylesLocatorListTest() {
        atSimplePage();
        List<Json> visibility = element("#furniture-double-hidden", "th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0).get("visibility"), "hidden");
        assertEquals(visibility.get(0).get("display"), "none");

        assertEquals(visibility.get(1).get("visibility"), "visible");
        assertEquals(visibility.get(1).get("display"), "table-cell");
    }
}
