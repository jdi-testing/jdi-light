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
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["data-table-table-tables-module"], {
    /***/"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/drag-drop.js":
    /*!**********************************************************************!*\
      !*** ./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/drag-drop.js ***!
      \**********************************************************************/
    /*! exports provided: CDK_DRAG_CONFIG, CDK_DRAG_CONFIG_FACTORY, CDK_DROP_LIST, CdkDrag, CdkDragHandle, CdkDragPlaceholder, CdkDragPreview, CdkDropList, CdkDropListGroup, DragDrop, DragDropModule, DragDropRegistry, DragRef, DropListRef, copyArrayItem, moveItemInArray, transferArrayItem, ɵangular_material_src_cdk_drag_drop_drag_drop_b */
    /***/
    function node_modulesAngularCdk__ivy_ngcc__Fesm2015DragDropJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CDK_DRAG_CONFIG", function () {
        return CDK_DRAG_CONFIG;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CDK_DRAG_CONFIG_FACTORY", function () {
        return CDK_DRAG_CONFIG_FACTORY;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CDK_DROP_LIST", function () {
        return CDK_DROP_LIST;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CdkDrag", function () {
        return CdkDrag;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CdkDragHandle", function () {
        return CdkDragHandle;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CdkDragPlaceholder", function () {
        return CdkDragPlaceholder;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CdkDragPreview", function () {
        return CdkDragPreview;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CdkDropList", function () {
        return CdkDropList;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CdkDropListGroup", function () {
        return CdkDropListGroup;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DragDrop", function () {
        return DragDrop;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DragDropModule", function () {
        return DragDropModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DragDropRegistry", function () {
        return DragDropRegistry;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DragRef", function () {
        return DragRef;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DropListRef", function () {
        return DropListRef;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "copyArrayItem", function () {
        return copyArrayItem;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "moveItemInArray", function () {
        return moveItemInArray;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "transferArrayItem", function () {
        return transferArrayItem;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ɵangular_material_src_cdk_drag_drop_drag_drop_b", function () {
        return CDK_DRAG_PARENT;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/cdk/scrolling */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/scrolling.js");
      /* harmony import */
      var _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/cdk/platform */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/platform.js");
      /* harmony import */
      var _angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/cdk/coercion */"./node_modules/@angular/cdk/fesm2015/coercion.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/cdk/bidi */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/bidi.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-styling.ts
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
       * Extended CSSStyleDeclaration that includes a couple of drag-related
       * properties that aren't in the built-in TS typings.
       * @record
       */

      function DragCSSStyleDeclaration() {}
      if (false) {}
      /**
       * Shallow-extends a stylesheet object with another stylesheet object.
       * \@docs-private
       * @param {?} dest
       * @param {?} source
       * @return {?}
       */
      function extendStyles(dest, source) {
        for (var key in source) {
          if (source.hasOwnProperty(key)) {
            dest[key] = /** @type {?} */source[key];
          }
        }
        return dest;
      }
      /**
       * Toggles whether the native drag interactions should be enabled for an element.
       * \@docs-private
       * @param {?} element Element on which to toggle the drag interactions.
       * @param {?} enable Whether the drag interactions should be enabled.
       * @return {?}
       */
      function toggleNativeDragInteractions(element, enable) {
        /** @type {?} */
        var userSelect = enable ? '' : 'none';
        extendStyles(element.style, {
          touchAction: enable ? '' : 'none',
          webkitUserDrag: enable ? '' : 'none',
          webkitTapHighlightColor: enable ? '' : 'transparent',
          userSelect: userSelect,
          msUserSelect: userSelect,
          webkitUserSelect: userSelect,
          MozUserSelect: userSelect
        });
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/transition-duration.ts
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
       * Parses a CSS time value to milliseconds.
       * @param {?} value
       * @return {?}
       */
      function parseCssTimeUnitsToMs(value) {
        // Some browsers will return it in seconds, whereas others will return milliseconds.
        /** @type {?} */
        var multiplier = value.toLowerCase().indexOf('ms') > -1 ? 1 : 1000;
        return parseFloat(value) * multiplier;
      }
      /**
       * Gets the transform transition duration, including the delay, of an element in milliseconds.
       * @param {?} element
       * @return {?}
       */
      function getTransformTransitionDurationInMs(element) {
        /** @type {?} */
        var computedStyle = getComputedStyle(element);
        /** @type {?} */
        var transitionedProperties = parseCssPropertyValue(computedStyle, 'transition-property');
        /** @type {?} */
        var property = transitionedProperties.find(
        /**
        * @param {?} prop
        * @return {?}
        */
        function (prop) {
          return prop === 'transform' || prop === 'all';
        });
        // If there's no transition for `all` or `transform`, we shouldn't do anything.
        if (!property) {
          return 0;
        }
        // Get the index of the property that we're interested in and match
        // it up to the same index in `transition-delay` and `transition-duration`.
        /** @type {?} */
        var propertyIndex = transitionedProperties.indexOf(property);
        /** @type {?} */
        var rawDurations = parseCssPropertyValue(computedStyle, 'transition-duration');
        /** @type {?} */
        var rawDelays = parseCssPropertyValue(computedStyle, 'transition-delay');
        return parseCssTimeUnitsToMs(rawDurations[propertyIndex]) + parseCssTimeUnitsToMs(rawDelays[propertyIndex]);
      }
      /**
       * Parses out multiple values from a computed style into an array.
       * @param {?} computedStyle
       * @param {?} name
       * @return {?}
       */
      function parseCssPropertyValue(computedStyle, name) {
        /** @type {?} */
        var value = computedStyle.getPropertyValue(name);
        return value.split(',').map(
        /**
        * @param {?} part
        * @return {?}
        */
        function (part) {
          return part.trim();
        });
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-ref.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Object that can be used to configure the behavior of DragRef.
       * @record
       */
      function DragRefConfig() {}
      if (false) {}
      /**
       * Options that can be used to bind a passive event listener.
       * @type {?}
       */
      var passiveEventListenerOptions = Object(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_3__["normalizePassiveListenerOptions"])({
        passive: true
      });
      /**
       * Options that can be used to bind an active event listener.
       * @type {?}
       */
      var activeEventListenerOptions = Object(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_3__["normalizePassiveListenerOptions"])({
        passive: false
      });
      /**
       * Time in milliseconds for which to ignore mouse events, after
       * receiving a touch event. Used to avoid doing double work for
       * touch devices where the browser fires fake mouse events, in
       * addition to touch events.
       * @type {?}
       */
      var MOUSE_EVENT_IGNORE_TIME = 800;
      /**
       * Internal compile-time-only representation of a `DragRef`.
       * Used to avoid circular import issues between the `DragRef` and the `DropListRef`.
       * \@docs-private
       * @record
       */
      function DragRefInternal() {}
      /**
       * Template that can be used to create a drag helper element (e.g. a preview or a placeholder).
       * @record
       * @template T
       */
      function DragHelperTemplate() {}
      if (false) {}
      /**
       * Template that can be used to create a drag preview element.
       * @record
       * @template T
       */
      function DragPreviewTemplate() {}
      if (false) {}
      /**
       * Point on the page or within an element.
       * @record
       */
      function Point() {}
      if (false) {}
      /**
       * Reference to a draggable item. Used to manipulate or dispose of the item.
       * @template T
       */
      var DragRef = /*#__PURE__*/function () {
        /**
         * @param {?} element
         * @param {?} _config
         * @param {?} _document
         * @param {?} _ngZone
         * @param {?} _viewportRuler
         * @param {?} _dragDropRegistry
         */
        function DragRef(element, _config, _document, _ngZone, _viewportRuler, _dragDropRegistry) {
          var _this = this;
          _classCallCheck(this, DragRef);
          this._config = _config;
          this._document = _document;
          this._ngZone = _ngZone;
          this._viewportRuler = _viewportRuler;
          this._dragDropRegistry = _dragDropRegistry;
          /**
           * CSS `transform` applied to the element when it isn't being dragged. We need a
           * passive transform in order for the dragged element to retain its new position
           * after the user has stopped dragging and because we need to know the relative
           * position in case they start dragging again. This corresponds to `element.style.transform`.
           */
          this._passiveTransform = {
            x: 0,
            y: 0
          };
          /**
           * CSS `transform` that is applied to the element while it's being dragged.
           */
          this._activeTransform = {
            x: 0,
            y: 0
          };
          /**
           * Emits when the item is being moved.
           */
          this._moveEvents = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Subscription to pointer movement events.
           */
          this._pointerMoveSubscription = rxjs__WEBPACK_IMPORTED_MODULE_5__["Subscription"].EMPTY;
          /**
           * Subscription to the event that is dispatched when the user lifts their pointer.
           */
          this._pointerUpSubscription = rxjs__WEBPACK_IMPORTED_MODULE_5__["Subscription"].EMPTY;
          /**
           * Subscription to the viewport being scrolled.
           */
          this._scrollSubscription = rxjs__WEBPACK_IMPORTED_MODULE_5__["Subscription"].EMPTY;
          /**
           * Subscription to the viewport being resized.
           */
          this._resizeSubscription = rxjs__WEBPACK_IMPORTED_MODULE_5__["Subscription"].EMPTY;
          /**
           * Cached reference to the boundary element.
           */
          this._boundaryElement = null;
          /**
           * Whether the native dragging interactions have been enabled on the root element.
           */
          this._nativeInteractionsEnabled = true;
          /**
           * Elements that can be used to drag the draggable item.
           */
          this._handles = [];
          /**
           * Registered handles that are currently disabled.
           */
          this._disabledHandles = new Set();
          /**
           * Layout direction of the item.
           */
          this._direction = 'ltr';
          /**
           * Amount of milliseconds to wait after the user has put their
           * pointer down before starting to drag the element.
           */
          this.dragStartDelay = 0;
          this._disabled = false;
          /**
           * Emits as the drag sequence is being prepared.
           */
          this.beforeStarted = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user starts dragging the item.
           */
          this.started = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user has released a drag item, before any animations have started.
           */
          this.released = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user stops dragging an item in the container.
           */
          this.ended = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user has moved the item into a new container.
           */
          this.entered = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user removes the item its container by dragging it into another container.
           */
          this.exited = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user drops the item inside a container.
           */
          this.dropped = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits as the user is dragging the item. Use with caution,
           * because this event will fire for every pixel that the user has dragged.
           */
          this.moved = this._moveEvents.asObservable();
          /**
           * Handler for the `mousedown`/`touchstart` events.
           */
          this._pointerDown =
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            _this.beforeStarted.next();
            // Delegate the event based on whether it started from a handle or the element itself.
            if (_this._handles.length) {
              /** @type {?} */
              var targetHandle = _this._handles.find(
              /**
              * @param {?} handle
              * @return {?}
              */
              function (handle) {
                /** @type {?} */
                var target = event.target;
                return !!target && (target === handle || handle.contains( /** @type {?} */target));
              });
              if (targetHandle && !_this._disabledHandles.has(targetHandle) && !_this.disabled) {
                _this._initializeDragSequence(targetHandle, event);
              }
            } else if (!_this.disabled) {
              _this._initializeDragSequence(_this._rootElement, event);
            }
          };
          /**
           * Handler that is invoked when the user moves their pointer after they've initiated a drag.
           */
          this._pointerMove =
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            // Prevent the default action as early as possible in order to block
            // native actions like dragging the selected text or images with the mouse.
            event.preventDefault();
            if (!_this._hasStartedDragging) {
              /** @type {?} */
              var pointerPosition = _this._getPointerPositionOnPage(event);
              /** @type {?} */
              var distanceX = Math.abs(pointerPosition.x - _this._pickupPositionOnPage.x);
              /** @type {?} */
              var distanceY = Math.abs(pointerPosition.y - _this._pickupPositionOnPage.y);
              /** @type {?} */
              var isOverThreshold = distanceX + distanceY >= _this._config.dragStartThreshold;
              // Only start dragging after the user has moved more than the minimum distance in either
              // direction. Note that this is preferrable over doing something like `skip(minimumDistance)`
              // in the `pointerMove` subscription, because we're not guaranteed to have one move event
              // per pixel of movement (e.g. if the user moves their pointer quickly).
              if (isOverThreshold) {
                /** @type {?} */
                var isDelayElapsed = Date.now() >= _this._dragStartTime + _this._getDragStartDelay(event);
                if (!isDelayElapsed) {
                  _this._endDragSequence(event);
                  return;
                }
                // Prevent other drag sequences from starting while something in the container is still
                // being dragged. This can happen while we're waiting for the drop animation to finish
                // and can cause errors, because some elements might still be moving around.
                if (!_this._dropContainer || !_this._dropContainer.isDragging()) {
                  _this._hasStartedDragging = true;
                  _this._ngZone.run(
                  /**
                  * @return {?}
                  */
                  function () {
                    return _this._startDragSequence(event);
                  });
                }
              }
              return;
            }
            // We only need the preview dimensions if we have a boundary element.
            if (_this._boundaryElement) {
              // Cache the preview element rect if we haven't cached it already or if
              // we cached it too early before the element dimensions were computed.
              if (!_this._previewRect || !_this._previewRect.width && !_this._previewRect.height) {
                _this._previewRect = (_this._preview || _this._rootElement).getBoundingClientRect();
              }
            }
            /** @type {?} */
            var constrainedPointerPosition = _this._getConstrainedPointerPosition(event);
            _this._hasMoved = true;
            _this._updatePointerDirectionDelta(constrainedPointerPosition);
            if (_this._dropContainer) {
              _this._updateActiveDropContainer(constrainedPointerPosition);
            } else {
              /** @type {?} */
              var activeTransform = _this._activeTransform;
              activeTransform.x = constrainedPointerPosition.x - _this._pickupPositionOnPage.x + _this._passiveTransform.x;
              activeTransform.y = constrainedPointerPosition.y - _this._pickupPositionOnPage.y + _this._passiveTransform.y;
              _this._applyRootElementTransform(activeTransform.x, activeTransform.y);
              // Apply transform as attribute if dragging and svg element to work for IE
              if (typeof SVGElement !== 'undefined' && _this._rootElement instanceof SVGElement) {
                /** @type {?} */
                var appliedTransform = "translate(".concat(activeTransform.x, " ").concat(activeTransform.y, ")");
                _this._rootElement.setAttribute('transform', appliedTransform);
              }
            }
            // Since this event gets fired for every pixel while dragging, we only
            // want to fire it if the consumer opted into it. Also we have to
            // re-enter the zone because we run all of the events on the outside.
            if (_this._moveEvents.observers.length) {
              _this._ngZone.run(
              /**
              * @return {?}
              */
              function () {
                _this._moveEvents.next({
                  source: _this,
                  pointerPosition: constrainedPointerPosition,
                  event: event,
                  distance: _this._getDragDistance(constrainedPointerPosition),
                  delta: _this._pointerDirectionDelta
                });
              });
            }
          };
          /**
           * Handler that is invoked when the user lifts their pointer up, after initiating a drag.
           */
          this._pointerUp =
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            _this._endDragSequence(event);
          };
          this.withRootElement(element);
          _dragDropRegistry.registerDragItem(this);
        }
        /**
         * Whether starting to drag this element is disabled.
         * @return {?}
         */
        _createClass(DragRef, [{
          key: "disabled",
          get: function get() {
            return this._disabled || !!(this._dropContainer && this._dropContainer.disabled);
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            /** @type {?} */
            var newValue = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(value);
            if (newValue !== this._disabled) {
              this._disabled = newValue;
              this._toggleNativeDragInteractions();
            }
          }
          /**
           * Returns the element that is being used as a placeholder
           * while the current element is being dragged.
           * @return {?}
           */
        }, {
          key: "getPlaceholderElement",
          value: function getPlaceholderElement() {
            return this._placeholder;
          }
          /**
           * Returns the root draggable element.
           * @return {?}
           */
        }, {
          key: "getRootElement",
          value: function getRootElement() {
            return this._rootElement;
          }
          /**
           * Gets the currently-visible element that represents the drag item.
           * While dragging this is the placeholder, otherwise it's the root element.
           * @return {?}
           */
        }, {
          key: "getVisibleElement",
          value: function getVisibleElement() {
            return this.isDragging() ? this.getPlaceholderElement() : this.getRootElement();
          }
          /**
           * Registers the handles that can be used to drag the element.
           * @template THIS
           * @this {THIS}
           * @param {?} handles
           * @return {THIS}
           */
        }, {
          key: "withHandles",
          value: function withHandles(handles) {
            /** @type {?} */this._handles = handles.map(
            /**
            * @param {?} handle
            * @return {?}
            */
            function (handle) {
              return Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(handle);
            });
            /** @type {?} */this._handles.forEach(
            /**
            * @param {?} handle
            * @return {?}
            */
            function (handle) {
              return toggleNativeDragInteractions(handle, false);
            });
            /** @type {?} */this._toggleNativeDragInteractions();
            return (/** @type {?} */this
            );
          }
          /**
           * Registers the template that should be used for the drag preview.
           * @template THIS
           * @this {THIS}
           * @param {?} template Template that from which to stamp out the preview.
           * @return {THIS}
           */
        }, {
          key: "withPreviewTemplate",
          value: function withPreviewTemplate(template) {
            /** @type {?} */this._previewTemplate = template;
            return (/** @type {?} */this
            );
          }
          /**
           * Registers the template that should be used for the drag placeholder.
           * @template THIS
           * @this {THIS}
           * @param {?} template Template that from which to stamp out the placeholder.
           * @return {THIS}
           */
        }, {
          key: "withPlaceholderTemplate",
          value: function withPlaceholderTemplate(template) {
            /** @type {?} */this._placeholderTemplate = template;
            return (/** @type {?} */this
            );
          }
          /**
           * Sets an alternate drag root element. The root element is the element that will be moved as
           * the user is dragging. Passing an alternate root element is useful when trying to enable
           * dragging on an element that you might not have access to.
           * @template THIS
           * @this {THIS}
           * @param {?} rootElement
           * @return {THIS}
           */
        }, {
          key: "withRootElement",
          value: function withRootElement(rootElement) {
            /** @type {?} */
            var element = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(rootElement);
            if (element !== /** @type {?} */this._rootElement) {
              if ( /** @type {?} */this._rootElement) {
                /** @type {?} */this._removeRootElementListeners( /** @type {?} */this._rootElement);
              }
              element.addEventListener('mousedown', /** @type {?} */this._pointerDown, activeEventListenerOptions);
              element.addEventListener('touchstart', /** @type {?} */this._pointerDown, passiveEventListenerOptions);
              /** @type {?} */this._initialTransform = undefined;
              /** @type {?} */this._rootElement = element;
            }
            return (/** @type {?} */this
            );
          }
          /**
           * Element to which the draggable's position will be constrained.
           * @template THIS
           * @this {THIS}
           * @param {?} boundaryElement
           * @return {THIS}
           */
        }, {
          key: "withBoundaryElement",
          value: function withBoundaryElement(boundaryElement) {
            var _this2 = this;
            /** @type {?} */this._boundaryElement = boundaryElement ? Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(boundaryElement) : null;
            /** @type {?} */this._resizeSubscription.unsubscribe();
            if (boundaryElement) {
              /** @type {?} */this._resizeSubscription = /** @type {?} */this._viewportRuler.change(10).subscribe(
              /**
              * @return {?}
              */
              function () {
                return (/** @type {?} */_this2._containInsideBoundaryOnResize()
                );
              });
            }
            return (/** @type {?} */this
            );
          }
          /**
           * Removes the dragging functionality from the DOM element.
           * @return {?}
           */
        }, {
          key: "dispose",
          value: function dispose() {
            this._removeRootElementListeners(this._rootElement);
            // Do this check before removing from the registry since it'll
            // stop being considered as dragged once it is removed.
            if (this.isDragging()) {
              // Since we move out the element to the end of the body while it's being
              // dragged, we have to make sure that it's removed if it gets destroyed.
              removeNode(this._rootElement);
            }
            removeNode(this._anchor);
            this._destroyPreview();
            this._destroyPlaceholder();
            this._dragDropRegistry.removeDragItem(this);
            this._removeSubscriptions();
            this.beforeStarted.complete();
            this.started.complete();
            this.released.complete();
            this.ended.complete();
            this.entered.complete();
            this.exited.complete();
            this.dropped.complete();
            this._moveEvents.complete();
            this._handles = [];
            this._disabledHandles.clear();
            this._dropContainer = undefined;
            this._resizeSubscription.unsubscribe();
            this._boundaryElement = this._rootElement = this._placeholderTemplate = this._previewTemplate = this._anchor = /** @type {?} */null;
          }
          /**
           * Checks whether the element is currently being dragged.
           * @return {?}
           */
        }, {
          key: "isDragging",
          value: function isDragging() {
            return this._hasStartedDragging && this._dragDropRegistry.isDragging(this);
          }
          /**
           * Resets a standalone drag item to its initial position.
           * @return {?}
           */
        }, {
          key: "reset",
          value: function reset() {
            this._rootElement.style.transform = this._initialTransform || '';
            this._activeTransform = {
              x: 0,
              y: 0
            };
            this._passiveTransform = {
              x: 0,
              y: 0
            };
          }
          /**
           * Sets a handle as disabled. While a handle is disabled, it'll capture and interrupt dragging.
           * @param {?} handle Handle element that should be disabled.
           * @return {?}
           */
        }, {
          key: "disableHandle",
          value: function disableHandle(handle) {
            if (this._handles.indexOf(handle) > -1) {
              this._disabledHandles.add(handle);
            }
          }
          /**
           * Enables a handle, if it has been disabled.
           * @param {?} handle Handle element to be enabled.
           * @return {?}
           */
        }, {
          key: "enableHandle",
          value: function enableHandle(handle) {
            this._disabledHandles["delete"](handle);
          }
          /**
           * Sets the layout direction of the draggable item.
           * @template THIS
           * @this {THIS}
           * @param {?} direction
           * @return {THIS}
           */
        }, {
          key: "withDirection",
          value: function withDirection(direction) {
            /** @type {?} */this._direction = direction;
            return (/** @type {?} */this
            );
          }
          /**
           * Sets the container that the item is part of.
           * @param {?} container
           * @return {?}
           */
        }, {
          key: "_withDropContainer",
          value: function _withDropContainer(container) {
            this._dropContainer = container;
          }
          /**
           * Gets the current position in pixels the draggable outside of a drop container.
           * @return {?}
           */
        }, {
          key: "getFreeDragPosition",
          value: function getFreeDragPosition() {
            /** @type {?} */
            var position = this.isDragging() ? this._activeTransform : this._passiveTransform;
            return {
              x: position.x,
              y: position.y
            };
          }
          /**
           * Sets the current position in pixels the draggable outside of a drop container.
           * @template THIS
           * @this {THIS}
           * @param {?} value New position to be set.
           * @return {THIS}
           */
        }, {
          key: "setFreeDragPosition",
          value: function setFreeDragPosition(value) {
            /** @type {?} */this._activeTransform = {
              x: 0,
              y: 0
            };
            /** @type {?} */this._passiveTransform.x = value.x;
            /** @type {?} */this._passiveTransform.y = value.y;
            if (! /** @type {?} */this._dropContainer) {
              /** @type {?} */this._applyRootElementTransform(value.x, value.y);
            }
            return (/** @type {?} */this
            );
          }
          /**
           * Updates the item's sort order based on the last-known pointer position.
           * @return {?}
           */
        }, {
          key: "_sortFromLastPointerPosition",
          value: function _sortFromLastPointerPosition() {
            /** @type {?} */
            var position = this._pointerPositionAtLastDirectionChange;
            if (position && this._dropContainer) {
              this._updateActiveDropContainer(position);
            }
          }
          /**
           * Unsubscribes from the global subscriptions.
           * @private
           * @return {?}
           */
        }, {
          key: "_removeSubscriptions",
          value: function _removeSubscriptions() {
            this._pointerMoveSubscription.unsubscribe();
            this._pointerUpSubscription.unsubscribe();
            this._scrollSubscription.unsubscribe();
          }
          /**
           * Destroys the preview element and its ViewRef.
           * @private
           * @return {?}
           */
        }, {
          key: "_destroyPreview",
          value: function _destroyPreview() {
            if (this._preview) {
              removeNode(this._preview);
            }
            if (this._previewRef) {
              this._previewRef.destroy();
            }
            this._preview = this._previewRef = /** @type {?} */null;
          }
          /**
           * Destroys the placeholder element and its ViewRef.
           * @private
           * @return {?}
           */
        }, {
          key: "_destroyPlaceholder",
          value: function _destroyPlaceholder() {
            if (this._placeholder) {
              removeNode(this._placeholder);
            }
            if (this._placeholderRef) {
              this._placeholderRef.destroy();
            }
            this._placeholder = this._placeholderRef = /** @type {?} */null;
          }
          /**
           * Clears subscriptions and stops the dragging sequence.
           * @private
           * @param {?} event Browser event object that ended the sequence.
           * @return {?}
           */
        }, {
          key: "_endDragSequence",
          value: function _endDragSequence(event) {
            var _this3 = this;
            // Note that here we use `isDragging` from the service, rather than from `this`.
            // The difference is that the one from the service reflects whether a dragging sequence
            // has been initiated, whereas the one on `this` includes whether the user has passed
            // the minimum dragging threshold.
            if (!this._dragDropRegistry.isDragging(this)) {
              return;
            }
            this._removeSubscriptions();
            this._dragDropRegistry.stopDragging(this);
            this._toggleNativeDragInteractions();
            if (this._handles) {
              this._rootElement.style.webkitTapHighlightColor = this._rootElementTapHighlight;
            }
            if (!this._hasStartedDragging) {
              return;
            }
            this.released.next({
              source: this
            });
            if (this._dropContainer) {
              // Stop scrolling immediately, instead of waiting for the animation to finish.
              this._dropContainer._stopScrolling();
              this._animatePreviewToPlaceholder().then(
              /**
              * @return {?}
              */
              function () {
                _this3._cleanupDragArtifacts(event);
                _this3._cleanupCachedDimensions();
                _this3._dragDropRegistry.stopDragging(_this3);
              });
            } else {
              // Convert the active transform into a passive one. This means that next time
              // the user starts dragging the item, its position will be calculated relatively
              // to the new passive transform.
              this._passiveTransform.x = this._activeTransform.x;
              this._passiveTransform.y = this._activeTransform.y;
              this._ngZone.run(
              /**
              * @return {?}
              */
              function () {
                _this3.ended.next({
                  source: _this3,
                  distance: _this3._getDragDistance(_this3._getPointerPositionOnPage(event))
                });
              });
              this._cleanupCachedDimensions();
              this._dragDropRegistry.stopDragging(this);
            }
          }
          /**
           * Starts the dragging sequence.
           * @private
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_startDragSequence",
          value: function _startDragSequence(event) {
            // Emit the event on the item before the one on the container.
            this.started.next({
              source: this
            });
            if (isTouchEvent(event)) {
              this._lastTouchEventTime = Date.now();
            }
            this._toggleNativeDragInteractions();
            if (this._dropContainer) {
              /** @type {?} */
              var element = this._rootElement;
              /** @type {?} */
              var parent = /** @type {?} */element.parentNode;
              /** @type {?} */
              var preview = this._preview = this._createPreviewElement();
              /** @type {?} */
              var placeholder = this._placeholder = this._createPlaceholderElement();
              /** @type {?} */
              var anchor = this._anchor = this._anchor || this._document.createComment('');
              // Insert an anchor node so that we can restore the element's position in the DOM.
              parent.insertBefore(anchor, element);
              // We move the element out at the end of the body and we make it hidden, because keeping it in
              // place will throw off the consumer's `:last-child` selectors. We can't remove the element
              // from the DOM completely, because iOS will stop firing all subsequent events in the chain.
              element.style.display = 'none';
              this._document.body.appendChild(parent.replaceChild(placeholder, element));
              getPreviewInsertionPoint(this._document).appendChild(preview);
              this._dropContainer.start();
              this._initialContainer = this._dropContainer;
              this._initialIndex = this._dropContainer.getItemIndex(this);
            } else {
              this._initialContainer = this._initialIndex = /** @type {?} */undefined;
            }
          }
          /**
           * Sets up the different variables and subscriptions
           * that will be necessary for the dragging sequence.
           * @private
           * @param {?} referenceElement Element that started the drag sequence.
           * @param {?} event Browser event object that started the sequence.
           * @return {?}
           */
        }, {
          key: "_initializeDragSequence",
          value: function _initializeDragSequence(referenceElement, event) {
            var _this4 = this;
            // Always stop propagation for the event that initializes
            // the dragging sequence, in order to prevent it from potentially
            // starting another sequence for a draggable parent somewhere up the DOM tree.
            event.stopPropagation();
            /** @type {?} */
            var isDragging = this.isDragging();
            /** @type {?} */
            var isTouchSequence = isTouchEvent(event);
            /** @type {?} */
            var isAuxiliaryMouseButton = !isTouchSequence && /** @type {?} */event.button !== 0;
            /** @type {?} */
            var rootElement = this._rootElement;
            /** @type {?} */
            var isSyntheticEvent = !isTouchSequence && this._lastTouchEventTime && this._lastTouchEventTime + MOUSE_EVENT_IGNORE_TIME > Date.now();
            // If the event started from an element with the native HTML drag&drop, it'll interfere
            // with our own dragging (e.g. `img` tags do it by default). Prevent the default action
            // to stop it from happening. Note that preventing on `dragstart` also seems to work, but
            // it's flaky and it fails if the user drags it away quickly. Also note that we only want
            // to do this for `mousedown` since doing the same for `touchstart` will stop any `click`
            // events from firing on touch devices.
            if (event.target && /** @type {?} */event.target.draggable && event.type === 'mousedown') {
              event.preventDefault();
            }
            // Abort if the user is already dragging or is using a mouse button other than the primary one.
            if (isDragging || isAuxiliaryMouseButton || isSyntheticEvent) {
              return;
            }
            // If we've got handles, we need to disable the tap highlight on the entire root element,
            // otherwise iOS will still add it, even though all the drag interactions on the handle
            // are disabled.
            if (this._handles.length) {
              this._rootElementTapHighlight = rootElement.style.webkitTapHighlightColor;
              rootElement.style.webkitTapHighlightColor = 'transparent';
            }
            this._hasStartedDragging = this._hasMoved = false;
            // Avoid multiple subscriptions and memory leaks when multi touch
            // (isDragging check above isn't enough because of possible temporal and/or dimensional delays)
            this._removeSubscriptions();
            this._pointerMoveSubscription = this._dragDropRegistry.pointerMove.subscribe(this._pointerMove);
            this._pointerUpSubscription = this._dragDropRegistry.pointerUp.subscribe(this._pointerUp);
            this._scrollSubscription = this._dragDropRegistry.scroll.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["startWith"])(null)).subscribe(
            /**
            * @return {?}
            */
            function () {
              _this4._scrollPosition = _this4._viewportRuler.getViewportScrollPosition();
            });
            if (this._boundaryElement) {
              this._boundaryRect = this._boundaryElement.getBoundingClientRect();
            }
            // If we have a custom preview we can't know ahead of time how large it'll be so we position
            // it next to the cursor. The exception is when the consumer has opted into making the preview
            // the same size as the root element, in which case we do know the size.
            /** @type {?} */
            var previewTemplate = this._previewTemplate;
            this._pickupPositionInElement = previewTemplate && previewTemplate.template && !previewTemplate.matchSize ? {
              x: 0,
              y: 0
            } : this._getPointerPositionInElement(referenceElement, event);
            /** @type {?} */
            var pointerPosition = this._pickupPositionOnPage = this._getPointerPositionOnPage(event);
            this._pointerDirectionDelta = {
              x: 0,
              y: 0
            };
            this._pointerPositionAtLastDirectionChange = {
              x: pointerPosition.x,
              y: pointerPosition.y
            };
            this._dragStartTime = Date.now();
            this._dragDropRegistry.startDragging(this, event);
          }
          /**
           * Cleans up the DOM artifacts that were added to facilitate the element being dragged.
           * @private
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_cleanupDragArtifacts",
          value: function _cleanupDragArtifacts(event) {
            var _this5 = this;
            // Restore the element's visibility and insert it at its old position in the DOM.
            // It's important that we maintain the position, because moving the element around in the DOM
            // can throw off `NgFor` which does smart diffing and re-creates elements only when necessary,
            // while moving the existing elements in all other cases.
            this._rootElement.style.display = '';
            /** @type {?} */this._anchor.parentNode.replaceChild(this._rootElement, this._anchor);
            this._destroyPreview();
            this._destroyPlaceholder();
            this._boundaryRect = this._previewRect = undefined;
            // Re-enter the NgZone since we bound `document` events on the outside.
            this._ngZone.run(
            /**
            * @return {?}
            */
            function () {
              /** @type {?} */
              var container = /** @type {?} */_this5._dropContainer;
              /** @type {?} */
              var currentIndex = container.getItemIndex(_this5);
              /** @type {?} */
              var pointerPosition = _this5._getPointerPositionOnPage(event);
              /** @type {?} */
              var distance = _this5._getDragDistance(_this5._getPointerPositionOnPage(event));
              /** @type {?} */
              var isPointerOverContainer = container._isOverContainer(pointerPosition.x, pointerPosition.y);
              _this5.ended.next({
                source: _this5,
                distance: distance
              });
              _this5.dropped.next({
                item: _this5,
                currentIndex: currentIndex,
                previousIndex: _this5._initialIndex,
                container: container,
                previousContainer: _this5._initialContainer,
                isPointerOverContainer: isPointerOverContainer,
                distance: distance
              });
              container.drop(_this5, currentIndex, _this5._initialContainer, isPointerOverContainer, distance, _this5._initialIndex);
              _this5._dropContainer = _this5._initialContainer;
            });
          }
          /**
           * Updates the item's position in its drop container, or moves it
           * into a new one, depending on its current drag position.
           * @private
           * @param {?} __0
           * @return {?}
           */
        }, {
          key: "_updateActiveDropContainer",
          value: function _updateActiveDropContainer(_ref) {
            var _this6 = this;
            var x = _ref.x,
              y = _ref.y;
            // Drop container that draggable has been moved into.
            /** @type {?} */
            var newContainer = this._initialContainer._getSiblingContainerFromPosition(this, x, y);
            // If we couldn't find a new container to move the item into, and the item has left its
            // initial container, check whether the it's over the initial container. This handles the
            // case where two containers are connected one way and the user tries to undo dragging an
            // item into a new container.
            if (!newContainer && this._dropContainer !== this._initialContainer && this._initialContainer._isOverContainer(x, y)) {
              newContainer = this._initialContainer;
            }
            if (newContainer && newContainer !== this._dropContainer) {
              this._ngZone.run(
              /**
              * @return {?}
              */
              function () {
                // Notify the old container that the item has left.
                _this6.exited.next({
                  item: _this6,
                  container: /** @type {?} */_this6._dropContainer
                });
                /** @type {?} */_this6._dropContainer.exit(_this6);
                // Notify the new container that the item has entered.
                _this6._dropContainer = /** @type {?} */newContainer;
                _this6._dropContainer.enter(_this6, x, y, newContainer === _this6._initialContainer &&
                // If we're re-entering the initial container and sorting is disabled,
                // put item the into its starting index to begin with.
                newContainer.sortingDisabled ? _this6._initialIndex : undefined);
                _this6.entered.next({
                  item: _this6,
                  container: /** @type {?} */newContainer,
                  currentIndex: /** @type {?} */newContainer.getItemIndex(_this6)
                });
              });
            }
            /** @type {?} */this._dropContainer._startScrollingIfNecessary(x, y);
            /** @type {?} */this._dropContainer._sortItem(this, x, y, this._pointerDirectionDelta);
            this._preview.style.transform = getTransform(x - this._pickupPositionInElement.x, y - this._pickupPositionInElement.y);
          }
          /**
           * Creates the element that will be rendered next to the user's pointer
           * and will be used as a preview of the element that is being dragged.
           * @private
           * @return {?}
           */
        }, {
          key: "_createPreviewElement",
          value: function _createPreviewElement() {
            /** @type {?} */
            var previewConfig = this._previewTemplate;
            /** @type {?} */
            var previewClass = this.previewClass;
            /** @type {?} */
            var previewTemplate = previewConfig ? previewConfig.template : null;
            /** @type {?} */
            var preview;
            if (previewTemplate) {
              /** @type {?} */
              var viewRef = /** @type {?} */previewConfig.viewContainer.createEmbeddedView(previewTemplate, /** @type {?} */previewConfig.context);
              viewRef.detectChanges();
              preview = getRootNode(viewRef, this._document);
              this._previewRef = viewRef;
              if ( /** @type {?} */previewConfig.matchSize) {
                matchElementSize(preview, this._rootElement);
              } else {
                preview.style.transform = getTransform(this._pickupPositionOnPage.x, this._pickupPositionOnPage.y);
              }
            } else {
              /** @type {?} */
              var element = this._rootElement;
              preview = deepCloneNode(element);
              matchElementSize(preview, element);
            }
            extendStyles(preview.style, {
              // It's important that we disable the pointer events on the preview, because
              // it can throw off the `document.elementFromPoint` calls in the `CdkDropList`.
              pointerEvents: 'none',
              // We have to reset the margin, because it can throw off positioning relative to the viewport.
              margin: '0',
              position: 'fixed',
              top: '0',
              left: '0',
              zIndex: '1000'
            });
            toggleNativeDragInteractions(preview, false);
            preview.classList.add('cdk-drag-preview');
            preview.setAttribute('dir', this._direction);
            if (previewClass) {
              if (Array.isArray(previewClass)) {
                previewClass.forEach(
                /**
                * @param {?} className
                * @return {?}
                */
                function (className) {
                  return preview.classList.add(className);
                });
              } else {
                preview.classList.add(previewClass);
              }
            }
            return preview;
          }
          /**
           * Animates the preview element from its current position to the location of the drop placeholder.
           * @private
           * @return {?} Promise that resolves when the animation completes.
           */
        }, {
          key: "_animatePreviewToPlaceholder",
          value: function _animatePreviewToPlaceholder() {
            var _this7 = this;
            // If the user hasn't moved yet, the transitionend event won't fire.
            if (!this._hasMoved) {
              return Promise.resolve();
            }
            /** @type {?} */
            var placeholderRect = this._placeholder.getBoundingClientRect();
            // Apply the class that adds a transition to the preview.
            this._preview.classList.add('cdk-drag-animating');
            // Move the preview to the placeholder position.
            this._preview.style.transform = getTransform(placeholderRect.left, placeholderRect.top);
            // If the element doesn't have a `transition`, the `transitionend` event won't fire. Since
            // we need to trigger a style recalculation in order for the `cdk-drag-animating` class to
            // apply its style, we take advantage of the available info to figure out whether we need to
            // bind the event in the first place.
            /** @type {?} */
            var duration = getTransformTransitionDurationInMs(this._preview);
            if (duration === 0) {
              return Promise.resolve();
            }
            return this._ngZone.runOutsideAngular(
            /**
            * @return {?}
            */
            function () {
              return new Promise(
              /**
              * @param {?} resolve
              * @return {?}
              */
              function (resolve) {
                /** @type {?} */
                var handler = /** @type {?} */ /**
                                               * @param {?} event
                                               * @return {?}
                                               */
                function handler(event) {
                  if (!event || event.target === _this7._preview && event.propertyName === 'transform') {
                    _this7._preview.removeEventListener('transitionend', handler);
                    resolve();
                    clearTimeout(timeout);
                  }
                };
                // If a transition is short enough, the browser might not fire the `transitionend` event.
                // Since we know how long it's supposed to take, add a timeout with a 50% buffer that'll
                // fire if the transition hasn't completed when it was supposed to.
                /** @type {?} */
                var timeout = setTimeout( /** @type {?} */handler, duration * 1.5);
                _this7._preview.addEventListener('transitionend', handler);
              });
            });
          }
          /**
           * Creates an element that will be shown instead of the current element while dragging.
           * @private
           * @return {?}
           */
        }, {
          key: "_createPlaceholderElement",
          value: function _createPlaceholderElement() {
            /** @type {?} */
            var placeholderConfig = this._placeholderTemplate;
            /** @type {?} */
            var placeholderTemplate = placeholderConfig ? placeholderConfig.template : null;
            /** @type {?} */
            var placeholder;
            if (placeholderTemplate) {
              this._placeholderRef = /** @type {?} */placeholderConfig.viewContainer.createEmbeddedView(placeholderTemplate, /** @type {?} */placeholderConfig.context);
              this._placeholderRef.detectChanges();
              placeholder = getRootNode(this._placeholderRef, this._document);
            } else {
              placeholder = deepCloneNode(this._rootElement);
            }
            placeholder.classList.add('cdk-drag-placeholder');
            return placeholder;
          }
          /**
           * Figures out the coordinates at which an element was picked up.
           * @private
           * @param {?} referenceElement Element that initiated the dragging.
           * @param {?} event Event that initiated the dragging.
           * @return {?}
           */
        }, {
          key: "_getPointerPositionInElement",
          value: function _getPointerPositionInElement(referenceElement, event) {
            /** @type {?} */
            var elementRect = this._rootElement.getBoundingClientRect();
            /** @type {?} */
            var handleElement = referenceElement === this._rootElement ? null : referenceElement;
            /** @type {?} */
            var referenceRect = handleElement ? handleElement.getBoundingClientRect() : elementRect;
            /** @type {?} */
            var point = isTouchEvent(event) ? event.targetTouches[0] : event;
            /** @type {?} */
            var x = point.pageX - referenceRect.left - this._scrollPosition.left;
            /** @type {?} */
            var y = point.pageY - referenceRect.top - this._scrollPosition.top;
            return {
              x: referenceRect.left - elementRect.left + x,
              y: referenceRect.top - elementRect.top + y
            };
          }
          /**
           * Determines the point of the page that was touched by the user.
           * @private
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_getPointerPositionOnPage",
          value: function _getPointerPositionOnPage(event) {
            // `touches` will be empty for start/end events so we have to fall back to `changedTouches`.
            /** @type {?} */
            var point = isTouchEvent(event) ? event.touches[0] || event.changedTouches[0] : event;
            return {
              x: point.pageX - this._scrollPosition.left,
              y: point.pageY - this._scrollPosition.top
            };
          }
          /**
           * Gets the pointer position on the page, accounting for any position constraints.
           * @private
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_getConstrainedPointerPosition",
          value: function _getConstrainedPointerPosition(event) {
            /** @type {?} */
            var point = this._getPointerPositionOnPage(event);
            /** @type {?} */
            var constrainedPoint = this.constrainPosition ? this.constrainPosition(point, this) : point;
            /** @type {?} */
            var dropContainerLock = this._dropContainer ? this._dropContainer.lockAxis : null;
            if (this.lockAxis === 'x' || dropContainerLock === 'x') {
              constrainedPoint.y = this._pickupPositionOnPage.y;
            } else if (this.lockAxis === 'y' || dropContainerLock === 'y') {
              constrainedPoint.x = this._pickupPositionOnPage.x;
            }
            if (this._boundaryRect) {
              var _this$_pickupPosition = this._pickupPositionInElement,
                pickupX = _this$_pickupPosition.x,
                pickupY = _this$_pickupPosition.y;
              /** @type {?} */
              var boundaryRect = this._boundaryRect;
              /** @type {?} */
              var previewRect = /** @type {?} */this._previewRect;
              /** @type {?} */
              var minY = boundaryRect.top + pickupY;
              /** @type {?} */
              var maxY = boundaryRect.bottom - (previewRect.height - pickupY);
              /** @type {?} */
              var minX = boundaryRect.left + pickupX;
              /** @type {?} */
              var maxX = boundaryRect.right - (previewRect.width - pickupX);
              constrainedPoint.x = clamp(constrainedPoint.x, minX, maxX);
              constrainedPoint.y = clamp(constrainedPoint.y, minY, maxY);
            }
            return constrainedPoint;
          }
          /**
           * Updates the current drag delta, based on the user's current pointer position on the page.
           * @private
           * @param {?} pointerPositionOnPage
           * @return {?}
           */
        }, {
          key: "_updatePointerDirectionDelta",
          value: function _updatePointerDirectionDelta(pointerPositionOnPage) {
            var x = pointerPositionOnPage.x,
              y = pointerPositionOnPage.y;
            /** @type {?} */
            var delta = this._pointerDirectionDelta;
            /** @type {?} */
            var positionSinceLastChange = this._pointerPositionAtLastDirectionChange;
            // Amount of pixels the user has dragged since the last time the direction changed.
            /** @type {?} */
            var changeX = Math.abs(x - positionSinceLastChange.x);
            /** @type {?} */
            var changeY = Math.abs(y - positionSinceLastChange.y);
            // Because we handle pointer events on a per-pixel basis, we don't want the delta
            // to change for every pixel, otherwise anything that depends on it can look erratic.
            // To make the delta more consistent, we track how much the user has moved since the last
            // delta change and we only update it after it has reached a certain threshold.
            if (changeX > this._config.pointerDirectionChangeThreshold) {
              delta.x = x > positionSinceLastChange.x ? 1 : -1;
              positionSinceLastChange.x = x;
            }
            if (changeY > this._config.pointerDirectionChangeThreshold) {
              delta.y = y > positionSinceLastChange.y ? 1 : -1;
              positionSinceLastChange.y = y;
            }
            return delta;
          }
          /**
           * Toggles the native drag interactions, based on how many handles are registered.
           * @private
           * @return {?}
           */
        }, {
          key: "_toggleNativeDragInteractions",
          value: function _toggleNativeDragInteractions() {
            if (!this._rootElement || !this._handles) {
              return;
            }
            /** @type {?} */
            var shouldEnable = this._handles.length > 0 || !this.isDragging();
            if (shouldEnable !== this._nativeInteractionsEnabled) {
              this._nativeInteractionsEnabled = shouldEnable;
              toggleNativeDragInteractions(this._rootElement, shouldEnable);
            }
          }
          /**
           * Removes the manually-added event listeners from the root element.
           * @private
           * @param {?} element
           * @return {?}
           */
        }, {
          key: "_removeRootElementListeners",
          value: function _removeRootElementListeners(element) {
            element.removeEventListener('mousedown', this._pointerDown, activeEventListenerOptions);
            element.removeEventListener('touchstart', this._pointerDown, passiveEventListenerOptions);
          }
          /**
           * Applies a `transform` to the root element, taking into account any existing transforms on it.
           * @private
           * @param {?} x New transform value along the X axis.
           * @param {?} y New transform value along the Y axis.
           * @return {?}
           */
        }, {
          key: "_applyRootElementTransform",
          value: function _applyRootElementTransform(x, y) {
            /** @type {?} */
            var transform = getTransform(x, y);
            // Cache the previous transform amount only after the first drag sequence, because
            // we don't want our own transforms to stack on top of each other.
            if (this._initialTransform == null) {
              this._initialTransform = this._rootElement.style.transform || '';
            }
            // Preserve the previous `transform` value, if there was one. Note that we apply our own
            // transform before the user's, because things like rotation can affect which direction
            // the element will be translated towards.
            this._rootElement.style.transform = this._initialTransform ? transform + ' ' + this._initialTransform : transform;
          }
          /**
           * Gets the distance that the user has dragged during the current drag sequence.
           * @private
           * @param {?} currentPosition Current position of the user's pointer.
           * @return {?}
           */
        }, {
          key: "_getDragDistance",
          value: function _getDragDistance(currentPosition) {
            /** @type {?} */
            var pickupPosition = this._pickupPositionOnPage;
            if (pickupPosition) {
              return {
                x: currentPosition.x - pickupPosition.x,
                y: currentPosition.y - pickupPosition.y
              };
            }
            return {
              x: 0,
              y: 0
            };
          }
          /**
           * Cleans up any cached element dimensions that we don't need after dragging has stopped.
           * @private
           * @return {?}
           */
        }, {
          key: "_cleanupCachedDimensions",
          value: function _cleanupCachedDimensions() {
            this._boundaryRect = this._previewRect = undefined;
          }
          /**
           * Checks whether the element is still inside its boundary after the viewport has been resized.
           * If not, the position is adjusted so that the element fits again.
           * @private
           * @return {?}
           */
        }, {
          key: "_containInsideBoundaryOnResize",
          value: function _containInsideBoundaryOnResize() {
            var _this$_passiveTransfo = this._passiveTransform,
              x = _this$_passiveTransfo.x,
              y = _this$_passiveTransfo.y;
            if (x === 0 && y === 0 || this.isDragging() || !this._boundaryElement) {
              return;
            }
            /** @type {?} */
            var boundaryRect = this._boundaryElement.getBoundingClientRect();
            /** @type {?} */
            var elementRect = this._rootElement.getBoundingClientRect();
            // It's possible that the element got hidden away after dragging (e.g. by switching to a
            // different tab). Don't do anything in this case so we don't clear the user's position.
            if (boundaryRect.width === 0 && boundaryRect.height === 0 || elementRect.width === 0 && elementRect.height === 0) {
              return;
            }
            /** @type {?} */
            var leftOverflow = boundaryRect.left - elementRect.left;
            /** @type {?} */
            var rightOverflow = elementRect.right - boundaryRect.right;
            /** @type {?} */
            var topOverflow = boundaryRect.top - elementRect.top;
            /** @type {?} */
            var bottomOverflow = elementRect.bottom - boundaryRect.bottom;
            // If the element has become wider than the boundary, we can't
            // do much to make it fit so we just anchor it to the left.
            if (boundaryRect.width > elementRect.width) {
              if (leftOverflow > 0) {
                x += leftOverflow;
              }
              if (rightOverflow > 0) {
                x -= rightOverflow;
              }
            } else {
              x = 0;
            }
            // If the element has become taller than the boundary, we can't
            // do much to make it fit so we just anchor it to the top.
            if (boundaryRect.height > elementRect.height) {
              if (topOverflow > 0) {
                y += topOverflow;
              }
              if (bottomOverflow > 0) {
                y -= bottomOverflow;
              }
            } else {
              y = 0;
            }
            if (x !== this._passiveTransform.x || y !== this._passiveTransform.y) {
              this.setFreeDragPosition({
                y: y,
                x: x
              });
            }
          }
          /**
           * Gets the drag start delay, based on the event type.
           * @private
           * @param {?} event
           * @return {?}
           */
        }, {
          key: "_getDragStartDelay",
          value: function _getDragStartDelay(event) {
            /** @type {?} */
            var value = this.dragStartDelay;
            if (typeof value === 'number') {
              return value;
            } else if (isTouchEvent(event)) {
              return value.touch;
            }
            return value ? value.mouse : 0;
          }
        }]);
        return DragRef;
      }();
      if (false) {}
      /**
       * Gets a 3d `transform` that can be applied to an element.
       * @param {?} x Desired position of the element along the X axis.
       * @param {?} y Desired position of the element along the Y axis.
       * @return {?}
       */
      function getTransform(x, y) {
        // Round the transforms since some browsers will
        // blur the elements for sub-pixel transforms.
        return "translate3d(".concat(Math.round(x), "px, ").concat(Math.round(y), "px, 0)");
      }
      /**
       * Creates a deep clone of an element.
       * @param {?} node
       * @return {?}
       */
      function deepCloneNode(node) {
        /** @type {?} */
        var clone = /** @type {?} */node.cloneNode(true);
        /** @type {?} */
        var descendantsWithId = clone.querySelectorAll('[id]');
        /** @type {?} */
        var descendantCanvases = node.querySelectorAll('canvas');
        // Remove the `id` to avoid having multiple elements with the same id on the page.
        clone.removeAttribute('id');
        for (var i = 0; i < descendantsWithId.length; i++) {
          descendantsWithId[i].removeAttribute('id');
        }
        // `cloneNode` won't transfer the content of `canvas` elements so we have to do it ourselves.
        // We match up the cloned canvas to their sources using their index in the DOM.
        if (descendantCanvases.length) {
          /** @type {?} */
          var cloneCanvases = clone.querySelectorAll('canvas');
          for (var _i = 0; _i < descendantCanvases.length; _i++) {
            /** @type {?} */
            var correspondingCloneContext = cloneCanvases[_i].getContext('2d');
            if (correspondingCloneContext) {
              correspondingCloneContext.drawImage(descendantCanvases[_i], 0, 0);
            }
          }
        }
        return clone;
      }
      /**
       * Clamps a value between a minimum and a maximum.
       * @param {?} value
       * @param {?} min
       * @param {?} max
       * @return {?}
       */
      function clamp(value, min, max) {
        return Math.max(min, Math.min(max, value));
      }
      /**
       * Helper to remove a node from the DOM and to do all the necessary null checks.
       * @param {?} node Node to be removed.
       * @return {?}
       */
      function removeNode(node) {
        if (node && node.parentNode) {
          node.parentNode.removeChild(node);
        }
      }
      /**
       * Determines whether an event is a touch event.
       * @param {?} event
       * @return {?}
       */
      function isTouchEvent(event) {
        // This function is called for every pixel that the user has dragged so we need it to be
        // as fast as possible. Since we only bind mouse events and touch events, we can assume
        // that if the event's name starts with `t`, it's a touch event.
        return event.type[0] === 't';
      }
      /**
       * Gets the element into which the drag preview should be inserted.
       * @param {?} documentRef
       * @return {?}
       */
      function getPreviewInsertionPoint(documentRef) {
        // We can't use the body if the user is in fullscreen mode,
        // because the preview will render under the fullscreen element.
        // TODO(crisbeto): dedupe this with the `FullscreenOverlayContainer` eventually.
        return documentRef.fullscreenElement || documentRef.webkitFullscreenElement || documentRef.mozFullScreenElement || documentRef.msFullscreenElement || documentRef.body;
      }
      /**
       * Gets the root HTML element of an embedded view.
       * If the root is not an HTML element it gets wrapped in one.
       * @param {?} viewRef
       * @param {?} _document
       * @return {?}
       */
      function getRootNode(viewRef, _document) {
        /** @type {?} */
        var rootNode = viewRef.rootNodes[0];
        if (rootNode.nodeType !== _document.ELEMENT_NODE) {
          /** @type {?} */
          var wrapper = _document.createElement('div');
          wrapper.appendChild(rootNode);
          return wrapper;
        }
        return (/** @type {?} */rootNode
        );
      }
      /**
       * Matches the target element's size to the source's size.
       * @param {?} target Element that needs to be resized.
       * @param {?} source Element whose size needs to be matched.
       * @return {?}
       */
      function matchElementSize(target, source) {
        /** @type {?} */
        var sourceRect = source.getBoundingClientRect();
        target.style.width = "".concat(sourceRect.width, "px");
        target.style.height = "".concat(sourceRect.height, "px");
        target.style.transform = getTransform(sourceRect.left, sourceRect.top);
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-utils.ts
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
       * Moves an item one index in an array to another.
       * @template T
       * @param {?} array Array in which to move the item.
       * @param {?} fromIndex Starting index of the item.
       * @param {?} toIndex Index to which the item should be moved.
       * @return {?}
       */
      function moveItemInArray(array, fromIndex, toIndex) {
        /** @type {?} */
        var from = clamp$1(fromIndex, array.length - 1);
        /** @type {?} */
        var to = clamp$1(toIndex, array.length - 1);
        if (from === to) {
          return;
        }
        /** @type {?} */
        var target = array[from];
        /** @type {?} */
        var delta = to < from ? -1 : 1;
        for (var i = from; i !== to; i += delta) {
          array[i] = array[i + delta];
        }
        array[to] = target;
      }
      /**
       * Moves an item from one array to another.
       * @template T
       * @param {?} currentArray Array from which to transfer the item.
       * @param {?} targetArray Array into which to put the item.
       * @param {?} currentIndex Index of the item in its current array.
       * @param {?} targetIndex Index at which to insert the item.
       * @return {?}
       */
      function transferArrayItem(currentArray, targetArray, currentIndex, targetIndex) {
        /** @type {?} */
        var from = clamp$1(currentIndex, currentArray.length - 1);
        /** @type {?} */
        var to = clamp$1(targetIndex, targetArray.length);
        if (currentArray.length) {
          targetArray.splice(to, 0, currentArray.splice(from, 1)[0]);
        }
      }
      /**
       * Copies an item from one array to another, leaving it in its
       * original position in current array.
       * @template T
       * @param {?} currentArray Array from which to copy the item.
       * @param {?} targetArray Array into which is copy the item.
       * @param {?} currentIndex Index of the item in its current array.
       * @param {?} targetIndex Index at which to insert the item.
       *
       * @return {?}
       */
      function copyArrayItem(currentArray, targetArray, currentIndex, targetIndex) {
        /** @type {?} */
        var to = clamp$1(targetIndex, targetArray.length);
        if (currentArray.length) {
          targetArray.splice(to, 0, currentArray[currentIndex]);
        }
      }
      /**
       * Clamps a number between zero and a maximum.
       * @param {?} value
       * @param {?} max
       * @return {?}
       */
      function clamp$1(value, max) {
        return Math.max(0, Math.min(max, value));
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drop-list-ref.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Proximity, as a ratio to width/height, at which a
       * dragged item will affect the drop container.
       * @type {?}
       */
      var DROP_PROXIMITY_THRESHOLD = 0.05;
      /**
       * Proximity, as a ratio to width/height at which to start auto-scrolling the drop list or the
       * viewport. The value comes from trying it out manually until it feels right.
       * @type {?}
       */
      var SCROLL_PROXIMITY_THRESHOLD = 0.05;
      /**
       * Number of pixels to scroll for each frame when auto-scrolling an element.
       * The value comes from trying it out manually until it feels right.
       * @type {?}
       */
      var AUTO_SCROLL_STEP = 2;
      /**
       * Entry in the position cache for draggable items.
       * \@docs-private
       * @record
       */
      function CachedItemPosition() {}
      if (false) {}
      /**
       * Object holding the scroll position of something.
       * @record
       */
      function ScrollPosition() {}
      if (false) {}
      /** @enum {number} */
      var AutoScrollVerticalDirection = {
        NONE: 0,
        UP: 1,
        DOWN: 2
      };
      /** @enum {number} */
      var AutoScrollHorizontalDirection = {
        NONE: 0,
        LEFT: 1,
        RIGHT: 2
      };
      /**
       * Internal compile-time-only representation of a `DropListRef`.
       * Used to avoid circular import issues between the `DropListRef` and the `DragRef`.
       * \@docs-private
       * @record
       */
      function DropListRefInternal() {}
      /**
       * Reference to a drop list. Used to manipulate or dispose of the container.
       * @template T
       */
      var DropListRef = /*#__PURE__*/function () {
        /**
         * @param {?} element
         * @param {?} _dragDropRegistry
         * @param {?} _document
         * @param {?} _ngZone
         * @param {?} _viewportRuler
         */
        function DropListRef(element, _dragDropRegistry, _document, _ngZone, _viewportRuler) {
          var _this8 = this;
          _classCallCheck(this, DropListRef);
          this._dragDropRegistry = _dragDropRegistry;
          this._ngZone = _ngZone;
          this._viewportRuler = _viewportRuler;
          /**
           * Whether starting a dragging sequence from this container is disabled.
           */
          this.disabled = false;
          /**
           * Whether sorting items within the list is disabled.
           */
          this.sortingDisabled = false;
          /**
           * Whether auto-scrolling the view when the user
           * moves their pointer close to the edges is disabled.
           */
          this.autoScrollDisabled = false;
          /**
           * Function that is used to determine whether an item
           * is allowed to be moved into a drop container.
           */
          this.enterPredicate =
          /**
          * @return {?}
          */
          function () {
            return true;
          };
          /**
           * Emits right before dragging has started.
           */
          this.beforeStarted = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user has moved a new drag item into this container.
           */
          this.entered = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user removes an item from the container
           * by dragging it into another container.
           */
          this.exited = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user drops an item inside the container.
           */
          this.dropped = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits as the user is swapping items while actively dragging.
           */
          this.sorted = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Whether an item in the list is being dragged.
           */
          this._isDragging = false;
          /**
           * Cache of the dimensions of all the items inside the container.
           */
          this._itemPositions = [];
          /**
           * Cached positions of the scrollable parent elements.
           */
          this._parentPositions = new Map();
          /**
           * Keeps track of the item that was last swapped with the dragged item, as
           * well as what direction the pointer was moving in when the swap occured.
           */
          this._previousSwap = {
            drag: /** @type {?} */null,
            delta: 0
          };
          /**
           * Drop lists that are connected to the current one.
           */
          this._siblings = [];
          /**
           * Direction in which the list is oriented.
           */
          this._orientation = 'vertical';
          /**
           * Connected siblings that currently have a dragged item.
           */
          this._activeSiblings = new Set();
          /**
           * Layout direction of the drop list.
           */
          this._direction = 'ltr';
          /**
           * Subscription to the window being scrolled.
           */
          this._viewportScrollSubscription = rxjs__WEBPACK_IMPORTED_MODULE_5__["Subscription"].EMPTY;
          /**
           * Vertical direction in which the list is currently scrolling.
           */
          this._verticalScrollDirection = 0 /* NONE */;
          /**
           * Horizontal direction in which the list is currently scrolling.
           */
          this._horizontalScrollDirection = 0 /* NONE */;
          /**
           * Used to signal to the current auto-scroll sequence when to stop.
           */
          this._stopScrollTimers = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Shadow root of the current element. Necessary for `elementFromPoint` to resolve correctly.
           */
          this._cachedShadowRoot = null;
          /**
           * Starts the interval that'll auto-scroll the element.
           */
          this._startScrollInterval =
          /**
          * @return {?}
          */
          function () {
            _this8._stopScrolling();
            Object(rxjs__WEBPACK_IMPORTED_MODULE_5__["interval"])(0, rxjs__WEBPACK_IMPORTED_MODULE_5__["animationFrameScheduler"]).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["takeUntil"])(_this8._stopScrollTimers)).subscribe(
            /**
            * @return {?}
            */
            function () {
              /** @type {?} */
              var node = _this8._scrollNode;
              if (_this8._verticalScrollDirection === 1 /* UP */) {
                incrementVerticalScroll(node, -AUTO_SCROLL_STEP);
              } else if (_this8._verticalScrollDirection === 2 /* DOWN */) {
                incrementVerticalScroll(node, AUTO_SCROLL_STEP);
              }
              if (_this8._horizontalScrollDirection === 1 /* LEFT */) {
                incrementHorizontalScroll(node, -AUTO_SCROLL_STEP);
              } else if (_this8._horizontalScrollDirection === 2 /* RIGHT */) {
                incrementHorizontalScroll(node, AUTO_SCROLL_STEP);
              }
            });
          };
          this.element = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(element);
          this._document = _document;
          this.withScrollableParents([this.element]);
          _dragDropRegistry.registerDropContainer(this);
        }
        /**
         * Removes the drop list functionality from the DOM element.
         * @return {?}
         */
        _createClass(DropListRef, [{
          key: "dispose",
          value: function dispose() {
            this._stopScrolling();
            this._stopScrollTimers.complete();
            this._viewportScrollSubscription.unsubscribe();
            this.beforeStarted.complete();
            this.entered.complete();
            this.exited.complete();
            this.dropped.complete();
            this.sorted.complete();
            this._activeSiblings.clear();
            this._scrollNode = /** @type {?} */null;
            this._parentPositions.clear();
            this._dragDropRegistry.removeDropContainer(this);
          }
          /**
           * Whether an item from this list is currently being dragged.
           * @return {?}
           */
        }, {
          key: "isDragging",
          value: function isDragging() {
            return this._isDragging;
          }
          /**
           * Starts dragging an item.
           * @return {?}
           */
        }, {
          key: "start",
          value: function start() {
            var _this9 = this;
            /** @type {?} */
            var styles = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(this.element).style;
            this.beforeStarted.next();
            this._isDragging = true;
            // We need to disable scroll snapping while the user is dragging, because it breaks automatic
            // scrolling. The browser seems to round the value based on the snapping points which means
            // that we can't increment/decrement the scroll position.
            this._initialScrollSnap = styles.msScrollSnapType || /** @type {?} */styles.scrollSnapType || '';
            /** @type {?} */styles.scrollSnapType = styles.msScrollSnapType = 'none';
            this._cacheItems();
            this._siblings.forEach(
            /**
            * @param {?} sibling
            * @return {?}
            */
            function (sibling) {
              return sibling._startReceiving(_this9);
            });
            this._viewportScrollSubscription.unsubscribe();
            this._listenToScrollEvents();
          }
          /**
           * Emits an event to indicate that the user moved an item into the container.
           * @param {?} item Item that was moved into the container.
           * @param {?} pointerX Position of the item along the X axis.
           * @param {?} pointerY Position of the item along the Y axis.
           * @param {?=} index Index at which the item entered. If omitted, the container will try to figure it
           *   out automatically.
           * @return {?}
           */
        }, {
          key: "enter",
          value: function enter(item, pointerX, pointerY, index) {
            this.start();
            // If sorting is disabled, we want the item to return to its starting
            // position if the user is returning it to its initial container.
            /** @type {?} */
            var newIndex;
            if (index == null) {
              newIndex = this.sortingDisabled ? this._draggables.indexOf(item) : -1;
              if (newIndex === -1) {
                // We use the coordinates of where the item entered the drop
                // zone to figure out at which index it should be inserted.
                newIndex = this._getItemIndexFromPointerPosition(item, pointerX, pointerY);
              }
            } else {
              newIndex = index;
            }
            /** @type {?} */
            var activeDraggables = this._activeDraggables;
            /** @type {?} */
            var currentIndex = activeDraggables.indexOf(item);
            /** @type {?} */
            var placeholder = item.getPlaceholderElement();
            /** @type {?} */
            var newPositionReference = activeDraggables[newIndex];
            // If the item at the new position is the same as the item that is being dragged,
            // it means that we're trying to restore the item to its initial position. In this
            // case we should use the next item from the list as the reference.
            if (newPositionReference === item) {
              newPositionReference = activeDraggables[newIndex + 1];
            }
            // Since the item may be in the `activeDraggables` already (e.g. if the user dragged it
            // into another container and back again), we have to ensure that it isn't duplicated.
            if (currentIndex > -1) {
              activeDraggables.splice(currentIndex, 1);
            }
            // Don't use items that are being dragged as a reference, because
            // their element has been moved down to the bottom of the body.
            if (newPositionReference && !this._dragDropRegistry.isDragging(newPositionReference)) {
              /** @type {?} */
              var element = newPositionReference.getRootElement();
              /** @type {?} */element.parentElement.insertBefore(placeholder, element);
              activeDraggables.splice(newIndex, 0, item);
            } else {
              Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(this.element).appendChild(placeholder);
              activeDraggables.push(item);
            }
            // The transform needs to be cleared so it doesn't throw off the measurements.
            placeholder.style.transform = '';
            // Note that the positions were already cached when we called `start` above,
            // but we need to refresh them since the amount of items has changed.
            this._cacheItemPositions();
            this.entered.next({
              item: item,
              container: this,
              currentIndex: this.getItemIndex(item)
            });
          }
          /**
           * Removes an item from the container after it was dragged into another container by the user.
           * @param {?} item Item that was dragged out.
           * @return {?}
           */
        }, {
          key: "exit",
          value: function exit(item) {
            this._reset();
            this.exited.next({
              item: item,
              container: this
            });
          }
          /**
           * Drops an item into this container.
           * \@breaking-change 11.0.0 `previousIndex` parameter to become required.
           * @param {?} item Item being dropped into the container.
           * @param {?} currentIndex Index at which the item should be inserted.
           * @param {?} previousContainer Container from which the item got dragged in.
           * @param {?} isPointerOverContainer Whether the user's pointer was over the
           *    container when the item was dropped.
           * @param {?} distance Distance the user has dragged since the start of the dragging sequence.
           * @param {?=} previousIndex Index of the item when dragging started.
           *
           * @return {?}
           */
        }, {
          key: "drop",
          value: function drop(item, currentIndex, previousContainer, isPointerOverContainer, distance, previousIndex) {
            this._reset();
            // @breaking-change 11.0.0 Remove this fallback logic once `previousIndex` is a required param.
            if (previousIndex == null) {
              previousIndex = previousContainer.getItemIndex(item);
            }
            this.dropped.next({
              item: item,
              currentIndex: currentIndex,
              previousIndex: previousIndex,
              container: this,
              previousContainer: previousContainer,
              isPointerOverContainer: isPointerOverContainer,
              distance: distance
            });
          }
          /**
           * Sets the draggable items that are a part of this list.
           * @template THIS
           * @this {THIS}
           * @param {?} items Items that are a part of this list.
           * @return {THIS}
           */
        }, {
          key: "withItems",
          value: function withItems(items) {
            var _this10 = this;
            /** @type {?} */this._draggables = items;
            items.forEach(
            /**
            * @param {?} item
            * @return {?}
            */
            function (item) {
              return item._withDropContainer( /** @type {?} */_this10);
            });
            if ( /** @type {?} */this.isDragging()) {
              /** @type {?} */this._cacheItems();
            }
            return (/** @type {?} */this
            );
          }
          /**
           * Sets the layout direction of the drop list.
           * @template THIS
           * @this {THIS}
           * @param {?} direction
           * @return {THIS}
           */
        }, {
          key: "withDirection",
          value: function withDirection(direction) {
            /** @type {?} */this._direction = direction;
            return (/** @type {?} */this
            );
          }
          /**
           * Sets the containers that are connected to this one. When two or more containers are
           * connected, the user will be allowed to transfer items between them.
           * @template THIS
           * @this {THIS}
           * @param {?} connectedTo Other containers that the current containers should be connected to.
           * @return {THIS}
           */
        }, {
          key: "connectedTo",
          value: function connectedTo(_connectedTo) {
            /** @type {?} */this._siblings = _connectedTo.slice();
            return (/** @type {?} */this
            );
          }
          /**
           * Sets the orientation of the container.
           * @template THIS
           * @this {THIS}
           * @param {?} orientation New orientation for the container.
           * @return {THIS}
           */
        }, {
          key: "withOrientation",
          value: function withOrientation(orientation) {
            /** @type {?} */this._orientation = orientation;
            return (/** @type {?} */this
            );
          }
          /**
           * Sets which parent elements are can be scrolled while the user is dragging.
           * @template THIS
           * @this {THIS}
           * @param {?} elements Elements that can be scrolled.
           * @return {THIS}
           */
        }, {
          key: "withScrollableParents",
          value: function withScrollableParents(elements) {
            /** @type {?} */
            var element = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])( /** @type {?} */this.element);
            // We always allow the current element to be scrollable
            // so we need to ensure that it's in the array.
            /** @type {?} */this._scrollableElements = elements.indexOf(element) === -1 ? [element].concat(_toConsumableArray(elements)) : elements.slice();
            return (/** @type {?} */this
            );
          }
          /**
           * Figures out the index of an item in the container.
           * @param {?} item Item whose index should be determined.
           * @return {?}
           */
        }, {
          key: "getItemIndex",
          value: function getItemIndex(item) {
            if (!this._isDragging) {
              return this._draggables.indexOf(item);
            }
            // Items are sorted always by top/left in the cache, however they flow differently in RTL.
            // The rest of the logic still stands no matter what orientation we're in, however
            // we need to invert the array when determining the index.
            /** @type {?} */
            var items = this._orientation === 'horizontal' && this._direction === 'rtl' ? this._itemPositions.slice().reverse() : this._itemPositions;
            return findIndex(items,
            /**
            * @param {?} currentItem
            * @return {?}
            */
            function (currentItem) {
              return currentItem.drag === item;
            });
          }
          /**
           * Whether the list is able to receive the item that
           * is currently being dragged inside a connected drop list.
           * @return {?}
           */
        }, {
          key: "isReceiving",
          value: function isReceiving() {
            return this._activeSiblings.size > 0;
          }
          /**
           * Sorts an item inside the container based on its position.
           * @param {?} item Item to be sorted.
           * @param {?} pointerX Position of the item along the X axis.
           * @param {?} pointerY Position of the item along the Y axis.
           * @param {?} pointerDelta Direction in which the pointer is moving along each axis.
           * @return {?}
           */
        }, {
          key: "_sortItem",
          value: function _sortItem(item, pointerX, pointerY, pointerDelta) {
            // Don't sort the item if sorting is disabled or it's out of range.
            if (this.sortingDisabled || !isPointerNearClientRect(this._clientRect, pointerX, pointerY)) {
              return;
            }
            /** @type {?} */
            var siblings = this._itemPositions;
            /** @type {?} */
            var newIndex = this._getItemIndexFromPointerPosition(item, pointerX, pointerY, pointerDelta);
            if (newIndex === -1 && siblings.length > 0) {
              return;
            }
            /** @type {?} */
            var isHorizontal = this._orientation === 'horizontal';
            /** @type {?} */
            var currentIndex = findIndex(siblings,
            /**
            * @param {?} currentItem
            * @return {?}
            */
            function (currentItem) {
              return currentItem.drag === item;
            });
            /** @type {?} */
            var siblingAtNewPosition = siblings[newIndex];
            /** @type {?} */
            var currentPosition = siblings[currentIndex].clientRect;
            /** @type {?} */
            var newPosition = siblingAtNewPosition.clientRect;
            /** @type {?} */
            var delta = currentIndex > newIndex ? 1 : -1;
            this._previousSwap.drag = siblingAtNewPosition.drag;
            this._previousSwap.delta = isHorizontal ? pointerDelta.x : pointerDelta.y;
            // How many pixels the item's placeholder should be offset.
            /** @type {?} */
            var itemOffset = this._getItemOffsetPx(currentPosition, newPosition, delta);
            // How many pixels all the other items should be offset.
            /** @type {?} */
            var siblingOffset = this._getSiblingOffsetPx(currentIndex, siblings, delta);
            // Save the previous order of the items before moving the item to its new index.
            // We use this to check whether an item has been moved as a result of the sorting.
            /** @type {?} */
            var oldOrder = siblings.slice();
            // Shuffle the array in place.
            moveItemInArray(siblings, currentIndex, newIndex);
            this.sorted.next({
              previousIndex: currentIndex,
              currentIndex: newIndex,
              container: this,
              item: item
            });
            siblings.forEach(
            /**
            * @param {?} sibling
            * @param {?} index
            * @return {?}
            */
            function (sibling, index) {
              // Don't do anything if the position hasn't changed.
              if (oldOrder[index] === sibling) {
                return;
              }
              /** @type {?} */
              var isDraggedItem = sibling.drag === item;
              /** @type {?} */
              var offset = isDraggedItem ? itemOffset : siblingOffset;
              /** @type {?} */
              var elementToOffset = isDraggedItem ? item.getPlaceholderElement() : sibling.drag.getRootElement();
              // Update the offset to reflect the new position.
              sibling.offset += offset;
              // Since we're moving the items with a `transform`, we need to adjust their cached
              // client rects to reflect their new position, as well as swap their positions in the cache.
              // Note that we shouldn't use `getBoundingClientRect` here to update the cache, because the
              // elements may be mid-animation which will give us a wrong result.
              if (isHorizontal) {
                // Round the transforms since some browsers will
                // blur the elements, for sub-pixel transforms.
                elementToOffset.style.transform = "translate3d(".concat(Math.round(sibling.offset), "px, 0, 0)");
                adjustClientRect(sibling.clientRect, 0, offset);
              } else {
                elementToOffset.style.transform = "translate3d(0, ".concat(Math.round(sibling.offset), "px, 0)");
                adjustClientRect(sibling.clientRect, offset, 0);
              }
            });
          }
          /**
           * Checks whether the user's pointer is close to the edges of either the
           * viewport or the drop list and starts the auto-scroll sequence.
           * @param {?} pointerX User's pointer position along the x axis.
           * @param {?} pointerY User's pointer position along the y axis.
           * @return {?}
           */
        }, {
          key: "_startScrollingIfNecessary",
          value: function _startScrollingIfNecessary(pointerX, pointerY) {
            var _this11 = this;
            if (this.autoScrollDisabled) {
              return;
            }
            /** @type {?} */
            var scrollNode;
            /** @type {?} */
            var verticalScrollDirection = 0 /* NONE */;
            /** @type {?} */
            var horizontalScrollDirection = 0 /* NONE */;
            // Check whether we should start scrolling any of the parent containers.
            this._parentPositions.forEach(
            /**
            * @param {?} position
            * @param {?} element
            * @return {?}
            */
            function (position, element) {
              // We have special handling for the `document` below. Also this would be
              // nicer with a  for...of loop, but it requires changing a compiler flag.
              if (element === _this11._document || !position.clientRect || scrollNode) {
                return;
              }
              if (isPointerNearClientRect(position.clientRect, pointerX, pointerY)) {
                var _getElementScrollDire = getElementScrollDirections( /** @type {?} */element, position.clientRect, pointerX, pointerY);
                var _getElementScrollDire2 = _slicedToArray(_getElementScrollDire, 2);
                verticalScrollDirection = _getElementScrollDire2[0];
                horizontalScrollDirection = _getElementScrollDire2[1];
                if (verticalScrollDirection || horizontalScrollDirection) {
                  scrollNode = /** @type {?} */element;
                }
              }
            });
            // Otherwise check if we can start scrolling the viewport.
            if (!verticalScrollDirection && !horizontalScrollDirection) {
              var _this$_viewportRuler$ = this._viewportRuler.getViewportSize(),
                width = _this$_viewportRuler$.width,
                height = _this$_viewportRuler$.height;
              /** @type {?} */
              var clientRect = {
                width: width,
                height: height,
                top: 0,
                right: width,
                bottom: height,
                left: 0
              };
              verticalScrollDirection = getVerticalScrollDirection(clientRect, pointerY);
              horizontalScrollDirection = getHorizontalScrollDirection(clientRect, pointerX);
              scrollNode = window;
            }
            if (scrollNode && (verticalScrollDirection !== this._verticalScrollDirection || horizontalScrollDirection !== this._horizontalScrollDirection || scrollNode !== this._scrollNode)) {
              this._verticalScrollDirection = verticalScrollDirection;
              this._horizontalScrollDirection = horizontalScrollDirection;
              this._scrollNode = scrollNode;
              if ((verticalScrollDirection || horizontalScrollDirection) && scrollNode) {
                this._ngZone.runOutsideAngular(this._startScrollInterval);
              } else {
                this._stopScrolling();
              }
            }
          }
          /**
           * Stops any currently-running auto-scroll sequences.
           * @return {?}
           */
        }, {
          key: "_stopScrolling",
          value: function _stopScrolling() {
            this._stopScrollTimers.next();
          }
          /**
           * Caches the positions of the configured scrollable parents.
           * @private
           * @return {?}
           */
        }, {
          key: "_cacheParentPositions",
          value: function _cacheParentPositions() {
            var _this12 = this;
            this._parentPositions.clear();
            this._parentPositions.set(this._document, {
              scrollPosition: /** @type {?} */this._viewportRuler.getViewportScrollPosition()
            });
            this._scrollableElements.forEach(
            /**
            * @param {?} element
            * @return {?}
            */
            function (element) {
              /** @type {?} */
              var clientRect = getMutableClientRect(element);
              // We keep the ClientRect cached in two properties, because it's referenced in a lot of
              // performance-sensitive places and we want to avoid the extra lookups. The `element` is
              // guaranteed to always be in the `_scrollableElements` so this should always match.
              if (element === _this12.element) {
                _this12._clientRect = clientRect;
              }
              _this12._parentPositions.set(element, {
                scrollPosition: {
                  top: element.scrollTop,
                  left: element.scrollLeft
                },
                clientRect: clientRect
              });
            });
          }
          /**
           * Refreshes the position cache of the items and sibling containers.
           * @private
           * @return {?}
           */
        }, {
          key: "_cacheItemPositions",
          value: function _cacheItemPositions() {
            /** @type {?} */
            var isHorizontal = this._orientation === 'horizontal';
            this._itemPositions = this._activeDraggables.map(
            /**
            * @param {?} drag
            * @return {?}
            */
            function (drag) {
              /** @type {?} */
              var elementToMeasure = drag.getVisibleElement();
              return {
                drag: drag,
                offset: 0,
                clientRect: getMutableClientRect(elementToMeasure)
              };
            }).sort(
            /**
            * @param {?} a
            * @param {?} b
            * @return {?}
            */
            function (a, b) {
              return isHorizontal ? a.clientRect.left - b.clientRect.left : a.clientRect.top - b.clientRect.top;
            });
          }
          /**
           * Resets the container to its initial state.
           * @private
           * @return {?}
           */
        }, {
          key: "_reset",
          value: function _reset() {
            var _this13 = this;
            this._isDragging = false;
            /** @type {?} */
            var styles = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(this.element).style;
            /** @type {?} */styles.scrollSnapType = styles.msScrollSnapType = this._initialScrollSnap;
            // TODO(crisbeto): may have to wait for the animations to finish.
            this._activeDraggables.forEach(
            /**
            * @param {?} item
            * @return {?}
            */
            function (item) {
              return item.getRootElement().style.transform = '';
            });
            this._siblings.forEach(
            /**
            * @param {?} sibling
            * @return {?}
            */
            function (sibling) {
              return sibling._stopReceiving(_this13);
            });
            this._activeDraggables = [];
            this._itemPositions = [];
            this._previousSwap.drag = null;
            this._previousSwap.delta = 0;
            this._stopScrolling();
            this._viewportScrollSubscription.unsubscribe();
            this._parentPositions.clear();
          }
          /**
           * Gets the offset in pixels by which the items that aren't being dragged should be moved.
           * @private
           * @param {?} currentIndex Index of the item currently being dragged.
           * @param {?} siblings All of the items in the list.
           * @param {?} delta Direction in which the user is moving.
           * @return {?}
           */
        }, {
          key: "_getSiblingOffsetPx",
          value: function _getSiblingOffsetPx(currentIndex, siblings, delta) {
            /** @type {?} */
            var isHorizontal = this._orientation === 'horizontal';
            /** @type {?} */
            var currentPosition = siblings[currentIndex].clientRect;
            /** @type {?} */
            var immediateSibling = siblings[currentIndex + delta * -1];
            /** @type {?} */
            var siblingOffset = currentPosition[isHorizontal ? 'width' : 'height'] * delta;
            if (immediateSibling) {
              /** @type {?} */
              var start = isHorizontal ? 'left' : 'top';
              /** @type {?} */
              var end = isHorizontal ? 'right' : 'bottom';
              // Get the spacing between the start of the current item and the end of the one immediately
              // after it in the direction in which the user is dragging, or vice versa. We add it to the
              // offset in order to push the element to where it will be when it's inline and is influenced
              // by the `margin` of its siblings.
              if (delta === -1) {
                siblingOffset -= immediateSibling.clientRect[start] - currentPosition[end];
              } else {
                siblingOffset += currentPosition[start] - immediateSibling.clientRect[end];
              }
            }
            return siblingOffset;
          }
          /**
           * Gets the offset in pixels by which the item that is being dragged should be moved.
           * @private
           * @param {?} currentPosition Current position of the item.
           * @param {?} newPosition Position of the item where the current item should be moved.
           * @param {?} delta Direction in which the user is moving.
           * @return {?}
           */
        }, {
          key: "_getItemOffsetPx",
          value: function _getItemOffsetPx(currentPosition, newPosition, delta) {
            /** @type {?} */
            var isHorizontal = this._orientation === 'horizontal';
            /** @type {?} */
            var itemOffset = isHorizontal ? newPosition.left - currentPosition.left : newPosition.top - currentPosition.top;
            // Account for differences in the item width/height.
            if (delta === -1) {
              itemOffset += isHorizontal ? newPosition.width - currentPosition.width : newPosition.height - currentPosition.height;
            }
            return itemOffset;
          }
          /**
           * Gets the index of an item in the drop container, based on the position of the user's pointer.
           * @private
           * @param {?} item Item that is being sorted.
           * @param {?} pointerX Position of the user's pointer along the X axis.
           * @param {?} pointerY Position of the user's pointer along the Y axis.
           * @param {?=} delta Direction in which the user is moving their pointer.
           * @return {?}
           */
        }, {
          key: "_getItemIndexFromPointerPosition",
          value: function _getItemIndexFromPointerPosition(item, pointerX, pointerY, delta) {
            var _this14 = this;
            /** @type {?} */
            var isHorizontal = this._orientation === 'horizontal';
            return findIndex(this._itemPositions,
            /**
            * @param {?} __0
            * @param {?} _
            * @param {?} array
            * @return {?}
            */
            function (_ref2, _, array) {
              var drag = _ref2.drag,
                clientRect = _ref2.clientRect;
              if (drag === item) {
                // If there's only one item left in the container, it must be
                // the dragged item itself so we use it as a reference.
                return array.length < 2;
              }
              if (delta) {
                /** @type {?} */
                var direction = isHorizontal ? delta.x : delta.y;
                // If the user is still hovering over the same item as last time, and they didn't change
                // the direction in which they're dragging, we don't consider it a direction swap.
                if (drag === _this14._previousSwap.drag && direction === _this14._previousSwap.delta) {
                  return false;
                }
              }
              return isHorizontal ?
              // Round these down since most browsers report client rects with
              // sub-pixel precision, whereas the pointer coordinates are rounded to pixels.
              pointerX >= Math.floor(clientRect.left) && pointerX <= Math.floor(clientRect.right) : pointerY >= Math.floor(clientRect.top) && pointerY <= Math.floor(clientRect.bottom);
            });
          }
          /**
           * Caches the current items in the list and their positions.
           * @private
           * @return {?}
           */
        }, {
          key: "_cacheItems",
          value: function _cacheItems() {
            this._activeDraggables = this._draggables.slice();
            this._cacheItemPositions();
            this._cacheParentPositions();
          }
          /**
           * Updates the internal state of the container after a scroll event has happened.
           * @private
           * @param {?} scrolledParent Element that was scrolled.
           * @param {?} newTop New top scroll position.
           * @param {?} newLeft New left scroll position.
           * @return {?}
           */
        }, {
          key: "_updateAfterScroll",
          value: function _updateAfterScroll(scrolledParent, newTop, newLeft) {
            var _this15 = this;
            // Used when figuring out whether an element is inside the scroll parent. If the scrolled
            // parent is the `document`, we use the `documentElement`, because IE doesn't support `contains`
            // on the `document`.
            /** @type {?} */
            var scrolledParentNode = scrolledParent === this._document ? scrolledParent.documentElement : scrolledParent;
            /** @type {?} */
            var scrollPosition = /** @type {?} */this._parentPositions.get(scrolledParent).scrollPosition;
            /** @type {?} */
            var topDifference = scrollPosition.top - newTop;
            /** @type {?} */
            var leftDifference = scrollPosition.left - newLeft;
            // Go through and update the cached positions of the scroll
            // parents that are inside the element that was scrolled.
            this._parentPositions.forEach(
            /**
            * @param {?} position
            * @param {?} node
            * @return {?}
            */
            function (position, node) {
              if (position.clientRect && scrolledParent !== node && scrolledParentNode.contains(node)) {
                adjustClientRect(position.clientRect, topDifference, leftDifference);
              }
            });
            // Since we know the amount that the user has scrolled we can shift all of the client rectangles
            // ourselves. This is cheaper than re-measuring everything and we can avoid inconsistent
            // behavior where we might be measuring the element before its position has changed.
            this._itemPositions.forEach(
            /**
            * @param {?} __0
            * @return {?}
            */
            function (_ref3) {
              var clientRect = _ref3.clientRect;
              adjustClientRect(clientRect, topDifference, leftDifference);
            });
            // We need two loops for this, because we want all of the cached
            // positions to be up-to-date before we re-sort the item.
            this._itemPositions.forEach(
            /**
            * @param {?} __0
            * @return {?}
            */
            function (_ref4) {
              var drag = _ref4.drag;
              if (_this15._dragDropRegistry.isDragging(drag)) {
                // We need to re-sort the item manually, because the pointer move
                // events won't be dispatched while the user is scrolling.
                drag._sortFromLastPointerPosition();
              }
            });
            scrollPosition.top = newTop;
            scrollPosition.left = newLeft;
          }
          /**
           * Checks whether the user's pointer is positioned over the container.
           * @param {?} x Pointer position along the X axis.
           * @param {?} y Pointer position along the Y axis.
           * @return {?}
           */
        }, {
          key: "_isOverContainer",
          value: function _isOverContainer(x, y) {
            return isInsideClientRect(this._clientRect, x, y);
          }
          /**
           * Figures out whether an item should be moved into a sibling
           * drop container, based on its current position.
           * @param {?} item Drag item that is being moved.
           * @param {?} x Position of the item along the X axis.
           * @param {?} y Position of the item along the Y axis.
           * @return {?}
           */
        }, {
          key: "_getSiblingContainerFromPosition",
          value: function _getSiblingContainerFromPosition(item, x, y) {
            return this._siblings.find(
            /**
            * @param {?} sibling
            * @return {?}
            */
            function (sibling) {
              return sibling._canReceive(item, x, y);
            });
          }
          /**
           * Checks whether the drop list can receive the passed-in item.
           * @param {?} item Item that is being dragged into the list.
           * @param {?} x Position of the item along the X axis.
           * @param {?} y Position of the item along the Y axis.
           * @return {?}
           */
        }, {
          key: "_canReceive",
          value: function _canReceive(item, x, y) {
            if (!isInsideClientRect(this._clientRect, x, y) || !this.enterPredicate(item, this)) {
              return false;
            }
            /** @type {?} */
            var elementFromPoint = /** @type {?} */this._getShadowRoot().elementFromPoint(x, y);
            // If there's no element at the pointer position, then
            // the client rect is probably scrolled out of the view.
            if (!elementFromPoint) {
              return false;
            }
            /** @type {?} */
            var nativeElement = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(this.element);
            // The `ClientRect`, that we're using to find the container over which the user is
            // hovering, doesn't give us any information on whether the element has been scrolled
            // out of the view or whether it's overlapping with other containers. This means that
            // we could end up transferring the item into a container that's invisible or is positioned
            // below another one. We use the result from `elementFromPoint` to get the top-most element
            // at the pointer position and to find whether it's one of the intersecting drop containers.
            return elementFromPoint === nativeElement || nativeElement.contains(elementFromPoint);
          }
          /**
           * Called by one of the connected drop lists when a dragging sequence has started.
           * @param {?} sibling Sibling in which dragging has started.
           * @return {?}
           */
        }, {
          key: "_startReceiving",
          value: function _startReceiving(sibling) {
            /** @type {?} */
            var activeSiblings = this._activeSiblings;
            if (!activeSiblings.has(sibling)) {
              activeSiblings.add(sibling);
              this._cacheParentPositions();
              this._listenToScrollEvents();
            }
          }
          /**
           * Called by a connected drop list when dragging has stopped.
           * @param {?} sibling Sibling whose dragging has stopped.
           * @return {?}
           */
        }, {
          key: "_stopReceiving",
          value: function _stopReceiving(sibling) {
            this._activeSiblings["delete"](sibling);
            this._viewportScrollSubscription.unsubscribe();
          }
          /**
           * Starts listening to scroll events on the viewport.
           * Used for updating the internal state of the list.
           * @private
           * @return {?}
           */
        }, {
          key: "_listenToScrollEvents",
          value: function _listenToScrollEvents() {
            var _this16 = this;
            this._viewportScrollSubscription = this._dragDropRegistry.scroll.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              if (_this16.isDragging()) {
                /** @type {?} */
                var target = /** @type {?} */event.target;
                /** @type {?} */
                var position = _this16._parentPositions.get(target);
                if (position) {
                  /** @type {?} */
                  var newTop;
                  /** @type {?} */
                  var newLeft;
                  if (target === _this16._document) {
                    /** @type {?} */
                    var scrollPosition = /** @type {?} */_this16._viewportRuler.getViewportScrollPosition();
                    newTop = scrollPosition.top;
                    newLeft = scrollPosition.left;
                  } else {
                    newTop = /** @type {?} */target.scrollTop;
                    newLeft = /** @type {?} */target.scrollLeft;
                  }
                  _this16._updateAfterScroll(target, newTop, newLeft);
                }
              } else if (_this16.isReceiving()) {
                _this16._cacheParentPositions();
              }
            });
          }
          /**
           * Lazily resolves and returns the shadow root of the element. We do this in a function, rather
           * than saving it in property directly on init, because we want to resolve it as late as possible
           * in order to ensure that the element has been moved into the shadow DOM. Doing it inside the
           * constructor might be too early if the element is inside of something like `ngFor` or `ngIf`.
           * @private
           * @return {?}
           */
        }, {
          key: "_getShadowRoot",
          value: function _getShadowRoot() {
            if (!this._cachedShadowRoot) {
              /** @type {?} */
              var shadowRoot = /** @type {?} */Object(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_3__["_getShadowRoot"])(Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(this.element));
              this._cachedShadowRoot = shadowRoot || this._document;
            }
            return this._cachedShadowRoot;
          }
        }]);
        return DropListRef;
      }();
      if (false) {}
      /**
       * Updates the top/left positions of a `ClientRect`, as well as their bottom/right counterparts.
       * @param {?} clientRect `ClientRect` that should be updated.
       * @param {?} top Amount to add to the `top` position.
       * @param {?} left Amount to add to the `left` position.
       * @return {?}
       */
      function adjustClientRect(clientRect, top, left) {
        clientRect.top += top;
        clientRect.bottom = clientRect.top + clientRect.height;
        clientRect.left += left;
        clientRect.right = clientRect.left + clientRect.width;
      }
      /**
       * Checks whether the pointer coordinates are close to a ClientRect.
       * @param {?} rect ClientRect to check against.
       * @param {?} pointerX Coordinates along the X axis.
       * @param {?} pointerY Coordinates along the Y axis.
       * @return {?}
       */
      function isPointerNearClientRect(rect, pointerX, pointerY) {
        var top = rect.top,
          right = rect.right,
          bottom = rect.bottom,
          left = rect.left,
          width = rect.width,
          height = rect.height;
        /** @type {?} */
        var xThreshold = width * DROP_PROXIMITY_THRESHOLD;
        /** @type {?} */
        var yThreshold = height * DROP_PROXIMITY_THRESHOLD;
        return pointerY > top - yThreshold && pointerY < bottom + yThreshold && pointerX > left - xThreshold && pointerX < right + xThreshold;
      }
      /**
       * Finds the index of an item that matches a predicate function. Used as an equivalent
       * of `Array.prototype.findIndex` which isn't part of the standard Google typings.
       * @template T
       * @param {?} array Array in which to look for matches.
       * @param {?} predicate Function used to determine whether an item is a match.
       * @return {?}
       */
      function findIndex(array, predicate) {
        for (var i = 0; i < array.length; i++) {
          if (predicate(array[i], i, array)) {
            return i;
          }
        }
        return -1;
      }
      /**
       * Checks whether some coordinates are within a `ClientRect`.
       * @param {?} clientRect ClientRect that is being checked.
       * @param {?} x Coordinates along the X axis.
       * @param {?} y Coordinates along the Y axis.
       * @return {?}
       */
      function isInsideClientRect(clientRect, x, y) {
        var top = clientRect.top,
          bottom = clientRect.bottom,
          left = clientRect.left,
          right = clientRect.right;
        return y >= top && y <= bottom && x >= left && x <= right;
      }
      /**
       * Gets a mutable version of an element's bounding `ClientRect`.
       * @param {?} element
       * @return {?}
       */
      function getMutableClientRect(element) {
        /** @type {?} */
        var clientRect = element.getBoundingClientRect();
        // We need to clone the `clientRect` here, because all the values on it are readonly
        // and we need to be able to update them. Also we can't use a spread here, because
        // the values on a `ClientRect` aren't own properties. See:
        // https://developer.mozilla.org/en-US/docs/Web/API/Element/getBoundingClientRect#Notes
        return {
          top: clientRect.top,
          right: clientRect.right,
          bottom: clientRect.bottom,
          left: clientRect.left,
          width: clientRect.width,
          height: clientRect.height
        };
      }
      /**
       * Increments the vertical scroll position of a node.
       * @param {?} node Node whose scroll position should change.
       * @param {?} amount Amount of pixels that the `node` should be scrolled.
       * @return {?}
       */
      function incrementVerticalScroll(node, amount) {
        if (node === window) {
          /** @type {?} */node.scrollBy(0, amount);
        } else {
          // Ideally we could use `Element.scrollBy` here as well, but IE and Edge don't support it.
          /** @type {?} */node.scrollTop += amount;
        }
      }
      /**
       * Increments the horizontal scroll position of a node.
       * @param {?} node Node whose scroll position should change.
       * @param {?} amount Amount of pixels that the `node` should be scrolled.
       * @return {?}
       */
      function incrementHorizontalScroll(node, amount) {
        if (node === window) {
          /** @type {?} */node.scrollBy(amount, 0);
        } else {
          // Ideally we could use `Element.scrollBy` here as well, but IE and Edge don't support it.
          /** @type {?} */node.scrollLeft += amount;
        }
      }
      /**
       * Gets whether the vertical auto-scroll direction of a node.
       * @param {?} clientRect Dimensions of the node.
       * @param {?} pointerY Position of the user's pointer along the y axis.
       * @return {?}
       */
      function getVerticalScrollDirection(clientRect, pointerY) {
        var top = clientRect.top,
          bottom = clientRect.bottom,
          height = clientRect.height;
        /** @type {?} */
        var yThreshold = height * SCROLL_PROXIMITY_THRESHOLD;
        if (pointerY >= top - yThreshold && pointerY <= top + yThreshold) {
          return 1 /* UP */;
        } else if (pointerY >= bottom - yThreshold && pointerY <= bottom + yThreshold) {
          return 2 /* DOWN */;
        }

        return 0 /* NONE */;
      }
      /**
       * Gets whether the horizontal auto-scroll direction of a node.
       * @param {?} clientRect Dimensions of the node.
       * @param {?} pointerX Position of the user's pointer along the x axis.
       * @return {?}
       */
      function getHorizontalScrollDirection(clientRect, pointerX) {
        var left = clientRect.left,
          right = clientRect.right,
          width = clientRect.width;
        /** @type {?} */
        var xThreshold = width * SCROLL_PROXIMITY_THRESHOLD;
        if (pointerX >= left - xThreshold && pointerX <= left + xThreshold) {
          return 1 /* LEFT */;
        } else if (pointerX >= right - xThreshold && pointerX <= right + xThreshold) {
          return 2 /* RIGHT */;
        }

        return 0 /* NONE */;
      }
      /**
       * Gets the directions in which an element node should be scrolled,
       * assuming that the user's pointer is already within it scrollable region.
       * @param {?} element Element for which we should calculate the scroll direction.
       * @param {?} clientRect Bounding client rectangle of the element.
       * @param {?} pointerX Position of the user's pointer along the x axis.
       * @param {?} pointerY Position of the user's pointer along the y axis.
       * @return {?}
       */
      function getElementScrollDirections(element, clientRect, pointerX, pointerY) {
        /** @type {?} */
        var computedVertical = getVerticalScrollDirection(clientRect, pointerY);
        /** @type {?} */
        var computedHorizontal = getHorizontalScrollDirection(clientRect, pointerX);
        /** @type {?} */
        var verticalScrollDirection = 0 /* NONE */;
        /** @type {?} */
        var horizontalScrollDirection = 0 /* NONE */;
        // Note that we here we do some extra checks for whether the element is actually scrollable in
        // a certain direction and we only assign the scroll direction if it is. We do this so that we
        // can allow other elements to be scrolled, if the current element can't be scrolled anymore.
        // This allows us to handle cases where the scroll regions of two scrollable elements overlap.
        if (computedVertical) {
          /** @type {?} */
          var scrollTop = element.scrollTop;
          if (computedVertical === 1 /* UP */) {
            if (scrollTop > 0) {
              verticalScrollDirection = 1 /* UP */;
            }
          } else if (element.scrollHeight - scrollTop > element.clientHeight) {
            verticalScrollDirection = 2 /* DOWN */;
          }
        }

        if (computedHorizontal) {
          /** @type {?} */
          var scrollLeft = element.scrollLeft;
          if (computedHorizontal === 1 /* LEFT */) {
            if (scrollLeft > 0) {
              horizontalScrollDirection = 1 /* LEFT */;
            }
          } else if (element.scrollWidth - scrollLeft > element.clientWidth) {
            horizontalScrollDirection = 2 /* RIGHT */;
          }
        }

        return [verticalScrollDirection, horizontalScrollDirection];
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-drop-registry.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Event options that can be used to bind an active, capturing event.
       * @type {?}
       */
      var activeCapturingEventOptions = Object(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_3__["normalizePassiveListenerOptions"])({
        passive: false,
        capture: true
      });
      /**
       * Service that keeps track of all the drag item and drop container
       * instances, and manages global event listeners on the `document`.
       * \@docs-private
       * @template I, C
       */
      // Note: this class is generic, rather than referencing CdkDrag and CdkDropList directly, in order
      // to avoid circular imports. If we were to reference them here, importing the registry into the
      // classes that are registering themselves will introduce a circular import.
      var DragDropRegistry = /*#__PURE__*/function () {
        /**
         * @param {?} _ngZone
         * @param {?} _document
         */
        function DragDropRegistry(_ngZone, _document) {
          var _this17 = this;
          _classCallCheck(this, DragDropRegistry);
          this._ngZone = _ngZone;
          /**
           * Registered drop container instances.
           */
          this._dropInstances = new Set();
          /**
           * Registered drag item instances.
           */
          this._dragInstances = new Set();
          /**
           * Drag item instances that are currently being dragged.
           */
          this._activeDragInstances = new Set();
          /**
           * Keeps track of the event listeners that we've bound to the `document`.
           */
          this._globalListeners = new Map();
          /**
           * Emits the `touchmove` or `mousemove` events that are dispatched
           * while the user is dragging a drag item instance.
           */
          this.pointerMove = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits the `touchend` or `mouseup` events that are dispatched
           * while the user is dragging a drag item instance.
           */
          this.pointerUp = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the viewport has been scrolled while the user is dragging an item.
           */
          this.scroll = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Event listener that will prevent the default browser action while the user is dragging.
           * @param event Event whose default action should be prevented.
           */
          this._preventDefaultWhileDragging =
          /**
          * @param {?} event
          * @return {?}
          */
          function (event) {
            if (_this17._activeDragInstances.size) {
              event.preventDefault();
            }
          };
          this._document = _document;
        }
        /**
         * Adds a drop container to the registry.
         * @param {?} drop
         * @return {?}
         */
        _createClass(DragDropRegistry, [{
          key: "registerDropContainer",
          value: function registerDropContainer(drop) {
            if (!this._dropInstances.has(drop)) {
              this._dropInstances.add(drop);
            }
          }
          /**
           * Adds a drag item instance to the registry.
           * @param {?} drag
           * @return {?}
           */
        }, {
          key: "registerDragItem",
          value: function registerDragItem(drag) {
            var _this18 = this;
            this._dragInstances.add(drag);
            // The `touchmove` event gets bound once, ahead of time, because WebKit
            // won't preventDefault on a dynamically-added `touchmove` listener.
            // See https://bugs.webkit.org/show_bug.cgi?id=184250.
            if (this._dragInstances.size === 1) {
              this._ngZone.runOutsideAngular(
              /**
              * @return {?}
              */
              function () {
                // The event handler has to be explicitly active,
                // because newer browsers make it passive by default.
                _this18._document.addEventListener('touchmove', _this18._preventDefaultWhileDragging, activeCapturingEventOptions);
              });
            }
          }
          /**
           * Removes a drop container from the registry.
           * @param {?} drop
           * @return {?}
           */
        }, {
          key: "removeDropContainer",
          value: function removeDropContainer(drop) {
            this._dropInstances["delete"](drop);
          }
          /**
           * Removes a drag item instance from the registry.
           * @param {?} drag
           * @return {?}
           */
        }, {
          key: "removeDragItem",
          value: function removeDragItem(drag) {
            this._dragInstances["delete"](drag);
            this.stopDragging(drag);
            if (this._dragInstances.size === 0) {
              this._document.removeEventListener('touchmove', this._preventDefaultWhileDragging, activeCapturingEventOptions);
            }
          }
          /**
           * Starts the dragging sequence for a drag instance.
           * @param {?} drag Drag instance which is being dragged.
           * @param {?} event Event that initiated the dragging.
           * @return {?}
           */
        }, {
          key: "startDragging",
          value: function startDragging(drag, event) {
            var _this19 = this;
            // Do not process the same drag twice to avoid memory leaks and redundant listeners
            if (this._activeDragInstances.has(drag)) {
              return;
            }
            this._activeDragInstances.add(drag);
            if (this._activeDragInstances.size === 1) {
              /** @type {?} */
              var _isTouchEvent = event.type.startsWith('touch');
              /** @type {?} */
              var moveEvent = _isTouchEvent ? 'touchmove' : 'mousemove';
              /** @type {?} */
              var upEvent = _isTouchEvent ? 'touchend' : 'mouseup';
              // We explicitly bind __active__ listeners here, because newer browsers will default to
              // passive ones for `mousemove` and `touchmove`. The events need to be active, because we
              // use `preventDefault` to prevent the page from scrolling while the user is dragging.
              this._globalListeners.set(moveEvent, {
                handler:
                /**
                * @param {?} e
                * @return {?}
                */
                function handler(e) {
                  return _this19.pointerMove.next( /** @type {?} */e);
                },
                options: activeCapturingEventOptions
              }).set(upEvent, {
                handler:
                /**
                * @param {?} e
                * @return {?}
                */
                function handler(e) {
                  return _this19.pointerUp.next( /** @type {?} */e);
                },
                options: true
              }).set('scroll', {
                handler:
                /**
                * @param {?} e
                * @return {?}
                */
                function handler(e) {
                  return _this19.scroll.next(e);
                },
                // Use capturing so that we pick up scroll changes in any scrollable nodes that aren't
                // the document. See https://github.com/angular/components/issues/17144.
                options: true
              })
              // Preventing the default action on `mousemove` isn't enough to disable text selection
              // on Safari so we need to prevent the selection event as well. Alternatively this can
              // be done by setting `user-select: none` on the `body`, however it has causes a style
              // recalculation which can be expensive on pages with a lot of elements.
              .set('selectstart', {
                handler: this._preventDefaultWhileDragging,
                options: activeCapturingEventOptions
              });
              this._ngZone.runOutsideAngular(
              /**
              * @return {?}
              */
              function () {
                _this19._globalListeners.forEach(
                /**
                * @param {?} config
                * @param {?} name
                * @return {?}
                */
                function (config, name) {
                  _this19._document.addEventListener(name, config.handler, config.options);
                });
              });
            }
          }
          /**
           * Stops dragging a drag item instance.
           * @param {?} drag
           * @return {?}
           */
        }, {
          key: "stopDragging",
          value: function stopDragging(drag) {
            this._activeDragInstances["delete"](drag);
            if (this._activeDragInstances.size === 0) {
              this._clearGlobalListeners();
            }
          }
          /**
           * Gets whether a drag item instance is currently being dragged.
           * @param {?} drag
           * @return {?}
           */
        }, {
          key: "isDragging",
          value: function isDragging(drag) {
            return this._activeDragInstances.has(drag);
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            var _this20 = this;
            this._dragInstances.forEach(
            /**
            * @param {?} instance
            * @return {?}
            */
            function (instance) {
              return _this20.removeDragItem(instance);
            });
            this._dropInstances.forEach(
            /**
            * @param {?} instance
            * @return {?}
            */
            function (instance) {
              return _this20.removeDropContainer(instance);
            });
            this._clearGlobalListeners();
            this.pointerMove.complete();
            this.pointerUp.complete();
          }
          /**
           * Clears out the global event listeners from the `document`.
           * @private
           * @return {?}
           */
        }, {
          key: "_clearGlobalListeners",
          value: function _clearGlobalListeners() {
            var _this21 = this;
            this._globalListeners.forEach(
            /**
            * @param {?} config
            * @param {?} name
            * @return {?}
            */
            function (config, name) {
              _this21._document.removeEventListener(name, config.handler, config.options);
            });
            this._globalListeners.clear();
          }
        }]);
        return DragDropRegistry;
      }();
      DragDropRegistry.ɵfac = function DragDropRegistry_Factory(t) {
        return new (t || DragDropRegistry)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]));
      };
      /** @nocollapse */
      DragDropRegistry.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]]
          }]
        }];
      };
      /** @nocollapse */
      DragDropRegistry.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"])({
        factory: function DragDropRegistry_Factory() {
          return new DragDropRegistry(Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]));
        },
        token: DragDropRegistry,
        providedIn: "root"
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DragDropRegistry, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]]
            }]
          }];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-drop.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Default configuration to be used when creating a `DragRef`.
       * @type {?}
       */
      var DEFAULT_CONFIG = {
        dragStartThreshold: 5,
        pointerDirectionChangeThreshold: 5
      };
      /**
       * Service that allows for drag-and-drop functionality to be attached to DOM elements.
       */
      var DragDrop = /*#__PURE__*/function () {
        /**
         * @param {?} _document
         * @param {?} _ngZone
         * @param {?} _viewportRuler
         * @param {?} _dragDropRegistry
         */
        function DragDrop(_document, _ngZone, _viewportRuler, _dragDropRegistry) {
          _classCallCheck(this, DragDrop);
          this._document = _document;
          this._ngZone = _ngZone;
          this._viewportRuler = _viewportRuler;
          this._dragDropRegistry = _dragDropRegistry;
        }
        /**
         * Turns an element into a draggable item.
         * @template T
         * @param {?} element Element to which to attach the dragging functionality.
         * @param {?=} config Object used to configure the dragging behavior.
         * @return {?}
         */
        _createClass(DragDrop, [{
          key: "createDrag",
          value: function createDrag(element) {
            var config = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : DEFAULT_CONFIG;
            return new DragRef(element, config, this._document, this._ngZone, this._viewportRuler, this._dragDropRegistry);
          }
          /**
           * Turns an element into a drop list.
           * @template T
           * @param {?} element Element to which to attach the drop list functionality.
           * @return {?}
           */
        }, {
          key: "createDropList",
          value: function createDropList(element) {
            return new DropListRef(element, this._dragDropRegistry, this._document, this._ngZone, this._viewportRuler);
          }
        }]);
        return DragDrop;
      }();
      DragDrop.ɵfac = function DragDrop_Factory(t) {
        return new (t || DragDrop)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ViewportRuler"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](DragDropRegistry));
      };
      /** @nocollapse */
      DragDrop.ctorParameters = function () {
        return [{
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
        }, {
          type: _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ViewportRuler"]
        }, {
          type: DragDropRegistry
        }];
      };
      /** @nocollapse */
      DragDrop.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"])({
        factory: function DragDrop_Factory() {
          return new DragDrop(Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ViewportRuler"]), Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(DragDropRegistry));
        },
        token: DragDrop,
        providedIn: "root"
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DragDrop, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
          }, {
            type: _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ViewportRuler"]
          }, {
            type: DragDropRegistry
          }];
        }, null);
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-events.ts
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
       * Event emitted when the user starts dragging a draggable.
       * @record
       * @template T
       */
      function CdkDragStart() {}
      if (false) {}
      /**
       * Event emitted when the user releases an item, before any animations have started.
       * @record
       * @template T
       */
      function CdkDragRelease() {}
      if (false) {}
      /**
       * Event emitted when the user stops dragging a draggable.
       * @record
       * @template T
       */
      function CdkDragEnd() {}
      if (false) {}
      /**
       * Event emitted when the user moves an item into a new drop container.
       * @record
       * @template T, I
       */
      function CdkDragEnter() {}
      if (false) {}
      /**
       * Event emitted when the user removes an item from a
       * drop container by moving it into another one.
       * @record
       * @template T, I
       */
      function CdkDragExit() {}
      if (false) {}
      /**
       * Event emitted when the user drops a draggable item inside a drop container.
       * @record
       * @template T, O
       */
      function CdkDragDrop() {}
      if (false) {}
      /**
       * Event emitted as the user is dragging a draggable item.
       * @record
       * @template T
       */
      function CdkDragMove() {}
      if (false) {}
      /**
       * Event emitted when the user swaps the position of two drag items.
       * @record
       * @template T, I
       */
      function CdkDragSortEvent() {}
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-parent.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used for a `CdkDrag` to provide itself as a parent to the
       * drag-specific child directive (`CdkDragHandle`, `CdkDragPreview` etc.). Used primarily
       * to avoid circular imports.
       * \@docs-private
       * @type {?}
       */
      var CDK_DRAG_PARENT = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('CDK_DRAG_PARENT');

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/drag-handle.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Handle that can be used to drag and CdkDrag instance.
       */
      var CdkDragHandle = /*#__PURE__*/function () {
        /**
         * @param {?} element
         * @param {?=} parentDrag
         */
        function CdkDragHandle(element, parentDrag) {
          _classCallCheck(this, CdkDragHandle);
          this.element = element;
          /**
           * Emits when the state of the handle has changed.
           */
          this._stateChanges = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          this._disabled = false;
          this._parentDrag = parentDrag;
          toggleNativeDragInteractions(element.nativeElement, false);
        }
        /**
         * Whether starting to drag through this handle is disabled.
         * @return {?}
         */
        _createClass(CdkDragHandle, [{
          key: "disabled",
          get: function get() {
            return this._disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._disabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(value);
            this._stateChanges.next(this);
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._stateChanges.complete();
          }
        }]);
        return CdkDragHandle;
      }();
      CdkDragHandle.ɵfac = function CdkDragHandle_Factory(t) {
        return new (t || CdkDragHandle)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](CDK_DRAG_PARENT, 8));
      };
      CdkDragHandle.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: CdkDragHandle,
        selectors: [["", "cdkDragHandle", ""]],
        hostAttrs: [1, "cdk-drag-handle"],
        inputs: {
          disabled: ["cdkDragHandleDisabled", "disabled"]
        }
      });
      /** @nocollapse */
      CdkDragHandle.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [CDK_DRAG_PARENT]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }]
        }];
      };
      CdkDragHandle.propDecorators = {
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragHandleDisabled']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CdkDragHandle, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: '[cdkDragHandle]',
            host: {
              'class': 'cdk-drag-handle'
            }
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [CDK_DRAG_PARENT]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, {
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragHandleDisabled']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/drag-placeholder.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Element that will be used as a template for the placeholder of a CdkDrag when
       * it is being dragged. The placeholder is displayed in place of the element being dragged.
       * @template T
       */
      var CdkDragPlaceholder = /*#__PURE__*/_createClass(
      /**
       * @param {?} templateRef
       */
      function CdkDragPlaceholder(templateRef) {
        _classCallCheck(this, CdkDragPlaceholder);
        this.templateRef = templateRef;
      });
      CdkDragPlaceholder.ɵfac = function CdkDragPlaceholder_Factory(t) {
        return new (t || CdkDragPlaceholder)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["TemplateRef"]));
      };
      CdkDragPlaceholder.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: CdkDragPlaceholder,
        selectors: [["ng-template", "cdkDragPlaceholder", ""]],
        inputs: {
          data: "data"
        }
      });
      /** @nocollapse */
      CdkDragPlaceholder.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["TemplateRef"]
        }];
      };
      CdkDragPlaceholder.propDecorators = {
        data: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CdkDragPlaceholder, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: 'ng-template[cdkDragPlaceholder]'
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["TemplateRef"]
          }];
        }, {
          data: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/drag-preview.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Element that will be used as a template for the preview
       * of a CdkDrag when it is being dragged.
       * @template T
       */
      var CdkDragPreview = /*#__PURE__*/function () {
        /**
         * @param {?} templateRef
         */
        function CdkDragPreview(templateRef) {
          _classCallCheck(this, CdkDragPreview);
          this.templateRef = templateRef;
          this._matchSize = false;
        }
        /**
         * Whether the preview should preserve the same size as the item that is being dragged.
         * @return {?}
         */
        _createClass(CdkDragPreview, [{
          key: "matchSize",
          get: function get() {
            return this._matchSize;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._matchSize = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(value);
          }
        }]);
        return CdkDragPreview;
      }();
      CdkDragPreview.ɵfac = function CdkDragPreview_Factory(t) {
        return new (t || CdkDragPreview)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["TemplateRef"]));
      };
      CdkDragPreview.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: CdkDragPreview,
        selectors: [["ng-template", "cdkDragPreview", ""]],
        inputs: {
          matchSize: "matchSize",
          data: "data"
        }
      });
      /** @nocollapse */
      CdkDragPreview.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["TemplateRef"]
        }];
      };
      CdkDragPreview.propDecorators = {
        data: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
        }],
        matchSize: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CdkDragPreview, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: 'ng-template[cdkDragPreview]'
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["TemplateRef"]
          }];
        }, {
          matchSize: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
          }],
          data: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/config.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that can be used to configure the
       * behavior of the drag&drop-related components.
       * @type {?}
       */
      var CDK_DRAG_CONFIG = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('CDK_DRAG_CONFIG');
      /**
       * Object that can be used to configure the drag
       * items and drop lists within a module or a component.
       * @record
       */
      function DragDropConfig() {}
      if (false) {}
      /**
       * @deprecated No longer being used. To be removed.
       * \@breaking-change 10.0.0
       * \@docs-private
       * @return {?}
       */
      function CDK_DRAG_CONFIG_FACTORY() {
        return {
          dragStartThreshold: 5,
          pointerDirectionChangeThreshold: 5
        };
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/drag.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Injection token that is used to provide a CdkDropList instance to CdkDrag.
       * Used for avoiding circular imports.
       * @type {?}
       */
      var CDK_DROP_LIST = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('CDK_DROP_LIST');
      /**
       * Element that can be moved inside a CdkDropList container.
       * @template T
       */
      var CdkDrag = /*#__PURE__*/function () {
        /**
         * @param {?} element
         * @param {?} dropContainer
         * @param {?} _document
         * @param {?} _ngZone
         * @param {?} _viewContainerRef
         * @param {?} config
         * @param {?} _dir
         * @param {?} dragDrop
         * @param {?} _changeDetectorRef
         */
        function CdkDrag(element, dropContainer, _document, _ngZone, _viewContainerRef, config, _dir, dragDrop, _changeDetectorRef) {
          var _this22 = this;
          _classCallCheck(this, CdkDrag);
          this.element = element;
          this.dropContainer = dropContainer;
          this._document = _document;
          this._ngZone = _ngZone;
          this._viewContainerRef = _viewContainerRef;
          this._dir = _dir;
          this._changeDetectorRef = _changeDetectorRef;
          this._destroyed = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Emits when the user starts dragging the item.
           */
          this.started = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user has released a drag item, before any animations have started.
           */
          this.released = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user stops dragging an item in the container.
           */
          this.ended = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user has moved the item into a new container.
           */
          this.entered = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user removes the item its container by dragging it into another container.
           */
          this.exited = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user drops the item inside a container.
           */
          this.dropped = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits as the user is dragging the item. Use with caution,
           * because this event will fire for every pixel that the user has dragged.
           */
          this.moved = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Observable"](
          /**
          * @param {?} observer
          * @return {?}
          */
          function (observer) {
            /** @type {?} */
            var subscription = _this22._dragRef.moved.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["map"])(
            /**
            * @param {?} movedEvent
            * @return {?}
            */
            function (movedEvent) {
              return {
                source: _this22,
                pointerPosition: movedEvent.pointerPosition,
                event: movedEvent.event,
                delta: movedEvent.delta,
                distance: movedEvent.distance
              };
            })).subscribe(observer);
            return (
              /**
              * @return {?}
              */
              function () {
                subscription.unsubscribe();
              }
            );
          });
          this._dragRef = dragDrop.createDrag(element, {
            dragStartThreshold: config && config.dragStartThreshold != null ? config.dragStartThreshold : 5,
            pointerDirectionChangeThreshold: config && config.pointerDirectionChangeThreshold != null ? config.pointerDirectionChangeThreshold : 5
          });
          this._dragRef.data = this;
          if (config) {
            this._assignDefaults(config);
          }
          // Note that usually the container is assigned when the drop list is picks up the item, but in
          // some cases (mainly transplanted views with OnPush, see #18341) we may end up in a situation
          // where there are no items on the first change detection pass, but the items get picked up as
          // soon as the user triggers another pass by dragging. This is a problem, because the item would
          // have to switch from standalone mode to drag mode in the middle of the dragging sequence which
          // is too late since the two modes save different kinds of information. We work around it by
          // assigning the drop container both from here and the list.
          if (dropContainer) {
            this._dragRef._withDropContainer(dropContainer._dropListRef);
            dropContainer.addItem(this);
          }
          this._syncInputs(this._dragRef);
          this._handleEvents(this._dragRef);
        }
        /**
         * Whether starting to drag this element is disabled.
         * @return {?}
         */
        _createClass(CdkDrag, [{
          key: "disabled",
          get: function get() {
            return this._disabled || this.dropContainer && this.dropContainer.disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._disabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(value);
            this._dragRef.disabled = this._disabled;
          }
          /**
           * Returns the element that is being used as a placeholder
           * while the current element is being dragged.
           * @return {?}
           */
        }, {
          key: "getPlaceholderElement",
          value: function getPlaceholderElement() {
            return this._dragRef.getPlaceholderElement();
          }
          /**
           * Returns the root draggable element.
           * @return {?}
           */
        }, {
          key: "getRootElement",
          value: function getRootElement() {
            return this._dragRef.getRootElement();
          }
          /**
           * Resets a standalone drag item to its initial position.
           * @return {?}
           */
        }, {
          key: "reset",
          value: function reset() {
            this._dragRef.reset();
          }
          /**
           * Gets the pixel coordinates of the draggable outside of a drop container.
           * @return {?}
           */
        }, {
          key: "getFreeDragPosition",
          value: function getFreeDragPosition() {
            return this._dragRef.getFreeDragPosition();
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterViewInit",
          value: function ngAfterViewInit() {
            var _this23 = this;
            // We need to wait for the zone to stabilize, in order for the reference
            // element to be in the proper place in the DOM. This is mostly relevant
            // for draggable elements inside portals since they get stamped out in
            // their original DOM position and then they get transferred to the portal.
            this._ngZone.onStable.asObservable().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["takeUntil"])(this._destroyed)).subscribe(
            /**
            * @return {?}
            */
            function () {
              _this23._updateRootElement();
              // Listen for any newly-added handles.
              _this23._handles.changes.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["startWith"])(_this23._handles),
              // Sync the new handles with the DragRef.
              Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["tap"])(
              /**
              * @param {?} handles
              * @return {?}
              */
              function (handles) {
                /** @type {?} */
                var childHandleElements = handles.filter(
                /**
                * @param {?} handle
                * @return {?}
                */
                function (handle) {
                  return handle._parentDrag === _this23;
                }).map(
                /**
                * @param {?} handle
                * @return {?}
                */
                function (handle) {
                  return handle.element;
                });
                _this23._dragRef.withHandles(childHandleElements);
              }),
              // Listen if the state of any of the handles changes.
              Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["switchMap"])(
              /**
              * @param {?} handles
              * @return {?}
              */
              function (handles) {
                return (/** @type {?} */Object(rxjs__WEBPACK_IMPORTED_MODULE_5__["merge"]).apply(void 0, _toConsumableArray(handles.map(
                  /**
                  * @param {?} item
                  * @return {?}
                  */
                  function (item) {
                    return item._stateChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["startWith"])(item));
                  })))
                );
              }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["takeUntil"])(_this23._destroyed)).subscribe(
              /**
              * @param {?} handleInstance
              * @return {?}
              */
              function (handleInstance) {
                // Enabled/disable the handle that changed in the DragRef.
                /** @type {?} */
                var dragRef = _this23._dragRef;
                /** @type {?} */
                var handle = handleInstance.element.nativeElement;
                handleInstance.disabled ? dragRef.disableHandle(handle) : dragRef.enableHandle(handle);
              });
              if (_this23.freeDragPosition) {
                _this23._dragRef.setFreeDragPosition(_this23.freeDragPosition);
              }
            });
          }
          /**
           * @param {?} changes
           * @return {?}
           */
        }, {
          key: "ngOnChanges",
          value: function ngOnChanges(changes) {
            /** @type {?} */
            var rootSelectorChange = changes['rootElementSelector'];
            /** @type {?} */
            var positionChange = changes['freeDragPosition'];
            // We don't have to react to the first change since it's being
            // handled in `ngAfterViewInit` where it needs to be deferred.
            if (rootSelectorChange && !rootSelectorChange.firstChange) {
              this._updateRootElement();
            }
            // Skip the first change since it's being handled in `ngAfterViewInit`.
            if (positionChange && !positionChange.firstChange && this.freeDragPosition) {
              this._dragRef.setFreeDragPosition(this.freeDragPosition);
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this.dropContainer) {
              this.dropContainer.removeItem(this);
            }
            this._destroyed.next();
            this._destroyed.complete();
            this._dragRef.dispose();
          }
          /**
           * Syncs the root element with the `DragRef`.
           * @private
           * @return {?}
           */
        }, {
          key: "_updateRootElement",
          value: function _updateRootElement() {
            /** @type {?} */
            var element = this.element.nativeElement;
            /** @type {?} */
            var rootElement = this.rootElementSelector ? getClosestMatchingAncestor(element, this.rootElementSelector) : element;
            if (rootElement && rootElement.nodeType !== this._document.ELEMENT_NODE) {
              throw Error("cdkDrag must be attached to an element node. " + "Currently attached to \"".concat(rootElement.nodeName, "\"."));
            }
            this._dragRef.withRootElement(rootElement || element);
          }
          /**
           * Gets the boundary element, based on the `boundaryElement` value.
           * @private
           * @return {?}
           */
        }, {
          key: "_getBoundaryElement",
          value: function _getBoundaryElement() {
            /** @type {?} */
            var boundary = this.boundaryElement;
            if (!boundary) {
              return null;
            }
            if (typeof boundary === 'string') {
              return getClosestMatchingAncestor(this.element.nativeElement, boundary);
            }
            /** @type {?} */
            var element = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceElement"])(boundary);
            if (Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["isDevMode"])() && !element.contains(this.element.nativeElement)) {
              throw Error('Draggable element is not inside of the node passed into cdkDragBoundary.');
            }
            return element;
          }
          /**
           * Syncs the inputs of the CdkDrag with the options of the underlying DragRef.
           * @private
           * @param {?} ref
           * @return {?}
           */
        }, {
          key: "_syncInputs",
          value: function _syncInputs(ref) {
            var _this24 = this;
            ref.beforeStarted.subscribe(
            /**
            * @return {?}
            */
            function () {
              if (!ref.isDragging()) {
                /** @type {?} */
                var dir = _this24._dir;
                /** @type {?} */
                var dragStartDelay = _this24.dragStartDelay;
                /** @type {?} */
                var placeholder = _this24._placeholderTemplate ? {
                  template: _this24._placeholderTemplate.templateRef,
                  context: _this24._placeholderTemplate.data,
                  viewContainer: _this24._viewContainerRef
                } : null;
                /** @type {?} */
                var preview = _this24._previewTemplate ? {
                  template: _this24._previewTemplate.templateRef,
                  context: _this24._previewTemplate.data,
                  matchSize: _this24._previewTemplate.matchSize,
                  viewContainer: _this24._viewContainerRef
                } : null;
                ref.disabled = _this24.disabled;
                ref.lockAxis = _this24.lockAxis;
                ref.dragStartDelay = typeof dragStartDelay === 'object' && dragStartDelay ? dragStartDelay : Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceNumberProperty"])(dragStartDelay);
                ref.constrainPosition = _this24.constrainPosition;
                ref.previewClass = _this24.previewClass;
                ref.withBoundaryElement(_this24._getBoundaryElement()).withPlaceholderTemplate(placeholder).withPreviewTemplate(preview);
                if (dir) {
                  ref.withDirection(dir.value);
                }
              }
            });
          }
          /**
           * Handles the events from the underlying `DragRef`.
           * @private
           * @param {?} ref
           * @return {?}
           */
        }, {
          key: "_handleEvents",
          value: function _handleEvents(ref) {
            var _this25 = this;
            ref.started.subscribe(
            /**
            * @return {?}
            */
            function () {
              _this25.started.emit({
                source: _this25
              });
              // Since all of these events run outside of change detection,
              // we need to ensure that everything is marked correctly.
              _this25._changeDetectorRef.markForCheck();
            });
            ref.released.subscribe(
            /**
            * @return {?}
            */
            function () {
              _this25.released.emit({
                source: _this25
              });
            });
            ref.ended.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this25.ended.emit({
                source: _this25,
                distance: event.distance
              });
              // Since all of these events run outside of change detection,
              // we need to ensure that everything is marked correctly.
              _this25._changeDetectorRef.markForCheck();
            });
            ref.entered.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this25.entered.emit({
                container: event.container.data,
                item: _this25,
                currentIndex: event.currentIndex
              });
            });
            ref.exited.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this25.exited.emit({
                container: event.container.data,
                item: _this25
              });
            });
            ref.dropped.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this25.dropped.emit({
                previousIndex: event.previousIndex,
                currentIndex: event.currentIndex,
                previousContainer: event.previousContainer.data,
                container: event.container.data,
                isPointerOverContainer: event.isPointerOverContainer,
                item: _this25,
                distance: event.distance
              });
            });
          }
          /**
           * Assigns the default input values based on a provided config object.
           * @private
           * @param {?} config
           * @return {?}
           */
        }, {
          key: "_assignDefaults",
          value: function _assignDefaults(config) {
            var lockAxis = config.lockAxis,
              dragStartDelay = config.dragStartDelay,
              constrainPosition = config.constrainPosition,
              previewClass = config.previewClass,
              boundaryElement = config.boundaryElement,
              draggingDisabled = config.draggingDisabled,
              rootElementSelector = config.rootElementSelector;
            this.disabled = draggingDisabled == null ? false : draggingDisabled;
            this.dragStartDelay = dragStartDelay || 0;
            if (lockAxis) {
              this.lockAxis = lockAxis;
            }
            if (constrainPosition) {
              this.constrainPosition = constrainPosition;
            }
            if (previewClass) {
              this.previewClass = previewClass;
            }
            if (boundaryElement) {
              this.boundaryElement = boundaryElement;
            }
            if (rootElementSelector) {
              this.rootElementSelector = rootElementSelector;
            }
          }
        }]);
        return CdkDrag;
      }();
      CdkDrag.ɵfac = function CdkDrag_Factory(t) {
        return new (t || CdkDrag)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](CDK_DROP_LIST, 12), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewContainerRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](CDK_DRAG_CONFIG, 8), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__["Directionality"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](DragDrop), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ChangeDetectorRef"]));
      };
      CdkDrag.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: CdkDrag,
        selectors: [["", "cdkDrag", ""]],
        contentQueries: function CdkDrag_ContentQueries(rf, ctx, dirIndex) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵcontentQuery"](dirIndex, CdkDragPreview, true);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵcontentQuery"](dirIndex, CdkDragPlaceholder, true);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵcontentQuery"](dirIndex, CdkDragHandle, true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx._previewTemplate = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx._placeholderTemplate = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx._handles = _t);
          }
        },
        hostAttrs: [1, "cdk-drag"],
        hostVars: 4,
        hostBindings: function CdkDrag_HostBindings(rf, ctx) {
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("cdk-drag-disabled", ctx.disabled)("cdk-drag-dragging", ctx._dragRef.isDragging());
          }
        },
        inputs: {
          disabled: ["cdkDragDisabled", "disabled"],
          dragStartDelay: ["cdkDragStartDelay", "dragStartDelay"],
          lockAxis: ["cdkDragLockAxis", "lockAxis"],
          constrainPosition: ["cdkDragConstrainPosition", "constrainPosition"],
          previewClass: ["cdkDragPreviewClass", "previewClass"],
          boundaryElement: ["cdkDragBoundary", "boundaryElement"],
          rootElementSelector: ["cdkDragRootElement", "rootElementSelector"],
          data: ["cdkDragData", "data"],
          freeDragPosition: ["cdkDragFreeDragPosition", "freeDragPosition"]
        },
        outputs: {
          started: "cdkDragStarted",
          released: "cdkDragReleased",
          ended: "cdkDragEnded",
          entered: "cdkDragEntered",
          exited: "cdkDragExited",
          dropped: "cdkDragDropped",
          moved: "cdkDragMoved"
        },
        exportAs: ["cdkDrag"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([{
          provide: CDK_DRAG_PARENT,
          useExisting: CdkDrag
        }]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵNgOnChangesFeature"]]
      });
      /** @nocollapse */
      CdkDrag.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [CDK_DROP_LIST]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
          }]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]]
          }]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewContainerRef"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [CDK_DRAG_CONFIG]
          }]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }]
        }, {
          type: DragDrop
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ChangeDetectorRef"]
        }];
      };
      CdkDrag.propDecorators = {
        _handles: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ContentChildren"],
          args: [CdkDragHandle, {
            descendants: true
          }]
        }],
        _previewTemplate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ContentChild"],
          args: [CdkDragPreview]
        }],
        _placeholderTemplate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ContentChild"],
          args: [CdkDragPlaceholder]
        }],
        data: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragData']
        }],
        lockAxis: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragLockAxis']
        }],
        rootElementSelector: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragRootElement']
        }],
        boundaryElement: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragBoundary']
        }],
        dragStartDelay: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragStartDelay']
        }],
        freeDragPosition: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragFreeDragPosition']
        }],
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragDisabled']
        }],
        constrainPosition: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragConstrainPosition']
        }],
        previewClass: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDragPreviewClass']
        }],
        started: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragStarted']
        }],
        released: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragReleased']
        }],
        ended: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragEnded']
        }],
        entered: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragEntered']
        }],
        exited: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragExited']
        }],
        dropped: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragDropped']
        }],
        moved: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDragMoved']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CdkDrag, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: '[cdkDrag]',
            exportAs: 'cdkDrag',
            host: {
              'class': 'cdk-drag',
              '[class.cdk-drag-disabled]': 'disabled',
              '[class.cdk-drag-dragging]': '_dragRef.isDragging()'
            },
            providers: [{
              provide: CDK_DRAG_PARENT,
              useExisting: CdkDrag
            }]
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [CDK_DROP_LIST]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
            }]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["DOCUMENT"]]
            }]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewContainerRef"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [CDK_DRAG_CONFIG]
            }]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }, {
            type: DragDrop
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ChangeDetectorRef"]
          }];
        }, {
          started: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragStarted']
          }],
          released: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragReleased']
          }],
          ended: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragEnded']
          }],
          entered: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragEntered']
          }],
          exited: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragExited']
          }],
          dropped: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragDropped']
          }],
          moved: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDragMoved']
          }],
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragDisabled']
          }],
          dragStartDelay: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragStartDelay']
          }],
          lockAxis: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragLockAxis']
          }],
          constrainPosition: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragConstrainPosition']
          }],
          previewClass: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragPreviewClass']
          }],
          boundaryElement: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragBoundary']
          }],
          rootElementSelector: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragRootElement']
          }],
          _handles: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ContentChildren"],
            args: [CdkDragHandle, {
              descendants: true
            }]
          }],
          _previewTemplate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ContentChild"],
            args: [CdkDragPreview]
          }],
          _placeholderTemplate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ContentChild"],
            args: [CdkDragPlaceholder]
          }],
          data: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragData']
          }],
          freeDragPosition: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDragFreeDragPosition']
          }]
        });
      })();
      if (false) {}
      /**
       * Gets the closest ancestor of an element that matches a selector.
       * @param {?} element
       * @param {?} selector
       * @return {?}
       */
      function getClosestMatchingAncestor(element, selector) {
        /** @type {?} */
        var currentElement = /** @type {?} */element.parentElement;
        while (currentElement) {
          // IE doesn't support `matches` so we have to fall back to `msMatchesSelector`.
          if (currentElement.matches ? currentElement.matches(selector) : /** @type {?} */currentElement.msMatchesSelector(selector)) {
            return currentElement;
          }
          currentElement = currentElement.parentElement;
        }
        return null;
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/drop-list-group.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Declaratively connects sibling `cdkDropList` instances together. All of the `cdkDropList`
       * elements that are placed inside a `cdkDropListGroup` will be connected to each other
       * automatically. Can be used as an alternative to the `cdkDropListConnectedTo` input
       * from `cdkDropList`.
       * @template T
       */
      var CdkDropListGroup = /*#__PURE__*/function () {
        function CdkDropListGroup() {
          _classCallCheck(this, CdkDropListGroup);
          /**
           * Drop lists registered inside the group.
           */
          this._items = new Set();
          this._disabled = false;
        }
        /**
         * Whether starting a dragging sequence from inside this group is disabled.
         * @return {?}
         */
        _createClass(CdkDropListGroup, [{
          key: "disabled",
          get: function get() {
            return this._disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._disabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(value);
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._items.clear();
          }
        }]);
        return CdkDropListGroup;
      }();
      CdkDropListGroup.ɵfac = function CdkDropListGroup_Factory(t) {
        return new (t || CdkDropListGroup)();
      };
      CdkDropListGroup.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: CdkDropListGroup,
        selectors: [["", "cdkDropListGroup", ""]],
        inputs: {
          disabled: ["cdkDropListGroupDisabled", "disabled"]
        },
        exportAs: ["cdkDropListGroup"]
      });
      CdkDropListGroup.propDecorators = {
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListGroupDisabled']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CdkDropListGroup, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: '[cdkDropListGroup]',
            exportAs: 'cdkDropListGroup'
          }]
        }], function () {
          return [];
        }, {
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListGroupDisabled']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/directives/drop-list.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Counter used to generate unique ids for drop zones.
       * @type {?}
       */
      var _uniqueIdCounter = 0;
      /**
       * Internal compile-time-only representation of a `CdkDropList`.
       * Used to avoid circular import issues between the `CdkDropList` and the `CdkDrag`.
       * \@docs-private
       * @record
       */
      function CdkDropListInternal() {}
      var ɵ0 = undefined;
      /**
       * Container that wraps a set of draggable items.
       * @template T
       */
      var CdkDropList = /*#__PURE__*/function () {
        /**
         * @param {?} element
         * @param {?} dragDrop
         * @param {?} _changeDetectorRef
         * @param {?=} _dir
         * @param {?=} _group
         * @param {?=} _scrollDispatcher
         * @param {?=} config
         */
        function CdkDropList(element, dragDrop, _changeDetectorRef, _dir, _group, _scrollDispatcher, config) {
          var _this26 = this;
          _classCallCheck(this, CdkDropList);
          this.element = element;
          this._changeDetectorRef = _changeDetectorRef;
          this._dir = _dir;
          this._group = _group;
          this._scrollDispatcher = _scrollDispatcher;
          /**
           * Emits when the list has been destroyed.
           */
          this._destroyed = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
          /**
           * Other draggable containers that this container is connected to and into which the
           * container's items can be transferred. Can either be references to other drop containers,
           * or their unique IDs.
           */
          this.connectedTo = [];
          /**
           * Unique ID for the drop zone. Can be used as a reference
           * in the `connectedTo` of another `CdkDropList`.
           */
          this.id = "cdk-drop-list-".concat(_uniqueIdCounter++);
          /**
           * Function that is used to determine whether an item
           * is allowed to be moved into a drop container.
           */
          this.enterPredicate =
          /**
          * @return {?}
          */
          function () {
            return true;
          };
          /**
           * Emits when the user drops an item inside the container.
           */
          this.dropped = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user has moved a new drag item into this container.
           */
          this.entered = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits when the user removes an item from the container
           * by dragging it into another container.
           */
          this.exited = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Emits as the user is swapping items while actively dragging.
           */
          this.sorted = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
          /**
           * Keeps track of the items that are registered with this container. Historically we used to
           * do this with a `ContentChildren` query, however queries don't handle transplanted views very
           * well which means that we can't handle cases like dragging the headers of a `mat-table`
           * correctly. What we do instead is to have the items register themselves with the container
           * and then we sort them based on their position in the DOM.
           */
          this._unsortedItems = new Set();
          this._dropListRef = dragDrop.createDropList(element);
          this._dropListRef.data = this;
          if (config) {
            this._assignDefaults(config);
          }
          this._dropListRef.enterPredicate =
          /**
          * @param {?} drag
          * @param {?} drop
          * @return {?}
          */
          function (drag, drop) {
            return _this26.enterPredicate(drag.data, drop.data);
          };
          this._setupInputSyncSubscription(this._dropListRef);
          this._handleEvents(this._dropListRef);
          CdkDropList._dropLists.push(this);
          if (_group) {
            _group._items.add(this);
          }
        }
        /**
         * Whether starting a dragging sequence from this container is disabled.
         * @return {?}
         */
        _createClass(CdkDropList, [{
          key: "disabled",
          get: function get() {
            return this._disabled || !!this._group && this._group.disabled;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            // Usually we sync the directive and ref state right before dragging starts, in order to have
            // a single point of failure and to avoid having to use setters for everything. `disabled` is
            // a special case, because it can prevent the `beforeStarted` event from firing, which can lock
            // the user in a disabled state, so we also need to sync it as it's being set.
            this._dropListRef.disabled = this._disabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(value);
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngAfterContentInit",
          value: function ngAfterContentInit() {
            // @breaking-change 11.0.0 Remove null check for _scrollDispatcher once it's required.
            if (this._scrollDispatcher) {
              /** @type {?} */
              var scrollableParents = this._scrollDispatcher.getAncestorScrollContainers(this.element).map(
              /**
              * @param {?} scrollable
              * @return {?}
              */
              function (scrollable) {
                return scrollable.getElementRef().nativeElement;
              });
              this._dropListRef.withScrollableParents(scrollableParents);
            }
          }
          /**
           * Registers an items with the drop list.
           * @param {?} item
           * @return {?}
           */
        }, {
          key: "addItem",
          value: function addItem(item) {
            this._unsortedItems.add(item);
            if (this._dropListRef.isDragging()) {
              this._syncItemsWithRef();
            }
          }
          /**
           * Removes an item from the drop list.
           * @param {?} item
           * @return {?}
           */
        }, {
          key: "removeItem",
          value: function removeItem(item) {
            this._unsortedItems["delete"](item);
            if (this._dropListRef.isDragging()) {
              this._syncItemsWithRef();
            }
          }
          /**
           * Gets the registered items in the list, sorted by their position in the DOM.
           * @return {?}
           */
        }, {
          key: "getSortedItems",
          value: function getSortedItems() {
            return Array.from(this._unsortedItems).sort(
            /**
            * @param {?} a
            * @param {?} b
            * @return {?}
            */
            function (a, b) {
              /** @type {?} */
              var documentPosition = a._dragRef.getVisibleElement().compareDocumentPosition(b._dragRef.getVisibleElement());
              // `compareDocumentPosition` returns a bitmask so we have to use a bitwise operator.
              // https://developer.mozilla.org/en-US/docs/Web/API/Node/compareDocumentPosition
              // tslint:disable-next-line:no-bitwise
              return documentPosition & Node.DOCUMENT_POSITION_FOLLOWING ? -1 : 1;
            });
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            /** @type {?} */
            var index = CdkDropList._dropLists.indexOf(this);
            if (index > -1) {
              CdkDropList._dropLists.splice(index, 1);
            }
            if (this._group) {
              this._group._items["delete"](this);
            }
            this._unsortedItems.clear();
            this._dropListRef.dispose();
            this._destroyed.next();
            this._destroyed.complete();
          }
          /**
           * Starts dragging an item.
           * @deprecated No longer being used. To be removed.
           * \@breaking-change 10.0.0
           * @return {?}
           */
        }, {
          key: "start",
          value: function start() {
            this._dropListRef.start();
          }
          /**
           * Drops an item into this container.
           * @deprecated No longer being used. To be removed.
           * \@breaking-change 10.0.0
           * @param {?} item Item being dropped into the container.
           * @param {?} currentIndex Index at which the item should be inserted.
           * @param {?} previousContainer Container from which the item got dragged in.
           * @param {?} isPointerOverContainer Whether the user's pointer was over the
           *    container when the item was dropped.
           *
           * @return {?}
           */
        }, {
          key: "drop",
          value: function drop(item, currentIndex, previousContainer, isPointerOverContainer) {
            this._dropListRef.drop(item._dragRef, currentIndex, previousContainer._dropListRef, isPointerOverContainer, {
              x: 0,
              y: 0
            });
          }
          /**
           * Emits an event to indicate that the user moved an item into the container.
           * @deprecated No longer being used. To be removed.
           * \@breaking-change 10.0.0
           * @param {?} item Item that was moved into the container.
           * @param {?} pointerX Position of the item along the X axis.
           * @param {?} pointerY Position of the item along the Y axis.
           * @return {?}
           */
        }, {
          key: "enter",
          value: function enter(item, pointerX, pointerY) {
            this._dropListRef.enter(item._dragRef, pointerX, pointerY);
          }
          /**
           * Removes an item from the container after it was dragged into another container by the user.
           * @deprecated No longer being used. To be removed.
           * \@breaking-change 10.0.0
           * @param {?} item Item that was dragged out.
           * @return {?}
           */
        }, {
          key: "exit",
          value: function exit(item) {
            this._dropListRef.exit(item._dragRef);
          }
          /**
           * Figures out the index of an item in the container.
           * @deprecated No longer being used. To be removed.
           * \@breaking-change 10.0.0
           * @param {?} item Item whose index should be determined.
           * @return {?}
           */
        }, {
          key: "getItemIndex",
          value: function getItemIndex(item) {
            return this._dropListRef.getItemIndex(item._dragRef);
          }
          /**
           * Syncs the inputs of the CdkDropList with the options of the underlying DropListRef.
           * @private
           * @param {?} ref
           * @return {?}
           */
        }, {
          key: "_setupInputSyncSubscription",
          value: function _setupInputSyncSubscription(ref) {
            var _this27 = this;
            if (this._dir) {
              this._dir.change.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["startWith"])(this._dir.value), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["takeUntil"])(this._destroyed)).subscribe(
              /**
              * @param {?} value
              * @return {?}
              */
              function (value) {
                return ref.withDirection(value);
              });
            }
            ref.beforeStarted.subscribe(
            /**
            * @return {?}
            */
            function () {
              /** @type {?} */
              var siblings = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceArray"])(_this27.connectedTo).map(
              /**
              * @param {?} drop
              * @return {?}
              */
              function (drop) {
                return typeof drop === 'string' ? /** @type {?} */CdkDropList._dropLists.find(
                /**
                * @param {?} list
                * @return {?}
                */
                function (list) {
                  return list.id === drop;
                }) : drop;
              });
              if (_this27._group) {
                _this27._group._items.forEach(
                /**
                * @param {?} drop
                * @return {?}
                */
                function (drop) {
                  if (siblings.indexOf(drop) === -1) {
                    siblings.push(drop);
                  }
                });
              }
              ref.disabled = _this27.disabled;
              ref.lockAxis = _this27.lockAxis;
              ref.sortingDisabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(_this27.sortingDisabled);
              ref.autoScrollDisabled = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceBooleanProperty"])(_this27.autoScrollDisabled);
              ref.connectedTo(siblings.filter(
              /**
              * @param {?} drop
              * @return {?}
              */
              function (drop) {
                return drop && drop !== _this27;
              }).map(
              /**
              * @param {?} list
              * @return {?}
              */
              function (list) {
                return list._dropListRef;
              })).withOrientation(_this27.orientation);
            });
          }
          /**
           * Handles events from the underlying DropListRef.
           * @private
           * @param {?} ref
           * @return {?}
           */
        }, {
          key: "_handleEvents",
          value: function _handleEvents(ref) {
            var _this28 = this;
            ref.beforeStarted.subscribe(
            /**
            * @return {?}
            */
            function () {
              _this28._syncItemsWithRef();
              _this28._changeDetectorRef.markForCheck();
            });
            ref.entered.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this28.entered.emit({
                container: _this28,
                item: event.item.data,
                currentIndex: event.currentIndex
              });
            });
            ref.exited.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this28.exited.emit({
                container: _this28,
                item: event.item.data
              });
              _this28._changeDetectorRef.markForCheck();
            });
            ref.sorted.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this28.sorted.emit({
                previousIndex: event.previousIndex,
                currentIndex: event.currentIndex,
                container: _this28,
                item: event.item.data
              });
            });
            ref.dropped.subscribe(
            /**
            * @param {?} event
            * @return {?}
            */
            function (event) {
              _this28.dropped.emit({
                previousIndex: event.previousIndex,
                currentIndex: event.currentIndex,
                previousContainer: event.previousContainer.data,
                container: event.container.data,
                item: event.item.data,
                isPointerOverContainer: event.isPointerOverContainer,
                distance: event.distance
              });
              // Mark for check since all of these events run outside of change
              // detection and we're not guaranteed for something else to have triggered it.
              _this28._changeDetectorRef.markForCheck();
            });
          }
          /**
           * Assigns the default input values based on a provided config object.
           * @private
           * @param {?} config
           * @return {?}
           */
        }, {
          key: "_assignDefaults",
          value: function _assignDefaults(config) {
            var lockAxis = config.lockAxis,
              draggingDisabled = config.draggingDisabled,
              sortingDisabled = config.sortingDisabled,
              listAutoScrollDisabled = config.listAutoScrollDisabled,
              listOrientation = config.listOrientation;
            this.disabled = draggingDisabled == null ? false : draggingDisabled;
            this.sortingDisabled = sortingDisabled == null ? false : sortingDisabled;
            this.autoScrollDisabled = listAutoScrollDisabled == null ? false : listAutoScrollDisabled;
            this.orientation = listOrientation || 'vertical';
            if (lockAxis) {
              this.lockAxis = lockAxis;
            }
          }
          /**
           * Syncs up the registered drag items with underlying drop list ref.
           * @private
           * @return {?}
           */
        }, {
          key: "_syncItemsWithRef",
          value: function _syncItemsWithRef() {
            this._dropListRef.withItems(this.getSortedItems().map(
            /**
            * @param {?} item
            * @return {?}
            */
            function (item) {
              return item._dragRef;
            }));
          }
        }]);
        return CdkDropList;
      }();
      CdkDropList.ɵfac = function CdkDropList_Factory(t) {
        return new (t || CdkDropList)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](DragDrop), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ChangeDetectorRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__["Directionality"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](CdkDropListGroup, 12), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ScrollDispatcher"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](CDK_DRAG_CONFIG, 8));
      };
      CdkDropList.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: CdkDropList,
        selectors: [["", "cdkDropList", ""], ["cdk-drop-list"]],
        hostAttrs: [1, "cdk-drop-list"],
        hostVars: 7,
        hostBindings: function CdkDropList_HostBindings(rf, ctx) {
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵhostProperty"]("id", ctx.id);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("cdk-drop-list-disabled", ctx.disabled)("cdk-drop-list-dragging", ctx._dropListRef.isDragging())("cdk-drop-list-receiving", ctx._dropListRef.isReceiving());
          }
        },
        inputs: {
          connectedTo: ["cdkDropListConnectedTo", "connectedTo"],
          id: "id",
          enterPredicate: ["cdkDropListEnterPredicate", "enterPredicate"],
          disabled: ["cdkDropListDisabled", "disabled"],
          sortingDisabled: ["cdkDropListSortingDisabled", "sortingDisabled"],
          autoScrollDisabled: ["cdkDropListAutoScrollDisabled", "autoScrollDisabled"],
          orientation: ["cdkDropListOrientation", "orientation"],
          lockAxis: ["cdkDropListLockAxis", "lockAxis"],
          data: ["cdkDropListData", "data"]
        },
        outputs: {
          dropped: "cdkDropListDropped",
          entered: "cdkDropListEntered",
          exited: "cdkDropListExited",
          sorted: "cdkDropListSorted"
        },
        exportAs: ["cdkDropList"],
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([
        // Prevent child drop lists from picking up the same group as their parent.
        {
          provide: CdkDropListGroup,
          useValue: ɵ0
        }, {
          provide: CDK_DROP_LIST,
          useExisting: CdkDropList
        }])]
      });
      /**
       * Keeps track of the drop lists that are currently on the page.
       */
      CdkDropList._dropLists = [];
      /** @nocollapse */
      CdkDropList.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
        }, {
          type: DragDrop
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ChangeDetectorRef"]
        }, {
          type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__["Directionality"],
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }]
        }, {
          type: CdkDropListGroup,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
          }]
        }, {
          type: _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ScrollDispatcher"]
        }, {
          type: undefined,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [CDK_DRAG_CONFIG]
          }]
        }];
      };
      CdkDropList.propDecorators = {
        connectedTo: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListConnectedTo']
        }],
        data: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListData']
        }],
        orientation: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListOrientation']
        }],
        id: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
        }],
        lockAxis: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListLockAxis']
        }],
        disabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListDisabled']
        }],
        sortingDisabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListSortingDisabled']
        }],
        enterPredicate: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListEnterPredicate']
        }],
        autoScrollDisabled: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['cdkDropListAutoScrollDisabled']
        }],
        dropped: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDropListDropped']
        }],
        entered: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDropListEntered']
        }],
        exited: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDropListExited']
        }],
        sorted: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
          args: ['cdkDropListSorted']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CdkDropList, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: '[cdkDropList], cdk-drop-list',
            exportAs: 'cdkDropList',
            providers: [
            // Prevent child drop lists from picking up the same group as their parent.
            {
              provide: CdkDropListGroup,
              useValue: ɵ0
            }, {
              provide: CDK_DROP_LIST,
              useExisting: CdkDropList
            }],
            host: {
              'class': 'cdk-drop-list',
              '[id]': 'id',
              '[class.cdk-drop-list-disabled]': 'disabled',
              '[class.cdk-drop-list-dragging]': '_dropListRef.isDragging()',
              '[class.cdk-drop-list-receiving]': '_dropListRef.isReceiving()'
            }
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
          }, {
            type: DragDrop
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ChangeDetectorRef"]
          }, {
            type: _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_7__["Directionality"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }, {
            type: CdkDropListGroup,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
            }]
          }, {
            type: _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_2__["ScrollDispatcher"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [CDK_DRAG_CONFIG]
            }]
          }];
        }, {
          connectedTo: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListConnectedTo']
          }],
          id: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
          }],
          enterPredicate: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListEnterPredicate']
          }],
          dropped: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDropListDropped']
          }],
          entered: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDropListEntered']
          }],
          exited: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDropListExited']
          }],
          sorted: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"],
            args: ['cdkDropListSorted']
          }],
          disabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListDisabled']
          }],
          sortingDisabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListSortingDisabled']
          }],
          autoScrollDisabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListAutoScrollDisabled']
          }],
          orientation: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListOrientation']
          }],
          lockAxis: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListLockAxis']
          }],
          data: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['cdkDropListData']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/drag-drop-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var DragDropModule = /*#__PURE__*/_createClass(function DragDropModule() {
        _classCallCheck(this, DragDropModule);
      });
      DragDropModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: DragDropModule
      });
      DragDropModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function DragDropModule_Factory(t) {
          return new (t || DragDropModule)();
        },
        providers: [DragDrop]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](DragDropModule, {
          declarations: [CdkDropList, CdkDropListGroup, CdkDrag, CdkDragHandle, CdkDragPreview, CdkDragPlaceholder],
          exports: [CdkDropList, CdkDropListGroup, CdkDrag, CdkDragHandle, CdkDragPreview, CdkDragPlaceholder]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DragDropModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [CdkDropList, CdkDropListGroup, CdkDrag, CdkDragHandle, CdkDragPreview, CdkDragPlaceholder],
            exports: [CdkDropList, CdkDropListGroup, CdkDrag, CdkDragHandle, CdkDragPreview, CdkDragPlaceholder],
            providers: [DragDrop]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/drag-drop/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=drag-drop.js.map

      /***/
    },

    /***/"./src/app/data-table/table/components/table-basic-example.ts":
    /*!********************************************************************!*\
      !*** ./src/app/data-table/table/components/table-basic-example.ts ***!
      \********************************************************************/
    /*! exports provided: TableBasicExample */
    /***/
    function srcAppDataTableTableComponentsTableBasicExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableBasicExample", function () {
        return TableBasicExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TableBasicExample_th_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicExample_td_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r44 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r44.position, " ");
        }
      }
      function TableBasicExample_th_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicExample_td_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r45 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r45.name, " ");
        }
      }
      function TableBasicExample_th_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicExample_td_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r46 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r46.weight, " ");
        }
      }
      function TableBasicExample_th_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicExample_td_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r47 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r47.symbol, " ");
        }
      }
      function TableBasicExample_tr_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 13);
        }
      }
      function TableBasicExample_tr_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 14);
        }
      }
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }];
      /**
       * @title Basic use of `<table mat-table>`
       */
      var TableBasicExample = /*#__PURE__*/_createClass(function TableBasicExample() {
        _classCallCheck(this, TableBasicExample);
        this.displayedColumns = ['position', 'name', 'weight', 'symbol'];
        this.dataSource = ELEMENT_DATA;
      });
      TableBasicExample.ɵfac = function TableBasicExample_Factory(t) {
        return new (t || TableBasicExample)();
      };
      TableBasicExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableBasicExample,
        selectors: [["table-basic-example"]],
        decls: 18,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#getting-started"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "position"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableBasicExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic use of '<table mat-table>' ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](4, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableBasicExample_th_5_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableBasicExample_td_6_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](7, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableBasicExample_th_8_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableBasicExample_td_9_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](10, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableBasicExample_th_11_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableBasicExample_td_12_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](13, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableBasicExample_th_14_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableBasicExample_td_15_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableBasicExample_tr_16_Template, 1, 0, "tr", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableBasicExample_tr_17_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableBasicExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-basic-example',
            templateUrl: 'table-basic-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-basic-flex-example.ts":
    /*!*************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-basic-flex-example.ts ***!
      \*************************************************************************/
    /*! exports provided: TableBasicFlexExample */
    /***/
    function srcAppDataTableTableComponentsTableBasicFlexExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableBasicFlexExample", function () {
        return TableBasicFlexExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TableBasicFlexExample_mat_header_cell_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-header-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicFlexExample_mat_cell_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r59 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r59.position, " ");
        }
      }
      function TableBasicFlexExample_mat_header_cell_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-header-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicFlexExample_mat_cell_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r60 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r60.name, " ");
        }
      }
      function TableBasicFlexExample_mat_header_cell_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-header-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicFlexExample_mat_cell_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r61 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r61.weight, " ");
        }
      }
      function TableBasicFlexExample_mat_header_cell_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-header-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableBasicFlexExample_mat_cell_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-cell");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r62 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r62.symbol, " ");
        }
      }
      function TableBasicFlexExample_mat_header_row_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "mat-header-row");
        }
      }
      function TableBasicFlexExample_mat_row_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "mat-row");
        }
      }
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }];
      /**
       * @title Basic use of `<mat-table>` (uses display flex)
       */
      var TableBasicFlexExample = /*#__PURE__*/_createClass(function TableBasicFlexExample() {
        _classCallCheck(this, TableBasicFlexExample);
        this.displayedColumns = ['position', 'name', 'weight', 'symbol'];
        this.dataSource = ELEMENT_DATA;
      });
      TableBasicFlexExample.ɵfac = function TableBasicFlexExample_Factory(t) {
        return new (t || TableBasicFlexExample)();
      };
      TableBasicFlexExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableBasicFlexExample,
        selectors: [["table-basic-flex-example"]],
        decls: 18,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#tables-with-code-display-flex-code-"], [1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "position"], [4, "matHeaderCellDef"], [4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], [4, "matHeaderRowDef"], [4, "matRowDef", "matRowDefColumns"]],
        template: function TableBasicFlexExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic use of '<mat-table>' (uses display flex) ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](4, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableBasicFlexExample_mat_header_cell_5_Template, 2, 0, "mat-header-cell", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableBasicFlexExample_mat_cell_6_Template, 2, 1, "mat-cell", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](7, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableBasicFlexExample_mat_header_cell_8_Template, 2, 0, "mat-header-cell", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableBasicFlexExample_mat_cell_9_Template, 2, 1, "mat-cell", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](10, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableBasicFlexExample_mat_header_cell_11_Template, 2, 0, "mat-header-cell", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableBasicFlexExample_mat_cell_12_Template, 2, 1, "mat-cell", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](13, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableBasicFlexExample_mat_header_cell_14_Template, 2, 0, "mat-header-cell", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableBasicFlexExample_mat_cell_15_Template, 2, 1, "mat-cell", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableBasicFlexExample_mat_header_row_16_Template, 1, 0, "mat-header-row", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableBasicFlexExample_mat_row_17_Template, 1, 0, "mat-row", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableBasicFlexExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-basic-flex-example',
            templateUrl: 'table-basic-flex-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-dynamic-columns-example.ts":
    /*!******************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-dynamic-columns-example.ts ***!
      \******************************************************************************/
    /*! exports provided: TableDynamicColumnsExample */
    /***/
    function srcAppDataTableTableComponentsTableDynamicColumnsExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableDynamicColumnsExample", function () {
        return TableDynamicColumnsExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function TableDynamicColumnsExample_ng_container_9_th_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 9);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var column_r67 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", column_r67, " ");
        }
      }
      function TableDynamicColumnsExample_ng_container_9_td_2_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r71 = ctx.$implicit;
          var column_r67 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r71[column_r67], " ");
        }
      }
      function TableDynamicColumnsExample_ng_container_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](0, 6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, TableDynamicColumnsExample_ng_container_9_th_1_Template, 2, 1, "th", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, TableDynamicColumnsExample_ng_container_9_td_2_Template, 2, 1, "td", 8);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        }
        if (rf & 2) {
          var column_r67 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matColumnDef", column_r67);
        }
      }
      function TableDynamicColumnsExample_tr_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 11);
        }
      }
      function TableDynamicColumnsExample_tr_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 12);
        }
      }
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }];
      /**
       * @title Table dynamically changing the columns displayed
       */
      var TableDynamicColumnsExample = /*#__PURE__*/function () {
        function TableDynamicColumnsExample() {
          _classCallCheck(this, TableDynamicColumnsExample);
          this.displayedColumns = ['name', 'weight', 'symbol', 'position'];
          this.columnsToDisplay = this.displayedColumns.slice();
          this.data = ELEMENT_DATA;
        }
        _createClass(TableDynamicColumnsExample, [{
          key: "addColumn",
          value: function addColumn() {
            var randomColumn = Math.floor(Math.random() * this.displayedColumns.length);
            this.columnsToDisplay.push(this.displayedColumns[randomColumn]);
          }
        }, {
          key: "removeColumn",
          value: function removeColumn() {
            if (this.columnsToDisplay.length) {
              this.columnsToDisplay.pop();
            }
          }
        }, {
          key: "shuffle",
          value: function shuffle() {
            var currentIndex = this.columnsToDisplay.length;
            while (0 !== currentIndex) {
              var randomIndex = Math.floor(Math.random() * currentIndex);
              currentIndex -= 1;
              // Swap
              var temp = this.columnsToDisplay[currentIndex];
              this.columnsToDisplay[currentIndex] = this.columnsToDisplay[randomIndex];
              this.columnsToDisplay[randomIndex] = temp;
            }
          }
        }]);
        return TableDynamicColumnsExample;
      }();
      TableDynamicColumnsExample.ɵfac = function TableDynamicColumnsExample_Factory(t) {
        return new (t || TableDynamicColumnsExample)();
      };
      TableDynamicColumnsExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableDynamicColumnsExample,
        selectors: [["table-dynamic-columns-example"]],
        decls: 12,
        vars: 4,
        consts: [[1, "example-h2"], ["mat-raised-button", "", 3, "click"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], [3, "matColumnDef", 4, "ngFor", "ngForOf"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], [3, "matColumnDef"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableDynamicColumnsExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table with dynamically changing the columns");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "button", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TableDynamicColumnsExample_Template_button_click_2_listener() {
              return ctx.addColumn();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, " Add column ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "button", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TableDynamicColumnsExample_Template_button_click_4_listener() {
              return ctx.removeColumn();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, " Remove column ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TableDynamicColumnsExample_Template_button_click_6_listener() {
              return ctx.shuffle();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, " Shuffle ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableDynamicColumnsExample_ng_container_9_Template, 3, 1, "ng-container", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableDynamicColumnsExample_tr_10_Template, 1, 0, "tr", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableDynamicColumnsExample_tr_11_Template, 1, 0, "tr", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.data);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.columnsToDisplay);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.columnsToDisplay);
          }
        },
        directives: [_angular_material_button__WEBPACK_IMPORTED_MODULE_1__["MatButton"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTable"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRow"]],
        styles: ["button[_ngcontent-%COMP%] {\r\n  margin: 16px 8px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLWR5bmFtaWMtY29sdW1ucy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGdCQUFnQjtBQUNsQiIsImZpbGUiOiJzcmMvYXBwL2RhdGEtdGFibGUvdGFibGUvY29tcG9uZW50cy90YWJsZS1keW5hbWljLWNvbHVtbnMtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJidXR0b24ge1xyXG4gIG1hcmdpbjogMTZweCA4cHg7XHJcbn1cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableDynamicColumnsExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-dynamic-columns-example',
            styleUrls: ['table-dynamic-columns-example.css'],
            templateUrl: 'table-dynamic-columns-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-expandable-rows-example.ts":
    /*!******************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-expandable-rows-example.ts ***!
      \******************************************************************************/
    /*! exports provided: TableExpandableRowsExample */
    /***/
    function srcAppDataTableTableComponentsTableExpandableRowsExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableExpandableRowsExample", function () {
        return TableExpandableRowsExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_animations__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/animations */"./node_modules/@angular/animations/__ivy_ngcc__/fesm2015/animations.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function TableExpandableRowsExample_ng_container_3_th_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var column_r79 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", column_r79, " ");
        }
      }
      function TableExpandableRowsExample_ng_container_3_td_2_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r83 = ctx.$implicit;
          var column_r79 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r83[column_r79], " ");
        }
      }
      function TableExpandableRowsExample_ng_container_3_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](0, 8);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, TableExpandableRowsExample_ng_container_3_th_1_Template, 2, 1, "th", 9);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, TableExpandableRowsExample_ng_container_3_td_2_Template, 2, 1, "td", 4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        }
        if (rf & 2) {
          var column_r79 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("matColumnDef", column_r79);
        }
      }
      function TableExpandableRowsExample_td_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 17);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 18);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "span", 19);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, " -- Wikipedia ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r85 = ctx.$implicit;
          var ctx_r75 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵattribute"]("colspan", ctx_r75.columnsToDisplay.length);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("@detailExpand", element_r85 == ctx_r75.expandedElement ? "expanded" : "collapsed");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r85.position, " ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r85.symbol, " ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r85.name, " ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r85.weight, " ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r85.description, " ");
        }
      }
      function TableExpandableRowsExample_tr_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 20);
        }
      }
      function TableExpandableRowsExample_tr_7_Template(rf, ctx) {
        if (rf & 1) {
          var _r88 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr", 21);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TableExpandableRowsExample_tr_7_Template_tr_click_0_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r88);
            var element_r86 = ctx.$implicit;
            var ctx_r87 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
            return ctx_r87.expandedElement = ctx_r87.expandedElement === element_r86 ? null : element_r86;
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r86 = ctx.$implicit;
          var ctx_r77 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("example-expanded-row", ctx_r77.expandedElement === element_r86);
        }
      }
      function TableExpandableRowsExample_tr_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 22);
        }
      }
      var _c0 = function _c0() {
        return ["expandedDetail"];
      };
      /**
       * @title Table with expandable rows
       */
      var TableExpandableRowsExample = /*#__PURE__*/_createClass(function TableExpandableRowsExample() {
        _classCallCheck(this, TableExpandableRowsExample);
        this.dataSource = ELEMENT_DATA;
        this.columnsToDisplay = ['name', 'weight', 'symbol', 'position'];
      });
      TableExpandableRowsExample.ɵfac = function TableExpandableRowsExample_Factory(t) {
        return new (t || TableExpandableRowsExample)();
      };
      TableExpandableRowsExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableExpandableRowsExample,
        selectors: [["table-expandable-rows-example"]],
        decls: 9,
        vars: 6,
        consts: [[1, "example-h2"], ["mat-table", "", "multiTemplateDataRows", "", 1, "mat-elevation-z8", 3, "dataSource"], [3, "matColumnDef", 4, "ngFor", "ngForOf"], ["matColumnDef", "expandedDetail"], ["mat-cell", "", 4, "matCellDef"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", "class", "example-element-row", 3, "example-expanded-row", "click", 4, "matRowDef", "matRowDefColumns"], ["mat-row", "", "class", "example-detail-row", 4, "matRowDef", "matRowDefColumns"], [3, "matColumnDef"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-header-cell", ""], ["mat-cell", ""], [1, "example-element-detail"], [1, "example-element-diagram"], [1, "example-element-position"], [1, "example-element-symbol"], [1, "example-element-name"], [1, "example-element-weight"], [1, "example-element-description"], [1, "example-element-description-attribution"], ["mat-header-row", ""], ["mat-row", "", 1, "example-element-row", 3, "click"], ["mat-row", "", 1, "example-detail-row"]],
        template: function TableExpandableRowsExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table with expandable rows");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "table", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](3, TableExpandableRowsExample_ng_container_3_Template, 3, 1, "ng-container", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](4, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableExpandableRowsExample_td_5_Template, 15, 7, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableExpandableRowsExample_tr_6_Template, 1, 0, "tr", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableExpandableRowsExample_tr_7_Template, 1, 2, "tr", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableExpandableRowsExample_tr_8_Template, 1, 0, "tr", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.columnsToDisplay);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.columnsToDisplay);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.columnsToDisplay);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](5, _c0));
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTable"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRow"]],
        styles: ["tr.example-detail-row[_ngcontent-%COMP%] {\r\n  height: 0;\r\n}\r\n\r\ntr.example-element-row[_ngcontent-%COMP%]:not(.example-expanded-row):hover {\r\n  background: whitesmoke;\r\n}\r\n\r\ntr.example-element-row[_ngcontent-%COMP%]:not(.example-expanded-row):active {\r\n  background: #efefef;\r\n}\r\n\r\n.example-element-row[_ngcontent-%COMP%]   td[_ngcontent-%COMP%] {\r\n  border-bottom-width: 0;\r\n}\r\n\r\n.example-element-detail[_ngcontent-%COMP%] {\r\n  overflow: hidden;\r\n  display: flex;\r\n}\r\n\r\n.example-element-diagram[_ngcontent-%COMP%] {\r\n  min-width: 80px;\r\n  border: 2px solid black;\r\n  padding: 8px;\r\n  font-weight: lighter;\r\n  margin: 8px 0;\r\n  height: 120px;\r\n}\r\n\r\n.example-element-symbol[_ngcontent-%COMP%] {\r\n  font-weight: bold;\r\n  font-size: 40px;\r\n  line-height: normal;\r\n}\r\n\r\n.example-element-description[_ngcontent-%COMP%] {\r\n  padding: 16px;\r\n}\r\n\r\n.example-element-description-attribution[_ngcontent-%COMP%] {\r\n  opacity: 0.5;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLWV4cGFuZGFibGUtcm93cy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLFNBQVM7QUFDWDs7QUFFQTtFQUNFLHNCQUFzQjtBQUN4Qjs7QUFFQTtFQUNFLG1CQUFtQjtBQUNyQjs7QUFFQTtFQUNFLHNCQUFzQjtBQUN4Qjs7QUFFQTtFQUNFLGdCQUFnQjtFQUNoQixhQUFhO0FBQ2Y7O0FBRUE7RUFDRSxlQUFlO0VBQ2YsdUJBQXVCO0VBQ3ZCLFlBQVk7RUFDWixvQkFBb0I7RUFDcEIsYUFBYTtFQUNiLGFBQWE7QUFDZjs7QUFFQTtFQUNFLGlCQUFpQjtFQUNqQixlQUFlO0VBQ2YsbUJBQW1CO0FBQ3JCOztBQUVBO0VBQ0UsYUFBYTtBQUNmOztBQUVBO0VBQ0UsWUFBWTtBQUNkIiwiZmlsZSI6InNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLWV4cGFuZGFibGUtcm93cy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbInRyLmV4YW1wbGUtZGV0YWlsLXJvdyB7XHJcbiAgaGVpZ2h0OiAwO1xyXG59XHJcblxyXG50ci5leGFtcGxlLWVsZW1lbnQtcm93Om5vdCguZXhhbXBsZS1leHBhbmRlZC1yb3cpOmhvdmVyIHtcclxuICBiYWNrZ3JvdW5kOiB3aGl0ZXNtb2tlO1xyXG59XHJcblxyXG50ci5leGFtcGxlLWVsZW1lbnQtcm93Om5vdCguZXhhbXBsZS1leHBhbmRlZC1yb3cpOmFjdGl2ZSB7XHJcbiAgYmFja2dyb3VuZDogI2VmZWZlZjtcclxufVxyXG5cclxuLmV4YW1wbGUtZWxlbWVudC1yb3cgdGQge1xyXG4gIGJvcmRlci1ib3R0b20td2lkdGg6IDA7XHJcbn1cclxuXHJcbi5leGFtcGxlLWVsZW1lbnQtZGV0YWlsIHtcclxuICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbn1cclxuXHJcbi5leGFtcGxlLWVsZW1lbnQtZGlhZ3JhbSB7XHJcbiAgbWluLXdpZHRoOiA4MHB4O1xyXG4gIGJvcmRlcjogMnB4IHNvbGlkIGJsYWNrO1xyXG4gIHBhZGRpbmc6IDhweDtcclxuICBmb250LXdlaWdodDogbGlnaHRlcjtcclxuICBtYXJnaW46IDhweCAwO1xyXG4gIGhlaWdodDogMTIwcHg7XHJcbn1cclxuXHJcbi5leGFtcGxlLWVsZW1lbnQtc3ltYm9sIHtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxuICBmb250LXNpemU6IDQwcHg7XHJcbiAgbGluZS1oZWlnaHQ6IG5vcm1hbDtcclxufVxyXG5cclxuLmV4YW1wbGUtZWxlbWVudC1kZXNjcmlwdGlvbiB7XHJcbiAgcGFkZGluZzogMTZweDtcclxufVxyXG5cclxuLmV4YW1wbGUtZWxlbWVudC1kZXNjcmlwdGlvbi1hdHRyaWJ1dGlvbiB7XHJcbiAgb3BhY2l0eTogMC41O1xyXG59XHJcbiJdfQ== */"],
        data: {
          animation: [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["trigger"])('detailExpand', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["state"])('collapsed', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({
            height: '0px',
            minHeight: '0'
          })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["state"])('expanded', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({
            height: '*'
          })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["transition"])('expanded <=> collapsed', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["animate"])('225ms cubic-bezier(0.4, 0.0, 0.2, 1)'))])]
        }
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableExpandableRowsExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-expandable-rows-example',
            styleUrls: ['table-expandable-rows-example.css'],
            templateUrl: 'table-expandable-rows-example.html',
            animations: [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["trigger"])('detailExpand', [Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["state"])('collapsed', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({
              height: '0px',
              minHeight: '0'
            })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["state"])('expanded', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({
              height: '*'
            })), Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["transition"])('expanded <=> collapsed', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["animate"])('225ms cubic-bezier(0.4, 0.0, 0.2, 1)'))])]
          }]
        }], null, null);
      })();
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H',
        description: "Hydrogen is a chemical element with symbol H and atomic number 1. With a standard\n        atomic weight of 1.008, hydrogen is the lightest element on the periodic table."
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He',
        description: "Helium is a chemical element with symbol He and atomic number 2. It is a\n        colorless, odorless, tasteless, non-toxic, inert, monatomic gas, the first in the noble gas\n        group in the periodic table. Its boiling point is the lowest among all the elements."
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li',
        description: "Lithium is a chemical element with symbol Li and atomic number 3. It is a soft,\n        silvery-white alkali metal. Under standard conditions, it is the lightest metal and the\n        lightest solid element."
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be',
        description: "Beryllium is a chemical element with symbol Be and atomic number 4. It is a\n        relatively rare element in the universe, usually occurring as a product of the spallation of\n        larger atomic nuclei that have collided with cosmic rays."
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B',
        description: "Boron is a chemical element with symbol B and atomic number 5. Produced entirely\n        by cosmic ray spallation and supernovae and not by stellar nucleosynthesis, it is a\n        low-abundance element in the Solar system and in the Earth's crust."
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C',
        description: "Carbon is a chemical element with symbol C and atomic number 6. It is nonmetallic\n        and tetravalent\u2014making four electrons available to form covalent chemical bonds. It belongs\n        to group 14 of the periodic table."
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N',
        description: "Nitrogen is a chemical element with symbol N and atomic number 7. It was first\n        discovered and isolated by Scottish physician Daniel Rutherford in 1772."
      }];

      /***/
    },

    /***/"./src/app/data-table/table/components/table-filtering-example.ts":
    /*!************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-filtering-example.ts ***!
      \************************************************************************/
    /*! exports provided: TableFilteringExample */
    /***/
    function srcAppDataTableTableComponentsTableFilteringExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableFilteringExample", function () {
        return TableFilteringExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      function TableFilteringExample_th_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFilteringExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r100 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r100.position, " ");
        }
      }
      function TableFilteringExample_th_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFilteringExample_td_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r101 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r101.name, " ");
        }
      }
      function TableFilteringExample_th_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFilteringExample_td_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r102 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r102.weight, " ");
        }
      }
      function TableFilteringExample_th_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFilteringExample_td_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r103 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r103.symbol, " ");
        }
      }
      function TableFilteringExample_tr_20_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 14);
        }
      }
      function TableFilteringExample_tr_21_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }];
      /**
       * @title Table with filtering
       */
      var TableFilteringExample = /*#__PURE__*/function () {
        function TableFilteringExample() {
          _classCallCheck(this, TableFilteringExample);
          this.displayedColumns = ['position', 'name', 'weight', 'symbol'];
          this.dataSource = new _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](ELEMENT_DATA);
        }
        _createClass(TableFilteringExample, [{
          key: "applyFilter",
          value: function applyFilter(event) {
            var filterValue = event.target.value;
            this.dataSource.filter = filterValue.trim().toLowerCase();
          }
        }]);
        return TableFilteringExample;
      }();
      TableFilteringExample.ɵfac = function TableFilteringExample_Factory(t) {
        return new (t || TableFilteringExample)();
      };
      TableFilteringExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableFilteringExample,
        selectors: [["table-filtering-example"]],
        decls: 22,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#filtering"], ["matInput", "", "placeholder", "Ex. ium", 3, "keyup"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "position"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableFilteringExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Table with filtering ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Filter");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "input", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("keyup", function TableFilteringExample_Template_input_keyup_6_listener($event) {
              return ctx.applyFilter($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "table", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8, 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableFilteringExample_th_9_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableFilteringExample_td_10_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](11, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableFilteringExample_th_12_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableFilteringExample_td_13_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](14, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableFilteringExample_th_15_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableFilteringExample_td_16_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](17, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TableFilteringExample_th_18_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, TableFilteringExample_td_19_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, TableFilteringExample_tr_20_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](21, TableFilteringExample_tr_21_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_3__["MatInput"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        styles: [".mat-form-field[_ngcontent-%COMP%] {\r\n  font-size: 14px;\r\n  width: 100%;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLWZpbHRlcmluZy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGVBQWU7RUFDZixXQUFXO0FBQ2IiLCJmaWxlIjoic3JjL2FwcC9kYXRhLXRhYmxlL3RhYmxlL2NvbXBvbmVudHMvdGFibGUtZmlsdGVyaW5nLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC1mb3JtLWZpZWxkIHtcclxuICBmb250LXNpemU6IDE0cHg7XHJcbiAgd2lkdGg6IDEwMCU7XHJcbn1cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableFilteringExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-filtering-example',
            styleUrls: ['table-filtering-example.css'],
            templateUrl: 'table-filtering-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-footer-row-example.ts":
    /*!*************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-footer-row-example.ts ***!
      \*************************************************************************/
    /*! exports provided: TableFooterRowExample */
    /***/
    function srcAppDataTableTableComponentsTableFooterRowExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableFooterRowExample", function () {
        return TableFooterRowExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function TableFooterRowExample_th_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Item ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFooterRowExample_td_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var transaction_r114 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", transaction_r114.item, " ");
        }
      }
      function TableFooterRowExample_td_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Total ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFooterRowExample_th_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Cost ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableFooterRowExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "currency");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var transaction_r115 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, transaction_r115.cost), " ");
        }
      }
      function TableFooterRowExample_td_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "currency");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r110 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, ctx_r110.getTotalCost()), " ");
        }
      }
      function TableFooterRowExample_tr_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 14);
        }
      }
      function TableFooterRowExample_tr_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      function TableFooterRowExample_tr_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 16);
        }
      }
      /**
       * @title Footer row table
       */
      var TableFooterRowExample = /*#__PURE__*/function () {
        function TableFooterRowExample() {
          _classCallCheck(this, TableFooterRowExample);
          this.displayedColumns = ['item', 'cost'];
          this.transactions = [{
            item: 'Beach ball',
            cost: 4
          }, {
            item: 'Towel',
            cost: 5
          }, {
            item: 'Frisbee',
            cost: 2
          }, {
            item: 'Sunscreen',
            cost: 4
          }, {
            item: 'Cooler',
            cost: 25
          }, {
            item: 'Swim suit',
            cost: 15
          }];
        }
        /** Gets the total cost of all transactions. */
        _createClass(TableFooterRowExample, [{
          key: "getTotalCost",
          value: function getTotalCost() {
            return this.transactions.map(function (t) {
              return t.cost;
            }).reduce(function (acc, value) {
              return acc + value;
            }, 0);
          }
        }]);
        return TableFooterRowExample;
      }();
      TableFooterRowExample.ɵfac = function TableFooterRowExample_Factory(t) {
        return new (t || TableFooterRowExample)();
      };
      TableFooterRowExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableFooterRowExample,
        selectors: [["table-footer-row-example"]],
        decls: 15,
        vars: 4,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#footer-row"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "item"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["mat-footer-cell", "", 4, "matFooterCellDef"], ["matColumnDef", "cost"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-footer-row", "", 4, "matFooterRowDef"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-footer-cell", ""], ["mat-header-row", ""], ["mat-row", ""], ["mat-footer-row", ""]],
        template: function TableFooterRowExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Footer row table ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](4, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableFooterRowExample_th_5_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableFooterRowExample_td_6_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableFooterRowExample_td_7_Template, 2, 0, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableFooterRowExample_th_9_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableFooterRowExample_td_10_Template, 3, 3, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableFooterRowExample_td_11_Template, 3, 3, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableFooterRowExample_tr_12_Template, 1, 0, "tr", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableFooterRowExample_tr_13_Template, 1, 0, "tr", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableFooterRowExample_tr_14_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.transactions);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matFooterRowDef", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterRow"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CurrencyPipe"]],
        styles: ["tr.mat-footer-row[_ngcontent-%COMP%] {\r\n  font-weight: bold;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLWZvb3Rlci1yb3ctZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxpQkFBaUI7QUFDbkIiLCJmaWxlIjoic3JjL2FwcC9kYXRhLXRhYmxlL3RhYmxlL2NvbXBvbmVudHMvdGFibGUtZm9vdGVyLXJvdy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbInRyLm1hdC1mb290ZXItcm93IHtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableFooterRowExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-footer-row-example',
            styleUrls: ['table-footer-row-example.css'],
            templateUrl: 'table-footer-row-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-http-example.ts":
    /*!*******************************************************************!*\
      !*** ./src/app/data-table/table/components/table-http-example.ts ***!
      \*******************************************************************/
    /*! exports provided: TableHttpExample, ExampleHttpDatabase */
    /***/
    function srcAppDataTableTableComponentsTableHttpExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableHttpExample", function () {
        return TableHttpExample;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ExampleHttpDatabase", function () {
        return ExampleHttpDatabase;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/paginator */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/paginator.js");
      /* harmony import */
      var _angular_material_sort__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/sort */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/common/http */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! @angular/material/progress-spinner */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-spinner.js");
      function TableHttpExample_div_3_mat_spinner_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "mat-spinner");
        }
      }
      function TableHttpExample_div_3_div_2_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 18);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " GitHub's API rate limit has been reached. It will be reset in one minute. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableHttpExample_div_3_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, TableHttpExample_div_3_mat_spinner_1_Template, 1, 0, "mat-spinner", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, TableHttpExample_div_3_div_2_Template, 2, 0, "div", 17);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r117 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r117.isLoadingResults);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r117.isRateLimitReached);
        }
      }
      function TableHttpExample_th_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 19);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "#");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableHttpExample_td_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 20);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r130 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](row_r130.number);
        }
      }
      function TableHttpExample_th_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 19);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Title");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableHttpExample_td_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 20);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r131 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](row_r131.title);
        }
      }
      function TableHttpExample_th_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 19);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "State");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableHttpExample_td_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 20);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r132 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](row_r132.state);
        }
      }
      function TableHttpExample_th_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 21);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Created ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableHttpExample_td_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 20);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "date");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r133 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, row_r133.created_at));
        }
      }
      function TableHttpExample_tr_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 22);
        }
      }
      function TableHttpExample_tr_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 23);
        }
      }
      /**
       * @title Table retrieving data through HTTP
       */
      var TableHttpExample = /*#__PURE__*/function () {
        function TableHttpExample(_httpClient) {
          _classCallCheck(this, TableHttpExample);
          this._httpClient = _httpClient;
          this.displayedColumns = ['created', 'state', 'number', 'title'];
          this.data = [];
          this.resultsLength = 0;
          this.isLoadingResults = true;
          this.isRateLimitReached = false;
        }
        _createClass(TableHttpExample, [{
          key: "ngAfterViewInit",
          value: function ngAfterViewInit() {
            var _this29 = this;
            this.exampleDatabase = new ExampleHttpDatabase(this._httpClient);
            // If the user changes the sort order, reset back to the first page.
            this.sort.sortChange.subscribe(function () {
              return _this29.paginator.pageIndex = 0;
            });
            Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["merge"])(this.sort.sortChange, this.paginator.page).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["startWith"])({}), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () {
              _this29.isLoadingResults = true;
              return _this29.exampleDatabase.getRepoIssues(_this29.sort.active, _this29.sort.direction, _this29.paginator.pageIndex);
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["map"])(function (data) {
              // Flip flag to show that loading has finished.
              _this29.isLoadingResults = false;
              _this29.isRateLimitReached = false;
              _this29.resultsLength = data.total_count;
              return data.items;
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["catchError"])(function () {
              _this29.isLoadingResults = false;
              // Catch if the GitHub API has reached its rate limit. Return empty data.
              _this29.isRateLimitReached = true;
              return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])([]);
            })).subscribe(function (data) {
              return _this29.data = data;
            });
          }
        }]);
        return TableHttpExample;
      }();
      TableHttpExample.ɵfac = function TableHttpExample_Factory(t) {
        return new (t || TableHttpExample)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"]));
      };
      TableHttpExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableHttpExample,
        selectors: [["table-http-example"]],
        viewQuery: function TableHttpExample_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵviewQuery"](_angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], true);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵviewQuery"](_angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSort"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.paginator = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.sort = _t.first);
          }
        },
        decls: 21,
        vars: 6,
        consts: [[1, "example-h2"], [1, "example-container", "mat-elevation-z8"], ["class", "example-loading-shade", 4, "ngIf"], [1, "example-table-container"], ["mat-table", "", "matSort", "", "matSortActive", "created", "matSortDisableClear", "", "matSortDirection", "desc", 1, "example-table", 3, "dataSource"], ["matColumnDef", "number"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "title"], ["matColumnDef", "state"], ["matColumnDef", "created"], ["mat-header-cell", "", "mat-sort-header", "", "disableClear", "", 4, "matHeaderCellDef"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], [3, "length", "pageSize"], [1, "example-loading-shade"], [4, "ngIf"], ["class", "example-rate-limit-reached", 4, "ngIf"], [1, "example-rate-limit-reached"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-cell", "", "mat-sort-header", "", "disableClear", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableHttpExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table retrieving data through HTTP");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](3, TableHttpExample_div_3_Template, 3, 2, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "table", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](6, 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableHttpExample_th_7_Template, 2, 0, "th", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableHttpExample_td_8_Template, 2, 1, "td", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](9, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableHttpExample_th_10_Template, 2, 0, "th", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableHttpExample_td_11_Template, 2, 1, "td", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](12, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableHttpExample_th_13_Template, 2, 0, "th", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableHttpExample_td_14_Template, 2, 1, "td", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](15, 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableHttpExample_th_16_Template, 2, 0, "th", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableHttpExample_td_17_Template, 3, 3, "td", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TableHttpExample_tr_18_Template, 1, 0, "tr", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, TableHttpExample_tr_19_Template, 1, 0, "tr", 13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](20, "mat-paginator", 14);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isLoadingResults || ctx.isRateLimitReached);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.data);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("length", ctx.resultsLength)("pageSize", 30);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_6__["NgIf"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatTable"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSort"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatRowDef"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_8__["MatSpinner"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatCell"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSortHeader"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_7__["MatRow"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_6__["DatePipe"]],
        styles: [".example-container[_ngcontent-%COMP%] {\r\n  position: relative;\r\n  min-height: 200px;\r\n}\r\n.example-table-container[_ngcontent-%COMP%] {\r\n  position: relative;\r\n  max-height: 300px;\r\n  overflow: auto;\r\n}\r\n.example-loading-shade[_ngcontent-%COMP%] {\r\n  position: absolute;\r\n  top: 0;\r\n  left: 0;\r\n  bottom: 56px;\r\n  right: 0;\r\n  background: rgba(0, 0, 0, 0.15);\r\n  z-index: 1;\r\n  display: flex;\r\n  align-items: center;\r\n  justify-content: center;\r\n}\r\n.example-rate-limit-reached[_ngcontent-%COMP%] {\r\n  color: #980000;\r\n  max-width: 360px;\r\n  text-align: center;\r\n}\r\n\r\n.mat-column-number[_ngcontent-%COMP%], .mat-column-state[_ngcontent-%COMP%] {\r\n  max-width: 64px;\r\n}\r\n.mat-column-created[_ngcontent-%COMP%] {\r\n  max-width: 124px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLWh0dHAtZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsY0FBYztBQUNkO0VBQ0Usa0JBQWtCO0VBQ2xCLGlCQUFpQjtBQUNuQjtBQUVBO0VBQ0Usa0JBQWtCO0VBQ2xCLGlCQUFpQjtFQUNqQixjQUFjO0FBQ2hCO0FBRUE7RUFDRSxrQkFBa0I7RUFDbEIsTUFBTTtFQUNOLE9BQU87RUFDUCxZQUFZO0VBQ1osUUFBUTtFQUNSLCtCQUErQjtFQUMvQixVQUFVO0VBQ1YsYUFBYTtFQUNiLG1CQUFtQjtFQUNuQix1QkFBdUI7QUFDekI7QUFFQTtFQUNFLGNBQWM7RUFDZCxnQkFBZ0I7RUFDaEIsa0JBQWtCO0FBQ3BCO0FBRUEsa0JBQWtCO0FBQ2xCOztFQUVFLGVBQWU7QUFDakI7QUFFQTtFQUNFLGdCQUFnQjtBQUNsQiIsImZpbGUiOiJzcmMvYXBwL2RhdGEtdGFibGUvdGFibGUvY29tcG9uZW50cy90YWJsZS1odHRwLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyogU3RydWN0dXJlICovXHJcbi5leGFtcGxlLWNvbnRhaW5lciB7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIG1pbi1oZWlnaHQ6IDIwMHB4O1xyXG59XHJcblxyXG4uZXhhbXBsZS10YWJsZS1jb250YWluZXIge1xyXG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICBtYXgtaGVpZ2h0OiAzMDBweDtcclxuICBvdmVyZmxvdzogYXV0bztcclxufVxyXG5cclxuLmV4YW1wbGUtbG9hZGluZy1zaGFkZSB7XHJcbiAgcG9zaXRpb246IGFic29sdXRlO1xyXG4gIHRvcDogMDtcclxuICBsZWZ0OiAwO1xyXG4gIGJvdHRvbTogNTZweDtcclxuICByaWdodDogMDtcclxuICBiYWNrZ3JvdW5kOiByZ2JhKDAsIDAsIDAsIDAuMTUpO1xyXG4gIHotaW5kZXg6IDE7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBhbGlnbi1pdGVtczogY2VudGVyO1xyXG4gIGp1c3RpZnktY29udGVudDogY2VudGVyO1xyXG59XHJcblxyXG4uZXhhbXBsZS1yYXRlLWxpbWl0LXJlYWNoZWQge1xyXG4gIGNvbG9yOiAjOTgwMDAwO1xyXG4gIG1heC13aWR0aDogMzYwcHg7XHJcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG59XHJcblxyXG4vKiBDb2x1bW4gV2lkdGhzICovXHJcbi5tYXQtY29sdW1uLW51bWJlcixcclxuLm1hdC1jb2x1bW4tc3RhdGUge1xyXG4gIG1heC13aWR0aDogNjRweDtcclxufVxyXG5cclxuLm1hdC1jb2x1bW4tY3JlYXRlZCB7XHJcbiAgbWF4LXdpZHRoOiAxMjRweDtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableHttpExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-http-example',
            styleUrls: ['table-http-example.css'],
            templateUrl: 'table-http-example.html'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"]
          }];
        }, {
          paginator: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"]]
          }],
          sort: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSort"]]
          }]
        });
      })();
      /** An example database that the data source uses to retrieve data for the table. */
      var ExampleHttpDatabase = /*#__PURE__*/function () {
        function ExampleHttpDatabase(_httpClient) {
          _classCallCheck(this, ExampleHttpDatabase);
          this._httpClient = _httpClient;
        }
        _createClass(ExampleHttpDatabase, [{
          key: "getRepoIssues",
          value: function getRepoIssues(sort, order, page) {
            var href = 'https://api.github.com/search/issues';
            var requestUrl = "".concat(href, "?q=repo:angular/components&sort=").concat(sort, "&order=").concat(order, "&page=").concat(page + 1);
            return this._httpClient.get(requestUrl);
          }
        }]);
        return ExampleHttpDatabase;
      }();
      /***/
    },
    /***/"./src/app/data-table/table/components/table-multiple-header-footer-example.ts":
    /*!*************************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-multiple-header-footer-example.ts ***!
      \*************************************************************************************/
    /*! exports provided: TableMultipleHeaderFooterExample */
    /***/
    function srcAppDataTableTableComponentsTableMultipleHeaderFooterExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableMultipleHeaderFooterExample", function () {
        return TableMultipleHeaderFooterExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function TableMultipleHeaderFooterExample_th_4_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Item ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableMultipleHeaderFooterExample_td_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 17);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var transaction_r149 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", transaction_r149.item, " ");
        }
      }
      function TableMultipleHeaderFooterExample_td_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 18);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Total ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableMultipleHeaderFooterExample_th_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Cost ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableMultipleHeaderFooterExample_td_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 17);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "currency");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var transaction_r150 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, transaction_r150.cost), " ");
        }
      }
      function TableMultipleHeaderFooterExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 18);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "currency");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r140 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, ctx_r140.getTotalCost()), " ");
        }
      }
      function TableMultipleHeaderFooterExample_th_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name of the item purchased ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableMultipleHeaderFooterExample_th_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 16);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Cost of the item in USD ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableMultipleHeaderFooterExample_td_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 19);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Please note that the cost of items displayed are completely and totally made up. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableMultipleHeaderFooterExample_tr_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 20);
        }
      }
      function TableMultipleHeaderFooterExample_tr_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 21);
        }
      }
      function TableMultipleHeaderFooterExample_tr_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 22);
        }
      }
      function TableMultipleHeaderFooterExample_tr_20_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 23);
        }
      }
      function TableMultipleHeaderFooterExample_tr_21_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 24);
        }
      }
      var _c0 = function _c0() {
        return ["item-description", "cost-description"];
      };
      var _c1 = function _c1() {
        return ["disclaimer"];
      };
      /**
       * @title Table with multiple header and footer rows
       */
      var TableMultipleHeaderFooterExample = /*#__PURE__*/function () {
        function TableMultipleHeaderFooterExample() {
          _classCallCheck(this, TableMultipleHeaderFooterExample);
          this.displayedColumns = ['item', 'cost'];
          this.transactions = [{
            item: 'Beach ball',
            cost: 4
          }, {
            item: 'Towel',
            cost: 5
          }, {
            item: 'Frisbee',
            cost: 2
          }, {
            item: 'Sunscreen',
            cost: 4
          }, {
            item: 'Cooler',
            cost: 25
          }, {
            item: 'Swim suit',
            cost: 15
          }];
        }
        /** Gets the total cost of all transactions. */
        _createClass(TableMultipleHeaderFooterExample, [{
          key: "getTotalCost",
          value: function getTotalCost() {
            return this.transactions.map(function (t) {
              return t.cost;
            }).reduce(function (acc, value) {
              return acc + value;
            }, 0);
          }
        }]);
        return TableMultipleHeaderFooterExample;
      }();
      TableMultipleHeaderFooterExample.ɵfac = function TableMultipleHeaderFooterExample_Factory(t) {
        return new (t || TableMultipleHeaderFooterExample)();
      };
      TableMultipleHeaderFooterExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableMultipleHeaderFooterExample,
        selectors: [["table-multiple-header-footer-example"]],
        decls: 22,
        vars: 8,
        consts: [[1, "example-h2"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "item"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["mat-footer-cell", "", 4, "matFooterCellDef"], ["matColumnDef", "cost"], ["matColumnDef", "item-description"], ["matColumnDef", "cost-description"], ["matColumnDef", "disclaimer"], ["mat-footer-cell", "", "colspan", "2", 4, "matFooterCellDef"], ["mat-header-row", "", "class", "example-first-header-row", 4, "matHeaderRowDef"], ["mat-header-row", "", "class", "example-second-header-row", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-footer-row", "", "class", "example-first-footer-row", 4, "matFooterRowDef"], ["mat-footer-row", "", "class", "example-second-footer-row", 4, "matFooterRowDef"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-footer-cell", ""], ["mat-footer-cell", "", "colspan", "2"], ["mat-header-row", "", 1, "example-first-header-row"], ["mat-header-row", "", 1, "example-second-header-row"], ["mat-row", ""], ["mat-footer-row", "", 1, "example-first-footer-row"], ["mat-footer-row", "", 1, "example-second-footer-row"]],
        template: function TableMultipleHeaderFooterExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table with multiple header and footer rows");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "table", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](3, 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, TableMultipleHeaderFooterExample_th_4_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableMultipleHeaderFooterExample_td_5_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableMultipleHeaderFooterExample_td_6_Template, 2, 0, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](7, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableMultipleHeaderFooterExample_th_8_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableMultipleHeaderFooterExample_td_9_Template, 3, 3, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableMultipleHeaderFooterExample_td_10_Template, 3, 3, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](11, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableMultipleHeaderFooterExample_th_12_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](13, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableMultipleHeaderFooterExample_th_14_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](15, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableMultipleHeaderFooterExample_td_16_Template, 2, 0, "td", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableMultipleHeaderFooterExample_tr_17_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TableMultipleHeaderFooterExample_tr_18_Template, 1, 0, "tr", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, TableMultipleHeaderFooterExample_tr_19_Template, 1, 0, "tr", 13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, TableMultipleHeaderFooterExample_tr_20_Template, 1, 0, "tr", 14);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](21, TableMultipleHeaderFooterExample_tr_21_Template, 1, 0, "tr", 15);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.transactions);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](15);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](6, _c0));
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matFooterRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matFooterRowDef", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](7, _c1));
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterRow"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CurrencyPipe"]],
        styles: [".example-first-header-row[_ngcontent-%COMP%]   th[_ngcontent-%COMP%] {\r\n  border-bottom: none;\r\n}\r\n\r\n.example-second-header-row[_ngcontent-%COMP%] {\r\n  font-style: italic;\r\n}\r\n\r\n.example-first-footer-row[_ngcontent-%COMP%] {\r\n  font-weight: bold;\r\n}\r\n\r\n.example-second-footer-row[_ngcontent-%COMP%]   td[_ngcontent-%COMP%] {\r\n  color: #900000;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLW11bHRpcGxlLWhlYWRlci1mb290ZXItZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxtQkFBbUI7QUFDckI7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSxpQkFBaUI7QUFDbkI7O0FBRUE7RUFDRSxjQUFjO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLW11bHRpcGxlLWhlYWRlci1mb290ZXItZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuZXhhbXBsZS1maXJzdC1oZWFkZXItcm93IHRoIHtcclxuICBib3JkZXItYm90dG9tOiBub25lO1xyXG59XHJcblxyXG4uZXhhbXBsZS1zZWNvbmQtaGVhZGVyLXJvdyB7XHJcbiAgZm9udC1zdHlsZTogaXRhbGljO1xyXG59XHJcblxyXG4uZXhhbXBsZS1maXJzdC1mb290ZXItcm93IHtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxufVxyXG5cclxuLmV4YW1wbGUtc2Vjb25kLWZvb3Rlci1yb3cgdGQge1xyXG4gIGNvbG9yOiAjOTAwMDAwO1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableMultipleHeaderFooterExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-multiple-header-footer-example',
            styleUrls: ['table-multiple-header-footer-example.css'],
            templateUrl: 'table-multiple-header-footer-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-overview-example.ts":
    /*!***********************************************************************!*\
      !*** ./src/app/data-table/table/components/table-overview-example.ts ***!
      \***********************************************************************/
    /*! exports provided: TableOverviewExample */
    /***/
    function srcAppDataTableTableComponentsTableOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableOverviewExample", function () {
        return TableOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/paginator */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/paginator.js");
      /* harmony import */
      var _angular_material_sort__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/sort */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      function TableOverviewExample_th_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " ID ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableOverviewExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r162 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", row_r162.id, " ");
        }
      }
      function TableOverviewExample_th_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Progress ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableOverviewExample_td_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r163 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", row_r163.progress, "% ");
        }
      }
      function TableOverviewExample_th_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableOverviewExample_td_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r164 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", row_r164.name, " ");
        }
      }
      function TableOverviewExample_th_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Color ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableOverviewExample_td_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r165 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstyleProp"]("color", row_r165.color);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", row_r165.color, " ");
        }
      }
      function TableOverviewExample_tr_20_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 16);
        }
      }
      function TableOverviewExample_tr_21_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 17);
        }
      }
      var _c0 = function _c0() {
        return [3, 5, 10, 15];
      };
      /** Constants used to fill up our data base. */
      var COLORS = ['maroon', 'red', 'orange', 'yellow', 'olive', 'green', 'purple', 'fuchsia', 'lime', 'teal', 'aqua', 'blue', 'navy', 'black', 'gray'];
      var NAMES = ['Maia', 'Asher', 'Olivia', 'Atticus', 'Amelia', 'Jack', 'Charlotte', 'Theodore', 'Isla', 'Oliver', 'Isabella', 'Jasper', 'Cora', 'Levi', 'Violet', 'Arthur', 'Mia', 'Thomas', 'Elizabeth'];
      /**
       * @title Data table with sorting, pagination, and filtering.
       */
      var TableOverviewExample = /*#__PURE__*/function () {
        function TableOverviewExample() {
          _classCallCheck(this, TableOverviewExample);
          this.displayedColumns = ['id', 'name', 'progress', 'color'];
          // Create 100 users
          var users = Array.from({
            length: 100
          }, function (_, k) {
            return createNewUser(k + 1);
          });
          // Assign the data to the data source for the table to render
          this.dataSource = new _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatTableDataSource"](users);
        }
        _createClass(TableOverviewExample, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;
          }
        }, {
          key: "applyFilter",
          value: function applyFilter(event) {
            var filterValue = event.target.value;
            this.dataSource.filter = filterValue.trim().toLowerCase();
            if (this.dataSource.paginator) {
              this.dataSource.paginator.firstPage();
            }
          }
        }]);
        return TableOverviewExample;
      }();
      TableOverviewExample.ɵfac = function TableOverviewExample_Factory(t) {
        return new (t || TableOverviewExample)();
      };
      TableOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableOverviewExample,
        selectors: [["table-overview-example"]],
        viewQuery: function TableOverviewExample_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], true);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSort"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.paginator = _t.first);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.sort = _t.first);
          }
        },
        decls: 23,
        vars: 5,
        consts: [[1, "example-h2"], ["matInput", "", "placeholder", "Ex. Mia", 3, "keyup"], [1, "mat-elevation-z8"], ["mat-table", "", "matSort", "", 3, "dataSource"], ["matColumnDef", "id"], ["mat-header-cell", "", "mat-sort-header", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "progress"], ["matColumnDef", "name"], ["matColumnDef", "color"], ["mat-cell", "", 3, "color", 4, "matCellDef"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], [3, "pageSizeOptions"], ["mat-header-cell", "", "mat-sort-header", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table with sorting, pagination, and filtering");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-form-field");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-label");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Filter");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "input", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("keyup", function TableOverviewExample_Template_input_keyup_5_listener($event) {
              return ctx.applyFilter($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "table", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8, 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableOverviewExample_th_9_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableOverviewExample_td_10_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](11, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableOverviewExample_th_12_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableOverviewExample_td_13_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](14, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableOverviewExample_th_15_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableOverviewExample_td_16_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](17, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TableOverviewExample_th_18_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, TableOverviewExample_td_19_Template, 2, 3, "td", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, TableOverviewExample_tr_20_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](21, TableOverviewExample_tr_21_Template, 1, 0, "tr", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](22, "mat-paginator", 13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("pageSizeOptions", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](4, _c0));
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_5__["MatInput"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatTable"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSort"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatRowDef"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderCell"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSortHeader"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatRow"]],
        styles: [".mat-form-field[_ngcontent-%COMP%] {\r\n  font-size: 14px;\r\n  width: 100%;\r\n}\r\n\r\ntd[_ngcontent-%COMP%], th[_ngcontent-%COMP%] {\r\n  width: 25%;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLW92ZXJ2aWV3LWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsZUFBZTtFQUNmLFdBQVc7QUFDYjs7QUFFQTs7RUFFRSxVQUFVO0FBQ1oiLCJmaWxlIjoic3JjL2FwcC9kYXRhLXRhYmxlL3RhYmxlL2NvbXBvbmVudHMvdGFibGUtb3ZlcnZpZXctZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LWZvcm0tZmllbGQge1xyXG4gIGZvbnQtc2l6ZTogMTRweDtcclxuICB3aWR0aDogMTAwJTtcclxufVxyXG5cclxudGQsXHJcbnRoIHtcclxuICB3aWR0aDogMjUlO1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-overview-example',
            styleUrls: ['table-overview-example.css'],
            templateUrl: 'table-overview-example.html'
          }]
        }], function () {
          return [];
        }, {
          paginator: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], {
              "static": true
            }]
          }],
          sort: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_sort__WEBPACK_IMPORTED_MODULE_2__["MatSort"], {
              "static": true
            }]
          }]
        });
      })();
      /** Builds and returns a new User. */
      function createNewUser(id) {
        var name = NAMES[Math.round(Math.random() * (NAMES.length - 1))] + ' ' + NAMES[Math.round(Math.random() * (NAMES.length - 1))].charAt(0) + '.';
        return {
          id: id.toString(),
          name: name,
          progress: Math.round(Math.random() * 100).toString(),
          color: COLORS[Math.round(Math.random() * (COLORS.length - 1))]
        };
      }

      /***/
    },

    /***/"./src/app/data-table/table/components/table-pagination-example.ts":
    /*!*************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-pagination-example.ts ***!
      \*************************************************************************/
    /*! exports provided: TablePaginationExample */
    /***/
    function srcAppDataTableTableComponentsTablePaginationExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TablePaginationExample", function () {
        return TablePaginationExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/paginator */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/paginator.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TablePaginationExample_th_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TablePaginationExample_td_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r177 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r177.position, " ");
        }
      }
      function TablePaginationExample_th_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TablePaginationExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r178 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r178.name, " ");
        }
      }
      function TablePaginationExample_th_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TablePaginationExample_td_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r179 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r179.weight, " ");
        }
      }
      function TablePaginationExample_th_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TablePaginationExample_td_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r180 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r180.symbol, " ");
        }
      }
      function TablePaginationExample_tr_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      function TablePaginationExample_tr_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 16);
        }
      }
      var _c0 = function _c0() {
        return [5, 10, 20];
      };
      /**
       * @title Table with pagination
       */
      var TablePaginationExample = /*#__PURE__*/function () {
        function TablePaginationExample() {
          _classCallCheck(this, TablePaginationExample);
          this.displayedColumns = ['position', 'name', 'weight', 'symbol'];
          this.dataSource = new _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTableDataSource"](ELEMENT_DATA);
        }
        _createClass(TablePaginationExample, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            this.dataSource.paginator = this.paginator;
          }
        }]);
        return TablePaginationExample;
      }();
      TablePaginationExample.ɵfac = function TablePaginationExample_Factory(t) {
        return new (t || TablePaginationExample)();
      };
      TablePaginationExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TablePaginationExample,
        selectors: [["table-pagination-example"]],
        viewQuery: function TablePaginationExample_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.paginator = _t.first);
          }
        },
        decls: 20,
        vars: 5,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#pagination"], [1, "mat-elevation-z8"], ["mat-table", "", 3, "dataSource"], ["matColumnDef", "position"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["showFirstLastButtons", "", 3, "pageSizeOptions"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TablePaginationExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Table with pagination ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "table", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](5, 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TablePaginationExample_th_6_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TablePaginationExample_td_7_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TablePaginationExample_th_9_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TablePaginationExample_td_10_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](11, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TablePaginationExample_th_12_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TablePaginationExample_td_13_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](14, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TablePaginationExample_th_15_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TablePaginationExample_td_16_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TablePaginationExample_tr_17_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TablePaginationExample_tr_18_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](19, "mat-paginator", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("pageSizeOptions", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](4, _c0));
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRowDef"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRow"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TablePaginationExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-pagination-example',
            templateUrl: 'table-pagination-example.html'
          }]
        }], null, {
          paginator: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_paginator__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"], {
              "static": true
            }]
          }]
        });
      })();
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }, {
        position: 8,
        name: 'Oxygen',
        weight: 15.9994,
        symbol: 'O'
      }, {
        position: 9,
        name: 'Fluorine',
        weight: 18.9984,
        symbol: 'F'
      }, {
        position: 10,
        name: 'Neon',
        weight: 20.1797,
        symbol: 'Ne'
      }, {
        position: 11,
        name: 'Sodium',
        weight: 22.9897,
        symbol: 'Na'
      }, {
        position: 12,
        name: 'Magnesium',
        weight: 24.305,
        symbol: 'Mg'
      }, {
        position: 13,
        name: 'Aluminum',
        weight: 26.9815,
        symbol: 'Al'
      }, {
        position: 14,
        name: 'Silicon',
        weight: 28.0855,
        symbol: 'Si'
      }, {
        position: 15,
        name: 'Phosphorus',
        weight: 30.9738,
        symbol: 'P'
      }, {
        position: 16,
        name: 'Sulfur',
        weight: 32.065,
        symbol: 'S'
      }, {
        position: 17,
        name: 'Chlorine',
        weight: 35.453,
        symbol: 'Cl'
      }, {
        position: 18,
        name: 'Argon',
        weight: 39.948,
        symbol: 'Ar'
      }, {
        position: 19,
        name: 'Potassium',
        weight: 39.0983,
        symbol: 'K'
      }, {
        position: 20,
        name: 'Calcium',
        weight: 40.078,
        symbol: 'Ca'
      }];

      /***/
    },

    /***/"./src/app/data-table/table/components/table-reorderable-example.ts":
    /*!**************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-reorderable-example.ts ***!
      \**************************************************************************/
    /*! exports provided: TableReorderableExample */
    /***/
    function srcAppDataTableTableComponentsTableReorderableExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableReorderableExample", function () {
        return TableReorderableExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/drag-drop */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/drag-drop.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TableReorderableExample_th_4_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableReorderableExample_td_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r192 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r192.position, " ");
        }
      }
      function TableReorderableExample_th_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableReorderableExample_td_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r193 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r193.name, " ");
        }
      }
      function TableReorderableExample_th_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableReorderableExample_td_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r194 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r194.weight, " ");
        }
      }
      function TableReorderableExample_th_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableReorderableExample_td_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r195 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r195.symbol, " ");
        }
      }
      function TableReorderableExample_tr_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 12);
        }
      }
      function TableReorderableExample_tr_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 13);
        }
      }
      /**
       * @title Table with re-orderable columns
       */
      var TableReorderableExample = /*#__PURE__*/function () {
        function TableReorderableExample() {
          _classCallCheck(this, TableReorderableExample);
          this.columns = ['position', 'name', 'weight', 'symbol'];
          this.dataSource = ELEMENT_DATA;
        }
        _createClass(TableReorderableExample, [{
          key: "drop",
          value: function drop(event) {
            Object(_angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_1__["moveItemInArray"])(this.columns, event.previousIndex, event.currentIndex);
          }
        }]);
        return TableReorderableExample;
      }();
      TableReorderableExample.ɵfac = function TableReorderableExample_Factory(t) {
        return new (t || TableReorderableExample)();
      };
      TableReorderableExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableReorderableExample,
        selectors: [["table-reorderable-example"]],
        decls: 17,
        vars: 3,
        consts: [[1, "example-h2"], ["mat-table", "", "cdkDropList", "", "cdkDropListOrientation", "horizontal", 3, "dataSource", "cdkDropListDropped"], ["matColumnDef", "position"], ["mat-header-cell", "", "cdkDrag", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", "", "cdkDrag", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableReorderableExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table with re-orderable columns");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "table", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("cdkDropListDropped", function TableReorderableExample_Template_table_cdkDropListDropped_2_listener($event) {
              return ctx.drop($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](3, 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, TableReorderableExample_th_4_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableReorderableExample_td_5_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](6, 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableReorderableExample_th_7_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableReorderableExample_td_8_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](9, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableReorderableExample_th_10_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableReorderableExample_td_11_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](12, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableReorderableExample_th_13_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableReorderableExample_td_14_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableReorderableExample_tr_15_Template, 1, 0, "tr", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableReorderableExample_tr_16_Template, 1, 0, "tr", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.columns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.columns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTable"], _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_1__["CdkDropList"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCell"], _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_1__["CdkDrag"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRow"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableReorderableExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-reorderable-example',
            templateUrl: './table-reorderable-example.html'
          }]
        }], null, null);
      })();
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }];

      /***/
    },

    /***/"./src/app/data-table/table/components/table-row-context-example.ts":
    /*!**************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-row-context-example.ts ***!
      \**************************************************************************/
    /*! exports provided: TableRowContextExample */
    /***/
    function srcAppDataTableTableComponentsTableRowContextExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableRowContextExample", function () {
        return TableRowContextExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TableRowContextExample_th_4_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " $implicit ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var data_r213 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", data_r213, " ");
        }
      }
      function TableRowContextExample_th_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " index ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var index_r214 = ctx.index;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", index_r214, " ");
        }
      }
      function TableRowContextExample_th_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " count ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var count_r215 = ctx.count;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", count_r215, " ");
        }
      }
      function TableRowContextExample_th_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " first ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var first_r216 = ctx.first;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", first_r216, " ");
        }
      }
      function TableRowContextExample_th_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " last ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var last_r217 = ctx.last;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", last_r217, " ");
        }
      }
      function TableRowContextExample_th_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " even ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_20_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var even_r218 = ctx.even;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", even_r218, " ");
        }
      }
      function TableRowContextExample_th_22_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " odd ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableRowContextExample_td_23_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var odd_r219 = ctx.odd;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", odd_r219, " ");
        }
      }
      function TableRowContextExample_tr_24_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      function TableRowContextExample_tr_25_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 16);
        }
      }
      /**
       * @title Table showing each row context properties.
       */
      var TableRowContextExample = /*#__PURE__*/_createClass(function TableRowContextExample() {
        _classCallCheck(this, TableRowContextExample);
        this.displayedColumns = ['$implicit', 'index', 'count', 'first', 'last', 'even', 'odd'];
        this.data = ['one', 'two', 'three', 'four', 'five'];
      });
      TableRowContextExample.ɵfac = function TableRowContextExample_Factory(t) {
        return new (t || TableRowContextExample)();
      };
      TableRowContextExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableRowContextExample,
        selectors: [["table-row-context-example"]],
        decls: 26,
        vars: 3,
        consts: [[1, "example-h2"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "$implicit"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "index"], ["matColumnDef", "count"], ["matColumnDef", "first"], ["matColumnDef", "last"], ["matColumnDef", "even"], ["matColumnDef", "odd"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableRowContextExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Table showing each row context properties");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "table", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](3, 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, TableRowContextExample_th_4_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableRowContextExample_td_5_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](6, 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableRowContextExample_th_7_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableRowContextExample_td_8_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](9, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableRowContextExample_th_10_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableRowContextExample_td_11_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](12, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableRowContextExample_th_13_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableRowContextExample_td_14_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](15, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableRowContextExample_th_16_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableRowContextExample_td_17_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](18, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, TableRowContextExample_th_19_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, TableRowContextExample_td_20_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](21, 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](22, TableRowContextExample_th_22_Template, 2, 0, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](23, TableRowContextExample_td_23_Template, 2, 1, "td", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](24, TableRowContextExample_tr_24_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](25, TableRowContextExample_tr_25_Template, 1, 0, "tr", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.data);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](22);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableRowContextExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-row-context-example',
            templateUrl: 'table-row-context-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-selection-example.ts":
    /*!************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-selection-example.ts ***!
      \************************************************************************/
    /*! exports provided: TableSelectionExample */
    /***/
    function srcAppDataTableTableComponentsTableSelectionExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableSelectionExample", function () {
        return TableSelectionExample;
      });
      /* harmony import */
      var _angular_cdk_collections__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/cdk/collections */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/collections.js");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      function TableSelectionExample_th_5_Template(rf, ctx) {
        if (rf & 1) {
          var _r234 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "mat-checkbox", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("change", function TableSelectionExample_th_5_Template_mat_checkbox_change_1_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r234);
            var ctx_r233 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
            return $event ? ctx_r233.masterToggle() : null;
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r221 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("checked", ctx_r221.selection.hasValue() && ctx_r221.isAllSelected())("indeterminate", ctx_r221.selection.hasValue() && !ctx_r221.isAllSelected())("aria-label", ctx_r221.checkboxLabel());
        }
      }
      function TableSelectionExample_td_6_Template(rf, ctx) {
        if (rf & 1) {
          var _r237 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "mat-checkbox", 15);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function TableSelectionExample_td_6_Template_mat_checkbox_click_1_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r237);
            return $event.stopPropagation();
          })("change", function TableSelectionExample_td_6_Template_mat_checkbox_change_1_listener($event) {
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r237);
            var row_r235 = ctx.$implicit;
            var ctx_r238 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
            return $event ? ctx_r238.selection.toggle(row_r235) : null;
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var row_r235 = ctx.$implicit;
          var ctx_r222 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("checked", ctx_r222.selection.isSelected(row_r235))("aria-label", ctx_r222.checkboxLabel(row_r235));
        }
      }
      function TableSelectionExample_th_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
      }
      function TableSelectionExample_td_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r239 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"](" ", element_r239.position, " ");
        }
      }
      function TableSelectionExample_th_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
      }
      function TableSelectionExample_td_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r240 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"](" ", element_r240.name, " ");
        }
      }
      function TableSelectionExample_th_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
      }
      function TableSelectionExample_td_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r241 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"](" ", element_r241.weight, " ");
        }
      }
      function TableSelectionExample_th_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
      }
      function TableSelectionExample_td_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r242 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"](" ", element_r242.symbol, " ");
        }
      }
      function TableSelectionExample_tr_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](0, "tr", 16);
        }
      }
      function TableSelectionExample_tr_20_Template(rf, ctx) {
        if (rf & 1) {
          var _r245 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "tr", 17);
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function TableSelectionExample_tr_20_Template_tr_click_0_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r245);
            var row_r243 = ctx.$implicit;
            var ctx_r244 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
            return ctx_r244.selection.toggle(row_r243);
          });
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        }
      }
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }];
      /**
       * @title Table with selection
       */
      var TableSelectionExample = /*#__PURE__*/function () {
        function TableSelectionExample() {
          _classCallCheck(this, TableSelectionExample);
          this.displayedColumns = ['select', 'position', 'name', 'weight', 'symbol'];
          this.dataSource = new _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTableDataSource"](ELEMENT_DATA);
          this.selection = new _angular_cdk_collections__WEBPACK_IMPORTED_MODULE_0__["SelectionModel"](true, []);
        }
        /** Whether the number of selected elements matches the total number of rows. */
        _createClass(TableSelectionExample, [{
          key: "isAllSelected",
          value: function isAllSelected() {
            var numSelected = this.selection.selected.length;
            var numRows = this.dataSource.data.length;
            return numSelected === numRows;
          }
          /** Selects all rows if they are not all selected; otherwise clear selection. */
        }, {
          key: "masterToggle",
          value: function masterToggle() {
            var _this30 = this;
            this.isAllSelected() ? this.selection.clear() : this.dataSource.data.forEach(function (row) {
              return _this30.selection.select(row);
            });
          }
          /** The label for the checkbox on the passed row */
        }, {
          key: "checkboxLabel",
          value: function checkboxLabel(row) {
            if (!row) {
              return "".concat(this.isAllSelected() ? 'select' : 'deselect', " all");
            }
            return "".concat(this.selection.isSelected(row) ? 'deselect' : 'select', " row ").concat(row.position + 1);
          }
        }]);
        return TableSelectionExample;
      }();
      TableSelectionExample.ɵfac = function TableSelectionExample_Factory(t) {
        return new (t || TableSelectionExample)();
      };
      TableSelectionExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
        type: TableSelectionExample,
        selectors: [["table-selection-example"]],
        decls: 21,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#selection"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "select"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "position"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 3, "click", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", ""], [3, "checked", "indeterminate", "aria-label", "change"], ["mat-cell", ""], [3, "checked", "aria-label", "click", "change"], ["mat-header-row", ""], ["mat-row", "", 3, "click"]],
        template: function TableSelectionExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2, " Table with selection ");
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](4, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](5, TableSelectionExample_th_5_Template, 2, 3, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](6, TableSelectionExample_td_6_Template, 2, 2, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](7, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](8, TableSelectionExample_th_8_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](9, TableSelectionExample_td_9_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](10, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](11, TableSelectionExample_th_11_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](12, TableSelectionExample_td_12_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](13, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](14, TableSelectionExample_th_14_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](15, TableSelectionExample_td_15_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](16, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](17, TableSelectionExample_th_17_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](18, TableSelectionExample_td_18_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](19, TableSelectionExample_tr_19_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](20, TableSelectionExample_tr_20_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](16);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCell"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_3__["MatCheckbox"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRow"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](TableSelectionExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"],
          args: [{
            selector: 'table-selection-example',
            templateUrl: 'table-selection-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-sorting-example.ts":
    /*!**********************************************************************!*\
      !*** ./src/app/data-table/table/components/table-sorting-example.ts ***!
      \**********************************************************************/
    /*! exports provided: TableSortingExample */
    /***/
    function srcAppDataTableTableComponentsTableSortingExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableSortingExample", function () {
        return TableSortingExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_sort__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/sort */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TableSortingExample_th_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableSortingExample_td_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r256 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r256.position, " ");
        }
      }
      function TableSortingExample_th_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableSortingExample_td_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r257 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r257.name, " ");
        }
      }
      function TableSortingExample_th_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableSortingExample_td_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r258 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r258.weight, " ");
        }
      }
      function TableSortingExample_th_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 11);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableSortingExample_td_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r259 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r259.symbol, " ");
        }
      }
      function TableSortingExample_tr_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 13);
        }
      }
      function TableSortingExample_tr_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 14);
        }
      }
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }];
      /**
       * @title Table with sorting
       */
      var TableSortingExample = /*#__PURE__*/function () {
        function TableSortingExample() {
          _classCallCheck(this, TableSortingExample);
          this.displayedColumns = ['position', 'name', 'weight', 'symbol'];
          this.dataSource = new _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTableDataSource"](ELEMENT_DATA);
        }
        _createClass(TableSortingExample, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            this.dataSource.sort = this.sort;
          }
        }]);
        return TableSortingExample;
      }();
      TableSortingExample.ɵfac = function TableSortingExample_Factory(t) {
        return new (t || TableSortingExample)();
      };
      TableSortingExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableSortingExample,
        selectors: [["table-sorting-example"]],
        viewQuery: function TableSortingExample_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_angular_material_sort__WEBPACK_IMPORTED_MODULE_1__["MatSort"], true);
          }
          if (rf & 2) {
            var _t;
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.sort = _t.first);
          }
        },
        decls: 18,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#sorting"], ["mat-table", "", "matSort", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "position"], ["mat-header-cell", "", "mat-sort-header", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", "", "mat-sort-header", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableSortingExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Table with sorting ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](4, 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, TableSortingExample_th_5_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableSortingExample_td_6_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](7, 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableSortingExample_th_8_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableSortingExample_td_9_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](10, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableSortingExample_th_11_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableSortingExample_td_12_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](13, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableSortingExample_th_14_Template, 2, 0, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableSortingExample_td_15_Template, 2, 1, "td", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableSortingExample_tr_16_Template, 1, 0, "tr", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableSortingExample_tr_17_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatTable"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_1__["MatSort"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderCell"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_1__["MatSortHeader"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_2__["MatRow"]],
        styles: ["th.mat-sort-header-sorted[_ngcontent-%COMP%] {\r\n  color: black;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLXNvcnRpbmctZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxZQUFZO0FBQ2QiLCJmaWxlIjoic3JjL2FwcC9kYXRhLXRhYmxlL3RhYmxlL2NvbXBvbmVudHMvdGFibGUtc29ydGluZy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbInRoLm1hdC1zb3J0LWhlYWRlci1zb3J0ZWQge1xyXG4gIGNvbG9yOiBibGFjaztcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableSortingExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-sorting-example',
            styleUrls: ['table-sorting-example.css'],
            templateUrl: 'table-sorting-example.html'
          }]
        }], null, {
          sort: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_sort__WEBPACK_IMPORTED_MODULE_1__["MatSort"], {
              "static": true
            }]
          }]
        });
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-sticky-columns-example.ts":
    /*!*****************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-sticky-columns-example.ts ***!
      \*****************************************************************************/
    /*! exports provided: TableStickyColumnsExample */
    /***/
    function srcAppDataTableTableComponentsTableStickyColumnsExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableStickyColumnsExample", function () {
        return TableStickyColumnsExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      function TableStickyColumnsExample_th_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyColumnsExample_td_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r273 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r273.name, " ");
        }
      }
      function TableStickyColumnsExample_th_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyColumnsExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r274 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r274.position, " ");
        }
      }
      function TableStickyColumnsExample_th_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyColumnsExample_td_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r275 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r275.weight, " ");
        }
      }
      function TableStickyColumnsExample_th_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyColumnsExample_td_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r276 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r276.symbol, " ");
        }
      }
      function TableStickyColumnsExample_th_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "th", 13);
        }
      }
      function TableStickyColumnsExample_td_19_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "mat-icon");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "more_vert");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyColumnsExample_tr_20_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      function TableStickyColumnsExample_tr_21_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 16);
        }
      }
      /**
       * @title Table with sticky columns
       */
      var TableStickyColumnsExample = /*#__PURE__*/_createClass(function TableStickyColumnsExample() {
        _classCallCheck(this, TableStickyColumnsExample);
        this.displayedColumns = ['name', 'position', 'weight', 'symbol', 'position', 'weight', 'symbol', 'star'];
        this.dataSource = ELEMENT_DATA;
      });
      TableStickyColumnsExample.ɵfac = function TableStickyColumnsExample_Factory(t) {
        return new (t || TableStickyColumnsExample)();
      };
      TableStickyColumnsExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableStickyColumnsExample,
        selectors: [["table-sticky-columns-example"]],
        decls: 22,
        vars: 3,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#sticky-rows-and-columns"], [1, "example-container", "mat-elevation-z8"], ["mat-table", "", 3, "dataSource"], ["matColumnDef", "name", "sticky", ""], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "position"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["matColumnDef", "star", "stickyEnd", ""], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableStickyColumnsExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Table with sticky columns ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "table", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](5, 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableStickyColumnsExample_th_6_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableStickyColumnsExample_td_7_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableStickyColumnsExample_th_9_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableStickyColumnsExample_td_10_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](11, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableStickyColumnsExample_th_12_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableStickyColumnsExample_td_13_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](14, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableStickyColumnsExample_th_15_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableStickyColumnsExample_td_16_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](17, 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TableStickyColumnsExample_th_18_Template, 1, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, TableStickyColumnsExample_td_19_Template, 3, 0, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, TableStickyColumnsExample_tr_20_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](21, TableStickyColumnsExample_tr_21_Template, 1, 0, "tr", 12);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](16);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_2__["MatIcon"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        styles: [".example-container[_ngcontent-%COMP%] {\r\n  height: 300px;\r\n  width: 550px;\r\n  overflow: auto;\r\n}\r\n\r\ntable[_ngcontent-%COMP%] {\r\n  width: 800px;\r\n}\r\n\r\ntd.mat-column-star[_ngcontent-%COMP%] {\r\n  width: 20px;\r\n  padding-right: 8px;\r\n}\r\n\r\nth.mat-column-position[_ngcontent-%COMP%], td.mat-column-position[_ngcontent-%COMP%] {\r\n  padding-left: 8px;\r\n}\r\n\r\n.mat-table-sticky[_ngcontent-%COMP%]:first-child {\r\n  border-right: 1px solid #e0e0e0;\r\n}\r\n\r\n.mat-table-sticky[_ngcontent-%COMP%]:last-child {\r\n  border-left: 1px solid #e0e0e0;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLXN0aWNreS1jb2x1bW5zLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsYUFBYTtFQUNiLFlBQVk7RUFDWixjQUFjO0FBQ2hCOztBQUVBO0VBQ0UsWUFBWTtBQUNkOztBQUVBO0VBQ0UsV0FBVztFQUNYLGtCQUFrQjtBQUNwQjs7QUFFQTs7RUFFRSxpQkFBaUI7QUFDbkI7O0FBRUE7RUFDRSwrQkFBK0I7QUFDakM7O0FBRUE7RUFDRSw4QkFBOEI7QUFDaEMiLCJmaWxlIjoic3JjL2FwcC9kYXRhLXRhYmxlL3RhYmxlL2NvbXBvbmVudHMvdGFibGUtc3RpY2t5LWNvbHVtbnMtZXhhbXBsZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuZXhhbXBsZS1jb250YWluZXIge1xyXG4gIGhlaWdodDogMzAwcHg7XHJcbiAgd2lkdGg6IDU1MHB4O1xyXG4gIG92ZXJmbG93OiBhdXRvO1xyXG59XHJcblxyXG50YWJsZSB7XHJcbiAgd2lkdGg6IDgwMHB4O1xyXG59XHJcblxyXG50ZC5tYXQtY29sdW1uLXN0YXIge1xyXG4gIHdpZHRoOiAyMHB4O1xyXG4gIHBhZGRpbmctcmlnaHQ6IDhweDtcclxufVxyXG5cclxudGgubWF0LWNvbHVtbi1wb3NpdGlvbixcclxudGQubWF0LWNvbHVtbi1wb3NpdGlvbiB7XHJcbiAgcGFkZGluZy1sZWZ0OiA4cHg7XHJcbn1cclxuXHJcbi5tYXQtdGFibGUtc3RpY2t5OmZpcnN0LWNoaWxkIHtcclxuICBib3JkZXItcmlnaHQ6IDFweCBzb2xpZCAjZTBlMGUwO1xyXG59XHJcblxyXG4ubWF0LXRhYmxlLXN0aWNreTpsYXN0LWNoaWxkIHtcclxuICBib3JkZXItbGVmdDogMXB4IHNvbGlkICNlMGUwZTA7XHJcbn1cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableStickyColumnsExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-sticky-columns-example',
            styleUrls: ['table-sticky-columns-example.css'],
            templateUrl: 'table-sticky-columns-example.html'
          }]
        }], null, null);
      })();
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }, {
        position: 8,
        name: 'Oxygen',
        weight: 15.9994,
        symbol: 'O'
      }, {
        position: 9,
        name: 'Fluorine',
        weight: 18.9984,
        symbol: 'F'
      }, {
        position: 10,
        name: 'Neon',
        weight: 20.1797,
        symbol: 'Ne'
      }];

      /***/
    },

    /***/"./src/app/data-table/table/components/table-sticky-footer-example.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-sticky-footer-example.ts ***!
      \****************************************************************************/
    /*! exports provided: TableStickyFooterExample */
    /***/
    function srcAppDataTableTableComponentsTableStickyFooterExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableStickyFooterExample", function () {
        return TableStickyFooterExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function TableStickyFooterExample_th_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Item ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyFooterExample_td_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var transaction_r288 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", transaction_r288.item, " ");
        }
      }
      function TableStickyFooterExample_td_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Total ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyFooterExample_th_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Cost ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyFooterExample_td_11_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "currency");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var transaction_r289 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, transaction_r289.cost), " ");
        }
      }
      function TableStickyFooterExample_td_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 14);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "currency");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var ctx_r284 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, ctx_r284.getTotalCost()), " ");
        }
      }
      function TableStickyFooterExample_tr_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      function TableStickyFooterExample_tr_14_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 16);
        }
      }
      function TableStickyFooterExample_tr_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 17);
        }
      }
      /**
       * @title Table with a sticky footer
       */
      var TableStickyFooterExample = /*#__PURE__*/function () {
        function TableStickyFooterExample() {
          _classCallCheck(this, TableStickyFooterExample);
          this.displayedColumns = ['item', 'cost'];
          this.transactions = [{
            item: 'Beach ball',
            cost: 4
          }, {
            item: 'Towel',
            cost: 5
          }, {
            item: 'Frisbee',
            cost: 2
          }, {
            item: 'Sunscreen',
            cost: 4
          }, {
            item: 'Cooler',
            cost: 25
          }, {
            item: 'Swim suit',
            cost: 15
          }];
        }
        /** Gets the total cost of all transactions. */
        _createClass(TableStickyFooterExample, [{
          key: "getTotalCost",
          value: function getTotalCost() {
            return this.transactions.map(function (t) {
              return t.cost;
            }).reduce(function (acc, value) {
              return acc + value;
            }, 0);
          }
        }]);
        return TableStickyFooterExample;
      }();
      TableStickyFooterExample.ɵfac = function TableStickyFooterExample_Factory(t) {
        return new (t || TableStickyFooterExample)();
      };
      TableStickyFooterExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableStickyFooterExample,
        selectors: [["table-sticky-footer-example"]],
        decls: 16,
        vars: 5,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#sticky-rows-and-columns"], [1, "example-container", "mat-elevation-z8"], ["mat-table", "", 3, "dataSource"], ["matColumnDef", "item"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["mat-footer-cell", "", 4, "matFooterCellDef"], ["matColumnDef", "cost"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-footer-row", "", 4, "matFooterRowDef", "matFooterRowDefSticky"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-footer-cell", ""], ["mat-header-row", ""], ["mat-row", ""], ["mat-footer-row", ""]],
        template: function TableStickyFooterExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Table with sticky footer ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "table", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](5, 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableStickyFooterExample_th_6_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableStickyFooterExample_td_7_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TableStickyFooterExample_td_8_Template, 2, 0, "td", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](9, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableStickyFooterExample_th_10_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](11, TableStickyFooterExample_td_11_Template, 3, 3, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableStickyFooterExample_td_12_Template, 3, 3, "td", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableStickyFooterExample_tr_13_Template, 1, 0, "tr", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, TableStickyFooterExample_tr_14_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableStickyFooterExample_tr_15_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.transactions);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matFooterRowDef", ctx.displayedColumns)("matFooterRowDefSticky", true);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatFooterRow"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CurrencyPipe"]],
        styles: [".example-container[_ngcontent-%COMP%] {\r\n  height: 250px;\r\n  overflow: auto;\r\n}\r\n\r\ntr.mat-footer-row[_ngcontent-%COMP%] {\r\n  font-weight: bold;\r\n}\r\n\r\n.mat-table-sticky[_ngcontent-%COMP%] {\r\n  border-top: 1px solid #e0e0e0;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLXN0aWNreS1mb290ZXItZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxhQUFhO0VBQ2IsY0FBYztBQUNoQjs7QUFFQTtFQUNFLGlCQUFpQjtBQUNuQjs7QUFFQTtFQUNFLDZCQUE2QjtBQUMvQiIsImZpbGUiOiJzcmMvYXBwL2RhdGEtdGFibGUvdGFibGUvY29tcG9uZW50cy90YWJsZS1zdGlja3ktZm9vdGVyLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtY29udGFpbmVyIHtcclxuICBoZWlnaHQ6IDI1MHB4O1xyXG4gIG92ZXJmbG93OiBhdXRvO1xyXG59XHJcblxyXG50ci5tYXQtZm9vdGVyLXJvdyB7XHJcbiAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbn1cclxuXHJcbi5tYXQtdGFibGUtc3RpY2t5IHtcclxuICBib3JkZXItdG9wOiAxcHggc29saWQgI2UwZTBlMDtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableStickyFooterExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-sticky-footer-example',
            styleUrls: ['table-sticky-footer-example.css'],
            templateUrl: 'table-sticky-footer-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/components/table-sticky-header-example.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/data-table/table/components/table-sticky-header-example.ts ***!
      \****************************************************************************/
    /*! exports provided: TableStickyHeaderExample */
    /***/
    function srcAppDataTableTableComponentsTableStickyHeaderExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TableStickyHeaderExample", function () {
        return TableStickyHeaderExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      function TableStickyHeaderExample_th_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " No. ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyHeaderExample_td_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r301 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r301.position, " ");
        }
      }
      function TableStickyHeaderExample_th_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyHeaderExample_td_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r302 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r302.name, " ");
        }
      }
      function TableStickyHeaderExample_th_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Weight ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyHeaderExample_td_13_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r303 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r303.weight, " ");
        }
      }
      function TableStickyHeaderExample_th_15_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Symbol ");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      function TableStickyHeaderExample_td_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var element_r304 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r304.symbol, " ");
        }
      }
      function TableStickyHeaderExample_tr_17_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 14);
        }
      }
      function TableStickyHeaderExample_tr_18_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }
      /**
       * @title Table with sticky header
       */
      var TableStickyHeaderExample = /*#__PURE__*/_createClass(function TableStickyHeaderExample() {
        _classCallCheck(this, TableStickyHeaderExample);
        this.displayedColumns = ['position', 'name', 'weight', 'symbol'];
        this.dataSource = ELEMENT_DATA;
      });
      TableStickyHeaderExample.ɵfac = function TableStickyHeaderExample_Factory(t) {
        return new (t || TableStickyHeaderExample)();
      };
      TableStickyHeaderExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TableStickyHeaderExample,
        selectors: [["table-sticky-header-example"]],
        decls: 19,
        vars: 4,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/table/overview#sticky-rows-and-columns"], [1, "example-container", "mat-elevation-z8"], ["mat-table", "", 3, "dataSource"], ["matColumnDef", "position"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["matColumnDef", "weight"], ["matColumnDef", "symbol"], ["mat-header-row", "", 4, "matHeaderRowDef", "matHeaderRowDefSticky"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function TableStickyHeaderExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Table with sticky header ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "table", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](5, 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TableStickyHeaderExample_th_6_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TableStickyHeaderExample_td_7_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8, 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, TableStickyHeaderExample_th_9_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, TableStickyHeaderExample_td_10_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](11, 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, TableStickyHeaderExample_th_12_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, TableStickyHeaderExample_td_13_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](14, 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, TableStickyHeaderExample_th_15_Template, 2, 0, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, TableStickyHeaderExample_td_16_Template, 2, 1, "td", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, TableStickyHeaderExample_tr_17_Template, 1, 0, "tr", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, TableStickyHeaderExample_tr_18_Template, 1, 0, "tr", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns)("matHeaderRowDefSticky", true);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        styles: [".example-container[_ngcontent-%COMP%] {\r\n  height: 250px;\r\n  overflow: auto;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS90YWJsZS9jb21wb25lbnRzL3RhYmxlLXN0aWNreS1oZWFkZXItZXhhbXBsZS5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxhQUFhO0VBQ2IsY0FBYztBQUNoQiIsImZpbGUiOiJzcmMvYXBwL2RhdGEtdGFibGUvdGFibGUvY29tcG9uZW50cy90YWJsZS1zdGlja3ktaGVhZGVyLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmV4YW1wbGUtY29udGFpbmVyIHtcclxuICBoZWlnaHQ6IDI1MHB4O1xyXG4gIG92ZXJmbG93OiBhdXRvO1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TableStickyHeaderExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'table-sticky-header-example',
            styleUrls: ['table-sticky-header-example.css'],
            templateUrl: 'table-sticky-header-example.html'
          }]
        }], null, null);
      })();
      var ELEMENT_DATA = [{
        position: 1,
        name: 'Hydrogen',
        weight: 1.0079,
        symbol: 'H'
      }, {
        position: 2,
        name: 'Helium',
        weight: 4.0026,
        symbol: 'He'
      }, {
        position: 3,
        name: 'Lithium',
        weight: 6.941,
        symbol: 'Li'
      }, {
        position: 4,
        name: 'Beryllium',
        weight: 9.0122,
        symbol: 'Be'
      }, {
        position: 5,
        name: 'Boron',
        weight: 10.811,
        symbol: 'B'
      }, {
        position: 6,
        name: 'Carbon',
        weight: 12.0107,
        symbol: 'C'
      }, {
        position: 7,
        name: 'Nitrogen',
        weight: 14.0067,
        symbol: 'N'
      }, {
        position: 8,
        name: 'Oxygen',
        weight: 15.9994,
        symbol: 'O'
      }, {
        position: 9,
        name: 'Fluorine',
        weight: 18.9984,
        symbol: 'F'
      }, {
        position: 10,
        name: 'Neon',
        weight: 20.1797,
        symbol: 'Ne'
      }];

      /***/
    },

    /***/"./src/app/data-table/table/tables-routing.module.ts":
    /*!***********************************************************!*\
      !*** ./src/app/data-table/table/tables-routing.module.ts ***!
      \***********************************************************/
    /*! exports provided: TablesRoutingModule */
    /***/
    function srcAppDataTableTableTablesRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TablesRoutingModule", function () {
        return TablesRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _tables_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./tables.component */"./src/app/data-table/table/tables.component.ts");
      var routes = [{
        path: '',
        component: _tables_component__WEBPACK_IMPORTED_MODULE_2__["TablesComponent"]
      }];
      var TablesRoutingModule = /*#__PURE__*/_createClass(function TablesRoutingModule() {
        _classCallCheck(this, TablesRoutingModule);
      });
      TablesRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: TablesRoutingModule
      });
      TablesRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function TablesRoutingModule_Factory(t) {
          return new (t || TablesRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](TablesRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TablesRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/tables.component.ts":
    /*!******************************************************!*\
      !*** ./src/app/data-table/table/tables.component.ts ***!
      \******************************************************/
    /*! exports provided: TablesComponent */
    /***/
    function srcAppDataTableTableTablesComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TablesComponent", function () {
        return TablesComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_table_basic_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/table-basic-example */"./src/app/data-table/table/components/table-basic-example.ts");
      /* harmony import */
      var _components_table_basic_flex_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/table-basic-flex-example */"./src/app/data-table/table/components/table-basic-flex-example.ts");
      /* harmony import */
      var _components_table_dynamic_columns_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./components/table-dynamic-columns-example */"./src/app/data-table/table/components/table-dynamic-columns-example.ts");
      /* harmony import */
      var _components_table_expandable_rows_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/table-expandable-rows-example */"./src/app/data-table/table/components/table-expandable-rows-example.ts");
      /* harmony import */
      var _components_table_footer_row_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/table-footer-row-example */"./src/app/data-table/table/components/table-footer-row-example.ts");
      /* harmony import */
      var _components_table_reorderable_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./components/table-reorderable-example */"./src/app/data-table/table/components/table-reorderable-example.ts");
      /* harmony import */
      var _components_table_multiple_header_footer_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! ./components/table-multiple-header-footer-example */"./src/app/data-table/table/components/table-multiple-header-footer-example.ts");
      /* harmony import */
      var _components_table_sorting_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! ./components/table-sorting-example */"./src/app/data-table/table/components/table-sorting-example.ts");
      /* harmony import */
      var _components_table_pagination_example__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! ./components/table-pagination-example */"./src/app/data-table/table/components/table-pagination-example.ts");
      /* harmony import */
      var _components_table_filtering_example__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! ./components/table-filtering-example */"./src/app/data-table/table/components/table-filtering-example.ts");
      /* harmony import */
      var _components_table_row_context_example__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! ./components/table-row-context-example */"./src/app/data-table/table/components/table-row-context-example.ts");
      /* harmony import */
      var _components_table_selection_example__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! ./components/table-selection-example */"./src/app/data-table/table/components/table-selection-example.ts");
      /* harmony import */
      var _components_table_http_example__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__( /*! ./components/table-http-example */"./src/app/data-table/table/components/table-http-example.ts");
      /* harmony import */
      var _components_table_overview_example__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__( /*! ./components/table-overview-example */"./src/app/data-table/table/components/table-overview-example.ts");
      /* harmony import */
      var _components_table_sticky_columns_example__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__( /*! ./components/table-sticky-columns-example */"./src/app/data-table/table/components/table-sticky-columns-example.ts");
      /* harmony import */
      var _components_table_sticky_footer_example__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__( /*! ./components/table-sticky-footer-example */"./src/app/data-table/table/components/table-sticky-footer-example.ts");
      /* harmony import */
      var _components_table_sticky_header_example__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__( /*! ./components/table-sticky-header-example */"./src/app/data-table/table/components/table-sticky-header-example.ts");
      var TablesComponent = /*#__PURE__*/_createClass(function TablesComponent() {
        _classCallCheck(this, TablesComponent);
      });
      TablesComponent.ɵfac = function TablesComponent_Factory(t) {
        return new (t || TablesComponent)();
      };
      TablesComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: TablesComponent,
        selectors: [["app-tables"]],
        decls: 17,
        vars: 0,
        template: function TablesComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "table-basic-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "table-basic-flex-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "table-dynamic-columns-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "table-expandable-rows-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "table-footer-row-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "table-reorderable-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "table-multiple-header-footer-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "table-sorting-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "table-pagination-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "table-filtering-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "table-row-context-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "table-selection-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "table-http-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](13, "table-overview-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](14, "table-sticky-columns-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "table-sticky-footer-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](16, "table-sticky-header-example");
          }
        },
        directives: [_components_table_basic_example__WEBPACK_IMPORTED_MODULE_1__["TableBasicExample"], _components_table_basic_flex_example__WEBPACK_IMPORTED_MODULE_2__["TableBasicFlexExample"], _components_table_dynamic_columns_example__WEBPACK_IMPORTED_MODULE_3__["TableDynamicColumnsExample"], _components_table_expandable_rows_example__WEBPACK_IMPORTED_MODULE_4__["TableExpandableRowsExample"], _components_table_footer_row_example__WEBPACK_IMPORTED_MODULE_5__["TableFooterRowExample"], _components_table_reorderable_example__WEBPACK_IMPORTED_MODULE_6__["TableReorderableExample"], _components_table_multiple_header_footer_example__WEBPACK_IMPORTED_MODULE_7__["TableMultipleHeaderFooterExample"], _components_table_sorting_example__WEBPACK_IMPORTED_MODULE_8__["TableSortingExample"], _components_table_pagination_example__WEBPACK_IMPORTED_MODULE_9__["TablePaginationExample"], _components_table_filtering_example__WEBPACK_IMPORTED_MODULE_10__["TableFilteringExample"], _components_table_row_context_example__WEBPACK_IMPORTED_MODULE_11__["TableRowContextExample"], _components_table_selection_example__WEBPACK_IMPORTED_MODULE_12__["TableSelectionExample"], _components_table_http_example__WEBPACK_IMPORTED_MODULE_13__["TableHttpExample"], _components_table_overview_example__WEBPACK_IMPORTED_MODULE_14__["TableOverviewExample"], _components_table_sticky_columns_example__WEBPACK_IMPORTED_MODULE_15__["TableStickyColumnsExample"], _components_table_sticky_footer_example__WEBPACK_IMPORTED_MODULE_16__["TableStickyFooterExample"], _components_table_sticky_header_example__WEBPACK_IMPORTED_MODULE_17__["TableStickyHeaderExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TablesComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-tables',
            templateUrl: './tables.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/table/tables.module.ts":
    /*!***************************************************!*\
      !*** ./src/app/data-table/table/tables.module.ts ***!
      \***************************************************/
    /*! exports provided: TablesModule */
    /***/
    function srcAppDataTableTableTablesModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "TablesModule", function () {
        return TablesModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _tables_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./tables-routing.module */"./src/app/data-table/table/tables-routing.module.ts");
      /* harmony import */
      var _tables_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./tables.component */"./src/app/data-table/table/tables.component.ts");
      /* harmony import */
      var _components_table_basic_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/table-basic-example */"./src/app/data-table/table/components/table-basic-example.ts");
      /* harmony import */
      var _angular_material_table__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/table */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
      /* harmony import */
      var _components_table_basic_flex_example__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./components/table-basic-flex-example */"./src/app/data-table/table/components/table-basic-flex-example.ts");
      /* harmony import */
      var _components_table_dynamic_columns_example__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! ./components/table-dynamic-columns-example */"./src/app/data-table/table/components/table-dynamic-columns-example.ts");
      /* harmony import */
      var _components_table_expandable_rows_example__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__( /*! ./components/table-expandable-rows-example */"./src/app/data-table/table/components/table-expandable-rows-example.ts");
      /* harmony import */
      var _components_table_filtering_example__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__( /*! ./components/table-filtering-example */"./src/app/data-table/table/components/table-filtering-example.ts");
      /* harmony import */
      var _components_table_footer_row_example__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__( /*! ./components/table-footer-row-example */"./src/app/data-table/table/components/table-footer-row-example.ts");
      /* harmony import */
      var _components_table_http_example__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__( /*! ./components/table-http-example */"./src/app/data-table/table/components/table-http-example.ts");
      /* harmony import */
      var _components_table_multiple_header_footer_example__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__( /*! ./components/table-multiple-header-footer-example */"./src/app/data-table/table/components/table-multiple-header-footer-example.ts");
      /* harmony import */
      var _components_table_overview_example__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__( /*! ./components/table-overview-example */"./src/app/data-table/table/components/table-overview-example.ts");
      /* harmony import */
      var _components_table_pagination_example__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__( /*! ./components/table-pagination-example */"./src/app/data-table/table/components/table-pagination-example.ts");
      /* harmony import */
      var _components_table_reorderable_example__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__( /*! ./components/table-reorderable-example */"./src/app/data-table/table/components/table-reorderable-example.ts");
      /* harmony import */
      var _components_table_row_context_example__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__( /*! ./components/table-row-context-example */"./src/app/data-table/table/components/table-row-context-example.ts");
      /* harmony import */
      var _components_table_selection_example__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__( /*! ./components/table-selection-example */"./src/app/data-table/table/components/table-selection-example.ts");
      /* harmony import */
      var _components_table_sorting_example__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__( /*! ./components/table-sorting-example */"./src/app/data-table/table/components/table-sorting-example.ts");
      /* harmony import */
      var _components_table_sticky_columns_example__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__( /*! ./components/table-sticky-columns-example */"./src/app/data-table/table/components/table-sticky-columns-example.ts");
      /* harmony import */
      var _components_table_sticky_footer_example__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__( /*! ./components/table-sticky-footer-example */"./src/app/data-table/table/components/table-sticky-footer-example.ts");
      /* harmony import */
      var _components_table_sticky_header_example__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__( /*! ./components/table-sticky-header-example */"./src/app/data-table/table/components/table-sticky-header-example.ts");
      /* harmony import */
      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__( /*! @angular/material/form-field */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
      /* harmony import */
      var _angular_material_sort__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__( /*! @angular/material/sort */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
      /* harmony import */
      var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__( /*! @angular/material/progress-spinner */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-spinner.js");
      /* harmony import */
      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__( /*! @angular/material/paginator */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/paginator.js");
      /* harmony import */
      var _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__( /*! @angular/cdk/drag-drop */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/drag-drop.js");
      /* harmony import */
      var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__( /*! @angular/material/checkbox */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      /* harmony import */
      var _angular_material_input__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__( /*! @angular/material/input */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      var TablesModule = /*#__PURE__*/_createClass(function TablesModule() {
        _classCallCheck(this, TablesModule);
      });
      TablesModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: TablesModule
      });
      TablesModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function TablesModule_Factory(t) {
          return new (t || TablesModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _tables_routing_module__WEBPACK_IMPORTED_MODULE_2__["TablesRoutingModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_5__["MatTableModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_22__["MatFormFieldModule"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_23__["MatSortModule"], _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_24__["MatProgressSpinnerModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_25__["MatPaginatorModule"], _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_26__["DragDropModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_27__["MatCheckboxModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_28__["MatIconModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_29__["MatInputModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_30__["MatButtonModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](TablesModule, {
          declarations: [_tables_component__WEBPACK_IMPORTED_MODULE_3__["TablesComponent"], _components_table_basic_example__WEBPACK_IMPORTED_MODULE_4__["TableBasicExample"], _components_table_basic_flex_example__WEBPACK_IMPORTED_MODULE_6__["TableBasicFlexExample"], _components_table_dynamic_columns_example__WEBPACK_IMPORTED_MODULE_7__["TableDynamicColumnsExample"], _components_table_expandable_rows_example__WEBPACK_IMPORTED_MODULE_8__["TableExpandableRowsExample"], _components_table_filtering_example__WEBPACK_IMPORTED_MODULE_9__["TableFilteringExample"], _components_table_footer_row_example__WEBPACK_IMPORTED_MODULE_10__["TableFooterRowExample"], _components_table_http_example__WEBPACK_IMPORTED_MODULE_11__["TableHttpExample"], _components_table_multiple_header_footer_example__WEBPACK_IMPORTED_MODULE_12__["TableMultipleHeaderFooterExample"], _components_table_overview_example__WEBPACK_IMPORTED_MODULE_13__["TableOverviewExample"], _components_table_pagination_example__WEBPACK_IMPORTED_MODULE_14__["TablePaginationExample"], _components_table_reorderable_example__WEBPACK_IMPORTED_MODULE_15__["TableReorderableExample"], _components_table_row_context_example__WEBPACK_IMPORTED_MODULE_16__["TableRowContextExample"], _components_table_selection_example__WEBPACK_IMPORTED_MODULE_17__["TableSelectionExample"], _components_table_sorting_example__WEBPACK_IMPORTED_MODULE_18__["TableSortingExample"], _components_table_sticky_columns_example__WEBPACK_IMPORTED_MODULE_19__["TableStickyColumnsExample"], _components_table_sticky_footer_example__WEBPACK_IMPORTED_MODULE_20__["TableStickyFooterExample"], _components_table_sticky_header_example__WEBPACK_IMPORTED_MODULE_21__["TableStickyHeaderExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _tables_routing_module__WEBPACK_IMPORTED_MODULE_2__["TablesRoutingModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_5__["MatTableModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_22__["MatFormFieldModule"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_23__["MatSortModule"], _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_24__["MatProgressSpinnerModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_25__["MatPaginatorModule"], _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_26__["DragDropModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_27__["MatCheckboxModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_28__["MatIconModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_29__["MatInputModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_30__["MatButtonModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TablesModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_tables_component__WEBPACK_IMPORTED_MODULE_3__["TablesComponent"], _components_table_basic_example__WEBPACK_IMPORTED_MODULE_4__["TableBasicExample"], _components_table_basic_flex_example__WEBPACK_IMPORTED_MODULE_6__["TableBasicFlexExample"], _components_table_dynamic_columns_example__WEBPACK_IMPORTED_MODULE_7__["TableDynamicColumnsExample"], _components_table_expandable_rows_example__WEBPACK_IMPORTED_MODULE_8__["TableExpandableRowsExample"], _components_table_filtering_example__WEBPACK_IMPORTED_MODULE_9__["TableFilteringExample"], _components_table_footer_row_example__WEBPACK_IMPORTED_MODULE_10__["TableFooterRowExample"], _components_table_http_example__WEBPACK_IMPORTED_MODULE_11__["TableHttpExample"], _components_table_multiple_header_footer_example__WEBPACK_IMPORTED_MODULE_12__["TableMultipleHeaderFooterExample"], _components_table_overview_example__WEBPACK_IMPORTED_MODULE_13__["TableOverviewExample"], _components_table_pagination_example__WEBPACK_IMPORTED_MODULE_14__["TablePaginationExample"], _components_table_reorderable_example__WEBPACK_IMPORTED_MODULE_15__["TableReorderableExample"], _components_table_row_context_example__WEBPACK_IMPORTED_MODULE_16__["TableRowContextExample"], _components_table_selection_example__WEBPACK_IMPORTED_MODULE_17__["TableSelectionExample"], _components_table_sorting_example__WEBPACK_IMPORTED_MODULE_18__["TableSortingExample"], _components_table_sticky_columns_example__WEBPACK_IMPORTED_MODULE_19__["TableStickyColumnsExample"], _components_table_sticky_footer_example__WEBPACK_IMPORTED_MODULE_20__["TableStickyFooterExample"], _components_table_sticky_header_example__WEBPACK_IMPORTED_MODULE_21__["TableStickyHeaderExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _tables_routing_module__WEBPACK_IMPORTED_MODULE_2__["TablesRoutingModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_5__["MatTableModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_22__["MatFormFieldModule"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_23__["MatSortModule"], _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_24__["MatProgressSpinnerModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_25__["MatPaginatorModule"], _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_26__["DragDropModule"], _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_27__["MatCheckboxModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_28__["MatIconModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_29__["MatInputModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_30__["MatButtonModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=data-table-table-tables-module-es5.js.map