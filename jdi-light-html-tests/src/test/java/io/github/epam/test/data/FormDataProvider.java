package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.pages.Header.pseudoForm;
import static pseudo.site.pages.Header.pseudoFormSmart;

public class FormDataProvider {
    @DataProvider
    public Object[][] formDataProvider() {
        return new Object[][]{
                {pseudoForm, "smart: #pseudo-form", pseudoHeader, "Pseudo Form"},

                {pseudoForm.getFbWebElement(), "css='#fbWebElement-id'", pseudoForm, "Fb Web Element"},
                {pseudoForm.getFbPublicWebElement(), "css='#fbPublicWebElement-id'", pseudoForm, "Fb Public Web Element"},
                {pseudoForm.getFbPrivateWebElement(), "css='#fbPrivateWebElement-id'", pseudoForm, "Fb Private Web Element"},
                {pseudoForm.getUiWebElement(), "css='#uiWebElement-id'", pseudoForm, "Ui Web Element"},
                {pseudoForm.getUiPublicWebElement(), "css='#uiPublicWebElement-id'", pseudoForm, "Ui Public Web Element"},
                {pseudoForm.getCssWebElement(), "css='#cssWebElement-id'", pseudoForm, "Css Web Element"},
                {pseudoForm.getXpathPublicWebElement(), "xpath='//*[@id='xpathPublicWebElement-id']'", pseudoForm, "Xpath Public Web Element"},

                {pseudoForm.getFbWebElementList(), "css='.fbWebElementList-class'", pseudoForm, "Fb Web Element List"},
                {pseudoForm.getFbPublicWebElementList(), "css='.fbPublicWebElementList-class'", pseudoForm, "Fb Public Web Element List"},
                {pseudoForm.getFbPrivateWebElementList(), "css='.fbPrivateWebElementList-class'", pseudoForm, "Fb Private Web Element List"},
                {pseudoForm.getUiWebElementList(), "css='.uiWebElementList-class'", pseudoForm, "Ui Web Element List"},
                {pseudoForm.getUiPublicWebElementList(), "css='.uiPublicWebElementList-class'", pseudoForm, "Ui Public Web Element List"},
                {pseudoForm.getCssWebElementList(), "css='.cssWebElementList-class'", pseudoForm, "Css Web Element List"},
                {pseudoForm.getXpathPublicWebElementList(), "xpath='//*[@class='xpathPublicWebElementList-class']'", pseudoForm, "Xpath Public Web Element List"},

                {pseudoForm.getFbUIElement(), "css='#fbUIElement-id'", pseudoForm, "Fb UI Element"},
                {pseudoForm.getFbPublicUIElement(), "css='#fbPublicUIElement-id'", pseudoForm, "Fb Public UI Element"},
                {pseudoForm.getFbPrivateUIElement(), "css='#fbPrivateUIElement-id'", pseudoForm, "Fb Private UI Element"},
                {pseudoForm.getUiUIElement(), "css='#uiUIElement-id'", pseudoForm, "Ui UI Element"},
                {pseudoForm.getUiPublicUIElement(), "css='#uiPublicUIElement-id'", pseudoForm, "Ui Public UI Element"},
                {pseudoForm.getCssUIElement(), "css='#cssUIElement-id'", pseudoForm, "Css UI Element"},
                {pseudoForm.getXpathPublicUIElement(), "xpath='//*[@id='xpathPublicUIElement-id']'", pseudoForm, "Xpath Public UI Element"},

                {pseudoForm.getFbUIElementList(), "css='.fbUIElementList-class'", pseudoForm, "Fb UI Element List"},
                {pseudoForm.getFbPublicUIElementList(), "css='.fbPublicUIElementList-class'", pseudoForm, "Fb Public UI Element List"},
                {pseudoForm.getFbPrivateUIElementList(), "css='.fbPrivateUIElementList-class'", pseudoForm, "Fb Private UI Element List"},
                {pseudoForm.getUiUIElementList(), "css='.uiUIElementList-class'", pseudoForm, "Ui UI Element List"},
                {pseudoForm.getUiPublicUIElementList(), "css='.uiPublicUIElementList-class'", pseudoForm, "Ui Public UI Element List"},
                {pseudoForm.getCssUIElementList(), "css='.cssUIElementList-class'", pseudoForm, "Css UI Element List"},
                {pseudoForm.getXpathPublicUIElementList(), "xpath='//*[@class='xpathPublicUIElementList-class']'", pseudoForm, "Xpath Public UI Element List"},

                {pseudoForm.getFbButton(), "css='#fbButton-id'", pseudoForm, "Fb Button"},
                {pseudoForm.getFbPublicButton(), "css='#fbPublicButton-id'", pseudoForm, "Fb Public Button"},
                {pseudoForm.getFbPrivateButton(), "css='#fbPrivateButton-id'", pseudoForm, "Fb Private Button"},
                {pseudoForm.getUiButton(), "css='#uiButton-id'", pseudoForm, "Ui Button"},
                {pseudoForm.getUiPublicButton(), "css='#uiPublicButton-id'", pseudoForm, "Ui Public Button"},
                {pseudoForm.getCssButton(), "css='#cssButton-id'", pseudoForm, "Css Button"},
                {pseudoForm.getXpathPublicButton(), "xpath='//*[@id='xpathPublicButton-id']'", pseudoForm, "Xpath Public Button"},

                {pseudoForm.getFbButtonList(), "css='.fbButtonList-class'", pseudoForm, "Fb Button List"},
                {pseudoForm.getFbPublicButtonList(), "css='.fbPublicButtonList-class'", pseudoForm, "Fb Public Button List"},
                {pseudoForm.getFbPrivateButtonList(), "css='.fbPrivateButtonList-class'", pseudoForm, "Fb Private Button List"},
                {pseudoForm.getUiButtonList(), "css='.uiButtonList-class'", pseudoForm, "Ui Button List"},
                {pseudoForm.getUiPublicButtonList(), "css='.uiPublicButtonList-class'", pseudoForm, "Ui Public Button List"},
                {pseudoForm.getCssButtonList(), "css='.cssButtonList-class'", pseudoForm, "Css Button List"},
                {pseudoForm.getXpathPublicButtonList(), "xpath='//*[@class='xpathPublicButtonList-class']'", pseudoForm, "Xpath Public Button List"},

                {pseudoForm.getFbWebList(), "css='.fbWebList-class'", pseudoForm, "Fb Web List"},
                {pseudoForm.getFbPublicWebList(), "css='.fbPublicWebList-class'", pseudoForm, "Fb Public Web List"},
                {pseudoForm.getFbPrivateWebList(), "css='.fbPrivateWebList-class'", pseudoForm, "Fb Private Web List"},
                {pseudoForm.getUiWebList(), "css='.uiWebList-class'", pseudoForm, "Ui Web List"},
                {pseudoForm.getUiPublicWebList(), "css='.uiPublicWebList-class'", pseudoForm, "Ui Public Web List"},
                {pseudoForm.getCssWebList(), "css='#cssWebList-id'", pseudoForm, "Css Web List"},
                {pseudoForm.getXpathPublicWebList(), "xpath='//*[@id='xpathPublicWebList-id']'", pseudoForm, "Xpath Public Web List"},

                {pseudoForm.getDropList(), "css='div[ui=dropList]'", pseudoForm, "Drop List"},
                {pseudoForm.getPublicDropList(), "css='div[ui=publicDropList]'", pseudoForm, "Public Drop List"},
                {pseudoForm.getPrivateDropList(), "css='div[ui=privateDropList]'", pseudoForm, "Private Drop List"}
        };
    }

