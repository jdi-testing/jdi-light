package pseudo.site.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import pseudo.site.entities.User;

public class LoginForm extends Form<User> {
    @UI("#user-name")
    public TextField userName;
    @UI("#user-password")
    public TextField userPassword;
    @UI("#login-button")
    public Button loginButton;
}
