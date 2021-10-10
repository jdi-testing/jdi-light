package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Button;

import java.util.List;

public class ButtonsPage extends VuetifyPage {

    @UI("//button[contains(@class,'elevation-2')]")
    public static Button commonButton;

    @UI("#button-state")
    public static Text commonButtonState;

    @UI("//button[contains(@class,'v-btn--block')]")
    public static Button blockButton;

    @UI("#block-button-state")
    public static Text blockButtonState;

    @UI("//button[contains(@class,'ma-2 v-btn')][normalize-space()='Normal']")
    public static Button depressedNormalButton;

    @UI("//button[contains(@class,'ma-2 v-btn')][normalize-space()='Primary']")
    public static Button depressedPrimaryButton;

    @UI("//button[contains(@class,'ma-2 v-btn')][normalize-space()='Error']")
    public static Button depressedErrorButton;

    @UI("//button[contains(@class,'ma-2 v-btn')][normalize-space()='Disabled']")
    public static Button depressedDisabledButton;

    @UI("#depr-buttons-state")
    public static Text depressedButtonState;

    @UI("//button[contains(@class,'v-btn--icon')]")
    public static List<Button> iconButtons;

    @UI("#icon-buttons-state")
    public static Text iconButtonState;

    @UI("//h2[normalize-space()='Loader Buttons']/following-sibling::button")
    public static List<Button> loaderButtons;

    @UI("//button[contains(@class,'v-btn--text')]")
    public static List<Button> textButtons;

    @UI("#text-buttons-state")
    public static Text textButtonState;

    @UI("//button[contains(@class,'v-btn--plain')]")
    public static List<Button> plainButtons;

    @UI("#plain-buttons-state")
    public static Text plainButtonState;

    @UI("//button[contains(@class,'v-btn--outlined')]")
    public static Button outlinedButton;

    @UI("#outline-buttons-state")
    public static Text outlinedButtonState;

    @UI("//button[contains(@class,'v-btn--rounded')]")
    public static Button roundedButton;

    @UI("#rounded-button-state")
    public static Text roundedButtonState;

    @UI("//button[contains(@class,'v-btn--tile')]")
    public static Button tileButton;

    @UI("#tile-button-state")
    public static Text tileButtonState;
}
