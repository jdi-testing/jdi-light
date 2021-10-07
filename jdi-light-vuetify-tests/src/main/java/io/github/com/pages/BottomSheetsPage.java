package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.bottomsheets.BottomSheetPlayer;
import io.github.com.custom.bottomsheets.ListBottomSheet;
import io.github.com.custom.bottomsheets.TextBottomSheet;

public class BottomSheetsPage extends VuetifyPage {

    // inset section
    @UI("#inset-bottom-sheet > button")
    public static Button insetBottomSheetButton;
    @UI("//div[contains(@class, 'v-dialog__content') and .//div[contains(text(), 'inset')]]")
    public static TextBottomSheet insetBottomSheet;

    // v-model section
    @UI("#model-bottom-sheet > button")
    public static Button vModelBottomSheetButton;
    @UI("//div[contains(@class, 'v-dialog__content') and .//div[contains(text(), 'v-model')]]")
    public static TextBottomSheet vModelBottomSheet;

    // persistent section
    @UI("#persistent-bottom-sheet > button")
    public static Button persistentBottomSheetButton;
    @UI("//div[contains(@class, 'v-dialog__content') and .//div[contains(text(), 'persistent')]]")
    public static TextBottomSheet persistentBottomSheet;

    // player section
    @UI("#music-player-bottom-sheet > button")
    public static Button playerBottomSheetButton;
    @UI("//div[contains(@class, 'v-dialog__content') and .//div[contains(text(), 'The Walker')]]")
    public static BottomSheetPlayer bottomSheetPlayer;

    // list section
    @UI("#open-in-list-bottom-sheet > button")
    public static Button listBottomSheetButton;
    @UI("//div[contains(@class, 'v-dialog__content') and .//div[contains(text(), 'Open')]]")
    public static ListBottomSheet listBottomSheet;
}
