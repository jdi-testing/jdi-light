package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.customSection;

public class SomeSectionDataProvider {
    @DataProvider
    public Object[][] someSectionWebElementDataProvider() {
        return new Object[][]{
                {customSection.webElementPublic, "id='webElementPublic'", customSection, "Web Element Public"},
                {customSection.webElementPublic, "id='webElementPublic'", customSection, "Web Element Public"},
                {customSection.webElementPublicUI, "css='.webElementPublicUI'", customSection, "Web Element Public UI"},
                {customSection.getWebElementPackage(), "id='webElementPackage'", customSection, "Web Element Package"},
                {customSection.getWebElementPrivate(), "id='webElementPrivate'", customSection, "Web Element Private"},
                {customSection.getWebElementPackageUI(), "css='.webElementPackageUI'", customSection, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionListWebElementDataProvider() {
        return new Object[][]{
                {customSection.listWebElementPublic, "id='listWebElementPublic'", customSection, "List Web Element Public"},
                {customSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", customSection, "List Web Element Public UI"},
                {customSection.getListWebElementPackage(), "id='listWebElementPackage'", customSection, "List Web Element Package"},
                {customSection.getListWebElementPrivate(), "id='listWebElementPrivate'", customSection, "List Web Element Private"},
                {customSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", customSection, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIElementDataProvider() {
        return new Object[][]{
                {customSection.uielementPublic, "id='uielementPublic'", customSection, "Uielement Public"},
                {customSection.uielementPublicUI, "css='.uielementPublicUI'", customSection, "Uielement Public UI"},
                {customSection.getUielementPackage(), "id='uielementPackage'", customSection, "Uielement Package"},
                {customSection.getUielementPrivate(), "id='uielementPrivate'", customSection, "Uielement Private"},
                {customSection.getUielementPackageUI(), "css='.uielementPackageUI'", customSection, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionButtonDataProvider() {
        return new Object[][]{
                {customSection.getButtonPackage(), "id='buttonPackage'", customSection, "Button Package"},
                {customSection.buttonPublic, "id='buttonPublic'", customSection, "Button Public"},
                {customSection.getButtonPrivate(), "id='buttonPrivate'", customSection, "Button Private"},
                {customSection.buttonPublicUI, "css='.buttonPublicUI'", customSection, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionWebListDataProvider() {
        return new Object[][]{
                {customSection.getWebListPackage(), "id='webListPackage'", customSection, "Web List Package"},
                {customSection.webListPublic, "id='webListPublic'", customSection, "Web List Public"},
                {customSection.getWebListPrivate(), "id='webListPrivate'", customSection, "Web List Private"},
                {customSection.getWebListPrivate(), "id='webListPrivate'", customSection, "Web List Private"},
                {customSection.getWebListPackageUI(), "css='.webListPackageUI'", customSection, "Web List Package UI"},
                {customSection.webListPublicUI, "css='.webListPublicUI'", customSection, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionListUIElementPublicDataProvider() {
        return new Object[][]{
                {customSection.listUIElementPublic, "id='listUIElementPublic'", customSection, "List UI Element Public"},
                {customSection.getListUIElementPackage(), "id='listUIElementPackage'", customSection, "List UI Element Package"},
                {customSection.getListUIElementPrivate(), "id='listUIElementPrivate'", customSection, "List UI Element Private"},
                {customSection.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", customSection, "List UI Element Package UI"},
                {customSection.listUIElementPublicUI, "css='.listUIElementPublicUI'", customSection, "List UI Element Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionListButtonPublicDataProvider() {
        return new Object[][]{
                {customSection.getListButtonPackage(), "id='listButtonPackage'", customSection, "List Button Package"},
                {customSection.listButtonPublic, "id='listButtonPublic'", customSection, "List Button Public"},
                {customSection.getListButtonPrivate(), "id='listButtonPrivate'", customSection, "List Button Private"},
                {customSection.getListButtonPackageUI(), "css='.listButtonPackageUI'", customSection, "List Button Package UI"},
                {customSection.listButtonPublicUI, "css='.listButtonPublicUI'", customSection, "List Button Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListQuestionDataProvider() {
        return new Object[][]{
                {customSection.getUilistQuestionPackage(), "id='uilistQuestionPackage'", customSection, "Uilist Question Package"},
                {customSection.uilistQuestionPublic, "id='uilistQuestionPublic'", customSection, "Uilist Question Public"},
                {customSection.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", customSection, "Uilist Question Private"},
                {customSection.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", customSection, "Uilist Question Package UI"},
                {customSection.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", customSection, "Uilist Question Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {customSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", customSection, "Uilist Somedata Package"},
                {customSection.uilistSomedataPublic, "id='uilistSomedataPublic'", customSection, "Uilist Somedata Public"},
                {customSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", customSection, "Uilist Somedata Private"},
                {customSection.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", customSection, "Uilist Somedata Package UI"},
                {customSection.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", customSection, "Uilist Somedata Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionDropDownDataProvider() {
        return new Object[][]{
                {customSection.getDroplistPackage(), "css='div[ui=droplistPackage'", customSection, "Droplist Package"},
                {customSection.droplistPublic, "css='div[ui=droplistPublic'", customSection, "Droplist Public"},
                {customSection.getDroplistPrivate(), "css='div[ui=droplistPrivate'", customSection, "Droplist Private"},
                {customSection.getDroplistPackageUI(), "css='.droplistPackageUI'", customSection, "Droplist Package UI"},
                {customSection.droplistPublicUI, "css='.droplistPublicUI'", customSection, "Droplist Public UI"},
        };
    }
}
