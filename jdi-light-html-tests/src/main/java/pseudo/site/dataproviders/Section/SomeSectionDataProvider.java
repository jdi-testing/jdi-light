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
                {SomeSection.webElementPublicStatic, "id='webElementPublicStatic'", someSection, "Web Element Public Static"},
                {someSection.getWebElementPackage(), "id='webElementPackage'", someSection, "Web Element Package"},
                {someSection.getWebElementPrivate(), "id='webElementPrivate'", someSection, "Web Element Private"},
                {SomeSection.getWebElementPackageStatic(), "id='webElementPackageStatic'", someSection, "Web Element Package Static"},
                {SomeSection.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", someSection, "Web Element Private Static"},
                {someSection.getWebElementPackageUI(), "css='.webElementPackageUI'", someSection, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionListWebElementDataProvider() {
        return new Object[][]{
                {someSection.listWebElementPublic, "id='listWebElementPublic'", someSection, "List Web Element Public"},
                {someSection.listWebElementPublicUI, "css='.listWebElementPublicUI'", someSection, "List Web Element Public UI"},
                {SomeSection.listWebElementPublicStatic, "id='listWebElementPublicStatic'", someSection, "List Web Element Public Static"},
                {someSection.getListWebElementPackage(), "id='listWebElementPackage'", someSection, "List Web Element Package"},
                {someSection.getListWebElementPrivate(), "id='listWebElementPrivate'", someSection, "List Web Element Private"},
                {SomeSection.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", someSection, "List Web Element Package Static"},
                {SomeSection.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", someSection, "List Web Element Private Static"},
                {someSection.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", someSection, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIElementDataProvider() {
        return new Object[][]{
                {someSection.uielementPublic, "id='uielementPublic'", someSection, "Uielement Public"},
                {someSection.uielementPublicUI, "css='.uielementPublicUI'", someSection, "Uielement Public UI"},
                {SomeSection.uielementPublicStatic, "id='uielementPublicStatic'", someSection, "Uielement Public Static"},
                {someSection.getUielementPackage(), "id='uielementPackage'", someSection, "Uielement Package"},
                {someSection.getUielementPrivate(), "id='uielementPrivate'", someSection, "Uielement Private"},
                {SomeSection.getUielementPackageStatic(), "id='uielementPackageStatic'", someSection, "Uielement Package Static"},
                {SomeSection.getUielementPrivateStatic(), "id='uielementPrivateStatic'", someSection, "Uielement Private Static"},
                {someSection.getUielementPackageUI(), "css='.uielementPackageUI'", someSection, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionButtonDataProvider() {
        return new Object[][]{
                {someSection.getButtonPackage(), "id='buttonPackage'", someSection, "Button Package"},
                {someSection.buttonPublic, "id='buttonPublic'", someSection, "Button Public"},
                {someSection.getButtonPrivate(), "id='buttonPrivate'", someSection, "Button Private"},
                {SomeSection.getButtonPackageStatic(), "id='buttonPackageStatic'", someSection, "Button Package Static"},
                {SomeSection.buttonPublicStatic, "id='buttonPublicStatic'", someSection, "Button Public Static"},
                {SomeSection.getButtonPrivateStatic(), "id='buttonPrivateStatic'", someSection, "Button Private Static"},
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
                {SomeSection.getWebListPackageStatic(), "id='webListPackageStatic'", someSection, "Web List Package Static"},
                {SomeSection.webListPublicStatic, "id='webListPublicStatic'", someSection, "Web List Public Static"},
                {SomeSection.getWebListPrivateStatic(), "id='webListPrivateStatic'", someSection, "Web List Private Static"},
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
                {SomeSection.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", someSection, "List UIElement Package Static"},
                {SomeSection.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", someSection, "List UIElement Public Static"},
                {SomeSection.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", someSection, "List UIElement Private Static"},
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
                {SomeSection.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", someSection, "List UIElement Package Static"},
                {SomeSection.listButtonPublicStatic, "id = 'listButtonPublicStatic'", someSection, "List UIElement Public Static"},
                {SomeSection.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", someSection, "List UIElement Private Static"},
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
                {SomeSection.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", someSection, "Uilist Question Public Static"},
                {SomeSection.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", someSection, "Uilist Question Private Static"},
                {someSection.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", someSection, "Uilist Question Package UI"},
                {someSection.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", someSection, "Uilist Question Public UI"},
                {SomeSection.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", someSection, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIListSomedataDataProvider() {
        return new Object[][]{
                {someSection.getUilistSomedataPackage(), "id='uilistSomedataPackage'", someSection, "Uilist Somedata Package"},
                {someSection.uilistSomedataPublic, "id='uilistSomedataPublic'", someSection, "Uilist Somedata Public"},
                {someSection.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", someSection, "Uilist Somedata Private"},
                {SomeSection.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", someSection, "Uilist Somedata Public Static"},
                {SomeSection.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", someSection, "Uilist Somedata Private Static"},
                {someSection.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", someSection, "Uilist Somedata Package UI"},
                {someSection.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", someSection, "Uilist Somedata Public UI"},
                {SomeSection.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", someSection, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] someSectionDropDownDataProvider() {
        return new Object[][]{
                {someSection.getDroplistPackage(), "css='div[ui=droplistPackage'", someSection, "Droplist Package"},
                {someSection.droplistPublic, "css='div[ui=droplistPublic'", someSection, "Droplist Public"},
                {someSection.getDroplistPrivate(), "css='div[ui=droplistPrivate'", someSection, "Droplist Private"},
                {SomeSection.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", someSection, "Droplist Package Static"},
                {SomeSection.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", someSection, "Droplist Public Static"},
                {SomeSection.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", someSection, "Droplist Private Static"},
                {someSection.getDroplistPackageUI(), "css='.droplistPackageUI'", someSection, "Droplist Package UI"},
                {someSection.droplistPublicUI, "css='.droplistPublicUI'", someSection, "Droplist Public UI"},
        };
    }
}
