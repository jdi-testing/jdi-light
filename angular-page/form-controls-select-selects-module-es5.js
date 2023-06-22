(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["form-controls-select-selects-module"], {
    /***/"./src/app/form-controls/select/components/select-custom-trigger-example.ts":
    /*!**********************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-custom-trigger-example.ts ***!
      \**********************************************************************************/
    /*! exports provided: SelectCustomTriggerExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectCustomTriggerExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectCustomTriggerExample", function () {
        return SelectCustomTriggerExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      function SelectCustomTriggerExample_span_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 5);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r352 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate2"](" (+", ctx_r352.toppings.value.length - 1, " ", (ctx_r352.toppings.value == null ? null : ctx_r352.toppings.value.length) === 2 ? "other" : "others", ") ");
        }
      }
      function SelectCustomTriggerExample_mat_option_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var topping_r354 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", topping_r354);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](topping_r354);
        }
      }
      /** @title Select with custom trigger text */
      var SelectCustomTriggerExample = /*#__PURE__*/_createClass(function SelectCustomTriggerExample() {
        _classCallCheck(this, SelectCustomTriggerExample);
        this.toppings = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]();
        this.toppingList = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
      });
      SelectCustomTriggerExample.ɵfac = function SelectCustomTriggerExample_Factory(t) {
        return new (t || SelectCustomTriggerExample)();
      };
      SelectCustomTriggerExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectCustomTriggerExample,
        selectors: [["select-custom-trigger-example"]],
        decls: 11,
        vars: 4,
        consts: [[1, "example-h2"], ["href", ""], ["multiple", "", "id", "custom-trigger-text-select", 3, "formControl"], ["class", "example-additional-selection", 4, "ngIf"], [3, "value", 4, "ngFor", "ngForOf"], [1, "example-additional-selection"], [3, "value"]],
        template: function SelectCustomTriggerExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with custom trigger text ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Toppings");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-select-trigger");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, SelectCustomTriggerExample_span_9_Template, 2, 2, "span", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, SelectCustomTriggerExample_mat_option_10_Template, 2, 2, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.toppings);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", ctx.toppings.value ? ctx.toppings.value[0] : "", " ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx.toppings.value == null ? null : ctx.toppings.value.length) > 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.toppingList);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelectTrigger"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_material_core__WEBPACK_IMPORTED_MODULE_5__["MatOption"]],
        styles: [".example-additional-selection[_ngcontent-%COMP%] {\r\n  opacity: 0.75;\r\n  font-size: 0.75em;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9zZWxlY3QvY29tcG9uZW50cy9zZWxlY3QtY3VzdG9tLXRyaWdnZXItZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxhQUFhO0VBQ2IsaUJBQWlCO0FBQ25CIiwiZmlsZSI6InNyYy9hcHAvZm9ybS1jb250cm9scy9zZWxlY3QvY29tcG9uZW50cy9zZWxlY3QtY3VzdG9tLXRyaWdnZXItZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuZXhhbXBsZS1hZGRpdGlvbmFsLXNlbGVjdGlvbiB7XHJcbiAgb3BhY2l0eTogMC43NTtcclxuICBmb250LXNpemU6IDAuNzVlbTtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectCustomTriggerExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-custom-trigger-example',
            templateUrl: 'select-custom-trigger-example.html',
            styleUrls: ['select-custom-trigger-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-disabled-example.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-disabled-example.ts ***!
      \****************************************************************************/
    /*! exports provided: SelectDisabledExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectDisabledExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectDisabledExample", function () {
        return SelectDisabledExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");

      /** @title Disabled select */
      var SelectDisabledExample = /*#__PURE__*/_createClass(function SelectDisabledExample() {
        _classCallCheck(this, SelectDisabledExample);
        this.disableSelect = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](false);
      });
      SelectDisabledExample.ɵfac = function SelectDisabledExample_Factory(t) {
        return new (t || SelectDisabledExample)();
      };
      SelectDisabledExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectDisabledExample,
        selectors: [["select-disabled-example"]],
        decls: 33,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#disabling-the-select-or-individual-options"], ["id", "disable-checkbox-select", 3, "formControl"], ["id", "disable-mat-select", 3, "disabled"], ["value", "option1"], ["value", "option2", "disabled", ""], ["value", "option3"], ["matNativeControl", "", "id", "disable-native-select", 3, "disabled"], ["value", "", "selected", "", "disabled", ""], ["value", "volvo"], ["value", "saab", "disabled", ""], ["value", "mercedes"], ["value", "audi"]],
        template: function SelectDisabledExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Disabled select ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-checkbox", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Disable select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "mat-select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Choose an option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-select", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "Option 1");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-option", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "Option 2 (disabled)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "mat-option", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "Option 3");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "native html select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22, "Choose an option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "select", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](24, "option", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "option", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "Volvo");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "option", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](28, "Saab");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "option", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](30, "Mercedes");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "option", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](32, "Audi");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.disableSelect);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.disableSelect.value);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.disableSelect.value);
          }
        },
        directives: [_angular_material_checkbox__WEBPACK_IMPORTED_MODULE_2__["MatCheckbox"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_3__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_3__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_4__["MatSelect"], _angular_material_core__WEBPACK_IMPORTED_MODULE_5__["MatOption"], _angular_material_input__WEBPACK_IMPORTED_MODULE_6__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_x"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectDisabledExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-disabled-example',
            templateUrl: 'select-disabled-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-error-state-matcher-example.ts":
    /*!***************************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-error-state-matcher-example.ts ***!
      \***************************************************************************************/
    /*! exports provided: MyErrorStateMatcher, SelectErrorStateMatcherExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectErrorStateMatcherExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MyErrorStateMatcher", function () {
        return MyErrorStateMatcher;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectErrorStateMatcherExample", function () {
        return SelectErrorStateMatcherExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      function SelectErrorStateMatcherExample_mat_error_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-error", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " You must make a selection ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function SelectErrorStateMatcherExample_mat_error_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-error", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Your selection is invalid ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function SelectErrorStateMatcherExample_mat_error_30_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-error", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " You must make a selection ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function SelectErrorStateMatcherExample_mat_error_31_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-error", 17);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Your selection is invalid ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      /** Error when invalid control is dirty, touched, or submitted. */
      var MyErrorStateMatcher = /*#__PURE__*/function () {
        function MyErrorStateMatcher() {
          _classCallCheck(this, MyErrorStateMatcher);
        }
        _createClass(MyErrorStateMatcher, [{
          key: "isErrorState",
          value: function isErrorState(control, form) {
            var isSubmitted = form && form.submitted;
            return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
          }
        }]);
        return MyErrorStateMatcher;
      }();
      /** @title Select with a custom ErrorStateMatcher */
      var SelectErrorStateMatcherExample = /*#__PURE__*/_createClass(function SelectErrorStateMatcherExample() {
        _classCallCheck(this, SelectErrorStateMatcherExample);
        this.selected = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('valid', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern('valid')]);
        this.selectFormControl = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('valid', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern('valid')]);
        this.nativeSelectFormControl = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('valid', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern('valid')]);
        this.matcher = new MyErrorStateMatcher();
      });
      SelectErrorStateMatcherExample.ɵfac = function SelectErrorStateMatcherExample_Factory(t) {
        return new (t || SelectErrorStateMatcherExample)();
      };
      SelectErrorStateMatcherExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectErrorStateMatcherExample,
        selectors: [["select-error-state-matcher-example"]],
        decls: 32,
        vars: 8,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#changing-when-error-messages-are-shown"], ["id", "mat-error-state-matcher-select", 3, "formControl", "errorStateMatcher"], ["value", "valid"], ["value", "invalid"], ["id", "mat-error-state-matcher-hint"], ["id", "mat-error-state-matcher-selection", 4, "ngIf"], ["id", "mat-error-state-matcher-invalid", 4, "ngIf"], [1, "demo-full-width"], ["matNativeControl", "", "id", "native-error-state-matcher-select", 3, "formControl", "errorStateMatcher"], ["value", ""], ["value", "valid", "selected", ""], ["id", "native-error-state-matcher-selection", 4, "ngIf"], ["id", "native-error-state-matcher-invalid", 4, "ngIf"], ["id", "mat-error-state-matcher-selection"], ["id", "mat-error-state-matcher-invalid"], ["id", "native-error-state-matcher-selection"], ["id", "native-error-state-matcher-invalid"]],
        template: function SelectErrorStateMatcherExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with a custom ErrorStateMatcher ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "mat-select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Choose one");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Clear");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "Valid option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Invalid option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "mat-hint", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "Errors appear instantly!");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, SelectErrorStateMatcherExample_mat_error_17_Template, 2, 0, "mat-error", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, SelectErrorStateMatcherExample_mat_error_18_Template, 2, 0, "mat-error", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "native html select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "mat-form-field", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, "Choose one");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "select", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](25, "option", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "option", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, "Valid option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](29, "Invalid option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](30, SelectErrorStateMatcherExample_mat_error_30_Template, 2, 0, "mat-error", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](31, SelectErrorStateMatcherExample_mat_error_31_Template, 2, 0, "mat-error", 13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.selected)("errorStateMatcher", ctx.matcher);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.selected.hasError("required"));
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.selected.hasError("pattern") && !ctx.selected.hasError("required"));
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.nativeSelectFormControl)("errorStateMatcher", ctx.matcher);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.nativeSelectFormControl.hasError("required"));
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.nativeSelectFormControl.hasError("pattern") && !ctx.nativeSelectFormControl.hasError("required"));
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatOption"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatHint"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgIf"], _angular_material_input__WEBPACK_IMPORTED_MODULE_6__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["SelectControlValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_x"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatError"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectErrorStateMatcherExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-error-state-matcher-example',
            templateUrl: 'select-error-state-matcher-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-form-example.ts":
    /*!************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-form-example.ts ***!
      \************************************************************************/
    /*! exports provided: SelectFormExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectFormExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectFormExample", function () {
        return SelectFormExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      function SelectFormExample_mat_option_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 9);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var food_r361 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", food_r361.value);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", food_r361.viewValue, " ");
        }
      }
      function SelectFormExample_option_20_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var car_r362 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", car_r362.value);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", car_r362.viewValue, " ");
        }
      }
      /**
       * @title Select in a form
       */
      var SelectFormExample = /*#__PURE__*/_createClass(function SelectFormExample() {
        _classCallCheck(this, SelectFormExample);
        this.foods = [{
          value: 'steak-0',
          viewValue: 'Steak'
        }, {
          value: 'pizza-1',
          viewValue: 'Pizza'
        }, {
          value: 'tacos-2',
          viewValue: 'Tacos'
        }];
        this.cars = [{
          value: 'volvo',
          viewValue: 'Volvo'
        }, {
          value: 'saab',
          viewValue: 'Saab'
        }, {
          value: 'mercedes',
          viewValue: 'Mercedes'
        }];
      });
      SelectFormExample.ɵfac = function SelectFormExample_Factory(t) {
        return new (t || SelectFormExample)();
      };
      SelectFormExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectFormExample,
        selectors: [["select-form-example"]],
        decls: 23,
        vars: 6,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#getting-and-setting-the-select-value"], ["name", "food", "id", "form-mat-select", 3, "ngModel", "ngModelChange"], ["id", "form-mat-select-list", 3, "value", 4, "ngFor", "ngForOf"], ["id", "form-mat-select-confirm"], ["matNativeControl", "", "name", "car", "id", "form-native-select", 3, "ngModel", "ngModelChange"], ["value", "", "selected", ""], [3, "value", 4, "ngFor", "ngForOf"], ["id", "form-native-select-confirm"], ["id", "form-mat-select-list", 3, "value"], [3, "value"]],
        template: function SelectFormExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select in a form ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "form");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "mat-select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Favorite food");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function SelectFormExample_Template_mat_select_ngModelChange_9_listener($event) {
              return ctx.selectedValue = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, SelectFormExample_mat_option_10_Template, 2, 2, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "p", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "native html select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "Favorite car");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "select", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function SelectFormExample_Template_select_ngModelChange_18_listener($event) {
              return ctx.selectedCar = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](19, "option", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, SelectFormExample_option_20_Template, 2, 2, "option", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "p", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.selectedValue);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.foods);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" Selected food: ", ctx.selectedValue, " ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.selectedCar);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.cars);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" Selected car: ", ctx.selectedCar, " ");
          }
        },
        directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgForm"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgModel"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_material_input__WEBPACK_IMPORTED_MODULE_5__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["SelectControlValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_x"], _angular_material_core__WEBPACK_IMPORTED_MODULE_6__["MatOption"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectFormExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-form-example',
            templateUrl: 'select-form-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-hint-error-example.ts":
    /*!******************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-hint-error-example.ts ***!
      \******************************************************************************/
    /*! exports provided: SelectHintErrorExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectHintErrorExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectHintErrorExample", function () {
        return SelectHintErrorExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      function SelectHintErrorExample_mat_option_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var animal_r366 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", animal_r366);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", animal_r366.name, " ");
        }
      }
      function SelectHintErrorExample_mat_error_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-error", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Please choose an animal");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function SelectHintErrorExample_mat_error_28_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-error", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " This field is required ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      /** @title Select with form field features */
      var SelectHintErrorExample = /*#__PURE__*/_createClass(function SelectHintErrorExample() {
        _classCallCheck(this, SelectHintErrorExample);
        this.animalControl = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required);
        this.selectFormControl = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required);
        this.animals = [{
          name: 'Dog',
          sound: 'Woof!'
        }, {
          name: 'Cat',
          sound: 'Meow!'
        }, {
          name: 'Cow',
          sound: 'Moo!'
        }, {
          name: 'Fox',
          sound: 'Wa-pa-pa-pa-pa-pa-pow!'
        }];
      });
      SelectHintErrorExample.ɵfac = function SelectHintErrorExample_Factory(t) {
        return new (t || SelectHintErrorExample)();
      };
      SelectHintErrorExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectHintErrorExample,
        selectors: [["select-hint-error-example"]],
        decls: 31,
        vars: 6,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#form-field-features"], ["required", "", "id", "form-mat-feature-select", 3, "formControl"], ["id", "form-mat-feature-list"], ["id", "form-mat-feature-list", 3, "value", 4, "ngFor", "ngForOf"], ["id", "form-mat-feature-error", 4, "ngIf"], ["id", "form-mat-feature-hint"], ["matNativeControl", "", "required", "", "id", "form-native-feature-select", 3, "formControl"], ["label", "--select something--"], ["value", "saab"], ["value", "mercedes"], ["value", "audi"], ["id", "form-native-feature-error", 4, "ngIf"], ["id", "form-native-feature-hint"], ["id", "form-mat-feature-list", 3, "value"], ["id", "form-mat-feature-error"], ["id", "form-native-feature-error"]],
        template: function SelectHintErrorExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with form field features ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "mat select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Favorite animal");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "--");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, SelectHintErrorExample_mat_option_11_Template, 2, 2, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, SelectHintErrorExample_mat_error_12_Template, 2, 0, "mat-error", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-hint", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "native html select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "Select your car (required)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "select", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](21, "option", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "option", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, "Saab");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "option", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25, "Mercedes");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "option", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, "Audi");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](28, SelectHintErrorExample_mat_error_28_Template, 2, 0, "mat-error", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "mat-hint", 13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](30, "You can pick up your favorite car here");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.animalControl);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.animals);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.animalControl.hasError("required"));
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.animalControl.value == null ? null : ctx.animalControl.value.sound);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.selectFormControl);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.selectFormControl.hasError("required"));
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["RequiredValidator"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatOption"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgIf"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatHint"], _angular_material_input__WEBPACK_IMPORTED_MODULE_6__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["SelectControlValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_x"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatError"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectHintErrorExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-hint-error-example',
            templateUrl: 'select-hint-error-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-multiple-example.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-multiple-example.ts ***!
      \****************************************************************************/
    /*! exports provided: SelectMultipleExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectMultipleExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectMultipleExample", function () {
        return SelectMultipleExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      function SelectMultipleExample_mat_option_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var topping_r368 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", topping_r368);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](topping_r368);
        }
      }
      /** @title Select with multiple selection */
      var SelectMultipleExample = /*#__PURE__*/_createClass(function SelectMultipleExample() {
        _classCallCheck(this, SelectMultipleExample);
        this.toppings = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]();
        this.toppingList = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
      });
      SelectMultipleExample.ɵfac = function SelectMultipleExample_Factory(t) {
        return new (t || SelectMultipleExample)();
      };
      SelectMultipleExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectMultipleExample,
        selectors: [["select-multiple-example"]],
        decls: 8,
        vars: 2,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#multiple-selection"], ["multiple", "", "id", "multiple-select", 3, "formControl"], [3, "value", 4, "ngFor", "ngForOf"], [3, "value"]],
        template: function SelectMultipleExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with multiple selection ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Toppings");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, SelectMultipleExample_mat_option_7_Template, 2, 2, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.toppings);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.toppingList);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_material_core__WEBPACK_IMPORTED_MODULE_5__["MatOption"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectMultipleExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-multiple-example',
            templateUrl: 'select-multiple-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-no-ripple-example.ts":
    /*!*****************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-no-ripple-example.ts ***!
      \*****************************************************************************/
    /*! exports provided: SelectNoRippleExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectNoRippleExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectNoRippleExample", function () {
        return SelectNoRippleExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");

      /** @title Select with no option ripple */
      var SelectNoRippleExample = /*#__PURE__*/_createClass(function SelectNoRippleExample() {
        _classCallCheck(this, SelectNoRippleExample);
      });
      SelectNoRippleExample.ɵfac = function SelectNoRippleExample_Factory(t) {
        return new (t || SelectNoRippleExample)();
      };
      SelectNoRippleExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectNoRippleExample,
        selectors: [["select-no-ripple-example"]],
        decls: 13,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#disabling-the-ripple-effect"], ["disableRipple", "", "id", "no-option-ripple-select"], ["value", "1"], ["value", "2"], ["value", "3"]],
        template: function SelectNoRippleExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with no option ripple ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Select an option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Option 1");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Option 2");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-option", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "Option 3");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_2__["MatSelect"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatOption"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectNoRippleExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-no-ripple-example',
            templateUrl: 'select-no-ripple-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-optgroup-example.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-optgroup-example.ts ***!
      \****************************************************************************/
    /*! exports provided: SelectOptgroupExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectOptgroupExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectOptgroupExample", function () {
        return SelectOptgroupExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      function SelectOptgroupExample_mat_optgroup_11_mat_option_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var pokemon_r372 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", pokemon_r372.value);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", pokemon_r372.viewValue, " ");
        }
      }
      function SelectOptgroupExample_mat_optgroup_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-optgroup", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, SelectOptgroupExample_mat_optgroup_11_mat_option_1_Template, 2, 2, "mat-option", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var group_r370 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("label", group_r370.name)("disabled", group_r370.disabled);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", group_r370.pokemon);
        }
      }
      /** @title Select with option groups */
      var SelectOptgroupExample = /*#__PURE__*/_createClass(function SelectOptgroupExample() {
        _classCallCheck(this, SelectOptgroupExample);
        this.pokemonControl = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]();
        this.pokemonGroups = [{
          name: 'Grass',
          pokemon: [{
            value: 'bulbasaur-0',
            viewValue: 'Bulbasaur'
          }, {
            value: 'oddish-1',
            viewValue: 'Oddish'
          }, {
            value: 'bellsprout-2',
            viewValue: 'Bellsprout'
          }]
        }, {
          name: 'Water',
          pokemon: [{
            value: 'squirtle-3',
            viewValue: 'Squirtle'
          }, {
            value: 'psyduck-4',
            viewValue: 'Psyduck'
          }, {
            value: 'horsea-5',
            viewValue: 'Horsea'
          }]
        }, {
          name: 'Fire',
          disabled: true,
          pokemon: [{
            value: 'charmander-6',
            viewValue: 'Charmander'
          }, {
            value: 'vulpix-7',
            viewValue: 'Vulpix'
          }, {
            value: 'flareon-8',
            viewValue: 'Flareon'
          }]
        }, {
          name: 'Psychic',
          pokemon: [{
            value: 'mew-9',
            viewValue: 'Mew'
          }, {
            value: 'mewtwo-10',
            viewValue: 'Mewtwo'
          }]
        }];
      });
      SelectOptgroupExample.ɵfac = function SelectOptgroupExample_Factory(t) {
        return new (t || SelectOptgroupExample)();
      };
      SelectOptgroupExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectOptgroupExample,
        selectors: [["select-optgroup-example"]],
        decls: 28,
        vars: 2,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#creating-groups-of-options"], ["id", "option-groups-mat-select", 3, "formControl"], [3, "label", "disabled", 4, "ngFor", "ngForOf"], ["matNativeControl", "", "id", "option-groups-native-select"], ["label", "Swedish Cars"], ["value", "volvo"], ["value", "saab"], ["label", "German Cars"], ["value", "mercedes"], ["value", "audi"], [3, "label", "disabled"], [3, "value", 4, "ngFor", "ngForOf"], [3, "value"]],
        template: function SelectOptgroupExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with option groups ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "mat-select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Pokemon");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "-- None --");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, SelectOptgroupExample_mat_optgroup_11_Template, 2, 3, "mat-optgroup", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "native html select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "Cars");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "select", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "optgroup", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "option", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "Volvo");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "option", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22, "Saab");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "optgroup", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "option", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25, "Mercedes");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "option", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, "Audi");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.pokemonControl);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.pokemonGroups);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatOption"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgForOf"], _angular_material_input__WEBPACK_IMPORTED_MODULE_6__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_x"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatOptgroup"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectOptgroupExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-optgroup-example',
            templateUrl: 'select-optgroup-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-panel-class-example.ts":
    /*!*******************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-panel-class-example.ts ***!
      \*******************************************************************************/
    /*! exports provided: SelectPanelClassExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectPanelClassExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectPanelClassExample", function () {
        return SelectPanelClassExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");

      /**
       * @title Select with custom panel styling
       */
      var SelectPanelClassExample = /*#__PURE__*/_createClass(function SelectPanelClassExample() {
        _classCallCheck(this, SelectPanelClassExample);
        this.panelColor = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('red');
      });
      SelectPanelClassExample.ɵfac = function SelectPanelClassExample_Factory(t) {
        return new (t || SelectPanelClassExample)();
      };
      SelectPanelClassExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectPanelClassExample,
        selectors: [["select-panel-class-example"]],
        decls: 13,
        vars: 2,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#adding-custom-styles-to-the-dropdown-panel"], ["id", "custom-panel-styling-select", 3, "formControl", "panelClass"], ["value", "red"], ["value", "green"], ["value", "blue"]],
        template: function SelectPanelClassExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with custom panel styling ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Panel color");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Red");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Green");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-option", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "Blue");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate1"]("panelClass", "example-panel-", ctx.panelColor.value, "");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formControl", ctx.panelColor);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_3__["MatSelect"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatOption"]],
        styles: [".example-panel-red.mat-select-panel {\r\n  background: rgba(255, 0, 0, 0.5);\r\n}\r\n\r\n.example-panel-green.mat-select-panel {\r\n  background: rgba(0, 255, 0, 0.5);\r\n}\r\n\r\n.example-panel-blue.mat-select-panel {\r\n  background: rgba(0, 0, 255, 0.5);\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9zZWxlY3QvY29tcG9uZW50cy9zZWxlY3QtcGFuZWwtY2xhc3MtZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxnQ0FBZ0M7QUFDbEM7O0FBRUE7RUFDRSxnQ0FBZ0M7QUFDbEM7O0FBRUE7RUFDRSxnQ0FBZ0M7QUFDbEMiLCJmaWxlIjoic3JjL2FwcC9mb3JtLWNvbnRyb2xzL3NlbGVjdC9jb21wb25lbnRzL3NlbGVjdC1wYW5lbC1jbGFzcy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLXBhbmVsLXJlZC5tYXQtc2VsZWN0LXBhbmVsIHtcclxuICBiYWNrZ3JvdW5kOiByZ2JhKDI1NSwgMCwgMCwgMC41KTtcclxufVxyXG5cclxuLmV4YW1wbGUtcGFuZWwtZ3JlZW4ubWF0LXNlbGVjdC1wYW5lbCB7XHJcbiAgYmFja2dyb3VuZDogcmdiYSgwLCAyNTUsIDAsIDAuNSk7XHJcbn1cclxuXHJcbi5leGFtcGxlLXBhbmVsLWJsdWUubWF0LXNlbGVjdC1wYW5lbCB7XHJcbiAgYmFja2dyb3VuZDogcmdiYSgwLCAwLCAyNTUsIDAuNSk7XHJcbn1cclxuIl19 */"],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectPanelClassExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-panel-class-example',
            templateUrl: 'select-panel-class-example.html',
            styleUrls: ['select-panel-class-example.css'],
            // Encapsulation has to be disabled in order for the
            // component style to apply to the select panel.
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewEncapsulation"].None
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-reset-example.ts":
    /*!*************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-reset-example.ts ***!
      \*************************************************************************/
    /*! exports provided: SelectResetExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectResetExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectResetExample", function () {
        return SelectResetExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      function SelectResetExample_mat_option_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-option", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var state_r374 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", state_r374);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](state_r374);
        }
      }
      /** @title Select with reset option */
      var SelectResetExample = /*#__PURE__*/_createClass(function SelectResetExample() {
        _classCallCheck(this, SelectResetExample);
        this.states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];
      });
      SelectResetExample.ɵfac = function SelectResetExample_Factory(t) {
        return new (t || SelectResetExample)();
      };
      SelectResetExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectResetExample,
        selectors: [["select-reset-example"]],
        decls: 27,
        vars: 1,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#resetting-the-select-value"], ["id", "reset-mat-select"], [3, "value", 4, "ngFor", "ngForOf"], ["matNativeControl", "", "id", "reset-native-select"], ["value", "", "selected", ""], ["value", "volvo"], ["value", "saab"], ["value", "mercedes"], ["value", "audi"], [3, "value"]],
        template: function SelectResetExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with reset option ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "mat-select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "State");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "None");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, SelectResetExample_mat_option_11_Template, 2, 2, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "native html select");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "Select your car");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "select", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](18, "option", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "option", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "Volvo");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "option", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22, "Saab");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "option", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](24, "Mercedes");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "option", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "Audi");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.states);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_2__["MatSelect"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatOption"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_material_input__WEBPACK_IMPORTED_MODULE_5__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["ɵangular_packages_forms_forms_x"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectResetExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-reset-example',
            templateUrl: 'select-reset-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/components/select-value-binding-example.ts":
    /*!*********************************************************************************!*\
      !*** ./src/app/form-controls/select/components/select-value-binding-example.ts ***!
      \*********************************************************************************/
    /*! exports provided: SelectValueBindingExample */
    /***/
    function srcAppFormControlsSelectComponentsSelectValueBindingExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectValueBindingExample", function () {
        return SelectValueBindingExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");

      /** @title Select with 2-way value binding */
      var SelectValueBindingExample = /*#__PURE__*/_createClass(function SelectValueBindingExample() {
        _classCallCheck(this, SelectValueBindingExample);
        this.selected = 'option2';
      });
      SelectValueBindingExample.ɵfac = function SelectValueBindingExample_Factory(t) {
        return new (t || SelectValueBindingExample)();
      };
      SelectValueBindingExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectValueBindingExample,
        selectors: [["select-value-binding-example"]],
        decls: 17,
        vars: 2,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/select/overview#getting-and-setting-the-select-value"], ["id", "two-binding-select", 3, "value", "valueChange"], ["value", "option1"], ["value", "option2"], ["value", "option3"], ["id", "select-binding-confirm"]],
        template: function SelectValueBindingExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Select with 2-way value binding ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Select an option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-select", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("valueChange", function SelectValueBindingExample_Template_mat_select_valueChange_6_listener($event) {
              return ctx.selected = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-option");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "None");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-option", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Option 1");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-option", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "Option 2");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-option", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Option 3");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "p", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", ctx.selected);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("You selected: ", ctx.selected, "");
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_1__["MatLabel"], _angular_material_select__WEBPACK_IMPORTED_MODULE_2__["MatSelect"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatOption"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectValueBindingExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'select-value-binding-example',
            templateUrl: 'select-value-binding-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/selects-routing.module.ts":
    /*!****************************************************************!*\
      !*** ./src/app/form-controls/select/selects-routing.module.ts ***!
      \****************************************************************/
    /*! exports provided: SelectsRoutingModule */
    /***/
    function srcAppFormControlsSelectSelectsRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectsRoutingModule", function () {
        return SelectsRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _selects_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./selects.component */"./src/app/form-controls/select/selects.component.ts");
      var routes = [{
        path: '',
        component: _selects_component__WEBPACK_IMPORTED_MODULE_2__["SelectsComponent"]
      }];
      var SelectsRoutingModule = /*#__PURE__*/_createClass(function SelectsRoutingModule() {
        _classCallCheck(this, SelectsRoutingModule);
      });
      SelectsRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SelectsRoutingModule
      });
      SelectsRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SelectsRoutingModule_Factory(t) {
          return new (t || SelectsRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SelectsRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectsRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/selects.component.ts":
    /*!***********************************************************!*\
      !*** ./src/app/form-controls/select/selects.component.ts ***!
      \***********************************************************/
    /*! exports provided: SelectsComponent */
    /***/
    function srcAppFormControlsSelectSelectsComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectsComponent", function () {
        return SelectsComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_select_custom_trigger_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/select-custom-trigger-example */"./src/app/form-controls/select/components/select-custom-trigger-example.ts");
      /* harmony import */
      var _components_select_disabled_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/select-disabled-example */"./src/app/form-controls/select/components/select-disabled-example.ts");
      /* harmony import */
      var _components_select_error_state_matcher_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./components/select-error-state-matcher-example */"./src/app/form-controls/select/components/select-error-state-matcher-example.ts");
      /* harmony import */
      var _components_select_form_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/select-form-example */"./src/app/form-controls/select/components/select-form-example.ts");
      /* harmony import */
      var _components_select_hint_error_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/select-hint-error-example */"./src/app/form-controls/select/components/select-hint-error-example.ts");
      /* harmony import */
      var _components_select_multiple_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./components/select-multiple-example */"./src/app/form-controls/select/components/select-multiple-example.ts");
      /* harmony import */
      var _components_select_no_ripple_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! ./components/select-no-ripple-example */"./src/app/form-controls/select/components/select-no-ripple-example.ts");
      /* harmony import */
      var _components_select_optgroup_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! ./components/select-optgroup-example */"./src/app/form-controls/select/components/select-optgroup-example.ts");
      /* harmony import */
      var _components_select_panel_class_example__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! ./components/select-panel-class-example */"./src/app/form-controls/select/components/select-panel-class-example.ts");
      /* harmony import */
      var _components_select_reset_example__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! ./components/select-reset-example */"./src/app/form-controls/select/components/select-reset-example.ts");
      /* harmony import */
      var _components_select_value_binding_example__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! ./components/select-value-binding-example */"./src/app/form-controls/select/components/select-value-binding-example.ts");
      var SelectsComponent = /*#__PURE__*/_createClass(function SelectsComponent() {
        _classCallCheck(this, SelectsComponent);
      });
      SelectsComponent.ɵfac = function SelectsComponent_Factory(t) {
        return new (t || SelectsComponent)();
      };
      SelectsComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SelectsComponent,
        selectors: [["app-selects"]],
        decls: 11,
        vars: 0,
        template: function SelectsComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "select-custom-trigger-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "select-disabled-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "select-error-state-matcher-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "select-form-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "select-hint-error-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "select-multiple-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "select-no-ripple-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "select-optgroup-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "select-panel-class-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "select-reset-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "select-value-binding-example");
          }
        },
        directives: [_components_select_custom_trigger_example__WEBPACK_IMPORTED_MODULE_1__["SelectCustomTriggerExample"], _components_select_disabled_example__WEBPACK_IMPORTED_MODULE_2__["SelectDisabledExample"], _components_select_error_state_matcher_example__WEBPACK_IMPORTED_MODULE_3__["SelectErrorStateMatcherExample"], _components_select_form_example__WEBPACK_IMPORTED_MODULE_4__["SelectFormExample"], _components_select_hint_error_example__WEBPACK_IMPORTED_MODULE_5__["SelectHintErrorExample"], _components_select_multiple_example__WEBPACK_IMPORTED_MODULE_6__["SelectMultipleExample"], _components_select_no_ripple_example__WEBPACK_IMPORTED_MODULE_7__["SelectNoRippleExample"], _components_select_optgroup_example__WEBPACK_IMPORTED_MODULE_8__["SelectOptgroupExample"], _components_select_panel_class_example__WEBPACK_IMPORTED_MODULE_9__["SelectPanelClassExample"], _components_select_reset_example__WEBPACK_IMPORTED_MODULE_10__["SelectResetExample"], _components_select_value_binding_example__WEBPACK_IMPORTED_MODULE_11__["SelectValueBindingExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectsComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-selects',
            templateUrl: './selects.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/select/selects.module.ts":
    /*!********************************************************!*\
      !*** ./src/app/form-controls/select/selects.module.ts ***!
      \********************************************************/
    /*! exports provided: SelectsModule */
    /***/
    function srcAppFormControlsSelectSelectsModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SelectsModule", function () {
        return SelectsModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _selects_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./selects-routing.module */"./src/app/form-controls/select/selects-routing.module.ts");
      /* harmony import */
      var _selects_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./selects.component */"./src/app/form-controls/select/selects.component.ts");
      /* harmony import */
      var _components_select_custom_trigger_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/select-custom-trigger-example */"./src/app/form-controls/select/components/select-custom-trigger-example.ts");
      /* harmony import */
      var _components_select_disabled_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/select-disabled-example */"./src/app/form-controls/select/components/select-disabled-example.ts");
      /* harmony import */
      var _components_select_error_state_matcher_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./components/select-error-state-matcher-example */"./src/app/form-controls/select/components/select-error-state-matcher-example.ts");
      /* harmony import */
      var _components_select_form_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! ./components/select-form-example */"./src/app/form-controls/select/components/select-form-example.ts");
      /* harmony import */
      var _components_select_hint_error_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! ./components/select-hint-error-example */"./src/app/form-controls/select/components/select-hint-error-example.ts");
      /* harmony import */
      var _components_select_multiple_example__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! ./components/select-multiple-example */"./src/app/form-controls/select/components/select-multiple-example.ts");
      /* harmony import */
      var _components_select_no_ripple_example__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! ./components/select-no-ripple-example */"./src/app/form-controls/select/components/select-no-ripple-example.ts");
      /* harmony import */
      var _components_select_optgroup_example__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! ./components/select-optgroup-example */"./src/app/form-controls/select/components/select-optgroup-example.ts");
      /* harmony import */
      var _components_select_panel_class_example__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! ./components/select-panel-class-example */"./src/app/form-controls/select/components/select-panel-class-example.ts");
      /* harmony import */
      var _components_select_reset_example__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__( /*! ./components/select-reset-example */"./src/app/form-controls/select/components/select-reset-example.ts");
      /* harmony import */
      var _components_select_value_binding_example__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__( /*! ./components/select-value-binding-example */"./src/app/form-controls/select/components/select-value-binding-example.ts");
      /* harmony import */
      var _angular_material_select__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__( /*! @angular/material/select */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      var SelectsModule = /*#__PURE__*/_createClass(function SelectsModule() {
        _classCallCheck(this, SelectsModule);
      });
      SelectsModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SelectsModule
      });
      SelectsModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SelectsModule_Factory(t) {
          return new (t || SelectsModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _selects_routing_module__WEBPACK_IMPORTED_MODULE_2__["SelectsRoutingModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_15__["MatSelectModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_16__["ReactiveFormsModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_17__["MatCheckboxModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_18__["MatInputModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_16__["FormsModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SelectsModule, {
          declarations: [_selects_component__WEBPACK_IMPORTED_MODULE_3__["SelectsComponent"], _components_select_custom_trigger_example__WEBPACK_IMPORTED_MODULE_4__["SelectCustomTriggerExample"], _components_select_disabled_example__WEBPACK_IMPORTED_MODULE_5__["SelectDisabledExample"], _components_select_error_state_matcher_example__WEBPACK_IMPORTED_MODULE_6__["SelectErrorStateMatcherExample"], _components_select_form_example__WEBPACK_IMPORTED_MODULE_7__["SelectFormExample"], _components_select_hint_error_example__WEBPACK_IMPORTED_MODULE_8__["SelectHintErrorExample"], _components_select_multiple_example__WEBPACK_IMPORTED_MODULE_9__["SelectMultipleExample"], _components_select_no_ripple_example__WEBPACK_IMPORTED_MODULE_10__["SelectNoRippleExample"], _components_select_optgroup_example__WEBPACK_IMPORTED_MODULE_11__["SelectOptgroupExample"], _components_select_panel_class_example__WEBPACK_IMPORTED_MODULE_12__["SelectPanelClassExample"], _components_select_reset_example__WEBPACK_IMPORTED_MODULE_13__["SelectResetExample"], _components_select_value_binding_example__WEBPACK_IMPORTED_MODULE_14__["SelectValueBindingExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _selects_routing_module__WEBPACK_IMPORTED_MODULE_2__["SelectsRoutingModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_15__["MatSelectModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_16__["ReactiveFormsModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_17__["MatCheckboxModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_18__["MatInputModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_16__["FormsModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectsModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_selects_component__WEBPACK_IMPORTED_MODULE_3__["SelectsComponent"], _components_select_custom_trigger_example__WEBPACK_IMPORTED_MODULE_4__["SelectCustomTriggerExample"], _components_select_disabled_example__WEBPACK_IMPORTED_MODULE_5__["SelectDisabledExample"], _components_select_error_state_matcher_example__WEBPACK_IMPORTED_MODULE_6__["SelectErrorStateMatcherExample"], _components_select_form_example__WEBPACK_IMPORTED_MODULE_7__["SelectFormExample"], _components_select_hint_error_example__WEBPACK_IMPORTED_MODULE_8__["SelectHintErrorExample"], _components_select_multiple_example__WEBPACK_IMPORTED_MODULE_9__["SelectMultipleExample"], _components_select_no_ripple_example__WEBPACK_IMPORTED_MODULE_10__["SelectNoRippleExample"], _components_select_optgroup_example__WEBPACK_IMPORTED_MODULE_11__["SelectOptgroupExample"], _components_select_panel_class_example__WEBPACK_IMPORTED_MODULE_12__["SelectPanelClassExample"], _components_select_reset_example__WEBPACK_IMPORTED_MODULE_13__["SelectResetExample"], _components_select_value_binding_example__WEBPACK_IMPORTED_MODULE_14__["SelectValueBindingExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _selects_routing_module__WEBPACK_IMPORTED_MODULE_2__["SelectsRoutingModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_15__["MatSelectModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_16__["ReactiveFormsModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_17__["MatCheckboxModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_18__["MatInputModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_16__["FormsModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=form-controls-select-selects-module-es5.js.map