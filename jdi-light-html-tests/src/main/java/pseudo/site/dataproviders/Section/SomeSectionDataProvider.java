package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomeSection;

import static pseudo.site.PseudoSite.someSection;

public class SomeSectionDataProvider {
    @DataProvider
    public Object[][] someSectionWebElementDataProvider() {
        return new Object[][]{
                {someSection.webElementPublic, "id='webElementPublic'", someSection, "Web Element Public"},
                {someSection.webElementPublic, "id='webElementPublic'", someSection, "Web Element Public"},
                {someSection.webElementPublicUI, "css='.webElementPublicUI'", someSection, "Web Element Public UI"},
                {someSection.getWebElementPackage(), "id='webElementPackage'", someSection, "Web Element Package"},
                {someSection.getWebElementPrivate(), "id='webElementPrivate'", someSection, "Web Element Private"},
                {someSection.getWebElementPackageUI(), "css='.webElementPackageUI'", someSection, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionListWebElementDataProvider() {
        return new Object[][]{
                {someSection.listWebElementPublic, "id='listWebElementPublic'", someSection, "List Web Element Public"},
                {someSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", someSection, "List Web Element Public UI"},
                {someSection.getListWebElementPackage(), "id='listWebElementPackage'", someSection, "List Web Element Package"},
                {someSection.getListWebElementPrivate(), "id='listWebElementPrivate'", someSection, "List Web Element Private"},
                {someSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", someSection, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIElementDataProvider() {
        return new Object[][]{
                {someSection.uielementPublic, "id='uielementPublic'", someSection, "Uielement Public"},
                {someSection.uielementPublicUI, "css='.uielementPublicUI'", someSection, "Uielement Public UI"},
                {someSection.getUielementPackage(), "id='uielementPackage'", someSection, "Uielement Package"},
                {someSection.getUielementPrivate(), "id='uielementPrivate'", someSection, "Uielement Private"},
                {someSection.getUielementPackageUI(), "css='.uielementPackageUI'", someSection, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionButtonDataProvider() {
        return new Object[][]{
                {someSection.getButtonPackage(), "id='buttonPackage'", someSection, "Button Package"},
                {someSection.buttonPublic, "id='buttonPublic'", someSection, "Button Public"},
                {someSection.getButtonPrivate(), "id='buttonPrivate'", someSection, "Button Private"},
                {someSection.buttonPublicUI, "css='.buttonPublicUI'", someSection, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionWebListDataProvider() {
        return new Object[][]{
                {someSection.getWebListPackage(), "id='webListPackage'", someSection, "Web List Package"},
                {someSection.webListPublic, "id='webListPublic'", someSection, "Web List Public"},
                {someSection.getWebListPrivate(), "id='webListPrivate'", someSection, "Web List Private"},
                {someSection.getWebListPrivate(), "id='webListPrivate'", someSection, "Web List Private"},
                {someSection.getWebListPackageUI(), "css='.webListPackageUI'", someSection, "Web List Package UI"},
                {someSection.webListPublicUI, "css='.webListPublicUI'", someSection, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionListUIElementPublicDataProvider() {
        return new Object[][]{
                {someSection.listUIElementPublic, "id = 'listUIElementPublic'", someSection, "List UIElement Public"},
                {someSection.getListUIElementPackage(), "id = 'listUIElementPackage'", someSection, "List UIElement Package"},
                {someSection.getListUIElementPrivate(), "id = 'listUIElementPrivate'", someSection, "List UIElement Private"},
                {someSection.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", someSection, "List UIElement Package UI"},
                {someSection.listUIElementPublicUI, "css = '.listUIElementPublicUI'", someSection, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionListButtonPublicDataProvider() {
        return new Object[][]{
                {someSection.getListButtonPackage(), "id = 'listButtonPackage'", someSection, "List UIElement Package"},
                {someSection.listButtonPublic, "id = 'listUIElementPublic'", someSection, "List UIElement Public"},
                {someSection.getListButtonPrivate(), "id = 'listButtonPrivate'", someSection, "List UIElement Private"},
                {someSection.getListButtonPackageUI(), "css = '.listButtonPackageUI'", someSection, "List UIElement Package UI"},
                {someSection.listButtonPublicUI, "css = '.listButtonPublicUI'", someSection, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListQuestionDataProvider() {
        return new Object[][]{
                {someSection.getUilistQuestionPackage(), "id='uilistQuestionPackage'", someSection, "Uilist Question Package"},
                {someSection.uilistQuestionPublic, "id='uilistQuestionPublic'", someSection, "Uilist Question Public"},
                {someSection.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", someSection, "Uilist Question Private"},
                {someSection.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", someSection, "Uilist Question Package UI"},
                {someSection.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", someSection, "Uilist Question Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {someSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", someSection, "Uilist Somedata Package"},
                {someSection.uilistSomedataPublic, "id='uilistSomedataPublic'", someSection, "Uilist Somedata Public"},
                {someSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", someSection, "Uilist Somedata Private"},
                {someSection.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", someSection, "Uilist Somedata Package UI"},
                {someSection.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", someSection, "Uilist Somedata Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionDropDownDataProvider() {
        return new Object[][]{
                {someSection.getDroplistPackage(), "css='div[ui=droplistPackage'", someSection, "Droplist Package"},
                {someSection.droplistPublic, "css='div[ui=droplistPublic'", someSection, "Droplist Public"},
                {someSection.getDroplistPrivate(), "css='div[ui=droplistPrivate'", someSection, "Droplist Private"},
                {someSection.getDroplistPackageUI(), "css='.droplistPackageUI'", someSection, "Droplist Package UI"},
                {someSection.droplistPublicUI, "css='.droplistPublicUI'", someSection, "Droplist Public UI"},
        };
    }
}
