package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomeObject;

import static pseudo.site.PseudoSite.someObjectUI;

public class SomeObjectUIDataProvider {
    @DataProvider
    public Object[][] someObjectUIWebElementDataProvider() {
        return new Object[][]{
                {someObjectUI.webElementPublic, "id='webElementPublic'", someObjectUI, "Web Element Public"},
                {someObjectUI.webElementPublic, "id='webElementPublic'", someObjectUI, "Web Element Public"},
                {someObjectUI.webElementPublicUI, "css='.webElementPublicUI'", someObjectUI, "Web Element Public UI"},
                {SomeObject.webElementPublicStatic, "id='webElementPublicStatic'", someObjectUI, "Web Element Public Static"},
                {someObjectUI.getWebElementPackage(), "id='webElementPackage'", someObjectUI, "Web Element Package"},
                {someObjectUI.getWebElementPrivate(), "id='webElementPrivate'", someObjectUI, "Web Element Private"},
                {SomeObject.getWebElementPackageStatic(), "id='webElementPackageStatic'", someObjectUI, "Web Element Package Static"},
                {SomeObject.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", someObjectUI, "Web Element Private Static"},
                {someObjectUI.getWebElementPackageUI(), "css='.webElementPackageUI'", someObjectUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someObjectUIListWebElementDataProvider() {
        return new Object[][]{
                {someObjectUI.listWebElementPublic, "id='listWebElementPublic'", someObjectUI, "List Web Element Public"},
                {someObjectUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", someObjectUI, "List Web Element Public UI"},
                {SomeObject.listWebElementPublicStatic, "id='listWebElementPublicStatic'", someObjectUI, "List Web Element Public Static"},
                {someObjectUI.getListWebElementPackage(), "id='listWebElementPackage'", someObjectUI, "List Web Element Package"},
                {someObjectUI.getListWebElementPrivate(), "id='listWebElementPrivate'", someObjectUI, "List Web Element Private"},
                {SomeObject.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", someObjectUI, "List Web Element Package Static"},
                {SomeObject.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", someObjectUI, "List Web Element Private Static"},
                {someObjectUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", someObjectUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIUIElementDataProvider() {
        return new Object[][]{
                {someObjectUI.uielementPublic, "id='uielementPublic'", someObjectUI, "Uielement Public"},
                {someObjectUI.uielementPublicUI, "css='.uielementPublicUI'", someObjectUI, "Uielement Public UI"},
                {SomeObject.uielementPublicStatic, "id='uielementPublicStatic'", someObjectUI, "Uielement Public Static"},
                {someObjectUI.getUielementPackage(), "id='uielementPackage'", someObjectUI, "Uielement Package"},
                {someObjectUI.getUielementPrivate(), "id='uielementPrivate'", someObjectUI, "Uielement Private"},
                {SomeObject.getUielementPackageStatic(), "id='uielementPackageStatic'", someObjectUI, "Uielement Package Static"},
                {SomeObject.getUielementPrivateStatic(), "id='uielementPrivateStatic'", someObjectUI, "Uielement Private Static"},
                {someObjectUI.getUielementPackageUI(), "css='.uielementPackageUI'", someObjectUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIButtonDataProvider() {
        return new Object[][]{
                {someObjectUI.getButtonPackage(), "id='buttonPackage'", someObjectUI, "Button Package"},
                {someObjectUI.buttonPublic, "id='buttonPublic'", someObjectUI, "Button Public"},
                {someObjectUI.getButtonPrivate(), "id='buttonPrivate'", someObjectUI, "Button Private"},
                {SomeObject.getButtonPackageStatic(), "id='buttonPackageStatic'", someObjectUI, "Button Package Static"},
                {SomeObject.buttonPublicStatic, "id='buttonPublicStatic'", someObjectUI, "Button Public Static"},
                {SomeObject.getButtonPrivateStatic(), "id='buttonPrivateStatic'", someObjectUI, "Button Private Static"},
                {someObjectUI.buttonPublicUI, "css='.buttonPublicUI'", someObjectUI, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIWebListDataProvider() {
        return new Object[][]{
                {someObjectUI.getWebListPackage(), "id='webListPackage'", someObjectUI, "Web List Package"},
                {someObjectUI.webListPublic, "id='webListPublic'", someObjectUI, "Web List Public"},
                {someObjectUI.getWebListPrivate(), "id='webListPrivate'", someObjectUI, "Web List Private"},
                {SomeObject.getWebListPackageStatic(), "id='webListPackageStatic'", someObjectUI, "Web List Package Static"},
                {SomeObject.webListPublicStatic, "id='webListPublicStatic'", someObjectUI, "Web List Public Static"},
                {SomeObject.getWebListPrivateStatic(), "id='webListPrivateStatic'", someObjectUI, "Web List Private Static"},
                {someObjectUI.getWebListPackageUI(), "css='.webListPackageUI'", someObjectUI, "Web List Package UI"},
                {someObjectUI.webListPublicUI, "css='.webListPublicUI'", someObjectUI, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {someObjectUI.listUIElementPublic, "id = 'listUIElementPublic'", someObjectUI, "List UIElement Public"},
                {someObjectUI.getListUIElementPackage(), "id = 'listUIElementPackage'", someObjectUI, "List UIElement Package"},
                {someObjectUI.getListUIElementPrivate(), "id = 'listUIElementPrivate'", someObjectUI, "List UIElement Private"},
                {SomeObject.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", someObjectUI, "List UIElement Package Static"},
                {SomeObject.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", someObjectUI, "List UIElement Public Static"},
                {SomeObject.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", someObjectUI, "List UIElement Private Static"},
                {someObjectUI.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", someObjectUI, "List UIElement Package UI"},
                {someObjectUI.listUIElementPublicUI, "css = '.listUIElementPublicUI'", someObjectUI, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someObjectUIListButtonPublicDataProvider() {
        return new Object[][]{
                {someObjectUI.getListButtonPackage(), "id = 'listButtonPackage'", someObjectUI, "List UIElement Package"},
                {someObjectUI.listButtonPublic, "id = 'listUIElementPublic'", someObjectUI, "List UIElement Public"},
                {someObjectUI.getListButtonPrivate(), "id = 'listButtonPrivate'", someObjectUI, "List UIElement Private"},
                {SomeObject.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", someObjectUI, "List UIElement Package Static"},
                {SomeObject.listButtonPublicStatic, "id = 'listButtonPublicStatic'", someObjectUI, "List UIElement Public Static"},
                {SomeObject.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", someObjectUI, "List UIElement Private Static"},
                {someObjectUI.getListButtonPackageUI(), "css = '.listButtonPackageUI'", someObjectUI, "List UIElement Package UI"},
                {someObjectUI.listButtonPublicUI, "css = '.listButtonPublicUI'", someObjectUI, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIUIListQuestionDataProvider() {
        return new Object[][]{
                {someObjectUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", someObjectUI, "Uilist Question Package"},
                {someObjectUI.uilistQuestionPublic, "id='uilistQuestionPublic'", someObjectUI, "Uilist Question Public"},
                {someObjectUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", someObjectUI, "Uilist Question Private"},
                {SomeObject.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", someObjectUI, "Uilist Question Public Static"},
                {SomeObject.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", someObjectUI, "Uilist Question Private Static"},
                {someObjectUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", someObjectUI, "Uilist Question Package UI"},
                {someObjectUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", someObjectUI, "Uilist Question Public UI"},
                {SomeObject.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", someObjectUI, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIUIListSomedataDataProvider() {
        return new Object[][]{
                {someObjectUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", someObjectUI, "Uilist Somedata Package"},
                {someObjectUI.uilistSomedataPublic, "id='uilistSomedataPublic'", someObjectUI, "Uilist Somedata Public"},
                {someObjectUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", someObjectUI, "Uilist Somedata Private"},
                {SomeObject.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", someObjectUI, "Uilist Somedata Public Static"},
                {SomeObject.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", someObjectUI, "Uilist Somedata Private Static"},
                {someObjectUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", someObjectUI, "Uilist Somedata Package UI"},
                {someObjectUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", someObjectUI, "Uilist Somedata Public UI"},
                {SomeObject.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", someObjectUI, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIDropDownDataProvider() {
        return new Object[][]{
                {someObjectUI.getDroplistPackage(), "css='div[ui=droplistPackage'", someObjectUI, "Droplist Package"},
                {someObjectUI.droplistPublic, "css='div[ui=droplistPublic'", someObjectUI, "Droplist Public"},
                {someObjectUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", someObjectUI, "Droplist Private"},
                {SomeObject.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", someObjectUI, "Droplist Package Static"},
                {SomeObject.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", someObjectUI, "Droplist Public Static"},
                {SomeObject.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", someObjectUI, "Droplist Private Static"},
                {someObjectUI.getDroplistPackageUI(), "css='.droplistPackageUI'", someObjectUI, "Droplist Package UI"},
                {someObjectUI.droplistPublicUI, "css='.droplistPublicUI'", someObjectUI, "Droplist Public UI"},
        };
    }
}
