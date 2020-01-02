package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.MediaObject;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MediaObjectNesting extends MediaObject {

    @UI("img")
    public Image imageOfMediaObject;

    @Title
    @UI("h5")
    public Text headingOfMediaObject;

    @UI(".media-body")
    public Text bodyOfMediaObject;

    @UI("div.media div.media")
    public MediaObjectSample  nestingMediaObject;

}
