!function(){function t(t,e){return function(t){if(Array.isArray(t))return t}(t)||function(t,e){var r=null==t?null:"undefined"!=typeof Symbol&&t[Symbol.iterator]||t["@@iterator"];if(null!=r){var n,i,o,a,s=[],c=!0,l=!1;try{if(o=(r=r.call(t)).next,0===e){if(Object(r)!==r)return;c=!1}else for(;!(c=(n=o.call(r)).done)&&(s.push(n.value),s.length!==e);c=!0);}catch(u){l=!0,i=u}finally{try{if(!c&&null!=r.return&&(a=r.return(),Object(a)!==a))return}finally{if(l)throw i}}return s}}(t,e)||n(t,e)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function e(t){return function(t){if(Array.isArray(t))return i(t)}(t)||function(t){if("undefined"!=typeof Symbol&&null!=t[Symbol.iterator]||null!=t["@@iterator"])return Array.from(t)}(t)||n(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function r(t,e){var r="undefined"!=typeof Symbol&&t[Symbol.iterator]||t["@@iterator"];if(!r){if(Array.isArray(t)||(r=n(t))||e&&t&&"number"==typeof t.length){r&&(t=r);var i=0,o=function(){};return{s:o,n:function(){return i>=t.length?{done:!0}:{done:!1,value:t[i++]}},e:function(t){throw t},f:o}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var a,s=!0,c=!1;return{s:function(){r=r.call(t)},n:function(){var t=r.next();return s=t.done,t},e:function(t){c=!0,a=t},f:function(){try{s||null==r.return||r.return()}finally{if(c)throw a}}}}function n(t,e){if(t){if("string"==typeof t)return i(t,e);var r=Object.prototype.toString.call(t).slice(8,-1);return"Object"===r&&t.constructor&&(r=t.constructor.name),"Map"===r||"Set"===r?Array.from(t):"Arguments"===r||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(r)?i(t,e):void 0}}function i(t,e){(null==e||e>t.length)&&(e=t.length);for(var r=0,n=new Array(e);r<e;r++)n[r]=t[r];return n}function o(){return(o="undefined"!=typeof Reflect&&Reflect.get?Reflect.get.bind():function(t,e,r){var n=a(t,e);if(n){var i=Object.getOwnPropertyDescriptor(n,e);return i.get?i.get.call(arguments.length<3?t:r):i.value}}).apply(this,arguments)}function a(t,e){for(;!Object.prototype.hasOwnProperty.call(t,e)&&null!==(t=y(t)););return t}function s(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function c(t,e){for(var r=0;r<e.length;r++){var n=e[r];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(t,(i=n.key,o=void 0,"symbol"==typeof(o=function(t,e){if("object"!=typeof t||null===t)return t;var r=t[Symbol.toPrimitive];if(void 0!==r){var n=r.call(t,e||"default");if("object"!=typeof n)return n;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===e?String:Number)(t)}(i,"string"))?o:String(o)),n)}var i,o}function l(t,e,r){return e&&c(t.prototype,e),r&&c(t,r),Object.defineProperty(t,"prototype",{writable:!1}),t}function u(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),Object.defineProperty(t,"prototype",{writable:!1}),e&&f(t,e)}function f(t,e){return(f=Object.setPrototypeOf?Object.setPrototypeOf.bind():function(t,e){return t.__proto__=e,t})(t,e)}function h(t){var e=function(){if("undefined"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){}))),!0}catch(t){return!1}}();return function(){var r,n=y(t);if(e){var i=y(this).constructor;r=Reflect.construct(n,arguments,i)}else r=n.apply(this,arguments);return d(this,r)}}function d(t,e){if(e&&("object"==typeof e||"function"==typeof e))return e;if(void 0!==e)throw new TypeError("Derived constructors may only return object or undefined");return function(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}(t)}function y(t){return(y=Object.setPrototypeOf?Object.getPrototypeOf.bind():function(t){return t.__proto__||Object.getPrototypeOf(t)})(t)}(window.webpackJsonp=window.webpackJsonp||[]).push([[20],{"+0xr":function(n,i,a){"use strict";a.d(i,"a",(function(){return ee})),a.d(i,"b",(function(){return Gt})),a.d(i,"c",(function(){return Kt})),a.d(i,"d",(function(){return te})),a.d(i,"e",(function(){return Zt})),a.d(i,"f",(function(){return ue})),a.d(i,"g",(function(){return ie})),a.d(i,"h",(function(){return Yt})),a.d(i,"i",(function(){return Vt})),a.d(i,"j",(function(){return ce})),a.d(i,"k",(function(){return re})),a.d(i,"l",(function(){return he})),a.d(i,"m",(function(){return ae})),a.d(i,"n",(function(){return Qt})),a.d(i,"o",(function(){return pe})),a.d(i,"p",(function(){return ye}));var c=a("8LU1"),f=a("0EQZ"),d=a("fXoL"),p=a("cH1L"),m=a("nLfN"),w=a("ofXK"),_=a("XNiG"),v=a("2Vo4"),b=a("7+OI"),g=a("LRne"),k=a("1G5W"),R=[[["caption"]]],D=["caption"];function C(t){return function(t){u(r,t);var e=h(r);function r(){var t;s(this,r);for(var n=arguments.length,i=new Array(n),o=0;o<n;o++)i[o]=arguments[o];return(t=e.call.apply(e,[this].concat(i)))._sticky=!1,t._hasStickyChanged=!1,t}return l(r,[{key:"sticky",get:function(){return this._sticky},set:function(t){var e=this._sticky;this._sticky=Object(c.c)(t),this._hasStickyChanged=e!==this._sticky}},{key:"hasStickyChanged",value:function(){var t=this._hasStickyChanged;return this._hasStickyChanged=!1,t}},{key:"resetStickyChanged",value:function(){this._hasStickyChanged=!1}}]),r}(t)}var S,O,x,E,A,j,F,T,I,P,H,N,J,M,B,L=new d.r("CDK_TABLE"),W=((x=l((function t(e){s(this,t),this.template=e}))).\u0275fac=function(t){return new(t||x)(d.Ob(d.M))},x.\u0275dir=d.Jb({type:x,selectors:[["","cdkCellDef",""]]}),x),Q=((O=l((function t(e){s(this,t),this.template=e}))).\u0275fac=function(t){return new(t||O)(d.Ob(d.M))},O.\u0275dir=d.Jb({type:O,selectors:[["","cdkHeaderCellDef",""]]}),O),z=((S=l((function t(e){s(this,t),this.template=e}))).\u0275fac=function(t){return new(t||S)(d.Ob(d.M))},S.\u0275dir=d.Jb({type:S,selectors:[["","cdkFooterCellDef",""]]}),S),G=C(l((function t(){s(this,t)}))),U=((E=function(t){u(r,t);var e=h(r);function r(t){var n;return s(this,r),(n=e.call(this))._table=t,n._stickyEnd=!1,n}return l(r,[{key:"name",get:function(){return this._name},set:function(t){t&&(this._name=t,this.cssClassFriendlyName=t.replace(/[^a-z0-9_-]/gi,"-"))}},{key:"stickyEnd",get:function(){return this._stickyEnd},set:function(t){var e=this._stickyEnd;this._stickyEnd=Object(c.c)(t),this._hasStickyChanged=e!==this._stickyEnd}}]),r}(G)).\u0275fac=function(t){return new(t||E)(d.Ob(L,8))},E.\u0275dir=d.Jb({type:E,selectors:[["","cdkColumnDef",""]],contentQueries:function(t,e,r){var n;1&t&&(d.Gb(r,W,!0),d.Gb(r,Q,!0),d.Gb(r,z,!0)),2&t&&(d.sc(n=d.dc())&&(e.cell=n.first),d.sc(n=d.dc())&&(e.headerCell=n.first),d.sc(n=d.dc())&&(e.footerCell=n.first))},inputs:{sticky:"sticky",name:["cdkColumnDef","name"],stickyEnd:"stickyEnd"},features:[d.Ab([{provide:"MAT_SORT_HEADER_COLUMN_DEF",useExisting:E}]),d.yb]}),E),V=l((function t(e,r){s(this,t),r.nativeElement.classList.add("cdk-column-"+e.cssClassFriendlyName)})),X=((T=function(t){u(r,t);var e=h(r);function r(t,n){return s(this,r),e.call(this,t,n)}return l(r)}(V)).\u0275fac=function(t){return new(t||T)(d.Ob(U),d.Ob(d.l))},T.\u0275dir=d.Jb({type:T,selectors:[["cdk-header-cell"],["th","cdk-header-cell",""]],hostAttrs:["role","columnheader",1,"cdk-header-cell"],features:[d.yb]}),T),Z=((F=function(t){u(r,t);var e=h(r);function r(t,n){return s(this,r),e.call(this,t,n)}return l(r)}(V)).\u0275fac=function(t){return new(t||F)(d.Ob(U),d.Ob(d.l))},F.\u0275dir=d.Jb({type:F,selectors:[["cdk-footer-cell"],["td","cdk-footer-cell",""]],hostAttrs:["role","gridcell",1,"cdk-footer-cell"],features:[d.yb]}),F),q=((j=function(t){u(r,t);var e=h(r);function r(t,n){return s(this,r),e.call(this,t,n)}return l(r)}(V)).\u0275fac=function(t){return new(t||j)(d.Ob(U),d.Ob(d.l))},j.\u0275dir=d.Jb({type:j,selectors:[["cdk-cell"],["td","cdk-cell",""]],hostAttrs:["role","gridcell",1,"cdk-cell"],features:[d.yb]}),j),K=((A=function(){function t(e,r){s(this,t),this.template=e,this._differs=r}return l(t,[{key:"ngOnChanges",value:function(t){if(!this._columnsDiffer){var e=t.columns&&t.columns.currentValue||[];this._columnsDiffer=this._differs.find(e).create(),this._columnsDiffer.diff(e)}}},{key:"getColumnsDiff",value:function(){return this._columnsDiffer.diff(this.columns)}},{key:"extractCellTemplate",value:function(t){return this instanceof Y?t.headerCell.template:this instanceof et?t.footerCell.template:t.cell.template}}]),t}()).\u0275fac=function(t){d.bc()},A.\u0275dir=d.Jb({type:A,features:[d.zb]}),A),$=C(function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(K)),Y=((I=function(t){u(r,t);var e=h(r);function r(t,n,i){var o;return s(this,r),(o=e.call(this,t,n))._table=i,o}return l(r,[{key:"ngOnChanges",value:function(t){o(y(r.prototype),"ngOnChanges",this).call(this,t)}}]),r}($)).\u0275fac=function(t){return new(t||I)(d.Ob(d.M),d.Ob(d.t),d.Ob(L,8))},I.\u0275dir=d.Jb({type:I,selectors:[["","cdkHeaderRowDef",""]],inputs:{columns:["cdkHeaderRowDef","columns"],sticky:["cdkHeaderRowDefSticky","sticky"]},features:[d.yb,d.zb]}),I),tt=C(function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(K)),et=((B=function(t){u(r,t);var e=h(r);function r(t,n,i){var o;return s(this,r),(o=e.call(this,t,n))._table=i,o}return l(r,[{key:"ngOnChanges",value:function(t){o(y(r.prototype),"ngOnChanges",this).call(this,t)}}]),r}(tt)).\u0275fac=function(t){return new(t||B)(d.Ob(d.M),d.Ob(d.t),d.Ob(L,8))},B.\u0275dir=d.Jb({type:B,selectors:[["","cdkFooterRowDef",""]],inputs:{columns:["cdkFooterRowDef","columns"],sticky:["cdkFooterRowDefSticky","sticky"]},features:[d.yb,d.zb]}),B),rt=((M=function(t){u(r,t);var e=h(r);function r(t,n,i){var o;return s(this,r),(o=e.call(this,t,n))._table=i,o}return l(r)}(K)).\u0275fac=function(t){return new(t||M)(d.Ob(d.M),d.Ob(d.t),d.Ob(L,8))},M.\u0275dir=d.Jb({type:M,selectors:[["","cdkRowDef",""]],inputs:{columns:["cdkRowDefColumns","columns"],when:["cdkRowDefWhen","when"]},features:[d.yb]}),M),nt=((J=function(){function t(e){s(this,t),this._viewContainer=e,t.mostRecentCellOutlet=this}return l(t,[{key:"ngOnDestroy",value:function(){t.mostRecentCellOutlet===this&&(t.mostRecentCellOutlet=null)}}]),t}()).\u0275fac=function(t){return new(t||J)(d.Ob(d.P))},J.\u0275dir=d.Jb({type:J,selectors:[["","cdkCellOutlet",""]]}),J.mostRecentCellOutlet=null,J),it=((N=l((function t(){s(this,t)}))).\u0275fac=function(t){return new(t||N)},N.\u0275cmp=d.Ib({type:N,selectors:[["cdk-header-row"],["tr","cdk-header-row",""]],hostAttrs:["role","row",1,"cdk-header-row"],decls:1,vars:0,consts:[["cdkCellOutlet",""]],template:function(t,e){1&t&&d.Qb(0,0)},directives:[nt],encapsulation:2}),N),ot=((H=l((function t(){s(this,t)}))).\u0275fac=function(t){return new(t||H)},H.\u0275cmp=d.Ib({type:H,selectors:[["cdk-footer-row"],["tr","cdk-footer-row",""]],hostAttrs:["role","row",1,"cdk-footer-row"],decls:1,vars:0,consts:[["cdkCellOutlet",""]],template:function(t,e){1&t&&d.Qb(0,0)},directives:[nt],encapsulation:2}),H),at=((P=l((function t(){s(this,t)}))).\u0275fac=function(t){return new(t||P)},P.\u0275cmp=d.Ib({type:P,selectors:[["cdk-row"],["tr","cdk-row",""]],hostAttrs:["role","row",1,"cdk-row"],decls:1,vars:0,consts:[["cdkCellOutlet",""]],template:function(t,e){1&t&&d.Qb(0,0)},directives:[nt],encapsulation:2}),P),st=["top","bottom","left","right"],ct=function(){function t(e,r,n){var i=!(arguments.length>3&&void 0!==arguments[3])||arguments[3];s(this,t),this._isNativeHtmlTable=e,this._stickCellCss=r,this.direction=n,this._isBrowser=i}return l(t,[{key:"clearStickyPositioning",value:function(t,e){var n,i=r(t);try{for(i.s();!(n=i.n()).done;){var o=n.value;if(o.nodeType===o.ELEMENT_NODE){this._removeStickyStyle(o,e);for(var a=0;a<o.children.length;a++)this._removeStickyStyle(o.children[a],e)}}}catch(s){i.e(s)}finally{i.f()}}},{key:"updateStickyColumns",value:function(t,e,n){var i=e.some((function(t){return t}))||n.some((function(t){return t}));if(t.length&&i&&this._isBrowser){var o,a=t[0],s=a.children.length,c=this._getCellWidths(a),l=this._getStickyStartColumnPositions(c,e),u=this._getStickyEndColumnPositions(c,n),f="rtl"===this.direction,h=r(t);try{for(h.s();!(o=h.n()).done;)for(var d=o.value,y=0;y<s;y++){var p=d.children[y];e[y]&&this._addStickyStyle(p,f?"right":"left",l[y]),n[y]&&this._addStickyStyle(p,f?"left":"right",u[y])}}catch(m){h.e(m)}finally{h.f()}}}},{key:"stickRows",value:function(t,e,r){if(this._isBrowser)for(var n="bottom"===r?t.reverse():t,i=0,o=0;o<n.length;o++)if(e[o]){var a=n[o];if(this._isNativeHtmlTable)for(var s=0;s<a.children.length;s++)this._addStickyStyle(a.children[s],r,i);else this._addStickyStyle(a,r,i);if(o===n.length-1)return;i+=a.getBoundingClientRect().height}}},{key:"updateStickyFooterContainer",value:function(t,e){if(this._isNativeHtmlTable){var r=t.querySelector("tfoot");e.some((function(t){return!t}))?this._removeStickyStyle(r,["bottom"]):this._addStickyStyle(r,"bottom",0)}}},{key:"_removeStickyStyle",value:function(t,e){var n,i=r(e);try{for(i.s();!(n=i.n()).done;){var o=n.value;t.style[o]=""}}catch(a){i.e(a)}finally{i.f()}t.style.zIndex=this._getCalculatedZIndex(t),st.some((function(e){return!!t.style[e]}))||(t.style.position="",t.classList.remove(this._stickCellCss))}},{key:"_addStickyStyle",value:function(t,e,r){t.classList.add(this._stickCellCss),t.style[e]=r+"px",t.style.cssText+="position: -webkit-sticky; position: sticky; ",t.style.zIndex=this._getCalculatedZIndex(t)}},{key:"_getCalculatedZIndex",value:function(t){for(var e={top:100,bottom:10,left:1,right:1},r=0,n=0,i=st;n<i.length;n++){var o=i[n];t.style[o]&&(r+=e[o])}return r?""+r:""}},{key:"_getCellWidths",value:function(t){for(var e=[],r=t.children,n=0;n<r.length;n++)e.push(r[n].getBoundingClientRect().width);return e}},{key:"_getStickyStartColumnPositions",value:function(t,e){for(var r=[],n=0,i=0;i<t.length;i++)e[i]&&(r[i]=n,n+=t[i]);return r}},{key:"_getStickyEndColumnPositions",value:function(t,e){for(var r=[],n=0,i=t.length;i>0;i--)e[i]&&(r[i]=n,n+=t[i]);return r}}]),t}();function lt(t){return Error('Could not find column with id "'.concat(t,'".'))}var ut,ft,ht,dt,yt=((dt=l((function t(e,r){s(this,t),this.viewContainer=e,this.elementRef=r}))).\u0275fac=function(t){return new(t||dt)(d.Ob(d.P),d.Ob(d.l))},dt.\u0275dir=d.Jb({type:dt,selectors:[["","rowOutlet",""]]}),dt),pt=((ht=l((function t(e,r){s(this,t),this.viewContainer=e,this.elementRef=r}))).\u0275fac=function(t){return new(t||ht)(d.Ob(d.P),d.Ob(d.l))},ht.\u0275dir=d.Jb({type:ht,selectors:[["","headerRowOutlet",""]]}),ht),mt=((ft=l((function t(e,r){s(this,t),this.viewContainer=e,this.elementRef=r}))).\u0275fac=function(t){return new(t||ft)(d.Ob(d.P),d.Ob(d.l))},ft.\u0275dir=d.Jb({type:ft,selectors:[["","footerRowOutlet",""]]}),ft),wt=((ut=function(){function t(e,r,n,i,o,a,c){s(this,t),this._differs=e,this._changeDetectorRef=r,this._elementRef=n,this._dir=o,this._platform=c,this._onDestroy=new _.a,this._columnDefsByName=new Map,this._customColumnDefs=new Set,this._customRowDefs=new Set,this._customHeaderRowDefs=new Set,this._customFooterRowDefs=new Set,this._headerRowDefChanged=!0,this._footerRowDefChanged=!0,this._cachedRenderRowsMap=new Map,this.stickyCssClass="cdk-table-sticky",this._multiTemplateDataRows=!1,this.viewChange=new v.a({start:0,end:Number.MAX_VALUE}),i||this._elementRef.nativeElement.setAttribute("role","grid"),this._document=a,this._isNativeHtmlTable="TABLE"===this._elementRef.nativeElement.nodeName}return l(t,[{key:"trackBy",get:function(){return this._trackByFn},set:function(t){Object(d.V)()&&null!=t&&"function"!=typeof t&&console&&console.warn&&console.warn("trackBy must be a function, but received ".concat(JSON.stringify(t),".")),this._trackByFn=t}},{key:"dataSource",get:function(){return this._dataSource},set:function(t){this._dataSource!==t&&this._switchDataSource(t)}},{key:"multiTemplateDataRows",get:function(){return this._multiTemplateDataRows},set:function(t){this._multiTemplateDataRows=Object(c.c)(t),this._rowOutlet&&this._rowOutlet.viewContainer.length&&this._forceRenderDataRows()}},{key:"ngOnInit",value:function(){var t=this;this._setupStickyStyler(),this._isNativeHtmlTable&&this._applyNativeTableSections(),this._dataDiffer=this._differs.find([]).create((function(e,r){return t.trackBy?t.trackBy(r.dataIndex,r.data):r}))}},{key:"ngAfterContentChecked",value:function(){if(this._cacheRowDefs(),this._cacheColumnDefs(),!this._headerRowDefs.length&&!this._footerRowDefs.length&&!this._rowDefs.length)throw Error("Missing definitions for header, footer, and row; cannot determine which columns should be rendered.");this._renderUpdatedColumns(),this._headerRowDefChanged&&(this._forceRenderHeaderRows(),this._headerRowDefChanged=!1),this._footerRowDefChanged&&(this._forceRenderFooterRows(),this._footerRowDefChanged=!1),this.dataSource&&this._rowDefs.length>0&&!this._renderChangeSubscription&&this._observeRenderChanges(),this._checkStickyStates()}},{key:"ngOnDestroy",value:function(){this._rowOutlet.viewContainer.clear(),this._headerRowOutlet.viewContainer.clear(),this._footerRowOutlet.viewContainer.clear(),this._cachedRenderRowsMap.clear(),this._onDestroy.next(),this._onDestroy.complete(),Object(f.e)(this.dataSource)&&this.dataSource.disconnect(this)}},{key:"renderRows",value:function(){var t=this;this._renderRows=this._getAllRenderRows();var e=this._dataDiffer.diff(this._renderRows);if(e){var r=this._rowOutlet.viewContainer;e.forEachOperation((function(e,n,i){if(null==e.previousIndex)t._insertRow(e.item,i);else if(null==i)r.remove(n);else{var o=r.get(n);r.move(o,i)}})),this._updateRowIndexContext(),e.forEachIdentityChange((function(t){r.get(t.currentIndex).context.$implicit=t.item.data})),this.updateStickyColumnStyles()}}},{key:"setHeaderRowDef",value:function(t){this._customHeaderRowDefs=new Set([t]),this._headerRowDefChanged=!0}},{key:"setFooterRowDef",value:function(t){this._customFooterRowDefs=new Set([t]),this._footerRowDefChanged=!0}},{key:"addColumnDef",value:function(t){this._customColumnDefs.add(t)}},{key:"removeColumnDef",value:function(t){this._customColumnDefs.delete(t)}},{key:"addRowDef",value:function(t){this._customRowDefs.add(t)}},{key:"removeRowDef",value:function(t){this._customRowDefs.delete(t)}},{key:"addHeaderRowDef",value:function(t){this._customHeaderRowDefs.add(t),this._headerRowDefChanged=!0}},{key:"removeHeaderRowDef",value:function(t){this._customHeaderRowDefs.delete(t),this._headerRowDefChanged=!0}},{key:"addFooterRowDef",value:function(t){this._customFooterRowDefs.add(t),this._footerRowDefChanged=!0}},{key:"removeFooterRowDef",value:function(t){this._customFooterRowDefs.delete(t),this._footerRowDefChanged=!0}},{key:"updateStickyHeaderRowStyles",value:function(){var t=this._getRenderedRows(this._headerRowOutlet),e=this._elementRef.nativeElement.querySelector("thead");e&&(e.style.display=t.length?"":"none");var r=this._headerRowDefs.map((function(t){return t.sticky}));this._stickyStyler.clearStickyPositioning(t,["top"]),this._stickyStyler.stickRows(t,r,"top"),this._headerRowDefs.forEach((function(t){return t.resetStickyChanged()}))}},{key:"updateStickyFooterRowStyles",value:function(){var t=this._getRenderedRows(this._footerRowOutlet),e=this._elementRef.nativeElement.querySelector("tfoot");e&&(e.style.display=t.length?"":"none");var r=this._footerRowDefs.map((function(t){return t.sticky}));this._stickyStyler.clearStickyPositioning(t,["bottom"]),this._stickyStyler.stickRows(t,r,"bottom"),this._stickyStyler.updateStickyFooterContainer(this._elementRef.nativeElement,r),this._footerRowDefs.forEach((function(t){return t.resetStickyChanged()}))}},{key:"updateStickyColumnStyles",value:function(){var t=this,r=this._getRenderedRows(this._headerRowOutlet),n=this._getRenderedRows(this._rowOutlet),i=this._getRenderedRows(this._footerRowOutlet);this._stickyStyler.clearStickyPositioning([].concat(e(r),e(n),e(i)),["left","right"]),r.forEach((function(e,r){t._addStickyColumnStyles([e],t._headerRowDefs[r])})),this._rowDefs.forEach((function(e){for(var r=[],i=0;i<n.length;i++)t._renderRows[i].rowDef===e&&r.push(n[i]);t._addStickyColumnStyles(r,e)})),i.forEach((function(e,r){t._addStickyColumnStyles([e],t._footerRowDefs[r])})),Array.from(this._columnDefsByName.values()).forEach((function(t){return t.resetStickyChanged()}))}},{key:"_getAllRenderRows",value:function(){var t=[],e=this._cachedRenderRowsMap;this._cachedRenderRowsMap=new Map;for(var r=0;r<this._data.length;r++){var n=this._data[r],i=this._getRenderRowsForData(n,r,e.get(n));this._cachedRenderRowsMap.has(n)||this._cachedRenderRowsMap.set(n,new WeakMap);for(var o=0;o<i.length;o++){var a=i[o],s=this._cachedRenderRowsMap.get(a.data);s.has(a.rowDef)?s.get(a.rowDef).push(a):s.set(a.rowDef,[a]),t.push(a)}}return t}},{key:"_getRenderRowsForData",value:function(t,e,r){return this._getRowDefs(t,e).map((function(n){var i=r&&r.has(n)?r.get(n):[];if(i.length){var o=i.shift();return o.dataIndex=e,o}return{data:t,rowDef:n,dataIndex:e}}))}},{key:"_cacheColumnDefs",value:function(){var t=this;this._columnDefsByName.clear(),_t(this._getOwnDefs(this._contentColumnDefs),this._customColumnDefs).forEach((function(e){if(t._columnDefsByName.has(e.name))throw Error('Duplicate column definition name provided: "'.concat(e.name,'".'));t._columnDefsByName.set(e.name,e)}))}},{key:"_cacheRowDefs",value:function(){this._headerRowDefs=_t(this._getOwnDefs(this._contentHeaderRowDefs),this._customHeaderRowDefs),this._footerRowDefs=_t(this._getOwnDefs(this._contentFooterRowDefs),this._customFooterRowDefs),this._rowDefs=_t(this._getOwnDefs(this._contentRowDefs),this._customRowDefs);var t=this._rowDefs.filter((function(t){return!t.when}));if(!this.multiTemplateDataRows&&t.length>1)throw Error("There can only be one default row without a when predicate function.");this._defaultRowDef=t[0]}},{key:"_renderUpdatedColumns",value:function(){var t=function(t,e){return t||!!e.getColumnsDiff()};this._rowDefs.reduce(t,!1)&&this._forceRenderDataRows(),this._headerRowDefs.reduce(t,!1)&&this._forceRenderHeaderRows(),this._footerRowDefs.reduce(t,!1)&&this._forceRenderFooterRows()}},{key:"_switchDataSource",value:function(t){this._data=[],Object(f.e)(this.dataSource)&&this.dataSource.disconnect(this),this._renderChangeSubscription&&(this._renderChangeSubscription.unsubscribe(),this._renderChangeSubscription=null),t||(this._dataDiffer&&this._dataDiffer.diff([]),this._rowOutlet.viewContainer.clear()),this._dataSource=t}},{key:"_observeRenderChanges",value:function(){var t=this;if(this.dataSource){var e;if(Object(f.e)(this.dataSource)?e=this.dataSource.connect(this):Object(b.a)(this.dataSource)?e=this.dataSource:Array.isArray(this.dataSource)&&(e=Object(g.a)(this.dataSource)),void 0===e)throw Error("Provided data source did not match an array, Observable, or DataSource");this._renderChangeSubscription=e.pipe(Object(k.a)(this._onDestroy)).subscribe((function(e){t._data=e||[],t.renderRows()}))}}},{key:"_forceRenderHeaderRows",value:function(){var t=this;this._headerRowOutlet.viewContainer.length>0&&this._headerRowOutlet.viewContainer.clear(),this._headerRowDefs.forEach((function(e,r){return t._renderRow(t._headerRowOutlet,e,r)})),this.updateStickyHeaderRowStyles(),this.updateStickyColumnStyles()}},{key:"_forceRenderFooterRows",value:function(){var t=this;this._footerRowOutlet.viewContainer.length>0&&this._footerRowOutlet.viewContainer.clear(),this._footerRowDefs.forEach((function(e,r){return t._renderRow(t._footerRowOutlet,e,r)})),this.updateStickyFooterRowStyles(),this.updateStickyColumnStyles()}},{key:"_addStickyColumnStyles",value:function(t,e){var r=this,n=Array.from(e.columns||[]).map((function(t){var e=r._columnDefsByName.get(t);if(!e)throw lt(t);return e})),i=n.map((function(t){return t.sticky})),o=n.map((function(t){return t.stickyEnd}));this._stickyStyler.updateStickyColumns(t,i,o)}},{key:"_getRenderedRows",value:function(t){for(var e=[],r=0;r<t.viewContainer.length;r++){var n=t.viewContainer.get(r);e.push(n.rootNodes[0])}return e}},{key:"_getRowDefs",value:function(t,e){if(1==this._rowDefs.length)return[this._rowDefs[0]];var r=[];if(this.multiTemplateDataRows)r=this._rowDefs.filter((function(r){return!r.when||r.when(e,t)}));else{var n=this._rowDefs.find((function(r){return r.when&&r.when(e,t)}))||this._defaultRowDef;n&&r.push(n)}if(!r.length)throw function(t){return Error("Could not find a matching row definition for theprovided row data: "+JSON.stringify(t))}(t);return r}},{key:"_insertRow",value:function(t,e){this._renderRow(this._rowOutlet,t.rowDef,e,{$implicit:t.data})}},{key:"_renderRow",value:function(t,e,n){var i=arguments.length>3&&void 0!==arguments[3]?arguments[3]:{};t.viewContainer.createEmbeddedView(e.template,i,n);var o,a=r(this._getCellTemplates(e));try{for(a.s();!(o=a.n()).done;){var s=o.value;nt.mostRecentCellOutlet&&nt.mostRecentCellOutlet._viewContainer.createEmbeddedView(s,i)}}catch(c){a.e(c)}finally{a.f()}this._changeDetectorRef.markForCheck()}},{key:"_updateRowIndexContext",value:function(){for(var t=this._rowOutlet.viewContainer,e=0,r=t.length;e<r;e++){var n=t.get(e).context;n.count=r,n.first=0===e,n.last=e===r-1,n.even=e%2==0,n.odd=!n.even,this.multiTemplateDataRows?(n.dataIndex=this._renderRows[e].dataIndex,n.renderIndex=e):n.index=this._renderRows[e].dataIndex}}},{key:"_getCellTemplates",value:function(t){var e=this;return t&&t.columns?Array.from(t.columns,(function(r){var n=e._columnDefsByName.get(r);if(!n)throw lt(r);return t.extractCellTemplate(n)})):[]}},{key:"_applyNativeTableSections",value:function(){for(var t=this._document.createDocumentFragment(),e=0,r=[{tag:"thead",outlet:this._headerRowOutlet},{tag:"tbody",outlet:this._rowOutlet},{tag:"tfoot",outlet:this._footerRowOutlet}];e<r.length;e++){var n=r[e],i=this._document.createElement(n.tag);i.setAttribute("role","rowgroup"),i.appendChild(n.outlet.elementRef.nativeElement),t.appendChild(i)}this._elementRef.nativeElement.appendChild(t)}},{key:"_forceRenderDataRows",value:function(){this._dataDiffer.diff([]),this._rowOutlet.viewContainer.clear(),this.renderRows(),this.updateStickyColumnStyles()}},{key:"_checkStickyStates",value:function(){var t=function(t,e){return t||e.hasStickyChanged()};this._headerRowDefs.reduce(t,!1)&&this.updateStickyHeaderRowStyles(),this._footerRowDefs.reduce(t,!1)&&this.updateStickyFooterRowStyles(),Array.from(this._columnDefsByName.values()).reduce(t,!1)&&this.updateStickyColumnStyles()}},{key:"_setupStickyStyler",value:function(){var t=this;this._stickyStyler=new ct(this._isNativeHtmlTable,this.stickyCssClass,this._dir?this._dir.value:"ltr",this._platform.isBrowser),(this._dir?this._dir.change:Object(g.a)()).pipe(Object(k.a)(this._onDestroy)).subscribe((function(e){t._stickyStyler.direction=e,t.updateStickyColumnStyles()}))}},{key:"_getOwnDefs",value:function(t){var e=this;return t.filter((function(t){return!t._table||t._table===e}))}}]),t}()).\u0275fac=function(t){return new(t||ut)(d.Ob(d.t),d.Ob(d.h),d.Ob(d.l),d.Zb("role"),d.Ob(p.b,8),d.Ob(w.e),d.Ob(m.a))},ut.\u0275cmp=d.Ib({type:ut,selectors:[["cdk-table"],["table","cdk-table",""]],contentQueries:function(t,e,r){var n;1&t&&(d.Gb(r,U,!0),d.Gb(r,rt,!0),d.Gb(r,Y,!0),d.Gb(r,et,!0)),2&t&&(d.sc(n=d.dc())&&(e._contentColumnDefs=n),d.sc(n=d.dc())&&(e._contentRowDefs=n),d.sc(n=d.dc())&&(e._contentHeaderRowDefs=n),d.sc(n=d.dc())&&(e._contentFooterRowDefs=n))},viewQuery:function(t,e){var r;1&t&&(d.zc(yt,!0),d.zc(pt,!0),d.zc(mt,!0)),2&t&&(d.sc(r=d.dc())&&(e._rowOutlet=r.first),d.sc(r=d.dc())&&(e._headerRowOutlet=r.first),d.sc(r=d.dc())&&(e._footerRowOutlet=r.first))},hostAttrs:[1,"cdk-table"],inputs:{trackBy:"trackBy",dataSource:"dataSource",multiTemplateDataRows:"multiTemplateDataRows"},exportAs:["cdkTable"],features:[d.Ab([{provide:L,useExisting:ut}])],ngContentSelectors:D,decls:4,vars:0,consts:[["headerRowOutlet",""],["rowOutlet",""],["footerRowOutlet",""]],template:function(t,e){1&t&&(d.lc(R),d.kc(0),d.Qb(1,0),d.Qb(2,1),d.Qb(3,2))},directives:[pt,yt,mt],encapsulation:2}),ut);function _t(t,e){return t.concat(Array.from(e))}var vt,bt,gt,kt,Rt,Dt,Ct,St,Ot,xt,Et,At,jt,Ft,Tt,It,Pt=((vt=l((function t(){s(this,t)}))).\u0275mod=d.Mb({type:vt}),vt.\u0275inj=d.Lb({factory:function(t){return new(t||vt)}}),vt),Ht=a("FKr1"),Nt=a("quSY"),Jt=a("VRyK"),Mt=a("itXk"),Bt=a("lJxs"),Lt=[[["caption"]]],Wt=["caption"],Qt=((bt=function(t){u(r,t);var e=h(r);function r(){var t;return s(this,r),(t=e.apply(this,arguments)).stickyCssClass="mat-table-sticky",t}return l(r)}(wt)).\u0275fac=function(t){return zt(t||bt)},bt.\u0275cmp=d.Ib({type:bt,selectors:[["mat-table"],["table","mat-table",""]],hostAttrs:[1,"mat-table"],exportAs:["matTable"],features:[d.Ab([{provide:wt,useExisting:bt},{provide:L,useExisting:bt}]),d.yb],ngContentSelectors:Wt,decls:4,vars:0,consts:[["headerRowOutlet",""],["rowOutlet",""],["footerRowOutlet",""]],template:function(t,e){1&t&&(d.lc(Lt),d.kc(0),d.Qb(1,0),d.Qb(2,1),d.Qb(3,2))},directives:[pt,yt,mt],styles:['mat-table{display:block}mat-header-row{min-height:56px}mat-row,mat-footer-row{min-height:48px}mat-row,mat-header-row,mat-footer-row{display:flex;border-width:0;border-bottom-width:1px;border-style:solid;align-items:center;box-sizing:border-box}mat-row::after,mat-header-row::after,mat-footer-row::after{display:inline-block;min-height:inherit;content:""}mat-cell:first-of-type,mat-header-cell:first-of-type,mat-footer-cell:first-of-type{padding-left:24px}[dir=rtl] mat-cell:first-of-type,[dir=rtl] mat-header-cell:first-of-type,[dir=rtl] mat-footer-cell:first-of-type{padding-left:0;padding-right:24px}mat-cell:last-of-type,mat-header-cell:last-of-type,mat-footer-cell:last-of-type{padding-right:24px}[dir=rtl] mat-cell:last-of-type,[dir=rtl] mat-header-cell:last-of-type,[dir=rtl] mat-footer-cell:last-of-type{padding-right:0;padding-left:24px}mat-cell,mat-header-cell,mat-footer-cell{flex:1;display:flex;align-items:center;overflow:hidden;word-wrap:break-word;min-height:inherit}table.mat-table{border-spacing:0}tr.mat-header-row{height:56px}tr.mat-row,tr.mat-footer-row{height:48px}th.mat-header-cell{text-align:left}[dir=rtl] th.mat-header-cell{text-align:right}th.mat-header-cell,td.mat-cell,td.mat-footer-cell{padding:0;border-bottom-width:1px;border-bottom-style:solid}th.mat-header-cell:first-of-type,td.mat-cell:first-of-type,td.mat-footer-cell:first-of-type{padding-left:24px}[dir=rtl] th.mat-header-cell:first-of-type,[dir=rtl] td.mat-cell:first-of-type,[dir=rtl] td.mat-footer-cell:first-of-type{padding-left:0;padding-right:24px}th.mat-header-cell:last-of-type,td.mat-cell:last-of-type,td.mat-footer-cell:last-of-type{padding-right:24px}[dir=rtl] th.mat-header-cell:last-of-type,[dir=rtl] td.mat-cell:last-of-type,[dir=rtl] td.mat-footer-cell:last-of-type{padding-right:0;padding-left:24px}\n'],encapsulation:2}),bt),zt=d.Wb(Qt),Gt=((gt=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(W)).\u0275fac=function(t){return Ut(t||gt)},gt.\u0275dir=d.Jb({type:gt,selectors:[["","matCellDef",""]],features:[d.Ab([{provide:W,useExisting:gt}]),d.yb]}),gt),Ut=d.Wb(Gt),Vt=((kt=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(Q)).\u0275fac=function(t){return Xt(t||kt)},kt.\u0275dir=d.Jb({type:kt,selectors:[["","matHeaderCellDef",""]],features:[d.Ab([{provide:Q,useExisting:kt}]),d.yb]}),kt),Xt=d.Wb(Vt),Zt=((Rt=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(z)).\u0275fac=function(t){return qt(t||Rt)},Rt.\u0275dir=d.Jb({type:Rt,selectors:[["","matFooterCellDef",""]],features:[d.Ab([{provide:z,useExisting:Rt}]),d.yb]}),Rt),qt=d.Wb(Zt),Kt=((Dt=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(U)).\u0275fac=function(t){return $t(t||Dt)},Dt.\u0275dir=d.Jb({type:Dt,selectors:[["","matColumnDef",""]],inputs:{sticky:"sticky",name:["matColumnDef","name"]},features:[d.Ab([{provide:U,useExisting:Dt},{provide:"MAT_SORT_HEADER_COLUMN_DEF",useExisting:Dt}]),d.yb]}),Dt),$t=d.Wb(Kt),Yt=((xt=function(t){u(r,t);var e=h(r);function r(t,n){var i;return s(this,r),i=e.call(this,t,n),n.nativeElement.classList.add("mat-column-"+t.cssClassFriendlyName),i}return l(r)}(X)).\u0275fac=function(t){return new(t||xt)(d.Ob(U),d.Ob(d.l))},xt.\u0275dir=d.Jb({type:xt,selectors:[["mat-header-cell"],["th","mat-header-cell",""]],hostAttrs:["role","columnheader",1,"mat-header-cell"],features:[d.yb]}),xt),te=((Ot=function(t){u(r,t);var e=h(r);function r(t,n){var i;return s(this,r),i=e.call(this,t,n),n.nativeElement.classList.add("mat-column-"+t.cssClassFriendlyName),i}return l(r)}(Z)).\u0275fac=function(t){return new(t||Ot)(d.Ob(U),d.Ob(d.l))},Ot.\u0275dir=d.Jb({type:Ot,selectors:[["mat-footer-cell"],["td","mat-footer-cell",""]],hostAttrs:["role","gridcell",1,"mat-footer-cell"],features:[d.yb]}),Ot),ee=((St=function(t){u(r,t);var e=h(r);function r(t,n){var i;return s(this,r),i=e.call(this,t,n),n.nativeElement.classList.add("mat-column-"+t.cssClassFriendlyName),i}return l(r)}(q)).\u0275fac=function(t){return new(t||St)(d.Ob(U),d.Ob(d.l))},St.\u0275dir=d.Jb({type:St,selectors:[["mat-cell"],["td","mat-cell",""]],hostAttrs:["role","gridcell",1,"mat-cell"],features:[d.yb]}),St),re=((Ct=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(Y)).\u0275fac=function(t){return ne(t||Ct)},Ct.\u0275dir=d.Jb({type:Ct,selectors:[["","matHeaderRowDef",""]],inputs:{columns:["matHeaderRowDef","columns"],sticky:["matHeaderRowDefSticky","sticky"]},features:[d.Ab([{provide:Y,useExisting:Ct}]),d.yb]}),Ct),ne=d.Wb(re),ie=((Et=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(et)).\u0275fac=function(t){return oe(t||Et)},Et.\u0275dir=d.Jb({type:Et,selectors:[["","matFooterRowDef",""]],inputs:{columns:["matFooterRowDef","columns"],sticky:["matFooterRowDefSticky","sticky"]},features:[d.Ab([{provide:et,useExisting:Et}]),d.yb]}),Et),oe=d.Wb(ie),ae=((At=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(rt)).\u0275fac=function(t){return se(t||At)},At.\u0275dir=d.Jb({type:At,selectors:[["","matRowDef",""]],inputs:{columns:["matRowDefColumns","columns"],when:["matRowDefWhen","when"]},features:[d.Ab([{provide:rt,useExisting:At}]),d.yb]}),At),se=d.Wb(ae),ce=((jt=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(it)).\u0275fac=function(t){return le(t||jt)},jt.\u0275cmp=d.Ib({type:jt,selectors:[["mat-header-row"],["tr","mat-header-row",""]],hostAttrs:["role","row",1,"mat-header-row"],exportAs:["matHeaderRow"],features:[d.Ab([{provide:it,useExisting:jt}]),d.yb],decls:1,vars:0,consts:[["cdkCellOutlet",""]],template:function(t,e){1&t&&d.Qb(0,0)},directives:[nt],encapsulation:2}),jt),le=d.Wb(ce),ue=((Ft=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(ot)).\u0275fac=function(t){return fe(t||Ft)},Ft.\u0275cmp=d.Ib({type:Ft,selectors:[["mat-footer-row"],["tr","mat-footer-row",""]],hostAttrs:["role","row",1,"mat-footer-row"],exportAs:["matFooterRow"],features:[d.Ab([{provide:ot,useExisting:Ft}]),d.yb],decls:1,vars:0,consts:[["cdkCellOutlet",""]],template:function(t,e){1&t&&d.Qb(0,0)},directives:[nt],encapsulation:2}),Ft),fe=d.Wb(ue),he=((Tt=function(t){u(r,t);var e=h(r);function r(){return s(this,r),e.apply(this,arguments)}return l(r)}(at)).\u0275fac=function(t){return de(t||Tt)},Tt.\u0275cmp=d.Ib({type:Tt,selectors:[["mat-row"],["tr","mat-row",""]],hostAttrs:["role","row",1,"mat-row"],exportAs:["matRow"],features:[d.Ab([{provide:at,useExisting:Tt}]),d.yb],decls:1,vars:0,consts:[["cdkCellOutlet",""]],template:function(t,e){1&t&&d.Qb(0,0)},directives:[nt],encapsulation:2}),Tt),de=d.Wb(he),ye=((It=l((function t(){s(this,t)}))).\u0275mod=d.Mb({type:It}),It.\u0275inj=d.Lb({factory:function(t){return new(t||It)},imports:[[Pt,Ht.j]]}),It),pe=function(e){u(n,e);var r=h(n);function n(){var t,e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[];return s(this,n),(t=r.call(this))._renderData=new v.a([]),t._filter=new v.a(""),t._internalPageChanges=new _.a,t._renderChangesSubscription=Nt.a.EMPTY,t.sortingDataAccessor=function(t,e){var r=t[e];if(Object(c.a)(r)){var n=Number(r);return n<9007199254740991?n:r}return r},t.sortData=function(e,r){var n=r.active,i=r.direction;return n&&""!=i?e.sort((function(e,r){var o=t.sortingDataAccessor(e,n),a=t.sortingDataAccessor(r,n),s=0;return null!=o&&null!=a?o>a?s=1:o<a&&(s=-1):null!=o?s=1:null!=a&&(s=-1),s*("asc"==i?1:-1)})):e},t.filterPredicate=function(t,e){var r=Object.keys(t).reduce((function(e,r){return e+t[r]+"\u25ec"}),"").toLowerCase(),n=e.trim().toLowerCase();return-1!=r.indexOf(n)},t._data=new v.a(e),t._updateChangeSubscription(),t}return l(n,[{key:"data",get:function(){return this._data.value},set:function(t){this._data.next(t)}},{key:"filter",get:function(){return this._filter.value},set:function(t){this._filter.next(t)}},{key:"sort",get:function(){return this._sort},set:function(t){this._sort=t,this._updateChangeSubscription()}},{key:"paginator",get:function(){return this._paginator},set:function(t){this._paginator=t,this._updateChangeSubscription()}},{key:"_updateChangeSubscription",value:function(){var e=this,r=this._sort?Object(Jt.a)(this._sort.sortChange,this._sort.initialized):Object(g.a)(null),n=this._paginator?Object(Jt.a)(this._paginator.page,this._internalPageChanges,this._paginator.initialized):Object(g.a)(null),i=this._data,o=Object(Mt.a)([i,this._filter]).pipe(Object(Bt.a)((function(r){var n=t(r,1)[0];return e._filterData(n)}))),a=Object(Mt.a)([o,r]).pipe(Object(Bt.a)((function(r){var n=t(r,1)[0];return e._orderData(n)}))),s=Object(Mt.a)([a,n]).pipe(Object(Bt.a)((function(r){var n=t(r,1)[0];return e._pageData(n)})));this._renderChangesSubscription.unsubscribe(),this._renderChangesSubscription=s.subscribe((function(t){return e._renderData.next(t)}))}},{key:"_filterData",value:function(t){var e=this;return this.filteredData=this.filter?t.filter((function(t){return e.filterPredicate(t,e.filter)})):t,this.paginator&&this._updatePaginator(this.filteredData.length),this.filteredData}},{key:"_orderData",value:function(t){return this.sort?this.sortData(t.slice(),this.sort):t}},{key:"_pageData",value:function(t){if(!this.paginator)return t;var e=this.paginator.pageIndex*this.paginator.pageSize;return t.slice(e,e+this.paginator.pageSize)}},{key:"_updatePaginator",value:function(t){var e=this;Promise.resolve().then((function(){var r=e.paginator;if(r&&(r.length=t,r.pageIndex>0)){var n=Math.ceil(r.length/r.pageSize)-1||0,i=Math.min(r.pageIndex,n);i!==r.pageIndex&&(r.pageIndex=i,e._internalPageChanges.next())}}))}},{key:"connect",value:function(){return this._renderData}},{key:"disconnect",value:function(){}}]),n}(f.b)}}])}();