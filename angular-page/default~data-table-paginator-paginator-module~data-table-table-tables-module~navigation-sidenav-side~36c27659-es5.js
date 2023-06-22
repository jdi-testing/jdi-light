(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["default~data-table-paginator-paginator-module~data-table-table-tables-module~navigation-sidenav-side~36c27659"], {
    /***/"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/layout.js":
    /*!*******************************************************************!*\
      !*** ./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/layout.js ***!
      \*******************************************************************/
    /*! exports provided: BreakpointObserver, Breakpoints, LayoutModule, MediaMatcher */
    /***/
    function node_modulesAngularCdk__ivy_ngcc__Fesm2015LayoutJs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "BreakpointObserver", function () {
        return BreakpointObserver;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "Breakpoints", function () {
        return Breakpoints;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "LayoutModule", function () {
        return LayoutModule;
      });
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "MediaMatcher", function () {
        return MediaMatcher;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/cdk/platform */"./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/platform.js");
      /* harmony import */
      var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! rxjs */"./node_modules/rxjs/_esm2015/index.js");
      /* harmony import */
      var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! rxjs/operators */"./node_modules/rxjs/_esm2015/operators/index.js");
      /* harmony import */
      var _angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/cdk/coercion */"./node_modules/@angular/cdk/fesm2015/coercion.js");

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/layout/layout-module.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      var LayoutModule = /*#__PURE__*/_createClass(function LayoutModule() {
        _classCallCheck(this, LayoutModule);
      });
      LayoutModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: LayoutModule
      });
      LayoutModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function LayoutModule_Factory(t) {
          return new (t || LayoutModule)();
        }
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](LayoutModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{}]
        }], null, null);
      })();

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/layout/media-matcher.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * Global registry for all dynamically-created, injected media queries.
       * @type {?}
       */
      var mediaQueriesForWebkitCompatibility = new Set();
      /**
       * Style tag that holds all of the dynamically-created media queries.
       * @type {?}
       */
      var mediaQueryStyleNode;
      /**
       * A utility for calling matchMedia queries.
       */
      var MediaMatcher = /*#__PURE__*/function () {
        /**
         * @param {?} _platform
         */
        function MediaMatcher(_platform) {
          _classCallCheck(this, MediaMatcher);
          this._platform = _platform;
          this._matchMedia = this._platform.isBrowser && window.matchMedia ?
          // matchMedia is bound to the window scope intentionally as it is an illegal invocation to
          // call it from a different scope.
          window.matchMedia.bind(window) : noopMatchMedia;
        }
        /**
         * Evaluates the given media query and returns the native MediaQueryList from which results
         * can be retrieved.
         * Confirms the layout engine will trigger for the selector query provided and returns the
         * MediaQueryList for the query provided.
         * @param {?} query
         * @return {?}
         */
        _createClass(MediaMatcher, [{
          key: "matchMedia",
          value: function matchMedia(query) {
            if (this._platform.WEBKIT) {
              createEmptyStyleRule(query);
            }
            return this._matchMedia(query);
          }
        }]);
        return MediaMatcher;
      }();
      MediaMatcher.ɵfac = function MediaMatcher_Factory(t) {
        return new (t || MediaMatcher)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_1__["Platform"]));
      };
      /** @nocollapse */
      MediaMatcher.ctorParameters = function () {
        return [{
          type: _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_1__["Platform"]
        }];
      };
      /** @nocollapse */
      MediaMatcher.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"])({
        factory: function MediaMatcher_Factory() {
          return new MediaMatcher(Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_cdk_platform__WEBPACK_IMPORTED_MODULE_1__["Platform"]));
        },
        token: MediaMatcher,
        providedIn: "root"
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MediaMatcher, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_cdk_platform__WEBPACK_IMPORTED_MODULE_1__["Platform"]
          }];
        }, null);
      })();
      if (false) {}
      /**
       * For Webkit engines that only trigger the MediaQueryListListener when
       * there is at least one CSS selector for the respective media query.
       * @param {?} query
       * @return {?}
       */
      function createEmptyStyleRule(query) {
        if (mediaQueriesForWebkitCompatibility.has(query)) {
          return;
        }
        try {
          if (!mediaQueryStyleNode) {
            mediaQueryStyleNode = document.createElement('style');
            mediaQueryStyleNode.setAttribute('type', 'text/css');
            /** @type {?} */document.head.appendChild(mediaQueryStyleNode);
          }
          if (mediaQueryStyleNode.sheet) {
            /** @type {?} */mediaQueryStyleNode.sheet.insertRule("@media ".concat(query, " {.fx-query-test{ }}"), 0);
            mediaQueriesForWebkitCompatibility.add(query);
          }
        } catch (e) {
          console.error(e);
        }
      }
      /**
       * No-op matchMedia replacement for non-browser platforms.
       * @param {?} query
       * @return {?}
       */
      function noopMatchMedia(query) {
        // Use `as any` here to avoid adding additional necessary properties for
        // the noop matcher.
        return (/** @type {?} */{
            matches: query === 'all' || query === '',
            media: query,
            addListener:
            /**
            * @return {?}
            */
            function addListener() {},
            removeListener:
            /**
            * @return {?}
            */
            function removeListener() {}
          }
        );
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/layout/breakpoints-observer.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      /**
       * The current state of a layout breakpoint.
       * @record
       */
      function BreakpointState() {}
      if (false) {}
      /**
       * The current state of a layout breakpoint.
       * @record
       */
      function InternalBreakpointState() {}
      if (false) {}
      /**
       * @record
       */
      function Query() {}
      if (false) {}
      /**
       * Utility for checking the matching state of \@media queries.
       */
      var BreakpointObserver = /*#__PURE__*/function () {
        /**
         * @param {?} _mediaMatcher
         * @param {?} _zone
         */
        function BreakpointObserver(_mediaMatcher, _zone) {
          _classCallCheck(this, BreakpointObserver);
          this._mediaMatcher = _mediaMatcher;
          this._zone = _zone;
          /**
           * A map of all media queries currently being listened for.
           */
          this._queries = new Map();
          /**
           * A subject for all other observables to takeUntil based on.
           */
          this._destroySubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["Subject"]();
        }
        /**
         * Completes the active subject, signalling to all other observables to complete.
         * @return {?}
         */
        _createClass(BreakpointObserver, [{
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            this._destroySubject.next();
            this._destroySubject.complete();
          }
          /**
           * Whether one or more media queries match the current viewport size.
           * @param {?} value One or more media queries to check.
           * @return {?} Whether any of the media queries match.
           */
        }, {
          key: "isMatched",
          value: function isMatched(value) {
            var _this = this;
            /** @type {?} */
            var queries = splitQueries(Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceArray"])(value));
            return queries.some(
            /**
            * @param {?} mediaQuery
            * @return {?}
            */
            function (mediaQuery) {
              return _this._registerQuery(mediaQuery).mql.matches;
            });
          }
          /**
           * Gets an observable of results for the given queries that will emit new results for any changes
           * in matching of the given queries.
           * @param {?} value One or more media queries to check.
           * @return {?} A stream of matches for the given queries.
           */
        }, {
          key: "observe",
          value: function observe(value) {
            var _this2 = this;
            /** @type {?} */
            var queries = splitQueries(Object(_angular_cdk_coercion__WEBPACK_IMPORTED_MODULE_4__["coerceArray"])(value));
            /** @type {?} */
            var observables = queries.map(
            /**
            * @param {?} query
            * @return {?}
            */
            function (query) {
              return _this2._registerQuery(query).observable;
            });
            /** @type {?} */
            var stateObservable = Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["combineLatest"])(observables);
            // Emit the first state immediately, and then debounce the subsequent emissions.
            stateObservable = Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["concat"])(stateObservable.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["take"])(1)), stateObservable.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["skip"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["debounceTime"])(0)));
            return stateObservable.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(
            /**
            * @param {?} breakpointStates
            * @return {?}
            */
            function (breakpointStates) {
              /** @type {?} */
              var response = {
                matches: false,
                breakpoints: {}
              };
              breakpointStates.forEach(
              /**
              * @param {?} state
              * @return {?}
              */
              function (state) {
                response.matches = response.matches || state.matches;
                response.breakpoints[state.query] = state.matches;
              });
              return response;
            }));
          }
          /**
           * Registers a specific query to be listened for.
           * @private
           * @param {?} query
           * @return {?}
           */
        }, {
          key: "_registerQuery",
          value: function _registerQuery(query) {
            var _this3 = this;
            // Only set up a new MediaQueryList if it is not already being listened for.
            if (this._queries.has(query)) {
              return (/** @type {?} */this._queries.get(query)
              );
            }
            /** @type {?} */
            var mql = this._mediaMatcher.matchMedia(query);
            // Create callback for match changes and add it is as a listener.
            /** @type {?} */
            var queryObservable = new rxjs__WEBPACK_IMPORTED_MODULE_2__["Observable"](
            /**
            * @param {?} observer
            * @return {?}
            */
            function (observer) {
              // Listener callback methods are wrapped to be placed back in ngZone. Callbacks must be placed
              // back into the zone because matchMedia is only included in Zone.js by loading the
              // webapis-media-query.js file alongside the zone.js file.  Additionally, some browsers do not
              // have MediaQueryList inherit from EventTarget, which causes inconsistencies in how Zone.js
              // patches it.
              /** @type {?} */
              var handler =
              /**
              * @param {?} e
              * @return {?}
              */
              function handler(e) {
                return _this3._zone.run(
                /**
                * @return {?}
                */
                function () {
                  return observer.next(e);
                });
              };
              mql.addListener(handler);
              return (
                /**
                * @return {?}
                */
                function () {
                  mql.removeListener(handler);
                }
              );
            }).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["startWith"])(mql), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(
            /**
            * @param {?} nextMql
            * @return {?}
            */
            function (nextMql) {
              return {
                query: query,
                matches: nextMql.matches
              };
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeUntil"])(this._destroySubject));
            // Add the MediaQueryList to the set of queries.
            /** @type {?} */
            var output = {
              observable: queryObservable,
              mql: mql
            };
            this._queries.set(query, output);
            return output;
          }
        }]);
        return BreakpointObserver;
      }();
      BreakpointObserver.ɵfac = function BreakpointObserver_Factory(t) {
        return new (t || BreakpointObserver)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](MediaMatcher), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]));
      };
      /** @nocollapse */
      BreakpointObserver.ctorParameters = function () {
        return [{
          type: MediaMatcher
        }, {
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
        }];
      };
      /** @nocollapse */
      BreakpointObserver.ɵprov = Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"])({
        factory: function BreakpointObserver_Factory() {
          return new BreakpointObserver(Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(MediaMatcher), Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"])(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]));
        },
        token: BreakpointObserver,
        providedIn: "root"
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BreakpointObserver, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: MediaMatcher
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"]
          }];
        }, null);
      })();
      if (false) {}
      /**
       * Split each query string into separate query strings if two queries are provided as comma
       * separated.
       * @param {?} queries
       * @return {?}
       */
      function splitQueries(queries) {
        return queries.map(
        /**
        * @param {?} query
        * @return {?}
        */
        function (query) {
          return query.split(',');
        }).reduce(
        /**
        * @param {?} a1
        * @param {?} a2
        * @return {?}
        */
        function (a1, a2) {
          return a1.concat(a2);
        }).map(
        /**
        * @param {?} query
        * @return {?}
        */
        function (query) {
          return query.trim();
        });
      }

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/layout/breakpoints.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */
      // PascalCase is being used as Breakpoints is used like an enum.
      // tslint:disable-next-line:variable-name
      /**
       * @license
       * Copyright Google LLC All Rights Reserved.
       *
       * Use of this source code is governed by an MIT-style license that can be
       * found in the LICENSE file at https://angular.io/license
       * @type {?}
       */
      var Breakpoints = {
        XSmall: '(max-width: 599.99px)',
        Small: '(min-width: 600px) and (max-width: 959.99px)',
        Medium: '(min-width: 960px) and (max-width: 1279.99px)',
        Large: '(min-width: 1280px) and (max-width: 1919.99px)',
        XLarge: '(min-width: 1920px)',
        Handset: '(max-width: 599.99px) and (orientation: portrait), ' + '(max-width: 959.99px) and (orientation: landscape)',
        Tablet: '(min-width: 600px) and (max-width: 839.99px) and (orientation: portrait), ' + '(min-width: 960px) and (max-width: 1279.99px) and (orientation: landscape)',
        Web: '(min-width: 840px) and (orientation: portrait), ' + '(min-width: 1280px) and (orientation: landscape)',
        HandsetPortrait: '(max-width: 599.99px) and (orientation: portrait)',
        TabletPortrait: '(min-width: 600px) and (max-width: 839.99px) and (orientation: portrait)',
        WebPortrait: '(min-width: 840px) and (orientation: portrait)',
        HandsetLandscape: '(max-width: 959.99px) and (orientation: landscape)',
        TabletLandscape: '(min-width: 960px) and (max-width: 1279.99px) and (orientation: landscape)',
        WebLandscape: '(min-width: 1280px) and (orientation: landscape)'
      };

      /**
       * @fileoverview added by tsickle
       * Generated from: src/cdk/layout/public-api.ts
       * @suppress {checkTypes,constantProperty,extraRequire,missingOverride,missingReturn,unusedPrivateMembers,uselessCode} checked by tsc
       */

      /**
       * Generated bundle index. Do not edit.
       */

      //# sourceMappingURL=layout.js.map

      /***/
    }
  }]);
})();
//# sourceMappingURL=default~data-table-paginator-paginator-module~data-table-table-tables-module~navigation-sidenav-side~36c27659-es5.js.map