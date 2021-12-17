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
