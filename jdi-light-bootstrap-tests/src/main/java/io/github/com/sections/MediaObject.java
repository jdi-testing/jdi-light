package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.common.IsMediaObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

import java.util.List;

public class MediaObject extends Section implements IsMediaObject {

    @Css("img")
    public Image image;
    @Css("h5")
    public Text mediaHeading;
    @Css(".media-body")
    public Text bodyOfMediaObject;
    @Css("li.media")
    public List<MediaObject> listOfMediaObject;
    @Css("div.media div.media")
    public List<MediaObject> listOfMediaObjectNesting;
}
