package org.jdiai.entities;

import org.jdiai.annotations.UI;
import org.jdiai.jswraper.interfaces.GetValue;

public class MarvelHero {
    @UI(".//td[1]")
    public int number;
    @UI(".//td[2]//option[@selected]")
    public String type;
    @UI(".//td[3]//a")
    public String name;
    @UI(".//td[4]//span")
    public String heroName;
    @UI(".//td[4]//img") @GetValue("src")
    public String img;
}
