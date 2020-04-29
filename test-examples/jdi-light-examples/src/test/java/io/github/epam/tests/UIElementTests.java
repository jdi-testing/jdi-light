package io.github.epam.tests;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.ElementArea;
import io.github.com.pages.UIElementContactFormPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static io.github.com.pages.UIElementContactFormPage.*;
import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.tests.epam.steps.Preconditions.*;
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
    public void getTagName(){
        assertEquals(submit.getTagName(), "button");
    }
    @Test
    public void getAttribute(){
        assertEquals(submit.getAttribute("type"), "submit");
    }
    @Test
    public void checkIfSelected(){
        assertTrue(forCalculateOne.isSelected());
    }
    @Test
    public void checkIfDeselected(){
        Assert.assertTrue(forCalculateThree.isDeselected());
    }
    @Test
    public void checkIfEnabled(){
        assertTrue(submit.isEnabled());
    }
    //TODO add not enabled, possible for button on another page
    @Test
    public void isDisplayed(){
        assertTrue(submit.isDisplayed());
    }
    @Test
    public void isHidden(){
        assertTrue(submitNotDisplayed.isHidden());
    }
    @Test
    public void cantFindBySmartLocator(){
        assertTrue(smartLocator.isHidden());
    }

    private WebElement getSeleniumElement() {
        return getDriver().findElement(By.xpath("//*[.='Submit']"));
    }
    @Test
    public void getLocation(){
        assertEquals(submit.getLocation(), getSeleniumElement().getLocation());
    }
    @Test
    public void getSize(){
        assertEquals(submit.getSize(), getSeleniumElement().getSize());
    }
    @Test
    public void getRect(){
        assertEquals(submit.getRect(), getSeleniumElement().getRect());
    }
    @Test
    public void jsExecute(){
        submit.jsExecute("click()");
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void input(){
        description.input("Hello world!");
        assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void setTextGetText(){
        description.setText("Hello world!");
        assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void clickPoint(){
        submit.click(10, 10);
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void isClickable(){
        assertTrue(submit.isClickable());
    }
    //TODO add isNotClickable
    @Test
    public void clickCENTER(){
        submit.click(ElementArea.CENTER);
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void select(){
        submit.select();
        assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void setAttribute(){
        String type = result.getAttribute("type");
        result.setAttribute("type", type + " happyType");
        assertEquals(result.attr("type"), type + " happyType");
        result.setAttribute("type", type);
        assertEquals(result.attr("type"), type);
    }
    @Test
    public void getAllAttributes(){
        assertEquals(submit.getAllAttributes().toString(), "class:uui-button dark-blue,type:submit");
    }

    @Test
    public void isExist(){
        assertTrue(submit.isExist());
    }
    @Test
    public void isNotExist(){
        assertTrue(submitNotDisplayed.isNotExist());
    }
    @Test
    public void classes(){
        assertEquals(submit.classes(), new ArrayList<>(Arrays.asList("uui-button", "dark-blue")));
    }
    @Test
    public void hasClass() {
        assertTrue(submit.hasClass("uui-button"));
        assertTrue(submit.hasClass("dark-blue"));
    }
    @Test
    public void hasNotClass(){
        assertFalse(submit.hasClass("no-class"));
    }
    @Test
    public void hasAttribute() {
        assertTrue(submit.hasAttribute("class"));
        assertTrue(submit.hasAttribute("type"));
    }
    @Test
    public void printHtml(){
        assertEquals(submit.printHtml(), "<button class=\"uui-button dark-blue\" type=\"submit\">Submit</button>");
    }
    @Test
    public void hasNotAttribute(){
        assertFalse(submit.hasAttribute("no-attr"));
    }


    @Test
    public void highlight(){
        String style = (result.getAttribute("style"));
        result.highlight();
        result.attr("style").contains("red");
        result.setAttribute("style", style);
    }
    @Test
    public void highlightWithColor(){
        String style = (result.getAttribute("style"));
        result.highlight("green");
        result.attr("style").contains("green");
        result.setAttribute("style", style);
    }
    @Test
    public void setValueGetValue(){
        description.setValue("Hello world!");
        assertEquals(description.getValue(), "Hello world!");
        description.clear();
    }

    //region Aliases
    @Test
    public void attr(){
        assertEquals(submit.attr("type"), "submit");
    }
    @Test
    public void attrs(){
        assertEquals(submit.attrs().toString(), "class:uui-button dark-blue,type:submit");
    }
    @Test
    public void text(){
        assertEquals(submit.text(), "SUBMIT");
    }
    //end region

    @Test
    public void isAssert(){
        IsAssert isAssertSubmit = new IsAssert();
        isAssertSubmit.set(submit);
        isAssertSubmit.text("SUBMIT");
        isAssertSubmit.attr("type", "submit");
        //TODO css and with Matcher<String> if possible
        isAssertSubmit.tag("button");
        isAssertSubmit.hasClass("uui-button");
        isAssertSubmit.hasClass("dark-blue");
        isAssertSubmit.cssClass("uui-button dark-blue");

        IsAssert isAssertForCalculateOne = new IsAssert();
        isAssertForCalculateOne.set(forCalculateOne);
        isAssertForCalculateOne.selected();
        IsAssert isAssertForCalculateThree = new IsAssert();
        isAssertForCalculateThree.set(forCalculateThree);
        isAssertForCalculateThree.deselected();
    }

    //region annotations
    @Test
    public void clickArea(){
        submitClickArea.click();
    }
    @Test
    public void getTextAs(){
        submit.click();
        assertEquals(sumGetTextAs.getText(), "Summary: 3");
    }
    @Test
    public void isRoot(){
        assertTrue(sumGetTextAs.locator.isRoot);
    }
    @Test
    public void setTextAs(){
        descriptionSetTextAs.input("Hello world!");
        assertEquals(descriptionSetTextAs.getText(), "Hello world!");
        descriptionSetTextAs.clear();
    }
    @Test
    public void noWait(){
        assertTrue(submitNotDisplayedNoWait.isHidden());
    }
    @Test
    public void waitTimeout(){
        descriptionWaitTimeout.input("Hello world!");
        assertEquals(descriptionWaitTimeout.getText(), "Hello world!");
        descriptionWaitTimeout.clear();
    }
    @Test
    public void name(){
        assertEquals(submitNotDisplayedNoWait.getName(), "HappyName");
    }
    @Test
    public void get(){
        submit.click();
        assertEquals(sumGet.getText(), "Summary: 3");
    }
    @Test
    public void getInView(){
        assertTrue(submitGetShowInView.isClickable());
        assertTrue(submitGetShowInView.isDisplayed());
    }
    @Test
    public void pageName(){
        assertEquals(submitPage.getPage().getTitle(), metalAndColorsPage.getTitle());
    }
    @Test
    public void sId(){
        assertEquals(sId.getLocator().toString(), "By.cssSelector: #s-id");
    }
    @Test
    public void sText(){
        assertEquals(sText.getLocator().toString(), "By.xpath: .//*/text()[normalize-space(.) = \"S Text\"]/parent::*");
    }
    @Test
    public void smart(){
        assertEquals(smart.getLocator().toString(), "By.cssSelector: [name='smart']");
    }
    @Test
    public void smartId(){
        assertEquals(smartId.getLocator().toString(), "By.cssSelector: [id='smart']");
    }
    @Test
    public void sClass(){
        assertEquals(sClass.getLocator().toString(), "By.cssSelector: .s-class");
    }
    @Test
    public void findBy(){
        assertEquals(findBy.getLocator().toString(), "By.cssSelector: findBy");
    }
    @Test
    public void findByNull(){
        assertEquals(findByNull.toString(), "UIElementContactFormPage.findByNull (smart: #find-by-null)");
    }
    @Test
    public void uiNull(){
        assertEquals(uiNull.toString(), "UIElementContactFormPage.uiNull (css='')");
    }
    @Test
    public void visualCheck(){
        assertTrue(visualCheck.params.has("visualCheck"));
    }
    //end region
}