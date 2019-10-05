package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class EnabledElementMockTests {

    private UIElement uiElement = null;
    private WebElement webElement = null;

    static final boolean active = true;
    static final boolean disabledByClass = true;
    static final boolean disabledByAttribute = true;
    static final boolean webElementEnabled = true;
    static final boolean isEnabled = true;

    @DataProvider
    public Object[][] combinations() {
        return new Object[][]{
                {active, disabledByClass, disabledByAttribute, webElementEnabled, isEnabled},
                {active, disabledByClass, !disabledByAttribute, webElementEnabled, isEnabled},
                {active, disabledByClass, !disabledByAttribute, !webElementEnabled, !isEnabled},
                {active, disabledByClass, disabledByAttribute, !webElementEnabled, !isEnabled},

                {active, !disabledByClass, disabledByAttribute, webElementEnabled, isEnabled},
                {active, !disabledByClass, disabledByAttribute, !webElementEnabled, !isEnabled},
                {active, !disabledByClass, !disabledByAttribute, webElementEnabled, isEnabled},
                {active, !disabledByClass, !disabledByAttribute, !webElementEnabled, !isEnabled},

                {!active, disabledByClass, disabledByAttribute, webElementEnabled, isEnabled},
                {!active, disabledByClass, disabledByAttribute, !webElementEnabled, !isEnabled},
                {!active, disabledByClass, !disabledByAttribute, webElementEnabled, isEnabled},
                {!active, disabledByClass, !disabledByAttribute, !webElementEnabled, !isEnabled},

                {!active, !disabledByClass, disabledByAttribute, webElementEnabled, isEnabled},
                {!active, !disabledByClass, disabledByAttribute, !webElementEnabled, !isEnabled},
                {!active, !disabledByClass, !disabledByAttribute, webElementEnabled, isEnabled},
                {!active, !disabledByClass, !disabledByAttribute, !webElementEnabled, !isEnabled},
        };
    }

    @BeforeMethod
    public void init() {
        uiElement = mock(UIElement.class);
        webElement = mock(WebElement.class);
    }

    @Test(dataProvider = "combinations")
    public void hasClassTest(boolean active,
                             boolean disabledByClass,
                             boolean disabledByAttribute,
                             boolean webElementEnabled,
                             boolean isEnabled) {
//        CardNavigationMock cardNavigationMock = Mockito.spy(new CardNavigationMock());
        webElement = Mockito.spy(new UIElement());
        Mockito.doReturn(active).when(uiElement).hasClass("active");
        Mockito.doReturn(disabledByClass).when(uiElement).hasClass("disabled");
        Mockito.doReturn(disabledByAttribute).when(uiElement).hasAttribute("disabled");
        Mockito.doReturn(webElement).when(uiElement).getWebElement();
        Mockito.doReturn(webElementEnabled).when(webElement).isEnabled();

        assertEquals(webElement.isEnabled(), isEnabled);
    }

}
