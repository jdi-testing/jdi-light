package selenium.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import org.openqa.selenium.WebElement;
import selenium.entities.User;

public class LoginForm extends Form<User> {
    WebElement name;
    WebElement password;

    WebElement loginButton;
}
