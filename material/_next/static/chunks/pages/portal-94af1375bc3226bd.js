(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[9632],{76234:function(n,e,r){"use strict";var t=r(67294),i=r(73935),u=(r(45697),r(34236)),l=r(17294);var o="undefined"!==typeof window?t.useLayoutEffect:t.useEffect,c=t.forwardRef((function(n,e){var r=n.children,c=n.container,a=n.disablePortal,f=void 0!==a&&a,d=n.onRendered,s=t.useState(null),h=s[0],v=s[1],p=(0,l.Z)(t.isValidElement(r)?r.ref:null,e);return o((function(){f||v(function(n){return n="function"===typeof n?n():n,i.findDOMNode(n)}(c)||document.body)}),[c,f]),o((function(){if(h&&!f)return(0,u.Z)(e,h),function(){(0,u.Z)(e,null)}}),[e,h,f]),o((function(){d&&(h||f)&&d()}),[d,h,f]),f?t.isValidElement(r)?t.cloneElement(r,{ref:p}):r:h?i.createPortal(r,h):h}));e.Z=c},41120:function(n,e,r){"use strict";var t=r(87462),i=r(11719),u=r(99700);e.Z=function(n){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(0,i.Z)(n,(0,t.Z)({defaultTheme:u.Z},e))}},40149:function(n,e,r){(window.__NEXT_P=window.__NEXT_P||[]).push(["/portal",function(){return r(64069)}])},64069:function(n,e,r){"use strict";r.r(e),r.d(e,{default:function(){return d}});var t=r(85893),i=r(67294),u=r(43832),l=r(7560),o=r(76234);function c(n,e){return function(n){if(Array.isArray(n))return n}(n)||function(n,e){var r=[],t=!0,i=!1,u=void 0;try{for(var l,o=n[Symbol.iterator]();!(t=(l=o.next()).done)&&(r.push(l.value),!e||r.length!==e);t=!0);}catch(c){i=!0,u=c}finally{try{t||null==o.return||o.return()}finally{if(i)throw u}}return r}(n,e)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var a=(0,r(41120).Z)((function(n){return{alert:{padding:n.spacing(1),margin:n.spacing(1,0),border:"1px solid"}}}));function f(){var n=a(),e=c(i.useState(!1),2),r=e[0],u=e[1],l=i.useRef(null);return(0,t.jsxs)("div",{children:[(0,t.jsx)("h1",{children:"Portal"}),(0,t.jsxs)("div",{children:[(0,t.jsx)("button",{type:"button",onClick:function(){u(!r)},children:r?"Unmount children":"Mount children"}),(0,t.jsxs)("div",{className:n.alert,children:["It looks like I will render here.",r?(0,t.jsx)(o.Z,{container:l.current,children:(0,t.jsx)("span",{children:"But I actually render here!"})}):null]}),(0,t.jsx)("div",{className:n.alert,ref:l})]})]})}function d(){return(0,t.jsx)(u.Z,{maxWidth:"xl",children:(0,t.jsx)(l.Z,{my:4,children:(0,t.jsx)(f,{})})})}}},function(n){n.O(0,[5770,9774,2888,179],(function(){return e=40149,n(n.s=e);var e}));var e=n.O();_N_E=e}]);