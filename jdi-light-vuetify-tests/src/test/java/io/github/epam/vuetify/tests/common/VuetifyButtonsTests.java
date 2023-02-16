package io.github.epam.vuetify.tests.common;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.blockButton;
import static io.github.com.pages.ButtonsPage.blockButtonState;
import static io.github.com.pages.ButtonsPage.commonButton;
import static io.github.com.pages.ButtonsPage.commonButtonState;
import static io.github.com.pages.ButtonsPage.depressedButtonState;
import static io.github.com.pages.ButtonsPage.depressedNormalButton;
import static io.github.com.pages.ButtonsPage.disabledButton;
import static io.github.com.pages.ButtonsPage.iconButtonState;
import static io.github.com.pages.ButtonsPage.iconButtons;
import static io.github.com.pages.ButtonsPage.loaderButtons;
import static io.github.com.pages.ButtonsPage.outlinedButton;
import static io.github.com.pages.ButtonsPage.outlinedButtonState;
import static io.github.com.pages.ButtonsPage.plainButtonState;
import static io.github.com.pages.ButtonsPage.plainButtons;
import static io.github.com.pages.ButtonsPage.roundedButton;
import static io.github.com.pages.ButtonsPage.roundedButtonState;
import static io.github.com.pages.ButtonsPage.sizingButton;
import static io.github.com.pages.ButtonsPage.sizingButtonState;
import static io.github.com.pages.ButtonsPage.textButtonState;
import static io.github.com.pages.ButtonsPage.textButtons;
import static io.github.com.pages.ButtonsPage.tileButton;
import static io.github.com.pages.ButtonsPage.tileButtonState;

