(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["layout-list-list-module"], {
    /***/"./src/app/layout/list/components/list-overview-example.ts":
    /*!*****************************************************************!*\
      !*** ./src/app/layout/list/components/list-overview-example.ts ***!
      \*****************************************************************/
    /*! exports provided: ListOverviewExample */
    /***/
    function srcAppLayoutListComponentsListOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ListOverviewExample", function () {
        return ListOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");

      /**
       * @title Basic list
       */
      var ListOverviewExample = /*#__PURE__*/_createClass(function ListOverviewExample() {
        _classCallCheck(this, ListOverviewExample);
      });
      ListOverviewExample.ɵfac = function ListOverviewExample_Factory(t) {
        return new (t || ListOverviewExample)();
      };
      ListOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ListOverviewExample,
        selectors: [["list-overview-example"]],
        decls: 10,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/list/overview"], ["id", "basic-list", "role", "list"], ["id", "basic-list-item-1", "role", "listitem"], ["id", "basic-list-item-2", "role", "listitem"], ["id", "basic-list-item-3", "role", "listitem"]],
        template: function ListOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic list ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-list", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "mat-list-item", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Item 1");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "mat-list-item", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Item 2");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "mat-list-item", 5);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "Item 3");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatList"], _angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatListItem"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbGF5b3V0L2xpc3QvY29tcG9uZW50cy9saXN0LW92ZXJ2aWV3LWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLDZCQUE2QiIsImZpbGUiOiJzcmMvYXBwL2xheW91dC9saXN0L2NvbXBvbmVudHMvbGlzdC1vdmVydmlldy1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qKiBObyBDU1MgZm9yIHRoaXMgZXhhbXBsZSAqL1xyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'list-overview-example',
            templateUrl: 'list-overview-example.html',
            styleUrls: ['list-overview-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/list/components/list-sections-example.ts":
    /*!*****************************************************************!*\
      !*** ./src/app/layout/list/components/list-sections-example.ts ***!
      \*****************************************************************/
    /*! exports provided: ListSectionsExample */
    /***/
    function srcAppLayoutListComponentsListSectionsExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ListSectionsExample", function () {
        return ListSectionsExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _angular_material_divider__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! @angular/material/divider */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/divider.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      /* harmony import */
      var _angular_material_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! @angular/material/core */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
      function ListSectionsExample_mat_list_item_6_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-list-item", 5);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "mat-icon", 6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "folder");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "date");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var folder_r382 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("id", "list-with-section-items-" + folder_r382.name.toLowerCase());
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](folder_r382.name);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 3, folder_r382.updated), " ");
        }
      }
      function ListSectionsExample_mat_list_item_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-list-item", 5);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "mat-icon", 6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "note");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 7);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "date");
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
        if (rf & 2) {
          var note_r383 = ctx.$implicit;
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("id", "list-with-section-items-" + note_r383.name.toLowerCase().replace(" ", "-"));
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](note_r383.name);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 3, note_r383.updated), " ");
        }
      }
      /**
       * @title List with sections
       */
      var ListSectionsExample = /*#__PURE__*/_createClass(function ListSectionsExample() {
        _classCallCheck(this, ListSectionsExample);
        this.folders = [{
          name: 'Photos',
          updated: new Date('1/1/16')
        }, {
          name: 'Recipes',
          updated: new Date('1/17/16')
        }, {
          name: 'Work',
          updated: new Date('1/28/16')
        }];
        this.notes = [{
          name: 'Vacation Itinerary',
          updated: new Date('2/20/16')
        }, {
          name: 'Kitchen Remodel',
          updated: new Date('1/18/16')
        }];
      });
      ListSectionsExample.ɵfac = function ListSectionsExample_Factory(t) {
        return new (t || ListSectionsExample)();
      };
      ListSectionsExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ListSectionsExample,
        selectors: [["list-sections-example"]],
        decls: 11,
        vars: 2,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/list/overview#lists-with-multiple-sections"], ["id", "list-with-sections"], ["mat-subheader", ""], [3, "id", 4, "ngFor", "ngForOf"], [3, "id"], ["mat-list-icon", ""], ["mat-line", ""]],
        template: function ListSectionsExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " List with sections ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-list", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Folders");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, ListSectionsExample_mat_list_item_6_Template, 8, 5, "mat-list-item", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "mat-divider");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "Notes");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, ListSectionsExample_mat_list_item_10_Template, 8, 5, "mat-list-item", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.folders);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.notes);
          }
        },
        directives: [_angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatList"], _angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatListSubheaderCssMatStyler"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["NgForOf"], _angular_material_divider__WEBPACK_IMPORTED_MODULE_3__["MatDivider"], _angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatListItem"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_4__["MatIcon"], _angular_material_list__WEBPACK_IMPORTED_MODULE_1__["MatListIconCssMatStyler"], _angular_material_core__WEBPACK_IMPORTED_MODULE_5__["MatLine"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["DatePipe"]],
        styles: [".mat-list-icon[_ngcontent-%COMP%] {\r\n  color: rgba(0, 0, 0, 0.54);\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbGF5b3V0L2xpc3QvY29tcG9uZW50cy9saXN0LXNlY3Rpb25zLWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsMEJBQTBCO0FBQzVCIiwiZmlsZSI6InNyYy9hcHAvbGF5b3V0L2xpc3QvY29tcG9uZW50cy9saXN0LXNlY3Rpb25zLWV4YW1wbGUuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC1saXN0LWljb24ge1xyXG4gIGNvbG9yOiByZ2JhKDAsIDAsIDAsIDAuNTQpO1xyXG59XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListSectionsExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'list-sections-example',
            styleUrls: ['list-sections-example.css'],
            templateUrl: 'list-sections-example.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/list/list-routing.module.ts":
    /*!****************************************************!*\
      !*** ./src/app/layout/list/list-routing.module.ts ***!
      \****************************************************/
    /*! exports provided: ListRoutingModule */
    /***/
    function srcAppLayoutListListRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ListRoutingModule", function () {
        return ListRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./list.component */"./src/app/layout/list/list.component.ts");
      var routes = [{
        path: '',
        component: _list_component__WEBPACK_IMPORTED_MODULE_2__["ListComponent"]
      }];
      var ListRoutingModule = /*#__PURE__*/_createClass(function ListRoutingModule() {
        _classCallCheck(this, ListRoutingModule);
      });
      ListRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ListRoutingModule
      });
      ListRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ListRoutingModule_Factory(t) {
          return new (t || ListRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ListRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/list/list.component.ts":
    /*!***********************************************!*\
      !*** ./src/app/layout/list/list.component.ts ***!
      \***********************************************/
    /*! exports provided: ListComponent */
    /***/
    function srcAppLayoutListListComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ListComponent", function () {
        return ListComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_list_overview_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/list-overview-example */"./src/app/layout/list/components/list-overview-example.ts");
      /* harmony import */
      var _components_list_sections_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/list-sections-example */"./src/app/layout/list/components/list-sections-example.ts");
      var ListComponent = /*#__PURE__*/_createClass(function ListComponent() {
        _classCallCheck(this, ListComponent);
      });
      ListComponent.ɵfac = function ListComponent_Factory(t) {
        return new (t || ListComponent)();
      };
      ListComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: ListComponent,
        selectors: [["app-list"]],
        decls: 2,
        vars: 0,
        template: function ListComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "list-overview-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "list-sections-example");
          }
        },
        directives: [_components_list_overview_example__WEBPACK_IMPORTED_MODULE_1__["ListOverviewExample"], _components_list_sections_example__WEBPACK_IMPORTED_MODULE_2__["ListSectionsExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-list',
            templateUrl: './list.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/list/list.module.ts":
    /*!********************************************!*\
      !*** ./src/app/layout/list/list.module.ts ***!
      \********************************************/
    /*! exports provided: ListModule */
    /***/
    function srcAppLayoutListListModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "ListModule", function () {
        return ListModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _list_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./list-routing.module */"./src/app/layout/list/list-routing.module.ts");
      /* harmony import */
      var _list_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./list.component */"./src/app/layout/list/list.component.ts");
      /* harmony import */
      var _components_list_overview_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/list-overview-example */"./src/app/layout/list/components/list-overview-example.ts");
      /* harmony import */
      var _components_list_sections_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/list-sections-example */"./src/app/layout/list/components/list-sections-example.ts");
      /* harmony import */
      var _angular_material_list__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/list */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
      /* harmony import */
      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__( /*! @angular/material/icon */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
      var ListModule = /*#__PURE__*/_createClass(function ListModule() {
        _classCallCheck(this, ListModule);
      });
      ListModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ListModule
      });
      ListModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ListModule_Factory(t) {
          return new (t || ListModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _list_routing_module__WEBPACK_IMPORTED_MODULE_2__["ListRoutingModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_6__["MatListModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ListModule, {
          declarations: [_list_component__WEBPACK_IMPORTED_MODULE_3__["ListComponent"], _components_list_overview_example__WEBPACK_IMPORTED_MODULE_4__["ListOverviewExample"], _components_list_sections_example__WEBPACK_IMPORTED_MODULE_5__["ListSectionsExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _list_routing_module__WEBPACK_IMPORTED_MODULE_2__["ListRoutingModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_6__["MatListModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_list_component__WEBPACK_IMPORTED_MODULE_3__["ListComponent"], _components_list_overview_example__WEBPACK_IMPORTED_MODULE_4__["ListOverviewExample"], _components_list_sections_example__WEBPACK_IMPORTED_MODULE_5__["ListSectionsExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _list_routing_module__WEBPACK_IMPORTED_MODULE_2__["ListRoutingModule"], _angular_material_list__WEBPACK_IMPORTED_MODULE_6__["MatListModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_7__["MatIconModule"]]
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=layout-list-list-module-es5.js.map