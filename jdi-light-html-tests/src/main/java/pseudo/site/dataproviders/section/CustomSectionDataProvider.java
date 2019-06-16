package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.customSection;

public class CustomSectionDataProvider {
    @DataProvider
    public Object[][] customSectionWebElementDataProvider() {
        return new Object[][]{
                {customSection.webElementPublic, "id='webElementPublic'", customSection, "Web Element Public"},
                {customSection.webElementPublicUI, "css='.webElementPublicUI'", customSection, "Web Element Public UI"},
                {customSection.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", customSection, "Web Element Public X Path"},
                {customSection.getWebElementPackage(), "id='webElementPackage'", customSection, "Web Element Package"},
                {customSection.getWebElementPrivate(), "id='webElementPrivate'", customSection, "Web Element Private"},
                {customSection.getWebElementPackageUI(), "css='.webElementPackageUI'", customSection, "Web Element Package UI"},
                {customSection.getWebElementPackageCss(), "css='.webElementPackageCss'", customSection, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customSectionListWebElementDataProvider() {
        return new Object[][]{
                {customSection.listWebElementPublic, "id='listWebElementPublic'", customSection, "List Web Element Public"},
                {customSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", customSection, "List Web Element Public UI"},
                {customSection.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", customSection, "List Web Element Public X Path"},
                {customSection.getListWebElementPackage(), "id='listWebElementPackage'", customSection, "List Web Element Package"},
                {customSection.getListWebElementPrivate(), "id='listWebElementPrivate'", customSection, "List Web Element Private"},
                {customSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", customSection, "List Web Element Package UI"},
                {customSection.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", customSection, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIElementDataProvider() {
        return new Object[][]{
                {customSection.uielementPublic, "id='uielementPublic'", customSection, "Uielement Public"},
                {customSection.uielementPublicUI, "css='.uielementPublicUI'", customSection, "Uielement Public UI"},
                {customSection.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", customSection, "Uielement Public X Path"},
                {customSection.getUielementPackage(), "id='uielementPackage'", customSection, "Uielement Package"},
                {customSection.getUielementPrivate(), "id='uielementPrivate'", customSection, "Uielement Private"},
                {customSection.getUielementPackageUI(), "css='.uielementPackageUI'", customSection, "Uielement Package UI"},
                {customSection.getUielementPackageCss(), "css='.uielementPackageCss'", customSection, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionButtonDataProvider() {
        return new Object[][]{
                {customSection.buttonPublic, "id='buttonPublic'", customSection, "Button Public"},
                {customSection.buttonPublicUI, "css='.buttonPublicUI'", customSection, "Button Public UI"},
                {customSection.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", customSection, "Button Public X Path"},
                {customSection.getButtonPackage(), "id='buttonPackage'", customSection, "Button Package"},
                {customSection.getButtonPrivate(), "id='buttonPrivate'", customSection, "Button Private"},
                {customSection.getButtonPackageUI(), "css='.buttonPackageUI'", customSection, "Button Package UI"},
                {customSection.getButtonPackageCss(), "css='.buttonPackageCss'", customSection, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionWebListDataProvider() {
        return new Object[][]{
                {customSection.webListPublic, "id='webListPublic'", customSection, "Web List Public"},
                {customSection.webListPublicUI, "css='.webListPublicUI'", customSection, "Web List Public UI"},
                {customSection.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", customSection, "Web List Public X Path"},
                {customSection.getWebListPackage(), "id='webListPackage'", customSection, "Web List Package"},
                {customSection.getWebListPrivate(), "id='webListPrivate'", customSection, "Web List Private"},
                {customSection.getWebListPackageUI(), "css='.webListPackageUI'", customSection, "Web List Package UI"},
                {customSection.getWebListPackageCss(), "css='.webListPackageCss'", customSection, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionListUIElementPublicDataProvider() {
        return new Object[][]{
                {customSection.listUIElementPublic, "id='listUIElementPublic'", customSection, "List UI Element Public"},
                {customSection.listUIElementPublicUI, "css='.listUIElementPublicUI'", customSection, "List UI Element Public UI"},
                {customSection.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", customSection, "List UI Element Public X Path"},
                {customSection.getListUIElementPackage(), "id='listUIElementPackage'", customSection, "List UI Element Package"},
                {customSection.getListUIElementPrivate(), "id='listUIElementPrivate'", customSection, "List UI Element Private"},
                {customSection.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", customSection, "List UI Element Package UI"},
                {customSection.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", customSection, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customSectionListButtonPublicDataProvider() {
        return new Object[][]{
                {customSection.listButtonPublic, "id='listButtonPublic'", customSection, "List Button Public"},
                {customSection.listButtonPublicUI, "css='.listButtonPublicUI'", customSection, "List Button Public UI"},
                {customSection.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", customSection, "List Button Public X Path"},
                {customSection.getListButtonPackage(), "id='listButtonPackage'", customSection, "List Button Package"},
                {customSection.getListButtonPrivate(), "id='listButtonPrivate'", customSection, "List Button Private"},
                {customSection.getListButtonPackageUI(), "css='.listButtonPackageUI'", customSection, "List Button Package UI"},
                {customSection.getListButtonPackageCss(), "css='.listButtonPackageCss'", customSection, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIListQuestionDataProvider() {
        return new Object[][]{
                {customSection.uilistQuestionPublic, "id='uilistQuestionPublic'", customSection, "Uilist Question Public"},
                {customSection.uilistQuestionPublicData, "css='.uilistQuestionPublicData'", customSection, "Uilist Question Public UI"},
                {customSection.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", customSection, "Uilist Question Public X Path"},
                {customSection.getUilistQuestionPackage(), "id='uilistQuestionPackage'", customSection, "Uilist Question Package"},
                {customSection.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", customSection, "Uilist Question Private"},
                {customSection.getUilistQuestionPackageData(), "css='.uilistQuestionPackageUI'", customSection, "Uilist Question Package UI"},
                {customSection.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", customSection, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {customSection.uilistSomedataPublic, "id='uilistSomedataPublic'", customSection, "Uilist Somedata Public"},
                {customSection.uilistSomedataPublicData, "css='.uilistSomedataPublicData'", customSection, "Uilist Somedata Public UI"},
                {customSection.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", customSection, "Uilist Somedata Public X Path"},
                {customSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", customSection, "Uilist Somedata Package"},
                {customSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", customSection, "Uilist Somedata Private"},
                {customSection.getUilistSomedataPackageData(), "css='.uilistSomedataPackageUI'", customSection, "Uilist Somedata Package UI"},
                {customSection.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", customSection, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] customSectionDropDownDataProvider() {
        return new Object[][]{
                {customSection.getDroplistPackage(), "css='div[ui=droplistPackage'", customSection, "Droplist Package"},
                {customSection.droplistPublic, "css='div[ui=droplistPublic'", customSection, "Droplist Public"},
                {customSection.getDroplistPrivate(), "css='div[ui=droplistPrivate'", customSection, "Droplist Private"},
                {customSection.getDroplistPackageUI(), "css='.droplistPackageUI'", customSection, "Droplist Package UI"},
                {customSection.droplistPublicUI, "css='.droplistPublicUI'", customSection, "Droplist Public UI"},
        };
    }
}
