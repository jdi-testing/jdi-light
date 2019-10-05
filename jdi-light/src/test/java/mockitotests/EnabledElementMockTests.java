package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import mocks.CardNavigationMock;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EnabledElementMockTests {

    @DataProvider
    public Object[][] combinations() {
        return new Object[][] {
                // §3
                {true, true, true, false, true},
                {false, true, true, false, false},
                {true, false, true, false, true},
                {false, false, true, false, false},

                {true, true, false, true, true},
                {false, true, false, true, false},
                {true, false, false, true, true},
                {false, false, false, true, true},

                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, false, true, true, true},
                {false, false, true, true, false},

                {true, true, false, false, true},
                {false, true, false, false, false},
                {true, false, false, false, true},
                {false, false, false, false, false},
        };
    }

    private CardNavigationMock cardNavigationMock = null;
    private UIElement uiElement = null;
    private WebElement webElement = null;

    @BeforeMethod
    public void init() {
        uiElement = mock(UIElement.class);
        webElement = mock(WebElement.class);
    }

    @Test(dataProvider = "combinations")
    public void hasClassTest(boolean value1, boolean value2, boolean value3, boolean value4, boolean assertion) {
        CardNavigationMock cardNavigationMock = Mockito.spy(new CardNavigationMock());
        WebElement webElement = Mockito.spy(new CardNavigationMock());
        Mockito.doReturn(value1).when(cardNavigationMock).hasClass("active");
        Mockito.doReturn(value2).when(cardNavigationMock).hasClass("disabled");
        Mockito.doReturn(value3).when(cardNavigationMock).hasAttribute("disabled");
        Mockito.doReturn(webElement).when(cardNavigationMock).getWebElement();
        Mockito.doReturn(value4).when(webElement).isEnabled();

        if (assertion == true) {
            assertTrue(cardNavigationMock.isEnabled());
        }
        if (assertion == false) {
            assertFalse(cardNavigationMock.isEnabled());
        }
    }

//    @Test
//    public void hasClassAndAttributeTest() {
//        when(cardNavigationMock.hasClass("active")).thenReturn(false);
//        when(cardNavigationMock.hasClass("disabled")).thenReturn(true);
//        when(cardNavigationMock.hasAttribute("disabled")).thenReturn(true);
//        when(cardNavigationMock.getUiElement().getWebElement().isEnabled()).thenReturn(cardNavigationMock.getUiElement());
//        when(cardNavigationMock.isEnabled()).thenReturn(false);
//        assertTrue(uiElement.isEnabled());
//    }

//    @Test
//    public void getWebElementCheck() {
//        when(cardNavigationMock.hasClassCheck()).thenReturn(false);
//        when(cardNavigationMock.hasClassAndAttributeCheck()).thenReturn(false);
//        when(cardNavigationMock.getWebElementCheck()).thenReturn(true);
//        assertTrue(cardNavigationMock.uiElementEnabled());
//    }

}
