package pseudo.site.dataproviders.Section;

import org.testng.annotations.DataProvider;
import pseudo.site.section.ExtendedObject;

import static pseudo.site.PseudoSite.extendedObject;

public class ExtendedObjectDataProvider {
    @DataProvider
    public Object[][] extendedObjectWebElementDataProvider() {
        return new Object[][]{
                {extendedObject.webElementPublic, "id='webElementPublic'", extendedObject, "Web Element Public"},
                {extendedObject.webElementPublic, "id='webElementPublic'", extendedObject, "Web Element Public"},
                {extendedObject.webElementPublicUI, "css='.webElementPublicUI'", extendedObject, "Web Element Public UI"},
                {ExtendedObject.webElementPublicStatic, "id='webElementPublicStatic'", extendedObject, "Web Element Public Static"},
                {extendedObject.getWebElementPackage(), "id='webElementPackage'", extendedObject, "Web Element Package"},
                {extendedObject.getWebElementPrivate(), "id='webElementPrivate'", extendedObject, "Web Element Private"},
                {ExtendedObject.getWebElementPackageStatic(), "id='webElementPackageStatic'", extendedObject, "Web Element Package Static"},
                {ExtendedObject.getWebElementPrivateStatic(), "id='webElementPrivateStatic'", extendedObject, "Web Element Private Static"},
                {extendedObject.getWebElementPackageUI(), "css='.webElementPackageUI'", extendedObject, "Web Element Package UI"},
        };
    }


