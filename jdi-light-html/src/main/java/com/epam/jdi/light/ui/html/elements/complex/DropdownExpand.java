package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.ListElementNameTypes;
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
import static com.epam.jdi.light.common.ListElementNameTypes.INNER;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownExpand extends UIListBase<UISelectAssert>
        implements IsDropdown, ISetup {
    protected String expandLocator = ".caret";
    public UIElement expander() {
        return linked(expandLocator, "expand");
    }

    protected String valueLocator = "input";
    public UIElement value() { return linked(valueLocator, "value"); }

    protected String listLocator = "li";
    @Override
    public WebList list() {
        return linkedList(listLocator, "list").setUIElementName(INNER);
    }

    public void toggle() {
        expander().click();
    }
    @JDIAction(value = "Is '{name}' expanded", level = DEBUG)
    public boolean isExpanded() {
        return list().noWait(WebList::isDisplayed, WebList.class);
    }
    @JDIAction(level = DEBUG)
    public void expand() {
        if (!isExpanded())
            toggle();
    }
    @JDIAction(level = DEBUG)
    public void close() {
        if (isExpanded())
            toggle();
    }
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        expand();
        list().select(value);
        close();
    }
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        expand();
        list().select(index-1);
        close();
    }
    @JDIAction("Get selected value") @Override
    public String selected() {
        expand();
        return list().selected();
    }
    @JDIAction("Is '{0}' selected") @Override
    public boolean selected(String value) {
        expand();
        return list().selected(value);
    }
    public boolean wait(JFunc1<IsDropdown, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }

    protected boolean setupDone = false;
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDropdown.class, DropdownExpand.class))
            return;
        JDropdown j = field.getAnnotation(JDropdown.class);
        if (isNotBlank(j.root()))
            base().setLocator(j.root());
        if (isNotBlank(j.value())) {
            valueLocator = j.value();
            expandLocator = isNotBlank(j.expand())
                ? j.expand() : j.value();
        } else if (isNotBlank(j.expand()))
            expandLocator = j.expand();
        if (isNotBlank(j.list()))
            listLocator = j.list();
        setupDone = true;
    }
    @JDIAction("Check that '{name}' is displayed") @Override
    public boolean isDisplayed() {
        return value().isDisplayed();
    }

}
