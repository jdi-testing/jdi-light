package mockitotests;

import com.epam.jdi.light.elements.common.UIElement;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class EnabledElementMockTests {

    private UIElement uiElement = null;
    private WebElement webElement = null;

    private static final boolean active = true;
    private static final boolean disabledByClass = true;
    private static final boolean disabledByAttribute = true;
    private static final boolean webElementEnabled = true;
    private static final boolean isEnabled = true;

    @DataProvider
    public Object[][] combinations() {
        return new Object[][]{
                {active, disabledByClass, disabledByAttribute, webElementEnabled, isEnabled},
                {active, disabledByClass, disabledByAttribute, !webElementEnabled, isEnabled},
                {active, disabledByClass, !disabledByAttribute, webElementEnabled, isEnabled},
                {active, disabledByClass, !disabledByAttribute, !webElementEnabled, isEnabled},

                {active, !disabledByClass, disabledByAttribute, webElementEnabled, isEnabled},
                {active, !disabledByClass, disabledByAttribute, !webElementEnabled, isEnabled},
                {active, !disabledByClass, !disabledByAttribute, webElementEnabled, isEnabled},
                {active, !disabledByClass, !disabledByAttribute, !webElementEnabled, isEnabled},

                {!active, disabledByClass, disabledByAttribute, webElementEnabled, !isEnabled},
                {!active, disabledByClass, disabledByAttribute, !webElementEnabled, !isEnabled},
                {!active, disabledByClass, !disabledByAttribute, webElementEnabled, !isEnabled},
                {!active, disabledByClass, !disabledByAttribute, !webElementEnabled, !isEnabled},

                {!active, !disabledByClass, disabledByAttribute, webElementEnabled, !isEnabled},
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
                             boolean isEnabled)
    {
        uiElement = Mockito.spy(new UIElement());

        Mockito.doReturn(active).when(uiElement).hasClass("active");

        Mockito.doReturn(disabledByClass).when(uiElement).hasClass("disabled");
        Mockito.doReturn(disabledByAttribute).when(uiElement).hasAttribute("disabled");

        Mockito.doReturn(webElement).when(uiElement).getWebElement();
        Mockito.doReturn(webElementEnabled).when(webElement).isEnabled();

        assertEquals(uiElement.isEnabled(), isEnabled);
    }

}
