package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.sections.gridinmodal.GridModal;
import io.github.com.sections.modalwindow.ModalWindow;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridModalWindow extends ModalWindow {
       @UI(".modal-body [class*='container']")
       public GridModal gridModal;
}