    @DataProvider
    public Object[][] extendedObjectListWebElementDataProvider() {
        return new Object[][]{
                {extendedObject.listWebElementPublic, "id='listWebElementPublic'", extendedObject, "List Web Element Public"},
                {extendedObject.listWebElementPublicUI, "css='.listWebElementPublicUI'", extendedObject, "List Web Element Public UI"},
                {ExtendedObject.listWebElementPublicStatic, "id='listWebElementPublicStatic'", extendedObject, "List Web Element Public Static"},
                {extendedObject.getListWebElementPackage(), "id='listWebElementPackage'", extendedObject, "List Web Element Package"},
                {extendedObject.getListWebElementPrivate(), "id='listWebElementPrivate'", extendedObject, "List Web Element Private"},
                {ExtendedObject.getListWebElementPackageStatic(), "id='listWebElementPackageStatic'", extendedObject, "List Web Element Package Static"},
                {ExtendedObject.getListWebElementPrivateStatic(), "id='listWebElementPrivateStatic'", extendedObject, "List Web Element Private Static"},
                {extendedObject.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", extendedObject, "List Web Element Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIElementDataProvider() {
        return new Object[][]{
                {extendedObject.uielementPublic, "id='uielementPublic'", extendedObject, "Uielement Public"},
                {extendedObject.uielementPublicUI, "css='.uielementPublicUI'", extendedObject, "Uielement Public UI"},
                {ExtendedObject.uielementPublicStatic, "id='uielementPublicStatic'", extendedObject, "Uielement Public Static"},
                {extendedObject.getUielementPackage(), "id='uielementPackage'", extendedObject, "Uielement Package"},
                {extendedObject.getUielementPrivate(), "id='uielementPrivate'", extendedObject, "Uielement Private"},
                {ExtendedObject.getUielementPackageStatic(), "id='uielementPackageStatic'", extendedObject, "Uielement Package Static"},
                {ExtendedObject.getUielementPrivateStatic(), "id='uielementPrivateStatic'", extendedObject, "Uielement Private Static"},
                {extendedObject.getUielementPackageUI(), "css='.uielementPackageUI'", extendedObject, "Uielement Package UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectButtonDataProvider() {
        return new Object[][]{
                {extendedObject.getButtonPackage(), "id='buttonPackage'", extendedObject, "Button Package"},
                {extendedObject.buttonPublic, "id='buttonPublic'", extendedObject, "Button Public"},
                {extendedObject.getButtonPrivate(), "id='buttonPrivate'", extendedObject, "Button Private"},
                {ExtendedObject.getButtonPackageStatic(), "id='buttonPackageStatic'", extendedObject, "Button Package Static"},
                {ExtendedObject.buttonPublicStatic, "id='buttonPublicStatic'", extendedObject, "Button Public Static"},
                {ExtendedObject.getButtonPrivateStatic(), "id='buttonPrivateStatic'", extendedObject, "Button Private Static"},
                {extendedObject.buttonPublicUI, "css='.buttonPublicUI'", extendedObject, "Button Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectWebListDataProvider() {
        return new Object[][]{
                {extendedObject.getWebListPackage(), "id='webListPackage'", extendedObject, "Web List Package"},
                {extendedObject.webListPublic, "id='webListPublic'", extendedObject, "Web List Public"},
                {extendedObject.getWebListPrivate(), "id='webListPrivate'", extendedObject, "Web List Private"},
                {extendedObject.getWebListPrivate(), "id='webListPrivate'", extendedObject, "Web List Private"},
                {ExtendedObject.getWebListPackageStatic(), "id='webListPackageStatic'", extendedObject, "Web List Package Static"},
                {ExtendedObject.webListPublicStatic, "id='webListPublicStatic'", extendedObject, "Web List Public Static"},
                {ExtendedObject.getWebListPrivateStatic(), "id='webListPrivateStatic'", extendedObject, "Web List Private Static"},
                {extendedObject.getWebListPackageUI(), "css='.webListPackageUI'", extendedObject, "Web List Package UI"},
                {extendedObject.webListPublicUI, "css='.webListPublicUI'", extendedObject, "Web List Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectListUIElementPublicDataProvider() {
        return new Object[][]{
                {extendedObject.listUIElementPublic, "id = 'listUIElementPublic'", extendedObject, "List UIElement Public"},
                {extendedObject.getListUIElementPackage(), "id = 'listUIElementPackage'", extendedObject, "List UIElement Package"},
                {extendedObject.getListUIElementPrivate(), "id = 'listUIElementPrivate'", extendedObject, "List UIElement Private"},
                {ExtendedObject.getListUIElementPackageStatic(), "id = 'listUIElementPackageStatic'", extendedObject, "List UIElement Package Static"},
                {ExtendedObject.listUIElementPublicStatic, "id = 'listUIElementPublicStatic'", extendedObject, "List UIElement Public Static"},
                {ExtendedObject.getListUIElementPrivateStatic(), "id = 'listUIElementPrivateStatic'", extendedObject, "List UIElement Private Static"},
                {extendedObject.getListUIElementPackageUI(), "css = '.listUIElementPackageUI'", extendedObject, "List UIElement Package UI"},
                {extendedObject.listUIElementPublicUI, "css = '.listUIElementPublicUI'", extendedObject, "List UIElement Public UI"},
        };
    }


    @DataProvider
    public Object[][] extendedObjectListButtonPublicDataProvider() {
        return new Object[][]{
                {extendedObject.getListButtonPackage(), "id = 'listButtonPackage'", extendedObject, "List UIElement Package"},
                {extendedObject.listButtonPublic, "id = 'listUIElementPublic'", extendedObject, "List UIElement Public"},
                {extendedObject.getListButtonPrivate(), "id = 'listButtonPrivate'", extendedObject, "List UIElement Private"},
                {ExtendedObject.getListButtonPackageStatic(), "id = 'listButtonPackageStatic'", extendedObject, "List UIElement Package Static"},
                {ExtendedObject.listButtonPublicStatic, "id = 'listButtonPublicStatic'", extendedObject, "List UIElement Public Static"},
                {ExtendedObject.getListButtonPrivateStatic(), "id = 'listButtonPrivateStatic'", extendedObject, "List UIElement Private Static"},
                {extendedObject.getListButtonPackageUI(), "css = '.listButtonPackageUI'", extendedObject, "List UIElement Package UI"},
                {extendedObject.listButtonPublicUI, "css = '.listButtonPublicUI'", extendedObject, "List UIElement Public UI"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIListQuestionDataProvider() {
        return new Object[][]{
                {extendedObject.getUilistQuestionPackage(), "id='uilistQuestionPackage'", extendedObject, "Uilist Question Package"},
                {extendedObject.uilistQuestionPublic, "id='uilistQuestionPublic'", extendedObject, "Uilist Question Public"},
                {extendedObject.getUilistQuestionPrivate(), "id='uilistQuestionPrivate'", extendedObject, "Uilist Question Private"},
                {ExtendedObject.uilistQuestionPublicStatic, "id='uilistQuestionPublicStatic'", extendedObject, "Uilist Question Public Static"},
                {ExtendedObject.getUilistQuestionPrivateStatic(), "id='uilistQuestionPrivateStatic'", extendedObject, "Uilist Question Private Static"},
                {extendedObject.getUilistQuestionPackageUI(), "css='.uilistQuestionPackageUI'", extendedObject, "Uilist Question Package UI"},
                {extendedObject.uilistQuestionPublicUI, "css='.uilistQuestionPublicUI'", extendedObject, "Uilist Question Public UI"},
                {ExtendedObject.getUilistQuestionPackageStatic(), "id='uilistQuestionPackageStatic'", extendedObject, "Uilist Question Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectUIListSomedataDataProvider() {
        return new Object[][]{
                {extendedObject.getUilistSomedataPackage(), "id='uilistSomedataPackage'", extendedObject, "Uilist Somedata Package"},
                {extendedObject.uilistSomedataPublic, "id='uilistSomedataPublic'", extendedObject, "Uilist Somedata Public"},
                {extendedObject.getUilistSomedataPrivate(), "id='uilistSomedataPrivate'", extendedObject, "Uilist Somedata Private"},
                {ExtendedObject.uilistSomedataPublicStatic, "id='uilistSomedataPublicStatic'", extendedObject, "Uilist Somedata Public Static"},
                {ExtendedObject.getUilistSomedataPrivateStatic(), "id='uilistSomedataPrivateStatic'", extendedObject, "Uilist Somedata Private Static"},
                {extendedObject.getUilistSomedataPackageUI(), "css='.uilistSomedataPackageUI'", extendedObject, "Uilist Somedata Package UI"},
                {extendedObject.uilistSomedataPublicUI, "css='.uilistSomedataPublicUI'", extendedObject, "Uilist Somedata Public UI"},
                {ExtendedObject.getUilistSomedataPackageStatic(), "id='uilistSomedataPackageStatic'", extendedObject, "Uilist Somedata Package Static"},
        };
    }

    @DataProvider
    public Object[][] extendedObjectDropDownDataProvider() {
        return new Object[][]{
                {extendedObject.getDroplistPackage(), "css='div[ui=droplistPackage'", extendedObject, "Droplist Package"},
                {extendedObject.droplistPublic, "css='div[ui=droplistPublic'", extendedObject, "Droplist Public"},
                {extendedObject.getDroplistPrivate(), "css='div[ui=droplistPrivate'", extendedObject, "Droplist Private"},
                {ExtendedObject.getDroplistPackageStatic(), "css='div[ui=droplistPackageStatic'", extendedObject, "Droplist Package Static"},
                {ExtendedObject.droplistPublicStatic, "css='div[ui=droplistPublicStatic'", extendedObject, "Droplist Public Static"},
                {ExtendedObject.getDroplistPrivateStatic(), "css='div[ui=droplistPrivateStatic'", extendedObject, "Droplist Private Static"},
                {extendedObject.getDroplistPackageUI(), "css='.droplistPackageUI'", extendedObject, "Droplist Package UI"},
                {extendedObject.droplistPublicUI, "css='.droplistPublicUI'", extendedObject, "Droplist Public UI"},
        };
    }
}
