package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.SomeSection;

import static pseudo.site.PseudoSite.someSectionUI;

public class SomeSectionUIDataProvider {
    @DataProvider
    public Object[][] someSectionUIWebElementDataProvider() {
        return new Object[][]{
                {someSectionUI.webElementPublic, "id='webElementPublic'", someSectionUI, "Web Element Public"},
                {someSectionUI.webElementPublic, "id='webElementPublic'", someSectionUI, "Web Element Public"},
                {someSectionUI.webElementPublicUI, "css='.webElementPublicUI'", someSectionUI, "Web Element Public UI"},
                {SomeSection.webElementPublicStatic, "id='webElementPublicStatic'", someSectionUI, "Web Element Public Static"},
                {someSectionUI.getWebElementPackage(), "id='webElementPackage'", someSectionUI, "Web Element Package"},
                {someSectionUI.getWebElementPrivate(), "id='webElementPrivate'", someSectionUI, "Web Element Private"},
                {SomeSection.getWebElementPackageStatic(), "id='webElementPackageStatic'", someSectionUI, "Web Element Package Static"},
                {SomeSection.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", someSectionUI, "Web Element Private Static"},
                {someSectionUI.getWebElementPackageUI(), "css='.webElementPackageUI'", someSectionUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListWebElementDataProvider() {
        return new Object[][]{
                {someSectionUI.listWebElementPublic, "id='listWebElementPublic'", someSectionUI, "List Web Element Public"},
                {someSectionUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", someSectionUI, "List Web Element Public UI"},
                {SomeSection.listWebElementPublicStatic, "id='listWebElementPublicStatic'", someSectionUI, "List Web Element Public Static"},
                {someSectionUI.getListWebElementPackage(), "id='listWebElementPackage'", someSectionUI, "List Web Element Package"},
                {someSectionUI.getListWebElementPrivate(), "id='listWebElementPrivate'", someSectionUI, "List Web Element Private"},
                {SomeSection.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", someSectionUI, "List Web Element Package Static"},
                {SomeSection.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", someSectionUI, "List Web Element Private Static"},
                {someSectionUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", someSectionUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIUIElementDataProvider() {
        return new Object[][]{
                {someSectionUI.uielementPublic, "id='uielementPublic'", someSectionUI, "Uielement Public"},
                {someSectionUI.uielementPublicUI, "css='.uielementPublicUI'", someSectionUI, "Uielement Public UI"},
                {SomeSection.uielementPublicStatic, "id='uielementPublicStatic'", someSectionUI, "Uielement Public Static"},
                {someSectionUI.getUielementPackage(), "id='uielementPackage'", someSectionUI, "Uielement Package"},
                {someSectionUI.getUielementPrivate(), "id='uielementPrivate'", someSectionUI, "Uielement Private"},
                {SomeSection.getUielementPackageStatic(), "id='uielementPackageStatic'", someSectionUI, "Uielement Package Static"},
                {SomeSection.getUielementPrivateStatic(), "id='uielementPrivateStatic'", someSectionUI, "Uielement Private Static"},
                {someSectionUI.getUielementPackageUI(), "css='.uielementPackageUI'", someSectionUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIButtonDataProvider() {
        return new Object[][]{
                {someSectionUI.getButtonPackage(), "id='buttonPackage'", someSectionUI, "Button Package"},
                {someSectionUI.buttonPublic, "id='buttonPublic'", someSectionUI, "Button Public"},
                {someSectionUI.getButtonPrivate(), "id='buttonPrivate'", someSectionUI, "Button Private"},
                {SomeSection.getButtonPackageStatic(), "id='buttonPackageStatic'", someSectionUI, "Button Package Static"},
                {SomeSection.buttonPublicStatic, "id='buttonPublicStatic'", someSectionUI, "Button Public Static"},
                {SomeSection.getButtonPrivateStatic(), "id='buttonPrivateStatic'", someSectionUI, "Button Private Static"},
                {someSectionUI.buttonPublicUI, "css='.buttonPublicUI'", someSectionUI, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIWebListDataProvider() {
        return new Object[][]{
                {someSectionUI.getWebListPackage(), "id='webListPackage'", someSectionUI, "Web List Package"},
                {someSectionUI.webListPublic, "id='webListPublic'", someSectionUI, "Web List Public"},
                {someSectionUI.getWebListPrivate(), "id='webListPrivate'", someSectionUI, "Web List Private"},
                {someSectionUI.getWebListPrivate(), "id='webListPrivate'", someSectionUI, "Web List Private"},
                {SomeSection.getWebListPackageStatic(), "id='webListPackageStatic'", someSectionUI, "Web List Package Static"},
                {SomeSection.webListPublicStatic, "id='webListPublicStatic'", someSectionUI, "Web List Public Static"},
                {SomeSection.getWebListPrivateStatic(), "id='webListPrivateStatic'", someSectionUI, "Web List Private Static"},
                {someSectionUI.getWebListPackageUI(), "css='.webListPackageUI'", someSectionUI, "Web List Package UI"},
                {someSectionUI.webListPublicUI, "css='.webListPublicUI'", someSectionUI, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {someSectionUI.listUIElementPublic, "id = 'listUIElementPublic'", someSectionUI, "List UIElement Public"},
                {someSectionUI.getListUIElementPackage(), "id = 'listUIElementPackage'", someSectionUI, "List UIElement Package"},
                {someSectionUI.getListUIElementPrivate(), "id = 'listUIElementPrivate'", someSectionUI, "List UIElement Private"},
                {SomeSection.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", someSectionUI, "List UIElement Package Static"},
                {SomeSection.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", someSectionUI, "List UIElement Public Static"},
                {SomeSection.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", someSectionUI, "List UIElement Private Static"},
                {someSectionUI.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", someSectionUI, "List UIElement Package UI"},
                {someSectionUI.listUIElementPublicUI, "css = '.listUIElementPublicUI'", someSectionUI, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIListButtonPublicDataProvider() {
        return new Object[][]{
                {someSectionUI.getListButtonPackage(), "id = 'listButtonPackage'", someSectionUI, "List UIElement Package"},
                {someSectionUI.listButtonPublic, "id = 'listUIElementPublic'", someSectionUI, "List UIElement Public"},
                {someSectionUI.getListButtonPrivate(), "id = 'listButtonPrivate'", someSectionUI, "List UIElement Private"},
                {SomeSection.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", someSectionUI, "List UIElement Package Static"},
                {SomeSection.listButtonPublicStatic, "id = 'listButtonPublicStatic'", someSectionUI, "List UIElement Public Static"},
                {SomeSection.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", someSectionUI, "List UIElement Private Static"},
                {someSectionUI.getListButtonPackageUI(), "css = '.listButtonPackageUI'", someSectionUI, "List UIElement Package UI"},
                {someSectionUI.listButtonPublicUI, "css = '.listButtonPublicUI'", someSectionUI, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] someSectionUIUIListQuestionDataProvider() {
        return new Object[][]{
                {someSectionUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", someSectionUI, "Uilist Question Package"},
                {someSectionUI.uilistQuestionPublic, "id='uilistQuestionPublic'", someSectionUI, "Uilist Question Public"},
                {someSectionUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", someSectionUI, "Uilist Question Private"},
                {SomeSection.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", someSectionUI, "Uilist Question Public Static"},
                {SomeSection.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", someSectionUI, "Uilist Question Private Static"},
                {someSectionUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", someSectionUI, "Uilist Question Package UI"},
                {someSectionUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", someSectionUI, "Uilist Question Public UI"},
                {SomeSection.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", someSectionUI, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIUIListSomedataDataProvider() {
        return new Object[][]{
                {someSectionUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", someSectionUI, "Uilist Somedata Package"},
                {someSectionUI.uilistSomedataPublic, "id='uilistSomedataPublic'", someSectionUI, "Uilist Somedata Public"},
                {someSectionUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", someSectionUI, "Uilist Somedata Private"},
                {SomeSection.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", someSectionUI, "Uilist Somedata Public Static"},
                {SomeSection.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", someSectionUI, "Uilist Somedata Private Static"},
                {someSectionUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", someSectionUI, "Uilist Somedata Package UI"},
                {someSectionUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", someSectionUI, "Uilist Somedata Public UI"},
                {SomeSection.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", someSectionUI, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] someSectionUIDropDownDataProvider() {
        return new Object[][]{
                {someSectionUI.getDroplistPackage(), "css='div[ui=droplistPackage'", someSectionUI, "Droplist Package"},
                {someSectionUI.droplistPublic, "css='div[ui=droplistPublic'", someSectionUI, "Droplist Public"},
                {someSectionUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", someSectionUI, "Droplist Private"},
                {SomeSection.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", someSectionUI, "Droplist Package Static"},
                {SomeSection.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", someSectionUI, "Droplist Public Static"},
                {SomeSection.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", someSectionUI, "Droplist Private Static"},
                {someSectionUI.getDroplistPackageUI(), "css='.droplistPackageUI'", someSectionUI, "Droplist Package UI"},
                {someSectionUI.droplistPublicUI, "css='.droplistPublicUI'", someSectionUI, "Droplist Public UI"},
        };
    }
}
