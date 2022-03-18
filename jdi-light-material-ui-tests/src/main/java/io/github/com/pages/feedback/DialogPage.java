package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.custom.annotations.JDIButtonWithDialog;
import io.github.com.custom.annotations.JDIListItemWithDialog;
import io.github.com.custom.elements.ButtonWithDialog;
import io.github.com.custom.elements.MUIListItemWithDialog;

public class DialogPage extends WebPage {

    @JDIButtonWithDialog(root = "//span[text()='Open simple dialog']/parent::button",
            dialog = "//div[@aria-labelledby = 'simple-dialog-title']/parent::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#simpleDialogSelection")
    public static ButtonWithDialog simpleDialogButton;

    @JDIButtonWithDialog(root = "//span[text()='Open alert dialog']/parent::button",
            dialog = "//h2[text() ='Alert dialog question?']/ancestor::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#alertDialogSelection")
    public static ButtonWithDialog alertDialogButton;

    @JDIButtonWithDialog(root = "//span[text()='Open form dialog']/parent::button",
            dialog = "//h2[text() ='Form Dialog']/ancestor::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#mailDialogSelection")
    public static ButtonWithDialog formDialogButton;

    @JDIListItemWithDialog(root = "//div[contains(@class, 'MuiListItem-root') and @aria-label = 'phone ringtone']",
            dialog = "//h2[text() ='Phone Ringtone']/ancestor::div[contains(@class, 'MuiDialog-container')]")
    public static MUIListItemWithDialog confirmationDialogListItem;

    @JDIButtonWithDialog(root = "//span[text()='scroll=paper']/parent::button",
            dialog = "//div[@class = 'MuiDialog-container MuiDialog-scrollPaper']",
            actionText = "#scrollableAction")
    public static ButtonWithDialog scrollPaperDialogButton;

    @JDIButtonWithDialog(root = "//span[text()='scroll=body']/parent::button",
            dialog = "//div[@class = 'MuiDialog-container MuiDialog-scrollBody']",
            actionText = "#scrollableAction")
    public static ButtonWithDialog scrollBodyDialogButton;

}
