package io.github.epam.vuetify.tests.common;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.blockButton;
import static io.github.com.pages.ButtonsPage.blockButtonState;
import static io.github.com.pages.ButtonsPage.commonButton;
import static io.github.com.pages.ButtonsPage.commonButtonState;
import static io.github.com.pages.ButtonsPage.depressedButtonState;
import static io.github.com.pages.ButtonsPage.depressedNormalButton;
import static io.github.com.pages.ButtonsPage.iconButtonState;
import static io.github.com.pages.ButtonsPage.iconButtons;
import static io.github.com.pages.ButtonsPage.loaderButtons;
import static io.github.com.pages.ButtonsPage.outlinedButton;
import static io.github.com.pages.ButtonsPage.outlinedButtonState;
import static io.github.com.pages.ButtonsPage.plainButtonState;
import static io.github.com.pages.ButtonsPage.plainButtons;
import static io.github.com.pages.ButtonsPage.roundedButton;
import static io.github.com.pages.ButtonsPage.roundedButtonState;
import static io.github.com.pages.ButtonsPage.textButtonState;
import static io.github.com.pages.ButtonsPage.textButtons;
import static io.github.com.pages.ButtonsPage.tileButton;
import static io.github.com.pages.ButtonsPage.tileButtonState;

import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.ProgressSpinner;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.tools.Timer;
import io.github.com.dataproviders.ButtonsDataProvider;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsTests extends TestsInit {

    @BeforeClass
    public void beforeClass() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
    }

    @Test
    public void commonButtonsTests() {
        commonButton.show();
        commonButton.is().displayed();

        commonButton.click();
        commonButtonState.has().text("Button clicked");
    }

    @Test
    public void blockButtonsTests() {
        blockButton.show();
        blockButton.is().displayed()
                .and().has().css("min-width", "100%");

        blockButton.click();
        blockButtonState.has().text("Block button clicked");
    }

    @Test(dataProvider = "depressedButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void depressedButtonsTests(int index, boolean enabled, String color, String name) {
        VuetifyButton button = depressedNormalButton.get(index);
        button.show();
        button.is().displayed();
        button.has().css("background-color", color);

        if (enabled) {
            button.is().enabled();
            button.click();
            depressedButtonState.has().text("Depressed button clicked: " + name);
        } else {
            button.is().disabled();
        }
        depressedButtonState.has().text("Depressed button clicked: " + name);
    }

    @Test(dataProvider = "iconButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void iconButtonsTests(int index, boolean enabled, String iconType, String color, String name) {
        VuetifyButton button = iconButtons.get(index);
        button.show();
        button.is().displayed();
        button.has().iconType(iconType).and().css("color", color);

        if (enabled) {
            button.is().enabled();
            button.click();
        } else {
            button.is().disabled();
        }
        iconButtonState.has().text("Icon button clicked: " + name);
    }

    @Test(dataProvider = "loadingButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void loaderButtonsTests(int index, String text, String loaderType, String content) {
        VuetifyButton button = loaderButtons.get(index);
        button.show();
        button.is().displayed().and().has().text(text);

        button.click();
        button.is().loading().and().disabled();
        checkLoader(button, loaderType, content);

        Timer timer = new Timer(10000L);
        timer.wait(() -> button.is().enabled());
    }

    private void checkLoader(VuetifyButton button, String loaderType, String content) {
        switch (loaderType) {
            case "text":
                button.loader().has().text(content);
                break;
            case "icon":
                Icon icon = new Icon().setCore(Icon.class, button.loader().find("i"));
                icon.is().displayed().and().has().type(content);
                break;
            default:
                ProgressSpinner progressSpinner = new ProgressSpinner().setCore(
                        ProgressSpinner.class, button.loader().find(".v-progress-circular")
                );
                progressSpinner.is().displayed().and().spinning();
        }
    }

    @Test(dataProvider = "textButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void textButtonsTests(int index, boolean enabled, String color, String text, String name) {
        VuetifyButton button = textButtons.get(index);
        button.show();
        button.is().displayed();
        button.has().css("color", color)
                .and().css("background-color", "rgba(0, 0, 0, 0)")
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

    @Test(dataProvider = "plainButtons",
            dataProviderClass = ButtonsDataProvider.class)
    public void plainButtonsTests(int index, String name, boolean withLoader) {
        VuetifyButton button = plainButtons.get(index);
        button.show();
        button.is().displayed();

        button.click();
        if (withLoader) {
            button.is().loading();
        }
        plainButtonState.is().text("Plain button clicked: " + name);
    }

    @Test
    public void outlinedButtonsTests() {
        outlinedButton.show();
        outlinedButton.is().displayed();
        outlinedButton.has().css("color", Colors.INDIGO.toString())
                .and().css("border-color", "rgb(63, 81, 181)");

        outlinedButton.click();
        outlinedButtonState.is().text("Outlined button clicked");
    }

    @Test
    public void roundedButtonsTests() {
        roundedButton.show();
        roundedButton.is().displayed();
        roundedButton.has().css("border-radius", "28px");

        roundedButton.click();
        roundedButtonState.is().text("Rounded button clicked");
    }

    @Test
    public void tileButtonsTests() {
        tileButton.show();
        tileButton.is().displayed();
        tileButton.has().css("border-radius", "0px");

        tileButton.click();
        tileButtonState.is().text("Tile button clicked");
    }
}
