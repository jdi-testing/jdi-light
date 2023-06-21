!function(){function t(){return(t="undefined"!=typeof Reflect&&Reflect.get?Reflect.get.bind():function(t,i,n){var r=e(t,i);if(r){var o=Object.getOwnPropertyDescriptor(r,i);return o.get?o.get.call(arguments.length<3?t:n):o.value}}).apply(this,arguments)}function e(t,e){for(;!Object.prototype.hasOwnProperty.call(t,e)&&null!==(t=s(t)););return t}function i(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),Object.defineProperty(t,"prototype",{writable:!1}),e&&n(t,e)}function n(t,e){return(n=Object.setPrototypeOf?Object.setPrototypeOf.bind():function(t,e){return t.__proto__=e,t})(t,e)}function r(t){var e=function(){if("undefined"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){}))),!0}catch(t){return!1}}();return function(){var i,n=s(t);if(e){var r=s(this).constructor;i=Reflect.construct(n,arguments,r)}else i=n.apply(this,arguments);return o(this,i)}}function o(t,e){if(e&&("object"==typeof e||"function"==typeof e))return e;if(void 0!==e)throw new TypeError("Derived constructors may only return object or undefined");return function(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}(t)}function s(t){return(s=Object.setPrototypeOf?Object.getPrototypeOf.bind():function(t){return t.__proto__||Object.getPrototypeOf(t)})(t)}function a(t){return function(t){if(Array.isArray(t))return l(t)}(t)||function(t){if("undefined"!=typeof Symbol&&null!=t[Symbol.iterator]||null!=t["@@iterator"])return Array.from(t)}(t)||function(t,e){if(!t)return;if("string"==typeof t)return l(t,e);var i=Object.prototype.toString.call(t).slice(8,-1);"Object"===i&&t.constructor&&(i=t.constructor.name);if("Map"===i||"Set"===i)return Array.from(t);if("Arguments"===i||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(i))return l(t,e)}(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function l(t,e){(null==e||e>t.length)&&(e=t.length);for(var i=0,n=new Array(e);i<e;i++)n[i]=t[i];return n}function c(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function u(t,e){for(var i=0;i<e.length;i++){var n=e[i];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(t,(r=n.key,o=void 0,"symbol"==typeof(o=function(t,e){if("object"!=typeof t||null===t)return t;var i=t[Symbol.toPrimitive];if(void 0!==i){var n=i.call(t,e||"default");if("object"!=typeof n)return n;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===e?String:Number)(t)}(r,"string"))?o:String(o)),n)}var r,o}function h(t,e,i){return e&&u(t.prototype,e),i&&u(t,i),Object.defineProperty(t,"prototype",{writable:!1}),t}(window.webpackJsonp=window.webpackJsonp||[]).push([[55],{pkJh:function(e,n,o){"use strict";o.r(n),o.d(n,"GridListModule",(function(){return $}));var l,u=o("ofXK"),d=o("tyNb"),g=o("fXoL"),f=o("FKr1"),p=o("8LU1"),m=o("cH1L"),y=["*"],w=new g.r("MAT_GRID_LIST"),b=((l=function(){function t(e,i){c(this,t),this._element=e,this._gridList=i,this._rowspan=1,this._colspan=1}return h(t,[{key:"rowspan",get:function(){return this._rowspan},set:function(t){this._rowspan=Math.round(Object(p.f)(t))}},{key:"colspan",get:function(){return this._colspan},set:function(t){this._colspan=Math.round(Object(p.f)(t))}},{key:"_setStyle",value:function(t,e){this._element.nativeElement.style[t]=e}}]),t}()).\u0275fac=function(t){return new(t||l)(g.Ob(g.l),g.Ob(w,8))},l.\u0275cmp=g.Ib({type:l,selectors:[["mat-grid-tile"]],hostAttrs:[1,"mat-grid-tile"],hostVars:2,hostBindings:function(t,e){2&t&&g.Cb("rowspan",e.rowspan)("colspan",e.colspan)},inputs:{rowspan:"rowspan",colspan:"colspan"},exportAs:["matGridTile"],ngContentSelectors:y,decls:2,vars:0,consts:[[1,"mat-figure"]],template:function(t,e){1&t&&(g.lc(),g.Ub(0,"figure",0),g.kc(1),g.Tb())},styles:[".mat-grid-list{display:block;position:relative}.mat-grid-tile{display:block;position:absolute;overflow:hidden}.mat-grid-tile .mat-figure{top:0;left:0;right:0;bottom:0;position:absolute;display:flex;align-items:center;justify-content:center;height:100%;padding:0;margin:0}.mat-grid-tile .mat-grid-tile-header,.mat-grid-tile .mat-grid-tile-footer{display:flex;align-items:center;height:48px;color:#fff;background:rgba(0,0,0,.38);overflow:hidden;padding:0 16px;position:absolute;left:0;right:0}.mat-grid-tile .mat-grid-tile-header>*,.mat-grid-tile .mat-grid-tile-footer>*{margin:0;padding:0;font-weight:normal;font-size:inherit}.mat-grid-tile .mat-grid-tile-header.mat-2-line,.mat-grid-tile .mat-grid-tile-footer.mat-2-line{height:68px}.mat-grid-tile .mat-grid-list-text{display:flex;flex-direction:column;width:100%;box-sizing:border-box;overflow:hidden}.mat-grid-tile .mat-grid-list-text>*{margin:0;padding:0;font-weight:normal;font-size:inherit}.mat-grid-tile .mat-grid-list-text:empty{display:none}.mat-grid-tile .mat-grid-tile-header{top:0}.mat-grid-tile .mat-grid-tile-footer{bottom:0}.mat-grid-tile .mat-grid-avatar{padding-right:16px}[dir=rtl] .mat-grid-tile .mat-grid-avatar{padding-right:0;padding-left:16px}.mat-grid-tile .mat-grid-avatar:empty{display:none}\n"],encapsulation:2,changeDetection:0}),l),v=function(){function t(){c(this,t),this.columnIndex=0,this.rowIndex=0}return h(t,[{key:"rowCount",get:function(){return this.rowIndex+1}},{key:"rowspan",get:function(){var t=Math.max.apply(Math,a(this.tracker));return t>1?this.rowCount+t-1:this.rowCount}},{key:"update",value:function(t,e){var i=this;this.columnIndex=0,this.rowIndex=0,this.tracker=new Array(t),this.tracker.fill(0,0,this.tracker.length),this.positions=e.map((function(t){return i._trackTile(t)}))}},{key:"_trackTile",value:function(t){var e=this._findMatchingGap(t.colspan);return this._markTilePosition(e,t),this.columnIndex=e+t.colspan,new _(this.rowIndex,e)}},{key:"_findMatchingGap",value:function(t){if(t>this.tracker.length)throw Error("mat-grid-list: tile with colspan ".concat(t,' is wider than grid with cols="').concat(this.tracker.length,'".'));var e=-1,i=-1;do{this.columnIndex+t>this.tracker.length?(this._nextRow(),e=this.tracker.indexOf(0,this.columnIndex),i=this._findGapEndIndex(e)):-1!=(e=this.tracker.indexOf(0,this.columnIndex))?(i=this._findGapEndIndex(e),this.columnIndex=e+1):(this._nextRow(),e=this.tracker.indexOf(0,this.columnIndex),i=this._findGapEndIndex(e))}while(i-e<t||0==i);return Math.max(e,0)}},{key:"_nextRow",value:function(){this.columnIndex=0,this.rowIndex++;for(var t=0;t<this.tracker.length;t++)this.tracker[t]=Math.max(0,this.tracker[t]-1)}},{key:"_findGapEndIndex",value:function(t){for(var e=t+1;e<this.tracker.length;e++)if(0!=this.tracker[e])return e;return this.tracker.length}},{key:"_markTilePosition",value:function(t,e){for(var i=0;i<e.colspan;i++)this.tracker[t+i]=e.rowspan}}]),t}(),_=h((function t(e,i){c(this,t),this.row=e,this.col=i})),x=/^-?\d+((\.\d+)?[A-Za-z%$]?)+$/,k=function(){function t(){c(this,t),this._rows=0,this._rowspan=0}return h(t,[{key:"init",value:function(t,e,i,n){this._gutterSize=H(t),this._rows=e.rowCount,this._rowspan=e.rowspan,this._cols=i,this._direction=n}},{key:"getBaseTileSize",value:function(t,e){return"(".concat(t,"% - (").concat(this._gutterSize," * ").concat(e,"))")}},{key:"getTilePosition",value:function(t,e){return 0===e?"0":C("(".concat(t," + ").concat(this._gutterSize,") * ").concat(e))}},{key:"getTileSize",value:function(t,e){return"(".concat(t," * ").concat(e,") + (").concat(e-1," * ").concat(this._gutterSize,")")}},{key:"setStyle",value:function(t,e,i){var n=100/this._cols,r=(this._cols-1)/this._cols;this.setColStyles(t,i,n,r),this.setRowStyles(t,e,n,r)}},{key:"setColStyles",value:function(t,e,i,n){var r=this.getBaseTileSize(i,n);t._setStyle("rtl"===this._direction?"right":"left",this.getTilePosition(r,e)),t._setStyle("width",C(this.getTileSize(r,t.colspan)))}},{key:"getGutterSpan",value:function(){return"".concat(this._gutterSize," * (").concat(this._rowspan," - 1)")}},{key:"getTileSpan",value:function(t){return"".concat(this._rowspan," * ").concat(this.getTileSize(t,1))}},{key:"getComputedHeight",value:function(){return null}}]),t}(),S=function(e){i(o,e);var n=r(o);function o(t){var e;return c(this,o),(e=n.call(this)).fixedRowHeight=t,e}return h(o,[{key:"init",value:function(e,i,n,r){if(t(s(o.prototype),"init",this).call(this,e,i,n,r),this.fixedRowHeight=H(this.fixedRowHeight),!x.test(this.fixedRowHeight))throw Error('Invalid value "'.concat(this.fixedRowHeight,'" set as rowHeight.'))}},{key:"setRowStyles",value:function(t,e){t._setStyle("top",this.getTilePosition(this.fixedRowHeight,e)),t._setStyle("height",C(this.getTileSize(this.fixedRowHeight,t.rowspan)))}},{key:"getComputedHeight",value:function(){return["height",C("".concat(this.getTileSpan(this.fixedRowHeight)," + ").concat(this.getGutterSpan()))]}},{key:"reset",value:function(t){t._setListStyle(["height",null]),t._tiles&&t._tiles.forEach((function(t){t._setStyle("top",null),t._setStyle("height",null)}))}}]),o}(k),T=function(t){i(n,t);var e=r(n);function n(t){var i;return c(this,n),(i=e.call(this))._parseRatio(t),i}return h(n,[{key:"setRowStyles",value:function(t,e,i,n){this.baseTileHeight=this.getBaseTileSize(i/this.rowHeightRatio,n),t._setStyle("marginTop",this.getTilePosition(this.baseTileHeight,e)),t._setStyle("paddingTop",C(this.getTileSize(this.baseTileHeight,t.rowspan)))}},{key:"getComputedHeight",value:function(){return["paddingBottom",C("".concat(this.getTileSpan(this.baseTileHeight)," + ").concat(this.getGutterSpan()))]}},{key:"reset",value:function(t){t._setListStyle(["paddingBottom",null]),t._tiles.forEach((function(t){t._setStyle("marginTop",null),t._setStyle("paddingTop",null)}))}},{key:"_parseRatio",value:function(t){var e=t.split(":");if(2!==e.length)throw Error('mat-grid-list: invalid ratio given for row-height: "'.concat(t,'"'));this.rowHeightRatio=parseFloat(e[0])/parseFloat(e[1])}}]),n}(k),O=function(t){i(n,t);var e=r(n);function n(){return c(this,n),e.apply(this,arguments)}return h(n,[{key:"setRowStyles",value:function(t,e){var i=this.getBaseTileSize(100/this._rowspan,(this._rows-1)/this._rows);t._setStyle("top",this.getTilePosition(i,e)),t._setStyle("height",C(this.getTileSize(i,t.rowspan)))}},{key:"reset",value:function(t){t._tiles&&t._tiles.forEach((function(t){t._setStyle("top",null),t._setStyle("height",null)}))}}]),n}(k);function C(t){return"calc(".concat(t,")")}function H(t){return t.match(/([A-Za-z%]+)$/)?t:t+"px"}var R,I,j,z=((j=function(){function t(e,i){c(this,t),this._element=e,this._dir=i,this._gutter="1px"}return h(t,[{key:"cols",get:function(){return this._cols},set:function(t){this._cols=Math.max(1,Math.round(Object(p.f)(t)))}},{key:"gutterSize",get:function(){return this._gutter},set:function(t){this._gutter=""+(null==t?"":t)}},{key:"rowHeight",get:function(){return this._rowHeight},set:function(t){var e=""+(null==t?"":t);e!==this._rowHeight&&(this._rowHeight=e,this._setTileStyler(this._rowHeight))}},{key:"ngOnInit",value:function(){this._checkCols(),this._checkRowHeight()}},{key:"ngAfterContentChecked",value:function(){this._layoutTiles()}},{key:"_checkCols",value:function(){if(!this.cols)throw Error('mat-grid-list: must pass in number of columns. Example: <mat-grid-list cols="3">')}},{key:"_checkRowHeight",value:function(){this._rowHeight||this._setTileStyler("1:1")}},{key:"_setTileStyler",value:function(t){this._tileStyler&&this._tileStyler.reset(this),this._tileStyler="fit"===t?new O:t&&t.indexOf(":")>-1?new T(t):new S(t)}},{key:"_layoutTiles",value:function(){var t=this;this._tileCoordinator||(this._tileCoordinator=new v);var e=this._tileCoordinator,i=this._tiles.filter((function(e){return!e._gridList||e._gridList===t})),n=this._dir?this._dir.value:"ltr";this._tileCoordinator.update(this.cols,i),this._tileStyler.init(this.gutterSize,e,this.cols,n),i.forEach((function(i,n){var r=e.positions[n];t._tileStyler.setStyle(i,r.row,r.col)})),this._setListStyle(this._tileStyler.getComputedHeight())}},{key:"_setListStyle",value:function(t){t&&(this._element.nativeElement.style[t[0]]=t[1])}}]),t}()).\u0275fac=function(t){return new(t||j)(g.Ob(g.l),g.Ob(m.b,8))},j.\u0275cmp=g.Ib({type:j,selectors:[["mat-grid-list"]],contentQueries:function(t,e,i){var n;1&t&&g.Gb(i,b,!0),2&t&&g.sc(n=g.dc())&&(e._tiles=n)},hostAttrs:[1,"mat-grid-list"],hostVars:1,hostBindings:function(t,e){2&t&&g.Cb("cols",e.cols)},inputs:{cols:"cols",gutterSize:"gutterSize",rowHeight:"rowHeight"},exportAs:["matGridList"],features:[g.Ab([{provide:w,useExisting:j}])],ngContentSelectors:y,decls:2,vars:0,template:function(t,e){1&t&&(g.lc(),g.Ub(0,"div"),g.kc(1),g.Tb())},styles:[".mat-grid-list{display:block;position:relative}.mat-grid-tile{display:block;position:absolute;overflow:hidden}.mat-grid-tile .mat-figure{top:0;left:0;right:0;bottom:0;position:absolute;display:flex;align-items:center;justify-content:center;height:100%;padding:0;margin:0}.mat-grid-tile .mat-grid-tile-header,.mat-grid-tile .mat-grid-tile-footer{display:flex;align-items:center;height:48px;color:#fff;background:rgba(0,0,0,.38);overflow:hidden;padding:0 16px;position:absolute;left:0;right:0}.mat-grid-tile .mat-grid-tile-header>*,.mat-grid-tile .mat-grid-tile-footer>*{margin:0;padding:0;font-weight:normal;font-size:inherit}.mat-grid-tile .mat-grid-tile-header.mat-2-line,.mat-grid-tile .mat-grid-tile-footer.mat-2-line{height:68px}.mat-grid-tile .mat-grid-list-text{display:flex;flex-direction:column;width:100%;box-sizing:border-box;overflow:hidden}.mat-grid-tile .mat-grid-list-text>*{margin:0;padding:0;font-weight:normal;font-size:inherit}.mat-grid-tile .mat-grid-list-text:empty{display:none}.mat-grid-tile .mat-grid-tile-header{top:0}.mat-grid-tile .mat-grid-tile-footer{bottom:0}.mat-grid-tile .mat-grid-avatar{padding-right:16px}[dir=rtl] .mat-grid-tile .mat-grid-avatar{padding-right:0;padding-left:16px}.mat-grid-tile .mat-grid-avatar:empty{display:none}\n"],encapsulation:2,changeDetection:0}),j),E=((I=h((function t(){c(this,t)}))).\u0275mod=g.Mb({type:I}),I.\u0275inj=g.Lb({factory:function(t){return new(t||I)},imports:[[f.l,f.j],f.l,f.j]}),I),P=((R=h((function t(){c(this,t)}))).\u0275fac=function(t){return new(t||R)},R.\u0275cmp=g.Ib({type:R,selectors:[["grid-list-overview-example"]],decls:12,vars:0,consts:[[1,"example-h2"],["href","https://material.angular.io/components/grid-list/overview"],["id","basic-grid-list","cols","2","rowHeight","2:1"],["id","basic-grid-list-tile-1"],["id","basic-grid-list-tile-2"],["id","basic-grid-list-tile-3"],["id","basic-grid-list-tile-4"]],template:function(t,e){1&t&&(g.Ub(0,"h2",0),g.Ub(1,"a",1),g.Cc(2," Basic grid-list "),g.Tb(),g.Tb(),g.Ub(3,"mat-grid-list",2),g.Ub(4,"mat-grid-tile",3),g.Cc(5,"1"),g.Tb(),g.Ub(6,"mat-grid-tile",4),g.Cc(7,"2"),g.Tb(),g.Ub(8,"mat-grid-tile",5),g.Cc(9,"3"),g.Tb(),g.Ub(10,"mat-grid-tile",6),g.Cc(11,"4"),g.Tb(),g.Tb())},directives:[z,b],styles:["mat-grid-tile[_ngcontent-%COMP%]{background:#add8e6}"]}),R);function A(t,e){if(1&t&&(g.Ub(0,"mat-grid-tile",3),g.Cc(1),g.Tb()),2&t){var i=e.$implicit;g.Ac("background",i.color,g.Hb),g.nc("id","dynamic-grid-list-"+i.text.toLowerCase()),g.mc("colspan",i.cols)("rowspan",i.rows),g.Bb(1),g.Ec(" ",i.text," ")}}var L,M,B,G,U=((L=h((function t(){c(this,t),this.tiles=[{text:"One",cols:3,rows:1,color:"lightblue"},{text:"Two",cols:1,rows:2,color:"lightgreen"},{text:"Three",cols:1,rows:1,color:"lightpink"},{text:"Four",cols:2,rows:1,color:"#DDBDF1"}]}))).\u0275fac=function(t){return new(t||L)},L.\u0275cmp=g.Ib({type:L,selectors:[["grid-list-dynamic-example"]],decls:4,vars:1,consts:[[1,"example-h2"],["id","dynamic-grid-list","cols","4","rowHeight","100px"],[3,"id","colspan","rowspan","background",4,"ngFor","ngForOf"],[3,"id","colspan","rowspan"]],template:function(t,e){1&t&&(g.Ub(0,"h2",0),g.Cc(1,"Dynamic grid-list"),g.Tb(),g.Ub(2,"mat-grid-list",1),g.Bc(3,A,2,6,"mat-grid-tile",2),g.Tb()),2&t&&(g.Bb(3),g.mc("ngForOf",e.tiles))},directives:[z,u.l,b],styles:[""]}),L),D=[{path:"",component:(M=h((function t(){c(this,t)})),M.\u0275fac=function(t){return new(t||M)},M.\u0275cmp=g.Ib({type:M,selectors:[["app-grid-list"]],decls:2,vars:0,template:function(t,e){1&t&&(g.Pb(0,"grid-list-overview-example"),g.Pb(1,"grid-list-dynamic-example"))},directives:[P,U],encapsulation:2}),M)}],F=((G=h((function t(){c(this,t)}))).\u0275mod=g.Mb({type:G}),G.\u0275inj=g.Lb({factory:function(t){return new(t||G)},imports:[[d.b.forChild(D)],d.b]}),G),$=((B=h((function t(){c(this,t)}))).\u0275mod=g.Mb({type:B}),B.\u0275inj=g.Lb({factory:function(t){return new(t||B)},imports:[[u.c,F,E]]}),B)}}])}();