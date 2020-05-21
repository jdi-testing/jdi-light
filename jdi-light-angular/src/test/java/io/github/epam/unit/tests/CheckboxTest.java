package io.github.epam.unit.tests;

import com.epam.jdi.light.elements.common.UIElement;
import elements.common.Checkbox;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

public class CheckboxTest {

    private static final String ANGULAR_SELECTED_CLASS = "mat-checkbox-checked";
    private static final String ANGULAR_DISABLE_CLASS = "mat-checkbox-disabled";

    @InjectMocks
    private Checkbox checkbox;

    @Mock
    private UIElement uiElement;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isBaseElementSelectedTest() {
        when(checkbox.core().isSelected()).thenReturn(true);
        assertTrue(checkbox.isSelected());
    }

    @Test
    public void isBaseElementUnselectedTest(){
        when(checkbox.core().isSelected()).thenReturn(false);
        assertFalse(checkbox.isSelected());
    }

    @Test
    public void isAngularElementSelectedTest() {
        when(checkbox.core().hasClass(ANGULAR_SELECTED_CLASS)).thenReturn(true);
        assertTrue(checkbox.isSelected());
    }

    @Test
    public void isAngularElementUnselectedTest() {
        when(checkbox.core().hasClass(ANGULAR_SELECTED_CLASS)).thenReturn(false);
        assertFalse(checkbox.isSelected());
    }

    @Test
    public void isBaseElementEnableTest() {
        when(checkbox.core().isEnabled()).thenReturn(true);
        assertTrue(checkbox.isEnabled());
    }

    @Test
    public void isBaseElementDisableTest() {
        when(checkbox.core().isEnabled()).thenReturn(false);
        assertTrue(checkbox.isDisabled());
    }

    @Test
    public void isAngularElementEnableTest() {
        when(checkbox.core().isEnabled()).thenReturn(true);
        when(checkbox.core().hasClass(ANGULAR_DISABLE_CLASS)).thenReturn(false);
        assertTrue(checkbox.isEnabled());
    }

    @Test
    public void isAngularElementDisableTest() {
        when(checkbox.core().isEnabled()).thenReturn(true);
        when(checkbox.core().hasClass(ANGULAR_DISABLE_CLASS)).thenReturn(true);
        assertTrue(checkbox.isDisabled());
    }
}
