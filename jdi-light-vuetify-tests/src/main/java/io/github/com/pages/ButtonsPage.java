package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Button;

import java.util.List;

public class ButtonsPage extends VuetifyPage {

    @UI(".elevation-2")
    public static Button commonButton;

    @UI("#button-state")
    public static Text commonButtonState;

    @UI(".v-btn--block")
    public static Button blockButton;

    @UI("#block-button-state")
    public static Text blockButtonState;

    @UI("//h2[text()='Depressed Buttons']/following-sibling::button")
    public static List<Button> depressedNormalButton;

    @UI("#depr-buttons-state")
    public static Text depressedButtonState;

    @UI(".v-btn--icon")
    public static List<Button> iconButtons;

    @UI("#icon-buttons-state")
    public static Text iconButtonState;

    @UI(".ma-2.v-btn--is-elevated")
    public static List<Button> loaderButtons;

    @UI("//button[contains(@class,'v-btn--text')]")
    public static List<Button> textButtons;

    @UI("#text-buttons-state")
    public static Text textButtonState;

    @UI(".v-btn--plain")
    public static List<Button> plainButtons;

    @UI("#plain-buttons-state")
    public static Text plainButtonState;

    @UI(".v-btn--outlined")
    public static Button outlinedButton;

    @UI("#outline-buttons-state")
    public static Text outlinedButtonState;

    @UI(".v-btn--rounded")
    public static Button roundedButton;

    @UI("#rounded-button-state")
    public static Text roundedButtonState;

    @UI(".v-btn--tile")
    public static Button tileButton;

    @UI("#tile-button-state")
    public static Text tileButtonState;
}
