package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.extendedSectionUI;

public class ExtendedSectionUIDataProvider {
    @DataProvider
    public Object[][] extendedSectionUIWebElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.webElementPublic, "id='webElementPublic'", extendedSectionUI, "Web Element Public"},
                {extendedSectionUI.webElementPublicUI, "css='.webElementPublicUI'", extendedSectionUI, "Web Element Public UI"},
                {extendedSectionUI.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", extendedSectionUI, "Web Element Public X Path"},
                {extendedSectionUI.getWebElementPackage(), "id='webElementPackage'", extendedSectionUI, "Web Element Package"},
                {extendedSectionUI.getWebElementPrivate(), "id='webElementPrivate'", extendedSectionUI, "Web Element Private"},
                {extendedSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedSectionUI, "Web Element Package UI"},
                {extendedSectionUI.getWebElementPackageCss(), "css='.webElementPackageCss'", extendedSectionUI, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.listWebElementPublic, "id='listWebElementPublic'", extendedSectionUI, "List Web Element Public"},
                {extendedSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedSectionUI, "List Web Element Public UI"},
                {extendedSectionUI.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", extendedSectionUI, "List Web Element Public X Path"},
                {extendedSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", extendedSectionUI, "List Web Element Package"},
                {extendedSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedSectionUI, "List Web Element Private"},
                {extendedSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedSectionUI, "List Web Element Package UI"},
                {extendedSectionUI.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", extendedSectionUI, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.uielementPublic, "id='uielementPublic'", extendedSectionUI, "Uielement Public"},
                {extendedSectionUI.uielementPublicUI, "css='.uielementPublicUI'", extendedSectionUI, "Uielement Public UI"},
                {extendedSectionUI.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", extendedSectionUI, "Uielement Public X Path"},
                {extendedSectionUI.getUielementPackage(), "id='uielementPackage'", extendedSectionUI, "Uielement Package"},
                {extendedSectionUI.getUielementPrivate(), "id='uielementPrivate'", extendedSectionUI, "Uielement Private"},
                {extendedSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", extendedSectionUI, "Uielement Package UI"},
                {extendedSectionUI.getUielementPackageCss(), "css='.uielementPackageCss'", extendedSectionUI, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIButtonDataProvider() {
        return new Object[][]{
                {extendedSectionUI.buttonPublic, "id='buttonPublic'", extendedSectionUI, "Button Public"},
                {extendedSectionUI.buttonPublicUI, "css='.buttonPublicUI'", extendedSectionUI, "Button Public UI"},
                {extendedSectionUI.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", extendedSectionUI, "Button Public X Path"},
                {extendedSectionUI.getButtonPackage(), "id='buttonPackage'", extendedSectionUI, "Button Package"},
                {extendedSectionUI.getButtonPrivate(), "id='buttonPrivate'", extendedSectionUI, "Button Private"},
                {extendedSectionUI.getButtonPackageUI(), "css='.buttonPackageUI'", extendedSectionUI, "Button Package UI"},
                {extendedSectionUI.getButtonPackageCss(), "css='.buttonPackageCss'", extendedSectionUI, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIWebListDataProvider() {
        return new Object[][]{
                {extendedSectionUI.webListPublic, "id='webListPublic'", extendedSectionUI, "Web List Public"},
                {extendedSectionUI.webListPublicUI, "css='.webListPublicUI'", extendedSectionUI, "Web List Public UI"},
                {extendedSectionUI.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", extendedSectionUI, "Web List Public X Path"},
                {extendedSectionUI.getWebListPackage(), "id='webListPackage'", extendedSectionUI, "Web List Package"},
                {extendedSectionUI.getWebListPrivate(), "id='webListPrivate'", extendedSectionUI, "Web List Private"},
                {extendedSectionUI.getWebListPackageUI(), "css='.webListPackageUI'", extendedSectionUI, "Web List Package UI"},
                {extendedSectionUI.getWebListPackageCss(), "css='.webListPackageCss'", extendedSectionUI, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedSectionUI.listUIElementPublic, "id='listUIElementPublic'", extendedSectionUI, "List UI Element Public"},
                {extendedSectionUI.listUIElementPublicUI, "css='.listUIElementPublicUI'", extendedSectionUI, "List UI Element Public UI"},
                {extendedSectionUI.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", extendedSectionUI, "List UI Element Public X Path"},
                {extendedSectionUI.getListUIElementPackage(), "id='listUIElementPackage'", extendedSectionUI, "List UI Element Package"},
                {extendedSectionUI.getListUIElementPrivate(), "id='listUIElementPrivate'", extendedSectionUI, "List UI Element Private"},
                {extendedSectionUI.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", extendedSectionUI, "List UI Element Package UI"},
                {extendedSectionUI.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", extendedSectionUI, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionUIListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedSectionUI.listButtonPublic, "id='listButtonPublic'", extendedSectionUI, "List Button Public"},
                {extendedSectionUI.listButtonPublicUI, "css='.listButtonPublicUI'", extendedSectionUI, "List Button Public UI"},
                {extendedSectionUI.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", extendedSectionUI, "List Button Public X Path"},
                {extendedSectionUI.getListButtonPackage(), "id='listButtonPackage'", extendedSectionUI, "List Button Package"},
                {extendedSectionUI.getListButtonPrivate(), "id='listButtonPrivate'", extendedSectionUI, "List Button Private"},
                {extendedSectionUI.getListButtonPackageUI(), "css='.listButtonPackageUI'", extendedSectionUI, "List Button Package UI"},
                {extendedSectionUI.getListButtonPackageCss(), "css='.listButtonPackageCss'", extendedSectionUI, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedSectionUI.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedSectionUI, "Uilist Question Public"},
                {extendedSectionUI.uilistQuestionPublicData, "css='.uilistQuestionPublicData'", extendedSectionUI, "Uilist Question Public UI"},
                {extendedSectionUI.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", extendedSectionUI, "Uilist Question Public X Path"},
                {extendedSectionUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedSectionUI, "Uilist Question Package"},
                {extendedSectionUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedSectionUI, "Uilist Question Private"},
                {extendedSectionUI.getUilistQuestionPackageData(), "css='.uilistQuestionPackageUI'", extendedSectionUI, "Uilist Question Package UI"},
                {extendedSectionUI.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", extendedSectionUI, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedSectionUI, "Uilist Somedata Public"},
                {extendedSectionUI.uilistSomedataPublicData, "css='.uilistSomedataPublicData'", extendedSectionUI, "Uilist Somedata Public UI"},
                {extendedSectionUI.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", extendedSectionUI, "Uilist Somedata Public X Path"},
                {extendedSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedSectionUI, "Uilist Somedata Package"},
                {extendedSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedSectionUI, "Uilist Somedata Private"},
                {extendedSectionUI.getUilistSomedataPackageData(), "css='.uilistSomedataPackageUI'", extendedSectionUI, "Uilist Somedata Package UI"},
                {extendedSectionUI.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", extendedSectionUI, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIDropDownDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedSectionUI, "Droplist Package"},
                {extendedSectionUI.droplistPublic, "css='div[ui=droplistPublic'", extendedSectionUI, "Droplist Public"},
                {extendedSectionUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedSectionUI, "Droplist Private"},
                {extendedSectionUI.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedSectionUI, "Droplist Package UI"},
                {extendedSectionUI.droplistPublicUI, "css='.droplistPublicUI'", extendedSectionUI, "Droplist Public UI"},
        };
    }
}
