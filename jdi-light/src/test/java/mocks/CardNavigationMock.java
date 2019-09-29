package mocks;

import com.epam.jdi.light.elements.common.UIElement;

public class CardNavigationMock {

    private UIElement uiElement;

    public boolean hasClassCheck() {
        return uiElement.hasClass("active");
    }

    public boolean hasClassAndAttributeCheck() {
        return uiElement.hasClass("disabled") || uiElement.hasAttribute("disabled");
    }

    public boolean getWebElementCheck() {
        return uiElement.getWebElement().isEnabled();
    }

}
