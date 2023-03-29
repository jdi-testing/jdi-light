package com.epam.jdi.light.vuetify.elements.complex.radiobuttons;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.radiobuttons.RadioButtonsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.TextTypes.LABEL;

/**
 * To see example of Radio buttons web element please visit https://vuetifyjs.com/en/components/radio-buttons/
 */

public class RadioButtons extends UIListBase<UISelectAssert<RadioButtonsAssert, RadioButtons>> implements HasLabel,
        HasTheme, HasColor, IsReadOnly, IsDense, HasMessages {
    private static final String INPUT_SLOT = "//ancestor::div[contains(@class, 'v-input__slot')]";
    private static final String LABEL_LOCATOR = "//ancestor::div[@class = 'v-input--selection-controls__input']//following-sibling::label";
    private static final String INPUT_SELECTION_CONTROLS = "//ancestor::div[contains(@class, 'v-input--selection-controls')]";
    private static final String RADIO = "//ancestor::div[contains(@class, 'v-radio')]";
    private static final String RADIO_GROUP = "//ancestor::div[contains(@class, 'v-input--radio-group')]";
    private static final String MESSAGES_WRAPPER = "//div[contains(@class, 'v-messages__wrapper')]";
    private static final String MESSAGE = "//div[contains(@class, 'v-messages__message')]";

    @Override
    public RadioButtonsAssert is() {
        return new RadioButtonsAssert().set(this);
    }

    @Override
    public RadioButtonsAssert has() {
        return is();
    }

    @Override
    public Label label() {
        return new Label().setup(Label.class, j->j
                .setLocator(By.xpath(LABEL_LOCATOR))
                .setName(getName() + " label").setTypeName("Label"));
    }

    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }

    private UIElement inputSelectionControls() {
        return find(INPUT_SELECTION_CONTROLS);
    }

    private UIElement radioGroup() {
        return find(RADIO_GROUP);
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return inputSelectionControls().classLike("theme--");
    }

    public List<RadioButton> radioButtons() {
        return finds(RADIO).stream()
                .map(e -> new RadioButton().setCore(RadioButton.class, e))
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return find(INPUT_SLOT).css("background-color");
    }

    @JDIAction("Get '{name}' label color")
    public String labelColor() {
        return find(LABEL_LOCATOR).css("color");
    }

    @Override
    @JDIAction("Get if '{name}' is readonly")
    public boolean isReadOnly() {
        return radioGroup().attr("class").contains("--is-readonly");
    }

    @JDIAction("Get if '{name}' has message")
    public boolean hasMessage() {
        return inputSelectionControls().find(MESSAGE).isExist();
    }

    @JDIAction("Get if '{name}' has message")
    public String getMessage() {
        return inputSelectionControls().find(MESSAGE).getText();
    }

    @Override
    @JDIAction("Get if '{name}' is dense")
    public boolean isDense() {
        return inputSelectionControls().attr("class").contains("--dense");
    }

    @JDIAction("Get '{name}' messages text by locator '{0}'")
    public List<UIElement> messages(String locator) {
        return inputSelectionControls().find(MESSAGES_WRAPPER).finds(locator);
    }

    @JDIAction("Get '{name}' messages text by locator '{0}'")
    public List<String> messagesText(String locator) {
        return messages(locator).stream().map(UIElement::getText).collect(Collectors.toList());
    }
}
