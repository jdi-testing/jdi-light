package pseudo.site.dataproviders.webpages;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.customWebPage;

public class CustomWebPageDataProvider {
    @DataProvider
    public Object[][] customWebPageWebElementDataProvider() {
        return new Object[][]{
                {customWebPage.webElementPublic, "id='webElementPublic'", customWebPage, "Web Element Public"},
                {customWebPage.webElementPublicUI, "css='.webElementPublicUI'", customWebPage, "Web Element Public UI"},
                {customWebPage.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", customWebPage, "Web Element Public X Path"},
                {customWebPage.getWebElementPackage(), "id='webElementPackage'", customWebPage, "Web Element Package"},
                {customWebPage.getWebElementPrivate(), "id='webElementPrivate'", customWebPage, "Web Element Private"},
                {customWebPage.getWebElementPackageUI(), "css='.webElementPackageUI'", customWebPage, "Web Element Package UI"},
                {customWebPage.getWebElementPackageCss(), "css='.webElementPackageCss'", customWebPage, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customWebPageListWebElementDataProvider() {
        return new Object[][]{
                {customWebPage.listWebElementPublic, "id='listWebElementPublic'", customWebPage, "List Web Element Public"},
                {customWebPage.listWebElementPublicUI, "css='.listWebElementPublicUI'", customWebPage, "List Web Element Public UI"},
                {customWebPage.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", customWebPage, "List Web Element Public X Path"},
                {customWebPage.getListWebElementPackage(), "id='listWebElementPackage'", customWebPage, "List Web Element Package"},
                {customWebPage.getListWebElementPrivate(), "id='listWebElementPrivate'", customWebPage, "List Web Element Private"},
                {customWebPage.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", customWebPage, "List Web Element Package UI"},
                {customWebPage.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", customWebPage, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIElementDataProvider() {
        return new Object[][]{
                {customWebPage.uielementPublic, "id='uielementPublic'", customWebPage, "Uielement Public"},
                {customWebPage.uielementPublicUI, "css='.uielementPublicUI'", customWebPage, "Uielement Public UI"},
                {customWebPage.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", customWebPage, "Uielement Public X Path"},
                {customWebPage.getUielementPackage(), "id='uielementPackage'", customWebPage, "Uielement Package"},
                {customWebPage.getUielementPrivate(), "id='uielementPrivate'", customWebPage, "Uielement Private"},
                {customWebPage.getUielementPackageUI(), "css='.uielementPackageUI'", customWebPage, "Uielement Package UI"},
                {customWebPage.getUielementPackageCss(), "css='.uielementPackageCss'", customWebPage, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageButtonDataProvider() {
        return new Object[][]{
                {customWebPage.buttonPublic, "id='buttonPublic'", customWebPage, "Button Public"},
                {customWebPage.buttonPublicUI, "css='.buttonPublicUI'", customWebPage, "Button Public UI"},
                {customWebPage.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", customWebPage, "Button Public X Path"},
                {customWebPage.getButtonPackage(), "id='buttonPackage'", customWebPage, "Button Package"},
                {customWebPage.getButtonPrivate(), "id='buttonPrivate'", customWebPage, "Button Private"},
                {customWebPage.getButtonPackageUI(), "css='.buttonPackageUI'", customWebPage, "Button Package UI"},
                {customWebPage.getButtonPackageCss(), "css='.buttonPackageCss'", customWebPage, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageWebListDataProvider() {
        return new Object[][]{
                {customWebPage.webListPublic, "id='webListPublic'", customWebPage, "Web List Public"},
                {customWebPage.webListPublicUI, "css='.webListPublicUI'", customWebPage, "Web List Public UI"},
                {customWebPage.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", customWebPage, "Web List Public X Path"},
                {customWebPage.getWebListPackage(), "id='webListPackage'", customWebPage, "Web List Package"},
                {customWebPage.getWebListPrivate(), "id='webListPrivate'", customWebPage, "Web List Private"},
                {customWebPage.getWebListPackageUI(), "css='.webListPackageUI'", customWebPage, "Web List Package UI"},
                {customWebPage.getWebListPackageCss(), "css='.webListPackageCss'", customWebPage, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageListUIElementPublicDataProvider() {
        return new Object[][]{
                {customWebPage.listUIElementPublic, "id='listUIElementPublic'", customWebPage, "List UI Element Public"},
                {customWebPage.listUIElementPublicUI, "css='.listUIElementPublicUI'", customWebPage, "List UI Element Public UI"},
                {customWebPage.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", customWebPage, "List UI Element Public X Path"},
                {customWebPage.getListUIElementPackage(), "id='listUIElementPackage'", customWebPage, "List UI Element Package"},
                {customWebPage.getListUIElementPrivate(), "id='listUIElementPrivate'", customWebPage, "List UI Element Private"},
                {customWebPage.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", customWebPage, "List UI Element Package UI"},
                {customWebPage.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", customWebPage, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customWebPageListButtonPublicDataProvider() {
        return new Object[][]{
                {customWebPage.listButtonPublic, "id='listButtonPublic'", customWebPage, "List Button Public"},
                {customWebPage.listButtonPublicUI, "css='.listButtonPublicUI'", customWebPage, "List Button Public UI"},
                {customWebPage.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", customWebPage, "List Button Public X Path"},
                {customWebPage.getListButtonPackage(), "id='listButtonPackage'", customWebPage, "List Button Package"},
                {customWebPage.getListButtonPrivate(), "id='listButtonPrivate'", customWebPage, "List Button Private"},
                {customWebPage.getListButtonPackageUI(), "css='.listButtonPackageUI'", customWebPage, "List Button Package UI"},
                {customWebPage.getListButtonPackageCss(), "css='.listButtonPackageCss'", customWebPage, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIListQuestionDataProvider() {
        return new Object[][]{
                {customWebPage.uilistQuestionPublic, "id='uilistQuestionPublic'", customWebPage, "Uilist Question Public"},
                {customWebPage.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", customWebPage, "Uilist Question Public UI"},
                {customWebPage.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", customWebPage, "Uilist Question Public X Path"},
                {customWebPage.getUilistQuestionPackage(), "id='uilistQuestionPackage'", customWebPage, "Uilist Question Package"},
                {customWebPage.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", customWebPage, "Uilist Question Private"},
                {customWebPage.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", customWebPage, "Uilist Question Package UI"},
                {customWebPage.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", customWebPage, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIListSomedataDataProvider() {
        return new Object[][]{
                {customWebPage.uilistSomedataPublic, "id='uilistSomedataPublic'", customWebPage, "Uilist Somedata Public"},
                {customWebPage.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", customWebPage, "Uilist Somedata Public UI"},
                {customWebPage.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", customWebPage, "Uilist Somedata Public X Path"},
                {customWebPage.getUilistSomedataPackage(), "id='uilistSomedataPackage'", customWebPage, "Uilist Somedata Package"},
                {customWebPage.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", customWebPage, "Uilist Somedata Private"},
                {customWebPage.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", customWebPage, "Uilist Somedata Package UI"},
                {customWebPage.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", customWebPage, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageDropDownDataProvider() {
        return new Object[][]{
                {customWebPage.getDropdownPackage(), "css='div[ui=droplistPackage'", customWebPage, "Droplist Package"},
                {customWebPage.droplistPublic, "css='div[ui=droplistPublic'", customWebPage, "Droplist Public"},
                {customWebPage.getDropdownPrivate(), "css='div[ui=droplistPrivate'", customWebPage, "Droplist Private"},
                {customWebPage.getDropdownPackageUI(), "css='.droplistPackageUI'", customWebPage, "Droplist Package UI"},
                {customWebPage.droplistPublicUI, "css='.droplistPublicUI'", customWebPage, "Droplist Public UI"},
        };
    }
}
