_N_E=(window.webpackJsonp_N_E=window.webpackJsonp_N_E||[]).push([[77],{"0iZo":function(e,t,r){(window.__NEXT_P=window.__NEXT_P||[]).push(["/progress",function(){return r("XJ3o")}])},"5rCv":function(e,t,r){"use strict";var n=r("TqRt"),a=r("284h");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var i=a(r("q1tI")),o=(0,n(r("8/g6")).default)(i.createElement("path",{d:"M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"}),"Check");t.default=o},XJ3o:function(e,t,r){"use strict";r.r(t),r.d(t,"default",(function(){return oe}));var n=r("nKUr"),a=r("q1tI"),i=r.n(a),o=r("Ji2X"),c=r("hlFM"),s=r("rePB"),l=r("R/WZ"),d=r("iae6");function u(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function b(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?u(Object(r),!0).forEach((function(t){Object(s.a)(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):u(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}var j=Object(l.a)((function(e){return{root:{display:"flex","& > * + *":{marginLeft:e.spacing(2)}}}}));function f(e){var t=j();return Object(n.jsx)("div",{className:t.root,children:Object(n.jsx)(d.a,b({},e))})}var O=r("ODXe"),p=Object(l.a)((function(e){return{root:{display:"flex","& > * + *":{marginLeft:e.spacing(2)}}}}));function h(){var e=p(),t=i.a.useState(0),r=Object(O.a)(t,2),a=r[0],o=r[1];return i.a.useEffect((function(){var e=setInterval((function(){o((function(e){return e>=100?0:e+10}))}),800);return function(){clearInterval(e)}}),[]),Object(n.jsxs)("div",{className:e.root,children:[Object(n.jsx)(d.a,{variant:"determinate",value:25}),Object(n.jsx)(d.a,{variant:"determinate",value:50}),Object(n.jsx)(d.a,{variant:"determinate",value:75}),Object(n.jsx)(d.a,{variant:"determinate",value:100}),Object(n.jsx)(d.a,{variant:"determinate",value:a}),Object(n.jsx)(d.a,{disableShrink:!0})]})}var m=r("iuhU"),v=r("6yBS"),y=r("Z3vd"),g=r("XX3T"),x=r("5rCv"),w=r.n(x),k=r("hQyO"),P=r.n(k),E=Object(l.a)((function(e){return{root:{display:"flex",alignItems:"center"},wrapper:{margin:e.spacing(1),position:"relative"},buttonSuccess:{backgroundColor:v.a[500],"&:hover":{backgroundColor:v.a[700]}},fabProgress:{color:v.a[500],position:"absolute",top:-6,left:-6,zIndex:1},buttonProgress:{color:v.a[500],position:"absolute",top:"50%",left:"50%",marginTop:-12,marginLeft:-12}}}));function S(){var e=E(),t=i.a.useState(!1),r=Object(O.a)(t,2),a=r[0],o=r[1],c=i.a.useState(!1),l=Object(O.a)(c,2),u=l[0],b=l[1],j=i.a.useRef(),f=Object(m.a)(Object(s.a)({},e.buttonSuccess,u));i.a.useEffect((function(){clearTimeout(j.current)}),[]);var p=function(){a||(b(!1),o(!0),j.current=window.setTimeout((function(){b(!0),o(!1)}),2e3))};return Object(n.jsxs)("div",{className:e.root,children:[Object(n.jsxs)("div",{className:e.wrapper,children:[Object(n.jsx)(g.a,{"aria-label":"save",color:"primary",className:f,onClick:p,children:u?Object(n.jsx)(w.a,{}):Object(n.jsx)(P.a,{})}),a&&Object(n.jsx)(d.a,{size:68,className:e.fabProgress})]}),Object(n.jsxs)("div",{className:e.wrapper,children:[Object(n.jsx)(y.a,{variant:"contained",color:"primary",className:f,disabled:a,onClick:p,children:"Accept terms"}),a&&Object(n.jsx)(d.a,{size:24,className:e.buttonProgress})]})]})}var D=r("ofer");function N(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function C(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?N(Object(r),!0).forEach((function(t){Object(s.a)(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):N(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function I(e){return Object(n.jsxs)(c.a,{position:"relative",display:"inline-flex",children:[Object(n.jsx)(d.a,C({variant:"determinate"},e)),Object(n.jsx)(c.a,{top:0,left:0,bottom:0,right:0,position:"absolute",display:"flex",alignItems:"center",justifyContent:"center",children:Object(n.jsx)(D.a,{variant:"caption",component:"div",color:"textSecondary",children:"".concat(Math.round(e.value),"%")})})]})}var T=r("de8u");function R(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function z(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?R(Object(r),!0).forEach((function(t){Object(s.a)(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):R(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}var M=Object(l.a)((function(e){return{root:{width:"100%","& > * + *":{marginTop:e.spacing(2)}}}}));function _(e){var t=M();return Object(n.jsx)("div",{className:t.root,children:Object(n.jsx)(T.a,z({},e))})}var L=Object(l.a)({root:{width:"100%"}});function X(){var e=L(),t=i.a.useState(0),r=Object(O.a)(t,2),a=r[0],o=r[1];return i.a.useEffect((function(){var e=setInterval((function(){o((function(e){if(100===e)return 0;var t=10*Math.random();return Math.min(e+t,100)}))}),500);return function(){clearInterval(e)}}),[]),Object(n.jsx)("div",{className:e.root,children:Object(n.jsx)(T.a,{variant:"determinate",value:a})})}var q=Object(l.a)({root:{width:"100%"}});function F(){var e=q(),t=i.a.useState(0),r=Object(O.a)(t,2),a=r[0],o=r[1],c=i.a.useState(10),s=Object(O.a)(c,2),l=s[0],d=s[1],u=i.a.useRef((function(){}));return i.a.useEffect((function(){u.current=function(){if(a>100)o(0),d(10);else{var e=10*Math.random(),t=10*Math.random();o(a+e),d(a+e+t)}}})),i.a.useEffect((function(){var e=setInterval((function(){u.current()}),500);return function(){clearInterval(e)}}),[]),Object(n.jsx)("div",{className:e.root,children:Object(n.jsx)(T.a,{variant:"buffer",value:a,valueBuffer:l})})}function V(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function W(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?V(Object(r),!0).forEach((function(t){Object(s.a)(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):V(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function H(e){return Object(n.jsxs)(c.a,{display:"flex",alignItems:"center",children:[Object(n.jsx)(c.a,{width:"100%",mr:1,children:Object(n.jsx)(T.a,W({variant:"determinate"},e))}),Object(n.jsx)(c.a,{minWidth:35,children:Object(n.jsx)(D.a,{variant:"body2",color:"textSecondary",children:"".concat(Math.round(e.value),"%")})})]})}var B=Object(l.a)({root:{width:"100%"}});function $(){var e=B(),t=i.a.useState(10),r=Object(O.a)(t,2),a=r[0],o=r[1];return i.a.useEffect((function(){var e=setInterval((function(){o((function(e){return e>=100?10:e+10}))}),800);return function(){clearInterval(e)}}),[]),Object(n.jsx)("div",{className:e.root,children:Object(n.jsx)(H,{value:a})})}var A=r("H2TA");function U(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function J(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?U(Object(r),!0).forEach((function(t){Object(s.a)(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):U(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}var Z=Object(A.a)((function(e){return{root:{height:10,borderRadius:5},colorPrimary:{backgroundColor:e.palette.grey["light"===e.palette.type?200:700]},bar:{borderRadius:5,backgroundColor:"#1a90ff"}}}))(T.a),K=Object(l.a)((function(e){return{root:{position:"relative"},bottom:{color:e.palette.grey["light"===e.palette.type?200:700]},top:{color:"#1a90ff",animationDuration:"550ms",position:"absolute",left:0},circle:{strokeLinecap:"round"}}}));function Q(e){var t=K();return Object(n.jsxs)("div",{className:t.root,children:[Object(n.jsx)(d.a,J(J({variant:"determinate",className:t.bottom,size:40,thickness:4},e),{},{value:100})),Object(n.jsx)(d.a,J({variant:"indeterminate",disableShrink:!0,className:t.top,classes:{circle:t.circle},size:40,thickness:4},e))]})}var G=Object(l.a)({root:{flexGrow:1}});function Y(){var e=G();return Object(n.jsxs)("div",{className:e.root,children:[Object(n.jsx)(Q,{}),Object(n.jsx)("br",{}),Object(n.jsx)(Z,{variant:"determinate",value:50})]})}var ee=r("kKU3"),te=Object(l.a)((function(e){return{root:{display:"flex",flexDirection:"column",alignItems:"center"},button:{margin:e.spacing(2)},placeholder:{height:40}}}));function re(){var e=te(),t=i.a.useState(!1),r=Object(O.a)(t,2),a=r[0],o=r[1],c=i.a.useState("idle"),s=Object(O.a)(c,2),l=s[0],u=s[1],b=i.a.useRef();i.a.useEffect((function(){return function(){clearTimeout(b.current)}}),[]);return Object(n.jsxs)("div",{className:e.root,children:[Object(n.jsx)("div",{className:e.placeholder,children:Object(n.jsx)(ee.a,{in:a,style:{transitionDelay:a?"800ms":"0ms"},unmountOnExit:!0,children:Object(n.jsx)(d.a,{})})}),Object(n.jsx)(y.a,{onClick:function(){o((function(e){return!e}))},className:e.button,children:a?"Stop loading":"Loading"}),Object(n.jsx)("div",{className:e.placeholder,children:"success"===l?Object(n.jsx)(D.a,{children:"Success!"}):Object(n.jsx)(ee.a,{in:"progress"===l,style:{transitionDelay:"progress"===l?"800ms":"0ms"},unmountOnExit:!0,children:Object(n.jsx)(d.a,{})})}),Object(n.jsx)(y.a,{onClick:function(){clearTimeout(b.current),"idle"===l?(u("progress"),b.current=window.setTimeout((function(){u("success")}),2e3)):u("idle")},className:e.button,children:"idle"!==l?"Reset":"Simulate a load"})]})}f.bind({});f.bind({}).args={color:"secondary"};h.bind({}),S.bind({});var ne=function(){var e=i.a.useState(10),t=Object(O.a)(e,2),r=t[0],a=t[1];return i.a.useEffect((function(){var e=setInterval((function(){a((function(e){return e>=100?0:e+10}))}),800);return function(){clearInterval(e)}}),[]),Object(n.jsx)(I,{value:r})}.bind({});_.bind({});_.bind({}).args={color:"secondary"};X.bind({}),F.bind({}),$.bind({}),Y.bind({}),re.bind({});var ae=Object(l.a)((function(e){return{root:{width:500}}}));function ie(){var e=ae();return Object(n.jsxs)("div",{className:e.root,children:[Object(n.jsx)("h1",{children:"Progress"}),Object(n.jsx)("h2",{children:"Circular indeterminate"}),Object(n.jsx)(f,{id:"circularIndeterminateProgress"}),Object(n.jsx)("h2",{children:"Circular determinate"}),Object(n.jsx)(h,{id:"circularDeterminateProgress"}),Object(n.jsx)("h2",{children:"Interactive integration"}),Object(n.jsx)(S,{id:"circularInteractionProgress"}),Object(n.jsx)("h2",{children:"Circular with label"}),Object(n.jsx)(ne,{id:"circularLabelProgress"}),Object(n.jsx)("h2",{children:"Linear indeterminate"}),Object(n.jsx)(_,{id:"linearIndeterminateProgress"}),Object(n.jsx)("h2",{children:"Linear determinate"}),Object(n.jsx)(X,{id:"linearDeterminateProgress"}),Object(n.jsx)("h2",{children:"Linear buffer"}),Object(n.jsx)(F,{id:"linearBufferProgress"}),Object(n.jsx)("h2",{children:"Linear with label"}),Object(n.jsx)($,{id:"linearLabelProgress"}),Object(n.jsx)("h2",{children:"Customized progress"}),Object(n.jsx)(Y,{id:"customizedProgress"}),Object(n.jsx)("h2",{children:"Delaying appearance"}),Object(n.jsx)(re,{id:"delayingAppearanceProgress"})]})}function oe(){return Object(n.jsx)(o.a,{maxWidth:"xl",children:Object(n.jsx)(c.a,{my:4,children:Object(n.jsx)(ie,{})})})}},XX3T:function(e,t,r){"use strict";var n=r("Ff2n"),a=r("wx14"),i=r("q1tI"),o=(r("17x9"),r("iuhU")),c=r("H2TA"),s=r("VD++"),l=r("NqtD"),d=i.forwardRef((function(e,t){var r=e.children,c=e.classes,d=e.className,u=e.color,b=void 0===u?"default":u,j=e.component,f=void 0===j?"button":j,O=e.disabled,p=void 0!==O&&O,h=e.disableFocusRipple,m=void 0!==h&&h,v=e.focusVisibleClassName,y=e.size,g=void 0===y?"large":y,x=e.variant,w=void 0===x?"round":x,k=Object(n.a)(e,["children","classes","className","color","component","disabled","disableFocusRipple","focusVisibleClassName","size","variant"]);return i.createElement(s.a,Object(a.a)({className:Object(o.a)(c.root,d,"round"!==w&&c.extended,"large"!==g&&c["size".concat(Object(l.a)(g))],p&&c.disabled,{primary:c.primary,secondary:c.secondary,inherit:c.colorInherit}[b]),component:f,disabled:p,focusRipple:!m,focusVisibleClassName:Object(o.a)(c.focusVisible,v),ref:t},k),i.createElement("span",{className:c.label},r))}));t.a=Object(c.a)((function(e){return{root:Object(a.a)({},e.typography.button,{boxSizing:"border-box",minHeight:36,transition:e.transitions.create(["background-color","box-shadow","border"],{duration:e.transitions.duration.short}),borderRadius:"50%",padding:0,minWidth:0,width:56,height:56,boxShadow:e.shadows[6],"&:active":{boxShadow:e.shadows[12]},color:e.palette.getContrastText(e.palette.grey[300]),backgroundColor:e.palette.grey[300],"&:hover":{backgroundColor:e.palette.grey.A100,"@media (hover: none)":{backgroundColor:e.palette.grey[300]},"&$disabled":{backgroundColor:e.palette.action.disabledBackground},textDecoration:"none"},"&$focusVisible":{boxShadow:e.shadows[6]},"&$disabled":{color:e.palette.action.disabled,boxShadow:e.shadows[0],backgroundColor:e.palette.action.disabledBackground}}),label:{width:"100%",display:"inherit",alignItems:"inherit",justifyContent:"inherit"},primary:{color:e.palette.primary.contrastText,backgroundColor:e.palette.primary.main,"&:hover":{backgroundColor:e.palette.primary.dark,"@media (hover: none)":{backgroundColor:e.palette.primary.main}}},secondary:{color:e.palette.secondary.contrastText,backgroundColor:e.palette.secondary.main,"&:hover":{backgroundColor:e.palette.secondary.dark,"@media (hover: none)":{backgroundColor:e.palette.secondary.main}}},extended:{borderRadius:24,padding:"0 16px",width:"auto",minHeight:"auto",minWidth:48,height:48,"&$sizeSmall":{width:"auto",padding:"0 8px",borderRadius:17,minWidth:34,height:34},"&$sizeMedium":{width:"auto",padding:"0 16px",borderRadius:20,minWidth:40,height:40}},focusVisible:{},disabled:{},colorInherit:{color:"inherit"},sizeSmall:{width:40,height:40},sizeMedium:{width:48,height:48}}}),{name:"MuiFab"})(d)},hQyO:function(e,t,r){"use strict";var n=r("TqRt"),a=r("284h");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var i=a(r("q1tI")),o=(0,n(r("8/g6")).default)(i.createElement("path",{d:"M17 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V7l-4-4zm-5 16c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3zm3-10H5V5h10v4z"}),"Save");t.default=o},iae6:function(e,t,r){"use strict";var n=r("wx14"),a=r("Ff2n"),i=r("q1tI"),o=(r("17x9"),r("iuhU")),c=r("H2TA"),s=r("NqtD"),l=44,d=i.forwardRef((function(e,t){var r=e.classes,c=e.className,d=e.color,u=void 0===d?"primary":d,b=e.disableShrink,j=void 0!==b&&b,f=e.size,O=void 0===f?40:f,p=e.style,h=e.thickness,m=void 0===h?3.6:h,v=e.value,y=void 0===v?0:v,g=e.variant,x=void 0===g?"indeterminate":g,w=Object(a.a)(e,["classes","className","color","disableShrink","size","style","thickness","value","variant"]),k={},P={},E={};if("determinate"===x||"static"===x){var S=2*Math.PI*((l-m)/2);k.strokeDasharray=S.toFixed(3),E["aria-valuenow"]=Math.round(y),k.strokeDashoffset="".concat(((100-y)/100*S).toFixed(3),"px"),P.transform="rotate(-90deg)"}return i.createElement("div",Object(n.a)({className:Object(o.a)(r.root,c,"inherit"!==u&&r["color".concat(Object(s.a)(u))],{determinate:r.determinate,indeterminate:r.indeterminate,static:r.static}[x]),style:Object(n.a)({width:O,height:O},P,p),ref:t,role:"progressbar"},E,w),i.createElement("svg",{className:r.svg,viewBox:"".concat(22," ").concat(22," ").concat(l," ").concat(l)},i.createElement("circle",{className:Object(o.a)(r.circle,j&&r.circleDisableShrink,{determinate:r.circleDeterminate,indeterminate:r.circleIndeterminate,static:r.circleStatic}[x]),style:k,cx:l,cy:l,r:(l-m)/2,fill:"none",strokeWidth:m})))}));t.a=Object(c.a)((function(e){return{root:{display:"inline-block"},static:{transition:e.transitions.create("transform")},indeterminate:{animation:"$circular-rotate 1.4s linear infinite"},determinate:{transition:e.transitions.create("transform")},colorPrimary:{color:e.palette.primary.main},colorSecondary:{color:e.palette.secondary.main},svg:{display:"block"},circle:{stroke:"currentColor"},circleStatic:{transition:e.transitions.create("stroke-dashoffset")},circleIndeterminate:{animation:"$circular-dash 1.4s ease-in-out infinite",strokeDasharray:"80px, 200px",strokeDashoffset:"0px"},circleDeterminate:{transition:e.transitions.create("stroke-dashoffset")},"@keyframes circular-rotate":{"0%":{transformOrigin:"50% 50%"},"100%":{transform:"rotate(360deg)"}},"@keyframes circular-dash":{"0%":{strokeDasharray:"1px, 200px",strokeDashoffset:"0px"},"50%":{strokeDasharray:"100px, 200px",strokeDashoffset:"-15px"},"100%":{strokeDasharray:"100px, 200px",strokeDashoffset:"-125px"}},circleDisableShrink:{animation:"none"}}}),{name:"MuiCircularProgress",flip:!1})(d)},kKU3:function(e,t,r){"use strict";var n=r("wx14"),a=r("ODXe"),i=r("Ff2n"),o=r("q1tI"),c=(r("17x9"),r("dRu9")),s=r("wpWl"),l=r("tr08"),d=r("4Hym"),u=r("bfFb"),b={entering:{opacity:1},entered:{opacity:1}},j={enter:s.b.enteringScreen,exit:s.b.leavingScreen},f=o.forwardRef((function(e,t){var r=e.children,s=e.disableStrictModeCompat,f=void 0!==s&&s,O=e.in,p=e.onEnter,h=e.onEntered,m=e.onEntering,v=e.onExit,y=e.onExited,g=e.onExiting,x=e.style,w=e.TransitionComponent,k=void 0===w?c.a:w,P=e.timeout,E=void 0===P?j:P,S=Object(i.a)(e,["children","disableStrictModeCompat","in","onEnter","onEntered","onEntering","onExit","onExited","onExiting","style","TransitionComponent","timeout"]),D=Object(l.a)(),N=D.unstable_strictMode&&!f,C=o.useRef(null),I=Object(u.a)(r.ref,t),T=Object(u.a)(N?C:void 0,I),R=function(e){return function(t,r){if(e){var n=N?[C.current,t]:[t,r],i=Object(a.a)(n,2),o=i[0],c=i[1];void 0===c?e(o):e(o,c)}}},z=R(m),M=R((function(e,t){Object(d.b)(e);var r=Object(d.a)({style:x,timeout:E},{mode:"enter"});e.style.webkitTransition=D.transitions.create("opacity",r),e.style.transition=D.transitions.create("opacity",r),p&&p(e,t)})),_=R(h),L=R(g),X=R((function(e){var t=Object(d.a)({style:x,timeout:E},{mode:"exit"});e.style.webkitTransition=D.transitions.create("opacity",t),e.style.transition=D.transitions.create("opacity",t),v&&v(e)})),q=R(y);return o.createElement(k,Object(n.a)({appear:!0,in:O,nodeRef:N?C:void 0,onEnter:M,onEntered:_,onEntering:z,onExit:X,onExited:q,onExiting:L,timeout:E},S),(function(e,t){return o.cloneElement(r,Object(n.a)({style:Object(n.a)({opacity:0,visibility:"exited"!==e||O?void 0:"hidden"},b[e],x,r.props.style),ref:T},t))}))}));t.a=f}},[["0iZo",0,1,2,3,4,20]]]);