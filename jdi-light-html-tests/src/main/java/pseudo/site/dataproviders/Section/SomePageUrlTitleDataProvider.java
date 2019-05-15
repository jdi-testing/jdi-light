package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomePage;

import static pseudo.site.PseudoSite.somePageUrlTitle;

public class SomePageUrlTitleDataProvider {
    @DataProvider
    public Object[][] somePageUrlTitleWebElementDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.webElementPublic, "id='webElementPublic'", somePageUrlTitle, "Web Element Public"},
                {somePageUrlTitle.webElementPublic, "id='webElementPublic'", somePageUrlTitle, "Web Element Public"},
                {somePageUrlTitle.webElementPublicUI, "css='.webElementPublicUI'", somePageUrlTitle, "Web Element Public UI"},
                {SomePage.webElementPublicStatic, "id='webElementPublicStatic'", somePageUrlTitle, "Web Element Public Static"},
                {somePageUrlTitle.getWebElementPackage(), "id='webElementPackage'", somePageUrlTitle, "Web Element Package"},
                {somePageUrlTitle.getWebElementPrivate(), "id='webElementPrivate'", somePageUrlTitle, "Web Element Private"},
                {SomePage.getWebElementPackageStatic(), "id='webElementPackageStatic'", somePageUrlTitle, "Web Element Package Static"},
                {SomePage.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", somePageUrlTitle, "Web Element Private Static"},
                {somePageUrlTitle.getWebElementPackageUI(), "css='.webElementPackageUI'", somePageUrlTitle, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] somePageUrlTitleListWebElementDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.listWebElementPublic, "id='listWebElementPublic'", somePageUrlTitle, "List Web Element Public"},
                {somePageUrlTitle.listWebElementPublicUI, "css='.listWebElementPublicUI'", somePageUrlTitle, "List Web Element Public UI"},
                {SomePage.listWebElementPublicStatic, "id='listWebElementPublicStatic'", somePageUrlTitle, "List Web Element Public Static"},
                {somePageUrlTitle.getListWebElementPackage(), "id='listWebElementPackage'", somePageUrlTitle, "List Web Element Package"},
                {somePageUrlTitle.getListWebElementPrivate(), "id='listWebElementPrivate'", somePageUrlTitle, "List Web Element Private"},
                {SomePage.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", somePageUrlTitle, "List Web Element Package Static"},
                {SomePage.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", somePageUrlTitle, "List Web Element Private Static"},
                {somePageUrlTitle.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", somePageUrlTitle, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleUIElementDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.uielementPublic, "id='uielementPublic'", somePageUrlTitle, "Uielement Public"},
                {somePageUrlTitle.uielementPublicUI, "css='.uielementPublicUI'", somePageUrlTitle, "Uielement Public UI"},
                {SomePage.uielementPublicStatic, "id='uielementPublicStatic'", somePageUrlTitle, "Uielement Public Static"},
                {somePageUrlTitle.getUielementPackage(), "id='uielementPackage'", somePageUrlTitle, "Uielement Package"},
                {somePageUrlTitle.getUielementPrivate(), "id='uielementPrivate'", somePageUrlTitle, "Uielement Private"},
                {SomePage.getUielementPackageStatic(), "id='uielementPackageStatic'", somePageUrlTitle, "Uielement Package Static"},
                {SomePage.getUielementPrivateStatic(), "id='uielementPrivateStatic'", somePageUrlTitle, "Uielement Private Static"},
                {somePageUrlTitle.getUielementPackageUI(), "css='.uielementPackageUI'", somePageUrlTitle, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleButtonDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.getButtonPackage(), "id='buttonPackage'", somePageUrlTitle, "Button Package"},
                {somePageUrlTitle.buttonPublic, "id='buttonPublic'", somePageUrlTitle, "Button Public"},
                {somePageUrlTitle.getButtonPrivate(), "id='buttonPrivate'", somePageUrlTitle, "Button Private"},
                {SomePage.getButtonPackageStatic(), "id='buttonPackageStatic'", somePageUrlTitle, "Button Package Static"},
                {SomePage.buttonPublicStatic, "id='buttonPublicStatic'", somePageUrlTitle, "Button Public Static"},
                {SomePage.getButtonPrivateStatic(), "id='buttonPrivateStatic'", somePageUrlTitle, "Button Private Static"},
                {somePageUrlTitle.buttonPublicUI, "css='.buttonPublicUI'", somePageUrlTitle, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleWebListDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.getWebListPackage(), "id='webListPackage'", somePageUrlTitle, "Web List Package"},
                {somePageUrlTitle.webListPublic, "id='webListPublic'", somePageUrlTitle, "Web List Public"},
                {somePageUrlTitle.getWebListPrivate(), "id='webListPrivate'", somePageUrlTitle, "Web List Private"},
                {somePageUrlTitle.getWebListPrivate(), "id='webListPrivate'", somePageUrlTitle, "Web List Private"},
                {SomePage.getWebListPackageStatic(), "id='webListPackageStatic'", somePageUrlTitle, "Web List Package Static"},
                {SomePage.webListPublicStatic, "id='webListPublicStatic'", somePageUrlTitle, "Web List Public Static"},
                {SomePage.getWebListPrivateStatic(), "id='webListPrivateStatic'", somePageUrlTitle, "Web List Private Static"},
                {somePageUrlTitle.getWebListPackageUI(), "css='.webListPackageUI'", somePageUrlTitle, "Web List Package UI"},
                {somePageUrlTitle.webListPublicUI, "css='.webListPublicUI'", somePageUrlTitle, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleListUIElementPublicDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.listUIElementPublic, "id = 'listUIElementPublic'", somePageUrlTitle, "List UIElement Public"},
                {somePageUrlTitle.getListUIElementPackage(), "id = 'listUIElementPackage'", somePageUrlTitle, "List UIElement Package"},
                {somePageUrlTitle.getListUIElementPrivate(), "id = 'listUIElementPrivate'", somePageUrlTitle, "List UIElement Private"},
                {SomePage.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", somePageUrlTitle, "List UIElement Package Static"},
                {SomePage.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", somePageUrlTitle, "List UIElement Public Static"},
                {SomePage.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", somePageUrlTitle, "List UIElement Private Static"},
                {somePageUrlTitle.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", somePageUrlTitle, "List UIElement Package UI"},
                {somePageUrlTitle.listUIElementPublicUI, "css = '.listUIElementPublicUI'", somePageUrlTitle, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] somePageUrlTitleListButtonPublicDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.getListButtonPackage(), "id = 'listButtonPackage'", somePageUrlTitle, "List UIElement Package"},
                {somePageUrlTitle.listButtonPublic, "id = 'listUIElementPublic'", somePageUrlTitle, "List UIElement Public"},
                {somePageUrlTitle.getListButtonPrivate(), "id = 'listButtonPrivate'", somePageUrlTitle, "List UIElement Private"},
                {SomePage.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", somePageUrlTitle, "List UIElement Package Static"},
                {SomePage.listButtonPublicStatic, "id = 'listButtonPublicStatic'", somePageUrlTitle, "List UIElement Public Static"},
                {SomePage.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", somePageUrlTitle, "List UIElement Private Static"},
                {somePageUrlTitle.getListButtonPackageUI(), "css = '.listButtonPackageUI'", somePageUrlTitle, "List UIElement Package UI"},
                {somePageUrlTitle.listButtonPublicUI, "css = '.listButtonPublicUI'", somePageUrlTitle, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleUIListQuestionDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.getUilistQuestionPackage(), "id='uilistQuestionPackage'", somePageUrlTitle, "Uilist Question Package"},
                {somePageUrlTitle.uilistQuestionPublic, "id='uilistQuestionPublic'", somePageUrlTitle, "Uilist Question Public"},
                {somePageUrlTitle.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", somePageUrlTitle, "Uilist Question Private"},
                {SomePage.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", somePageUrlTitle, "Uilist Question Public Static"},
                {SomePage.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", somePageUrlTitle, "Uilist Question Private Static"},
                {somePageUrlTitle.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", somePageUrlTitle, "Uilist Question Package UI"},
                {somePageUrlTitle.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", somePageUrlTitle, "Uilist Question Public UI"},
                {SomePage.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", somePageUrlTitle, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleUIListSomedataDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.getUilistSomedataPackage(), "id='uilistSomedataPackage'", somePageUrlTitle, "Uilist Somedata Package"},
                {somePageUrlTitle.uilistSomedataPublic, "id='uilistSomedataPublic'", somePageUrlTitle, "Uilist Somedata Public"},
                {somePageUrlTitle.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", somePageUrlTitle, "Uilist Somedata Private"},
                {SomePage.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", somePageUrlTitle, "Uilist Somedata Public Static"},
                {SomePage.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", somePageUrlTitle, "Uilist Somedata Private Static"},
                {somePageUrlTitle.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", somePageUrlTitle, "Uilist Somedata Package UI"},
                {somePageUrlTitle.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", somePageUrlTitle, "Uilist Somedata Public UI"},
                {SomePage.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", somePageUrlTitle, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] somePageUrlTitleDropDownDataProvider() {
        return new Object[][]{
                {somePageUrlTitle.getDroplistPackage(), "css='div[ui=droplistPackage'", somePageUrlTitle, "Droplist Package"},
                {somePageUrlTitle.droplistPublic, "css='div[ui=droplistPublic'", somePageUrlTitle, "Droplist Public"},
                {somePageUrlTitle.getDroplistPrivate(), "css='div[ui=droplistPrivate'", somePageUrlTitle, "Droplist Private"},
                {SomePage.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", somePageUrlTitle, "Droplist Package Static"},
                {SomePage.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", somePageUrlTitle, "Droplist Public Static"},
                {SomePage.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", somePageUrlTitle, "Droplist Private Static"},
                {somePageUrlTitle.getDroplistPackageUI(), "css='.droplistPackageUI'", somePageUrlTitle, "Droplist Package UI"},
                {somePageUrlTitle.droplistPublicUI, "css='.droplistPublicUI'", somePageUrlTitle, "Droplist Public UI"},
        };
    }
}
