(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["form-controls-checkbox-checkbox-module"], {
    /***/"./src/app/form-controls/checkbox/checkbox-routing.module.ts":
    /*!*******************************************************************!*\
      !*** ./src/app/form-controls/checkbox/checkbox-routing.module.ts ***!
      \*******************************************************************/
    /*! exports provided: CheckboxRoutingModule */
    /***/
    function srcAppFormControlsCheckboxCheckboxRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CheckboxRoutingModule", function () {
        return CheckboxRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _checkbox_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./checkbox.component */"./src/app/form-controls/checkbox/checkbox.component.ts");
      var routes = [{
        path: '',
        component: _checkbox_component__WEBPACK_IMPORTED_MODULE_2__["CheckboxComponent"]
      }];
      var CheckboxRoutingModule = /*#__PURE__*/_createClass(function CheckboxRoutingModule() {
        _classCallCheck(this, CheckboxRoutingModule);
      });
      CheckboxRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: CheckboxRoutingModule
      });
      CheckboxRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function CheckboxRoutingModule_Factory(t) {
          return new (t || CheckboxRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CheckboxRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CheckboxRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/checkbox/checkbox.component.ts":
    /*!**************************************************************!*\
      !*** ./src/app/form-controls/checkbox/checkbox.component.ts ***!
      \**************************************************************/
    /*! exports provided: CheckboxComponent */
    /***/
    function srcAppFormControlsCheckboxCheckboxComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CheckboxComponent", function () {
        return CheckboxComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_checkbox_configurable_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/checkbox-configurable-example */"./src/app/form-controls/checkbox/components/checkbox-configurable-example.ts");
      /* harmony import */
      var _components_checkbox_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/checkbox-overview-example */"./src/app/form-controls/checkbox/components/checkbox-overview-example.ts");
      var CheckboxComponent = /*#__PURE__*/_createClass(function CheckboxComponent() {
        _classCallCheck(this, CheckboxComponent);
      });
      CheckboxComponent.ɵfac = function CheckboxComponent_Factory(t) {
        return new (t || CheckboxComponent)();
      };
      CheckboxComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: CheckboxComponent,
        selectors: [["app-checkbox"]],
        decls: 2,
        vars: 0,
        template: function CheckboxComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "checkbox-configurable-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "checkbox-overview-example");
          }
        },
        directives: [_components_checkbox_configurable_example__WEBPACK_IMPORTED_MODULE_1__["CheckboxConfigurableExample"], _components_checkbox_overview_example__WEBPACK_IMPORTED_MODULE_2__["CheckboxOverviewExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CheckboxComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-checkbox',
            templateUrl: './checkbox.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/checkbox/checkbox.module.ts":
    /*!***********************************************************!*\
      !*** ./src/app/form-controls/checkbox/checkbox.module.ts ***!
      \***********************************************************/
    /*! exports provided: CheckboxModule */
    /***/
    function srcAppFormControlsCheckboxCheckboxModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CheckboxModule", function () {
        return CheckboxModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _checkbox_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./checkbox-routing.module */"./src/app/form-controls/checkbox/checkbox-routing.module.ts");
      /* harmony import */
      var _checkbox_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./checkbox.component */"./src/app/form-controls/checkbox/checkbox.component.ts");
      /* harmony import */
      var _components_checkbox_configurable_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/checkbox-configurable-example */"./src/app/form-controls/checkbox/components/checkbox-configurable-example.ts");
      /* harmony import */
      var _components_checkbox_overview_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/checkbox-overview-example */"./src/app/form-controls/checkbox/components/checkbox-overview-example.ts");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      /* harmony import */
      var _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/material/radio */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      var CheckboxModule = /*#__PURE__*/_createClass(function CheckboxModule() {
        _classCallCheck(this, CheckboxModule);
      });
      CheckboxModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: CheckboxModule
      });
      CheckboxModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function CheckboxModule_Factory(t) {
          return new (t || CheckboxModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _checkbox_routing_module__WEBPACK_IMPORTED_MODULE_2__["CheckboxRoutingModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_6__["MatCardModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_7__["MatCheckboxModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CheckboxModule, {
          declarations: [_checkbox_component__WEBPACK_IMPORTED_MODULE_3__["CheckboxComponent"], _components_checkbox_configurable_example__WEBPACK_IMPORTED_MODULE_4__["CheckboxConfigurableExample"], _components_checkbox_overview_example__WEBPACK_IMPORTED_MODULE_5__["CheckboxOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _checkbox_routing_module__WEBPACK_IMPORTED_MODULE_2__["CheckboxRoutingModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_6__["MatCardModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_7__["MatCheckboxModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CheckboxModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_checkbox_component__WEBPACK_IMPORTED_MODULE_3__["CheckboxComponent"], _components_checkbox_configurable_example__WEBPACK_IMPORTED_MODULE_4__["CheckboxConfigurableExample"], _components_checkbox_overview_example__WEBPACK_IMPORTED_MODULE_5__["CheckboxOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _checkbox_routing_module__WEBPACK_IMPORTED_MODULE_2__["CheckboxRoutingModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_6__["MatCardModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_7__["MatCheckboxModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/checkbox/components/checkbox-configurable-example.ts":
    /*!************************************************************************************!*\
      !*** ./src/app/form-controls/checkbox/components/checkbox-configurable-example.ts ***!
      \************************************************************************************/
    /*! exports provided: CheckboxConfigurableExample */
    /***/
    function srcAppFormControlsCheckboxComponentsCheckboxConfigurableExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CheckboxConfigurableExample", function () {
        return CheckboxConfigurableExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_radio__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/radio */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");

      /**
       * @title Configurable checkbox
       */
      var CheckboxConfigurableExample = /*#__PURE__*/_createClass(function CheckboxConfigurableExample() {
        _classCallCheck(this, CheckboxConfigurableExample);
        this.checked = false;
        this.indeterminate = false;
        this.labelPosition = 'after';
        this.disabled = false;
      });
      CheckboxConfigurableExample.ɵfac = function CheckboxConfigurableExample_Factory(t) {
        return new (t || CheckboxConfigurableExample)();
      };
      CheckboxConfigurableExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: CheckboxConfigurableExample,
        selectors: [["checkbox-configurable-example"]],
        decls: 29,
        vars: 8,
        consts: [[1, "example-h2"], [1, "example-section"], ["id", "checked-checkbox", 1, "example-margin", 3, "ngModel", "ngModelChange"], ["id", "indeterminate-checkbox", 1, "example-margin", 3, "ngModel", "ngModelChange"], [1, "example-margin"], [3, "ngModel", "ngModelChange"], ["id", "align-after-radio-button", "value", "after", 1, "example-margin"], ["id", "align-before-radio-button", "value", "before", 1, "example-margin"], ["id", "disabled-checkbox", 1, "example-margin", 3, "ngModel", "ngModelChange"], [1, "result"], ["id", "result-checkbox", 1, "example-margin", 3, "ngModel", "indeterminate", "labelPosition", "disabled", "ngModelChange", "indeterminateChange"]],
        template: function CheckboxConfigurableExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Configurable checkbox");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-card");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-card-content");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Checkbox configuration");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-checkbox", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CheckboxConfigurableExample_Template_mat_checkbox_ngModelChange_7_listener($event) {
              return ctx.checked = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, " Checked ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-checkbox", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CheckboxConfigurableExample_Template_mat_checkbox_ngModelChange_9_listener($event) {
              return ctx.indeterminate = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, " Indeterminate ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "label", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "Align:");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-radio-group", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CheckboxConfigurableExample_Template_mat_radio_group_ngModelChange_14_listener($event) {
              return ctx.labelPosition = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "mat-radio-button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, " After ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "mat-radio-button", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, " Before ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "mat-checkbox", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CheckboxConfigurableExample_Template_mat_checkbox_ngModelChange_20_listener($event) {
              return ctx.disabled = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21, " Disabled ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "mat-card", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "mat-card-content");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25, "Result");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "mat-checkbox", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CheckboxConfigurableExample_Template_mat_checkbox_ngModelChange_27_listener($event) {
              return ctx.checked = $event;
            })("indeterminateChange", function CheckboxConfigurableExample_Template_mat_checkbox_indeterminateChange_27_listener($event) {
              return ctx.indeterminate = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](28, " I'm a checkbox ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.checked);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.indeterminate);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.labelPosition);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.disabled);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.checked)("indeterminate", ctx.indeterminate)("labelPosition", ctx.labelPosition)("disabled", ctx.disabled);
          }
        },
        directives: [_angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCard"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardContent"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_2__["MatCheckbox"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgModel"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_4__["MatRadioGroup"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_4__["MatRadioButton"]],
        styles: [".example-h2[_ngcontent-%COMP%] {\r\n  margin: 10px;\r\n}\r\n\r\n.example-section[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-content: center;\r\n  align-items: center;\r\n  height: 60px;\r\n}\r\n\r\n.example-margin[_ngcontent-%COMP%] {\r\n  margin: 0 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9jaGVja2JveC9jb21wb25lbnRzL2NoZWNrYm94LWNvbmZpZ3VyYWJsZS1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLFlBQVk7QUFDZDs7QUFFQTtFQUNFLGFBQWE7RUFDYixxQkFBcUI7RUFDckIsbUJBQW1CO0VBQ25CLFlBQVk7QUFDZDs7QUFFQTtFQUNFLGNBQWM7QUFDaEIiLCJmaWxlIjoic3JjL2FwcC9mb3JtLWNvbnRyb2xzL2NoZWNrYm94L2NvbXBvbmVudHMvY2hlY2tib3gtY29uZmlndXJhYmxlLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtaDIge1xyXG4gIG1hcmdpbjogMTBweDtcclxufVxyXG5cclxuLmV4YW1wbGUtc2VjdGlvbiB7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBhbGlnbi1jb250ZW50OiBjZW50ZXI7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxuICBoZWlnaHQ6IDYwcHg7XHJcbn1cclxuXHJcbi5leGFtcGxlLW1hcmdpbiB7XHJcbiAgbWFyZ2luOiAwIDEwcHg7XHJcbn1cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CheckboxConfigurableExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'checkbox-configurable-example',
            templateUrl: 'checkbox-configurable-example.html',
            styleUrls: ['checkbox-configurable-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/checkbox/components/checkbox-overview-example.ts":
    /*!********************************************************************************!*\
      !*** ./src/app/form-controls/checkbox/components/checkbox-overview-example.ts ***!
      \********************************************************************************/
    /*! exports provided: CheckboxOverviewExample */
    /***/
    function srcAppFormControlsCheckboxComponentsCheckboxOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CheckboxOverviewExample", function () {
        return CheckboxOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");

      /**
       * @title Basic checkboxes
       */
      var CheckboxOverviewExample = /*#__PURE__*/_createClass(function CheckboxOverviewExample() {
        _classCallCheck(this, CheckboxOverviewExample);
      });
      CheckboxOverviewExample.ɵfac = function CheckboxOverviewExample_Factory(t) {
        return new (t || CheckboxOverviewExample)();
      };
      CheckboxOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: CheckboxOverviewExample,
        selectors: [["checkbox-overview-example"]],
        decls: 6,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/checkbox/overview"], [1, "example-section"], ["id", "basic-checkbox"]],
        template: function CheckboxOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic checkbox ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "section", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-checkbox", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Check me!");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_checkbox__WEBPACK_IMPORTED_MODULE_1__["MatCheckbox"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CheckboxOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'checkbox-overview-example',
            templateUrl: 'checkbox-overview-example.html'
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=form-controls-checkbox-checkbox-module-es5.js.map