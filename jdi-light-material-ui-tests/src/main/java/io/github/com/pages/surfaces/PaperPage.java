package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Paper;

public class PaperPage extends WebPage {

  @UI("#paperElevation0")
    public static Paper zeroElevationPaper;

  @UI("#paperElevationDefault")
    public static Paper defaultElevationPaper;

  @UI("#paperElevation3")
    public static Paper elevationThreePaper;

  @UI("#paperOutlined")
    public static Paper outlinedRoundedPaper;

  @UI("#paperOutlinedZero")
    public static Paper outlinedSquarePaper;

  @UI("#lastClickContent")
    public static Paper infoPaper;
}
