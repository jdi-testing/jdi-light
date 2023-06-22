(function () {
  function _slicedToArray(arr, i) { return _arrayWithHoles(arr) || _iterableToArrayLimit(arr, i) || _unsupportedIterableToArray(arr, i) || _nonIterableRest(); }
  function _nonIterableRest() { throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method."); }
  function _iterableToArrayLimit(arr, i) { var _i = null == arr ? null : "undefined" != typeof Symbol && arr[Symbol.iterator] || arr["@@iterator"]; if (null != _i) { var _s, _e, _x, _r, _arr = [], _n = !0, _d = !1; try { if (_x = (_i = _i.call(arr)).next, 0 === i) { if (Object(_i) !== _i) return; _n = !1; } else for (; !(_n = (_s = _x.call(_i)).done) && (_arr.push(_s.value), _arr.length !== i); _n = !0); } catch (err) { _d = !0, _e = err; } finally { try { if (!_n && null != _i["return"] && (_r = _i["return"](), Object(_r) !== _r)) return; } finally { if (_d) throw _e; } } return _arr; } }
  function _arrayWithHoles(arr) { if (Array.isArray(arr)) return arr; }
  function _toConsumableArray(arr) { return _arrayWithoutHoles(arr) || _iterableToArray(arr) || _unsupportedIterableToArray(arr) || _nonIterableSpread(); }
  function _nonIterableSpread() { throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method."); }
  function _unsupportedIterableToArray(o, minLen) { if (!o) return; if (typeof o === "string") return _arrayLikeToArray(o, minLen); var n = Object.prototype.toString.call(o).slice(8, -1); if (n === "Object" && o.constructor) n = o.constructor.name; if (n === "Map" || n === "Set") return Array.from(o); if (n === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return _arrayLikeToArray(o, minLen); }
  function _iterableToArray(iter) { if (typeof Symbol !== "undefined" && iter[Symbol.iterator] != null || iter["@@iterator"] != null) return Array.from(iter); }
  function _arrayWithoutHoles(arr) { if (Array.isArray(arr)) return _arrayLikeToArray(arr); }
  function _arrayLikeToArray(arr, len) { if (len == null || len > arr.length) len = arr.length; for (var i = 0, arr2 = new Array(len); i < len; i++) arr2[i] = arr[i]; return arr2; }
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
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["navigation-menu-menu-module"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js":
    /*!**********************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js ***!
      \**********************************************************************/
    /*! exports provided: MAT_MENU_DEFAULT_OPTIONS, MAT_MENU_PANEL, MAT_MENU_SCROLL_STRATEGY, MatMenu, MatMenuContent, MatMenuItem, MatMenuModule, MatMenuTrigger, _MatMenu, _MatMenuBase, _MatMenuDirectivesModule, fadeInItems, matMenuAnimations, transformMenu, ɵangular_material_src_material_menu_menu_a, ɵangular_material_src_material_menu_menu_b, ɵangular_material_src_material_menu_menu_c */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015MenuJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_MENU_DEFAULT_OPTIONS", function () {
        return MAT_MENU_DEFAULT_OPTIONS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_MENU_PANEL", function () {
        return MAT_MENU_PANEL;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_MENU_SCROLL_STRATEGY", function () {
        return MAT_MENU_SCROLL_STRATEGY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMenu", function () {
        return MatMenu;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMenuContent", function () {
        return MatMenuContent;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMenuItem", function () {
        return MatMenuItem;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMenuModule", function () {
        return MatMenuModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatMenuTrigger", function () {
        return MatMenuTrigger;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "_MatMenu", function () {
        return _MatMenu;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "_MatMenuBase", function () {
        return _MatMenuBase;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "_MatMenuDirectivesModule", function () {
        return _MatMenuDirectivesModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "fadeInItems", function () {
        return fadeInItems;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "matMenuAnimations", function () {
        return matMenuAnimations;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "transformMenu", function () {
        return transformMenu;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ɵangular_material_src_material_menu_menu_a", function () {
        return MAT_MENU_DEFAULT_OPTIONS_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ɵangular_material_src_material_menu_menu_b", function () {
        return MAT_MENU_SCROLL_STRATEGY_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ɵangular_material_src_material_menu_menu_c", function () {
        return MAT_MENU_SCROLL_STRATEGY_FACTORY_PROVIDER;
      });
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/coercion */"./node_modules/@angular/cdk/fesm2015/coercion.js");
      /* harmony import */
      var _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/cdk/keycodes */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/keycodes.js");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");
      /* harmony import */
      var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/cdk/portal */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/portal.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/cdk/bidi */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/bidi.js");
      /* harmony import */
      var _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! @angular/cdk/overlay */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/overlay.js");
      /* harmony import */
      var _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! @angular/cdk/platform */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/platform.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-animations.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Animations used by the mat-menu component.
       * Animation duration and timing values are based on:
       * https://material.io/guidelines/components/menus.html#menus-usage
       * \@docs-private
       * @type {?}
       */

      var _c0 = ["mat-menu-item", ""];
      var _c1 = ["*"];
      function _MatMenu_ng_template_0_Template(rf, ctx) {
        if (rf & 1) {
          var _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "div", 0);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("keydown", function _MatMenu_ng_template_0_Template_div_keydown_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r6);
            var ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
            return ctx_r5._handleKeydown($event);
          })("click", function _MatMenu_ng_template_0_Template_div_click_0_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r6);
            var ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
            return ctx_r7.closed.emit("click");
          })("@transformMenu.start", function _MatMenu_ng_template_0_Template_div_animation_transformMenu_start_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r6);
            var ctx_r8 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
            return ctx_r8._onAnimationStart($event);
          })("@transformMenu.done", function _MatMenu_ng_template_0_Template_div_animation_transformMenu_done_0_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r6);
            var ctx_r9 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
            return ctx_r9._onAnimationDone($event);
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "div", 1);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵprojection"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("id", ctx_r4.panelId)("ngClass", ctx_r4._classList)("@transformMenu", ctx_r4._panelAnimationState);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵattribute"]("aria-label", ctx_r4.ariaLabel || null)("aria-labelledby", ctx_r4.ariaLabelledby || null)("aria-describedby", ctx_r4.ariaDescribedby || null);
        }
      }
      var matMenuAnimations = {
        /**
         * This animation controls the menu panel's entry and exit from the page.
         *
         * When the menu panel is added to the DOM, it scales in and fades in its border.
         *
         * When the menu panel is removed from the DOM, it simply fades out after a brief
         * delay to display the ripple.
         */
        transformMenu: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["trigger"])('transformMenu', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["state"])('void', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({
          opacity: 0,
          transform: 'scale(0.8)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["transition"])('void => enter', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["group"])([Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["query"])('.mat-menu-content, .mat-mdc-menu-content', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["animate"])('100ms linear', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({
          opacity: 1
        }))), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["animate"])('120ms cubic-bezier(0, 0, 0.2, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({
          transform: 'scale(1)'
        }))])), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["transition"])('* => void', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["animate"])('100ms 25ms linear', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({
          opacity: 0
        })))]),
        /**
         * This animation fades in the background color and content of the menu panel
         * after its containing element is scaled in.
         */
        fadeInItems: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["trigger"])('fadeInItems', [
        // TODO(crisbeto): this is inside the `transformMenu`
        // now. Remove next time we do breaking changes.
        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["state"])('showing', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({
          opacity: 1
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["transition"])('void => *', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({
          opacity: 0
        }), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["animate"])('400ms 100ms cubic-bezier(0.55, 0, 0.55, 0.2)')])])
      };
      /**
       * @deprecated
       * \@breaking-change 8.0.0
       * \@docs-private
       * @type {?}
       */
      var fadeInItems = matMenuAnimations.fadeInItems;
      /**
       * @deprecated
       * \@breaking-change 8.0.0
       * \@docs-private
       * @type {?}
       */
      var transformMenu = matMenuAnimations.transformMenu;

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-content.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Menu content that will be rendered lazily once the menu is opened.
       */
      var MatMenuContent = /*#__PURE__*/function () {
        /**
         * @param {?} _template
         * @param {?} _componentFactoryResolver
         * @param {?} _appRef
         * @param {?} _injector
         * @param {?} _viewContainerRef
         * @param {?} _document
         * @param {?=} _changeDetectorRef
         */
        function MatMenuContent(_template, _componentFactoryResolver, _appRef, _injector, _viewContainerRef, _document, _changeDetectorRef) {
          _classCallCheck(this, MatMenuContent);
          this._template = _template;
          this._componentFactoryResolver = _componentFactoryResolver;
          this._appRef = _appRef;
          this._injector = _injector;
          this._viewContainerRef = _viewContainerRef;
          this._document = _document;
          this._changeDetectorRef = _changeDetectorRef;
          /**
           * Emits when the menu content has been attached.
           */
          this._attached = new rxjs__WEBPACK_IMPORTED_MODULE_4__["Subject"]();
        }
        /**
         * Attaches the content with a particular context.
         * \@docs-private
         * @param {?=} context
         * @return {?}
         */
        _createClass(MatMenuContent, [{
          key: "attach",
          value: function attach() {
            var context = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};
            if (!this._portal) {
              this._portal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_7__["TemplatePortal"](this._template, this._viewContainerRef);
            }
            this.detach();
            if (!this._outlet) {
              this._outlet = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_7__["DomPortalOutlet"](this._document.createElement('div'), this._componentFactoryResolver, this._appRef, this._injector);
            }
            /** @type {?} */
            var element = this._template.elementRef.nativeElement;
            // Because we support opening the same menu from different triggers (which in turn have their
            // own `OverlayRef` panel), we have to re-insert the host element every time, otherwise we
            // risk it staying attached to a pane that's no longer in the DOM.
            /** @type {?} */element.parentNode.insertBefore(this._outlet.outletElement, element);
            // When `MatMenuContent` is used in an `OnPush` component, the insertion of the menu
            // content via `createEmbeddedView` does not cause the content to be seen as "dirty"
            // by Angular. This causes the `@ContentChildren` for menu items within the menu to
            // not be updated by Angular. By explicitly marking for check here, we tell Angular that
            // it needs to check for new menu items and update the `@ContentChild` in `MatMenu`.
            // @breaking-change 9.0.0 Make change detector ref required
            if (this._changeDetectorRef) {
              this._changeDetectorRef.markForCheck();
            }
            this._portal.attach(this._outlet, context);
            this._attached.next();
          }
          /**
           * Detaches the content.
           * \@docs-private
           * @return {?}
           */
        }, {
          key: "detach",
          value: function detach() {
            if (this._portal.isAttached) {
              this._portal.detach();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this._outlet) {
              this._outlet.dispose();
            }
          }
        }]);
        return MatMenuContent;
      }();
      MatMenuContent.ɵfac = function MatMenuContent_Factory(t) {
        return new (t || MatMenuContent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ComponentFactoryResolver"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ApplicationRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["Injector"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_8__["DOCUMENT"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]));
      };
      MatMenuContent.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineDirective"]({
        type: MatMenuContent,
        selectors: [["ng-template", "matMenuContent", ""]]
      });
      /** @nocollapse */
      MatMenuContent.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ComponentFactoryResolver"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ApplicationRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Injector"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["DOCUMENT"]]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]
        }];
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatMenuContent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Directive"],
          args: [{
            selector: 'ng-template[matMenuContent]'
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ComponentFactoryResolver"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ApplicationRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Injector"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["DOCUMENT"]]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]
          }];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-errors.ts
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
       * Throws an exception for the case when menu trigger doesn't have a valid mat-menu instance
       * \@docs-private
       * @return {?}
       */
      function throwMatMenuMissingError() {
        throw Error("matMenuTriggerFor: must pass in an mat-menu instance.\n\n    Example:\n      <mat-menu #menu=\"matMenu\"></mat-menu>\n      <button [matMenuTriggerFor]=\"menu\"></button>");
      }
      /**
       * Throws an exception for the case when menu's x-position value isn't valid.
       * In other words, it doesn't match 'before' or 'after'.
       * \@docs-private
       * @return {?}
       */
      function throwMatMenuInvalidPositionX() {
        throw Error("xPosition value must be either 'before' or after'.\n      Example: <mat-menu xPosition=\"before\" #menu=\"matMenu\"></mat-menu>");
      }
      /**
       * Throws an exception for the case when menu's y-position value isn't valid.
       * In other words, it doesn't match 'above' or 'below'.
       * \@docs-private
       * @return {?}
       */
      function throwMatMenuInvalidPositionY() {
        throw Error("yPosition value must be either 'above' or below'.\n      Example: <mat-menu yPosition=\"above\" #menu=\"matMenu\"></mat-menu>");
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-panel.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token used to provide the parent menu to menu-specific components.
       * \@docs-private
       * @type {?}
       */
      var MAT_MENU_PANEL = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('MAT_MENU_PANEL');
      /**
       * Interface for a custom menu panel that can be used with `matMenuTriggerFor`.
       * \@docs-private
       * @record
       * @template T
       */
      function MatMenuPanel() {}
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-item.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      // Boilerplate for applying mixins to MatMenuItem.
      /**
       * \@docs-private
       */
      var MatMenuItemBase = /*#__PURE__*/_createClass(function MatMenuItemBase() {
        _classCallCheck(this, MatMenuItemBase);
      });
      /** @type {?} */
      var _MatMenuItemMixinBase = Object(_angular_material_core__WEBPACK_IMPORTED_MODULE_9__["mixinDisableRipple"])(Object(_angular_material_core__WEBPACK_IMPORTED_MODULE_9__["mixinDisabled"])(MatMenuItemBase));
      /**
       * Single item inside of a `mat-menu`. Provides the menu item styling and accessibility treatment.
       */
      var MatMenuItem = /*#__PURE__*/function (_MatMenuItemMixinBase2) {
        _inherits(MatMenuItem, _MatMenuItemMixinBase2);
        var _super = _createSuper(MatMenuItem);
        /**
         * @param {?} _elementRef
         * @param {?=} document
         * @param {?=} _focusMonitor
         * @param {?=} _parentMenu
         */
        function MatMenuItem(_elementRef, document, _focusMonitor, _parentMenu) {
          var _this;
          _classCallCheck(this, MatMenuItem);
          // @breaking-change 8.0.0 make `_focusMonitor` and `document` required params.
          _this = _super.call(this);
          _this._elementRef = _elementRef;
          _this._focusMonitor = _focusMonitor;
          _this._parentMenu = _parentMenu;
          /**
           * ARIA role for the menu item.
           */
          _this.role = 'menuitem';
          /**
           * Stream that emits when the menu item is hovered.
           */
          _this._hovered = new rxjs__WEBPACK_IMPORTED_MODULE_4__["Subject"]();
          /**
           * Stream that emits when the menu item is focused.
           */
          _this._focused = new rxjs__WEBPACK_IMPORTED_MODULE_4__["Subject"]();
          /**
           * Whether the menu item is highlighted.
           */
          _this._highlighted = false;
          /**
           * Whether the menu item acts as a trigger for a sub-menu.
           */
          _this._triggersSubmenu = false;
          if (_focusMonitor) {
            // Start monitoring the element so it gets the appropriate focused classes. We want
            // to show the focus style for menu items only when the focus was not caused by a
            // mouse or touch interaction.
            _focusMonitor.monitor(_this._elementRef, false);
          }
          if (_parentMenu && _parentMenu.addItem) {
            _parentMenu.addItem(_assertThisInitialized(_this));
          }
          _this._document = document;
          return _this;
        }
        /**
         * Focuses the menu item.
         * @param {?=} origin
         * @param {?=} options
         * @return {?}
         */
        _createClass(MatMenuItem, [{
          key: "focus",
          value: function focus() {
            var origin = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'program';
            var options = arguments.length > 1 ? arguments[1] : undefined;
            if (this._focusMonitor) {
              this._focusMonitor.focusVia(this._getHostElement(), origin, options);
            } else {
              this._getHostElement().focus(options);
            }
            this._focused.next(this);
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this._focusMonitor) {
              this._focusMonitor.stopMonitoring(this._elementRef);
            }
            if (this._parentMenu && this._parentMenu.removeItem) {
              this._parentMenu.removeItem(this);
            }
            this._hovered.complete();
            this._focused.complete();
          }
          /**
           * Used to set the `tabindex`.
           * @return {?}
           */
        }, {
          key: "_getTabIndex",
          value: function _getTabIndex() {
            return this.disabled ? '-1' : '0';
          }
          /**
           * Returns the host DOM element.
           * @return {?}
           */
        }, {
          key: "_getHostElement",
          value: function _getHostElement() {
            return this._elementRef.nativeElement;
          }
          /**
           * Prevents the default element actions if it is disabled.
           * @param {?} event
           * @return {?}
           */
          // We have to use a `HostListener` here in order to support both Ivy and ViewEngine.
          // In Ivy the `host` bindings will be merged when this class is extended, whereas in
          // ViewEngine they're overwritten.
          // TODO(crisbeto): we move this back into `host` once Ivy is turned on by default.
          // tslint:disable-next-line:no-host-decorator-in-concrete
        }, {
          key: "_checkDisabled",
          value: function _checkDisabled(event) {
            if (this.disabled) {
              event.preventDefault();
              event.stopPropagation();
            }
          }
          /**
           * Emits to the hover stream.
           * @return {?}
           */
          // We have to use a `HostListener` here in order to support both Ivy and ViewEngine.
          // In Ivy the `host` bindings will be merged when this class is extended, whereas in
          // ViewEngine they're overwritten.
          // TODO(crisbeto): we move this back into `host` once Ivy is turned on by default.
          // tslint:disable-next-line:no-host-decorator-in-concrete
        }, {
          key: "_handleMouseEnter",
          value: function _handleMouseEnter() {
            this._hovered.next(this);
          }
          /**
           * Gets the label to be used when determining whether the option should be focused.
           * @return {?}
           */
        }, {
          key: "getLabel",
          value: function getLabel() {
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            /** @type {?} */
            var textNodeType = this._document ? this._document.TEXT_NODE : 3;
            /** @type {?} */
            var output = '';
            if (element.childNodes) {
              /** @type {?} */
              var length = element.childNodes.length;
              // Go through all the top-level text nodes and extract their text.
              // We skip anything that's not a text node to prevent the text from
              // being thrown off by something like an icon.
              for (var i = 0; i < length; i++) {
                if (element.childNodes[i].nodeType === textNodeType) {
                  output += element.childNodes[i].textContent;
                }
              }
            }
            return output.trim();
          }
        }]);
        return MatMenuItem;
      }(_MatMenuItemMixinBase);
      MatMenuItem.ɵfac = function MatMenuItem_Factory(t) {
        return new (t || MatMenuItem)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_8__["DOCUMENT"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusMonitor"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_MENU_PANEL, 8));
      };
      MatMenuItem.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
        type: MatMenuItem,
        selectors: [["", "mat-menu-item", ""]],
        hostAttrs: [1, "mat-focus-indicator"],
        hostVars: 10,
        hostBindings: function MatMenuItem_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("click", function MatMenuItem_click_HostBindingHandler($event) {
              return ctx._checkDisabled($event);
            })("mouseenter", function MatMenuItem_mouseenter_HostBindingHandler() {
              return ctx._handleMouseEnter();
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵattribute"]("role", ctx.role)("tabindex", ctx._getTabIndex())("aria-disabled", ctx.disabled.toString())("disabled", ctx.disabled || null);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵclassProp"]("mat-menu-item", true)("mat-menu-item-highlighted", ctx._highlighted)("mat-menu-item-submenu-trigger", ctx._triggersSubmenu);
          }
        },
        inputs: {
          disabled: "disabled",
          disableRipple: "disableRipple",
          role: "role"
        },
        exportAs: ["matMenuItem"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵInheritDefinitionFeature"]],
        attrs: _c0,
        ngContentSelectors: _c1,
        decls: 2,
        vars: 2,
        consts: [["matRipple", "", 1, "mat-menu-ripple", 3, "matRippleDisabled", "matRippleTrigger"]],
        template: function MatMenuItem_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵprojectionDef"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵprojection"](0);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](1, "div", 0);
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("matRippleDisabled", ctx.disableRipple || ctx.disabled)("matRippleTrigger", ctx._getHostElement());
          }
        },
        directives: [_angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatRipple"]],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      MatMenuItem.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["DOCUMENT"]]
          }]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusMonitor"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_MENU_PANEL]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }]
        }];
      };
      MatMenuItem.propDecorators = {
        role: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        _checkDisabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["HostListener"],
          args: ['click', ['$event']]
        }],
        _handleMouseEnter: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["HostListener"],
          args: ['mouseenter']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatMenuItem, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Component"],
          args: [{
            selector: '[mat-menu-item]',
            exportAs: 'matMenuItem',
            inputs: ['disabled', 'disableRipple'],
            host: {
              '[attr.role]': 'role',
              '[class.mat-menu-item]': 'true',
              '[class.mat-menu-item-highlighted]': '_highlighted',
              '[class.mat-menu-item-submenu-trigger]': '_triggersSubmenu',
              '[attr.tabindex]': '_getTabIndex()',
              '[attr.aria-disabled]': 'disabled.toString()',
              '[attr.disabled]': 'disabled || null',
              'class': 'mat-focus-indicator'
            },
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectionStrategy"].OnPush,
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewEncapsulation"].None,
            template: "<ng-content></ng-content>\n<div class=\"mat-menu-ripple\" matRipple\n     [matRippleDisabled]=\"disableRipple || disabled\"\n     [matRippleTrigger]=\"_getHostElement()\">\n</div>\n"
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["DOCUMENT"]]
            }]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusMonitor"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_MENU_PANEL]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }]
          }];
        }, {
          role: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          _checkDisabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["HostListener"],
            args: ['click', ['$event']]
          }],
          _handleMouseEnter: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["HostListener"],
            args: ['mouseenter']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Default `mat-menu` options that can be overridden.
       * @record
       */
      function MatMenuDefaultOptions() {}
      if (false) {}
      /**
       * Injection token to be used to override the default options for `mat-menu`.
       * @type {?}
       */
      var MAT_MENU_DEFAULT_OPTIONS = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('mat-menu-default-options', {
        providedIn: 'root',
        factory: MAT_MENU_DEFAULT_OPTIONS_FACTORY
      });
      /**
       * \@docs-private
       * @return {?}
       */
      function MAT_MENU_DEFAULT_OPTIONS_FACTORY() {
        return {
          overlapTrigger: false,
          xPosition: 'after',
          yPosition: 'below',
          backdropClass: 'cdk-overlay-transparent-backdrop'
        };
      }
      /**
       * Start elevation for the menu panel.
       * \@docs-private
       * @type {?}
       */
      var MAT_MENU_BASE_ELEVATION = 4;
      /** @type {?} */
      var menuPanelUid = 0;
      /**
       * Base class with all of the `MatMenu` functionality.
       */
      // tslint:disable-next-line:class-name
      var _MatMenuBase = /*#__PURE__*/function () {
        /**
         * @param {?} _elementRef
         * @param {?} _ngZone
         * @param {?} _defaultOptions
         */
        function _MatMenuBase(_elementRef, _ngZone, _defaultOptions) {
          _classCallCheck(this, _MatMenuBase);
          this._elementRef = _elementRef;
          this._ngZone = _ngZone;
          this._defaultOptions = _defaultOptions;
          this._xPosition = this._defaultOptions.xPosition;
          this._yPosition = this._defaultOptions.yPosition;
          /**
           * Only the direct descendant menu items.
           */
          this._directDescendantItems = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["QueryList"]();
          /**
           * Subscription to tab events on the menu panel
           */
          this._tabSubscription = rxjs__WEBPACK_IMPORTED_MODULE_4__["Subscription"].EMPTY;
          /**
           * Config object to be passed into the menu's ngClass
           */
          this._classList = {};
          /**
           * Current state of the panel animation.
           */
          this._panelAnimationState = 'void';
          /**
           * Emits whenever an animation on the menu completes.
           */
          this._animationDone = new rxjs__WEBPACK_IMPORTED_MODULE_4__["Subject"]();
          /**
           * Class to be added to the backdrop element.
           */
          this.backdropClass = this._defaultOptions.backdropClass;
          this._overlapTrigger = this._defaultOptions.overlapTrigger;
          this._hasBackdrop = this._defaultOptions.hasBackdrop;
          /**
           * Event emitted when the menu is closed.
           */
          this.closed = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["EventEmitter"]();
          /**
           * Event emitted when the menu is closed.
           * @deprecated Switch to `closed` instead
           * \@breaking-change 8.0.0
           */
          this.close = this.closed;
          this.panelId = "mat-menu-panel-".concat(menuPanelUid++);
        }
        /**
         * Position of the menu in the X axis.
         * @return {?}
         */
        _createClass(_MatMenuBase, [{
          key: "xPosition",
          get: function get() {
            return this._xPosition;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            if (value !== 'before' && value !== 'after') {
              throwMatMenuInvalidPositionX();
            }
            this._xPosition = value;
            this.setPositionClasses();
          }
          /**
           * Position of the menu in the Y axis.
           * @return {?}
           */
        }, {
          key: "yPosition",
          get: function get() {
            return this._yPosition;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            if (value !== 'above' && value !== 'below') {
              throwMatMenuInvalidPositionY();
            }
            this._yPosition = value;
            this.setPositionClasses();
          }
          /**
           * Whether the menu should overlap its trigger.
           * @return {?}
           */
        }, {
          key: "overlapTrigger",
          get: function get() {
            return this._overlapTrigger;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._overlapTrigger = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_1__["coerceBooleanProperty"])(value);
          }
          /**
           * Whether the menu has a backdrop.
           * @return {?}
           */
        }, {
          key: "hasBackdrop",
          get: function get() {
            return this._hasBackdrop;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._hasBackdrop = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_1__["coerceBooleanProperty"])(value);
          }
          /**
           * This method takes classes set on the host mat-menu element and applies them on the
           * menu template that displays in the overlay container.  Otherwise, it's difficult
           * to style the containing menu from outside the component.
           * @param {?} classes list of class names
           * @return {?}
           */
        }, {
          key: "panelClass",
          set: function set(classes) {
            var _this2 = this;
            /** @type {?} */
            var previousPanelClass = this._previousPanelClass;
            if (previousPanelClass && previousPanelClass.length) {
              previousPanelClass.split(' ').forEach(
              /**
              * @param {?} className
              * @return {?}
              */
              function (className) {
                _this2._classList[className] = false;
              });
            }
            this._previousPanelClass = classes;
            if (classes && classes.length) {
              classes.split(' ').forEach(
              /**
              * @param {?} className
              * @return {?}
              */
              function (className) {
                _this2._classList[className] = true;
              });
              this._elementRef.nativeElement.className = '';
            }
          }
          /**
           * This method takes classes set on the host mat-menu element and applies them on the
           * menu template that displays in the overlay container.  Otherwise, it's difficult
           * to style the containing menu from outside the component.
           * @deprecated Use `panelClass` instead.
           * \@breaking-change 8.0.0
           * @return {?}
           */
        }, {
          key: "classList",
          get: function get() {
            return this.panelClass;
          }
          /**
           * @param {?} classes
           * @return {?}
           */,
          set: function set(classes) {
            this.panelClass = classes;
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnInit",
          value: function ngOnInit() {
            this.setPositionClasses();
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            var _this3 = this;
            this._updateDirectDescendants();
            this._keyManager = new _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusKeyManager"](this._directDescendantItems).withWrap().withTypeAhead();
            this._tabSubscription = this._keyManager.tabOut.subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this3.closed.emit('tab');
            });
            // If a user manually (programatically) focuses a menu item, we need to reflect that focus
            // change back to the key manager. Note that we don't need to unsubscribe here because _focused
            // is internal and we know that it gets completed on destroy.
            this._directDescendantItems.changes.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["startWith"])(this._directDescendantItems), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["switchMap"])(
            /**
            * @param {?} items
            * @return {?}
            */
            function (items) {
              return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["merge"]).apply(void 0, _toConsumableArray(items.map(
              /**
              * @param {?} item
              * @return {?}
              */
              function (item) {
                return item._focused;
              })));
            })).subscribe(
            /**
            * @param {?} focusedItem
            * @return {?}
            */
            function (focusedItem) {
              return _this3._keyManager.updateActiveItem(focusedItem);
            });
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._directDescendantItems.destroy();
            this._tabSubscription.unsubscribe();
            this.closed.complete();
          }
          /**
           * Stream that emits whenever the hovered menu item changes.
           * @return {?}
           */
        }, {
          key: "_hovered",
          value: function _hovered() {
            // Coerce the `changes` property because Angular types it as `Observable<any>`
            /** @type {?} */
            var itemChanges = /** @type {?} */this._directDescendantItems.changes;
            return (/** @type {?} */itemChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["startWith"])(this._directDescendantItems), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["switchMap"])(
              /**
              * @param {?} items
              * @return {?}
              */
              function (items) {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["merge"]).apply(void 0, _toConsumableArray(items.map(
                /**
                * @param {?} item
                * @return {?}
                */
                function (item) {
                  return item._hovered;
                })));
              }))
            );
          }
          /*
             * Registers a menu item with the menu.
             * @docs-private
             * @deprecated No longer being used. To be removed.
             * @breaking-change 9.0.0
             */
          /**
           * @param {?} _item
           * @return {?}
           */
        }, {
          key: "addItem",
          value: function addItem(_item) {}
          /**
           * Removes an item from the menu.
           * \@docs-private
           * @deprecated No longer being used. To be removed.
           * \@breaking-change 9.0.0
           * @param {?} _item
           * @return {?}
           */
        }, {
          key: "removeItem",
          value: function removeItem(_item) {}
          /**
           * Handle a keyboard event from the menu, delegating to the appropriate action.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleKeydown",
          value: function _handleKeydown(event) {
            /** @type {?} */
            var keyCode = event.keyCode;
            /** @type {?} */
            var manager = this._keyManager;
            switch (keyCode) {
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["ESCAPE"]:
                if (!Object(_angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["hasModifierKey"])(event)) {
                  event.preventDefault();
                  this.closed.emit('keydown');
                }
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["LEFT_ARROW"]:
                if (this.parentMenu && this.direction === 'ltr') {
                  this.closed.emit('keydown');
                }
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["RIGHT_ARROW"]:
                if (this.parentMenu && this.direction === 'rtl') {
                  this.closed.emit('keydown');
                }
                break;
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["HOME"]:
              case _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["END"]:
                if (!Object(_angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["hasModifierKey"])(event)) {
                  keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["HOME"] ? manager.setFirstItemActive() : manager.setLastItemActive();
                  event.preventDefault();
                }
                break;
              default:
                if (keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["UP_ARROW"] || keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["DOWN_ARROW"]) {
                  manager.setFocusOrigin('keyboard');
                }
                manager.onKeydown(event);
            }
          }
          /**
           * Focus the first item in the menu.
           * @param {?=} origin Action from which the focus originated. Used to set the correct styling.
           * @return {?}
           */
        }, {
          key: "focusFirstItem",
          value: function focusFirstItem() {
            var _this4 = this;
            var origin = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'program';
            // When the content is rendered lazily, it takes a bit before the items are inside the DOM.
            if (this.lazyContent) {
              this._ngZone.onStable.asObservable().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["take"])(1)).subscribe(
              /**
              * @return {?}
              */
              function () {
                return _this4._focusFirstItem(origin);
              });
            } else {
              this._focusFirstItem(origin);
            }
          }
          /**
           * Actual implementation that focuses the first item. Needs to be separated
           * out so we don't repeat the same logic in the public `focusFirstItem` method.
           * @private
           * @param {?} origin
           * @return {?}
           */
        }, {
          key: "_focusFirstItem",
          value: function _focusFirstItem(origin) {
            /** @type {?} */
            var manager = this._keyManager;
            manager.setFocusOrigin(origin).setFirstItemActive();
            // If there's no active item at this point, it means that all the items are disabled.
            // Move focus to the menu panel so keyboard events like Escape still work. Also this will
            // give _some_ feedback to screen readers.
            if (!manager.activeItem && this._directDescendantItems.length) {
              /** @type {?} */
              var element = this._directDescendantItems.first._getHostElement().parentElement;
              // Because the `mat-menu` is at the DOM insertion point, not inside the overlay, we don't
              // have a nice way of getting a hold of the menu panel. We can't use a `ViewChild` either
              // because the panel is inside an `ng-template`. We work around it by starting from one of
              // the items and walking up the DOM.
              while (element) {
                if (element.getAttribute('role') === 'menu') {
                  element.focus();
                  break;
                } else {
                  element = element.parentElement;
                }
              }
            }
          }
          /**
           * Resets the active item in the menu. This is used when the menu is opened, allowing
           * the user to start from the first option when pressing the down arrow.
           * @return {?}
           */
        }, {
          key: "resetActiveItem",
          value: function resetActiveItem() {
            this._keyManager.setActiveItem(-1);
          }
          /**
           * Sets the menu panel elevation.
           * @param {?} depth Number of parent menus that come before the menu.
           * @return {?}
           */
        }, {
          key: "setElevation",
          value: function setElevation(depth) {
            // The elevation starts at the base and increases by one for each level.
            // Capped at 24 because that's the maximum elevation defined in the Material design spec.
            /** @type {?} */
            var elevation = Math.min(MAT_MENU_BASE_ELEVATION + depth, 24);
            /** @type {?} */
            var newElevation = "mat-elevation-z".concat(elevation);
            /** @type {?} */
            var customElevation = Object.keys(this._classList).find(
            /**
            * @param {?} c
            * @return {?}
            */
            function (c) {
              return c.startsWith('mat-elevation-z');
            });
            if (!customElevation || customElevation === this._previousElevation) {
              if (this._previousElevation) {
                this._classList[this._previousElevation] = false;
              }
              this._classList[newElevation] = true;
              this._previousElevation = newElevation;
            }
          }
          /**
           * Adds classes to the menu panel based on its position. Can be used by
           * consumers to add specific styling based on the position.
           * \@docs-private
           * @param {?=} posX Position of the menu along the x axis.
           * @param {?=} posY Position of the menu along the y axis.
           * @return {?}
           */
        }, {
          key: "setPositionClasses",
          value: function setPositionClasses() {
            var posX = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : this.xPosition;
            var posY = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : this.yPosition;
            /** @type {?} */
            var classes = this._classList;
            classes['mat-menu-before'] = posX === 'before';
            classes['mat-menu-after'] = posX === 'after';
            classes['mat-menu-above'] = posY === 'above';
            classes['mat-menu-below'] = posY === 'below';
          }
          /**
           * Starts the enter animation.
           * @return {?}
           */
        }, {
          key: "_startAnimation",
          value: function _startAnimation() {
            // @breaking-change 8.0.0 Combine with _resetAnimation.
            this._panelAnimationState = 'enter';
          }
          /**
           * Resets the panel animation to its initial state.
           * @return {?}
           */
        }, {
          key: "_resetAnimation",
          value: function _resetAnimation() {
            // @breaking-change 8.0.0 Combine with _startAnimation.
            this._panelAnimationState = 'void';
          }
          /**
           * Callback that is invoked when the panel animation completes.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onAnimationDone",
          value: function _onAnimationDone(event) {
            this._animationDone.next(event);
            this._isAnimating = false;
          }
          /**
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onAnimationStart",
          value: function _onAnimationStart(event) {
            this._isAnimating = true;
            // Scroll the content element to the top as soon as the animation starts. This is necessary,
            // because we move focus to the first item while it's still being animated, which can throw
            // the browser off when it determines the scroll position. Alternatively we can move focus
            // when the animation is done, however moving focus asynchronously will interrupt screen
            // readers which are in the process of reading out the menu already. We take the `element`
            // from the `event` since we can't use a `ViewChild` to access the pane.
            if (event.toState === 'enter' && this._keyManager.activeItemIndex === 0) {
              event.element.scrollTop = 0;
            }
          }
          /**
           * Sets up a stream that will keep track of any newly-added menu items and will update the list
           * of direct descendants. We collect the descendants this way, because `_allItems` can include
           * items that are part of child menus, and using a custom way of registering items is unreliable
           * when it comes to maintaining the item order.
           * @private
           * @return {?}
           */
        }, {
          key: "_updateDirectDescendants",
          value: function _updateDirectDescendants() {
            var _this5 = this;
            this._allItems.changes.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["startWith"])(this._allItems)).subscribe(
            /**
            * @param {?} items
            * @return {?}
            */
            function (items) {
              _this5._directDescendantItems.reset(items.filter(
              /**
              * @param {?} item
              * @return {?}
              */
              function (item) {
                return item._parentMenu === _this5;
              }));
              _this5._directDescendantItems.notifyOnChanges();
            });
          }
        }]);
        return _MatMenuBase;
      }();
      _MatMenuBase.ɵfac = function _MatMenuBase_Factory(t) {
        return new (t || _MatMenuBase)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_MENU_DEFAULT_OPTIONS));
      };
      _MatMenuBase.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineDirective"]({
        type: _MatMenuBase,
        contentQueries: function _MatMenuBase_ContentQueries(rf, ctx, dirIndex) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵcontentQuery"](dirIndex, MatMenuContent, true);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵcontentQuery"](dirIndex, MatMenuItem, true);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵcontentQuery"](dirIndex, MatMenuItem, false);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵloadQuery"]()) && (ctx.lazyContent = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵloadQuery"]()) && (ctx._allItems = _t);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵloadQuery"]()) && (ctx.items = _t);
          }
        },
        viewQuery: function _MatMenuBase_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵviewQuery"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵloadQuery"]()) && (ctx.templateRef = _t.first);
          }
        },
        inputs: {
          backdropClass: "backdropClass",
          xPosition: "xPosition",
          yPosition: "yPosition",
          overlapTrigger: "overlapTrigger",
          hasBackdrop: "hasBackdrop",
          panelClass: ["class", "panelClass"],
          classList: "classList",
          ariaLabel: ["aria-label", "ariaLabel"],
          ariaLabelledby: ["aria-labelledby", "ariaLabelledby"],
          ariaDescribedby: ["aria-describedby", "ariaDescribedby"]
        },
        outputs: {
          closed: "closed",
          close: "close"
        }
      });
      /** @nocollapse */
      _MatMenuBase.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_MENU_DEFAULT_OPTIONS]
          }]
        }];
      };
      _MatMenuBase.propDecorators = {
        _allItems: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ContentChildren"],
          args: [MatMenuItem, {
            descendants: true
          }]
        }],
        backdropClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        ariaLabel: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['aria-label']
        }],
        ariaLabelledby: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['aria-labelledby']
        }],
        ariaDescribedby: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['aria-describedby']
        }],
        xPosition: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        yPosition: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        templateRef: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewChild"],
          args: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"]]
        }],
        items: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ContentChildren"],
          args: [MatMenuItem, {
            descendants: false
          }]
        }],
        lazyContent: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ContentChild"],
          args: [MatMenuContent]
        }],
        overlapTrigger: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        hasBackdrop: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        panelClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['class']
        }],
        classList: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
        }],
        closed: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
        }],
        close: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](_MatMenuBase, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Directive"]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_MENU_DEFAULT_OPTIONS]
            }]
          }];
        }, {
          backdropClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          closed: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
          }],
          close: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
          }],
          xPosition: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          yPosition: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          overlapTrigger: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          hasBackdrop: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          panelClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['class']
          }],
          classList: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"]
          }],
          _allItems: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ContentChildren"],
            args: [MatMenuItem, {
              descendants: true
            }]
          }],
          ariaLabel: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['aria-label']
          }],
          ariaLabelledby: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['aria-labelledby']
          }],
          ariaDescribedby: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['aria-describedby']
          }],
          templateRef: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewChild"],
            args: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"]]
          }],
          items: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ContentChildren"],
            args: [MatMenuItem, {
              descendants: false
            }]
          }],
          lazyContent: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ContentChild"],
            args: [MatMenuContent]
          }]
        });
      })();
      if (false) {}
      /**
       * \@docs-private We show the "_MatMenu" class as "MatMenu" in the docs.
       */
      var MatMenu = /*#__PURE__*/function (_MatMenuBase2) {
        _inherits(MatMenu, _MatMenuBase2);
        var _super2 = _createSuper(MatMenu);
        function MatMenu() {
          _classCallCheck(this, MatMenu);
          return _super2.apply(this, arguments);
        }
        return _createClass(MatMenu);
      }(_MatMenuBase);
      MatMenu.ɵfac = function MatMenu_Factory(t) {
        return ɵMatMenu_BaseFactory(t || MatMenu);
      };
      MatMenu.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineDirective"]({
        type: MatMenu,
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵInheritDefinitionFeature"]]
      });
      var ɵMatMenu_BaseFactory = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵgetInheritedFactory"](MatMenu);
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatMenu, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Directive"]
        }], null, null);
      })();
      // Note on the weird inheritance setup: we need three classes, because the MDC-based menu has to
      // extend `MatMenu`, however keeping a reference to it will cause the inlined template and styles
      // to be retained as well. The MDC menu also has to provide itself as a `MatMenu` in order for
      // queries and DI to work correctly, while still not referencing the actual menu class.
      // Class responsibility is split up as follows:
      // * _MatMenuBase - provides all the functionality without any of the Angular metadata.
      // * MatMenu - keeps the same name symbol name as the current menu and
      // is used as a provider for DI and query purposes.
      // * _MatMenu - the actual menu component implementation with the Angular metadata that should
      // be tree shaken away for MDC.
      /**
       * \@docs-public MatMenu
       */
      // tslint:disable-next-line:class-name
      var _MatMenu = /*#__PURE__*/function (_MatMenu2) {
        _inherits(_MatMenu, _MatMenu2);
        var _super3 = _createSuper(_MatMenu);
        /**
         * @param {?} elementRef
         * @param {?} ngZone
         * @param {?} defaultOptions
         */
        function _MatMenu(elementRef, ngZone, defaultOptions) {
          _classCallCheck(this, _MatMenu);
          return _super3.call(this, elementRef, ngZone, defaultOptions);
        }
        return _createClass(_MatMenu);
      }(MatMenu);
      _MatMenu.ɵfac = function _MatMenu_Factory(t) {
        return new (t || _MatMenu)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_MENU_DEFAULT_OPTIONS));
      };
      _MatMenu.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
        type: _MatMenu,
        selectors: [["mat-menu"]],
        exportAs: ["matMenu"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵProvidersFeature"]([{
          provide: MAT_MENU_PANEL,
          useExisting: MatMenu
        }, {
          provide: MatMenu,
          useExisting: _MatMenu
        }]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵInheritDefinitionFeature"]],
        ngContentSelectors: _c1,
        decls: 1,
        vars: 0,
        consts: [["tabindex", "-1", "role", "menu", 1, "mat-menu-panel", 3, "id", "ngClass", "keydown", "click"], [1, "mat-menu-content"]],
        template: function _MatMenu_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵprojectionDef"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](0, _MatMenu_ng_template_0_Template, 3, 6, "ng-template");
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["NgClass"]],
        styles: [".mat-menu-panel{min-width:112px;max-width:280px;overflow:auto;-webkit-overflow-scrolling:touch;max-height:calc(100vh - 48px);border-radius:4px;outline:0;min-height:64px}.mat-menu-panel.ng-animating{pointer-events:none}.cdk-high-contrast-active .mat-menu-panel{outline:solid 1px}.mat-menu-content:not(:empty){padding-top:8px;padding-bottom:8px}.mat-menu-item{-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;display:block;line-height:48px;height:48px;padding:0 16px;text-align:left;text-decoration:none;max-width:100%;position:relative}.mat-menu-item::-moz-focus-inner{border:0}.mat-menu-item[disabled]{cursor:default}[dir=rtl] .mat-menu-item{text-align:right}.mat-menu-item .mat-icon{margin-right:16px;vertical-align:middle}.mat-menu-item .mat-icon svg{vertical-align:top}[dir=rtl] .mat-menu-item .mat-icon{margin-left:16px;margin-right:0}.mat-menu-item[disabled]{pointer-events:none}.cdk-high-contrast-active .mat-menu-item.cdk-program-focused,.cdk-high-contrast-active .mat-menu-item.cdk-keyboard-focused,.cdk-high-contrast-active .mat-menu-item-highlighted{outline:dotted 1px}.mat-menu-item-submenu-trigger{padding-right:32px}.mat-menu-item-submenu-trigger::after{width:0;height:0;border-style:solid;border-width:5px 0 5px 5px;border-color:transparent transparent transparent currentColor;content:\"\";display:inline-block;position:absolute;top:50%;right:16px;transform:translateY(-50%)}[dir=rtl] .mat-menu-item-submenu-trigger{padding-right:16px;padding-left:32px}[dir=rtl] .mat-menu-item-submenu-trigger::after{right:auto;left:16px;transform:rotateY(180deg) translateY(-50%)}button.mat-menu-item{width:100%}.mat-menu-item .mat-menu-ripple{top:0;left:0;right:0;bottom:0;position:absolute;pointer-events:none}\n"],
        encapsulation: 2,
        data: {
          animation: [matMenuAnimations.transformMenu, matMenuAnimations.fadeInItems]
        },
        changeDetection: 0
      });
      /** @nocollapse */
      _MatMenu.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_MENU_DEFAULT_OPTIONS]
          }]
        }];
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](_MatMenu, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Component"],
          args: [{
            selector: 'mat-menu',
            template: "<ng-template>\n  <div\n    class=\"mat-menu-panel\"\n    [id]=\"panelId\"\n    [ngClass]=\"_classList\"\n    (keydown)=\"_handleKeydown($event)\"\n    (click)=\"closed.emit('click')\"\n    [@transformMenu]=\"_panelAnimationState\"\n    (@transformMenu.start)=\"_onAnimationStart($event)\"\n    (@transformMenu.done)=\"_onAnimationDone($event)\"\n    tabindex=\"-1\"\n    role=\"menu\"\n    [attr.aria-label]=\"ariaLabel || null\"\n    [attr.aria-labelledby]=\"ariaLabelledby || null\"\n    [attr.aria-describedby]=\"ariaDescribedby || null\">\n    <div class=\"mat-menu-content\">\n      <ng-content></ng-content>\n    </div>\n  </div>\n</ng-template>\n",
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectionStrategy"].OnPush,
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewEncapsulation"].None,
            exportAs: 'matMenu',
            animations: [matMenuAnimations.transformMenu, matMenuAnimations.fadeInItems],
            providers: [{
              provide: MAT_MENU_PANEL,
              useExisting: MatMenu
            }, {
              provide: MatMenu,
              useExisting: _MatMenu
            }],
            styles: [".mat-menu-panel{min-width:112px;max-width:280px;overflow:auto;-webkit-overflow-scrolling:touch;max-height:calc(100vh - 48px);border-radius:4px;outline:0;min-height:64px}.mat-menu-panel.ng-animating{pointer-events:none}.cdk-high-contrast-active .mat-menu-panel{outline:solid 1px}.mat-menu-content:not(:empty){padding-top:8px;padding-bottom:8px}.mat-menu-item{-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;display:block;line-height:48px;height:48px;padding:0 16px;text-align:left;text-decoration:none;max-width:100%;position:relative}.mat-menu-item::-moz-focus-inner{border:0}.mat-menu-item[disabled]{cursor:default}[dir=rtl] .mat-menu-item{text-align:right}.mat-menu-item .mat-icon{margin-right:16px;vertical-align:middle}.mat-menu-item .mat-icon svg{vertical-align:top}[dir=rtl] .mat-menu-item .mat-icon{margin-left:16px;margin-right:0}.mat-menu-item[disabled]{pointer-events:none}.cdk-high-contrast-active .mat-menu-item.cdk-program-focused,.cdk-high-contrast-active .mat-menu-item.cdk-keyboard-focused,.cdk-high-contrast-active .mat-menu-item-highlighted{outline:dotted 1px}.mat-menu-item-submenu-trigger{padding-right:32px}.mat-menu-item-submenu-trigger::after{width:0;height:0;border-style:solid;border-width:5px 0 5px 5px;border-color:transparent transparent transparent currentColor;content:\"\";display:inline-block;position:absolute;top:50%;right:16px;transform:translateY(-50%)}[dir=rtl] .mat-menu-item-submenu-trigger{padding-right:16px;padding-left:32px}[dir=rtl] .mat-menu-item-submenu-trigger::after{right:auto;left:16px;transform:rotateY(180deg) translateY(-50%)}button.mat-menu-item{width:100%}.mat-menu-item .mat-menu-ripple{top:0;left:0;right:0;bottom:0;position:absolute;pointer-events:none}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_MENU_DEFAULT_OPTIONS]
            }]
          }];
        }, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-trigger.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that determines the scroll handling while the menu is open.
       * @type {?}
       */
      var MAT_MENU_SCROLL_STRATEGY = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('mat-menu-scroll-strategy');
      /**
       * \@docs-private
       * @param {?} overlay
       * @return {?}
       */
      function MAT_MENU_SCROLL_STRATEGY_FACTORY(overlay) {
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
      var MAT_MENU_SCROLL_STRATEGY_FACTORY_PROVIDER = {
        provide: MAT_MENU_SCROLL_STRATEGY,
        deps: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["Overlay"]],
        useFactory: MAT_MENU_SCROLL_STRATEGY_FACTORY
      };
      /**
       * Default top padding of the menu panel.
       * @type {?}
       */
      var MENU_PANEL_TOP_PADDING = 8;
      /**
       * Options for binding a passive event listener.
       * @type {?}
       */
      var passiveEventListenerOptions = Object(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_12__["normalizePassiveListenerOptions"])({
        passive: true
      });
      // TODO(andrewseguin): Remove the kebab versions in favor of camelCased attribute selectors
      /**
       * Directive applied to an element that should trigger a `mat-menu`.
       */
      var MatMenuTrigger = /*#__PURE__*/function () {
        /**
         * @param {?} _overlay
         * @param {?} _element
         * @param {?} _viewContainerRef
         * @param {?} scrollStrategy
         * @param {?} _parentMenu
         * @param {?} _menuItemInstance
         * @param {?} _dir
         * @param {?=} _focusMonitor
         */
        function MatMenuTrigger(_overlay, _element, _viewContainerRef, scrollStrategy, _parentMenu, _menuItemInstance, _dir, _focusMonitor) {
          var _this6 = this;
          _classCallCheck(this, MatMenuTrigger);
          this._overlay = _overlay;
          this._element = _element;
          this._viewContainerRef = _viewContainerRef;
          this._parentMenu = _parentMenu;
          this._menuItemInstance = _menuItemInstance;
          this._dir = _dir;
          this._focusMonitor = _focusMonitor;
          this._overlayRef = null;
          this._menuOpen = false;
          this._closingActionsSubscription = rxjs__WEBPACK_IMPORTED_MODULE_4__["Subscription"].EMPTY;
          this._hoverSubscription = rxjs__WEBPACK_IMPORTED_MODULE_4__["Subscription"].EMPTY;
          this._menuCloseSubscription = rxjs__WEBPACK_IMPORTED_MODULE_4__["Subscription"].EMPTY;
          /**
           * Handles touch start events on the trigger.
           * Needs to be an arrow function so we can easily use addEventListener and removeEventListener.
           */
          this._handleTouchStart =
          /**
          * @return {?}
          */
          function () {
            return _this6._openedBy = 'touch';
          };
          // Tracking input type is necessary so it's possible to only auto-focus
          // the first item of the list when the menu is opened via the keyboard
          this._openedBy = null;
          /**
           * Whether focus should be restored when the menu is closed.
           * Note that disabling this option can have accessibility implications
           * and it's up to you to manage focus, if you decide to turn it off.
           */
          this.restoreFocus = true;
          /**
           * Event emitted when the associated menu is opened.
           */
          this.menuOpened = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["EventEmitter"]();
          /**
           * Event emitted when the associated menu is opened.
           * @deprecated Switch to `menuOpened` instead
           * \@breaking-change 8.0.0
           */
          // tslint:disable-next-line:no-output-on-prefix
          this.onMenuOpen = this.menuOpened;
          /**
           * Event emitted when the associated menu is closed.
           */
          this.menuClosed = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["EventEmitter"]();
          /**
           * Event emitted when the associated menu is closed.
           * @deprecated Switch to `menuClosed` instead
           * \@breaking-change 8.0.0
           */
          // tslint:disable-next-line:no-output-on-prefix
          this.onMenuClose = this.menuClosed;
          _element.nativeElement.addEventListener('touchstart', this._handleTouchStart, passiveEventListenerOptions);
          if (_menuItemInstance) {
            _menuItemInstance._triggersSubmenu = this.triggersSubmenu();
          }
          this._scrollStrategy = scrollStrategy;
        }
        /**
         * @deprecated
         * \@breaking-change 8.0.0
         * @return {?}
         */
        _createClass(MatMenuTrigger, [{
          key: "_deprecatedMatMenuTriggerFor",
          get: function get() {
            return this.menu;
          }
          /**
           * @param {?} v
           * @return {?}
           */,
          set: function set(v) {
            this.menu = v;
          }
          /**
           * References the menu instance that the trigger is associated with.
           * @return {?}
           */
        }, {
          key: "menu",
          get: function get() {
            return this._menu;
          }
          /**
           * @param {?} menu
           * @return {?}
           */,
          set: function set(menu) {
            var _this7 = this;
            if (menu === this._menu) {
              return;
            }
            this._menu = menu;
            this._menuCloseSubscription.unsubscribe();
            if (menu) {
              this._menuCloseSubscription = menu.close.asObservable().subscribe(
              /**
              * @param {?} reason
              * @return {?}
              */
              function (reason) {
                _this7._destroyMenu();
                // If a click closed the menu, we should close the entire chain of nested menus.
                if ((reason === 'click' || reason === 'tab') && _this7._parentMenu) {
                  _this7._parentMenu.closed.emit(reason);
                }
              });
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            this._checkMenu();
            this._handleHover();
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this._overlayRef) {
              this._overlayRef.dispose();
              this._overlayRef = null;
            }
            this._element.nativeElement.removeEventListener('touchstart', this._handleTouchStart, passiveEventListenerOptions);
            this._menuCloseSubscription.unsubscribe();
            this._closingActionsSubscription.unsubscribe();
            this._hoverSubscription.unsubscribe();
          }
          /**
           * Whether the menu is open.
           * @return {?}
           */
        }, {
          key: "menuOpen",
          get: function get() {
            return this._menuOpen;
          }
          /**
           * The text direction of the containing app.
           * @return {?}
           */
        }, {
          key: "dir",
          get: function get() {
            return this._dir && this._dir.value === 'rtl' ? 'rtl' : 'ltr';
          }
          /**
           * Whether the menu triggers a sub-menu or a top-level one.
           * @return {?}
           */
        }, {
          key: "triggersSubmenu",
          value: function triggersSubmenu() {
            return !!(this._menuItemInstance && this._parentMenu);
          }
          /**
           * Toggles the menu between the open and closed states.
           * @return {?}
           */
        }, {
          key: "toggleMenu",
          value: function toggleMenu() {
            return this._menuOpen ? this.closeMenu() : this.openMenu();
          }
          /**
           * Opens the menu.
           * @return {?}
           */
        }, {
          key: "openMenu",
          value: function openMenu() {
            var _this8 = this;
            if (this._menuOpen) {
              return;
            }
            this._checkMenu();
            /** @type {?} */
            var overlayRef = this._createOverlay();
            /** @type {?} */
            var overlayConfig = overlayRef.getConfig();
            this._setPosition( /** @type {?} */overlayConfig.positionStrategy);
            overlayConfig.hasBackdrop = this.menu.hasBackdrop == null ? !this.triggersSubmenu() : this.menu.hasBackdrop;
            overlayRef.attach(this._getPortal());
            if (this.menu.lazyContent) {
              this.menu.lazyContent.attach(this.menuData);
            }
            this._closingActionsSubscription = this._menuClosingActions().subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this8.closeMenu();
            });
            this._initMenu();
            if (this.menu instanceof MatMenu) {
              this.menu._startAnimation();
            }
          }
          /**
           * Closes the menu.
           * @return {?}
           */
        }, {
          key: "closeMenu",
          value: function closeMenu() {
            this.menu.close.emit();
          }
          /**
           * Focuses the menu trigger.
           * @param {?=} origin Source of the menu trigger's focus.
           * @param {?=} options
           * @return {?}
           */
        }, {
          key: "focus",
          value: function focus() {
            var origin = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'program';
            var options = arguments.length > 1 ? arguments[1] : undefined;
            if (this._focusMonitor) {
              this._focusMonitor.focusVia(this._element, origin, options);
            } else {
              this._element.nativeElement.focus(options);
            }
          }
          /**
           * Closes the menu and does the necessary cleanup.
           * @private
           * @return {?}
           */
        }, {
          key: "_destroyMenu",
          value: function _destroyMenu() {
            var _this9 = this;
            if (!this._overlayRef || !this.menuOpen) {
              return;
            }
            /** @type {?} */
            var menu = this.menu;
            this._closingActionsSubscription.unsubscribe();
            this._overlayRef.detach();
            this._restoreFocus();
            if (menu instanceof MatMenu) {
              menu._resetAnimation();
              if (menu.lazyContent) {
                // Wait for the exit animation to finish before detaching the content.
                menu._animationDone.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["filter"])(
                /**
                * @param {?} event
                * @return {?}
                */
                function (event) {
                  return event.toState === 'void';
                }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["take"])(1),
                // Interrupt if the content got re-attached.
                Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeUntil"])(menu.lazyContent._attached)).subscribe({
                  next:
                  /**
                  * @return {?}
                  */
                  function next() {
                    return (/** @type {?} */menu.lazyContent.detach()
                    );
                  },
                  // No matter whether the content got re-attached, reset the menu.
                  complete:
                  /**
                  * @return {?}
                  */
                  function complete() {
                    return _this9._setIsMenuOpen(false);
                  }
                });
              } else {
                this._setIsMenuOpen(false);
              }
            } else {
              this._setIsMenuOpen(false);
              if (menu.lazyContent) {
                menu.lazyContent.detach();
              }
            }
          }
          /**
           * This method sets the menu state to open and focuses the first item if
           * the menu was opened via the keyboard.
           * @private
           * @return {?}
           */
        }, {
          key: "_initMenu",
          value: function _initMenu() {
            this.menu.parentMenu = this.triggersSubmenu() ? this._parentMenu : undefined;
            this.menu.direction = this.dir;
            this._setMenuElevation();
            this._setIsMenuOpen(true);
            this.menu.focusFirstItem(this._openedBy || 'program');
          }
          /**
           * Updates the menu elevation based on the amount of parent menus that it has.
           * @private
           * @return {?}
           */
        }, {
          key: "_setMenuElevation",
          value: function _setMenuElevation() {
            if (this.menu.setElevation) {
              /** @type {?} */
              var depth = 0;
              /** @type {?} */
              var parentMenu = this.menu.parentMenu;
              while (parentMenu) {
                depth++;
                parentMenu = parentMenu.parentMenu;
              }
              this.menu.setElevation(depth);
            }
          }
          /**
           * Restores focus to the element that was focused before the menu was open.
           * @private
           * @return {?}
           */
        }, {
          key: "_restoreFocus",
          value: function _restoreFocus() {
            // We should reset focus if the user is navigating using a keyboard or
            // if we have a top-level trigger which might cause focus to be lost
            // when clicking on the backdrop.
            if (this.restoreFocus) {
              if (!this._openedBy) {
                // Note that the focus style will show up both for `program` and
                // `keyboard` so we don't have to specify which one it is.
                this.focus();
              } else if (!this.triggersSubmenu()) {
                this.focus(this._openedBy);
              }
            }
            this._openedBy = null;
          }
          // set state rather than toggle to support triggers sharing a menu
          /**
           * @private
           * @param {?} isOpen
           * @return {?}
           */
        }, {
          key: "_setIsMenuOpen",
          value: function _setIsMenuOpen(isOpen) {
            this._menuOpen = isOpen;
            this._menuOpen ? this.menuOpened.emit() : this.menuClosed.emit();
            if (this.triggersSubmenu()) {
              this._menuItemInstance._highlighted = isOpen;
            }
          }
          /**
           * This method checks that a valid instance of MatMenu has been passed into
           * matMenuTriggerFor. If not, an exception is thrown.
           * @private
           * @return {?}
           */
        }, {
          key: "_checkMenu",
          value: function _checkMenu() {
            if (!this.menu) {
              throwMatMenuMissingError();
            }
          }
          /**
           * This method creates the overlay from the provided menu's template and saves its
           * OverlayRef so that it can be attached to the DOM when openMenu is called.
           * @private
           * @return {?}
           */
        }, {
          key: "_createOverlay",
          value: function _createOverlay() {
            if (!this._overlayRef) {
              /** @type {?} */
              var config = this._getOverlayConfig();
              this._subscribeToPositions( /** @type {?} */config.positionStrategy);
              this._overlayRef = this._overlay.create(config);
              // Consume the `keydownEvents` in order to prevent them from going to another overlay.
              // Ideally we'd also have our keyboard event logic in here, however doing so will
              // break anybody that may have implemented the `MatMenuPanel` themselves.
              this._overlayRef.keydownEvents().subscribe();
            }
            return this._overlayRef;
          }
          /**
           * This method builds the configuration object needed to create the overlay, the OverlayState.
           * @private
           * @return {?} OverlayConfig
           */
        }, {
          key: "_getOverlayConfig",
          value: function _getOverlayConfig() {
            return new _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["OverlayConfig"]({
              positionStrategy: this._overlay.position().flexibleConnectedTo(this._element).withLockedPosition().withTransformOriginOn('.mat-menu-panel, .mat-mdc-menu-panel'),
              backdropClass: this.menu.backdropClass || 'cdk-overlay-transparent-backdrop',
              scrollStrategy: this._scrollStrategy(),
              direction: this._dir
            });
          }
          /**
           * Listens to changes in the position of the overlay and sets the correct classes
           * on the menu based on the new position. This ensures the animation origin is always
           * correct, even if a fallback position is used for the overlay.
           * @private
           * @param {?} position
           * @return {?}
           */
        }, {
          key: "_subscribeToPositions",
          value: function _subscribeToPositions(position) {
            var _this10 = this;
            if (this.menu.setPositionClasses) {
              position.positionChanges.subscribe(
              /**
              * @param {?} change
              * @return {?}
              */
              function (change) {
                /** @type {?} */
                var posX = change.connectionPair.overlayX === 'start' ? 'after' : 'before';
                /** @type {?} */
                var posY = change.connectionPair.overlayY === 'top' ? 'below' : 'above';
                /** @type {?} */_this10.menu.setPositionClasses(posX, posY);
              });
            }
          }
          /**
           * Sets the appropriate positions on a position strategy
           * so the overlay connects with the trigger correctly.
           * @private
           * @param {?} positionStrategy Strategy whose position to update.
           * @return {?}
           */
        }, {
          key: "_setPosition",
          value: function _setPosition(positionStrategy) {
            var _ref = this.menu.xPosition === 'before' ? ['end', 'start'] : ['start', 'end'],
              _ref2 = _slicedToArray(_ref, 2),
              originX = _ref2[0],
              originFallbackX = _ref2[1];
            var _ref3 = this.menu.yPosition === 'above' ? ['bottom', 'top'] : ['top', 'bottom'],
              _ref4 = _slicedToArray(_ref3, 2),
              overlayY = _ref4[0],
              overlayFallbackY = _ref4[1];
            var originY = overlayY,
              originFallbackY = overlayFallbackY;
            var overlayX = originX,
              overlayFallbackX = originFallbackX;
            /** @type {?} */
            var offsetY = 0;
            if (this.triggersSubmenu()) {
              // When the menu is a sub-menu, it should always align itself
              // to the edges of the trigger, instead of overlapping it.
              overlayFallbackX = originX = this.menu.xPosition === 'before' ? 'start' : 'end';
              originFallbackX = overlayX = originX === 'end' ? 'start' : 'end';
              offsetY = overlayY === 'bottom' ? MENU_PANEL_TOP_PADDING : -MENU_PANEL_TOP_PADDING;
            } else if (!this.menu.overlapTrigger) {
              originY = overlayY === 'top' ? 'bottom' : 'top';
              originFallbackY = overlayFallbackY === 'top' ? 'bottom' : 'top';
            }
            positionStrategy.withPositions([{
              originX: originX,
              originY: originY,
              overlayX: overlayX,
              overlayY: overlayY,
              offsetY: offsetY
            }, {
              originX: originFallbackX,
              originY: originY,
              overlayX: overlayFallbackX,
              overlayY: overlayY,
              offsetY: offsetY
            }, {
              originX: originX,
              originY: originFallbackY,
              overlayX: overlayX,
              overlayY: overlayFallbackY,
              offsetY: -offsetY
            }, {
              originX: originFallbackX,
              originY: originFallbackY,
              overlayX: overlayFallbackX,
              overlayY: overlayFallbackY,
              offsetY: -offsetY
            }]);
          }
          /**
           * Returns a stream that emits whenever an action that should close the menu occurs.
           * @private
           * @return {?}
           */
        }, {
          key: "_menuClosingActions",
          value: function _menuClosingActions() {
            var _this11 = this;
            /** @type {?} */
            var backdrop = /** @type {?} */this._overlayRef.backdropClick();
            /** @type {?} */
            var detachments = /** @type {?} */this._overlayRef.detachments();
            /** @type {?} */
            var parentClose = this._parentMenu ? this._parentMenu.closed : Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["of"])();
            /** @type {?} */
            var hover = this._parentMenu ? this._parentMenu._hovered().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["filter"])(
            /**
            * @param {?} active
            * @return {?}
            */
            function (active) {
              return active !== _this11._menuItemInstance;
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["filter"])(
            /**
            * @return {?}
            */
            function () {
              return _this11._menuOpen;
            })) : Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["of"])();
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["merge"])(backdrop, parentClose, hover, detachments);
          }
          /**
           * Handles mouse presses on the trigger.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleMousedown",
          value: function _handleMousedown(event) {
            if (!Object(_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["isFakeMousedownFromScreenReader"])(event)) {
              // Since right or middle button clicks won't trigger the `click` event,
              // we shouldn't consider the menu as opened by mouse in those cases.
              this._openedBy = event.button === 0 ? 'mouse' : null;
              // Since clicking on the trigger won't close the menu if it opens a sub-menu,
              // we should prevent focus from moving onto it via click to avoid the
              // highlight from lingering on the menu item.
              if (this.triggersSubmenu()) {
                event.preventDefault();
              }
            }
          }
          /**
           * Handles key presses on the trigger.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleKeydown",
          value: function _handleKeydown(event) {
            /** @type {?} */
            var keyCode = event.keyCode;
            if (this.triggersSubmenu() && (keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["RIGHT_ARROW"] && this.dir === 'ltr' || keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_2__["LEFT_ARROW"] && this.dir === 'rtl')) {
              this.openMenu();
            }
          }
          /**
           * Handles click events on the trigger.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_handleClick",
          value: function _handleClick(event) {
            if (this.triggersSubmenu()) {
              // Stop event propagation to avoid closing the parent menu.
              event.stopPropagation();
              this.openMenu();
            } else {
              this.toggleMenu();
            }
          }
          /**
           * Handles the cases where the user hovers over the trigger.
           * @private
           * @return {?}
           */
        }, {
          key: "_handleHover",
          value: function _handleHover() {
            var _this12 = this;
            // Subscribe to changes in the hovered item in order to toggle the panel.
            if (!this.triggersSubmenu()) {
              return;
            }
            this._hoverSubscription = this._parentMenu._hovered()
            // Since we might have multiple competing triggers for the same menu (e.g. a sub-menu
            // with different data and triggers), we have to delay it by a tick to ensure that
            // it won't be closed immediately after it is opened.
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["filter"])(
            /**
            * @param {?} active
            * @return {?}
            */
            function (active) {
              return active === _this12._menuItemInstance && !active.disabled;
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["delay"])(0, rxjs__WEBPACK_IMPORTED_MODULE_4__["asapScheduler"])).subscribe(
            /**
            * @return {?}
            */
            function () {
              _this12._openedBy = 'mouse';
              // If the same menu is used between multiple triggers, it might still be animating
              // while the new trigger tries to re-open it. Wait for the animation to finish
              // before doing so. Also interrupt if the user moves to another item.
              if (_this12.menu instanceof MatMenu && _this12.menu._isAnimating) {
                // We need the `delay(0)` here in order to avoid
                // 'changed after checked' errors in some cases. See #12194.
                _this12.menu._animationDone.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["delay"])(0, rxjs__WEBPACK_IMPORTED_MODULE_4__["asapScheduler"]), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeUntil"])(_this12._parentMenu._hovered())).subscribe(
                /**
                * @return {?}
                */
                function () {
                  return _this12.openMenu();
                });
              } else {
                _this12.openMenu();
              }
            });
          }
          /**
           * Gets the portal that should be attached to the overlay.
           * @private
           * @return {?}
           */
        }, {
          key: "_getPortal",
          value: function _getPortal() {
            // Note that we can avoid this check by keeping the portal on the menu panel.
            // While it would be cleaner, we'd have to introduce another required method on
            // `MatMenuPanel`, making it harder to consume.
            if (!this._portal || this._portal.templateRef !== this.menu.templateRef) {
              this._portal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_7__["TemplatePortal"](this.menu.templateRef, this._viewContainerRef);
            }
            return this._portal;
          }
        }]);
        return MatMenuTrigger;
      }();
      MatMenuTrigger.ɵfac = function MatMenuTrigger_Factory(t) {
        return new (t || MatMenuTrigger)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["Overlay"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_MENU_SCROLL_STRATEGY), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MatMenu, 8), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MatMenuItem, 10), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusMonitor"]));
      };
      MatMenuTrigger.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineDirective"]({
        type: MatMenuTrigger,
        selectors: [["", "mat-menu-trigger-for", ""], ["", "matMenuTriggerFor", ""]],
        hostAttrs: ["aria-haspopup", "true", 1, "mat-menu-trigger"],
        hostVars: 2,
        hostBindings: function MatMenuTrigger_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("mousedown", function MatMenuTrigger_mousedown_HostBindingHandler($event) {
              return ctx._handleMousedown($event);
            })("keydown", function MatMenuTrigger_keydown_HostBindingHandler($event) {
              return ctx._handleKeydown($event);
            })("click", function MatMenuTrigger_click_HostBindingHandler($event) {
              return ctx._handleClick($event);
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵattribute"]("aria-expanded", ctx.menuOpen || null)("aria-controls", ctx.menuOpen ? ctx.menu.panelId : null);
          }
        },
        inputs: {
          restoreFocus: ["matMenuTriggerRestoreFocus", "restoreFocus"],
          _deprecatedMatMenuTriggerFor: ["mat-menu-trigger-for", "_deprecatedMatMenuTriggerFor"],
          menu: ["matMenuTriggerFor", "menu"],
          menuData: ["matMenuTriggerData", "menuData"]
        },
        outputs: {
          menuOpened: "menuOpened",
          onMenuOpen: "onMenuOpen",
          menuClosed: "menuClosed",
          onMenuClose: "onMenuClose"
        },
        exportAs: ["matMenuTrigger"]
      });
      /** @nocollapse */
      MatMenuTrigger.ctorParameters = function () {
        return [{
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["Overlay"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_MENU_SCROLL_STRATEGY]
          }]
        }, {
          type: MatMenu,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }]
        }, {
          type: MatMenuItem,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Self"]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusMonitor"]
        }];
      };
      MatMenuTrigger.propDecorators = {
        _deprecatedMatMenuTriggerFor: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['mat-menu-trigger-for']
        }],
        menu: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matMenuTriggerFor']
        }],
        menuData: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matMenuTriggerData']
        }],
        restoreFocus: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matMenuTriggerRestoreFocus']
        }],
        menuOpened: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
        }],
        onMenuOpen: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
        }],
        menuClosed: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
        }],
        onMenuClose: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatMenuTrigger, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Directive"],
          args: [{
            selector: "[mat-menu-trigger-for], [matMenuTriggerFor]",
            host: {
              'class': 'mat-menu-trigger',
              'aria-haspopup': 'true',
              '[attr.aria-expanded]': 'menuOpen || null',
              '[attr.aria-controls]': 'menuOpen ? menu.panelId : null',
              '(mousedown)': '_handleMousedown($event)',
              '(keydown)': '_handleKeydown($event)',
              '(click)': '_handleClick($event)'
            },
            exportAs: 'matMenuTrigger'
          }]
        }], function () {
          return [{
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["Overlay"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_MENU_SCROLL_STRATEGY]
            }]
          }, {
            type: MatMenu,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }]
          }, {
            type: MatMenuItem,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Self"]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_10__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_0__["FocusMonitor"]
          }];
        }, {
          restoreFocus: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matMenuTriggerRestoreFocus']
          }],
          menuOpened: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
          }],
          onMenuOpen: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
          }],
          menuClosed: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
          }],
          onMenuClose: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Output"]
          }],
          _deprecatedMatMenuTriggerFor: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['mat-menu-trigger-for']
          }],
          menu: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matMenuTriggerFor']
          }],
          menuData: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matMenuTriggerData']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Used by both the current `MatMenuModule` and the MDC `MatMenuModule`
       * to declare the menu-related directives.
       */
      // tslint:disable-next-line:class-name
      var _MatMenuDirectivesModule = /*#__PURE__*/_createClass(function _MatMenuDirectivesModule() {
        _classCallCheck(this, _MatMenuDirectivesModule);
      });
      _MatMenuDirectivesModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
        type: _MatMenuDirectivesModule
      });
      _MatMenuDirectivesModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
        factory: function _MatMenuDirectivesModule_Factory(t) {
          return new (t || _MatMenuDirectivesModule)();
        },
        providers: [MAT_MENU_SCROLL_STRATEGY_FACTORY_PROVIDER],
        imports: [_angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatCommonModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](_MatMenuDirectivesModule, {
          declarations: function declarations() {
            return [MatMenuTrigger, MatMenuContent];
          },
          exports: function exports() {
            return [MatMenuTrigger, MatMenuContent, _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatCommonModule"]];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](_MatMenuDirectivesModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"],
          args: [{
            exports: [MatMenuTrigger, MatMenuContent, _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatCommonModule"]],
            declarations: [MatMenuTrigger, MatMenuContent],
            providers: [MAT_MENU_SCROLL_STRATEGY_FACTORY_PROVIDER]
          }]
        }], null, null);
      })();
      var MatMenuModule = /*#__PURE__*/_createClass(function MatMenuModule() {
        _classCallCheck(this, MatMenuModule);
      });
      MatMenuModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
        type: MatMenuModule
      });
      MatMenuModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
        factory: function MatMenuModule_Factory(t) {
          return new (t || MatMenuModule)();
        },
        providers: [MAT_MENU_SCROLL_STRATEGY_FACTORY_PROVIDER],
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_8__["CommonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatCommonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatRippleModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["OverlayModule"], _MatMenuDirectivesModule], _MatMenuDirectivesModule]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](MatMenuModule, {
          declarations: function declarations() {
            return [_MatMenu, MatMenuItem];
          },
          imports: function imports() {
            return [_angular_common__WEBPACK_IMPORTED_MODULE_8__["CommonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatCommonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatRippleModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["OverlayModule"], _MatMenuDirectivesModule];
          },
          exports: function exports() {
            return [_MatMenu, MatMenuItem, _MatMenuDirectivesModule];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatMenuModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"],
          args: [{
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["CommonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatCommonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_9__["MatRippleModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_11__["OverlayModule"], _MatMenuDirectivesModule],
            exports: [_MatMenu, MatMenuItem, _MatMenuDirectivesModule],
            declarations: [_MatMenu, MatMenuItem],
            providers: [MAT_MENU_SCROLL_STRATEGY_FACTORY_PROVIDER]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/menu-positions.ts
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
       * @fileoverview added by tsickle
       * Generated from: src/material/menu/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=menu.js.map

      /***/
    },

    /***/"./src/app/navigation/menu/components/menu-icons-example.ts":
    /*!******************************************************************!*\
      !*** ./src/app/navigation/menu/components/menu-icons-example.ts ***!
      \******************************************************************/
    /*! exports provided: MenuIconsExample */
    /***/
    function srcAppNavigationMenuComponentsMenuIconsExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MenuIconsExample", function () {
        return MenuIconsExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/menu */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");

      /**
       * @title Menu with icons
       */
      var MenuIconsExample = /*#__PURE__*/_createClass(function MenuIconsExample() {
        _classCallCheck(this, MenuIconsExample);
      });
      MenuIconsExample.ɵfac = function MenuIconsExample_Factory(t) {
        return new (t || MenuIconsExample)();
      };
      MenuIconsExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: MenuIconsExample,
        selectors: [["menu-icons-example"]],
        decls: 26,
        vars: 2,
        consts: [[1, "example-h2"], ["id", "menu-with-icons-button", "mat-icon-button", "", "aria-label", "Example icon-button with a menu", 3, "matMenuTriggerFor"], ["menu", "matMenu"], ["mat-menu-item", "", 3, "click"], ["mat-menu-item", "", "disabled", "", 3, "click"], ["id", "icons-menu-selected-option"]],
        template: function MenuIconsExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Menu with icons");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "button", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-icon");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "more_vert");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-menu", null, 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MenuIconsExample_Template_button_click_7_listener() {
              return ctx.menuOptionSelected = "Redial";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-icon");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "dialpad");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Redial");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MenuIconsExample_Template_button_click_12_listener() {
              return ctx.menuOptionSelected = "voicemail";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-icon");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "voicemail");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "Check voice mail");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "button", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MenuIconsExample_Template_button_click_17_listener() {
              return ctx.menuOptionSelected = "notifications_off";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "mat-icon");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "notifications_off");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21, "Disable alerts");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, "Selected: ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "span", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            var _r468 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r468);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](23);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.menuOptionSelected);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["MatMenuTrigger"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_3__["MatIcon"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["_MatMenu"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["MatMenuItem"]],
        styles: [".mat-icon-button[_ngcontent-%COMP%] {\r\n  margin-bottom: 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbmF2aWdhdGlvbi9tZW51L2NvbXBvbmVudHMvbWVudS1pY29ucy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLG1CQUFtQjtBQUNyQiIsImZpbGUiOiJzcmMvYXBwL25hdmlnYXRpb24vbWVudS9jb21wb25lbnRzL21lbnUtaWNvbnMtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LWljb24tYnV0dG9uIHtcclxuICBtYXJnaW4tYm90dG9tOiAxMHB4O1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MenuIconsExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'menu-icons-example',
            templateUrl: 'menu-icons-example.html',
            styleUrls: ['menu-icons-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/menu/components/menu-overview-example.ts":
    /*!*********************************************************************!*\
      !*** ./src/app/navigation/menu/components/menu-overview-example.ts ***!
      \*********************************************************************/
    /*! exports provided: MenuOverviewExample */
    /***/
    function srcAppNavigationMenuComponentsMenuOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MenuOverviewExample", function () {
        return MenuOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/menu */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js");

      /**
       * @title Basic menu
       */
      var MenuOverviewExample = /*#__PURE__*/_createClass(function MenuOverviewExample() {
        _classCallCheck(this, MenuOverviewExample);
      });
      MenuOverviewExample.ɵfac = function MenuOverviewExample_Factory(t) {
        return new (t || MenuOverviewExample)();
      };
      MenuOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: MenuOverviewExample,
        selectors: [["menu-overview-example"]],
        decls: 15,
        vars: 2,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/menu/overview"], ["id", "basic-menu-button", "mat-button", "", 3, "matMenuTriggerFor"], ["menu", "matMenu"], ["mat-menu-item", "", 3, "click"], ["id", "basic-menu-selected-option"]],
        template: function MenuOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic menu ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Menu");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-menu", null, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MenuOverviewExample_Template_button_click_7_listener() {
              return ctx.menuOptionSelected = "Item 1";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Item 1");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MenuOverviewExample_Template_button_click_9_listener() {
              return ctx.menuOptionSelected = "Item 2";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Item 2");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "Selected: ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "span", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            var _r469 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r469);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.menuOptionSelected);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["MatMenuTrigger"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["_MatMenu"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["MatMenuItem"]],
        styles: [".mat-button[_ngcontent-%COMP%] {\r\n  margin-bottom: 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbmF2aWdhdGlvbi9tZW51L2NvbXBvbmVudHMvbWVudS1vdmVydmlldy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLG1CQUFtQjtBQUNyQiIsImZpbGUiOiJzcmMvYXBwL25hdmlnYXRpb24vbWVudS9jb21wb25lbnRzL21lbnUtb3ZlcnZpZXctZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LWJ1dHRvbiB7XHJcbiAgbWFyZ2luLWJvdHRvbTogMTBweDtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MenuOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'menu-overview-example',
            templateUrl: 'menu-overview-example.html',
            styleUrls: ['menu-overview-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/menu/components/nested-menu-example.ts":
    /*!*******************************************************************!*\
      !*** ./src/app/navigation/menu/components/nested-menu-example.ts ***!
      \*******************************************************************/
    /*! exports provided: NestedMenuExample */
    /***/
    function srcAppNavigationMenuComponentsNestedMenuExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "NestedMenuExample", function () {
        return NestedMenuExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/menu */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js");

      /**
       * @title Nested menu
       */
      var NestedMenuExample = /*#__PURE__*/_createClass(function NestedMenuExample() {
        _classCallCheck(this, NestedMenuExample);
      });
      NestedMenuExample.ɵfac = function NestedMenuExample_Factory(t) {
        return new (t || NestedMenuExample)();
      };
      NestedMenuExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: NestedMenuExample,
        selectors: [["nested-menu-example"]],
        decls: 77,
        vars: 7,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/menu/overview#nested-menu"], ["id", "nested-menu-button", "mat-button", "", 3, "matMenuTriggerFor"], ["animals", "matMenu"], ["mat-menu-item", "", 3, "matMenuTriggerFor", "click"], ["vertebrates", "matMenu"], ["mat-menu-item", "", 3, "click"], ["invertebrates", "matMenu"], ["fish", "matMenu"], ["amphibians", "matMenu"], ["reptiles", "matMenu"], ["mat-menu-item", "", "disabled", "", 3, "click"], ["id", "nested-menu-selected-option"]],
        template: function NestedMenuExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Nested menu ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Animal index");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-menu", null, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_7_listener() {
              return ctx.menuOptionSelected = "Vertebrates";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Vertebrates ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_9_listener() {
              return ctx.menuOptionSelected = "Invertebrates";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, " Invertebrates ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-menu", null, 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_13_listener() {
              return ctx.menuOptionSelected = "Fishes";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Fishes");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_15_listener() {
              return ctx.menuOptionSelected = "Amphibians";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "Amphibians");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_17_listener() {
              return ctx.menuOptionSelected = "Reptiles";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "Reptiles");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_19_listener() {
              return ctx.menuOptionSelected = "Birds";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "Birds");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_21_listener() {
              return ctx.menuOptionSelected = "Mammals";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22, "Mammals");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "mat-menu", null, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_25_listener() {
              return ctx.menuOptionSelected = "Insects";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "Insects");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_27_listener() {
              return ctx.menuOptionSelected = "Molluscs";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](28, "Molluscs");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_29_listener() {
              return ctx.menuOptionSelected = "Crustaceans";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](30, "Crustaceans");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_31_listener() {
              return ctx.menuOptionSelected = "Corals";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](32, "Corals");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_33_listener() {
              return ctx.menuOptionSelected = "Arachnids";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](34, "Arachnids");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_35_listener() {
              return ctx.menuOptionSelected = "Velvet worms";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](36, "Velvet worms");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_37_listener() {
              return ctx.menuOptionSelected = "Horseshoe crabs";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](38, "Horseshoe crabs");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](39, "mat-menu", null, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_41_listener() {
              return ctx.menuOptionSelected = "Baikal oilfish";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](42, "Baikal oilfish");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](43, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_43_listener() {
              return ctx.menuOptionSelected = "Bala shark";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](44, "Bala shark");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](45, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_45_listener() {
              return ctx.menuOptionSelected = "Ballan wrasse";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](46, "Ballan wrasse");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](47, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_47_listener() {
              return ctx.menuOptionSelected = "Bamboo shark";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](48, "Bamboo shark");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](49, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_49_listener() {
              return ctx.menuOptionSelected = "Banded killifish";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](50, "Banded killifish");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](51, "mat-menu", null, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](53, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_53_listener() {
              return ctx.menuOptionSelected = "Sonoran desert toad";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](54, "Sonoran desert toad");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](55, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_55_listener() {
              return ctx.menuOptionSelected = "Western toad";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](56, "Western toad");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](57, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_57_listener() {
              return ctx.menuOptionSelected = "Arroyo toad";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](58, "Arroyo toad");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](59, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_59_listener() {
              return ctx.menuOptionSelected = "Yosemite toad";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](60, "Yosemite toad");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](61, "mat-menu", null, 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](63, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_63_listener() {
              return ctx.menuOptionSelected = "Banded Day Gecko";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](64, "Banded Day Gecko");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](65, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_65_listener() {
              return ctx.menuOptionSelected = "Banded Gila Monster";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](66, "Banded Gila Monster");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](67, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_67_listener() {
              return ctx.menuOptionSelected = "Black Tree Monitor";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](68, "Black Tree Monitor");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](69, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_69_listener() {
              return ctx.menuOptionSelected = "Blue Spiny Lizard";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](70, "Blue Spiny Lizard");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](71, "button", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NestedMenuExample_Template_button_click_71_listener() {
              return ctx.menuOptionSelected = "Velociraptor";
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](72, "Velociraptor");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](73, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](74, "Selected: ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](75, "span", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](76);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            var _r470 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](6);
            var _r471 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](12);
            var _r472 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](24);
            var _r473 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](40);
            var _r474 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](52);
            var _r475 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](62);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r470);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r471);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r472);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r473);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r474);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matMenuTriggerFor", _r475);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](59);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.menuOptionSelected);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["MatMenuTrigger"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["_MatMenu"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_2__["MatMenuItem"]],
        styles: [".mat-button[_ngcontent-%COMP%] {\r\n  margin-bottom: 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbmF2aWdhdGlvbi9tZW51L2NvbXBvbmVudHMvbmVzdGVkLW1lbnUtZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxtQkFBbUI7QUFDckIiLCJmaWxlIjoic3JjL2FwcC9uYXZpZ2F0aW9uL21lbnUvY29tcG9uZW50cy9uZXN0ZWQtbWVudS1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5tYXQtYnV0dG9uIHtcclxuICBtYXJnaW4tYm90dG9tOiAxMHB4O1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](NestedMenuExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'nested-menu-example',
            templateUrl: 'nested-menu-example.html',
            styleUrls: ['nested-menu-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/menu/menu-routing.module.ts":
    /*!********************************************************!*\
      !*** ./src/app/navigation/menu/menu-routing.module.ts ***!
      \********************************************************/
    /*! exports provided: MenuRoutingModule */
    /***/
    function srcAppNavigationMenuMenuRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MenuRoutingModule", function () {
        return MenuRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _menu_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./menu.component */"./src/app/navigation/menu/menu.component.ts");
      var routes = [{
        path: '',
        component: _menu_component__WEBPACK_IMPORTED_MODULE_2__["MenuComponent"]
      }];
      var MenuRoutingModule = /*#__PURE__*/_createClass(function MenuRoutingModule() {
        _classCallCheck(this, MenuRoutingModule);
      });
      MenuRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: MenuRoutingModule
      });
      MenuRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function MenuRoutingModule_Factory(t) {
          return new (t || MenuRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](MenuRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MenuRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/menu/menu.component.ts":
    /*!***************************************************!*\
      !*** ./src/app/navigation/menu/menu.component.ts ***!
      \***************************************************/
    /*! exports provided: MenuComponent */
    /***/
    function srcAppNavigationMenuMenuComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MenuComponent", function () {
        return MenuComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_menu_icons_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/menu-icons-example */"./src/app/navigation/menu/components/menu-icons-example.ts");
      /* harmony import */
      var _components_menu_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/menu-overview-example */"./src/app/navigation/menu/components/menu-overview-example.ts");
      /* harmony import */
      var _components_nested_menu_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./components/nested-menu-example */"./src/app/navigation/menu/components/nested-menu-example.ts");
      var MenuComponent = /*#__PURE__*/_createClass(function MenuComponent() {
        _classCallCheck(this, MenuComponent);
      });
      MenuComponent.ɵfac = function MenuComponent_Factory(t) {
        return new (t || MenuComponent)();
      };
      MenuComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: MenuComponent,
        selectors: [["app-menu"]],
        decls: 3,
        vars: 0,
        template: function MenuComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "menu-icons-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "menu-overview-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "nested-menu-example");
          }
        },
        directives: [_components_menu_icons_example__WEBPACK_IMPORTED_MODULE_1__["MenuIconsExample"], _components_menu_overview_example__WEBPACK_IMPORTED_MODULE_2__["MenuOverviewExample"], _components_nested_menu_example__WEBPACK_IMPORTED_MODULE_3__["NestedMenuExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MenuComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-menu',
            templateUrl: './menu.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/menu/menu.module.ts":
    /*!************************************************!*\
      !*** ./src/app/navigation/menu/menu.module.ts ***!
      \************************************************/
    /*! exports provided: MenuModule */
    /***/
    function srcAppNavigationMenuMenuModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MenuModule", function () {
        return MenuModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _menu_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./menu-routing.module */"./src/app/navigation/menu/menu-routing.module.ts");
      /* harmony import */
      var _menu_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./menu.component */"./src/app/navigation/menu/menu.component.ts");
      /* harmony import */
      var _components_menu_icons_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/menu-icons-example */"./src/app/navigation/menu/components/menu-icons-example.ts");
      /* harmony import */
      var _components_menu_overview_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/menu-overview-example */"./src/app/navigation/menu/components/menu-overview-example.ts");
      /* harmony import */
      var _components_nested_menu_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./components/nested-menu-example */"./src/app/navigation/menu/components/nested-menu-example.ts");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      /* harmony import */
      var _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/material/menu */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      var MenuModule = /*#__PURE__*/_createClass(function MenuModule() {
        _classCallCheck(this, MenuModule);
      });
      MenuModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: MenuModule
      });
      MenuModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function MenuModule_Factory(t) {
          return new (t || MenuModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _menu_routing_module__WEBPACK_IMPORTED_MODULE_2__["MenuRoutingModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__["_MatMenuDirectivesModule"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__["MatMenuModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_9__["MatButtonModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](MenuModule, {
          declarations: [_menu_component__WEBPACK_IMPORTED_MODULE_3__["MenuComponent"], _components_menu_icons_example__WEBPACK_IMPORTED_MODULE_4__["MenuIconsExample"], _components_menu_overview_example__WEBPACK_IMPORTED_MODULE_5__["MenuOverviewExample"], _components_nested_menu_example__WEBPACK_IMPORTED_MODULE_6__["NestedMenuExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _menu_routing_module__WEBPACK_IMPORTED_MODULE_2__["MenuRoutingModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__["_MatMenuDirectivesModule"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__["MatMenuModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_9__["MatButtonModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MenuModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_menu_component__WEBPACK_IMPORTED_MODULE_3__["MenuComponent"], _components_menu_icons_example__WEBPACK_IMPORTED_MODULE_4__["MenuIconsExample"], _components_menu_overview_example__WEBPACK_IMPORTED_MODULE_5__["MenuOverviewExample"], _components_nested_menu_example__WEBPACK_IMPORTED_MODULE_6__["NestedMenuExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _menu_routing_module__WEBPACK_IMPORTED_MODULE_2__["MenuRoutingModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__["_MatMenuDirectivesModule"], _angular_material_menu__WEBPACK_IMPORTED_MODULE_8__["MatMenuModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_9__["MatButtonModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=navigation-menu-menu-module-es5.js.map