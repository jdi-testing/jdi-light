(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["form-controls-radio-button-radio-buttons-module"],{

/***/ "./src/app/form-controls/radio-button/components/radio-ng-model-example.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/form-controls/radio-button/components/radio-ng-model-example.ts ***!
  \*********************************************************************************/
/*! exports provided: RadioNgModelExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RadioNgModelExample", function() { return RadioNgModelExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");





function RadioNgModelExample_mat_radio_button_5_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-radio-button", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const season_r467 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("id", "favorite-season-" + season_r467.toLowerCase());
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", season_r467);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", season_r467, " ");
} }
/**
 * @title Radios with ngModel
 */
class RadioNgModelExample {
    constructor() {
        this.seasons = ['Winter', 'Spring', 'Summer', 'Autumn'];
    }
}
RadioNgModelExample.ɵfac = function RadioNgModelExample_Factory(t) { return new (t || RadioNgModelExample)(); };
RadioNgModelExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: RadioNgModelExample, selectors: [["radio-ng-model-example"]], decls: 8, vars: 3, consts: [[1, "example-h2"], ["id", "example-radio-group-label"], ["id", "season-radio-group", "aria-labelledby", "example-radio-group-label", 1, "example-radio-group", 3, "ngModel", "ngModelChange"], ["class", "example-radio-button", 3, "id", "value", 4, "ngFor", "ngForOf"], ["id", "your-favorite-season-text"], [1, "example-radio-button", 3, "id", "value"]], template: function RadioNgModelExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Radios with ngModel");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "label", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "Pick your favorite season");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-radio-group", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function RadioNgModelExample_Template_mat_radio_group_ngModelChange_4_listener($event) { return ctx.favoriteSeason = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, RadioNgModelExample_mat_radio_button_5_Template, 2, 3, "mat-radio-button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.favoriteSeason);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.seasons);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("Your favorite season is: ", ctx.favoriteSeason, "");
    } }, directives: [_angular_material_radio__WEBPACK_IMPORTED_MODULE_1__["MatRadioGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgModel"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_1__["MatRadioButton"]], styles: [".example-radio-group[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  flex-direction: column;\r\n  margin: 15px 0;\r\n}\r\n\r\n.example-radio-button[_ngcontent-%COMP%] {\r\n  margin: 5px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9yYWRpby1idXR0b24vY29tcG9uZW50cy9yYWRpby1uZy1tb2RlbC1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGFBQWE7RUFDYixzQkFBc0I7RUFDdEIsY0FBYztBQUNoQjs7QUFFQTtFQUNFLFdBQVc7QUFDYiIsImZpbGUiOiJzcmMvYXBwL2Zvcm0tY29udHJvbHMvcmFkaW8tYnV0dG9uL2NvbXBvbmVudHMvcmFkaW8tbmctbW9kZWwtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuZXhhbXBsZS1yYWRpby1ncm91cCB7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xyXG4gIG1hcmdpbjogMTVweCAwO1xyXG59XHJcblxyXG4uZXhhbXBsZS1yYWRpby1idXR0b24ge1xyXG4gIG1hcmdpbjogNXB4O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](RadioNgModelExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'radio-ng-model-example',
                templateUrl: 'radio-ng-model-example.html',
                styleUrls: ['radio-ng-model-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/form-controls/radio-button/components/radio-overview-example.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/form-controls/radio-button/components/radio-overview-example.ts ***!
  \*********************************************************************************/
/*! exports provided: RadioOverviewExample */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RadioOverviewExample", function() { return RadioOverviewExample; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");



/**
 * @title Basic radios
 */
class RadioOverviewExample {
}
RadioOverviewExample.ɵfac = function RadioOverviewExample_Factory(t) { return new (t || RadioOverviewExample)(); };
RadioOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: RadioOverviewExample, selectors: [["radio-overview-example"]], decls: 8, vars: 2, consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/radio/overview"], ["id", "basic-radio-group", "aria-label", "Select an option"], ["value", "1", 3, "id"], ["value", "2", 3, "id"]], template: function RadioOverviewExample_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic radios ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-radio-group", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-radio-button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Option 1");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-radio-button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Option 2");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("id", "radio-option-one");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("id", "radio-option-two");
    } }, directives: [_angular_material_radio__WEBPACK_IMPORTED_MODULE_1__["MatRadioGroup"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_1__["MatRadioButton"]], styles: [".mat-radio-button[_ngcontent-%COMP%]    ~ .mat-radio-button[_ngcontent-%COMP%] {\r\n  margin-left: 16px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9yYWRpby1idXR0b24vY29tcG9uZW50cy9yYWRpby1vdmVydmlldy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGlCQUFpQjtBQUNuQiIsImZpbGUiOiJzcmMvYXBwL2Zvcm0tY29udHJvbHMvcmFkaW8tYnV0dG9uL2NvbXBvbmVudHMvcmFkaW8tb3ZlcnZpZXctZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LXJhZGlvLWJ1dHRvbiB+IC5tYXQtcmFkaW8tYnV0dG9uIHtcclxuICBtYXJnaW4tbGVmdDogMTZweDtcclxufVxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](RadioOverviewExample, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'radio-overview-example',
                templateUrl: 'radio-overview-example.html',
                styleUrls: ['radio-overview-example.css'],
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/form-controls/radio-button/radio-buttons-routing.module.ts":
/*!****************************************************************************!*\
  !*** ./src/app/form-controls/radio-button/radio-buttons-routing.module.ts ***!
  \****************************************************************************/
/*! exports provided: RadioButtonsRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RadioButtonsRoutingModule", function() { return RadioButtonsRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _radio_buttons_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./radio-buttons.component */ "./src/app/form-controls/radio-button/radio-buttons.component.ts");





const routes = [{
        path: '',
        component: _radio_buttons_component__WEBPACK_IMPORTED_MODULE_2__["RadioButtonsComponent"],
    }];
class RadioButtonsRoutingModule {
}
RadioButtonsRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: RadioButtonsRoutingModule });
RadioButtonsRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function RadioButtonsRoutingModule_Factory(t) { return new (t || RadioButtonsRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
        _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](RadioButtonsRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](RadioButtonsRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/form-controls/radio-button/radio-buttons.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/form-controls/radio-button/radio-buttons.component.ts ***!
  \***********************************************************************/
/*! exports provided: RadioButtonsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RadioButtonsComponent", function() { return RadioButtonsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _components_radio_ng_model_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./components/radio-ng-model-example */ "./src/app/form-controls/radio-button/components/radio-ng-model-example.ts");
/* harmony import */ var _components_radio_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./components/radio-overview-example */ "./src/app/form-controls/radio-button/components/radio-overview-example.ts");




