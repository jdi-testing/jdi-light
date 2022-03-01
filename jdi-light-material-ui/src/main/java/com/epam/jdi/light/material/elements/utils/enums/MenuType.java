package com.epam.jdi.light.material.elements.utils.enums;

import com.epam.jdi.light.material.elements.navigation.Menu;

public enum MenuType {
        SIMPLE {
            public Menu menu() {
                return new Menu(".MuiButton-text", "#selectedItem");
            }
        },
        ICON {
            public Menu menu() {
                return new Menu(".MuiIconButton-root", "#selectedIconMenu");
            }
        },
        SELECTED {
            public Menu menu() {
                return new Menu(".MuiListItemText-multiline", ".MuiTypography-colorTextSecondary");
            }
        },
        SCROLL {
            public Menu menu() {
                return new Menu("[aria-controls=long-menu]", "#selectedLongMenu");
            }
        };

        public abstract Menu menu() ;
}
