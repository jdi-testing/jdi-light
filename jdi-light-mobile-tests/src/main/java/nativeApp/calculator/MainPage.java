package nativeApp.calculator;


import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.init.PageFactory;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

//import com.epam.jdi.light.ui.html.elements.common.Button;

public class MainPage {

    private final String LOCATOR_PATH = "com.android.calculator2:id/";

    @FindBy(id = LOCATOR_PATH + "clr")
    Button clr;

    @FindBy(id = LOCATOR_PATH + "del")
    Button del;

    @FindBy(id = LOCATOR_PATH + "formula")
    WebElement formula;

    @FindBy(id = LOCATOR_PATH + "dec_point")
    Button dec_point;

    @FindBy(id = LOCATOR_PATH + "result")
    Text result;

    @FindBy(id = LOCATOR_PATH + "eq")
    Button eq;

    @FindBy(id = LOCATOR_PATH + "digit_0")
    Button digit_0;
    // /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.View[1]/android.widget.Button[7]
    @FindBy(id = LOCATOR_PATH + "digit_1")
    Button digit_1;
    @FindBy(id = LOCATOR_PATH + "digit_2")
    Button digit_2;
    @FindBy(id = LOCATOR_PATH + "digit_3")
    Button digit_3;
    @FindBy(id = LOCATOR_PATH + "digit_4")
    Button digit_4;
    @FindBy(id = LOCATOR_PATH + "digit_5")
    Button digit_5;
    @FindBy(id = LOCATOR_PATH + "digit_6")
    Button digit_6;
    @FindBy(id = LOCATOR_PATH + "digit_7")
    Button digit_7;
    @FindBy(id = LOCATOR_PATH + "digit_8")
    Button digit_8;
    @FindBy(id = LOCATOR_PATH + "digit_9")
    Button digit_9;

    @FindBy(id = LOCATOR_PATH + "op_add")
    Button op_add;
    @FindBy(id = LOCATOR_PATH + "op_sub")
    Button op_sub;
    @FindBy(id = LOCATOR_PATH + "op_mul")
    Button op_mul;
    @FindBy(id = LOCATOR_PATH + "op_div")
    Button op_div;

    public MainPage() {
        PageFactory.initElements(this);
    }

//    public double calculate(double number1, double number2, Operations operation){
//        try{
//            switch (operation){
//                case ADDITION:
//                    break;
//                case SUBTRACTION:
//                    break;
//                case MULTIPLICATION:
//                    break;
//                case DIVISION:
//                    break;
//            }
//        } catch(Exception exc){
//            exc.getMessage();
//        }
//        return 0;
//    }

    public double addition() {
        digit_1.click();
        op_add.click();
        digit_8.click();
        eq.click();
        return Double.parseDouble(formula.getText());
    }

    public double additionReal() {
        digit_0.click();
        dec_point.click();
        digit_7.click();

        op_add.click();

        digit_3.click();
        dec_point.click();
        digit_4.click();

        eq.click();
        return parseDouble(formula.getText());
    }

    private double parseDouble(String numberToParse) {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = null;
        try {
            number = format.parse(numberToParse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number.doubleValue();
    }

    public void clearDisplay() {
        if (clr.isEnabled()) {
            clr.click();
        } else if (del.isEnabled()) {
            while (formula.getText() != null) {
                del.click();
            }
        }
    }

}
