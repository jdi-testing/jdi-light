package mockitotests;

import mocks.CardNavigationMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EnabledElementMockTests {

    private CardNavigationMock cardNavigationMock = null;

    @BeforeMethod
    public void init() {
        cardNavigationMock = mock(CardNavigationMock.class);
    }

    @Test
    public void hasClassTest() {
        when(cardNavigationMock.hasClassCheck()).thenReturn(true);
        assertTrue(cardNavigationMock.enabled());
    }

    @Test
    public void hasClassAndAttributeTest() {
        when(cardNavigationMock.hasClassAndAttributeCheck()).thenReturn(false);
        assertFalse(cardNavigationMock.hasClassAndAttributeCheck());
    }

    @Test
    public void getWebElementCheck() {
        when(cardNavigationMock.getWebElementCheck()).thenReturn(true);
        assertTrue(cardNavigationMock.getWebElementCheck());
    }

}
