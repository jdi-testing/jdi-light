(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, _toPropertyKey(descriptor.key), descriptor); } }
  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); Object.defineProperty(Constructor, "prototype", { writable: false }); return Constructor; }
  function _toPropertyKey(arg) { var key = _toPrimitive(arg, "string"); return typeof key === "symbol" ? key : String(key); }
  function _toPrimitive(input, hint) { if (typeof input !== "object" || input === null) return input; var prim = input[Symbol.toPrimitive]; if (prim !== undefined) { var res = prim.call(input, hint || "default"); if (typeof res !== "object") return res; throw new TypeError("@@toPrimitive must return a primitive value."); } return (hint === "string" ? String : Number)(input); }
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["layout-card-card-module"], {
    /***/"./src/app/layout/card/card-routing.module.ts":
    /*!****************************************************!*\
      !*** ./src/app/layout/card/card-routing.module.ts ***!
      \****************************************************/
    /*! exports provided: CardRoutingModule */
    /***/
    function srcAppLayoutCardCardRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CardRoutingModule", function () {
        return CardRoutingModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/router */"./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
      /* harmony import */
      var _card_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./card.component */"./src/app/layout/card/card.component.ts");
      var routes = [{
        path: '',
        component: _card_component__WEBPACK_IMPORTED_MODULE_2__["CardComponent"]
      }];
      var CardRoutingModule = /*#__PURE__*/_createClass(function CardRoutingModule() {
        _classCallCheck(this, CardRoutingModule);
      });
      CardRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: CardRoutingModule
      });
      CardRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function CardRoutingModule_Factory(t) {
          return new (t || CardRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CardRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CardRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/card/card.component.ts":
    /*!***********************************************!*\
      !*** ./src/app/layout/card/card.component.ts ***!
      \***********************************************/
    /*! exports provided: CardComponent */
    /***/
    function srcAppLayoutCardCardComponentTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CardComponent", function () {
        return CardComponent;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _components_card_overview_example__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! ./components/card-overview-example */"./src/app/layout/card/components/card-overview-example.ts");
      /* harmony import */
      var _components_card_fancy_example__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./components/card-fancy-example */"./src/app/layout/card/components/card-fancy-example.ts");
      var CardComponent = /*#__PURE__*/_createClass(function CardComponent() {
        _classCallCheck(this, CardComponent);
      });
      CardComponent.ɵfac = function CardComponent_Factory(t) {
        return new (t || CardComponent)();
      };
      CardComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: CardComponent,
        selectors: [["app-card"]],
        decls: 2,
        vars: 0,
        template: function CardComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "card-overview-example");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "card-fancy-example");
          }
        },
        directives: [_components_card_overview_example__WEBPACK_IMPORTED_MODULE_1__["CardOverviewExample"], _components_card_fancy_example__WEBPACK_IMPORTED_MODULE_2__["CardFancyExample"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CardComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-card',
            templateUrl: './card.component.html'
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/card/card.module.ts":
    /*!********************************************!*\
      !*** ./src/app/layout/card/card.module.ts ***!
      \********************************************/
    /*! exports provided: CardModule */
    /***/
    function srcAppLayoutCardCardModuleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CardModule", function () {
        return CardModule;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/common */"./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
      /* harmony import */
      var _card_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__( /*! ./card-routing.module */"./src/app/layout/card/card-routing.module.ts");
      /* harmony import */
      var _card_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__( /*! ./card.component */"./src/app/layout/card/card.component.ts");
      /* harmony import */
      var _components_card_fancy_example__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__( /*! ./components/card-fancy-example */"./src/app/layout/card/components/card-fancy-example.ts");
      /* harmony import */
      var _components_card_overview_example__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__( /*! ./components/card-overview-example */"./src/app/layout/card/components/card-overview-example.ts");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
      var CardModule = /*#__PURE__*/_createClass(function CardModule() {
        _classCallCheck(this, CardModule);
      });
      CardModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: CardModule
      });
      CardModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function CardModule_Factory(t) {
          return new (t || CardModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _card_routing_module__WEBPACK_IMPORTED_MODULE_2__["CardRoutingModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_6__["MatCardModule"]]]
      });
      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CardModule, {
          declarations: [_card_component__WEBPACK_IMPORTED_MODULE_3__["CardComponent"], _components_card_fancy_example__WEBPACK_IMPORTED_MODULE_4__["CardFancyExample"], _components_card_overview_example__WEBPACK_IMPORTED_MODULE_5__["CardOverviewExample"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _card_routing_module__WEBPACK_IMPORTED_MODULE_2__["CardRoutingModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_6__["MatCardModule"]]
        });
      })();
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CardModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_card_component__WEBPACK_IMPORTED_MODULE_3__["CardComponent"], _components_card_fancy_example__WEBPACK_IMPORTED_MODULE_4__["CardFancyExample"], _components_card_overview_example__WEBPACK_IMPORTED_MODULE_5__["CardOverviewExample"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _card_routing_module__WEBPACK_IMPORTED_MODULE_2__["CardRoutingModule"], _angular_material_card__WEBPACK_IMPORTED_MODULE_6__["MatCardModule"]]
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/card/components/card-fancy-example.ts":
    /*!**************************************************************!*\
      !*** ./src/app/layout/card/components/card-fancy-example.ts ***!
      \**************************************************************/
    /*! exports provided: CardFancyExample */
    /***/
    function srcAppLayoutCardComponentsCardFancyExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CardFancyExample", function () {
        return CardFancyExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");

      /**
       * @title Card with multiple sections
       */
      var CardFancyExample = /*#__PURE__*/_createClass(function CardFancyExample() {
        _classCallCheck(this, CardFancyExample);
      });
      CardFancyExample.ɵfac = function CardFancyExample_Factory(t) {
        return new (t || CardFancyExample)();
      };
      CardFancyExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: CardFancyExample,
        selectors: [["card-fancy-example"]],
        decls: 18,
        vars: 0,
        consts: [[1, "example-h2"], ["id", "example-card", 1, "example-card"], ["mat-card-avatar", "", 1, "example-header-image"], ["mat-card-image", "", "src", "https://material.angular.io/assets/img/examples/shiba2.jpg", "alt", "Photo of a Shiba Inu"], ["mat-button", ""]],
        template: function CardFancyExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Card with multiple sections");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "mat-card", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-card-header");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "div", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "mat-card-title");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "Shiba Inu");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "mat-card-subtitle");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Dog Breed");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "img", 3);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "mat-card-content");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "p");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, " The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally bred for hunting. ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-card-actions");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "LIKE");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "button", 4);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "SHARE");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCard"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardHeader"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardAvatar"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardTitle"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardSubtitle"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardImage"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardContent"], _angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCardActions"]],
        styles: [".example-card[_ngcontent-%COMP%] {\r\n  max-width: 400px;\r\n}\r\n\r\n.example-header-image[_ngcontent-%COMP%] {\r\n  background-image: url('https://material.angular.io/assets/img/examples/shiba1.jpg');\r\n  background-size: cover;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbGF5b3V0L2NhcmQvY29tcG9uZW50cy9jYXJkLWZhbmN5LWV4YW1wbGUuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsZ0JBQWdCO0FBQ2xCOztBQUVBO0VBQ0UsbUZBQW1GO0VBQ25GLHNCQUFzQjtBQUN4QiIsImZpbGUiOiJzcmMvYXBwL2xheW91dC9jYXJkL2NvbXBvbmVudHMvY2FyZC1mYW5jeS1leGFtcGxlLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLWNhcmQge1xyXG4gIG1heC13aWR0aDogNDAwcHg7XHJcbn1cclxuXHJcbi5leGFtcGxlLWhlYWRlci1pbWFnZSB7XHJcbiAgYmFja2dyb3VuZC1pbWFnZTogdXJsKCdodHRwczovL21hdGVyaWFsLmFuZ3VsYXIuaW8vYXNzZXRzL2ltZy9leGFtcGxlcy9zaGliYTEuanBnJyk7XHJcbiAgYmFja2dyb3VuZC1zaXplOiBjb3ZlcjtcclxufVxyXG4iXX0= */"]
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CardFancyExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'card-fancy-example',
            templateUrl: 'card-fancy-example.html',
            styleUrls: ['card-fancy-example.css']
          }]
        }], null, null);
      })();

      /***/
    },

    /***/"./src/app/layout/card/components/card-overview-example.ts":
    /*!*****************************************************************!*\
      !*** ./src/app/layout/card/components/card-overview-example.ts ***!
      \*****************************************************************/
    /*! exports provided: CardOverviewExample */
    /***/
    function srcAppLayoutCardComponentsCardOverviewExampleTs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */
      __webpack_require__.d(__webpack_exports__, "CardOverviewExample", function () {
        return CardOverviewExample;
      });
      /* harmony import */
      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__( /*! @angular/core */"./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
      /* harmony import */
      var _angular_material_card__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__( /*! @angular/material/card */"./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");

      /**
       * @title Basic cards
       */
      var CardOverviewExample = /*#__PURE__*/_createClass(function CardOverviewExample() {
        _classCallCheck(this, CardOverviewExample);
      });
      CardOverviewExample.ɵfac = function CardOverviewExample_Factory(t) {
        return new (t || CardOverviewExample)();
      };
      CardOverviewExample.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: CardOverviewExample,
        selectors: [["card-overview-example"]],
        decls: 5,
        vars: 0,
        consts: [[1, "example-h2"], ["href", "https://material.angular.io/components/card/overview"], ["id", "simple-card"]],
        template: function CardOverviewExample_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2", 0);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 1);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Basic card ");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-card", 2);
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Simple card");
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        directives: [_angular_material_card__WEBPACK_IMPORTED_MODULE_1__["MatCard"]],
        encapsulation: 2
      });
      /*@__PURE__*/
      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CardOverviewExample, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'card-overview-example',
            templateUrl: 'card-overview-example.html'
          }]
        }], null, null);
      })();

      /***/
    }
  }]);
})();
//# sourceMappingURL=layout-card-card-module-es5.js.map