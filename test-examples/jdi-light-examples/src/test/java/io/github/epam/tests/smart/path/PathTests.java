package io.github.epam.tests.smart.path;

import io.github.epam.StaticTestsInit;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static io.github.com.StaticSite.*;
import static io.github.epam.enums.Navigation.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;
import static java.util.Arrays.*;
import static org.testng.Assert.*;

public class PathTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
    }
    @Test
    public void complexTest() {
        List<Object> bys = searchBy(By.xpath("//*[text()='Description']"));
        assertEquals(bys.size(), 1);
        assertEquals(bys.get(0), By.xpath("//*[text()='Description']"));
        assertEquals(getElement(bys).getText(), "Description");

        bys = searchBy(By.cssSelector("input[type=text][4]"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).findElement(By.xpath("..")).getText(), "Last Name");

        navigationL.select(Service);
        bys = searchBy(By.cssSelector(".sidebar-menu>li[3]li[ui='label'][2]span"));
        assertEquals(bys.size(), 5);
        assertEquals(getElement(bys).getText(), "Dates");

        bys = searchBy(By.cssSelector("input[type=text][4]<"));
        assertEquals(bys.size(), 3);
        assertEquals(getElement(bys).getText(), "Last Name");
        assertEquals(getElement(bys).getTagName(), "div");

        bys = searchBy(By.cssSelector("input[type=text][4]<label"));
        assertEquals(bys.size(), 4);
        assertEquals(getElement(bys).getText(), "Last Name");
        assertEquals(getElement(bys).getTagName(), "label");

        bys = searchBy(By.cssSelector("input[type=text][4]<<<<"));
        assertEquals(bys.size(), 3);
        assertEquals(getElement(bys).getTagName(), "form");

        bys = searchBy(By.cssSelector("#contact-form['Last Name']"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).getTagName(), "label");
        assertEquals(getElement(bys).getAttribute("for"), "last-name");

        bys = searchBy(By.cssSelector("#contact-form[*'Last N']"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).getTagName(), "label");
        assertEquals(getElement(bys).getAttribute("for"), "last-name");
    }

    private WebElement getElement(List<Object> locators) {
        SearchContext ctx = getDriver();
        List<WebElement> els = null;
        for (Object locator : locators) {
            if (isClass(locator.getClass(), By.class))
                els = els == null
                    ? ctx.findElements((By)locator)
                    : els.get(0).findElements((By)locator);
            else if (isClass(locator.getClass(), Integer.class))
                els = asList(els.get((Integer)locator-1));
        }
        return els.get(0);
    }
}
