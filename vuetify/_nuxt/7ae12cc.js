(window.webpackJsonp=window.webpackJsonp||[]).push([[15],{1128:function(t,e,n){"use strict";n.r(e);var r=n(1040),o=n(1130),c=n(82),component=Object(c.a)({},(function(){var t=this,e=t._self._c;return e(o.a,[e(r.a,[e("h1",[t._v("Application")])]),t._v(" "),e("p",{staticClass:"body-1 mx-5"},[t._v("\n    The "),e("code",[t._v("v-app")]),t._v(" component is REQUIRED for all applications. \n    This is the mount point for many of Vuetify’s components. "),e("br"),t._v(" "),e("code",[t._v("v-app")]),t._v(" should only be rendered within your application ONCE.\n    ")]),t._v(" "),e("h2",{staticClass:"mb-3"},[t._v("Application components")]),t._v("\n    Each of these application components have a designated location and priority that it affects within the layout system.\n    "),e("ul",{staticClass:"my-3"},[e("li",[e("code",[t._v("v-app-bar")]),t._v(": Is always placed at the top of an application with a lower priority than v-system-bar.")]),t._v(" "),e("li",[e("code",[t._v("v-bottom-navigation")]),t._v(": Is always placed at the bottom of an application with a higher priority than v-footer.")]),t._v(" "),e("li",[e("code",[t._v("v-footer")]),t._v(": Is always placed at the bottom of an application with a lower priority than v-bottom-navigation.")]),t._v(" "),e("li",[e("code",[t._v("v-navigation-drawer")]),t._v(": Can be placed on the left or right side of an application \n        and can be configured to sit next to or below v-app-bar.")]),t._v(" "),e("li",[e("code",[t._v("v-system-bar")]),t._v(": Is always placed at the top of an application with higher priority than v-app-bar.")])])],1)}),[],!1,null,null,null);e.default=component.exports},411:function(t,e,n){var r=n(17);t.exports=function(t){return r(Map.prototype.entries,t)}},417:function(t,e,n){n(436)},418:function(t,e,n){"use strict";n(4)({target:"Map",proto:!0,real:!0,forced:!0},{deleteAll:n(434)})},419:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(74),f=n(411),v=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{every:function(t){var map=o(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0);return!v(e,(function(t,e,r){if(!n(e,t,map))return r()}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).stopped}})},420:function(t,e,n){"use strict";var r=n(4),o=n(45),c=n(74),f=n(17),v=n(57),l=n(21),d=n(156),h=n(411),E=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{filter:function(t){var map=l(this),e=h(map),n=c(t,arguments.length>1?arguments[1]:void 0),r=new(d(map,o("Map"))),_=v(r.set);return E(e,(function(t,e){n(e,t,map)&&f(_,r,t,e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),r}})},421:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(74),f=n(411),v=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{find:function(t){var map=o(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0);return v(e,(function(t,e,r){if(n(e,t,map))return r(e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).result}})},422:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(74),f=n(411),v=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{findKey:function(t){var map=o(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0);return v(e,(function(t,e,r){if(n(e,t,map))return r(t)}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).result}})},423:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(411),f=n(437),v=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{includes:function(t){return v(c(o(this)),(function(e,n,r){if(f(n,t))return r()}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).stopped}})},424:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(411),f=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{keyOf:function(t){return f(c(o(this)),(function(e,n,r){if(n===t)return r(e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).result}})},425:function(t,e,n){"use strict";var r=n(4),o=n(45),c=n(74),f=n(17),v=n(57),l=n(21),d=n(156),h=n(411),E=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{mapKeys:function(t){var map=l(this),e=h(map),n=c(t,arguments.length>1?arguments[1]:void 0),r=new(d(map,o("Map"))),_=v(r.set);return E(e,(function(t,e){f(_,r,n(e,t,map),e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),r}})},426:function(t,e,n){"use strict";var r=n(4),o=n(45),c=n(74),f=n(17),v=n(57),l=n(21),d=n(156),h=n(411),E=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{mapValues:function(t){var map=l(this),e=h(map),n=c(t,arguments.length>1?arguments[1]:void 0),r=new(d(map,o("Map"))),_=v(r.set);return E(e,(function(t,e){f(_,r,t,n(e,t,map))}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),r}})},427:function(t,e,n){"use strict";var r=n(4),o=n(57),c=n(21),f=n(191);r({target:"Map",proto:!0,real:!0,arity:1,forced:!0},{merge:function(t){for(var map=c(this),e=o(map.set),n=arguments.length,i=0;i<n;)f(arguments[i++],e,{that:map,AS_ENTRIES:!0});return map}})},428:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(57),f=n(411),v=n(191),l=TypeError;r({target:"Map",proto:!0,real:!0,forced:!0},{reduce:function(t){var map=o(this),e=f(map),n=arguments.length<2,r=n?void 0:arguments[1];if(c(t),v(e,(function(e,o){n?(n=!1,r=o):r=t(r,o,e,map)}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),n)throw l("Reduce of empty map with no initial value");return r}})},429:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(74),f=n(411),v=n(191);r({target:"Map",proto:!0,real:!0,forced:!0},{some:function(t){var map=o(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0);return v(e,(function(t,e,r){if(n(e,t,map))return r()}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).stopped}})},430:function(t,e,n){"use strict";var r=n(4),o=n(17),c=n(21),f=n(57),v=TypeError;r({target:"Map",proto:!0,real:!0,forced:!0},{update:function(t,e){var map=c(this),n=f(map.get),r=f(map.has),l=f(map.set),d=arguments.length;f(e);var h=o(r,map,t);if(!h&&d<3)throw v("Updating absent value");var E=h?o(n,map,t):f(d>2?arguments[2]:void 0)(t,map);return o(l,map,t,e(E,t,map)),map}})},432:function(t,e,n){"use strict";var r=n(4),o=n(8),c=n(7),f=n(125),v=n(41),l=n(274),d=n(191),h=n(193),E=n(13),_=n(33),T=n(6),R=n(199),I=n(104),y=n(202);t.exports=function(t,e,n){var S=-1!==t.indexOf("Map"),w=-1!==t.indexOf("Weak"),x=S?"set":"add",m=o[t],A=m&&m.prototype,N=m,M={},O=function(t){var e=c(A[t]);v(A,t,"add"==t?function(t){return e(this,0===t?0:t),this}:"delete"==t?function(t){return!(w&&!_(t))&&e(this,0===t?0:t)}:"get"==t?function(t){return w&&!_(t)?void 0:e(this,0===t?0:t)}:"has"==t?function(t){return!(w&&!_(t))&&e(this,0===t?0:t)}:function(t,n){return e(this,0===t?0:t,n),this})};if(f(t,!E(m)||!(w||A.forEach&&!T((function(){(new m).entries().next()})))))N=n.getConstructor(e,t,S,x),l.enable();else if(f(t,!0)){var k=new N,z=k[x](w?{}:-0,1)!=k,U=T((function(){k.has(1)})),C=R((function(t){new m(t)})),D=!w&&T((function(){for(var t=new m,e=5;e--;)t[x](e,e);return!t.has(-0)}));C||((N=e((function(t,e){h(t,A);var n=y(new m,t,N);return null!=e&&d(e,n[x],{that:n,AS_ENTRIES:S}),n}))).prototype=A,A.constructor=N),(U||D)&&(O("delete"),O("has"),S&&O("get")),(D||z)&&O(x),w&&A.clear&&delete A.clear}return M[t]=N,r({global:!0,constructor:!0,forced:N!=m},M),I(N,t),w||n.setStrong(N,t,S),N}},433:function(t,e,n){"use strict";var r=n(37).f,o=n(77),c=n(278),f=n(74),v=n(193),l=n(191),d=n(200),h=n(201),E=n(28),_=n(274).fastKey,T=n(66),R=T.set,I=T.getterFor;t.exports={getConstructor:function(t,e,n,d){var h=t((function(t,r){v(t,T),R(t,{type:e,index:o(null),first:void 0,last:void 0,size:0}),E||(t.size=0),null!=r&&l(r,t[d],{that:t,AS_ENTRIES:n})})),T=h.prototype,y=I(e),S=function(t,e,n){var r,o,c=y(t),f=w(t,e);return f?f.value=n:(c.last=f={index:o=_(e,!0),key:e,value:n,previous:r=c.last,next:void 0,removed:!1},c.first||(c.first=f),r&&(r.next=f),E?c.size++:t.size++,"F"!==o&&(c.index[o]=f)),t},w=function(t,e){var n,r=y(t),o=_(e);if("F"!==o)return r.index[o];for(n=r.first;n;n=n.next)if(n.key==e)return n};return c(T,{clear:function(){for(var t=y(this),data=t.index,e=t.first;e;)e.removed=!0,e.previous&&(e.previous=e.previous.next=void 0),delete data[e.index],e=e.next;t.first=t.last=void 0,E?t.size=0:this.size=0},delete:function(t){var e=this,n=y(e),r=w(e,t);if(r){var o=r.next,c=r.previous;delete n.index[r.index],r.removed=!0,c&&(c.next=o),o&&(o.previous=c),n.first==r&&(n.first=o),n.last==r&&(n.last=c),E?n.size--:e.size--}return!!r},forEach:function(t){for(var e,n=y(this),r=f(t,arguments.length>1?arguments[1]:void 0);e=e?e.next:n.first;)for(r(e.value,e.key,this);e&&e.removed;)e=e.previous},has:function(t){return!!w(this,t)}}),c(T,n?{get:function(t){var e=w(this,t);return e&&e.value},set:function(t,e){return S(this,0===t?0:t,e)}}:{add:function(t){return S(this,t=0===t?0:t,t)}}),E&&r(T,"size",{get:function(){return y(this).size}}),h},setStrong:function(t,e,n){var r=e+" Iterator",o=I(e),c=I(r);d(t,e,(function(t,e){R(this,{type:r,target:t,state:o(t),kind:e,last:void 0})}),(function(){for(var t=c(this),e=t.kind,n=t.last;n&&n.removed;)n=n.previous;return t.target&&(t.last=n=n?n.next:t.state.first)?"keys"==e?{value:n.key,done:!1}:"values"==e?{value:n.value,done:!1}:{value:[n.key,n.value],done:!1}:(t.target=void 0,{value:void 0,done:!0})}),n?"entries":"values",!n,!0),h(e)}}},434:function(t,e,n){"use strict";var r=n(17),o=n(57),c=n(21);t.exports=function(){for(var t,e=c(this),n=o(e.delete),f=!0,v=0,l=arguments.length;v<l;v++)t=r(n,e,arguments[v]),f=f&&t;return!!f}},436:function(t,e,n){"use strict";n(432)("Map",(function(t){return function(){return t(this,arguments.length?arguments[0]:void 0)}}),n(433))},437:function(t,e){t.exports=function(t,e){return t===e||t!=t&&e!=e}}}]);