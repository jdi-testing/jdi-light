(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[9283],{59009:function(e,o,t){"use strict";var r=t(87462),a=t(45987),n=t(67294),i=(t(45697),t(86010)),l=t(1591),d=t(93871),c=n.forwardRef((function(e,o){var t=e.anchorOrigin,l=void 0===t?{vertical:"top",horizontal:"right"}:t,c=e.badgeContent,s=e.children,p=e.classes,u=e.className,h=e.color,m=void 0===h?"default":h,g=e.component,b=void 0===g?"span":g,f=e.invisible,v=e.max,x=void 0===v?99:v,y=e.overlap,Z=void 0===y?"rectangle":y,C=e.showZero,S=void 0!==C&&C,z=e.variant,R=void 0===z?"standard":z,w=(0,a.Z)(e,["anchorOrigin","badgeContent","children","classes","className","color","component","invisible","max","overlap","showZero","variant"]),k=f;null==f&&(0===c&&!S||null==c&&"dot"!==R)&&(k=!0);var j="";return"dot"!==R&&(j=c>x?"".concat(x,"+"):c),n.createElement(b,(0,r.Z)({className:(0,i.Z)(p.root,u),ref:o},w),s,n.createElement("span",{className:(0,i.Z)(p.badge,p["".concat(l.horizontal).concat((0,d.Z)(l.vertical),"}")],p["anchorOrigin".concat((0,d.Z)(l.vertical)).concat((0,d.Z)(l.horizontal)).concat((0,d.Z)(Z))],"default"!==m&&p["color".concat((0,d.Z)(m))],k&&p.invisible,"dot"===R&&p.dot)},j))}));o.Z=(0,l.Z)((function(e){return{root:{position:"relative",display:"inline-flex",verticalAlign:"middle",flexShrink:0},badge:{display:"flex",flexDirection:"row",flexWrap:"wrap",justifyContent:"center",alignContent:"center",alignItems:"center",position:"absolute",boxSizing:"border-box",fontFamily:e.typography.fontFamily,fontWeight:e.typography.fontWeightMedium,fontSize:e.typography.pxToRem(12),minWidth:20,lineHeight:1,padding:"0 6px",height:20,borderRadius:10,zIndex:1,transition:e.transitions.create("transform",{easing:e.transitions.easing.easeInOut,duration:e.transitions.duration.enteringScreen})},colorPrimary:{backgroundColor:e.palette.primary.main,color:e.palette.primary.contrastText},colorSecondary:{backgroundColor:e.palette.secondary.main,color:e.palette.secondary.contrastText},colorError:{backgroundColor:e.palette.error.main,color:e.palette.error.contrastText},dot:{borderRadius:4,height:8,minWidth:8,padding:0},anchorOriginTopRightRectangle:{top:0,right:0,transform:"scale(1) translate(50%, -50%)",transformOrigin:"100% 0%","&$invisible":{transform:"scale(0) translate(50%, -50%)"}},anchorOriginBottomRightRectangle:{bottom:0,right:0,transform:"scale(1) translate(50%, 50%)",transformOrigin:"100% 100%","&$invisible":{transform:"scale(0) translate(50%, 50%)"}},anchorOriginTopLeftRectangle:{top:0,left:0,transform:"scale(1) translate(-50%, -50%)",transformOrigin:"0% 0%","&$invisible":{transform:"scale(0) translate(-50%, -50%)"}},anchorOriginBottomLeftRectangle:{bottom:0,left:0,transform:"scale(1) translate(-50%, 50%)",transformOrigin:"0% 100%","&$invisible":{transform:"scale(0) translate(-50%, 50%)"}},anchorOriginTopRightCircle:{top:"14%",right:"14%",transform:"scale(1) translate(50%, -50%)",transformOrigin:"100% 0%","&$invisible":{transform:"scale(0) translate(50%, -50%)"}},anchorOriginBottomRightCircle:{bottom:"14%",right:"14%",transform:"scale(1) translate(50%, 50%)",transformOrigin:"100% 100%","&$invisible":{transform:"scale(0) translate(50%, 50%)"}},anchorOriginTopLeftCircle:{top:"14%",left:"14%",transform:"scale(1) translate(-50%, -50%)",transformOrigin:"0% 0%","&$invisible":{transform:"scale(0) translate(-50%, -50%)"}},anchorOriginBottomLeftCircle:{bottom:"14%",left:"14%",transform:"scale(1) translate(-50%, 50%)",transformOrigin:"0% 100%","&$invisible":{transform:"scale(0) translate(-50%, 50%)"}},invisible:{transition:e.transitions.create("transform",{easing:e.transitions.easing.easeInOut,duration:e.transitions.duration.leavingScreen})}}}),{name:"MuiBadge"})(c)},24837:function(e,o,t){"use strict";var r=t(87462),a=t(45987),n=t(67294),i=(t(59864),t(45697),t(86010)),l=t(93871),d=t(59693),c=t(1591);t(282).Z.styles;var s=n.forwardRef((function(e,o){var t=e.children,d=e.classes,c=e.className,s=e.color,p=void 0===s?"default":s,u=e.component,h=void 0===u?"div":u,m=e.disabled,g=void 0!==m&&m,b=e.disableElevation,f=void 0!==b&&b,v=e.disableFocusRipple,x=void 0!==v&&v,y=e.disableRipple,Z=void 0!==y&&y,C=e.fullWidth,S=void 0!==C&&C,z=e.orientation,R=void 0===z?"horizontal":z,w=e.size,k=void 0===w?"medium":w,j=e.variant,O=void 0===j?"outlined":j,T=(0,a.Z)(e,["children","classes","className","color","component","disabled","disableElevation","disableFocusRipple","disableRipple","fullWidth","orientation","size","variant"]),E=(0,i.Z)(d.grouped,d["grouped".concat((0,l.Z)(R))],d["grouped".concat((0,l.Z)(O))],d["grouped".concat((0,l.Z)(O)).concat((0,l.Z)(R))],d["grouped".concat((0,l.Z)(O)).concat("default"!==p?(0,l.Z)(p):"")],g&&d.disabled);return n.createElement(h,(0,r.Z)({role:"group",className:(0,i.Z)(d.root,c,S&&d.fullWidth,f&&d.disableElevation,"contained"===O&&d.contained,"vertical"===R&&d.vertical),ref:o},T),n.Children.map(t,(function(e){return n.isValidElement(e)?n.cloneElement(e,{className:(0,i.Z)(E,e.props.className),color:e.props.color||p,disabled:e.props.disabled||g,disableElevation:e.props.disableElevation||f,disableFocusRipple:x,disableRipple:Z,fullWidth:S,size:e.props.size||k,variant:e.props.variant||O}):null})))}));o.Z=(0,c.Z)((function(e){return{root:{display:"inline-flex",borderRadius:e.shape.borderRadius},contained:{boxShadow:e.shadows[2]},disableElevation:{boxShadow:"none"},disabled:{},fullWidth:{width:"100%"},vertical:{flexDirection:"column"},grouped:{minWidth:40},groupedHorizontal:{"&:not(:first-child)":{borderTopLeftRadius:0,borderBottomLeftRadius:0},"&:not(:last-child)":{borderTopRightRadius:0,borderBottomRightRadius:0}},groupedVertical:{"&:not(:first-child)":{borderTopRightRadius:0,borderTopLeftRadius:0},"&:not(:last-child)":{borderBottomRightRadius:0,borderBottomLeftRadius:0}},groupedText:{},groupedTextHorizontal:{"&:not(:last-child)":{borderRight:"1px solid ".concat("light"===e.palette.type?"rgba(0, 0, 0, 0.23)":"rgba(255, 255, 255, 0.23)")}},groupedTextVertical:{"&:not(:last-child)":{borderBottom:"1px solid ".concat("light"===e.palette.type?"rgba(0, 0, 0, 0.23)":"rgba(255, 255, 255, 0.23)")}},groupedTextPrimary:{"&:not(:last-child)":{borderColor:(0,d.U1)(e.palette.primary.main,.5)}},groupedTextSecondary:{"&:not(:last-child)":{borderColor:(0,d.U1)(e.palette.secondary.main,.5)}},groupedOutlined:{},groupedOutlinedHorizontal:{"&:not(:first-child)":{marginLeft:-1},"&:not(:last-child)":{borderRightColor:"transparent"}},groupedOutlinedVertical:{"&:not(:first-child)":{marginTop:-1},"&:not(:last-child)":{borderBottomColor:"transparent"}},groupedOutlinedPrimary:{"&:hover":{borderColor:e.palette.primary.main}},groupedOutlinedSecondary:{"&:hover":{borderColor:e.palette.secondary.main}},groupedContained:{boxShadow:"none"},groupedContainedHorizontal:{"&:not(:last-child)":{borderRight:"1px solid ".concat(e.palette.grey[400]),"&$disabled":{borderRight:"1px solid ".concat(e.palette.action.disabled)}}},groupedContainedVertical:{"&:not(:last-child)":{borderBottom:"1px solid ".concat(e.palette.grey[400]),"&$disabled":{borderBottom:"1px solid ".concat(e.palette.action.disabled)}}},groupedContainedPrimary:{"&:not(:last-child)":{borderColor:e.palette.primary.dark}},groupedContainedSecondary:{"&:not(:last-child)":{borderColor:e.palette.secondary.dark}}}}),{name:"MuiButtonGroup"})(s)},282:function(e,o,t){"use strict";var r=t(45987),a=t(87462),n=t(67294),i=(t(45697),t(86010)),l=t(1591),d=t(59693),c=t(4024),s=t(93871),p=n.forwardRef((function(e,o){var t=e.children,l=e.classes,d=e.className,p=e.color,u=void 0===p?"default":p,h=e.component,m=void 0===h?"button":h,g=e.disabled,b=void 0!==g&&g,f=e.disableElevation,v=void 0!==f&&f,x=e.disableFocusRipple,y=void 0!==x&&x,Z=e.endIcon,C=e.focusVisibleClassName,S=e.fullWidth,z=void 0!==S&&S,R=e.size,w=void 0===R?"medium":R,k=e.startIcon,j=e.type,O=void 0===j?"button":j,T=e.variant,E=void 0===T?"text":T,B=(0,r.Z)(e,["children","classes","className","color","component","disabled","disableElevation","disableFocusRipple","endIcon","focusVisibleClassName","fullWidth","size","startIcon","type","variant"]),$=k&&n.createElement("span",{className:(0,i.Z)(l.startIcon,l["iconSize".concat((0,s.Z)(w))])},k),N=Z&&n.createElement("span",{className:(0,i.Z)(l.endIcon,l["iconSize".concat((0,s.Z)(w))])},Z);return n.createElement(c.Z,(0,a.Z)({className:(0,i.Z)(l.root,l[E],d,"inherit"===u?l.colorInherit:"default"!==u&&l["".concat(E).concat((0,s.Z)(u))],"medium"!==w&&[l["".concat(E,"Size").concat((0,s.Z)(w))],l["size".concat((0,s.Z)(w))]],v&&l.disableElevation,b&&l.disabled,z&&l.fullWidth),component:m,disabled:b,focusRipple:!y,focusVisibleClassName:(0,i.Z)(l.focusVisible,C),ref:o,type:O},B),n.createElement("span",{className:l.label},$,t,N))}));o.Z=(0,l.Z)((function(e){return{root:(0,a.Z)({},e.typography.button,{boxSizing:"border-box",minWidth:64,padding:"6px 16px",borderRadius:e.shape.borderRadius,color:e.palette.text.primary,transition:e.transitions.create(["background-color","box-shadow","border"],{duration:e.transitions.duration.short}),"&:hover":{textDecoration:"none",backgroundColor:(0,d.U1)(e.palette.text.primary,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"},"&$disabled":{backgroundColor:"transparent"}},"&$disabled":{color:e.palette.action.disabled}}),label:{width:"100%",display:"inherit",alignItems:"inherit",justifyContent:"inherit"},text:{padding:"6px 8px"},textPrimary:{color:e.palette.primary.main,"&:hover":{backgroundColor:(0,d.U1)(e.palette.primary.main,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}}},textSecondary:{color:e.palette.secondary.main,"&:hover":{backgroundColor:(0,d.U1)(e.palette.secondary.main,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}}},outlined:{padding:"5px 15px",border:"1px solid ".concat("light"===e.palette.type?"rgba(0, 0, 0, 0.23)":"rgba(255, 255, 255, 0.23)"),"&$disabled":{border:"1px solid ".concat(e.palette.action.disabledBackground)}},outlinedPrimary:{color:e.palette.primary.main,border:"1px solid ".concat((0,d.U1)(e.palette.primary.main,.5)),"&:hover":{border:"1px solid ".concat(e.palette.primary.main),backgroundColor:(0,d.U1)(e.palette.primary.main,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}}},outlinedSecondary:{color:e.palette.secondary.main,border:"1px solid ".concat((0,d.U1)(e.palette.secondary.main,.5)),"&:hover":{border:"1px solid ".concat(e.palette.secondary.main),backgroundColor:(0,d.U1)(e.palette.secondary.main,e.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:"transparent"}},"&$disabled":{border:"1px solid ".concat(e.palette.action.disabled)}},contained:{color:e.palette.getContrastText(e.palette.grey[300]),backgroundColor:e.palette.grey[300],boxShadow:e.shadows[2],"&:hover":{backgroundColor:e.palette.grey.A100,boxShadow:e.shadows[4],"@media (hover: none)":{boxShadow:e.shadows[2],backgroundColor:e.palette.grey[300]},"&$disabled":{backgroundColor:e.palette.action.disabledBackground}},"&$focusVisible":{boxShadow:e.shadows[6]},"&:active":{boxShadow:e.shadows[8]},"&$disabled":{color:e.palette.action.disabled,boxShadow:e.shadows[0],backgroundColor:e.palette.action.disabledBackground}},containedPrimary:{color:e.palette.primary.contrastText,backgroundColor:e.palette.primary.main,"&:hover":{backgroundColor:e.palette.primary.dark,"@media (hover: none)":{backgroundColor:e.palette.primary.main}}},containedSecondary:{color:e.palette.secondary.contrastText,backgroundColor:e.palette.secondary.main,"&:hover":{backgroundColor:e.palette.secondary.dark,"@media (hover: none)":{backgroundColor:e.palette.secondary.main}}},disableElevation:{boxShadow:"none","&:hover":{boxShadow:"none"},"&$focusVisible":{boxShadow:"none"},"&:active":{boxShadow:"none"},"&$disabled":{boxShadow:"none"}},focusVisible:{},disabled:{},colorInherit:{color:"inherit",borderColor:"currentColor"},textSizeSmall:{padding:"4px 5px",fontSize:e.typography.pxToRem(13)},textSizeLarge:{padding:"8px 11px",fontSize:e.typography.pxToRem(15)},outlinedSizeSmall:{padding:"3px 9px",fontSize:e.typography.pxToRem(13)},outlinedSizeLarge:{padding:"7px 21px",fontSize:e.typography.pxToRem(15)},containedSizeSmall:{padding:"4px 10px",fontSize:e.typography.pxToRem(13)},containedSizeLarge:{padding:"8px 22px",fontSize:e.typography.pxToRem(15)},sizeSmall:{},sizeLarge:{},fullWidth:{width:"100%"},startIcon:{display:"inherit",marginRight:8,marginLeft:-4,"&$iconSizeSmall":{marginLeft:-2}},endIcon:{display:"inherit",marginRight:-4,marginLeft:8,"&$iconSizeSmall":{marginRight:-2}},iconSizeSmall:{"& > *:first-child":{fontSize:18}},iconSizeMedium:{"& > *:first-child":{fontSize:20}},iconSizeLarge:{"& > *:first-child":{fontSize:22}}}}),{name:"MuiButton"})(p)},15736:function(e,o,t){"use strict";t.d(o,{Y:function(){return n}});var r=t(67294),a=r.createContext();function n(){return r.useContext(a)}o.Z=a},22601:function(e,o,t){"use strict";t.d(o,{Z:function(){return n}});var r=t(67294),a=t(15736);function n(){return r.useContext(a.Z)}},41120:function(e,o,t){"use strict";var r=t(87462),a=t(11719),n=t(99700);o.Z=function(e){var o=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(0,a.Z)(e,(0,r.Z)({defaultTheme:n.Z},o))}},63957:function(e,o,t){"use strict";var r=t(95318),a=t(20862);o.Z=void 0;var n=a(t(67294)),i=(0,r(t(2108)).default)(n.createElement("path",{d:"M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"}),"Add");o.Z=i},62865:function(e,o,t){"use strict";var r=t(95318),a=t(20862);o.Z=void 0;var n=a(t(67294)),i=(0,r(t(2108)).default)(n.createElement("path",{d:"M20 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm0 4l-8 5-8-5V6l8 5 8-5v2z"}),"Mail");o.Z=i},10064:function(e,o,t){"use strict";var r=t(95318),a=t(20862);o.Z=void 0;var n=a(t(67294)),i=(0,r(t(2108)).default)(n.createElement("path",{d:"M19 13H5v-2h14v2z"}),"Remove");o.Z=i},81827:function(e,o,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/badge",function(){return t(19031)}])},19031:function(e,o,t){"use strict";t.r(o),t.d(o,{default:function(){return x}});var r=t(85893),a=t(67294),n=t(43832),i=t(7560),l=t(41120),d=t(59009),c=t(24837),s=t(282),p=t(63957),u=t(10064),h=t(62865),m=t(9570),g=t(30553);function b(e,o){return function(e){if(Array.isArray(e))return e}(e)||function(e,o){var t=[],r=!0,a=!1,n=void 0;try{for(var i,l=e[Symbol.iterator]();!(r=(i=l.next()).done)&&(t.push(i.value),!o||t.length!==o);r=!0);}catch(d){a=!0,n=d}finally{try{r||null==l.return||l.return()}finally{if(a)throw n}}return t}(e,o)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var f=(0,l.Z)((function(e){return{root:{display:"flex",flexDirection:"column","& > *":{marginBottom:e.spacing(2)},"& .MuiBadge-root":{marginRight:e.spacing(4)},"& .MuiButtonGroup-root":{marginRight:e.spacing(4)}}}}));function v(){var e=f(),o=b(a.useState(1),2),t=o[0],n=o[1],i=b(a.useState(!1),2),l=i[0],v=i[1],x=b(a.useState(!1),2),y=x[0],Z=x[1];return(0,r.jsxs)("div",{className:e.root,children:[(0,r.jsx)("h1",{children:"Badges"}),(0,r.jsxs)("div",{children:[(0,r.jsx)(d.Z,{badgeContent:4,color:"primary",id:"primaryColorBadge",children:(0,r.jsx)(h.Z,{})}),(0,r.jsx)(d.Z,{badgeContent:4,color:"error",id:"errorColorBadge",children:(0,r.jsx)(h.Z,{})})]}),(0,r.jsxs)("div",{children:[(0,r.jsx)(d.Z,{color:"secondary",badgeContent:t,max:10,showZero:y,id:"secondaryColorBadge",children:(0,r.jsx)(h.Z,{})}),(0,r.jsxs)(c.Z,{children:[(0,r.jsx)(s.Z,{"aria-label":"reduce",onClick:function(){n(Math.max(t-1,0))},children:(0,r.jsx)(u.Z,{fontSize:"small"})}),(0,r.jsx)(s.Z,{"aria-label":"increase",onClick:function(){n(t+1)},children:(0,r.jsx)(p.Z,{fontSize:"small"})})]}),(0,r.jsx)(g.Z,{control:(0,r.jsx)(m.Z,{color:"primary",checked:!y,onChange:function(){Z(!y)}}),label:"Show Zero"})]}),(0,r.jsxs)("div",{children:[(0,r.jsx)(d.Z,{color:"secondary",variant:"dot",invisible:l,id:"dotBadge",children:(0,r.jsx)(h.Z,{})}),(0,r.jsx)(g.Z,{control:(0,r.jsx)(m.Z,{color:"primary",checked:!l,onChange:function(){v(!l)}}),label:"Show Badge"})]}),(0,r.jsxs)("div",{children:[(0,r.jsx)(d.Z,{badgeContent:-1,color:"primary",anchorOrigin:{vertical:"top",horizontal:"right"},children:(0,r.jsx)(h.Z,{})}),(0,r.jsx)(d.Z,{badgeContent:5,color:"primary",anchorOrigin:{vertical:"bottom",horizontal:"right"},children:(0,r.jsx)(h.Z,{})}),(0,r.jsx)(d.Z,{badgeContent:6,color:"primary",anchorOrigin:{vertical:"bottom",horizontal:"left"},children:(0,r.jsx)(h.Z,{})}),(0,r.jsx)(d.Z,{badgeContent:7,color:"primary",anchorOrigin:{vertical:"top",horizontal:"left"},children:(0,r.jsx)(h.Z,{})})]})]})}function x(){return(0,r.jsx)(n.Z,{maxWidth:"xl",children:(0,r.jsx)(i.Z,{my:4,children:(0,r.jsx)(v,{})})})}},69921:function(e,o){"use strict";var t=60103,r=60106,a=60107,n=60108,i=60114,l=60109,d=60110,c=60112,s=60113,p=60120,u=60115,h=60116,m=60121,g=60122,b=60117,f=60129,v=60131;if("function"===typeof Symbol&&Symbol.for){var x=Symbol.for;t=x("react.element"),r=x("react.portal"),a=x("react.fragment"),n=x("react.strict_mode"),i=x("react.profiler"),l=x("react.provider"),d=x("react.context"),c=x("react.forward_ref"),s=x("react.suspense"),p=x("react.suspense_list"),u=x("react.memo"),h=x("react.lazy"),m=x("react.block"),g=x("react.server.block"),b=x("react.fundamental"),f=x("react.debug_trace_mode"),v=x("react.legacy_hidden")}function y(e){if("object"===typeof e&&null!==e){var o=e.$$typeof;switch(o){case t:switch(e=e.type){case a:case i:case n:case s:case p:return e;default:switch(e=e&&e.$$typeof){case d:case c:case h:case u:case l:return e;default:return o}}case r:return o}}}},59864:function(e,o,t){"use strict";t(69921)}},function(e){e.O(0,[5770,9193,9774,2888,179],(function(){return o=81827,e(e.s=o);var o}));var o=e.O();_N_E=o}]);