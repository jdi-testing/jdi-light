package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSiteUtils.extendedSection;

public class ExtendedSectionDataProvider {
    @DataProvider
    public Object[][] extendedSectionWebElementDataProvider() {
        return new Object[][]{
                {extendedSection.webElementPublic, "id='webElementPublic'", extendedSection, "Web Element Public"},
                {extendedSection.webElementPublicUI, "css='.webElementPublicUI'", extendedSection, "Web Element Public UI"},
                {extendedSection.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", extendedSection, "Web Element Public X Path"},
                {extendedSection.getWebElementPackage(), "id='webElementPackage'", extendedSection, "Web Element Package"},
                {extendedSection.getWebElementPrivate(), "id='webElementPrivate'", extendedSection, "Web Element Private"},
                {extendedSection.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedSection, "Web Element Package UI"},
                {extendedSection.getWebElementPackageCss(), "css='.webElementPackageCss'", extendedSection, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionListWebElementDataProvider() {
        return new Object[][]{
                {extendedSection.listWebElementPublic, "id='listWebElementPublic'", extendedSection, "List Web Element Public"},
                {extendedSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedSection, "List Web Element Public UI"},
                {extendedSection.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", extendedSection, "List Web Element Public X Path"},
                {extendedSection.getListWebElementPackage(), "id='listWebElementPackage'", extendedSection, "List Web Element Package"},
                {extendedSection.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedSection, "List Web Element Private"},
                {extendedSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedSection, "List Web Element Package UI"},
                {extendedSection.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", extendedSection, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIElementDataProvider() {
        return new Object[][]{
                {extendedSection.uielementPublic, "id='uielementPublic'", extendedSection, "Uielement Public"},
                {extendedSection.uielementPublicUI, "css='.uielementPublicUI'", extendedSection, "Uielement Public UI"},
                {extendedSection.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", extendedSection, "Uielement Public X Path"},
                {extendedSection.getUielementPackage(), "id='uielementPackage'", extendedSection, "Uielement Package"},
                {extendedSection.getUielementPrivate(), "id='uielementPrivate'", extendedSection, "Uielement Private"},
                {extendedSection.getUielementPackageUI(), "css='.uielementPackageUI'", extendedSection, "Uielement Package UI"},
                {extendedSection.getUielementPackageCss(), "css='.uielementPackageCss'", extendedSection, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionButtonDataProvider() {
        return new Object[][]{
                {extendedSection.buttonPublic, "id='buttonPublic'", extendedSection, "Button Public"},
                {extendedSection.buttonPublicUI, "css='.buttonPublicUI'", extendedSection, "Button Public UI"},
                {extendedSection.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", extendedSection, "Button Public X Path"},
                {extendedSection.getButtonPackage(), "id='buttonPackage'", extendedSection, "Button Package"},
                {extendedSection.getButtonPrivate(), "id='buttonPrivate'", extendedSection, "Button Private"},
                {extendedSection.getButtonPackageUI(), "css='.buttonPackageUI'", extendedSection, "Button Package UI"},
                {extendedSection.getButtonPackageCss(), "css='.buttonPackageCss'", extendedSection, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionWebListDataProvider() {
        return new Object[][]{
                {extendedSection.webListPublic, "id='webListPublic'", extendedSection, "Web List Public"},
                {extendedSection.webListPublicUI, "css='.webListPublicUI'", extendedSection, "Web List Public UI"},
                {extendedSection.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", extendedSection, "Web List Public X Path"},
                {extendedSection.getWebListPackage(), "id='webListPackage'", extendedSection, "Web List Package"},
                {extendedSection.getWebListPrivate(), "id='webListPrivate'", extendedSection, "Web List Private"},
                {extendedSection.getWebListPackageUI(), "css='.webListPackageUI'", extendedSection, "Web List Package UI"},
                {extendedSection.getWebListPackageCss(), "css='.webListPackageCss'", extendedSection, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedSection.listUIElementPublic, "id='listUIElementPublic'", extendedSection, "List UI Element Public"},
                {extendedSection.listUIElementPublicUI, "css='.listUIElementPublicUI'", extendedSection, "List UI Element Public UI"},
                {extendedSection.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", extendedSection, "List UI Element Public X Path"},
                {extendedSection.getListUIElementPackage(), "id='listUIElementPackage'", extendedSection, "List UI Element Package"},
                {extendedSection.getListUIElementPrivate(), "id='listUIElementPrivate'", extendedSection, "List UI Element Private"},
                {extendedSection.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", extendedSection, "List UI Element Package UI"},
                {extendedSection.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", extendedSection, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedSection.listButtonPublic, "id='listButtonPublic'", extendedSection, "List Button Public"},
                {extendedSection.listButtonPublicUI, "css='.listButtonPublicUI'", extendedSection, "List Button Public UI"},
                {extendedSection.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", extendedSection, "List Button Public X Path"},
                {extendedSection.getListButtonPackage(), "id='listButtonPackage'", extendedSection, "List Button Package"},
                {extendedSection.getListButtonPrivate(), "id='listButtonPrivate'", extendedSection, "List Button Private"},
                {extendedSection.getListButtonPackageUI(), "css='.listButtonPackageUI'", extendedSection, "List Button Package UI"},
                {extendedSection.getListButtonPackageCss(), "css='.listButtonPackageCss'", extendedSection, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedSection.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedSection, "Uilist Question Public"},
                {extendedSection.uilistQuestionPublicData, "css='.uilistQuestionPublicData'", extendedSection, "Uilist Question Public Data"},
                {extendedSection.uilistQuestionPublicXPath, "xpath='//*[@class='uilistQuestionPublicXPath']'", extendedSection, "Uilist Question Public X Path"},
                {extendedSection.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedSection, "Uilist Question Package"},
                {extendedSection.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedSection, "Uilist Question Private"},
                {extendedSection.getUilistQuestionPackageData(), "css='.uilistQuestionPackageData'", extendedSection, "Uilist Question Package Data"},
                {extendedSection.getUilistQuestionPackageCss(), "css='.uilistQuestionPackageCss'", extendedSection, "Uilist Question Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedSection.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedSection, "Uilist Somedata Public"},
                {extendedSection.uilistSomedataPublicData, "css='.uilistSomedataPublicData'", extendedSection, "Uilist Somedata Public Data"},
                {extendedSection.uilistSomedataPublicXPath, "xpath='//*[@class='uilistSomedataPublicXPath']'", extendedSection, "Uilist Somedata Public X Path"},
                {extendedSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedSection, "Uilist Somedata Package"},
                {extendedSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedSection, "Uilist Somedata Private"},
                {extendedSection.getUilistSomedataPackageData(), "css='.uilistSomedataPackageData'", extendedSection, "Uilist Somedata Package Data"},
                {extendedSection.getUilistSomedataPackageCss(), "css='.uilistSomedataPackageCss'", extendedSection, "Uilist Somedata Package Css"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionDropDownDataProvider() {
        return new Object[][]{
                {extendedSection.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedSection, "Droplist Package"},
                {extendedSection.droplistPublic, "css='div[ui=droplistPublic'", extendedSection, "Droplist Public"},
                {extendedSection.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedSection, "Droplist Private"},
                {extendedSection.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedSection, "Droplist Package UI"},
                {extendedSection.droplistPublicUI, "css='.droplistPublicUI'", extendedSection, "Droplist Public UI"},
        };
    }
}
