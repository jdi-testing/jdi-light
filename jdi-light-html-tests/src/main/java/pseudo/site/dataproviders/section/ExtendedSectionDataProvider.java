package pseudo.site.dataproviders.section;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.extendedSection;

public class ExtendedSectionDataProvider {
    @DataProvider
    public Object[][] extendedSectionWebElementDataProvider() {
        return new Object[][]{
                {extendedSection.webElementPublic, "id='webElementPublic'", extendedSection, "Web Element Public"},
                {extendedSection.webElementPublic, "id='webElementPublic'", extendedSection, "Web Element Public"},
                {extendedSection.webElementPublicUI, "css='.webElementPublicUI'", extendedSection, "Web Element Public UI"},
                {extendedSection.getWebElementPackage(), "id='webElementPackage'", extendedSection, "Web Element Package"},
                {extendedSection.getWebElementPrivate(), "id='webElementPrivate'", extendedSection, "Web Element Private"},
                {extendedSection.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedSection, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionListWebElementDataProvider() {
        return new Object[][]{
                {extendedSection.listWebElementPublic, "id='listWebElementPublic'", extendedSection, "List Web Element Public"},
                {extendedSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedSection, "List Web Element Public UI"},
                {extendedSection.getListWebElementPackage(), "id='listWebElementPackage'", extendedSection, "List Web Element Package"},
                {extendedSection.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedSection, "List Web Element Private"},
                {extendedSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedSection, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIElementDataProvider() {
        return new Object[][]{
                {extendedSection.uielementPublic, "id='uielementPublic'", extendedSection, "Uielement Public"},
                {extendedSection.uielementPublicUI, "css='.uielementPublicUI'", extendedSection, "Uielement Public UI"},
                {extendedSection.getUielementPackage(), "id='uielementPackage'", extendedSection, "Uielement Package"},
                {extendedSection.getUielementPrivate(), "id='uielementPrivate'", extendedSection, "Uielement Private"},
                {extendedSection.getUielementPackageUI(), "css='.uielementPackageUI'", extendedSection, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionButtonDataProvider() {
        return new Object[][]{
                {extendedSection.getButtonPackage(), "id='buttonPackage'", extendedSection, "Button Package"},
                {extendedSection.buttonPublic, "id='buttonPublic'", extendedSection, "Button Public"},
                {extendedSection.getButtonPrivate(), "id='buttonPrivate'", extendedSection, "Button Private"},
                {extendedSection.buttonPublicUI, "css='.buttonPublicUI'", extendedSection, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionWebListDataProvider() {
        return new Object[][]{
                {extendedSection.getWebListPackage(), "id='webListPackage'", extendedSection, "Web List Package"},
                {extendedSection.webListPublic, "id='webListPublic'", extendedSection, "Web List Public"},
                {extendedSection.getWebListPrivate(), "id='webListPrivate'", extendedSection, "Web List Private"},
                {extendedSection.getWebListPrivate(), "id='webListPrivate'", extendedSection, "Web List Private"},
                {extendedSection.getWebListPackageUI(), "css='.webListPackageUI'", extendedSection, "Web List Package UI"},
                {extendedSection.webListPublicUI, "css='.webListPublicUI'", extendedSection, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedSection.listUIElementPublic, "id = 'listUIElementPublic'", extendedSection, "List UIElement Public"},
                {extendedSection.getListUIElementPackage(), "id = 'listUIElementPackage'", extendedSection, "List UIElement Package"},
                {extendedSection.getListUIElementPrivate(), "id = 'listUIElementPrivate'", extendedSection, "List UIElement Private"},
                {extendedSection.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", extendedSection, "List UIElement Package UI"},
                {extendedSection.listUIElementPublicUI, "css = '.listUIElementPublicUI'", extendedSection, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedSection.getListButtonPackage(), "id = 'listButtonPackage'", extendedSection, "List UIElement Package"},
                {extendedSection.listButtonPublic, "id = 'listUIElementPublic'", extendedSection, "List UIElement Public"},
                {extendedSection.getListButtonPrivate(), "id = 'listButtonPrivate'", extendedSection, "List UIElement Private"},
                {extendedSection.getListButtonPackageUI(), "css = '.listButtonPackageUI'", extendedSection, "List UIElement Package UI"},
                {extendedSection.listButtonPublicUI, "css = '.listButtonPublicUI'", extendedSection, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedSection.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedSection, "Uilist Question Package"},
                {extendedSection.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedSection, "Uilist Question Public"},
                {extendedSection.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedSection, "Uilist Question Private"},
                {extendedSection.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedSection, "Uilist Question Package UI"},
                {extendedSection.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedSection, "Uilist Question Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedSection, "Uilist Somedata Package"},
                {extendedSection.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedSection, "Uilist Somedata Public"},
                {extendedSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedSection, "Uilist Somedata Private"},
                {extendedSection.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedSection, "Uilist Somedata Package UI"},
                {extendedSection.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedSection, "Uilist Somedata Public UI"},
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
