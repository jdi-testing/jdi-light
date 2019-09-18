package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.customSectionUI;

public class CustomSectionUIDataProvider {
    @DataProvider
    public Object[][] customSectionUIWebElementDataProvider() {
        return new Object[][]{
                {customSectionUI.webElementPublic, "id='webElementPublic'", customSectionUI, "Web Element Public"},
                {customSectionUI.webElementPublicUI, "css='.webElementPublicUI'", customSectionUI, "Web Element Public UI"},
                {customSectionUI.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", customSectionUI, "Web Element Public X Path"},
                {customSectionUI.getWebElementPackage(), "id='webElementPackage'", customSectionUI, "Web Element Package"},
                {customSectionUI.getWebElementPrivate(), "id='webElementPrivate'", customSectionUI, "Web Element Private"},
                {customSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", customSectionUI, "Web Element Package UI"},
                {customSectionUI.getWebElementPackageCss(), "css='.webElementPackageCss'", customSectionUI, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {customSectionUI.listWebElementPublic, "id='listWebElementPublic'", customSectionUI, "List Web Element Public"},
                {customSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", customSectionUI, "List Web Element Public UI"},
                {customSectionUI.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", customSectionUI, "List Web Element Public X Path"},
                {customSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", customSectionUI, "List Web Element Package"},
                {customSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", customSectionUI, "List Web Element Private"},
                {customSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", customSectionUI, "List Web Element Package UI"},
                {customSectionUI.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", customSectionUI, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIUIElementDataProvider() {
        return new Object[][]{
                {customSectionUI.uielementPublic, "id='uielementPublic'", customSectionUI, "Uielement Public"},
                {customSectionUI.uielementPublicUI, "css='.uielementPublicUI'", customSectionUI, "Uielement Public UI"},
                {customSectionUI.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", customSectionUI, "Uielement Public X Path"},
                {customSectionUI.getUielementPackage(), "id='uielementPackage'", customSectionUI, "Uielement Package"},
                {customSectionUI.getUielementPrivate(), "id='uielementPrivate'", customSectionUI, "Uielement Private"},
                {customSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", customSectionUI, "Uielement Package UI"},
                {customSectionUI.getUielementPackageCss(), "css='.uielementPackageCss'", customSectionUI, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIButtonDataProvider() {
        return new Object[][]{
                {customSectionUI.buttonPublic, "id='buttonPublic'", customSectionUI, "Button Public"},
                {customSectionUI.buttonPublicUI, "css='.buttonPublicUI'", customSectionUI, "Button Public UI"},
                {customSectionUI.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", customSectionUI, "Button Public X Path"},
                {customSectionUI.getButtonPackage(), "id='buttonPackage'", customSectionUI, "Button Package"},
                {customSectionUI.getButtonPrivate(), "id='buttonPrivate'", customSectionUI, "Button Private"},
                {customSectionUI.getButtonPackageUI(), "css='.buttonPackageUI'", customSectionUI, "Button Package UI"},
                {customSectionUI.getButtonPackageCss(), "css='.buttonPackageCss'", customSectionUI, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIWebListDataProvider() {
        return new Object[][]{
                {customSectionUI.webListPublic, "id='webListPublic'", customSectionUI, "Web List Public"},
                {customSectionUI.webListPublicUI, "css='.webListPublicUI'", customSectionUI, "Web List Public UI"},
                {customSectionUI.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", customSectionUI, "Web List Public X Path"},
                {customSectionUI.getWebListPackage(), "id='webListPackage'", customSectionUI, "Web List Package"},
                {customSectionUI.getWebListPrivate(), "id='webListPrivate'", customSectionUI, "Web List Private"},
                {customSectionUI.getWebListPackageUI(), "css='.webListPackageUI'", customSectionUI, "Web List Package UI"},
                {customSectionUI.getWebListPackageCss(), "css='.webListPackageCss'", customSectionUI, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {customSectionUI.listUIElementPublic, "id='listUIElementPublic'", customSectionUI, "List UI Element Public"},
                {customSectionUI.listUIElementPublicUI, "css='.listUIElementPublicUI'", customSectionUI, "List UI Element Public UI"},
                {customSectionUI.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", customSectionUI, "List UI Element Public X Path"},
                {customSectionUI.getListUIElementPackage(), "id='listUIElementPackage'", customSectionUI, "List UI Element Package"},
                {customSectionUI.getListUIElementPrivate(), "id='listUIElementPrivate'", customSectionUI, "List UI Element Private"},
                {customSectionUI.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", customSectionUI, "List UI Element Package UI"},
                {customSectionUI.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", customSectionUI, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customSectionUIListButtonPublicDataProvider() {
        return new Object[][]{
                {customSectionUI.listButtonPublic, "id='listButtonPublic'", customSectionUI, "List Button Public"},
                {customSectionUI.listButtonPublicUI, "css='.listButtonPublicUI'", customSectionUI, "List Button Public UI"},
                {customSectionUI.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", customSectionUI, "List Button Public X Path"},
                {customSectionUI.getListButtonPackage(), "id='listButtonPackage'", customSectionUI, "List Button Package"},
                {customSectionUI.getListButtonPrivate(), "id='listButtonPrivate'", customSectionUI, "List Button Private"},
                {customSectionUI.getListButtonPackageUI(), "css='.listButtonPackageUI'", customSectionUI, "List Button Package UI"},
                {customSectionUI.getListButtonPackageCss(), "css='.listButtonPackageCss'", customSectionUI, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIUIListQuestionDataProvider() {
        return new Object[][]{
                {customSectionUI.uilistQuestionPublic, "id='uilistQuestionPublic'", customSectionUI, "Uilist Question Public"},
                {customSectionUI.uilistQuestionPublicData, "css='.uilistQuestionPublicData'", customSectionUI, "Uilist Question Public Data"},
                {customSectionUI.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", customSectionUI, "Uilist Question Public X Path"},
                {customSectionUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", customSectionUI, "Uilist Question Package"},
                {customSectionUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", customSectionUI, "Uilist Question Private"},
                {customSectionUI.getUilistQuestionPackageData(), "css='.uilistQuestionPackageData'", customSectionUI, "Uilist Question Package Data"},
                {customSectionUI.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", customSectionUI, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {customSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", customSectionUI, "Uilist Somedata Public"},
                {customSectionUI.uilistSomedataPublicData, "css='.uilistSomedataPublicData'", customSectionUI, "Uilist Somedata Public Data"},
                {customSectionUI.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", customSectionUI, "Uilist Somedata Public X Path"},
                {customSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", customSectionUI, "Uilist Somedata Package"},
                {customSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", customSectionUI, "Uilist Somedata Private"},
                {customSectionUI.getUilistSomedataPackageData(), "css='.uilistSomedataPackageData'", customSectionUI, "Uilist Somedata Package Data"},
                {customSectionUI.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", customSectionUI, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIDropDownDataProvider() {
        return new Object[][]{
                {customSectionUI.getDroplistPackage(), "css='div[ui=droplistPackage'", customSectionUI, "Droplist Package"},
                {customSectionUI.droplistPublic, "css='div[ui=droplistPublic'", customSectionUI, "Droplist Public"},
                {customSectionUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", customSectionUI, "Droplist Private"},
                {customSectionUI.getDroplistPackageUI(), "css='.droplistPackageUI'", customSectionUI, "Droplist Package UI"},
                {customSectionUI.droplistPublicUI, "css='.droplistPublicUI'", customSectionUI, "Droplist Public UI"},
        };
    }
}
