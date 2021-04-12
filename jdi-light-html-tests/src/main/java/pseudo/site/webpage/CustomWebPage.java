package pseudo.site.webpage;

import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import pseudo.site.section.CustomSection;
import pseudo.site.section.SomeData;

import java.util.List;

public class CustomWebPage extends WebPage {
    @FindBy(id = "webElementPackage")
    WebElement webElementPackage;
    @FindBy(id = "webElementPublic")
    public WebElement webElementPublic;
    @FindBy(id = "webElementPrivate")
    private WebElement webElementPrivate;
    @UI(".webElementPackageUI")
    WebElement webElementPackageUI;
    @UI(".webElementPublicUI")
    public WebElement webElementPublicUI;
    @Css(".webElementPackageCss")
    WebElement webElementPackageCss;
    @XPath("//*[@class='webElementPublicXPath']")
    public WebElement webElementPublicXPath;

    @FindBy(id = "listWebElementPackage")
    List<WebElement> listWebElementPackage;
    @FindBy(id = "listWebElementPublic")
    public List<WebElement> listWebElementPublic;
    @FindBy(id = "listWebElementPrivate")
    private List<WebElement> listWebElementPrivate;
    @UI(".listWebElementPackageUI")
    List<WebElement> listWebElementPackageUI;
    @UI(".listWebElementPublicUI")
    public List<WebElement> listWebElementPublicUI;
    @Css(".listWebElementPackageCss")
    List<WebElement> listWebElementPackageCss;
    @XPath("//*[@class='listWebElementPublicXPath']")
    public List<WebElement> listWebElementPublicXPath;

    @FindBy(id = "uielementPackage")
    uiElement uielementPackage;
    @FindBy(id = "uielementPublic")
    public uiElement uielementPublic;
    @FindBy(id = "uielementPrivate")
    private uiElement uielementPrivate;
    @UI(".uielementPackageUI")
    uiElement uielementPackageUI;
    @UI(".uielementPublicUI")
    public uiElement uielementPublicUI;
    @Css(".uielementPackageCss")
    uiElement uielementPackageCss;
    @XPath("//*[@class='uielementPublicXPath']")
    public uiElement uielementPublicXPath;

    @FindBy(id = "buttonPackage")
    Button buttonPackage;
    @FindBy(id = "buttonPublic")
    public Button buttonPublic;
    @FindBy(id = "buttonPrivate")
    private Button buttonPrivate;
    @UI(".buttonPackageUI")
    Button buttonPackageUI;
    @UI(".buttonPublicUI")
    public Button buttonPublicUI;
    @Css(".buttonPackageCss")
    uiElement buttonPackageCss;
    @XPath("//*[@class='buttonPublicXPath']")
    public uiElement buttonPublicXPath;

    @FindBy(id = "listUIElementPackage")
    List<uiElement> listUIElementPackage;
    @FindBy(id = "listUIElementPublic")
    public List<uiElement> listUIElementPublic;
    @FindBy(id = "listUIElementPrivate")
    private List<uiElement> listUIElementPrivate;
    @UI(".listUIElementPackageUI")
    List<uiElement> listUIElementPackageUI;
    @UI(".listUIElementPublicUI")
    public List<uiElement> listUIElementPublicUI;
    @Css(".listUIElementPackageCss")
    List<uiElement> listUIElementPackageCss;
    @XPath("//*[@class='listUIElementPublicXPath']")
    public List<uiElement> listUIElementPublicXPath;

    @FindBy(id = "listButtonPackage")
    List<Button> listButtonPackage;
    @FindBy(id = "listButtonPublic")
    public List<Button> listButtonPublic;
    @FindBy(id = "listButtonPrivate")
    private List<Button> listButtonPrivate;
    @UI(".listButtonPackageUI")
    List<Button> listButtonPackageUI;
    @UI(".listButtonPublicUI")
    public List<Button> listButtonPublicUI;
    @Css(".listButtonPackageCss")
    List<Button> listButtonPackageCss;
    @XPath("//*[@class='listButtonPublicXPath']")
    public List<Button> listButtonPublicXPath;

    @FindBy(id = "webListPackage")
    webList webListPackage;
    @FindBy(id = "webListPublic")
    public webList webListPublic;
    @FindBy(id = "webListPrivate")
    private webList webListPrivate;
    @UI(".webListPackageUI")
    webList webListPackageUI;
    @UI(".webListPublicUI")
    public webList webListPublicUI;
    @Css(".webListPackageCss")
    webList webListPackageCss;
    @XPath("//*[@class='webListPublicXPath']")
    public webList webListPublicXPath;

