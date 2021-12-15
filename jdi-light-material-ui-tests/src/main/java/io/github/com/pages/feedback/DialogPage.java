package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class DialogPage extends WebPage {

    @UI("//span[text()='Open simple dialog']/parent::button")
    public static Button simpleDialogButton;

    @UI("#simpleDialogSelection")
    public static Text simpleDialogSelectedText;

    @UI("//div[@aria-labelledby = 'simple-dialog-title']/parent::div[contains(@class, 'MuiDialog-container')]")
    public static Dialog simpleDialog;

    @UI("//span[text()='Open alert dialog']/parent::button")
    public static Button alertDialogButton;

    @UI("#alertDialogSelection")
    public static Text alertDialogSelectedText;

    @UI("//h2[text() ='Alert dialog question?']/ancestor::div[contains(@class, 'MuiDialog-container')]")
    public static Dialog alertDialog;

    @UI("//span[text()='Open form dialog']/parent::button")
    public static Button formDialogButton;

    @UI("#mailDialogSelection")
    public static Text formDialogSelectedText;

    @UI("//h2[text() ='Form Dialog']/ancestor::div[contains(@class, 'MuiDialog-container')]")
    public static Dialog formDialog;

    @UI("//div[contains(@class, 'MuiListItem-root') and @aria-label = 'phone ringtone']")
    public static ListItem confirmationDialogListItem;

    @UI("//h2[text() ='Phone Ringtone']/ancestor::div[contains(@class, 'MuiDialog-container')]")
    public static Dialog confirmationDialog;

    @UI("//span[text()='scroll=paper']/parent::button")
    public static Button scrollPaperButton;

    @UI("//span[text()='scroll=body']/parent::button")
    public static Button scrollBodyButton;

    @UI("#scrollableAction")
    public static Text scrollDialogsActionText;

    @UI("//div[@class = 'MuiDialog-container MuiDialog-scrollBody']")
    public static Dialog scrollBodyDialog;

    @UI("//div[@class = 'MuiDialog-container MuiDialog-scrollPaper']")
    public static Dialog scrollPaperDialog;





}


//    @UI("//span[text()='Open form dialog']/parent::*[contains(@class,'MuiButtonBase-root')]")
//    public static Button formDialogButton;
//
//    @UI("#mailDialogSelection")
//    public static Text formDialogField;
//
//    @UI("//input[@type='email']")
//    public static TextField dialogEmailInputForm;
//
//
//    @UI("//span[text()='Phone ringtone']/parent::div")
//    public static Button confirmationDialogButton;
//
//    @UI("//span[text()='Phone ringtone']/following-sibling::p")
//    public static Text confirmationDialogField;
//
//    @UI("//*[text()='Ok']")
//    public static Button confirmationDialogOkButton;
//
//    @UI("//span[text()='Cancel']")
//    public static Button confirmationDialogCancelButton;
//
//
//    @UI("//span[text()='scroll=paper']/parent::*[contains(@class,'MuiButtonBase-root')]")
//    public static Button scrollPaperDialogButton;
//
//    @UI("#scrollableAction")
//    public static Text scrollableDialogField;
//
//    @UI("//div[@id='scroll-dialog-title']/following::span[text()='Cancel']")
//    public static Button scrollableDialogCancelButton;
//
//
//    @UI("//h2[contains(@class,'MuiTypography-h6')]")
//    public static Text phoneRingtoneDialogTitle;
//
//    @UI("//div[@class='MuiFormGroup-root']//span[text()='Callisto']")
//    public static Button dialogCallistoRingtone;
//
//    @UI("//div[@class='MuiFormGroup-root']//span[text()='Luna']")
//    public static Button dialogLunaRingtone;
//
//
//    @UI("//h2[contains(@class,'MuiTypography-h6') and not (text()='Phone Ringtone')]")
//    public static Text dialogTitle;
//
//    @UI("//div[contains(@class,'MuiDialogContent-root')]/p")
//    public static Text dialogContent;
//
//    @UI("//*[text()='ok']")
//    public static Button dialogOkButton;
//
//    @UI("//span[text()='close']")
//    public static Button dialogCloseButton;
//
//    @UI("//span[text()='Subscribe']")
//    public static Button subscribeButton;
//}
