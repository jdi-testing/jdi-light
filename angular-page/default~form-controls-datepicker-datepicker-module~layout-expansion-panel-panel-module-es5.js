(function () {
  function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function"); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, writable: true, configurable: true } }); Object.defineProperty(subClass, "prototype", { writable: false }); if (superClass) _setPrototypeOf(subClass, superClass); }
  function _setPrototypeOf(o, p) { _setPrototypeOf = Object.setPrototypeOf ? Object.setPrototypeOf.bind() : function _setPrototypeOf(o, p) { o.__proto__ = p; return o; }; return _setPrototypeOf(o, p); }
  function _createSuper(Derived) { var hasNativeReflectConstruct = _isNativeReflectConstruct(); return function _createSuperInternal() { var Super = _getPrototypeOf(Derived), result; if (hasNativeReflectConstruct) { var NewTarget = _getPrototypeOf(this).constructor; result = Reflect.construct(Super, arguments, NewTarget); } else { result = Super.apply(this, arguments); } return _possibleConstructorReturn(this, result); }; }
  function _possibleConstructorReturn(self, call) { if (call && (typeof call === "object" || typeof call === "function")) { return call; } else if (call !== void 0) { throw new TypeError("Derived constructors may only return object or undefined"); } return _assertThisInitialized(self); }
  function _assertThisInitialized(self) { if (self === void 0) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return self; }
  function _isNativeReflectConstruct() { if (typeof Reflect === "undefined" || !Reflect.construct) return false; if (Reflect.construct.sham) return false; if (typeof Proxy === "function") return true; try { Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {})); return true; } catch (e) { return false; } }
  function _getPrototypeOf(o) { _getPrototypeOf = Object.setPrototypeOf ? Object.getPrototypeOf.bind() : function _getPrototypeOf(o) { return o.__proto__ || Object.getPrototypeOf(o); }; return _getPrototypeOf(o); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["default~form-controls-datepicker-datepicker-module~layout-expansion-panel-panel-module"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/datepicker.js":
    /*!****************************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/datepicker.js ***!
      \****************************************************************************/
    /*! exports provided: MAT_DATEPICKER_SCROLL_STRATEGY, MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY, MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY_PROVIDER, MAT_DATEPICKER_VALIDATORS, MAT_DATEPICKER_VALUE_ACCESSOR, MatCalendar, MatCalendarBody, MatCalendarCell, MatCalendarHeader, MatDatepicker, MatDatepickerContent, MatDatepickerInput, MatDatepickerInputEvent, MatDatepickerIntl, MatDatepickerModule, MatDatepickerToggle, MatDatepickerToggleIcon, MatMonthView, MatMultiYearView, MatYearView, matDatepickerAnimations, yearsPerPage, yearsPerRow */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015DatepickerJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DATEPICKER_SCROLL_STRATEGY", function () {
        return MAT_DATEPICKER_SCROLL_STRATEGY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY", function () {
        return MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY_PROVIDER", function () {
        return MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY_PROVIDER;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DATEPICKER_VALIDATORS", function () {
        return MAT_DATEPICKER_VALIDATORS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DATEPICKER_VALUE_ACCESSOR", function () {
        return MAT_DATEPICKER_VALUE_ACCESSOR;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatCalendar", function () {
        return MatCalendar;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatCalendarBody", function () {
        return MatCalendarBody;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatCalendarCell", function () {
        return MatCalendarCell;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatCalendarHeader", function () {
        return MatCalendarHeader;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepicker", function () {
        return MatDatepicker;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerContent", function () {
        return MatDatepickerContent;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerInput", function () {
        return MatDatepickerInput;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerInputEvent", function () {
        return MatDatepickerInputEvent;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerIntl", function () {
        return MatDatepickerIntl;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerModule", function () {
        return MatDatepickerModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerToggle", function () {
        return MatDatepickerToggle;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDatepickerToggleIcon", function () {
        return MatDatepickerToggleIcon;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMonthView", function () {
        return MatMonthView;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMultiYearView", function () {
        return MatMultiYearView;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatYearView", function () {
        return MatYearView;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "matDatepickerAnimations", function () {
        return matDatepickerAnimations;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "yearsPerPage", function () {
        return yearsPerPage;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "yearsPerRow", function () {
        return yearsPerRow;
      });
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/overlay */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/overlay.js");
      /* harmony import */
      var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/cdk/portal */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/portal.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/dialog */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/dialog.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/cdk/keycodes */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/keycodes.js");
      /* harmony import */
      var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/cdk/bidi */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/bidi.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! @angular/cdk/coercion */"./node_modules/@angular/cdk/fesm2015/coercion.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker-errors.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * @license
       * Copyright Google LLC All Rights Reserved.
       *
       * Use of this source code is governed by an MIT-style license that can be
       * found in the LICENSE file at https://angular.io/license
       */
      /**
       * \@docs-private
       * @param {?} provider
       * @return {?}
       */

      var _c0 = ["mat-calendar-body", ""];
      function MatCalendarBody_tr_0_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "tr", 2);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "td", 3);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵstyleProp"]("padding-top", ctx_r3._cellPadding)("padding-bottom", ctx_r3._cellPadding);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("colspan", ctx_r3.numCols);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", ctx_r3.label, " ");
        }
      }
      function MatCalendarBody_tr_1_td_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "td", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵstyleProp"]("padding-top", ctx_r7._cellPadding)("padding-bottom", ctx_r7._cellPadding);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("colspan", ctx_r7._firstRowOffset);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", ctx_r7._firstRowOffset >= ctx_r7.labelMinRequiredCells ? ctx_r7.label : "", " ");
        }
      }
      function MatCalendarBody_tr_1_td_2_Template(rf, ctx) {
        if (rf & 1) {
          var _r12 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "td", 8);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function MatCalendarBody_tr_1_td_2_Template_td_click_0_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r12);
            var item_r9 = ctx.$implicit;
            var ctx_r11 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
            return ctx_r11._cellClicked(item_r9);
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "div", 9);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var item_r9 = ctx.$implicit;
          var colIndex_r10 = ctx.index;
          var rowIndex_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]().index;
          var ctx_r8 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵstyleProp"]("width", ctx_r8._cellWidth)("padding-top", ctx_r8._cellPadding)("padding-bottom", ctx_r8._cellPadding);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵclassProp"]("mat-calendar-body-disabled", !item_r9.enabled)("mat-calendar-body-active", ctx_r8._isActiveCell(rowIndex_r6, colIndex_r10));
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngClass", item_r9.cssClasses)("tabindex", ctx_r8._isActiveCell(rowIndex_r6, colIndex_r10) ? 0 : 0 - 1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-label", item_r9.ariaLabel)("aria-disabled", !item_r9.enabled || null)("aria-selected", ctx_r8.selectedValue === item_r9.value);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵclassProp"]("mat-calendar-body-selected", ctx_r8.selectedValue === item_r9.value)("mat-calendar-body-today", ctx_r8.todayValue === item_r9.value);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", item_r9.displayValue, " ");
        }
      }
      function MatCalendarBody_tr_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "tr", 4);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, MatCalendarBody_tr_1_td_1_Template, 2, 6, "td", 5);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, MatCalendarBody_tr_1_td_2_Template, 3, 20, "td", 6);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r5 = ctx.$implicit;
          var rowIndex_r6 = ctx.index;
          var ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", rowIndex_r6 === 0 && ctx_r4._firstRowOffset);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", row_r5);
        }
      }
      function MatMonthView_th_3_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "th", 5);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var day_r15 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-label", day_r15["long"]);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate"](day_r15.narrow);
        }
      }
      var _c1 = ["*"];
      function MatCalendar_ng_template_0_Template(rf, ctx) {}
      function MatCalendar_mat_month_view_2_Template(rf, ctx) {
        if (rf & 1) {
          var _r21 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-month-view", 5);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("activeDateChange", function MatCalendar_mat_month_view_2_Template_mat_month_view_activeDateChange_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r21);
            var ctx_r20 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r20.activeDate = $event;
          })("selectedChange", function MatCalendar_mat_month_view_2_Template_mat_month_view_selectedChange_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r21);
            var ctx_r22 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r22._dateSelected($event);
          })("_userSelection", function MatCalendar_mat_month_view_2_Template_mat_month_view__userSelection_0_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r21);
            var ctx_r23 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r23._userSelected();
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r17 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("activeDate", ctx_r17.activeDate)("selected", ctx_r17.selected)("dateFilter", ctx_r17.dateFilter)("maxDate", ctx_r17.maxDate)("minDate", ctx_r17.minDate)("dateClass", ctx_r17.dateClass);
        }
      }
      function MatCalendar_mat_year_view_3_Template(rf, ctx) {
        if (rf & 1) {
          var _r25 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-year-view", 6);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("activeDateChange", function MatCalendar_mat_year_view_3_Template_mat_year_view_activeDateChange_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r25);
            var ctx_r24 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r24.activeDate = $event;
          })("monthSelected", function MatCalendar_mat_year_view_3_Template_mat_year_view_monthSelected_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r25);
            var ctx_r26 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r26._monthSelectedInYearView($event);
          })("selectedChange", function MatCalendar_mat_year_view_3_Template_mat_year_view_selectedChange_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r25);
            var ctx_r27 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r27._goToDateInView($event, "month");
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r18 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("activeDate", ctx_r18.activeDate)("selected", ctx_r18.selected)("dateFilter", ctx_r18.dateFilter)("maxDate", ctx_r18.maxDate)("minDate", ctx_r18.minDate);
        }
      }
      function MatCalendar_mat_multi_year_view_4_Template(rf, ctx) {
        if (rf & 1) {
          var _r29 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-multi-year-view", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("activeDateChange", function MatCalendar_mat_multi_year_view_4_Template_mat_multi_year_view_activeDateChange_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r29);
            var ctx_r28 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r28.activeDate = $event;
          })("yearSelected", function MatCalendar_mat_multi_year_view_4_Template_mat_multi_year_view_yearSelected_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r29);
            var ctx_r30 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r30._yearSelectedInMultiYearView($event);
          })("selectedChange", function MatCalendar_mat_multi_year_view_4_Template_mat_multi_year_view_selectedChange_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r29);
            var ctx_r31 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
            return ctx_r31._goToDateInView($event, "year");
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r19 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("activeDate", ctx_r19.activeDate)("selected", ctx_r19.selected)("dateFilter", ctx_r19.dateFilter)("maxDate", ctx_r19.maxDate)("minDate", ctx_r19.minDate);
        }
      }
      var _c2 = ["button"];
      function MatDatepickerToggle__svg_svg_2_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnamespaceSVG"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "svg", 3);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "path", 4);
          _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        }
      }
      var _c3 = [[["", "matDatepickerToggleIcon", ""]]];
      var _c4 = ["[matDatepickerToggleIcon]"];
      function createMissingDateImplError(provider) {
        return Error("MatDatepicker: No provider found for ".concat(provider, ". You must import one of the following ") + "modules at your application root: MatNativeDateModule, MatMomentDateModule, or provide a " + "custom implementation.");
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker-intl.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Datepicker data that requires internationalization.
       */
      var MatDatepickerIntl = /*#__PURE__*/function () {
        function MatDatepickerIntl() {
          _classCallCheck(this, MatDatepickerIntl);
          /**
           * Stream that emits whenever the labels here are changed. Use this to notify
           * components if the labels have changed after initialization.
           */
          this.changes = new rxjs__WEBPACK_IMPORTED_MODULE_8__["Subject"]();
          /**
           * A label for the calendar popup (used by screen readers).
           */
          this.calendarLabel = 'Calendar';
          /**
           * A label for the button used to open the calendar popup (used by screen readers).
           */
          this.openCalendarLabel = 'Open calendar';
          /**
           * A label for the previous month button (used by screen readers).
           */
          this.prevMonthLabel = 'Previous month';
          /**
           * A label for the next month button (used by screen readers).
           */
          this.nextMonthLabel = 'Next month';
          /**
           * A label for the previous year button (used by screen readers).
           */
          this.prevYearLabel = 'Previous year';
          /**
           * A label for the next year button (used by screen readers).
           */
          this.nextYearLabel = 'Next year';
          /**
           * A label for the previous multi-year button (used by screen readers).
           */
          this.prevMultiYearLabel = 'Previous 20 years';
          /**
           * A label for the next multi-year button (used by screen readers).
           */
          this.nextMultiYearLabel = 'Next 20 years';
          /**
           * A label for the 'switch to month view' button (used by screen readers).
           */
          this.switchToMonthViewLabel = 'Choose date';
          /**
           * A label for the 'switch to year view' button (used by screen readers).
           */
          this.switchToMultiYearViewLabel = 'Choose month and year';
        }
        /**
         * Formats a range of years.
         * @param {?} start
         * @param {?} end
         * @return {?}
         */
        _createClass(MatDatepickerIntl, [{
          key: "formatYearRange",
          value: function formatYearRange(start, end) {
            return "".concat(start, " \u2013 ").concat(end);
          }
        }]);
        return MatDatepickerIntl;
      }();
      MatDatepickerIntl.ɵfac = function MatDatepickerIntl_Factory(t) {
        return new (t || MatDatepickerIntl)();
      };
      /** @nocollapse */
      MatDatepickerIntl.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjectable"])({
        factory: function MatDatepickerIntl_Factory() {
          return new MatDatepickerIntl();
        },
        token: MatDatepickerIntl,
        providedIn: "root"
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepickerIntl, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/calendar-body.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * An internal class that represents the data corresponding to a single calendar cell.
       * \@docs-private
       */
      var MatCalendarCell = /*#__PURE__*/_createClass(
      /**
       * @param {?} value
       * @param {?} displayValue
       * @param {?} ariaLabel
       * @param {?} enabled
       * @param {?=} cssClasses
       */
      function MatCalendarCell(value, displayValue, ariaLabel, enabled) {
        var cssClasses = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : {};
        _classCallCheck(this, MatCalendarCell);
        this.value = value;
        this.displayValue = displayValue;
        this.ariaLabel = ariaLabel;
        this.enabled = enabled;
        this.cssClasses = cssClasses;
      });
      if (false) {}
      /**
       * An internal component used to display calendar data in a table.
       * \@docs-private
       */
      var MatCalendarBody = /*#__PURE__*/function () {
        /**
         * @param {?} _elementRef
         * @param {?} _ngZone
         */
        function MatCalendarBody(_elementRef, _ngZone) {
          _classCallCheck(this, MatCalendarBody);
          this._elementRef = _elementRef;
          this._ngZone = _ngZone;
          /**
           * The number of columns in the table.
           */
          this.numCols = 7;
          /**
           * The cell number of the active cell in the table.
           */
          this.activeCell = 0;
          /**
           * The aspect ratio (width / height) to use for the cells in the table. This aspect ratio will be
           * maintained even as the table resizes.
           */
          this.cellAspectRatio = 1;
          /**
           * Emits when a new value is selected.
           */
          this.selectedValueChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
        }
        /**
         * @param {?} cell
         * @return {?}
         */
        _createClass(MatCalendarBody, [{
          key: "_cellClicked",
          value: function _cellClicked(cell) {
            if (cell.enabled) {
              this.selectedValueChange.emit(cell.value);
            }
          }
          /**
           * @param {?} changes
           * @return {?}
           */
        }, {
          key: "ngOnChanges",
          value: function ngOnChanges(changes) {
            /** @type {?} */
            var columnChanges = changes['numCols'];
            var rows = this.rows,
              numCols = this.numCols;
            if (changes['rows'] || columnChanges) {
              this._firstRowOffset = rows && rows.length && rows[0].length ? numCols - rows[0].length : 0;
            }
            if (changes['cellAspectRatio'] || columnChanges || !this._cellPadding) {
              this._cellPadding = "".concat(50 * this.cellAspectRatio / numCols, "%");
            }
            if (columnChanges || !this._cellWidth) {
              this._cellWidth = "".concat(100 / numCols, "%");
            }
          }
          /**
           * @param {?} rowIndex
           * @param {?} colIndex
           * @return {?}
           */
        }, {
          key: "_isActiveCell",
          value: function _isActiveCell(rowIndex, colIndex) {
            /** @type {?} */
            var cellNumber = rowIndex * this.numCols + colIndex;
            // Account for the fact that the first row may not have as many cells.
            if (rowIndex) {
              cellNumber -= this._firstRowOffset;
            }
            return cellNumber == this.activeCell;
          }
          /**
           * Focuses the active cell after the microtask queue is empty.
           * @return {?}
           */
        }, {
          key: "_focusActiveCell",
          value: function _focusActiveCell() {
            var _this = this;
            this._ngZone.runOutsideAngular(
            /**
            * @return {?}
            */
            function () {
              _this._ngZone.onStable.asObservable().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
              /**
              * @return {?}
              */
              function () {
                /** @type {?} */
                var activeCell = _this._elementRef.nativeElement.querySelector('.mat-calendar-body-active');
                if (activeCell) {
                  activeCell.focus();
                }
              });
            });
          }
        }]);
        return MatCalendarBody;
      }();
      MatCalendarBody.ɵfac = function MatCalendarBody_Factory(t) {
        return new (t || MatCalendarBody)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["NgZone"]));
      };
      MatCalendarBody.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatCalendarBody,
        selectors: [["", "mat-calendar-body", ""]],
        hostAttrs: ["role", "grid", "aria-readonly", "true", 1, "mat-calendar-body"],
        inputs: {
          numCols: "numCols",
          activeCell: "activeCell",
          cellAspectRatio: "cellAspectRatio",
          label: "label",
          rows: "rows",
          todayValue: "todayValue",
          selectedValue: "selectedValue",
          labelMinRequiredCells: "labelMinRequiredCells"
        },
        outputs: {
          selectedValueChange: "selectedValueChange"
        },
        exportAs: ["matCalendarBody"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵNgOnChangesFeature"]],
        attrs: _c0,
        decls: 2,
        vars: 2,
        consts: [["aria-hidden", "true", 4, "ngIf"], ["role", "row", 4, "ngFor", "ngForOf"], ["aria-hidden", "true"], [1, "mat-calendar-body-label"], ["role", "row"], ["aria-hidden", "true", "class", "mat-calendar-body-label", 3, "paddingTop", "paddingBottom", 4, "ngIf"], ["role", "gridcell", "class", "mat-calendar-body-cell mat-focus-indicator", "role", "button", 3, "ngClass", "tabindex", "mat-calendar-body-disabled", "mat-calendar-body-active", "width", "paddingTop", "paddingBottom", "click", 4, "ngFor", "ngForOf"], ["aria-hidden", "true", 1, "mat-calendar-body-label"], ["role", "gridcell", "role", "button", 1, "mat-calendar-body-cell", "mat-focus-indicator", 3, "ngClass", "tabindex", "click"], [1, "mat-calendar-body-cell-content"]],
        template: function MatCalendarBody_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, MatCalendarBody_tr_0_Template, 3, 6, "tr", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, MatCalendarBody_tr_1_Template, 3, 2, "tr", 1);
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx._firstRowOffset < ctx.labelMinRequiredCells);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx.rows);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgClass"]],
        styles: [".mat-calendar-body{min-width:224px}.mat-calendar-body-label{height:0;line-height:0;text-align:left;padding-left:4.7142857143%;padding-right:4.7142857143%}.mat-calendar-body-cell{position:relative;height:0;line-height:0;text-align:center;outline:none;cursor:pointer}.mat-calendar-body-disabled{cursor:default}.mat-calendar-body-cell-content{position:absolute;top:5%;left:5%;display:flex;align-items:center;justify-content:center;box-sizing:border-box;width:90%;height:90%;line-height:1;border-width:1px;border-style:solid;border-radius:999px}.cdk-high-contrast-active .mat-calendar-body-cell-content{border:none}.cdk-high-contrast-active .mat-datepicker-popup:not(:empty),.cdk-high-contrast-active .mat-calendar-body-selected{outline:solid 1px}.cdk-high-contrast-active .mat-calendar-body-today{outline:dotted 1px}.cdk-high-contrast-active .cdk-keyboard-focused .mat-calendar-body-active>.mat-calendar-body-cell-content:not(.mat-calendar-body-selected),.cdk-high-contrast-active .cdk-program-focused .mat-calendar-body-active>.mat-calendar-body-cell-content:not(.mat-calendar-body-selected){outline:dotted 2px}[dir=rtl] .mat-calendar-body-label{text-align:right}\n"],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatCalendarBody.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["NgZone"]
        }];
      };
      MatCalendarBody.propDecorators = {
        label: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        rows: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        todayValue: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selectedValue: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        labelMinRequiredCells: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        numCols: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        activeCell: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        cellAspectRatio: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selectedValueChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatCalendarBody, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: '[mat-calendar-body]',
            template: "<!--\n  If there's not enough space in the first row, create a separate label row. We mark this row as\n  aria-hidden because we don't want it to be read out as one of the weeks in the month.\n-->\n<tr *ngIf=\"_firstRowOffset < labelMinRequiredCells\" aria-hidden=\"true\">\n  <td class=\"mat-calendar-body-label\"\n      [attr.colspan]=\"numCols\"\n      [style.paddingTop]=\"_cellPadding\"\n      [style.paddingBottom]=\"_cellPadding\">\n    {{label}}\n  </td>\n</tr>\n\n<!-- Create the first row separately so we can include a special spacer cell. -->\n<tr *ngFor=\"let row of rows; let rowIndex = index\" role=\"row\">\n  <!--\n    We mark this cell as aria-hidden so it doesn't get read out as one of the days in the week.\n    The aspect ratio of the table cells is maintained by setting the top and bottom padding as a\n    percentage of the width (a variant of the trick described here:\n    https://www.w3schools.com/howto/howto_css_aspect_ratio.asp).\n  -->\n  <td *ngIf=\"rowIndex === 0 && _firstRowOffset\"\n      aria-hidden=\"true\"\n      class=\"mat-calendar-body-label\"\n      [attr.colspan]=\"_firstRowOffset\"\n      [style.paddingTop]=\"_cellPadding\"\n      [style.paddingBottom]=\"_cellPadding\">\n    {{_firstRowOffset >= labelMinRequiredCells ? label : ''}}\n  </td>\n  <td *ngFor=\"let item of row; let colIndex = index\"\n      role=\"gridcell\"\n      class=\"mat-calendar-body-cell mat-focus-indicator\"\n      [ngClass]=\"item.cssClasses\"\n      [tabindex]=\"_isActiveCell(rowIndex, colIndex) ? 0 : -1\"\n      [class.mat-calendar-body-disabled]=\"!item.enabled\"\n      [class.mat-calendar-body-active]=\"_isActiveCell(rowIndex, colIndex)\"\n      [attr.aria-label]=\"item.ariaLabel\"\n      [attr.aria-disabled]=\"!item.enabled || null\"\n      [attr.aria-selected]=\"selectedValue === item.value\"\n      (click)=\"_cellClicked(item)\"\n      [style.width]=\"_cellWidth\"\n      [style.paddingTop]=\"_cellPadding\"\n      role=\"button\"\n      [style.paddingBottom]=\"_cellPadding\">\n      <div class=\"mat-calendar-body-cell-content\"\n        [class.mat-calendar-body-selected]=\"selectedValue === item.value\"\n        [class.mat-calendar-body-today]=\"todayValue === item.value\">\n        {{item.displayValue}}\n      </div>\n  </td>\n</tr>\n",
            host: {
              'class': 'mat-calendar-body',
              'role': 'grid',
              'aria-readonly': 'true'
            },
            exportAs: 'matCalendarBody',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush,
            styles: [".mat-calendar-body{min-width:224px}.mat-calendar-body-label{height:0;line-height:0;text-align:left;padding-left:4.7142857143%;padding-right:4.7142857143%}.mat-calendar-body-cell{position:relative;height:0;line-height:0;text-align:center;outline:none;cursor:pointer}.mat-calendar-body-disabled{cursor:default}.mat-calendar-body-cell-content{position:absolute;top:5%;left:5%;display:flex;align-items:center;justify-content:center;box-sizing:border-box;width:90%;height:90%;line-height:1;border-width:1px;border-style:solid;border-radius:999px}.cdk-high-contrast-active .mat-calendar-body-cell-content{border:none}.cdk-high-contrast-active .mat-datepicker-popup:not(:empty),.cdk-high-contrast-active .mat-calendar-body-selected{outline:solid 1px}.cdk-high-contrast-active .mat-calendar-body-today{outline:dotted 1px}.cdk-high-contrast-active .cdk-keyboard-focused .mat-calendar-body-active>.mat-calendar-body-cell-content:not(.mat-calendar-body-selected),.cdk-high-contrast-active .cdk-program-focused .mat-calendar-body-active>.mat-calendar-body-cell-content:not(.mat-calendar-body-selected){outline:dotted 2px}[dir=rtl] .mat-calendar-body-label{text-align:right}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["NgZone"]
          }];
        }, {
          numCols: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          activeCell: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          cellAspectRatio: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selectedValueChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          label: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          rows: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          todayValue: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selectedValue: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          labelMinRequiredCells: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/month-view.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /** @type {?} */
      var DAYS_PER_WEEK = 7;
      /**
       * An internal component used to display a single month in the datepicker.
       * \@docs-private
       * @template D
       */
      var MatMonthView = /*#__PURE__*/function () {
        /**
         * @param {?} _changeDetectorRef
         * @param {?} _dateFormats
         * @param {?} _dateAdapter
         * @param {?=} _dir
         */
        function MatMonthView(_changeDetectorRef, _dateFormats, _dateAdapter, _dir) {
          _classCallCheck(this, MatMonthView);
          this._changeDetectorRef = _changeDetectorRef;
          this._dateFormats = _dateFormats;
          this._dateAdapter = _dateAdapter;
          this._dir = _dir;
          this._rerenderSubscription = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          /**
           * Emits when a new date is selected.
           */
          this.selectedChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when any date is selected.
           */
          this._userSelection = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when any date is activated.
           */
          this.activeDateChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          if (!this._dateAdapter) {
            throw createMissingDateImplError('DateAdapter');
          }
          if (!this._dateFormats) {
            throw createMissingDateImplError('MAT_DATE_FORMATS');
          }
          this._activeDate = this._dateAdapter.today();
        }
        /**
         * The date to display in this month view (everything other than the month and year is ignored).
         * @return {?}
         */
        _createClass(MatMonthView, [{
          key: "activeDate",
          get: function get() {
            return this._activeDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            /** @type {?} */
            var oldActiveDate = this._activeDate;
            /** @type {?} */
            var validDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value)) || this._dateAdapter.today();
            this._activeDate = this._dateAdapter.clampDate(validDate, this.minDate, this.maxDate);
            if (!this._hasSameMonthAndYear(oldActiveDate, this._activeDate)) {
              this._init();
            }
          }
          /**
           * The currently selected date.
           * @return {?}
           */
        }, {
          key: "selected",
          get: function get() {
            return this._selected;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._selected = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
            this._selectedDate = this._getDateInCurrentMonth(this._selected);
          }
          /**
           * The minimum selectable date.
           * @return {?}
           */
        }, {
          key: "minDate",
          get: function get() {
            return this._minDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._minDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The maximum selectable date.
           * @return {?}
           */
        }, {
          key: "maxDate",
          get: function get() {
            return this._maxDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._maxDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            var _this2 = this;
            this._rerenderSubscription = this._dateAdapter.localeChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["startWith"])(null)).subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this2._init();
            });
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._rerenderSubscription.unsubscribe();
          }
          /**
           * Handles when a new date is selected.
           * @param {?} date
           * @return {?}
           */
        }, {
          key: "_dateSelected",
          value: function _dateSelected(date) {
            if (this._selectedDate != date) {
              /** @type {?} */
              var selectedYear = this._dateAdapter.getYear(this.activeDate);
              /** @type {?} */
              var selectedMonth = this._dateAdapter.getMonth(this.activeDate);
              /** @type {?} */
              var selectedDate = this._dateAdapter.createDate(selectedYear, selectedMonth, date);
              this.selectedChange.emit(selectedDate);
            }
            this._userSelection.emit();
          }
          /**
           * Handles keydown events on the calendar body when calendar is in month view.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleCalendarBodyKeydown",
          value: function _handleCalendarBodyKeydown(event) {
            // TODO(mmalerba): We currently allow keyboard navigation to disabled dates, but just prevent
            // disabled ones from being selected. This may not be ideal, we should look into whether
            // navigation should skip over disabled dates, and if so, how to implement that efficiently.
            // TODO(mmalerba): We currently allow keyboard navigation to disabled dates, but just prevent
            // disabled ones from being selected. This may not be ideal, we should look into whether
            // navigation should skip over disabled dates, and if so, how to implement that efficiently.
            /** @type {?} */
            var oldActiveDate = this._activeDate;
            /** @type {?} */
            var isRtl = this._isRtl();
            switch (event.keyCode) {
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["LEFT_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarDays(this._activeDate, isRtl ? 1 : -1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["RIGHT_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarDays(this._activeDate, isRtl ? -1 : 1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["UP_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarDays(this._activeDate, -7);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["DOWN_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarDays(this._activeDate, 7);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["HOME"]:
                this.activeDate = this._dateAdapter.addCalendarDays(this._activeDate, 1 - this._dateAdapter.getDate(this._activeDate));
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["END"]:
                this.activeDate = this._dateAdapter.addCalendarDays(this._activeDate, this._dateAdapter.getNumDaysInMonth(this._activeDate) - this._dateAdapter.getDate(this._activeDate));
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["PAGE_UP"]:
                this.activeDate = event.altKey ? this._dateAdapter.addCalendarYears(this._activeDate, -1) : this._dateAdapter.addCalendarMonths(this._activeDate, -1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["PAGE_DOWN"]:
                this.activeDate = event.altKey ? this._dateAdapter.addCalendarYears(this._activeDate, 1) : this._dateAdapter.addCalendarMonths(this._activeDate, 1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["ENTER"]:
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["SPACE"]:
                if (!this.dateFilter || this.dateFilter(this._activeDate)) {
                  this._dateSelected(this._dateAdapter.getDate(this._activeDate));
                  this._userSelection.emit();
                  // Prevent unexpected default actions such as form submission.
                  event.preventDefault();
                }
                return;
              default:
                // Don't prevent default or focus active cell on keys that we don't explicitly handle.
                return;
            }
            if (this._dateAdapter.compareDate(oldActiveDate, this.activeDate)) {
              this.activeDateChange.emit(this.activeDate);
            }
            this._focusActiveCell();
            // Prevent unexpected default actions such as form submission.
            event.preventDefault();
          }
          /**
           * Initializes this month view.
           * @return {?}
           */
        }, {
          key: "_init",
          value: function _init() {
            this._selectedDate = this._getDateInCurrentMonth(this.selected);
            this._todayDate = this._getDateInCurrentMonth(this._dateAdapter.today());
            this._monthLabel = this._dateAdapter.getMonthNames('short')[this._dateAdapter.getMonth(this.activeDate)].toLocaleUpperCase();
            /** @type {?} */
            var firstOfMonth = this._dateAdapter.createDate(this._dateAdapter.getYear(this.activeDate), this._dateAdapter.getMonth(this.activeDate), 1);
            this._firstWeekOffset = (DAYS_PER_WEEK + this._dateAdapter.getDayOfWeek(firstOfMonth) - this._dateAdapter.getFirstDayOfWeek()) % DAYS_PER_WEEK;
            this._initWeekdays();
            this._createWeekCells();
            this._changeDetectorRef.markForCheck();
          }
          /**
           * Focuses the active cell after the microtask queue is empty.
           * @return {?}
           */
        }, {
          key: "_focusActiveCell",
          value: function _focusActiveCell() {
            this._matCalendarBody._focusActiveCell();
          }
          /**
           * Initializes the weekdays.
           * @private
           * @return {?}
           */
        }, {
          key: "_initWeekdays",
          value: function _initWeekdays() {
            /** @type {?} */
            var firstDayOfWeek = this._dateAdapter.getFirstDayOfWeek();
            /** @type {?} */
            var narrowWeekdays = this._dateAdapter.getDayOfWeekNames('narrow');
            /** @type {?} */
            var longWeekdays = this._dateAdapter.getDayOfWeekNames('long');
            // Rotate the labels for days of the week based on the configured first day of the week.
            /** @type {?} */
            var weekdays = longWeekdays.map(
            /**
            * @param {?} long
            * @param {?} i
            * @return {?}
            */
            function (_long, i) {
              return {
                "long": _long,
                narrow: narrowWeekdays[i]
              };
            });
            this._weekdays = weekdays.slice(firstDayOfWeek).concat(weekdays.slice(0, firstDayOfWeek));
          }
          /**
           * Creates MatCalendarCells for the dates in this month.
           * @private
           * @return {?}
           */
        }, {
          key: "_createWeekCells",
          value: function _createWeekCells() {
            /** @type {?} */
            var daysInMonth = this._dateAdapter.getNumDaysInMonth(this.activeDate);
            /** @type {?} */
            var dateNames = this._dateAdapter.getDateNames();
            this._weeks = [[]];
            for (var i = 0, cell = this._firstWeekOffset; i < daysInMonth; i++, cell++) {
              if (cell == DAYS_PER_WEEK) {
                this._weeks.push([]);
                cell = 0;
              }
              /** @type {?} */
              var date = this._dateAdapter.createDate(this._dateAdapter.getYear(this.activeDate), this._dateAdapter.getMonth(this.activeDate), i + 1);
              /** @type {?} */
              var enabled = this._shouldEnableDate(date);
              /** @type {?} */
              var ariaLabel = this._dateAdapter.format(date, this._dateFormats.display.dateA11yLabel);
              /** @type {?} */
              var cellClasses = this.dateClass ? this.dateClass(date) : undefined;
              this._weeks[this._weeks.length - 1].push(new MatCalendarCell(i + 1, dateNames[i], ariaLabel, enabled, cellClasses));
            }
          }
          /**
           * Date filter for the month
           * @private
           * @param {?} date
           * @return {?}
           */
        }, {
          key: "_shouldEnableDate",
          value: function _shouldEnableDate(date) {
            return !!date && (!this.minDate || this._dateAdapter.compareDate(date, this.minDate) >= 0) && (!this.maxDate || this._dateAdapter.compareDate(date, this.maxDate) <= 0) && (!this.dateFilter || this.dateFilter(date));
          }
          /**
           * Gets the date in this month that the given Date falls on.
           * Returns null if the given Date is in another month.
           * @private
           * @param {?} date
           * @return {?}
           */
        }, {
          key: "_getDateInCurrentMonth",
          value: function _getDateInCurrentMonth(date) {
            return date && this._hasSameMonthAndYear(date, this.activeDate) ? this._dateAdapter.getDate(date) : null;
          }
          /**
           * Checks whether the 2 dates are non-null and fall within the same month of the same year.
           * @private
           * @param {?} d1
           * @param {?} d2
           * @return {?}
           */
        }, {
          key: "_hasSameMonthAndYear",
          value: function _hasSameMonthAndYear(d1, d2) {
            return !!(d1 && d2 && this._dateAdapter.getMonth(d1) == this._dateAdapter.getMonth(d2) && this._dateAdapter.getYear(d1) == this._dateAdapter.getYear(d2));
          }
          /**
           * @private
           * @param {?} obj The object to check.
           * @return {?} The given object if it is both a date instance and valid, otherwise null.
           */
        }, {
          key: "_getValidDateOrNull",
          value: function _getValidDateOrNull(obj) {
            return this._dateAdapter.isDateInstance(obj) && this._dateAdapter.isValid(obj) ? obj : null;
          }
          /**
           * Determines whether the user has the RTL layout direction.
           * @private
           * @return {?}
           */
        }, {
          key: "_isRtl",
          value: function _isRtl() {
            return this._dir && this._dir.value === 'rtl';
          }
        }]);
        return MatMonthView;
      }();
      MatMonthView.ɵfac = function MatMonthView_Factory(t) {
        return new (t || MatMonthView)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"], 8));
      };
      MatMonthView.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatMonthView,
        selectors: [["mat-month-view"]],
        viewQuery: function MatMonthView_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatCalendarBody, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx._matCalendarBody = _t.first);
          }
        },
        inputs: {
          activeDate: "activeDate",
          selected: "selected",
          minDate: "minDate",
          maxDate: "maxDate",
          dateFilter: "dateFilter",
          dateClass: "dateClass"
        },
        outputs: {
          selectedChange: "selectedChange",
          _userSelection: "_userSelection",
          activeDateChange: "activeDateChange"
        },
        exportAs: ["matMonthView"],
        decls: 7,
        vars: 7,
        consts: [["role", "presentation", 1, "mat-calendar-table"], [1, "mat-calendar-table-header"], ["scope", "col", 4, "ngFor", "ngForOf"], ["colspan", "7", "aria-hidden", "true", 1, "mat-calendar-table-header-divider"], ["mat-calendar-body", "", 3, "label", "rows", "todayValue", "selectedValue", "labelMinRequiredCells", "activeCell", "selectedValueChange", "keydown"], ["scope", "col"]],
        template: function MatMonthView_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "table", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "thead", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](2, "tr");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, MatMonthView_th_3_Template, 2, 2, "th", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](4, "tr");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](5, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](6, "tbody", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("selectedValueChange", function MatMonthView_Template_tbody_selectedValueChange_6_listener($event) {
              return ctx._dateSelected($event);
            })("keydown", function MatMonthView_Template_tbody_keydown_6_listener($event) {
              return ctx._handleCalendarBodyKeydown($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx._weekdays);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("label", ctx._monthLabel)("rows", ctx._weeks)("todayValue", ctx._todayDate)("selectedValue", ctx._selectedDate)("labelMinRequiredCells", 3)("activeCell", ctx._dateAdapter.getDate(ctx.activeDate) - 1);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], MatCalendarBody],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatMonthView.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
          }]
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }];
      };
      MatMonthView.propDecorators = {
        activeDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        minDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        maxDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateFilter: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selectedChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        _userSelection: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        activeDateChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        _matCalendarBody: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatCalendarBody]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatMonthView, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-month-view',
            template: "<table class=\"mat-calendar-table\" role=\"presentation\">\n  <thead class=\"mat-calendar-table-header\">\n    <tr>\n      <th scope=\"col\" *ngFor=\"let day of _weekdays\" [attr.aria-label]=\"day.long\">{{day.narrow}}</th>\n    </tr>\n    <tr><th class=\"mat-calendar-table-header-divider\" colspan=\"7\" aria-hidden=\"true\"></th></tr>\n  </thead>\n  <tbody mat-calendar-body\n         [label]=\"_monthLabel\"\n         [rows]=\"_weeks\"\n         [todayValue]=\"_todayDate!\"\n         [selectedValue]=\"_selectedDate!\"\n         [labelMinRequiredCells]=\"3\"\n         [activeCell]=\"_dateAdapter.getDate(activeDate) - 1\"\n         (selectedValueChange)=\"_dateSelected($event)\"\n         (keydown)=\"_handleCalendarBodyKeydown($event)\">\n  </tbody>\n</table>\n",
            exportAs: 'matMonthView',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
            }]
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }];
        }, {
          selectedChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          _userSelection: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          activeDateChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          activeDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          minDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          maxDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateFilter: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          _matCalendarBody: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatCalendarBody]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/multi-year-view.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /** @type {?} */
      var yearsPerPage = 24;
      /** @type {?} */
      var yearsPerRow = 4;
      /**
       * An internal component used to display a year selector in the datepicker.
       * \@docs-private
       * @template D
       */
      var MatMultiYearView = /*#__PURE__*/function () {
        /**
         * @param {?} _changeDetectorRef
         * @param {?} _dateAdapter
         * @param {?=} _dir
         */
        function MatMultiYearView(_changeDetectorRef, _dateAdapter, _dir) {
          _classCallCheck(this, MatMultiYearView);
          this._changeDetectorRef = _changeDetectorRef;
          this._dateAdapter = _dateAdapter;
          this._dir = _dir;
          this._rerenderSubscription = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          /**
           * Emits when a new year is selected.
           */
          this.selectedChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits the selected year. This doesn't imply a change on the selected date
           */
          this.yearSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when any date is activated.
           */
          this.activeDateChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          if (!this._dateAdapter) {
            throw createMissingDateImplError('DateAdapter');
          }
          this._activeDate = this._dateAdapter.today();
        }
        /**
         * The date to display in this multi-year view (everything other than the year is ignored).
         * @return {?}
         */
        _createClass(MatMultiYearView, [{
          key: "activeDate",
          get: function get() {
            return this._activeDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            /** @type {?} */
            var oldActiveDate = this._activeDate;
            /** @type {?} */
            var validDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value)) || this._dateAdapter.today();
            this._activeDate = this._dateAdapter.clampDate(validDate, this.minDate, this.maxDate);
            if (!isSameMultiYearView(this._dateAdapter, oldActiveDate, this._activeDate, this.minDate, this.maxDate)) {
              this._init();
            }
          }
          /**
           * The currently selected date.
           * @return {?}
           */
        }, {
          key: "selected",
          get: function get() {
            return this._selected;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._selected = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
            this._selectedYear = this._selected && this._dateAdapter.getYear(this._selected);
          }
          /**
           * The minimum selectable date.
           * @return {?}
           */
        }, {
          key: "minDate",
          get: function get() {
            return this._minDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._minDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The maximum selectable date.
           * @return {?}
           */
        }, {
          key: "maxDate",
          get: function get() {
            return this._maxDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._maxDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            var _this3 = this;
            this._rerenderSubscription = this._dateAdapter.localeChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["startWith"])(null)).subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this3._init();
            });
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._rerenderSubscription.unsubscribe();
          }
          /**
           * Initializes this multi-year view.
           * @return {?}
           */
        }, {
          key: "_init",
          value: function _init() {
            var _this4 = this;
            this._todayYear = this._dateAdapter.getYear(this._dateAdapter.today());
            // We want a range years such that we maximize the number of
            // enabled dates visible at once. This prevents issues where the minimum year
            // is the last item of a page OR the maximum year is the first item of a page.
            // The offset from the active year to the "slot" for the starting year is the
            // *actual* first rendered year in the multi-year view.
            /** @type {?} */
            var activeYear = this._dateAdapter.getYear(this._activeDate);
            /** @type {?} */
            var minYearOfPage = activeYear - getActiveOffset(this._dateAdapter, this.activeDate, this.minDate, this.maxDate);
            this._years = [];
            for (var i = 0, row = []; i < yearsPerPage; i++) {
              row.push(minYearOfPage + i);
              if (row.length == yearsPerRow) {
                this._years.push(row.map(
                /**
                * @param {?} year
                * @return {?}
                */
                function (year) {
                  return _this4._createCellForYear(year);
                }));
                row = [];
              }
            }
            this._changeDetectorRef.markForCheck();
          }
          /**
           * Handles when a new year is selected.
           * @param {?} year
           * @return {?}
           */
        }, {
          key: "_yearSelected",
          value: function _yearSelected(year) {
            this.yearSelected.emit(this._dateAdapter.createDate(year, 0, 1));
            /** @type {?} */
            var month = this._dateAdapter.getMonth(this.activeDate);
            /** @type {?} */
            var daysInMonth = this._dateAdapter.getNumDaysInMonth(this._dateAdapter.createDate(year, month, 1));
            this.selectedChange.emit(this._dateAdapter.createDate(year, month, Math.min(this._dateAdapter.getDate(this.activeDate), daysInMonth)));
          }
          /**
           * Handles keydown events on the calendar body when calendar is in multi-year view.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleCalendarBodyKeydown",
          value: function _handleCalendarBodyKeydown(event) {
            /** @type {?} */
            var oldActiveDate = this._activeDate;
            /** @type {?} */
            var isRtl = this._isRtl();
            switch (event.keyCode) {
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["LEFT_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, isRtl ? 1 : -1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["RIGHT_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, isRtl ? -1 : 1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["UP_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, -yearsPerRow);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["DOWN_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, yearsPerRow);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["HOME"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, -getActiveOffset(this._dateAdapter, this.activeDate, this.minDate, this.maxDate));
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["END"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, yearsPerPage - getActiveOffset(this._dateAdapter, this.activeDate, this.minDate, this.maxDate) - 1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["PAGE_UP"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, event.altKey ? -yearsPerPage * 10 : -yearsPerPage);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["PAGE_DOWN"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, event.altKey ? yearsPerPage * 10 : yearsPerPage);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["ENTER"]:
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["SPACE"]:
                this._yearSelected(this._dateAdapter.getYear(this._activeDate));
                break;
              default:
                // Don't prevent default or focus active cell on keys that we don't explicitly handle.
                return;
            }
            if (this._dateAdapter.compareDate(oldActiveDate, this.activeDate)) {
              this.activeDateChange.emit(this.activeDate);
            }
            this._focusActiveCell();
            // Prevent unexpected default actions such as form submission.
            event.preventDefault();
          }
          /**
           * @return {?}
           */
        }, {
          key: "_getActiveCell",
          value: function _getActiveCell() {
            return getActiveOffset(this._dateAdapter, this.activeDate, this.minDate, this.maxDate);
          }
          /**
           * Focuses the active cell after the microtask queue is empty.
           * @return {?}
           */
        }, {
          key: "_focusActiveCell",
          value: function _focusActiveCell() {
            this._matCalendarBody._focusActiveCell();
          }
          /**
           * Creates an MatCalendarCell for the given year.
           * @private
           * @param {?} year
           * @return {?}
           */
        }, {
          key: "_createCellForYear",
          value: function _createCellForYear(year) {
            /** @type {?} */
            var yearName = this._dateAdapter.getYearName(this._dateAdapter.createDate(year, 0, 1));
            return new MatCalendarCell(year, yearName, yearName, this._shouldEnableYear(year));
          }
          /**
           * Whether the given year is enabled.
           * @private
           * @param {?} year
           * @return {?}
           */
        }, {
          key: "_shouldEnableYear",
          value: function _shouldEnableYear(year) {
            // disable if the year is greater than maxDate lower than minDate
            if (year === undefined || year === null || this.maxDate && year > this._dateAdapter.getYear(this.maxDate) || this.minDate && year < this._dateAdapter.getYear(this.minDate)) {
              return false;
            }
            // enable if it reaches here and there's no filter defined
            if (!this.dateFilter) {
              return true;
            }
            /** @type {?} */
            var firstOfYear = this._dateAdapter.createDate(year, 0, 1);
            // If any date in the year is enabled count the year as enabled.
            for (var date = firstOfYear; this._dateAdapter.getYear(date) == year; date = this._dateAdapter.addCalendarDays(date, 1)) {
              if (this.dateFilter(date)) {
                return true;
              }
            }
            return false;
          }
          /**
           * @private
           * @param {?} obj The object to check.
           * @return {?} The given object if it is both a date instance and valid, otherwise null.
           */
        }, {
          key: "_getValidDateOrNull",
          value: function _getValidDateOrNull(obj) {
            return this._dateAdapter.isDateInstance(obj) && this._dateAdapter.isValid(obj) ? obj : null;
          }
          /**
           * Determines whether the user has the RTL layout direction.
           * @private
           * @return {?}
           */
        }, {
          key: "_isRtl",
          value: function _isRtl() {
            return this._dir && this._dir.value === 'rtl';
          }
        }]);
        return MatMultiYearView;
      }();
      MatMultiYearView.ɵfac = function MatMultiYearView_Factory(t) {
        return new (t || MatMultiYearView)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"], 8));
      };
      MatMultiYearView.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatMultiYearView,
        selectors: [["mat-multi-year-view"]],
        viewQuery: function MatMultiYearView_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatCalendarBody, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx._matCalendarBody = _t.first);
          }
        },
        inputs: {
          activeDate: "activeDate",
          selected: "selected",
          minDate: "minDate",
          maxDate: "maxDate",
          dateFilter: "dateFilter"
        },
        outputs: {
          selectedChange: "selectedChange",
          yearSelected: "yearSelected",
          activeDateChange: "activeDateChange"
        },
        exportAs: ["matMultiYearView"],
        decls: 5,
        vars: 6,
        consts: [["role", "presentation", 1, "mat-calendar-table"], [1, "mat-calendar-table-header"], ["colspan", "4", 1, "mat-calendar-table-header-divider"], ["mat-calendar-body", "", 3, "rows", "todayValue", "selectedValue", "numCols", "cellAspectRatio", "activeCell", "selectedValueChange", "keydown"]],
        template: function MatMultiYearView_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "table", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "thead", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](2, "tr");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](3, "th", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](4, "tbody", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("selectedValueChange", function MatMultiYearView_Template_tbody_selectedValueChange_4_listener($event) {
              return ctx._yearSelected($event);
            })("keydown", function MatMultiYearView_Template_tbody_keydown_4_listener($event) {
              return ctx._handleCalendarBodyKeydown($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("rows", ctx._years)("todayValue", ctx._todayYear)("selectedValue", ctx._selectedYear)("numCols", 4)("cellAspectRatio", 4 / 7)("activeCell", ctx._getActiveCell());
          }
        },
        directives: [MatCalendarBody],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatMultiYearView.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }];
      };
      MatMultiYearView.propDecorators = {
        activeDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        minDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        maxDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateFilter: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selectedChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        yearSelected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        activeDateChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        _matCalendarBody: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatCalendarBody]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatMultiYearView, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-multi-year-view',
            template: "<table class=\"mat-calendar-table\" role=\"presentation\">\n  <thead class=\"mat-calendar-table-header\">\n    <tr><th class=\"mat-calendar-table-header-divider\" colspan=\"4\"></th></tr>\n  </thead>\n  <tbody mat-calendar-body\n         [rows]=\"_years\"\n         [todayValue]=\"_todayYear\"\n         [selectedValue]=\"_selectedYear!\"\n         [numCols]=\"4\"\n         [cellAspectRatio]=\"4 / 7\"\n         [activeCell]=\"_getActiveCell()\"\n         (selectedValueChange)=\"_yearSelected($event)\"\n         (keydown)=\"_handleCalendarBodyKeydown($event)\">\n  </tbody>\n</table>\n",
            exportAs: 'matMultiYearView',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }];
        }, {
          selectedChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          yearSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          activeDateChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          activeDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          minDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          maxDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateFilter: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          _matCalendarBody: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatCalendarBody]
          }]
        });
      })();
      if (false) {}
      /**
       * @template D
       * @param {?} dateAdapter
       * @param {?} date1
       * @param {?} date2
       * @param {?} minDate
       * @param {?} maxDate
       * @return {?}
       */
      function isSameMultiYearView(dateAdapter, date1, date2, minDate, maxDate) {
        /** @type {?} */
        var year1 = dateAdapter.getYear(date1);
        /** @type {?} */
        var year2 = dateAdapter.getYear(date2);
        /** @type {?} */
        var startingYear = getStartingYear(dateAdapter, minDate, maxDate);
        return Math.floor((year1 - startingYear) / yearsPerPage) === Math.floor((year2 - startingYear) / yearsPerPage);
      }
      /**
       * When the multi-year view is first opened, the active year will be in view.
       * So we compute how many years are between the active year and the *slot* where our
       * "startingYear" will render when paged into view.
       * @template D
       * @param {?} dateAdapter
       * @param {?} activeDate
       * @param {?} minDate
       * @param {?} maxDate
       * @return {?}
       */
      function getActiveOffset(dateAdapter, activeDate, minDate, maxDate) {
        /** @type {?} */
        var activeYear = dateAdapter.getYear(activeDate);
        return euclideanModulo(activeYear - getStartingYear(dateAdapter, minDate, maxDate), yearsPerPage);
      }
      /**
       * We pick a "starting" year such that either the maximum year would be at the end
       * or the minimum year would be at the beginning of a page.
       * @template D
       * @param {?} dateAdapter
       * @param {?} minDate
       * @param {?} maxDate
       * @return {?}
       */
      function getStartingYear(dateAdapter, minDate, maxDate) {
        /** @type {?} */
        var startingYear = 0;
        if (maxDate) {
          /** @type {?} */
          var maxYear = dateAdapter.getYear(maxDate);
          startingYear = maxYear - yearsPerPage + 1;
        } else if (minDate) {
          startingYear = dateAdapter.getYear(minDate);
        }
        return startingYear;
      }
      /**
       * Gets remainder that is non-negative, even if first number is negative
       * @param {?} a
       * @param {?} b
       * @return {?}
       */
      function euclideanModulo(a, b) {
        return (a % b + b) % b;
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/year-view.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * An internal component used to display a single year in the datepicker.
       * \@docs-private
       * @template D
       */
      var MatYearView = /*#__PURE__*/function () {
        /**
         * @param {?} _changeDetectorRef
         * @param {?} _dateFormats
         * @param {?} _dateAdapter
         * @param {?=} _dir
         */
        function MatYearView(_changeDetectorRef, _dateFormats, _dateAdapter, _dir) {
          _classCallCheck(this, MatYearView);
          this._changeDetectorRef = _changeDetectorRef;
          this._dateFormats = _dateFormats;
          this._dateAdapter = _dateAdapter;
          this._dir = _dir;
          this._rerenderSubscription = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          /**
           * Emits when a new month is selected.
           */
          this.selectedChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits the selected month. This doesn't imply a change on the selected date
           */
          this.monthSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when any date is activated.
           */
          this.activeDateChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          if (!this._dateAdapter) {
            throw createMissingDateImplError('DateAdapter');
          }
          if (!this._dateFormats) {
            throw createMissingDateImplError('MAT_DATE_FORMATS');
          }
          this._activeDate = this._dateAdapter.today();
        }
        /**
         * The date to display in this year view (everything other than the year is ignored).
         * @return {?}
         */
        _createClass(MatYearView, [{
          key: "activeDate",
          get: function get() {
            return this._activeDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            /** @type {?} */
            var oldActiveDate = this._activeDate;
            /** @type {?} */
            var validDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value)) || this._dateAdapter.today();
            this._activeDate = this._dateAdapter.clampDate(validDate, this.minDate, this.maxDate);
            if (this._dateAdapter.getYear(oldActiveDate) !== this._dateAdapter.getYear(this._activeDate)) {
              this._init();
            }
          }
          /**
           * The currently selected date.
           * @return {?}
           */
        }, {
          key: "selected",
          get: function get() {
            return this._selected;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._selected = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
            this._selectedMonth = this._getMonthInCurrentYear(this._selected);
          }
          /**
           * The minimum selectable date.
           * @return {?}
           */
        }, {
          key: "minDate",
          get: function get() {
            return this._minDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._minDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The maximum selectable date.
           * @return {?}
           */
        }, {
          key: "maxDate",
          get: function get() {
            return this._maxDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._maxDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            var _this5 = this;
            this._rerenderSubscription = this._dateAdapter.localeChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["startWith"])(null)).subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this5._init();
            });
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._rerenderSubscription.unsubscribe();
          }
          /**
           * Handles when a new month is selected.
           * @param {?} month
           * @return {?}
           */
        }, {
          key: "_monthSelected",
          value: function _monthSelected(month) {
            /** @type {?} */
            var normalizedDate = this._dateAdapter.createDate(this._dateAdapter.getYear(this.activeDate), month, 1);
            this.monthSelected.emit(normalizedDate);
            /** @type {?} */
            var daysInMonth = this._dateAdapter.getNumDaysInMonth(normalizedDate);
            this.selectedChange.emit(this._dateAdapter.createDate(this._dateAdapter.getYear(this.activeDate), month, Math.min(this._dateAdapter.getDate(this.activeDate), daysInMonth)));
          }
          /**
           * Handles keydown events on the calendar body when calendar is in year view.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleCalendarBodyKeydown",
          value: function _handleCalendarBodyKeydown(event) {
            // TODO(mmalerba): We currently allow keyboard navigation to disabled dates, but just prevent
            // disabled ones from being selected. This may not be ideal, we should look into whether
            // navigation should skip over disabled dates, and if so, how to implement that efficiently.
            // TODO(mmalerba): We currently allow keyboard navigation to disabled dates, but just prevent
            // disabled ones from being selected. This may not be ideal, we should look into whether
            // navigation should skip over disabled dates, and if so, how to implement that efficiently.
            /** @type {?} */
            var oldActiveDate = this._activeDate;
            /** @type {?} */
            var isRtl = this._isRtl();
            switch (event.keyCode) {
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["LEFT_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarMonths(this._activeDate, isRtl ? 1 : -1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["RIGHT_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarMonths(this._activeDate, isRtl ? -1 : 1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["UP_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarMonths(this._activeDate, -4);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["DOWN_ARROW"]:
                this.activeDate = this._dateAdapter.addCalendarMonths(this._activeDate, 4);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["HOME"]:
                this.activeDate = this._dateAdapter.addCalendarMonths(this._activeDate, -this._dateAdapter.getMonth(this._activeDate));
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["END"]:
                this.activeDate = this._dateAdapter.addCalendarMonths(this._activeDate, 11 - this._dateAdapter.getMonth(this._activeDate));
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["PAGE_UP"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, event.altKey ? -10 : -1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["PAGE_DOWN"]:
                this.activeDate = this._dateAdapter.addCalendarYears(this._activeDate, event.altKey ? 10 : 1);
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["ENTER"]:
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["SPACE"]:
                this._monthSelected(this._dateAdapter.getMonth(this._activeDate));
                break;
              default:
                // Don't prevent default or focus active cell on keys that we don't explicitly handle.
                return;
            }
            if (this._dateAdapter.compareDate(oldActiveDate, this.activeDate)) {
              this.activeDateChange.emit(this.activeDate);
            }
            this._focusActiveCell();
            // Prevent unexpected default actions such as form submission.
            event.preventDefault();
          }
          /**
           * Initializes this year view.
           * @return {?}
           */
        }, {
          key: "_init",
          value: function _init() {
            var _this6 = this;
            this._selectedMonth = this._getMonthInCurrentYear(this.selected);
            this._todayMonth = this._getMonthInCurrentYear(this._dateAdapter.today());
            this._yearLabel = this._dateAdapter.getYearName(this.activeDate);
            /** @type {?} */
            var monthNames = this._dateAdapter.getMonthNames('short');
            // First row of months only contains 5 elements so we can fit the year label on the same row.
            this._months = [[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 10, 11]].map(
            /**
            * @param {?} row
            * @return {?}
            */
            function (row) {
              return row.map(
              /**
              * @param {?} month
              * @return {?}
              */
              function (month) {
                return _this6._createCellForMonth(month, monthNames[month]);
              });
            });
            this._changeDetectorRef.markForCheck();
          }
          /**
           * Focuses the active cell after the microtask queue is empty.
           * @return {?}
           */
        }, {
          key: "_focusActiveCell",
          value: function _focusActiveCell() {
            this._matCalendarBody._focusActiveCell();
          }
          /**
           * Gets the month in this year that the given Date falls on.
           * Returns null if the given Date is in another year.
           * @private
           * @param {?} date
           * @return {?}
           */
        }, {
          key: "_getMonthInCurrentYear",
          value: function _getMonthInCurrentYear(date) {
            return date && this._dateAdapter.getYear(date) == this._dateAdapter.getYear(this.activeDate) ? this._dateAdapter.getMonth(date) : null;
          }
          /**
           * Creates an MatCalendarCell for the given month.
           * @private
           * @param {?} month
           * @param {?} monthName
           * @return {?}
           */
        }, {
          key: "_createCellForMonth",
          value: function _createCellForMonth(month, monthName) {
            /** @type {?} */
            var ariaLabel = this._dateAdapter.format(this._dateAdapter.createDate(this._dateAdapter.getYear(this.activeDate), month, 1), this._dateFormats.display.monthYearA11yLabel);
            return new MatCalendarCell(month, monthName.toLocaleUpperCase(), ariaLabel, this._shouldEnableMonth(month));
          }
          /**
           * Whether the given month is enabled.
           * @private
           * @param {?} month
           * @return {?}
           */
        }, {
          key: "_shouldEnableMonth",
          value: function _shouldEnableMonth(month) {
            /** @type {?} */
            var activeYear = this._dateAdapter.getYear(this.activeDate);
            if (month === undefined || month === null || this._isYearAndMonthAfterMaxDate(activeYear, month) || this._isYearAndMonthBeforeMinDate(activeYear, month)) {
              return false;
            }
            if (!this.dateFilter) {
              return true;
            }
            /** @type {?} */
            var firstOfMonth = this._dateAdapter.createDate(activeYear, month, 1);
            // If any date in the month is enabled count the month as enabled.
            for (var date = firstOfMonth; this._dateAdapter.getMonth(date) == month; date = this._dateAdapter.addCalendarDays(date, 1)) {
              if (this.dateFilter(date)) {
                return true;
              }
            }
            return false;
          }
          /**
           * Tests whether the combination month/year is after this.maxDate, considering
           * just the month and year of this.maxDate
           * @private
           * @param {?} year
           * @param {?} month
           * @return {?}
           */
        }, {
          key: "_isYearAndMonthAfterMaxDate",
          value: function _isYearAndMonthAfterMaxDate(year, month) {
            if (this.maxDate) {
              /** @type {?} */
              var maxYear = this._dateAdapter.getYear(this.maxDate);
              /** @type {?} */
              var maxMonth = this._dateAdapter.getMonth(this.maxDate);
              return year > maxYear || year === maxYear && month > maxMonth;
            }
            return false;
          }
          /**
           * Tests whether the combination month/year is before this.minDate, considering
           * just the month and year of this.minDate
           * @private
           * @param {?} year
           * @param {?} month
           * @return {?}
           */
        }, {
          key: "_isYearAndMonthBeforeMinDate",
          value: function _isYearAndMonthBeforeMinDate(year, month) {
            if (this.minDate) {
              /** @type {?} */
              var minYear = this._dateAdapter.getYear(this.minDate);
              /** @type {?} */
              var minMonth = this._dateAdapter.getMonth(this.minDate);
              return year < minYear || year === minYear && month < minMonth;
            }
            return false;
          }
          /**
           * @private
           * @param {?} obj The object to check.
           * @return {?} The given object if it is both a date instance and valid, otherwise null.
           */
        }, {
          key: "_getValidDateOrNull",
          value: function _getValidDateOrNull(obj) {
            return this._dateAdapter.isDateInstance(obj) && this._dateAdapter.isValid(obj) ? obj : null;
          }
          /**
           * Determines whether the user has the RTL layout direction.
           * @private
           * @return {?}
           */
        }, {
          key: "_isRtl",
          value: function _isRtl() {
            return this._dir && this._dir.value === 'rtl';
          }
        }]);
        return MatYearView;
      }();
      MatYearView.ɵfac = function MatYearView_Factory(t) {
        return new (t || MatYearView)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"], 8));
      };
      MatYearView.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatYearView,
        selectors: [["mat-year-view"]],
        viewQuery: function MatYearView_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatCalendarBody, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx._matCalendarBody = _t.first);
          }
        },
        inputs: {
          activeDate: "activeDate",
          selected: "selected",
          minDate: "minDate",
          maxDate: "maxDate",
          dateFilter: "dateFilter"
        },
        outputs: {
          selectedChange: "selectedChange",
          monthSelected: "monthSelected",
          activeDateChange: "activeDateChange"
        },
        exportAs: ["matYearView"],
        decls: 5,
        vars: 8,
        consts: [["role", "presentation", 1, "mat-calendar-table"], [1, "mat-calendar-table-header"], ["colspan", "4", 1, "mat-calendar-table-header-divider"], ["mat-calendar-body", "", 3, "label", "rows", "todayValue", "selectedValue", "labelMinRequiredCells", "numCols", "cellAspectRatio", "activeCell", "selectedValueChange", "keydown"]],
        template: function MatYearView_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "table", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "thead", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](2, "tr");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](3, "th", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](4, "tbody", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("selectedValueChange", function MatYearView_Template_tbody_selectedValueChange_4_listener($event) {
              return ctx._monthSelected($event);
            })("keydown", function MatYearView_Template_tbody_keydown_4_listener($event) {
              return ctx._handleCalendarBodyKeydown($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("label", ctx._yearLabel)("rows", ctx._months)("todayValue", ctx._todayMonth)("selectedValue", ctx._selectedMonth)("labelMinRequiredCells", 2)("numCols", 4)("cellAspectRatio", 4 / 7)("activeCell", ctx._dateAdapter.getMonth(ctx.activeDate));
          }
        },
        directives: [MatCalendarBody],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatYearView.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
          }]
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }];
      };
      MatYearView.propDecorators = {
        activeDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        minDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        maxDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateFilter: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selectedChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        monthSelected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        activeDateChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        _matCalendarBody: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatCalendarBody]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatYearView, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-year-view',
            template: "<table class=\"mat-calendar-table\" role=\"presentation\">\n  <thead class=\"mat-calendar-table-header\">\n    <tr><th class=\"mat-calendar-table-header-divider\" colspan=\"4\"></th></tr>\n  </thead>\n  <tbody mat-calendar-body\n         [label]=\"_yearLabel\"\n         [rows]=\"_months\"\n         [todayValue]=\"_todayMonth!\"\n         [selectedValue]=\"_selectedMonth!\"\n         [labelMinRequiredCells]=\"2\"\n         [numCols]=\"4\"\n         [cellAspectRatio]=\"4 / 7\"\n         [activeCell]=\"_dateAdapter.getMonth(activeDate)\"\n         (selectedValueChange)=\"_monthSelected($event)\"\n         (keydown)=\"_handleCalendarBodyKeydown($event)\">\n  </tbody>\n</table>\n",
            exportAs: 'matYearView',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
            }]
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }];
        }, {
          selectedChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          monthSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          activeDateChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          activeDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          minDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          maxDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateFilter: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          _matCalendarBody: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatCalendarBody]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/calendar.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Default header for MatCalendar
       * @template D
       */
      var MatCalendarHeader = /*#__PURE__*/function () {
        /**
         * @param {?} _intl
         * @param {?} calendar
         * @param {?} _dateAdapter
         * @param {?} _dateFormats
         * @param {?} changeDetectorRef
         */
        function MatCalendarHeader(_intl, calendar, _dateAdapter, _dateFormats, changeDetectorRef) {
          _classCallCheck(this, MatCalendarHeader);
          this._intl = _intl;
          this.calendar = calendar;
          this._dateAdapter = _dateAdapter;
          this._dateFormats = _dateFormats;
          this.calendar.stateChanges.subscribe(
          /**
          * @return {?}
          */
          function () {
            return changeDetectorRef.markForCheck();
          });
        }
        /**
         * The label for the current calendar view.
         * @return {?}
         */
        _createClass(MatCalendarHeader, [{
          key: "periodButtonText",
          get: function get() {
            if (this.calendar.currentView == 'month') {
              return this._dateAdapter.format(this.calendar.activeDate, this._dateFormats.display.monthYearLabel).toLocaleUpperCase();
            }
            if (this.calendar.currentView == 'year') {
              return this._dateAdapter.getYearName(this.calendar.activeDate);
            }
            // The offset from the active year to the "slot" for the starting year is the
            // *actual* first rendered year in the multi-year view, and the last year is
            // just yearsPerPage - 1 away.
            /** @type {?} */
            var activeYear = this._dateAdapter.getYear(this.calendar.activeDate);
            /** @type {?} */
            var minYearOfPage = activeYear - getActiveOffset(this._dateAdapter, this.calendar.activeDate, this.calendar.minDate, this.calendar.maxDate);
            /** @type {?} */
            var maxYearOfPage = minYearOfPage + yearsPerPage - 1;
            /** @type {?} */
            var minYearName = this._dateAdapter.getYearName(this._dateAdapter.createDate(minYearOfPage, 0, 1));
            /** @type {?} */
            var maxYearName = this._dateAdapter.getYearName(this._dateAdapter.createDate(maxYearOfPage, 0, 1));
            return this._intl.formatYearRange(minYearName, maxYearName);
          }
          /**
           * @return {?}
           */
        }, {
          key: "periodButtonLabel",
          get: function get() {
            return this.calendar.currentView == 'month' ? this._intl.switchToMultiYearViewLabel : this._intl.switchToMonthViewLabel;
          }
          /**
           * The label for the previous button.
           * @return {?}
           */
        }, {
          key: "prevButtonLabel",
          get: function get() {
            return {
              'month': this._intl.prevMonthLabel,
              'year': this._intl.prevYearLabel,
              'multi-year': this._intl.prevMultiYearLabel
            }[this.calendar.currentView];
          }
          /**
           * The label for the next button.
           * @return {?}
           */
        }, {
          key: "nextButtonLabel",
          get: function get() {
            return {
              'month': this._intl.nextMonthLabel,
              'year': this._intl.nextYearLabel,
              'multi-year': this._intl.nextMultiYearLabel
            }[this.calendar.currentView];
          }
          /**
           * Handles user clicks on the period label.
           * @return {?}
           */
        }, {
          key: "currentPeriodClicked",
          value: function currentPeriodClicked() {
            this.calendar.currentView = this.calendar.currentView == 'month' ? 'multi-year' : 'month';
          }
          /**
           * Handles user clicks on the previous button.
           * @return {?}
           */
        }, {
          key: "previousClicked",
          value: function previousClicked() {
            this.calendar.activeDate = this.calendar.currentView == 'month' ? this._dateAdapter.addCalendarMonths(this.calendar.activeDate, -1) : this._dateAdapter.addCalendarYears(this.calendar.activeDate, this.calendar.currentView == 'year' ? -1 : -yearsPerPage);
          }
          /**
           * Handles user clicks on the next button.
           * @return {?}
           */
        }, {
          key: "nextClicked",
          value: function nextClicked() {
            this.calendar.activeDate = this.calendar.currentView == 'month' ? this._dateAdapter.addCalendarMonths(this.calendar.activeDate, 1) : this._dateAdapter.addCalendarYears(this.calendar.activeDate, this.calendar.currentView == 'year' ? 1 : yearsPerPage);
          }
          /**
           * Whether the previous period button is enabled.
           * @return {?}
           */
        }, {
          key: "previousEnabled",
          value: function previousEnabled() {
            if (!this.calendar.minDate) {
              return true;
            }
            return !this.calendar.minDate || !this._isSameView(this.calendar.activeDate, this.calendar.minDate);
          }
          /**
           * Whether the next period button is enabled.
           * @return {?}
           */
        }, {
          key: "nextEnabled",
          value: function nextEnabled() {
            return !this.calendar.maxDate || !this._isSameView(this.calendar.activeDate, this.calendar.maxDate);
          }
          /**
           * Whether the two dates represent the same view in the current view mode (month or year).
           * @private
           * @param {?} date1
           * @param {?} date2
           * @return {?}
           */
        }, {
          key: "_isSameView",
          value: function _isSameView(date1, date2) {
            if (this.calendar.currentView == 'month') {
              return this._dateAdapter.getYear(date1) == this._dateAdapter.getYear(date2) && this._dateAdapter.getMonth(date1) == this._dateAdapter.getMonth(date2);
            }
            if (this.calendar.currentView == 'year') {
              return this._dateAdapter.getYear(date1) == this._dateAdapter.getYear(date2);
            }
            // Otherwise we are in 'multi-year' view.
            return isSameMultiYearView(this._dateAdapter, date1, date2, this.calendar.minDate, this.calendar.maxDate);
          }
        }]);
        return MatCalendarHeader;
      }();
      MatCalendarHeader.ɵfac = function MatCalendarHeader_Factory(t) {
        return new (t || MatCalendarHeader)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](MatDatepickerIntl), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["forwardRef"])(
        /**
        * @return {?}
        */
        function () {
          return MatCalendar;
        })), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]));
      };
      MatCalendarHeader.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatCalendarHeader,
        selectors: [["mat-calendar-header"]],
        exportAs: ["matCalendarHeader"],
        ngContentSelectors: _c1,
        decls: 9,
        vars: 8,
        consts: [[1, "mat-calendar-header"], [1, "mat-calendar-controls"], ["mat-button", "", "type", "button", "cdkAriaLive", "polite", 1, "mat-calendar-period-button", 3, "click"], [1, "mat-calendar-arrow"], [1, "mat-calendar-spacer"], ["mat-icon-button", "", "type", "button", 1, "mat-calendar-previous-button", 3, "disabled", "click"], ["mat-icon-button", "", "type", "button", 1, "mat-calendar-next-button", 3, "disabled", "click"]],
        template: function MatCalendarHeader_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵprojectionDef"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "div", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](2, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function MatCalendarHeader_Template_button_click_2_listener() {
              return ctx.currentPeriodClicked();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](4, "div", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](5, "div", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵprojection"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "button", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function MatCalendarHeader_Template_button_click_7_listener() {
              return ctx.previousClicked();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](8, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function MatCalendarHeader_Template_button_click_8_listener() {
              return ctx.nextClicked();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-label", ctx.periodButtonLabel);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", ctx.periodButtonText, " ");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵclassProp"]("mat-calendar-invert", ctx.calendar.currentView != "month");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("disabled", !ctx.previousEnabled());
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-label", ctx.prevButtonLabel);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("disabled", !ctx.nextEnabled());
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-label", ctx.nextButtonLabel);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButton"], _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["CdkAriaLive"]],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatCalendarHeader.ctorParameters = function () {
        return [{
          type: MatDatepickerIntl
        }, {
          type: MatCalendar,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["forwardRef"])(
            /**
            * @return {?}
            */
            function () {
              return MatCalendar;
            })]
          }]
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }];
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatCalendarHeader, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-calendar-header',
            template: "<div class=\"mat-calendar-header\">\n  <div class=\"mat-calendar-controls\">\n    <button mat-button type=\"button\" class=\"mat-calendar-period-button\"\n            (click)=\"currentPeriodClicked()\" [attr.aria-label]=\"periodButtonLabel\"\n            cdkAriaLive=\"polite\">\n      {{periodButtonText}}\n      <div class=\"mat-calendar-arrow\"\n           [class.mat-calendar-invert]=\"calendar.currentView != 'month'\"></div>\n    </button>\n\n    <div class=\"mat-calendar-spacer\"></div>\n\n    <ng-content></ng-content>\n\n    <button mat-icon-button type=\"button\" class=\"mat-calendar-previous-button\"\n            [disabled]=\"!previousEnabled()\" (click)=\"previousClicked()\"\n            [attr.aria-label]=\"prevButtonLabel\">\n    </button>\n\n    <button mat-icon-button type=\"button\" class=\"mat-calendar-next-button\"\n            [disabled]=\"!nextEnabled()\" (click)=\"nextClicked()\"\n            [attr.aria-label]=\"nextButtonLabel\">\n    </button>\n  </div>\n</div>\n",
            exportAs: 'matCalendarHeader',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush
          }]
        }], function () {
          return [{
            type: MatDatepickerIntl
          }, {
            type: MatCalendar,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["forwardRef"])(
              /**
              * @return {?}
              */
              function () {
                return MatCalendar;
              })]
            }]
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }];
        }, null);
      })();
      if (false) {}
      /**
       * A calendar that is used as part of the datepicker.
       * \@docs-private
       * @template D
       */
      var MatCalendar = /*#__PURE__*/function () {
        /**
         * @param {?} _intl
         * @param {?} _dateAdapter
         * @param {?} _dateFormats
         * @param {?} _changeDetectorRef
         */
        function MatCalendar(_intl, _dateAdapter, _dateFormats, _changeDetectorRef) {
          var _this7 = this;
          _classCallCheck(this, MatCalendar);
          this._dateAdapter = _dateAdapter;
          this._dateFormats = _dateFormats;
          this._changeDetectorRef = _changeDetectorRef;
          /**
           * Used for scheduling that focus should be moved to the active cell on the next tick.
           * We need to schedule it, rather than do it immediately, because we have to wait
           * for Angular to re-evaluate the view children.
           */
          this._moveFocusOnNextTick = false;
          /**
           * Whether the calendar should be started in month or year view.
           */
          this.startView = 'month';
          /**
           * Emits when the currently selected date changes.
           */
          this.selectedChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits the year chosen in multiyear view.
           * This doesn't imply a change on the selected date.
           */
          this.yearSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits the month chosen in year view.
           * This doesn't imply a change on the selected date.
           */
          this.monthSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when any date is selected.
           */
          this._userSelection = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits whenever there is a state change that the header may need to respond to.
           */
          this.stateChanges = new rxjs__WEBPACK_IMPORTED_MODULE_8__["Subject"]();
          if (!this._dateAdapter) {
            throw createMissingDateImplError('DateAdapter');
          }
          if (!this._dateFormats) {
            throw createMissingDateImplError('MAT_DATE_FORMATS');
          }
          this._intlChanges = _intl.changes.subscribe(
          /**
          * @return {?}
          */
          function () {
            _changeDetectorRef.markForCheck();
            _this7.stateChanges.next();
          });
        }
        /**
         * A date representing the period (month or year) to start the calendar in.
         * @return {?}
         */
        _createClass(MatCalendar, [{
          key: "startAt",
          get: function get() {
            return this._startAt;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._startAt = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The currently selected date.
           * @return {?}
           */
        }, {
          key: "selected",
          get: function get() {
            return this._selected;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._selected = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The minimum selectable date.
           * @return {?}
           */
        }, {
          key: "minDate",
          get: function get() {
            return this._minDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._minDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The maximum selectable date.
           * @return {?}
           */
        }, {
          key: "maxDate",
          get: function get() {
            return this._maxDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._maxDate = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * The current active date. This determines which time period is shown and which date is
           * highlighted when using keyboard navigation.
           * @return {?}
           */
        }, {
          key: "activeDate",
          get: function get() {
            return this._clampedActiveDate;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._clampedActiveDate = this._dateAdapter.clampDate(value, this.minDate, this.maxDate);
            this.stateChanges.next();
            this._changeDetectorRef.markForCheck();
          }
          /**
           * Whether the calendar is in month view.
           * @return {?}
           */
        }, {
          key: "currentView",
          get: function get() {
            return this._currentView;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._currentView = value;
            this._moveFocusOnNextTick = true;
            this._changeDetectorRef.markForCheck();
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            this._calendarHeaderPortal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__["ComponentPortal"](this.headerComponent || MatCalendarHeader);
            this.activeDate = this.startAt || this._dateAdapter.today();
            // Assign to the private property since we don't want to move focus on init.
            this._currentView = this.startView;
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterViewChecked",
          value: function ngAfterViewChecked() {
            if (this._moveFocusOnNextTick) {
              this._moveFocusOnNextTick = false;
              this.focusActiveCell();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._intlChanges.unsubscribe();
            this.stateChanges.complete();
          }
          /**
           * @param {?} changes
           * @return {?}
           */
        }, {
          key: "ngOnChanges",
          value: function ngOnChanges(changes) {
            /** @type {?} */
            var change = changes['minDate'] || changes['maxDate'] || changes['dateFilter'];
            if (change && !change.firstChange) {
              /** @type {?} */
              var view = this._getCurrentViewComponent();
              if (view) {
                // We need to `detectChanges` manually here, because the `minDate`, `maxDate` etc. are
                // passed down to the view via data bindings which won't be up-to-date when we call `_init`.
                this._changeDetectorRef.detectChanges();
                view._init();
              }
            }
            this.stateChanges.next();
          }
          /**
           * @return {?}
           */
        }, {
          key: "focusActiveCell",
          value: function focusActiveCell() {
            this._getCurrentViewComponent()._focusActiveCell();
          }
          /**
           * Updates today's date after an update of the active date
           * @return {?}
           */
        }, {
          key: "updateTodaysDate",
          value: function updateTodaysDate() {
            /** @type {?} */
            var currentView = this.currentView;
            /** @type {?} */
            var view;
            if (currentView === 'month') {
              view = this.monthView;
            } else if (currentView === 'year') {
              view = this.yearView;
            } else {
              view = this.multiYearView;
            }
            view.ngAfterContentInit();
          }
          /**
           * Handles date selection in the month view.
           * @param {?} date
           * @return {?}
           */
        }, {
          key: "_dateSelected",
          value: function _dateSelected(date) {
            if (date && !this._dateAdapter.sameDate(date, this.selected)) {
              this.selectedChange.emit(date);
            }
          }
          /**
           * Handles year selection in the multiyear view.
           * @param {?} normalizedYear
           * @return {?}
           */
        }, {
          key: "_yearSelectedInMultiYearView",
          value: function _yearSelectedInMultiYearView(normalizedYear) {
            this.yearSelected.emit(normalizedYear);
          }
          /**
           * Handles month selection in the year view.
           * @param {?} normalizedMonth
           * @return {?}
           */
        }, {
          key: "_monthSelectedInYearView",
          value: function _monthSelectedInYearView(normalizedMonth) {
            this.monthSelected.emit(normalizedMonth);
          }
          /**
           * @return {?}
           */
        }, {
          key: "_userSelected",
          value: function _userSelected() {
            this._userSelection.emit();
          }
          /**
           * Handles year/month selection in the multi-year/year views.
           * @param {?} date
           * @param {?} view
           * @return {?}
           */
        }, {
          key: "_goToDateInView",
          value: function _goToDateInView(date, view) {
            this.activeDate = date;
            this.currentView = view;
          }
          /**
           * @private
           * @param {?} obj The object to check.
           * @return {?} The given object if it is both a date instance and valid, otherwise null.
           */
        }, {
          key: "_getValidDateOrNull",
          value: function _getValidDateOrNull(obj) {
            return this._dateAdapter.isDateInstance(obj) && this._dateAdapter.isValid(obj) ? obj : null;
          }
          /**
           * Returns the component instance that corresponds to the current calendar view.
           * @private
           * @return {?}
           */
        }, {
          key: "_getCurrentViewComponent",
          value: function _getCurrentViewComponent() {
            return this.monthView || this.yearView || this.multiYearView;
          }
        }]);
        return MatCalendar;
      }();
      MatCalendar.ɵfac = function MatCalendar_Factory(t) {
        return new (t || MatCalendar)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](MatDatepickerIntl), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]));
      };
      MatCalendar.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatCalendar,
        selectors: [["mat-calendar"]],
        viewQuery: function MatCalendar_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatMonthView, true);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatYearView, true);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatMultiYearView, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx.monthView = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx.yearView = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx.multiYearView = _t.first);
          }
        },
        hostAttrs: [1, "mat-calendar"],
        inputs: {
          startView: "startView",
          startAt: "startAt",
          selected: "selected",
          minDate: "minDate",
          maxDate: "maxDate",
          headerComponent: "headerComponent",
          dateFilter: "dateFilter",
          dateClass: "dateClass"
        },
        outputs: {
          selectedChange: "selectedChange",
          yearSelected: "yearSelected",
          monthSelected: "monthSelected",
          _userSelection: "_userSelection"
        },
        exportAs: ["matCalendar"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵNgOnChangesFeature"]],
        decls: 5,
        vars: 5,
        consts: [[3, "cdkPortalOutlet"], ["cdkMonitorSubtreeFocus", "", "tabindex", "-1", 1, "mat-calendar-content", 3, "ngSwitch"], [3, "activeDate", "selected", "dateFilter", "maxDate", "minDate", "dateClass", "activeDateChange", "selectedChange", "_userSelection", 4, "ngSwitchCase"], [3, "activeDate", "selected", "dateFilter", "maxDate", "minDate", "activeDateChange", "monthSelected", "selectedChange", 4, "ngSwitchCase"], [3, "activeDate", "selected", "dateFilter", "maxDate", "minDate", "activeDateChange", "yearSelected", "selectedChange", 4, "ngSwitchCase"], [3, "activeDate", "selected", "dateFilter", "maxDate", "minDate", "dateClass", "activeDateChange", "selectedChange", "_userSelection"], [3, "activeDate", "selected", "dateFilter", "maxDate", "minDate", "activeDateChange", "monthSelected", "selectedChange"], [3, "activeDate", "selected", "dateFilter", "maxDate", "minDate", "activeDateChange", "yearSelected", "selectedChange"]],
        template: function MatCalendar_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, MatCalendar_ng_template_0_Template, 0, 0, "ng-template", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "div", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, MatCalendar_mat_month_view_2_Template, 1, 6, "mat-month-view", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, MatCalendar_mat_year_view_3_Template, 1, 5, "mat-year-view", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](4, MatCalendar_mat_multi_year_view_4_Template, 1, 5, "mat-multi-year-view", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("cdkPortalOutlet", ctx._calendarHeaderPortal);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngSwitch", ctx.currentView);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngSwitchCase", "month");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngSwitchCase", "year");
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngSwitchCase", "multi-year");
          }
        },
        directives: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__["CdkPortalOutlet"], _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["CdkMonitorFocus"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgSwitch"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgSwitchCase"], MatMonthView, MatYearView, MatMultiYearView],
        styles: [".mat-calendar{display:block}.mat-calendar-header{padding:8px 8px 0 8px}.mat-calendar-content{padding:0 8px 8px 8px;outline:none}.mat-calendar-controls{display:flex;margin:5% calc(33% / 7 - 16px)}.mat-calendar-spacer{flex:1 1 auto}.mat-calendar-period-button{min-width:0}.mat-calendar-arrow{display:inline-block;width:0;height:0;border-left:5px solid transparent;border-right:5px solid transparent;border-top-width:5px;border-top-style:solid;margin:0 0 0 5px;vertical-align:middle}.mat-calendar-arrow.mat-calendar-invert{transform:rotate(180deg)}[dir=rtl] .mat-calendar-arrow{margin:0 5px 0 0}.mat-calendar-previous-button,.mat-calendar-next-button{position:relative}.mat-calendar-previous-button::after,.mat-calendar-next-button::after{top:0;left:0;right:0;bottom:0;position:absolute;content:\"\";margin:15.5px;border:0 solid currentColor;border-top-width:2px}[dir=rtl] .mat-calendar-previous-button,[dir=rtl] .mat-calendar-next-button{transform:rotate(180deg)}.mat-calendar-previous-button::after{border-left-width:2px;transform:translateX(2px) rotate(-45deg)}.mat-calendar-next-button::after{border-right-width:2px;transform:translateX(-2px) rotate(45deg)}.mat-calendar-table{border-spacing:0;border-collapse:collapse;width:100%}.mat-calendar-table-header th{text-align:center;padding:0 0 8px 0}.mat-calendar-table-header-divider{position:relative;height:1px}.mat-calendar-table-header-divider::after{content:\"\";position:absolute;top:0;left:-8px;right:-8px;height:1px}\n"],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatCalendar.ctorParameters = function () {
        return [{
          type: MatDatepickerIntl
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }];
      };
      MatCalendar.propDecorators = {
        headerComponent: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        startAt: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        startView: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        minDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        maxDate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateFilter: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        selectedChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        yearSelected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        monthSelected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        _userSelection: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        monthView: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatMonthView]
        }],
        yearView: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatYearView]
        }],
        multiYearView: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatMultiYearView]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatCalendar, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-calendar',
            template: "\n<ng-template [cdkPortalOutlet]=\"_calendarHeaderPortal\"></ng-template>\n\n<div class=\"mat-calendar-content\" [ngSwitch]=\"currentView\" cdkMonitorSubtreeFocus tabindex=\"-1\">\n  <mat-month-view\n      *ngSwitchCase=\"'month'\"\n      [(activeDate)]=\"activeDate\"\n      [selected]=\"selected\"\n      [dateFilter]=\"dateFilter\"\n      [maxDate]=\"maxDate\"\n      [minDate]=\"minDate\"\n      [dateClass]=\"dateClass\"\n      (selectedChange)=\"_dateSelected($event)\"\n      (_userSelection)=\"_userSelected()\">\n  </mat-month-view>\n\n  <mat-year-view\n      *ngSwitchCase=\"'year'\"\n      [(activeDate)]=\"activeDate\"\n      [selected]=\"selected\"\n      [dateFilter]=\"dateFilter\"\n      [maxDate]=\"maxDate\"\n      [minDate]=\"minDate\"\n      (monthSelected)=\"_monthSelectedInYearView($event)\"\n      (selectedChange)=\"_goToDateInView($event, 'month')\">\n  </mat-year-view>\n\n  <mat-multi-year-view\n      *ngSwitchCase=\"'multi-year'\"\n      [(activeDate)]=\"activeDate\"\n      [selected]=\"selected\"\n      [dateFilter]=\"dateFilter\"\n      [maxDate]=\"maxDate\"\n      [minDate]=\"minDate\"\n      (yearSelected)=\"_yearSelectedInMultiYearView($event)\"\n      (selectedChange)=\"_goToDateInView($event, 'year')\">\n  </mat-multi-year-view>\n</div>\n",
            host: {
              'class': 'mat-calendar'
            },
            exportAs: 'matCalendar',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush,
            styles: [".mat-calendar{display:block}.mat-calendar-header{padding:8px 8px 0 8px}.mat-calendar-content{padding:0 8px 8px 8px;outline:none}.mat-calendar-controls{display:flex;margin:5% calc(33% / 7 - 16px)}.mat-calendar-spacer{flex:1 1 auto}.mat-calendar-period-button{min-width:0}.mat-calendar-arrow{display:inline-block;width:0;height:0;border-left:5px solid transparent;border-right:5px solid transparent;border-top-width:5px;border-top-style:solid;margin:0 0 0 5px;vertical-align:middle}.mat-calendar-arrow.mat-calendar-invert{transform:rotate(180deg)}[dir=rtl] .mat-calendar-arrow{margin:0 5px 0 0}.mat-calendar-previous-button,.mat-calendar-next-button{position:relative}.mat-calendar-previous-button::after,.mat-calendar-next-button::after{top:0;left:0;right:0;bottom:0;position:absolute;content:\"\";margin:15.5px;border:0 solid currentColor;border-top-width:2px}[dir=rtl] .mat-calendar-previous-button,[dir=rtl] .mat-calendar-next-button{transform:rotate(180deg)}.mat-calendar-previous-button::after{border-left-width:2px;transform:translateX(2px) rotate(-45deg)}.mat-calendar-next-button::after{border-right-width:2px;transform:translateX(-2px) rotate(45deg)}.mat-calendar-table{border-spacing:0;border-collapse:collapse;width:100%}.mat-calendar-table-header th{text-align:center;padding:0 0 8px 0}.mat-calendar-table-header-divider{position:relative;height:1px}.mat-calendar-table-header-divider::after{content:\"\";position:absolute;top:0;left:-8px;right:-8px;height:1px}\n"]
          }]
        }], function () {
          return [{
            type: MatDatepickerIntl
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }];
        }, {
          startView: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selectedChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          yearSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          monthSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          _userSelection: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          startAt: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          selected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          minDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          maxDate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          headerComponent: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateFilter: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          monthView: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatMonthView]
          }],
          yearView: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatYearView]
          }],
          multiYearView: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatMultiYearView]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker-animations.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Animations used by the Material datepicker.
       * \@docs-private
       * @type {?}
       */
      var matDatepickerAnimations = {
        /**
         * Transforms the height of the datepicker's calendar.
         */
        transformPanel: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["trigger"])('transformPanel', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["state"])('void', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["style"])({
          opacity: 0,
          transform: 'scale(1, 0.8)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["transition"])('void => enter', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["animate"])('120ms cubic-bezier(0, 0, 0.2, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["style"])({
          opacity: 1,
          transform: 'scale(1, 1)'
        }))), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["transition"])('* => void', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["animate"])('100ms linear', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["style"])({
          opacity: 0
        })))]),
        /**
         * Fades in the content of the calendar.
         */
        fadeInCalendar: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["trigger"])('fadeInCalendar', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["state"])('void', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["style"])({
          opacity: 0
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["state"])('enter', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["style"])({
          opacity: 1
        })),
        // TODO(crisbeto): this animation should be removed since it isn't quite on spec, but we
        // need to keep it until #12440 gets in, otherwise the exit animation will look glitchy.
        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["transition"])('void => *', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_13__["animate"])('120ms 100ms cubic-bezier(0.55, 0, 0.55, 0.2)'))])
      };

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Used to generate a unique ID for each datepicker instance.
       * @type {?}
       */
      var datepickerUid = 0;
      /**
       * Injection token that determines the scroll handling while the calendar is open.
       * @type {?}
       */
      var MAT_DATEPICKER_SCROLL_STRATEGY = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["InjectionToken"]('mat-datepicker-scroll-strategy');
      /**
       * \@docs-private
       * @param {?} overlay
       * @return {?}
       */
      function MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY(overlay) {
        return (
          /**
          * @return {?}
          */
          function () {
            return overlay.scrollStrategies.reposition();
          }
        );
      }
      /**
       * \@docs-private
       * @type {?}
       */
      var MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY_PROVIDER = {
        provide: MAT_DATEPICKER_SCROLL_STRATEGY,
        deps: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["Overlay"]],
        useFactory: MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY
      };
      // Boilerplate for applying mixins to MatDatepickerContent.
      /**
       * \@docs-private
       */
      var MatDatepickerContentBase = /*#__PURE__*/_createClass(
      /**
       * @param {?} _elementRef
       */
      function MatDatepickerContentBase(_elementRef) {
        _classCallCheck(this, MatDatepickerContentBase);
        this._elementRef = _elementRef;
      });
      if (false) {}
      /** @type {?} */
      var _MatDatepickerContentMixinBase = Object(_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["mixinColor"])(MatDatepickerContentBase);
      /**
       * Component used as the content for the datepicker dialog and popup. We use this instead of using
       * MatCalendar directly as the content so we can control the initial focus. This also gives us a
       * place to put additional features of the popup that are not part of the calendar itself in the
       * future. (e.g. confirmation buttons).
       * \@docs-private
       * @template D
       */
      var MatDatepickerContent = /*#__PURE__*/function (_MatDatepickerContent) {
        _inherits(MatDatepickerContent, _MatDatepickerContent);
        var _super = _createSuper(MatDatepickerContent);
        /**
         * @param {?} elementRef
         * @param {?=} _changeDetectorRef
         */
        function MatDatepickerContent(elementRef, _changeDetectorRef) {
          var _this8;
          _classCallCheck(this, MatDatepickerContent);
          _this8 = _super.call(this, elementRef);
          _this8._changeDetectorRef = _changeDetectorRef;
          /**
           * Current state of the animation.
           */
          _this8._animationState = 'enter';
          /**
           * Emits when an animation has finished.
           */
          _this8._animationDone = new rxjs__WEBPACK_IMPORTED_MODULE_8__["Subject"]();
          return _this8;
        }
        /**
         * @return {?}
         */
        _createClass(MatDatepickerContent, [{
          key: "ngAfterViewInit",
          value: function ngAfterViewInit() {
            this._calendar.focusActiveCell();
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._animationDone.complete();
          }
          /**
           * @return {?}
           */
        }, {
          key: "_startExitAnimation",
          value: function _startExitAnimation() {
            this._animationState = 'void';
            // @breaking-change 11.0.0 Remove null check for `_changeDetectorRef`.
            if (this._changeDetectorRef) {
              this._changeDetectorRef.markForCheck();
            }
          }
        }]);
        return MatDatepickerContent;
      }(_MatDatepickerContentMixinBase);
      MatDatepickerContent.ɵfac = function MatDatepickerContent_Factory(t) {
        return new (t || MatDatepickerContent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]));
      };
      MatDatepickerContent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatDatepickerContent,
        selectors: [["mat-datepicker-content"]],
        viewQuery: function MatDatepickerContent_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](MatCalendar, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx._calendar = _t.first);
          }
        },
        hostAttrs: [1, "mat-datepicker-content"],
        hostVars: 3,
        hostBindings: function MatDatepickerContent_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵcomponentHostSyntheticListener"]("@transformPanel.done", function MatDatepickerContent_animation_transformPanel_done_HostBindingHandler() {
              return ctx._animationDone.next();
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵupdateSyntheticHostBinding"]("@transformPanel", ctx._animationState);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵclassProp"]("mat-datepicker-content-touch", ctx.datepicker.touchUi);
          }
        },
        inputs: {
          color: "color"
        },
        exportAs: ["matDatepickerContent"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵInheritDefinitionFeature"]],
        decls: 1,
        vars: 11,
        consts: [["cdkTrapFocus", "", 3, "id", "ngClass", "startAt", "startView", "minDate", "maxDate", "dateFilter", "headerComponent", "selected", "dateClass", "selectedChange", "yearSelected", "monthSelected", "_userSelection"]],
        template: function MatDatepickerContent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-calendar", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("selectedChange", function MatDatepickerContent_Template_mat_calendar_selectedChange_0_listener($event) {
              return ctx.datepicker.select($event);
            })("yearSelected", function MatDatepickerContent_Template_mat_calendar_yearSelected_0_listener($event) {
              return ctx.datepicker._selectYear($event);
            })("monthSelected", function MatDatepickerContent_Template_mat_calendar_monthSelected_0_listener($event) {
              return ctx.datepicker._selectMonth($event);
            })("_userSelection", function MatDatepickerContent_Template_mat_calendar__userSelection_0_listener() {
              return ctx.datepicker.close();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("id", ctx.datepicker.id)("ngClass", ctx.datepicker.panelClass)("startAt", ctx.datepicker.startAt)("startView", ctx.datepicker.startView)("minDate", ctx.datepicker._minDate)("maxDate", ctx.datepicker._maxDate)("dateFilter", ctx.datepicker._dateFilter)("headerComponent", ctx.datepicker.calendarHeaderComponent)("selected", ctx.datepicker._selected)("dateClass", ctx.datepicker.dateClass)("@fadeInCalendar", "enter");
          }
        },
        directives: [MatCalendar, _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["CdkTrapFocus"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgClass"]],
        styles: [".mat-datepicker-content{display:block;border-radius:4px}.mat-datepicker-content .mat-calendar{width:296px;height:354px}.mat-datepicker-content-touch{display:block;max-height:80vh;overflow:auto;margin:-24px}.mat-datepicker-content-touch .mat-calendar{min-width:250px;min-height:312px;max-width:750px;max-height:788px}@media all and (orientation: landscape){.mat-datepicker-content-touch .mat-calendar{width:64vh;height:80vh}}@media all and (orientation: portrait){.mat-datepicker-content-touch .mat-calendar{width:80vw;height:100vw}}\n"],
        encapsulation: 2,
        data: {
          animation: [matDatepickerAnimations.transformPanel, matDatepickerAnimations.fadeInCalendar]
        },
        changeDetection: 0
      });
      /** @nocollapse */
      MatDatepickerContent.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }];
      };
      MatDatepickerContent.propDecorators = {
        _calendar: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: [MatCalendar]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepickerContent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-datepicker-content',
            template: "<mat-calendar cdkTrapFocus\n    [id]=\"datepicker.id\"\n    [ngClass]=\"datepicker.panelClass\"\n    [startAt]=\"datepicker.startAt\"\n    [startView]=\"datepicker.startView\"\n    [minDate]=\"datepicker._minDate\"\n    [maxDate]=\"datepicker._maxDate\"\n    [dateFilter]=\"datepicker._dateFilter\"\n    [headerComponent]=\"datepicker.calendarHeaderComponent\"\n    [selected]=\"datepicker._selected\"\n    [dateClass]=\"datepicker.dateClass\"\n    [@fadeInCalendar]=\"'enter'\"\n    (selectedChange)=\"datepicker.select($event)\"\n    (yearSelected)=\"datepicker._selectYear($event)\"\n    (monthSelected)=\"datepicker._selectMonth($event)\"\n    (_userSelection)=\"datepicker.close()\">\n</mat-calendar>\n",
            host: {
              'class': 'mat-datepicker-content',
              '[@transformPanel]': '_animationState',
              '(@transformPanel.done)': '_animationDone.next()',
              '[class.mat-datepicker-content-touch]': 'datepicker.touchUi'
            },
            animations: [matDatepickerAnimations.transformPanel, matDatepickerAnimations.fadeInCalendar],
            exportAs: 'matDatepickerContent',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush,
            inputs: ['color'],
            styles: [".mat-datepicker-content{display:block;border-radius:4px}.mat-datepicker-content .mat-calendar{width:296px;height:354px}.mat-datepicker-content-touch{display:block;max-height:80vh;overflow:auto;margin:-24px}.mat-datepicker-content-touch .mat-calendar{min-width:250px;min-height:312px;max-width:750px;max-height:788px}@media all and (orientation: landscape){.mat-datepicker-content-touch .mat-calendar{width:64vh;height:80vh}}@media all and (orientation: portrait){.mat-datepicker-content-touch .mat-calendar{width:80vw;height:100vw}}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }];
        }, {
          _calendar: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: [MatCalendar]
          }]
        });
      })();
      if (false) {}
      // TODO(mmalerba): We use a component instead of a directive here so the user can use implicit
      // template reference variables (e.g. #d vs #d="matDatepicker"). We can change this to a directive
      // if angular adds support for `exportAs: '$implicit'` on directives.
      /**
       * Component responsible for managing the datepicker popup/dialog.
       * @template D
       */
      var MatDatepicker = /*#__PURE__*/function () {
        /**
         * @param {?} _dialog
         * @param {?} _overlay
         * @param {?} _ngZone
         * @param {?} _viewContainerRef
         * @param {?} scrollStrategy
         * @param {?} _dateAdapter
         * @param {?} _dir
         * @param {?} _document
         */
        function MatDatepicker(_dialog, _overlay, _ngZone, _viewContainerRef, scrollStrategy, _dateAdapter, _dir, _document) {
          _classCallCheck(this, MatDatepicker);
          this._dialog = _dialog;
          this._overlay = _overlay;
          this._ngZone = _ngZone;
          this._viewContainerRef = _viewContainerRef;
          this._dateAdapter = _dateAdapter;
          this._dir = _dir;
          this._document = _document;
          /**
           * The view that the calendar should start in.
           */
          this.startView = 'month';
          this._touchUi = false;
          /**
           * Emits selected year in multiyear view.
           * This doesn't imply a change on the selected date.
           */
          this.yearSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits selected month in year view.
           * This doesn't imply a change on the selected date.
           */
          this.monthSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when the datepicker has been opened.
           */
          this.openedStream = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when the datepicker has been closed.
           */
          this.closedStream = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          this._opened = false;
          /**
           * The id for the datepicker calendar.
           */
          this.id = "mat-datepicker-".concat(datepickerUid++);
          this._validSelected = null;
          /**
           * The element that was focused before the datepicker was opened.
           */
          this._focusedElementBeforeOpen = null;
          /**
           * Subscription to value changes in the associated input element.
           */
          this._inputSubscription = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          /**
           * Emits when the datepicker is disabled.
           */
          this._disabledChange = new rxjs__WEBPACK_IMPORTED_MODULE_8__["Subject"]();
          /**
           * Emits new selected date when selected date changes.
           */
          this._selectedChanged = new rxjs__WEBPACK_IMPORTED_MODULE_8__["Subject"]();
          if (!this._dateAdapter) {
            throw createMissingDateImplError('DateAdapter');
          }
          this._scrollStrategy = scrollStrategy;
        }
        /**
         * The date to open the calendar to initially.
         * @return {?}
         */
        _createClass(MatDatepicker, [{
          key: "startAt",
          get: function get() {
            // If an explicit startAt is set we start there, otherwise we start at whatever the currently
            // selected value is.
            return this._startAt || (this._datepickerInput ? this._datepickerInput.value : null);
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._startAt = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
          }
          /**
           * Color palette to use on the datepicker's calendar.
           * @return {?}
           */
        }, {
          key: "color",
          get: function get() {
            return this._color || (this._datepickerInput ? this._datepickerInput._getThemePalette() : undefined);
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._color = value;
          }
          /**
           * Whether the calendar UI is in touch mode. In touch mode the calendar opens in a dialog rather
           * than a popup and elements have more padding to allow for bigger touch targets.
           * @return {?}
           */
        }, {
          key: "touchUi",
          get: function get() {
            return this._touchUi;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._touchUi = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_12__["coerceBooleanProperty"])(value);
          }
          /**
           * Whether the datepicker pop-up should be disabled.
           * @return {?}
           */
        }, {
          key: "disabled",
          get: function get() {
            return this._disabled === undefined && this._datepickerInput ? this._datepickerInput.disabled : !!this._disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            /** @type {?} */
            var newValue = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_12__["coerceBooleanProperty"])(value);
            if (newValue !== this._disabled) {
              this._disabled = newValue;
              this._disabledChange.next(newValue);
            }
          }
          /**
           * Whether the calendar is open.
           * @return {?}
           */
        }, {
          key: "opened",
          get: function get() {
            return this._opened;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            value ? this.open() : this.close();
          }
          /**
           * The currently selected date.
           * @return {?}
           */
        }, {
          key: "_selected",
          get: function get() {
            return this._validSelected;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._validSelected = value;
          }
          /**
           * The minimum selectable date.
           * @return {?}
           */
        }, {
          key: "_minDate",
          get: function get() {
            return this._datepickerInput && this._datepickerInput.min;
          }
          /**
           * The maximum selectable date.
           * @return {?}
           */
        }, {
          key: "_maxDate",
          get: function get() {
            return this._datepickerInput && this._datepickerInput.max;
          }
          /**
           * @return {?}
           */
        }, {
          key: "_dateFilter",
          get: function get() {
            return this._datepickerInput && this._datepickerInput._dateFilter;
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._destroyPopup();
            this.close();
            this._inputSubscription.unsubscribe();
            this._disabledChange.complete();
          }
          /**
           * Selects the given date
           * @param {?} date
           * @return {?}
           */
        }, {
          key: "select",
          value: function select(date) {
            /** @type {?} */
            var oldValue = this._selected;
            this._selected = date;
            if (!this._dateAdapter.sameDate(oldValue, this._selected)) {
              this._selectedChanged.next(date);
            }
          }
          /**
           * Emits the selected year in multiyear view
           * @param {?} normalizedYear
           * @return {?}
           */
        }, {
          key: "_selectYear",
          value: function _selectYear(normalizedYear) {
            this.yearSelected.emit(normalizedYear);
          }
          /**
           * Emits selected month in year view
           * @param {?} normalizedMonth
           * @return {?}
           */
        }, {
          key: "_selectMonth",
          value: function _selectMonth(normalizedMonth) {
            this.monthSelected.emit(normalizedMonth);
          }
          /**
           * Register an input with this datepicker.
           * @param {?} input The datepicker input to register with this datepicker.
           * @return {?}
           */
        }, {
          key: "_registerInput",
          value: function _registerInput(input) {
            var _this9 = this;
            if (this._datepickerInput) {
              throw Error('A MatDatepicker can only be associated with a single input.');
            }
            this._datepickerInput = input;
            this._inputSubscription = this._datepickerInput._valueChange.subscribe(
            /**
            * @param {?} value
            * @return {?}
            */
            function (value) {
              return _this9._selected = value;
            });
          }
          /**
           * Open the calendar.
           * @return {?}
           */
        }, {
          key: "open",
          value: function open() {
            if (this._opened || this.disabled) {
              return;
            }
            if (!this._datepickerInput) {
              throw Error('Attempted to open an MatDatepicker with no associated input.');
            }
            if (this._document) {
              this._focusedElementBeforeOpen = this._document.activeElement;
            }
            this.touchUi ? this._openAsDialog() : this._openAsPopup();
            this._opened = true;
            this.openedStream.emit();
          }
          /**
           * Close the calendar.
           * @return {?}
           */
        }, {
          key: "close",
          value: function close() {
            var _this10 = this;
            if (!this._opened) {
              return;
            }
            if (this._popupComponentRef && this._popupRef) {
              /** @type {?} */
              var instance = this._popupComponentRef.instance;
              instance._startExitAnimation();
              instance._animationDone.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
              /**
              * @return {?}
              */
              function () {
                return _this10._destroyPopup();
              });
            }
            if (this._dialogRef) {
              this._dialogRef.close();
              this._dialogRef = null;
            }
            /** @type {?} */
            var completeClose =
            /**
            * @return {?}
            */
            function completeClose() {
              // The `_opened` could've been reset already if
              // we got two events in quick succession.
              if (_this10._opened) {
                _this10._opened = false;
                _this10.closedStream.emit();
                _this10._focusedElementBeforeOpen = null;
              }
            };
            if (this._focusedElementBeforeOpen && typeof this._focusedElementBeforeOpen.focus === 'function') {
              // Because IE moves focus asynchronously, we can't count on it being restored before we've
              // marked the datepicker as closed. If the event fires out of sequence and the element that
              // we're refocusing opens the datepicker on focus, the user could be stuck with not being
              // able to close the calendar at all. We work around it by making the logic, that marks
              // the datepicker as closed, async as well.
              this._focusedElementBeforeOpen.focus();
              setTimeout(completeClose);
            } else {
              completeClose();
            }
          }
          /**
           * Open the calendar as a dialog.
           * @private
           * @return {?}
           */
        }, {
          key: "_openAsDialog",
          value: function _openAsDialog() {
            var _this11 = this;
            // Usually this would be handled by `open` which ensures that we can only have one overlay
            // open at a time, however since we reset the variables in async handlers some overlays
            // may slip through if the user opens and closes multiple times in quick succession (e.g.
            // by holding down the enter key).
            if (this._dialogRef) {
              this._dialogRef.close();
            }
            this._dialogRef = this._dialog.open(MatDatepickerContent, {
              direction: this._dir ? this._dir.value : 'ltr',
              viewContainerRef: this._viewContainerRef,
              panelClass: 'mat-datepicker-dialog',
              // These values are all the same as the defaults, but we set them explicitly so that the
              // datepicker dialog behaves consistently even if the user changed the defaults.
              hasBackdrop: true,
              disableClose: false,
              width: '',
              height: '',
              minWidth: '',
              minHeight: '',
              maxWidth: '80vw',
              maxHeight: '',
              position: {},
              autoFocus: true,
              restoreFocus: true
            });
            this._dialogRef.afterClosed().subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this11.close();
            });
            this._dialogRef.componentInstance.datepicker = this;
            this._dialogRef.componentInstance.color = this.color;
          }
          /**
           * Open the calendar as a popup.
           * @private
           * @return {?}
           */
        }, {
          key: "_openAsPopup",
          value: function _openAsPopup() {
            var _this12 = this;
            /** @type {?} */
            var portal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__["ComponentPortal"](MatDatepickerContent, this._viewContainerRef);
            this._destroyPopup();
            this._createPopup();
            /** @type {?} */
            var ref = this._popupComponentRef = /** @type {?} */this._popupRef.attach(portal);
            ref.instance.datepicker = this;
            ref.instance.color = this.color;
            // Update the position once the calendar has rendered.
            this._ngZone.onStable.asObservable().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
            /**
            * @return {?}
            */
            function () {
              /** @type {?} */_this12._popupRef.updatePosition();
            });
          }
          /**
           * Create the popup.
           * @private
           * @return {?}
           */
        }, {
          key: "_createPopup",
          value: function _createPopup() {
            var _this13 = this;
            /** @type {?} */
            var overlayConfig = new _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["OverlayConfig"]({
              positionStrategy: this._createPopupPositionStrategy(),
              hasBackdrop: true,
              backdropClass: 'mat-overlay-transparent-backdrop',
              direction: this._dir,
              scrollStrategy: this._scrollStrategy(),
              panelClass: 'mat-datepicker-popup'
            });
            this._popupRef = this._overlay.create(overlayConfig);
            this._popupRef.overlayElement.setAttribute('role', 'dialog');
            Object(rxjs__WEBPACK_IMPORTED_MODULE_8__["merge"])(this._popupRef.backdropClick(), this._popupRef.detachments(), this._popupRef.keydownEvents().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["filter"])(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              // Closing on alt + up is only valid when there's an input associated with the datepicker.
              return event.keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["ESCAPE"] || _this13._datepickerInput && event.altKey && event.keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["UP_ARROW"];
            }))).subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              if (event) {
                event.preventDefault();
              }
              _this13.close();
            });
          }
          /**
           * Destroys the current popup overlay.
           * @private
           * @return {?}
           */
        }, {
          key: "_destroyPopup",
          value: function _destroyPopup() {
            if (this._popupRef) {
              this._popupRef.dispose();
              this._popupRef = this._popupComponentRef = null;
            }
          }
          /**
           * Create the popup PositionStrategy.
           * @private
           * @return {?}
           */
        }, {
          key: "_createPopupPositionStrategy",
          value: function _createPopupPositionStrategy() {
            return this._overlay.position().flexibleConnectedTo(this._datepickerInput.getConnectedOverlayOrigin()).withTransformOriginOn('.mat-datepicker-content').withFlexibleDimensions(false).withViewportMargin(8).withLockedPosition().withPositions([{
              originX: 'start',
              originY: 'bottom',
              overlayX: 'start',
              overlayY: 'top'
            }, {
              originX: 'start',
              originY: 'top',
              overlayX: 'start',
              overlayY: 'bottom'
            }, {
              originX: 'end',
              originY: 'bottom',
              overlayX: 'end',
              overlayY: 'top'
            }, {
              originX: 'end',
              originY: 'top',
              overlayX: 'end',
              overlayY: 'bottom'
            }]);
          }
          /**
           * @private
           * @param {?} obj The object to check.
           * @return {?} The given object if it is both a date instance and valid, otherwise null.
           */
        }, {
          key: "_getValidDateOrNull",
          value: function _getValidDateOrNull(obj) {
            return this._dateAdapter.isDateInstance(obj) && this._dateAdapter.isValid(obj) ? obj : null;
          }
        }]);
        return MatDatepicker;
      }();
      MatDatepicker.ɵfac = function MatDatepicker_Factory(t) {
        return new (t || MatDatepicker)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__["MatDialog"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["Overlay"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewContainerRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](MAT_DATEPICKER_SCROLL_STRATEGY), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_3__["DOCUMENT"], 8));
      };
      MatDatepicker.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatDatepicker,
        selectors: [["mat-datepicker"]],
        inputs: {
          startView: "startView",
          startAt: "startAt",
          color: "color",
          touchUi: "touchUi",
          disabled: "disabled",
          opened: "opened",
          calendarHeaderComponent: "calendarHeaderComponent",
          panelClass: "panelClass",
          dateClass: "dateClass"
        },
        outputs: {
          yearSelected: "yearSelected",
          monthSelected: "monthSelected",
          openedStream: "opened",
          closedStream: "closed"
        },
        exportAs: ["matDatepicker"],
        decls: 0,
        vars: 0,
        template: function MatDatepicker_Template(rf, ctx) {},
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatDatepicker.ctorParameters = function () {
        return [{
          type: _angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__["MatDialog"]
        }, {
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["Overlay"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["NgZone"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewContainerRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [MAT_DATEPICKER_SCROLL_STRATEGY]
          }]
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["DOCUMENT"]]
          }]
        }];
      };
      MatDatepicker.propDecorators = {
        calendarHeaderComponent: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        startAt: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        startView: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        color: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        touchUi: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        yearSelected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        monthSelected: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        panelClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        openedStream: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"],
          args: ['opened']
        }],
        closedStream: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"],
          args: ['closed']
        }],
        opened: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepicker, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-datepicker',
            template: '',
            exportAs: 'matDatepicker',
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush,
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None
          }]
        }], function () {
          return [{
            type: _angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__["MatDialog"]
          }, {
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["Overlay"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["NgZone"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewContainerRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [MAT_DATEPICKER_SCROLL_STRATEGY]
            }]
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["DOCUMENT"]]
            }]
          }];
        }, {
          startView: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          yearSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          monthSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          openedStream: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"],
            args: ['opened']
          }],
          closedStream: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"],
            args: ['closed']
          }],
          startAt: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          color: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          touchUi: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          opened: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          calendarHeaderComponent: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          panelClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          dateClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker-input.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * \@docs-private
       * @type {?}
       */
      var MAT_DATEPICKER_VALUE_ACCESSOR = {
        provide: _angular_forms__WEBPACK_IMPORTED_MODULE_14__["NG_VALUE_ACCESSOR"],
        useExisting: Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["forwardRef"])(
        /**
        * @return {?}
        */
        function () {
          return MatDatepickerInput;
        }),
        multi: true
      };
      /**
       * \@docs-private
       * @type {?}
       */
      var MAT_DATEPICKER_VALIDATORS = {
        provide: _angular_forms__WEBPACK_IMPORTED_MODULE_14__["NG_VALIDATORS"],
        useExisting: Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["forwardRef"])(
        /**
        * @return {?}
        */
        function () {
          return MatDatepickerInput;
        }),
        multi: true
      };
      /**
       * An event used for datepicker input and change events. We don't always have access to a native
       * input or change event because the event may have been triggered by the user clicking on the
       * calendar popup. For consistency, we always use MatDatepickerInputEvent instead.
       * @template D
       */
      var MatDatepickerInputEvent = /*#__PURE__*/_createClass(
      /**
       * @param {?} target
       * @param {?} targetElement
       */
      function MatDatepickerInputEvent(target, targetElement) {
        _classCallCheck(this, MatDatepickerInputEvent);
        this.target = target;
        this.targetElement = targetElement;
        this.value = this.target.value;
      });
      if (false) {}
      /**
       * Directive used to connect an input to a MatDatepicker.
       * @template D
       */
      var MatDatepickerInput = /*#__PURE__*/function () {
        /**
         * @param {?} _elementRef
         * @param {?} _dateAdapter
         * @param {?} _dateFormats
         * @param {?} _formField
         */
        function MatDatepickerInput(_elementRef, _dateAdapter, _dateFormats, _formField) {
          var _this14 = this;
          _classCallCheck(this, MatDatepickerInput);
          this._elementRef = _elementRef;
          this._dateAdapter = _dateAdapter;
          this._dateFormats = _dateFormats;
          this._formField = _formField;
          /**
           * Emits when a `change` event is fired on this `<input>`.
           */
          this.dateChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when an `input` event is fired on this `<input>`.
           */
          this.dateInput = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when the value changes (either due to user input or programmatic change).
           */
          this._valueChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          /**
           * Emits when the disabled state has changed
           */
          this._disabledChange = new _angular_core__WEBPACK_IMPORTED_MODULE_4__["EventEmitter"]();
          this._onTouched =
          /**
          * @return {?}
          */
          function () {};
          this._cvaOnChange =
          /**
          * @return {?}
          */
          function () {};
          this._validatorOnChange =
          /**
          * @return {?}
          */
          function () {};
          this._datepickerSubscription = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          this._localeSubscription = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          /**
           * The form control validator for whether the input parses.
           */
          this._parseValidator =
          /**
          * @return {?}
          */
          function () {
            return _this14._lastValueValid ? null : {
              'matDatepickerParse': {
                'text': _this14._elementRef.nativeElement.value
              }
            };
          };
          /**
           * The form control validator for the min date.
           */
          this._minValidator =
          /**
          * @param {?} control
          * @return {?}
          */
          function (control) {
            /** @type {?} */
            var controlValue = _this14._getValidDateOrNull(_this14._dateAdapter.deserialize(control.value));
            return !_this14.min || !controlValue || _this14._dateAdapter.compareDate(_this14.min, controlValue) <= 0 ? null : {
              'matDatepickerMin': {
                'min': _this14.min,
                'actual': controlValue
              }
            };
          };
          /**
           * The form control validator for the max date.
           */
          this._maxValidator =
          /**
          * @param {?} control
          * @return {?}
          */
          function (control) {
            /** @type {?} */
            var controlValue = _this14._getValidDateOrNull(_this14._dateAdapter.deserialize(control.value));
            return !_this14.max || !controlValue || _this14._dateAdapter.compareDate(_this14.max, controlValue) >= 0 ? null : {
              'matDatepickerMax': {
                'max': _this14.max,
                'actual': controlValue
              }
            };
          };
          /**
           * The form control validator for the date filter.
           */
          this._filterValidator =
          /**
          * @param {?} control
          * @return {?}
          */
          function (control) {
            /** @type {?} */
            var controlValue = _this14._getValidDateOrNull(_this14._dateAdapter.deserialize(control.value));
            return !_this14._dateFilter || !controlValue || _this14._dateFilter(controlValue) ? null : {
              'matDatepickerFilter': true
            };
          };
          /**
           * The combined form control validator for this input.
           */
          this._validator = _angular_forms__WEBPACK_IMPORTED_MODULE_14__["Validators"].compose([this._parseValidator, this._minValidator, this._maxValidator, this._filterValidator]);
          /**
           * Whether the last value set on the input was valid.
           */
          this._lastValueValid = false;
          if (!this._dateAdapter) {
            throw createMissingDateImplError('DateAdapter');
          }
          if (!this._dateFormats) {
            throw createMissingDateImplError('MAT_DATE_FORMATS');
          }
          // Update the displayed date when the locale changes.
          this._localeSubscription = _dateAdapter.localeChanges.subscribe(
          /**
          * @return {?}
          */
          function () {
            _this14.value = _this14.value;
          });
        }
        /**
         * The datepicker that this input is associated with.
         * @param {?} value
         * @return {?}
         */
        _createClass(MatDatepickerInput, [{
          key: "matDatepicker",
          set: function set(value) {
            var _this15 = this;
            if (!value) {
              return;
            }
            this._datepicker = value;
            this._datepicker._registerInput(this);
            this._datepickerSubscription.unsubscribe();
            this._datepickerSubscription = this._datepicker._selectedChanged.subscribe(
            /**
            * @param {?} selected
            * @return {?}
            */
            function (selected) {
              _this15.value = selected;
              _this15._cvaOnChange(selected);
              _this15._onTouched();
              _this15.dateInput.emit(new MatDatepickerInputEvent(_this15, _this15._elementRef.nativeElement));
              _this15.dateChange.emit(new MatDatepickerInputEvent(_this15, _this15._elementRef.nativeElement));
            });
          }
          /**
           * Function that can be used to filter out dates within the datepicker.
           * @param {?} value
           * @return {?}
           */
        }, {
          key: "matDatepickerFilter",
          set: function set(value) {
            this._dateFilter = value;
            this._validatorOnChange();
          }
          /**
           * The value of the input.
           * @return {?}
           */
        }, {
          key: "value",
          get: function get() {
            return this._value;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            value = this._dateAdapter.deserialize(value);
            this._lastValueValid = !value || this._dateAdapter.isValid(value);
            value = this._getValidDateOrNull(value);
            /** @type {?} */
            var oldDate = this.value;
            this._value = value;
            this._formatValue(value);
            if (!this._dateAdapter.sameDate(oldDate, value)) {
              this._valueChange.emit(value);
            }
          }
          /**
           * The minimum valid date.
           * @return {?}
           */
        }, {
          key: "min",
          get: function get() {
            return this._min;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._min = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
            this._validatorOnChange();
          }
          /**
           * The maximum valid date.
           * @return {?}
           */
        }, {
          key: "max",
          get: function get() {
            return this._max;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._max = this._getValidDateOrNull(this._dateAdapter.deserialize(value));
            this._validatorOnChange();
          }
          /**
           * Whether the datepicker-input is disabled.
           * @return {?}
           */
        }, {
          key: "disabled",
          get: function get() {
            return !!this._disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            /** @type {?} */
            var newValue = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_12__["coerceBooleanProperty"])(value);
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            if (this._disabled !== newValue) {
              this._disabled = newValue;
              this._disabledChange.emit(newValue);
            }
            // We need to null check the `blur` method, because it's undefined during SSR.
            if (newValue && element.blur) {
              // Normally, native input elements automatically blur if they turn disabled. This behavior
              // is problematic, because it would mean that it triggers another change detection cycle,
              // which then causes a changed after checked error if the input element was focused before.
              element.blur();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._datepickerSubscription.unsubscribe();
            this._localeSubscription.unsubscribe();
            this._valueChange.complete();
            this._disabledChange.complete();
          }
          /**
           * \@docs-private
           * @param {?} fn
           * @return {?}
           */
        }, {
          key: "registerOnValidatorChange",
          value: function registerOnValidatorChange(fn) {
            this._validatorOnChange = fn;
          }
          /**
           * \@docs-private
           * @param {?} c
           * @return {?}
           */
        }, {
          key: "validate",
          value: function validate(c) {
            return this._validator ? this._validator(c) : null;
          }
          /**
           * @deprecated
           * \@breaking-change 8.0.0 Use `getConnectedOverlayOrigin` instead
           * @return {?}
           */
        }, {
          key: "getPopupConnectionElementRef",
          value: function getPopupConnectionElementRef() {
            return this.getConnectedOverlayOrigin();
          }
          /**
           * Gets the element that the datepicker popup should be connected to.
           * @return {?} The element to connect the popup to.
           */
        }, {
          key: "getConnectedOverlayOrigin",
          value: function getConnectedOverlayOrigin() {
            return this._formField ? this._formField.getConnectedOverlayOrigin() : this._elementRef;
          }
          // Implemented as part of ControlValueAccessor.
          /**
           * @param {?} value
           * @return {?}
           */
        }, {
          key: "writeValue",
          value: function writeValue(value) {
            this.value = value;
          }
          // Implemented as part of ControlValueAccessor.
          /**
           * @param {?} fn
           * @return {?}
           */
        }, {
          key: "registerOnChange",
          value: function registerOnChange(fn) {
            this._cvaOnChange = fn;
          }
          // Implemented as part of ControlValueAccessor.
          /**
           * @param {?} fn
           * @return {?}
           */
        }, {
          key: "registerOnTouched",
          value: function registerOnTouched(fn) {
            this._onTouched = fn;
          }
          // Implemented as part of ControlValueAccessor.
          /**
           * @param {?} isDisabled
           * @return {?}
           */
        }, {
          key: "setDisabledState",
          value: function setDisabledState(isDisabled) {
            this.disabled = isDisabled;
          }
          /**
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onKeydown",
          value: function _onKeydown(event) {
            /** @type {?} */
            var isAltDownArrow = event.altKey && event.keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_9__["DOWN_ARROW"];
            if (this._datepicker && isAltDownArrow && !this._elementRef.nativeElement.readOnly) {
              this._datepicker.open();
              event.preventDefault();
            }
          }
          /**
           * @param {?} value
           * @return {?}
           */
        }, {
          key: "_onInput",
          value: function _onInput(value) {
            /** @type {?} */
            var lastValueWasValid = this._lastValueValid;
            /** @type {?} */
            var date = this._dateAdapter.parse(value, this._dateFormats.parse.dateInput);
            this._lastValueValid = !date || this._dateAdapter.isValid(date);
            date = this._getValidDateOrNull(date);
            if (!this._dateAdapter.sameDate(date, this._value)) {
              this._value = date;
              this._cvaOnChange(date);
              this._valueChange.emit(date);
              this.dateInput.emit(new MatDatepickerInputEvent(this, this._elementRef.nativeElement));
            } else if (lastValueWasValid !== this._lastValueValid) {
              this._validatorOnChange();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "_onChange",
          value: function _onChange() {
            this.dateChange.emit(new MatDatepickerInputEvent(this, this._elementRef.nativeElement));
          }
          /**
           * Returns the palette used by the input's form field, if any.
           * @return {?}
           */
        }, {
          key: "_getThemePalette",
          value: function _getThemePalette() {
            return this._formField ? this._formField.color : undefined;
          }
          /**
           * Handles blur events on the input.
           * @return {?}
           */
        }, {
          key: "_onBlur",
          value: function _onBlur() {
            // Reformat the input only if we have a valid value.
            if (this.value) {
              this._formatValue(this.value);
            }
            this._onTouched();
          }
          /**
           * Formats a value and sets it on the input element.
           * @private
           * @param {?} value
           * @return {?}
           */
        }, {
          key: "_formatValue",
          value: function _formatValue(value) {
            this._elementRef.nativeElement.value = value ? this._dateAdapter.format(value, this._dateFormats.display.dateInput) : '';
          }
          /**
           * @private
           * @param {?} obj The object to check.
           * @return {?} The given object if it is both a date instance and valid, otherwise null.
           */
        }, {
          key: "_getValidDateOrNull",
          value: function _getValidDateOrNull(obj) {
            return this._dateAdapter.isDateInstance(obj) && this._dateAdapter.isValid(obj) ? obj : null;
          }
        }]);
        return MatDatepickerInput;
      }();
      MatDatepickerInput.ɵfac = function MatDatepickerInput_Factory(t) {
        return new (t || MatDatepickerInput)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_material_form_field__WEBPACK_IMPORTED_MODULE_15__["MAT_FORM_FIELD"], 8));
      };
      MatDatepickerInput.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineDirective"]({
        type: MatDatepickerInput,
        selectors: [["input", "matDatepicker", ""]],
        hostVars: 5,
        hostBindings: function MatDatepickerInput_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("input", function MatDatepickerInput_input_HostBindingHandler($event) {
              return ctx._onInput($event.target.value);
            })("change", function MatDatepickerInput_change_HostBindingHandler() {
              return ctx._onChange();
            })("blur", function MatDatepickerInput_blur_HostBindingHandler() {
              return ctx._onBlur();
            })("keydown", function MatDatepickerInput_keydown_HostBindingHandler($event) {
              return ctx._onKeydown($event);
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵhostProperty"]("disabled", ctx.disabled);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-haspopup", ctx._datepicker ? "dialog" : null)("aria-owns", (ctx._datepicker == null ? null : ctx._datepicker.opened) && ctx._datepicker.id || null)("min", ctx.min ? ctx._dateAdapter.toIso8601(ctx.min) : null)("max", ctx.max ? ctx._dateAdapter.toIso8601(ctx.max) : null);
          }
        },
        inputs: {
          value: "value",
          matDatepicker: "matDatepicker",
          matDatepickerFilter: "matDatepickerFilter",
          min: "min",
          max: "max",
          disabled: "disabled"
        },
        outputs: {
          dateChange: "dateChange",
          dateInput: "dateInput"
        },
        exportAs: ["matDatepickerInput"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵProvidersFeature"]([MAT_DATEPICKER_VALUE_ACCESSOR, MAT_DATEPICKER_VALIDATORS, {
          provide: _angular_material_input__WEBPACK_IMPORTED_MODULE_16__["MAT_INPUT_VALUE_ACCESSOR"],
          useExisting: MatDatepickerInput
        }])]
      });
      /** @nocollapse */
      MatDatepickerInput.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]
        }, {
          type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
          }]
        }, {
          type: _angular_material_form_field__WEBPACK_IMPORTED_MODULE_15__["MatFormField"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
            args: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_15__["MAT_FORM_FIELD"]]
          }]
        }];
      };
      MatDatepickerInput.propDecorators = {
        matDatepicker: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        matDatepickerFilter: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        value: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        min: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        max: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        dateChange: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }],
        dateInput: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepickerInput, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Directive"],
          args: [{
            selector: 'input[matDatepicker]',
            providers: [MAT_DATEPICKER_VALUE_ACCESSOR, MAT_DATEPICKER_VALIDATORS, {
              provide: _angular_material_input__WEBPACK_IMPORTED_MODULE_16__["MAT_INPUT_VALUE_ACCESSOR"],
              useExisting: MatDatepickerInput
            }],
            host: {
              '[attr.aria-haspopup]': '_datepicker ? "dialog" : null',
              '[attr.aria-owns]': '(_datepicker?.opened && _datepicker.id) || null',
              '[attr.min]': 'min ? _dateAdapter.toIso8601(min) : null',
              '[attr.max]': 'max ? _dateAdapter.toIso8601(max) : null',
              '[disabled]': 'disabled',
              '(input)': '_onInput($event.target.value)',
              '(change)': '_onChange()',
              '(blur)': '_onBlur()',
              '(keydown)': '_onKeydown($event)'
            },
            exportAs: 'matDatepickerInput'
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ElementRef"]
          }, {
            type: _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["DateAdapter"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MAT_DATE_FORMATS"]]
            }]
          }, {
            type: _angular_material_form_field__WEBPACK_IMPORTED_MODULE_15__["MatFormField"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Inject"],
              args: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_15__["MAT_FORM_FIELD"]]
            }]
          }];
        }, {
          dateChange: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          dateInput: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Output"]
          }],
          value: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          matDatepicker: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          matDatepickerFilter: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          min: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          max: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker-toggle.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Can be used to override the icon of a `matDatepickerToggle`.
       */
      var MatDatepickerToggleIcon = /*#__PURE__*/_createClass(function MatDatepickerToggleIcon() {
        _classCallCheck(this, MatDatepickerToggleIcon);
      });
      MatDatepickerToggleIcon.ɵfac = function MatDatepickerToggleIcon_Factory(t) {
        return new (t || MatDatepickerToggleIcon)();
      };
      MatDatepickerToggleIcon.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineDirective"]({
        type: MatDatepickerToggleIcon,
        selectors: [["", "matDatepickerToggleIcon", ""]]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepickerToggleIcon, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Directive"],
          args: [{
            selector: '[matDatepickerToggleIcon]'
          }]
        }], null, null);
      })();
      /**
       * @template D
       */
      var MatDatepickerToggle = /*#__PURE__*/function () {
        /**
         * @param {?} _intl
         * @param {?} _changeDetectorRef
         * @param {?} defaultTabIndex
         */
        function MatDatepickerToggle(_intl, _changeDetectorRef, defaultTabIndex) {
          _classCallCheck(this, MatDatepickerToggle);
          this._intl = _intl;
          this._changeDetectorRef = _changeDetectorRef;
          this._stateChanges = rxjs__WEBPACK_IMPORTED_MODULE_8__["Subscription"].EMPTY;
          /** @type {?} */
          var parsedTabIndex = Number(defaultTabIndex);
          this.tabIndex = parsedTabIndex || parsedTabIndex === 0 ? parsedTabIndex : null;
        }
        /**
         * Whether the toggle button is disabled.
         * @return {?}
         */
        _createClass(MatDatepickerToggle, [{
          key: "disabled",
          get: function get() {
            if (this._disabled === undefined && this.datepicker) {
              return this.datepicker.disabled;
            }
            return !!this._disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._disabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_12__["coerceBooleanProperty"])(value);
          }
          /**
           * @param {?} changes
           * @return {?}
           */
        }, {
          key: "ngOnChanges",
          value: function ngOnChanges(changes) {
            if (changes['datepicker']) {
              this._watchStateChanges();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._stateChanges.unsubscribe();
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            this._watchStateChanges();
          }
          /**
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_open",
          value: function _open(event) {
            if (this.datepicker && !this.disabled) {
              this.datepicker.open();
              event.stopPropagation();
            }
          }
          /**
           * @private
           * @return {?}
           */
        }, {
          key: "_watchStateChanges",
          value: function _watchStateChanges() {
            var _this16 = this;
            /** @type {?} */
            var datepickerDisabled = this.datepicker ? this.datepicker._disabledChange : Object(rxjs__WEBPACK_IMPORTED_MODULE_8__["of"])();
            /** @type {?} */
            var inputDisabled = this.datepicker && this.datepicker._datepickerInput ? this.datepicker._datepickerInput._disabledChange : Object(rxjs__WEBPACK_IMPORTED_MODULE_8__["of"])();
            /** @type {?} */
            var datepickerToggled = this.datepicker ? Object(rxjs__WEBPACK_IMPORTED_MODULE_8__["merge"])(this.datepicker.openedStream, this.datepicker.closedStream) : Object(rxjs__WEBPACK_IMPORTED_MODULE_8__["of"])();
            this._stateChanges.unsubscribe();
            this._stateChanges = Object(rxjs__WEBPACK_IMPORTED_MODULE_8__["merge"])(this._intl.changes, datepickerDisabled, inputDisabled, datepickerToggled).subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this16._changeDetectorRef.markForCheck();
            });
          }
        }]);
        return MatDatepickerToggle;
      }();
      MatDatepickerToggle.ɵfac = function MatDatepickerToggle_Factory(t) {
        return new (t || MatDatepickerToggle)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](MatDatepickerIntl), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵinjectAttribute"]('tabindex'));
      };
      MatDatepickerToggle.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
        type: MatDatepickerToggle,
        selectors: [["mat-datepicker-toggle"]],
        contentQueries: function MatDatepickerToggle_ContentQueries(rf, ctx, dirIndex) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵcontentQuery"](dirIndex, MatDatepickerToggleIcon, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx._customIcon = _t.first);
          }
        },
        viewQuery: function MatDatepickerToggle_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵviewQuery"](_c2, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵloadQuery"]()) && (ctx._button = _t.first);
          }
        },
        hostAttrs: [1, "mat-datepicker-toggle"],
        hostVars: 7,
        hostBindings: function MatDatepickerToggle_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("focus", function MatDatepickerToggle_focus_HostBindingHandler() {
              return ctx._button.focus();
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("tabindex", ctx.disabled ? null : 0 - 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵclassProp"]("mat-datepicker-toggle-active", ctx.datepicker && ctx.datepicker.opened)("mat-accent", ctx.datepicker && ctx.datepicker.color === "accent")("mat-warn", ctx.datepicker && ctx.datepicker.color === "warn");
          }
        },
        inputs: {
          tabIndex: "tabIndex",
          disabled: "disabled",
          datepicker: ["for", "datepicker"],
          disableRipple: "disableRipple"
        },
        exportAs: ["matDatepickerToggle"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵNgOnChangesFeature"]],
        ngContentSelectors: _c4,
        decls: 4,
        vars: 6,
        consts: [["mat-icon-button", "", "type", "button", 3, "disabled", "disableRipple", "click"], ["button", ""], ["class", "mat-datepicker-toggle-default-icon", "viewBox", "0 0 24 24", "width", "24px", "height", "24px", "fill", "currentColor", "focusable", "false", 4, "ngIf"], ["viewBox", "0 0 24 24", "width", "24px", "height", "24px", "fill", "currentColor", "focusable", "false", 1, "mat-datepicker-toggle-default-icon"], ["d", "M19 3h-1V1h-2v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm0 16H5V8h14v11zM7 10h5v5H7z"]],
        template: function MatDatepickerToggle_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵprojectionDef"](_c3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "button", 0, 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function MatDatepickerToggle_Template_button_click_0_listener($event) {
              return ctx._open($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, MatDatepickerToggle__svg_svg_2_Template, 2, 0, "svg", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵprojection"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("disabled", ctx.disabled)("disableRipple", ctx.disableRipple);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵattribute"]("aria-haspopup", ctx.datepicker ? "dialog" : null)("aria-label", ctx._intl.openCalendarLabel)("tabindex", ctx.disabled ? 0 - 1 : ctx.tabIndex);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", !ctx._customIcon);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButton"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"]],
        styles: [".mat-form-field-appearance-legacy .mat-form-field-prefix .mat-datepicker-toggle-default-icon,.mat-form-field-appearance-legacy .mat-form-field-suffix .mat-datepicker-toggle-default-icon{width:1em}.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-prefix .mat-datepicker-toggle-default-icon,.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-suffix .mat-datepicker-toggle-default-icon{display:block;width:1.5em;height:1.5em}.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-prefix .mat-icon-button .mat-datepicker-toggle-default-icon,.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-suffix .mat-icon-button .mat-datepicker-toggle-default-icon{margin:auto}\n"],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatDatepickerToggle.ctorParameters = function () {
        return [{
          type: MatDatepickerIntl
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
        }, {
          type: String,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Attribute"],
            args: ['tabindex']
          }]
        }];
      };
      MatDatepickerToggle.propDecorators = {
        datepicker: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"],
          args: ['for']
        }],
        tabIndex: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        disableRipple: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
        }],
        _customIcon: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ContentChild"],
          args: [MatDatepickerToggleIcon]
        }],
        _button: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
          args: ['button']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepickerToggle, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Component"],
          args: [{
            selector: 'mat-datepicker-toggle',
            template: "<button\n  #button\n  mat-icon-button\n  type=\"button\"\n  [attr.aria-haspopup]=\"datepicker ? 'dialog' : null\"\n  [attr.aria-label]=\"_intl.openCalendarLabel\"\n  [attr.tabindex]=\"disabled ? -1 : tabIndex\"\n  [disabled]=\"disabled\"\n  [disableRipple]=\"disableRipple\"\n  (click)=\"_open($event)\">\n\n  <svg\n    *ngIf=\"!_customIcon\"\n    class=\"mat-datepicker-toggle-default-icon\"\n    viewBox=\"0 0 24 24\"\n    width=\"24px\"\n    height=\"24px\"\n    fill=\"currentColor\"\n    focusable=\"false\">\n    <path d=\"M19 3h-1V1h-2v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm0 16H5V8h14v11zM7 10h5v5H7z\"/>\n  </svg>\n\n  <ng-content select=\"[matDatepickerToggleIcon]\"></ng-content>\n</button>\n",
            host: {
              'class': 'mat-datepicker-toggle',
              // Always set the tabindex to -1 so that it doesn't overlap with any custom tabindex the
              // consumer may have provided, while still being able to receive focus.
              '[attr.tabindex]': 'disabled ? null : -1',
              '[class.mat-datepicker-toggle-active]': 'datepicker && datepicker.opened',
              '[class.mat-accent]': 'datepicker && datepicker.color === "accent"',
              '[class.mat-warn]': 'datepicker && datepicker.color === "warn"',
              '(focus)': '_button.focus()'
            },
            exportAs: 'matDatepickerToggle',
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectionStrategy"].OnPush,
            styles: [".mat-form-field-appearance-legacy .mat-form-field-prefix .mat-datepicker-toggle-default-icon,.mat-form-field-appearance-legacy .mat-form-field-suffix .mat-datepicker-toggle-default-icon{width:1em}.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-prefix .mat-datepicker-toggle-default-icon,.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-suffix .mat-datepicker-toggle-default-icon{display:block;width:1.5em;height:1.5em}.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-prefix .mat-icon-button .mat-datepicker-toggle-default-icon,.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-suffix .mat-icon-button .mat-datepicker-toggle-default-icon{margin:auto}\n"]
          }]
        }], function () {
          return [{
            type: MatDatepickerIntl
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ChangeDetectorRef"]
          }, {
            type: String,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Attribute"],
              args: ['tabindex']
            }]
          }];
        }, {
          tabIndex: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          datepicker: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"],
            args: ['for']
          }],
          disableRipple: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["Input"]
          }],
          _customIcon: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ContentChild"],
            args: [MatDatepickerToggleIcon]
          }],
          _button: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["ViewChild"],
            args: ['button']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/datepicker-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var MatDatepickerModule = /*#__PURE__*/_createClass(function MatDatepickerModule() {
        _classCallCheck(this, MatDatepickerModule);
      });
      MatDatepickerModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
        type: MatDatepickerModule
      });
      MatDatepickerModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
        factory: function MatDatepickerModule_Factory(t) {
          return new (t || MatDatepickerModule)();
        },
        providers: [MatDatepickerIntl, MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY_PROVIDER],
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_3__["CommonModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButtonModule"], _angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__["MatDialogModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["OverlayModule"], _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["A11yModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__["PortalModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](MatDatepickerModule, {
          declarations: function declarations() {
            return [MatCalendar, MatCalendarBody, MatDatepicker, MatDatepickerContent, MatDatepickerInput, MatDatepickerToggle, MatDatepickerToggleIcon, MatMonthView, MatYearView, MatMultiYearView, MatCalendarHeader];
          },
          imports: function imports() {
            return [_angular_common__WEBPACK_IMPORTED_MODULE_3__["CommonModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButtonModule"], _angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__["MatDialogModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["OverlayModule"], _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["A11yModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__["PortalModule"]];
          },
          exports: function exports() {
            return [MatCalendar, MatCalendarBody, MatDatepicker, MatDatepickerContent, MatDatepickerInput, MatDatepickerToggle, MatDatepickerToggleIcon, MatMonthView, MatYearView, MatMultiYearView, MatCalendarHeader];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵsetClassMetadata"](MatDatepickerModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_4__["NgModule"],
          args: [{
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["CommonModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButtonModule"], _angular_material_dialog__WEBPACK_IMPORTED_MODULE_6__["MatDialogModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_1__["OverlayModule"], _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["A11yModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_2__["PortalModule"]],
            exports: [MatCalendar, MatCalendarBody, MatDatepicker, MatDatepickerContent, MatDatepickerInput, MatDatepickerToggle, MatDatepickerToggleIcon, MatMonthView, MatYearView, MatMultiYearView, MatCalendarHeader],
            declarations: [MatCalendar, MatCalendarBody, MatDatepicker, MatDatepickerContent, MatDatepickerInput, MatDatepickerToggle, MatDatepickerToggleIcon, MatMonthView, MatYearView, MatMultiYearView, MatCalendarHeader],
            providers: [MatDatepickerIntl, MAT_DATEPICKER_SCROLL_STRATEGY_FACTORY_PROVIDER],
            entryComponents: [MatDatepickerContent, MatCalendarHeader]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/datepicker/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=datepicker.js.map

      /***/
    }
  }]);
})();
//# sourceMappingURL=default~form-controls-datepicker-datepicker-module~layout-expansion-panel-panel-module-es5.js.map