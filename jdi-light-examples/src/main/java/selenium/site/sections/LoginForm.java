package selenium.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import org.openqa.selenium.WebElement;
import selenium.entities.User;

@SuppressWarnings("unused")
public class LoginForm extends Form<User> {
    private WebElement name;
    private WebElement password;

    private WebElement loginButton;
}
