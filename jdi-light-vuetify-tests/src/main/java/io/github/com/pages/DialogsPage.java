package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import io.github.com.custom.dialog.NestingDialog;
import io.github.com.custom.dialog.ScrollableDialog;

public class DialogsPage extends VuetifyPage {
    @UI("#fullscreenDialog > button")
    public static VuetifyButton fullscreenDialogButton;

    @UI("#persistentDialog > button")
    public static VuetifyButton persistentDialogButton;

    @UI("#scrollableDialog > button")
    public static VuetifyButton scrollableDialogButton;

    @UI("#nestingDialog button [1]")
    public static VuetifyButton nestingDialogFirstButton;

    @UI("#withoutActivatorDialog > button")
    public static VuetifyButton withoutActivatorDialogButton;

    @UI("//div[@role='dialog'][div[contains(@class,'v-dialog')][not(contains(@style,'display: none'))]]")
    public static Dialog currentDialog;

    @UI("//div[@role='dialog'][.//div[text()='Select Country']]")
    public static ScrollableDialog scrollableDialog;

    @UI("//div[@role='dialog'][contains(@class,'v-dialog__content--active')][.//div[text()='Settings']]")
    public static NestingDialog nestingDialogFirst;

    @UI("//div[@role='dialog'][.//span[text()='Dialog 2']]")
    public static NestingDialog nestingDialogSecond;

    @UI("//div[@role='dialog'][.//span[text()='Dialog 3']]")
    public static Dialog nestingDialogThird;

    @UI("#disabledDialog > button")
    public static VuetifyButton disabledDialogButton;
}
