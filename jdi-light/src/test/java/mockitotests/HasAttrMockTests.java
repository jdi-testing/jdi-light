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

    private UIElement uiElement = null;
    private String exceptionMessage1 = "Expected: an array containing";
    private String exceptionMessage2 = "but: mismatches were: [";


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
    // TODO: Leave assertContains to assertEquals
    @Test(dataProvider = "attributesNegative")
    public void negativeTest1(MapArray<String, String> actualMapAttr, String wrongAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();

        try {
            uiElement.is().hasAttr(wrongAttr);
        } catch (RuntimeException exp) {
            String expMessage = exp.getMessage();
            assertTrue(expMessage.contains(exceptionMessage1 + " \"" + wrongAttr + "\""));
            assertTrue(expMessage.contains(exceptionMessage2));
            for (String key : actualMapAttr.keys()) {
                System.out.println("was  \"" + key + "\"");
                assertTrue(expMessage.contains("was \"" + key + "\""));
            }
        }
    }

    //WORKING
    //TODO: Improve Chrome closing
    @Test(dataProvider = "attributesPositive")
    public void positiveTest(MapArray<String, String> actualMapAttr, String expectedAttr) {
        uiElement = Mockito.spy(new UIElement());
        Mockito.doReturn(actualMapAttr).when(uiElement).attrs();
        uiElement.is().hasAttr(expectedAttr);
    }

}
