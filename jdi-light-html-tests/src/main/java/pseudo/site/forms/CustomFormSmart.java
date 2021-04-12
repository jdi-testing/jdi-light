package pseudo.site.forms;

import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import pseudo.site.entities.User;

import java.util.List;

public class CustomFormSmart extends Form<User> {
    WebElement fbWebElement;
    public WebElement fbPublicWebElement;
    private WebElement fbPrivateWebElement;

    List<WebElement> fbWebElementList;
    public List<WebElement> fbPublicWebElementList;
    private List<WebElement> fbPrivateWebElementList;

    com.epam.jdi.light.elements.common.uiElement fbUIElement;
    public com.epam.jdi.light.elements.common.uiElement fbPublicUIElement;
    private com.epam.jdi.light.elements.common.uiElement fbPrivateUIElement;

    List<com.epam.jdi.light.elements.common.uiElement> fbUIElementList;
    public List<com.epam.jdi.light.elements.common.uiElement> fbPublicUIElementList;
    private List<com.epam.jdi.light.elements.common.uiElement> fbPrivateUIElementList;

    Button fbButton;
    public Button fbPublicButton;
    private Button fbPrivateButton;

    List<Button> fbButtonList;
    public List<Button> fbPublicButtonList;
    private List<Button> fbPrivateButtonList;

    webList fbWebList;
    public webList fbPublicWebList;
    private webList fbPrivateWebList;

    public WebElement getFbWebElement() {
        return fbWebElement;
    }

    public WebElement getFbPublicWebElement() {
        return fbPublicWebElement;
    }

    public WebElement getFbPrivateWebElement() {
        return fbPrivateWebElement;
    }

    public List<WebElement> getFbWebElementList() {
        return fbWebElementList;
    }

    public List<WebElement> getFbPublicWebElementList() {
        return fbPublicWebElementList;
    }

    public List<WebElement> getFbPrivateWebElementList() {
        return fbPrivateWebElementList;
    }

    public com.epam.jdi.light.elements.common.uiElement getFbUIElement() {
        return fbUIElement;
    }

    public com.epam.jdi.light.elements.common.uiElement getFbPublicUIElement() {
        return fbPublicUIElement;
    }

    public com.epam.jdi.light.elements.common.uiElement getFbPrivateUIElement() {
        return fbPrivateUIElement;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getFbUIElementList() {
        return fbUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getFbPublicUIElementList() {
        return fbPublicUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getFbPrivateUIElementList() {
        return fbPrivateUIElementList;
    }

    public Button getFbButton() {
        return fbButton;
    }

    public Button getFbPublicButton() {
        return fbPublicButton;
    }

    public Button getFbPrivateButton() {
        return fbPrivateButton;
    }

    public List<Button> getFbButtonList() {
        return fbButtonList;
    }

    public List<Button> getFbPublicButtonList() {
        return fbPublicButtonList;
    }

    public List<Button> getFbPrivateButtonList() {
        return fbPrivateButtonList;
    }

    public webList getFbWebList() {
        return fbWebList;
    }

    public webList getFbPublicWebList() {
        return fbPublicWebList;
    }

    public webList getFbPrivateWebList() {
        return fbPrivateWebList;
    }
}
