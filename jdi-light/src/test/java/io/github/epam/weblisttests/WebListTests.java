package io.github.epam.weblisttests;

import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class WebListTests {
    private String element0Text = "0 element";
    private String element1Text = "1 element";
    private By locator = new By.ByCssSelector("");
    private List<WebElement> list;
    private WebList webList;
    private WebElement element0;
    private WebElement element1;

    @BeforeClass
    public void before() {
        list = new ArrayList<>();
        element0 = mock(WebElement.class);
        element1 = mock(WebElement.class);
        list.add(element0);
        list.add(element1);
        when(element0.getText()).thenReturn(element0Text);
        when(element1.getText()).thenReturn(element1Text);
    }

    @Test
    public void seleniumWebListTest() {
        webList = new WebList(list);
        assertEquals(webList.get(0).getText(), element0Text);
        assertEquals(webList.get(1).getText(), element1Text);
    }

    @Test
    public void jdiWebListTest() {
        webList = new WebList(locator, 1);
        webList.setWebElements(list);
        assertEquals(webList.get(1).getText(), element0Text);
        assertEquals(webList.get(2).getText(), element1Text);
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void jdiWebListNullTest() {
        webList = new WebList(locator, 1);
        webList.setWebElements(list);
        webList.get(0);
    }
}
