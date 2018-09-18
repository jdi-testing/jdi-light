package io.github.epam.tests.staticPO;

import io.github.epam.StaticTestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.searchBy;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.*;
import static io.github.epam.enums.NavigationNums.nContactForm;
import static io.github.epam.enums.NavigationNums.nHome;
import static io.github.epam.tests.staticPO.steps.Preconditions.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.*;
import static staticPageObject.StaticSite.*;
import static staticPageObject.pages.HomePage.githubLink;
import static staticPageObject.pages.HomePage.jdiText;
import static staticPageObject.pages.MetalAndColorsPage.colors;
import static staticPageObject.pages.MetalAndColorsPage.metals;

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

        bys = searchBy(By.cssSelector(".sidebar-menu>li[3][ui='label'][2]span"));
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
                els = asList(els.get((Integer)locator));
        }
        return els.get(0);
    }
}
