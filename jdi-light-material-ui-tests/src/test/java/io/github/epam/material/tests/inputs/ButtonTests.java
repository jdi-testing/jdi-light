package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.ComplexMUIButton;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import io.github.epam.TestsInit;
import io.github.epam.test.data.ButtonDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonPage;
import static io.github.com.pages.inputs.ButtonPage.containedButtons;
import static io.github.com.pages.inputs.ButtonPage.textButtons;
import static io.github.com.pages.inputs.ButtonPage.iconLabelButtons;
import static io.github.com.pages.inputs.ButtonPage.iconButtons;
import static io.github.com.pages.inputs.ButtonPage.customizedButtons;
import static io.github.com.pages.inputs.ButtonPage.complexButtons;

/**
 * To see an example of Button web element please visit
 * https://material-ui.com/components/buttons/
 */
public class ButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonPage.open();
        buttonPage.isOpened();
    }

    @Test(dataProvider = "containedButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void containedButtonTest(int buttonIndex, String buttonTitle, boolean isEnable){
        MUIButton containedButton = containedButtons.get(buttonIndex);
        containedButton.label().is().text(buttonTitle);
        if(isEnable) {
            containedButton.is().enabled();
            containedButton.click();
        } else {
            containedButton.is().disabled();
        }
    }

    @Test (dataProvider = "textButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void textButtonTest(int buttonIndex, String buttonTitle, boolean isEnable) {
        MUIButton textButton = textButtons.get(buttonIndex);
        textButton.label().is().text(buttonTitle);
        if(isEnable) {
            textButton.is().enabled();
            textButton.click();
        } else {
            textButton.is().disabled();
        }
    }

    @Test (dataProvider = "iconLabelButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void iconLabelButtonTest(int buttonIndex, String buttonTitle, boolean isEnable) {
        MUIButton iconLabelButton = iconLabelButtons.get(buttonIndex);
        iconLabelButton.icon().is().displayed();
        iconLabelButton.label().is().text(buttonTitle);
        if(isEnable){
            iconLabelButton.is().enabled();
            iconLabelButton.click();
        } else {
            iconLabelButton.is().disabled();
        }
    }

    @Test (dataProvider = "iconButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void iconButtonTest(int buttonIndex, boolean isEnable) {
        MUIButton iconButton = iconButtons.get(buttonIndex);
        iconButton.icon().is().displayed();
        if (isEnable) {
            iconButton.is().enabled();
            iconButton.click();
        } else {
            iconButton.is().disabled();
        }
    }

    @Test (dataProvider = "customizeButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void customizeButtonTest(int buttonIndex, String buttonTitle, boolean isEnable) {
        MUIButton customizedButton = customizedButtons.get(buttonIndex);
        customizedButton.label().is().text(buttonTitle);
        if (isEnable) {
            customizedButton.is().enabled();
            customizedButton.click();
        } else {
            customizedButton.is().disabled();
        }
    }

    @Test (dataProvider = "complexButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void complexButtonTest(int buttonIndex, String buttonTitle, boolean isEnable) {
        ComplexMUIButton complexButton = complexButtons.get(buttonIndex);
        complexButton.typography().is().text(buttonTitle);
        complexButton.image().is().displayed();
        if (isEnable) {
            complexButton.is().enabled();
            complexButton.click();
        } else {
            complexButton.is().disabled();
        }
    }
}
