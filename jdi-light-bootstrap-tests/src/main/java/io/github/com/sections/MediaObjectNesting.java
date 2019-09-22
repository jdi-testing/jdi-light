package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.MediaObject;

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
