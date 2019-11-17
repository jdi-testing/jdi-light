package applitools.hackathon.utils;

import applitools.hackathon.entities.Transaction;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.Dimension;

import java.util.List;

public class Utils {

    public static boolean advertismentPresent(Object element) {
        UIElement adv = (UIElement)element;
        Dimension size = adv.getSize();
        return adv.isDisplayed() && adv.childs().size() > 0 &&
                size.getWidth() >= 5 && size.height >= 5;
    }
    public static Transaction[] toArray(List<Transaction> list) {
        return list.toArray(new Transaction[]{});
    }
}
