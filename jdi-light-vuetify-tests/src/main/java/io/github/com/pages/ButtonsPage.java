package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

import java.util.List;

public class ButtonsPage extends VuetifyPage {

    @UI(".elevation-2")
    public static VuetifyButton commonButton;

    @UI("#button-state")
    public static Text commonButtonState;

    @UI(".v-btn--block")
    public static VuetifyButton blockButton;

    @UI("#block-button-state")
    public static Text blockButtonState;

    @UI("//h2[text()='Depressed Buttons']/following-sibling::button")
    public static List<VuetifyButton> depressedNormalButton;

    @UI("//h2[text()='Depressed Buttons']/following-sibling::button[contains(@class,'v-btn--disabled')]")
    public static VuetifyButton disabledButton;

    @UI("#depr-buttons-state")
    public static Text depressedButtonState;

    @UI(".v-btn--icon")
    public static List<VuetifyButton> iconButtons;

    @UI("#icon-buttons-state")
    public static Text iconButtonState;

    @UI(".ma-2.v-btn--is-elevated")
    public static List<VuetifyButton> loaderButtons;

    @UI("//button[contains(@class,'v-btn--text') and contains(@class,'theme--light')]")
    public static List<VuetifyButton> textButtons;

    @UI("#text-buttons-state")
    public static Text textButtonState;

    @UI(".v-btn--plain")
    public static List<VuetifyButton> plainButtons;

    @UI("#plain-buttons-state")
    public static Text plainButtonState;

    @UI(".v-btn--outlined")
    public static VuetifyButton outlinedButton;

    @UI("#outline-buttons-state")
    public static Text outlinedButtonState;

    @UI(".v-btn--rounded")
    public static VuetifyButton roundedButton;

    @UI("#rounded-button-state")
    public static Text roundedButtonState;

    @UI(".v-btn--tile")
    public static VuetifyButton tileButton;

    @UI("#tile-button-state")
    public static Text tileButtonState;

    @UI("//div[@id='SizingIconButtons']//button[contains(@class,'v-btn--fab')]")
    public static List<VuetifyButton> sizingButton;

    @UI("#sizing-buttons-state")
    public static Text sizingButtonState;
}
