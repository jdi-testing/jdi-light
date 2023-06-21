!function(){function t(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function e(t,e){for(var r=0;r<e.length;r++){var n=e[r];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(t,(a=n.key,o=void 0,"symbol"==typeof(o=function(t,e){if("object"!=typeof t||null===t)return t;var r=t[Symbol.toPrimitive];if(void 0!==r){var n=r.call(t,e||"default");if("object"!=typeof n)return n;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===e?String:Number)(t)}(a,"string"))?o:String(o)),n)}var a,o}function r(t,r,n){return r&&e(t.prototype,r),n&&e(t,n),Object.defineProperty(t,"prototype",{writable:!1}),t}(window.webpackJsonp=window.webpackJsonp||[]).push([[48],{x9j4:function(e,n,a){"use strict";a.r(n),a.d(n,"SortHeaderModule",(function(){return h}));var o=a("ofXK"),i=a("tyNb"),c=a("fXoL"),s=a("Dh3D");function b(t,e){if(1&t&&(c.Ub(0,"tr"),c.Ub(1,"td"),c.Cc(2),c.Tb(),c.Ub(3,"td"),c.Cc(4),c.Tb(),c.Ub(5,"td"),c.Cc(6),c.Tb(),c.Ub(7,"td"),c.Cc(8),c.Tb(),c.Ub(9,"td"),c.Cc(10),c.Tb(),c.Tb()),2&t){var r=e.$implicit;c.Bb(2),c.Dc(r.name),c.Bb(2),c.Dc(r.calories),c.Bb(2),c.Dc(r.fat),c.Bb(2),c.Dc(r.carbs),c.Bb(2),c.Dc(r.protein)}}function u(t,e,r){return(t<e?-1:1)*(r?1:-1)}var f,l,p,m=[{path:"",component:(f=function(){function e(){t(this,e),this.desserts=[{name:"Frozen yogurt",calories:159,fat:6,carbs:24,protein:4},{name:"Ice cream sandwich",calories:237,fat:9,carbs:37,protein:4},{name:"Eclair",calories:262,fat:16,carbs:24,protein:6},{name:"Cupcake",calories:305,fat:4,carbs:67,protein:4},{name:"Gingerbread",calories:356,fat:16,carbs:49,protein:4}],this.sortedData=this.desserts.slice()}return r(e,[{key:"sortData",value:function(t){var e=this.desserts.slice();this.sortedData=t.active&&""!==t.direction?e.sort((function(e,r){var n="asc"===t.direction;switch(t.active){case"name":return u(e.name,r.name,n);case"calories":return u(e.calories,r.calories,n);case"fat":return u(e.fat,r.fat,n);case"carbs":return u(e.carbs,r.carbs,n);case"protein":return u(e.protein,r.protein,n);default:return 0}})):e}}]),e}(),f.\u0275fac=function(t){return new(t||f)},f.\u0275cmp=c.Ib({type:f,selectors:[["sort-overview-example"]],decls:17,vars:1,consts:[[1,"example-h2"],["href","https://material.angular.io/components/sort/overview"],["matSort","","id","sort-headers",3,"matSortChange"],["mat-sort-header","name"],["mat-sort-header","calories"],["mat-sort-header","fat"],["mat-sort-header","carbs"],["mat-sort-header","protein"],[4,"ngFor","ngForOf"]],template:function(t,e){1&t&&(c.Ub(0,"h2",0),c.Ub(1,"a",1),c.Cc(2," Sorting overview "),c.Tb(),c.Tb(),c.Pb(3,"br"),c.Ub(4,"table",2),c.cc("matSortChange",(function(t){return e.sortData(t)})),c.Ub(5,"tr"),c.Ub(6,"th",3),c.Cc(7,"Dessert (100g)"),c.Tb(),c.Ub(8,"th",4),c.Cc(9,"Calories"),c.Tb(),c.Ub(10,"th",5),c.Cc(11,"Fat (g)"),c.Tb(),c.Ub(12,"th",6),c.Cc(13,"Carbs (g)"),c.Tb(),c.Ub(14,"th",7),c.Cc(15,"Protein (g)"),c.Tb(),c.Tb(),c.Bc(16,b,11,5,"tr",8),c.Tb()),2&t&&(c.Bb(16),c.mc("ngForOf",e.sortedData))},directives:[s.a,s.b,o.l],styles:[".mat-sort-header-container[_ngcontent-%COMP%]{align-items:center}td[_ngcontent-%COMP%]{padding-right:15px}"]}),f)}],d=((p=r((function e(){t(this,e)}))).\u0275mod=c.Mb({type:p}),p.\u0275inj=c.Lb({factory:function(t){return new(t||p)},imports:[[i.b.forChild(m)],i.b]}),p),h=((l=r((function e(){t(this,e)}))).\u0275mod=c.Mb({type:l}),l.\u0275inj=c.Lb({factory:function(t){return new(t||l)},imports:[[o.c,d,s.c]]}),l)}}])}();