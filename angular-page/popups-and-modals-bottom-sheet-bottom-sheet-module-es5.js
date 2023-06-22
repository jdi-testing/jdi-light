(function () {
  function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function"); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, writable: true, configurable: true } }); Object.defineProperty(subClass, "prototype", { writable: false }); if (superClass) _setPrototypeOf(subClass, superClass); }
  function _setPrototypeOf(o, p) { _setPrototypeOf = Object.setPrototypeOf ? Object.setPrototypeOf.bind() : function _setPrototypeOf(o, p) { o.__proto__ = p; return o; }; return _setPrototypeOf(o, p); }
  function _createSuper(Derived) { var hasNativeReflectConstruct = _isNativeReflectConstruct(); return function _createSuperInternal() { var Super = _getPrototypeOf(Derived), result; if (hasNativeReflectConstruct) { var NewTarget = _getPrototypeOf(this).constructor; result = Reflect.construct(Super, arguments, NewTarget); } else { result = Super.apply(this, arguments); } return _possibleConstructorReturn(this, result); }; }
  function _possibleConstructorReturn(self, call) { if (call && (typeof call === "object" || typeof call === "function")) { return call; } else if (call !== void 0) { throw new TypeError("Derived constructors may only return object or undefined"); } return _assertThisInitialized(self); }
  function _assertThisInitialized(self) { if (self === void 0) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return self; }
  function _isNativeReflectConstruct() { if (typeof Reflect === "undefined" || !Reflect.construct) return false; if (Reflect.construct.sham) return false; if (typeof Proxy === "function") return true; try { Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {})); return true; } catch (e) { return false; } }
  function _getPrototypeOf(o) { _getPrototypeOf = Object.setPrototypeOf ? Object.getPrototypeOf.bind() : function _getPrototypeOf(o) { return o.__proto__ || Object.getPrototypeOf(o); }; return _getPrototypeOf(o); }
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["popups-and-modals-bottom-sheet-bottom-sheet-module"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/bottom-sheet.js":
    /*!******************************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/bottom-sheet.js ***!
      \******************************************************************************/
    /*! exports provided: MAT_BOTTOM_SHEET_DATA, MAT_BOTTOM_SHEET_DEFAULT_OPTIONS, MatBottomSheet, MatBottomSheetConfig, MatBottomSheetContainer, MatBottomSheetModule, MatBottomSheetRef, matBottomSheetAnimations */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015BottomSheetJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_BOTTOM_SHEET_DATA", function () {
        return MAT_BOTTOM_SHEET_DATA;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_BOTTOM_SHEET_DEFAULT_OPTIONS", function () {
        return MAT_BOTTOM_SHEET_DEFAULT_OPTIONS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBottomSheet", function () {
        return MatBottomSheet;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBottomSheetConfig", function () {
        return MatBottomSheetConfig;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBottomSheetContainer", function () {
        return MatBottomSheetContainer;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBottomSheetModule", function () {
        return MatBottomSheetModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBottomSheetRef", function () {
        return MatBottomSheetRef;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "matBottomSheetAnimations", function () {
        return matBottomSheetAnimations;
      });
      /* harmony import */
      var _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/cdk/overlay */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/overlay.js");
      /* harmony import */
      var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/portal */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/portal.js");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/cdk/layout */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/layout.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/cdk/bidi */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/bidi.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/cdk/keycodes */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/keycodes.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/bottom-sheet-config.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used to access the data that was passed in to a bottom sheet.
       * @type {?}
       */

      function MatBottomSheetContainer_ng_template_0_Template(rf, ctx) {}
      var MAT_BOTTOM_SHEET_DATA = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["InjectionToken"]('MatBottomSheetData');
      /**
       * Configuration used when opening a bottom sheet.
       * @template D
       */
      var MatBottomSheetConfig = /*#__PURE__*/_createClass(function MatBottomSheetConfig() {
        _classCallCheck(this, MatBottomSheetConfig);
        /**
         * Data being injected into the child component.
         */
        this.data = null;
        /**
         * Whether the bottom sheet has a backdrop.
         */
        this.hasBackdrop = true;
        /**
         * Whether the user can use escape or clicking outside to close the bottom sheet.
         */
        this.disableClose = false;
        /**
         * Aria label to assign to the bottom sheet element.
         */
        this.ariaLabel = null;
        /**
         * Whether the bottom sheet should close when the user goes backwards/forwards in history.
         * Note that this usually doesn't include clicking on links (unless the user is using
         * the `HashLocationStrategy`).
         */
        this.closeOnNavigation = true;
        // Note that this is disabled by default, because while the a11y recommendations are to focus
        // the first focusable element, doing so prevents screen readers from reading out the
        // rest of the bottom sheet content.
        /**
         * Whether the bottom sheet should focus the first focusable element on open.
         */
        this.autoFocus = false;
        /**
         * Whether the bottom sheet should restore focus to the
         * previously-focused element, after it's closed.
         */
        this.restoreFocus = true;
      });
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/bottom-sheet-animations.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Animations used by the Material bottom sheet.
       * @type {?}
       */
      var matBottomSheetAnimations = {
        /**
         * Animation that shows and hides a bottom sheet.
         */
        bottomSheetState: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["trigger"])('state', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["state"])('void, hidden', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["style"])({
          transform: 'translateY(100%)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["state"])('visible', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["style"])({
          transform: 'translateY(0%)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["transition"])('visible => void, visible => hidden', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["animate"])("".concat(_angular_material_core__WEBPACK_IMPORTED_MODULE_3__["AnimationDurations"].COMPLEX, " ").concat(_angular_material_core__WEBPACK_IMPORTED_MODULE_3__["AnimationCurves"].ACCELERATION_CURVE))), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["transition"])('void => visible', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_5__["animate"])("".concat(_angular_material_core__WEBPACK_IMPORTED_MODULE_3__["AnimationDurations"].EXITING, " ").concat(_angular_material_core__WEBPACK_IMPORTED_MODULE_3__["AnimationCurves"].DECELERATION_CURVE)))])
      };

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/bottom-sheet-container.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      // TODO(crisbeto): consolidate some logic between this, MatDialog and MatSnackBar
      /**
       * Internal component that wraps user-provided bottom sheet content.
       * \@docs-private
       */
      var MatBottomSheetContainer = /*#__PURE__*/function (_angular_cdk_portal__) {
        _inherits(MatBottomSheetContainer, _angular_cdk_portal__);
        var _super = _createSuper(MatBottomSheetContainer);
        /**
         * @param {?} _elementRef
         * @param {?} _changeDetectorRef
         * @param {?} _focusTrapFactory
         * @param {?} breakpointObserver
         * @param {?} document
         * @param {?} bottomSheetConfig
         */
        function MatBottomSheetContainer(_elementRef, _changeDetectorRef, _focusTrapFactory, breakpointObserver, document, bottomSheetConfig) {
          var _this;
          _classCallCheck(this, MatBottomSheetContainer);
          _this = _super.call(this);
          _this._elementRef = _elementRef;
          _this._changeDetectorRef = _changeDetectorRef;
          _this._focusTrapFactory = _focusTrapFactory;
          _this.bottomSheetConfig = bottomSheetConfig;
          /**
           * The state of the bottom sheet animations.
           */
          _this._animationState = 'void';
          /**
           * Emits whenever the state of the animation changes.
           */
          _this._animationStateChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["EventEmitter"]();
          /**
           * Element that was focused before the bottom sheet was opened.
           */
          _this._elementFocusedBeforeOpened = null;
          /**
           * Attaches a DOM portal to the bottom sheet container.
           * @deprecated To be turned into a method.
           * \@breaking-change 10.0.0
           */
          _this.attachDomPortal =
          /**
          * @param {?} portal
          * @return {?}
          */
          function (portal) {
            _this._validatePortalAttached();
            _this._setPanelClass();
            _this._savePreviouslyFocusedElement();
            return _this._portalOutlet.attachDomPortal(portal);
          };
          _this._document = document;
          _this._breakpointSubscription = breakpointObserver.observe([_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["Breakpoints"].Medium, _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["Breakpoints"].Large, _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["Breakpoints"].XLarge]).subscribe(
          /**
          * @return {?}
          */
          function () {
            _this._toggleClass('mat-bottom-sheet-container-medium', breakpointObserver.isMatched(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["Breakpoints"].Medium));
            _this._toggleClass('mat-bottom-sheet-container-large', breakpointObserver.isMatched(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["Breakpoints"].Large));
            _this._toggleClass('mat-bottom-sheet-container-xlarge', breakpointObserver.isMatched(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["Breakpoints"].XLarge));
          });
          return _this;
        }
        /**
         * Attach a component portal as content to this bottom sheet container.
         * @template T
         * @param {?} portal
         * @return {?}
         */
        _createClass(MatBottomSheetContainer, [{
          key: "attachComponentPortal",
          value: function attachComponentPortal(portal) {
            this._validatePortalAttached();
            this._setPanelClass();
            this._savePreviouslyFocusedElement();
            return this._portalOutlet.attachComponentPortal(portal);
          }
          /**
           * Attach a template portal as content to this bottom sheet container.
           * @template C
           * @param {?} portal
           * @return {?}
           */
        }, {
          key: "attachTemplatePortal",
          value: function attachTemplatePortal(portal) {
            this._validatePortalAttached();
            this._setPanelClass();
            this._savePreviouslyFocusedElement();
            return this._portalOutlet.attachTemplatePortal(portal);
          }
          /**
           * Begin animation of bottom sheet entrance into view.
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
           * Begin animation of the bottom sheet exiting from view.
           * @return {?}
           */
        }, {
          key: "exit",
          value: function exit() {
            if (!this._destroyed) {
              this._animationState = 'hidden';
              this._changeDetectorRef.markForCheck();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._breakpointSubscription.unsubscribe();
            this._destroyed = true;
          }
          /**
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onAnimationDone",
          value: function _onAnimationDone(event) {
            if (event.toState === 'hidden') {
              this._restoreFocus();
            } else if (event.toState === 'visible') {
              this._trapFocus();
            }
            this._animationStateChanged.emit(event);
          }
          /**
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onAnimationStart",
          value: function _onAnimationStart(event) {
            this._animationStateChanged.emit(event);
          }
          /**
           * @private
           * @param {?} cssClass
           * @param {?} add
           * @return {?}
           */
        }, {
          key: "_toggleClass",
          value: function _toggleClass(cssClass, add) {
            /** @type {?} */
            var classList = this._elementRef.nativeElement.classList;
            add ? classList.add(cssClass) : classList.remove(cssClass);
          }
          /**
           * @private
           * @return {?}
           */
        }, {
          key: "_validatePortalAttached",
          value: function _validatePortalAttached() {
            if (this._portalOutlet.hasAttached()) {
              throw Error('Attempting to attach bottom sheet content after content is already attached');
            }
          }
          /**
           * @private
           * @return {?}
           */
        }, {
          key: "_setPanelClass",
          value: function _setPanelClass() {
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            /** @type {?} */
            var panelClass = this.bottomSheetConfig.panelClass;
            if (Array.isArray(panelClass)) {
              // Note that we can't use a spread here, because IE doesn't support multiple arguments.
              panelClass.forEach(
              /**
              * @param {?} cssClass
              * @return {?}
              */
              function (cssClass) {
                return element.classList.add(cssClass);
              });
            } else if (panelClass) {
              element.classList.add(panelClass);
            }
          }
          /**
           * Moves the focus inside the focus trap.
           * @private
           * @return {?}
           */
        }, {
          key: "_trapFocus",
          value: function _trapFocus() {
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            if (!this._focusTrap) {
              this._focusTrap = this._focusTrapFactory.create(element);
            }
            if (this.bottomSheetConfig.autoFocus) {
              this._focusTrap.focusInitialElementWhenReady();
            } else {
              /** @type {?} */
              var activeElement = this._document.activeElement;
              // Otherwise ensure that focus is on the container. It's possible that a different
              // component tried to move focus while the open animation was running. See:
              // https://github.com/angular/components/issues/16215. Note that we only want to do this
              // if the focus isn't inside the bottom sheet already, because it's possible that the
              // consumer turned off `autoFocus` in order to move focus themselves.
              if (activeElement !== element && !element.contains(activeElement)) {
                element.focus();
              }
            }
          }
          /**
           * Restores focus to the element that was focused before the bottom sheet was opened.
           * @private
           * @return {?}
           */
        }, {
          key: "_restoreFocus",
          value: function _restoreFocus() {
            /** @type {?} */
            var toFocus = this._elementFocusedBeforeOpened;
            // We need the extra check, because IE can set the `activeElement` to null in some cases.
            if (this.bottomSheetConfig.restoreFocus && toFocus && typeof toFocus.focus === 'function') {
              /** @type {?} */
              var activeElement = this._document.activeElement;
              /** @type {?} */
              var element = this._elementRef.nativeElement;
              // Make sure that focus is still inside the bottom sheet or is on the body (usually because a
              // non-focusable element like the backdrop was clicked) before moving it. It's possible that
              // the consumer moved it themselves before the animation was done, in which case we shouldn't
              // do anything.
              if (!activeElement || activeElement === this._document.body || activeElement === element || element.contains(activeElement)) {
                toFocus.focus();
              }
            }
            if (this._focusTrap) {
              this._focusTrap.destroy();
            }
          }
          /**
           * Saves a reference to the element that was focused before the bottom sheet was opened.
           * @private
           * @return {?}
           */
        }, {
          key: "_savePreviouslyFocusedElement",
          value: function _savePreviouslyFocusedElement() {
            var _this2 = this;
            this._elementFocusedBeforeOpened = /** @type {?} */this._document.activeElement;
            // The `focus` method isn't available during server-side rendering.
            if (this._elementRef.nativeElement.focus) {
              Promise.resolve().then(
              /**
              * @return {?}
              */
              function () {
                return _this2._elementRef.nativeElement.focus();
              });
            }
          }
        }]);
        return MatBottomSheetContainer;
      }(_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["BasePortalOutlet"]);
      MatBottomSheetContainer.ɵfac = function MatBottomSheetContainer_Factory(t) {
        return new (t || MatBottomSheetContainer)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_7__["FocusTrapFactory"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["BreakpointObserver"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_6__["DOCUMENT"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](MatBottomSheetConfig));
      };
      MatBottomSheetContainer.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
        type: MatBottomSheetContainer,
        selectors: [["mat-bottom-sheet-container"]],
        viewQuery: function MatBottomSheetContainer_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵstaticViewQuery"](_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵloadQuery"]()) && (ctx._portalOutlet = _t.first);
          }
        },
        hostAttrs: ["tabindex", "-1", "role", "dialog", "aria-modal", "true", 1, "mat-bottom-sheet-container"],
        hostVars: 2,
        hostBindings: function MatBottomSheetContainer_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵcomponentHostSyntheticListener"]("@state.start", function MatBottomSheetContainer_animation_state_start_HostBindingHandler($event) {
              return ctx._onAnimationStart($event);
            })("@state.done", function MatBottomSheetContainer_animation_state_done_HostBindingHandler($event) {
              return ctx._onAnimationDone($event);
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵattribute"]("aria-label", ctx.bottomSheetConfig == null ? null : ctx.bottomSheetConfig.ariaLabel);
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵupdateSyntheticHostBinding"]("@state", ctx._animationState);
          }
        },
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵInheritDefinitionFeature"]],
        decls: 1,
        vars: 0,
        consts: [["cdkPortalOutlet", ""]],
        template: function MatBottomSheetContainer_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](0, MatBottomSheetContainer_ng_template_0_Template, 0, 0, "ng-template", 0);
          }
        },
        directives: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"]],
        styles: [".mat-bottom-sheet-container{padding:8px 16px;min-width:100vw;box-sizing:border-box;display:block;outline:0;max-height:80vh;overflow:auto}.cdk-high-contrast-active .mat-bottom-sheet-container{outline:1px solid}.mat-bottom-sheet-container-xlarge,.mat-bottom-sheet-container-large,.mat-bottom-sheet-container-medium{border-top-left-radius:4px;border-top-right-radius:4px}.mat-bottom-sheet-container-medium{min-width:384px;max-width:calc(100vw - 128px)}.mat-bottom-sheet-container-large{min-width:512px;max-width:calc(100vw - 256px)}.mat-bottom-sheet-container-xlarge{min-width:576px;max-width:calc(100vw - 384px)}\n"],
        encapsulation: 2,
        data: {
          animation: [matBottomSheetAnimations.bottomSheetState]
        },
        changeDetection: 0
      });
      /** @nocollapse */
      MatBottomSheetContainer.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectorRef"]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_7__["FocusTrapFactory"]
        }, {
          type: _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["BreakpointObserver"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_6__["DOCUMENT"]]
          }]
        }, {
          type: MatBottomSheetConfig
        }];
      };
      MatBottomSheetContainer.propDecorators = {
        _portalOutlet: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ViewChild"],
          args: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], {
            "static": true
          }]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatBottomSheetContainer, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Component"],
          args: [{
            selector: 'mat-bottom-sheet-container',
            template: "<ng-template cdkPortalOutlet></ng-template>\r\n",
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectionStrategy"].OnPush,
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ViewEncapsulation"].None,
            animations: [matBottomSheetAnimations.bottomSheetState],
            host: {
              'class': 'mat-bottom-sheet-container',
              'tabindex': '-1',
              'role': 'dialog',
              'aria-modal': 'true',
              '[attr.aria-label]': 'bottomSheetConfig?.ariaLabel',
              '[@state]': '_animationState',
              '(@state.start)': '_onAnimationStart($event)',
              '(@state.done)': '_onAnimationDone($event)'
            },
            styles: [".mat-bottom-sheet-container{padding:8px 16px;min-width:100vw;box-sizing:border-box;display:block;outline:0;max-height:80vh;overflow:auto}.cdk-high-contrast-active .mat-bottom-sheet-container{outline:1px solid}.mat-bottom-sheet-container-xlarge,.mat-bottom-sheet-container-large,.mat-bottom-sheet-container-medium{border-top-left-radius:4px;border-top-right-radius:4px}.mat-bottom-sheet-container-medium{min-width:384px;max-width:calc(100vw - 128px)}.mat-bottom-sheet-container-large{min-width:512px;max-width:calc(100vw - 256px)}.mat-bottom-sheet-container-xlarge{min-width:576px;max-width:calc(100vw - 384px)}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectorRef"]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_7__["FocusTrapFactory"]
          }, {
            type: _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_4__["BreakpointObserver"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_6__["DOCUMENT"]]
            }]
          }, {
            type: MatBottomSheetConfig
          }];
        }, {
          _portalOutlet: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ViewChild"],
            args: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], {
              "static": true
            }]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/bottom-sheet-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var MatBottomSheetModule = /*#__PURE__*/_createClass(function MatBottomSheetModule() {
        _classCallCheck(this, MatBottomSheetModule);
      });
      MatBottomSheetModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
        type: MatBottomSheetModule
      });
      MatBottomSheetModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
        factory: function MatBottomSheetModule_Factory(t) {
          return new (t || MatBottomSheetModule)();
        },
        imports: [[_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"]], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](MatBottomSheetModule, {
          declarations: function declarations() {
            return [MatBottomSheetContainer];
          },
          imports: function imports() {
            return [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"]];
          },
          exports: function exports() {
            return [MatBottomSheetContainer, _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatBottomSheetModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"],
          args: [{
            imports: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"]],
            exports: [MatBottomSheetContainer, _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]],
            declarations: [MatBottomSheetContainer],
            entryComponents: [MatBottomSheetContainer]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/bottom-sheet-ref.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Reference to a bottom sheet dispatched from the bottom sheet service.
       * @template T, R
       */
      var MatBottomSheetRef = /*#__PURE__*/function () {
        /**
         * @param {?} containerInstance
         * @param {?} _overlayRef
         * @param {?=} _location
         */
        function MatBottomSheetRef(containerInstance, _overlayRef,
        // @breaking-change 8.0.0 `_location` parameter to be removed.
        _location) {
          var _this3 = this;
          _classCallCheck(this, MatBottomSheetRef);
          this._overlayRef = _overlayRef;
          /**
           * Subject for notifying the user that the bottom sheet has been dismissed.
           */
          this._afterDismissed = new rxjs__WEBPACK_IMPORTED_MODULE_9__["Subject"]();
          /**
           * Subject for notifying the user that the bottom sheet has opened and appeared.
           */
          this._afterOpened = new rxjs__WEBPACK_IMPORTED_MODULE_9__["Subject"]();
          this.containerInstance = containerInstance;
          this.disableClose = containerInstance.bottomSheetConfig.disableClose;
          // Emit when opening animation completes
          containerInstance._animationStateChanged.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["filter"])(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            return event.phaseName === 'done' && event.toState === 'visible';
          }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
          /**
          * @return {?}
          */
          function () {
            _this3._afterOpened.next();
            _this3._afterOpened.complete();
          });
          // Dispose overlay when closing animation is complete
          containerInstance._animationStateChanged.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["filter"])(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            return event.phaseName === 'done' && event.toState === 'hidden';
          }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
          /**
          * @return {?}
          */
          function () {
            clearTimeout(_this3._closeFallbackTimeout);
            _overlayRef.dispose();
          });
          _overlayRef.detachments().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
          /**
          * @return {?}
          */
          function () {
            _this3._afterDismissed.next(_this3._result);
            _this3._afterDismissed.complete();
          });
          Object(rxjs__WEBPACK_IMPORTED_MODULE_9__["merge"])(_overlayRef.backdropClick(), _overlayRef.keydownEvents().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["filter"])(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            return event.keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_10__["ESCAPE"];
          }))).subscribe(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            if (!_this3.disableClose && (event.type !== 'keydown' || !Object(_angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_10__["hasModifierKey"])( /** @type {?} */event))) {
              event.preventDefault();
              _this3.dismiss();
            }
          });
        }
        /**
         * Dismisses the bottom sheet.
         * @param {?=} result Data to be passed back to the bottom sheet opener.
         * @return {?}
         */
        _createClass(MatBottomSheetRef, [{
          key: "dismiss",
          value: function dismiss(result) {
            var _this4 = this;
            if (!this._afterDismissed.closed) {
              // Transition the backdrop in parallel to the bottom sheet.
              this.containerInstance._animationStateChanged.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["filter"])(
              /**
              * @param {?} event
              * @return {?}
              */
              function (event) {
                return event.phaseName === 'start';
              }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_11__["take"])(1)).subscribe(
              /**
              * @param {?} event
              * @return {?}
              */
              function (event) {
                // The logic that disposes of the overlay depends on the exit animation completing, however
                // it isn't guaranteed if the parent view is destroyed while it's running. Add a fallback
                // timeout which will clean everything up if the animation hasn't fired within the specified
                // amount of time plus 100ms. We don't need to run this outside the NgZone, because for the
                // vast majority of cases the timeout will have been cleared before it has fired.
                _this4._closeFallbackTimeout = setTimeout(
                /**
                * @return {?}
                */
                function () {
                  _this4._overlayRef.dispose();
                }, event.totalTime + 100);
                _this4._overlayRef.detachBackdrop();
              });
              this._result = result;
              this.containerInstance.exit();
            }
          }
          /**
           * Gets an observable that is notified when the bottom sheet is finished closing.
           * @return {?}
           */
        }, {
          key: "afterDismissed",
          value: function afterDismissed() {
            return this._afterDismissed.asObservable();
          }
          /**
           * Gets an observable that is notified when the bottom sheet has opened and appeared.
           * @return {?}
           */
        }, {
          key: "afterOpened",
          value: function afterOpened() {
            return this._afterOpened.asObservable();
          }
          /**
           * Gets an observable that emits when the overlay's backdrop has been clicked.
           * @return {?}
           */
        }, {
          key: "backdropClick",
          value: function backdropClick() {
            return this._overlayRef.backdropClick();
          }
          /**
           * Gets an observable that emits when keydown events are targeted on the overlay.
           * @return {?}
           */
        }, {
          key: "keydownEvents",
          value: function keydownEvents() {
            return this._overlayRef.keydownEvents();
          }
        }]);
        return MatBottomSheetRef;
      }();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/bottom-sheet.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used to specify default bottom sheet options.
       * @type {?}
       */
      var MAT_BOTTOM_SHEET_DEFAULT_OPTIONS = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["InjectionToken"]('mat-bottom-sheet-default-options');
      /**
       * Service to trigger Material Design bottom sheets.
       */
      var MatBottomSheet = /*#__PURE__*/function () {
        /**
         * @param {?} _overlay
         * @param {?} _injector
         * @param {?} _parentBottomSheet
         * @param {?=} _location
         * @param {?=} _defaultOptions
         */
        function MatBottomSheet(_overlay, _injector, _parentBottomSheet, _location, _defaultOptions) {
          _classCallCheck(this, MatBottomSheet);
          this._overlay = _overlay;
          this._injector = _injector;
          this._parentBottomSheet = _parentBottomSheet;
          this._location = _location;
          this._defaultOptions = _defaultOptions;
          this._bottomSheetRefAtThisLevel = null;
        }
        /**
         * Reference to the currently opened bottom sheet.
         * @return {?}
         */
        _createClass(MatBottomSheet, [{
          key: "_openedBottomSheetRef",
          get: function get() {
            /** @type {?} */
            var parent = this._parentBottomSheet;
            return parent ? parent._openedBottomSheetRef : this._bottomSheetRefAtThisLevel;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            if (this._parentBottomSheet) {
              this._parentBottomSheet._openedBottomSheetRef = value;
            } else {
              this._bottomSheetRefAtThisLevel = value;
            }
          }
          /**
           * @template T, D, R
           * @param {?} componentOrTemplateRef
           * @param {?=} config
           * @return {?}
           */
        }, {
          key: "open",
          value: function open(componentOrTemplateRef, config) {
            var _this5 = this;
            /** @type {?} */
            var _config = _applyConfigDefaults(this._defaultOptions || new MatBottomSheetConfig(), config);
            /** @type {?} */
            var overlayRef = this._createOverlay(_config);
            /** @type {?} */
            var container = this._attachContainer(overlayRef, _config);
            /** @type {?} */
            var ref = new MatBottomSheetRef(container, overlayRef, this._location);
            if (componentOrTemplateRef instanceof _angular_core__WEBPACK_IMPORTED_MODULE_2__["TemplateRef"]) {
              container.attachTemplatePortal(new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["TemplatePortal"](componentOrTemplateRef, /** @type {?} */null, /** @type {?} */{
                $implicit: _config.data,
                bottomSheetRef: ref
              }));
            } else {
              /** @type {?} */
              var portal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["ComponentPortal"](componentOrTemplateRef, undefined, this._createInjector(_config, ref));
              /** @type {?} */
              var contentRef = container.attachComponentPortal(portal);
              ref.instance = contentRef.instance;
            }
            // When the bottom sheet is dismissed, clear the reference to it.
            ref.afterDismissed().subscribe(
            /**
            * @return {?}
            */
            function () {
              // Clear the bottom sheet ref if it hasn't already been replaced by a newer one.
              if (_this5._openedBottomSheetRef == ref) {
                _this5._openedBottomSheetRef = null;
              }
            });
            if (this._openedBottomSheetRef) {
              // If a bottom sheet is already in view, dismiss it and enter the
              // new bottom sheet after exit animation is complete.
              this._openedBottomSheetRef.afterDismissed().subscribe(
              /**
              * @return {?}
              */
              function () {
                return ref.containerInstance.enter();
              });
              this._openedBottomSheetRef.dismiss();
            } else {
              // If no bottom sheet is in view, enter the new bottom sheet.
              ref.containerInstance.enter();
            }
            this._openedBottomSheetRef = ref;
            return ref;
          }
          /**
           * Dismisses the currently-visible bottom sheet.
           * @return {?}
           */
        }, {
          key: "dismiss",
          value: function dismiss() {
            if (this._openedBottomSheetRef) {
              this._openedBottomSheetRef.dismiss();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this._bottomSheetRefAtThisLevel) {
              this._bottomSheetRefAtThisLevel.dismiss();
            }
          }
          /**
           * Attaches the bottom sheet container component to the overlay.
           * @private
           * @param {?} overlayRef
           * @param {?} config
           * @return {?}
           */
        }, {
          key: "_attachContainer",
          value: function _attachContainer(overlayRef, config) {
            /** @type {?} */
            var userInjector = config && config.viewContainerRef && config.viewContainerRef.injector;
            /** @type {?} */
            var injector = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalInjector"](userInjector || this._injector, new WeakMap([[MatBottomSheetConfig, config]]));
            /** @type {?} */
            var containerPortal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["ComponentPortal"](MatBottomSheetContainer, config.viewContainerRef, injector);
            /** @type {?} */
            var containerRef = overlayRef.attach(containerPortal);
            return containerRef.instance;
          }
          /**
           * Creates a new overlay and places it in the correct location.
           * @private
           * @param {?} config The user-specified bottom sheet config.
           * @return {?}
           */
        }, {
          key: "_createOverlay",
          value: function _createOverlay(config) {
            /** @type {?} */
            var overlayConfig = new _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayConfig"]({
              direction: config.direction,
              hasBackdrop: config.hasBackdrop,
              disposeOnNavigation: config.closeOnNavigation,
              maxWidth: '100%',
              scrollStrategy: config.scrollStrategy || this._overlay.scrollStrategies.block(),
              positionStrategy: this._overlay.position().global().centerHorizontally().bottom('0')
            });
            if (config.backdropClass) {
              overlayConfig.backdropClass = config.backdropClass;
            }
            return this._overlay.create(overlayConfig);
          }
          /**
           * Creates an injector to be used inside of a bottom sheet component.
           * @private
           * @template T
           * @param {?} config Config that was used to create the bottom sheet.
           * @param {?} bottomSheetRef Reference to the bottom sheet.
           * @return {?}
           */
        }, {
          key: "_createInjector",
          value: function _createInjector(config, bottomSheetRef) {
            /** @type {?} */
            var userInjector = config && config.viewContainerRef && config.viewContainerRef.injector;
            /** @type {?} */
            var injectionTokens = new WeakMap([[MatBottomSheetRef, bottomSheetRef], [MAT_BOTTOM_SHEET_DATA, config.data]]);
            if (config.direction && (!userInjector || !userInjector.get(_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_8__["Directionality"], null))) {
              injectionTokens.set(_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_8__["Directionality"], {
                value: config.direction,
                change: Object(rxjs__WEBPACK_IMPORTED_MODULE_9__["of"])()
              });
            }
            return new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalInjector"](userInjector || this._injector, injectionTokens);
          }
        }]);
        return MatBottomSheet;
      }();
      MatBottomSheet.ɵfac = function MatBottomSheet_Factory(t) {
        return new (t || MatBottomSheet)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](MatBottomSheet, 12), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_common__WEBPACK_IMPORTED_MODULE_6__["Location"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](MAT_BOTTOM_SHEET_DEFAULT_OPTIONS, 8));
      };
      /** @nocollapse */
      MatBottomSheet.ctorParameters = function () {
        return [{
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"]
        }, {
          type: MatBottomSheet,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["SkipSelf"]
          }]
        }, {
          type: _angular_common__WEBPACK_IMPORTED_MODULE_6__["Location"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }]
        }, {
          type: MatBottomSheetConfig,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
            args: [MAT_BOTTOM_SHEET_DEFAULT_OPTIONS]
          }]
        }];
      };
      /** @nocollapse */
      MatBottomSheet.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjectable"])({
        factory: function MatBottomSheet_Factory() {
          return new MatBottomSheet(Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"])(_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"])(_angular_core__WEBPACK_IMPORTED_MODULE_2__["INJECTOR"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"])(MatBottomSheet, 12), Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"])(_angular_common__WEBPACK_IMPORTED_MODULE_6__["Location"], 8), Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"])(MAT_BOTTOM_SHEET_DEFAULT_OPTIONS, 8));
        },
        token: MatBottomSheet,
        providedIn: MatBottomSheetModule
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatBottomSheet, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"],
          args: [{
            providedIn: MatBottomSheetModule
          }]
        }], function () {
          return [{
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"]
          }, {
            type: MatBottomSheet,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["SkipSelf"]
            }]
          }, {
            type: _angular_common__WEBPACK_IMPORTED_MODULE_6__["Location"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }]
          }, {
            type: MatBottomSheetConfig,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
              args: [MAT_BOTTOM_SHEET_DEFAULT_OPTIONS]
            }]
          }];
        }, null);
      })();
      if (false) {}
      /**
       * Applies default options to the bottom sheet config.
       * @param {?} defaults Object containing the default values to which to fall back.
       * @param {?=} config The configuration to which the defaults will be applied.
       * @return {?} The new configuration object with defaults applied.
       */
      function _applyConfigDefaults(defaults, config) {
        return Object.assign(Object.assign({}, defaults), config);
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/bottom-sheet/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=bottom-sheet.js.map

      /***/
    },

    /***/"./src/app/popups-and-modals/bottom-sheet/bottom-sheet-overview-example.ts":
    /*!*********************************************************************************!*\
      !*** ./src/app/popups-and-modals/bottom-sheet/bottom-sheet-overview-example.ts ***!
      \*********************************************************************************/
    /*! exports provided: BottomSheetOverviewExample, BottomSheetOverviewExampleSheet */
    /***/
    function srcAppPopupsAndModalsBottomSheetBottomSheetOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BottomSheetOverviewExample", function () {
        return BottomSheetOverviewExample;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BottomSheetOverviewExampleSheet", function () {
        return BottomSheetOverviewExampleSheet;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/bottom-sheet */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/bottom-sheet.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");

      /**
       * @title Bottom Sheet Overview
       */
      var BottomSheetOverviewExample = /*#__PURE__*/function () {
        function BottomSheetOverviewExample(_bottomSheet) {
          _classCallCheck(this, BottomSheetOverviewExample);
          this._bottomSheet = _bottomSheet;
        }
        _createClass(BottomSheetOverviewExample, [{
          key: "openBottomSheet",
          value: function openBottomSheet() {
            this._bottomSheet.open(BottomSheetOverviewExampleSheet);
          }
        }]);
        return BottomSheetOverviewExample;
      }();
      BottomSheetOverviewExample.ɵfac = function BottomSheetOverviewExample_Factory(t) {
        return new (t || BottomSheetOverviewExample)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_1__["MatBottomSheet"]));
      };
      BottomSheetOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: BottomSheetOverviewExample,
        selectors: [["bottom-sheet-overview-example"]],
        decls: 7,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/bottom-sheet/overview"], ["mat-raised-button", "", "id", "bottom-sheet", 3, "click"]],
        template: function BottomSheetOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Bottom sheet overview ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "You have received a file called \"cat-picture.jpeg\"");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "button", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BottomSheetOverviewExample_Template_button_click_5_listener() {
              return ctx.openBottomSheet();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "Open file");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_2__["MatButton"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcG9wdXBzLWFuZC1tb2RhbHMvYm90dG9tLXNoZWV0L2JvdHRvbS1zaGVldC1vdmVydmlldy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSw2QkFBNkIiLCJmaWxlIjoic3JjL2FwcC9wb3B1cHMtYW5kLW1vZGFscy9ib3R0b20tc2hlZXQvYm90dG9tLXNoZWV0LW92ZXJ2aWV3LWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyoqIE5vIENTUyBmb3IgdGhpcyBleGFtcGxlICovXHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BottomSheetOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'bottom-sheet-overview-example',
            templateUrl: 'bottom-sheet-overview-example.html',
            styleUrls: ['bottom-sheet-overview-example.css']
          }]
        }], function () {
          return [{
            type: _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_1__["MatBottomSheet"]
          }];
        }, null);
      })();
      var BottomSheetOverviewExampleSheet = /*#__PURE__*/function () {
        function BottomSheetOverviewExampleSheet(_bottomSheetRef) {
          _classCallCheck(this, BottomSheetOverviewExampleSheet);
          this._bottomSheetRef = _bottomSheetRef;
        }
        _createClass(BottomSheetOverviewExampleSheet, [{
          key: "openLink",
          value: function openLink(event) {
            this._bottomSheetRef.dismiss();
            event.preventDefault();
          }
        }]);
        return BottomSheetOverviewExampleSheet;
      }();
      BottomSheetOverviewExampleSheet.ɵfac = function BottomSheetOverviewExampleSheet_Factory(t) {
        return new (t || BottomSheetOverviewExampleSheet)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_1__["MatBottomSheetRef"]));
      };
      BottomSheetOverviewExampleSheet.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: BottomSheetOverviewExampleSheet,
        selectors: [["bottom-sheet-overview-example-sheet"]],
        decls: 21,
        vars: 0,
        consts: [["id", "bottom-sheet-container"], ["href", "https://keep.google.com/", "mat-list-item", "", 3, "click"], ["mat-line", ""], ["href", "https://docs.google.com/", "mat-list-item", "", 3, "click"], ["href", "https://plus.google.com/", "mat-list-item", "", 3, "click"], ["href", "https://hangouts.google.com/", "mat-list-item", "", 3, "click"]],
        template: function BottomSheetOverviewExampleSheet_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-nav-list", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BottomSheetOverviewExampleSheet_Template_a_click_1_listener($event) {
              return ctx.openLink($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "Google Keep");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Add to a note");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "a", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BottomSheetOverviewExampleSheet_Template_a_click_6_listener($event) {
              return ctx.openLink($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Google Docs");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Embed in a document");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "a", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BottomSheetOverviewExampleSheet_Template_a_click_11_listener($event) {
              return ctx.openLink($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "Google Plus");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "Share with your friends");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "a", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BottomSheetOverviewExampleSheet_Template_a_click_16_listener($event) {
              return ctx.openLink($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "Google Hangouts");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "Show to your coworkers");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_list__WEBPACK_IMPORTED_MODULE_3__["MatNavList"], _angular_material_list__WEBPACK_IMPORTED_MODULE_3__["MatListItem"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatLine"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BottomSheetOverviewExampleSheet, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'bottom-sheet-overview-example-sheet',
            templateUrl: 'bottom-sheet-overview-example-sheet.html'
          }]
        }], function () {
          return [{
            type: _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_1__["MatBottomSheetRef"]
          }];
        }, null);
      })();

      /***/
    },

    /***/"./src/app/popups-and-modals/bottom-sheet/bottom-sheet-routing.module.ts":
    /*!*******************************************************************************!*\
      !*** ./src/app/popups-and-modals/bottom-sheet/bottom-sheet-routing.module.ts ***!
      \*******************************************************************************/
    /*! exports provided: BottomSheetRoutingModule */
    /***/
    function srcAppPopupsAndModalsBottomSheetBottomSheetRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BottomSheetRoutingModule", function () {
        return BottomSheetRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./bottom-sheet-overview-example */"./src/app/popups-and-modals/bottom-sheet/bottom-sheet-overview-example.ts");
      var routes = [{
        path: '',
        component: _bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_2__["BottomSheetOverviewExample"]
      }];
      var BottomSheetRoutingModule = /*#__PURE__*/_createClass(function BottomSheetRoutingModule() {
        _classCallCheck(this, BottomSheetRoutingModule);
      });
      BottomSheetRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: BottomSheetRoutingModule
      });
      BottomSheetRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function BottomSheetRoutingModule_Factory(t) {
          return new (t || BottomSheetRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](BottomSheetRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BottomSheetRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/popups-and-modals/bottom-sheet/bottom-sheet.module.ts":
    /*!***********************************************************************!*\
      !*** ./src/app/popups-and-modals/bottom-sheet/bottom-sheet.module.ts ***!
      \***********************************************************************/
    /*! exports provided: BottomSheetModule */
    /***/
    function srcAppPopupsAndModalsBottomSheetBottomSheetModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BottomSheetModule", function () {
        return BottomSheetModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _bottom_sheet_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./bottom-sheet-routing.module */"./src/app/popups-and-modals/bottom-sheet/bottom-sheet-routing.module.ts");
      /* harmony import */
      var _bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./bottom-sheet-overview-example */"./src/app/popups-and-modals/bottom-sheet/bottom-sheet-overview-example.ts");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
      /* harmony import */
      var _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/bottom-sheet */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/bottom-sheet.js");
      var BottomSheetModule = /*#__PURE__*/_createClass(function BottomSheetModule() {
        _classCallCheck(this, BottomSheetModule);
      });
      BottomSheetModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: BottomSheetModule
      });
      BottomSheetModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function BottomSheetModule_Factory(t) {
          return new (t || BottomSheetModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _bottom_sheet_routing_module__WEBPACK_IMPORTED_MODULE_2__["BottomSheetRoutingModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_5__["MatListModule"], _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_6__["MatBottomSheetModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](BottomSheetModule, {
          declarations: [_bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_3__["BottomSheetOverviewExample"], _bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_3__["BottomSheetOverviewExampleSheet"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _bottom_sheet_routing_module__WEBPACK_IMPORTED_MODULE_2__["BottomSheetRoutingModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_5__["MatListModule"], _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_6__["MatBottomSheetModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BottomSheetModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_3__["BottomSheetOverviewExample"], _bottom_sheet_overview_example__WEBPACK_IMPORTED_MODULE_3__["BottomSheetOverviewExampleSheet"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _bottom_sheet_routing_module__WEBPACK_IMPORTED_MODULE_2__["BottomSheetRoutingModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_5__["MatListModule"], _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_6__["MatBottomSheetModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=popups-and-modals-bottom-sheet-bottom-sheet-module-es5.js.map