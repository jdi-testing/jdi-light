package pseudo.site.dataproviders.webpage;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.customWebPageUI;

public class CustomWebPageUIDataProvider {
    @DataProvider
    public Object[][] customWebPageUIWebElementDataProvider() {
        return new Object[][]{
                {customWebPageUI.webElementPublic, "id='webElementPublic'", customWebPageUI, "Web Element Public"},
                {customWebPageUI.webElementPublicUI, "css='.webElementPublicUI'", customWebPageUI, "Web Element Public UI"},
                {customWebPageUI.webElementPublicXPath, "xpath='//*[@class='webElementPublicXPath']'", customWebPageUI, "Web Element Public X Path"},
                {customWebPageUI.getWebElementPackage(), "id='webElementPackage'", customWebPageUI, "Web Element Package"},
                {customWebPageUI.getWebElementPrivate(), "id='webElementPrivate'", customWebPageUI, "Web Element Private"},
                {customWebPageUI.getWebElementPackageUI(), "css='.webElementPackageUI'", customWebPageUI, "Web Element Package UI"},
                {customWebPageUI.getWebElementPackageCss(), "css='.webElementPackageCss'", customWebPageUI, "Web Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customWebPageUIListWebElementDataProvider() {
        return new Object[][]{
                {customWebPageUI.listWebElementPublic, "id='listWebElementPublic'", customWebPageUI, "List Web Element Public"},
                {customWebPageUI.listWebElementPublicUI, "css='.listWebElementPublicUI'", customWebPageUI, "List Web Element Public UI"},
                {customWebPageUI.listWebElementPublicXPath, "xpath='//*[@class='listWebElementPublicXPath']'", customWebPageUI, "List Web Element Public X Path"},
                {customWebPageUI.getListWebElementPackage(), "id='listWebElementPackage'", customWebPageUI, "List Web Element Package"},
                {customWebPageUI.getListWebElementPrivate(), "id='listWebElementPrivate'", customWebPageUI, "List Web Element Private"},
                {customWebPageUI.getListWebElementPackageUI(), "css='.listWebElementPackageUI'", customWebPageUI, "List Web Element Package UI"},
                {customWebPageUI.getListWebElementPackageCss(), "css='.listWebElementPackageCss'", customWebPageUI, "List Web Element Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIUIElementDataProvider() {
        return new Object[][]{
                {customWebPageUI.uielementPublic, "id='uielementPublic'", customWebPageUI, "Uielement Public"},
                {customWebPageUI.uielementPublicUI, "css='.uielementPublicUI'", customWebPageUI, "Uielement Public UI"},
                {customWebPageUI.uielementPublicXPath, "xpath='//*[@class='uielementPublicXPath']'", customWebPageUI, "Uielement Public X Path"},
                {customWebPageUI.getUielementPackage(), "id='uielementPackage'", customWebPageUI, "Uielement Package"},
                {customWebPageUI.getUielementPrivate(), "id='uielementPrivate'", customWebPageUI, "Uielement Private"},
                {customWebPageUI.getUielementPackageUI(), "css='.uielementPackageUI'", customWebPageUI, "Uielement Package UI"},
                {customWebPageUI.getUielementPackageCss(), "css='.uielementPackageCss'", customWebPageUI, "Uielement Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIButtonDataProvider() {
        return new Object[][]{
                {customWebPageUI.buttonPublic, "id='buttonPublic'", customWebPageUI, "Button Public"},
                {customWebPageUI.buttonPublicUI, "css='.buttonPublicUI'", customWebPageUI, "Button Public UI"},
                {customWebPageUI.buttonPublicXPath, "xpath='//*[@class='buttonPublicXPath']'", customWebPageUI, "Button Public X Path"},
                {customWebPageUI.getButtonPackage(), "id='buttonPackage'", customWebPageUI, "Button Package"},
                {customWebPageUI.getButtonPrivate(), "id='buttonPrivate'", customWebPageUI, "Button Private"},
                {customWebPageUI.getButtonPackageUI(), "css='.buttonPackageUI'", customWebPageUI, "Button Package UI"},
                {customWebPageUI.getButtonPackageCss(), "css='.buttonPackageCss'", customWebPageUI, "Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIWebListDataProvider() {
        return new Object[][]{
                {customWebPageUI.webListPublic, "id='webListPublic'", customWebPageUI, "Web List Public"},
                {customWebPageUI.webListPublicUI, "css='.webListPublicUI'", customWebPageUI, "Web List Public UI"},
                {customWebPageUI.webListPublicXPath, "xpath='//*[@class='webListPublicXPath']'", customWebPageUI, "Web List Public X Path"},
                {customWebPageUI.getWebListPackage(), "id='webListPackage'", customWebPageUI, "Web List Package"},
                {customWebPageUI.getWebListPrivate(), "id='webListPrivate'", customWebPageUI, "Web List Private"},
                {customWebPageUI.getWebListPackageUI(), "css='.webListPackageUI'", customWebPageUI, "Web List Package UI"},
                {customWebPageUI.getWebListPackageCss(), "css='.webListPackageCss'", customWebPageUI, "Web List Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIListUIElementPublicDataProvider() {
        return new Object[][]{
                {customWebPageUI.listUIElementPublic, "id='listUIElementPublic'", customWebPageUI, "List UI Element Public"},
                {customWebPageUI.listUIElementPublicUI, "css='.listUIElementPublicUI'", customWebPageUI, "List UI Element Public UI"},
                {customWebPageUI.listUIElementPublicXPath, "xpath='//*[@class='listUIElementPublicXPath']'", customWebPageUI, "List UI Element Public X Path"},
                {customWebPageUI.getListUIElementPackage(), "id='listUIElementPackage'", customWebPageUI, "List UI Element Package"},
                {customWebPageUI.getListUIElementPrivate(), "id='listUIElementPrivate'", customWebPageUI, "List UI Element Private"},
                {customWebPageUI.getListUIElementPackageUI(), "css='.listUIElementPackageUI'", customWebPageUI, "List UI Element Package UI"},
                {customWebPageUI.getListUIElementPackageCss(), "css='.listUIElementPackageCss'", customWebPageUI, "List UI Element Package Css"},
        };
    }


    @DataProvider
    public Object[][] customWebPageUIListButtonPublicDataProvider() {
        return new Object[][]{
                {customWebPageUI.listButtonPublic, "id='listButtonPublic'", customWebPageUI, "List Button Public"},
                {customWebPageUI.listButtonPublicUI, "css='.listButtonPublicUI'", customWebPageUI, "List Button Public UI"},
                {customWebPageUI.listButtonPublicXPath, "xpath='//*[@class='listButtonPublicXPath']'", customWebPageUI, "List Button Public X Path"},
                {customWebPageUI.getListButtonPackage(), "id='listButtonPackage'", customWebPageUI, "List Button Package"},
                {customWebPageUI.getListButtonPrivate(), "id='listButtonPrivate'", customWebPageUI, "List Button Private"},
                {customWebPageUI.getListButtonPackageUI(), "css='.listButtonPackageUI'", customWebPageUI, "List Button Package UI"},
                {customWebPageUI.getListButtonPackageCss(), "css='.listButtonPackageCss'", customWebPageUI, "List Button Package Css"},
        };
    }

    @DataProvider
    public Object[][] customWebPageUIDropDownDataProvider() {
        return new Object[][]{
                {customWebPageUI.getDroplistPackage(), "css='div[ui=droplistPackage'", customWebPageUI, "Droplist Package"},
                {customWebPageUI.droplistPublic, "css='div[ui=droplistPublic'", customWebPageUI, "Droplist Public"},
                {customWebPageUI.getDroplistPrivate(), "css='div[ui=droplistPrivate'", customWebPageUI, "Droplist Private"},
                {customWebPageUI.getDroplistPackageUI(), "css='.droplistPackageUI'", customWebPageUI, "Droplist Package UI"},
                {customWebPageUI.droplistPublicUI, "css='.droplistPublicUI'", customWebPageUI, "Droplist Public UI"},
        };
    }
}
