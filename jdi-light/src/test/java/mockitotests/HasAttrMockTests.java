package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.map.MapArray;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class HasAttrMockTests {

    private UIElement uiElement = null;
    private WebElement webElement = null;

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
        };
    }

    @BeforeMethod
    public void init() {
        uiElement = mock(UIElement.class);
        webElement = mock(WebElement.class);
    }

    @Test(expectedExceptions = {RuntimeException.class}, dataProvider = "attributesNegative"/*,expectedExceptionsMessageRegExp = "Expected: an array containing"*/)
    public void negativeTest(MapArray<String, String> actualMapAttr, String wrongAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(wrongAttr);
        /*try {uiElement.is().hasAttr(wrongAttr)}
        catch(RuntimeException exp){
            assertEquals(exp.getMessage(),)
        }*/
    }

    @Test(dataProvider = "attributesPositive")
    public void positiveTest(MapArray<String, String> actualMapAttr, String expectedAttr) {
        uiElement = Mockito.spy(new UIElement());
        //Mockito.doReturn(webElement).when(uiElement).getWebElement();
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();

        uiElement.is().hasAttr(expectedAttr);
    }

}
