package mocks;

import com.epam.jdi.light.elements.common.UIElement;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CardNavigationMock extends UIElement {

    @Override
    public boolean hasClass(String className) {
        return this.classes().contains(className);
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return isNotBlank(this.attr(attrName));
    }
}
