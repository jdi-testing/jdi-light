_N_E=(window.webpackJsonp_N_E=window.webpackJsonp_N_E||[]).push([[77],{"4Hym":function(t,e,n){"use strict";n.d(e,"b",(function(){return i})),n.d(e,"a",(function(){return r}));var i=function(t){return t.scrollTop};function r(t,e){var n=t.timeout,i=t.style,r=void 0===i?{}:i;return{duration:r.transitionDuration||"number"===typeof n?n:n[e.mode]||0,delay:r.transitionDelay}}},"7Ww7":function(t,e,n){"use strict";n.r(e),n.d(e,"default",(function(){return S}));var i=n("nKUr"),r=n("q1tI"),o=n.n(r),a=n("Ji2X"),c=n("hlFM"),s=n("rePB"),l=n("ODXe"),u=n("R/WZ"),p=n("AOnC"),d=n("ofer"),f=n("tRbT"),h=n("Z3vd"),b=n("kKU3"),x=n("kKAo");function m(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,i)}return n}function g(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?m(Object(n),!0).forEach((function(e){Object(s.a)(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):m(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}var v=Object(u.a)((function(t){return{typography:{padding:t.spacing(2)}}}));function j(){var t=o.a.useState(!1),e=Object(l.a)(t,2),n=e[0],r=e[1],a=o.a.useState(null),c=Object(l.a)(a,2),s=c[0],u=c[1],f=v(),h=function(){r(!1)},m=n?"faked-reference-popper":void 0;return Object(i.jsxs)("div",{onMouseLeave:h,children:[Object(i.jsx)(d.a,{"aria-describedby":m,onMouseUp:function(){var t=window.getSelection();if(t&&t.anchorOffset!==t.focusOffset){var e=function(){return t.getRangeAt(0).getBoundingClientRect()};r(!0),u({clientWidth:e().width,clientHeight:e().height,getBoundingClientRect:e})}else h()},children:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ipsum purus, bibendum sit amet vulputate eget, porta semper ligula. Donec bibendum vulputate erat, ac fringilla mi finibus nec. Donec ac dolor sed dolor porttitor blandit vel vel purus. Fusce vel malesuada ligula. Nam quis vehicula ante, eu finibus est. Proin ullamcorper fermentum orci, quis finibus massa. Nunc lobortis, massa ut rutrum ultrices, metus metus finibus ex, sit amet facilisis neque enim sed neque. Quisque accumsan metus vel maximus consequat. Suspendisse lacinia tellus a libero volutpat maximus."}),Object(i.jsx)(p.a,{id:m,open:n,anchorEl:s,transition:!0,placement:"bottom-start",children:function(t){var e=t.TransitionProps;return Object(i.jsx)(b.a,g(g({},e),{},{timeout:350,children:Object(i.jsx)(x.a,{children:Object(i.jsx)(d.a,{className:f.typography,children:"The content of the Popper."})})}))}})]})}function y(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,i)}return n}function O(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?y(Object(n),!0).forEach((function(e){Object(s.a)(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):y(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}var E=Object(u.a)((function(t){return{root:{hight:800,width:600},typography:{padding:t.spacing(2)}}}));function w(){var t=o.a.useState(null),e=Object(l.a)(t,2),n=e[0],r=e[1],a=o.a.useState(!1),c=Object(l.a)(a,2),s=c[0],u=c[1],m=o.a.useState(),g=Object(l.a)(m,2),v=g[0],y=g[1],w=E(),S=function(t){return function(e){r(e.currentTarget),u((function(e){return v!==t||!e})),y(t)}};return Object(i.jsxs)("div",{children:[Object(i.jsx)("h1",{children:"Poppers"}),Object(i.jsx)("h2",{children:"Positioned popper"}),Object(i.jsxs)("div",{className:w.root,children:[Object(i.jsx)(p.a,{open:s,anchorEl:n,placement:v,transition:!0,id:"positionedPopper",children:function(t){var e=t.TransitionProps;return Object(i.jsx)(b.a,O(O({},e),{},{timeout:350,children:Object(i.jsx)(x.a,{children:Object(i.jsx)(d.a,{className:w.typography,children:"The content of the Popper."})})}))}}),Object(i.jsx)(f.a,{container:!0,justify:"center",children:Object(i.jsxs)(f.a,{item:!0,container:!0,xs:6,alignItems:"center",direction:"column",children:[Object(i.jsx)(f.a,{item:!0,children:Object(i.jsx)(h.a,{onClick:S("top"),children:"top"})}),Object(i.jsx)(f.a,{item:!0,children:Object(i.jsx)(h.a,{onClick:S("left"),children:"left"})}),Object(i.jsx)(f.a,{item:!0,children:Object(i.jsx)(h.a,{onClick:S("right"),children:"right"})}),Object(i.jsx)(f.a,{item:!0,children:Object(i.jsx)(h.a,{onClick:S("bottom"),children:"bottom"})})]})})]}),Object(i.jsx)("h2",{children:"Fake reference object"}),Object(i.jsx)(j,{})]})}function S(){return Object(i.jsx)(a.a,{maxWidth:"xl",children:Object(i.jsx)(c.a,{my:4,children:Object(i.jsx)(w,{})})})}},"MKL+":function(t,e,n){(window.__NEXT_P=window.__NEXT_P||[]).push(["/popper",function(){return n("7Ww7")}])},"R/WZ":function(t,e,n){"use strict";var i=n("wx14"),r=n("RD7I"),o=n("cNwE");e.a=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return Object(r.a)(t,Object(i.a)({defaultTheme:o.a},e))}},bjog:function(t,e,n){"use strict";var i=n("q1tI"),r=n("i8i4"),o=(n("17x9"),n("GIek")),a=n("bfFb");var c="undefined"!==typeof window?i.useLayoutEffect:i.useEffect,s=i.forwardRef((function(t,e){var n=t.children,s=t.container,l=t.disablePortal,u=void 0!==l&&l,p=t.onRendered,d=i.useState(null),f=d[0],h=d[1],b=Object(a.a)(i.isValidElement(n)?n.ref:null,e);return c((function(){u||h(function(t){return t="function"===typeof t?t():t,r.findDOMNode(t)}(s)||document.body)}),[s,u]),c((function(){if(f&&!u)return Object(o.a)(e,f),function(){Object(o.a)(e,null)}}),[e,f,u]),c((function(){p&&(f||u)&&p()}),[p,f,u]),u?i.isValidElement(n)?i.cloneElement(n,{ref:b}):n:f?r.createPortal(n,f):f}));e.a=s},dRu9:function(t,e,n){"use strict";var i=n("zLVn"),r=n("dI71"),o=(n("17x9"),n("q1tI")),a=n.n(o),c=n("i8i4"),s=n.n(c),l=!1,u=n("0PSK"),p="unmounted",d="exited",f="entering",h="entered",b="exiting",x=function(t){function e(e,n){var i;i=t.call(this,e,n)||this;var r,o=n&&!n.isMounting?e.enter:e.appear;return i.appearStatus=null,e.in?o?(r=d,i.appearStatus=f):r=h:r=e.unmountOnExit||e.mountOnEnter?p:d,i.state={status:r},i.nextCallback=null,i}Object(r.a)(e,t),e.getDerivedStateFromProps=function(t,e){return t.in&&e.status===p?{status:d}:null};var n=e.prototype;return n.componentDidMount=function(){this.updateStatus(!0,this.appearStatus)},n.componentDidUpdate=function(t){var e=null;if(t!==this.props){var n=this.state.status;this.props.in?n!==f&&n!==h&&(e=f):n!==f&&n!==h||(e=b)}this.updateStatus(!1,e)},n.componentWillUnmount=function(){this.cancelNextCallback()},n.getTimeouts=function(){var t,e,n,i=this.props.timeout;return t=e=n=i,null!=i&&"number"!==typeof i&&(t=i.exit,e=i.enter,n=void 0!==i.appear?i.appear:e),{exit:t,enter:e,appear:n}},n.updateStatus=function(t,e){void 0===t&&(t=!1),null!==e?(this.cancelNextCallback(),e===f?this.performEnter(t):this.performExit()):this.props.unmountOnExit&&this.state.status===d&&this.setState({status:p})},n.performEnter=function(t){var e=this,n=this.props.enter,i=this.context?this.context.isMounting:t,r=this.props.nodeRef?[i]:[s.a.findDOMNode(this),i],o=r[0],a=r[1],c=this.getTimeouts(),u=i?c.appear:c.enter;!t&&!n||l?this.safeSetState({status:h},(function(){e.props.onEntered(o)})):(this.props.onEnter(o,a),this.safeSetState({status:f},(function(){e.props.onEntering(o,a),e.onTransitionEnd(u,(function(){e.safeSetState({status:h},(function(){e.props.onEntered(o,a)}))}))})))},n.performExit=function(){var t=this,e=this.props.exit,n=this.getTimeouts(),i=this.props.nodeRef?void 0:s.a.findDOMNode(this);e&&!l?(this.props.onExit(i),this.safeSetState({status:b},(function(){t.props.onExiting(i),t.onTransitionEnd(n.exit,(function(){t.safeSetState({status:d},(function(){t.props.onExited(i)}))}))}))):this.safeSetState({status:d},(function(){t.props.onExited(i)}))},n.cancelNextCallback=function(){null!==this.nextCallback&&(this.nextCallback.cancel(),this.nextCallback=null)},n.safeSetState=function(t,e){e=this.setNextCallback(e),this.setState(t,e)},n.setNextCallback=function(t){var e=this,n=!0;return this.nextCallback=function(i){n&&(n=!1,e.nextCallback=null,t(i))},this.nextCallback.cancel=function(){n=!1},this.nextCallback},n.onTransitionEnd=function(t,e){this.setNextCallback(e);var n=this.props.nodeRef?this.props.nodeRef.current:s.a.findDOMNode(this),i=null==t&&!this.props.addEndListener;if(n&&!i){if(this.props.addEndListener){var r=this.props.nodeRef?[this.nextCallback]:[n,this.nextCallback],o=r[0],a=r[1];this.props.addEndListener(o,a)}null!=t&&setTimeout(this.nextCallback,t)}else setTimeout(this.nextCallback,0)},n.render=function(){var t=this.state.status;if(t===p)return null;var e=this.props,n=e.children,r=(e.in,e.mountOnEnter,e.unmountOnExit,e.appear,e.enter,e.exit,e.timeout,e.addEndListener,e.onEnter,e.onEntering,e.onEntered,e.onExit,e.onExiting,e.onExited,e.nodeRef,Object(i.a)(e,["children","in","mountOnEnter","unmountOnExit","appear","enter","exit","timeout","addEndListener","onEnter","onEntering","onEntered","onExit","onExiting","onExited","nodeRef"]));return a.a.createElement(u.a.Provider,{value:null},"function"===typeof n?n(t,r):a.a.cloneElement(a.a.Children.only(n),r))},e}(a.a.Component);function m(){}x.contextType=u.a,x.propTypes={},x.defaultProps={in:!1,mountOnEnter:!1,unmountOnExit:!1,appear:!1,enter:!0,exit:!0,onEnter:m,onEntering:m,onEntered:m,onExit:m,onExiting:m,onExited:m},x.UNMOUNTED=p,x.EXITED=d,x.ENTERING=f,x.ENTERED=h,x.EXITING=b;e.a=x},kKAo:function(t,e,n){"use strict";var i=n("Ff2n"),r=n("wx14"),o=n("q1tI"),a=(n("17x9"),n("iuhU")),c=n("H2TA"),s=o.forwardRef((function(t,e){var n=t.classes,c=t.className,s=t.component,l=void 0===s?"div":s,u=t.square,p=void 0!==u&&u,d=t.elevation,f=void 0===d?1:d,h=t.variant,b=void 0===h?"elevation":h,x=Object(i.a)(t,["classes","className","component","square","elevation","variant"]);return o.createElement(l,Object(r.a)({className:Object(a.a)(n.root,c,"outlined"===b?n.outlined:n["elevation".concat(f)],!p&&n.rounded),ref:e},x))}));e.a=Object(c.a)((function(t){var e={};return t.shadows.forEach((function(t,n){e["elevation".concat(n)]={boxShadow:t}})),Object(r.a)({root:{backgroundColor:t.palette.background.paper,color:t.palette.text.primary,transition:t.transitions.create("box-shadow")},rounded:{borderRadius:t.shape.borderRadius},outlined:{border:"1px solid ".concat(t.palette.divider)}},e)}),{name:"MuiPaper"})(s)},kKU3:function(t,e,n){"use strict";var i=n("wx14"),r=n("ODXe"),o=n("Ff2n"),a=n("q1tI"),c=(n("17x9"),n("dRu9")),s=n("wpWl"),l=n("tr08"),u=n("4Hym"),p=n("bfFb"),d={entering:{opacity:1},entered:{opacity:1}},f={enter:s.b.enteringScreen,exit:s.b.leavingScreen},h=a.forwardRef((function(t,e){var n=t.children,s=t.disableStrictModeCompat,h=void 0!==s&&s,b=t.in,x=t.onEnter,m=t.onEntered,g=t.onEntering,v=t.onExit,j=t.onExited,y=t.onExiting,O=t.style,E=t.TransitionComponent,w=void 0===E?c.a:E,S=t.timeout,C=void 0===S?f:S,k=Object(o.a)(t,["children","disableStrictModeCompat","in","onEnter","onEntered","onEntering","onExit","onExited","onExiting","style","TransitionComponent","timeout"]),N=Object(l.a)(),P=N.unstable_strictMode&&!h,T=a.useRef(null),R=Object(p.a)(n.ref,e),D=Object(p.a)(P?T:void 0,R),M=function(t){return function(e,n){if(t){var i=P?[T.current,e]:[e,n],o=Object(r.a)(i,2),a=o[0],c=o[1];void 0===c?t(a):t(a,c)}}},I=M(g),W=M((function(t,e){Object(u.b)(t);var n=Object(u.a)({style:O,timeout:C},{mode:"enter"});t.style.webkitTransition=N.transitions.create("opacity",n),t.style.transition=N.transitions.create("opacity",n),x&&x(t,e)})),q=M(m),A=M(y),B=M((function(t){var e=Object(u.a)({style:O,timeout:C},{mode:"exit"});t.style.webkitTransition=N.transitions.create("opacity",e),t.style.transition=N.transitions.create("opacity",e),v&&v(t)})),_=M(j);return a.createElement(w,Object(i.a)({appear:!0,in:b,nodeRef:P?T:void 0,onEnter:W,onEntered:q,onEntering:I,onExit:B,onExited:_,onExiting:A,timeout:C},k),(function(t,e){return a.cloneElement(n,Object(i.a)({style:Object(i.a)({opacity:0,visibility:"exited"!==t||b?void 0:"hidden"},d[t],O,n.props.style),ref:D},e))}))}));e.a=h},ofer:function(t,e,n){"use strict";var i=n("wx14"),r=n("Ff2n"),o=n("q1tI"),a=(n("17x9"),n("iuhU")),c=n("H2TA"),s=n("NqtD"),l={h1:"h1",h2:"h2",h3:"h3",h4:"h4",h5:"h5",h6:"h6",subtitle1:"h6",subtitle2:"h6",body1:"p",body2:"p"},u=o.forwardRef((function(t,e){var n=t.align,c=void 0===n?"inherit":n,u=t.classes,p=t.className,d=t.color,f=void 0===d?"initial":d,h=t.component,b=t.display,x=void 0===b?"initial":b,m=t.gutterBottom,g=void 0!==m&&m,v=t.noWrap,j=void 0!==v&&v,y=t.paragraph,O=void 0!==y&&y,E=t.variant,w=void 0===E?"body1":E,S=t.variantMapping,C=void 0===S?l:S,k=Object(r.a)(t,["align","classes","className","color","component","display","gutterBottom","noWrap","paragraph","variant","variantMapping"]),N=h||(O?"p":C[w]||l[w])||"span";return o.createElement(N,Object(i.a)({className:Object(a.a)(u.root,p,"inherit"!==w&&u[w],"initial"!==f&&u["color".concat(Object(s.a)(f))],j&&u.noWrap,g&&u.gutterBottom,O&&u.paragraph,"inherit"!==c&&u["align".concat(Object(s.a)(c))],"initial"!==x&&u["display".concat(Object(s.a)(x))]),ref:e},k))}));e.a=Object(c.a)((function(t){return{root:{margin:0},body2:t.typography.body2,body1:t.typography.body1,caption:t.typography.caption,button:t.typography.button,h1:t.typography.h1,h2:t.typography.h2,h3:t.typography.h3,h4:t.typography.h4,h5:t.typography.h5,h6:t.typography.h6,subtitle1:t.typography.subtitle1,subtitle2:t.typography.subtitle2,overline:t.typography.overline,srOnly:{position:"absolute",height:1,width:1,overflow:"hidden"},alignLeft:{textAlign:"left"},alignCenter:{textAlign:"center"},alignRight:{textAlign:"right"},alignJustify:{textAlign:"justify"},noWrap:{overflow:"hidden",textOverflow:"ellipsis",whiteSpace:"nowrap"},gutterBottom:{marginBottom:"0.35em"},paragraph:{marginBottom:16},colorInherit:{color:"inherit"},colorPrimary:{color:t.palette.primary.main},colorSecondary:{color:t.palette.secondary.main},colorTextPrimary:{color:t.palette.text.primary},colorTextSecondary:{color:t.palette.text.secondary},colorError:{color:t.palette.error.main},displayInline:{display:"inline"},displayBlock:{display:"block"}}}),{name:"MuiTypography"})(u)},tRbT:function(t,e,n){"use strict";var i=n("Ff2n"),r=n("wx14"),o=n("q1tI"),a=(n("17x9"),n("iuhU")),c=n("H2TA"),s=[0,1,2,3,4,5,6,7,8,9,10],l=["auto",!0,1,2,3,4,5,6,7,8,9,10,11,12];function u(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,n=parseFloat(t);return"".concat(n/e).concat(String(t).replace(String(n),"")||"px")}var p=o.forwardRef((function(t,e){var n=t.alignContent,c=void 0===n?"stretch":n,s=t.alignItems,l=void 0===s?"stretch":s,u=t.classes,p=t.className,d=t.component,f=void 0===d?"div":d,h=t.container,b=void 0!==h&&h,x=t.direction,m=void 0===x?"row":x,g=t.item,v=void 0!==g&&g,j=t.justify,y=void 0===j?"flex-start":j,O=t.lg,E=void 0!==O&&O,w=t.md,S=void 0!==w&&w,C=t.sm,k=void 0!==C&&C,N=t.spacing,P=void 0===N?0:N,T=t.wrap,R=void 0===T?"wrap":T,D=t.xl,M=void 0!==D&&D,I=t.xs,W=void 0!==I&&I,q=t.zeroMinWidth,A=void 0!==q&&q,B=Object(i.a)(t,["alignContent","alignItems","classes","className","component","container","direction","item","justify","lg","md","sm","spacing","wrap","xl","xs","zeroMinWidth"]),_=Object(a.a)(u.root,p,b&&[u.container,0!==P&&u["spacing-xs-".concat(String(P))]],v&&u.item,A&&u.zeroMinWidth,"row"!==m&&u["direction-xs-".concat(String(m))],"wrap"!==R&&u["wrap-xs-".concat(String(R))],"stretch"!==l&&u["align-items-xs-".concat(String(l))],"stretch"!==c&&u["align-content-xs-".concat(String(c))],"flex-start"!==y&&u["justify-xs-".concat(String(y))],!1!==W&&u["grid-xs-".concat(String(W))],!1!==k&&u["grid-sm-".concat(String(k))],!1!==S&&u["grid-md-".concat(String(S))],!1!==E&&u["grid-lg-".concat(String(E))],!1!==M&&u["grid-xl-".concat(String(M))]);return o.createElement(f,Object(r.a)({className:_,ref:e},B))})),d=Object(c.a)((function(t){return Object(r.a)({root:{},container:{boxSizing:"border-box",display:"flex",flexWrap:"wrap",width:"100%"},item:{boxSizing:"border-box",margin:"0"},zeroMinWidth:{minWidth:0},"direction-xs-column":{flexDirection:"column"},"direction-xs-column-reverse":{flexDirection:"column-reverse"},"direction-xs-row-reverse":{flexDirection:"row-reverse"},"wrap-xs-nowrap":{flexWrap:"nowrap"},"wrap-xs-wrap-reverse":{flexWrap:"wrap-reverse"},"align-items-xs-center":{alignItems:"center"},"align-items-xs-flex-start":{alignItems:"flex-start"},"align-items-xs-flex-end":{alignItems:"flex-end"},"align-items-xs-baseline":{alignItems:"baseline"},"align-content-xs-center":{alignContent:"center"},"align-content-xs-flex-start":{alignContent:"flex-start"},"align-content-xs-flex-end":{alignContent:"flex-end"},"align-content-xs-space-between":{alignContent:"space-between"},"align-content-xs-space-around":{alignContent:"space-around"},"justify-xs-center":{justifyContent:"center"},"justify-xs-flex-end":{justifyContent:"flex-end"},"justify-xs-space-between":{justifyContent:"space-between"},"justify-xs-space-around":{justifyContent:"space-around"},"justify-xs-space-evenly":{justifyContent:"space-evenly"}},function(t,e){var n={};return s.forEach((function(i){var r=t.spacing(i);0!==r&&(n["spacing-".concat(e,"-").concat(i)]={margin:"-".concat(u(r,2)),width:"calc(100% + ".concat(u(r),")"),"& > $item":{padding:u(r,2)}})})),n}(t,"xs"),t.breakpoints.keys.reduce((function(e,n){return function(t,e,n){var i={};l.forEach((function(t){var e="grid-".concat(n,"-").concat(t);if(!0!==t)if("auto"!==t){var r="".concat(Math.round(t/12*1e8)/1e6,"%");i[e]={flexBasis:r,flexGrow:0,maxWidth:r}}else i[e]={flexBasis:"auto",flexGrow:0,maxWidth:"none"};else i[e]={flexBasis:0,flexGrow:1,maxWidth:"100%"}})),"xs"===n?Object(r.a)(t,i):t[e.breakpoints.up(n)]=i}(e,t,n),e}),{}))}),{name:"MuiGrid"})(p);e.a=d},tr08:function(t,e,n){"use strict";n.d(e,"a",(function(){return o}));var i=n("aXM8"),r=(n("q1tI"),n("cNwE"));function o(){return Object(i.a)()||r.a}},x6Ns:function(t,e,n){"use strict";function i(){for(var t=arguments.length,e=new Array(t),n=0;n<t;n++)e[n]=arguments[n];return e.reduce((function(t,e){return null==e?t:function(){for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];t.apply(this,i),e.apply(this,i)}}),(function(){}))}n.d(e,"a",(function(){return i}))}},[["MKL+",0,1,2,3,4,16]]]);