    @FindBy(id = "uilistQuestionPackage")
    DataList<CustomSection, ?> uilistQuestionPackage;
    @FindBy(id = "uilistQuestionPublic")
    public DataList<CustomSection, ?> uilistQuestionPublic;
    @FindBy(id = "uilistQuestionPrivate")
    private DataList<CustomSection, ?> uilistQuestionPrivate;
    @UI(".uilistQuestionPackageUI")
    DataList<CustomSection, ?> uilistQuestionPackageUI;
    @UI(".uilistQuestionPublicUI")
    public DataList<CustomSection, ?> uilistQuestionPublicUI;
    @Css(".uilistQuestionPackageCss")
    DataList<CustomSection, ?> uilistQuestionPackageCss;
    @XPath("//*[@class='uilistQuestionPublicXPath']")
    public DataList<CustomSection, ?> uilistQuestionPublicXPath;

    @FindBy(id = "uilistSomedataPackage")
    DataList<CustomSection, SomeData> uilistSomedataPackage;
    @FindBy(id = "uilistSomedataPublic")
    public DataList<CustomSection, SomeData> uilistSomedataPublic;
    @FindBy(id = "uilistSomedataPrivate")
    private DataList<CustomSection, SomeData> uilistSomedataPrivate;
    @UI(".uilistSomedataPackageUI")
    DataList<CustomSection, SomeData> uilistSomedataPackageUI;
    @UI(".uilistSomedataPublicUI")
    public DataList<CustomSection, SomeData> uilistSomedataPublicUI;
    @Css(".uilistSomedataPackageCss")
    DataList<CustomSection, SomeData> uilistSomedataPackageCss;
    @XPath("//*[@class='uilistSomedataPublicXPath']")
    public DataList<CustomSection, SomeData> uilistSomedataPublicXPath;

    @JDropdown(root = "div[ui=droplistPackage", value = "input", list = "li", expand = ".expand")
    DropdownExpand droplistPackage;
    @JDropdown(root = "div[ui=droplistPublic", value = "input", list = "li", expand = ".expand")
    public DropdownExpand droplistPublic;
    @JDropdown(root = "div[ui=droplistPrivate", value = "input", list = "li", expand = ".expand")
    private DropdownExpand droplistPrivate;
    @UI(".droplistPackageUI")
    DropdownExpand droplistPackageUI;
    @UI(".droplistPublicUI")
    public DropdownExpand droplistPublicUI;

    public WebElement getWebElementPackage() {
        return webElementPackage;
    }

    public void setWebElementPackage(WebElement webElementPackage) {
        this.webElementPackage = webElementPackage;
    }

    public WebElement getWebElementPrivate() {
        return webElementPrivate;
    }

    public void setWebElementPrivate(WebElement webElementPrivate) {
        this.webElementPrivate = webElementPrivate;
    }

    public WebElement getWebElementPackageUI() {
        return webElementPackageUI;
    }

    public void setWebElementPackageUI(WebElement webElementPackageUI) {
        this.webElementPackageUI = webElementPackageUI;
    }

    public List<WebElement> getListWebElementPackage() {
        return listWebElementPackage;
    }

    public void setListWebElementPackage(List<WebElement> listWebElementPackage) {
        this.listWebElementPackage = listWebElementPackage;
    }

    public List<WebElement> getListWebElementPrivate() {
        return listWebElementPrivate;
    }

    public void setListWebElementPrivate(List<WebElement> listWebElementPrivate) {
        this.listWebElementPrivate = listWebElementPrivate;
    }


    public List<WebElement> getListWebElementPackageUI() {
        return listWebElementPackageUI;
    }

    public void setListWebElementPackageUI(List<WebElement> listWebElementPackageUI) {
        this.listWebElementPackageUI = listWebElementPackageUI;
    }

    public uiElement getUielementPackage() {
        return uielementPackage;
    }

    public void setUielementPackage(uiElement uielementPackage) {
        this.uielementPackage = uielementPackage;
    }

    public uiElement getUielementPrivate() {
        return uielementPrivate;
    }

    public void setUielementPrivate(uiElement uielementPrivate) {
        this.uielementPrivate = uielementPrivate;
    }


    public uiElement getUielementPackageUI() {
        return uielementPackageUI;
    }

    public void setUielementPackageUI(uiElement uielementPackageUI) {
        this.uielementPackageUI = uielementPackageUI;
    }

    public Button getButtonPackage() {
        return buttonPackage;
    }

    public void setButtonPackage(Button buttonPackage) {
        this.buttonPackage = buttonPackage;
    }

    public Button getButtonPrivate() {
        return buttonPrivate;
    }

    public void setButtonPrivate(Button buttonPrivate) {
        this.buttonPrivate = buttonPrivate;
    }

    public Button getButtonPackageUI() {
        return buttonPackageUI;
    }

    public void setButtonPackageUI(Button buttonPackageUI) {
        this.buttonPackageUI = buttonPackageUI;
    }

    public List<uiElement> getListUIElementPackage() {
        return listUIElementPackage;
    }

    public void setListUIElementPackage(List<uiElement> listUIElementPackage) {
        this.listUIElementPackage = listUIElementPackage;
    }

    public List<uiElement> getListUIElementPrivate() {
        return listUIElementPrivate;
    }

