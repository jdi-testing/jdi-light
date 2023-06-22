(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["buttons-and-indicators-icon-icons-module"], {
    /***/"./src/app/buttons-and-indicators/icon/components/icon-overview-example.ts":
    /*!*********************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/icon/components/icon-overview-example.ts ***!
      \*********************************************************************************/
    /*! exports provided: IconOverviewExample */
    /***/
    function srcAppButtonsAndIndicatorsIconComponentsIconOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "IconOverviewExample", function () {
        return IconOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");

      /**
       * @title Basic icons
       */
      var IconOverviewExample = /*#__PURE__*/_createClass(function IconOverviewExample() {
        _classCallCheck(this, IconOverviewExample);
      });
      IconOverviewExample.ɵfac = function IconOverviewExample_Factory(t) {
        return new (t || IconOverviewExample)();
      };
      IconOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: IconOverviewExample,
        selectors: [["icon-overview-example"]],
        decls: 5,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/icon/overview"], ["aria-hidden", "false", "id", "basic_icon", "aria-label", "Example home icon"]],
        template: function IconOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic icon ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-icon", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "home");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_icon__WEBPACK_IMPORTED_MODULE_1__["MatIcon"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](IconOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'icon-overview-example',
            templateUrl: 'icon-overview-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/icon/components/icon-svg-example.ts":
    /*!****************************************************************************!*\
      !*** ./src/app/buttons-and-indicators/icon/components/icon-svg-example.ts ***!
      \****************************************************************************/
    /*! exports provided: IconSvgExample */
    /***/
    function srcAppButtonsAndIndicatorsIconComponentsIconSvgExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "IconSvgExample", function () {
        return IconSvgExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      /* harmony import */
      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/platform-browser */"./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js");

      /**
       * @title SVG icons
       */
      var IconSvgExample = /*#__PURE__*/_createClass(function IconSvgExample(iconRegistry, sanitizer) {
        _classCallCheck(this, IconSvgExample);
        iconRegistry.addSvgIcon('thumbs-up', sanitizer.bypassSecurityTrustResourceUrl('./angular/assets/img/examples/thumbup_icon.svg'));
      });
      IconSvgExample.ɵfac = function IconSvgExample_Factory(t) {
        return new (t || IconSvgExample)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_icon__WEBPACK_IMPORTED_MODULE_1__["MatIconRegistry"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__["DomSanitizer"]));
      };
      IconSvgExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: IconSvgExample,
        selectors: [["icon-svg-example"]],
        decls: 4,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/icon/overview#svg-icons"], ["svgIcon", "thumbs-up", "aria-hidden", "false", "id", "svg_icon", "aria-label", "Example thumbs up SVG icon"]],
        template: function IconSvgExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " SVG icon ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "mat-icon", 2);
          }
        },
        directives: [_angular_material_icon__WEBPACK_IMPORTED_MODULE_1__["MatIcon"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](IconSvgExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'icon-svg-example',
            templateUrl: 'icon-svg-example.html'
          }]
        }], function () {
          return [{
            type: _angular_material_icon__WEBPACK_IMPORTED_MODULE_1__["MatIconRegistry"]
          }, {
            type: _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__["DomSanitizer"]
          }];
        }, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/icon/icons-routing.module.ts":
    /*!*********************************************************************!*\
      !*** ./src/app/buttons-and-indicators/icon/icons-routing.module.ts ***!
      \*********************************************************************/
    /*! exports provided: IconsRoutingModule */
    /***/
    function srcAppButtonsAndIndicatorsIconIconsRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "IconsRoutingModule", function () {
        return IconsRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _icons_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./icons.component */"./src/app/buttons-and-indicators/icon/icons.component.ts");
      var routes = [{
        path: '',
        component: _icons_component__WEBPACK_IMPORTED_MODULE_2__["IconsComponent"]
      }];
      var IconsRoutingModule = /*#__PURE__*/_createClass(function IconsRoutingModule() {
        _classCallCheck(this, IconsRoutingModule);
      });
      IconsRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: IconsRoutingModule
      });
      IconsRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function IconsRoutingModule_Factory(t) {
          return new (t || IconsRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](IconsRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](IconsRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/icon/icons.component.ts":
    /*!****************************************************************!*\
      !*** ./src/app/buttons-and-indicators/icon/icons.component.ts ***!
      \****************************************************************/
    /*! exports provided: IconsComponent */
    /***/
    function srcAppButtonsAndIndicatorsIconIconsComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "IconsComponent", function () {
        return IconsComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_icon_overview_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/icon-overview-example */"./src/app/buttons-and-indicators/icon/components/icon-overview-example.ts");
      /* harmony import */
      var _components_icon_svg_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/icon-svg-example */"./src/app/buttons-and-indicators/icon/components/icon-svg-example.ts");
      var IconsComponent = /*#__PURE__*/_createClass(function IconsComponent() {
        _classCallCheck(this, IconsComponent);
      });
      IconsComponent.ɵfac = function IconsComponent_Factory(t) {
        return new (t || IconsComponent)();
      };
      IconsComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: IconsComponent,
        selectors: [["app-icons"]],
        decls: 2,
        vars: 0,
        template: function IconsComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "icon-overview-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "icon-svg-example");
          }
        },
        directives: [_components_icon_overview_example__WEBPACK_IMPORTED_MODULE_1__["IconOverviewExample"], _components_icon_svg_example__WEBPACK_IMPORTED_MODULE_2__["IconSvgExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](IconsComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-icons',
            templateUrl: './icons.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/buttons-and-indicators/icon/icons.module.ts":
    /*!*************************************************************!*\
      !*** ./src/app/buttons-and-indicators/icon/icons.module.ts ***!
      \*************************************************************/
    /*! exports provided: IconsModule */
    /***/
    function srcAppButtonsAndIndicatorsIconIconsModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "IconsModule", function () {
        return IconsModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _icons_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./icons-routing.module */"./src/app/buttons-and-indicators/icon/icons-routing.module.ts");
      /* harmony import */
      var _icons_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./icons.component */"./src/app/buttons-and-indicators/icon/icons.component.ts");
      /* harmony import */
      var _components_icon_overview_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/icon-overview-example */"./src/app/buttons-and-indicators/icon/components/icon-overview-example.ts");
      /* harmony import */
      var _components_icon_svg_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/icon-svg-example */"./src/app/buttons-and-indicators/icon/components/icon-svg-example.ts");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      var IconsModule = /*#__PURE__*/_createClass(function IconsModule() {
        _classCallCheck(this, IconsModule);
      });
      IconsModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: IconsModule
      });
      IconsModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function IconsModule_Factory(t) {
          return new (t || IconsModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _icons_routing_module__WEBPACK_IMPORTED_MODULE_2__["IconsRoutingModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_6__["MatIconModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](IconsModule, {
          declarations: [_icons_component__WEBPACK_IMPORTED_MODULE_3__["IconsComponent"], _components_icon_overview_example__WEBPACK_IMPORTED_MODULE_4__["IconOverviewExample"], _components_icon_svg_example__WEBPACK_IMPORTED_MODULE_5__["IconSvgExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _icons_routing_module__WEBPACK_IMPORTED_MODULE_2__["IconsRoutingModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_6__["MatIconModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](IconsModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_icons_component__WEBPACK_IMPORTED_MODULE_3__["IconsComponent"], _components_icon_overview_example__WEBPACK_IMPORTED_MODULE_4__["IconOverviewExample"], _components_icon_svg_example__WEBPACK_IMPORTED_MODULE_5__["IconSvgExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _icons_routing_module__WEBPACK_IMPORTED_MODULE_2__["IconsRoutingModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_6__["MatIconModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=buttons-and-indicators-icon-icons-module-es5.js.map