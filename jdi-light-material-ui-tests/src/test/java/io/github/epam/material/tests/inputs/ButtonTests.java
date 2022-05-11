package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.ComplexMUIButton;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import io.github.epam.TestsInit;
import io.github.epam.test.data.ButtonDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonPage;
import static io.github.com.pages.inputs.ButtonPage.complexLastClick;
import static io.github.com.pages.inputs.ButtonPage.containedButtons;
import static io.github.com.pages.inputs.ButtonPage.customizedLastClick;
import static io.github.com.pages.inputs.ButtonPage.iconLastClick;
import static io.github.com.pages.inputs.ButtonPage.labeledLastClick;
import static io.github.com.pages.inputs.ButtonPage.simpleLastClick;
import static io.github.com.pages.inputs.ButtonPage.textButtons;
import static io.github.com.pages.inputs.ButtonPage.iconLabelButtons;
import static io.github.com.pages.inputs.ButtonPage.iconButtons;
import static io.github.com.pages.inputs.ButtonPage.customizedButtons;
import static io.github.com.pages.inputs.ButtonPage.complexButtons;
import static io.github.com.pages.inputs.ButtonPage.textLastClick;

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
    public void containedButtonTest(int buttonIndex, String buttonTitle, String reactiveResult) {
        MUIButton containedButton = containedButtons.get(buttonIndex);
        containedButton.label().is().text(buttonTitle);
        containedButton.isClickable();
        simpleLastClick.is().text(reactiveResult);
    }

    @Test (dataProvider = "textButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void textButtonTest(int buttonIndex, String buttonTitle, String reactiveResult) {
        MUIButton textButton = textButtons.get(buttonIndex);
        textButton.label().is().text(buttonTitle);
        textButton.isClickable();
        textLastClick.is().text(reactiveResult);
    }

    @Test (dataProvider = "iconLabelButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void iconLabelButtonTest(int buttonIndex, String buttonTitle, String reactiveResult) {
        MUIButton iconLabelButton = iconLabelButtons.get(buttonIndex);
        iconLabelButton.icon().is().displayed();
        iconLabelButton.label().is().text(buttonTitle);
        iconLabelButton.isClickable();
        labeledLastClick.is().text(reactiveResult);

    }

    @Test (dataProvider = "iconButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void iconButtonTest(int buttonIndex, String reactiveResult) {
        MUIButton iconButton = iconButtons.get(buttonIndex);
        iconButton.icon().is().displayed();
        iconButton.isClickable();
        iconLastClick.is().text(reactiveResult);
    }

    @Test (dataProvider = "customizeButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void customizeButtonTest(int buttonIndex, String buttonTitle, String reactiveResult) {
        MUIButton customizedButton = customizedButtons.get(buttonIndex);
        customizedButton.label().is().text(buttonTitle);
        customizedButton.is().enabled();
        customizedButton.click();
        customizedLastClick.is().text(reactiveResult);
    }

    @Test (dataProvider = "complexButtonTestData", dataProviderClass = ButtonDataProvider.class)
    public void complexButtonTest(int buttonIndex, String buttonTitle, String reactiveResult) {
        ComplexMUIButton complexButton = complexButtons.get(buttonIndex);
        complexButton.typography().is().text(buttonTitle);
        complexButton.image().is().displayed();
        complexButton.is().enabled();
        complexButton.click();
        complexLastClick.is().text(reactiveResult);
    }
}
