package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import mocks.CardNavigationMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

public class EnabledElementMockTests {

    private CardNavigationMock cardNavigationMock = null;
    private UIElement uiElement = null;

    @BeforeMethod
    public void init() {
        cardNavigationMock = mock(CardNavigationMock.class);
        uiElement = mock(UIElement.class);
    }

    @Test
    public void hasClassTest() {
        when(cardNavigationMock.hasClass("active")).thenReturn(true);
        when(cardNavigationMock.hasClass("disabled")).thenReturn(false);
        when(cardNavigationMock.hasAttribute("disabled")).thenReturn(false);
        when(cardNavigationMock.getWebElement()).thenReturn(uiElement);
        when(uiElement.isEnabled()).thenReturn(false);
        assertTrue(cardNavigationMock.isEnabled());
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
