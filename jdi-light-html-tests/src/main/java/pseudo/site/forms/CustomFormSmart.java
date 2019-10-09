package pseudo.site.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import pseudo.site.entities.User;

import java.util.List;

public class CustomFormSmart extends Form<User> {
    WebElement fbWebElement;
    public WebElement fbPublicWebElement;
    private WebElement fbPrivateWebElement;

    WebList fbWebElementList;
    public WebList fbPublicWebElementList;
    private WebList fbPrivateWebElementList;

    UIElement fbUIElement;
    public UIElement fbPublicUIElement;
    private UIElement fbPrivateUIElement;

    List<UIElement> fbUIElementList;
    public List<UIElement> fbPublicUIElementList;
    private List<UIElement> fbPrivateUIElementList;

    Button fbButton;
    public Button fbPublicButton;
    private Button fbPrivateButton;

    List<Button> fbButtonList;
    public List<Button> fbPublicButtonList;
    private List<Button> fbPrivateButtonList;

    WebList fbWebList;
    public WebList fbPublicWebList;
    private WebList fbPrivateWebList;

    public WebElement getFbWebElement() {
        return fbWebElement;
    }

    public WebElement getFbPublicWebElement() {
        return fbPublicWebElement;
    }

    public WebElement getFbPrivateWebElement() {
        return fbPrivateWebElement;
    }

    public WebList getFbWebElementList() {
        return fbWebElementList;
    }

    public WebList getFbPublicWebElementList() {
        return fbPublicWebElementList;
    }

    public WebList getFbPrivateWebElementList() {
        return fbPrivateWebElementList;
    }

    public UIElement getFbUIElement() {
        return fbUIElement;
    }

    public UIElement getFbPublicUIElement() {
        return fbPublicUIElement;
    }

    public UIElement getFbPrivateUIElement() {
        return fbPrivateUIElement;
    }

    public List<UIElement> getFbUIElementList() {
        return fbUIElementList;
    }

    public List<UIElement> getFbPublicUIElementList() {
        return fbPublicUIElementList;
    }

    public List<UIElement> getFbPrivateUIElementList() {
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

    public WebList getFbWebList() {
        return fbWebList;
    }

    public WebList getFbPublicWebList() {
        return fbPublicWebList;
    }

    public WebList getFbPrivateWebList() {
        return fbPrivateWebList;
    }
}
