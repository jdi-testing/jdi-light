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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TheSameTextOfElementsMockTests {

    private WebList webList;
    private List<WebElement> list;
    private JList<UIElement> jList;
    private WebElement element0;
    private WebElement element1;
    private WebElement element2;
    private String element0Text = "text01";
    private String element1Text = "text01";
    private String element2Text = "text2";

    private int actualNumberOfElements = 3;
    private int loopIndex = 1;

    @BeforeMethod
    public void init() {
        element0 = mock(WebElement.class);
        element1 = mock(WebElement.class);
        element2 = mock(WebElement.class);

        list = Arrays.asList(element0, element1, element2);

        when(element0.getText()).thenReturn(element0Text);
        when(element1.getText()).thenReturn(element1Text);
        when(element2.getText()).thenReturn(element2Text);

        webList = new WebList(list);
        jList = new JList<>(list);
    }

    @Test
    public void JListNumberOfElements() {
        int NumberUIElementsInJList = jList.list().size();
        assertThat(actualNumberOfElements, is(equalTo(NumberUIElementsInJList)));
    }

    @Test
    public void WebListListNumberOfElements() {
        int NumberUIElementsInWebList = jList.list().size();
        assertThat(actualNumberOfElements, is(equalTo(NumberUIElementsInWebList)));
    }

    @Test
    public void WebListTest() {
        int NumberUIElementsInWebList = webList.list().elements(0).size();
        int actualNumberOfUIElements = webList.list().size();
        assertThat(NumberUIElementsInWebList, is(equalTo(actualNumberOfUIElements)));
    }

    @Test
    public void JListTest() {
        int NumberUIElementsInJList = jList.list().elements(0).size();
        int actualNumberOfUIElements = jList.list().size();
        assertThat(NumberUIElementsInJList, is(equalTo(actualNumberOfUIElements)));
    }

    @Test
    public void numberOfUIElementsForEachLoopTest() {
        int[] iarr = {loopIndex};
        System.out.println("------------UIElements in forEach loop----------");
        jList.forEach(e -> System.out.println(e.getText() + " " + iarr[0]++));
        assertThat(iarr[0] - 1, is(equalTo(actualNumberOfElements)));
    }

    @Test
    public void numberOfUIElementsForLoopTest() {
        int i = loopIndex;
        System.out.println("------------UIElements in for loop--------------");
        while (i < jList.size()) {
            System.out.println(jList.get(i).getText() + " " + i);
            i++;
        }
        assertThat (i - 1, is(equalTo(actualNumberOfElements)));
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