class RadioButtonsComponent {
}
RadioButtonsComponent.ɵfac = function RadioButtonsComponent_Factory(t) { return new (t || RadioButtonsComponent)(); };
RadioButtonsComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: RadioButtonsComponent, selectors: [["app-radio-buttons"]], decls: 2, vars: 0, template: function RadioButtonsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "radio-ng-model-example");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "radio-overview-example");
    } }, directives: [_components_radio_ng_model_example__WEBPACK_IMPORTED_MODULE_1__["RadioNgModelExample"], _components_radio_overview_example__WEBPACK_IMPORTED_MODULE_2__["RadioOverviewExample"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](RadioButtonsComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-radio-buttons',
                templateUrl: './radio-buttons.component.html',
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/form-controls/radio-button/radio-buttons.module.ts":
/*!********************************************************************!*\
  !*** ./src/app/form-controls/radio-button/radio-buttons.module.ts ***!
  \********************************************************************/
/*! exports provided: RadioButtonsModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RadioButtonsModule", function() { return RadioButtonsModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _radio_buttons_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./radio-buttons-routing.module */ "./src/app/form-controls/radio-button/radio-buttons-routing.module.ts");
/* harmony import */ var _radio_buttons_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./radio-buttons.component */ "./src/app/form-controls/radio-button/radio-buttons.component.ts");
/* harmony import */ var _components_radio_ng_model_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/radio-ng-model-example */ "./src/app/form-controls/radio-button/components/radio-ng-model-example.ts");
/* harmony import */ var _components_radio_overview_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/radio-overview-example */ "./src/app/form-controls/radio-button/components/radio-overview-example.ts");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");









class RadioButtonsModule {
}
RadioButtonsModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: RadioButtonsModule });
RadioButtonsModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function RadioButtonsModule_Factory(t) { return new (t || RadioButtonsModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _radio_buttons_routing_module__WEBPACK_IMPORTED_MODULE_2__["RadioButtonsRoutingModule"],
            _angular_material_radio__WEBPACK_IMPORTED_MODULE_6__["MatRadioModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](RadioButtonsModule, { declarations: [_radio_buttons_component__WEBPACK_IMPORTED_MODULE_3__["RadioButtonsComponent"], _components_radio_ng_model_example__WEBPACK_IMPORTED_MODULE_4__["RadioNgModelExample"], _components_radio_overview_example__WEBPACK_IMPORTED_MODULE_5__["RadioOverviewExample"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _radio_buttons_routing_module__WEBPACK_IMPORTED_MODULE_2__["RadioButtonsRoutingModule"],
        _angular_material_radio__WEBPACK_IMPORTED_MODULE_6__["MatRadioModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](RadioButtonsModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_radio_buttons_component__WEBPACK_IMPORTED_MODULE_3__["RadioButtonsComponent"], _components_radio_ng_model_example__WEBPACK_IMPORTED_MODULE_4__["RadioNgModelExample"], _components_radio_overview_example__WEBPACK_IMPORTED_MODULE_5__["RadioOverviewExample"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _radio_buttons_routing_module__WEBPACK_IMPORTED_MODULE_2__["RadioButtonsRoutingModule"],
                    _angular_material_radio__WEBPACK_IMPORTED_MODULE_6__["MatRadioModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"]
                ]
            }]
    }], null, null); })();


/***/ })

}]);
//# sourceMappingURL=form-controls-radio-button-radio-buttons-module-es2015.js.map