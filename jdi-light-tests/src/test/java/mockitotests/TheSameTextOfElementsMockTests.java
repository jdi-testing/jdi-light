package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class TheSameTextOfElementsMockTests {

    private WebList webList;
    private JList<UIElement> jList;
    private String baseText = "text";
    private String element0Text = String.format(baseText + "%s", 1);
    private String element1Text = String.format(baseText + "%s", 1);;
    private String element2Text = String.format(baseText + "%s", 2);;

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
        jList.forEach(e -> {
            iarr[0]++;
        });
        assertEquals(iarr[0], expectedNumberOfElements);
    }

    @Test
    public void numberOfUIElementsForEachLoopAltTest() {
        int i = 0;
        for (UIElement e : jList) {
            assertEquals(e.getText(), baseText + i);
            i++;
        }
    }

    @Test
    public void numberOfUIElementsForLoopTest() {
        int i = 0;
        while (i < jList.size()) {
            assertEquals(jList.get(i).getText(),
                    i != 2 ? baseText + 1 : baseText + i);
            i++;
        }
        assertEquals(i, expectedNumberOfElements);
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
