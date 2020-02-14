package io.github.epam.tests;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;

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
        Assert.assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void sendKeysAndClear() {
        description.sendKeys("Hello world!");
        Assert.assertEquals(description.getText(), "Hello world!");
        description.clear();
        Assert.assertEquals(description.getText(), "");
    }
    @Test
    public void getTagName(){
        Assert.assertEquals(submit.getTagName(), "button");
    }
    @Test
    public void getAttribute(){
        Assert.assertEquals(submit.getAttribute("type"), "submit");
    }
    @Test
    public void checkIfSelected(){
        Assert.assertTrue(forCalculateOne.isSelected());
    }
    @Test
    public void checkIfDeselected(){
        Assert.assertTrue(forCalculateThree.isDeselected());
    }
    @Test
    public void checkIfEnabled(){
        Assert.assertTrue(submit.isEnabled());
    }
    //TODO add not enabled, possible for button on another page
    @Test
    public void isDisplayed(){
        Assert.assertTrue(submit.isDisplayed());
    }
    @Test
    public void isHidden(){
        Assert.assertTrue(submitNotDisplayed.isHidden());
    }
    @Test
    public void cantFindBySmartLocator(){
        Assert.assertTrue(smartLocator.isHidden());
    }
    @Test
    public void getLocation(){
        Assert.assertEquals(submit.getLocation(), new Point(1042, 477));
    }
    @Test
    public void getSize(){
        Assert.assertEquals(submit.getSize(), new Dimension(82, 34));
    }
    @Test
    public void getRect(){
        Assert.assertEquals(submit.getRect(), new Rectangle(1042, 477, 34, 82));
    }
    @Test
    public void jsExecute(){
        submit.jsExecute("click()");
        Assert.assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void input(){
        description.input("Hello world!");
        Assert.assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void setTextGetText(){
        description.setText("Hello world!");
        Assert.assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void clickPoint(){
        submit.click(10, 10);
        Assert.assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void isClickable(){
        Assert.assertTrue(submit.isClickable());
    }
    //TODO add isNotClickable
    @Test
    public void clickCENTER(){
        submit.click(ElementArea.CENTER);
        Assert.assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void select(){
        submit.select();
        Assert.assertEquals(sum.getText(), "Summary: 3");
    }
    @Test
    public void setAttribute(){
        String type = result.getAttribute("type");
        result.setAttribute("type", type + " happyType");
        Assert.assertEquals(result.attr("type"), type + " happyType");
        result.setAttribute("type", type);
        Assert.assertEquals(result.attr("type"), type);
    }
    @Test
    public void getAllAttributes(){
        MapArray<String, String> map = new MapArray<String, String>();
        map.add("class", "uui-button dark-blue");
        map.add("type", "submit");
        Assert.assertEquals(submit.getAllAttributes(), map);
    }
    @Test
    public void isExist(){
        Assert.assertTrue(submit.isExist());
    }
    @Test
    public void isNotExist(){
        Assert.assertTrue(submitNotDisplayed.isNotExist());
    }
    @Test
    public void classes(){
        Assert.assertEquals(submit.classes(), new ArrayList<>(Arrays.asList("uui-button", "dark-blue")));
    }
    @Test
    public void hasClass() {
        Assert.assertTrue(submit.hasClass("uui-button"));
        Assert.assertTrue(submit.hasClass("dark-blue"));
    }
    @Test
    public void hasNotClass(){
        Assert.assertFalse(submit.hasClass("no-class"));
    }
    @Test
    public void hasAttribute() {
        Assert.assertTrue(submit.hasAttribute("class"));
        Assert.assertTrue(submit.hasAttribute("type"));
    }
    @Test
    public void printHtml(){
        Assert.assertEquals(submit.printHtml(), "<button class=\"uui-button dark-blue\" type=\"submit\">Submit</button>");
    }
    @Test
    public void hasNotAttribute(){
        Assert.assertFalse(submit.hasAttribute("no-attr"));
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
        Assert.assertEquals(description.getValue(), "Hello world!");
        description.clear();
    }

    //region Aliases
    @Test
    public void attr(){
        Assert.assertEquals(submit.attr("type"), "submit");
    }
    @Test
    public void attrs(){
        Assert.assertEquals(submit.attrs(), MapArray.map(Pair.$("class", "uui-button dark-blue"), Pair.$("type", "submit")));
        /*MapArray<String, String> map = new MapArray<String, String>();
        map.add("class", "uui-button dark-blue");
        map.add("type", "submit");
        Assert.assertEquals(submit.attrs(), map);*/
    }
    @Test
    public void text(){
        Assert.assertEquals(submit.text(), "SUBMIT");
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
