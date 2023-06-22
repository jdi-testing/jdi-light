(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["layout-divider-divider-module"], {
    /***/"./src/app/layout/divider/divider-overview-example.ts":
    /*!************************************************************!*\
      !*** ./src/app/layout/divider/divider-overview-example.ts ***!
      \************************************************************/
    /*! exports provided: DividerOverviewExample */
    /***/
    function srcAppLayoutDividerDividerOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DividerOverviewExample", function () {
        return DividerOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
      /* harmony import */
      var _angular_material_divider__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/material/divider */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/divider.js");

      /**
       * @title Basic divider
       */
      var DividerOverviewExample = /*#__PURE__*/_createClass(function DividerOverviewExample() {
        _classCallCheck(this, DividerOverviewExample);
      });
      DividerOverviewExample.ɵfac = function DividerOverviewExample_Factory(t) {
        return new (t || DividerOverviewExample)();
      };
      DividerOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: DividerOverviewExample,
        selectors: [["divider-overview-example"]],
        decls: 12,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/divider/overview"], ["id", "divider-list"]],
        template: function DividerOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic divider ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-list", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-list-item");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Item 1");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "mat-divider");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-list-item");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Item 2");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "mat-divider");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "mat-list-item");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Item 3");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatList"], _angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatListItem"], _angular_material_divider__WEBPACK_IMPORTED_MODULE_2__["MatDivider"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbGF5b3V0L2RpdmlkZXIvZGl2aWRlci1vdmVydmlldy1leGFtcGxlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSw2QkFBNkIiLCJmaWxlIjoic3JjL2FwcC9sYXlvdXQvZGl2aWRlci9kaXZpZGVyLW92ZXJ2aWV3LWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyoqIE5vIENTUyBmb3IgdGhpcyBleGFtcGxlICovXHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DividerOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'divider-overview-example',
            templateUrl: 'divider-overview-example.html',
            styleUrls: ['divider-overview-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/divider/divider-routing.module.ts":
    /*!**********************************************************!*\
      !*** ./src/app/layout/divider/divider-routing.module.ts ***!
      \**********************************************************/
    /*! exports provided: DividerRoutingModule */
    /***/
    function srcAppLayoutDividerDividerRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DividerRoutingModule", function () {
        return DividerRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _divider_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./divider-overview-example */"./src/app/layout/divider/divider-overview-example.ts");
      var routes = [{
        path: '',
        component: _divider_overview_example__WEBPACK_IMPORTED_MODULE_2__["DividerOverviewExample"]
      }];
      var DividerRoutingModule = /*#__PURE__*/_createClass(function DividerRoutingModule() {
        _classCallCheck(this, DividerRoutingModule);
      });
      DividerRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: DividerRoutingModule
      });
      DividerRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function DividerRoutingModule_Factory(t) {
          return new (t || DividerRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](DividerRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DividerRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/divider/divider.module.ts":
    /*!**************************************************!*\
      !*** ./src/app/layout/divider/divider.module.ts ***!
      \**************************************************/
    /*! exports provided: DividerModule */
    /***/
    function srcAppLayoutDividerDividerModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "DividerModule", function () {
        return DividerModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _divider_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./divider-routing.module */"./src/app/layout/divider/divider-routing.module.ts");
      /* harmony import */
      var _divider_overview_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./divider-overview-example */"./src/app/layout/divider/divider-overview-example.ts");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
      var DividerModule = /*#__PURE__*/_createClass(function DividerModule() {
        _classCallCheck(this, DividerModule);
      });
      DividerModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: DividerModule
      });
      DividerModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function DividerModule_Factory(t) {
          return new (t || DividerModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _divider_routing_module__WEBPACK_IMPORTED_MODULE_2__["DividerRoutingModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_4__["MatListModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](DividerModule, {
          declarations: [_divider_overview_example__WEBPACK_IMPORTED_MODULE_3__["DividerOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _divider_routing_module__WEBPACK_IMPORTED_MODULE_2__["DividerRoutingModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_4__["MatListModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DividerModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_divider_overview_example__WEBPACK_IMPORTED_MODULE_3__["DividerOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _divider_routing_module__WEBPACK_IMPORTED_MODULE_2__["DividerRoutingModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_4__["MatListModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=layout-divider-divider-module-es5.js.map