package io.github.epam.tests.smart.path;

import io.github.epam.StaticTestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.searchBy;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.navigationL;
import static io.github.epam.enums.Navigation.Service;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.apache.commons.lang3.ObjectUtils.*;
import static org.testng.Assert.assertEquals;

public class PathTests extends StaticTestsInit {
    private List<Object> bys;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
    }

    @Test(description = "Tests possibility to search element by xpath")
    public void xpathTextTest() {
        bys = searchBy(By.xpath("//*[text()='Passport']"));
        assertEquals(bys.size(), 1);
        assertEquals(bys.get(0), By.xpath("//*[text()='Passport']"));
        assertEquals(getElement(bys).getText(), "Passport");
    }

    @Test(description = "Tests possibility to search element by css with index")
    public void cssIndexTest() {
        bys = searchBy(By.cssSelector("input[type=text][4]"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).findElement(By.xpath("..")).getText(), "Last Name");
    }

    @Test(description = "Tests possibility to search element by css with index")
    public void cssDeepIndexTest() {
        navigationL.select(Service);
        bys = searchBy(By.cssSelector(".sidebar-menu>li[3]li[ui='label'][2]span"));
        assertEquals(bys.size(), 5);
        assertEquals(getElement(bys).getText(), "Dates");
    }

    @Test(description = "Tests possibility to search element's parent by css with index")
    public void indexAndParentTest() {
        bys = searchBy(By.cssSelector("input[type=text][4]<"));
        assertEquals(bys.size(), 3);
        assertEquals(getElement(bys).getText(), "Last Name");
        assertEquals(getElement(bys).getTagName(), "div");
    }

    @Test(description = "Tests possibility to search element's sibling by css with index")
    public void indexAndSiblingTest() {
        bys = searchBy(By.cssSelector("input[type=text][4]<label"));
        assertEquals(bys.size(), 4);
        assertEquals(getElement(bys).getText(), "Last Name");
        assertEquals(getElement(bys).getTagName(), "label");
    }

    @Test
    public void indexAndDeepParentTest() {
        bys = searchBy(By.cssSelector("input[type=text][4]<<<<"));
        assertEquals(bys.size(), 3);
        assertEquals(getElement(bys).getTagName(), "form");
    }

    @Test
    public void fullTextTest() {
        bys = searchBy(By.cssSelector("#contact-form['Last Name']"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).getTagName(), "label");
        assertEquals(getElement(bys).getAttribute("for"), "last-name");
    }

    @Test
    public void partTextTest() {
        bys = searchBy(By.cssSelector("#contact-form[*'Last N']"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).getTagName(), "label");
        assertEquals(getElement(bys).getAttribute("for"), "last-name");
    }

    private WebElement getElement(List<Object> locators) {
        SearchContext ctx = getDriver();
        List<WebElement> els = null;
        for (Object locator : locators) {
            if (els == null) {
                if (isClass(locator.getClass(), By.class))
                    els = ctx.findElements((By) locator);
                else
                    throw exception("First locator should be by locator");
            }
            els = isClass(locator.getClass(), By.class)
                ? els.get(0).findElements((By) locator)
                : getElementsByIndex(els, locator);
        }
        if (isEmpty(els))
            throw exception("Get element failed to find at least one element");
        return els.get(0);
    }
    private List<WebElement> getElementsByIndex(List<WebElement> els, Object locator) {
        if (!isClass(locator.getClass(), Integer.class))
            throw exception("Locator should be By or integer");
        return singletonList(els.get((Integer) locator - 1));
    }
}