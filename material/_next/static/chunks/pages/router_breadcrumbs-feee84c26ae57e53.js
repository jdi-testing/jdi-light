(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[6097],{54025:function(n,r,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/router_breadcrumbs",function(){return t(90337)}])},90337:function(n,r,t){"use strict";t.r(r),t.d(r,{default:function(){return S}});var e=t(85893),o=t(67294),i=t(43832),a=t(7560),l=t(45697),c=t.n(l),u=t(41120),s=t(62822),f=t(89659),d=t(50998),p=t(66037),x=t(95757),b=t(22318),h=t(35025),j=t(64566),m=t(7885),y=t(76775),v=t(73727);function g(n,r,t){return r in n?Object.defineProperty(n,r,{value:t,enumerable:!0,configurable:!0,writable:!0}):n[r]=t,n}function O(n){for(var r=1;r<arguments.length;r++){var t=null!=arguments[r]?arguments[r]:{},e=Object.keys(t);"function"===typeof Object.getOwnPropertySymbols&&(e=e.concat(Object.getOwnPropertySymbols(t).filter((function(n){return Object.getOwnPropertyDescriptor(t,n).enumerable})))),e.forEach((function(r){g(n,r,t[r])}))}return n}function w(n,r){if(null==n)return{};var t,e,o=function(n,r){if(null==n)return{};var t,e,o={},i=Object.keys(n);for(e=0;e<i.length;e++)t=i[e],r.indexOf(t)>=0||(o[t]=n[t]);return o}(n,r);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(n);for(e=0;e<i.length;e++)t=i[e],r.indexOf(t)>=0||Object.prototype.propertyIsEnumerable.call(n,t)&&(o[t]=n[t])}return o}function Z(n,r){return function(n){if(Array.isArray(n))return n}(n)||function(n,r){var t=[],e=!0,o=!1,i=void 0;try{for(var a,l=n[Symbol.iterator]();!(e=(a=l.next()).done)&&(t.push(a.value),!r||t.length!==r);e=!0);}catch(c){o=!0,i=c}finally{try{e||null==l.return||l.return()}finally{if(o)throw i}}return t}(n,r)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var _={"/inbox":"Inbox","/inbox/important":"Important","/trash":"Trash","/spam":"Spam","/drafts":"Drafts"};function E(n){var r=n.to,t=n.open,o=w(n,["to","open"]),i=_[r];return(0,e.jsx)("li",{children:(0,e.jsxs)(d.Z,O({button:!0,component:v.rU,to:r},o,{children:[(0,e.jsx)(x.Z,{primary:i}),null!=t?t?(0,e.jsx)(h.Z,{}):(0,e.jsx)(j.Z,{}):null]}))})}E.propTypes={open:c().bool,to:c().string.isRequired};var P=(0,u.Z)((function(n){return{root:{display:"flex",flexDirection:"column",width:360},lists:{backgroundColor:n.palette.background.paper,marginTop:n.spacing(1)},nested:{paddingLeft:n.spacing(4)}}})),k=function(n){return(0,e.jsx)(f.Z,O({},n,{component:v.rU}))};function N(){var n=P(),r=Z(o.useState(!0),2),t=r[0],i=r[1];return(0,e.jsx)(y.VA,{initialEntries:["/inbox"],initialIndex:0,children:(0,e.jsxs)("div",{children:[(0,e.jsx)("h1",{children:"Router Breadcrumbs"}),(0,e.jsxs)("div",{className:n.root,children:[(0,e.jsx)(y.AW,{children:function(n){var r=n.location.pathname.split("/").filter((function(n){return n}));return(0,e.jsxs)(m.Z,{"aria-label":"breadcrumb",children:[(0,e.jsx)(k,{color:"inherit",to:"/",children:"Home"}),r.map((function(n,t){var o=t===r.length-1,i="/".concat(r.slice(0,t+1).join("/"));return o?(0,e.jsx)(b.Z,{color:"textPrimary",children:_[i]},i):(0,e.jsx)(k,{color:"inherit",to:i,children:_[i]},i)}))]})}}),(0,e.jsx)("nav",{className:n.lists,"aria-label":"mailbox folders",children:(0,e.jsxs)(s.Z,{children:[(0,e.jsx)(E,{to:"/inbox",open:t,onClick:function(){i((function(n){return!n}))}}),(0,e.jsx)(p.Z,{component:"li",in:t,timeout:"auto",unmountOnExit:!0,children:(0,e.jsx)(s.Z,{disablePadding:!0,children:(0,e.jsx)(E,{to:"/inbox/important",className:n.nested})})}),(0,e.jsx)(E,{to:"/trash"}),(0,e.jsx)(E,{to:"/spam"})]})})]})]})})}function S(){return(0,e.jsx)(i.Z,{maxWidth:"xl",children:(0,e.jsx)(a.Z,{my:4,children:(0,e.jsx)(N,{})})})}}},function(n){n.O(0,[5770,9535,9774,2888,179],(function(){return r=54025,n(n.s=r);var r}));var r=n.O();_N_E=r}]);