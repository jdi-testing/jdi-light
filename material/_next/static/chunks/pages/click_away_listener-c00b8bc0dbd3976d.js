(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[5399],{52795:function(n,t,e){"use strict";var r=e(67294),o=e(73935),i=e(30626),u=e(17294),c=e(55192);function l(n){return n.substring(2).toLowerCase()}t.Z=function(n){var t=n.children,e=n.disableReactTree,a=void 0!==e&&e,s=n.mouseEvent,f=void 0===s?"onClick":s,d=n.onClickAway,v=n.touchEvent,m=void 0===v?"onTouchEnd":v,p=r.useRef(!1),h=r.useRef(null),y=r.useRef(!1),b=r.useRef(!1);r.useEffect((function(){return setTimeout((function(){y.current=!0}),0),function(){y.current=!1}}),[]);var w=r.useCallback((function(n){h.current=o.findDOMNode(n)}),[]),x=(0,u.Z)(t.ref,w),E=(0,c.Z)((function(n){var t=b.current;if(b.current=!1,y.current&&h.current&&!function(n){return document.documentElement.clientWidth<n.clientX||document.documentElement.clientHeight<n.clientY}(n))if(p.current)p.current=!1;else{var e;if(n.composedPath)e=n.composedPath().indexOf(h.current)>-1;else e=!(0,i.Z)(h.current).documentElement.contains(n.target)||h.current.contains(n.target);e||!a&&t||d(n)}})),k=function(n){return function(e){b.current=!0;var r=t.props[n];r&&r(e)}},g={ref:x};return!1!==m&&(g[m]=k(m)),r.useEffect((function(){if(!1!==m){var n=l(m),t=(0,i.Z)(h.current),e=function(){p.current=!0};return t.addEventListener(n,E),t.addEventListener("touchmove",e),function(){t.removeEventListener(n,E),t.removeEventListener("touchmove",e)}}}),[E,m]),!1!==f&&(g[f]=k(f)),r.useEffect((function(){if(!1!==f){var n=l(f),t=(0,i.Z)(h.current);return t.addEventListener(n,E),function(){t.removeEventListener(n,E)}}}),[E,f]),r.createElement(r.Fragment,null,r.cloneElement(t,g))}},76234:function(n,t,e){"use strict";var r=e(67294),o=e(73935),i=e(34236),u=e(17294);var c="undefined"!==typeof window?r.useLayoutEffect:r.useEffect,l=r.forwardRef((function(n,t){var e=n.children,l=n.container,a=n.disablePortal,s=void 0!==a&&a,f=n.onRendered,d=r.useState(null),v=d[0],m=d[1],p=(0,u.Z)(r.isValidElement(e)?e.ref:null,t);return c((function(){s||m(function(n){return n="function"===typeof n?n():n,o.findDOMNode(n)}(l)||document.body)}),[l,s]),c((function(){if(v&&!s)return(0,i.Z)(t,v),function(){(0,i.Z)(t,null)}}),[t,v,s]),c((function(){f&&(v||s)&&f()}),[f,v,s]),s?r.isValidElement(e)?r.cloneElement(e,{ref:p}):e:v?o.createPortal(e,v):v}));t.Z=l},41120:function(n,t,e){"use strict";var r=e(87462),o=e(11719),i=e(99700);t.Z=function(n){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(0,o.Z)(n,(0,r.Z)({defaultTheme:i.Z},t))}},96774:function(n,t,e){(window.__NEXT_P=window.__NEXT_P||[]).push(["/click_away_listener",function(){return e(21717)}])},21717:function(n,t,e){"use strict";e.r(t),e.d(t,{default:function(){return x}});var r=e(85893),o=e(67294),i=e(43832),u=e(80343),c=e(41120),l=e(52795),a=e(76234);function s(n,t){(null==t||t>n.length)&&(t=n.length);for(var e=0,r=new Array(t);e<t;e++)r[e]=n[e];return r}function f(n,t){return function(n){if(Array.isArray(n))return n}(n)||function(n,t){var e=null==n?null:"undefined"!==typeof Symbol&&n[Symbol.iterator]||n["@@iterator"];if(null!=e){var r,o,i=[],u=!0,c=!1;try{for(e=e.call(n);!(u=(r=e.next()).done)&&(i.push(r.value),!t||i.length!==t);u=!0);}catch(l){c=!0,o=l}finally{try{u||null==e.return||e.return()}finally{if(c)throw o}}return i}}(n,t)||function(n,t){if(!n)return;if("string"===typeof n)return s(n,t);var e=Object.prototype.toString.call(n).slice(8,-1);"Object"===e&&n.constructor&&(e=n.constructor.name);if("Map"===e||"Set"===e)return Array.from(e);if("Arguments"===e||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(e))return s(n,t)}(n,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}var d=(0,c.Z)((function(n){return{dropdown:{position:"fixed",width:200,top:"50%",left:"50%",transform:"translate(-50%, -50%)",border:"1px solid",padding:n.spacing(1),backgroundColor:n.palette.background.paper}}}));function v(){var n=d(),t=f(o.useState(!1),2),e=t[0],i=t[1];return(0,r.jsx)(l.Z,{onClickAway:function(){i(!1)},children:(0,r.jsxs)("div",{children:[(0,r.jsx)("button",{type:"button",onClick:function(){i((function(n){return!n}))},children:"Open menu dropdown"}),e?(0,r.jsx)(a.Z,{children:(0,r.jsx)("div",{className:n.dropdown,children:"Click me, I will stay visible until you click outside."})}):null]})})}function m(n,t){(null==t||t>n.length)&&(t=n.length);for(var e=0,r=new Array(t);e<t;e++)r[e]=n[e];return r}function p(n,t){return function(n){if(Array.isArray(n))return n}(n)||function(n,t){var e=null==n?null:"undefined"!==typeof Symbol&&n[Symbol.iterator]||n["@@iterator"];if(null!=e){var r,o,i=[],u=!0,c=!1;try{for(e=e.call(n);!(u=(r=e.next()).done)&&(i.push(r.value),!t||i.length!==t);u=!0);}catch(l){c=!0,o=l}finally{try{u||null==e.return||e.return()}finally{if(c)throw o}}return i}}(n,t)||function(n,t){if(!n)return;if("string"===typeof n)return m(n,t);var e=Object.prototype.toString.call(n).slice(8,-1);"Object"===e&&n.constructor&&(e=n.constructor.name);if("Map"===e||"Set"===e)return Array.from(e);if("Arguments"===e||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(e))return m(n,t)}(n,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}var h=(0,c.Z)((function(n){return{root:{position:"relative"},dropdown:{position:"absolute",top:28,right:0,left:0,zIndex:1,border:"1px solid",padding:n.spacing(1),backgroundColor:n.palette.background.paper}}}));function y(){var n=h(),t=p(o.useState(!1),2),e=t[0],i=t[1];return(0,r.jsx)(l.Z,{onClickAway:function(){i(!1)},children:(0,r.jsxs)("div",{className:n.root,children:[(0,r.jsx)("button",{type:"button",onClick:function(){i((function(n){return!n}))},children:"Open menu dropdown"}),e?(0,r.jsx)("div",{className:n.dropdown,children:"Click me, I will stay visible until you click outside."}):null]})})}var b=(0,c.Z)((function(n){return{click_root:{position:"relative",display:"flex"}}}));function w(){var n=b();return(0,r.jsxs)("div",{children:[(0,r.jsx)("h1",{children:"Click Away Listener"}),(0,r.jsx)("h2",{children:"Example"}),(0,r.jsx)("div",{className:n.click_root,children:(0,r.jsx)(y,{id:"simpleClickAway",className:n.click_root})}),(0,r.jsx)("h2",{children:"Portal"}),(0,r.jsx)("div",{className:n.click_root,children:(0,r.jsx)(v,{id:"portalClickAway",className:n.click_root})})]})}function x(){return(0,r.jsx)(i.Z,{maxWidth:"xl",children:(0,r.jsx)(u.Z,{my:4,children:(0,r.jsx)(w,{})})})}}},function(n){n.O(0,[7431,9774,2888,179],(function(){return t=96774,n(n.s=t);var t}));var t=n.O();_N_E=t}]);