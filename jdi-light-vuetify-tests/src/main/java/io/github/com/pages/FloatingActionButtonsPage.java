package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.radiobuttons.RadioButtons;
import java.util.List;

/**
 * To see an example of Alert web element please visit
 * https://vuetifyjs.com/en/components/floating-action-buttons/
 */

public class FloatingActionButtonsPage extends VuetifyPage {

    @UI("#fb-heart")
    public static VuetifyButton heartFloatingButton;

    @UI("#fb-plus")
    public static VuetifyButton plusFloatingButton;

    @UI("#fb-pencil")
    public static VuetifyButton pencilFloatingButton;

    @UI("#fb-state")
    public static Text floatingButtonState;

    @UI("//button[normalize-space()='Hide']")
    public static VuetifyButton hideAnimationButton;

    @UI("//button[normalize-space()='Show']")
    public static VuetifyButton showAnimationButton;

    @UI("//h2[text()='Display Animation']/following-sibling::div[contains(@class,'container')]//div[@class='v-toolbar__extension']/button")
    public static VuetifyButton smallPlusAnimationButton;

    @UI("//h2[text()='Display Animation']/following-sibling::div[contains(@class,'container')]//div[@class='v-card__text']/button")
    public static VuetifyButton plusAnimationButton;

    @UI("#da-state")
    public static Text animationButtonState;

    @UI(".v-tab")
    public static List<VuetifyButton> lateralScreenTabs;

    @UI("//div[@id='lateral']//i[contains(@class,'mdi-share-variant')]")
    public static VuetifyButton shareLateralScreenButton;

    @UI("//div[@id='lateral']//i[contains(@class,'mdi-pencil')]")
    public static VuetifyButton pencilLateralScreenButton;

    @UI("//div[@id='lateral']//i[contains(@class,'mdi-chevron-up')]")
    public static VuetifyButton chevronUpLateralScreenButton;

    @UI("#ls-state")
    public static Text lateralScreenButtonState;

    @UI("//h2[text()='Small Variant']/following-sibling::div//button[contains(@class,'v-btn--absolute')]")
    public static VuetifyButton addSmallVariantButton;

    @UI(".v-dialog--active")
    public static Section smallVariantDialog;

    @UI(".v-dialog--active input")
    public static TextField fileNameTextField;

    @UI(".v-dialog--active button")
    public static VuetifyButton submitButton;

    @UI("//h2[text()='Speed Dial']/following-sibling::div//div[contains(@class,'v-speed-dial--')]")
    public static VuetifyButton expandSpeedDialButton;

    @UI("//div[text()='FAB location']/following-sibling::div//div[contains(@class, 'v-input--selection-controls__input')]")
    @WaitAfterAction(1)
    public static List<VueCheckbox> fabLocationCheckbox;

    @UI("//div[text()='Speed dial direction']/following-sibling::div//div[contains(@class, 'v-input--selection-controls__input')]")
    @WaitAfterAction(1)
    public static RadioButtons speedDialDirectionRadioButtons;

    @UI("//div[text()='Options']/following-sibling::div//div[contains(@class, 'v-input--selection-controls__input')]")
    @WaitAfterAction(1)
    public static VueCheckbox hoverSpeedDialCheckbox;

    @UI("//h2[text()='Speed Dial']/following-sibling::div//i[contains(@class,'mdi-close')]")
    public static VuetifyButton collapseSpeedDialButton;

    @UI(".v-speed-dial__list button")
    public static List<VuetifyButton> listSpeedDialButtons;
}
