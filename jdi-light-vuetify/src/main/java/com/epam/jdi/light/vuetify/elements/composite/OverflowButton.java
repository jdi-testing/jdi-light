package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.vuetify.asserts.OverflowButtonAssert;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsFullWidth;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static org.openqa.selenium.Keys.ESCAPE;

/**
 * To see example of Overflow Button web element please visit https://vuetifyjs.com/en/components/overflow-btns/
 */

public class OverflowButton extends UIBaseElement<OverflowButtonAssert> implements HasPlaceholder, HasMessages,
        IsReadOnly, IsLoading, IsDense, IsFilled, IsReverse, HasRounded, IsFlat, HasTheme, IsOutlined, IsShaped,
        IsSingleLine, IsFullWidth {

    private static final String EXPANDER_LOCATOR = ".v-input__append-inner";
    private static final String OPEN_PANEL_CLASS = "v-select--is-menu-active";
    private static final String COUNTER_LOCATOR = ".v-counter";
    private static final String PLACEHOLDER_LOCATOR = ".v-label";
    private static final String SELECT_LOCATOR = ".v-select__selections";
    private static final String PROGRESS_LINEAR = ".v-progress-linear";
    private static final String INPUT_LOCATOR = "input[type='text']";
    private static final String INPUT_VALUE = "input[type='hidden']";
    private static final String SELECTED_CHIP = ".v-chip";

    protected String listID() {
        return core().find(".v-input__slot").getAttribute("aria-owns");
    }

    public UIElement expander() {
        return core().find(EXPANDER_LOCATOR);
    }

    public WebList dropDownList() {
        return $$("//*[@id = '" + listID() + "']//div[@role = 'option']");
    }

    public UIElement input() {
        return core().find(INPUT_LOCATOR);
    }

    public UIElement selectedValue() {
        return core().find(SELECT_LOCATOR);
    }

    public UIElement counter() {
        return core().find(COUNTER_LOCATOR);
    }

    public UIElement placeholderElement() {
        return core().find(PLACEHOLDER_LOCATOR);
    }
    public List<Chip> selectedChips() {
        return selectedValue().finds(SELECTED_CHIP)
                .stream()
                .map(e -> new Chip().setCore(Chip.class, e))
                .collect(Collectors.toList());
    }

    @JDIAction("Open '{name}'")
    public void expand() {
        if (isClosed()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            // expander is not always available for click
            press(ESCAPE);
        }
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String text) {
        try {
            expand();
            dropDownList().select(text);
        } catch (RuntimeException e) {
            throw runtimeException("List don't have element %s", text);
        }
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        expand();
        if (index < dropDownList().getStartIndex() || index > dropDownList().size()) {
            throw runtimeException("Can't get element with index '%s'. Index should be from 1 to " + dropDownList().size(), index);
        }
        dropDownList().select(index);
    }

    @JDIAction("Set '{0}' in '{name}' input text field")
    public void sendText(String text) {
        input().sendKeys(text);
    }

    @JDIAction("Clear '{name}' text field")
    public void clear() {
        input().clear();
    }


    @JDIAction("Get '{name}' selected text")
    public String selected() {
        if (selectedValue().isExist()) {
            return selectedValue().getText();
        }
        // check input value
        UIElement hidden = core().find(INPUT_VALUE);
        if (hidden.isExist()) {
            return hidden.attr("value");
        }
        return "";
    }

    @Override
    public String placeholder() {
        if (placeholderElement().isExist()) {
            return placeholderElement().getText();
        }
        return "";
    }

    @JDIAction("Get if '{name}' has counter")
    public boolean hasCounter() {
        return counter().isExist();
    }

    @JDIAction("Get '{name}' counter value")
    public int counterValue() {
        if (counter().isExist()) {
            return Integer.parseInt(counter().getText());
        }
        return -1;
    }

    @JDIAction("Get if '{name}' is expanded")
    public boolean isExpanded() {
        return core().hasClass(OPEN_PANEL_CLASS);
    }

    @JDIAction("Get if '{name}' is closed")
    public boolean isClosed() {
        return !isExpanded();
    }

    @Override
    public boolean isDisabled() {
        return core().hasClass("v-input--is-disabled");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Get if '{name}' is editable")
    public boolean isEditable() {
        return core().hasClass("v-overflow-btn--editable");
    }

    @JDIAction("Get '{name}' loader height")
    public ProgressLinear loader() {
        return new ProgressLinear().setCore(ProgressLinear.class, core().find(PROGRESS_LINEAR));
    }

    @JDIAction("Get if '{name}' is segmented")
    public boolean isSegmented() {
        return core().hasClass("v-overflow-btn--segmented");
    }

    @JDIAction("Get if '{name}' has chips")
    public boolean hasChips() {
        return core().hasClass("v-select--chips");
    }

    @JDIAction("Get if '{name}' has small chips")
    public boolean hasSmallChips() {
        return core().hasClass("v-select--chips--small");
    }

    public OverflowButtonAssert is() {
        return new OverflowButtonAssert().set(this);
    }
}
