package io.github.epam.tests;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.com.pages.UIElementContactFormPage;
import io.github.epam.TestsInit;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static io.github.com.pages.UIElementContactFormPage.*;
import static io.github.epam.EpamGithubSite.contactFormPage;
import static io.github.epam.EpamGithubSite.metalAndColorsPage;
import static io.github.epam.tests.epam.steps.Preconditions.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class UIElementTests extends TestsInit {

    @BeforeMethod
    public void before() {
        initElements(UIElementContactFormPage.class);
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
    }
    @Test
    public void click() {
        submit.click();
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void sendKeysAndClear() {
        description.sendKeys("Hello world!");
        assertEquals(description.getText(), "Hello world!");
        description.clear();
        assertEquals(description.getText(), "");
    }
    @Test
    public void getTagName() {
        assertEquals(submit.getTagName(), "button");
    }
    @Test
    public void getAttribute() {
        assertEquals(submit.getAttribute("type"), "submit");
    }
    @Test
    public void checkIfSelected() {
        assertTrue(forCalculateOne.isSelected());
    }
    @Test
    public void checkIfDeselected() {
        Assert.assertTrue(forCalculateThree.isDeselected());
    }
    @Test
    public void checkIfEnabled() {
        assertTrue(submit.isEnabled());
    }

    @Test
    public void isDisplayed() {
        assertTrue(submit.isDisplayed());
    }
    @Test
    public void isHidden() {
        assertTrue(submitNotDisplayed.isHidden());
    }
    @Test
    public void cantFindBySmartLocator() {
        assertTrue(smartLocator.isHidden());
    }

    private WebElement getSeleniumElement() {
        return getDriver().findElement(By.xpath("//*[.='Submit']"));
    }
    @Test
    public void getLocation() {
        assertEquals(submit.getLocation(), getSeleniumElement().getLocation());
    }
    @Test
    public void getSize() {
        assertEquals(submit.getSize(), getSeleniumElement().getSize());
    }
    @Test
    public void getRect() {
        assertEquals(submit.getRect(), getSeleniumElement().getRect());
    }
    @Test
    public void jsExecute() {
        submit.jsExecute("click()");
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void input() {
        description.input("Hello world!");
        assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void setTextGetText() {
        description.setText("Hello world!");
        assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void clickPoint() {
        submit.click(10, 10);
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void isClickable() {
        assertTrue(submit.isClickable());
    }
    @Test
    public void clickCENTER() {
        submit.click(ElementArea.CENTER);
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void select() {
        submit.select();
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void setAttribute() {
        String type = result.getAttribute("type");
        result.setAttribute("type", type + " happyType");
        assertEquals(result.attr("type"), type + " happyType");
        result.setAttribute("type", type);
        assertEquals(result.attr("type"), type);
    }
    @Test
    public void getAllAttributes() {
        assertEquals(submit.getAllAttributes().toString(), "class:uui-button dark-blue,type:submit");
    }

    @Test
    public void isExist() {
        assertTrue(submit.isExist());
    }
    @Test
    public void isNotExist() {
        assertTrue(submitNotDisplayed.isNotExist());
    }
    @Test
    public void classes() {
        assertEquals(submit.classes(), new ArrayList<>(Arrays.asList("uui-button", "dark-blue")));
    }
    @Test
    public void hasClass() {
        assertTrue(submit.hasClass("uui-button"));
        assertTrue(submit.hasClass("dark-blue"));
    }

    @Test
    public void likeClass() {
        assertEquals(submit.classLike("button"), "uui-button");
        assertEquals(submit.classLike("button", StringUtils::endsWith), "uui-button");
    }
    @Test
    public void hasNotClass() {
        assertFalse(submit.hasClass("no-class"));
    }
    @Test
    public void hasAttribute() {
        assertTrue(submit.hasAttribute("class"));
        assertTrue(submit.hasAttribute("type"));
    }
    @Test
    public void printHtml() {
        assertEquals(submit.printHtml(), "<button class=\"uui-button dark-blue\" type=\"submit\">Submit</button>");
    }
    @Test
    public void hasNotAttribute() {
        assertFalse(submit.hasAttribute("no-attr"));
    }


    @Test
    public void highlight() {
        String style = (result.getAttribute("style"));
        result.highlight();
    }
    @Test
    public void highlightWithColor() {
        String style = (result.getAttribute("style"));
        result.highlight("green");
    }
    @Test
    public void setValueGetValue() {
        description.setValue("Hello world!");
        assertEquals(description.getValue(), "Hello world!");
        description.clear();
    }

    //region Aliases
    @Test
    public void attr() {
        assertEquals(submit.attr("type"), "submit");
    }
    @Test
    public void attrs() {
        assertEquals(submit.attrs().toString(), "class:uui-button dark-blue,type:submit");
    }
    @Test
    public void text() {
        assertEquals(submit.text(), "SUBMIT");
    }
    //end region

    @Test
    public void isAssert() {
        IsAssert isAssertSubmit = new IsAssert();
        isAssertSubmit.set(submit);
        isAssertSubmit.text("SUBMIT");
        isAssertSubmit.attr("type", "submit");
        isAssertSubmit.tag("button");
        isAssertSubmit.cssClass("uui-button");
        isAssertSubmit.cssClass("dark-blue");
        isAssertSubmit.classValue("uui-button dark-blue");

        IsAssert isAssertForCalculateOne = new IsAssert();
        isAssertForCalculateOne.set(forCalculateOne);
        isAssertForCalculateOne.selected();
        IsAssert isAssertForCalculateThree = new IsAssert();
        isAssertForCalculateThree.set(forCalculateThree);
        isAssertForCalculateThree.deselected();
    }

    //region annotations
    @Test
    public void clickArea() {
        submitClickArea.click();
    }
    @Test
    public void getTextAs() {
        submit.click();
        assertEquals(summPanel.sumGetTextAs.getText(), "Summary: 3");
    }

    @Test
    public void findsFromRoot() {
        submit.click();
        WebList results = summPanel.sumItems.finds(By.tagName("li"));
        assertEquals(results.size(), 2);
        assertEquals(results.get(1).getText(), "Summary: 3");
        assertEquals(results.get(2).getText(), "Vegetables:");
    }

    @Test
    public void findFromRoot() {
        submit.click();
        assertEquals(summPanel.sumItems.find(By.tagName("li")).getText(), "Summary: 3");
    }

    @Test
    public void isRoot() {
        assertTrue(summPanel.sumGetTextAs.locator.isRoot());
    }
    @Test
    public void setTextAs() {
        descriptionSetTextAs.input("Hello world!");
        assertEquals(descriptionSetTextAs.getText(), "Hello world!");
        descriptionSetTextAs.clear();
    }
    @Test
    public void noWait() {
        assertTrue(submitNotDisplayedNoWait.isHidden());
    }
    @Test
    public void waitTimeout() {
        descriptionWaitTimeout.input("Hello world!");
        assertEquals(descriptionWaitTimeout.getText(), "Hello world!");
        descriptionWaitTimeout.clear();
    }
    @Test
    public void name() {
        assertEquals(submitNotDisplayedNoWait.getName(), "HappyName");
    }
    @Test
    public void get() {
        submit.click();
        assertEquals(sumGet.getText(), "Summary: 3");
    }
    @Test
    public void getInView() {
        assertTrue(submitGetShowInView.isClickable());
        assertTrue(submitGetShowInView.isDisplayed());
    }
    @Test
    public void pageName() {
        assertEquals(submitPage.getPage().getTitle(), metalAndColorsPage.getTitle());
    }
    @Test
    public void sId() {
        assertEquals(sId.getLocator().toString(), "By.cssSelector: #s-id");
    }
    @Test
    public void sText() {
        assertEquals(sText.getLocator().toString(), "By.xpath: .//*/text()[normalize-space(.) = \"SText\"]/parent::*");
    }
    @Test
    public void smart() {
        assertEquals(smart.getLocator().toString(), "By.cssSelector: [name='smart']");
    }
    @Test
    public void smartId() {
        assertEquals(smartId.getLocator().toString(), "By.cssSelector: [id='smart']");
    }
    @Test
    public void sClass() {
        assertEquals(sClass.getLocator().toString(), "By.cssSelector: .s-class");
    }
    @Test
    public void findBy() {
        assertEquals(findBy.getLocator().toString(), "By.cssSelector: findBy");
    }
    @Test
    public void findByNull() {
        assertEquals(findByNull.toString(), "UIElementContactFormPage.findByNull (smart: #find-by-null)");
    }
    @Test
    public void uiNull() {
        assertEquals(uiNull.toString(), "UIElementContactFormPage.uiNull (css='')");
    }
    @Test
    public void visualCheck() {
        assertTrue(visualCheck.params.has("visualCheck"));
    }
    //end region
}