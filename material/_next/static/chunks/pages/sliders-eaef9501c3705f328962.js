_N_E=(window.webpackJsonp_N_E=window.webpackJsonp_N_E||[]).push([[89],{"284h":function(e,t,n){var r=n("cDf5");function a(){if("function"!==typeof WeakMap)return null;var e=new WeakMap;return a=function(){return e},e}e.exports=function(e){if(e&&e.__esModule)return e;if(null===e||"object"!==r(e)&&"function"!==typeof e)return{default:e};var t=a();if(t&&t.has(e))return t.get(e);var n={},i=Object.defineProperty&&Object.getOwnPropertyDescriptor;for(var o in e)if(Object.prototype.hasOwnProperty.call(e,o)){var c=i?Object.getOwnPropertyDescriptor(e,o):null;c&&(c.get||c.set)?Object.defineProperty(n,o,c):n[o]=e[o]}return n.default=e,t&&t.set(e,n),n}},"28cb":function(e,t,n){"use strict";function r(e){var t=e.props,n=e.states,r=e.muiFormControl;return n.reduce((function(e,n){return e[n]=t[n],r&&"undefined"===typeof t[n]&&(e[n]=r[n]),e}),{})}n.d(t,"a",(function(){return r}))},"4hqb":function(e,t,n){"use strict";n.d(t,"b",(function(){return i}));var r=n("q1tI"),a=r.createContext();function i(){return r.useContext(a)}t.a=a},"5AJ6":function(e,t,n){"use strict";n.d(t,"a",(function(){return c}));var r=n("wx14"),a=n("q1tI"),i=n.n(a),o=n("HR5l");function c(e,t){var n=function(t,n){return i.a.createElement(o.a,Object(r.a)({ref:n},t),e)};return n.muiName=o.a.muiName,i.a.memo(i.a.forwardRef(n))}},"8/g6":function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),Object.defineProperty(t,"default",{enumerable:!0,get:function(){return r.createSvgIcon}});var r=n("kNCj")},ByqB:function(e,t,n){"use strict";function r(e){return null!=e&&!(Array.isArray(e)&&0===e.length)}function a(e){var t=arguments.length>1&&void 0!==arguments[1]&&arguments[1];return e&&(r(e.value)&&""!==e.value||t&&r(e.defaultValue)&&""!==e.defaultValue)}function i(e){return e.startAdornment}n.d(t,"b",(function(){return a})),n.d(t,"a",(function(){return i}))},G7As:function(e,t,n){"use strict";n.d(t,"a",(function(){return v}));var r=n("q1tI"),a=n("i8i4"),i=!0,o=!1,c=null,l={text:!0,search:!0,url:!0,tel:!0,email:!0,password:!0,number:!0,date:!0,month:!0,week:!0,time:!0,datetime:!0,"datetime-local":!0};function u(e){e.metaKey||e.altKey||e.ctrlKey||(i=!0)}function s(){i=!1}function d(){"hidden"===this.visibilityState&&o&&(i=!0)}function f(e){var t=e.target;try{return t.matches(":focus-visible")}catch(n){}return i||function(e){var t=e.type,n=e.tagName;return!("INPUT"!==n||!l[t]||e.readOnly)||"TEXTAREA"===n&&!e.readOnly||!!e.isContentEditable}(t)}function b(){o=!0,window.clearTimeout(c),c=window.setTimeout((function(){o=!1}),100)}function v(){return{isFocusVisible:f,onBlurVisible:b,ref:r.useCallback((function(e){var t,n=a.findDOMNode(e);null!=n&&((t=n.ownerDocument).addEventListener("keydown",u,!0),t.addEventListener("mousedown",s,!0),t.addEventListener("pointerdown",s,!0),t.addEventListener("touchstart",s,!0),t.addEventListener("visibilitychange",d,!0))}),[])}}},GIek:function(e,t,n){"use strict";function r(e,t){"function"===typeof e?e(t):e&&(e.current=t)}n.d(t,"a",(function(){return r}))},HR5l:function(e,t,n){"use strict";var r=n("wx14"),a=n("Ff2n"),i=n("q1tI"),o=(n("17x9"),n("iuhU")),c=n("H2TA"),l=n("NqtD"),u=i.forwardRef((function(e,t){var n=e.children,c=e.classes,u=e.className,s=e.color,d=void 0===s?"inherit":s,f=e.component,b=void 0===f?"svg":f,v=e.fontSize,p=void 0===v?"default":v,m=e.htmlColor,h=e.titleAccess,g=e.viewBox,x=void 0===g?"0 0 24 24":g,y=Object(a.a)(e,["children","classes","className","color","component","fontSize","htmlColor","titleAccess","viewBox"]);return i.createElement(b,Object(r.a)({className:Object(o.a)(c.root,u,"inherit"!==d&&c["color".concat(Object(l.a)(d))],"default"!==p&&c["fontSize".concat(Object(l.a)(p))]),focusable:"false",viewBox:x,color:m,"aria-hidden":!h||void 0,role:h?"img":void 0,ref:t},y),n,h?i.createElement("title",null,h):null)}));u.muiName="SvgIcon",t.a=Object(c.a)((function(e){return{root:{userSelect:"none",width:"1em",height:"1em",display:"inline-block",fill:"currentColor",flexShrink:0,fontSize:e.typography.pxToRem(24),transition:e.transitions.create("fill",{duration:e.transitions.duration.shorter})},colorPrimary:{color:e.palette.primary.main},colorSecondary:{color:e.palette.secondary.main},colorAction:{color:e.palette.action.active},colorError:{color:e.palette.error.main},colorDisabled:{color:e.palette.action.disabled},fontSizeInherit:{fontSize:"inherit"},fontSizeSmall:{fontSize:e.typography.pxToRem(20)},fontSizeLarge:{fontSize:e.typography.pxToRem(35)}}}),{name:"MuiSvgIcon"})(u)},LkvZ:function(e,t,n){"use strict";var r=n("TqRt"),a=n("284h");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var i=a(n("q1tI")),o=(0,r(n("8/g6")).default)(i.createElement("path",{d:"M3 9v6h4l5 5V4L7 9H3zm13.5 3c0-1.77-1.02-3.29-2.5-4.03v8.05c1.48-.73 2.5-2.25 2.5-4.02zM14 3.23v2.06c2.89.86 5 3.54 5 6.71s-2.11 5.85-5 6.71v2.06c4.01-.91 7-4.49 7-8.77s-2.99-7.86-7-8.77z"}),"VolumeUp");t.default=o},"Lw+h":function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return ue}));var r=n("nKUr"),a=n("q1tI"),i=n.n(a),o=n("Ji2X"),c=n("hlFM"),l=n("ODXe"),u=n("R/WZ"),s=n("ofer"),d=n("KQm4"),f=n("Ff2n"),b=n("wx14"),v=(n("17x9"),n("iuhU")),p=n("H2TA"),m=n("tr08"),h=n("ye/S"),g=n("G7As"),x=n("gk1O"),y=n("Ovef"),j=n("bfFb"),O=n("NqtD"),w=n("yCxk");var S=Object(p.a)((function(e){return{thumb:{"&$open":{"& $offset":{transform:"scale(1) translateY(-10px)"}}},open:{},offset:Object(b.a)({zIndex:1},e.typography.body2,{fontSize:e.typography.pxToRem(12),lineHeight:1.2,transition:e.transitions.create(["transform"],{duration:e.transitions.duration.shortest}),top:-34,transformOrigin:"bottom center",transform:"scale(0)",position:"absolute"}),circle:{display:"flex",alignItems:"center",justifyContent:"center",width:32,height:32,borderRadius:"50% 50% 50% 0",backgroundColor:"currentColor",transform:"rotate(-45deg)"},label:{color:e.palette.primary.contrastText,transform:"rotate(45deg)"}}}),{name:"PrivateValueLabel"})((function(e){var t=e.children,n=e.classes,r=e.className,i=e.open,o=e.value,c=e.valueLabelDisplay;return"off"===c?t:a.cloneElement(t,{className:Object(v.a)(t.props.className,(i||"on"===c)&&n.open,n.thumb)},a.createElement("span",{className:Object(v.a)(n.offset,r)},a.createElement("span",{className:n.circle},a.createElement("span",{className:n.label},o))))}));function C(e,t){return e-t}function k(e,t,n){return Math.min(Math.max(t,e),n)}function E(e,t){return e.reduce((function(e,n,r){var a=Math.abs(t-n);return null===e||a<e.distance||a===e.distance?{distance:a,index:r}:e}),null).index}function L(e,t){if(void 0!==t.current&&e.changedTouches){for(var n=0;n<e.changedTouches.length;n+=1){var r=e.changedTouches[n];if(r.identifier===t.current)return{x:r.clientX,y:r.clientY}}return!1}return{x:e.clientX,y:e.clientY}}function A(e,t,n){return 100*(e-t)/(n-t)}function N(e,t,n){var r=Math.round((e-n)/t)*t+n;return Number(r.toFixed(function(e){if(Math.abs(e)<1){var t=e.toExponential().split("e-"),n=t[0].split(".")[1];return(n?n.length:0)+parseInt(t[1],10)}var r=e.toString().split(".")[1];return r?r.length:0}(t)))}function I(e){var t=e.values,n=e.source,r=e.newValue,a=e.index;if(t[a]===r)return n;var i=t.slice();return i[a]=r,i}function T(e){var t=e.sliderRef,n=e.activeIndex,r=e.setActive;t.current.contains(document.activeElement)&&Number(document.activeElement.getAttribute("data-index"))===n||t.current.querySelector('[role="slider"][data-index="'.concat(n,'"]')).focus(),r&&r(n)}var V={horizontal:{offset:function(e){return{left:"".concat(e,"%")}},leap:function(e){return{width:"".concat(e,"%")}}},"horizontal-reverse":{offset:function(e){return{right:"".concat(e,"%")}},leap:function(e){return{width:"".concat(e,"%")}}},vertical:{offset:function(e){return{bottom:"".concat(e,"%")}},leap:function(e){return{height:"".concat(e,"%")}}}},R=function(e){return e},D=a.forwardRef((function(e,t){var n=e["aria-label"],r=e["aria-labelledby"],i=e["aria-valuetext"],o=e.classes,c=e.className,u=e.color,s=void 0===u?"primary":u,p=e.component,h=void 0===p?"span":p,D=e.defaultValue,B=e.disabled,M=void 0!==B&&B,z=e.getAriaLabel,F=e.getAriaValueText,P=e.marks,q=void 0!==P&&P,W=e.max,$=void 0===W?100:W,_=e.min,H=void 0===_?0:_,G=e.name,U=e.onChange,X=e.onChangeCommitted,K=e.onMouseDown,J=e.orientation,Y=void 0===J?"horizontal":J,Z=e.scale,Q=void 0===Z?R:Z,ee=e.step,te=void 0===ee?1:ee,ne=e.ThumbComponent,re=void 0===ne?"span":ne,ae=e.track,ie=void 0===ae?"normal":ae,oe=e.value,ce=e.ValueLabelComponent,le=void 0===ce?S:ce,ue=e.valueLabelDisplay,se=void 0===ue?"off":ue,de=e.valueLabelFormat,fe=void 0===de?R:de,be=Object(f.a)(e,["aria-label","aria-labelledby","aria-valuetext","classes","className","color","component","defaultValue","disabled","getAriaLabel","getAriaValueText","marks","max","min","name","onChange","onChangeCommitted","onMouseDown","orientation","scale","step","ThumbComponent","track","value","ValueLabelComponent","valueLabelDisplay","valueLabelFormat"]),ve=Object(m.a)(),pe=a.useRef(),me=a.useState(-1),he=me[0],ge=me[1],xe=a.useState(-1),ye=xe[0],je=xe[1],Oe=Object(w.a)({controlled:oe,default:D,name:"Slider"}),we=Object(l.a)(Oe,2),Se=we[0],Ce=we[1],ke=Array.isArray(Se),Ee=ke?Se.slice().sort(C):[Se];Ee=Ee.map((function(e){return k(e,H,$)}));var Le=!0===q&&null!==te?Object(d.a)(Array(Math.floor(($-H)/te)+1)).map((function(e,t){return{value:H+te*t}})):q||[],Ae=Object(g.a)(),Ne=Ae.isFocusVisible,Ie=Ae.onBlurVisible,Te=Ae.ref,Ve=a.useState(-1),Re=Ve[0],De=Ve[1],Be=a.useRef(),Me=Object(j.a)(Te,Be),ze=Object(j.a)(t,Me),Fe=Object(y.a)((function(e){var t=Number(e.currentTarget.getAttribute("data-index"));Ne(e)&&De(t),je(t)})),Pe=Object(y.a)((function(){-1!==Re&&(De(-1),Ie()),je(-1)})),qe=Object(y.a)((function(e){var t=Number(e.currentTarget.getAttribute("data-index"));je(t)})),We=Object(y.a)((function(){je(-1)})),$e="rtl"===ve.direction,_e=Object(y.a)((function(e){var t,n=Number(e.currentTarget.getAttribute("data-index")),r=Ee[n],a=($-H)/10,i=Le.map((function(e){return e.value})),o=i.indexOf(r),c=$e?"ArrowLeft":"ArrowRight",l=$e?"ArrowRight":"ArrowLeft";switch(e.key){case"Home":t=H;break;case"End":t=$;break;case"PageUp":te&&(t=r+a);break;case"PageDown":te&&(t=r-a);break;case c:case"ArrowUp":t=te?r+te:i[o+1]||i[i.length-1];break;case l:case"ArrowDown":t=te?r-te:i[o-1]||i[0];break;default:return}if(e.preventDefault(),te&&(t=N(t,te,H)),t=k(t,H,$),ke){var u=t;t=I({values:Ee,source:Se,newValue:t,index:n}).sort(C),T({sliderRef:Be,activeIndex:t.indexOf(u)})}Ce(t),De(n),U&&U(e,t),X&&X(e,t)})),He=a.useRef(),Ge=Y;$e&&"vertical"!==Y&&(Ge+="-reverse");var Ue=function(e){var t,n,r=e.finger,a=e.move,i=void 0!==a&&a,o=e.values,c=e.source,l=Be.current.getBoundingClientRect(),u=l.width,s=l.height,d=l.bottom,f=l.left;if(t=0===Ge.indexOf("vertical")?(d-r.y)/s:(r.x-f)/u,-1!==Ge.indexOf("-reverse")&&(t=1-t),n=function(e,t,n){return(n-t)*e+t}(t,H,$),te)n=N(n,te,H);else{var b=Le.map((function(e){return e.value}));n=b[E(b,n)]}n=k(n,H,$);var v=0;if(ke){var p=n;v=(n=I({values:o,source:c,newValue:n,index:v=i?He.current:E(o,n)}).sort(C)).indexOf(p),He.current=v}return{newValue:n,activeIndex:v}},Xe=Object(y.a)((function(e){var t=L(e,pe);if(t){var n=Ue({finger:t,move:!0,values:Ee,source:Se}),r=n.newValue,a=n.activeIndex;T({sliderRef:Be,activeIndex:a,setActive:ge}),Ce(r),U&&U(e,r)}})),Ke=Object(y.a)((function(e){var t=L(e,pe);if(t){var n=Ue({finger:t,values:Ee,source:Se}).newValue;ge(-1),"touchend"===e.type&&je(-1),X&&X(e,n),pe.current=void 0;var r=Object(x.a)(Be.current);r.removeEventListener("mousemove",Xe),r.removeEventListener("mouseup",Ke),r.removeEventListener("touchmove",Xe),r.removeEventListener("touchend",Ke)}})),Je=Object(y.a)((function(e){e.preventDefault();var t=e.changedTouches[0];null!=t&&(pe.current=t.identifier);var n=L(e,pe),r=Ue({finger:n,values:Ee,source:Se}),a=r.newValue,i=r.activeIndex;T({sliderRef:Be,activeIndex:i,setActive:ge}),Ce(a),U&&U(e,a);var o=Object(x.a)(Be.current);o.addEventListener("touchmove",Xe),o.addEventListener("touchend",Ke)}));a.useEffect((function(){var e=Be.current;e.addEventListener("touchstart",Je);var t=Object(x.a)(e);return function(){e.removeEventListener("touchstart",Je),t.removeEventListener("mousemove",Xe),t.removeEventListener("mouseup",Ke),t.removeEventListener("touchmove",Xe),t.removeEventListener("touchend",Ke)}}),[Ke,Xe,Je]);var Ye=Object(y.a)((function(e){K&&K(e),e.preventDefault();var t=L(e,pe),n=Ue({finger:t,values:Ee,source:Se}),r=n.newValue,a=n.activeIndex;T({sliderRef:Be,activeIndex:a,setActive:ge}),Ce(r),U&&U(e,r);var i=Object(x.a)(Be.current);i.addEventListener("mousemove",Xe),i.addEventListener("mouseup",Ke)})),Ze=A(ke?Ee[0]:H,H,$),Qe=A(Ee[Ee.length-1],H,$)-Ze,et=Object(b.a)({},V[Ge].offset(Ze),V[Ge].leap(Qe));return a.createElement(h,Object(b.a)({ref:ze,className:Object(v.a)(o.root,o["color".concat(Object(O.a)(s))],c,M&&o.disabled,Le.length>0&&Le.some((function(e){return e.label}))&&o.marked,!1===ie&&o.trackFalse,"vertical"===Y&&o.vertical,"inverted"===ie&&o.trackInverted),onMouseDown:Ye},be),a.createElement("span",{className:o.rail}),a.createElement("span",{className:o.track,style:et}),a.createElement("input",{value:Ee.join(","),name:G,type:"hidden"}),Le.map((function(e,t){var n,r=A(e.value,H,$),i=V[Ge].offset(r);return n=!1===ie?-1!==Ee.indexOf(e.value):"normal"===ie&&(ke?e.value>=Ee[0]&&e.value<=Ee[Ee.length-1]:e.value<=Ee[0])||"inverted"===ie&&(ke?e.value<=Ee[0]||e.value>=Ee[Ee.length-1]:e.value>=Ee[0]),a.createElement(a.Fragment,{key:e.value},a.createElement("span",{style:i,"data-index":t,className:Object(v.a)(o.mark,n&&o.markActive)}),null!=e.label?a.createElement("span",{"aria-hidden":!0,"data-index":t,style:i,className:Object(v.a)(o.markLabel,n&&o.markLabelActive)},e.label):null)})),Ee.map((function(e,t){var c=A(e,H,$),l=V[Ge].offset(c);return a.createElement(le,{key:t,valueLabelFormat:fe,valueLabelDisplay:se,className:o.valueLabel,value:"function"===typeof fe?fe(Q(e),t):fe,index:t,open:ye===t||he===t||"on"===se,disabled:M},a.createElement(re,{className:Object(v.a)(o.thumb,o["thumbColor".concat(Object(O.a)(s))],he===t&&o.active,M&&o.disabled,Re===t&&o.focusVisible),tabIndex:M?null:0,role:"slider",style:l,"data-index":t,"aria-label":z?z(t):n,"aria-labelledby":r,"aria-orientation":Y,"aria-valuemax":Q($),"aria-valuemin":Q(H),"aria-valuenow":Q(e),"aria-valuetext":F?F(Q(e),t):i,onKeyDown:_e,onFocus:Fe,onBlur:Pe,onMouseOver:qe,onMouseLeave:We}))})))})),B=Object(p.a)((function(e){return{root:{height:2,width:"100%",boxSizing:"content-box",padding:"13px 0",display:"inline-block",position:"relative",cursor:"pointer",touchAction:"none",color:e.palette.primary.main,WebkitTapHighlightColor:"transparent","&$disabled":{pointerEvents:"none",cursor:"default",color:e.palette.grey[400]},"&$vertical":{width:2,height:"100%",padding:"0 13px"},"@media (pointer: coarse)":{padding:"20px 0","&$vertical":{padding:"0 20px"}},"@media print":{colorAdjust:"exact"}},colorPrimary:{},colorSecondary:{color:e.palette.secondary.main},marked:{marginBottom:20,"&$vertical":{marginBottom:"auto",marginRight:20}},vertical:{},disabled:{},rail:{display:"block",position:"absolute",width:"100%",height:2,borderRadius:1,backgroundColor:"currentColor",opacity:.38,"$vertical &":{height:"100%",width:2}},track:{display:"block",position:"absolute",height:2,borderRadius:1,backgroundColor:"currentColor","$vertical &":{width:2}},trackFalse:{"& $track":{display:"none"}},trackInverted:{"& $track":{backgroundColor:"light"===e.palette.type?Object(h.i)(e.palette.primary.main,.62):Object(h.a)(e.palette.primary.main,.5)},"& $rail":{opacity:1}},thumb:{position:"absolute",width:12,height:12,marginLeft:-6,marginTop:-5,boxSizing:"border-box",borderRadius:"50%",outline:0,backgroundColor:"currentColor",display:"flex",alignItems:"center",justifyContent:"center",transition:e.transitions.create(["box-shadow"],{duration:e.transitions.duration.shortest}),"&::after":{position:"absolute",content:'""',borderRadius:"50%",left:-15,top:-15,right:-15,bottom:-15},"&$focusVisible,&:hover":{boxShadow:"0px 0px 0px 8px ".concat(Object(h.d)(e.palette.primary.main,.16)),"@media (hover: none)":{boxShadow:"none"}},"&$active":{boxShadow:"0px 0px 0px 14px ".concat(Object(h.d)(e.palette.primary.main,.16))},"&$disabled":{width:8,height:8,marginLeft:-4,marginTop:-3,"&:hover":{boxShadow:"none"}},"$vertical &":{marginLeft:-5,marginBottom:-6},"$vertical &$disabled":{marginLeft:-3,marginBottom:-4}},thumbColorPrimary:{},thumbColorSecondary:{"&$focusVisible,&:hover":{boxShadow:"0px 0px 0px 8px ".concat(Object(h.d)(e.palette.secondary.main,.16))},"&$active":{boxShadow:"0px 0px 0px 14px ".concat(Object(h.d)(e.palette.secondary.main,.16))}},active:{},focusVisible:{},valueLabel:{left:"calc(-50% - 4px)"},mark:{position:"absolute",width:2,height:2,borderRadius:1,backgroundColor:"currentColor"},markActive:{backgroundColor:e.palette.background.paper,opacity:.8},markLabel:Object(b.a)({},e.typography.body2,{color:e.palette.text.secondary,position:"absolute",top:26,transform:"translateX(-50%)",whiteSpace:"nowrap","$vertical &":{top:"auto",left:26,transform:"translateY(50%)"},"@media (pointer: coarse)":{top:40,"$vertical &":{left:31}}}),markLabelActive:{color:e.palette.text.primary}}}),{name:"MuiSlider"})(D),M=Object(u.a)({root:{width:400}});function z(e){return"".concat(e,"\xb0C")}function F(){var e=M(),t=i.a.useState([20,37]),n=Object(l.a)(t,2),a=n[0],o=n[1];return Object(r.jsxs)("div",{className:e.root,children:[Object(r.jsxs)(s.a,{id:"range-slider",gutterBottom:!0,children:["Range Slider with selection from ",a[0]," to ",a[1]]}),Object(r.jsx)(B,{value:a,onChange:function(e,t){o(t)},valueLabelDisplay:"auto","aria-labelledby":"range-slider",getAriaValueText:z,width:300})]})}var P=Object(u.a)({root:{height:300}});function q(){var e=P(),t=i.a.useState(30),n=Object(l.a)(t,2),a=n[0],o=n[1];return Object(r.jsxs)(i.a.Fragment,{children:[Object(r.jsxs)(s.a,{id:"vertical-slider",gutterBottom:!0,children:["Vertical Slider with value ",a]}),Object(r.jsx)("div",{className:e.root,children:Object(r.jsx)(B,{orientation:"vertical",onChange:function(e,t){o(t)},defaultValue:30,"aria-labelledby":"vertical-slider"})})]})}var W=n("tRbT"),$=Object(u.a)({root:{width:400}});function _(){var e=$(),t=i.a.useState(30),n=Object(l.a)(t,2),a=n[0],o=n[1];return Object(r.jsxs)("div",{className:e.root,children:[Object(r.jsx)(s.a,{id:"continuous-slider",gutterBottom:!0,children:"Default Slider"}),Object(r.jsxs)(W.a,{container:!0,spacing:2,children:[Object(r.jsx)(W.a,{item:!0,xs:!0,children:Object(r.jsx)(B,{value:a,onChange:function(e,t){o(t)},"aria-labelledby":"continuous-slider"})}),Object(r.jsxs)(s.a,{id:"continuousValue",children:["Selected value: ",a]})]}),Object(r.jsx)(s.a,{id:"disabled-slider",gutterBottom:!0,children:"Disabled slider"}),Object(r.jsx)(B,{disabled:!0,defaultValue:30,"aria-labelledby":"disabled-slider"})]})}var H=Object(u.a)({root:{width:400}});function G(e){return"".concat(e,"\xb0C")}function U(){var e=H(),t=i.a.useState(30),n=Object(l.a)(t,2),a=n[0],o=n[1];return Object(r.jsxs)("div",{className:e.root,children:[Object(r.jsxs)(s.a,{id:"discrete-slider",gutterBottom:!0,children:["Temperature is ",G(a)]}),Object(r.jsx)(B,{defaultValue:30,getAriaValueText:G,"aria-labelledby":"discrete-slider",valueLabelDisplay:"auto",step:10,marks:!0,min:10,max:110,onChange:function(e,t){o(t)}}),Object(r.jsx)(s.a,{id:"discrete-slider",gutterBottom:!0,children:"Disabled"}),Object(r.jsx)(B,{defaultValue:30,getAriaValueText:G,"aria-labelledby":"discrete-slider",valueLabelDisplay:"auto",step:10,marks:!0,min:10,max:110,disabled:!0})]})}var X=Object(u.a)({root:{width:400}}),K=[{value:0,label:"0\xb0C"},{value:20,label:"20\xb0C"},{value:37,label:"37\xb0C"},{value:100,label:"100\xb0C"}];function J(e){return"".concat(e,"\xb0C")}function Y(e){return K.findIndex((function(t){return t.value===e}))+1}function Z(){var e=X(),t=i.a.useState(30),n=Object(l.a)(t,2),a=n[0],o=n[1];return Object(r.jsxs)("div",{className:e.root,children:[Object(r.jsxs)(s.a,{id:"discrete-slider-restrict",gutterBottom:!0,children:["Restricted values with value ",J(a)]}),Object(r.jsx)(B,{defaultValue:20,valueLabelFormat:Y,getAriaValueText:J,"aria-labelledby":"discrete-slider-restrict",step:null,valueLabelDisplay:"auto",marks:K,onChange:function(e,t){o(t)}})]})}var Q=Object(u.a)((function(e){return{root:{width:400},margin:{height:e.spacing(3)}}})),ee=[{value:0,label:"0\xb0C"},{value:20,label:"20\xb0C"},{value:37,label:"37\xb0C"},{value:100,label:"100\xb0C"}];function te(e){return"".concat(e,"\xb0C")}function ne(){var e=Q();return Object(r.jsxs)("div",{className:e.root,children:[Object(r.jsx)(s.a,{id:"discrete-slider-always",gutterBottom:!0,children:"Always visible"}),Object(r.jsx)(B,{defaultValue:80,getAriaValueText:te,"aria-labelledby":"discrete-slider-always",step:10,marks:ee,valueLabelDisplay:"on"})]})}var re=n("pdwK"),ae=n("LkvZ"),ie=n.n(ae),oe=Object(u.a)({root:{width:250},input:{width:42}});function ce(){var e=oe(),t=i.a.useState(30),n=Object(l.a)(t,2),a=n[0],o=n[1];return Object(r.jsxs)("div",{className:e.root,children:[Object(r.jsx)(s.a,{id:"input-slider",gutterBottom:!0,children:"Volume"}),Object(r.jsxs)(W.a,{container:!0,spacing:2,alignItems:"center",children:[Object(r.jsx)(W.a,{item:!0,children:Object(r.jsx)(ie.a,{})}),Object(r.jsx)(W.a,{item:!0,xs:!0,children:Object(r.jsx)(B,{value:"number"===typeof a?a:0,onChange:function(e,t){o(t)},"aria-labelledby":"input-slider"})}),Object(r.jsx)(W.a,{item:!0,children:Object(r.jsx)(re.a,{className:e.input,value:a,margin:"dense",onChange:function(e){o(""===e.target.value?"":Number(e.target.value))},onBlur:function(){a<0?o(0):a>100&&o(100)},inputProps:{step:10,min:0,max:100,type:"number","aria-labelledby":"input-slider"}})})]})]})}function le(){return Object(r.jsxs)("div",{children:[Object(r.jsx)("h1",{children:"Slider"}),Object(r.jsx)("h2",{children:"Continuous sliders"}),Object(r.jsx)(_,{id:"continuousSlider"}),Object(r.jsx)("h2",{children:"Discrete sliders"}),Object(r.jsx)(U,{id:"discreteSlider"}),Object(r.jsx)("h2",{children:"Custom marks and restricted values"}),Object(r.jsx)(Z,{id:"customDiscreteSlider"}),Object(r.jsx)("h2",{children:"Label always visible"}),Object(r.jsx)(ne,{id:"alwaysVisibleLabelsSlider"}),Object(r.jsx)("h2",{children:"Range slider"}),Object(r.jsx)(F,{id:"rangeSlider"}),Object(r.jsx)("h2",{children:"Slider with input field"}),Object(r.jsx)(ce,{id:"inputSlider"}),Object(r.jsx)("h2",{children:"Vertical sliders"}),Object(r.jsx)(q,{id:"verticalSlider"})]})}function ue(){return Object(r.jsx)(o.a,{maxWidth:"xl",children:Object(r.jsx)(c.a,{my:4,children:Object(r.jsx)(le,{})})})}},Ovef:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n("q1tI"),a="undefined"!==typeof window?r.useLayoutEffect:r.useEffect;function i(e){var t=r.useRef(e);return a((function(){t.current=e})),r.useCallback((function(){return t.current.apply(void 0,arguments)}),[])}},TqRt:function(e,t){e.exports=function(e){return e&&e.__esModule?e:{default:e}}},bfFb:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n("q1tI"),a=n("GIek");function i(e,t){return r.useMemo((function(){return null==e&&null==t?null:function(n){Object(a.a)(e,n),Object(a.a)(t,n)}}),[e,t])}},cDf5:function(e,t){function n(t){return"function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?e.exports=n=function(e){return typeof e}:e.exports=n=function(e){return e&&"function"===typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},n(t)}e.exports=n},"g+pH":function(e,t,n){"use strict";n.d(t,"a",(function(){return a}));var r=n("gk1O");function a(e){return Object(r.a)(e).defaultView||window}},gk1O:function(e,t,n){"use strict";function r(e){return e&&e.ownerDocument||document}n.d(t,"a",(function(){return r}))},kNCj:function(e,t,n){"use strict";n.r(t),n.d(t,"capitalize",(function(){return r.a})),n.d(t,"createChainedFunction",(function(){return a.a})),n.d(t,"createSvgIcon",(function(){return i.a})),n.d(t,"debounce",(function(){return o.a})),n.d(t,"deprecatedPropType",(function(){return c})),n.d(t,"isMuiElement",(function(){return l.a})),n.d(t,"ownerDocument",(function(){return u.a})),n.d(t,"ownerWindow",(function(){return s.a})),n.d(t,"requirePropFactory",(function(){return d.a})),n.d(t,"setRef",(function(){return f.a})),n.d(t,"unsupportedProp",(function(){return b.a})),n.d(t,"useControlled",(function(){return v.a})),n.d(t,"useEventCallback",(function(){return p.a})),n.d(t,"useForkRef",(function(){return m.a})),n.d(t,"unstable_useId",(function(){return h.a})),n.d(t,"useIsFocusVisible",(function(){return g.a}));var r=n("NqtD"),a=n("x6Ns"),i=n("5AJ6"),o=n("l3Wi");function c(e,t){return function(){return null}}var l=n("ucBr"),u=n("gk1O"),s=n("g+pH"),d=n("ueBp"),f=n("GIek"),b=n("y6BH"),v=n("yCxk"),p=n("Ovef"),m=n("bfFb"),h=n("wRgb"),g=n("G7As")},"l/PA":function(e,t,n){(window.__NEXT_P=window.__NEXT_P||[]).push(["/sliders",function(){return n("Lw+h")}])},l3Wi:function(e,t,n){"use strict";function r(e){var t,n=arguments.length>1&&void 0!==arguments[1]?arguments[1]:166;function r(){for(var r=arguments.length,a=new Array(r),i=0;i<r;i++)a[i]=arguments[i];var o=this,c=function(){e.apply(o,a)};clearTimeout(t),t=setTimeout(c,n)}return r.clear=function(){clearTimeout(t)},r}n.d(t,"a",(function(){return r}))},ofer:function(e,t,n){"use strict";var r=n("wx14"),a=n("Ff2n"),i=n("q1tI"),o=(n("17x9"),n("iuhU")),c=n("H2TA"),l=n("NqtD"),u={h1:"h1",h2:"h2",h3:"h3",h4:"h4",h5:"h5",h6:"h6",subtitle1:"h6",subtitle2:"h6",body1:"p",body2:"p"},s=i.forwardRef((function(e,t){var n=e.align,c=void 0===n?"inherit":n,s=e.classes,d=e.className,f=e.color,b=void 0===f?"initial":f,v=e.component,p=e.display,m=void 0===p?"initial":p,h=e.gutterBottom,g=void 0!==h&&h,x=e.noWrap,y=void 0!==x&&x,j=e.paragraph,O=void 0!==j&&j,w=e.variant,S=void 0===w?"body1":w,C=e.variantMapping,k=void 0===C?u:C,E=Object(a.a)(e,["align","classes","className","color","component","display","gutterBottom","noWrap","paragraph","variant","variantMapping"]),L=v||(O?"p":k[S]||u[S])||"span";return i.createElement(L,Object(r.a)({className:Object(o.a)(s.root,d,"inherit"!==S&&s[S],"initial"!==b&&s["color".concat(Object(l.a)(b))],y&&s.noWrap,g&&s.gutterBottom,O&&s.paragraph,"inherit"!==c&&s["align".concat(Object(l.a)(c))],"initial"!==m&&s["display".concat(Object(l.a)(m))]),ref:t},E))}));t.a=Object(c.a)((function(e){return{root:{margin:0},body2:e.typography.body2,body1:e.typography.body1,caption:e.typography.caption,button:e.typography.button,h1:e.typography.h1,h2:e.typography.h2,h3:e.typography.h3,h4:e.typography.h4,h5:e.typography.h5,h6:e.typography.h6,subtitle1:e.typography.subtitle1,subtitle2:e.typography.subtitle2,overline:e.typography.overline,srOnly:{position:"absolute",height:1,width:1,overflow:"hidden"},alignLeft:{textAlign:"left"},alignCenter:{textAlign:"center"},alignRight:{textAlign:"right"},alignJustify:{textAlign:"justify"},noWrap:{overflow:"hidden",textOverflow:"ellipsis",whiteSpace:"nowrap"},gutterBottom:{marginBottom:"0.35em"},paragraph:{marginBottom:16},colorInherit:{color:"inherit"},colorPrimary:{color:e.palette.primary.main},colorSecondary:{color:e.palette.secondary.main},colorTextPrimary:{color:e.palette.text.primary},colorTextSecondary:{color:e.palette.text.secondary},colorError:{color:e.palette.error.main},displayInline:{display:"inline"},displayBlock:{display:"block"}}}),{name:"MuiTypography"})(s)},tRbT:function(e,t,n){"use strict";var r=n("Ff2n"),a=n("wx14"),i=n("q1tI"),o=(n("17x9"),n("iuhU")),c=n("H2TA"),l=[0,1,2,3,4,5,6,7,8,9,10],u=["auto",!0,1,2,3,4,5,6,7,8,9,10,11,12];function s(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,n=parseFloat(e);return"".concat(n/t).concat(String(e).replace(String(n),"")||"px")}var d=i.forwardRef((function(e,t){var n=e.alignContent,c=void 0===n?"stretch":n,l=e.alignItems,u=void 0===l?"stretch":l,s=e.classes,d=e.className,f=e.component,b=void 0===f?"div":f,v=e.container,p=void 0!==v&&v,m=e.direction,h=void 0===m?"row":m,g=e.item,x=void 0!==g&&g,y=e.justify,j=void 0===y?"flex-start":y,O=e.lg,w=void 0!==O&&O,S=e.md,C=void 0!==S&&S,k=e.sm,E=void 0!==k&&k,L=e.spacing,A=void 0===L?0:L,N=e.wrap,I=void 0===N?"wrap":N,T=e.xl,V=void 0!==T&&T,R=e.xs,D=void 0!==R&&R,B=e.zeroMinWidth,M=void 0!==B&&B,z=Object(r.a)(e,["alignContent","alignItems","classes","className","component","container","direction","item","justify","lg","md","sm","spacing","wrap","xl","xs","zeroMinWidth"]),F=Object(o.a)(s.root,d,p&&[s.container,0!==A&&s["spacing-xs-".concat(String(A))]],x&&s.item,M&&s.zeroMinWidth,"row"!==h&&s["direction-xs-".concat(String(h))],"wrap"!==I&&s["wrap-xs-".concat(String(I))],"stretch"!==u&&s["align-items-xs-".concat(String(u))],"stretch"!==c&&s["align-content-xs-".concat(String(c))],"flex-start"!==j&&s["justify-xs-".concat(String(j))],!1!==D&&s["grid-xs-".concat(String(D))],!1!==E&&s["grid-sm-".concat(String(E))],!1!==C&&s["grid-md-".concat(String(C))],!1!==w&&s["grid-lg-".concat(String(w))],!1!==V&&s["grid-xl-".concat(String(V))]);return i.createElement(b,Object(a.a)({className:F,ref:t},z))})),f=Object(c.a)((function(e){return Object(a.a)({root:{},container:{boxSizing:"border-box",display:"flex",flexWrap:"wrap",width:"100%"},item:{boxSizing:"border-box",margin:"0"},zeroMinWidth:{minWidth:0},"direction-xs-column":{flexDirection:"column"},"direction-xs-column-reverse":{flexDirection:"column-reverse"},"direction-xs-row-reverse":{flexDirection:"row-reverse"},"wrap-xs-nowrap":{flexWrap:"nowrap"},"wrap-xs-wrap-reverse":{flexWrap:"wrap-reverse"},"align-items-xs-center":{alignItems:"center"},"align-items-xs-flex-start":{alignItems:"flex-start"},"align-items-xs-flex-end":{alignItems:"flex-end"},"align-items-xs-baseline":{alignItems:"baseline"},"align-content-xs-center":{alignContent:"center"},"align-content-xs-flex-start":{alignContent:"flex-start"},"align-content-xs-flex-end":{alignContent:"flex-end"},"align-content-xs-space-between":{alignContent:"space-between"},"align-content-xs-space-around":{alignContent:"space-around"},"justify-xs-center":{justifyContent:"center"},"justify-xs-flex-end":{justifyContent:"flex-end"},"justify-xs-space-between":{justifyContent:"space-between"},"justify-xs-space-around":{justifyContent:"space-around"},"justify-xs-space-evenly":{justifyContent:"space-evenly"}},function(e,t){var n={};return l.forEach((function(r){var a=e.spacing(r);0!==a&&(n["spacing-".concat(t,"-").concat(r)]={margin:"-".concat(s(a,2)),width:"calc(100% + ".concat(s(a),")"),"& > $item":{padding:s(a,2)}})})),n}(e,"xs"),e.breakpoints.keys.reduce((function(t,n){return function(e,t,n){var r={};u.forEach((function(e){var t="grid-".concat(n,"-").concat(e);if(!0!==e)if("auto"!==e){var a="".concat(Math.round(e/12*1e8)/1e6,"%");r[t]={flexBasis:a,flexGrow:0,maxWidth:a}}else r[t]={flexBasis:"auto",flexGrow:0,maxWidth:"none"};else r[t]={flexBasis:0,flexGrow:1,maxWidth:"100%"}})),"xs"===n?Object(a.a)(e,r):e[t.breakpoints.up(n)]=r}(t,e,n),t}),{}))}),{name:"MuiGrid"})(d);t.a=f},tr08:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n("aXM8"),a=(n("q1tI"),n("cNwE"));function i(){return Object(r.a)()||a.a}},ucBr:function(e,t,n){"use strict";n.d(t,"a",(function(){return a}));var r=n("q1tI");function a(e,t){return r.isValidElement(e)&&-1!==t.indexOf(e.type.muiName)}},ueBp:function(e,t,n){"use strict";function r(e){return function(){return null}}n.d(t,"a",(function(){return r}))},wRgb:function(e,t,n){"use strict";n.d(t,"a",(function(){return a}));var r=n("q1tI");function a(e){var t=r.useState(e),n=t[0],a=t[1],i=e||n;return r.useEffect((function(){null==n&&a("mui-".concat(Math.round(1e5*Math.random())))}),[n]),i}},x6Ns:function(e,t,n){"use strict";function r(){for(var e=arguments.length,t=new Array(e),n=0;n<e;n++)t[n]=arguments[n];return t.reduce((function(e,t){return null==t?e:function(){for(var n=arguments.length,r=new Array(n),a=0;a<n;a++)r[a]=arguments[a];e.apply(this,r),t.apply(this,r)}}),(function(){}))}n.d(t,"a",(function(){return r}))},y6BH:function(e,t,n){"use strict";function r(e,t,n,r,a){return null}n.d(t,"a",(function(){return r}))},yCxk:function(e,t,n){"use strict";n.d(t,"a",(function(){return a}));var r=n("q1tI");function a(e){var t=e.controlled,n=e.default,a=(e.name,e.state,r.useRef(void 0!==t).current),i=r.useState(n),o=i[0],c=i[1];return[a?t:o,r.useCallback((function(e){a||c(e)}),[])]}}},[["l/PA",0,1,2,3,12]]]);