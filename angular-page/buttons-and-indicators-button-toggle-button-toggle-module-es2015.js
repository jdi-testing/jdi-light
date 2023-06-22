(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["buttons-and-indicators-button-toggle-button-toggle-module"],{

/***/ "./src/app/buttons-and-indicators/button-toggle/button-toggle-routing.module.ts":
/*!**************************************************************************************!*\
  !*** ./src/app/buttons-and-indicators/button-toggle/button-toggle-routing.module.ts ***!
  \**************************************************************************************/
/*! exports provided: ButtonToggleRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ButtonToggleRoutingModule", function() { return ButtonToggleRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _button_toggle_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./button-toggle.component */ "./src/app/buttons-and-indicators/button-toggle/button-toggle.component.ts");





const routes = [{
        path: '',
        component: _button_toggle_component__WEBPACK_IMPORTED_MODULE_2__["ButtonToggleComponent"],
    }];
class ButtonToggleRoutingModule {
}
ButtonToggleRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: ButtonToggleRoutingModule });
ButtonToggleRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function ButtonToggleRoutingModule_Factory(t) { return new (t || ButtonToggleRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
        _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ButtonToggleRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ButtonToggleRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/buttons-and-indicators/button-toggle/button-toggle.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/buttons-and-indicators/button-toggle/button-toggle.component.ts ***!
  \*********************************************************************************/
/*! exports provided: ButtonToggleComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ButtonToggleComponent", function() { return ButtonToggleComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _components_button_toggle_overview_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./components/button-toggle-overview-example */ "./src/app/buttons-and-indicators/button-toggle/components/button-toggle-overview-example.ts");
/* harmony import */ var _components_button_toggle_exclusive_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./components/button-toggle-exclusive-example */ "./src/app/buttons-and-indicators/button-toggle/components/button-toggle-exclusive-example.ts");




class ButtonToggleComponent {
}
ButtonToggleComponent.ɵfac = function ButtonToggleComponent_Factory(t) { return new (t || ButtonToggleComponent)(); };
ButtonToggleComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ButtonToggleComponent, selectors: [["app-button-toggle"]], decls: 2, vars: 0, template: function ButtonToggleComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "button-toggle-overview-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "button-toggle-exclusive-example");
    } }, directives: [_components_button_toggle_overview_example__WEBPACK_IMPORTED_MODULE_1__["ButtonToggleOverviewExample"], _components_button_toggle_exclusive_example__WEBPACK_IMPORTED_MODULE_2__["ButtonToggleExclusiveExample"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ButtonToggleComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-button-toggle',
                templateUrl: './button-toggle.component.html',
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/buttons-and-indicators/button-toggle/button-toggle.module.ts":
/*!******************************************************************************!*\
  !*** ./src/app/buttons-and-indicators/button-toggle/button-toggle.module.ts ***!
  \******************************************************************************/
/*! exports provided: ButtonToggleModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ButtonToggleModule", function() { return ButtonToggleModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _button_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./button-toggle-routing.module */ "./src/app/buttons-and-indicators/button-toggle/button-toggle-routing.module.ts");
/* harmony import */ var _button_toggle_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./button-toggle.component */ "./src/app/buttons-and-indicators/button-toggle/button-toggle.component.ts");
/* harmony import */ var _components_button_toggle_overview_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/button-toggle-overview-example */ "./src/app/buttons-and-indicators/button-toggle/components/button-toggle-overview-example.ts");
/* harmony import */ var _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/button-toggle */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button-toggle.js");
/* harmony import */ var _components_button_toggle_exclusive_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/button-toggle-exclusive-example */ "./src/app/buttons-and-indicators/button-toggle/components/button-toggle-exclusive-example.ts");
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/icon */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");









