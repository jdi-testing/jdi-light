package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.ui.html.elements.annotations.JDropdown;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownExpand extends UIListBase<UISelectAssert>
        implements IsDropdown, ISetup {
    private UIElement expander;
    public UIElement expander() {
        if (expander == null)
            expander = core();
        return expander;
    }
    @Override
    public void toggle() {
        expander().click();
    }

    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDropdown.class, DropdownExpand.class))
            return;
        JDropdown j = field.getAnnotation(JDropdown.class);
        By root = isNotBlank(j.root())
            ? defineLocator(j.root()) : null;
        By valueLocator = isNotBlank(j.value())
            ? defineLocator(j.value()) : null;
        By listLocator = isNotBlank(j.list())
            ? defineLocator(j.list()) : null;
        By expandLocator = isNotBlank(j.expand())
            ? defineLocator(j.expand()) : null;
        if (valueLocator != null)
            uiElement.setLocator(valueLocator);
        if (listLocator != null)
            list().setLocator(listLocator);
        if (expandLocator != null) {
            expander = $(expandLocator, base().parent).setName(getName() + " expand element");
            expander.driverName = base().driverName;
            if (valueLocator == null)
                uiElement = expander;
        }
        if (root != null) {
            UIElement parent = $(root, base().parent).setName(getName());
            uiElement.setParent(parent);
            expander.setParent(parent);
            list.setParent(parent);
        }

    }

}
