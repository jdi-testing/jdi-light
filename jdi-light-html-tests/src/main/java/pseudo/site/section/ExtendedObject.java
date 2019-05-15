package pseudo.site.section;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtendedObject extends SomeObject {
    @FindBy(id = "webElementPackage")
    WebElement webElementPackage;
    @FindBy(id = "webElementPublic")
    public WebElement webElementPublic;
    @FindBy(id = "webElementPrivate")
    private WebElement webElementPrivate;
    @FindBy(id = "webElementPackageStatic")
    static WebElement webElementPackageStatic;
    @FindBy(id = "webElementPublicStatic")
    public static WebElement webElementPublicStatic;
    @FindBy(id = "webElementPrivateStatic")
    private static WebElement webElementPrivateStatic;
    @UI(".webElementPackageUI")
    WebElement webElementPackageUI;
    @UI(".webElementPublicUI")
    public WebElement webElementPublicUI;


    @FindBy(id = "listWebElementPackage")
    List<WebElement> listWebElementPackage;
    @FindBy(id = "listWebElementPublic")
    public List<WebElement> listWebElementPublic;
    @FindBy(id = "listWebElementPrivate")
    private List<WebElement> listWebElementPrivate;
    @FindBy(id = "listWebElementPackageStatic")
    static List<WebElement> listWebElementPackageStatic;
    @FindBy(id = "listWebElementPublicStatic")
    public static List<WebElement> listWebElementPublicStatic;
    @FindBy(id = "listWebElementPrivateStatic")
    private static List<WebElement> listWebElementPrivateStatic;
    @UI(".listWebElementPackageUI")
    List<WebElement> listWebElementPackageUI;
    @UI(".listWebElementPublicUI")
    public List<WebElement> listWebElementPublicUI;


    @FindBy(id = "uielementPackage")
    UIElement uielementPackage;
    @FindBy(id = "uielementPublic")
    public UIElement uielementPublic;
    @FindBy(id = "uielementPrivate")
    private UIElement uielementPrivate;
    @FindBy(id = "uielementPackageStatic")
    static UIElement uielementPackageStatic;
    @FindBy(id = "uielementPublicStatic")
    public static UIElement uielementPublicStatic;
    @FindBy(id = "uielementPrivateStatic")
    private static UIElement uielementPrivateStatic;
    @UI(".uielementPackageUI")
    UIElement uielementPackageUI;
    @UI(".uielementPublicUI")
    public UIElement uielementPublicUI;


    @FindBy(id = "buttonPackage")
    Button buttonPackage;
    @FindBy(id = "buttonPublic")
    public Button buttonPublic;
    @FindBy(id = "buttonPrivate")
    private Button buttonPrivate;
    @FindBy(id = "buttonPackageStatic")
    static Button buttonPackageStatic;
    @FindBy(id = "buttonPublicStatic")
    public static Button buttonPublicStatic;
    @FindBy(id = "buttonPrivateStatic")
    private static Button buttonPrivateStatic;
    @UI(".buttonPackageUI")
    Button buttonPackageUI;
    @UI(".buttonPublicUI")
    public Button buttonPublicUI;


    @FindBy(id = "listUIElementPackage")
    List<UIElement> listUIElementPackage;
    @FindBy(id = "listUIElementPublic")
    public List<UIElement> listUIElementPublic;
    @FindBy(id = "listUIElementPrivate")
    private List<UIElement> listUIElementPrivate;
    @FindBy(id = "listUIElementPackageStatic")
    static List<UIElement> listUIElementPackageStatic;
    @FindBy(id = "listUIElementPublicStatic")
    public static List<UIElement> listUIElementPublicStatic;
    @FindBy(id = "listUIElementPrivateStatic")
    private static List<UIElement> listUIElementPrivateStatic;
    @UI(".listUIElementPackageUI")
    List<UIElement> listUIElementPackageUI;
    @UI(".listUIElementPublicUI")
    public List<UIElement> listUIElementPublicUI;

    @FindBy(id = "listButtonPackage")
    List<Button> listButtonPackage;
    @FindBy(id = "listButtonPublic")
    public List<Button> listButtonPublic;
    @FindBy(id = "listButtonPrivate")
    private List<Button> listButtonPrivate;
    @FindBy(id = "listButtonPackageStatic")
    static List<Button> listButtonPackageStatic;
    @FindBy(id = "listButtonPublicStatic")
    public static List<Button> listButtonPublicStatic;
    @FindBy(id = "listButtonPrivateStatic")
    private static List<Button> listButtonPrivateStatic;
    @UI(".listButtonPackageUI")
    List<Button> listButtonPackageUI;
    @UI(".listButtonPublicUI")
    public List<Button> listButtonPublicUI;

    @FindBy(id = "webListPackage")
    WebList webListPackage;
    @FindBy(id = "webListPublic")
    public WebList webListPublic;
    @FindBy(id = "webListPrivate")
    private WebList webListPrivate;
    @FindBy(id = "webListPackageStatic")
    static WebList webListPackageStatic;
    @FindBy(id = "webListPublicStatic")
    public static WebList webListPublicStatic;
    @FindBy(id = "webListPrivateStatic")
    private static WebList webListPrivateStatic;
    @UI(".webListPackageUI")
    WebList webListPackageUI;
    @UI(".webListPublicUI")
    public WebList webListPublicUI;


    @FindBy(id = "uilistQuestionPackage")
    UIList<SomeSection, ?> uilistQuestionPackage;
    @FindBy(id = "uilistQuestionPublic")
    public UIList<SomeSection, ?> uilistQuestionPublic;
    @FindBy(id = "uilistQuestionPrivate")
    private UIList<SomeSection, ?> uilistQuestionPrivate;
    @FindBy(id = "uilistQuestionPackageStatic")
    static UIList<SomeSection, ?> uilistQuestionPackageStatic;
    @FindBy(id = "uilistQuestionPublicStatic")
    public static UIList<SomeSection, ?> uilistQuestionPublicStatic;
    @FindBy(id = "uilistQuestionPrivateStatic")
    private static UIList<SomeSection, ?> uilistQuestionPrivateStatic;
    @UI(".uilistQuestionPackageUI")
    UIList<SomeSection, ?> uilistQuestionPackageUI;
    @UI(".uilistQuestionPublicUI")
    public UIList<SomeSection, ?> uilistQuestionPublicUI;


    @FindBy(id = "uilistSomedataPackage")
    UIList<SomeSection, SomeData> uilistSomedataPackage;
    @FindBy(id = "uilistSomedataPublic")
    public UIList<SomeSection, SomeData> uilistSomedataPublic;
    @FindBy(id = "uilistSomedataPrivate")
    private UIList<SomeSection, SomeData> uilistSomedataPrivate;
    @FindBy(id = "uilistSomedataPackageStatic")
    static UIList<SomeSection, SomeData> uilistSomedataPackageStatic;
    @FindBy(id = "uilistSomedataPublicStatic")
    public static UIList<SomeSection, SomeData> uilistSomedataPublicStatic;
    @FindBy(id = "uilistSomedataPrivateStatic")
    private static UIList<SomeSection, SomeData> uilistSomedataPrivateStatic;
    @UI(".uilistSomedataPackageUI")
    UIList<SomeSection, SomeData> uilistSomedataPackageUI;
    @UI(".uilistSomedataPublicUI")
    public UIList<SomeSection, SomeData> uilistSomedataPublicUI;


    @JDropdown(root = "div[ui=droplistPackage", value = "input", list = "li", expand = ".expand")
    Droplist droplistPackage;
    @JDropdown(root = "div[ui=droplistPublic", value = "input", list = "li", expand = ".expand")
    public Droplist droplistPublic;
    @JDropdown(root = "div[ui=droplistPrivate", value = "input", list = "li", expand = ".expand")
    private Droplist droplistPrivate;
    @JDropdown(root = "div[ui=droplistPackageStatic", value = "input", list = "li", expand = ".expand")
    static Droplist droplistPackageStatic;
    @JDropdown(root = "div[ui=droplistPublicStatic", value = "input", list = "li", expand = ".expand")
    public static Droplist droplistPublicStatic;
    @JDropdown(root = "div[ui=droplistPrivateStatic", value = "input", list = "li", expand = ".expand")
    private static Droplist droplistPrivateStatic;
    @UI(".droplistPackageUI")
    Droplist droplistPackageUI;
    @UI(".droplistPublicUI")
    public Droplist droplistPublicUI;


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

    public static WebElement getWebElementPackageStatic() {
        return webElementPackageStatic;
    }

    public static void setWebElementPackageStatic(WebElement webElementPackageStatic) {
        ExtendedObject.webElementPackageStatic = webElementPackageStatic;
    }

    public static WebElement getWebElementPrivateStatic() {
        return webElementPrivateStatic;
    }

    public static void setWebElementPrivateStatic(WebElement webElementPrivateStatic) {
        ExtendedObject.webElementPrivateStatic = webElementPrivateStatic;
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

    public static List<WebElement> getListWebElementPackageStatic() {
        return listWebElementPackageStatic;
    }

    public static void setListWebElementPackageStatic(List<WebElement> listWebElementPackageStatic) {
        ExtendedObject.listWebElementPackageStatic = listWebElementPackageStatic;
    }

    public static List<WebElement> getListWebElementPrivateStatic() {
        return listWebElementPrivateStatic;
    }

    public static void setListWebElementPrivateStatic(List<WebElement> listWebElementPrivateStatic) {
        ExtendedObject.listWebElementPrivateStatic = listWebElementPrivateStatic;
    }

    public List<WebElement> getListWebElementPackageUI() {
        return listWebElementPackageUI;
    }

    public void setListWebElementPackageUI(List<WebElement> listWebElementPackageUI) {
        this.listWebElementPackageUI = listWebElementPackageUI;
    }

    public UIElement getUielementPackage() {
        return uielementPackage;
    }

    public void setUielementPackage(UIElement uielementPackage) {
        this.uielementPackage = uielementPackage;
    }

    public UIElement getUielementPrivate() {
        return uielementPrivate;
    }

    public void setUielementPrivate(UIElement uielementPrivate) {
        this.uielementPrivate = uielementPrivate;
    }

    public static UIElement getUielementPackageStatic() {
        return uielementPackageStatic;
    }

    public static void setUielementPackageStatic(UIElement uielementPackageStatic) {
        ExtendedObject.uielementPackageStatic = uielementPackageStatic;
    }

    public static UIElement getUielementPrivateStatic() {
        return uielementPrivateStatic;
    }

    public static void setUielementPrivateStatic(UIElement uielementPrivateStatic) {
        ExtendedObject.uielementPrivateStatic = uielementPrivateStatic;
    }

    public UIElement getUielementPackageUI() {
        return uielementPackageUI;
    }

    public void setUielementPackageUI(UIElement uielementPackageUI) {
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

    public static Button getButtonPackageStatic() {
        return buttonPackageStatic;
    }

    public static void setButtonPackageStatic(Button buttonPackageStatic) {
        ExtendedObject.buttonPackageStatic = buttonPackageStatic;
    }

    public static Button getButtonPrivateStatic() {
        return buttonPrivateStatic;
    }

    public static void setButtonPrivateStatic(Button buttonPrivateStatic) {
        ExtendedObject.buttonPrivateStatic = buttonPrivateStatic;
    }

    public Button getButtonPackageUI() {
        return buttonPackageUI;
    }

    public void setButtonPackageUI(Button buttonPackageUI) {
        this.buttonPackageUI = buttonPackageUI;
    }

    public List<UIElement> getListUIElementPackage() {
        return listUIElementPackage;
    }

    public void setListUIElementPackage(List<UIElement> listUIElementPackage) {
        this.listUIElementPackage = listUIElementPackage;
    }

    public List<UIElement> getListUIElementPrivate() {
        return listUIElementPrivate;
    }

    public void setListUIElementPrivate(List<UIElement> listUIElementPrivate) {
        this.listUIElementPrivate = listUIElementPrivate;
    }

    public static List<UIElement> getListUIElementPackageStatic() {
        return listUIElementPackageStatic;
    }

    public static void setListUIElementPackageStatic(List<UIElement> listUIElementPackageStatic) {
        ExtendedObject.listUIElementPackageStatic = listUIElementPackageStatic;
    }

    public static List<UIElement> getListUIElementPrivateStatic() {
        return listUIElementPrivateStatic;
    }

    public static void setListUIElementPrivateStatic(List<UIElement> listUIElementPrivateStatic) {
        ExtendedObject.listUIElementPrivateStatic = listUIElementPrivateStatic;
    }

    public List<UIElement> getListUIElementPackageUI() {
        return listUIElementPackageUI;
    }

    public void setListUIElementPackageUI(List<UIElement> listUIElementPackageUI) {
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

    public static List<Button> getListButtonPackageStatic() {
        return listButtonPackageStatic;
    }

    public static void setListButtonPackageStatic(List<Button> listButtonPackageStatic) {
        ExtendedObject.listButtonPackageStatic = listButtonPackageStatic;
    }

    public static List<Button> getListButtonPrivateStatic() {
        return listButtonPrivateStatic;
    }

    public static void setListButtonPrivateStatic(List<Button> listButtonPrivateStatic) {
        ExtendedObject.listButtonPrivateStatic = listButtonPrivateStatic;
    }

    public List<Button> getListButtonPackageUI() {
        return listButtonPackageUI;
    }

    public void setListButtonPackageUI(List<Button> listButtonPackageUI) {
        this.listButtonPackageUI = listButtonPackageUI;
    }

    public WebList getWebListPackage() {
        return webListPackage;
    }

    public void setWebListPackage(WebList webListPackage) {
        this.webListPackage = webListPackage;
    }

    public WebList getWebListPrivate() {
        return webListPrivate;
    }

    public void setWebListPrivate(WebList webListPrivate) {
        this.webListPrivate = webListPrivate;
    }

    public static WebList getWebListPackageStatic() {
        return webListPackageStatic;
    }

    public static void setWebListPackageStatic(WebList webListPackageStatic) {
        ExtendedObject.webListPackageStatic = webListPackageStatic;
    }

    public static WebList getWebListPrivateStatic() {
        return webListPrivateStatic;
    }

    public static void setWebListPrivateStatic(WebList webListPrivateStatic) {
        ExtendedObject.webListPrivateStatic = webListPrivateStatic;
    }

    public WebList getWebListPackageUI() {
        return webListPackageUI;
    }

    public void setWebListPackageUI(WebList webListPackageUI) {
        this.webListPackageUI = webListPackageUI;
    }

    public UIList<SomeSection, ?> getUilistQuestionPackage() {
        return uilistQuestionPackage;
    }

    public void setUilistQuestionPackage(UIList<SomeSection, ?> uilistQuestionPackage) {
        this.uilistQuestionPackage = uilistQuestionPackage;
    }

    public UIList<SomeSection, ?> getUilistQuestionPrivate() {
        return uilistQuestionPrivate;
    }

    public void setUilistQuestionPrivate(UIList<SomeSection, ?> uilistQuestionPrivate) {
        this.uilistQuestionPrivate = uilistQuestionPrivate;
    }

    public static UIList<SomeSection, ?> getUilistQuestionPackageStatic() {
        return uilistQuestionPackageStatic;
    }

    public static void setUilistQuestionPackageStatic(UIList<SomeSection, ?> uilistQuestionPackageStatic) {
        ExtendedObject.uilistQuestionPackageStatic = uilistQuestionPackageStatic;
    }

    public static UIList<SomeSection, ?> getUilistQuestionPrivateStatic() {
        return uilistQuestionPrivateStatic;
    }

    public static void setUilistQuestionPrivateStatic(UIList<SomeSection, ?> uilistQuestionPrivateStatic) {
        ExtendedObject.uilistQuestionPrivateStatic = uilistQuestionPrivateStatic;
    }

    public UIList<SomeSection, ?> getUilistQuestionPackageUI() {
        return uilistQuestionPackageUI;
    }

    public void setUilistQuestionPackageUI(UIList<SomeSection, ?> uilistQuestionPackageUI) {
        this.uilistQuestionPackageUI = uilistQuestionPackageUI;
    }

    public UIList<SomeSection, SomeData> getUilistSomedataPackage() {
        return uilistSomedataPackage;
    }

    public void setUilistSomedataPackage(UIList<SomeSection, SomeData> uilistSomedataPackage) {
        this.uilistSomedataPackage = uilistSomedataPackage;
    }

    public UIList<SomeSection, SomeData> getUilistSomedataPrivate() {
        return uilistSomedataPrivate;
    }

    public void setUilistSomedataPrivate(UIList<SomeSection, SomeData> uilistSomedataPrivate) {
        this.uilistSomedataPrivate = uilistSomedataPrivate;
    }

    public static UIList<SomeSection, SomeData> getUilistSomedataPackageStatic() {
        return uilistSomedataPackageStatic;
    }

    public static void setUilistSomedataPackageStatic(UIList<SomeSection, SomeData> uilistSomedataPackageStatic) {
        ExtendedObject.uilistSomedataPackageStatic = uilistSomedataPackageStatic;
    }

    public static UIList<SomeSection, SomeData> getUilistSomedataPrivateStatic() {
        return uilistSomedataPrivateStatic;
    }

    public static void setUilistSomedataPrivateStatic(UIList<SomeSection, SomeData> uilistSomedataPrivateStatic) {
        ExtendedObject.uilistSomedataPrivateStatic = uilistSomedataPrivateStatic;
    }

    public UIList<SomeSection, SomeData> getUilistSomedataPackageUI() {
        return uilistSomedataPackageUI;
    }

    public void setUilistSomedataPackageUI(UIList<SomeSection, SomeData> uilistSomedataPackageUI) {
        this.uilistSomedataPackageUI = uilistSomedataPackageUI;
    }

    public Droplist getDroplistPackage() {
        return droplistPackage;
    }

    public void setDroplistPackage(Droplist droplistPackage) {
        this.droplistPackage = droplistPackage;
    }

    public Droplist getDroplistPrivate() {
        return droplistPrivate;
    }

    public void setDroplistPrivate(Droplist droplistPrivate) {
        this.droplistPrivate = droplistPrivate;
    }

    public static Droplist getDroplistPackageStatic() {
        return droplistPackageStatic;
    }

    public static void setDroplistPackageStatic(Droplist droplistPackageStatic) {
        ExtendedObject.droplistPackageStatic = droplistPackageStatic;
    }

    public static Droplist getDroplistPrivateStatic() {
        return droplistPrivateStatic;
    }

    public static void setDroplistPrivateStatic(Droplist droplistPrivateStatic) {
        ExtendedObject.droplistPrivateStatic = droplistPrivateStatic;
    }

    public Droplist getDroplistPackageUI() {
        return droplistPackageUI;
    }

    public void setDroplistPackageUI(Droplist droplistPackageUI) {
        this.droplistPackageUI = droplistPackageUI;
    }
}
