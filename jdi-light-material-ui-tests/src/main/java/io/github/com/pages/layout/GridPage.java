package io.github.com.pages.layout;

import com.epam.jdi.light.elements.complex.table.Grid;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.List;

public class GridPage extends WebPage {

    @UI(".MuiContainer-root")
    public static Grid rootGrid;

    @UI("//h2[text()='Complex grid']/preceding::div[contains(@class,'MuiGrid-spacing')]")
    public static Grid basicGrid;

    @UI("//h2[text()='Complex grid']/following::div[contains(@class,'MuiPaper-rounded')]/div[contains(@class,'MuiGrid-spacing')]")
    public static Grid complexGrid;

    @UI("//div[contains(@class,'MuiPaper-rounded')]")
    public static List<Button> listButton;

    @UI("//input[contains(@class,'MuiInput-input')]")
    public static List<TextField> listInput;
}
