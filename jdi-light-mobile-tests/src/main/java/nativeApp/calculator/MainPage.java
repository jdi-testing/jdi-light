package nativeApp.calculator;


import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.init.PageFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MainPage {

    private final String LOCATOR_PATH = "com.android.calculator2:id/";

    @FindBy(id = LOCATOR_PATH + "clr")
    Button clr;

    @FindBy(id = LOCATOR_PATH + "del")
    Button del;

    @FindBy(id = LOCATOR_PATH + "formula")
    Text formula;

    @FindBy(id = LOCATOR_PATH + "dec_point")
    Button dec_point;

    @FindBy(id = LOCATOR_PATH + "result")
    Text result;

    @FindBy(id = LOCATOR_PATH + "eq")
    Button eq;

    @FindBy(id = LOCATOR_PATH + "digit_0")
    Button digit_0;
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

    public double addition() {
        digit_1.click();
        op_add.click();
        digit_8.click();
        eq.click();
        return Double.parseDouble(formula.getValue());
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
        return parseDouble(formula.getValue());
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
