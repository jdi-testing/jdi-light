package jdisite.pages;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.WebPage;
import jdisite.custom.MarvelUser;
import jdisite.entities.MarvelUserInfo;

public class MarvelousPage extends WebPage {
    public static DataTable<MarvelUser, MarvelUserInfo> userTable;
}
