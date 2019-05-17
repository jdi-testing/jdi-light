package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.someSectionUI;

public class SomeSectionUIDataProvider {
    @DataProvider
    public Object[][] someSectionUIWebElementDataProvider() {
        return new Object[][]{
                {someSectionUI.webElementPublic, "id='webElementPublic'", someSectionUI, "Web Element Public"},
                {someSectionUI.webElementPublic, "id='webElementPublic'", someSectionUI, "Web Element Public"},
                {someSectionUI.webElementPublicUI, "css='.webElementPublicUI'", someSectionUI, "Web Element Public UI"},
                {someSectionUI.getWebElementPackage(), "id='webElementPackage'", someSectionUI, "Web Element Package"},
                {someSectionUI.getWebElementPrivate(), "id='webElementPrivate'", someSectionUI, "Web Element Private"},
                {someSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", someSectionUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {someSectionUI.listWebElementPublic, "id='listWebElementPublic'", someSectionUI, "List Web Element Public"},
                {someSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", someSectionUI, "List Web Element Public UI"},
                {someSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", someSectionUI, "List Web Element Package"},
                {someSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", someSectionUI, "List Web Element Private"},
                {someSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", someSectionUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIUIElementDataProvider() {
        return new Object[][]{
                {someSectionUI.uielementPublic, "id='uielementPublic'", someSectionUI, "Uielement Public"},
                {someSectionUI.uielementPublicUI, "css='.uielementPublicUI'", someSectionUI, "Uielement Public UI"},
                {someSectionUI.getUielementPackage(), "id='uielementPackage'", someSectionUI, "Uielement Package"},
                {someSectionUI.getUielementPrivate(), "id='uielementPrivate'", someSectionUI, "Uielement Private"},
                {someSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", someSectionUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIButtonDataProvider() {
        return new Object[][]{
                {someSectionUI.getButtonPackage(), "id='buttonPackage'", someSectionUI, "Button Package"},
                {someSectionUI.buttonPublic, "id='buttonPublic'", someSectionUI, "Button Public"},
                {someSectionUI.getButtonPrivate(), "id='buttonPrivate'", someSectionUI, "Button Private"},
                {someSectionUI.buttonPublicUI, "css='.buttonPublicUI'", someSectionUI, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIWebListDataProvider() {
        return new Object[][]{
                {someSectionUI.getWebListPackage(), "id='webListPackage'", someSectionUI, "Web List Package"},
                {someSectionUI.webListPublic, "id='webListPublic'", someSectionUI, "Web List Public"},
                {someSectionUI.getWebListPrivate(), "id='webListPrivate'", someSectionUI, "Web List Private"},
                {someSectionUI.getWebListPrivate(), "id='webListPrivate'", someSectionUI, "Web List Private"},
                {someSectionUI.getWebListPackageUI(), "css='.webListPackageUI'", someSectionUI, "Web List Package UI"},
                {someSectionUI.webListPublicUI, "css='.webListPublicUI'", someSectionUI, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {someSectionUI.listUIElementPublic, "id = 'listUIElementPublic'", someSectionUI, "List UIElement Public"},
                {someSectionUI.getListUIElementPackage(), "id = 'listUIElementPackage'", someSectionUI, "List UIElement Package"},
                {someSectionUI.getListUIElementPrivate(), "id = 'listUIElementPrivate'", someSectionUI, "List UIElement Private"},
                {someSectionUI.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", someSectionUI, "List UIElement Package UI"},
                {someSectionUI.listUIElementPublicUI, "css = '.listUIElementPublicUI'", someSectionUI, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListButtonPublicDataProvider() {
        return new Object[][]{
                {someSectionUI.getListButtonPackage(), "id = 'listButtonPackage'", someSectionUI, "List UIElement Package"},
                {someSectionUI.listButtonPublic, "id = 'listUIElementPublic'", someSectionUI, "List UIElement Public"},
                {someSectionUI.getListButtonPrivate(), "id = 'listButtonPrivate'", someSectionUI, "List UIElement Private"},
                {someSectionUI.getListButtonPackageUI(), "css = '.listButtonPackageUI'", someSectionUI, "List UIElement Package UI"},
                {someSectionUI.listButtonPublicUI, "css = '.listButtonPublicUI'", someSectionUI, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIUIListQuestionDataProvider() {
        return new Object[][]{
                {someSectionUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", someSectionUI, "Uilist Question Package"},
                {someSectionUI.uilistQuestionPublic, "id='uilistQuestionPublic'", someSectionUI, "Uilist Question Public"},
                {someSectionUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", someSectionUI, "Uilist Question Private"},
                {someSectionUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", someSectionUI, "Uilist Question Package UI"},
                {someSectionUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", someSectionUI, "Uilist Question Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {someSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", someSectionUI, "Uilist Somedata Package"},
                {someSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", someSectionUI, "Uilist Somedata Public"},
                {someSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", someSectionUI, "Uilist Somedata Private"},
                {someSectionUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", someSectionUI, "Uilist Somedata Package UI"},
                {someSectionUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", someSectionUI, "Uilist Somedata Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIDropDownDataProvider() {
        return new Object[][]{
                {someSectionUI.getDroplistPackage(), "css='div[ui=droplistPackage'", someSectionUI, "Droplist Package"},
                {someSectionUI.droplistPublic, "css='div[ui=droplistPublic'", someSectionUI, "Droplist Public"},
                {someSectionUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", someSectionUI, "Droplist Private"},
                {someSectionUI.getDroplistPackageUI(), "css='.droplistPackageUI'", someSectionUI, "Droplist Package UI"},
                {someSectionUI.droplistPublicUI, "css='.droplistPublicUI'", someSectionUI, "Droplist Public UI"},
        };
    }
}
