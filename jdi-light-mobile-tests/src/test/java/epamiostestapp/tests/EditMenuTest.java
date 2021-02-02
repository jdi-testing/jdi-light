package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.TextFieldPage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuTextField;

public class EditMenuTest extends IosApplicationInit {

    private final String DEFAULT_TEXT = "Enter username...";

    @Test
    public void editMenuTest(){
        menuTextField.tap();

        TextFieldPage.textField.setValue("Test");

        TextFieldPage.textField.doubleTap();
        TextFieldPage.editMenu.cut();
        TextFieldPage.textField.is().text(DEFAULT_TEXT);

        TextFieldPage.textField.doubleTap();
        TextFieldPage.editMenu.paste();
        TextFieldPage.textField.is().text("Test");

        TextFieldPage.textField.doubleTap();
        TextFieldPage.editMenu.copy();
        TextFieldPage.textField.doubleTap();
        TextFieldPage.editMenu.cut();
        TextFieldPage.textField.is().text(DEFAULT_TEXT);

        TextFieldPage.textField.doubleTap();
        TextFieldPage.editMenu.paste();
        TextFieldPage.textField.is().text("Test");

    }
}
