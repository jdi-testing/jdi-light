package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.map.MapArray;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertTrue;

public class HasAttrMockTests {

    private static final String exceptionMessageFirstPart = "Expected: an array containing";
    private static final String exceptionMessageSecondPart = "but: mismatches were: [";
    private UIElement uiElement = null;
    private MapArray<String, String> attributesSet1 = new MapArray<>(new String[]{"type", "value", "class"},
            new String[]{"checkbox", "option1", "form-check"});
    private MapArray<String, String> attributesSet2 = new MapArray<>(new String[]{"type", "value", "class"},
            new String[]{"checkbox", "option1", "form-check"});
    private MapArray<String, String> attributesSet3 = new MapArray<>(new String[]{"type", "value", "class"},
            new String[]{"checkbox", "option1", "form-check"});
    private MapArray<String, String> attributesSet4 = new MapArray<>(new String[]{"type", "value", "class"},
            new String[]{"checkbox", "option1", "form-check"});


    @DataProvider
    public Object[][] attributesPositive() {
        return new Object[][]{
                {attributesSet1, "type"},
                {attributesSet2, "value"},
                {attributesSet3, "class"},
                {attributesSet4, "class"}
        };
    }

    @DataProvider
    public Object[][] attributesNegative() {
        return new Object[][]{
                {attributesSet1, "type1"},
                {attributesSet2, "value1"},
                {attributesSet3, "class1"},
                {attributesSet4, "class1"}
        };
    }

    @BeforeMethod
    public void init() {
        uiElement = mock(UIElement.class);
    }

    @Test(expectedExceptions = {RuntimeException.class}, dataProvider = "attributesNegative",
            expectedExceptionsMessageRegExp = ".*Expected: an array containing.*[a-zA-Z'].*but: mismatches were:.*[a-zA-Z'].*")
    public void hasAttrNegativeOuterExceptionHandlingTest(MapArray<String, String> actualMapAttr, String wrongAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(wrongAttr);
    }

    @Test(dataProvider = "attributesNegative")
    public void hasAttrNegativeInnerExceptionHandlingTest(MapArray<String, String> actualMapAttr, String wrongAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();

        try {
            uiElement.is().hasAttr(wrongAttr);
        } catch (RuntimeException exp) {
            String expMessage = exp.getMessage();
            assertTrue(expMessage.contains(exceptionMessageFirstPart + " \"" + wrongAttr + "\""));
            assertTrue(expMessage.contains(exceptionMessageSecondPart));
            for (String key : actualMapAttr.keys()) {
                assertTrue(expMessage.contains("was \"" + key + "\""));
            }
        }
    }

    @Test(dataProvider = "attributesPositive")
    public void hasAttrPositiveTest(MapArray<String, String> actualMapAttr, String expectedAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(expectedAttr);

    }

}
