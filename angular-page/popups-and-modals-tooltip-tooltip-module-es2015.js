(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["popups-and-modals-tooltip-tooltip-module"],{

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-auto-hide-example.ts":
/*!***********************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-auto-hide-example.ts ***!
  \***********************************************************************************/
/*! exports provided: TooltipAutoHideExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipAutoHideExample", function() { return TooltipAutoHideExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/cdk/scrolling */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/scrolling.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");











function TooltipAutoHideExample_mat_option_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const positionOption_r503 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", positionOption_r503);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", positionOption_r503, " ");
} }
/**
 * @title Tooltip that demonstrates auto-hiding when it clips out of its scrolling container.
 */
class TooltipAutoHideExample {
    constructor() {
        this.positionOptions = ['below', 'above', 'left', 'right'];
        this.position = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](this.positionOptions[0]);
    }
}
TooltipAutoHideExample.ɵfac = function TooltipAutoHideExample_Factory(t) { return new (t || TooltipAutoHideExample)(); };
TooltipAutoHideExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipAutoHideExample, selectors: [["tooltip-auto-hide-example"]], decls: 11, vars: 3, consts: [[1, "example-h2"], [3, "formControl"], [3, "value", 4, "ngFor", "ngForOf"], ["cdkScrollable", "", 1, "example-container"], ["mat-raised-button", "", "matTooltip", "Tooltip text", "matTooltipHideDelay", "100000", "aria-label", "Button that displays a tooltip that hides when scrolled out of the container", 1, "example-button", 3, "matTooltipPosition"], ["tooltip", "matTooltip"], [3, "value"]], template: function TooltipAutoHideExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Tooltip that demonstrates auto-hiding when it clips out of its scrolling container");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-form-field");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Tooltip position");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-select", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TooltipAutoHideExample_mat_option_6_Template, 2, 2, "mat-option", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "button", 4, 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, " Show tooltip ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.position);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.positionOptions);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matTooltipPosition", ctx.position.value);
    } }, directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_5__["CdkScrollable"], _angular_material_button__WEBPACK_IMPORTED_MODULE_6__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_7__["MatTooltip"], _angular_material_core__WEBPACK_IMPORTED_MODULE_8__["MatOption"]], styles: [".example-button[_ngcontent-%COMP%] {\r\n  display: block;\r\n  margin: 80px auto 400px;\r\n}\r\n\r\n.example-container[_ngcontent-%COMP%] {\r\n  height: 200px;\r\n  overflow: auto;\r\n  border: 1px solid #ccc;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtYXV0by1oaWRlLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsY0FBYztFQUNkLHVCQUF1QjtBQUN6Qjs7QUFFQTtFQUNFLGFBQWE7RUFDYixjQUFjO0VBQ2Qsc0JBQXNCO0FBQ3hCIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtYXV0by1oaWRlLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtYnV0dG9uIHtcclxuICBkaXNwbGF5OiBibG9jaztcclxuICBtYXJnaW46IDgwcHggYXV0byA0MDBweDtcclxufVxyXG5cclxuLmV4YW1wbGUtY29udGFpbmVyIHtcclxuICBoZWlnaHQ6IDIwMHB4O1xyXG4gIG92ZXJmbG93OiBhdXRvO1xyXG4gIGJvcmRlcjogMXB4IHNvbGlkICNjY2M7XHJcbn1cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipAutoHideExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-auto-hide-example',
                templateUrl: 'tooltip-auto-hide-example.html',
                styleUrls: ['tooltip-auto-hide-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-custom-class-example.ts":
/*!**************************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-custom-class-example.ts ***!
  \**************************************************************************************/
/*! exports provided: TooltipCustomClassExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipCustomClassExample", function() { return TooltipCustomClassExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");




/**
 * @title Tooltip that can have a custom class applied.
 */
class TooltipCustomClassExample {
}
TooltipCustomClassExample.ɵfac = function TooltipCustomClassExample_Factory(t) { return new (t || TooltipCustomClassExample)(); };
TooltipCustomClassExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipCustomClassExample, selectors: [["tooltip-custom-class-example"]], decls: 4, vars: 0, consts: [[1, "example-h2"], ["mat-raised-button", "", "matTooltip", "Tooltip text", "matTooltipClass", "example-tooltip-red", "aria-label", "Button that shows a red tooltip", 1, "example-button"]], template: function TooltipCustomClassExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Red tooltip");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "button", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, " Show red tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_2__["MatTooltip"]], styles: [".example-button {\r\n  margin-top: 16px;\r\n}\r\n\r\n.example-tooltip-red {\r\n  background: #b71c1c;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtY3VzdG9tLWNsYXNzLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsZ0JBQWdCO0FBQ2xCOztBQUVBO0VBQ0UsbUJBQW1CO0FBQ3JCIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtY3VzdG9tLWNsYXNzLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtYnV0dG9uIHtcclxuICBtYXJnaW4tdG9wOiAxNnB4O1xyXG59XHJcblxyXG4uZXhhbXBsZS10b29sdGlwLXJlZCB7XHJcbiAgYmFja2dyb3VuZDogI2I3MWMxYztcclxufVxyXG4iXX0= */"], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipCustomClassExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-custom-class-example',
                templateUrl: 'tooltip-custom-class-example.html',
                styleUrls: ['tooltip-custom-class-example.css'],
                // Need to remove view encapsulation so that the custom tooltip style defined in
                // `tooltip-custom-class-example.css` will not be scoped to this component's view.
                encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewEncapsulation"].None,
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-delay-example.ts":
/*!*******************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-delay-example.ts ***!
  \*******************************************************************************/
/*! exports provided: TooltipDelayExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipDelayExample", function() { return TooltipDelayExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");








/**
 * @title Tooltip with a show and hide delay
 */
class TooltipDelayExample {
    constructor() {
        this.showDelay = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](1000);
        this.hideDelay = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](2000);
    }
}
TooltipDelayExample.ɵfac = function TooltipDelayExample_Factory(t) { return new (t || TooltipDelayExample)(); };
TooltipDelayExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipDelayExample, selectors: [["tooltip-delay-example"]], decls: 17, vars: 4, consts: [["href", "https://material.angular.io/components/tooltip/overview#showing-and-hiding"], [1, "example-user-input"], ["matInput", "", "type", "number", "aria-label", "Adds a delay between hovering over the button and displaying the tooltip", 3, "formControl"], ["matInput", "", "type", "number", "aria-label", "Adds a delay between hovering away from the button and hiding the tooltip", 3, "formControl"], ["mat-raised-button", "", "matTooltip", "Tooltip text", "aria-label", "Button that displays a tooltip with a customized delay in showing and hiding", 3, "matTooltipShowDelay", "matTooltipHideDelay"]], template: function TooltipDelayExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Tooltip with a show and hide delay ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Show delay");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "input", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-hint");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "milliseconds");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-form-field", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "mat-label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Hide delay");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "input", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-hint");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "milliseconds");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, " Show tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.showDelay);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.hideDelay);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matTooltipShowDelay", ctx.showDelay.value)("matTooltipHideDelay", ctx.hideDelay.value);
    } }, directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_3__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NumberValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatHint"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_5__["MatTooltip"]], styles: [".mat-form-field[_ngcontent-%COMP%]    + .mat-form-field[_ngcontent-%COMP%], .mat-raised-button[_ngcontent-%COMP%] {\r\n  margin-left: 8px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtZGVsYXktZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7O0VBRUUsZ0JBQWdCO0FBQ2xCIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtZGVsYXktZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LWZvcm0tZmllbGQgKyAubWF0LWZvcm0tZmllbGQsXHJcbi5tYXQtcmFpc2VkLWJ1dHRvbiB7XHJcbiAgbWFyZ2luLWxlZnQ6IDhweDtcclxufVxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipDelayExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-delay-example',
                templateUrl: 'tooltip-delay-example.html',
                styleUrls: ['tooltip-delay-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-disabled-example.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-disabled-example.ts ***!
  \**********************************************************************************/
/*! exports provided: TooltipDisabledExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipDisabledExample", function() { return TooltipDisabledExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");
/* harmony import */ var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material/checkbox */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");







/**
 * @title Tooltip that can be disabled
 */
class TooltipDisabledExample {
    constructor() {
        this.disabled = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](false);
    }
}
TooltipDisabledExample.ɵfac = function TooltipDisabledExample_Factory(t) { return new (t || TooltipDisabledExample)(); };
TooltipDisabledExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipDisabledExample, selectors: [["tooltip-disabled-example"]], decls: 7, vars: 2, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/tooltip/overview#disabling-the-tooltip-from-showing"], ["mat-raised-button", "", "matTooltip", "Tooltip message", "aria-label", "Button that displays a tooltip that can be programatically disabled", 3, "matTooltipDisabled"], [1, "example-disabled-checkbox", 3, "formControl"]], template: function TooltipDisabledExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Tooltip that can be disabled ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, " Show tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-checkbox", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, " Tooltip disabled\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matTooltipDisabled", ctx.disabled.value);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.disabled);
    } }, directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_2__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_3__["MatTooltip"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_4__["MatCheckbox"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"]], styles: [".example-disabled-checkbox[_ngcontent-%COMP%] {\r\n  margin-left: 8px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtZGlzYWJsZWQtZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxnQkFBZ0I7QUFDbEIiLCJmaWxlIjoic3JjL2FwcC9wb3B1cHMtYW5kLW1vZGFscy90b29sdGlwL2NvbXBvbmVudHMvdG9vbHRpcC1kaXNhYmxlZC1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLWRpc2FibGVkLWNoZWNrYm94IHtcclxuICBtYXJnaW4tbGVmdDogOHB4O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipDisabledExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-disabled-example',
                templateUrl: 'tooltip-disabled-example.html',
                styleUrls: ['tooltip-disabled-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-manual-example.ts":
/*!********************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-manual-example.ts ***!
  \********************************************************************************/
/*! exports provided: TooltipManualExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipManualExample", function() { return TooltipManualExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");




/**
 * @title Tooltip that can be manually shown/hidden.
 */
class TooltipManualExample {
}
TooltipManualExample.ɵfac = function TooltipManualExample_Factory(t) { return new (t || TooltipManualExample)(); };
TooltipManualExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipManualExample, selectors: [["tooltip-manual-example"]], decls: 15, vars: 0, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/tooltip/overview#manually-calling-show-and-hide-"], ["mat-button", "", "aria-label", "Show tooltip on the button at the end of this section", 1, "example-action-button", 3, "click"], ["mat-button", "", "aria-label", "Hide tooltip on the button at the end of this section", 1, "example-action-button", 3, "click"], ["mat-button", "", "aria-label", "Show/Hide tooltip on the button at the end of this section", 1, "example-action-button", 3, "click"], ["mat-raised-button", "", "matTooltip", "This button is disabled", "matTooltipPosition", "right", "aria-tooltip", "Button that displays and hides a tooltip triggered by other buttons", "disabled", ""], ["tooltip", "matTooltip"]], template: function TooltipManualExample_Template(rf, ctx) { if (rf & 1) {
        const _r507 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Tooltip that can be manually shown/hidden ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, " Click the following buttons to... ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TooltipManualExample_Template_button_click_6_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r507); const _r506 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](13); return _r506.show(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, " show ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TooltipManualExample_Template_button_click_8_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r507); const _r506 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](13); return _r506.hide(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, " hide ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TooltipManualExample_Template_button_click_10_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r507); const _r506 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](13); return _r506.toggle(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, " toggle show/hide ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "button", 5, 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, " :)\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_2__["MatTooltip"]], styles: [".example-action-button[_ngcontent-%COMP%] {\r\n  margin-top: 16px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtbWFudWFsLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsZ0JBQWdCO0FBQ2xCIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtbWFudWFsLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtYWN0aW9uLWJ1dHRvbiB7XHJcbiAgbWFyZ2luLXRvcDogMTZweDtcclxufVxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipManualExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-manual-example',
                templateUrl: 'tooltip-manual-example.html',
                styleUrls: ['tooltip-manual-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-message-example.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-message-example.ts ***!
  \*********************************************************************************/
/*! exports provided: TooltipMessageExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipMessageExample", function() { return TooltipMessageExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");








/**
 * @title Tooltip with a changing message
 */
class TooltipMessageExample {
    constructor() {
        this.message = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('Have a nice day!');
    }
}
TooltipMessageExample.ɵfac = function TooltipMessageExample_Factory(t) { return new (t || TooltipMessageExample)(); };
TooltipMessageExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipMessageExample, selectors: [["tooltip-message-example"]], decls: 8, vars: 2, consts: [[1, "example-h2"], [1, "example-user-input"], ["matInput", "", 3, "formControl"], ["mat-raised-button", "", "aria-label", "Button that displays a tooltip with a custom message", 3, "matTooltip"]], template: function TooltipMessageExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Tooltip with a changing message");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-form-field", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Tooltip message");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "input", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, " Show tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.message);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matTooltip", ctx.message.value);
    } }, directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_3__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_5__["MatTooltip"]], styles: [".example-user-input[_ngcontent-%COMP%] {\r\n  margin-right: 8px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtbWVzc2FnZS1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGlCQUFpQjtBQUNuQiIsImZpbGUiOiJzcmMvYXBwL3BvcHVwcy1hbmQtbW9kYWxzL3Rvb2x0aXAvY29tcG9uZW50cy90b29sdGlwLW1lc3NhZ2UtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuZXhhbXBsZS11c2VyLWlucHV0IHtcclxuICBtYXJnaW4tcmlnaHQ6IDhweDtcclxufVxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipMessageExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-message-example',
                templateUrl: 'tooltip-message-example.html',
                styleUrls: ['tooltip-message-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-modified-defaults-example.ts":
/*!*******************************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-modified-defaults-example.ts ***!
  \*******************************************************************************************/
/*! exports provided: myCustomTooltipDefaults, TooltipModifiedDefaultsExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "myCustomTooltipDefaults", function() { return myCustomTooltipDefaults; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipModifiedDefaultsExample", function() { return TooltipModifiedDefaultsExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");





/** Custom options the configure the tooltip's default show/hide delays. */
const myCustomTooltipDefaults = {
    showDelay: 1000,
    hideDelay: 1000,
    touchendHideDelay: 1000,
};
/**
 * @title Tooltip with a show and hide delay
 */
class TooltipModifiedDefaultsExample {
}
TooltipModifiedDefaultsExample.ɵfac = function TooltipModifiedDefaultsExample_Factory(t) { return new (t || TooltipModifiedDefaultsExample)(); };
TooltipModifiedDefaultsExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipModifiedDefaultsExample, selectors: [["tooltip-modified-defaults-example"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([
            { provide: _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_1__["MAT_TOOLTIP_DEFAULT_OPTIONS"], useValue: myCustomTooltipDefaults }
        ])], decls: 5, vars: 0, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/tooltip/overview#changing-the-default-delay-behavior"], ["mat-raised-button", "", "matTooltip", "By default, I delay", "aria-label", "Button that displays a tooltip that has custom delays through a default config"]], template: function TooltipModifiedDefaultsExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Tooltip with a show and hide delay ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, " Button with delay-default tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_2__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_1__["MatTooltip"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtbW9kaWZpZWQtZGVmYXVsdHMtZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsNkJBQTZCIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtbW9kaWZpZWQtZGVmYXVsdHMtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiogTm8gQ1NTIGZvciB0aGlzIGV4YW1wbGUgKi9cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipModifiedDefaultsExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-modified-defaults-example',
                templateUrl: 'tooltip-modified-defaults-example.html',
                styleUrls: ['tooltip-modified-defaults-example.css'],
                providers: [
                    { provide: _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_1__["MAT_TOOLTIP_DEFAULT_OPTIONS"], useValue: myCustomTooltipDefaults }
                ],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-overview-example.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-overview-example.ts ***!
  \**********************************************************************************/
/*! exports provided: TooltipOverviewExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipOverviewExample", function() { return TooltipOverviewExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");




/**
 * @title Basic tooltip
 */
class TooltipOverviewExample {
}
TooltipOverviewExample.ɵfac = function TooltipOverviewExample_Factory(t) { return new (t || TooltipOverviewExample)(); };
TooltipOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipOverviewExample, selectors: [["tooltip-overview-example"]], decls: 5, vars: 0, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/tooltip/overview"], ["mat-raised-button", "", "matTooltip", "Petit a petit, l\u2019oiseau fait son nid", "aria-label", "Button that displays a tooltip when focused or hovered over"]], template: function TooltipOverviewExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic tooltip ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, " Show tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_2__["MatTooltip"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtb3ZlcnZpZXctZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsNkJBQTZCIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtb3ZlcnZpZXctZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiogTm8gQ1NTIGZvciB0aGlzIGV4YW1wbGUgKi9cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipOverviewExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-overview-example',
                templateUrl: 'tooltip-overview-example.html',
                styleUrls: ['tooltip-overview-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/components/tooltip-position-example.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/components/tooltip-position-example.ts ***!
  \**********************************************************************************/
/*! exports provided: TooltipPositionExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipPositionExample", function() { return TooltipPositionExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");










function TooltipPositionExample_mat_option_7_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const positionOption_r505 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", positionOption_r505);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", positionOption_r505, " ");
} }
/**
 * @title Tooltip with a custom position
 */
class TooltipPositionExample {
    constructor() {
        this.positionOptions = ['after', 'before', 'above', 'below', 'left', 'right'];
        this.position = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](this.positionOptions[0]);
    }
}
TooltipPositionExample.ɵfac = function TooltipPositionExample_Factory(t) { return new (t || TooltipPositionExample)(); };
TooltipPositionExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipPositionExample, selectors: [["tooltip-position-example"]], decls: 10, vars: 3, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/tooltip/overview#positioning"], [1, "example-user-input"], [3, "formControl"], [3, "value", 4, "ngFor", "ngForOf"], ["mat-raised-button", "", "matTooltip", "Tooltip message", "aria-label", "Button that displays a tooltip in various positions", 3, "matTooltipPosition"], [3, "value"]], template: function TooltipPositionExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Tooltip with a custom position ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Tooltip position");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-select", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TooltipPositionExample_mat_option_7_Template, 2, 2, "mat-option", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, " Show tooltip\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.position);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.positionOptions);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matTooltipPosition", ctx.position.value);
    } }, directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButton"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_6__["MatTooltip"], _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MatOption"]], styles: [".example-user-input[_ngcontent-%COMP%] {\r\n  margin-right: 8px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvdG9vbHRpcC9jb21wb25lbnRzL3Rvb2x0aXAtcG9zaXRpb24tZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxpQkFBaUI7QUFDbkIiLCJmaWxlIjoic3JjL2FwcC9wb3B1cHMtYW5kLW1vZGFscy90b29sdGlwL2NvbXBvbmVudHMvdG9vbHRpcC1wb3NpdGlvbi1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLXVzZXItaW5wdXQge1xyXG4gIG1hcmdpbi1yaWdodDogOHB4O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipPositionExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'tooltip-position-example',
                templateUrl: 'tooltip-position-example.html',
                styleUrls: ['tooltip-position-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/tooltip-routing.module.ts":
/*!*********************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/tooltip-routing.module.ts ***!
  \*********************************************************************/
/*! exports provided: TooltipRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipRoutingModule", function() { return TooltipRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _tooltip_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./tooltip.component */ "./src/app/popups-and-modals/tooltip/tooltip.component.ts");





const routes = [{
        path: '',
        component: _tooltip_component__WEBPACK_IMPORTED_MODULE_2__["TooltipComponent"],
    }];
class TooltipRoutingModule {
}
TooltipRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: TooltipRoutingModule });
TooltipRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function TooltipRoutingModule_Factory(t) { return new (t || TooltipRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
        _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](TooltipRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/tooltip.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/tooltip.component.ts ***!
  \****************************************************************/
/*! exports provided: TooltipComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipComponent", function() { return TooltipComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _components_tooltip_overview_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./components/tooltip-overview-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-overview-example.ts");
/* harmony import */ var _components_tooltip_auto_hide_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./components/tooltip-auto-hide-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-auto-hide-example.ts");
/* harmony import */ var _components_tooltip_custom_class_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/tooltip-custom-class-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-custom-class-example.ts");
/* harmony import */ var _components_tooltip_delay_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/tooltip-delay-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-delay-example.ts");
/* harmony import */ var _components_tooltip_disabled_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/tooltip-disabled-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-disabled-example.ts");
/* harmony import */ var _components_tooltip_manual_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/tooltip-manual-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-manual-example.ts");
/* harmony import */ var _components_tooltip_message_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./components/tooltip-message-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-message-example.ts");
/* harmony import */ var _components_tooltip_modified_defaults_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/tooltip-modified-defaults-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-modified-defaults-example.ts");
/* harmony import */ var _components_tooltip_position_example__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./components/tooltip-position-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-position-example.ts");











class TooltipComponent {
}
TooltipComponent.ɵfac = function TooltipComponent_Factory(t) { return new (t || TooltipComponent)(); };
TooltipComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TooltipComponent, selectors: [["app-tooltip"]], decls: 9, vars: 0, template: function TooltipComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tooltip-overview-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "tooltip-auto-hide-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "tooltip-custom-class-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "tooltip-delay-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "tooltip-disabled-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "tooltip-manual-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "tooltip-message-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "tooltip-modified-defaults-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "tooltip-position-example");
    } }, directives: [_components_tooltip_overview_example__WEBPACK_IMPORTED_MODULE_1__["TooltipOverviewExample"], _components_tooltip_auto_hide_example__WEBPACK_IMPORTED_MODULE_2__["TooltipAutoHideExample"], _components_tooltip_custom_class_example__WEBPACK_IMPORTED_MODULE_3__["TooltipCustomClassExample"], _components_tooltip_delay_example__WEBPACK_IMPORTED_MODULE_4__["TooltipDelayExample"], _components_tooltip_disabled_example__WEBPACK_IMPORTED_MODULE_5__["TooltipDisabledExample"], _components_tooltip_manual_example__WEBPACK_IMPORTED_MODULE_6__["TooltipManualExample"], _components_tooltip_message_example__WEBPACK_IMPORTED_MODULE_7__["TooltipMessageExample"], _components_tooltip_modified_defaults_example__WEBPACK_IMPORTED_MODULE_8__["TooltipModifiedDefaultsExample"], _components_tooltip_position_example__WEBPACK_IMPORTED_MODULE_9__["TooltipPositionExample"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-tooltip',
                templateUrl: './tooltip.component.html',
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/popups-and-modals/tooltip/tooltip.module.ts":
/*!*************************************************************!*\
  !*** ./src/app/popups-and-modals/tooltip/tooltip.module.ts ***!
  \*************************************************************/
/*! exports provided: TooltipModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TooltipModule", function() { return TooltipModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _tooltip_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./tooltip-routing.module */ "./src/app/popups-and-modals/tooltip/tooltip-routing.module.ts");
/* harmony import */ var _components_tooltip_auto_hide_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/tooltip-auto-hide-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-auto-hide-example.ts");
/* harmony import */ var _tooltip_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./tooltip.component */ "./src/app/popups-and-modals/tooltip/tooltip.component.ts");
/* harmony import */ var _components_tooltip_custom_class_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/tooltip-custom-class-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-custom-class-example.ts");
/* harmony import */ var _components_tooltip_delay_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/tooltip-delay-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-delay-example.ts");
/* harmony import */ var _components_tooltip_disabled_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./components/tooltip-disabled-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-disabled-example.ts");
/* harmony import */ var _components_tooltip_message_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/tooltip-message-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-message-example.ts");
/* harmony import */ var _components_tooltip_modified_defaults_example__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./components/tooltip-modified-defaults-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-modified-defaults-example.ts");
/* harmony import */ var _components_tooltip_position_example__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./components/tooltip-position-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-position-example.ts");
/* harmony import */ var _components_tooltip_manual_example__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./components/tooltip-manual-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-manual-example.ts");
/* harmony import */ var _components_tooltip_overview_example__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./components/tooltip-overview-example */ "./src/app/popups-and-modals/tooltip/components/tooltip-overview-example.ts");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
/* harmony import */ var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/material/checkbox */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
/* harmony import */ var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/cdk/scrolling */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/scrolling.js");






















