package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomePage;

import static pseudo.site.PseudoSite.somePageUrl;

public class SomePageUrlDataProvider {
    @DataProvider
    public Object[][] somePageUrlWebElementDataProvider() {
        return new Object[][]{
                {somePageUrl.webElementPublic, "id='webElementPublic'", somePageUrl, "Web Element Public"},
                {somePageUrl.webElementPublic, "id='webElementPublic'", somePageUrl, "Web Element Public"},
                {somePageUrl.webElementPublicUI, "css='.webElementPublicUI'", somePageUrl, "Web Element Public UI"},
                {SomePage.webElementPublicStatic, "id='webElementPublicStatic'", somePageUrl, "Web Element Public Static"},
                {somePageUrl.getWebElementPackage(), "id='webElementPackage'", somePageUrl, "Web Element Package"},
                {somePageUrl.getWebElementPrivate(), "id='webElementPrivate'", somePageUrl, "Web Element Private"},
                {SomePage.getWebElementPackageStatic(), "id='webElementPackageStatic'", somePageUrl, "Web Element Package Static"},
                {SomePage.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", somePageUrl, "Web Element Private Static"},
                {somePageUrl.getWebElementPackageUI(), "css='.webElementPackageUI'", somePageUrl, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] somePageUrlListWebElementDataProvider() {
        return new Object[][]{
                {somePageUrl.listWebElementPublic, "id='listWebElementPublic'", somePageUrl, "List Web Element Public"},
                {somePageUrl.listWebElementPublicUI, "css='.listWebElementPublicUI'", somePageUrl, "List Web Element Public UI"},
                {SomePage.listWebElementPublicStatic, "id='listWebElementPublicStatic'", somePageUrl, "List Web Element Public Static"},
                {somePageUrl.getListWebElementPackage(), "id='listWebElementPackage'", somePageUrl, "List Web Element Package"},
                {somePageUrl.getListWebElementPrivate(), "id='listWebElementPrivate'", somePageUrl, "List Web Element Private"},
                {SomePage.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", somePageUrl, "List Web Element Package Static"},
                {SomePage.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", somePageUrl, "List Web Element Private Static"},
                {somePageUrl.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", somePageUrl, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlUIElementDataProvider() {
        return new Object[][]{
                {somePageUrl.uielementPublic, "id='uielementPublic'", somePageUrl, "Uielement Public"},
                {somePageUrl.uielementPublicUI, "css='.uielementPublicUI'", somePageUrl, "Uielement Public UI"},
                {SomePage.uielementPublicStatic, "id='uielementPublicStatic'", somePageUrl, "Uielement Public Static"},
                {somePageUrl.getUielementPackage(), "id='uielementPackage'", somePageUrl, "Uielement Package"},
                {somePageUrl.getUielementPrivate(), "id='uielementPrivate'", somePageUrl, "Uielement Private"},
                {SomePage.getUielementPackageStatic(), "id='uielementPackageStatic'", somePageUrl, "Uielement Package Static"},
                {SomePage.getUielementPrivateStatic(), "id='uielementPrivateStatic'", somePageUrl, "Uielement Private Static"},
                {somePageUrl.getUielementPackageUI(), "css='.uielementPackageUI'", somePageUrl, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlButtonDataProvider() {
        return new Object[][]{
                {somePageUrl.getButtonPackage(), "id='buttonPackage'", somePageUrl, "Button Package"},
                {somePageUrl.buttonPublic, "id='buttonPublic'", somePageUrl, "Button Public"},
                {somePageUrl.getButtonPrivate(), "id='buttonPrivate'", somePageUrl, "Button Private"},
                {SomePage.getButtonPackageStatic(), "id='buttonPackageStatic'", somePageUrl, "Button Package Static"},
                {SomePage.buttonPublicStatic, "id='buttonPublicStatic'", somePageUrl, "Button Public Static"},
                {SomePage.getButtonPrivateStatic(), "id='buttonPrivateStatic'", somePageUrl, "Button Private Static"},
                {somePageUrl.buttonPublicUI, "css='.buttonPublicUI'", somePageUrl, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlWebListDataProvider() {
        return new Object[][]{
                {somePageUrl.getWebListPackage(), "id='webListPackage'", somePageUrl, "Web List Package"},
                {somePageUrl.webListPublic, "id='webListPublic'", somePageUrl, "Web List Public"},
                {somePageUrl.getWebListPrivate(), "id='webListPrivate'", somePageUrl, "Web List Private"},
                {somePageUrl.getWebListPrivate(), "id='webListPrivate'", somePageUrl, "Web List Private"},
                {SomePage.getWebListPackageStatic(), "id='webListPackageStatic'", somePageUrl, "Web List Package Static"},
                {SomePage.webListPublicStatic, "id='webListPublicStatic'", somePageUrl, "Web List Public Static"},
                {SomePage.getWebListPrivateStatic(), "id='webListPrivateStatic'", somePageUrl, "Web List Private Static"},
                {somePageUrl.getWebListPackageUI(), "css='.webListPackageUI'", somePageUrl, "Web List Package UI"},
                {somePageUrl.webListPublicUI, "css='.webListPublicUI'", somePageUrl, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlListUIElementPublicDataProvider() {
        return new Object[][]{
                {somePageUrl.listUIElementPublic, "id = 'listUIElementPublic'", somePageUrl, "List UIElement Public"},
                {somePageUrl.getListUIElementPackage(), "id = 'listUIElementPackage'", somePageUrl, "List UIElement Package"},
                {somePageUrl.getListUIElementPrivate(), "id = 'listUIElementPrivate'", somePageUrl, "List UIElement Private"},
                {SomePage.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", somePageUrl, "List UIElement Package Static"},
                {SomePage.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", somePageUrl, "List UIElement Public Static"},
                {SomePage.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", somePageUrl, "List UIElement Private Static"},
                {somePageUrl.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", somePageUrl, "List UIElement Package UI"},
                {somePageUrl.listUIElementPublicUI, "css = '.listUIElementPublicUI'", somePageUrl, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] somePageUrlListButtonPublicDataProvider() {
        return new Object[][]{
                {somePageUrl.getListButtonPackage(), "id = 'listButtonPackage'", somePageUrl, "List UIElement Package"},
                {somePageUrl.listButtonPublic, "id = 'listUIElementPublic'", somePageUrl, "List UIElement Public"},
                {somePageUrl.getListButtonPrivate(), "id = 'listButtonPrivate'", somePageUrl, "List UIElement Private"},
                {SomePage.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", somePageUrl, "List UIElement Package Static"},
                {SomePage.listButtonPublicStatic, "id = 'listButtonPublicStatic'", somePageUrl, "List UIElement Public Static"},
                {SomePage.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", somePageUrl, "List UIElement Private Static"},
                {somePageUrl.getListButtonPackageUI(), "css = '.listButtonPackageUI'", somePageUrl, "List UIElement Package UI"},
                {somePageUrl.listButtonPublicUI, "css = '.listButtonPublicUI'", somePageUrl, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlUIListQuestionDataProvider() {
        return new Object[][]{
                {somePageUrl.getUilistQuestionPackage(), "id='uilistQuestionPackage'", somePageUrl, "Uilist Question Package"},
                {somePageUrl.uilistQuestionPublic, "id='uilistQuestionPublic'", somePageUrl, "Uilist Question Public"},
                {somePageUrl.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", somePageUrl, "Uilist Question Private"},
                {SomePage.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", somePageUrl, "Uilist Question Public Static"},
                {SomePage.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", somePageUrl, "Uilist Question Private Static"},
                {somePageUrl.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", somePageUrl, "Uilist Question Package UI"},
                {somePageUrl.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", somePageUrl, "Uilist Question Public UI"},
                {SomePage.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", somePageUrl, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlUIListSomedataDataProvider() {
        return new Object[][]{
                {somePageUrl.getUilistSomedataPackage(), "id='uilistSomedataPackage'", somePageUrl, "Uilist Somedata Package"},
                {somePageUrl.uilistSomedataPublic, "id='uilistSomedataPublic'", somePageUrl, "Uilist Somedata Public"},
                {somePageUrl.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", somePageUrl, "Uilist Somedata Private"},
                {SomePage.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", somePageUrl, "Uilist Somedata Public Static"},
                {SomePage.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", somePageUrl, "Uilist Somedata Private Static"},
                {somePageUrl.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", somePageUrl, "Uilist Somedata Package UI"},
                {somePageUrl.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", somePageUrl, "Uilist Somedata Public UI"},
                {SomePage.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", somePageUrl, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlDropDownDataProvider() {
        return new Object[][]{
                {somePageUrl.getDroplistPackage(), "css='div[ui=droplistPackage'", somePageUrl, "Droplist Package"},
                {somePageUrl.droplistPublic, "css='div[ui=droplistPublic'", somePageUrl, "Droplist Public"},
                {somePageUrl.getDroplistPrivate(), "css='div[ui=droplistPrivate'", somePageUrl, "Droplist Private"},
                {SomePage.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", somePageUrl, "Droplist Package Static"},
                {SomePage.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", somePageUrl, "Droplist Public Static"},
                {SomePage.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", somePageUrl, "Droplist Private Static"},
                {somePageUrl.getDroplistPackageUI(), "css='.droplistPackageUI'", somePageUrl, "Droplist Package UI"},
                {somePageUrl.droplistPublicUI, "css='.droplistPublicUI'", somePageUrl, "Droplist Public UI"},
        };
    }
}
