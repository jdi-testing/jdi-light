package jdisite.pages;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.ui.html.elements.common.Button;

@Url("/html5.html") @Title("HTML 5")
public class Html5Page extends WebPage {
    public static Button suspendButton;
}
