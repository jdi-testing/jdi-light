package io.github.epam.tests;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.ElementArea;
import io.github.com.pages.UIElementContactFormPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static io.github.com.pages.UIElementContactFormPage.*;
import static io.github.epam.EpamGithubSite.contactFormPage;
import static io.github.epam.tests.epam.steps.Preconditions.shouldBeLoggedIn;
import static junit.framework.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class UIElementTests extends TestsInit{

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

    @Test
    public void getLocation(){
        assertEquals(submit.getLocation(), new Point(1042, 477));
    }
    @Test
    public void getSize(){
        assertEquals(submit.getSize(), new Dimension(82, 34));
    }
    @Test
    public void getRect(){
        assertEquals(submit.getRect(), new Rectangle(1042, 477, 34, 82));
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
    //endregion

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
}
