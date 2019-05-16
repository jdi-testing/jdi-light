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
                {extendedSectionUI.getWebElementPackage(), "id='webElementPackage'", extendedSectionUI, "Web Element Package"},
                {extendedSectionUI.getWebElementPrivate(), "id='webElementPrivate'", extendedSectionUI, "Web Element Private"},
                {extendedSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedSectionUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] extendedSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.listWebElementPublic, "id='listWebElementPublic'", extendedSectionUI, "List Web Element Public"},
                {extendedSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedSectionUI, "List Web Element Public UI"},
                {extendedSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", extendedSectionUI, "List Web Element Package"},
                {extendedSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedSectionUI, "List Web Element Private"},
                {extendedSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedSectionUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIElementDataProvider() {
        return new Object[][]{
                {extendedSectionUI.uielementPublic, "id='uielementPublic'", extendedSectionUI, "Uielement Public"},
                {extendedSectionUI.uielementPublicUI, "css='.uielementPublicUI'", extendedSectionUI, "Uielement Public UI"},
                {extendedSectionUI.getUielementPackage(), "id='uielementPackage'", extendedSectionUI, "Uielement Package"},
                {extendedSectionUI.getUielementPrivate(), "id='uielementPrivate'", extendedSectionUI, "Uielement Private"},
                {extendedSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", extendedSectionUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIButtonDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getButtonPackage(), "id='buttonPackage'", extendedSectionUI, "Button Package"},
                {extendedSectionUI.buttonPublic, "id='buttonPublic'", extendedSectionUI, "Button Public"},
                {extendedSectionUI.getButtonPrivate(), "id='buttonPrivate'", extendedSectionUI, "Button Private"},
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
                {extendedSectionUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedSectionUI, "Uilist Question Package UI"},
                {extendedSectionUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedSectionUI, "Uilist Question Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedSectionUI, "Uilist Somedata Package"},
                {extendedSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedSectionUI, "Uilist Somedata Public"},
                {extendedSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedSectionUI, "Uilist Somedata Private"},
                {extendedSectionUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedSectionUI, "Uilist Somedata Package UI"},
                {extendedSectionUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedSectionUI, "Uilist Somedata Public UI"},
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