class ButtonToggleModule {
}
ButtonToggleModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: ButtonToggleModule });
ButtonToggleModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function ButtonToggleModule_Factory(t) { return new (t || ButtonToggleModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _button_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__["ButtonToggleRoutingModule"],
            _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_5__["MatButtonToggleModule"],
            _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ButtonToggleModule, { declarations: [_button_toggle_component__WEBPACK_IMPORTED_MODULE_3__["ButtonToggleComponent"], _components_button_toggle_overview_example__WEBPACK_IMPORTED_MODULE_4__["ButtonToggleOverviewExample"], _components_button_toggle_exclusive_example__WEBPACK_IMPORTED_MODULE_6__["ButtonToggleExclusiveExample"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _button_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__["ButtonToggleRoutingModule"],
        _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_5__["MatButtonToggleModule"],
        _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ButtonToggleModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_button_toggle_component__WEBPACK_IMPORTED_MODULE_3__["ButtonToggleComponent"], _components_button_toggle_overview_example__WEBPACK_IMPORTED_MODULE_4__["ButtonToggleOverviewExample"], _components_button_toggle_exclusive_example__WEBPACK_IMPORTED_MODULE_6__["ButtonToggleExclusiveExample"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _button_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__["ButtonToggleRoutingModule"],
                    _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_5__["MatButtonToggleModule"],
                    _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]
                ]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/buttons-and-indicators/button-toggle/components/button-toggle-exclusive-example.ts":
/*!****************************************************************************************************!*\
  !*** ./src/app/buttons-and-indicators/button-toggle/components/button-toggle-exclusive-example.ts ***!
  \****************************************************************************************************/
/*! exports provided: ButtonToggleExclusiveExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ButtonToggleExclusiveExample", function() { return ButtonToggleExclusiveExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/button-toggle */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button-toggle.js");
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/icon */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");




/**
 * @title Exclusive selection
 */
class ButtonToggleExclusiveExample {
}
ButtonToggleExclusiveExample.ɵfac = function ButtonToggleExclusiveExample_Factory(t) { return new (t || ButtonToggleExclusiveExample)(); };
ButtonToggleExclusiveExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ButtonToggleExclusiveExample, selectors: [["button-toggle-exclusive-example"]], decls: 18, vars: 1, consts: [[1, "example-h2"], ["id", "mat-button-toggle-group-align"], ["group", "matButtonToggleGroup"], ["value", "left", "aria-label", "Text align left"], ["value", "center", "aria-label", "Text align center"], ["value", "right", "aria-label", "Text align right"], ["value", "justify", "disabled", "", "aria-label", "Text align justify"], [1, "example-selected-value"]], template: function ButtonToggleExclusiveExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Exclusive selection button-toggles");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-button-toggle-group", 1, 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-button-toggle", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-icon");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "format_align_left");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-button-toggle", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-icon");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "format_align_center");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "mat-button-toggle", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-icon");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "format_align_right");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-button-toggle", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-icon");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "format_align_justify");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("Selected value: ", _r1.value, "");
    } }, directives: [_angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_1__["MatButtonToggleGroup"], _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_1__["MatButtonToggle"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_2__["MatIcon"]], styles: [".example-selected-value[_ngcontent-%COMP%] {\r\n  margin: 15px 0;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9idXR0b24tdG9nZ2xlL2NvbXBvbmVudHMvYnV0dG9uLXRvZ2dsZS1leGNsdXNpdmUtZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxjQUFjO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9idXR0b24tdG9nZ2xlL2NvbXBvbmVudHMvYnV0dG9uLXRvZ2dsZS1leGNsdXNpdmUtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuZXhhbXBsZS1zZWxlY3RlZC12YWx1ZSB7XHJcbiAgbWFyZ2luOiAxNXB4IDA7XHJcbn1cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ButtonToggleExclusiveExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'button-toggle-exclusive-example',
                templateUrl: 'button-toggle-exclusive-example.html',
                styleUrls: ['button-toggle-exclusive-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/buttons-and-indicators/button-toggle/components/button-toggle-overview-example.ts":
/*!***************************************************************************************************!*\
  !*** ./src/app/buttons-and-indicators/button-toggle/components/button-toggle-overview-example.ts ***!
  \***************************************************************************************************/
/*! exports provided: ButtonToggleOverviewExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ButtonToggleOverviewExample", function() { return ButtonToggleOverviewExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/button-toggle */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button-toggle.js");



/**
 * @title Basic button-toggles
 */
class ButtonToggleOverviewExample {
}
ButtonToggleOverviewExample.ɵfac = function ButtonToggleOverviewExample_Factory(t) { return new (t || ButtonToggleOverviewExample)(); };
ButtonToggleOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ButtonToggleOverviewExample, selectors: [["button-toggle-overview-example"]], decls: 10, vars: 0, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/button-toggle/overview"], ["id", "mat-button-toggle-group-font", "name", "fontStyle", "aria-label", "Font Style", "multiple", ""], ["value", "bold"], ["value", "italic"], ["value", "underline"]], template: function ButtonToggleOverviewExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic button-toggles ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-button-toggle-group", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-button-toggle", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Bold");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-button-toggle", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Italic");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-button-toggle", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "Underline");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_1__["MatButtonToggleGroup"], _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_1__["MatButtonToggle"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ButtonToggleOverviewExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'button-toggle-overview-example',
                templateUrl: 'button-toggle-overview-example.html',
            }]
    }], null, null); })();


/***/ })

}]);
//# sourceMappingURL=buttons-and-indicators-button-toggle-button-toggle-module-es2015.js.map