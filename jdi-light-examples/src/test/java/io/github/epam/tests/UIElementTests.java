package io.github.epam.tests;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.tools.map.MapArray;
import io.github.com.pages.UIElementContactFormPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
        Assert.assertEquals(forCalculateOne.isSelected(), true);
    }
    @Test
    public void checkIfDeselected(){
        Assert.assertEquals(forCalculateThree.isDeselected(), true);
    }
    @Test
    public void checkIfEnabled(){
        Assert.assertEquals(submit.isEnabled(), true);
    }
    //TODO add not enabled, possible for button on another page
    @Test
    public void isDisplayed(){
        Assert.assertEquals(submit.isDisplayed(), true);
    }
    @Test
    public void isHidden(){
        Assert.assertEquals(submitNotDisplayed.isHidden(), true);
    }
    @Test
    public void cantFindBySmartLocator(){
        try {
            //if no RuntimeException catched, test will fail on this step
            Assert.assertEquals(smartLocator.isHidden(), "some text");
       } catch (RuntimeException exception){ }
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
        Assert.assertEquals(submit.isClickable(), true);
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
        Assert.assertEquals(submit.isExist(), true);
    }
    @Test
    public void isNotExist(){
        Assert.assertEquals(submitNotDisplayed.isNotExist(), true);
    }
    @Test
    public void classes(){
        ArrayList<String> list = new ArrayList<>();
        list.add("uui-button");
        list.add("dark-blue");
        Assert.assertEquals(submit.classes(), list);
    }
    @Test
    public void hasClass() {
        Assert.assertEquals(submit.hasClass("uui-button"), true);
        Assert.assertEquals(submit.hasClass("dark-blue"), true);
    }
    @Test
    public void hasNotClass(){
        Assert.assertEquals(submit.hasClass("no-class"), false);
    }
    @Test
    public void hasAttribute() {
        Assert.assertEquals(submit.hasAttribute("class"), true);
        Assert.assertEquals(submit.hasAttribute("type"), true);
    }
    @Test
    public void printHtml(){
        Assert.assertEquals(submit.printHtml(), "<button class=\"uui-button dark-blue\" type=\"submit\">Submit</button>");
    }
    @Test
    public void hasNotAttribute(){
        Assert.assertEquals(submit.hasAttribute("no-attr"), false);
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
        MapArray<String, String> map = new MapArray<String, String>();
        map.add("class", "uui-button dark-blue");
        map.add("type", "submit");
        Assert.assertEquals(submit.attrs(), map);
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
