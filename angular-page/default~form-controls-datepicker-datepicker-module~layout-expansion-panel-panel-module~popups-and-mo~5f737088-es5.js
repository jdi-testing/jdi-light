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
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["default~form-controls-datepicker-datepicker-module~layout-expansion-panel-panel-module~popups-and-mo~5f737088"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/dialog.js":
    /*!************************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/dialog.js ***!
      \************************************************************************/
    /*! exports provided: MAT_DIALOG_DATA, MAT_DIALOG_DEFAULT_OPTIONS, MAT_DIALOG_SCROLL_STRATEGY, MAT_DIALOG_SCROLL_STRATEGY_FACTORY, MAT_DIALOG_SCROLL_STRATEGY_PROVIDER, MAT_DIALOG_SCROLL_STRATEGY_PROVIDER_FACTORY, MatDialog, MatDialogActions, MatDialogClose, MatDialogConfig, MatDialogContainer, MatDialogContent, MatDialogModule, MatDialogRef, MatDialogTitle, matDialogAnimations, throwMatDialogContentAlreadyAttachedError */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015DialogJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DIALOG_DATA", function () {
        return MAT_DIALOG_DATA;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DIALOG_DEFAULT_OPTIONS", function () {
        return MAT_DIALOG_DEFAULT_OPTIONS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DIALOG_SCROLL_STRATEGY", function () {
        return MAT_DIALOG_SCROLL_STRATEGY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DIALOG_SCROLL_STRATEGY_FACTORY", function () {
        return MAT_DIALOG_SCROLL_STRATEGY_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DIALOG_SCROLL_STRATEGY_PROVIDER", function () {
        return MAT_DIALOG_SCROLL_STRATEGY_PROVIDER;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_DIALOG_SCROLL_STRATEGY_PROVIDER_FACTORY", function () {
        return MAT_DIALOG_SCROLL_STRATEGY_PROVIDER_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialog", function () {
        return MatDialog;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogActions", function () {
        return MatDialogActions;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogClose", function () {
        return MatDialogClose;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogConfig", function () {
        return MatDialogConfig;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogContainer", function () {
        return MatDialogContainer;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogContent", function () {
        return MatDialogContent;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogModule", function () {
        return MatDialogModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogRef", function () {
        return MatDialogRef;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatDialogTitle", function () {
        return MatDialogTitle;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "matDialogAnimations", function () {
        return matDialogAnimations;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "throwMatDialogContentAlreadyAttachedError", function () {
        return throwMatDialogContentAlreadyAttachedError;
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
      var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/cdk/bidi */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/bidi.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/cdk/keycodes */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/keycodes.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/dialog-config.ts
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
       * Possible overrides for a dialog's position.
       * @record
       */

      function MatDialogContainer_ng_template_0_Template(rf, ctx) {}
      function DialogPosition() {}
      if (false) {}
      /**
       * Configuration for opening a modal dialog with the MatDialog service.
       * @template D
       */
      var MatDialogConfig = /*#__PURE__*/_createClass(function MatDialogConfig() {
        _classCallCheck(this, MatDialogConfig);
        /**
         * The ARIA role of the dialog element.
         */
        this.role = 'dialog';
        /**
         * Custom class for the overlay pane.
         */
        this.panelClass = '';
        /**
         * Whether the dialog has a backdrop.
         */
        this.hasBackdrop = true;
        /**
         * Custom class for the backdrop.
         */
        this.backdropClass = '';
        /**
         * Whether the user can use escape or clicking on the backdrop to close the modal.
         */
        this.disableClose = false;
        /**
         * Width of the dialog.
         */
        this.width = '';
        /**
         * Height of the dialog.
         */
        this.height = '';
        /**
         * Max-width of the dialog. If a number is provided, assumes pixel units. Defaults to 80vw.
         */
        this.maxWidth = '80vw';
        /**
         * Data being injected into the child component.
         */
        this.data = null;
        /**
         * ID of the element that describes the dialog.
         */
        this.ariaDescribedBy = null;
        /**
         * ID of the element that labels the dialog.
         */
        this.ariaLabelledBy = null;
        /**
         * Aria label to assign to the dialog element.
         */
        this.ariaLabel = null;
        /**
         * Whether the dialog should focus the first focusable element on open.
         */
        this.autoFocus = true;
        /**
         * Whether the dialog should restore focus to the
         * previously-focused element, after it's closed.
         */
        this.restoreFocus = true;
        /**
         * Whether the dialog should close when the user goes backwards/forwards in history.
         * Note that this usually doesn't include clicking on links (unless the user is using
         * the `HashLocationStrategy`).
         */
        this.closeOnNavigation = true;
        // TODO(jelbourn): add configuration for lifecycle hooks, ARIA labelling.
      });

      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/dialog-animations.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Animations used by MatDialog.
       * \@docs-private
       * @type {?}
       */
      var matDialogAnimations = {
        /**
         * Animation that is applied on the dialog container by defalt.
         */
        dialogContainer: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["trigger"])('dialogContainer', [
        // Note: The `enter` animation transitions to `transform: none`, because for some reason
        // specifying the transform explicitly, causes IE both to blur the dialog content and
        // decimate the animation performance. Leaving it as `none` solves both issues.
        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["state"])('void, exit', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          opacity: 0,
          transform: 'scale(0.7)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["state"])('enter', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          transform: 'none'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["transition"])('* => enter', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["animate"])('150ms cubic-bezier(0, 0, 0.2, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          transform: 'none',
          opacity: 1
        }))), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["transition"])('* => void, * => exit', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["animate"])('75ms cubic-bezier(0.4, 0.0, 0.2, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_8__["style"])({
          opacity: 0
        })))])
      };

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/dialog-container.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Throws an exception for the case when a ComponentPortal is
       * attached to a DomPortalOutlet without an origin.
       * \@docs-private
       * @return {?}
       */
      function throwMatDialogContentAlreadyAttachedError() {
        throw Error('Attempting to attach dialog content after content is already attached');
      }
      /**
       * Internal component that wraps user-provided dialog content.
       * Animation is based on https://material.io/guidelines/motion/choreography.html.
       * \@docs-private
       */
      var MatDialogContainer = /*#__PURE__*/function (_angular_cdk_portal__) {
        _inherits(MatDialogContainer, _angular_cdk_portal__);
        var _super = _createSuper(MatDialogContainer);
        /**
         * @param {?} _elementRef
         * @param {?} _focusTrapFactory
         * @param {?} _changeDetectorRef
         * @param {?} _document
         * @param {?} _config
         */
        function MatDialogContainer(_elementRef, _focusTrapFactory, _changeDetectorRef, _document, _config) {
          var _this;
          _classCallCheck(this, MatDialogContainer);
          _this = _super.call(this);
          _this._elementRef = _elementRef;
          _this._focusTrapFactory = _focusTrapFactory;
          _this._changeDetectorRef = _changeDetectorRef;
          _this._config = _config;
          /**
           * Element that was focused before the dialog was opened. Save this to restore upon close.
           */
          _this._elementFocusedBeforeDialogWasOpened = null;
          /**
           * State of the dialog animation.
           */
          _this._state = 'enter';
          /**
           * Emits when an animation state changes.
           */
          _this._animationStateChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["EventEmitter"]();
          /**
           * Attaches a DOM portal to the dialog container.
           * @param portal Portal to be attached.
           * @deprecated To be turned into a method.
           * \@breaking-change 10.0.0
           */
          _this.attachDomPortal =
          /**
          * @param {?} portal
          * @return {?}
          */
          function (portal) {
            if (_this._portalOutlet.hasAttached()) {
              throwMatDialogContentAlreadyAttachedError();
            }
            _this._savePreviouslyFocusedElement();
            return _this._portalOutlet.attachDomPortal(portal);
          };
          _this._ariaLabelledBy = _config.ariaLabelledBy || null;
          _this._document = _document;
          return _this;
        }
        /**
         * Attach a ComponentPortal as content to this dialog container.
         * @template T
         * @param {?} portal Portal to be attached as the dialog content.
         * @return {?}
         */
        _createClass(MatDialogContainer, [{
          key: "attachComponentPortal",
          value: function attachComponentPortal(portal) {
            if (this._portalOutlet.hasAttached()) {
              throwMatDialogContentAlreadyAttachedError();
            }
            this._savePreviouslyFocusedElement();
            return this._portalOutlet.attachComponentPortal(portal);
          }
          /**
           * Attach a TemplatePortal as content to this dialog container.
           * @template C
           * @param {?} portal Portal to be attached as the dialog content.
           * @return {?}
           */
        }, {
          key: "attachTemplatePortal",
          value: function attachTemplatePortal(portal) {
            if (this._portalOutlet.hasAttached()) {
              throwMatDialogContentAlreadyAttachedError();
            }
            this._savePreviouslyFocusedElement();
            return this._portalOutlet.attachTemplatePortal(portal);
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
            // If we were to attempt to focus immediately, then the content of the dialog would not yet be
            // ready in instances where change detection has to run first. To deal with this, we simply
            // wait for the microtask queue to be empty.
            if (this._config.autoFocus) {
              this._focusTrap.focusInitialElementWhenReady();
            } else {
              /** @type {?} */
              var activeElement = this._document.activeElement;
              // Otherwise ensure that focus is on the dialog container. It's possible that a different
              // component tried to move focus while the open animation was running. See:
              // https://github.com/angular/components/issues/16215. Note that we only want to do this
              // if the focus isn't inside the dialog already, because it's possible that the consumer
              // turned off `autoFocus` in order to move focus themselves.
              if (activeElement !== element && !element.contains(activeElement)) {
                element.focus();
              }
            }
          }
          /**
           * Restores focus to the element that was focused before the dialog opened.
           * @private
           * @return {?}
           */
        }, {
          key: "_restoreFocus",
          value: function _restoreFocus() {
            /** @type {?} */
            var toFocus = this._elementFocusedBeforeDialogWasOpened;
            // We need the extra check, because IE can set the `activeElement` to null in some cases.
            if (this._config.restoreFocus && toFocus && typeof toFocus.focus === 'function') {
              /** @type {?} */
              var activeElement = this._document.activeElement;
              /** @type {?} */
              var element = this._elementRef.nativeElement;
              // Make sure that focus is still inside the dialog or is on the body (usually because a
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
           * Saves a reference to the element that was focused before the dialog was opened.
           * @private
           * @return {?}
           */
        }, {
          key: "_savePreviouslyFocusedElement",
          value: function _savePreviouslyFocusedElement() {
            var _this2 = this;
            if (this._document) {
              this._elementFocusedBeforeDialogWasOpened = /** @type {?} */this._document.activeElement;
              // Note that there is no focus method when rendering on the server.
              if (this._elementRef.nativeElement.focus) {
                // Move focus onto the dialog immediately in order to prevent the user from accidentally
                // opening multiple dialogs at the same time. Needs to be async, because the element
                // may not be focusable immediately.
                Promise.resolve().then(
                /**
                * @return {?}
                */
                function () {
                  return _this2._elementRef.nativeElement.focus();
                });
              }
            }
          }
          /**
           * Callback, invoked whenever an animation on the host completes.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onAnimationDone",
          value: function _onAnimationDone(event) {
            if (event.toState === 'enter') {
              this._trapFocus();
            } else if (event.toState === 'exit') {
              this._restoreFocus();
            }
            this._animationStateChanged.emit(event);
          }
          /**
           * Callback, invoked when an animation on the host starts.
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_onAnimationStart",
          value: function _onAnimationStart(event) {
            this._animationStateChanged.emit(event);
          }
          /**
           * Starts the dialog exit animation.
           * @return {?}
           */
        }, {
          key: "_startExitAnimation",
          value: function _startExitAnimation() {
            this._state = 'exit';
            // Mark the container for check so it can react if the
            // view container is using OnPush change detection.
            this._changeDetectorRef.markForCheck();
          }
        }]);
        return MatDialogContainer;
      }(_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["BasePortalOutlet"]);
      MatDialogContainer.ɵfac = function MatDialogContainer_Factory(t) {
        return new (t || MatDialogContainer)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["FocusTrapFactory"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_5__["DOCUMENT"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](MatDialogConfig));
      };
      MatDialogContainer.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
        type: MatDialogContainer,
        selectors: [["mat-dialog-container"]],
        viewQuery: function MatDialogContainer_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵstaticViewQuery"](_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵloadQuery"]()) && (ctx._portalOutlet = _t.first);
          }
        },
        hostAttrs: ["tabindex", "-1", "aria-modal", "true", 1, "mat-dialog-container"],
        hostVars: 6,
        hostBindings: function MatDialogContainer_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵcomponentHostSyntheticListener"]("@dialogContainer.start", function MatDialogContainer_animation_dialogContainer_start_HostBindingHandler($event) {
              return ctx._onAnimationStart($event);
            })("@dialogContainer.done", function MatDialogContainer_animation_dialogContainer_done_HostBindingHandler($event) {
              return ctx._onAnimationDone($event);
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵattribute"]("id", ctx._id)("role", ctx._config.role)("aria-labelledby", ctx._config.ariaLabel ? null : ctx._ariaLabelledBy)("aria-label", ctx._config.ariaLabel)("aria-describedby", ctx._config.ariaDescribedBy || null);
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵupdateSyntheticHostBinding"]("@dialogContainer", ctx._state);
          }
        },
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵInheritDefinitionFeature"]],
        decls: 1,
        vars: 0,
        consts: [["cdkPortalOutlet", ""]],
        template: function MatDialogContainer_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](0, MatDialogContainer_ng_template_0_Template, 0, 0, "ng-template", 0);
          }
        },
        directives: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"]],
        styles: [".mat-dialog-container{display:block;padding:24px;border-radius:4px;box-sizing:border-box;overflow:auto;outline:0;width:100%;height:100%;min-height:inherit;max-height:inherit}.cdk-high-contrast-active .mat-dialog-container{outline:solid 1px}.mat-dialog-content{display:block;margin:0 -24px;padding:0 24px;max-height:65vh;overflow:auto;-webkit-overflow-scrolling:touch}.mat-dialog-title{margin:0 0 20px;display:block}.mat-dialog-actions{padding:8px 0;display:flex;flex-wrap:wrap;min-height:52px;align-items:center;margin-bottom:-24px}.mat-dialog-actions[align=end]{justify-content:flex-end}.mat-dialog-actions[align=center]{justify-content:center}.mat-dialog-actions .mat-button-base+.mat-button-base,.mat-dialog-actions .mat-mdc-button-base+.mat-mdc-button-base{margin-left:8px}[dir=rtl] .mat-dialog-actions .mat-button-base+.mat-button-base,[dir=rtl] .mat-dialog-actions .mat-mdc-button-base+.mat-mdc-button-base{margin-left:0;margin-right:8px}\n"],
        encapsulation: 2,
        data: {
          animation: [matDialogAnimations.dialogContainer]
        }
      });
      /** @nocollapse */
      MatDialogContainer.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["FocusTrapFactory"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectorRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_5__["DOCUMENT"]]
          }]
        }, {
          type: MatDialogConfig
        }];
      };
      MatDialogContainer.propDecorators = {
        _portalOutlet: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ViewChild"],
          args: [_angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["CdkPortalOutlet"], {
            "static": true
          }]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialogContainer, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Component"],
          args: [{
            selector: 'mat-dialog-container',
            template: "<ng-template cdkPortalOutlet></ng-template>\n",
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ViewEncapsulation"].None,
            // Using OnPush for dialogs caused some G3 sync issues. Disabled until we can track them down.
            // tslint:disable-next-line:validate-decorators
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectionStrategy"].Default,
            animations: [matDialogAnimations.dialogContainer],
            host: {
              'class': 'mat-dialog-container',
              'tabindex': '-1',
              'aria-modal': 'true',
              '[attr.id]': '_id',
              '[attr.role]': '_config.role',
              '[attr.aria-labelledby]': '_config.ariaLabel ? null : _ariaLabelledBy',
              '[attr.aria-label]': '_config.ariaLabel',
              '[attr.aria-describedby]': '_config.ariaDescribedBy || null',
              '[@dialogContainer]': '_state',
              '(@dialogContainer.start)': '_onAnimationStart($event)',
              '(@dialogContainer.done)': '_onAnimationDone($event)'
            },
            styles: [".mat-dialog-container{display:block;padding:24px;border-radius:4px;box-sizing:border-box;overflow:auto;outline:0;width:100%;height:100%;min-height:inherit;max-height:inherit}.cdk-high-contrast-active .mat-dialog-container{outline:solid 1px}.mat-dialog-content{display:block;margin:0 -24px;padding:0 24px;max-height:65vh;overflow:auto;-webkit-overflow-scrolling:touch}.mat-dialog-title{margin:0 0 20px;display:block}.mat-dialog-actions{padding:8px 0;display:flex;flex-wrap:wrap;min-height:52px;align-items:center;margin-bottom:-24px}.mat-dialog-actions[align=end]{justify-content:flex-end}.mat-dialog-actions[align=center]{justify-content:center}.mat-dialog-actions .mat-button-base+.mat-button-base,.mat-dialog-actions .mat-mdc-button-base+.mat-mdc-button-base{margin-left:8px}[dir=rtl] .mat-dialog-actions .mat-button-base+.mat-button-base,[dir=rtl] .mat-dialog-actions .mat-mdc-button-base+.mat-mdc-button-base{margin-left:0;margin-right:8px}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_9__["FocusTrapFactory"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ChangeDetectorRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_5__["DOCUMENT"]]
            }]
          }, {
            type: MatDialogConfig
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
       * Generated from: src/material/dialog/dialog-ref.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      // TODO(jelbourn): resizing
      // Counter for unique dialog ids.
      /** @type {?} */
      var uniqueId = 0;
      /** @enum {number} */
      var MatDialogState = {
        OPEN: 0,
        CLOSING: 1,
        CLOSED: 2
      };
      /**
       * Reference to a dialog opened via the MatDialog service.
       * @template T, R
       */
      var MatDialogRef = /*#__PURE__*/function () {
        /**
         * @param {?} _overlayRef
         * @param {?} _containerInstance
         * @param {?=} id
         */
        function MatDialogRef(_overlayRef, _containerInstance) {
          var _this3 = this;
          var id = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "mat-dialog-".concat(uniqueId++);
          _classCallCheck(this, MatDialogRef);
          this._overlayRef = _overlayRef;
          this._containerInstance = _containerInstance;
          this.id = id;
          /**
           * Whether the user is allowed to close the dialog.
           */
          this.disableClose = this._containerInstance._config.disableClose;
          /**
           * Subject for notifying the user that the dialog has finished opening.
           */
          this._afterOpened = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Subject for notifying the user that the dialog has finished closing.
           */
          this._afterClosed = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Subject for notifying the user that the dialog has started closing.
           */
          this._beforeClosed = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          /**
           * Current state of the dialog.
           */
          this._state = 0 /* OPEN */;
          // Pass the id along to the container.
          _containerInstance._id = id;
          // Emit when opening animation completes
          _containerInstance._animationStateChanged.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["filter"])(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            return event.phaseName === 'done' && event.toState === 'enter';
          }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["take"])(1)).subscribe(
          /**
          * @return {?}
          */
          function () {
            _this3._afterOpened.next();
            _this3._afterOpened.complete();
          });
          // Dispose overlay when closing animation is complete
          _containerInstance._animationStateChanged.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["filter"])(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            return event.phaseName === 'done' && event.toState === 'exit';
          }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["take"])(1)).subscribe(
          /**
          * @return {?}
          */
          function () {
            clearTimeout(_this3._closeFallbackTimeout);
            _this3._overlayRef.dispose();
          });
          _overlayRef.detachments().subscribe(
          /**
          * @return {?}
          */
          function () {
            _this3._beforeClosed.next(_this3._result);
            _this3._beforeClosed.complete();
            _this3._afterClosed.next(_this3._result);
            _this3._afterClosed.complete();
            _this3.componentInstance = /** @type {?} */null;
            _this3._overlayRef.dispose();
          });
          _overlayRef.keydownEvents().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["filter"])(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            return event.keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_10__["ESCAPE"] && !_this3.disableClose && !Object(_angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_10__["hasModifierKey"])(event);
          })).subscribe(
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            event.preventDefault();
            _this3.close();
          });
        }
        /**
         * Close the dialog.
         * @param {?=} dialogResult Optional result to return to the dialog opener.
         * @return {?}
         */
        _createClass(MatDialogRef, [{
          key: "close",
          value: function close(dialogResult) {
            var _this4 = this;
            this._result = dialogResult;
            // Transition the backdrop in parallel to the dialog.
            this._containerInstance._animationStateChanged.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["filter"])(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              return event.phaseName === 'start';
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["take"])(1)).subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this4._beforeClosed.next(dialogResult);
              _this4._beforeClosed.complete();
              _this4._state = 2 /* CLOSED */;
              _this4._overlayRef.detachBackdrop();
              // The logic that disposes of the overlay depends on the exit animation completing, however
              // it isn't guaranteed if the parent view is destroyed while it's running. Add a fallback
              // timeout which will clean everything up if the animation hasn't fired within the specified
              // amount of time plus 100ms. We don't need to run this outside the NgZone, because for the
              // vast majority of cases the timeout will have been cleared before it has the chance to fire.
              _this4._closeFallbackTimeout = setTimeout(
              /**
              * @return {?}
              */
              function () {
                _this4._overlayRef.dispose();
              }, event.totalTime + 100);
            });
            this._containerInstance._startExitAnimation();
            this._state = 1 /* CLOSING */;
          }
          /**
           * Gets an observable that is notified when the dialog is finished opening.
           * @return {?}
           */
        }, {
          key: "afterOpened",
          value: function afterOpened() {
            return this._afterOpened.asObservable();
          }
          /**
           * Gets an observable that is notified when the dialog is finished closing.
           * @return {?}
           */
        }, {
          key: "afterClosed",
          value: function afterClosed() {
            return this._afterClosed.asObservable();
          }
          /**
           * Gets an observable that is notified when the dialog has started closing.
           * @return {?}
           */
        }, {
          key: "beforeClosed",
          value: function beforeClosed() {
            return this._beforeClosed.asObservable();
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
          /**
           * Updates the dialog's position.
           * @template THIS
           * @this {THIS}
           * @param {?=} position New dialog position.
           * @return {THIS}
           */
        }, {
          key: "updatePosition",
          value: function updatePosition(position) {
            /** @type {?} */
            var strategy = /** @type {?} */this._getPositionStrategy();
            if (position && (position.left || position.right)) {
              position.left ? strategy.left(position.left) : strategy.right(position.right);
            } else {
              strategy.centerHorizontally();
            }
            if (position && (position.top || position.bottom)) {
              position.top ? strategy.top(position.top) : strategy.bottom(position.bottom);
            } else {
              strategy.centerVertically();
            }
            /** @type {?} */this._overlayRef.updatePosition();
            return (/** @type {?} */this
            );
          }
          /**
           * Updates the dialog's width and height.
           * @template THIS
           * @this {THIS}
           * @param {?=} width New width of the dialog.
           * @param {?=} height New height of the dialog.
           * @return {THIS}
           */
        }, {
          key: "updateSize",
          value: function updateSize() {
            var width = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : '';
            var height = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : '';
            /** @type {?} */this._getPositionStrategy().width(width).height(height);
            /** @type {?} */this._overlayRef.updatePosition();
            return (/** @type {?} */this
            );
          }
          /**
           * Add a CSS class or an array of classes to the overlay pane.
           * @template THIS
           * @this {THIS}
           * @param {?} classes
           * @return {THIS}
           */
        }, {
          key: "addPanelClass",
          value: function addPanelClass(classes) {
            /** @type {?} */this._overlayRef.addPanelClass(classes);
            return (/** @type {?} */this
            );
          }
          /**
           * Remove a CSS class or an array of classes from the overlay pane.
           * @template THIS
           * @this {THIS}
           * @param {?} classes
           * @return {THIS}
           */
        }, {
          key: "removePanelClass",
          value: function removePanelClass(classes) {
            /** @type {?} */this._overlayRef.removePanelClass(classes);
            return (/** @type {?} */this
            );
          }
          /**
           * Gets the current state of the dialog's lifecycle.
           * @return {?}
           */
        }, {
          key: "getState",
          value: function getState() {
            return this._state;
          }
          /**
           * Fetches the position strategy object from the overlay ref.
           * @private
           * @return {?}
           */
        }, {
          key: "_getPositionStrategy",
          value: function _getPositionStrategy() {
            return (/** @type {?} */this._overlayRef.getConfig().positionStrategy
            );
          }
        }]);
        return MatDialogRef;
      }();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/dialog.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used to access the data that was passed in to a dialog.
       * @type {?}
       */
      var MAT_DIALOG_DATA = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["InjectionToken"]('MatDialogData');
      /**
       * Injection token that can be used to specify default dialog options.
       * @type {?}
       */
      var MAT_DIALOG_DEFAULT_OPTIONS = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["InjectionToken"]('mat-dialog-default-options');
      /**
       * Injection token that determines the scroll handling while the dialog is open.
       * @type {?}
       */
      var MAT_DIALOG_SCROLL_STRATEGY = new _angular_core__WEBPACK_IMPORTED_MODULE_2__["InjectionToken"]('mat-dialog-scroll-strategy');
      /**
       * \@docs-private
       * @param {?} overlay
       * @return {?}
       */
      function MAT_DIALOG_SCROLL_STRATEGY_FACTORY(overlay) {
        return (
          /**
          * @return {?}
          */
          function () {
            return overlay.scrollStrategies.block();
          }
        );
      }
      /**
       * \@docs-private
       * @param {?} overlay
       * @return {?}
       */
      function MAT_DIALOG_SCROLL_STRATEGY_PROVIDER_FACTORY(overlay) {
        return (
          /**
          * @return {?}
          */
          function () {
            return overlay.scrollStrategies.block();
          }
        );
      }
      /**
       * \@docs-private
       * @type {?}
       */
      var MAT_DIALOG_SCROLL_STRATEGY_PROVIDER = {
        provide: MAT_DIALOG_SCROLL_STRATEGY,
        deps: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]],
        useFactory: MAT_DIALOG_SCROLL_STRATEGY_PROVIDER_FACTORY
      };
      /**
       * Service to open Material Design modal dialogs.
       */
      var MatDialog = /*#__PURE__*/function () {
        /**
         * @param {?} _overlay
         * @param {?} _injector
         * @param {?} _location
         * @param {?} _defaultOptions
         * @param {?} scrollStrategy
         * @param {?} _parentDialog
         * @param {?} _overlayContainer
         */
        function MatDialog(_overlay, _injector,
        /**
         * @deprecated `_location` parameter to be removed.
         * @breaking-change 10.0.0
         */
        _location, _defaultOptions, scrollStrategy, _parentDialog, _overlayContainer) {
          var _this5 = this;
          _classCallCheck(this, MatDialog);
          this._overlay = _overlay;
          this._injector = _injector;
          this._defaultOptions = _defaultOptions;
          this._parentDialog = _parentDialog;
          this._overlayContainer = _overlayContainer;
          this._openDialogsAtThisLevel = [];
          this._afterAllClosedAtThisLevel = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          this._afterOpenedAtThisLevel = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
          this._ariaHiddenElements = new Map();
          // TODO (jelbourn): tighten the typing right-hand side of this expression.
          /**
           * Stream that emits when all open dialog have finished closing.
           * Will emit on subscribe if there are no open dialogs to begin with.
           */
          this.afterAllClosed = /** @type {?} */Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["defer"])(
          /**
          * @return {?}
          */
          function () {
            return _this5.openDialogs.length ? _this5._afterAllClosed : _this5._afterAllClosed.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["startWith"])(undefined));
          });
          this._scrollStrategy = scrollStrategy;
        }
        /**
         * Keeps track of the currently-open dialogs.
         * @return {?}
         */
        _createClass(MatDialog, [{
          key: "openDialogs",
          get: function get() {
            return this._parentDialog ? this._parentDialog.openDialogs : this._openDialogsAtThisLevel;
          }
          /**
           * Stream that emits when a dialog has been opened.
           * @return {?}
           */
        }, {
          key: "afterOpened",
          get: function get() {
            return this._parentDialog ? this._parentDialog.afterOpened : this._afterOpenedAtThisLevel;
          }
          /**
           * @return {?}
           */
        }, {
          key: "_afterAllClosed",
          get: function get() {
            /** @type {?} */
            var parent = this._parentDialog;
            return parent ? parent._afterAllClosed : this._afterAllClosedAtThisLevel;
          }
          /**
           * Opens a modal dialog containing the given component.
           * @template T, D, R
           * @param {?} componentOrTemplateRef Type of the component to load into the dialog,
           *     or a TemplateRef to instantiate as the dialog content.
           * @param {?=} config Extra configuration options.
           * @return {?} Reference to the newly-opened dialog.
           */
        }, {
          key: "open",
          value: function open(componentOrTemplateRef, config) {
            var _this6 = this;
            config = _applyConfigDefaults(config, this._defaultOptions || new MatDialogConfig());
            if (config.id && this.getDialogById(config.id)) {
              throw Error("Dialog with id \"".concat(config.id, "\" exists already. The dialog id must be unique."));
            }
            /** @type {?} */
            var overlayRef = this._createOverlay(config);
            /** @type {?} */
            var dialogContainer = this._attachDialogContainer(overlayRef, config);
            /** @type {?} */
            var dialogRef = this._attachDialogContent(componentOrTemplateRef, dialogContainer, overlayRef, config);
            // If this is the first dialog that we're opening, hide all the non-overlay content.
            if (!this.openDialogs.length) {
              this._hideNonDialogContentFromAssistiveTechnology();
            }
            this.openDialogs.push(dialogRef);
            dialogRef.afterClosed().subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this6._removeOpenDialog(dialogRef);
            });
            this.afterOpened.next(dialogRef);
            return dialogRef;
          }
          /**
           * Closes all of the currently-open dialogs.
           * @return {?}
           */
        }, {
          key: "closeAll",
          value: function closeAll() {
            this._closeDialogs(this.openDialogs);
          }
          /**
           * Finds an open dialog by its id.
           * @param {?} id ID to use when looking up the dialog.
           * @return {?}
           */
        }, {
          key: "getDialogById",
          value: function getDialogById(id) {
            return this.openDialogs.find(
            /**
            * @param {?} dialog
            * @return {?}
            */
            function (dialog) {
              return dialog.id === id;
            });
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            // Only close the dialogs at this level on destroy
            // since the parent service may still be active.
            this._closeDialogs(this._openDialogsAtThisLevel);
            this._afterAllClosedAtThisLevel.complete();
            this._afterOpenedAtThisLevel.complete();
          }
          /**
           * Creates the overlay into which the dialog will be loaded.
           * @private
           * @param {?} config The dialog configuration.
           * @return {?} A promise resolving to the OverlayRef for the created overlay.
           */
        }, {
          key: "_createOverlay",
          value: function _createOverlay(config) {
            /** @type {?} */
            var overlayConfig = this._getOverlayConfig(config);
            return this._overlay.create(overlayConfig);
          }
          /**
           * Creates an overlay config from a dialog config.
           * @private
           * @param {?} dialogConfig The dialog configuration.
           * @return {?} The overlay configuration.
           */
        }, {
          key: "_getOverlayConfig",
          value: function _getOverlayConfig(dialogConfig) {
            /** @type {?} */
            var state = new _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayConfig"]({
              positionStrategy: this._overlay.position().global(),
              scrollStrategy: dialogConfig.scrollStrategy || this._scrollStrategy(),
              panelClass: dialogConfig.panelClass,
              hasBackdrop: dialogConfig.hasBackdrop,
              direction: dialogConfig.direction,
              minWidth: dialogConfig.minWidth,
              minHeight: dialogConfig.minHeight,
              maxWidth: dialogConfig.maxWidth,
              maxHeight: dialogConfig.maxHeight,
              disposeOnNavigation: dialogConfig.closeOnNavigation
            });
            if (dialogConfig.backdropClass) {
              state.backdropClass = dialogConfig.backdropClass;
            }
            return state;
          }
          /**
           * Attaches an MatDialogContainer to a dialog's already-created overlay.
           * @private
           * @param {?} overlay Reference to the dialog's underlying overlay.
           * @param {?} config The dialog configuration.
           * @return {?} A promise resolving to a ComponentRef for the attached container.
           */
        }, {
          key: "_attachDialogContainer",
          value: function _attachDialogContainer(overlay, config) {
            /** @type {?} */
            var userInjector = config && config.viewContainerRef && config.viewContainerRef.injector;
            /** @type {?} */
            var injector = _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"].create({
              parent: userInjector || this._injector,
              providers: [{
                provide: MatDialogConfig,
                useValue: config
              }]
            });
            /** @type {?} */
            var containerPortal = new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["ComponentPortal"](MatDialogContainer, config.viewContainerRef, injector, config.componentFactoryResolver);
            /** @type {?} */
            var containerRef = overlay.attach(containerPortal);
            return containerRef.instance;
          }
          /**
           * Attaches the user-provided component to the already-created MatDialogContainer.
           * @private
           * @template T, R
           * @param {?} componentOrTemplateRef The type of component being loaded into the dialog,
           *     or a TemplateRef to instantiate as the content.
           * @param {?} dialogContainer Reference to the wrapping MatDialogContainer.
           * @param {?} overlayRef Reference to the overlay in which the dialog resides.
           * @param {?} config The dialog configuration.
           * @return {?} A promise resolving to the MatDialogRef that should be returned to the user.
           */
        }, {
          key: "_attachDialogContent",
          value: function _attachDialogContent(componentOrTemplateRef, dialogContainer, overlayRef, config) {
            // Create a reference to the dialog we're creating in order to give the user a handle
            // to modify and close it.
            /** @type {?} */
            var dialogRef = new MatDialogRef(overlayRef, dialogContainer, config.id);
            // When the dialog backdrop is clicked, we want to close it.
            if (config.hasBackdrop) {
              overlayRef.backdropClick().subscribe(
              /**
              * @return {?}
              */
              function () {
                if (!dialogRef.disableClose) {
                  dialogRef.close();
                }
              });
            }
            if (componentOrTemplateRef instanceof _angular_core__WEBPACK_IMPORTED_MODULE_2__["TemplateRef"]) {
              dialogContainer.attachTemplatePortal(new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["TemplatePortal"](componentOrTemplateRef, /** @type {?} */null, /** @type {?} */{
                $implicit: config.data,
                dialogRef: dialogRef
              }));
            } else {
              /** @type {?} */
              var injector = this._createInjector(config, dialogRef, dialogContainer);
              /** @type {?} */
              var contentRef = dialogContainer.attachComponentPortal(new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["ComponentPortal"](componentOrTemplateRef, config.viewContainerRef, injector));
              dialogRef.componentInstance = contentRef.instance;
            }
            dialogRef.updateSize(config.width, config.height).updatePosition(config.position);
            return dialogRef;
          }
          /**
           * Creates a custom injector to be used inside the dialog. This allows a component loaded inside
           * of a dialog to close itself and, optionally, to return a value.
           * @private
           * @template T
           * @param {?} config Config object that is used to construct the dialog.
           * @param {?} dialogRef Reference to the dialog.
           * @param {?} dialogContainer
           * @return {?} The custom injector that can be used inside the dialog.
           */
        }, {
          key: "_createInjector",
          value: function _createInjector(config, dialogRef, dialogContainer) {
            /** @type {?} */
            var userInjector = config && config.viewContainerRef && config.viewContainerRef.injector;
            // The MatDialogContainer is injected in the portal as the MatDialogContainer and the dialog's
            // content are created out of the same ViewContainerRef and as such, are siblings for injector
            // purposes. To allow the hierarchy that is expected, the MatDialogContainer is explicitly
            // added to the injection tokens.
            /** @type {?} */
            var providers = [{
              provide: MatDialogContainer,
              useValue: dialogContainer
            }, {
              provide: MAT_DIALOG_DATA,
              useValue: config.data
            }, {
              provide: MatDialogRef,
              useValue: dialogRef
            }];
            if (config.direction && (!userInjector || !userInjector.get(_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_4__["Directionality"], null))) {
              providers.push({
                provide: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_4__["Directionality"],
                useValue: {
                  value: config.direction,
                  change: Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["of"])()
                }
              });
            }
            return _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"].create({
              parent: userInjector || this._injector,
              providers: providers
            });
          }
          /**
           * Removes a dialog from the array of open dialogs.
           * @private
           * @param {?} dialogRef Dialog to be removed.
           * @return {?}
           */
        }, {
          key: "_removeOpenDialog",
          value: function _removeOpenDialog(dialogRef) {
            /** @type {?} */
            var index = this.openDialogs.indexOf(dialogRef);
            if (index > -1) {
              this.openDialogs.splice(index, 1);
              // If all the dialogs were closed, remove/restore the `aria-hidden`
              // to a the siblings and emit to the `afterAllClosed` stream.
              if (!this.openDialogs.length) {
                this._ariaHiddenElements.forEach(
                /**
                * @param {?} previousValue
                * @param {?} element
                * @return {?}
                */
                function (previousValue, element) {
                  if (previousValue) {
                    element.setAttribute('aria-hidden', previousValue);
                  } else {
                    element.removeAttribute('aria-hidden');
                  }
                });
                this._ariaHiddenElements.clear();
                this._afterAllClosed.next();
              }
            }
          }
          /**
           * Hides all of the content that isn't an overlay from assistive technology.
           * @private
           * @return {?}
           */
        }, {
          key: "_hideNonDialogContentFromAssistiveTechnology",
          value: function _hideNonDialogContentFromAssistiveTechnology() {
            /** @type {?} */
            var overlayContainer = this._overlayContainer.getContainerElement();
            // Ensure that the overlay container is attached to the DOM.
            if (overlayContainer.parentElement) {
              /** @type {?} */
              var siblings = overlayContainer.parentElement.children;
              for (var i = siblings.length - 1; i > -1; i--) {
                /** @type {?} */
                var sibling = siblings[i];
                if (sibling !== overlayContainer && sibling.nodeName !== 'SCRIPT' && sibling.nodeName !== 'STYLE' && !sibling.hasAttribute('aria-live')) {
                  this._ariaHiddenElements.set(sibling, sibling.getAttribute('aria-hidden'));
                  sibling.setAttribute('aria-hidden', 'true');
                }
              }
            }
          }
          /**
           * Closes all of the dialogs in an array.
           * @private
           * @param {?} dialogs
           * @return {?}
           */
        }, {
          key: "_closeDialogs",
          value: function _closeDialogs(dialogs) {
            /** @type {?} */
            var i = dialogs.length;
            while (i--) {
              // The `_openDialogs` property isn't updated after close until the rxjs subscription
              // runs on the next microtask, in addition to modifying the array as we're going
              // through it. We loop through all of them and call close without assuming that
              // they'll be removed from the list instantaneously.
              dialogs[i].close();
            }
          }
        }]);
        return MatDialog;
      }();
      MatDialog.ɵfac = function MatDialog_Factory(t) {
        return new (t || MatDialog)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_common__WEBPACK_IMPORTED_MODULE_5__["Location"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](MAT_DIALOG_DEFAULT_OPTIONS, 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](MAT_DIALOG_SCROLL_STRATEGY), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](MatDialog, 12), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayContainer"]));
      };
      MatDialog.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjectable"]({
        token: MatDialog,
        factory: MatDialog.ɵfac
      });
      /** @nocollapse */
      MatDialog.ctorParameters = function () {
        return [{
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"]
        }, {
          type: _angular_common__WEBPACK_IMPORTED_MODULE_5__["Location"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }]
        }, {
          type: MatDialogConfig,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
            args: [MAT_DIALOG_DEFAULT_OPTIONS]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
            args: [MAT_DIALOG_SCROLL_STRATEGY]
          }]
        }, {
          type: MatDialog,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["SkipSelf"]
          }]
        }, {
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayContainer"]
        }];
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialog, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"]
        }], function () {
          return [{
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injector"]
          }, {
            type: _angular_common__WEBPACK_IMPORTED_MODULE_5__["Location"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }]
          }, {
            type: MatDialogConfig,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
              args: [MAT_DIALOG_DEFAULT_OPTIONS]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Inject"],
              args: [MAT_DIALOG_SCROLL_STRATEGY]
            }]
          }, {
            type: MatDialog,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["SkipSelf"]
            }]
          }, {
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayContainer"]
          }];
        }, null);
      })();
      if (false) {}
      /**
       * Applies default options to the dialog config.
       * @param {?=} config Config to be modified.
       * @param {?=} defaultOptions Default options provided.
       * @return {?} The new configuration object.
       */
      function _applyConfigDefaults(config, defaultOptions) {
        return Object.assign(Object.assign({}, defaultOptions), config);
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/dialog-content-directives.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Counter used to generate unique IDs for dialog elements.
       * @type {?}
       */
      var dialogElementUid = 0;
      /**
       * Button that will close the current dialog.
       */
      var MatDialogClose = /*#__PURE__*/function () {
        /**
         * @param {?} dialogRef
         * @param {?} _elementRef
         * @param {?} _dialog
         */
        function MatDialogClose(dialogRef, _elementRef, _dialog) {
          _classCallCheck(this, MatDialogClose);
          this.dialogRef = dialogRef;
          this._elementRef = _elementRef;
          this._dialog = _dialog;
          /**
           * Default to "button" to prevents accidental form submits.
           */
          this.type = 'button';
        }
        /**
         * @return {?}
         */
        _createClass(MatDialogClose, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            if (!this.dialogRef) {
              // When this directive is included in a dialog via TemplateRef (rather than being
              // in a Component), the DialogRef isn't available via injection because embedded
              // views cannot be given a custom injector. Instead, we look up the DialogRef by
              // ID. This must occur in `onInit`, as the ID binding for the dialog container won't
              // be resolved at constructor time.
              this.dialogRef = /** @type {?} */getClosestDialog(this._elementRef, this._dialog.openDialogs);
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
            var proxiedChange = changes['_matDialogClose'] || changes['_matDialogCloseResult'];
            if (proxiedChange) {
              this.dialogResult = proxiedChange.currentValue;
            }
          }
        }]);
        return MatDialogClose;
      }();
      MatDialogClose.ɵfac = function MatDialogClose_Factory(t) {
        return new (t || MatDialogClose)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](MatDialogRef, 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](MatDialog));
      };
      MatDialogClose.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineDirective"]({
        type: MatDialogClose,
        selectors: [["", "mat-dialog-close", ""], ["", "matDialogClose", ""]],
        hostVars: 2,
        hostBindings: function MatDialogClose_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function MatDialogClose_click_HostBindingHandler() {
              return ctx.dialogRef.close(ctx.dialogResult);
            });
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵattribute"]("aria-label", ctx.ariaLabel || null)("type", ctx.type);
          }
        },
        inputs: {
          type: "type",
          dialogResult: ["mat-dialog-close", "dialogResult"],
          ariaLabel: ["aria-label", "ariaLabel"],
          _matDialogClose: ["matDialogClose", "_matDialogClose"]
        },
        exportAs: ["matDialogClose"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵNgOnChangesFeature"]]
      });
      /** @nocollapse */
      MatDialogClose.ctorParameters = function () {
        return [{
          type: MatDialogRef,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
        }, {
          type: MatDialog
        }];
      };
      MatDialogClose.propDecorators = {
        ariaLabel: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"],
          args: ['aria-label']
        }],
        type: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"]
        }],
        dialogResult: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"],
          args: ['mat-dialog-close']
        }],
        _matDialogClose: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"],
          args: ['matDialogClose']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialogClose, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Directive"],
          args: [{
            selector: '[mat-dialog-close], [matDialogClose]',
            exportAs: 'matDialogClose',
            host: {
              '(click)': 'dialogRef.close(dialogResult)',
              '[attr.aria-label]': 'ariaLabel || null',
              '[attr.type]': 'type'
            }
          }]
        }], function () {
          return [{
            type: MatDialogRef,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
          }, {
            type: MatDialog
          }];
        }, {
          type: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"]
          }],
          dialogResult: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"],
            args: ['mat-dialog-close']
          }],
          ariaLabel: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"],
            args: ['aria-label']
          }],
          _matDialogClose: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"],
            args: ['matDialogClose']
          }]
        });
      })();
      if (false) {}
      /**
       * Title of a dialog element. Stays fixed to the top of the dialog when scrolling.
       */
      var MatDialogTitle = /*#__PURE__*/function () {
        /**
         * @param {?} _dialogRef
         * @param {?} _elementRef
         * @param {?} _dialog
         */
        function MatDialogTitle(_dialogRef, _elementRef, _dialog) {
          _classCallCheck(this, MatDialogTitle);
          this._dialogRef = _dialogRef;
          this._elementRef = _elementRef;
          this._dialog = _dialog;
          this.id = "mat-dialog-title-".concat(dialogElementUid++);
        }
        /**
         * @return {?}
         */
        _createClass(MatDialogTitle, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            var _this7 = this;
            if (!this._dialogRef) {
              this._dialogRef = /** @type {?} */getClosestDialog(this._elementRef, this._dialog.openDialogs);
            }
            if (this._dialogRef) {
              Promise.resolve().then(
              /**
              * @return {?}
              */
              function () {
                /** @type {?} */
                var container = _this7._dialogRef._containerInstance;
                if (container && !container._ariaLabelledBy) {
                  container._ariaLabelledBy = _this7.id;
                }
              });
            }
          }
        }]);
        return MatDialogTitle;
      }();
      MatDialogTitle.ɵfac = function MatDialogTitle_Factory(t) {
        return new (t || MatDialogTitle)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](MatDialogRef, 8), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](MatDialog));
      };
      MatDialogTitle.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineDirective"]({
        type: MatDialogTitle,
        selectors: [["", "mat-dialog-title", ""], ["", "matDialogTitle", ""]],
        hostAttrs: [1, "mat-dialog-title"],
        hostVars: 1,
        hostBindings: function MatDialogTitle_HostBindings(rf, ctx) {
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵhostProperty"]("id", ctx.id);
          }
        },
        inputs: {
          id: "id"
        },
        exportAs: ["matDialogTitle"]
      });
      /** @nocollapse */
      MatDialogTitle.ctorParameters = function () {
        return [{
          type: MatDialogRef,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
        }, {
          type: MatDialog
        }];
      };
      MatDialogTitle.propDecorators = {
        id: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialogTitle, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Directive"],
          args: [{
            selector: '[mat-dialog-title], [matDialogTitle]',
            exportAs: 'matDialogTitle',
            host: {
              'class': 'mat-dialog-title',
              '[id]': 'id'
            }
          }]
        }], function () {
          return [{
            type: MatDialogRef,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Optional"]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ElementRef"]
          }, {
            type: MatDialog
          }];
        }, {
          id: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Input"]
          }]
        });
      })();
      if (false) {}
      /**
       * Scrollable content container of a dialog.
       */
      var MatDialogContent = /*#__PURE__*/_createClass(function MatDialogContent() {
        _classCallCheck(this, MatDialogContent);
      });
      MatDialogContent.ɵfac = function MatDialogContent_Factory(t) {
        return new (t || MatDialogContent)();
      };
      MatDialogContent.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineDirective"]({
        type: MatDialogContent,
        selectors: [["", "mat-dialog-content", ""], ["mat-dialog-content"], ["", "matDialogContent", ""]],
        hostAttrs: [1, "mat-dialog-content"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialogContent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Directive"],
          args: [{
            selector: "[mat-dialog-content], mat-dialog-content, [matDialogContent]",
            host: {
              'class': 'mat-dialog-content'
            }
          }]
        }], null, null);
      })();
      /**
       * Container for the bottom action buttons in a dialog.
       * Stays fixed to the bottom when scrolling.
       */
      var MatDialogActions = /*#__PURE__*/_createClass(function MatDialogActions() {
        _classCallCheck(this, MatDialogActions);
      });
      MatDialogActions.ɵfac = function MatDialogActions_Factory(t) {
        return new (t || MatDialogActions)();
      };
      MatDialogActions.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineDirective"]({
        type: MatDialogActions,
        selectors: [["", "mat-dialog-actions", ""], ["mat-dialog-actions"], ["", "matDialogActions", ""]],
        hostAttrs: [1, "mat-dialog-actions"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialogActions, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Directive"],
          args: [{
            selector: "[mat-dialog-actions], mat-dialog-actions, [matDialogActions]",
            host: {
              'class': 'mat-dialog-actions'
            }
          }]
        }], null, null);
      })();
      /**
       * Finds the closest MatDialogRef to an element by looking at the DOM.
       * @param {?} element Element relative to which to look for a dialog.
       * @param {?} openDialogs References to the currently-open dialogs.
       * @return {?}
       */
      function getClosestDialog(element, openDialogs) {
        /** @type {?} */
        var parent = element.nativeElement.parentElement;
        while (parent && !parent.classList.contains('mat-dialog-container')) {
          parent = parent.parentElement;
        }
        return parent ? openDialogs.find(
        /**
        * @param {?} dialog
        * @return {?}
        */
        function (dialog) {
          return dialog.id === /** @type {?} */parent.id;
        }) : null;
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/dialog-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var MatDialogModule = /*#__PURE__*/_createClass(function MatDialogModule() {
        _classCallCheck(this, MatDialogModule);
      });
      MatDialogModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
        type: MatDialogModule
      });
      MatDialogModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
        factory: function MatDialogModule_Factory(t) {
          return new (t || MatDialogModule)();
        },
        providers: [MatDialog, MAT_DIALOG_SCROLL_STRATEGY_PROVIDER],
        imports: [[_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](MatDialogModule, {
          declarations: function declarations() {
            return [MatDialogContainer, MatDialogClose, MatDialogTitle, MatDialogActions, MatDialogContent];
          },
          imports: function imports() {
            return [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]];
          },
          exports: function exports() {
            return [MatDialogContainer, MatDialogClose, MatDialogTitle, MatDialogContent, MatDialogActions, _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](MatDialogModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"],
          args: [{
            imports: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_1__["PortalModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]],
            exports: [MatDialogContainer, MatDialogClose, MatDialogTitle, MatDialogContent, MatDialogActions, _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["MatCommonModule"]],
            declarations: [MatDialogContainer, MatDialogClose, MatDialogTitle, MatDialogActions, MatDialogContent],
            providers: [MatDialog, MAT_DIALOG_SCROLL_STRATEGY_PROVIDER],
            entryComponents: [MatDialogContainer]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/dialog/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=dialog.js.map

      /***/
    }
  }]);
})();
//# sourceMappingURL=default~form-controls-datepicker-datepicker-module~layout-expansion-panel-panel-module~popups-and-mo~5f737088-es5.js.map