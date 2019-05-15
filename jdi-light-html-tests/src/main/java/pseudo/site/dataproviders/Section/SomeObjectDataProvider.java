package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomeObject;

import static pseudo.site.PseudoSite.someObject;

public class SomeObjectDataProvider {
    @DataProvider
    public Object[][] someObjectWebElementDataProvider() {
        return new Object[][]{
                {someObject.webElementPublic, "id='webElementPublic'", someObject, "Web Element Public"},
                {someObject.webElementPublic, "id='webElementPublic'", someObject, "Web Element Public"},
                {someObject.webElementPublicUI, "css='.webElementPublicUI'", someObject, "Web Element Public UI"},
                {SomeObject.webElementPublicStatic, "id='webElementPublicStatic'", someObject, "Web Element Public Static"},
                {someObject.getWebElementPackage(), "id='webElementPackage'", someObject, "Web Element Package"},
                {someObject.getWebElementPrivate(), "id='webElementPrivate'", someObject, "Web Element Private"},
                {SomeObject.getWebElementPackageStatic(), "id='webElementPackageStatic'", someObject, "Web Element Package Static"},
                {SomeObject.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", someObject, "Web Element Private Static"},
                {someObject.getWebElementPackageUI(), "css='.webElementPackageUI'", someObject, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someObjectListWebElementDataProvider() {
        return new Object[][]{
                {someObject.listWebElementPublic, "id='listWebElementPublic'", someObject, "List Web Element Public"},
                {someObject.listWebElementPublicUI, "css='.listWebElementPublicUI'", someObject, "List Web Element Public UI"},
                {SomeObject.listWebElementPublicStatic, "id='listWebElementPublicStatic'", someObject, "List Web Element Public Static"},
                {someObject.getListWebElementPackage(), "id='listWebElementPackage'", someObject, "List Web Element Package"},
                {someObject.getListWebElementPrivate(), "id='listWebElementPrivate'", someObject, "List Web Element Private"},
                {SomeObject.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", someObject, "List Web Element Package Static"},
                {SomeObject.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", someObject, "List Web Element Private Static"},
                {someObject.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", someObject, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIElementDataProvider() {
        return new Object[][]{
                {someObject.uielementPublic, "id='uielementPublic'", someObject, "Uielement Public"},
                {someObject.uielementPublicUI, "css='.uielementPublicUI'", someObject, "Uielement Public UI"},
                {SomeObject.uielementPublicStatic, "id='uielementPublicStatic'", someObject, "Uielement Public Static"},
                {someObject.getUielementPackage(), "id='uielementPackage'", someObject, "Uielement Package"},
                {someObject.getUielementPrivate(), "id='uielementPrivate'", someObject, "Uielement Private"},
                {SomeObject.getUielementPackageStatic(), "id='uielementPackageStatic'", someObject, "Uielement Package Static"},
                {SomeObject.getUielementPrivateStatic(), "id='uielementPrivateStatic'", someObject, "Uielement Private Static"},
                {someObject.getUielementPackageUI(), "css='.uielementPackageUI'", someObject, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectButtonDataProvider() {
        return new Object[][]{
                {someObject.getButtonPackage(), "id='buttonPackage'", someObject, "Button Package"},
                {someObject.buttonPublic, "id='buttonPublic'", someObject, "Button Public"},
                {someObject.getButtonPrivate(), "id='buttonPrivate'", someObject, "Button Private"},
                {SomeObject.getButtonPackageStatic(), "id='buttonPackageStatic'", someObject, "Button Package Static"},
                {SomeObject.buttonPublicStatic, "id='buttonPublicStatic'", someObject, "Button Public Static"},
                {SomeObject.getButtonPrivateStatic(), "id='buttonPrivateStatic'", someObject, "Button Private Static"},
                {someObject.buttonPublicUI, "css='.buttonPublicUI'", someObject, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectWebListDataProvider() {
        return new Object[][]{
                {someObject.getWebListPackage(), "id='webListPackage'", someObject, "Web List Package"},
                {someObject.webListPublic, "id='webListPublic'", someObject, "Web List Public"},
                {someObject.getWebListPrivate(), "id='webListPrivate'", someObject, "Web List Private"},
                {someObject.getWebListPrivate(), "id='webListPrivate'", someObject, "Web List Private"},
                {SomeObject.getWebListPackageStatic(), "id='webListPackageStatic'", someObject, "Web List Package Static"},
                {SomeObject.webListPublicStatic, "id='webListPublicStatic'", someObject, "Web List Public Static"},
                {SomeObject.getWebListPrivateStatic(), "id='webListPrivateStatic'", someObject, "Web List Private Static"},
                {someObject.getWebListPackageUI(), "css='.webListPackageUI'", someObject, "Web List Package UI"},
                {someObject.webListPublicUI, "css='.webListPublicUI'", someObject, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectListUIElementPublicDataProvider() {
        return new Object[][]{
                {someObject.listUIElementPublic, "id = 'listUIElementPublic'", someObject, "List UIElement Public"},
                {someObject.getListUIElementPackage(), "id = 'listUIElementPackage'", someObject, "List UIElement Package"},
                {someObject.getListUIElementPrivate(), "id = 'listUIElementPrivate'", someObject, "List UIElement Private"},
                {SomeObject.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", someObject, "List UIElement Package Static"},
                {SomeObject.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", someObject, "List UIElement Public Static"},
                {SomeObject.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", someObject, "List UIElement Private Static"},
                {someObject.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", someObject, "List UIElement Package UI"},
                {someObject.listUIElementPublicUI, "css = '.listUIElementPublicUI'", someObject, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someObjectListButtonPublicDataProvider() {
        return new Object[][]{
                {someObject.getListButtonPackage(), "id = 'listButtonPackage'", someObject, "List UIElement Package"},
                {someObject.listButtonPublic, "id = 'listUIElementPublic'", someObject, "List UIElement Public"},
                {someObject.getListButtonPrivate(), "id = 'listButtonPrivate'", someObject, "List UIElement Private"},
                {SomeObject.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", someObject, "List UIElement Package Static"},
                {SomeObject.listButtonPublicStatic, "id = 'listButtonPublicStatic'", someObject, "List UIElement Public Static"},
                {SomeObject.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", someObject, "List UIElement Private Static"},
                {someObject.getListButtonPackageUI(), "css = '.listButtonPackageUI'", someObject, "List UIElement Package UI"},
                {someObject.listButtonPublicUI, "css = '.listButtonPublicUI'", someObject, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIListQuestionDataProvider() {
        return new Object[][]{
                {someObject.getUilistQuestionPackage(), "id='uilistQuestionPackage'", someObject, "Uilist Question Package"},
                {someObject.uilistQuestionPublic, "id='uilistQuestionPublic'", someObject, "Uilist Question Public"},
                {someObject.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", someObject, "Uilist Question Private"},
                {SomeObject.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", someObject, "Uilist Question Public Static"},
                {SomeObject.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", someObject, "Uilist Question Private Static"},
                {someObject.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", someObject, "Uilist Question Package UI"},
                {someObject.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", someObject, "Uilist Question Public UI"},
                {SomeObject.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", someObject, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] someObjectUIListSomedataDataProvider() {
        return new Object[][]{
                {someObject.getUilistSomedataPackage(), "id='uilistSomedataPackage'", someObject, "Uilist Somedata Package"},
                {someObject.uilistSomedataPublic, "id='uilistSomedataPublic'", someObject, "Uilist Somedata Public"},
                {someObject.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", someObject, "Uilist Somedata Private"},
                {SomeObject.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", someObject, "Uilist Somedata Public Static"},
                {SomeObject.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", someObject, "Uilist Somedata Private Static"},
                {someObject.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", someObject, "Uilist Somedata Package UI"},
                {someObject.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", someObject, "Uilist Somedata Public UI"},
                {SomeObject.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", someObject, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] someObjectDropDownDataProvider() {
        return new Object[][]{
                {someObject.getDroplistPackage(), "css='div[ui=droplistPackage'", someObject, "Droplist Package"},
                {someObject.droplistPublic, "css='div[ui=droplistPublic'", someObject, "Droplist Public"},
                {someObject.getDroplistPrivate(), "css='div[ui=droplistPrivate'", someObject, "Droplist Private"},
                {SomeObject.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", someObject, "Droplist Package Static"},
                {SomeObject.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", someObject, "Droplist Public Static"},
                {SomeObject.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", someObject, "Droplist Private Static"},
                {someObject.getDroplistPackageUI(), "css='.droplistPackageUI'", someObject, "Droplist Package UI"},
                {someObject.droplistPublicUI, "css='.droplistPublicUI'", someObject, "Droplist Public UI"},
        };
    }
}
