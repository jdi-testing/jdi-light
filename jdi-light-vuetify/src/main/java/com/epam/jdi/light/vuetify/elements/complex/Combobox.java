package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.asserts.ComboboxAssert;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsClearable;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsFullWidth;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsMultiple;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import com.epam.jdi.light.vuetify.interfaces.IsSolo;
import com.epam.jdi.light.vuetify.interfaces.IsVuetifyInput;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see example of Combobox web element please visit https://vuetifyjs.com/en/components/combobox/
 */

public class Combobox extends UIBaseElement<ComboboxAssert> implements ISetup, IsClearable, IsMultiple,
        IsReverse, IsSingleLine, IsFilled, IsLoading, IsReadOnly, HasMessages, IsDense, IsOutlined, IsSolo,
        IsFullWidth, HasColor, HasTheme, IsFlat, HasMeasurement, HasRounded, IsShaped, HasDetailsHidden, IsVuetifyInput {

    protected String rootLocator = "div[role = 'combobox']";
    protected String selectLocator = "//ancestor::div[contains(@class, 'v-input')]";
    protected String listLocator = ".v-list-item__title";
    protected String valueLocator = "div input[type='hidden']";
    protected String inputLocator = "div input[type='text']";
    protected String expandLocator = "div .v-input__append-inner";
    protected String labelLocator = ".v-label";
    protected String messageLocator = "//following::div[@class = 'v-messages__message']";
    protected String counterLocator = "//following::div[contains(@class, 'v-counter')]";
    protected String errorMessageLocator = "//following::div[contains(@class, 'error--text')]"
            + "//div[@class = 'v-messages__message']";
    protected String successMessageLocator = "//following::div[contains(@class, 'success--text')]"
            + "//div[@class = 'v-messages__message']";
    protected String selectedChipsLocator = ".v-select__slot .v-chip";
    protected String prefixLocator = "div .v-text-field__prefix";
    protected String suffixLocator = "div .v-text-field__suffix";
    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDICombobox.class, Combobox.class)) {
            return;
        }
        JDICombobox j = field.getAnnotation(JDICombobox.class);
        setup(j.root(), j.listItems());
    }

    public Combobox setup(String comboboxLocator, String listItemsLocator) {
        if (isNotBlank(comboboxLocator)) {
            rootLocator = comboboxLocator;
        }
        if (isNotBlank(listItemsLocator)) {
            listLocator = listItemsLocator;
        }
        base().setLocator(rootLocator);
        return this;
    }

    @Override
    public ComboboxAssert is() {
        return new ComboboxAssert().set(this);
    }

    public List<Chip> selectedChips() {
        return core().finds(selectedChipsLocator)
                .stream()
                .map(e -> new Chip().setCore(Chip.class, e))
                .collect(Collectors.toList());
    }
    public List<String> selectedValues() {
        return Arrays.asList(core().find(valueLocator).attr("value").split(","));
    }
    private UIElement select() {
        return core().find(selectLocator);
    }
    private UIElement input() {
        return core().find(inputLocator);
    }

    private UIElement expander() {
        return core().find(expandLocator);
    }

    private UIElement counter() {
        return core().find(counterLocator);
    }

    private UIElement prefix() {
        return core().find(prefixLocator);
    }

    private UIElement suffix() {
        return core().find(suffixLocator);
    }

    public WebList list() {
        return finds(listLocator);
    }

    public Label label() {
        return new Label().setCore(Label.class, core().find(labelLocator));
    }

    @Override
    public List<UIElement> messages() {
        return messages(messageLocator);
    }

    @Override
    @JDIAction("Get '{name}' messages text")
    public List<String> messagesText() {
        return messagesText(messageLocator);
    }

    @Override
    @JDIAction("Get '{name}' error messages")
    public List<String> errorMessagesText() {
        return messagesText(errorMessageLocator);
    }

    @Override
    @JDIAction("Get '{name}' success messages")
    public List<String> successMessagesText() {
        return messagesText(successMessageLocator);
    }

    @JDIAction("Get if '{name}' is error")
    public boolean isError() {
        return select().hasClass("error--text");
    }

    @JDIAction("Get if '{name}' is success")
    public boolean isSuccess() {
        return select().hasClass("success--text");
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Select '{0}' from '{name}'")
    public void select(String value) {
        if (!isSelected(value)) {
            expand();
            list().select(value);
            if (isExpanded()) {
                close();
            }
        }
    }


    @JDIAction("Select '{0}' from '{name}'")
    public void select(List<String> values) {
        values.forEach(x -> {
            if (!isSelected(x)) {
                expand();
                list().select(x);
                if (isExpanded()) {
                    close();
                }
            }
        });
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(String value) {
        if (isSelected(value)) {
            expand();
            list().select(value);
            if (isExpanded()) {
                close();
            }
        }
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(List<String> values) {
        expand();
        values.forEach(x -> {
            if (isSelected(x)) {
                list().select(x);
            }
        });
        if (isExpanded()) {
            close();
        }
    }

    @JDIAction("Send '{0} keys' to '{name}' input")
    public void sendKeys(String keys) {
        input().sendKeys(keys);
        input().sendKeys(Keys.ENTER);
    }

    @JDIAction("Get if '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equals("true");
    }

    @JDIAction("Get if '{0}' from '{name}' is selected")
    public boolean isSelected(String value) {
        return selectedValues().contains(value);
    }

    @JDIAction("Get if '{0}' from '{name}' is selected")
    public boolean isSelected(List<String> values) {
        return selectedValues().containsAll(values);
    }

    @Override
    @JDIAction("Get if '{name}' is readonly")
    public boolean isReadOnly() {
        return select().attr("class").contains("--is-readonly");
    }

    @JDIAction("Get if '{name}' is loading")
    public boolean isLoading() {
        return select().attr("class").contains("--is-loading");
    }

    @Override
    @JDIAction("Get if '{name}' is dense")
    public boolean isDense() {
        return select().attr("class").contains("--dense");
    }

    @Override
    @JDIAction("Get if '{name}' is outlined")
    public boolean isOutlined() {
        return select().attr("class").contains("--outlined");
    }

    @Override
    @JDIAction("Get if '{name}' is solo")
    public boolean isSolo() {
        return select().attr("class").contains("--solo");
    }

    @Override
    @JDIAction("Get if '{name}' is solo-inverted")
    public boolean isSoloInverted() {
        return select().attr("class").contains("--solo-inverted");
    }

    @Override
    @JDIAction("Get if '{name}' is full-width")
    public boolean isFullWidth() {
        return select().attr("class").contains("--full-width");
    }

    @JDIAction("Get if '{name}' has chips")
    public boolean hasChips() {
        return select().hasClass("v-select--chips");
    }

    @JDIAction("Get if '{name}' has small chips")
    public boolean hasSmallChips() {
        return select().hasClass("v-select--chips--small");
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return select().classLike("theme--");
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return select().hasClass("v-input--is-disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    @JDIAction("Get if '{name}' is flat")
    public boolean isFlat() {
        return select().attr("class").contains("-flat");
    }

    @JDIAction("Get if '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return select().hasClass("v-text-field--placeholder");
    }

    @JDIAction("Get if '{name}' has placeholder")
    public String placeholder() {
        return input().attr("placeholder");
    }

    @Override
    @JDIAction("Get if '{name}' is rounded")
    public boolean isRounded() {
        return select().attr("class").matches(String.format(".*%s.*", ROUNDED_PATTERN));
    }

    @Override
    @JDIAction("Get if '{name}' is shaped")
    public boolean isShaped() {
        return select().attr("class").contains("--shaped");
    }

    @JDIAction("Get if '{name}' is autofocus")
    public boolean isAutofocus() {
        return input().hasAttribute("autofocus")
                && input().getAttribute("autofocus").equals("true")
                || input().getAttribute("autofocus").equals("autofocus");
    }

    @JDIAction("Get if '{name}' has counter")
    public boolean hasCounter() {
        return counter().isExist();
    }

    @JDIAction("Get if '{name}' has counter")
    public String hasCounterValue() {
        return counter().getText();
    }

    @Override
    @JDIAction("Get if {name} has details hidden")
    public boolean hasDetailsHidden() {
        return select().attr("class").contains("-hide-details");
    }

    @JDIAction("Get if '{name}' has prefix")
    public boolean hasPrefix() {
        return prefix().isExist();
    }

    @JDIAction("Get '{name}' prefix text")
    public String getPrefixText() {
        return prefix().getText();
    }

    @JDIAction("Get if '{name}' has suffix")
    public boolean hasSuffix() {
        return suffix().isExist();
    }

    @JDIAction("Get '{name}' suffix text")
    public String getSuffixText() {
        return suffix().getText();
    }

    @Override
    @JDIAction("Clear '{name}' text")
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            input().sendKeys(Keys.chord(Keys.COMMAND, "a"));
            input().sendKeys(Keys.DELETE);
        } else {
            input().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }
}
