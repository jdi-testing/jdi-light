package mocks;

import com.epam.jdi.light.elements.common.UIElement;
import interfaces.IEnabled;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CardNavigationMock implements IEnabled {

    private UIElement uiElement;

    public UIElement getUiElement() {
        return uiElement;
    }

    @Override
    public boolean hasClass(String className) {
        return uiElement.classes().contains(className);
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return isNotBlank(uiElement.attr(attrName));
    }

    @Override
    public boolean isEnabled() {
        return uiElement.getWebElement().isEnabled();
    }
}
