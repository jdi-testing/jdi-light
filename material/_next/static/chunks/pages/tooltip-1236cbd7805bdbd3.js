(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[9688],{33758:function(e,t,o){"use strict";var n=o(45987),i=o(87462),r=o(67294),a=o(86010),l=o(1591),d=o(4024),s=o(93871),c=r.forwardRef((function(e,t){var o=e.children,l=e.classes,c=e.className,u=e.color,h=void 0===u?"default":u,p=e.component,f=void 0===p?"button":p,m=e.disabled,b=void 0!==m&&m,g=e.disableFocusRipple,v=void 0!==g&&g,y=e.focusVisibleClassName,x=e.size,Z=void 0===x?"large":x,j=e.variant,w=void 0===j?"circular":j,E=(0,n.Z)(e,["children","classes","className","color","component","disabled","disableFocusRipple","focusVisibleClassName","size","variant"]);return r.createElement(d.Z,(0,i.Z)({className:(0,a.Z)(l.root,c,"large"!==Z&&l["size".concat((0,s.Z)(Z))],b&&l.disabled,"extended"===w&&l.extended,{primary:l.primary,secondary:l.secondary,inherit:l.colorInherit}[h]),component:f,disabled:b,focusRipple:!v,focusVisibleClassName:(0,a.Z)(l.focusVisible,y),ref:t},E),r.createElement("span",{className:l.label},o))}));t.Z=(0,l.Z)((function(e){return{root:(0,i.Z)({},e.typography.button,{boxSizing:"border-box",minHeight:36,transition:e.transitions.create(["background-color","box-shadow","border"],{duration:e.transitions.duration.short}),borderRadius:"50%",padding:0,minWidth:0,width:56,height:56,boxShadow:e.shadows[6],"&:active":{boxShadow:e.shadows[12]},color:e.palette.getContrastText(e.palette.grey[300]),backgroundColor:e.palette.grey[300],"&:hover":{backgroundColor:e.palette.grey.A100,"@media (hover: none)":{backgroundColor:e.palette.grey[300]},"&$disabled":{backgroundColor:e.palette.action.disabledBackground},textDecoration:"none"},"&$focusVisible":{boxShadow:e.shadows[6]},"&$disabled":{color:e.palette.action.disabled,boxShadow:e.shadows[0],backgroundColor:e.palette.action.disabledBackground}}),label:{width:"100%",display:"inherit",alignItems:"inherit",justifyContent:"inherit"},primary:{color:e.palette.primary.contrastText,backgroundColor:e.palette.primary.main,"&:hover":{backgroundColor:e.palette.primary.dark,"@media (hover: none)":{backgroundColor:e.palette.primary.main}}},secondary:{color:e.palette.secondary.contrastText,backgroundColor:e.palette.secondary.main,"&:hover":{backgroundColor:e.palette.secondary.dark,"@media (hover: none)":{backgroundColor:e.palette.secondary.main}}},extended:{borderRadius:24,padding:"0 16px",width:"auto",minHeight:"auto",minWidth:48,height:48,"&$sizeSmall":{width:"auto",padding:"0 8px",borderRadius:17,minWidth:34,height:34},"&$sizeMedium":{width:"auto",padding:"0 16px",borderRadius:20,minWidth:40,height:40}},focusVisible:{},disabled:{},colorInherit:{color:"inherit"},sizeSmall:{width:40,height:40},sizeMedium:{width:48,height:48}}}),{name:"MuiFab"})(c)},20170:function(e,t,o){"use strict";var n=o(87462),i=o(97685),r=o(45987),a=o(67294),l=o(98885),d=o(8920),s=o(5653),c=o(17294);function u(e){return"scale(".concat(e,", ").concat(Math.pow(e,2),")")}var h={entering:{opacity:1,transform:u(1)},entered:{opacity:1,transform:"none"}},p=a.forwardRef((function(e,t){var o=e.children,p=e.disableStrictModeCompat,f=void 0!==p&&p,m=e.in,b=e.onEnter,g=e.onEntered,v=e.onEntering,y=e.onExit,x=e.onExited,Z=e.onExiting,j=e.style,w=e.timeout,E=void 0===w?"auto":w,C=e.TransitionComponent,k=void 0===C?l.ZP:C,T=(0,r.Z)(e,["children","disableStrictModeCompat","in","onEnter","onEntered","onEntering","onExit","onExited","onExiting","style","timeout","TransitionComponent"]),S=a.useRef(),R=a.useRef(),A=(0,d.Z)(),P=A.unstable_strictMode&&!f,z=a.useRef(null),N=(0,c.Z)(o.ref,t),O=(0,c.Z)(P?z:void 0,N),I=function(e){return function(t,o){if(e){var n=P?[z.current,t]:[t,o],r=(0,i.Z)(n,2),a=r[0],l=r[1];void 0===l?e(a):e(a,l)}}},L=I(v),F=I((function(e,t){(0,s.n)(e);var o,n=(0,s.C)({style:j,timeout:E},{mode:"enter"}),i=n.duration,r=n.delay;"auto"===E?(o=A.transitions.getAutoHeightDuration(e.clientHeight),R.current=o):o=i,e.style.transition=[A.transitions.create("opacity",{duration:o,delay:r}),A.transitions.create("transform",{duration:.666*o,delay:r})].join(","),b&&b(e,t)})),H=I(g),M=I(Z),_=I((function(e){var t,o=(0,s.C)({style:j,timeout:E},{mode:"exit"}),n=o.duration,i=o.delay;"auto"===E?(t=A.transitions.getAutoHeightDuration(e.clientHeight),R.current=t):t=n,e.style.transition=[A.transitions.create("opacity",{duration:t,delay:i}),A.transitions.create("transform",{duration:.666*t,delay:i||.333*t})].join(","),e.style.opacity="0",e.style.transform=u(.75),y&&y(e)})),V=I(x);return a.useEffect((function(){return function(){clearTimeout(S.current)}}),[]),a.createElement(k,(0,n.Z)({appear:!0,in:m,nodeRef:P?z:void 0,onEnter:F,onEntered:H,onEntering:L,onExit:_,onExited:V,onExiting:M,addEndListener:function(e,t){var o=P?e:t;"auto"===E&&(S.current=setTimeout(o,R.current||0))},timeout:"auto"===E?null:E},T),(function(e,t){return a.cloneElement(o,(0,n.Z)({style:(0,n.Z)({opacity:0,transform:u(.75),visibility:"exited"!==e||m?void 0:"hidden"},h[e],j,o.props.style),ref:O},t))}))}));p.muiSupportAuto=!0,t.Z=p},17812:function(e,t,o){"use strict";var n=o(87462),i=o(45987),r=o(67294),a=o(86010),l=o(1591),d=o(59693),s=o(4024),c=o(93871),u=r.forwardRef((function(e,t){var o=e.edge,l=void 0!==o&&o,d=e.children,u=e.classes,h=e.className,p=e.color,f=void 0===p?"default":p,m=e.disabled,b=void 0!==m&&m,g=e.disableFocusRipple,v=void 0!==g&&g,y=e.size,x=void 0===y?"medium":y,Z=(0,i.Z)(e,["edge","children","classes","className","color","disabled","disableFocusRipple","size"]);return r.createElement(s.Z,(0,n.Z)({className:(0,a.Z)(u.root,h,"default"!==f&&u["color".concat((0,c.Z)(f))],b&&u.disabled,"small"===x&&u["size".concat((0,c.Z)(x))],{start:u.edgeStart,end:u.edgeEnd}[l]),centerRipple:!0,focusRipple:!v,disabled:b,ref:t},Z),r.createElement("span",{className:u.label},d))}));t.Z=(0,l.Z)((function(e){return{root:{textAlign:"center",flex:"0 0 auto",fontSize:e.typography.pxToRem(24),padding:12,borderRadius:"50%",overflow:"visible",color:e.palette.action.active,transition:e.transitions.create("background-color",{duration:e.transitions.duration.shortest}),"&:hover":{backgroundColor:(0,d.Fq)(e.palette.action.active,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}},"&$disabled":{backgroundColor:"transparent",color:e.palette.action.disabled}},edgeStart:{marginLeft:-12,"$sizeSmall&":{marginLeft:-3}},edgeEnd:{marginRight:-12,"$sizeSmall&":{marginRight:-3}},colorInherit:{color:"inherit"},colorPrimary:{color:e.palette.primary.main,"&:hover":{backgroundColor:(0,d.Fq)(e.palette.primary.main,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}}},colorSecondary:{color:e.palette.secondary.main,"&:hover":{backgroundColor:(0,d.Fq)(e.palette.secondary.main,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}}},disabled:{},sizeSmall:{padding:3,fontSize:e.typography.pxToRem(18)},label:{width:"100%",display:"flex",alignItems:"inherit",justifyContent:"inherit"}}}),{name:"MuiIconButton"})(u)},76234:function(e,t,o){"use strict";var n=o(67294),i=o(73935),r=o(34236),a=o(17294);var l="undefined"!==typeof window?n.useLayoutEffect:n.useEffect,d=n.forwardRef((function(e,t){var o=e.children,d=e.container,s=e.disablePortal,c=void 0!==s&&s,u=e.onRendered,h=n.useState(null),p=h[0],f=h[1],m=(0,a.Z)(n.isValidElement(o)?o.ref:null,t);return l((function(){c||f(function(e){return e="function"===typeof e?e():e,i.findDOMNode(e)}(d)||document.body)}),[d,c]),l((function(){if(p&&!c)return(0,r.Z)(t,p),function(){(0,r.Z)(t,null)}}),[t,p,c]),l((function(){u&&(p||c)&&u()}),[u,p,c]),c?n.isValidElement(o)?n.cloneElement(o,{ref:m}):o:p?i.createPortal(o,p):p}));t.Z=d},41120:function(e,t,o){"use strict";var n=o(87462),i=o(11719),r=o(99700);t.Z=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(0,i.Z)(e,(0,n.Z)({defaultTheme:r.Z},t))}},63957:function(e,t,o){"use strict";var n=o(95318),i=o(20862);t.Z=void 0;var r=i(o(67294)),a=(0,n(o(2108)).default)(r.createElement("path",{d:"M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"}),"Add");t.Z=a},88646:function(e,t,o){(window.__NEXT_P=window.__NEXT_P||[]).push(["/tooltip",function(){return o(21265)}])},21265:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return A}});var n=o(85893),i=o(67294),r=o(43832),a=o(80343),l=o(41120),d=o(63957),s=o(33758),c=o(28428),u=o(17812),h=o(868),p=o(1591),f=o(282),m=o(22318);function b(e,t,o){return t in e?Object.defineProperty(e,t,{value:o,enumerable:!0,configurable:!0,writable:!0}):e[t]=o,e}var g=(0,p.Z)((function(e){return{tooltip:{backgroundColor:e.palette.common.white,color:"rgba(0, 0, 0, 0.87)",boxShadow:e.shadows[1],fontSize:11}}}))(h.ZP),v=(0,l.Z)((function(e){return{arrow:{color:e.palette.common.black},tooltip:{backgroundColor:e.palette.common.black}}}));function y(e){var t=v();return(0,n.jsx)(h.ZP,function(e){for(var t=1;t<arguments.length;t++){var o=null!=arguments[t]?arguments[t]:{},n=Object.keys(o);"function"===typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(o).filter((function(e){return Object.getOwnPropertyDescriptor(o,e).enumerable})))),n.forEach((function(t){b(e,t,o[t])}))}return e}({arrow:!0,classes:t},e))}var x=(0,p.Z)((function(e){return{tooltip:{backgroundColor:"#f5f5f9",color:"rgba(0, 0, 0, 0.87)",maxWidth:220,fontSize:e.typography.pxToRem(12),border:"1px solid #dadde9"}}}))(h.ZP);function Z(){return(0,n.jsxs)("div",{children:[(0,n.jsx)(g,{title:"Add",id:"lightTooltip",children:(0,n.jsx)(f.Z,{children:"Light"})}),(0,n.jsx)(y,{title:"Add",id:"bootstrapTooltip",children:(0,n.jsx)(f.Z,{children:"Bootstrap"})}),(0,n.jsx)(x,{id:"htmlTooltip",title:(0,n.jsxs)(i.Fragment,{children:[(0,n.jsx)(m.Z,{color:"inherit",children:"Tooltip with HTML"}),(0,n.jsx)("em",{children:"And here's"})," ",(0,n.jsx)("b",{children:"some"})," ",(0,n.jsx)("u",{children:"amazing content"}),"."," ","It's very engaging. Right?"]}),children:(0,n.jsx)(f.Z,{children:"HTML"})})]})}var j=o(41749),w=o(52795);function E(e,t){(null==t||t>e.length)&&(t=e.length);for(var o=0,n=new Array(t);o<t;o++)n[o]=e[o];return n}function C(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){var o=null==e?null:"undefined"!==typeof Symbol&&e[Symbol.iterator]||e["@@iterator"];if(null!=o){var n,i,r=[],a=!0,l=!1;try{for(o=o.call(e);!(a=(n=o.next()).done)&&(r.push(n.value),!t||r.length!==t);a=!0);}catch(d){l=!0,i=d}finally{try{a||null==o.return||o.return()}finally{if(l)throw i}}return r}}(e,t)||function(e,t){if(!e)return;if("string"===typeof e)return E(e,t);var o=Object.prototype.toString.call(e).slice(8,-1);"Object"===o&&e.constructor&&(o=e.constructor.name);if("Map"===o||"Set"===o)return Array.from(o);if("Arguments"===o||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o))return E(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function k(){var e=C(i.useState(!1),2),t=e[0],o=e[1],r=function(){o(!1)};return(0,n.jsx)("div",{children:(0,n.jsxs)(j.Z,{container:!0,justify:"center",children:[(0,n.jsx)(j.Z,{item:!0,id:"touchItem",children:(0,n.jsx)(h.ZP,{disableFocusListener:!0,title:"Add",id:"touchTooltip",children:(0,n.jsx)(f.Z,{children:"Hover or touch"})})}),(0,n.jsx)(j.Z,{item:!0,id:"focusItem",children:(0,n.jsx)(h.ZP,{disableHoverListener:!0,title:"Add",id:"focusTooltip",children:(0,n.jsx)(f.Z,{children:"Focus or touch"})})}),(0,n.jsx)(j.Z,{item:!0,id:"hoverItem",children:(0,n.jsx)(h.ZP,{disableFocusListener:!0,disableTouchListener:!0,title:"Add",id:"hoverTooltip",children:(0,n.jsx)(f.Z,{children:"Hover"})})}),(0,n.jsx)(j.Z,{item:!0,id:"clickItem",children:(0,n.jsx)(w.Z,{onClickAway:r,children:(0,n.jsx)("div",{children:(0,n.jsx)(h.ZP,{PopperProps:{disablePortal:!0},onClose:r,open:t,disableFocusListener:!0,disableHoverListener:!0,disableTouchListener:!0,title:"Add",id:"clickTooltip",children:(0,n.jsx)(f.Z,{onClick:function(){o(!0)},children:"Click"})})})})})]})})}function T(){return(0,n.jsx)(h.ZP,{title:"You don't have permission to do this",id:"disableTooltip",children:(0,n.jsx)("span",{children:(0,n.jsx)(f.Z,{disabled:!0,id:"disabledBtn",children:"A Disabled Button"})})})}var S=(0,l.Z)((function(e){return{fab:{margin:e.spacing(2)},absolute:{position:"absolute",bottom:e.spacing(2),right:e.spacing(3)}}}));function R(){var e=S();return(0,n.jsxs)("div",{children:[(0,n.jsx)("h1",{children:"Tooltips"}),(0,n.jsx)("h2",{children:"Simple tooltips"}),(0,n.jsxs)("div",{children:[(0,n.jsx)(h.ZP,{title:"Delete",id:"deleteTooltip",children:(0,n.jsx)(u.Z,{"aria-label":"delete",id:"deleteBtn",children:(0,n.jsx)(c.Z,{})})}),(0,n.jsx)(h.ZP,{title:"Add","aria-label":"add",id:"primaryAddTooltip",children:(0,n.jsx)(s.Z,{color:"primary",className:e.fab,children:(0,n.jsx)(d.Z,{})})}),(0,n.jsx)(h.ZP,{title:"Add","aria-label":"add",id:"secondaryAddTooltip",children:(0,n.jsx)(s.Z,{color:"secondary",className:e.absolute,children:(0,n.jsx)(d.Z,{})})})]}),(0,n.jsx)("h2",{children:"Customizable tooltips"}),(0,n.jsx)(Z,{id:"customTooltips"}),(0,n.jsx)("h2",{children:"Triggered tooltips"}),(0,n.jsx)(k,{id:"triggeredTooltips"}),(0,n.jsx)("h2",{children:"Disabled elements"}),(0,n.jsx)(T,{id:"disabledElementsTooltips"})]})}function A(){return(0,n.jsx)(r.Z,{maxWidth:"xl",children:(0,n.jsx)(a.Z,{my:4,children:(0,n.jsx)(R,{})})})}}},function(e){e.O(0,[7431,7644,4184,9774,2888,179],(function(){return t=88646,e(e.s=t);var t}));var t=e.O();_N_E=t}]);