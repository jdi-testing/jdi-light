(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["navigation-toolbar-toolbar-module"], {
    /***/"./src/app/navigation/toolbar/components/toolbar-multirow-example.ts":
    /*!***************************************************************************!*\
      !*** ./src/app/navigation/toolbar/components/toolbar-multirow-example.ts ***!
      \***************************************************************************/
    /*! exports provided: ToolbarMultirowExample */
    /***/
    function srcAppNavigationToolbarComponentsToolbarMultirowExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ToolbarMultirowExample", function () {
        return ToolbarMultirowExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/toolbar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/toolbar.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");

      /**
       * @title Multi-row toolbar
       */
      var ToolbarMultirowExample = /*#__PURE__*/_createClass(function ToolbarMultirowExample() {
        _classCallCheck(this, ToolbarMultirowExample);
      });
      ToolbarMultirowExample.ɵfac = function ToolbarMultirowExample_Factory(t) {
        return new (t || ToolbarMultirowExample)();
      };
      ToolbarMultirowExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ToolbarMultirowExample,
        selectors: [["toolbar-multirow-example"]],
        decls: 20,
        vars: 0,
        consts: [[1, "example-h2"], ["id", "toolbar-table", "color", "primary"], [1, "example-spacer"], ["aria-hidden", "false", "aria-label", "Example user verified icon", 1, "example-icon"], ["aria-hidden", "false", "aria-label", "Example heart icon", 1, "example-icon"], ["aria-hidden", "false", "aria-label", "Example delete icon", 1, "example-icon"]],
        template: function ToolbarMultirowExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Multi-row toolbar");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-toolbar", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-toolbar-row");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Custom Toolbar");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-toolbar-row");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Second Line");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "mat-icon", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "verified_user");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "mat-toolbar-row");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "span");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Third Line");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "span", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "mat-icon", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "favorite");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "mat-icon", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "delete");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__["MatToolbar"], _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__["MatToolbarRow"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_2__["MatIcon"]],
        styles: [".example-icon[_ngcontent-%COMP%] {\r\n  padding: 0 14px;\r\n}\r\n\r\n.example-spacer[_ngcontent-%COMP%] {\r\n  flex: 1 1 auto;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbmF2aWdhdGlvbi90b29sYmFyL2NvbXBvbmVudHMvdG9vbGJhci1tdWx0aXJvdy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGVBQWU7QUFDakI7O0FBRUE7RUFDRSxjQUFjO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvbmF2aWdhdGlvbi90b29sYmFyL2NvbXBvbmVudHMvdG9vbGJhci1tdWx0aXJvdy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLWljb24ge1xyXG4gIHBhZGRpbmc6IDAgMTRweDtcclxufVxyXG5cclxuLmV4YW1wbGUtc3BhY2VyIHtcclxuICBmbGV4OiAxIDEgYXV0bztcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ToolbarMultirowExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'toolbar-multirow-example',
            templateUrl: 'toolbar-multirow-example.html',
            styleUrls: ['toolbar-multirow-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/toolbar/components/toolbar-overview-example.ts":
    /*!***************************************************************************!*\
      !*** ./src/app/navigation/toolbar/components/toolbar-overview-example.ts ***!
      \***************************************************************************/
    /*! exports provided: ToolbarOverviewExample */
    /***/
    function srcAppNavigationToolbarComponentsToolbarOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ToolbarOverviewExample", function () {
        return ToolbarOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/toolbar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/toolbar.js");

      /**
       * @title Basic toolbar
       */
      var ToolbarOverviewExample = /*#__PURE__*/_createClass(function ToolbarOverviewExample() {
        _classCallCheck(this, ToolbarOverviewExample);
      });
      ToolbarOverviewExample.ɵfac = function ToolbarOverviewExample_Factory(t) {
        return new (t || ToolbarOverviewExample)();
      };
      ToolbarOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ToolbarOverviewExample,
        selectors: [["toolbar-overview-example"]],
        decls: 5,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/toolbar/overview"], ["id", "toolbar-basic"]],
        template: function ToolbarOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic toolbar ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-toolbar", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "My App");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__["MatToolbar"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ToolbarOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'toolbar-overview-example',
            templateUrl: 'toolbar-overview-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/toolbar/toolbar-routing.module.ts":
    /*!**************************************************************!*\
      !*** ./src/app/navigation/toolbar/toolbar-routing.module.ts ***!
      \**************************************************************/
    /*! exports provided: ToolbarRoutingModule */
    /***/
    function srcAppNavigationToolbarToolbarRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ToolbarRoutingModule", function () {
        return ToolbarRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _toolbar_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./toolbar.component */"./src/app/navigation/toolbar/toolbar.component.ts");
      var routes = [{
        path: '',
        component: _toolbar_component__WEBPACK_IMPORTED_MODULE_2__["ToolbarComponent"]
      }];
      var ToolbarRoutingModule = /*#__PURE__*/_createClass(function ToolbarRoutingModule() {
        _classCallCheck(this, ToolbarRoutingModule);
      });
      ToolbarRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ToolbarRoutingModule
      });
      ToolbarRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ToolbarRoutingModule_Factory(t) {
          return new (t || ToolbarRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ToolbarRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ToolbarRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/toolbar/toolbar.component.ts":
    /*!*********************************************************!*\
      !*** ./src/app/navigation/toolbar/toolbar.component.ts ***!
      \*********************************************************/
    /*! exports provided: ToolbarComponent */
    /***/
    function srcAppNavigationToolbarToolbarComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ToolbarComponent", function () {
        return ToolbarComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_toolbar_multirow_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/toolbar-multirow-example */"./src/app/navigation/toolbar/components/toolbar-multirow-example.ts");
      /* harmony import */
      var _components_toolbar_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/toolbar-overview-example */"./src/app/navigation/toolbar/components/toolbar-overview-example.ts");
      var ToolbarComponent = /*#__PURE__*/_createClass(function ToolbarComponent() {
        _classCallCheck(this, ToolbarComponent);
      });
      ToolbarComponent.ɵfac = function ToolbarComponent_Factory(t) {
        return new (t || ToolbarComponent)();
      };
      ToolbarComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ToolbarComponent,
        selectors: [["app-toolbar"]],
        decls: 2,
        vars: 0,
        template: function ToolbarComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "toolbar-multirow-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "toolbar-overview-example");
          }
        },
        directives: [_components_toolbar_multirow_example__WEBPACK_IMPORTED_MODULE_1__["ToolbarMultirowExample"], _components_toolbar_overview_example__WEBPACK_IMPORTED_MODULE_2__["ToolbarOverviewExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ToolbarComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-toolbar',
            templateUrl: './toolbar.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/navigation/toolbar/toolbar.module.ts":
    /*!******************************************************!*\
      !*** ./src/app/navigation/toolbar/toolbar.module.ts ***!
      \******************************************************/
    /*! exports provided: ToolbarModule */
    /***/
    function srcAppNavigationToolbarToolbarModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ToolbarModule", function () {
        return ToolbarModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _toolbar_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./toolbar-routing.module */"./src/app/navigation/toolbar/toolbar-routing.module.ts");
      /* harmony import */
      var _toolbar_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./toolbar.component */"./src/app/navigation/toolbar/toolbar.component.ts");
      /* harmony import */
      var _components_toolbar_multirow_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/toolbar-multirow-example */"./src/app/navigation/toolbar/components/toolbar-multirow-example.ts");
      /* harmony import */
      var _components_toolbar_overview_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/toolbar-overview-example */"./src/app/navigation/toolbar/components/toolbar-overview-example.ts");
      /* harmony import */
      var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/toolbar */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/toolbar.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      var ToolbarModule = /*#__PURE__*/_createClass(function ToolbarModule() {
        _classCallCheck(this, ToolbarModule);
      });
      ToolbarModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ToolbarModule
      });
      ToolbarModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ToolbarModule_Factory(t) {
          return new (t || ToolbarModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _toolbar_routing_module__WEBPACK_IMPORTED_MODULE_2__["ToolbarRoutingModule"], _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_6__["MatToolbarModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ToolbarModule, {
          declarations: [_toolbar_component__WEBPACK_IMPORTED_MODULE_3__["ToolbarComponent"], _components_toolbar_multirow_example__WEBPACK_IMPORTED_MODULE_4__["ToolbarMultirowExample"], _components_toolbar_overview_example__WEBPACK_IMPORTED_MODULE_5__["ToolbarOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _toolbar_routing_module__WEBPACK_IMPORTED_MODULE_2__["ToolbarRoutingModule"], _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_6__["MatToolbarModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ToolbarModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_toolbar_component__WEBPACK_IMPORTED_MODULE_3__["ToolbarComponent"], _components_toolbar_multirow_example__WEBPACK_IMPORTED_MODULE_4__["ToolbarMultirowExample"], _components_toolbar_overview_example__WEBPACK_IMPORTED_MODULE_5__["ToolbarOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _toolbar_routing_module__WEBPACK_IMPORTED_MODULE_2__["ToolbarRoutingModule"], _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_6__["MatToolbarModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=navigation-toolbar-toolbar-module-es5.js.map