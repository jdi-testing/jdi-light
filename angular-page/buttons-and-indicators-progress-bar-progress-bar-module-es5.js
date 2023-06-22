(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["buttons-and-indicators-progress-bar-progress-bar-module"], {
    /***/"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-buffer-example.ts":
    /*!***********************************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/components/progress-bar-buffer-example.ts ***!
      \***********************************************************************************************/
    /*! exports provided: ProgressBarBufferExample */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarComponentsProgressBarBufferExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarBufferExample", function () {
        return ProgressBarBufferExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/progress-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");

      /**
       * @title Buffer progress-bar
       */
      var ProgressBarBufferExample = /*#__PURE__*/function () {
        function ProgressBarBufferExample() {
          _classCallCheck(this, ProgressBarBufferExample);
          this.isShown = false;
        }
        _createClass(ProgressBarBufferExample, [{
          key: "showProgressBar",
          value: function showProgressBar(seconds) {
            var _this = this;
            this.isShown = true;
            setTimeout(function () {
              _this.isShown = false;
            }, seconds * 1000);
          }
        }]);
        return ProgressBarBufferExample;
      }();
      ProgressBarBufferExample.ɵfac = function ProgressBarBufferExample_Factory(t) {
        return new (t || ProgressBarBufferExample)();
      };
      ProgressBarBufferExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ProgressBarBufferExample,
        selectors: [["progress-bar-buffer-example"]],
        decls: 7,
        vars: 1,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/progress-bar/overview#buffer"], ["mat-raised-button", "", "id", "show-buffer-progress-bar-button", 3, "click"], [3, "hidden"], ["id", "mat-progress-bar-buffer", "mode", "buffer"]],
        template: function ProgressBarBufferExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Buffer progress-bar ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function ProgressBarBufferExample_Template_button_click_3_listener() {
              return ctx.showProgressBar(5);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, " Show progress-bar for 5 seconds\n");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "mat-progress-bar", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("hidden", !ctx.isShown);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_2__["MatProgressBar"]],
        styles: ["mat-progress-bar[_ngcontent-%COMP%] {\r\n  margin-top: 20px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9wcm9ncmVzcy1iYXIvY29tcG9uZW50cy9wcm9ncmVzcy1iYXItYnVmZmVyLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsZ0JBQWdCO0FBQ2xCIiwiZmlsZSI6InNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9wcm9ncmVzcy1iYXIvY29tcG9uZW50cy9wcm9ncmVzcy1iYXItYnVmZmVyLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsibWF0LXByb2dyZXNzLWJhciB7XHJcbiAgbWFyZ2luLXRvcDogMjBweDtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarBufferExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'progress-bar-buffer-example',
            templateUrl: 'progress-bar-buffer-example.html',
            styleUrls: ['progress-bar-buffer-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-configurable-example.ts":
    /*!*****************************************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/components/progress-bar-configurable-example.ts ***!
      \*****************************************************************************************************/
    /*! exports provided: ProgressBarConfigurableExample */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarComponentsProgressBarConfigurableExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarConfigurableExample", function () {
        return ProgressBarConfigurableExample;
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
      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/progress-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");
      /* harmony import */
      var _angular_material_slider__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/slider */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slider.js");
      function ProgressBarConfigurableExample_section_28_Template(rf, ctx) {
        if (rf & 1) {
          var _r25 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "section", 1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "label", 2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Progress:");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-slider", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function ProgressBarConfigurableExample_section_28_Template_mat_slider_ngModelChange_3_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r25);
            var ctx_r24 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
            return ctx_r24.value = $event;
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r22 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx_r22.value);
        }
      }
      function ProgressBarConfigurableExample_section_29_Template(rf, ctx) {
        if (rf & 1) {
          var _r27 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "section", 1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "label", 2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Buffer:");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-slider", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function ProgressBarConfigurableExample_section_29_Template_mat_slider_ngModelChange_3_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r27);
            var ctx_r26 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
            return ctx_r26.bufferValue = $event;
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r23 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx_r23.bufferValue);
        }
      }
      /**
       * @title Configurable progress-bar
       */
      var ProgressBarConfigurableExample = /*#__PURE__*/_createClass(function ProgressBarConfigurableExample() {
        _classCallCheck(this, ProgressBarConfigurableExample);
        this.color = 'primary';
        this.mode = 'determinate';
        this.value = 50;
        this.bufferValue = 75;
      });
      ProgressBarConfigurableExample.ɵfac = function ProgressBarConfigurableExample_Factory(t) {
        return new (t || ProgressBarConfigurableExample)();
      };
      ProgressBarConfigurableExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ProgressBarConfigurableExample,
        selectors: [["progress-bar-configurable-example"]],
        decls: 36,
        vars: 8,
        consts: [[1, "example-h2"], [1, "example-section"], [1, "example-margin"], [3, "ngModel", "ngModelChange"], ["id", "progress-bars-primary-color-radio", "value", "primary", 1, "example-margin"], ["id", "progress-bars-accent-color-radio", "value", "accent", 1, "example-margin"], ["id", "progress-bars-warn-color-radio", "value", "warn", 1, "example-margin"], ["id", "progress-bars-determinate-mode-radio", "value", "determinate", 1, "example-margin"], ["id", "progress-bars-indeterminate-mode-radio", "value", "indeterminate", 1, "example-margin"], ["id", "progress-bars-buffer-mode-radio", "value", "buffer", 1, "example-margin"], ["id", "progress-bars-query-mode-radio", "value", "query", 1, "example-margin"], ["class", "example-section", 4, "ngIf"], ["id", "mat-progress-bar-configurable", 1, "example-margin", 3, "color", "mode", "value", "bufferValue"], ["id", "progress-bars-progress-slider", 1, "example-margin", 3, "ngModel", "ngModelChange"], ["id", "progress-bars-buffer-slider", 1, "example-margin", 3, "ngModel", "ngModelChange"]],
        template: function ProgressBarConfigurableExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Configurable progress bar");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-card");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-card-content");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Progress bar configuration");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "label", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Color:");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-radio-group", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function ProgressBarConfigurableExample_Template_mat_radio_group_ngModelChange_9_listener($event) {
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
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "label", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "Mode:");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "mat-radio-group", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function ProgressBarConfigurableExample_Template_mat_radio_group_ngModelChange_19_listener($event) {
              return ctx.mode = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "mat-radio-button", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21, " Determinate ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "mat-radio-button", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, " Indeterminate ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "mat-radio-button", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25, " Buffer ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "mat-radio-button", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, " Query ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](28, ProgressBarConfigurableExample_section_28_Template, 4, 1, "section", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](29, ProgressBarConfigurableExample_section_29_Template, 4, 1, "section", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "mat-card");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "mat-card-content");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "h4");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](33, "Result");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "section", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](35, "mat-progress-bar", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.color);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.mode);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.mode === "determinate" || ctx.mode === "buffer");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.mode === "buffer");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("color", ctx.color)("mode", ctx.mode)("value", ctx.value)("bufferValue", ctx.bufferValue);
          }
        },
        directives: [_angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCard"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardContent"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_2__["MatRadioGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgModel"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_2__["MatRadioButton"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"], _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_5__["MatProgressBar"], _angular_material_slider__WEBPACK_IMPORTED_MODULE_6__["MatSlider"]],
        styles: [".example-h2[_ngcontent-%COMP%] {\r\n  margin: 10px;\r\n}\r\n\r\n.example-section[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-content: center;\r\n  align-items: center;\r\n  height: 60px;\r\n}\r\n\r\n.example-margin[_ngcontent-%COMP%] {\r\n  margin: 0 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9wcm9ncmVzcy1iYXIvY29tcG9uZW50cy9wcm9ncmVzcy1iYXItY29uZmlndXJhYmxlLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsWUFBWTtBQUNkOztBQUVBO0VBQ0UsYUFBYTtFQUNiLHFCQUFxQjtFQUNyQixtQkFBbUI7RUFDbkIsWUFBWTtBQUNkOztBQUVBO0VBQ0UsY0FBYztBQUNoQiIsImZpbGUiOiJzcmMvYXBwL2J1dHRvbnMtYW5kLWluZGljYXRvcnMvcHJvZ3Jlc3MtYmFyL2NvbXBvbmVudHMvcHJvZ3Jlc3MtYmFyLWNvbmZpZ3VyYWJsZS1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLWgyIHtcclxuICBtYXJnaW46IDEwcHg7XHJcbn1cclxuXHJcbi5leGFtcGxlLXNlY3Rpb24ge1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAgYWxpZ24tY29udGVudDogY2VudGVyO1xyXG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XHJcbiAgaGVpZ2h0OiA2MHB4O1xyXG59XHJcblxyXG4uZXhhbXBsZS1tYXJnaW4ge1xyXG4gIG1hcmdpbjogMCAxMHB4O1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarConfigurableExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'progress-bar-configurable-example',
            templateUrl: 'progress-bar-configurable-example.html',
            styleUrls: ['progress-bar-configurable-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-determinate-example.ts":
    /*!****************************************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/components/progress-bar-determinate-example.ts ***!
      \****************************************************************************************************/
    /*! exports provided: ProgressBarDeterminateExample */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarComponentsProgressBarDeterminateExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarDeterminateExample", function () {
        return ProgressBarDeterminateExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/progress-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");

      /**
       * @title Determinate progress-bar
       */
      var ProgressBarDeterminateExample = /*#__PURE__*/_createClass(function ProgressBarDeterminateExample() {
        _classCallCheck(this, ProgressBarDeterminateExample);
      });
      ProgressBarDeterminateExample.ɵfac = function ProgressBarDeterminateExample_Factory(t) {
        return new (t || ProgressBarDeterminateExample)();
      };
      ProgressBarDeterminateExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ProgressBarDeterminateExample,
        selectors: [["progress-bar-determinate-example"]],
        decls: 4,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/progress-bar/overview#determinate"], ["id", "mat-progress-bar-determinate", "mode", "determinate", "value", "40"]],
        template: function ProgressBarDeterminateExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Determinate progress-bar ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "mat-progress-bar", 2);
          }
        },
        directives: [_angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_1__["MatProgressBar"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarDeterminateExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'progress-bar-determinate-example',
            templateUrl: 'progress-bar-determinate-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-indeterminate-example.ts":
    /*!******************************************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/components/progress-bar-indeterminate-example.ts ***!
      \******************************************************************************************************/
    /*! exports provided: ProgressBarIndeterminateExample */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarComponentsProgressBarIndeterminateExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarIndeterminateExample", function () {
        return ProgressBarIndeterminateExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/progress-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");

      /**
       * @title Indeterminate progress-bar
       */
      var ProgressBarIndeterminateExample = /*#__PURE__*/function () {
        function ProgressBarIndeterminateExample() {
          _classCallCheck(this, ProgressBarIndeterminateExample);
          this.isShown = false;
        }
        _createClass(ProgressBarIndeterminateExample, [{
          key: "showProgressBar",
          value: function showProgressBar(seconds) {
            var _this2 = this;
            this.isShown = true;
            setTimeout(function () {
              _this2.isShown = false;
            }, seconds * 1000);
          }
        }]);
        return ProgressBarIndeterminateExample;
      }();
      ProgressBarIndeterminateExample.ɵfac = function ProgressBarIndeterminateExample_Factory(t) {
        return new (t || ProgressBarIndeterminateExample)();
      };
      ProgressBarIndeterminateExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ProgressBarIndeterminateExample,
        selectors: [["progress-bar-indeterminate-example"]],
        decls: 7,
        vars: 1,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/progress-bar/overview#indeterminate"], ["mat-raised-button", "", "id", "show-indeterminate-progress-bar-button", 3, "click"], [3, "hidden"], ["id", "mat-progress-bar-indeterminate", "mode", "indeterminate"]],
        template: function ProgressBarIndeterminateExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Indeterminate progress-bar ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function ProgressBarIndeterminateExample_Template_button_click_3_listener() {
              return ctx.showProgressBar(5);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, " Show progress-bar for 5 seconds\n");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "mat-progress-bar", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("hidden", !ctx.isShown);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_2__["MatProgressBar"]],
        styles: ["mat-progress-bar[_ngcontent-%COMP%] {\r\n  margin-top: 20px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9wcm9ncmVzcy1iYXIvY29tcG9uZW50cy9wcm9ncmVzcy1iYXItaW5kZXRlcm1pbmF0ZS1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGdCQUFnQjtBQUNsQiIsImZpbGUiOiJzcmMvYXBwL2J1dHRvbnMtYW5kLWluZGljYXRvcnMvcHJvZ3Jlc3MtYmFyL2NvbXBvbmVudHMvcHJvZ3Jlc3MtYmFyLWluZGV0ZXJtaW5hdGUtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJtYXQtcHJvZ3Jlc3MtYmFyIHtcclxuICBtYXJnaW4tdG9wOiAyMHB4O1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarIndeterminateExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'progress-bar-indeterminate-example',
            templateUrl: 'progress-bar-indeterminate-example.html',
            styleUrls: ['progress-bar-indeterminate-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-query-example.ts":
    /*!**********************************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/components/progress-bar-query-example.ts ***!
      \**********************************************************************************************/
    /*! exports provided: ProgressBarQueryExample */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarComponentsProgressBarQueryExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarQueryExample", function () {
        return ProgressBarQueryExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/progress-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");

      /**
       * @title Query progress-bar
       */
      var ProgressBarQueryExample = /*#__PURE__*/_createClass(function ProgressBarQueryExample() {
        _classCallCheck(this, ProgressBarQueryExample);
      });
      ProgressBarQueryExample.ɵfac = function ProgressBarQueryExample_Factory(t) {
        return new (t || ProgressBarQueryExample)();
      };
      ProgressBarQueryExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ProgressBarQueryExample,
        selectors: [["progress-bar-query-example"]],
        decls: 4,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/progress-bar/overview#query"], ["id", "mat-progress-bar-query", "mode", "query"]],
        template: function ProgressBarQueryExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Query progress-bar ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "mat-progress-bar", 2);
          }
        },
        directives: [_angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_1__["MatProgressBar"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarQueryExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'progress-bar-query-example',
            templateUrl: 'progress-bar-query-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/progress-bar-routing.module.ts":
    /*!************************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/progress-bar-routing.module.ts ***!
      \************************************************************************************/
    /*! exports provided: ProgressBarRoutingModule */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarProgressBarRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarRoutingModule", function () {
        return ProgressBarRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _progress_bar_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./progress-bar.component */"./src/app/buttons-and-indicators/progress-bar/progress-bar.component.ts");
      var routes = [{
        path: '',
        component: _progress_bar_component__WEBPACK_IMPORTED_MODULE_2__["ProgressBarComponent"]
      }];
      var ProgressBarRoutingModule = /*#__PURE__*/_createClass(function ProgressBarRoutingModule() {
        _classCallCheck(this, ProgressBarRoutingModule);
      });
      ProgressBarRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ProgressBarRoutingModule
      });
      ProgressBarRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ProgressBarRoutingModule_Factory(t) {
          return new (t || ProgressBarRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ProgressBarRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/progress-bar.component.ts":
    /*!*******************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/progress-bar.component.ts ***!
      \*******************************************************************************/
    /*! exports provided: ProgressBarComponent */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarProgressBarComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarComponent", function () {
        return ProgressBarComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_progress_bar_buffer_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/progress-bar-buffer-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-buffer-example.ts");
      /* harmony import */
      var _components_progress_bar_determinate_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/progress-bar-determinate-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-determinate-example.ts");
      /* harmony import */
      var _components_progress_bar_indeterminate_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./components/progress-bar-indeterminate-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-indeterminate-example.ts");
      /* harmony import */
      var _components_progress_bar_query_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/progress-bar-query-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-query-example.ts");
      /* harmony import */
      var _components_progress_bar_configurable_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/progress-bar-configurable-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-configurable-example.ts");
      var ProgressBarComponent = /*#__PURE__*/_createClass(function ProgressBarComponent() {
        _classCallCheck(this, ProgressBarComponent);
      });
      ProgressBarComponent.ɵfac = function ProgressBarComponent_Factory(t) {
        return new (t || ProgressBarComponent)();
      };
      ProgressBarComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ProgressBarComponent,
        selectors: [["app-progress-bar"]],
        decls: 5,
        vars: 0,
        template: function ProgressBarComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "progress-bar-buffer-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "progress-bar-determinate-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "progress-bar-indeterminate-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "progress-bar-query-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "progress-bar-configurable-example");
          }
        },
        directives: [_components_progress_bar_buffer_example__WEBPACK_IMPORTED_MODULE_1__["ProgressBarBufferExample"], _components_progress_bar_determinate_example__WEBPACK_IMPORTED_MODULE_2__["ProgressBarDeterminateExample"], _components_progress_bar_indeterminate_example__WEBPACK_IMPORTED_MODULE_3__["ProgressBarIndeterminateExample"], _components_progress_bar_query_example__WEBPACK_IMPORTED_MODULE_4__["ProgressBarQueryExample"], _components_progress_bar_configurable_example__WEBPACK_IMPORTED_MODULE_5__["ProgressBarConfigurableExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-progress-bar',
            templateUrl: './progress-bar.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/progress-bar/progress-bar.module.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/progress-bar/progress-bar.module.ts ***!
      \****************************************************************************/
    /*! exports provided: ProgressBarModule */
    /***/
    function srcAppButtonsAndIndicatorsProgressBarProgressBarModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ProgressBarModule", function () {
        return ProgressBarModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _progress_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./progress-bar-routing.module */"./src/app/buttons-and-indicators/progress-bar/progress-bar-routing.module.ts");
      /* harmony import */
      var _progress_bar_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./progress-bar.component */"./src/app/buttons-and-indicators/progress-bar/progress-bar.component.ts");
      /* harmony import */
      var _components_progress_bar_buffer_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/progress-bar-buffer-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-buffer-example.ts");
      /* harmony import */
      var _components_progress_bar_determinate_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/progress-bar-determinate-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-determinate-example.ts");
      /* harmony import */
      var _components_progress_bar_configurable_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./components/progress-bar-configurable-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-configurable-example.ts");
      /* harmony import */
      var _components_progress_bar_indeterminate_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! ./components/progress-bar-indeterminate-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-indeterminate-example.ts");
      /* harmony import */
      var _components_progress_bar_query_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! ./components/progress-bar-query-example */"./src/app/buttons-and-indicators/progress-bar/components/progress-bar-query-example.ts");
      /* harmony import */
      var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/material/progress-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
      /* harmony import */
      var _angular_material_radio__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! @angular/material/radio */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_slider__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__( /*! @angular/material/slider */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slider.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      var ProgressBarModule = /*#__PURE__*/_createClass(function ProgressBarModule() {
        _classCallCheck(this, ProgressBarModule);
      });
      ProgressBarModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ProgressBarModule
      });
      ProgressBarModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ProgressBarModule_Factory(t) {
          return new (t || ProgressBarModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _progress_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__["ProgressBarRoutingModule"], _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_9__["MatProgressBarModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_10__["MatCardModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_11__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormsModule"], _angular_material_slider__WEBPACK_IMPORTED_MODULE_13__["MatSliderModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_14__["MatButtonModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ProgressBarModule, {
          declarations: [_progress_bar_component__WEBPACK_IMPORTED_MODULE_3__["ProgressBarComponent"], _components_progress_bar_buffer_example__WEBPACK_IMPORTED_MODULE_4__["ProgressBarBufferExample"], _components_progress_bar_determinate_example__WEBPACK_IMPORTED_MODULE_5__["ProgressBarDeterminateExample"], _components_progress_bar_configurable_example__WEBPACK_IMPORTED_MODULE_6__["ProgressBarConfigurableExample"], _components_progress_bar_indeterminate_example__WEBPACK_IMPORTED_MODULE_7__["ProgressBarIndeterminateExample"], _components_progress_bar_query_example__WEBPACK_IMPORTED_MODULE_8__["ProgressBarQueryExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _progress_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__["ProgressBarRoutingModule"], _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_9__["MatProgressBarModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_10__["MatCardModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_11__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormsModule"], _angular_material_slider__WEBPACK_IMPORTED_MODULE_13__["MatSliderModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_14__["MatButtonModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ProgressBarModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_progress_bar_component__WEBPACK_IMPORTED_MODULE_3__["ProgressBarComponent"], _components_progress_bar_buffer_example__WEBPACK_IMPORTED_MODULE_4__["ProgressBarBufferExample"], _components_progress_bar_determinate_example__WEBPACK_IMPORTED_MODULE_5__["ProgressBarDeterminateExample"], _components_progress_bar_configurable_example__WEBPACK_IMPORTED_MODULE_6__["ProgressBarConfigurableExample"], _components_progress_bar_indeterminate_example__WEBPACK_IMPORTED_MODULE_7__["ProgressBarIndeterminateExample"], _components_progress_bar_query_example__WEBPACK_IMPORTED_MODULE_8__["ProgressBarQueryExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _progress_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__["ProgressBarRoutingModule"], _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_9__["MatProgressBarModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_10__["MatCardModule"], _angular_material_radio__WEBPACK_IMPORTED_MODULE_11__["MatRadioModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormsModule"], _angular_material_slider__WEBPACK_IMPORTED_MODULE_13__["MatSliderModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_14__["MatButtonModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=buttons-and-indicators-progress-bar-progress-bar-module-es5.js.map