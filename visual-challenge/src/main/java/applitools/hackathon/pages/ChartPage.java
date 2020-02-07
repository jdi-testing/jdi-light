package applitools.hackathon.pages;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Image;
import com.epam.jdi.mobile.ui.html.elements.common.Link;

public class ChartPage extends WebPage {
    @UI("#addDataset") public static Link showNextYear;
    @UI("#canvas") public static Image expensesChart;
}
