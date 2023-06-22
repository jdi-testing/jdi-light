(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["form-controls-slide-toggle-slide-toggle-module"], {
    /***/"./src/app/form-controls/slide-toggle/components/slide-toggle-configurable-example.ts":
    /*!********************************************************************************************!*\
      !*** ./src/app/form-controls/slide-toggle/components/slide-toggle-configurable-example.ts ***!
      \********************************************************************************************/
    /*! exports provided: SlideToggleConfigurableExample */
    /***/
    function srcAppFormControlsSlideToggleComponentsSlideToggleConfigurableExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SlideToggleConfigurableExample", function () {
        return SlideToggleConfigurableExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
      /* harmony import */
      var _angular_material_radio__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/radio */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      /* harmony import */
      var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/slide-toggle */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slide-toggle.js");

      /**
       * @title Configurable slide-toggle
       */
      var SlideToggleConfigurableExample = /*#__PURE__*/_createClass(function SlideToggleConfigurableExample() {
        _classCallCheck(this, SlideToggleConfigurableExample);
        this.color = 'accent';
        this.checked = false;
        this.disabled = false;
      });
      SlideToggleConfigurableExample.ɵfac = function SlideToggleConfigurableExample_Factory(t) {
        return new (t || SlideToggleConfigurableExample)();
      };
      SlideToggleConfigurableExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SlideToggleConfigurableExample,
        selectors: [["slide-toggle-configurable-example"]],
        decls: 29,
        vars: 6,
        consts: [[1, "example-h2"], [1, "example-section"], [1, "example-margin"], ["id", "slide-toggles-colors_radio_buttons", 3, "ngModel", "ngModelChange"], ["id", "slide-toggles-set_primary_color_radio", "value", "primary", 1, "example-margin"], ["id", "slide-toggles-set_accent_color_radio", "value", "accent", 1, "example-margin"], ["id", "slide-toggles-set_warn_color_radio", "value", "warn", 1, "example-margin"], ["id", "slide-toggles-set_checked_checkbox", 1, "example-margin", 3, "ngModel", "ngModelChange"], ["id", "slide-toggles-set_disabled_checkbox", 1, "example-margin", 3, "ngModel", "ngModelChange"], [1, "result"], ["id", "slide-toggles-configured", 1, "example-margin", 3, "color", "checked", "disabled"]],
        template: function SlideToggleConfigurableExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Configurable slide-toggle");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-card");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-card-content");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Slider configuration");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "label", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Color:");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-radio-group", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function SlideToggleConfigurableExample_Template_mat_radio_group_ngModelChange_9_listener($event) {
              return ctx.color = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "mat-radio-button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, " Primary ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "mat-radio-button", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, " Accent ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-radio-button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, " Warn ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "mat-checkbox", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function SlideToggleConfigurableExample_Template_mat_checkbox_ngModelChange_17_listener($event) {
              return ctx.checked = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, " Checked ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "mat-checkbox", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function SlideToggleConfigurableExample_Template_mat_checkbox_ngModelChange_20_listener($event) {
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
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "mat-slide-toggle", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](28, " Slide me! ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.color);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.checked);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.disabled);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("color", ctx.color)("checked", ctx.checked)("disabled", ctx.disabled);
          }
        },
        directives: [_angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCard"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardContent"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_2__["MatRadioGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgModel"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_2__["MatRadioButton"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_4__["MatCheckbox"], _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_5__["MatSlideToggle"]],
        styles: [".example-h2[_ngcontent-%COMP%] {\r\n  margin: 10px;\r\n}\r\n\r\n.example-section[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-content: center;\r\n  align-items: center;\r\n  height: 60px;\r\n}\r\n\r\n.example-margin[_ngcontent-%COMP%] {\r\n  margin: 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9zbGlkZS10b2dnbGUvY29tcG9uZW50cy9zbGlkZS10b2dnbGUtY29uZmlndXJhYmxlLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsWUFBWTtBQUNkOztBQUVBO0VBQ0UsYUFBYTtFQUNiLHFCQUFxQjtFQUNyQixtQkFBbUI7RUFDbkIsWUFBWTtBQUNkOztBQUVBO0VBQ0UsWUFBWTtBQUNkIiwiZmlsZSI6InNyYy9hcHAvZm9ybS1jb250cm9scy9zbGlkZS10b2dnbGUvY29tcG9uZW50cy9zbGlkZS10b2dnbGUtY29uZmlndXJhYmxlLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtaDIge1xyXG4gIG1hcmdpbjogMTBweDtcclxufVxyXG5cclxuLmV4YW1wbGUtc2VjdGlvbiB7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBhbGlnbi1jb250ZW50OiBjZW50ZXI7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxuICBoZWlnaHQ6IDYwcHg7XHJcbn1cclxuXHJcbi5leGFtcGxlLW1hcmdpbiB7XHJcbiAgbWFyZ2luOiAxMHB4O1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SlideToggleConfigurableExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'slide-toggle-configurable-example',
            templateUrl: 'slide-toggle-configurable-example.html',
            styleUrls: ['slide-toggle-configurable-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/slide-toggle/components/slide-toggle-overview-example.ts":
    /*!****************************************************************************************!*\
      !*** ./src/app/form-controls/slide-toggle/components/slide-toggle-overview-example.ts ***!
      \****************************************************************************************/
    /*! exports provided: SlideToggleOverviewExample */
    /***/
    function srcAppFormControlsSlideToggleComponentsSlideToggleOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SlideToggleOverviewExample", function () {
        return SlideToggleOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/slide-toggle */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slide-toggle.js");

      /**
       * @title Basic slide-toggles
       */
      var SlideToggleOverviewExample = /*#__PURE__*/_createClass(function SlideToggleOverviewExample() {
        _classCallCheck(this, SlideToggleOverviewExample);
      });
      SlideToggleOverviewExample.ɵfac = function SlideToggleOverviewExample_Factory(t) {
        return new (t || SlideToggleOverviewExample)();
      };
      SlideToggleOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SlideToggleOverviewExample,
        selectors: [["slide-toggle-overview-example"]],
        decls: 6,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/slide-toggle/overview"], [1, "example-section"], ["id", "slide-toggles-basic"]],
        template: function SlideToggleOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic slide-toggles ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "section", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-slide-toggle", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Slide me!");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_1__["MatSlideToggle"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9ybS1jb250cm9scy9zbGlkZS10b2dnbGUvY29tcG9uZW50cy9zbGlkZS10b2dnbGUtb3ZlcnZpZXctZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsNkJBQTZCIiwiZmlsZSI6InNyYy9hcHAvZm9ybS1jb250cm9scy9zbGlkZS10b2dnbGUvY29tcG9uZW50cy9zbGlkZS10b2dnbGUtb3ZlcnZpZXctZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiogTm8gQ1NTIGZvciB0aGlzIGV4YW1wbGUgKi9cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SlideToggleOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'slide-toggle-overview-example',
            templateUrl: 'slide-toggle-overview-example.html',
            styleUrls: ['slide-toggle-overview-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/slide-toggle/slide-toggle-routing.module.ts":
    /*!***************************************************************************!*\
      !*** ./src/app/form-controls/slide-toggle/slide-toggle-routing.module.ts ***!
      \***************************************************************************/
    /*! exports provided: SlideToggleRoutingModule */
    /***/
    function srcAppFormControlsSlideToggleSlideToggleRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SlideToggleRoutingModule", function () {
        return SlideToggleRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _slide_toggle_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./slide-toggle.component */"./src/app/form-controls/slide-toggle/slide-toggle.component.ts");
      var routes = [{
        path: '',
        component: _slide_toggle_component__WEBPACK_IMPORTED_MODULE_2__["SlideToggleComponent"]
      }];
      var SlideToggleRoutingModule = /*#__PURE__*/_createClass(function SlideToggleRoutingModule() {
        _classCallCheck(this, SlideToggleRoutingModule);
      });
      SlideToggleRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SlideToggleRoutingModule
      });
      SlideToggleRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SlideToggleRoutingModule_Factory(t) {
          return new (t || SlideToggleRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SlideToggleRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SlideToggleRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/slide-toggle/slide-toggle.component.ts":
    /*!**********************************************************************!*\
      !*** ./src/app/form-controls/slide-toggle/slide-toggle.component.ts ***!
      \**********************************************************************/
    /*! exports provided: SlideToggleComponent */
    /***/
    function srcAppFormControlsSlideToggleSlideToggleComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SlideToggleComponent", function () {
        return SlideToggleComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_slide_toggle_configurable_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/slide-toggle-configurable-example */"./src/app/form-controls/slide-toggle/components/slide-toggle-configurable-example.ts");
      /* harmony import */
      var _components_slide_toggle_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/slide-toggle-overview-example */"./src/app/form-controls/slide-toggle/components/slide-toggle-overview-example.ts");
      var SlideToggleComponent = /*#__PURE__*/_createClass(function SlideToggleComponent() {
        _classCallCheck(this, SlideToggleComponent);
      });
      SlideToggleComponent.ɵfac = function SlideToggleComponent_Factory(t) {
        return new (t || SlideToggleComponent)();
      };
      SlideToggleComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SlideToggleComponent,
        selectors: [["app-slide-toggle"]],
        decls: 2,
        vars: 0,
        template: function SlideToggleComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "slide-toggle-configurable-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "slide-toggle-overview-example");
          }
        },
        directives: [_components_slide_toggle_configurable_example__WEBPACK_IMPORTED_MODULE_1__["SlideToggleConfigurableExample"], _components_slide_toggle_overview_example__WEBPACK_IMPORTED_MODULE_2__["SlideToggleOverviewExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SlideToggleComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-slide-toggle',
            templateUrl: './slide-toggle.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/form-controls/slide-toggle/slide-toggle.module.ts":
    /*!*******************************************************************!*\
      !*** ./src/app/form-controls/slide-toggle/slide-toggle.module.ts ***!
      \*******************************************************************/
    /*! exports provided: SlideToggleModule */
    /***/
    function srcAppFormControlsSlideToggleSlideToggleModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SlideToggleModule", function () {
        return SlideToggleModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _slide_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./slide-toggle-routing.module */"./src/app/form-controls/slide-toggle/slide-toggle-routing.module.ts");
      /* harmony import */
      var _slide_toggle_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./slide-toggle.component */"./src/app/form-controls/slide-toggle/slide-toggle.component.ts");
      /* harmony import */
      var _components_slide_toggle_overview_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/slide-toggle-overview-example */"./src/app/form-controls/slide-toggle/components/slide-toggle-overview-example.ts");
      /* harmony import */
      var _components_slide_toggle_configurable_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/slide-toggle-configurable-example */"./src/app/form-controls/slide-toggle/components/slide-toggle-configurable-example.ts");
      /* harmony import */
      var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/slide-toggle */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slide-toggle.js");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
      /* harmony import */
      var _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/material/radio */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      var SlideToggleModule = /*#__PURE__*/_createClass(function SlideToggleModule() {
        _classCallCheck(this, SlideToggleModule);
      });
      SlideToggleModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SlideToggleModule
      });
      SlideToggleModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SlideToggleModule_Factory(t) {
          return new (t || SlideToggleModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _slide_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__["SlideToggleRoutingModule"], _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_6__["MatSlideToggleModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_7__["MatCardModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_10__["MatCheckboxModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SlideToggleModule, {
          declarations: [_slide_toggle_component__WEBPACK_IMPORTED_MODULE_3__["SlideToggleComponent"], _components_slide_toggle_configurable_example__WEBPACK_IMPORTED_MODULE_5__["SlideToggleConfigurableExample"], _components_slide_toggle_overview_example__WEBPACK_IMPORTED_MODULE_4__["SlideToggleOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _slide_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__["SlideToggleRoutingModule"], _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_6__["MatSlideToggleModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_7__["MatCardModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_10__["MatCheckboxModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SlideToggleModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_slide_toggle_component__WEBPACK_IMPORTED_MODULE_3__["SlideToggleComponent"], _components_slide_toggle_configurable_example__WEBPACK_IMPORTED_MODULE_5__["SlideToggleConfigurableExample"], _components_slide_toggle_overview_example__WEBPACK_IMPORTED_MODULE_4__["SlideToggleOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _slide_toggle_routing_module__WEBPACK_IMPORTED_MODULE_2__["SlideToggleRoutingModule"], _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_6__["MatSlideToggleModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_7__["MatCardModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_8__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_10__["MatCheckboxModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=form-controls-slide-toggle-slide-toggle-module-es5.js.map