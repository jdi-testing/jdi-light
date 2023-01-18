package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.custom.annotations.JButtonWithDialog;
import io.github.com.custom.annotations.JListItemWithDialog;
import io.github.com.custom.elements.ButtonWithDialog;
import io.github.com.custom.elements.MUIListItemWithDialog;

public class DialogPage extends WebPage {

    @JButtonWithDialog(root = "//span[text()='Open simple dialog']/parent::button",
            dialog = "//div[@aria-labelledby = 'simple-dialog-title']/parent::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#simpleDialogSelection")
    public static ButtonWithDialog simpleDialogButton;

    @JButtonWithDialog(root = "//span[text()='Open alert dialog']/parent::button",
            dialog = "//h2[text() ='Alert dialog question?']/ancestor::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#alertDialogSelection")
    public static ButtonWithDialog alertDialogButton;

    @JButtonWithDialog(root = "//span[text()='Open form dialog']/parent::button",
            dialog = "//h2[text() ='Form Dialog']/ancestor::div[contains(@class, 'MuiDialog-container')]",
            actionText = "#mailDialogSelection")
    public static ButtonWithDialog formDialogButton;

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