import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.jdiai.tools.Timer;
import io.github.com.dataproviders.ButtonsDataProvider;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VuetifyButtonsTests extends TestsInit {

    @BeforeClass
    public void beforeClass() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test(description = "Test checks that common button is clickable")
    public void commonButtonsTests() {
        commonButton.has().hasNoLabel();
        commonButton.show();
        commonButton.is().displayed();
        commonButton.has().elevated();
        commonButton.has().lightTheme();
        commonButton.click();
        commonButtonState.has().text("Button clicked");
    }

    @Test(description = "Test checks button feature: 'block' (in css min-width=100%)")
    public void blockButtonsTests() {
        blockButton.has().hasNoLabel();
        blockButton.show();
        blockButton.is().displayed()
                .and().has().css("min-width", "100%");

        blockButton.click();
        blockButtonState.has().text("Block button clicked");
    }

    @Test(description = "Test checks button feature: 'depressed' and colors of the buttons",
            dataProvider = "depressedButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void depressedButtonsTests(int index, boolean enabled, String color, String name) {
        VuetifyButton button = depressedNormalButton.get(index);
        button.has().hasNoLabel();
        button.show();
        button.is().displayed();
        button.has().backgroundColor(color);

        if (enabled) {
            button.is().enabled();
            button.click();
            depressedButtonState.has().text("Depressed button clicked: " + name);
        } else {
            button.is().disabled();
        }
        depressedButtonState.has().text("Depressed button clicked: " + name);
    }

    @Test(description = "Test checks button feature: 'disabled'")
    public void disabledButtonsTests() {
        disabledButton.show();
        disabledButton.is().displayed();
        disabledButton.is().disabled();
    }

    @Test(description = "Test checks button feature: 'icon' type, clickable, displayed",
            dataProvider = "iconButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void iconButtonsTests(int index, boolean enabled, String iconType, String color, String name) {
        VuetifyButton button = iconButtons.get(index);
        button.has().hasNoLabel();
        button.show();
        button.is().displayed();
        button.icon().has().type(iconType).and().color(color);
        button.has().icon();

        if (enabled) {
            button.is().enabled();
            button.click();
        } else {
            button.is().disabled();
        }
        iconButtonState.has().text("Icon button clicked: " + name);
    }

    @Test(description = "Test checks button feature: 'loading'",
            dataProvider = "loadingButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void loaderButtonsTests(int index, String text, String loaderType, String content) {
        VuetifyButton button = loaderButtons.get(index);
        button.has().hasNoLabel();
        button.show();
        button.is().displayed().and().has().text(text);
        checkLoader(button, loaderType, content);

        Timer timer = new Timer(10000L);
        timer.wait(() -> button.is().enabled());
    }

    private void checkLoader(VuetifyButton button, String loaderType, String content) {
        button.click();
        button.is().loading().and().disabled();
        switch (loaderType) {
            case "text":
                waitCondition(() -> button.loader().isExist());
                button.loader().has().text(content);
                break;
            case "icon":
                Icon iconLoader = new Icon().setCore(Icon.class, button.loader().find("i"));
                waitCondition(iconLoader::isExist);
                iconLoader.is().displayed().and().has().type(content);
                break;
            default:
                ProgressCircular progressSpinner = new ProgressCircular().setCore(
                        ProgressCircular.class, button.loader().find(".v-progress-circular"));
                waitCondition(progressSpinner::isDisplayed);
                progressSpinner.is().spinning();
                break;
        }
    }

    @Test(description = "Test checks button feature: 'text' and its color",
            dataProvider = "textButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void textButtonsTests(int index, boolean enabled, String color, String text, String name) {
        VuetifyButton button = textButtons.get(index);
        button.has().hasNoLabel();
        button.show();
        button.is().displayed();
        button.has().color(color);
        button.has().css("background-color", Colors.TRANSPARENT.value())
                .and().css("border-style", "none")
                .and().text(text);

        if (enabled) {
            button.is().enabled();
            button.click();
        } else {
            button.is().disabled();
        }
        textButtonState.is().text("Text button clicked: " + name);
    }

    @Test(description = "Test checks button feature: 'plain'",
            dataProvider = "plainButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void plainButtonsTests(int index, String name, boolean withLoader) {
        VuetifyButton button = plainButtons.get(index);
        button.has().hasNoLabel();
        button.show();
        button.is().displayed();

        button.click();
        if (withLoader) {
            button.is().loading();
        }
        plainButtonState.is().text("Plain button clicked: " + name);
    }

    @Test(description = "Test checks button feature: 'outlined', 'border-color', clickable")
    public void outlinedButtonsTests() {
        outlinedButton.has().hasNoLabel();
        outlinedButton.show();
        outlinedButton.is().displayed();
        outlinedButton.has().css("color", Colors.INDIGO.value())
                .and().css("border-color", "rgb(63, 81, 181)");

        outlinedButton.has().outlined();
        outlinedButton.click();
        outlinedButtonState.is().text("Outlined button clicked");
    }

    @Test(description = "Test checks button feature: 'rounded' (here it is border-radius=28px)")
    public void roundedButtonsTests() {
        roundedButton.has().hasNoLabel();
        roundedButton.show();
        roundedButton.is().displayed();
        roundedButton.has().css("border-radius", "28px");

        roundedButton.click();
        roundedButtonState.is().text("Rounded button clicked");
    }

    @Test(description = "Test checks button feature: 'tile' (here it is border-radius=0px)")
    public void tileButtonsTests() {
        tileButton.has().hasNoLabel();
        tileButton.show();
        tileButton.is().displayed();
        tileButton.has().css("border-radius", "0px");

        tileButton.click();
        tileButtonState.is().text("Tile button clicked");
    }

    @Test(description = "Test checks button feature: 'size'",
            dataProvider = "sizingButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void sizingButtonsTests(int index, boolean enabled, String iconType, String color, String name, int height,
                                   int width) {
        VuetifyButton button = sizingButton.get(index);
        button.has().hasNoLabel();
        button.show();
        button.is().displayed();
        button.icon().has().type(iconType);
        button.has().backgroundColor(color);
        button.has().height(height);
        button.has().width(width);

        if (enabled) {
            button.is().enabled();
            button.click();
        } else {
            button.is().disabled();
        }
        sizingButtonState.has().text("Icon button is clicked: " + name);
    }
}
