package pseudo.site.dataproviders;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.pages.Header.pseudoForm;

public class FormDataProvider {
    @DataProvider
    public Object[][] formDataProvider() {
        return new Object[][]{
                {pseudoForm, "", pseudoHeader, "Pseudo Form"},
                {pseudoForm.getFbWebElement(), "css='#fbWebElement-id'", pseudoForm, "Fb Web Element"},
                {pseudoForm.getFbPublicWebElement(), "css='#fbPublicWebElement-id'", pseudoForm, "Fb Public Web Element"},
                {pseudoForm.getFbPrivateWebElement(), "css='#fbPrivateWebElement-id'", pseudoForm, "Fb Private Web Element"},
                {pseudoForm.getFbStaticWebElement(), "css='#fbStaticWebElement-id'", pseudoForm, "Fb Static Web Element"},
                {pseudoForm.getFbPublicStaticWebElement(), "css='#fbPublicStaticWebElement-id'", pseudoForm, "Fb Public Static Web Element"},
                {pseudoForm.getFbPrivateStaticWebElement(), "css='#fbPrivateStaticWebElement-id'", pseudoForm, "Fb Private Static Web Element"},
                {pseudoForm.getUiWebElement(), "css='#uiWebElement-id'", pseudoForm, "Ui Web Element"},
                {pseudoForm.getUiPublicWebElement(), "css='#uiPublicWebElement-id'", pseudoForm, "Ui Public Web Element"},
                {pseudoForm.getFbWebElementList(), "css='.fbWebElementList-class'", pseudoForm, "Fb Web Element List"},
                {pseudoForm.getFbPublicWebElementList(), "css='.fbPublicWebElementList-class'", pseudoForm, "Fb Public Web Element List"},
                {pseudoForm.getFbPrivateWebElementList(), "css='.fbPrivateWebElementList-class'", pseudoForm, "Fb Private Web Element List"},
                {pseudoForm.getFbStaticWebElementList(), "css='.fbStaticWebElementList-class'", pseudoForm, "Fb Static Web Element List"},
                {pseudoForm.getFbPublicStaticWebElementList(), "css='.fbPublicStaticWebElementList-class'", pseudoForm, "Fb Public Static Web Element List"},
                {pseudoForm.getFbPrivateStaticWebElementList(), "css='.fbPrivateStaticWebElementList-class'", pseudoForm, "Fb Private Static Web Element List"},
                {pseudoForm.getUiWebElementList(), "css='.uiWebElementList-class'", pseudoForm, "Ui Web Element List"},
                {pseudoForm.getUiPublicWebElementList(), "css='.uiPublicWebElementList-class'", pseudoForm, "Ui Public Web Element List"},
                {pseudoForm.getFbUIElement(), "css='#fbUIElement-id'", pseudoForm, "Fb UI Element"},
                {pseudoForm.getFbPublicUIElement(), "css='#fbPublicUIElement-id'", pseudoForm, "Fb Public UI Element"},
                {pseudoForm.getFbPrivateUIElement(), "css='#fbPrivateUIElement-id'", pseudoForm, "Fb Private UI Element"},
                {pseudoForm.getFbStaticUIElement(), "css='#fbStaticUIElement-id'", pseudoForm, "Fb Static UI Element"},
                {pseudoForm.getFbPublicStaticUIElement(), "css='#fbPublicStaticUIElement-id'", pseudoForm, "Fb Public Static UI Element"},
                {pseudoForm.getFbPrivateStaticUIElement(), "css='#fbPrivateStaticUIElement-id'", pseudoForm, "Fb Private Static UI Element"},
                {pseudoForm.getUiUIElement(), "css='#uiUIElement-id'", pseudoForm, "Ui UI Element"},
                {pseudoForm.getUiPublicUIElement(), "css='#uiPublicUIElement-id'", pseudoForm, "Ui Public UI Element"},
                {pseudoForm.getFbUIElementList(), "css='.fbUIElementList-class'", pseudoForm, "Fb UI Element List"},
                {pseudoForm.getFbPublicUIElementList(), "css='.fbPublicUIElementList-class'", pseudoForm, "Fb Public UI Element List"},
                {pseudoForm.getFbPrivateUIElementList(), "css='.fbPrivateUIElementList-class'", pseudoForm, "Fb Private UI Element List"},
                {pseudoForm.getFbStaticUIElementList(), "css='.fbStaticUIElementList-class'", pseudoForm, "Fb Static UI Element List"},
                {pseudoForm.getFbPublicStaticUIElementList(), "css='.fbPublicStaticUIElementList-class'", pseudoForm, "Fb Public Static UI Element List"},
                {pseudoForm.getFbPrivateStaticUIElementList(), "css='.fbPrivateStaticUIElementList-class'", pseudoForm, "Fb Private Static UI Element List"},
                {pseudoForm.getUiUIElementList(), "css='.uiUIElementList-class'", pseudoForm, "Ui UI Element List"},
                {pseudoForm.getUiPublicUIElementList(), "css='.uiPublicUIElementList-class'", pseudoForm, "Ui Public UI Element List"},
                {pseudoForm.getFbButton(), "css='#fbButton-id'", pseudoForm, "Fb Button"},
                {pseudoForm.getFbPublicButton(), "css='#fbPublicButton-id'", pseudoForm, "Fb Public Button"},
                {pseudoForm.getFbPrivateButton(), "css='#fbPrivateButton-id'", pseudoForm, "Fb Private Button"},
                {pseudoForm.getFbStaticButton(), "css='#fbStaticButton-id'", pseudoForm, "Fb Static Button"},
                {pseudoForm.getFbPublicStaticButton(), "css='#fbPublicStaticButton-id'", pseudoForm, "Fb Public Static Button"},
                {pseudoForm.getFbPrivateStaticButton(), "css='#fbPrivateStaticButton-id'", pseudoForm, "Fb Private Static Button"},
                {pseudoForm.getUiButton(), "css='#uiButton-id'", pseudoForm, "Ui Button"},
                {pseudoForm.getUiPublicButton(), "css='#uiPublicButton-id'", pseudoForm, "Ui Public Button"},
                {pseudoForm.getFbButtonList(), "css='.fbButtonList-class'", pseudoForm, "Fb Button List"},
                {pseudoForm.getFbPublicButtonList(), "css='.fbPublicButtonList-class'", pseudoForm, "Fb Public Button List"},
                {pseudoForm.getFbPrivateButtonList(), "css='.fbPrivateButtonList-class'", pseudoForm, "Fb Private Button List"},
                {pseudoForm.getFbStaticButtonList(), "css='.fbStaticButtonList-class'", pseudoForm, "Fb Static Button List"},
                {pseudoForm.getFbPublicStaticButtonList(), "css='.fbPublicStaticButtonList-class'", pseudoForm, "Fb Public Static Button List"},
                {pseudoForm.getFbPrivateStaticButtonList(), "css='.fbPrivateStaticButtonList-class'", pseudoForm, "Fb Private Static Button List"},
                {pseudoForm.getUiButtonList(), "css='.uiButtonList-class'", pseudoForm, "Ui Button List"},
                {pseudoForm.getUiPublicButtonList(), "css='.uiPublicButtonList-class'", pseudoForm, "Ui Public Button List"},
                {pseudoForm.getFbWebList(), "css='.fbWebList-class'", pseudoForm, "Fb Web List"},
                {pseudoForm.getFbPublicWebList(), "css='.fbPublicWebList-class'", pseudoForm, "Fb Public Web List"},
                {pseudoForm.getFbPrivateWebList(), "css='.fbPrivateWebList-class'", pseudoForm, "Fb Private Web List"},
                {pseudoForm.getFbStaticWebList(), "css='.fbStaticWebList-class'", pseudoForm, "Fb Static Web List"},
                {pseudoForm.getFbPublicStaticWebList(), "css='.fbPublicStaticWebList-class'", pseudoForm, "Fb Public Static Web List"},
                {pseudoForm.getFbPrivateStaticWebList(), "css='.fbPrivateStaticWebList-class'", pseudoForm, "Fb Private Static Web List"},
                {pseudoForm.getUiWebList(), "css='.uiWebList-class'", pseudoForm, "Ui Web List"},
                {pseudoForm.getUiPublicWebList(), "css='.uiPublicWebList-class'", pseudoForm, "Ui Public Web List"},
                {pseudoForm.getDropList(), "css='div[ui=dropList]'", pseudoForm, "Drop List"},
                {pseudoForm.getPublicDropList(), "css='div[ui=publicDropList]'", pseudoForm, "Public Drop List"},
                {pseudoForm.getPrivateDropList(), "css='div[ui=privateDropList]'", pseudoForm, "Private Drop List"},
                {pseudoForm.getStaticDropList(), "css='div[ui=staticDropList]'", pseudoForm, "Static Drop List"},
                {pseudoForm.getPublicStaticDropList(), "css='div[ui=publicStaticDropList]'", pseudoForm, "Public Static Drop List"},
                {pseudoForm.getPrivateStaticDropList(), "css='div[ui=privateStaticDropList]'", pseudoForm, "Private Static Drop List"}
        };
    }
}
