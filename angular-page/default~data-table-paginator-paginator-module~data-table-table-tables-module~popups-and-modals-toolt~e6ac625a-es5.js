(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["default~data-table-paginator-paginator-module~data-table-table-tables-module~popups-and-modals-toolt~e6ac625a"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js":
    /*!*************************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js ***!
      \*************************************************************************/
    /*! exports provided: MAT_TOOLTIP_DEFAULT_OPTIONS, MAT_TOOLTIP_DEFAULT_OPTIONS_FACTORY, MAT_TOOLTIP_SCROLL_STRATEGY, MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY, MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY_PROVIDER, MatTooltip, MatTooltipModule, SCROLL_THROTTLE_MS, TOOLTIP_PANEL_CLASS, TooltipComponent, getMatTooltipInvalidPositionError, matTooltipAnimations */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015TooltipJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_TOOLTIP_DEFAULT_OPTIONS", function () {
        return MAT_TOOLTIP_DEFAULT_OPTIONS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_TOOLTIP_DEFAULT_OPTIONS_FACTORY", function () {
        return MAT_TOOLTIP_DEFAULT_OPTIONS_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_TOOLTIP_SCROLL_STRATEGY", function () {
        return MAT_TOOLTIP_SCROLL_STRATEGY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY", function () {
        return MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY_PROVIDER", function () {
        return MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY_PROVIDER;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatTooltip", function () {
        return MatTooltip;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatTooltipModule", function () {
        return MatTooltipModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SCROLL_THROTTLE_MS", function () {
        return SCROLL_THROTTLE_MS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TOOLTIP_PANEL_CLASS", function () {
        return TOOLTIP_PANEL_CLASS;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TooltipComponent", function () {
        return TooltipComponent;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "getMatTooltipInvalidPositionError", function () {
        return getMatTooltipInvalidPositionError;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "matTooltipAnimations", function () {
        return matTooltipAnimations;
      });
      /* harmony import */
      var _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/cdk/overlay */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/overlay.js");
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/cdk/bidi */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/bidi.js");
      /* harmony import */
      var _angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/cdk/coercion */"./node_modules/@angular/cdk/fesm2015/coercion.js");
      /* harmony import */
      var _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/cdk/keycodes */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/keycodes.js");
      /* harmony import */
      var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/cdk/layout */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/layout.js");
      /* harmony import */
      var _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! @angular/cdk/platform */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/platform.js");
      /* harmony import */
      var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! @angular/cdk/portal */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/portal.js");
      /* harmony import */
      var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! @angular/cdk/scrolling */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/scrolling.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/tooltip/tooltip-animations.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Animations used by MatTooltip.
       * \@docs-private
       * @type {?}
       */

      var matTooltipAnimations = {
        /**
         * Animation that transitions a tooltip in and out.
         */
        tooltipState: Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["trigger"])('state', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["state"])('initial, void, hidden', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["style"])({
          opacity: 0,
          transform: 'scale(0)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["state"])('visible', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["style"])({
          transform: 'scale(1)'
        })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["transition"])('* => visible', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["animate"])('200ms cubic-bezier(0, 0, 0.2, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["keyframes"])([Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["style"])({
          opacity: 0,
          transform: 'scale(0)',
          offset: 0
        }), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["style"])({
          opacity: 0.5,
          transform: 'scale(0.99)',
          offset: 0.5
        }), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["style"])({
          opacity: 1,
          transform: 'scale(1)',
          offset: 1
        })]))), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["transition"])('* => hidden', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["animate"])('100ms cubic-bezier(0, 0, 0.2, 1)', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_14__["style"])({
          opacity: 0
        })))])
      };

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/tooltip/tooltip.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Time in ms to throttle repositioning after scroll events.
       * @type {?}
       */
      var SCROLL_THROTTLE_MS = 20;
      /**
       * CSS class that will be attached to the overlay panel.
       * @type {?}
       */
      var TOOLTIP_PANEL_CLASS = 'mat-tooltip-panel';
      /**
       * Options used to bind passive event listeners.
       * @type {?}
       */
      var passiveListenerOptions = Object(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_9__["normalizePassiveListenerOptions"])({
        passive: true
      });
      /**
       * Time between the user putting the pointer on a tooltip
       * trigger and the long press event being fired.
       * @type {?}
       */
      var LONGPRESS_DELAY = 500;
      /**
       * Creates an error to be thrown if the user supplied an invalid tooltip position.
       * \@docs-private
       * @param {?} position
       * @return {?}
       */
      function getMatTooltipInvalidPositionError(position) {
        return Error("Tooltip position \"".concat(position, "\" is invalid."));
      }
      /**
       * Injection token that determines the scroll handling while a tooltip is visible.
       * @type {?}
       */
      var MAT_TOOLTIP_SCROLL_STRATEGY = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('mat-tooltip-scroll-strategy');
      /**
       * \@docs-private
       * @param {?} overlay
       * @return {?}
       */
      function MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY(overlay) {
        return (
          /**
          * @return {?}
          */
          function () {
            return overlay.scrollStrategies.reposition({
              scrollThrottle: SCROLL_THROTTLE_MS
            });
          }
        );
      }
      /**
       * \@docs-private
       * @type {?}
       */
      var MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY_PROVIDER = {
        provide: MAT_TOOLTIP_SCROLL_STRATEGY,
        deps: [_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]],
        useFactory: MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY
      };
      /**
       * Default `matTooltip` options that can be overridden.
       * @record
       */
      function MatTooltipDefaultOptions() {}
      if (false) {}
      /**
       * Injection token to be used to override the default options for `matTooltip`.
       * @type {?}
       */
      var MAT_TOOLTIP_DEFAULT_OPTIONS = new _angular_core__WEBPACK_IMPORTED_MODULE_3__["InjectionToken"]('mat-tooltip-default-options', {
        providedIn: 'root',
        factory: MAT_TOOLTIP_DEFAULT_OPTIONS_FACTORY
      });
      /**
       * \@docs-private
       * @return {?}
       */
      function MAT_TOOLTIP_DEFAULT_OPTIONS_FACTORY() {
        return {
          showDelay: 0,
          hideDelay: 0,
          touchendHideDelay: 1500
        };
      }
      /**
       * Directive that attaches a material design tooltip to the host element. Animates the showing and
       * hiding of a tooltip provided position (defaults to below the element).
       *
       * https://material.io/design/components/tooltips.html
       */
      var MatTooltip = /*#__PURE__*/function () {
        /**
         * @param {?} _overlay
         * @param {?} _elementRef
         * @param {?} _scrollDispatcher
         * @param {?} _viewContainerRef
         * @param {?} _ngZone
         * @param {?} _platform
         * @param {?} _ariaDescriber
         * @param {?} _focusMonitor
         * @param {?} scrollStrategy
         * @param {?} _dir
         * @param {?} _defaultOptions
         * @param {?=} _hammerLoader
         */
        function MatTooltip(_overlay, _elementRef, _scrollDispatcher, _viewContainerRef, _ngZone, _platform, _ariaDescriber, _focusMonitor, scrollStrategy, _dir, _defaultOptions,
        /**
         * @deprecated _hammerLoader parameter to be removed.
         * @breaking-change 9.0.0
         */
        // Note that we need to give Angular something to inject here so it doesn't throw.
        _hammerLoader) {
          var _this = this;
          _classCallCheck(this, MatTooltip);
          this._overlay = _overlay;
          this._elementRef = _elementRef;
          this._scrollDispatcher = _scrollDispatcher;
          this._viewContainerRef = _viewContainerRef;
          this._ngZone = _ngZone;
          this._platform = _platform;
          this._ariaDescriber = _ariaDescriber;
          this._focusMonitor = _focusMonitor;
          this._dir = _dir;
          this._defaultOptions = _defaultOptions;
          this._position = 'below';
          this._disabled = false;
          /**
           * The default delay in ms before showing the tooltip after show is called
           */
          this.showDelay = this._defaultOptions.showDelay;
          /**
           * The default delay in ms before hiding the tooltip after hide is called
           */
          this.hideDelay = this._defaultOptions.hideDelay;
          /**
           * How touch gestures should be handled by the tooltip. On touch devices the tooltip directive
           * uses a long press gesture to show and hide, however it can conflict with the native browser
           * gestures. To work around the conflict, Angular Material disables native gestures on the
           * trigger, but that might not be desirable on particular elements (e.g. inputs and draggable
           * elements). The different values for this option configure the touch event handling as follows:
           * - `auto` - Enables touch gestures for all elements, but tries to avoid conflicts with native
           *   browser gestures on particular elements. In particular, it allows text selection on inputs
           *   and textareas, and preserves the native browser dragging on elements marked as `draggable`.
           * - `on` - Enables touch gestures for all elements and disables native
           *   browser gestures with no exceptions.
           * - `off` - Disables touch gestures. Note that this will prevent the tooltip from
           *   showing on touch devices.
           */
          this.touchGestures = 'auto';
          this._message = '';
          /**
           * Manually-bound passive event listeners.
           */
          this._passiveListeners = new Map();
          /**
           * Emits when the component is destroyed.
           */
          this._destroyed = new rxjs__WEBPACK_IMPORTED_MODULE_12__["Subject"]();
          /**
           * Handles the keydown events on the host element.
           * Needs to be an arrow function so that we can use it in addEventListener.
           */
          this._handleKeydown =
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            if (_this._isTooltipVisible() && event.keyCode === _angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_7__["ESCAPE"] && !Object(_angular_cdk_keycodes__WEBPACK_IMPORTED_MODULE_7__["hasModifierKey"])(event)) {
              event.preventDefault();
              event.stopPropagation();
              _this._ngZone.run(
              /**
              * @return {?}
              */
              function () {
                return _this.hide(0);
              });
            }
          };
          this._scrollStrategy = scrollStrategy;
          if (_defaultOptions) {
            if (_defaultOptions.position) {
              this.position = _defaultOptions.position;
            }
            if (_defaultOptions.touchGestures) {
              this.touchGestures = _defaultOptions.touchGestures;
            }
          }
          _focusMonitor.monitor(_elementRef).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_13__["takeUntil"])(this._destroyed)).subscribe(
          /**
          * @param {?} origin
          * @return {?}
          */
          function (origin) {
            // Note that the focus monitor runs outside the Angular zone.
            if (!origin) {
              _ngZone.run(
              /**
              * @return {?}
              */
              function () {
                return _this.hide(0);
              });
            } else if (origin === 'keyboard') {
              _ngZone.run(
              /**
              * @return {?}
              */
              function () {
                return _this.show();
              });
            }
          });
          _ngZone.runOutsideAngular(
          /**
          * @return {?}
          */
          function () {
            _elementRef.nativeElement.addEventListener('keydown', _this._handleKeydown);
          });
        }
        /**
         * Allows the user to define the position of the tooltip relative to the parent element
         * @return {?}
         */
        _createClass(MatTooltip, [{
          key: "position",
          get: function get() {
            return this._position;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            if (value !== this._position) {
              this._position = value;
              if (this._overlayRef) {
                this._updatePosition();
                if (this._tooltipInstance) {
                  /** @type {?} */this._tooltipInstance.show(0);
                }
                this._overlayRef.updatePosition();
              }
            }
          }
          /**
           * Disables the display of the tooltip.
           * @return {?}
           */
        }, {
          key: "disabled",
          get: function get() {
            return this._disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._disabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_6__["coerceBooleanProperty"])(value);
            // If tooltip is disabled, hide immediately.
            if (this._disabled) {
              this.hide(0);
            }
          }
          /**
           * The message to be displayed in the tooltip
           * @return {?}
           */
        }, {
          key: "message",
          get: function get() {
            return this._message;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            var _this2 = this;
            this._ariaDescriber.removeDescription(this._elementRef.nativeElement, this._message);
            // If the message is not a string (e.g. number), convert it to a string and trim it.
            this._message = value != null ? "".concat(value).trim() : '';
            if (!this._message && this._isTooltipVisible()) {
              this.hide(0);
            } else {
              this._updateTooltipMessage();
              this._ngZone.runOutsideAngular(
              /**
              * @return {?}
              */
              function () {
                // The `AriaDescriber` has some functionality that avoids adding a description if it's the
                // same as the `aria-label` of an element, however we can't know whether the tooltip trigger
                // has a data-bound `aria-label` or when it'll be set for the first time. We can avoid the
                // issue by deferring the description by a tick so Angular has time to set the `aria-label`.
                Promise.resolve().then(
                /**
                * @return {?}
                */
                function () {
                  _this2._ariaDescriber.describe(_this2._elementRef.nativeElement, _this2.message);
                });
              });
            }
          }
          /**
           * Classes to be passed to the tooltip. Supports the same syntax as `ngClass`.
           * @return {?}
           */
        }, {
          key: "tooltipClass",
          get: function get() {
            return this._tooltipClass;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._tooltipClass = value;
            if (this._tooltipInstance) {
              this._setTooltipClass(this._tooltipClass);
            }
          }
          /**
           * Setup styling-specific things
           * @return {?}
           */
        }, {
          key: "ngOnInit",
          value: function ngOnInit() {
            // This needs to happen in `ngOnInit` so the initial values for all inputs have been set.
            this._setupPointerEvents();
          }
          /**
           * Dispose the tooltip when destroyed.
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            /** @type {?} */
            var nativeElement = this._elementRef.nativeElement;
            clearTimeout(this._touchstartTimeout);
            if (this._overlayRef) {
              this._overlayRef.dispose();
              this._tooltipInstance = null;
            }
            // Clean up the event listeners set in the constructor
            nativeElement.removeEventListener('keydown', this._handleKeydown);
            this._passiveListeners.forEach(
            /**
            * @param {?} listener
            * @param {?} event
            * @return {?}
            */
            function (listener, event) {
              nativeElement.removeEventListener(event, listener, passiveListenerOptions);
            });
            this._passiveListeners.clear();
            this._destroyed.next();
            this._destroyed.complete();
            this._ariaDescriber.removeDescription(nativeElement, this.message);
            this._focusMonitor.stopMonitoring(nativeElement);
          }
          /**
           * Shows the tooltip after the delay in ms, defaults to tooltip-delay-show or 0ms if no input
           * @param {?=} delay
           * @return {?}
           */
        }, {
          key: "show",
          value: function show() {
            var _this3 = this;
            var delay = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : this.showDelay;
            if (this.disabled || !this.message || this._isTooltipVisible() && ! /** @type {?} */this._tooltipInstance._showTimeoutId && ! /** @type {?} */this._tooltipInstance._hideTimeoutId) {
              return;
            }
            /** @type {?} */
            var overlayRef = this._createOverlay();
            this._detach();
            this._portal = this._portal || new _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_10__["ComponentPortal"](TooltipComponent, this._viewContainerRef);
            this._tooltipInstance = overlayRef.attach(this._portal).instance;
            this._tooltipInstance.afterHidden().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_13__["takeUntil"])(this._destroyed)).subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this3._detach();
            });
            this._setTooltipClass(this._tooltipClass);
            this._updateTooltipMessage();
            /** @type {?} */this._tooltipInstance.show(delay);
          }
          /**
           * Hides the tooltip after the delay in ms, defaults to tooltip-delay-hide or 0ms if no input
           * @param {?=} delay
           * @return {?}
           */
        }, {
          key: "hide",
          value: function hide() {
            var delay = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : this.hideDelay;
            if (this._tooltipInstance) {
              this._tooltipInstance.hide(delay);
            }
          }
          /**
           * Shows/hides the tooltip
           * @return {?}
           */
        }, {
          key: "toggle",
          value: function toggle() {
            this._isTooltipVisible() ? this.hide() : this.show();
          }
          /**
           * Returns true if the tooltip is currently visible to the user
           * @return {?}
           */
        }, {
          key: "_isTooltipVisible",
          value: function _isTooltipVisible() {
            return !!this._tooltipInstance && this._tooltipInstance.isVisible();
          }
          /**
           * Create the overlay config and position strategy
           * @private
           * @return {?}
           */
        }, {
          key: "_createOverlay",
          value: function _createOverlay() {
            var _this4 = this;
            if (this._overlayRef) {
              return this._overlayRef;
            }
            /** @type {?} */
            var scrollableAncestors = this._scrollDispatcher.getAncestorScrollContainers(this._elementRef);
            // Create connected position strategy that listens for scroll events to reposition.
            /** @type {?} */
            var strategy = this._overlay.position().flexibleConnectedTo(this._elementRef).withTransformOriginOn('.mat-tooltip').withFlexibleDimensions(false).withViewportMargin(8).withScrollableContainers(scrollableAncestors);
            strategy.positionChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_13__["takeUntil"])(this._destroyed)).subscribe(
            /**
            * @param {?} change
            * @return {?}
            */
            function (change) {
              if (_this4._tooltipInstance) {
                if (change.scrollableViewProperties.isOverlayClipped && _this4._tooltipInstance.isVisible()) {
                  // After position changes occur and the overlay is clipped by
                  // a parent scrollable then close the tooltip.
                  _this4._ngZone.run(
                  /**
                  * @return {?}
                  */
                  function () {
                    return _this4.hide(0);
                  });
                }
              }
            });
            this._overlayRef = this._overlay.create({
              direction: this._dir,
              positionStrategy: strategy,
              panelClass: TOOLTIP_PANEL_CLASS,
              scrollStrategy: this._scrollStrategy()
            });
            this._updatePosition();
            this._overlayRef.detachments().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_13__["takeUntil"])(this._destroyed)).subscribe(
            /**
            * @return {?}
            */
            function () {
              return _this4._detach();
            });
            return this._overlayRef;
          }
          /**
           * Detaches the currently-attached tooltip.
           * @private
           * @return {?}
           */
        }, {
          key: "_detach",
          value: function _detach() {
            if (this._overlayRef && this._overlayRef.hasAttached()) {
              this._overlayRef.detach();
            }
            this._tooltipInstance = null;
          }
          /**
           * Updates the position of the current tooltip.
           * @private
           * @return {?}
           */
        }, {
          key: "_updatePosition",
          value: function _updatePosition() {
            /** @type {?} */
            var position = /** @type {?} */ /** @type {?} */this._overlayRef.getConfig().positionStrategy;
            /** @type {?} */
            var origin = this._getOrigin();
            /** @type {?} */
            var overlay = this._getOverlayPosition();
            position.withPositions([Object.assign(Object.assign({}, origin.main), overlay.main), Object.assign(Object.assign({}, origin.fallback), overlay.fallback)]);
          }
          /**
           * Returns the origin position and a fallback position based on the user's position preference.
           * The fallback position is the inverse of the origin (e.g. `'below' -> 'above'`).
           * @return {?}
           */
        }, {
          key: "_getOrigin",
          value: function _getOrigin() {
            /** @type {?} */
            var isLtr = !this._dir || this._dir.value == 'ltr';
            /** @type {?} */
            var position = this.position;
            /** @type {?} */
            var originPosition;
            if (position == 'above' || position == 'below') {
              originPosition = {
                originX: 'center',
                originY: position == 'above' ? 'top' : 'bottom'
              };
            } else if (position == 'before' || position == 'left' && isLtr || position == 'right' && !isLtr) {
              originPosition = {
                originX: 'start',
                originY: 'center'
              };
            } else if (position == 'after' || position == 'right' && isLtr || position == 'left' && !isLtr) {
              originPosition = {
                originX: 'end',
                originY: 'center'
              };
            } else {
              throw getMatTooltipInvalidPositionError(position);
            }
            var _this$_invertPosition = this._invertPosition(originPosition.originX, originPosition.originY),
              x = _this$_invertPosition.x,
              y = _this$_invertPosition.y;
            return {
              main: originPosition,
              fallback: {
                originX: x,
                originY: y
              }
            };
          }
          /**
           * Returns the overlay position and a fallback position based on the user's preference
           * @return {?}
           */
        }, {
          key: "_getOverlayPosition",
          value: function _getOverlayPosition() {
            /** @type {?} */
            var isLtr = !this._dir || this._dir.value == 'ltr';
            /** @type {?} */
            var position = this.position;
            /** @type {?} */
            var overlayPosition;
            if (position == 'above') {
              overlayPosition = {
                overlayX: 'center',
                overlayY: 'bottom'
              };
            } else if (position == 'below') {
              overlayPosition = {
                overlayX: 'center',
                overlayY: 'top'
              };
            } else if (position == 'before' || position == 'left' && isLtr || position == 'right' && !isLtr) {
              overlayPosition = {
                overlayX: 'end',
                overlayY: 'center'
              };
            } else if (position == 'after' || position == 'right' && isLtr || position == 'left' && !isLtr) {
              overlayPosition = {
                overlayX: 'start',
                overlayY: 'center'
              };
            } else {
              throw getMatTooltipInvalidPositionError(position);
            }
            var _this$_invertPosition2 = this._invertPosition(overlayPosition.overlayX, overlayPosition.overlayY),
              x = _this$_invertPosition2.x,
              y = _this$_invertPosition2.y;
            return {
              main: overlayPosition,
              fallback: {
                overlayX: x,
                overlayY: y
              }
            };
          }
          /**
           * Updates the tooltip message and repositions the overlay according to the new message length
           * @private
           * @return {?}
           */
        }, {
          key: "_updateTooltipMessage",
          value: function _updateTooltipMessage() {
            var _this5 = this;
            // Must wait for the message to be painted to the tooltip so that the overlay can properly
            // calculate the correct positioning based on the size of the text.
            if (this._tooltipInstance) {
              this._tooltipInstance.message = this.message;
              this._tooltipInstance._markForCheck();
              this._ngZone.onMicrotaskEmpty.asObservable().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_13__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_13__["takeUntil"])(this._destroyed)).subscribe(
              /**
              * @return {?}
              */
              function () {
                if (_this5._tooltipInstance) {
                  /** @type {?} */_this5._overlayRef.updatePosition();
                }
              });
            }
          }
          /**
           * Updates the tooltip class
           * @private
           * @param {?} tooltipClass
           * @return {?}
           */
        }, {
          key: "_setTooltipClass",
          value: function _setTooltipClass(tooltipClass) {
            if (this._tooltipInstance) {
              this._tooltipInstance.tooltipClass = tooltipClass;
              this._tooltipInstance._markForCheck();
            }
          }
          /**
           * Inverts an overlay position.
           * @private
           * @param {?} x
           * @param {?} y
           * @return {?}
           */
        }, {
          key: "_invertPosition",
          value: function _invertPosition(x, y) {
            if (this.position === 'above' || this.position === 'below') {
              if (y === 'top') {
                y = 'bottom';
              } else if (y === 'bottom') {
                y = 'top';
              }
            } else {
              if (x === 'end') {
                x = 'start';
              } else if (x === 'start') {
                x = 'end';
              }
            }
            return {
              x: x,
              y: y
            };
          }
          /**
           * Binds the pointer events to the tooltip trigger.
           * @private
           * @return {?}
           */
        }, {
          key: "_setupPointerEvents",
          value: function _setupPointerEvents() {
            var _this6 = this;
            // The mouse events shouldn't be bound on mobile devices, because they can prevent the
            // first tap from firing its click event or can cause the tooltip to open for clicks.
            if (!this._platform.IOS && !this._platform.ANDROID) {
              this._passiveListeners.set('mouseenter',
              /**
              * @return {?}
              */
              function () {
                return _this6.show();
              }).set('mouseleave',
              /**
              * @return {?}
              */
              function () {
                return _this6.hide();
              });
            } else if (this.touchGestures !== 'off') {
              this._disableNativeGesturesIfNecessary();
              /** @type {?} */
              var touchendListener =
              /**
              * @return {?}
              */
              function touchendListener() {
                clearTimeout(_this6._touchstartTimeout);
                _this6.hide(_this6._defaultOptions.touchendHideDelay);
              };
              this._passiveListeners.set('touchend', touchendListener).set('touchcancel', touchendListener).set('touchstart',
              /**
              * @return {?}
              */
              function () {
                // Note that it's important that we don't `preventDefault` here,
                // because it can prevent click events from firing on the element.
                clearTimeout(_this6._touchstartTimeout);
                _this6._touchstartTimeout = setTimeout(
                /**
                * @return {?}
                */
                function () {
                  return _this6.show();
                }, LONGPRESS_DELAY);
              });
            }
            this._passiveListeners.forEach(
            /**
            * @param {?} listener
            * @param {?} event
            * @return {?}
            */
            function (listener, event) {
              _this6._elementRef.nativeElement.addEventListener(event, listener, passiveListenerOptions);
            });
          }
          /**
           * Disables the native browser gestures, based on how the tooltip has been configured.
           * @private
           * @return {?}
           */
        }, {
          key: "_disableNativeGesturesIfNecessary",
          value: function _disableNativeGesturesIfNecessary() {
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            /** @type {?} */
            var style = element.style;
            /** @type {?} */
            var gestures = this.touchGestures;
            if (gestures !== 'off') {
              // If gestures are set to `auto`, we don't disable text selection on inputs and
              // textareas, because it prevents the user from typing into them on iOS Safari.
              if (gestures === 'on' || element.nodeName !== 'INPUT' && element.nodeName !== 'TEXTAREA') {
                style.userSelect = style.msUserSelect = style.webkitUserSelect = /** @type {?} */style.MozUserSelect = 'none';
              }
              // If we have `auto` gestures and the element uses native HTML dragging,
              // we don't set `-webkit-user-drag` because it prevents the native behavior.
              if (gestures === 'on' || !element.draggable) {
                /** @type {?} */style.webkitUserDrag = 'none';
              }
              style.touchAction = 'none';
              style.webkitTapHighlightColor = 'transparent';
            }
          }
        }]);
        return MatTooltip;
      }();
      MatTooltip.ɵfac = function MatTooltip_Factory(t) {
        return new (t || MatTooltip)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_11__["ScrollDispatcher"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_9__["Platform"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["AriaDescriber"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["FocusMonitor"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_TOOLTIP_SCROLL_STRATEGY), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_5__["Directionality"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](MAT_TOOLTIP_DEFAULT_OPTIONS, 8), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]));
      };
      MatTooltip.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineDirective"]({
        type: MatTooltip,
        selectors: [["", "matTooltip", ""]],
        inputs: {
          showDelay: ["matTooltipShowDelay", "showDelay"],
          hideDelay: ["matTooltipHideDelay", "hideDelay"],
          touchGestures: ["matTooltipTouchGestures", "touchGestures"],
          position: ["matTooltipPosition", "position"],
          disabled: ["matTooltipDisabled", "disabled"],
          message: ["matTooltip", "message"],
          tooltipClass: ["matTooltipClass", "tooltipClass"]
        },
        exportAs: ["matTooltip"]
      });
      /** @nocollapse */
      MatTooltip.ctorParameters = function () {
        return [{
          type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
        }, {
          type: _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_11__["ScrollDispatcher"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
        }, {
          type: _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_9__["Platform"]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["AriaDescriber"]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["FocusMonitor"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_TOOLTIP_SCROLL_STRATEGY]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_5__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [MAT_TOOLTIP_DEFAULT_OPTIONS]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
            args: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]]
          }]
        }];
      };
      MatTooltip.propDecorators = {
        position: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltipPosition']
        }],
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltipDisabled']
        }],
        showDelay: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltipShowDelay']
        }],
        hideDelay: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltipHideDelay']
        }],
        touchGestures: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltipTouchGestures']
        }],
        message: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltip']
        }],
        tooltipClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
          args: ['matTooltipClass']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatTooltip, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Directive"],
          args: [{
            selector: '[matTooltip]',
            exportAs: 'matTooltip'
          }]
        }], function () {
          return [{
            type: _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["Overlay"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]
          }, {
            type: _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_11__["ScrollDispatcher"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewContainerRef"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgZone"]
          }, {
            type: _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_9__["Platform"]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["AriaDescriber"]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["FocusMonitor"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_TOOLTIP_SCROLL_STRATEGY]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_5__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [MAT_TOOLTIP_DEFAULT_OPTIONS]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Inject"],
              args: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ElementRef"]]
            }]
          }];
        }, {
          showDelay: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltipShowDelay']
          }],
          hideDelay: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltipHideDelay']
          }],
          touchGestures: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltipTouchGestures']
          }],
          position: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltipPosition']
          }],
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltipDisabled']
          }],
          message: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltip']
          }],
          tooltipClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Input"],
            args: ['matTooltipClass']
          }]
        });
      })();
      if (false) {}
      /**
       * Internal component that wraps the tooltip's content.
       * \@docs-private
       */
      var TooltipComponent = /*#__PURE__*/function () {
        /**
         * @param {?} _changeDetectorRef
         * @param {?} _breakpointObserver
         */
        function TooltipComponent(_changeDetectorRef, _breakpointObserver) {
          _classCallCheck(this, TooltipComponent);
          this._changeDetectorRef = _changeDetectorRef;
          this._breakpointObserver = _breakpointObserver;
          /**
           * Property watched by the animation framework to show or hide the tooltip
           */
          this._visibility = 'initial';
          /**
           * Whether interactions on the page should close the tooltip
           */
          this._closeOnInteraction = false;
          /**
           * Subject for notifying that the tooltip has been hidden from the view
           */
          this._onHide = new rxjs__WEBPACK_IMPORTED_MODULE_12__["Subject"]();
          /**
           * Stream that emits whether the user has a handset-sized display.
           */
          this._isHandset = this._breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_8__["Breakpoints"].Handset);
        }
        /**
         * Shows the tooltip with an animation originating from the provided origin
         * @param {?} delay Amount of milliseconds to the delay showing the tooltip.
         * @return {?}
         */
        _createClass(TooltipComponent, [{
          key: "show",
          value: function show(delay) {
            var _this7 = this;
            // Cancel the delayed hide if it is scheduled
            if (this._hideTimeoutId) {
              clearTimeout(this._hideTimeoutId);
              this._hideTimeoutId = null;
            }
            // Body interactions should cancel the tooltip if there is a delay in showing.
            this._closeOnInteraction = true;
            this._showTimeoutId = setTimeout(
            /**
            * @return {?}
            */
            function () {
              _this7._visibility = 'visible';
              _this7._showTimeoutId = null;
              // Mark for check so if any parent component has set the
              // ChangeDetectionStrategy to OnPush it will be checked anyways
              _this7._markForCheck();
            }, delay);
          }
          /**
           * Begins the animation to hide the tooltip after the provided delay in ms.
           * @param {?} delay Amount of milliseconds to delay showing the tooltip.
           * @return {?}
           */
        }, {
          key: "hide",
          value: function hide(delay) {
            var _this8 = this;
            // Cancel the delayed show if it is scheduled
            if (this._showTimeoutId) {
              clearTimeout(this._showTimeoutId);
              this._showTimeoutId = null;
            }
            this._hideTimeoutId = setTimeout(
            /**
            * @return {?}
            */
            function () {
              _this8._visibility = 'hidden';
              _this8._hideTimeoutId = null;
              // Mark for check so if any parent component has set the
              // ChangeDetectionStrategy to OnPush it will be checked anyways
              _this8._markForCheck();
            }, delay);
          }
          /**
           * Returns an observable that notifies when the tooltip has been hidden from view.
           * @return {?}
           */
        }, {
          key: "afterHidden",
          value: function afterHidden() {
            return this._onHide.asObservable();
          }
          /**
           * Whether the tooltip is being displayed.
           * @return {?}
           */
        }, {
          key: "isVisible",
          value: function isVisible() {
            return this._visibility === 'visible';
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._onHide.complete();
          }
          /**
           * @return {?}
           */
        }, {
          key: "_animationStart",
          value: function _animationStart() {
            this._closeOnInteraction = false;
          }
          /**
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_animationDone",
          value: function _animationDone(event) {
            /** @type {?} */
            var toState = /** @type {?} */event.toState;
            if (toState === 'hidden' && !this.isVisible()) {
              this._onHide.next();
            }
            if (toState === 'visible' || toState === 'hidden') {
              this._closeOnInteraction = true;
            }
          }
          /**
           * Interactions on the HTML body should close the tooltip immediately as defined in the
           * material design spec.
           * https://material.io/design/components/tooltips.html#behavior
           * @return {?}
           */
        }, {
          key: "_handleBodyInteraction",
          value: function _handleBodyInteraction() {
            if (this._closeOnInteraction) {
              this.hide(0);
            }
          }
          /**
           * Marks that the tooltip needs to be checked in the next change detection run.
           * Mainly used for rendering the initial text before positioning a tooltip, which
           * can be problematic in components with OnPush change detection.
           * @return {?}
           */
        }, {
          key: "_markForCheck",
          value: function _markForCheck() {
            this._changeDetectorRef.markForCheck();
          }
        }]);
        return TooltipComponent;
      }();
      TooltipComponent.ɵfac = function TooltipComponent_Factory(t) {
        return new (t || TooltipComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_8__["BreakpointObserver"]));
      };
      TooltipComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
        type: TooltipComponent,
        selectors: [["mat-tooltip-component"]],
        hostAttrs: ["aria-hidden", "true"],
        hostVars: 2,
        hostBindings: function TooltipComponent_HostBindings(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("click", function TooltipComponent_click_HostBindingHandler() {
              return ctx._handleBodyInteraction();
            }, false, _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵresolveBody"]);
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵstyleProp"]("zoom", ctx._visibility === "visible" ? 1 : null);
          }
        },
        decls: 3,
        vars: 7,
        consts: [[1, "mat-tooltip", 3, "ngClass"]],
        template: function TooltipComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "div", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("@state.start", function TooltipComponent_Template_div_animation_state_start_0_listener() {
              return ctx._animationStart();
            })("@state.done", function TooltipComponent_Template_div_animation_state_done_0_listener($event) {
              return ctx._animationDone($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](1, "async");
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            var tmp_0_0 = null;
            var currVal_0 = (tmp_0_0 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](1, 5, ctx._isHandset)) == null ? null : tmp_0_0.matches;
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵclassProp"]("mat-tooltip-handset", currVal_0);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngClass", ctx.tooltipClass)("@state", ctx._visibility);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](ctx.message);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["NgClass"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["AsyncPipe"]],
        styles: [".mat-tooltip-panel{pointer-events:none !important}.mat-tooltip{color:#fff;border-radius:4px;margin:14px;max-width:250px;padding-left:8px;padding-right:8px;overflow:hidden;text-overflow:ellipsis}.cdk-high-contrast-active .mat-tooltip{outline:solid 1px}.mat-tooltip-handset{margin:24px;padding-left:16px;padding-right:16px}\n"],
        encapsulation: 2,
        data: {
          animation: [matTooltipAnimations.tooltipState]
        },
        changeDetection: 0
      });
      /** @nocollapse */
      TooltipComponent.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]
        }, {
          type: _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_8__["BreakpointObserver"]
        }];
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](TooltipComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["Component"],
          args: [{
            selector: 'mat-tooltip-component',
            template: "<div class=\"mat-tooltip\"\n     [ngClass]=\"tooltipClass\"\n     [class.mat-tooltip-handset]=\"(_isHandset | async)?.matches\"\n     [@state]=\"_visibility\"\n     (@state.start)=\"_animationStart()\"\n     (@state.done)=\"_animationDone($event)\">{{message}}</div>\n",
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ViewEncapsulation"].None,
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectionStrategy"].OnPush,
            animations: [matTooltipAnimations.tooltipState],
            host: {
              // Forces the element to have a layout in IE and Edge. This fixes issues where the element
              // won't be rendered if the animations are disabled or there is no web animations polyfill.
              '[style.zoom]': '_visibility === "visible" ? 1 : null',
              '(body:click)': 'this._handleBodyInteraction()',
              'aria-hidden': 'true'
            },
            styles: [".mat-tooltip-panel{pointer-events:none !important}.mat-tooltip{color:#fff;border-radius:4px;margin:14px;max-width:250px;padding-left:8px;padding-right:8px;overflow:hidden;text-overflow:ellipsis}.cdk-high-contrast-active .mat-tooltip{outline:solid 1px}.mat-tooltip-handset{margin:24px;padding-left:16px;padding-right:16px}\n"]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["ChangeDetectorRef"]
          }, {
            type: _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_8__["BreakpointObserver"]
          }];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/tooltip/tooltip-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var MatTooltipModule = /*#__PURE__*/_createClass(function MatTooltipModule() {
        _classCallCheck(this, MatTooltipModule);
      });
      MatTooltipModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
        type: MatTooltipModule
      });
      MatTooltipModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
        factory: function MatTooltipModule_Factory(t) {
          return new (t || MatTooltipModule)();
        },
        providers: [MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY_PROVIDER],
        imports: [[_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](MatTooltipModule, {
          declarations: function declarations() {
            return [MatTooltip, TooltipComponent];
          },
          imports: function imports() {
            return [_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]];
          },
          exports: function exports() {
            return [MatTooltip, TooltipComponent, _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵsetClassMetadata"](MatTooltipModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"],
          args: [{
            imports: [_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_cdk_overlay__WEBPACK_IMPORTED_MODULE_0__["OverlayModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]],
            exports: [MatTooltip, TooltipComponent, _angular_material_core__WEBPACK_IMPORTED_MODULE_4__["MatCommonModule"]],
            declarations: [MatTooltip, TooltipComponent],
            entryComponents: [TooltipComponent],
            providers: [MAT_TOOLTIP_SCROLL_STRATEGY_FACTORY_PROVIDER]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/tooltip/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=tooltip.js.map

      /***/
    }
  }]);
})();
//# sourceMappingURL=default~data-table-paginator-paginator-module~data-table-table-tables-module~popups-and-modals-toolt~e6ac625a-es5.js.map