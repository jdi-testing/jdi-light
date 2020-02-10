package io.github.epam.tests;

import com.epam.jdi.light.common.ElementArea;
import io.github.com.pages.UIElementContactFormPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void checkIfSelected(){
        Assert.assertEquals(forCalculateOne.isSelected(), true);
    }
    @Test
    public void checkIfDeselected(){
        Assert.assertEquals(forCalculateThree.isDeselected(), true);
    }
    @Test
    public void isDisplayed(){
        Assert.assertEquals(submit.isDisplayed(), true);
    }
    @Test
    public void isHidden(){
        Assert.assertEquals(submitNotDisplayed.isHidden(), true);
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
    public void input(){
        description.input("Hello world!");
        Assert.assertEquals(description.getText(), "Hello world!");
        description.clear();
    }
    @Test
    public void setText(){
        description.setText("Hello world!");
        Assert.assertEquals(description.getText(), "Hello world!");
        description.clear();
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
    public void isExist(){
        Assert.assertEquals(submit.isExist(), true);
    }
    @Test
    public void isNotExist(){
        Assert.assertEquals(submitNotDisplayed.isNotExist(), true);
    }
    @Test
    public void highlight(){
        result.highlight();
        //TODO check selection if possible
    }
}
