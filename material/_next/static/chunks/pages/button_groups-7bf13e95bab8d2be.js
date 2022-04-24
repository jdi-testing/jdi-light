(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[7289],{48817:function(n,r,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/button_groups",function(){return t(41599)}])},41599:function(n,r,t){"use strict";t.r(r),t.d(r,{default:function(){return a}});var e=t(85893),i=(t(67294),t(43832)),o=t(80343),c=t(82453);function a(){return(0,e.jsx)(i.Z,{maxWidth:"xl",children:(0,e.jsx)(o.Z,{my:4,children:(0,e.jsx)(c.Z,{})})})}},82453:function(n,r,t){"use strict";t.d(r,{Z:function(){return C}});var e=t(85893),i=t(67294),o=t(282),c=t(24837),a=t(41120),l=(0,a.Z)((function(n){return{root:{display:"flex",flexDirection:"column",alignItems:"center","& > *":{margin:n.spacing(1)}}}}));function u(){var n=l(),r=(0,i.useState)(""),t=r[0],a=r[1],u=function(n){a(n.target.textContent)};return(0,e.jsxs)("div",{className:n.root,children:[(0,e.jsxs)(c.Z,{color:"primary","aria-label":"outlined primary button group",children:[(0,e.jsx)(o.Z,{onClick:function(n){return u(n)},children:"One"}),(0,e.jsx)(o.Z,{onClick:function(n){return u(n)},children:"Two"}),(0,e.jsx)(o.Z,{onClick:function(n){return u(n)},children:"Three"})]}),(0,e.jsxs)("p",{id:"basicLastClick",children:["Last click: ",t]})]})}var s=(0,a.Z)((function(n){return{root:{display:"flex","& > *":{margin:n.spacing(1)}}}}));function f(){var n=s(),r=(0,i.useState)(""),t=r[0],a=r[1],l=function(n){a(n.target.textContent)};return(0,e.jsxs)("div",{className:n.root,children:[(0,e.jsxs)(c.Z,{orientation:"vertical",color:"primary","aria-label":"vertical contained primary button group",variant:"contained",children:[(0,e.jsx)(o.Z,{onClick:function(n){return l(n)},children:"One"}),(0,e.jsx)(o.Z,{onClick:function(n){return l(n)},children:"Two"}),(0,e.jsx)(o.Z,{onClick:function(n){return l(n)},children:"Three"})]}),(0,e.jsxs)("p",{id:"verticalLastClick",children:["Last click: ",t]})]})}var d=t(41749),h=t(89039),p=t(52795),m=t(20170),x=t(79895),j=t(84872),b=t(85639),y=t(29829);function v(n,r){(null==r||r>n.length)&&(r=n.length);for(var t=0,e=new Array(r);t<r;t++)e[t]=n[t];return e}function g(n,r,t){return r in n?Object.defineProperty(n,r,{value:t,enumerable:!0,configurable:!0,writable:!0}):n[r]=t,n}function Z(n,r){return function(n){if(Array.isArray(n))return n}(n)||function(n,r){var t=null==n?null:"undefined"!==typeof Symbol&&n[Symbol.iterator]||n["@@iterator"];if(null!=t){var e,i,o=[],c=!0,a=!1;try{for(t=t.call(n);!(c=(e=t.next()).done)&&(o.push(e.value),!r||o.length!==r);c=!0);}catch(l){a=!0,i=l}finally{try{c||null==t.return||t.return()}finally{if(a)throw i}}return o}}(n,r)||function(n,r){if(!n)return;if("string"===typeof n)return v(n,r);var t=Object.prototype.toString.call(n).slice(8,-1);"Object"===t&&n.constructor&&(t=n.constructor.name);if("Map"===t||"Set"===t)return Array.from(t);if("Arguments"===t||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(t))return v(n,r)}(n,r)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}var k=["Create a merge commit","Squash and merge","Rebase and merge"];function w(){var n=Z(i.useState(!1),2),r=n[0],t=n[1],a=i.useRef(null),l=Z(i.useState(1),2),u=l[0],s=l[1],f=function(n){a.current&&a.current.contains(n.target)||t(!1)};return(0,e.jsx)(d.Z,{container:!0,direction:"column",alignItems:"center",children:(0,e.jsxs)(d.Z,{item:!0,xs:12,children:[(0,e.jsxs)(c.Z,{variant:"contained",color:"primary",ref:a,"aria-label":"split button",children:[(0,e.jsx)(o.Z,{onClick:function(){console.info("You clicked ".concat(k[u]))},children:k[u]}),(0,e.jsx)(o.Z,{color:"primary",size:"small","aria-controls":r?"split-button-menu":void 0,"aria-expanded":r?"true":void 0,"aria-label":"select merge strategy","aria-haspopup":"menu",onClick:function(){t((function(n){return!n}))},children:(0,e.jsx)(h.Z,{})})]}),(0,e.jsx)(j.Z,{open:r,anchorEl:a.current,role:void 0,transition:!0,disablePortal:!0,children:function(n){var r=n.TransitionProps,i=n.placement;return(0,e.jsx)(m.Z,function(n){for(var r=1;r<arguments.length;r++){var t=null!=arguments[r]?arguments[r]:{},e=Object.keys(t);"function"===typeof Object.getOwnPropertySymbols&&(e=e.concat(Object.getOwnPropertySymbols(t).filter((function(n){return Object.getOwnPropertyDescriptor(t,n).enumerable})))),e.forEach((function(r){g(n,r,t[r])}))}return n}({},r,{style:{transformOrigin:"bottom"===i?"center top":"center bottom"},children:(0,e.jsx)(x.Z,{children:(0,e.jsx)(p.Z,{onClickAway:f,children:(0,e.jsx)(y.Z,{id:"split-button-menu",children:k.map((function(n,r){return(0,e.jsx)(b.Z,{disabled:2===r,selected:r===u,onClick:function(n){return function(n,r){s(r),t(!1)}(0,r)},children:n},n)}))})})})}))}})]})})}function C(){for(var n=arguments.length,r=new Array(n),t=0;t<n;t++)r[t]=arguments[t];return(0,e.jsxs)("div",{children:[(0,e.jsx)("h1",{children:"Button Groups"}),(0,e.jsx)("h2",{children:"Basic button groups"}),(0,e.jsx)(u,{id:"basicBtnGroups"}),(0,e.jsx)("h2",{children:"Vertical button groups"}),(0,e.jsx)(f,{id:"verticalBtnGroups"}),(0,e.jsx)("h2",{children:"Split button"}),(0,e.jsx)(w,{id:"splitBtnGroups"})]})}}},function(n){n.O(0,[7431,7815,7644,4626,9774,2888,179],(function(){return r=48817,n(n.s=r);var r}));var r=n.O();_N_E=r}]);