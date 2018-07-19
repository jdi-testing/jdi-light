package selenium.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;
import selenium.entities.User;

public class LoginForm extends Form<User> {
    @Css("#Name")      WebElement userName;
    @Css("#Password")  WebElement password;

    @Css("[type=submit]") WebElement enter;
}
