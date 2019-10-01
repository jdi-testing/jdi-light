package mocks;

import com.epam.jdi.light.elements.common.UIElement;
import interfaces.IEnabled;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CardNavigationMock implements IEnabled {

    private UIElement uiElement;

    @Override
    public boolean hasClass(String className) {
        return uiElement.classes().contains(className);
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return isNotBlank(uiElement.attr(attrName));
    };

    @Override
    public boolean isEnabled() {
        return uiElement.getWebElement().isEnabled();
    }

    public boolean hasClassCheck() {
        return this.hasClass("active");
    }

    public boolean hasClassAndAttributeCheck() {
        return this.hasClass("disabled") || this.hasAttribute("disabled");
    }

    public boolean getWebElementCheck() {
        return this.isEnabled();
    }
}
