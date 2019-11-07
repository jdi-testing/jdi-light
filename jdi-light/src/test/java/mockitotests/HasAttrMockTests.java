package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.map.MapArray;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertTrue;

public class HasAttrMockTests {

    private UIElement uiElement = null;
    private WebElement webElement = null;
    private String exceptionMessage1 = "Expected: an array containing";
    private String exceptionMessage2 = "but: mismatches were";


    @DataProvider
    public Object[][] attributesPositive() {
        return new Object[][]{
                {new MapArray<>(new String[]{"type", "value", "class"}, new String[]{"checkbox", "option1", "form-check"}), "type"},
                {new MapArray<>(new String[]{"type", "value", "class"}, new String[]{"checkbox", "option1", "form-check"}), "value"},
                {new MapArray<>(new String[]{"type", "value", "class"}, new String[]{"", "", ""}), "class"},
                {new MapArray<>("class", "form-check"), "class"}
        };
    }

    @DataProvider
    public Object[][] attributesNegative() {
        return new Object[][]{
                {new MapArray<>(new String[]{"type", "value", "class"}, new String[]{"checkbox", "option1", "form-check"}), "type1"},
                {new MapArray<>(new String[]{"type", "value", "class"}, new String[]{"checkbox", "option1", "form-check"}), "value1"},
                {new MapArray<>(new String[]{"type", "value", "class"}, new String[]{"", "", ""}), "class1"},
                {new MapArray<>("class", "form-check"), "class1"}
        };
    }

    @BeforeMethod
    public void init() {
        uiElement = mock(UIElement.class);
        webElement = mock(WebElement.class);
    }

    //WORKING:
    // TODO: Need to add regex on exception message--DONE
    @Test(expectedExceptions = {RuntimeException.class}, dataProvider = "attributesNegative",
            expectedExceptionsMessageRegExp = ".*Expected: an array containing.*[a-zA-Z'].*but: mismatches were:.*[a-zA-Z'].*")
    public void negativeTest(MapArray<String, String> actualMapAttr, String wrongAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(wrongAttr);
    }

    //WORKING
    // TODO: Need to improve assertContains to assertEquals, more efficient String building with params
    @Test(dataProvider = "attributesNegative")
    public void negativeTest1(MapArray<String, String> actualMapAttr, String wrongAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();

        try {
            uiElement.is().hasAttr(wrongAttr);
        } catch (RuntimeException exp) {
            assertTrue(exp.getMessage().contains(exceptionMessage1));
            assertTrue(exp.getMessage().contains(wrongAttr));
            assertTrue(exp.getMessage().contains(exceptionMessage2));
            //assertTrue(exp.getMessage().contains(actualMapAttr.keys().toString()));
            //System.out.println(actualMapAttr.keys());
            assertTrue(exp.getMessage().contains(actualMapAttr.key(0)));
            assertTrue(exp.getMessage().contains(actualMapAttr.key(1)));
            assertTrue(exp.getMessage().contains(actualMapAttr.key(2)));

            /*assertEquals(exp.getMessage().trim(),(exceptionMessage1+" "+wrongAttr+exceptionMessage2+actualMapAttr.key(0)
            +", was "+actualMapAttr.key(1)+", was "+ actualMapAttr.key(2)).trim());*/
        }
    }

    //WORKING
   //TODO: Improve Chrome closing (through webElement) -First try in positiveTest1(trey are the same)
    @Test(dataProvider = "attributesPositive")
    public void positiveTest(MapArray<String, String> actualMapAttr, String expectedAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(expectedAttr);
    }

    @DataProvider
    public Object[][] attributesPositive1() {
        return new Object[][]{
                {new MapArray<>("type", ""), "type"}
        };
    }

    //Copy of positiveTest, here tried to improve Chrome closing
    //TODO: Improve Chrome closing (through webElement)
    @Test(dataProvider = "attributesPositive1")
    public void positiveTest1(MapArray<String, String> actualAttr, String expectedAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(webElement).when(uiElement).getWebElement();
        Mockito.doReturn(actualAttr.key(0)).when(webElement).getAttribute(expectedAttr);
        Mockito.doReturn(actualAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(expectedAttr);
    }

}
