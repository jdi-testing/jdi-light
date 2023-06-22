(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["data-table-sort-header-sort-header-module"], {
    /***/"./src/app/data-table/sort-header/sort-header-routing.module.ts":
    /*!**********************************************************************!*\
      !*** ./src/app/data-table/sort-header/sort-header-routing.module.ts ***!
      \**********************************************************************/
    /*! exports provided: SortHeaderRoutingModule */
    /***/
    function srcAppDataTableSortHeaderSortHeaderRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SortHeaderRoutingModule", function () {
        return SortHeaderRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _sort_overview_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./sort-overview-example */"./src/app/data-table/sort-header/sort-overview-example.ts");
      var routes = [{
        path: '',
        component: _sort_overview_example__WEBPACK_IMPORTED_MODULE_2__["SortOverviewExample"]
      }];
      var SortHeaderRoutingModule = /*#__PURE__*/_createClass(function SortHeaderRoutingModule() {
        _classCallCheck(this, SortHeaderRoutingModule);
      });
      SortHeaderRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SortHeaderRoutingModule
      });
      SortHeaderRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SortHeaderRoutingModule_Factory(t) {
          return new (t || SortHeaderRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SortHeaderRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SortHeaderRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/sort-header/sort-header.module.ts":
    /*!**************************************************************!*\
      !*** ./src/app/data-table/sort-header/sort-header.module.ts ***!
      \**************************************************************/
    /*! exports provided: SortHeaderModule */
    /***/
    function srcAppDataTableSortHeaderSortHeaderModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SortHeaderModule", function () {
        return SortHeaderModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _sort_header_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./sort-header-routing.module */"./src/app/data-table/sort-header/sort-header-routing.module.ts");
      /* harmony import */
      var _sort_overview_example__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./sort-overview-example */"./src/app/data-table/sort-header/sort-overview-example.ts");
      /* harmony import */
      var _angular_material_sort__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/sort */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
      var SortHeaderModule = /*#__PURE__*/_createClass(function SortHeaderModule() {
        _classCallCheck(this, SortHeaderModule);
      });
      SortHeaderModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: SortHeaderModule
      });
      SortHeaderModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function SortHeaderModule_Factory(t) {
          return new (t || SortHeaderModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _sort_header_routing_module__WEBPACK_IMPORTED_MODULE_2__["SortHeaderRoutingModule"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_4__["MatSortModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](SortHeaderModule, {
          declarations: [_sort_overview_example__WEBPACK_IMPORTED_MODULE_3__["SortOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _sort_header_routing_module__WEBPACK_IMPORTED_MODULE_2__["SortHeaderRoutingModule"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_4__["MatSortModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SortHeaderModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_sort_overview_example__WEBPACK_IMPORTED_MODULE_3__["SortOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _sort_header_routing_module__WEBPACK_IMPORTED_MODULE_2__["SortHeaderRoutingModule"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_4__["MatSortModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/data-table/sort-header/sort-overview-example.ts":
    /*!*****************************************************************!*\
      !*** ./src/app/data-table/sort-header/sort-overview-example.ts ***!
      \*****************************************************************/
    /*! exports provided: SortOverviewExample */
    /***/
    function srcAppDataTableSortHeaderSortOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "SortOverviewExample", function () {
        return SortOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_sort__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/sort */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      function SortOverviewExample_tr_16_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "td");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "td");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "td");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "td");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var dessert_r33 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](dessert_r33.name);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](dessert_r33.calories);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](dessert_r33.fat);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](dessert_r33.carbs);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](dessert_r33.protein);
        }
      }
      /**
       * @title Sorting overview
       */
      var SortOverviewExample = /*#__PURE__*/function () {
        function SortOverviewExample() {
          _classCallCheck(this, SortOverviewExample);
          this.desserts = [{
            name: 'Frozen yogurt',
            calories: 159,
            fat: 6,
            carbs: 24,
            protein: 4
          }, {
            name: 'Ice cream sandwich',
            calories: 237,
            fat: 9,
            carbs: 37,
            protein: 4
          }, {
            name: 'Eclair',
            calories: 262,
            fat: 16,
            carbs: 24,
            protein: 6
          }, {
            name: 'Cupcake',
            calories: 305,
            fat: 4,
            carbs: 67,
            protein: 4
          }, {
            name: 'Gingerbread',
            calories: 356,
            fat: 16,
            carbs: 49,
            protein: 4
          }];
          this.sortedData = this.desserts.slice();
        }
        _createClass(SortOverviewExample, [{
          key: "sortData",
          value: function sortData(sort) {
            var data = this.desserts.slice();
            if (!sort.active || sort.direction === '') {
              this.sortedData = data;
              return;
            }
            this.sortedData = data.sort(function (a, b) {
              var isAsc = sort.direction === 'asc';
              switch (sort.active) {
                case 'name':
                  return compare(a.name, b.name, isAsc);
                case 'calories':
                  return compare(a.calories, b.calories, isAsc);
                case 'fat':
                  return compare(a.fat, b.fat, isAsc);
                case 'carbs':
                  return compare(a.carbs, b.carbs, isAsc);
                case 'protein':
                  return compare(a.protein, b.protein, isAsc);
                default:
                  return 0;
              }
            });
          }
        }]);
        return SortOverviewExample;
      }();
      SortOverviewExample.ɵfac = function SortOverviewExample_Factory(t) {
        return new (t || SortOverviewExample)();
      };
      SortOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: SortOverviewExample,
        selectors: [["sort-overview-example"]],
        decls: 17,
        vars: 1,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/sort/overview"], ["matSort", "", "id", "sort-headers", 3, "matSortChange"], ["mat-sort-header", "name"], ["mat-sort-header", "calories"], ["mat-sort-header", "fat"], ["mat-sort-header", "carbs"], ["mat-sort-header", "protein"], [4, "ngFor", "ngForOf"]],
        template: function SortOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Sorting overview ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "br");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "table", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("matSortChange", function SortOverviewExample_Template_table_matSortChange_4_listener($event) {
              return ctx.sortData($event);
            });
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "tr");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "th", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Dessert (100g)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "th", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "Calories");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "th", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Fat (g)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "th", 6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "Carbs (g)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "th", 7);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "Protein (g)");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, SortOverviewExample_tr_16_Template, 11, 5, "tr", 8);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](16);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.sortedData);
          }
        },
        directives: [_angular_material_sort__WEBPACK_IMPORTED_MODULE_1__["MatSort"], _angular_material_sort__WEBPACK_IMPORTED_MODULE_1__["MatSortHeader"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["NgForOf"]],
        styles: [".mat-sort-header-container[_ngcontent-%COMP%] {\r\n  align-items: center;\r\n}\r\n\r\ntd[_ngcontent-%COMP%] {\r\n  padding-right: 15px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZGF0YS10YWJsZS9zb3J0LWhlYWRlci9zb3J0LW92ZXJ2aWV3LWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsbUJBQW1CO0FBQ3JCOztBQUVBO0VBQ0UsbUJBQW1CO0FBQ3JCIiwiZmlsZSI6InNyYy9hcHAvZGF0YS10YWJsZS9zb3J0LWhlYWRlci9zb3J0LW92ZXJ2aWV3LWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC1zb3J0LWhlYWRlci1jb250YWluZXIge1xyXG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XHJcbn1cclxuXHJcbnRkIHtcclxuICBwYWRkaW5nLXJpZ2h0OiAxNXB4O1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SortOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'sort-overview-example',
            templateUrl: 'sort-overview-example.html',
            styleUrls: ['sort-overview-example.css']
          }]
        }], function () {
          return [];
        }, null);
      })();
      function compare(a, b, isAsc) {
        return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
      }

      /***/
    }
  }]);
})();
//# sourceMappingURL=data-table-sort-header-sort-header-module-es5.js.map