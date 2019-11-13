package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class TheSameTextOfElementsMockTests {

    private WebList webList;
    private JList<UIElement> jList;
    private String element0Text = "text01";
    private String element1Text = "text01";
    private String element2Text = "text2";

    private int expectedNumberOfElements = 3;

    @BeforeMethod
    public void init() {
        WebElement element0 = mock(WebElement.class);
        WebElement element1 = mock(WebElement.class);
        WebElement element2 = mock(WebElement.class);

        when(element0.getText()).thenReturn(element0Text);
        when(element1.getText()).thenReturn(element1Text);
        when(element2.getText()).thenReturn(element2Text);

        List<WebElement> list = Arrays.asList(element0, element1, element2);
        webList = new WebList(list);
        jList = new JList<>(list);
    }

    @Test
    public void jListNumberOfElements() {
        assertEquals(jList.size(), expectedNumberOfElements);
    }

    @Test
    public void webListNumberOfElements() {
        assertEquals(webList.size(), expectedNumberOfElements);
    }

    @Test
    public void webListTest() {
        int shownNumberUIElements = webList.list().elements(0).size();
        int actualNumberOfUIElements = webList.list().size();
        assertEquals(shownNumberUIElements, actualNumberOfUIElements);
    }

    @Test
    public void jListTest() {
        int shownNumberUIElements = jList.list().elements(0).size();
        int actualNumberOfUIElements = jList.list().size();
        assertEquals(shownNumberUIElements, actualNumberOfUIElements);
    }

    @Test
    public void numberOfUIElementsForEachLoopTest() {
        int[] iarr = {0};
        System.out.println("------------UIElements in forEach loop----------");
        jList.forEach(e -> System.out.println(e.getText() + " " + iarr[0]++));
        assertEquals(iarr[0], expectedNumberOfElements);
    }

    @Test
    public void numberOfUIElementsForLoopTest() {
        int i = 0;
        System.out.println("------------UIElements in for loop--------------");
        while (i < jList.size()) {
            System.out.println(jList.get(i).getText() + " " + i);
            i++;
        }
        assertEquals(i, expectedNumberOfElements);
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
