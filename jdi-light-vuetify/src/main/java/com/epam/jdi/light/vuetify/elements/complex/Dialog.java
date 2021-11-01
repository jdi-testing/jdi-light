package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import com.epam.jdi.light.vuetify.asserts.DialogAssert;

public class Dialog extends UIBaseElement<DialogAssert> implements HasAssert<DialogAssert> {

    protected UIElement dialogWindow() {
        return $(".v-dialog__content--active");
    }

    protected UIElement nestedDialogWindow() {
        return $("//*[@class='v-dialog__content v-dialog__content--active'][2]");
    }

    protected WebList dialogButtons() {
        return finds("button[type='button']");
    }

    protected WebList buttons() {
        return dialogWindow().finds(".v-btn");
    }

    protected WebList elements() {
        return dialogWindow().finds("//*[@role='list'][1]/div[@role='listitem']");
    }

    protected WebList checkboxes() {
        return dialogWindow().finds("//*[@role='list'][2]/div[@role='listitem']");
    }

    protected WebList radioButtons() {
        return dialogWindow().finds("//div[@role='radiogroup']/child::div");
    }

    protected WebList forms() {
        return dialogWindow().finds("//*[@class='row']/child::div");
    }

    protected WebList menuContent() {
        return $$(".menuable__content__active div[role='option']");
    }

    @JDIAction("Show that {name} button is disabled")
    public boolean isDisabled() {
        return find("button[type='button']").attr("class").contains("disabled");
    }

    @JDIAction("Show that {name} button is active")
    public boolean isActive() {
        return !isDisabled();
    }

    @JDIAction("Open {name}")
    public void open() {
        dialogButtons().get(1).click();
    }

    @JDIAction("Open {0} {name} ")
    public void open(int dialogNum) {
        dialogButtons().get(dialogNum).click();
    }

    @JDIAction("Open {name} menu")
    public void openMenu() {
        dialogWindow().find(".mdi-dots-vertical").click();
    }

    @JDIAction("Open {name} nested dialog")
    public void openNestedDialog() {
        dialogWindow().find("//span[contains(text(), 'Open Dialog')]").click();
    }

    @JDIAction("Show that {name} nested dialog is opened")
    public boolean nestedDialogIsOpen() {
        return nestedDialogWindow().isVisible();
    }

    @JDIAction("Close {name} nested dialog")
    public void closeNestedDialog() {
        nestedDialogWindow().find("//span[contains(text(), 'Close')]").click();
    }

    @JDIAction("Open {name} tooltip")
    public void openTooltip() {
        buttons().get("Tool Tip Activator").hover();
    }

    @JDIAction("Show that {name} tooltip is opened")
    public boolean tooltipIsOpened() {
        return buttons().get(5).attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction(" that {name} is opened")
    public boolean isOpened() {
        return dialogWindow().isVisible();
    }

    @JDIAction("Get {name} title")
    public String getTitle() {
        UIElement toolbarTitle = dialogWindow().find(".v-toolbar__content");
        UIElement cardTitle = dialogWindow().find(".v-card__title");
        if (cardTitle.isExist()) {
            return cardTitle.text();
        } else {
            return toolbarTitle.text();
        }
    }

    @JDIAction("Get {0} {name} element text")
    public String elementText(int numEl) {
        return elements().get(numEl).find(".v-list-item__title").text();
    }

    @JDIAction("Get {name} text")
    public String cardText() {
        return dialogWindow().find(".v-card__text").text();
    }

    @JDIAction("Check {0} {name} element")
    public void checkElement(int elNum) {
        UIElement checkbox = checkboxes().get(elNum).find(".v-input");
        if (!checkbox.attr("class").contains("active")) {
            checkbox.click();
        }
    }

    @JDIAction("Uncheck {0} {name} element")
    public void uncheckElement(int elNum) {
        UIElement checkbox = checkboxes().get(elNum).find(".v-input");
        if (checkbox.attr("class").contains("active")) {
            checkbox.click();
        }
    }

    @JDIAction("Select {0} {name} element")
    public void selectElement(int elNum) {
        radioButtons().get(elNum).click();
    }

    @JDIAction("Select {0} element in {name} menu")
    public void selectMenuElement(int elNum) {
        $$(".menuable__content__active div[role='menuitem']").select(elNum);
    }

    @JDIAction("Fill {name} form")
    public void fillTheForm(String firstName, String middleName, String lastName, String email,
                            String password, int ageGap, String... hobby) {
        forms().get(1).find("input").sendKeys(firstName);
        forms().get(2).find("input").sendKeys(middleName);
        forms().get(3).find("input").sendKeys(lastName);
        forms().get(4).find("input").sendKeys(email);
        forms().get(5).find("input").sendKeys(password);
        forms().get(6).find(".v-icon").click();
        menuContent().select(ageGap);
        forms().get(7).find(".v-icon").click();
        menuContent().select(hobby);
    }

    @JDIAction("Show that {0} {name} element is selected")
    public boolean isSelected(int elNum) {
        return radioButtons().get(elNum).attr("class").contains("active");
    }

    @JDIAction("Close {name}")
    public void cancel() {
        UIElement closeButton = dialogWindow().find("//span[contains(text(), 'Close')]");
        if (closeButton.isExist()) {
            closeButton.click();
        } else {
            buttons().select(1);
        }
    }

    @JDIAction("Save changes in {name}")
    public void save() {
        buttons().select(2);
    }

    @JDIAction("Show that {name} is loading")
    public boolean isLoading() {
        return dialogWindow().find("div[role='progressbar']").attr("class").contains("visible");
    }


    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}
