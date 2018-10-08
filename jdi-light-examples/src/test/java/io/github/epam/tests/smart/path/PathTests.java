package io.github.epam.tests.smart.path;

import io.github.epam.StaticTestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.searchBy;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.navigationL;
import static io.github.com.StaticSite.navigationS;
import static io.github.epam.enums.Navigation.Service;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

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
        assertEquals(getElement(bys).getAttribute("for"), "LastName");

        bys = searchBy(By.cssSelector("#contact-form[*'Last N']"));
        assertEquals(bys.size(), 2);
        assertEquals(getElement(bys).getTagName(), "label");
        assertEquals(getElement(bys).getAttribute("for"), "LastName");
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