class TooltipModule {
}
TooltipModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: TooltipModule });
TooltipModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function TooltipModule_Factory(t) { return new (t || TooltipModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _tooltip_routing_module__WEBPACK_IMPORTED_MODULE_2__["TooltipRoutingModule"],
            _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"],
            _angular_material_select__WEBPACK_IMPORTED_MODULE_14__["MatSelectModule"],
            _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_15__["MatTooltipModule"],
            _angular_material_button__WEBPACK_IMPORTED_MODULE_16__["MatButtonModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_17__["ReactiveFormsModule"],
            _angular_material_input__WEBPACK_IMPORTED_MODULE_18__["MatInputModule"],
            _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_19__["MatCheckboxModule"],
            _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_20__["ScrollingModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](TooltipModule, { declarations: [_tooltip_component__WEBPACK_IMPORTED_MODULE_4__["TooltipComponent"],
        _components_tooltip_auto_hide_example__WEBPACK_IMPORTED_MODULE_3__["TooltipAutoHideExample"],
        _components_tooltip_custom_class_example__WEBPACK_IMPORTED_MODULE_5__["TooltipCustomClassExample"],
        _components_tooltip_delay_example__WEBPACK_IMPORTED_MODULE_6__["TooltipDelayExample"],
        _components_tooltip_disabled_example__WEBPACK_IMPORTED_MODULE_7__["TooltipDisabledExample"],
        _components_tooltip_message_example__WEBPACK_IMPORTED_MODULE_8__["TooltipMessageExample"],
        _components_tooltip_modified_defaults_example__WEBPACK_IMPORTED_MODULE_9__["TooltipModifiedDefaultsExample"],
        _components_tooltip_position_example__WEBPACK_IMPORTED_MODULE_10__["TooltipPositionExample"],
        _components_tooltip_manual_example__WEBPACK_IMPORTED_MODULE_11__["TooltipManualExample"],
        _components_tooltip_overview_example__WEBPACK_IMPORTED_MODULE_12__["TooltipOverviewExample"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _tooltip_routing_module__WEBPACK_IMPORTED_MODULE_2__["TooltipRoutingModule"],
        _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"],
        _angular_material_select__WEBPACK_IMPORTED_MODULE_14__["MatSelectModule"],
        _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_15__["MatTooltipModule"],
        _angular_material_button__WEBPACK_IMPORTED_MODULE_16__["MatButtonModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_17__["ReactiveFormsModule"],
        _angular_material_input__WEBPACK_IMPORTED_MODULE_18__["MatInputModule"],
        _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_19__["MatCheckboxModule"],
        _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_20__["ScrollingModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TooltipModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [
                    _tooltip_component__WEBPACK_IMPORTED_MODULE_4__["TooltipComponent"],
                    _components_tooltip_auto_hide_example__WEBPACK_IMPORTED_MODULE_3__["TooltipAutoHideExample"],
                    _components_tooltip_custom_class_example__WEBPACK_IMPORTED_MODULE_5__["TooltipCustomClassExample"],
                    _components_tooltip_delay_example__WEBPACK_IMPORTED_MODULE_6__["TooltipDelayExample"],
                    _components_tooltip_disabled_example__WEBPACK_IMPORTED_MODULE_7__["TooltipDisabledExample"],
                    _components_tooltip_message_example__WEBPACK_IMPORTED_MODULE_8__["TooltipMessageExample"],
                    _components_tooltip_modified_defaults_example__WEBPACK_IMPORTED_MODULE_9__["TooltipModifiedDefaultsExample"],
                    _components_tooltip_position_example__WEBPACK_IMPORTED_MODULE_10__["TooltipPositionExample"],
                    _components_tooltip_manual_example__WEBPACK_IMPORTED_MODULE_11__["TooltipManualExample"],
                    _components_tooltip_overview_example__WEBPACK_IMPORTED_MODULE_12__["TooltipOverviewExample"],
                ],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _tooltip_routing_module__WEBPACK_IMPORTED_MODULE_2__["TooltipRoutingModule"],
                    _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"],
                    _angular_material_select__WEBPACK_IMPORTED_MODULE_14__["MatSelectModule"],
                    _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_15__["MatTooltipModule"],
                    _angular_material_button__WEBPACK_IMPORTED_MODULE_16__["MatButtonModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_17__["ReactiveFormsModule"],
                    _angular_material_input__WEBPACK_IMPORTED_MODULE_18__["MatInputModule"],
                    _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_19__["MatCheckboxModule"],
                    _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_20__["ScrollingModule"]
                ]
            }]
    }], null, null); })();


/***/ })

}]);
//# sourceMappingURL=popups-and-modals-tooltip-tooltip-module-es2015.js.map