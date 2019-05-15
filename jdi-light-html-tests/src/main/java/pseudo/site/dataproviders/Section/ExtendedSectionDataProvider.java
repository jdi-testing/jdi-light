package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.ExtendedSection;

import static pseudo.site.PseudoSite.extendedSection;

public class ExtendedSectionDataProvider {
    @DataProvider
    public Object[][] extendedSectionWebElementDataProvider() {
        return new Object[][]{
                {extendedSection.webElementPublic, "id='webElementPublic'", extendedSection, "Web Element Public"},
                {extendedSection.webElementPublic, "id='webElementPublic'", extendedSection, "Web Element Public"},
                {extendedSection.webElementPublicUI, "css='.webElementPublicUI'", extendedSection, "Web Element Public UI"},
                {ExtendedSection.webElementPublicStatic, "id='webElementPublicStatic'", extendedSection, "Web Element Public Static"},
                {extendedSection.getWebElementPackage(), "id='webElementPackage'", extendedSection, "Web Element Package"},
                {extendedSection.getWebElementPrivate(), "id='webElementPrivate'", extendedSection, "Web Element Private"},
                {ExtendedSection.getWebElementPackageStatic(), "id='webElementPackageStatic'", extendedSection, "Web Element Package Static"},
                {ExtendedSection.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", extendedSection, "Web Element Private Static"},
                {extendedSection.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedSection, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionListWebElementDataProvider() {
        return new Object[][]{
                {extendedSection.listWebElementPublic, "id='listWebElementPublic'", extendedSection, "List Web Element Public"},
                {extendedSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedSection, "List Web Element Public UI"},
                {ExtendedSection.listWebElementPublicStatic, "id='listWebElementPublicStatic'", extendedSection, "List Web Element Public Static"},
                {extendedSection.getListWebElementPackage(), "id='listWebElementPackage'", extendedSection, "List Web Element Package"},
                {extendedSection.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedSection, "List Web Element Private"},
                {ExtendedSection.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", extendedSection, "List Web Element Package Static"},
                {ExtendedSection.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", extendedSection, "List Web Element Private Static"},
                {extendedSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedSection, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIElementDataProvider() {
        return new Object[][]{
                {extendedSection.uielementPublic, "id='uielementPublic'", extendedSection, "Uielement Public"},
                {extendedSection.uielementPublicUI, "css='.uielementPublicUI'", extendedSection, "Uielement Public UI"},
                {ExtendedSection.uielementPublicStatic, "id='uielementPublicStatic'", extendedSection, "Uielement Public Static"},
                {extendedSection.getUielementPackage(), "id='uielementPackage'", extendedSection, "Uielement Package"},
                {extendedSection.getUielementPrivate(), "id='uielementPrivate'", extendedSection, "Uielement Private"},
                {ExtendedSection.getUielementPackageStatic(), "id='uielementPackageStatic'", extendedSection, "Uielement Package Static"},
                {ExtendedSection.getUielementPrivateStatic(), "id='uielementPrivateStatic'", extendedSection, "Uielement Private Static"},
                {extendedSection.getUielementPackageUI(), "css='.uielementPackageUI'", extendedSection, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionButtonDataProvider() {
        return new Object[][]{
                {extendedSection.getButtonPackage(), "id='buttonPackage'", extendedSection, "Button Package"},
                {extendedSection.buttonPublic, "id='buttonPublic'", extendedSection, "Button Public"},
                {extendedSection.getButtonPrivate(), "id='buttonPrivate'", extendedSection, "Button Private"},
                {ExtendedSection.getButtonPackageStatic(), "id='buttonPackageStatic'", extendedSection, "Button Package Static"},
                {ExtendedSection.buttonPublicStatic, "id='buttonPublicStatic'", extendedSection, "Button Public Static"},
                {ExtendedSection.getButtonPrivateStatic(), "id='buttonPrivateStatic'", extendedSection, "Button Private Static"},
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
                {ExtendedSection.getWebListPackageStatic(), "id='webListPackageStatic'", extendedSection, "Web List Package Static"},
                {ExtendedSection.webListPublicStatic, "id='webListPublicStatic'", extendedSection, "Web List Public Static"},
                {ExtendedSection.getWebListPrivateStatic(), "id='webListPrivateStatic'", extendedSection, "Web List Private Static"},
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
                {ExtendedSection.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", extendedSection, "List UIElement Package Static"},
                {ExtendedSection.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", extendedSection, "List UIElement Public Static"},
                {ExtendedSection.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", extendedSection, "List UIElement Private Static"},
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
                {ExtendedSection.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", extendedSection, "List UIElement Package Static"},
                {ExtendedSection.listButtonPublicStatic, "id = 'listButtonPublicStatic'", extendedSection, "List UIElement Public Static"},
                {ExtendedSection.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", extendedSection, "List UIElement Private Static"},
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
                {ExtendedSection.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", extendedSection, "Uilist Question Public Static"},
                {ExtendedSection.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", extendedSection, "Uilist Question Private Static"},
                {extendedSection.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedSection, "Uilist Question Package UI"},
                {extendedSection.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedSection, "Uilist Question Public UI"},
                {ExtendedSection.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", extendedSection, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedSection, "Uilist Somedata Package"},
                {extendedSection.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedSection, "Uilist Somedata Public"},
                {extendedSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedSection, "Uilist Somedata Private"},
                {ExtendedSection.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", extendedSection, "Uilist Somedata Public Static"},
                {ExtendedSection.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", extendedSection, "Uilist Somedata Private Static"},
                {extendedSection.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedSection, "Uilist Somedata Package UI"},
                {extendedSection.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedSection, "Uilist Somedata Public UI"},
                {ExtendedSection.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", extendedSection, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionDropDownDataProvider() {
        return new Object[][]{
                {extendedSection.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedSection, "Droplist Package"},
                {extendedSection.droplistPublic, "css='div[ui=droplistPublic'", extendedSection, "Droplist Public"},
                {extendedSection.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedSection, "Droplist Private"},
                {ExtendedSection.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", extendedSection, "Droplist Package Static"},
                {ExtendedSection.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", extendedSection, "Droplist Public Static"},
                {ExtendedSection.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", extendedSection, "Droplist Private Static"},
                {extendedSection.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedSection, "Droplist Package UI"},
                {extendedSection.droplistPublicUI, "css='.droplistPublicUI'", extendedSection, "Droplist Public UI"},
        };
    }
}
