package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import mocks.CardNavigationMock;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertTrue;

public class EnabledElementMockTests {

    private CardNavigationMock cardNavigationMock = null;
    private UIElement uiElement = null;
    private WebElement webElement = null;

    @BeforeMethod
    public void init() {
//        cardNavigationMock = mock(CardNavigationMock.class);
//        cardNavigationMock = new CardNavigationMock();
        uiElement = mock(UIElement.class);
        webElement = mock(WebElement.class);
    }

    @Test
    public void hasClassTest() {
        CardNavigationMock cardNavigationMock = Mockito.spy(new CardNavigationMock());
        WebElement webElement = Mockito.spy(new CardNavigationMock());
//        when(cardNavigationMock.hasClass("active")).thenReturn(true);
        Mockito.doReturn(false).when(cardNavigationMock).hasClass("active");
        Mockito.doReturn(false).when(cardNavigationMock).hasClass("disabled");
        Mockito.doReturn(false).when(cardNavigationMock).hasAttribute("disabled");
        Mockito.doReturn(webElement).when(cardNavigationMock).getWebElement();
        Mockito.doReturn(true).when(webElement).isEnabled();
//        when(cardNavigationMock.getWebElement()).thenReturn(webElement);
//        when(webElement.isEnabled()).thenReturn(false);
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
