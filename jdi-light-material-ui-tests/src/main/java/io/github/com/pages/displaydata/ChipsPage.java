package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIChip;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ChipsPage extends WebPage {

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][1]"
    )
    public static Chip basicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][2]"
    )
    public static Chip basicDisabledChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][3]"
    )
    public static Chip basicClickableChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][4]"
    )
    public static Chip deletableBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][5]",
            icon = ".MuiChip-icon"
    )
    public static Chip clickableDeletableBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][6]"
    )
    public static Chip customDeleteIconBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/a[contains(@class,'MuiChip-root')]"
    )
    public static Chip clickableLinkBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][7]"
    )
    public static Chip primaryClickableBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][8]",
            icon = ".MuiChip-icon"
    )
    public static Chip primaryClickableWithFaceBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][9]"
    )
    public static Chip deletablePrimaryBasicChip;

    @JDIChip(
            root = "//h2[text()='Chip']/following-sibling::div/div[contains(@class,'MuiChip-root')][10]",
            icon = ".MuiChip-icon"
    )
    public static Chip deletableSecondaryBasicChip;

    @UI("#lastClickInfo")
    public static Text lastClickBasicInfo;

    @UI("#lastDeleteInfo")
    public static Text lastDeleteBasicInfo;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[1]"
    )
    public static Chip outlinedChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[2]"
    )
    public static Chip outlinedDisabledChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[3]"
    )
    public static Chip outlinedClickableChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[4]"
    )
    public static Chip outlinedDeletableChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[5]",
            icon = ".MuiChip-icon"
    )
    public static Chip outlinedClickableDeletableChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[6]"
    )
    public static Chip outlinedCustomDeleteIconChip;

    @JDIChip(
            root = "//a[contains(@class, 'MuiChip-outlined')]"
    )
    public static Chip outlinedClickableLinkChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[7]"
    )
    public static Chip outlinedPrimaryClickableChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[8]",
            icon = ".MuiChip-icon"
    )
    public static Chip outlinedPrimaryClickableWithFaceChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[9]"
    )
    public static Chip outlinedPrimaryDeletableChip;

    @JDIChip(
            root = "(//div[contains(@class, 'MuiChip-outlined')])[10]",
            icon = ".MuiChip-icon"
    )
    public static Chip outlinedSecondaryDeletableChip;

    @UI("#lastOutlinedClickInfo")
    public static Text lastClickOutlinedInfo;

    @UI("#lastOutlinedDeleteInfo")
    public static Text lastDeleteOutlinedInfo;

    @JDIChip(
            root = "(//li/div[contains(@class, 'MuiChip-root')])[1]"
    )
    public static Chip chipArrayAngular;

    @JDIChip(
            root = "(//li/div[contains(@class, 'MuiChip-root')])[2]"
    )
    public static Chip chipArrayJquery;

    @JDIChip(
            root = "(//li/div[contains(@class, 'MuiChip-root')])[3]"
    )
    public static Chip chipArrayPolymer;

    @JDIChip(
            root = "(//li/div[contains(@class, 'MuiChip-root')])[4]"
    )
    public static Chip chipArrayReact;

    @JDIChip(
            root = "(//li/div[contains(@class, 'MuiChip-root')])[5]"
    )
    public static Chip chipArrayVuejs;

    @UI("#lastChipArrayClickInfo")
    public static Text lastClickArrayInfo;
}
