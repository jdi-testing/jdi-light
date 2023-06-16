package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.jdiai.tools.Timer.waitCondition;

public class EditableCalendar extends Calendar {
    private static final String EVENT_CARD_LOCATOR = ".menuable__content__active .v-card";
    private static final String EVENT_MENU_LOCATOR = "//ancestor::div[@role='menu']";
    private static final String EVENT_EDIT_BUTTON_LOCATOR = " .mdi-pencil";
    private static final String EVENT_DELETE_BUTTON_LOCATOR = " .mdi-delete";
    private static final String EVENT_EDIT_INPUT_LOCATOR = "//div[contains(text(), 'Change event')]/..//div[contains(@class, 'v-input')]";
    private static final String EVENT_EDIT_SAVE_BUTTON_LOCATOR = "//div[contains(text(), 'Change event')]/ .. //span[contains(text(), 'Save and Close')]";

    public Card eventCard() {
        return new Card().setCore(Card.class, $(EVENT_CARD_LOCATOR));
    }

    @JDIAction("Close {name} event")
    public void closeEvent() {
        eventCard().actions().getButtonByText("CANCEL").click();
    }

    @JDIAction("Rename {name} event")
    public void renameEvent(int eventNumber, String title) {
        events().select(eventNumber);
        VuetifyButton edt = new VuetifyButton().setCore(VuetifyButton.class, $(EVENT_EDIT_BUTTON_LOCATOR));
        edt.click();

        TextField titleField = new TextField().setCore(TextField.class, $(EVENT_EDIT_INPUT_LOCATOR));
        titleField.clear();
        titleField.sendKeys(title);
        $(EVENT_EDIT_SAVE_BUTTON_LOCATOR).click();
        closeEvent();
    }

    @JDIAction("Delete {name} event")
    public void deleteEvent(int eventNumber) {
        events().select(eventNumber);
        waitCondition(() -> $(EVENT_DELETE_BUTTON_LOCATOR).isClickable());
        $(EVENT_DELETE_BUTTON_LOCATOR).click();
    }

    @JDIAction("Get if {name} event is opened")
    public boolean isEventOpened() {
        return eventCard().find(EVENT_MENU_LOCATOR).attr("class").contains("active");
    }
}
