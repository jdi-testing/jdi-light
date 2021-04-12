package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class DialogPage extends WebPage {

    @UI("//span[text()='Open simple dialog']/parent::*[contains(@class,'MuiButtonBase-root')]")
    public static Button simpleDialogButton;

    @UI("//div[@id='simple-dialog-title']/following::div[@class='MuiListItemText-root'][1]")
    public static Button simpleDialogListButton;

    @UI("#simpleDialogSelection")
    public static Text simpleDialogField;



    @UI("//span[text()='Open alert dialog']/parent::*[contains(@class,'MuiButtonBase-root')]")
    public static Button alertDialogButton;

    @UI("#alertDialogSelection")
    public static Text alertDialogField;



    @UI("//span[text()='Open form dialog']/parent::*[contains(@class,'MuiButtonBase-root')]")
    public static Button formDialogButton;

    @UI("#mailDialogSelection")
    public static Text formDialogField;

    @UI("//input[@type='email']")
    public static TextField dialogEmailInputForm;



    @UI("//span[text()='Phone ringtone']/parent::div")
    public static Button confirmationDialogButton;

    @UI("//div[contains(@class,'MuiListItemText-multiline')]/span[text()='Phone ringtone']/following-sibling::p")
    public static Text confirmationDialogField;

    @UI("//*[text()='Ok']")
    public static Button confirmationDialogOkButton;

    @UI("//span[text()='Cancel']")
    public static Button confirmationDialogCancelButton;



    @UI("//span[text()='scroll=paper']/parent::*[contains(@class,'MuiButtonBase-root')]")
    public static Button scrollPaperDialogButton;

    @UI("//span[text()='scroll=body']/parent::*[contains(@class,'MuiButtonBase-root')]")
    public static Button scrollBodyDialogButton;

    @UI("#scrollableAction")
    public static Text scrollableDialogField;

    @UI("//div[@id='scroll-dialog-title']/following::span[text()='Cancel']")
    public static Button scrollableDialogCancelButton;

    @UI("//div[@id='scroll-dialog-title']/following::div[contains(@class,'MuiDialogContent-dividers')]")
    public static TextArea dialogScrollableContent;


    @UI("//h2[contains(@class,'MuiTypography-h6')]")
    public static Text phoneRingtoneDialogTitle;

    @UI("//div[@class='MuiFormGroup-root']//span[text()='Callisto']")
    public static Button dialogCallistoRingtone;

    @UI("//div[@class='MuiFormGroup-root']//span[text()='Luna']")
    public static Button dialogLunaRingtone;



    @UI("//h2[contains(@class,'MuiTypography-h6') and not (text()='Phone Ringtone')]")
    public static Text dialogTitle;

    @UI("//div[contains(@class,'MuiDialogContent-root')]/p")
    public static Text dialogContent;

    @UI("//*[text()='ok']")
    public static Button dialogOkButton;

    @UI("//span[text()='close']")
    public static Button dialogCloseButton;

    @UI("//span[text()='Subscribe']")
    public static Button subscribeButton;

}
