(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[7957],{38396:function(e,n,t){"use strict";var r=t(87462),o=t(45987),i=t(67294),s=(t(59864),t(86010)),l=t(1591),a=t(52387),u=t(29829),c=t(73935),d=t(34236),p=t(8920),m={vertical:"top",horizontal:"right"},f={vertical:"top",horizontal:"left"},h=i.forwardRef((function(e,n){var t=e.autoFocus,l=void 0===t||t,h=e.children,v=e.classes,b=e.disableAutoFocusItem,g=void 0!==b&&b,Z=e.MenuListProps,y=void 0===Z?{}:Z,x=e.onClose,C=e.onEntering,w=e.open,P=e.PaperProps,E=void 0===P?{}:P,j=e.PopoverClasses,_=e.transitionDuration,k=void 0===_?"auto":_,I=e.TransitionProps,M=(I=void 0===I?{}:I).onEntering,N=(0,o.Z)(I,["onEntering"]),S=e.variant,D=void 0===S?"selectedMenu":S,A=(0,o.Z)(e,["autoFocus","children","classes","disableAutoFocusItem","MenuListProps","onClose","onEntering","open","PaperProps","PopoverClasses","transitionDuration","TransitionProps","variant"]),O=(0,p.Z)(),T=l&&!g&&w,F=i.useRef(null),X=i.useRef(null),Y=-1;i.Children.map(h,(function(e,n){i.isValidElement(e)&&(e.props.disabled||("menu"!==D&&e.props.selected||-1===Y)&&(Y=n))}));var H=i.Children.map(h,(function(e,n){return n===Y?i.cloneElement(e,{ref:function(n){X.current=c.findDOMNode(n),(0,d.Z)(e.ref,n)}}):e}));return i.createElement(a.ZP,(0,r.Z)({getContentAnchorEl:function(){return X.current},classes:j,onClose:x,TransitionProps:(0,r.Z)({onEntering:function(e,n){F.current&&F.current.adjustStyleForScrollbar(e,O),C&&C(e,n),M&&M(e,n)}},N),anchorOrigin:"rtl"===O.direction?m:f,transformOrigin:"rtl"===O.direction?m:f,PaperProps:(0,r.Z)({},E,{classes:(0,r.Z)({},E.classes,{root:v.paper})}),open:w,ref:n,transitionDuration:k},A),i.createElement(u.Z,(0,r.Z)({onKeyDown:function(e){"Tab"===e.key&&(e.preventDefault(),x&&x(e,"tabKeyDown"))},actions:F,autoFocus:l&&(-1===Y||g),autoFocusItem:T,variant:D},y,{className:(0,s.Z)(v.list,y.className)}),H))}));n.Z=(0,l.Z)({paper:{maxHeight:"calc(100% - 96px)",WebkitOverflowScrolling:"touch"},list:{outline:0}},{name:"MuiMenu"})(h)},85639:function(e,n,t){"use strict";var r=t(45987),o=t(4942),i=t(87462),s=t(67294),l=t(86010),a=t(1591),u=t(50998),c=s.forwardRef((function(e,n){var t,o=e.classes,a=e.className,c=e.component,d=void 0===c?"li":c,p=e.disableGutters,m=void 0!==p&&p,f=e.ListItemClasses,h=e.role,v=void 0===h?"menuitem":h,b=e.selected,g=e.tabIndex,Z=(0,r.Z)(e,["classes","className","component","disableGutters","ListItemClasses","role","selected","tabIndex"]);return e.disabled||(t=void 0!==g?g:-1),s.createElement(u.Z,(0,i.Z)({button:!0,role:v,tabIndex:t,component:d,selected:b,disableGutters:m,classes:(0,i.Z)({dense:o.dense},f),className:(0,l.Z)(o.root,a,b&&o.selected,!m&&o.gutters),ref:n},Z))}));n.Z=(0,a.Z)((function(e){return{root:(0,i.Z)({},e.typography.body1,(0,o.Z)({minHeight:48,paddingTop:6,paddingBottom:6,boxSizing:"border-box",width:"auto",overflow:"hidden",whiteSpace:"nowrap"},e.breakpoints.up("sm"),{minHeight:"auto"})),gutters:{},selected:{},dense:(0,i.Z)({},e.typography.body2,{minHeight:"auto"})}}),{name:"MuiMenuItem"})(c)},40317:function(e,n,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/context_menu",function(){return t(54286)}])},54286:function(e,n,t){"use strict";t.r(n),t.d(n,{default:function(){return f}});var r=t(85893),o=t(67294),i=t(43832),s=t(80343),l=t(38396),a=t(85639),u=t(22318);function c(e,n){(null==n||n>e.length)&&(n=e.length);for(var t=0,r=new Array(n);t<n;t++)r[t]=e[t];return r}function d(e,n){return function(e){if(Array.isArray(e))return e}(e)||function(e,n){var t=null==e?null:"undefined"!==typeof Symbol&&e[Symbol.iterator]||e["@@iterator"];if(null!=t){var r,o,i=[],s=!0,l=!1;try{for(t=t.call(e);!(s=(r=t.next()).done)&&(i.push(r.value),!n||i.length!==n);s=!0);}catch(a){l=!0,o=a}finally{try{s||null==t.return||t.return()}finally{if(l)throw o}}return i}}(e,n)||function(e,n){if(!e)return;if("string"===typeof e)return c(e,n);var t=Object.prototype.toString.call(e).slice(8,-1);"Object"===t&&e.constructor&&(t=e.constructor.name);if("Map"===t||"Set"===t)return Array.from(t);if("Arguments"===t||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(t))return c(e,n)}(e,n)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}var p={mouseX:null,mouseY:null};function m(){var e=d(o.useState(p),2),n=e[0],t=e[1],i=function(){t(p)};return(0,r.jsxs)("div",{children:[(0,r.jsx)("h1",{children:"Context Menu"}),(0,r.jsxs)("div",{onContextMenu:function(e){e.preventDefault(),t({mouseX:e.clientX-2,mouseY:e.clientY-4})},style:{cursor:"context-menu"},children:[(0,r.jsx)(u.Z,{children:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ipsum purus, bibendum sit amet vulputate eget, porta semper ligula. Donec bibendum vulputate erat, ac fringilla mi finibus nec. Donec ac dolor sed dolor porttitor blandit vel vel purus."}),(0,r.jsxs)(l.Z,{keepMounted:!0,open:null!==n.mouseY,onClose:i,anchorReference:"anchorPosition",anchorPosition:null!==n.mouseY&&null!==n.mouseX?{top:n.mouseY,left:n.mouseX}:void 0,children:[(0,r.jsx)(a.Z,{onClick:i,children:"Copy"}),(0,r.jsx)(a.Z,{onClick:i,children:"Print"}),(0,r.jsx)(a.Z,{onClick:i,children:"Highlight"}),(0,r.jsx)(a.Z,{onClick:i,children:"Email"})]})]})]})}function f(){return(0,r.jsx)(i.Z,{maxWidth:"xl",children:(0,r.jsx)(s.Z,{my:4,children:(0,r.jsx)(m,{})})})}}},function(e){e.O(0,[7431,6517,7815,2387,9774,2888,179],(function(){return n=40317,e(e.s=n);var n}));var n=e.O();_N_E=n}]);