package pseudo.site.dataproviders.webpage;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.extendedWebPage;

public class ExtendedWebPageDataProvider {
    @DataProvider
    public Object[][] extendedWebPageWebElementDataProvider() {
        return new Object[][]{
                {extendedWebPage.webElementPublic, "id='webElementPublic'", extendedWebPage, "Web Element Public"},
                {extendedWebPage.webElementPublicUI, "css='.webElementPublicUI'", extendedWebPage, "Web Element Public UI"},
                {extendedWebPage.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", extendedWebPage, "Web Element Public X Path"},
                {extendedWebPage.getWebElementPackage(), "id='webElementPackage'", extendedWebPage, "Web Element Package"},
                {extendedWebPage.getWebElementPrivate(), "id='webElementPrivate'", extendedWebPage, "Web Element Private"},
                {extendedWebPage.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedWebPage, "Web Element Package UI"},
                {extendedWebPage.getWebElementPackageCss(), "css='.webElementPackageCss'", extendedWebPage, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedWebPageListWebElementDataProvider() {
        return new Object[][]{
                {extendedWebPage.listWebElementPublic, "id='listWebElementPublic'", extendedWebPage, "List Web Element Public"},
                {extendedWebPage.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedWebPage, "List Web Element Public UI"},
                {extendedWebPage.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", extendedWebPage, "List Web Element Public X Path"},
                {extendedWebPage.getListWebElementPackage(), "id='listWebElementPackage'", extendedWebPage, "List Web Element Package"},
                {extendedWebPage.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedWebPage, "List Web Element Private"},
                {extendedWebPage.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedWebPage, "List Web Element Package UI"},
                {extendedWebPage.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", extendedWebPage, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIElementDataProvider() {
        return new Object[][]{
                {extendedWebPage.uielementPublic, "id='uielementPublic'", extendedWebPage, "Uielement Public"},
                {extendedWebPage.uielementPublicUI, "css='.uielementPublicUI'", extendedWebPage, "Uielement Public UI"},
                {extendedWebPage.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", extendedWebPage, "Uielement Public X Path"},
                {extendedWebPage.getUielementPackage(), "id='uielementPackage'", extendedWebPage, "Uielement Package"},
                {extendedWebPage.getUielementPrivate(), "id='uielementPrivate'", extendedWebPage, "Uielement Private"},
                {extendedWebPage.getUielementPackageUI(), "css='.uielementPackageUI'", extendedWebPage, "Uielement Package UI"},
                {extendedWebPage.getUielementPackageCss(), "css='.uielementPackageCss'", extendedWebPage, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageButtonDataProvider() {
        return new Object[][]{
                {extendedWebPage.buttonPublic, "id='buttonPublic'", extendedWebPage, "Button Public"},
                {extendedWebPage.buttonPublicUI, "css='.buttonPublicUI'", extendedWebPage, "Button Public UI"},
                {extendedWebPage.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", extendedWebPage, "Button Public X Path"},
                {extendedWebPage.getButtonPackage(), "id='buttonPackage'", extendedWebPage, "Button Package"},
                {extendedWebPage.getButtonPrivate(), "id='buttonPrivate'", extendedWebPage, "Button Private"},
                {extendedWebPage.getButtonPackageUI(), "css='.buttonPackageUI'", extendedWebPage, "Button Package UI"},
                {extendedWebPage.getButtonPackageCss(), "css='.buttonPackageCss'", extendedWebPage, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageWebListDataProvider() {
        return new Object[][]{
                {extendedWebPage.webListPublic, "id='webListPublic'", extendedWebPage, "Web List Public"},
                {extendedWebPage.webListPublicUI, "css='.webListPublicUI'", extendedWebPage, "Web List Public UI"},
                {extendedWebPage.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", extendedWebPage, "Web List Public X Path"},
                {extendedWebPage.getWebListPackage(), "id='webListPackage'", extendedWebPage, "Web List Package"},
                {extendedWebPage.getWebListPrivate(), "id='webListPrivate'", extendedWebPage, "Web List Private"},
                {extendedWebPage.getWebListPackageUI(), "css='.webListPackageUI'", extendedWebPage, "Web List Package UI"},
                {extendedWebPage.getWebListPackageCss(), "css='.webListPackageCss'", extendedWebPage, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedWebPage.listUIElementPublic, "id='listUIElementPublic'", extendedWebPage, "List UI Element Public"},
                {extendedWebPage.listUIElementPublicUI, "css='.listUIElementPublicUI'", extendedWebPage, "List UI Element Public UI"},
                {extendedWebPage.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", extendedWebPage, "List UI Element Public X Path"},
                {extendedWebPage.getListUIElementPackage(), "id='listUIElementPackage'", extendedWebPage, "List UI Element Package"},
                {extendedWebPage.getListUIElementPrivate(), "id='listUIElementPrivate'", extendedWebPage, "List UI Element Private"},
                {extendedWebPage.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", extendedWebPage, "List UI Element Package UI"},
                {extendedWebPage.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", extendedWebPage, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedWebPageListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedWebPage.listButtonPublic, "id='listButtonPublic'", extendedWebPage, "List Button Public"},
                {extendedWebPage.listButtonPublicUI, "css='.listButtonPublicUI'", extendedWebPage, "List Button Public UI"},
                {extendedWebPage.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", extendedWebPage, "List Button Public X Path"},
                {extendedWebPage.getListButtonPackage(), "id='listButtonPackage'", extendedWebPage, "List Button Package"},
                {extendedWebPage.getListButtonPrivate(), "id='listButtonPrivate'", extendedWebPage, "List Button Private"},
                {extendedWebPage.getListButtonPackageUI(), "css='.listButtonPackageUI'", extendedWebPage, "List Button Package UI"},
                {extendedWebPage.getListButtonPackageCss(), "css='.listButtonPackageCss'", extendedWebPage, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedWebPage.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedWebPage, "Uilist Question Public"},
                {extendedWebPage.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedWebPage, "Uilist Question Public UI"},
                {extendedWebPage.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", extendedWebPage, "Uilist Question Public X Path"},
                {extendedWebPage.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedWebPage, "Uilist Question Package"},
                {extendedWebPage.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedWebPage, "Uilist Question Private"},
                {extendedWebPage.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedWebPage, "Uilist Question Package UI"},
                {extendedWebPage.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", extendedWebPage, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedWebPage.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedWebPage, "Uilist Somedata Public"},
                {extendedWebPage.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedWebPage, "Uilist Somedata Public UI"},
                {extendedWebPage.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", extendedWebPage, "Uilist Somedata Public X Path"},
                {extendedWebPage.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedWebPage, "Uilist Somedata Package"},
                {extendedWebPage.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedWebPage, "Uilist Somedata Private"},
                {extendedWebPage.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedWebPage, "Uilist Somedata Package UI"},
                {extendedWebPage.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", extendedWebPage, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageDropDownDataProvider() {
        return new Object[][]{
                {extendedWebPage.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedWebPage, "Droplist Package"},
                {extendedWebPage.droplistPublic, "css='div[ui=droplistPublic'", extendedWebPage, "Droplist Public"},
                {extendedWebPage.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedWebPage, "Droplist Private"},
                {extendedWebPage.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedWebPage, "Droplist Package UI"},
                {extendedWebPage.droplistPublicUI, "css='.droplistPublicUI'", extendedWebPage, "Droplist Public UI"},
        };
    }
}
