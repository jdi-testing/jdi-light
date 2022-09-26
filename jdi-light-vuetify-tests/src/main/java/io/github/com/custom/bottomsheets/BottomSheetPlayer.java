package io.github.com.custom.bottomsheets;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;

public class BottomSheetPlayer extends BottomSheet {
    @UI(".v-progress-linear")
    protected ProgressLinear progressBar;

    @UI(".v-list-item__title")
    protected Text songName;

    @UI(".v-list-item__subtitle")
    protected Text songAuthor;

    @UI("//button[.//i[contains(@class, 'mdi-rewind')]]")
    protected Button arrowLeftButton;

    @UI("//button[.//i[contains(@class, 'mdi-pause')]]")
    protected Button pauseButton;

    @UI("//button[.//i[contains(@class, 'mdi-fast-forward')]]")
    protected Button arrowRightButton;


    public ProgressLinear progressBar() {
        return progressBar;
    }

    public Text songName() {
        return songName;
    }

    public Text songAuthor() {
        return songAuthor;
    }

    public Button arrowLeftButton() {
        return arrowLeftButton;
    }

    public Button pauseButton() {
        return pauseButton;
    }

    public Button arrowRightButton() {
        return arrowRightButton;
    }
}
