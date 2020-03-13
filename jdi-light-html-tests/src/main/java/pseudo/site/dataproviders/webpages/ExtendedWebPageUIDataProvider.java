package pseudo.site.dataproviders.webpages;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.*;

public class ExtendedWebPageUIDataProvider {
    @DataProvider
    public Object[][] extendedWebPageUIWebElementDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.webElementPublic, "id='webElementPublic'", extendedWebPageUI, "Web Element Public"},
                {extendedWebPageUI.webElementPublicUI, "css='.webElementPublicUI'", extendedWebPageUI, "Web Element Public UI"},
                {extendedWebPageUI.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", extendedWebPageUI, "Web Element Public X Path"},
                {extendedWebPageUI.getWebElementPackage(), "id='webElementPackage'", extendedWebPageUI, "Web Element Package"},
                {extendedWebPageUI.getWebElementPrivate(), "id='webElementPrivate'", extendedWebPageUI, "Web Element Private"},
                {extendedWebPageUI.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedWebPageUI, "Web Element Package UI"},
                {extendedWebPageUI.getWebElementPackageCss(), "css='.webElementPackageCss'", extendedWebPageUI, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedWebPageUIListWebElementDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.listWebElementPublic, "id='listWebElementPublic'", extendedWebPageUI, "List Web Element Public"},
                {extendedWebPageUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedWebPageUI, "List Web Element Public UI"},
                {extendedWebPageUI.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", extendedWebPageUI, "List Web Element Public X Path"},
                {extendedWebPageUI.getListWebElementPackage(), "id='listWebElementPackage'", extendedWebPageUI, "List Web Element Package"},
                {extendedWebPageUI.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedWebPageUI, "List Web Element Private"},
                {extendedWebPageUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedWebPageUI, "List Web Element Package UI"},
                {extendedWebPageUI.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", extendedWebPageUI, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIUIElementDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.uielementPublic, "id='uielementPublic'", extendedWebPageUI, "Uielement Public"},
                {extendedWebPageUI.uielementPublicUI, "css='.uielementPublicUI'", extendedWebPageUI, "Uielement Public UI"},
                {extendedWebPageUI.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", extendedWebPageUI, "Uielement Public X Path"},
                {extendedWebPageUI.getUielementPackage(), "id='uielementPackage'", extendedWebPageUI, "Uielement Package"},
                {extendedWebPageUI.getUielementPrivate(), "id='uielementPrivate'", extendedWebPageUI, "Uielement Private"},
                {extendedWebPageUI.getUielementPackageUI(), "css='.uielementPackageUI'", extendedWebPageUI, "Uielement Package UI"},
                {extendedWebPageUI.getUielementPackageCss(), "css='.uielementPackageCss'", extendedWebPageUI, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIButtonDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.buttonPublic, "id='buttonPublic'", extendedWebPageUI, "Button Public"},
                {extendedWebPageUI.buttonPublicUI, "css='.buttonPublicUI'", extendedWebPageUI, "Button Public UI"},
                {extendedWebPageUI.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", extendedWebPageUI, "Button Public X Path"},
                {extendedWebPageUI.getButtonPackage(), "id='buttonPackage'", extendedWebPageUI, "Button Package"},
                {extendedWebPageUI.getButtonPrivate(), "id='buttonPrivate'", extendedWebPageUI, "Button Private"},
                {extendedWebPageUI.getButtonPackageUI(), "css='.buttonPackageUI'", extendedWebPageUI, "Button Package UI"},
                {extendedWebPageUI.getButtonPackageCss(), "css='.buttonPackageCss'", extendedWebPageUI, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIWebListDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.webListPublic, "id='webListPublic'", extendedWebPageUI, "Web List Public"},
                {extendedWebPageUI.webListPublicUI, "css='.webListPublicUI'", extendedWebPageUI, "Web List Public UI"},
                {extendedWebPageUI.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", extendedWebPageUI, "Web List Public X Path"},
                {extendedWebPageUI.getWebListPackage(), "id='webListPackage'", extendedWebPageUI, "Web List Package"},
                {extendedWebPageUI.getWebListPrivate(), "id='webListPrivate'", extendedWebPageUI, "Web List Private"},
                {extendedWebPageUI.getWebListPackageUI(), "css='.webListPackageUI'", extendedWebPageUI, "Web List Package UI"},
                {extendedWebPageUI.getWebListPackageCss(), "css='.webListPackageCss'", extendedWebPageUI, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.listUIElementPublic, "id='listUIElementPublic'", extendedWebPageUI, "List UI Element Public"},
                {extendedWebPageUI.listUIElementPublicUI, "css='.listUIElementPublicUI'", extendedWebPageUI, "List UI Element Public UI"},
                {extendedWebPageUI.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", extendedWebPageUI, "List UI Element Public X Path"},
                {extendedWebPageUI.getListUIElementPackage(), "id='listUIElementPackage'", extendedWebPageUI, "List UI Element Package"},
                {extendedWebPageUI.getListUIElementPrivate(), "id='listUIElementPrivate'", extendedWebPageUI, "List UI Element Private"},
                {extendedWebPageUI.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", extendedWebPageUI, "List UI Element Package UI"},
                {extendedWebPageUI.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", extendedWebPageUI, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedWebPageUIListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.listButtonPublic, "id='listButtonPublic'", extendedWebPageUI, "List Button Public"},
                {extendedWebPageUI.listButtonPublicUI, "css='.listButtonPublicUI'", extendedWebPageUI, "List Button Public UI"},
                {extendedWebPageUI.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", extendedWebPageUI, "List Button Public X Path"},
                {extendedWebPageUI.getListButtonPackage(), "id='listButtonPackage'", extendedWebPageUI, "List Button Package"},
                {extendedWebPageUI.getListButtonPrivate(), "id='listButtonPrivate'", extendedWebPageUI, "List Button Private"},
                {extendedWebPageUI.getListButtonPackageUI(), "css='.listButtonPackageUI'", extendedWebPageUI, "List Button Package UI"},
                {extendedWebPageUI.getListButtonPackageCss(), "css='.listButtonPackageCss'", extendedWebPageUI, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedWebPageUI, "Uilist Question Public"},
                {extendedWebPageUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedWebPageUI, "Uilist Question Public UI"},
                {extendedWebPageUI.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", extendedWebPageUI, "Uilist Question Public X Path"},
                {extendedWebPageUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedWebPageUI, "Uilist Question Package"},
                {extendedWebPageUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedWebPageUI, "Uilist Question Private"},
                {extendedWebPageUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedWebPageUI, "Uilist Question Package UI"},
                {extendedWebPageUI.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", extendedWebPageUI, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedWebPageUI, "Uilist Somedata Public"},
                {extendedWebPageUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedWebPageUI, "Uilist Somedata Public UI"},
                {extendedWebPageUI.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", extendedWebPageUI, "Uilist Somedata Public X Path"},
                {extendedWebPageUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedWebPageUI, "Uilist Somedata Package"},
                {extendedWebPageUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedWebPageUI, "Uilist Somedata Private"},
                {extendedWebPageUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedWebPageUI, "Uilist Somedata Package UI"},
                {extendedWebPageUI.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", extendedWebPageUI, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedWebPageUIDropDownDataProvider() {
        return new Object[][]{
                {extendedWebPageUI.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedWebPageUI, "Droplist Package"},
                {extendedWebPageUI.droplistPublic, "css='div[ui=droplistPublic'", extendedWebPageUI, "Droplist Public"},
                {extendedWebPageUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedWebPageUI, "Droplist Private"},
                {extendedWebPageUI.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedWebPageUI, "Droplist Package UI"},
                {extendedWebPageUI.droplistPublicUI, "css='.droplistPublicUI'", extendedWebPageUI, "Droplist Public UI"},
        };
    }
}
