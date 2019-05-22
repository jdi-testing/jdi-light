package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.customSectionUI;

public class SomeSectionUIDataProvider {
    @DataProvider
    public Object[][] someSectionUIWebElementDataProvider() {
        return new Object[][]{
                {customSectionUI.webElementPublic, "id='webElementPublic'", customSectionUI, "Web Element Public"},
                {customSectionUI.webElementPublic, "id='webElementPublic'", customSectionUI, "Web Element Public"},
                {customSectionUI.webElementPublicUI, "css='.webElementPublicUI'", customSectionUI, "Web Element Public UI"},
                {customSectionUI.getWebElementPackage(), "id='webElementPackage'", customSectionUI, "Web Element Package"},
                {customSectionUI.getWebElementPrivate(), "id='webElementPrivate'", customSectionUI, "Web Element Private"},
                {customSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", customSectionUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {customSectionUI.listWebElementPublic, "id='listWebElementPublic'", customSectionUI, "List Web Element Public"},
                {customSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", customSectionUI, "List Web Element Public UI"},
                {customSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", customSectionUI, "List Web Element Package"},
                {customSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", customSectionUI, "List Web Element Private"},
                {customSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", customSectionUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIUIElementDataProvider() {
        return new Object[][]{
                {customSectionUI.uielementPublic, "id='uielementPublic'", customSectionUI, "Uielement Public"},
                {customSectionUI.uielementPublicUI, "css='.uielementPublicUI'", customSectionUI, "Uielement Public UI"},
                {customSectionUI.getUielementPackage(), "id='uielementPackage'", customSectionUI, "Uielement Package"},
                {customSectionUI.getUielementPrivate(), "id='uielementPrivate'", customSectionUI, "Uielement Private"},
                {customSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", customSectionUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIButtonDataProvider() {
        return new Object[][]{
                {customSectionUI.getButtonPackage(), "id='buttonPackage'", customSectionUI, "Button Package"},
                {customSectionUI.buttonPublic, "id='buttonPublic'", customSectionUI, "Button Public"},
                {customSectionUI.getButtonPrivate(), "id='buttonPrivate'", customSectionUI, "Button Private"},
                {customSectionUI.buttonPublicUI, "css='.buttonPublicUI'", customSectionUI, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIWebListDataProvider() {
        return new Object[][]{
                {customSectionUI.getWebListPackage(), "id='webListPackage'", customSectionUI, "Web List Package"},
                {customSectionUI.webListPublic, "id='webListPublic'", customSectionUI, "Web List Public"},
                {customSectionUI.getWebListPrivate(), "id='webListPrivate'", customSectionUI, "Web List Private"},
                {customSectionUI.getWebListPrivate(), "id='webListPrivate'", customSectionUI, "Web List Private"},
                {customSectionUI.getWebListPackageUI(), "css='.webListPackageUI'", customSectionUI, "Web List Package UI"},
                {customSectionUI.webListPublicUI, "css='.webListPublicUI'", customSectionUI, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {customSectionUI.listUIElementPublic, "id='listUIElementPublic'", customSectionUI, "List UI Element Public"},
                {customSectionUI.getListUIElementPackage(), "id='listUIElementPackage'", customSectionUI, "List UI Element Package"},
                {customSectionUI.getListUIElementPrivate(), "id='listUIElementPrivate'", customSectionUI, "List UI Element Private"},
                {customSectionUI.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", customSectionUI, "List UI Element Package UI"},
                {customSectionUI.listUIElementPublicUI, "css='.listUIElementPublicUI'", customSectionUI, "List UI Element Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListButtonPublicDataProvider() {
        return new Object[][]{
                {customSectionUI.getListButtonPackage(), "id='listButtonPackage'", customSectionUI, "List Button Package"},
                {customSectionUI.listButtonPublic, "id='listButtonPublic'", customSectionUI, "List Button Public"},
                {customSectionUI.getListButtonPrivate(), "id='listButtonPrivate'", customSectionUI, "List Button Private"},
                {customSectionUI.getListButtonPackageUI(), "css='.listButtonPackageUI'", customSectionUI, "List Button Package UI"},
                {customSectionUI.listButtonPublicUI, "css='.listButtonPublicUI'", customSectionUI, "List Button Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIUIListQuestionDataProvider() {
        return new Object[][]{
                {customSectionUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", customSectionUI, "Uilist Question Package"},
                {customSectionUI.uilistQuestionPublic, "id='uilistQuestionPublic'", customSectionUI, "Uilist Question Public"},
                {customSectionUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", customSectionUI, "Uilist Question Private"},
                {customSectionUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", customSectionUI, "Uilist Question Package UI"},
                {customSectionUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", customSectionUI, "Uilist Question Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {customSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", customSectionUI, "Uilist Somedata Package"},
                {customSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", customSectionUI, "Uilist Somedata Public"},
                {customSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", customSectionUI, "Uilist Somedata Private"},
                {customSectionUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", customSectionUI, "Uilist Somedata Package UI"},
                {customSectionUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", customSectionUI, "Uilist Somedata Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIDropDownDataProvider() {
        return new Object[][]{
                {customSectionUI.getDroplistPackage(), "css='div[ui=droplistPackage'", customSectionUI, "Droplist Package"},
                {customSectionUI.droplistPublic, "css='div[ui=droplistPublic'", customSectionUI, "Droplist Public"},
                {customSectionUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", customSectionUI, "Droplist Private"},
                {customSectionUI.getDroplistPackageUI(), "css='.droplistPackageUI'", customSectionUI, "Droplist Package UI"},
                {customSectionUI.droplistPublicUI, "css='.droplistPublicUI'", customSectionUI, "Droplist Public UI"},
        };
    }
}
