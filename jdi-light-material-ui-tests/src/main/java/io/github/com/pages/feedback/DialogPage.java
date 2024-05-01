package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import io.github.com.custom.annotations.JButtonWithDialog;
import io.github.com.custom.annotations.JListItemWithDialog;
import io.github.com.custom.elements.ButtonWithDialog;
import io.github.com.custom.elements.MUIListItemWithDialog;
import io.github.com.custom.elements.dialog.DialogWithEmail;

public class DialogPage extends WebPage {

    @JButtonWithDialog(root = "//button[./*[text()='Open simple dialog']]",
            dialog = "//div[@aria-labelledby = 'simple-dialog-title']/parent::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#simpleDialogSelection")
    public static ButtonWithDialog simpleDialogButton;

    @JButtonWithDialog(root = "//button[./*[text()='Open alert dialog']]",
            dialog = "//h2[text() ='Alert dialog question?']/ancestor::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#alertDialogSelection")
    public static ButtonWithDialog alertDialogButton;

    @UI("//*[contains(@class, 'MuiDialog-container')][.//h2[text()='Form Dialog']]")
    public static DialogWithEmail formDialog;
    @UI("//button[./*[text()='Open form dialog']]")
    public static MUIButton formDialogButton;
    @UI("#mailDialogSelection")
    public static Typography formDialogAction;

    @JListItemWithDialog(root = "//div[contains(@class, 'MuiListItem-root') and @aria-label = 'phone ringtone']",
            dialog = "//h2[text() ='Phone Ringtone']/ancestor::div[contains(@class, 'MuiDialog-container')]")
    public static MUIListItemWithDialog confirmationDialogListItem;

    @JButtonWithDialog(root = "//span[text()='scroll=paper']/parent::button",
            dialog = "//div[@class = 'MuiDialog-container MuiDialog-scrollPaper']",
            actionText = "#scrollableAction")
    public static ButtonWithDialog scrollPaperDialogButton;

    @JButtonWithDialog(root = "//span[text()='scroll=body']/parent::button",
            dialog = "//div[@class = 'MuiDialog-container MuiDialog-scrollBody']",
            actionText = "#scrollableAction")
    public static ButtonWithDialog scrollBodyDialogButton;

}
