package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.elements.common.Button;

import java.util.List;

/**
 * To see an example of Alert web element please visit
 * https://vuetifyjs.com/en/components/floating-action-buttons/
 */

public class FloatingActionButtonsPage extends VuetifyPage {

    @UI("#fb-heart")
    public static Button heartFloatingButton;

    @UI("#fb-plus")
    public static Button plusFloatingButton;

    @UI("#fb-pencil")
    public static Button pencilFloatingButton;

    @UI("#fb-state")
    public static Text floatingButtonState;

    @UI("//button[normalize-space()='Hide']")
    public static Button hideAnimationButton;

    @UI("//button[normalize-space()='Show']")
    public static Button showAnimationButton;

    @UI("//h2[text()='Display Animation']/following-sibling::div[contains(@class,'container')]//div[@class='v-toolbar__extension']/button")
    public static Button smallPlusAnimationButton;

    @UI("//h2[text()='Display Animation']/following-sibling::div[contains(@class,'container')]//div[@class='v-card__text']/button")
    public static Button plusAnimationButton;

    @UI("#da-state")
    public static Text animationButtonState;

    @UI(".v-tab")
    public static List<Button> lateralScreenTabs;

    @UI("//div[@id='lateral']//i[contains(@class,'mdi-share-variant')]")
    public static Button shareLateralScreenButton;

    @UI("//div[@id='lateral']//i[contains(@class,'mdi-pencil')]")
    public static Button pencilLateralScreenButton;

    @UI("//div[@id='lateral']//i[contains(@class,'mdi-chevron-up')]")
    public static Button chevronUpLateralScreenButton;

    @UI("#ls-state")
    public static Text lateralScreenButtonState;

    @UI("//h2[text()='Small Variant']/following-sibling::div//i[contains(@class,'mdi-plus')]")
    public static Button addSmallVariantButton;

    @UI(".v-dialog--active")
    public static Section smallVariantDialog;

    @UI(".v-dialog--active input")
    public static TextField fileNameTextField;

    @UI(".v-dialog--active button")
    public static Button submitButton;

    @UI("//h2[text()='Speed Dial']/following-sibling::div//i[contains(@class,'mdi-account-circle')]")
    public static Button expandSpeedDialButton;

    @UI("//h2[text()='Speed Dial']/following-sibling::div//i[contains(@class,'mdi-close')]")
    public static Button collapseSpeedDialButton;

    @UI(".v-speed-dial__list button")
    public static List<Button> listSpeedDialButtons;
}
