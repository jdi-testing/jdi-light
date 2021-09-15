package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Paper;

import java.util.List;

public class PaperPage extends WebPage {

    @UI(".MuiPaper-root")
    public static List<Paper> paper;
}
