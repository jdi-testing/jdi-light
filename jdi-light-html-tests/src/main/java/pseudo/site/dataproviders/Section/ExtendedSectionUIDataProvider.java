package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.ExtendedSection;

import static pseudo.site.PseudoSite.extendedSectionUI;

public class ExtendedSectionUIDataProvider {
    @DataProvider
    public Object[][] extendedSectionUIWebElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.webElementPublic, "id='webElementPublic'", extendedSectionUI, "Web Element Public"},
                {extendedSectionUI.webElementPublic, "id='webElementPublic'", extendedSectionUI, "Web Element Public"},
                {extendedSectionUI.webElementPublicUI, "css='.webElementPublicUI'", extendedSectionUI, "Web Element Public UI"},
                {ExtendedSection.webElementPublicStatic, "id='webElementPublicStatic'", extendedSectionUI, "Web Element Public Static"},
                {extendedSectionUI.getWebElementPackage(), "id='webElementPackage'", extendedSectionUI, "Web Element Package"},
                {extendedSectionUI.getWebElementPrivate(), "id='webElementPrivate'", extendedSectionUI, "Web Element Private"},
                {ExtendedSection.getWebElementPackageStatic(), "id='webElementPackageStatic'", extendedSectionUI, "Web Element Package Static"},
                {ExtendedSection.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", extendedSectionUI, "Web Element Private Static"},
                {extendedSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedSectionUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.listWebElementPublic, "id='listWebElementPublic'", extendedSectionUI, "List Web Element Public"},
                {extendedSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedSectionUI, "List Web Element Public UI"},
                {ExtendedSection.listWebElementPublicStatic, "id='listWebElementPublicStatic'", extendedSectionUI, "List Web Element Public Static"},
                {extendedSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", extendedSectionUI, "List Web Element Package"},
                {extendedSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedSectionUI, "List Web Element Private"},
                {ExtendedSection.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", extendedSectionUI, "List Web Element Package Static"},
                {ExtendedSection.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", extendedSectionUI, "List Web Element Private Static"},
                {extendedSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedSectionUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.uielementPublic, "id='uielementPublic'", extendedSectionUI, "Uielement Public"},
                {extendedSectionUI.uielementPublicUI, "css='.uielementPublicUI'", extendedSectionUI, "Uielement Public UI"},
                {ExtendedSection.uielementPublicStatic, "id='uielementPublicStatic'", extendedSectionUI, "Uielement Public Static"},
                {extendedSectionUI.getUielementPackage(), "id='uielementPackage'", extendedSectionUI, "Uielement Package"},
                {extendedSectionUI.getUielementPrivate(), "id='uielementPrivate'", extendedSectionUI, "Uielement Private"},
                {ExtendedSection.getUielementPackageStatic(), "id='uielementPackageStatic'", extendedSectionUI, "Uielement Package Static"},
                {ExtendedSection.getUielementPrivateStatic(), "id='uielementPrivateStatic'", extendedSectionUI, "Uielement Private Static"},
                {extendedSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", extendedSectionUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIButtonDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getButtonPackage(), "id='buttonPackage'", extendedSectionUI, "Button Package"},
                {extendedSectionUI.buttonPublic, "id='buttonPublic'", extendedSectionUI, "Button Public"},
                {extendedSectionUI.getButtonPrivate(), "id='buttonPrivate'", extendedSectionUI, "Button Private"},
                {ExtendedSection.getButtonPackageStatic(), "id='buttonPackageStatic'", extendedSectionUI, "Button Package Static"},
                {ExtendedSection.buttonPublicStatic, "id='buttonPublicStatic'", extendedSectionUI, "Button Public Static"},
                {ExtendedSection.getButtonPrivateStatic(), "id='buttonPrivateStatic'", extendedSectionUI, "Button Private Static"},
                {extendedSectionUI.buttonPublicUI, "css='.buttonPublicUI'", extendedSectionUI, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIWebListDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getWebListPackage(), "id='webListPackage'", extendedSectionUI, "Web List Package"},
                {extendedSectionUI.webListPublic, "id='webListPublic'", extendedSectionUI, "Web List Public"},
                {extendedSectionUI.getWebListPrivate(), "id='webListPrivate'", extendedSectionUI, "Web List Private"},
                {extendedSectionUI.getWebListPrivate(), "id='webListPrivate'", extendedSectionUI, "Web List Private"},
                {ExtendedSection.getWebListPackageStatic(), "id='webListPackageStatic'", extendedSectionUI, "Web List Package Static"},
                {ExtendedSection.webListPublicStatic, "id='webListPublicStatic'", extendedSectionUI, "Web List Public Static"},
                {ExtendedSection.getWebListPrivateStatic(), "id='webListPrivateStatic'", extendedSectionUI, "Web List Private Static"},
                {extendedSectionUI.getWebListPackageUI(), "css='.webListPackageUI'", extendedSectionUI, "Web List Package UI"},
                {extendedSectionUI.webListPublicUI, "css='.webListPublicUI'", extendedSectionUI, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedSectionUI.listUIElementPublic, "id = 'listUIElementPublic'", extendedSectionUI, "List UIElement Public"},
                {extendedSectionUI.getListUIElementPackage(), "id = 'listUIElementPackage'", extendedSectionUI, "List UIElement Package"},
                {extendedSectionUI.getListUIElementPrivate(), "id = 'listUIElementPrivate'", extendedSectionUI, "List UIElement Private"},
                {ExtendedSection.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", extendedSectionUI, "List UIElement Package Static"},
                {ExtendedSection.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", extendedSectionUI, "List UIElement Public Static"},
                {ExtendedSection.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", extendedSectionUI, "List UIElement Private Static"},
                {extendedSectionUI.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", extendedSectionUI, "List UIElement Package UI"},
                {extendedSectionUI.listUIElementPublicUI, "css = '.listUIElementPublicUI'", extendedSectionUI, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getListButtonPackage(), "id = 'listButtonPackage'", extendedSectionUI, "List UIElement Package"},
                {extendedSectionUI.listButtonPublic, "id = 'listUIElementPublic'", extendedSectionUI, "List UIElement Public"},
                {extendedSectionUI.getListButtonPrivate(), "id = 'listButtonPrivate'", extendedSectionUI, "List UIElement Private"},
                {ExtendedSection.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", extendedSectionUI, "List UIElement Package Static"},
                {ExtendedSection.listButtonPublicStatic, "id = 'listButtonPublicStatic'", extendedSectionUI, "List UIElement Public Static"},
                {ExtendedSection.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", extendedSectionUI, "List UIElement Private Static"},
                {extendedSectionUI.getListButtonPackageUI(), "css = '.listButtonPackageUI'", extendedSectionUI, "List UIElement Package UI"},
                {extendedSectionUI.listButtonPublicUI, "css = '.listButtonPublicUI'", extendedSectionUI, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedSectionUI, "Uilist Question Package"},
                {extendedSectionUI.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedSectionUI, "Uilist Question Public"},
                {extendedSectionUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedSectionUI, "Uilist Question Private"},
                {ExtendedSection.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", extendedSectionUI, "Uilist Question Public Static"},
                {ExtendedSection.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", extendedSectionUI, "Uilist Question Private Static"},
                {extendedSectionUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedSectionUI, "Uilist Question Package UI"},
                {extendedSectionUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedSectionUI, "Uilist Question Public UI"},
                {ExtendedSection.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", extendedSectionUI, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedSectionUI, "Uilist Somedata Package"},
                {extendedSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedSectionUI, "Uilist Somedata Public"},
                {extendedSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedSectionUI, "Uilist Somedata Private"},
                {ExtendedSection.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", extendedSectionUI, "Uilist Somedata Public Static"},
                {ExtendedSection.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", extendedSectionUI, "Uilist Somedata Private Static"},
                {extendedSectionUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedSectionUI, "Uilist Somedata Package UI"},
                {extendedSectionUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedSectionUI, "Uilist Somedata Public UI"},
                {ExtendedSection.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", extendedSectionUI, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIDropDownDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedSectionUI, "Droplist Package"},
                {extendedSectionUI.droplistPublic, "css='div[ui=droplistPublic'", extendedSectionUI, "Droplist Public"},
                {extendedSectionUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedSectionUI, "Droplist Private"},
                {ExtendedSection.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", extendedSectionUI, "Droplist Package Static"},
                {ExtendedSection.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", extendedSectionUI, "Droplist Public Static"},
                {ExtendedSection.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", extendedSectionUI, "Droplist Private Static"},
                {extendedSectionUI.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedSectionUI, "Droplist Package UI"},
                {extendedSectionUI.droplistPublicUI, "css='.droplistPublicUI'", extendedSectionUI, "Droplist Public UI"},
        };
    }
}