    public void setListUIElementPrivate(List<uiElement> listUIElementPrivate) {
        this.listUIElementPrivate = listUIElementPrivate;
    }

    public List<uiElement> getListUIElementPackageUI() {
        return listUIElementPackageUI;
    }

    public void setListUIElementPackageUI(List<uiElement> listUIElementPackageUI) {
        this.listUIElementPackageUI = listUIElementPackageUI;
    }

    public List<Button> getListButtonPackage() {
        return listButtonPackage;
    }

    public void setListButtonPackage(List<Button> listButtonPackage) {
        this.listButtonPackage = listButtonPackage;
    }

    public List<Button> getListButtonPrivate() {
        return listButtonPrivate;
    }

    public void setListButtonPrivate(List<Button> listButtonPrivate) {
        this.listButtonPrivate = listButtonPrivate;
    }

    public List<Button> getListButtonPackageUI() {
        return listButtonPackageUI;
    }

    public void setListButtonPackageUI(List<Button> listButtonPackageUI) {
        this.listButtonPackageUI = listButtonPackageUI;
    }

    public webList getWebListPackage() {
        return webListPackage;
    }

    public void setWebListPackage(webList webListPackage) {
        this.webListPackage = webListPackage;
    }

    public webList getWebListPrivate() {
        return webListPrivate;
    }

    public void setWebListPrivate(webList webListPrivate) {
        this.webListPrivate = webListPrivate;
    }


    public webList getWebListPackageUI() {
        return webListPackageUI;
    }

    public void setWebListPackageUI(webList webListPackageUI) {
        this.webListPackageUI = webListPackageUI;
    }

    public DataList<CustomSection, ?> getUilistQuestionPackage() {
        return uilistQuestionPackage;
    }

    public void setUilistQuestionPackage(DataList<CustomSection, ?> uilistQuestionPackage) {
        this.uilistQuestionPackage = uilistQuestionPackage;
    }

    public DataList<CustomSection, ?> getUilistQuestionPrivate() {
        return uilistQuestionPrivate;
    }

    public void setUilistQuestionPrivate(DataList<CustomSection, ?> uilistQuestionPrivate) {
        this.uilistQuestionPrivate = uilistQuestionPrivate;
    }

    public DataList<CustomSection, ?> getUilistQuestionPackageUI() {
        return uilistQuestionPackageUI;
    }

    public void setUilistQuestionPackageUI(DataList<CustomSection, ?> uilistQuestionPackageUI) {
        this.uilistQuestionPackageUI = uilistQuestionPackageUI;
    }

    public DataList<CustomSection, SomeData> getUilistSomedataPackage() {
        return uilistSomedataPackage;
    }

    public void setUilistSomedataPackage(DataList<CustomSection, SomeData> uilistSomedataPackage) {
        this.uilistSomedataPackage = uilistSomedataPackage;
    }

    public DataList<CustomSection, SomeData> getUilistSomedataPrivate() {
        return uilistSomedataPrivate;
    }

    public void setUilistSomedataPrivate(DataList<CustomSection, SomeData> uilistSomedataPrivate) {
        this.uilistSomedataPrivate = uilistSomedataPrivate;
    }

    public DataList<CustomSection, SomeData> getUilistSomedataPackageUI() {
        return uilistSomedataPackageUI;
    }

    public void setUilistSomedataPackageUI(DataList<CustomSection, SomeData> uilistSomedataPackageUI) {
        this.uilistSomedataPackageUI = uilistSomedataPackageUI;
    }

    public DropdownExpand getDropdownPackage() {
        return droplistPackage;
    }

    public void setDropdownPackage(DropdownExpand droplistPackage) {
        this.droplistPackage = droplistPackage;
    }

    public DropdownExpand getDropdownPrivate() {
        return droplistPrivate;
    }

    public void setDropdownPrivate(DropdownExpand droplistPrivate) {
        this.droplistPrivate = droplistPrivate;
    }

    public DropdownExpand getDropdownPackageUI() {
        return droplistPackageUI;
    }

    public void setDropdownPackageUI(DropdownExpand droplistPackageUI) {
        this.droplistPackageUI = droplistPackageUI;
    }

    public WebElement getWebElementPackageCss() {
        return webElementPackageCss;
    }

    public List<WebElement> getListWebElementPackageCss() {
        return listWebElementPackageCss;
    }

    public uiElement getUielementPackageCss() {
        return uielementPackageCss;
    }

    public uiElement getButtonPackageCss() {
        return buttonPackageCss;
    }

    public List<uiElement> getListUIElementPackageCss() {
        return listUIElementPackageCss;
    }

    public List<Button> getListButtonPackageCss() {
        return listButtonPackageCss;
    }

    public webList getWebListPackageCss() {
        return webListPackageCss;
    }

    public DataList<CustomSection, ?> getUilistQuestionPackageCss() {
        return uilistQuestionPackageCss;
    }

    public DataList<CustomSection, SomeData> getUilistSomedataPackageCss() {
        return uilistSomedataPackageCss;
    }
}

