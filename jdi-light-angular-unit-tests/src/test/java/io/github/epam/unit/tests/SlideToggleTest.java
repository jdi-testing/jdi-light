package io.github.epam.unit.tests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.angular.elements.common.SlideToggle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.when;

import static org.testng.Assert.assertTrue;


public class SlideToggleTest {

    private static final String ANGULAR_SELECTED_CLASS = "mat-checked";
    private static final String ANGULAR_DISABLE_CLASS = "mat-disabled";

    @InjectMocks
    private SlideToggle slideToggle;

    @Mock
    private UIElement uiElement;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isBaseElementSelectedTest() {
        when(slideToggle.core().isSelected()).thenReturn(true);
        assertTrue(slideToggle.isSelected());
    }

    @Test
    public void isBaseElementUnselectedTest(){
        when(slideToggle.core().isSelected()).thenReturn(false);
        assertFalse(slideToggle.isSelected());
    }

    @Test
    public void isAngularElementSelectedTest() {
        when(slideToggle.core().hasClass(ANGULAR_SELECTED_CLASS)).thenReturn(true);
        assertTrue(slideToggle.isSelected());
    }

    @Test
    public void isAngularElementUnselectedTest() {
        when(slideToggle.core().hasClass(ANGULAR_SELECTED_CLASS)).thenReturn(false);
        assertFalse(slideToggle.isSelected());
    }

    @Test
    public void isBaseElementEnableTest() {
        when(slideToggle.core().isEnabled()).thenReturn(true);
        assertTrue(slideToggle.isEnabled());
    }

    @Test
    public void isBaseElementDisableTest() {
        when(slideToggle.core().isEnabled()).thenReturn(false);
        assertTrue(slideToggle.isDisabled());
    }

    @Test
    public void isAngularElementEnableTest() {
        when(slideToggle.core().isEnabled()).thenReturn(true);
        when(slideToggle.core().hasClass(ANGULAR_DISABLE_CLASS)).thenReturn(false);
        assertTrue(slideToggle.isEnabled());
    }

    @Test
    public void isAngularElementDisableTest() {
        when(slideToggle.core().isEnabled()).thenReturn(true);
        when(slideToggle.core().hasClass(ANGULAR_DISABLE_CLASS)).thenReturn(true);
        assertTrue(slideToggle.isDisabled());
    }
}
