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
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["popups-and-modals-snackbar-snack-bar-module"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/snack-bar.js":
    /*!***************************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/snack-bar.js ***!
      \***************************************************************************/
    /*! exports provided: MAT_SNACK_BAR_DATA, MAT_SNACK_BAR_DEFAULT_OPTIONS, MAT_SNACK_BAR_DEFAULT_OPTIONS_FACTORY, MatSnackBar, MatSnackBarConfig, MatSnackBarContainer, MatSnackBarModule, MatSnackBarRef, SimpleSnackBar, matSnackBarAnimations */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015SnackBarJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_SNACK_BAR_DATA", function () {
        return MAT_SNACK_BAR_DATA;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_SNACK_BAR_DEFAULT_OPTIONS", function () {
        return MAT_SNACK_BAR_DEFAULT_OPTIONS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_SNACK_BAR_DEFAULT_OPTIONS_FACTORY", function () {
        return MAT_SNACK_BAR_DEFAULT_OPTIONS_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatSnackBar", function () {
        return MatSnackBar;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatSnackBarConfig", function () {
        return MatSnackBarConfig;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatSnackBarContainer", function () {
        return MatSnackBarContainer;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatSnackBarModule", function () {
        return MatSnackBarModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatSnackBarRef", function () {
        return MatSnackBarRef;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SimpleSnackBar", function () {
        return SimpleSnackBar;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "matSnackBarAnimations", function () {
        return matSnackBarAnimations;
      });
      /* harmony import */
      var _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/cdk/overlay */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/overlay.js");
      /* harmony import */
      var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/portal */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/portal.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/cdk/layout */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/layout.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/snack-bar-ref.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Event that is emitted when a snack bar is dismissed.
       * @record
       */

      function SimpleSnackBar_div_2_Template(rf, ctx) {
        if (rf & 1) {
          var _r36 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "div", 1);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "button", 2);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("click", function SimpleSnackBar_div_2_Template_button_click_1_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r36);
            var ctx_r35 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
            return ctx_r35.action();
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r34 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](ctx_r34.data.action);
        }
      }
      function MatSnackBarContainer_ng_template_0_Template(rf, ctx) {}
      function MatSnackBarDismiss() {}
      if (false) {}
      /**
       * Maximum amount of milliseconds that can be passed into setTimeout.
       * @type {?}
       */
      var MAX_TIMEOUT = Math.pow(2, 31) - 1;
      /**
       * Reference to a snack bar dispatched from the snack bar service.
       * @template T
       */
      var MatSnackBarRef = /*#__PURE__*/function () {
        /**
         * @param {?} containerInstance
         * @param {?} _overlayRef
         */
        function MatSnackBarRef(containerInstance, _overlayRef) {
          var _this = this;
          _classCallCheck(this, MatSnackBarRef);
          this._overlayRef = _overlayRef;
          /**
           * Subject for notifying the user that the snack bar has been dismissed.
           */
          this._afterDismissed = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Subject for notifying the user that the snack bar has opened and appeared.
           */
          this._afterOpened = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Subject for notifying the user that the snack bar action was called.
           */
          this._onAction = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Whether the snack bar was dismissed using the action button.
           */
          this._dismissedByAction = false;
          this.containerInstance = containerInstance;
          // Dismiss snackbar on action.
          this.onAction().subscribe(
          /**
          * @return {?}
          */
          function () {
            return _this.dismiss();
          });
          containerInstance._onExit.subscribe(
          /**
          * @return {?}
          */
          function () {
            return _this._finishDismiss();
          });
        }
        /**
         * Dismisses the snack bar.
         * @return {?}
         */
        _createClass(MatSnackBarRef, [{
          key: "dismiss",
          value: function dismiss() {
            if (!this._afterDismissed.closed) {
              this.containerInstance.exit();
            }
            clearTimeout(this._durationTimeoutId);
          }
          /**
           * Marks the snackbar action clicked.
           * @return {?}
           */
        }, {
          key: "dismissWithAction",
          value: function dismissWithAction() {
            if (!this._onAction.closed) {
              this._dismissedByAction = true;
              this._onAction.next();
              this._onAction.complete();
            }
          }
          /**
           * Marks the snackbar action clicked.
           * @deprecated Use `dismissWithAction` instead.
           * \@breaking-change 8.0.0
           * @return {?}
           */
        }, {
          key: "closeWithAction",
          value: function closeWithAction() {
            this.dismissWithAction();
          }
          /**
           * Dismisses the snack bar after some duration
           * @param {?} duration
           * @return {?}
           */
        }, {
          key: "_dismissAfter",
          value: function _dismissAfter(duration) {
            var _this2 = this;
            // Note that we need to cap the duration to the maximum value for setTimeout, because
            // it'll revert to 1 if somebody passes in something greater (e.g. `Infinity`). See #17234.
            this._durationTimeoutId = setTimeout(
            /**
            * @return {?}
            */
            function () {
              return _this2.dismiss();
            }, Math.min(duration, MAX_TIMEOUT));
          }
          /**
           * Marks the snackbar as opened
           * @return {?}
           */
        }, {
          key: "_open",
          value: function _open() {
            if (!this._afterOpened.closed) {
              this._afterOpened.next();
              this._afterOpened.complete();
            }
          }
          /**
           * Cleans up the DOM after closing.
           * @private
           * @return {?}
           */
        }, {
          key: "_finishDismiss",
          value: function _finishDismiss() {
            this._overlayRef.dispose();
            if (!this._onAction.closed) {
              this._onAction.complete();
            }
            this._afterDismissed.next({
              dismissedByAction: this._dismissedByAction
            });
            this._afterDismissed.complete();
            this._dismissedByAction = false;
          }
          /**
           * Gets an observable that is notified when the snack bar is finished closing.
           * @return {?}
           */
        }, {
          key: "afterDismissed",
          value: function afterDismissed() {
            return this._afterDismissed.asObservable();
          }
          /**
           * Gets an observable that is notified when the snack bar has opened and appeared.
           * @return {?}
           */
        }, {
          key: "afterOpened",
          value: function afterOpened() {
            return this.containerInstance._onEnter;
          }
          /**
           * Gets an observable that is notified when the snack bar action is called.
           * @return {?}
           */
        }, {
          key: "onAction",
          value: function onAction() {
            return this._onAction.asObservable();
          }
        }]);
        return MatSnackBarRef;
      }();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/snack-bar-config.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used to access the data that was passed in to a snack bar.
       * @type {?}
       */
      var MAT_SNACK_BAR_DATA = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('MatSnackBarData');
      /**
       * Configuration used when opening a snack-bar.
       * @template D
       */
      var MatSnackBarConfig = /*#__PURE__*/_createClass(function MatSnackBarConfig() {
        _classCallCheck(this, MatSnackBarConfig);
        /**
         * The politeness level for the MatAriaLiveAnnouncer announcement.
         */
        this.politeness = 'assertive';
        /**
         * Message to be announced by the LiveAnnouncer. When opening a snackbar without a custom
         * component or template, the announcement message will default to the specified message.
         */
        this.announcementMessage = '';
        /**
         * The length of time in milliseconds to wait before automatically dismissing the snack bar.
         */
        this.duration = 0;
        /**
         * Data being injected into the child component.
         */
        this.data = null;
        /**
         * The horizontal position to place the snack bar.
         */
        this.horizontalPosition = 'center';
        /**
         * The vertical position to place the snack bar.
         */
        this.verticalPosition = 'bottom';
      });
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/simple-snack-bar.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * A component used to open as the default snack bar, matching material spec.
       * This should only be used internally by the snack bar service.
       */
      var SimpleSnackBar = /*#__PURE__*/function () {
        /**
         * @param {?} snackBarRef
         * @param {?} data
         */
        function SimpleSnackBar(snackBarRef, data) {
          _classCallCheck(this, SimpleSnackBar);
          this.snackBarRef = snackBarRef;
          this.data = data;
        }
        /**
         * Performs the action on the snack bar.
         * @return {?}
         */
        _createClass(SimpleSnackBar, [{
          key: "action",
          value: function action() {
            this.snackBarRef.dismissWithAction();
          }
          /**
           * If the action button should be shown.
           * @return {?}
           */
        }, {
          key: "hasAction",
          get: function get() {
            return !!this.data.action;
          }
        }]);
        return SimpleSnackBar;
      }();
      SimpleSnackBar.ɵfac = function SimpleSnackBar_Factory(t) {
        return new (t || SimpleSnackBar)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MatSnackBarRef), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_SNACK_BAR_DATA));
      };
      SimpleSnackBar.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
        type: SimpleSnackBar,
        selectors: [["simple-snack-bar"]],
        hostAttrs: [1, "mat-simple-snackbar"],
        decls: 3,
        vars: 2,
        consts: [["class", "mat-simple-snackbar-action", 4, "ngIf"], [1, "mat-simple-snackbar-action"], ["mat-button", "", 3, "click"]],
        template: function SimpleSnackBar_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](2, SimpleSnackBar_div_2_Template, 3, 1, "div", 0);
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](ctx.data.message);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", ctx.hasAction);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["NgIf"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButton"]],
        styles: [".mat-simple-snackbar{display:flex;justify-content:space-between;align-items:center;line-height:20px;opacity:1}.mat-simple-snackbar-action{flex-shrink:0;margin:-8px -8px -8px 8px}.mat-simple-snackbar-action button{max-height:36px;min-width:0}[dir=rtl] .mat-simple-snackbar-action{margin-left:-8px;margin-right:8px}\n"],
        encapsulation: 2,
        changeDetection: 0
      });
      /** @nocollapse */
      SimpleSnackBar.ctorParameters = function () {
        return [{
          type: MatSnackBarRef
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_SNACK_BAR_DATA]
          }]
        }];
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](SimpleSnackBar, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Component"],
          args: [{
            selector: 'simple-snack-bar',
            template: "<span>{{data.message}}</span>\n<div class=\"mat-simple-snackbar-action\"  *ngIf=\"hasAction\">\n  <button mat-button (click)=\"action()\">{{data.action}}</button>\n</div>\n",
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectionStrategy"].OnPush,
            host: {
              'class': 'mat-simple-snackbar'
            },
            styles: [".mat-simple-snackbar{display:flex;justify-content:space-between;align-items:center;line-height:20px;opacity:1}.mat-simple-snackbar-action{flex-shrink:0;margin:-8px -8px -8px 8px}.mat-simple-snackbar-action button{max-height:36px;min-width:0}[dir=rtl] .mat-simple-snackbar-action{margin-left:-8px;margin-right:8px}\n"]
          }]
        }], function () {
          return [{
            type: MatSnackBarRef
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_SNACK_BAR_DATA]
            }]
          }];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/snack-bar-animations.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Animations used by the Material snack bar.
       * \@docs-private
       * @type {?}
       */
      var matSnackBarAnimations = {
        /**
         * Animation that shows and hides a snack bar.
         */
        snackBarState: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["trigger"])('state', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["state"])('void, hidden', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          transform: 'scale(0.8)',
          opacity: 0
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["state"])('visible', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          transform: 'scale(1)',
          opacity: 1
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["transition"])('* => visible', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["animate"])('150ms cubic-bezier(0, 0, 0.2, 1)')), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["transition"])('* => void, * => hidden', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["animate"])('75ms cubic-bezier(0.4, 0.0, 1, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          opacity: 0
        })))])
      };

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/snack-bar-container.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Internal component that wraps user-provided snack bar content.
       * \@docs-private
       */
      var MatSnackBarContainer = /*#__PURE__*/function (_angular_cdk_portal__) {
        _inherits(MatSnackBarContainer, _angular_cdk_portal__);
        var _super = _createSuper(MatSnackBarContainer);
        /**
         * @param {?} _ngZone
         * @param {?} _elementRef
         * @param {?} _changeDetectorRef
         * @param {?} snackBarConfig
         */
        function MatSnackBarContainer(_ngZone, _elementRef, _changeDetectorRef, snackBarConfig) {
          var _this3;
          _classCallCheck(this, MatSnackBarContainer);
          _this3 = _super.call(this);
          _this3._ngZone = _ngZone;
          _this3._elementRef = _elementRef;
          _this3._changeDetectorRef = _changeDetectorRef;
          _this3.snackBarConfig = snackBarConfig;
          /**
           * Whether the component has been destroyed.
           */
          _this3._destroyed = false;
          /**
           * Subject for notifying that the snack bar has exited from view.
           */
          _this3._onExit = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Subject for notifying that the snack bar has finished entering the view.
           */
          _this3._onEnter = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * The state of the snack bar animations.
           */
          _this3._animationState = 'void';
          /**
           * Attaches a DOM portal to the snack bar container.
           * @deprecated To be turned into a method.
           * \@breaking-change 10.0.0
           */
          _this3.attachDomPortal =
          /**
          * @param {?} portal
          * @return {?}
          */
          function (portal) {
            _this3._assertNotAttached();
            _this3._applySnackBarClasses();
            return _this3._portalOutlet.attachDomPortal(portal);
          };
          // Based on the ARIA spec, `alert` and `status` roles have an
          // implicit `assertive` and `polite` politeness respectively.
          if (snackBarConfig.politeness === 'assertive' && !snackBarConfig.announcementMessage) {
            _this3._role = 'alert';
          } else if (snackBarConfig.politeness === 'off') {
            _this3._role = null;
          } else {
            _this3._role = 'status';
          }
          return _this3;
        }
        /**
         * Attach a component portal as content to this snack bar container.
         * @template T
         * @param {?} portal
         * @return {?}
         */
        _createClass(MatSnackBarContainer, [{
          key: "attachComponentPortal",
          value: function attachComponentPortal(portal) {
            this._assertNotAttached();
            this._applySnackBarClasses();
            return this._portalOutlet.attachComponentPortal(portal);
          }
          /**
           * Attach a template portal as content to this snack bar container.
           * @template C
           * @param {?} portal
           * @return {?}
           */
        }, {
          key: "attachTemplatePortal",
          value: function attachTemplatePortal(portal) {
            this._assertNotAttached();
            this._applySnackBarClasses();
            return this._portalOutlet.attachTemplatePortal(portal);
          }
          /**
           * Handle end of animations, updating the state of the snackbar.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "onAnimationEnd",
          value: function onAnimationEnd(event) {
            var fromState = event.fromState,
              toState = event.toState;
            if (toState === 'void' && fromState !== 'void' || toState === 'hidden') {
              this._completeExit();
            }
            if (toState === 'visible') {
              // Note: we shouldn't use `this` inside the zone callback,
              // because it can cause a memory leak.
              /** @type {?} */
              var onEnter = this._onEnter;
              this._ngZone.run(
              /**
              * @return {?}
              */
              function () {
                onEnter.next();
                onEnter.complete();
              });
            }
          }
          /**
           * Begin animation of snack bar entrance into view.
           * @return {?}
           */
        }, {
          key: "enter",
          value: function enter() {
            if (!this._destroyed) {
              this._animationState = 'visible';
              this._changeDetectorRef.detectChanges();
            }
          }
          /**
           * Begin animation of the snack bar exiting from view.
           * @return {?}
           */
        }, {
          key: "exit",
          value: function exit() {
            // Note: this one transitions to `hidden`, rather than `void`, in order to handle the case
            // where multiple snack bars are opened in quick succession (e.g. two consecutive calls to
            // `MatSnackBar.open`).
            this._animationState = 'hidden';
            // Mark this element with an 'exit' attribute to indicate that the snackbar has
            // been dismissed and will soon be removed from the DOM. This is used by the snackbar
            // test harness.
            this._elementRef.nativeElement.setAttribute('mat-exit', '');
            return this._onExit;
          }
          /**
           * Makes sure the exit callbacks have been invoked when the element is destroyed.
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._destroyed = true;
            this._completeExit();
          }
          /**
           * Waits for the zone to settle before removing the element. Helps prevent
           * errors where we end up removing an element which is in the middle of an animation.
           * @private
           * @return {?}
           */
        }, {
          key: "_completeExit",
          value: function _completeExit() {
            var _this4 = this;
            this._ngZone.onMicrotaskEmpty.asObservable().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["take"])(1)).subscribe(
            /**
            * @return {?}
            */
            function () {
              _this4._onExit.next();
              _this4._onExit.complete();
            });
          }
          /**
           * Applies the various positioning and user-configured CSS classes to the snack bar.
           * @private
           * @return {?}
           */
        }, {
          key: "_applySnackBarClasses",
          value: function _applySnackBarClasses() {
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            /** @type {?} */
            var panelClasses = this.snackBarConfig.panelClass;
            if (panelClasses) {
              if (Array.isArray(panelClasses)) {
                // Note that we can't use a spread here, because IE doesn't support multiple arguments.
                panelClasses.forEach(
                /**
                * @param {?} cssClass
                * @return {?}
                */
                function (cssClass) {
                  return element.classList.add(cssClass);
                });
              } else {
                element.classList.add(panelClasses);
              }
            }
            if (this.snackBarConfig.horizontalPosition === 'center') {
              element.classList.add('mat-snack-bar-center');
            }
            if (this.snackBarConfig.verticalPosition === 'top') {
              element.classList.add('mat-snack-bar-top');
            }
          }
          /**
           * Asserts that no content is already attached to the container.
           * @private
           * @return {?}
           */
        }, {
          key: "_assertNotAttached",
          value: function _assertNotAttached() {
            if (this._portalOutlet.hasAttached()) {
              throw Error('Attempting to attach snack bar content after content is already attached');
            }
          }
        }]);
        return MatSnackBarContainer;
      }(_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["BasePortalOutlet"]);
      MatSnackBarContainer.ɵfac = function MatSnackBarContainer_Factory(t) {
        return new (t || MatSnackBarContainer)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MatSnackBarConfig));
      };
      MatSnackBarContainer.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
        type: MatSnackBarContainer,
        selectors: [["snack-bar-container"]],
        viewQuery: function MatSnackBarContainer_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵstaticViewQuery"](_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵloadQuery"]()) && (ctx._portalOutlet = _t.first);
          }
        },
        hostAttrs: [1, "mat-snack-bar-container"],
        hostVars: 2,
        hostBindings: function MatSnackBarContainer_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵcomponentHostSyntheticListener"]("@state.done", function MatSnackBarContainer_animation_state_done_HostBindingHandler($event) {
              return ctx.onAnimationEnd($event);
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵattribute"]("role", ctx._role);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵupdateSyntheticHostBinding"]("@state", ctx._animationState);
          }
        },
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵInheritDefinitionFeature"]],
        decls: 1,
        vars: 0,
        consts: [["cdkPortalOutlet", ""]],
        template: function MatSnackBarContainer_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](0, MatSnackBarContainer_ng_template_0_Template, 0, 0, "ng-template", 0);
          }
        },
        directives: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"]],
        styles: [".mat-snack-bar-container{border-radius:4px;box-sizing:border-box;display:block;margin:24px;max-width:33vw;min-width:344px;padding:14px 16px;min-height:48px;transform-origin:center}.cdk-high-contrast-active .mat-snack-bar-container{border:solid 1px}.mat-snack-bar-handset{width:100%}.mat-snack-bar-handset .mat-snack-bar-container{margin:8px;max-width:100%;min-width:0;width:100%}\n"],
        encapsulation: 2,
        data: {
          animation: [matSnackBarAnimations.snackBarState]
        }
      });
      /** @nocollapse */
      MatSnackBarContainer.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]
        }, {
          type: MatSnackBarConfig
        }];
      };
      MatSnackBarContainer.propDecorators = {
        _portalOutlet: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewChild"],
          args: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], {
            "static": true
          }]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatSnackBarContainer, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Component"],
          args: [{
            selector: 'snack-bar-container',
            template: "<ng-template cdkPortalOutlet></ng-template>\n",
            // In Ivy embedded views will be change detected from their declaration place, rather than
            // where they were stamped out. This means that we can't have the snack bar container be OnPush,
            // because it might cause snack bars that were opened from a template not to be out of date.
            // tslint:disable-next-line:validate-decorators
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectionStrategy"].Default,
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewEncapsulation"].None,
            animations: [matSnackBarAnimations.snackBarState],
            host: {
              '[attr.role]': '_role',
              'class': 'mat-snack-bar-container',
              '[@state]': '_animationState',
              '(@state.done)': 'onAnimationEnd($event)'
            },
            styles: [".mat-snack-bar-container{border-radius:4px;box-sizing:border-box;display:block;margin:24px;max-width:33vw;min-width:344px;padding:14px 16px;min-height:48px;transform-origin:center}.cdk-high-contrast-active .mat-snack-bar-container{border:solid 1px}.mat-snack-bar-handset{width:100%}.mat-snack-bar-handset .mat-snack-bar-container{margin:8px;max-width:100%;min-width:0;width:100%}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]
          }, {
            type: MatSnackBarConfig
          }];
        }, {
          _portalOutlet: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewChild"],
            args: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], {
              "static": true
            }]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/snack-bar-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var MatSnackBarModule = /*#__PURE__*/_createClass(function MatSnackBarModule() {
        _classCallCheck(this, MatSnackBarModule);
      });
      MatSnackBarModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
        type: MatSnackBarModule
      });
      MatSnackBarModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
        factory: function MatSnackBarModule_Factory(t) {
          return new (t || MatSnackBarModule)();
        },
        imports: [[_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButtonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](MatSnackBarModule, {
          declarations: function declarations() {
            return [MatSnackBarContainer, SimpleSnackBar];
          },
          imports: function imports() {
            return [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButtonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]];
          },
          exports: function exports() {
            return [MatSnackBarContainer, _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatSnackBarModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"],
          args: [{
            imports: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButtonModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]],
            exports: [MatSnackBarContainer, _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]],
            declarations: [MatSnackBarContainer, SimpleSnackBar],
            entryComponents: [MatSnackBarContainer, SimpleSnackBar]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/snack-bar.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used to specify default snack bar.
       * @type {?}
       */
      var MAT_SNACK_BAR_DEFAULT_OPTIONS = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('mat-snack-bar-default-options', {
        providedIn: 'root',
        factory: MAT_SNACK_BAR_DEFAULT_OPTIONS_FACTORY
      });
      /**
       * \@docs-private
       * @return {?}
       */
      function MAT_SNACK_BAR_DEFAULT_OPTIONS_FACTORY() {
        return new MatSnackBarConfig();
      }
      /**
       * Service to dispatch Material Design snack bar messages.
       */
      var MatSnackBar = /*#__PURE__*/function () {
        /**
         * @param {?} _overlay
         * @param {?} _live
         * @param {?} _injector
         * @param {?} _breakpointObserver
         * @param {?} _parentSnackBar
         * @param {?} _defaultConfig
         */
        function MatSnackBar(_overlay, _live, _injector, _breakpointObserver, _parentSnackBar, _defaultConfig) {
          _classCallCheck(this, MatSnackBar);
          this._overlay = _overlay;
          this._live = _live;
          this._injector = _injector;
          this._breakpointObserver = _breakpointObserver;
          this._parentSnackBar = _parentSnackBar;
          this._defaultConfig = _defaultConfig;
          /**
           * Reference to the current snack bar in the view *at this level* (in the Angular injector tree).
           * If there is a parent snack-bar service, all operations should delegate to that parent
           * via `_openedSnackBarRef`.
           */
          this._snackBarRefAtThisLevel = null;
        }
        /**
         * Reference to the currently opened snackbar at *any* level.
         * @return {?}
         */
        _createClass(MatSnackBar, [{
          key: "_openedSnackBarRef",
          get: function get() {
            /** @type {?} */
            var parent = this._parentSnackBar;
            return parent ? parent._openedSnackBarRef : this._snackBarRefAtThisLevel;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            if (this._parentSnackBar) {
              this._parentSnackBar._openedSnackBarRef = value;
            } else {
              this._snackBarRefAtThisLevel = value;
            }
          }
          /**
           * Creates and dispatches a snack bar with a custom component for the content, removing any
           * currently opened snack bars.
           *
           * @template T
           * @param {?} component Component to be instantiated.
           * @param {?=} config Extra configuration for the snack bar.
           * @return {?}
           */
        }, {
          key: "openFromComponent",
          value: function openFromComponent(component, config) {
            return (/** @type {?} */this._attach(component, config)
            );
          }
          /**
           * Creates and dispatches a snack bar with a custom template for the content, removing any
           * currently opened snack bars.
           *
           * @param {?} template Template to be instantiated.
           * @param {?=} config Extra configuration for the snack bar.
           * @return {?}
           */
        }, {
          key: "openFromTemplate",
          value: function openFromTemplate(template, config) {
            return this._attach(template, config);
          }
          /**
           * Opens a snackbar with a message and an optional action.
           * @param {?} message The message to show in the snackbar.
           * @param {?=} action The label for the snackbar action.
           * @param {?=} config Additional configuration options for the snackbar.
           * @return {?}
           */
        }, {
          key: "open",
          value: function open(message) {
            var action = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : '';
            var config = arguments.length > 2 ? arguments[2] : undefined;
            /** @type {?} */
            var _config = Object.assign(Object.assign({}, this._defaultConfig), config);
            // Since the user doesn't have access to the component, we can
            // override the data to pass in our own message and action.
            _config.data = {
              message: message,
              action: action
            };
            if (!_config.announcementMessage) {
              _config.announcementMessage = message;
            }
            return this.openFromComponent(SimpleSnackBar, _config);
          }
          /**
           * Dismisses the currently-visible snack bar.
           * @return {?}
           */
        }, {
          key: "dismiss",
          value: function dismiss() {
            if (this._openedSnackBarRef) {
              this._openedSnackBarRef.dismiss();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            // Only dismiss the snack bar at the current level on destroy.
            if (this._snackBarRefAtThisLevel) {
              this._snackBarRefAtThisLevel.dismiss();
            }
          }
          /**
           * Attaches the snack bar container component to the overlay.
           * @private
           * @param {?} overlayRef
           * @param {?} config
           * @return {?}
           */
        }, {
          key: "_attachSnackBarContainer",
          value: function _attachSnackBarContainer(overlayRef, config) {
            /** @type {?} */
            var userInjector = config && config.viewContainerRef && config.viewContainerRef.injector;
            /** @type {?} */
            var injector = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalInjector"](userInjector || this._injector, new WeakMap([[MatSnackBarConfig, config]]));
            /** @type {?} */
            var containerPortal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["ComponentPortal"](MatSnackBarContainer, config.viewContainerRef, injector);
            /** @type {?} */
            var containerRef = overlayRef.attach(containerPortal);
            containerRef.instance.snackBarConfig = config;
            return containerRef.instance;
          }
          /**
           * Places a new component or a template as the content of the snack bar container.
           * @private
           * @template T
           * @param {?} content
           * @param {?=} userConfig
           * @return {?}
           */
        }, {
          key: "_attach",
          value: function _attach(content, userConfig) {
            /** @type {?} */
            var config = Object.assign(Object.assign(Object.assign({}, new MatSnackBarConfig()), this._defaultConfig), userConfig);
            /** @type {?} */
            var overlayRef = this._createOverlay(config);
            /** @type {?} */
            var container = this._attachSnackBarContainer(overlayRef, config);
            /** @type {?} */
            var snackBarRef = new MatSnackBarRef(container, overlayRef);
            if (content instanceof _angular_core__WEBPACK_IMPORTED_MODULE_3__["TemplateRef"]) {
              /** @type {?} */
              var portal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["TemplatePortal"](content, /** @type {?} */null, /** @type {?} */{
                $implicit: config.data,
                snackBarRef: snackBarRef
              });
              snackBarRef.instance = container.attachTemplatePortal(portal);
            } else {
              /** @type {?} */
              var injector = this._createInjector(config, snackBarRef);
              /** @type {?} */
              var _portal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["ComponentPortal"](content, undefined, injector);
              /** @type {?} */
              var contentRef = container.attachComponentPortal(_portal);
              // We can't pass this via the injector, because the injector is created earlier.
              snackBarRef.instance = contentRef.instance;
            }
            // Subscribe to the breakpoint observer and attach the mat-snack-bar-handset class as
            // appropriate. This class is applied to the overlay element because the overlay must expand to
            // fill the width of the screen for full width snackbars.
            this._breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_10__["Breakpoints"].HandsetPortrait).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["takeUntil"])(overlayRef.detachments())).subscribe(
            /**
            * @param {?} state
            * @return {?}
            */
            function (state) {
              /** @type {?} */
              var classList = overlayRef.overlayElement.classList;
              /** @type {?} */
              var className = 'mat-snack-bar-handset';
              state.matches ? classList.add(className) : classList.remove(className);
            });
            this._animateSnackBar(snackBarRef, config);
            this._openedSnackBarRef = snackBarRef;
            return this._openedSnackBarRef;
          }
          /**
           * Animates the old snack bar out and the new one in.
           * @private
           * @param {?} snackBarRef
           * @param {?} config
           * @return {?}
           */
        }, {
          key: "_animateSnackBar",
          value: function _animateSnackBar(snackBarRef, config) {
            var _this5 = this;
            // When the snackbar is dismissed, clear the reference to it.
            snackBarRef.afterDismissed().subscribe(
            /**
            * @return {?}
            */
            function () {
              // Clear the snackbar ref if it hasn't already been replaced by a newer snackbar.
              if (_this5._openedSnackBarRef == snackBarRef) {
                _this5._openedSnackBarRef = null;
              }
              if (config.announcementMessage) {
                _this5._live.clear();
              }
            });
            if (this._openedSnackBarRef) {
              // If a snack bar is already in view, dismiss it and enter the
              // new snack bar after exit animation is complete.
              this._openedSnackBarRef.afterDismissed().subscribe(
              /**
              * @return {?}
              */
              function () {
                snackBarRef.containerInstance.enter();
              });
              this._openedSnackBarRef.dismiss();
            } else {
              // If no snack bar is in view, enter the new snack bar.
              snackBarRef.containerInstance.enter();
            }
            // If a dismiss timeout is provided, set up dismiss based on after the snackbar is opened.
            if (config.duration && config.duration > 0) {
              snackBarRef.afterOpened().subscribe(
              /**
              * @return {?}
              */
              function () {
                return snackBarRef._dismissAfter( /** @type {?} */config.duration);
              });
            }
            if (config.announcementMessage) {
              this._live.announce(config.announcementMessage, config.politeness);
            }
          }
          /**
           * Creates a new overlay and places it in the correct location.
           * @private
           * @param {?} config The user-specified snack bar config.
           * @return {?}
           */
        }, {
          key: "_createOverlay",
          value: function _createOverlay(config) {
            /** @type {?} */
            var overlayConfig = new _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayConfig"]();
            overlayConfig.direction = config.direction;
            /** @type {?} */
            var positionStrategy = this._overlay.position().global();
            // Set horizontal position.
            /** @type {?} */
            var isRtl = config.direction === 'rtl';
            /** @type {?} */
            var isLeft = config.horizontalPosition === 'left' || config.horizontalPosition === 'start' && !isRtl || config.horizontalPosition === 'end' && isRtl;
            /** @type {?} */
            var isRight = !isLeft && config.horizontalPosition !== 'center';
            if (isLeft) {
              positionStrategy.left('0');
            } else if (isRight) {
              positionStrategy.right('0');
            } else {
              positionStrategy.centerHorizontally();
            }
            // Set horizontal position.
            if (config.verticalPosition === 'top') {
              positionStrategy.top('0');
            } else {
              positionStrategy.bottom('0');
            }
            overlayConfig.positionStrategy = positionStrategy;
            return this._overlay.create(overlayConfig);
          }
          /**
           * Creates an injector to be used inside of a snack bar component.
           * @private
           * @template T
           * @param {?} config Config that was used to create the snack bar.
           * @param {?} snackBarRef Reference to the snack bar.
           * @return {?}
           */
        }, {
          key: "_createInjector",
          value: function _createInjector(config, snackBarRef) {
            /** @type {?} */
            var userInjector = config && config.viewContainerRef && config.viewContainerRef.injector;
            return new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalInjector"](userInjector || this._injector, new WeakMap([[MatSnackBarRef, snackBarRef], [MAT_SNACK_BAR_DATA, config.data]]));
          }
        }]);
        return MatSnackBar;
      }();
      MatSnackBar.ɵfac = function MatSnackBar_Factory(t) {
        return new (t || MatSnackBar)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["LiveAnnouncer"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["Injector"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_10__["BreakpointObserver"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](MatSnackBar, 12), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](MAT_SNACK_BAR_DEFAULT_OPTIONS));
      };
      /** @nocollapse */
      MatSnackBar.ctorParameters = function () {
        return [{
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["LiveAnnouncer"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Injector"]
        }, {
          type: _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_10__["BreakpointObserver"]
        }, {
          type: MatSnackBar,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["SkipSelf"]
          }]
        }, {
          type: MatSnackBarConfig,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_SNACK_BAR_DEFAULT_OPTIONS]
          }]
        }];
      };
      /** @nocollapse */
      MatSnackBar.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjectable"])({
        factory: function MatSnackBar_Factory() {
          return new MatSnackBar(Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"])(_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"])(_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["LiveAnnouncer"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"])(_angular_core__WEBPACK_IMPORTED_MODULE_3__["INJECTOR"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"])(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_10__["BreakpointObserver"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"])(MatSnackBar, 12), Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"])(MAT_SNACK_BAR_DEFAULT_OPTIONS));
        },
        token: MatSnackBar,
        providedIn: MatSnackBarModule
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatSnackBar, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Injectable"],
          args: [{
            providedIn: MatSnackBarModule
          }]
        }], function () {
          return [{
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["LiveAnnouncer"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Injector"]
          }, {
            type: _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_10__["BreakpointObserver"]
          }, {
            type: MatSnackBar,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["SkipSelf"]
            }]
          }, {
            type: MatSnackBarConfig,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_SNACK_BAR_DEFAULT_OPTIONS]
            }]
          }];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/snack-bar/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=snack-bar.js.map

      /***/
    },

    /***/"./src/app/popups-and-modals/snackbar/components/snack-bar-component-example.ts":
    /*!**************************************************************************************!*\
      !*** ./src/app/popups-and-modals/snackbar/components/snack-bar-component-example.ts ***!
      \**************************************************************************************/
    /*! exports provided: SnackBarComponentExample, PizzaPartyComponent */
    /***/
    function srcAppPopupsAndModalsSnackbarComponentsSnackBarComponentExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SnackBarComponentExample", function () {
        return SnackBarComponentExample;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "PizzaPartyComponent", function () {
        return PizzaPartyComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/snack-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/snack-bar.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");

      /**
       * @title Snack-bar with a custom component
       */
      var SnackBarComponentExample = /*#__PURE__*/function () {
        function SnackBarComponentExample(_snackBar) {
          _classCallCheck(this, SnackBarComponentExample);
          this._snackBar = _snackBar;
          this.durationInSeconds = 5;
        }
        _createClass(SnackBarComponentExample, [{
          key: "openSnackBar",
          value: function openSnackBar() {
            this._snackBar.openFromComponent(PizzaPartyComponent, {
              duration: this.durationInSeconds * 1000
            });
          }
        }]);
        return SnackBarComponentExample;
      }();
      SnackBarComponentExample.ɵfac = function SnackBarComponentExample_Factory(t) {
        return new (t || SnackBarComponentExample)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]));
      };
      SnackBarComponentExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SnackBarComponentExample,
        selectors: [["snack-bar-component-example"]],
        decls: 8,
        vars: 1,
        consts: [[1, "example-h2"], ["id", "snack-bar-custom-component-input", "type", "number", "matInput", "", 3, "ngModel", "ngModelChange"], ["mat-stroked-button", "", "id", "snack-bar-custom-component-button", "aria-label", "Show an example snack-bar", 3, "click"]],
        template: function SnackBarComponentExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Snack-bar with a custom component");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Snack bar duration (seconds)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "input", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function SnackBarComponentExample_Template_input_ngModelChange_5_listener($event) {
              return ctx.durationInSeconds = $event;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function SnackBarComponentExample_Template_button_click_6_listener() {
              return ctx.openSnackBar();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, " Pizza party\n");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.durationInSeconds);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NumberValueAccessor"], _angular_material_input__WEBPACK_IMPORTED_MODULE_4__["MatInput"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["NgModel"], _angular_material_button__WEBPACK_IMPORTED_MODULE_5__["MatButton"]],
        styles: [".mat-form-field[_ngcontent-%COMP%] {\r\n  margin-right: 8px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvc25hY2tiYXIvY29tcG9uZW50cy9zbmFjay1iYXItY29tcG9uZW50LWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsaUJBQWlCO0FBQ25CIiwiZmlsZSI6InNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvc25hY2tiYXIvY29tcG9uZW50cy9zbmFjay1iYXItY29tcG9uZW50LWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC1mb3JtLWZpZWxkIHtcclxuICBtYXJnaW4tcmlnaHQ6IDhweDtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SnackBarComponentExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'snack-bar-component-example',
            templateUrl: 'snack-bar-component-example.html',
            styleUrls: ['snack-bar-component-example.css']
          }]
        }], function () {
          return [{
            type: _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]
          }];
        }, null);
      })();
      var PizzaPartyComponent = /*#__PURE__*/_createClass(function PizzaPartyComponent() {
        _classCallCheck(this, PizzaPartyComponent);
      });
      PizzaPartyComponent.ɵfac = function PizzaPartyComponent_Factory(t) {
        return new (t || PizzaPartyComponent)();
      };
      PizzaPartyComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: PizzaPartyComponent,
        selectors: [["snack-bar-component-example-snack"]],
        hostAttrs: ["id", "snack-bar-custom-component"],
        decls: 2,
        vars: 0,
        consts: [[1, "example-pizza-party"]],
        template: function PizzaPartyComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Pizza party!!! \uD83C\uDF55\n");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        styles: [".example-pizza-party[_ngcontent-%COMP%] {\n      color: hotpink;\n    }"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](PizzaPartyComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'snack-bar-component-example-snack',
            templateUrl: 'snack-bar-component-example-snack.html',
            styles: ["\n    .example-pizza-party {\n      color: hotpink;\n    }\n  "],
            host: {
              id: "snack-bar-custom-component"
            }
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/popups-and-modals/snackbar/components/snack-bar-overview-example.ts":
    /*!*************************************************************************************!*\
      !*** ./src/app/popups-and-modals/snackbar/components/snack-bar-overview-example.ts ***!
      \*************************************************************************************/
    /*! exports provided: SnackBarOverviewExample */
    /***/
    function srcAppPopupsAndModalsSnackbarComponentsSnackBarOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SnackBarOverviewExample", function () {
        return SnackBarOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/snack-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/snack-bar.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");

      /**
       * @title Basic snack-bar
       */
      var SnackBarOverviewExample = /*#__PURE__*/function () {
        function SnackBarOverviewExample(_snackBar) {
          _classCallCheck(this, SnackBarOverviewExample);
          this._snackBar = _snackBar;
        }
        _createClass(SnackBarOverviewExample, [{
          key: "openSnackBar",
          value: function openSnackBar(message, action) {
            this._snackBar.open(message, action, {
              duration: 2000
            });
          }
        }]);
        return SnackBarOverviewExample;
      }();
      SnackBarOverviewExample.ɵfac = function SnackBarOverviewExample_Factory(t) {
        return new (t || SnackBarOverviewExample)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]));
      };
      SnackBarOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SnackBarOverviewExample,
        selectors: [["snack-bar-overview-example"]],
        decls: 15,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/snack-bar/overview"], ["matInput", "", "id", "snack-bar-message-input", "value", "Disco party!"], ["message", ""], ["matInput", "", "id", "snack-bar-action-input", "value", "Dance"], ["action", ""], ["mat-stroked-button", "", "id", "snack-bar-open-button", 3, "click"]],
        template: function SnackBarOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            var _r500 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic snack-bar ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Message");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "input", 2, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Action");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "input", 4, 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "button", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function SnackBarOverviewExample_Template_button_click_13_listener() {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r500);
              var _r498 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](7);
              var _r499 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](12);
              return ctx.openSnackBar(_r498.value, _r499.value);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Show snack-bar");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_3__["MatInput"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButton"]],
        styles: ["mat-form-field[_ngcontent-%COMP%] {\r\n  margin-right: 12px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvc25hY2tiYXIvY29tcG9uZW50cy9zbmFjay1iYXItb3ZlcnZpZXctZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxrQkFBa0I7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC9wb3B1cHMtYW5kLW1vZGFscy9zbmFja2Jhci9jb21wb25lbnRzL3NuYWNrLWJhci1vdmVydmlldy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIm1hdC1mb3JtLWZpZWxkIHtcclxuICBtYXJnaW4tcmlnaHQ6IDEycHg7XHJcbn1cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SnackBarOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'snack-bar-overview-example',
            templateUrl: 'snack-bar-overview-example.html',
            styleUrls: ['snack-bar-overview-example.css']
          }]
        }], function () {
          return [{
            type: _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]
          }];
        }, null);
      })();

      /***/
    },

    /***/"./src/app/popups-and-modals/snackbar/snack-bar-routing.module.ts":
    /*!************************************************************************!*\
      !*** ./src/app/popups-and-modals/snackbar/snack-bar-routing.module.ts ***!
      \************************************************************************/
    /*! exports provided: SnackBarRoutingModule */
    /***/
    function srcAppPopupsAndModalsSnackbarSnackBarRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SnackBarRoutingModule", function () {
        return SnackBarRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _snack_bar_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./snack-bar.component */"./src/app/popups-and-modals/snackbar/snack-bar.component.ts");
      var routes = [{
        path: '',
        component: _snack_bar_component__WEBPACK_IMPORTED_MODULE_2__["SnackBarComponent"]
      }];
      var SnackBarRoutingModule = /*#__PURE__*/_createClass(function SnackBarRoutingModule() {
        _classCallCheck(this, SnackBarRoutingModule);
      });
      SnackBarRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SnackBarRoutingModule
      });
      SnackBarRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SnackBarRoutingModule_Factory(t) {
          return new (t || SnackBarRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SnackBarRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SnackBarRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/popups-and-modals/snackbar/snack-bar.component.ts":
    /*!*******************************************************************!*\
      !*** ./src/app/popups-and-modals/snackbar/snack-bar.component.ts ***!
      \*******************************************************************/
    /*! exports provided: SnackBarComponent */
    /***/
    function srcAppPopupsAndModalsSnackbarSnackBarComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SnackBarComponent", function () {
        return SnackBarComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_snack_bar_component_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/snack-bar-component-example */"./src/app/popups-and-modals/snackbar/components/snack-bar-component-example.ts");
      /* harmony import */
      var _components_snack_bar_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/snack-bar-overview-example */"./src/app/popups-and-modals/snackbar/components/snack-bar-overview-example.ts");
      var SnackBarComponent = /*#__PURE__*/_createClass(function SnackBarComponent() {
        _classCallCheck(this, SnackBarComponent);
      });
      SnackBarComponent.ɵfac = function SnackBarComponent_Factory(t) {
        return new (t || SnackBarComponent)();
      };
      SnackBarComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SnackBarComponent,
        selectors: [["app-snack-bar"]],
        decls: 2,
        vars: 0,
        template: function SnackBarComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "snack-bar-component-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "snack-bar-overview-example");
          }
        },
        directives: [_components_snack_bar_component_example__WEBPACK_IMPORTED_MODULE_1__["SnackBarComponentExample"], _components_snack_bar_overview_example__WEBPACK_IMPORTED_MODULE_2__["SnackBarOverviewExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SnackBarComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-snack-bar',
            templateUrl: './snack-bar.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/popups-and-modals/snackbar/snack-bar.module.ts":
    /*!****************************************************************!*\
      !*** ./src/app/popups-and-modals/snackbar/snack-bar.module.ts ***!
      \****************************************************************/
    /*! exports provided: SnackBarModule */
    /***/
    function srcAppPopupsAndModalsSnackbarSnackBarModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SnackBarModule", function () {
        return SnackBarModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _snack_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./snack-bar-routing.module */"./src/app/popups-and-modals/snackbar/snack-bar-routing.module.ts");
      /* harmony import */
      var _snack_bar_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./snack-bar.component */"./src/app/popups-and-modals/snackbar/snack-bar.component.ts");
      /* harmony import */
      var _components_snack_bar_overview_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/snack-bar-overview-example */"./src/app/popups-and-modals/snackbar/components/snack-bar-overview-example.ts");
      /* harmony import */
      var _components_snack_bar_component_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/snack-bar-component-example */"./src/app/popups-and-modals/snackbar/components/snack-bar-component-example.ts");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/forms */"./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
      /* harmony import */
      var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/material/snack-bar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/snack-bar.js");
      var SnackBarModule = /*#__PURE__*/_createClass(function SnackBarModule() {
        _classCallCheck(this, SnackBarModule);
      });
      SnackBarModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SnackBarModule
      });
      SnackBarModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SnackBarModule_Factory(t) {
          return new (t || SnackBarModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _snack_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__["SnackBarRoutingModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_6__["MatFormFieldModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_8__["MatButtonModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"], _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_10__["MatSnackBarModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SnackBarModule, {
          declarations: [_snack_bar_component__WEBPACK_IMPORTED_MODULE_3__["SnackBarComponent"], _components_snack_bar_overview_example__WEBPACK_IMPORTED_MODULE_4__["SnackBarOverviewExample"], _components_snack_bar_component_example__WEBPACK_IMPORTED_MODULE_5__["SnackBarComponentExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _snack_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__["SnackBarRoutingModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_6__["MatFormFieldModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_8__["MatButtonModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"], _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_10__["MatSnackBarModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SnackBarModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_snack_bar_component__WEBPACK_IMPORTED_MODULE_3__["SnackBarComponent"], _components_snack_bar_overview_example__WEBPACK_IMPORTED_MODULE_4__["SnackBarOverviewExample"], _components_snack_bar_component_example__WEBPACK_IMPORTED_MODULE_5__["SnackBarComponentExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _snack_bar_routing_module__WEBPACK_IMPORTED_MODULE_2__["SnackBarRoutingModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_6__["MatFormFieldModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_8__["MatButtonModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"], _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_10__["MatSnackBarModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=popups-and-modals-snackbar-snack-bar-module-es5.js.map