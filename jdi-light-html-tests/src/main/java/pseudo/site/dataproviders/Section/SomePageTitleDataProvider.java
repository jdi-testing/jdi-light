package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomePage;

import static pseudo.site.PseudoSite.somePageTitle;

public class SomePageTitleDataProvider {
    @DataProvider
    public Object[][] somePageTitleWebElementDataProvider() {
        return new Object[][]{
                {somePageTitle.webElementPublic, "id='webElementPublic'", somePageTitle, "Web Element Public"},
                {somePageTitle.webElementPublic, "id='webElementPublic'", somePageTitle, "Web Element Public"},
                {somePageTitle.webElementPublicUI, "css='.webElementPublicUI'", somePageTitle, "Web Element Public UI"},
                {SomePage.webElementPublicStatic, "id='webElementPublicStatic'", somePageTitle, "Web Element Public Static"},
                {somePageTitle.getWebElementPackage(), "id='webElementPackage'", somePageTitle, "Web Element Package"},
                {somePageTitle.getWebElementPrivate(), "id='webElementPrivate'", somePageTitle, "Web Element Private"},
                {SomePage.getWebElementPackageStatic(), "id='webElementPackageStatic'", somePageTitle, "Web Element Package Static"},
                {SomePage.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", somePageTitle, "Web Element Private Static"},
                {somePageTitle.getWebElementPackageUI(), "css='.webElementPackageUI'", somePageTitle, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] somePageTitleListWebElementDataProvider() {
        return new Object[][]{
                {somePageTitle.listWebElementPublic, "id='listWebElementPublic'", somePageTitle, "List Web Element Public"},
                {somePageTitle.listWebElementPublicUI, "css='.listWebElementPublicUI'", somePageTitle, "List Web Element Public UI"},
                {SomePage.listWebElementPublicStatic, "id='listWebElementPublicStatic'", somePageTitle, "List Web Element Public Static"},
                {somePageTitle.getListWebElementPackage(), "id='listWebElementPackage'", somePageTitle, "List Web Element Package"},
                {somePageTitle.getListWebElementPrivate(), "id='listWebElementPrivate'", somePageTitle, "List Web Element Private"},
                {SomePage.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", somePageTitle, "List Web Element Package Static"},
                {SomePage.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", somePageTitle, "List Web Element Private Static"},
                {somePageTitle.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", somePageTitle, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleUIElementDataProvider() {
        return new Object[][]{
                {somePageTitle.uielementPublic, "id='uielementPublic'", somePageTitle, "Uielement Public"},
                {somePageTitle.uielementPublicUI, "css='.uielementPublicUI'", somePageTitle, "Uielement Public UI"},
                {SomePage.uielementPublicStatic, "id='uielementPublicStatic'", somePageTitle, "Uielement Public Static"},
                {somePageTitle.getUielementPackage(), "id='uielementPackage'", somePageTitle, "Uielement Package"},
                {somePageTitle.getUielementPrivate(), "id='uielementPrivate'", somePageTitle, "Uielement Private"},
                {SomePage.getUielementPackageStatic(), "id='uielementPackageStatic'", somePageTitle, "Uielement Package Static"},
                {SomePage.getUielementPrivateStatic(), "id='uielementPrivateStatic'", somePageTitle, "Uielement Private Static"},
                {somePageTitle.getUielementPackageUI(), "css='.uielementPackageUI'", somePageTitle, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleButtonDataProvider() {
        return new Object[][]{
                {somePageTitle.getButtonPackage(), "id='buttonPackage'", somePageTitle, "Button Package"},
                {somePageTitle.buttonPublic, "id='buttonPublic'", somePageTitle, "Button Public"},
                {somePageTitle.getButtonPrivate(), "id='buttonPrivate'", somePageTitle, "Button Private"},
                {SomePage.getButtonPackageStatic(), "id='buttonPackageStatic'", somePageTitle, "Button Package Static"},
                {SomePage.buttonPublicStatic, "id='buttonPublicStatic'", somePageTitle, "Button Public Static"},
                {SomePage.getButtonPrivateStatic(), "id='buttonPrivateStatic'", somePageTitle, "Button Private Static"},
                {somePageTitle.buttonPublicUI, "css='.buttonPublicUI'", somePageTitle, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleWebListDataProvider() {
        return new Object[][]{
                {somePageTitle.getWebListPackage(), "id='webListPackage'", somePageTitle, "Web List Package"},
                {somePageTitle.webListPublic, "id='webListPublic'", somePageTitle, "Web List Public"},
                {somePageTitle.getWebListPrivate(), "id='webListPrivate'", somePageTitle, "Web List Private"},
                {somePageTitle.getWebListPrivate(), "id='webListPrivate'", somePageTitle, "Web List Private"},
                {SomePage.getWebListPackageStatic(), "id='webListPackageStatic'", somePageTitle, "Web List Package Static"},
                {SomePage.webListPublicStatic, "id='webListPublicStatic'", somePageTitle, "Web List Public Static"},
                {SomePage.getWebListPrivateStatic(), "id='webListPrivateStatic'", somePageTitle, "Web List Private Static"},
                {somePageTitle.getWebListPackageUI(), "css='.webListPackageUI'", somePageTitle, "Web List Package UI"},
                {somePageTitle.webListPublicUI, "css='.webListPublicUI'", somePageTitle, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleListUIElementPublicDataProvider() {
        return new Object[][]{
                {somePageTitle.listUIElementPublic, "id = 'listUIElementPublic'", somePageTitle, "List UIElement Public"},
                {somePageTitle.getListUIElementPackage(), "id = 'listUIElementPackage'", somePageTitle, "List UIElement Package"},
                {somePageTitle.getListUIElementPrivate(), "id = 'listUIElementPrivate'", somePageTitle, "List UIElement Private"},
                {SomePage.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", somePageTitle, "List UIElement Package Static"},
                {SomePage.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", somePageTitle, "List UIElement Public Static"},
                {SomePage.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", somePageTitle, "List UIElement Private Static"},
                {somePageTitle.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", somePageTitle, "List UIElement Package UI"},
                {somePageTitle.listUIElementPublicUI, "css = '.listUIElementPublicUI'", somePageTitle, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] somePageTitleListButtonPublicDataProvider() {
        return new Object[][]{
                {somePageTitle.getListButtonPackage(), "id = 'listButtonPackage'", somePageTitle, "List UIElement Package"},
                {somePageTitle.listButtonPublic, "id = 'listUIElementPublic'", somePageTitle, "List UIElement Public"},
                {somePageTitle.getListButtonPrivate(), "id = 'listButtonPrivate'", somePageTitle, "List UIElement Private"},
                {SomePage.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", somePageTitle, "List UIElement Package Static"},
                {SomePage.listButtonPublicStatic, "id = 'listButtonPublicStatic'", somePageTitle, "List UIElement Public Static"},
                {SomePage.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", somePageTitle, "List UIElement Private Static"},
                {somePageTitle.getListButtonPackageUI(), "css = '.listButtonPackageUI'", somePageTitle, "List UIElement Package UI"},
                {somePageTitle.listButtonPublicUI, "css = '.listButtonPublicUI'", somePageTitle, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleUIListQuestionDataProvider() {
        return new Object[][]{
                {somePageTitle.getUilistQuestionPackage(), "id='uilistQuestionPackage'", somePageTitle, "Uilist Question Package"},
                {somePageTitle.uilistQuestionPublic, "id='uilistQuestionPublic'", somePageTitle, "Uilist Question Public"},
                {somePageTitle.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", somePageTitle, "Uilist Question Private"},
                {SomePage.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", somePageTitle, "Uilist Question Public Static"},
                {SomePage.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", somePageTitle, "Uilist Question Private Static"},
                {somePageTitle.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", somePageTitle, "Uilist Question Package UI"},
                {somePageTitle.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", somePageTitle, "Uilist Question Public UI"},
                {SomePage.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", somePageTitle, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleUIListSomedataDataProvider() {
        return new Object[][]{
                {somePageTitle.getUilistSomedataPackage(), "id='uilistSomedataPackage'", somePageTitle, "Uilist Somedata Package"},
                {somePageTitle.uilistSomedataPublic, "id='uilistSomedataPublic'", somePageTitle, "Uilist Somedata Public"},
                {somePageTitle.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", somePageTitle, "Uilist Somedata Private"},
                {SomePage.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", somePageTitle, "Uilist Somedata Public Static"},
                {SomePage.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", somePageTitle, "Uilist Somedata Private Static"},
                {somePageTitle.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", somePageTitle, "Uilist Somedata Package UI"},
                {somePageTitle.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", somePageTitle, "Uilist Somedata Public UI"},
                {SomePage.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", somePageTitle, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageTitleDropDownDataProvider() {
        return new Object[][]{
                {somePageTitle.getDroplistPackage(), "css='div[ui=droplistPackage'", somePageTitle, "Droplist Package"},
                {somePageTitle.droplistPublic, "css='div[ui=droplistPublic'", somePageTitle, "Droplist Public"},
                {somePageTitle.getDroplistPrivate(), "css='div[ui=droplistPrivate'", somePageTitle, "Droplist Private"},
                {SomePage.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", somePageTitle, "Droplist Package Static"},
                {SomePage.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", somePageTitle, "Droplist Public Static"},
                {SomePage.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", somePageTitle, "Droplist Private Static"},
                {somePageTitle.getDroplistPackageUI(), "css='.droplistPackageUI'", somePageTitle, "Droplist Package UI"},
                {somePageTitle.droplistPublicUI, "css='.droplistPublicUI'", somePageTitle, "Droplist Public UI"},
        };
    }
}