    @DataProvider
    public Object[][] smartFormDataProvider() {
        return new Object[][]{
                {pseudoFormSmart, "smart: #pseudo-form-smart", pseudoHeader, "Pseudo Form Smart"},

                {pseudoFormSmart.getFbWebElement(), "smart: #fb-web-element", pseudoFormSmart, "Fb Web Element"},
                {pseudoFormSmart.getFbPublicWebElement(), "smart: #fb-public-web-element", pseudoFormSmart, "Fb Public Web Element"},
                {pseudoFormSmart.getFbPrivateWebElement(), "smart: #fb-private-web-element", pseudoFormSmart, "Fb Private Web Element"},

                {pseudoFormSmart.getFbWebElementList(), "smart: #fb-web-element-list", pseudoFormSmart, "Fb Web Element List"},
                {pseudoFormSmart.getFbPublicWebElementList(), "smart: #fb-public-web-element-list", pseudoFormSmart, "Fb Public Web Element List"},
                {pseudoFormSmart.getFbPrivateWebElementList(), "smart: #fb-private-web-element-list", pseudoFormSmart, "Fb Private Web Element List"},

                {pseudoFormSmart.getFbUIElement(), "smart: #fb-ui-element", pseudoFormSmart, "Fb UI Element"},
                {pseudoFormSmart.getFbPublicUIElement(), "smart: #fb-public-ui-element", pseudoFormSmart, "Fb Public UI Element"},
                {pseudoFormSmart.getFbPrivateUIElement(), "smart: #fb-private-ui-element", pseudoFormSmart, "Fb Private UI Element"},

                {pseudoFormSmart.getFbUIElementList(), "smart: #fb-ui-element-list", pseudoFormSmart, "Fb UI Element List"},
                {pseudoFormSmart.getFbPublicUIElementList(), "smart: #fb-public-ui-element-list", pseudoFormSmart, "Fb Public UI Element List"},
                {pseudoFormSmart.getFbPrivateUIElementList(), "smart: #fb-private-ui-element-list", pseudoFormSmart, "Fb Private UI Element List"},

                {pseudoFormSmart.getFbButton(), "smart: #fb-button", pseudoFormSmart, "Fb Button"},
                {pseudoFormSmart.getFbPublicButton(), "smart: #fb-public-button", pseudoFormSmart, "Fb Public Button"},
                {pseudoFormSmart.getFbPrivateButton(), "smart: #fb-private-button", pseudoFormSmart, "Fb Private Button"},

                {pseudoFormSmart.getFbButtonList(), "smart: #fb-button-list", pseudoFormSmart, "Fb Button List"},
                {pseudoFormSmart.getFbPublicButtonList(), "smart: #fb-public-button-list", pseudoFormSmart, "Fb Public Button List"},
                {pseudoFormSmart.getFbPrivateButtonList(), "smart: #fb-private-button-list", pseudoFormSmart, "Fb Private Button List"},

                {pseudoFormSmart.getFbWebList(), "smart: #fb-web-list", pseudoFormSmart, "Fb Web List"},
                {pseudoFormSmart.getFbPublicWebList(), "smart: #fb-public-web-list", pseudoFormSmart, "Fb Public Web List"},
                {pseudoFormSmart.getFbPrivateWebList(), "smart: #fb-private-web-list", pseudoFormSmart, "Fb Private Web List"}
        };
    }
}
