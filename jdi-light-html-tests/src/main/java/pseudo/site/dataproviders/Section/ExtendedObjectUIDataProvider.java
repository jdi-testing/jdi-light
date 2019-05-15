package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.ExtendedObject;

import static pseudo.site.PseudoSite.extendedObjectUI;

public class ExtendedObjectUIDataProvider {
    @DataProvider
    public Object[][] extendedObjectUIWebElementDataProvider() {
        return new Object[][]{
                {extendedObjectUI.webElementPublic, "id='webElementPublic'", extendedObjectUI, "Web Element Public"},
                {extendedObjectUI.webElementPublic, "id='webElementPublic'", extendedObjectUI, "Web Element Public"},
                {extendedObjectUI.webElementPublicUI, "css='.webElementPublicUI'", extendedObjectUI, "Web Element Public UI"},
                {ExtendedObject.webElementPublicStatic, "id='webElementPublicStatic'", extendedObjectUI, "Web Element Public Static"},
                {extendedObjectUI.getWebElementPackage(), "id='webElementPackage'", extendedObjectUI, "Web Element Package"},
                {extendedObjectUI.getWebElementPrivate(), "id='webElementPrivate'", extendedObjectUI, "Web Element Private"},
                {ExtendedObject.getWebElementPackageStatic(), "id='webElementPackageStatic'", extendedObjectUI, "Web Element Package Static"},
                {ExtendedObject.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", extendedObjectUI, "Web Element Private Static"},
                {extendedObjectUI.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedObjectUI, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] extendedObjectUIListWebElementDataProvider() {
        return new Object[][]{
                {extendedObjectUI.listWebElementPublic, "id='listWebElementPublic'", extendedObjectUI, "List Web Element Public"},
                {extendedObjectUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedObjectUI, "List Web Element Public UI"},
                {ExtendedObject.listWebElementPublicStatic, "id='listWebElementPublicStatic'", extendedObjectUI, "List Web Element Public Static"},
                {extendedObjectUI.getListWebElementPackage(), "id='listWebElementPackage'", extendedObjectUI, "List Web Element Package"},
                {extendedObjectUI.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedObjectUI, "List Web Element Private"},
                {ExtendedObject.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", extendedObjectUI, "List Web Element Package Static"},
                {ExtendedObject.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", extendedObjectUI, "List Web Element Private Static"},
                {extendedObjectUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedObjectUI, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIUIElementDataProvider() {
        return new Object[][]{
                {extendedObjectUI.uielementPublic, "id='uielementPublic'", extendedObjectUI, "Uielement Public"},
                {extendedObjectUI.uielementPublicUI, "css='.uielementPublicUI'", extendedObjectUI, "Uielement Public UI"},
                {ExtendedObject.uielementPublicStatic, "id='uielementPublicStatic'", extendedObjectUI, "Uielement Public Static"},
                {extendedObjectUI.getUielementPackage(), "id='uielementPackage'", extendedObjectUI, "Uielement Package"},
                {extendedObjectUI.getUielementPrivate(), "id='uielementPrivate'", extendedObjectUI, "Uielement Private"},
                {ExtendedObject.getUielementPackageStatic(), "id='uielementPackageStatic'", extendedObjectUI, "Uielement Package Static"},
                {ExtendedObject.getUielementPrivateStatic(), "id='uielementPrivateStatic'", extendedObjectUI, "Uielement Private Static"},
                {extendedObjectUI.getUielementPackageUI(), "css='.uielementPackageUI'", extendedObjectUI, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIButtonDataProvider() {
        return new Object[][]{
                {extendedObjectUI.getButtonPackage(), "id='buttonPackage'", extendedObjectUI, "Button Package"},
                {extendedObjectUI.buttonPublic, "id='buttonPublic'", extendedObjectUI, "Button Public"},
                {extendedObjectUI.getButtonPrivate(), "id='buttonPrivate'", extendedObjectUI, "Button Private"},
                {ExtendedObject.getButtonPackageStatic(), "id='buttonPackageStatic'", extendedObjectUI, "Button Package Static"},
                {ExtendedObject.buttonPublicStatic, "id='buttonPublicStatic'", extendedObjectUI, "Button Public Static"},
                {ExtendedObject.getButtonPrivateStatic(), "id='buttonPrivateStatic'", extendedObjectUI, "Button Private Static"},
                {extendedObjectUI.buttonPublicUI, "css='.buttonPublicUI'", extendedObjectUI, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIWebListDataProvider() {
        return new Object[][]{
                {extendedObjectUI.getWebListPackage(), "id='webListPackage'", extendedObjectUI, "Web List Package"},
                {extendedObjectUI.webListPublic, "id='webListPublic'", extendedObjectUI, "Web List Public"},
                {extendedObjectUI.getWebListPrivate(), "id='webListPrivate'", extendedObjectUI, "Web List Private"},
                {extendedObjectUI.getWebListPrivate(), "id='webListPrivate'", extendedObjectUI, "Web List Private"},
                {ExtendedObject.getWebListPackageStatic(), "id='webListPackageStatic'", extendedObjectUI, "Web List Package Static"},
                {ExtendedObject.webListPublicStatic, "id='webListPublicStatic'", extendedObjectUI, "Web List Public Static"},
                {ExtendedObject.getWebListPrivateStatic(), "id='webListPrivateStatic'", extendedObjectUI, "Web List Private Static"},
                {extendedObjectUI.getWebListPackageUI(), "css='.webListPackageUI'", extendedObjectUI, "Web List Package UI"},
                {extendedObjectUI.webListPublicUI, "css='.webListPublicUI'", extendedObjectUI, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedObjectUI.listUIElementPublic, "id = 'listUIElementPublic'", extendedObjectUI, "List UIElement Public"},
                {extendedObjectUI.getListUIElementPackage(), "id = 'listUIElementPackage'", extendedObjectUI, "List UIElement Package"},
                {extendedObjectUI.getListUIElementPrivate(), "id = 'listUIElementPrivate'", extendedObjectUI, "List UIElement Private"},
                {ExtendedObject.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", extendedObjectUI, "List UIElement Package Static"},
                {ExtendedObject.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", extendedObjectUI, "List UIElement Public Static"},
                {ExtendedObject.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", extendedObjectUI, "List UIElement Private Static"},
                {extendedObjectUI.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", extendedObjectUI, "List UIElement Package UI"},
                {extendedObjectUI.listUIElementPublicUI, "css = '.listUIElementPublicUI'", extendedObjectUI, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] extendedObjectUIListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedObjectUI.getListButtonPackage(), "id = 'listButtonPackage'", extendedObjectUI, "List UIElement Package"},
                {extendedObjectUI.listButtonPublic, "id = 'listUIElementPublic'", extendedObjectUI, "List UIElement Public"},
                {extendedObjectUI.getListButtonPrivate(), "id = 'listButtonPrivate'", extendedObjectUI, "List UIElement Private"},
                {ExtendedObject.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", extendedObjectUI, "List UIElement Package Static"},
                {ExtendedObject.listButtonPublicStatic, "id = 'listButtonPublicStatic'", extendedObjectUI, "List UIElement Public Static"},
                {ExtendedObject.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", extendedObjectUI, "List UIElement Private Static"},
                {extendedObjectUI.getListButtonPackageUI(), "css = '.listButtonPackageUI'", extendedObjectUI, "List UIElement Package UI"},
                {extendedObjectUI.listButtonPublicUI, "css = '.listButtonPublicUI'", extendedObjectUI, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedObjectUI.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedObjectUI, "Uilist Question Package"},
                {extendedObjectUI.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedObjectUI, "Uilist Question Public"},
                {extendedObjectUI.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedObjectUI, "Uilist Question Private"},
                {ExtendedObject.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", extendedObjectUI, "Uilist Question Public Static"},
                {ExtendedObject.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", extendedObjectUI, "Uilist Question Private Static"},
                {extendedObjectUI.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedObjectUI, "Uilist Question Package UI"},
                {extendedObjectUI.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedObjectUI, "Uilist Question Public UI"},
                {ExtendedObject.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", extendedObjectUI, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedObjectUI.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedObjectUI, "Uilist Somedata Package"},
                {extendedObjectUI.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedObjectUI, "Uilist Somedata Public"},
                {extendedObjectUI.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedObjectUI, "Uilist Somedata Private"},
                {ExtendedObject.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", extendedObjectUI, "Uilist Somedata Public Static"},
                {ExtendedObject.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", extendedObjectUI, "Uilist Somedata Private Static"},
                {extendedObjectUI.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedObjectUI, "Uilist Somedata Package UI"},
                {extendedObjectUI.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedObjectUI, "Uilist Somedata Public UI"},
                {ExtendedObject.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", extendedObjectUI, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIDropDownDataProvider() {
        return new Object[][]{
                {extendedObjectUI.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedObjectUI, "Droplist Package"},
                {extendedObjectUI.droplistPublic, "css='div[ui=droplistPublic'", extendedObjectUI, "Droplist Public"},
                {extendedObjectUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedObjectUI, "Droplist Private"},
                {ExtendedObject.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", extendedObjectUI, "Droplist Package Static"},
                {ExtendedObject.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", extendedObjectUI, "Droplist Public Static"},
                {ExtendedObject.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", extendedObjectUI, "Droplist Private Static"},
                {extendedObjectUI.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedObjectUI, "Droplist Package UI"},
                {extendedObjectUI.droplistPublicUI, "css='.droplistPublicUI'", extendedObjectUI, "Droplist Public UI"},
        };
    }
}
