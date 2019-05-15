package pseudo.site.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import pseudo.site.entities.User;

public class SomeFormSmart extends Form<User> {
    public TextField userName, userPassword;
    public Button loginButton;
}
