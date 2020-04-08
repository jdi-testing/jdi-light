package io.github.epam;

import com.epam.jdi.light.elements.complex.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static org.mockito.Mockito.*;

public class ListTestsInit {
    protected String element0Text = "0 element";
    protected String element1Text = "1 element";
    protected By locator = new By.ByCssSelector("");
    protected List<WebElement> list;
    protected DataList dataList;
    protected JList jList;
    protected WebList webList;
    protected WebElement element0;
    protected WebElement element1;

    @BeforeClass
    public void before() {
        list = new ArrayList<>();
        element0 = mock(WebElement.class);
        element1 = mock(WebElement.class);
        list.add(element0);
        list.add(element1);
        when(element0.getText()).thenReturn(element0Text);
        when(element1.getText()).thenReturn(element1Text);
        when(element0.isDisplayed()).thenReturn(true);
        when(element1.isDisplayed()).thenReturn(true);
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
