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
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["buttons-and-indicators-badge-badges-module"], {
    /***/"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/badge.js":
    /*!***********************************************************************!*\
      !*** ./node_modules/@angular/material/__ivy_ngcc__/fesm2015/badge.js ***!
      \***********************************************************************/
    /*! exports provided: MatBadge, MatBadgeModule */
    /***/
    function node_modulesAngularMaterial__ivy_ngcc__Fesm2015BadgeJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBadge", function () {
        return MatBadge;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MatBadgeModule", function () {
        return MatBadgeModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/cdk/a11y */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
      /* harmony import */
      var _angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/cdk/coercion */"./node_modules/@angular/cdk/fesm2015/coercion.js");
      /* harmony import */
      var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/platform-browser/animations */"./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/animations.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/badge/badge.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /** @type {?} */

      var nextId = 0;
      // Boilerplate for applying mixins to MatBadge.
      /**
       * \@docs-private
       */
      var MatBadgeBase = /*#__PURE__*/_createClass(function MatBadgeBase() {
        _classCallCheck(this, MatBadgeBase);
      });
      /** @type {?} */
      var _MatBadgeMixinBase = Object(_angular_material_core__WEBPACK_IMPORTED_MODULE_1__["mixinDisabled"])(MatBadgeBase);
      /**
       * Directive to display a text badge.
       */
      var MatBadge = /*#__PURE__*/function (_MatBadgeMixinBase2) {
        _inherits(MatBadge, _MatBadgeMixinBase2);
        var _super = _createSuper(MatBadge);
        /**
         * @param {?} _ngZone
         * @param {?} _elementRef
         * @param {?} _ariaDescriber
         * @param {?} _renderer
         * @param {?=} _animationMode
         */
        function MatBadge(_ngZone, _elementRef, _ariaDescriber, _renderer, _animationMode) {
          var _this;
          _classCallCheck(this, MatBadge);
          _this = _super.call(this);
          _this._ngZone = _ngZone;
          _this._elementRef = _elementRef;
          _this._ariaDescriber = _ariaDescriber;
          _this._renderer = _renderer;
          _this._animationMode = _animationMode;
          /**
           * Whether the badge has any content.
           */
          _this._hasContent = false;
          _this._color = 'primary';
          _this._overlap = true;
          /**
           * Position the badge should reside.
           * Accepts any combination of 'above'|'below' and 'before'|'after'
           */
          _this.position = 'above after';
          /**
           * Size of the badge. Can be 'small', 'medium', or 'large'.
           */
          _this.size = 'medium';
          /**
           * Unique id for the badge
           */
          _this._id = nextId++;
          if (Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["isDevMode"])()) {
            /** @type {?} */
            var nativeElement = _elementRef.nativeElement;
            if (nativeElement.nodeType !== nativeElement.ELEMENT_NODE) {
              throw Error('matBadge must be attached to an element node.');
            }
          }
          return _this;
        }
        /**
         * The color of the badge. Can be `primary`, `accent`, or `warn`.
         * @return {?}
         */
        _createClass(MatBadge, [{
          key: "color",
          get: function get() {
            return this._color;
          }
          /**
           * @param {?} value
           * @return {?}
           */,
          set: function set(value) {
            this._setColor(value);
            this._color = value;
          }
          /**
           * Whether the badge should overlap its contents or not
           * @return {?}
           */
        }, {
          key: "overlap",
          get: function get() {
            return this._overlap;
          }
          /**
           * @param {?} val
           * @return {?}
           */,
          set: function set(val) {
            this._overlap = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_3__["coerceBooleanProperty"])(val);
          }
          /**
           * Message used to describe the decorated element via aria-describedby
           * @return {?}
           */
        }, {
          key: "description",
          get: function get() {
            return this._description;
          }
          /**
           * @param {?} newDescription
           * @return {?}
           */,
          set: function set(newDescription) {
            if (newDescription !== this._description) {
              /** @type {?} */
              var badgeElement = this._badgeElement;
              this._updateHostAriaDescription(newDescription, this._description);
              this._description = newDescription;
              if (badgeElement) {
                newDescription ? badgeElement.setAttribute('aria-label', newDescription) : badgeElement.removeAttribute('aria-label');
              }
            }
          }
          /**
           * Whether the badge is hidden.
           * @return {?}
           */
        }, {
          key: "hidden",
          get: function get() {
            return this._hidden;
          }
          /**
           * @param {?} val
           * @return {?}
           */,
          set: function set(val) {
            this._hidden = Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_3__["coerceBooleanProperty"])(val);
          }
          /**
           * Whether the badge is above the host or not
           * @return {?}
           */
        }, {
          key: "isAbove",
          value: function isAbove() {
            return this.position.indexOf('below') === -1;
          }
          /**
           * Whether the badge is after the host or not
           * @return {?}
           */
        }, {
          key: "isAfter",
          value: function isAfter() {
            return this.position.indexOf('before') === -1;
          }
          /**
           * @param {?} changes
           * @return {?}
           */
        }, {
          key: "ngOnChanges",
          value: function ngOnChanges(changes) {
            /** @type {?} */
            var contentChange = changes['content'];
            if (contentChange) {
              /** @type {?} */
              var value = contentChange.currentValue;
              this._hasContent = value != null && "".concat(value).trim().length > 0;
              this._updateTextContent();
            }
          }
          /**
           * @return {?}
           */
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            /** @type {?} */
            var badgeElement = this._badgeElement;
            if (badgeElement) {
              if (this.description) {
                this._ariaDescriber.removeDescription(badgeElement, this.description);
              }
              // When creating a badge through the Renderer, Angular will keep it in an index.
              // We have to destroy it ourselves, otherwise it'll be retained in memory.
              if (this._renderer.destroyNode) {
                this._renderer.destroyNode(badgeElement);
              }
            }
          }
          /**
           * Gets the element into which the badge's content is being rendered.
           * Undefined if the element hasn't been created (e.g. if the badge doesn't have content).
           * @return {?}
           */
        }, {
          key: "getBadgeElement",
          value: function getBadgeElement() {
            return this._badgeElement;
          }
          /**
           * Injects a span element into the DOM with the content.
           * @private
           * @return {?}
           */
        }, {
          key: "_updateTextContent",
          value: function _updateTextContent() {
            if (!this._badgeElement) {
              this._badgeElement = this._createBadgeElement();
            } else {
              this._badgeElement.textContent = this.content;
            }
            return this._badgeElement;
          }
          /**
           * Creates the badge element
           * @private
           * @return {?}
           */
        }, {
          key: "_createBadgeElement",
          value: function _createBadgeElement() {
            /** @type {?} */
            var badgeElement = this._renderer.createElement('span');
            /** @type {?} */
            var activeClass = 'mat-badge-active';
            /** @type {?} */
            var contentClass = 'mat-badge-content';
            // Clear any existing badges which may have persisted from a server-side render.
            this._clearExistingBadges(contentClass);
            badgeElement.setAttribute('id', "mat-badge-content-".concat(this._id));
            badgeElement.classList.add(contentClass);
            badgeElement.textContent = this.content;
            if (this._animationMode === 'NoopAnimations') {
              badgeElement.classList.add('_mat-animation-noopable');
            }
            if (this.description) {
              badgeElement.setAttribute('aria-label', this.description);
            }
            this._elementRef.nativeElement.appendChild(badgeElement);
            // animate in after insertion
            if (typeof requestAnimationFrame === 'function' && this._animationMode !== 'NoopAnimations') {
              this._ngZone.runOutsideAngular(
              /**
              * @return {?}
              */
              function () {
                requestAnimationFrame(
                /**
                * @return {?}
                */
                function () {
                  badgeElement.classList.add(activeClass);
                });
              });
            } else {
              badgeElement.classList.add(activeClass);
            }
            return badgeElement;
          }
          /**
           * Sets the aria-label property on the element
           * @private
           * @param {?} newDescription
           * @param {?} oldDescription
           * @return {?}
           */
        }, {
          key: "_updateHostAriaDescription",
          value: function _updateHostAriaDescription(newDescription, oldDescription) {
            // ensure content available before setting label
            /** @type {?} */
            var content = this._updateTextContent();
            if (oldDescription) {
              this._ariaDescriber.removeDescription(content, oldDescription);
            }
            if (newDescription) {
              this._ariaDescriber.describe(content, newDescription);
            }
          }
          /**
           * Adds css theme class given the color to the component host
           * @private
           * @param {?} colorPalette
           * @return {?}
           */
        }, {
          key: "_setColor",
          value: function _setColor(colorPalette) {
            if (colorPalette !== this._color) {
              if (this._color) {
                this._elementRef.nativeElement.classList.remove("mat-badge-".concat(this._color));
              }
              if (colorPalette) {
                this._elementRef.nativeElement.classList.add("mat-badge-".concat(colorPalette));
              }
            }
          }
          /**
           * Clears any existing badges that might be left over from server-side rendering.
           * @private
           * @param {?} cssClass
           * @return {?}
           */
        }, {
          key: "_clearExistingBadges",
          value: function _clearExistingBadges(cssClass) {
            /** @type {?} */
            var element = this._elementRef.nativeElement;
            /** @type {?} */
            var childCount = element.children.length;
            // Use a reverse while, because we'll be removing elements from the list as we're iterating.
            while (childCount--) {
              /** @type {?} */
              var currentChild = element.children[childCount];
              if (currentChild.classList.contains(cssClass)) {
                element.removeChild(currentChild);
              }
            }
          }
        }]);
        return MatBadge;
      }(_MatBadgeMixinBase);
      MatBadge.ɵfac = function MatBadge_Factory(t) {
        return new (t || MatBadge)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["AriaDescriber"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["Renderer2"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["ANIMATION_MODULE_TYPE"], 8));
      };
      MatBadge.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
        type: MatBadge,
        selectors: [["", "matBadge", ""]],
        hostAttrs: [1, "mat-badge"],
        hostVars: 20,
        hostBindings: function MatBadge_HostBindings(rf, ctx) {
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("mat-badge-overlap", ctx.overlap)("mat-badge-above", ctx.isAbove())("mat-badge-below", !ctx.isAbove())("mat-badge-before", !ctx.isAfter())("mat-badge-after", ctx.isAfter())("mat-badge-small", ctx.size === "small")("mat-badge-medium", ctx.size === "medium")("mat-badge-large", ctx.size === "large")("mat-badge-hidden", ctx.hidden || !ctx._hasContent)("mat-badge-disabled", ctx.disabled);
          }
        },
        inputs: {
          disabled: ["matBadgeDisabled", "disabled"],
          position: ["matBadgePosition", "position"],
          size: ["matBadgeSize", "size"],
          color: ["matBadgeColor", "color"],
          overlap: ["matBadgeOverlap", "overlap"],
          description: ["matBadgeDescription", "description"],
          hidden: ["matBadgeHidden", "hidden"],
          content: ["matBadge", "content"]
        },
        features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵInheritDefinitionFeature"], _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵNgOnChangesFeature"]]
      });
      /** @nocollapse */
      MatBadge.ctorParameters = function () {
        return [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
        }, {
          type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["AriaDescriber"]
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Renderer2"]
        }, {
          type: String,
          decorators: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
            args: [_angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["ANIMATION_MODULE_TYPE"]]
          }]
        }];
      };
      MatBadge.propDecorators = {
        color: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadgeColor']
        }],
        overlap: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadgeOverlap']
        }],
        position: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadgePosition']
        }],
        content: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadge']
        }],
        description: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadgeDescription']
        }],
        size: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadgeSize']
        }],
        hidden: [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
          args: ['matBadgeHidden']
        }]
      };
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MatBadge, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Directive"],
          args: [{
            selector: '[matBadge]',
            inputs: ['disabled: matBadgeDisabled'],
            host: {
              'class': 'mat-badge',
              '[class.mat-badge-overlap]': 'overlap',
              '[class.mat-badge-above]': 'isAbove()',
              '[class.mat-badge-below]': '!isAbove()',
              '[class.mat-badge-before]': '!isAfter()',
              '[class.mat-badge-after]': 'isAfter()',
              '[class.mat-badge-small]': 'size === "small"',
              '[class.mat-badge-medium]': 'size === "medium"',
              '[class.mat-badge-large]': 'size === "large"',
              '[class.mat-badge-hidden]': 'hidden || !_hasContent',
              '[class.mat-badge-disabled]': 'disabled'
            }
          }]
        }], function () {
          return [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]
          }, {
            type: _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["AriaDescriber"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Renderer2"]
          }, {
            type: String,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["ANIMATION_MODULE_TYPE"]]
            }]
          }];
        }, {
          position: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadgePosition']
          }],
          size: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadgeSize']
          }],
          color: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadgeColor']
          }],
          overlap: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadgeOverlap']
          }],
          description: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadgeDescription']
          }],
          hidden: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadgeHidden']
          }],
          content: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['matBadge']
          }]
        });
      })();
      if (false) {}

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/badge/badge-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var MatBadgeModule = /*#__PURE__*/_createClass(function MatBadgeModule() {
        _classCallCheck(this, MatBadgeModule);
      });
      MatBadgeModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: MatBadgeModule
      });
      MatBadgeModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function MatBadgeModule_Factory(t) {
          return new (t || MatBadgeModule)();
        },
        imports: [[_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["A11yModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_1__["MatCommonModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](MatBadgeModule, {
          declarations: function declarations() {
            return [MatBadge];
          },
          imports: function imports() {
            return [_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["A11yModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_1__["MatCommonModule"]];
          },
          exports: function exports() {
            return [MatBadge];
          }
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MatBadgeModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["A11yModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_1__["MatCommonModule"]],
            exports: [MatBadge],
            declarations: [MatBadge]
          }]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/material/badge/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=badge.js.map

      /***/
    },

    /***/"./src/app/buttons-and-indicators/badge/badge-overview-example.ts":
    /*!************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/badge/badge-overview-example.ts ***!
      \************************************************************************/
    /*! exports provided: BadgeOverviewExample */
    /***/
    function srcAppButtonsAndIndicatorsBadgeBadgeOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BadgeOverviewExample", function () {
        return BadgeOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_badge__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/badge */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/badge.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function BadgeOverviewExample_div_36_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 13);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Top secret message");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }
      /**
       * @title Badge overview
       */
      var BadgeOverviewExample = /*#__PURE__*/function () {
        function BadgeOverviewExample() {
          _classCallCheck(this, BadgeOverviewExample);
          this.showMsg = false;
          this.isHidden = false;
          this.isDisabled = true;
        }
        _createClass(BadgeOverviewExample, [{
          key: "toggleBadgeIsVisible",
          value: function toggleBadgeIsVisible() {
            this.isHidden = !this.isHidden;
          }
        }, {
          key: "toggleBadgeIsDisabled",
          value: function toggleBadgeIsDisabled() {
            this.isDisabled = !this.isDisabled;
          }
        }]);
        return BadgeOverviewExample;
      }();
      BadgeOverviewExample.ɵfac = function BadgeOverviewExample_Factory(t) {
        return new (t || BadgeOverviewExample)();
      };
      BadgeOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: BadgeOverviewExample,
        selectors: [["badge-overview-example"]],
        decls: 37,
        vars: 4,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/badge/overview"], ["matBadge", "4", "matBadgeOverlap", "false", "id", "text-with-badge"], ["matBadgeSize", "large", "matBadge", "4"], ["matBadgeSize", "small", "matBadge", "4"], ["matBadge", "Best", 1, "large-custom-size"], ["matBadgePosition", "below", "matBadge", "4"], ["mat-raised-button", "", "color", "primary", "matBadge", "8", "matBadgePosition", "before", "matBadgeColor", "accent", "id", "button-with-badge", 3, "click"], ["matBadge", "15", "matBadgeColor", "warn", "id", "icon-with-badge"], [1, "cdk-visually-hidden"], ["mat-raised-button", "", "matBadge", "7", 3, "matBadgeHidden", "click"], ["mat-raised-button", "", "matBadge", "7", 3, "matBadgeDisabled", "click"], ["id", "hidden-message", 4, "ngIf"], ["id", "hidden-message"]],
        template: function BadgeOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Badge overview ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Text with a badge");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "span", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Text with a large badge");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "span", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Text with a small badge");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "span", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Text with a text-content badge");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "span", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "Badge position bellow");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, " Button with a badge on the left ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "button", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BadgeOverviewExample_Template_button_click_20_listener() {
              return ctx.showMsg = !ctx.showMsg;
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, " Icon with a badge ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "mat-icon", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25, "home");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "span", 9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, " Example with a home icon with overlaid badge showing the number 15 ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](29, " Button toggles badge visibility ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "button", 10);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BadgeOverviewExample_Template_button_click_30_listener() {
              return ctx.toggleBadgeIsVisible();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](31, " Hide ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](33, " Button toggles badge disabled ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "button", 11);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BadgeOverviewExample_Template_button_click_34_listener() {
              return ctx.toggleBadgeIsDisabled();
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](35, " isDisabled ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](36, BadgeOverviewExample_div_36_Template, 2, 0, "div", 12);
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](21);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", ctx.showMsg ? "Hide" : "Show", " message ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matBadgeHidden", ctx.isHidden);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matBadgeDisabled", ctx.isDisabled);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showMsg);
          }
        },
        directives: [_angular_material_badge__WEBPACK_IMPORTED_MODULE_1__["MatBadge"], _angular_material_button__WEBPACK_IMPORTED_MODULE_2__["MatButton"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_3__["MatIcon"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"]],
        styles: [".large-custom-size[_ngcontent-%COMP%]   .mat-badge-content[_ngcontent-%COMP%] {\r\n  width: 42px;\r\n  height: 42px;\r\n  line-height: 42px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYnV0dG9ucy1hbmQtaW5kaWNhdG9ycy9iYWRnZS9iYWRnZS1vdmVydmlldy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSw2QkFBNkI7O0FBRTdCO0VBQ0UsV0FBVztFQUNYLFlBQVk7RUFDWixpQkFBaUI7QUFDbkIiLCJmaWxlIjoic3JjL2FwcC9idXR0b25zLWFuZC1pbmRpY2F0b3JzL2JhZGdlL2JhZGdlLW92ZXJ2aWV3LWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyoqIE5vIENTUyBmb3IgdGhpcyBleGFtcGxlICovXHJcblxyXG4ubGFyZ2UtY3VzdG9tLXNpemUgLm1hdC1iYWRnZS1jb250ZW50IHtcclxuICB3aWR0aDogNDJweDtcclxuICBoZWlnaHQ6IDQycHg7XHJcbiAgbGluZS1oZWlnaHQ6IDQycHg7XHJcbn1cclxuIl19 */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BadgeOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'badge-overview-example',
            templateUrl: 'badge-overview-example.html',
            styleUrls: ['badge-overview-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/badge/badges-routing.module.ts":
    /*!***********************************************************************!*\
      !*** ./src/app/buttons-and-indicators/badge/badges-routing.module.ts ***!
      \***********************************************************************/
    /*! exports provided: BadgeRoutingModule */
    /***/
    function srcAppButtonsAndIndicatorsBadgeBadgesRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BadgeRoutingModule", function () {
        return BadgeRoutingModule;
      });
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _badge_overview_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./badge-overview-example */"./src/app/buttons-and-indicators/badge/badge-overview-example.ts");
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      var routes = [{
        path: '',
        component: _badge_overview_example__WEBPACK_IMPORTED_MODULE_1__["BadgeOverviewExample"]
      }];
      var BadgeRoutingModule = /*#__PURE__*/_createClass(function BadgeRoutingModule() {
        _classCallCheck(this, BadgeRoutingModule);
      });
      BadgeRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
        type: BadgeRoutingModule
      });
      BadgeRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
        factory: function BadgeRoutingModule_Factory(t) {
          return new (t || BadgeRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](BadgeRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](BadgeRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/badge/badges.module.ts":
    /*!***************************************************************!*\
      !*** ./src/app/buttons-and-indicators/badge/badges.module.ts ***!
      \***************************************************************/
    /*! exports provided: BadgesModule */
    /***/
    function srcAppButtonsAndIndicatorsBadgeBadgesModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BadgesModule", function () {
        return BadgesModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _badge_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./badge-overview-example */"./src/app/buttons-and-indicators/badge/badge-overview-example.ts");
      /* harmony import */
      var _angular_material_badge__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/badge */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/badge.js");
      /* harmony import */
      var _angular_material_button__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/button */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      /* harmony import */
      var _badges_routing_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! ./badges-routing.module */"./src/app/buttons-and-indicators/badge/badges-routing.module.ts");
      var BadgesModule = /*#__PURE__*/_createClass(function BadgesModule() {
        _classCallCheck(this, BadgesModule);
      });
      BadgesModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: BadgesModule
      });
      BadgesModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function BadgesModule_Factory(t) {
          return new (t || BadgesModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _angular_material_badge__WEBPACK_IMPORTED_MODULE_3__["MatBadgeModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIconModule"], _badges_routing_module__WEBPACK_IMPORTED_MODULE_6__["BadgeRoutingModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](BadgesModule, {
          declarations: [_badge_overview_example__WEBPACK_IMPORTED_MODULE_2__["BadgeOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _angular_material_badge__WEBPACK_IMPORTED_MODULE_3__["MatBadgeModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIconModule"], _badges_routing_module__WEBPACK_IMPORTED_MODULE_6__["BadgeRoutingModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BadgesModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_badge_overview_example__WEBPACK_IMPORTED_MODULE_2__["BadgeOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _angular_material_badge__WEBPACK_IMPORTED_MODULE_3__["MatBadgeModule"], _angular_material_button__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIconModule"], _badges_routing_module__WEBPACK_IMPORTED_MODULE_6__["BadgeRoutingModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=buttons-and-indicators-badge-badges-module-es5.js.map