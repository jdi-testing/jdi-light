package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomePage;

import static pseudo.site.PseudoSite.somePage;

public class SomePageDataProvider {
    @DataProvider
    public Object[][] somePageWebElementDataProvider() {
        return new Object[][]{
                {somePage.webElementPublic, "id='webElementPublic'", somePage, "Web Element Public"},
                {somePage.webElementPublic, "id='webElementPublic'", somePage, "Web Element Public"},
                {somePage.webElementPublicUI, "css='.webElementPublicUI'", somePage, "Web Element Public UI"},
                {SomePage.webElementPublicStatic, "id='webElementPublicStatic'", somePage, "Web Element Public Static"},
                {somePage.getWebElementPackage(), "id='webElementPackage'", somePage, "Web Element Package"},
                {somePage.getWebElementPrivate(), "id='webElementPrivate'", somePage, "Web Element Private"},
                {SomePage.getWebElementPackageStatic(), "id='webElementPackageStatic'", somePage, "Web Element Package Static"},
                {SomePage.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", somePage, "Web Element Private Static"},
                {somePage.getWebElementPackageUI(), "css='.webElementPackageUI'", somePage, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] somePageListWebElementDataProvider() {
        return new Object[][]{
                {somePage.listWebElementPublic, "id='listWebElementPublic'", somePage, "List Web Element Public"},
                {somePage.listWebElementPublicUI, "css='.listWebElementPublicUI'", somePage, "List Web Element Public UI"},
                {SomePage.listWebElementPublicStatic, "id='listWebElementPublicStatic'", somePage, "List Web Element Public Static"},
                {somePage.getListWebElementPackage(), "id='listWebElementPackage'", somePage, "List Web Element Package"},
                {somePage.getListWebElementPrivate(), "id='listWebElementPrivate'", somePage, "List Web Element Private"},
                {SomePage.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", somePage, "List Web Element Package Static"},
                {SomePage.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", somePage, "List Web Element Private Static"},
                {somePage.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", somePage, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUIElementDataProvider() {
        return new Object[][]{
                {somePage.uielementPublic, "id='uielementPublic'", somePage, "Uielement Public"},
                {somePage.uielementPublicUI, "css='.uielementPublicUI'", somePage, "Uielement Public UI"},
                {SomePage.uielementPublicStatic, "id='uielementPublicStatic'", somePage, "Uielement Public Static"},
                {somePage.getUielementPackage(), "id='uielementPackage'", somePage, "Uielement Package"},
                {somePage.getUielementPrivate(), "id='uielementPrivate'", somePage, "Uielement Private"},
                {SomePage.getUielementPackageStatic(), "id='uielementPackageStatic'", somePage, "Uielement Package Static"},
                {SomePage.getUielementPrivateStatic(), "id='uielementPrivateStatic'", somePage, "Uielement Private Static"},
                {somePage.getUielementPackageUI(), "css='.uielementPackageUI'", somePage, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageButtonDataProvider() {
        return new Object[][]{
                {somePage.getButtonPackage(), "id='buttonPackage'", somePage, "Button Package"},
                {somePage.buttonPublic, "id='buttonPublic'", somePage, "Button Public"},
                {somePage.getButtonPrivate(), "id='buttonPrivate'", somePage, "Button Private"},
                {SomePage.getButtonPackageStatic(), "id='buttonPackageStatic'", somePage, "Button Package Static"},
                {SomePage.buttonPublicStatic, "id='buttonPublicStatic'", somePage, "Button Public Static"},
                {SomePage.getButtonPrivateStatic(), "id='buttonPrivateStatic'", somePage, "Button Private Static"},
                {somePage.buttonPublicUI, "css='.buttonPublicUI'", somePage, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageWebListDataProvider() {
        return new Object[][]{
                {somePage.getWebListPackage(), "id='webListPackage'", somePage, "Web List Package"},
                {somePage.webListPublic, "id='webListPublic'", somePage, "Web List Public"},
                {somePage.getWebListPrivate(), "id='webListPrivate'", somePage, "Web List Private"},
                {somePage.getWebListPrivate(), "id='webListPrivate'", somePage, "Web List Private"},
                {SomePage.getWebListPackageStatic(), "id='webListPackageStatic'", somePage, "Web List Package Static"},
                {SomePage.webListPublicStatic, "id='webListPublicStatic'", somePage, "Web List Public Static"},
                {SomePage.getWebListPrivateStatic(), "id='webListPrivateStatic'", somePage, "Web List Private Static"},
                {somePage.getWebListPackageUI(), "css='.webListPackageUI'", somePage, "Web List Package UI"},
                {somePage.webListPublicUI, "css='.webListPublicUI'", somePage, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageListUIElementPublicDataProvider() {
        return new Object[][]{
                {somePage.listUIElementPublic, "id = 'listUIElementPublic'", somePage, "List UIElement Public"},
                {somePage.getListUIElementPackage(), "id = 'listUIElementPackage'", somePage, "List UIElement Package"},
                {somePage.getListUIElementPrivate(), "id = 'listUIElementPrivate'", somePage, "List UIElement Private"},
                {SomePage.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", somePage, "List UIElement Package Static"},
                {SomePage.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", somePage, "List UIElement Public Static"},
                {SomePage.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", somePage, "List UIElement Private Static"},
                {somePage.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", somePage, "List UIElement Package UI"},
                {somePage.listUIElementPublicUI, "css = '.listUIElementPublicUI'", somePage, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] somePageListButtonPublicDataProvider() {
        return new Object[][]{
                {somePage.getListButtonPackage(), "id = 'listButtonPackage'", somePage, "List UIElement Package"},
                {somePage.listButtonPublic, "id = 'listUIElementPublic'", somePage, "List UIElement Public"},
                {somePage.getListButtonPrivate(), "id = 'listButtonPrivate'", somePage, "List UIElement Private"},
                {SomePage.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", somePage, "List UIElement Package Static"},
                {SomePage.listButtonPublicStatic, "id = 'listButtonPublicStatic'", somePage, "List UIElement Public Static"},
                {SomePage.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", somePage, "List UIElement Private Static"},
                {somePage.getListButtonPackageUI(), "css = '.listButtonPackageUI'", somePage, "List UIElement Package UI"},
                {somePage.listButtonPublicUI, "css = '.listButtonPublicUI'", somePage, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUIListQuestionDataProvider() {
        return new Object[][]{
                {somePage.getUilistQuestionPackage(), "id='uilistQuestionPackage'", somePage, "Uilist Question Package"},
                {somePage.uilistQuestionPublic, "id='uilistQuestionPublic'", somePage, "Uilist Question Public"},
                {somePage.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", somePage, "Uilist Question Private"},
                {SomePage.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", somePage, "Uilist Question Public Static"},
                {SomePage.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", somePage, "Uilist Question Private Static"},
                {somePage.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", somePage, "Uilist Question Package UI"},
                {somePage.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", somePage, "Uilist Question Public UI"},
                {SomePage.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", somePage, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageUIListSomedataDataProvider() {
        return new Object[][]{
                {somePage.getUilistSomedataPackage(), "id='uilistSomedataPackage'", somePage, "Uilist Somedata Package"},
                {somePage.uilistSomedataPublic, "id='uilistSomedataPublic'", somePage, "Uilist Somedata Public"},
                {somePage.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", somePage, "Uilist Somedata Private"},
                {SomePage.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", somePage, "Uilist Somedata Public Static"},
                {SomePage.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", somePage, "Uilist Somedata Private Static"},
                {somePage.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", somePage, "Uilist Somedata Package UI"},
                {somePage.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", somePage, "Uilist Somedata Public UI"},
                {SomePage.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", somePage, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageDropDownDataProvider() {
        return new Object[][]{
                {somePage.getDroplistPackage(), "css='div[ui=droplistPackage'", somePage, "Droplist Package"},
                {somePage.droplistPublic, "css='div[ui=droplistPublic'", somePage, "Droplist Public"},
                {somePage.getDroplistPrivate(), "css='div[ui=droplistPrivate'", somePage, "Droplist Private"},
                {SomePage.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", somePage, "Droplist Package Static"},
                {SomePage.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", somePage, "Droplist Public Static"},
                {SomePage.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", somePage, "Droplist Private Static"},
                {somePage.getDroplistPackageUI(), "css='.droplistPackageUI'", somePage, "Droplist Package UI"},
                {somePage.droplistPublicUI, "css='.droplistPublicUI'", somePage, "Droplist Public UI"},
        };
    }
}
