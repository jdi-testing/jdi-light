(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5eec2b91"],{"0bc6":function(t,e,i){},"169a":function(t,e,i){"use strict";var n=i("5530"),a=i("2909"),o=i("ade3"),s=(i("a9e3"),i("498a"),i("caad"),i("2532"),i("7db0"),i("368e"),i("480e")),r=i("4ad4"),c=i("b848"),l=i("75eb"),d=i("e707"),u=i("e4d3"),h=i("21be"),v=i("f2e7"),f=i("a293"),p=i("58df"),m=i("d9bd"),b=i("80d2"),g=Object(p["a"])(r["a"],c["a"],l["a"],d["a"],u["a"],h["a"],v["a"]);e["a"]=g.extend({name:"v-dialog",directives:{ClickOutside:f["a"]},props:{dark:Boolean,disabled:Boolean,fullscreen:Boolean,light:Boolean,maxWidth:{type:[String,Number],default:"none"},noClickAnimation:Boolean,origin:{type:String,default:"center center"},persistent:Boolean,retainFocus:{type:Boolean,default:!0},scrollable:Boolean,transition:{type:[String,Boolean],default:"dialog-transition"},width:{type:[String,Number],default:"auto"}},data:function(){return{activatedBy:null,animate:!1,animateTimeout:-1,isActive:!!this.value,stackMinZIndex:200,previousActiveElement:null}},computed:{classes:function(){var t;return t={},Object(o["a"])(t,"v-dialog ".concat(this.contentClass).trim(),!0),Object(o["a"])(t,"v-dialog--active",this.isActive),Object(o["a"])(t,"v-dialog--persistent",this.persistent),Object(o["a"])(t,"v-dialog--fullscreen",this.fullscreen),Object(o["a"])(t,"v-dialog--scrollable",this.scrollable),Object(o["a"])(t,"v-dialog--animated",this.animate),t},contentClasses:function(){return{"v-dialog__content":!0,"v-dialog__content--active":this.isActive}},hasActivator:function(){return Boolean(!!this.$slots.activator||!!this.$scopedSlots.activator)}},watch:{isActive:function(t){var e;t?(this.show(),this.hideScroll()):(this.removeOverlay(),this.unbind(),null==(e=this.previousActiveElement)||e.focus())},fullscreen:function(t){this.isActive&&(t?(this.hideScroll(),this.removeOverlay(!1)):(this.showScroll(),this.genOverlay()))}},created:function(){this.$attrs.hasOwnProperty("full-width")&&Object(m["e"])("full-width",this)},beforeMount:function(){var t=this;this.$nextTick((function(){t.isBooted=t.isActive,t.isActive&&t.show()}))},beforeDestroy:function(){"undefined"!==typeof window&&this.unbind()},methods:{animateClick:function(){var t=this;this.animate=!1,this.$nextTick((function(){t.animate=!0,window.clearTimeout(t.animateTimeout),t.animateTimeout=window.setTimeout((function(){return t.animate=!1}),150)}))},closeConditional:function(t){var e=t.target;return!(this._isDestroyed||!this.isActive||this.$refs.content.contains(e)||this.overlay&&e&&!this.overlay.$el.contains(e))&&this.activeZIndex>=this.getMaxZIndex()},hideScroll:function(){this.fullscreen?document.documentElement.classList.add("overflow-y-hidden"):d["a"].options.methods.hideScroll.call(this)},show:function(){var t=this;!this.fullscreen&&!this.hideOverlay&&this.genOverlay(),this.$nextTick((function(){t.$nextTick((function(){t.previousActiveElement=document.activeElement,t.$refs.content.focus(),t.bind()}))}))},bind:function(){window.addEventListener("focusin",this.onFocusin)},unbind:function(){window.removeEventListener("focusin",this.onFocusin)},onClickOutside:function(t){this.$emit("click:outside",t),this.persistent?this.noClickAnimation||this.animateClick():this.isActive=!1},onKeydown:function(t){if(t.keyCode===b["s"].esc&&!this.getOpenDependents().length)if(this.persistent)this.noClickAnimation||this.animateClick();else{this.isActive=!1;var e=this.getActivator();this.$nextTick((function(){return e&&e.focus()}))}this.$emit("keydown",t)},onFocusin:function(t){if(t&&this.retainFocus){var e=t.target;if(e&&![document,this.$refs.content].includes(e)&&!this.$refs.content.contains(e)&&this.activeZIndex>=this.getMaxZIndex()&&!this.getOpenDependentElements().some((function(t){return t.contains(e)}))){var i=this.$refs.content.querySelectorAll('button, [href], input, select, textarea, [tabindex]:not([tabindex="-1"])'),n=Object(a["a"])(i).find((function(t){return!t.hasAttribute("disabled")}));n&&n.focus()}}},genContent:function(){var t=this;return this.showLazyContent((function(){return[t.$createElement(s["a"],{props:{root:!0,light:t.light,dark:t.dark}},[t.$createElement("div",{class:t.contentClasses,attrs:Object(n["a"])({role:"document",tabindex:t.isActive?0:void 0},t.getScopeIdAttrs()),on:{keydown:t.onKeydown},style:{zIndex:t.activeZIndex},ref:"content"},[t.genTransition()])])]}))},genTransition:function(){var t=this.genInnerContent();return this.transition?this.$createElement("transition",{props:{name:this.transition,origin:this.origin,appear:!0}},[t]):t},genInnerContent:function(){var t={class:this.classes,ref:"dialog",directives:[{name:"click-outside",value:{handler:this.onClickOutside,closeConditional:this.closeConditional,include:this.getOpenDependentElements}},{name:"show",value:this.isActive}],style:{transformOrigin:this.origin}};return this.fullscreen||(t.style=Object(n["a"])(Object(n["a"])({},t.style),{},{maxWidth:"none"===this.maxWidth?void 0:Object(b["f"])(this.maxWidth),width:"auto"===this.width?void 0:Object(b["f"])(this.width)})),this.$createElement("div",t,this.getContentSlot())}},render:function(t){return t("div",{staticClass:"v-dialog__container",class:{"v-dialog__container--attached":""===this.attach||!0===this.attach||"attach"===this.attach},attrs:{role:"dialog"}},[this.genActivator(),this.genContent()])}})},"16b7":function(t,e,i){"use strict";i("a9e3");var n=i("2b0e");e["a"]=n["a"].extend().extend({name:"delayable",props:{openDelay:{type:[Number,String],default:0},closeDelay:{type:[Number,String],default:0}},data:function(){return{openTimeout:void 0,closeTimeout:void 0}},methods:{clearDelay:function(){clearTimeout(this.openTimeout),clearTimeout(this.closeTimeout)},runDelay:function(t,e){var i=this;this.clearDelay();var n=parseInt(this["".concat(t,"Delay")],10);this["".concat(t,"Timeout")]=setTimeout(e||function(){i.isActive={open:!0,close:!1}[t]},n)}}})},"1e6c":function(t,e,i){"use strict";var n=i("9d65"),a=i("4e82"),o=i("c3f0"),s=i("80d2"),r=i("58df"),c=Object(r["a"])(n["a"],Object(a["a"])("windowGroup","v-window-item","v-window"));e["a"]=c.extend().extend().extend({name:"v-window-item",directives:{Touch:o["a"]},props:{disabled:Boolean,reverseTransition:{type:[Boolean,String],default:void 0},transition:{type:[Boolean,String],default:void 0},value:{required:!1}},data:function(){return{isActive:!1,inTransition:!1}},computed:{classes:function(){return this.groupClasses},computedTransition:function(){return this.windowGroup.internalReverse?"undefined"!==typeof this.reverseTransition?this.reverseTransition||"":this.windowGroup.computedTransition:"undefined"!==typeof this.transition?this.transition||"":this.windowGroup.computedTransition}},methods:{genDefaultSlot:function(){return this.$slots.default},genWindowItem:function(){return this.$createElement("div",{staticClass:"v-window-item",class:this.classes,directives:[{name:"show",value:this.isActive}],on:this.$listeners},this.genDefaultSlot())},onAfterTransition:function(){this.inTransition&&(this.inTransition=!1,this.windowGroup.transitionCount>0&&(this.windowGroup.transitionCount--,0===this.windowGroup.transitionCount&&(this.windowGroup.transitionHeight=void 0)))},onBeforeTransition:function(){this.inTransition||(this.inTransition=!0,0===this.windowGroup.transitionCount&&(this.windowGroup.transitionHeight=Object(s["f"])(this.windowGroup.$el.clientHeight)),this.windowGroup.transitionCount++)},onTransitionCancelled:function(){this.onAfterTransition()},onEnter:function(t){var e=this;this.inTransition&&this.$nextTick((function(){e.computedTransition&&e.inTransition&&(e.windowGroup.transitionHeight=Object(s["f"])(t.clientHeight))}))}},render:function(t){var e=this;return t("transition",{props:{name:this.computedTransition},on:{beforeEnter:this.onBeforeTransition,afterEnter:this.onAfterTransition,enterCancelled:this.onTransitionCancelled,beforeLeave:this.onBeforeTransition,afterLeave:this.onAfterTransition,leaveCancelled:this.onTransitionCancelled,enter:this.onEnter}},this.showLazyContent((function(){return[e.genWindowItem()]})))}})},"21be":function(t,e,i){"use strict";var n=i("2909"),a=(i("99af"),i("caad"),i("2532"),i("2b0e")),o=i("80d2");e["a"]=a["a"].extend().extend({name:"stackable",data:function(){return{stackElement:null,stackExclude:null,stackMinZIndex:0,isActive:!1}},computed:{activeZIndex:function(){if("undefined"===typeof window)return 0;var t=this.stackElement||this.$refs.content,e=this.isActive?this.getMaxZIndex(this.stackExclude||[t])+2:Object(o["q"])(t);return null==e?e:parseInt(e)}},methods:{getMaxZIndex:function(){for(var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[],e=this.$el,i=[this.stackMinZIndex,Object(o["q"])(e)],a=[].concat(Object(n["a"])(document.getElementsByClassName("v-menu__content--active")),Object(n["a"])(document.getElementsByClassName("v-dialog__content--active"))),s=0;s<a.length;s++)t.includes(a[s])||i.push(Object(o["q"])(a[s]));return Math.max.apply(Math,i)}}})},"2c64":function(t,e,i){},"2fa4":function(t,e,i){"use strict";i("20f6");var n=i("80d2");e["a"]=Object(n["h"])("spacer","div","v-spacer")},"368e":function(t,e,i){},"3d86":function(t,e,i){},"43a6":function(t,e,i){"use strict";var n=i("5530"),a=(i("a9e3"),i("ec29"),i("3d86"),i("c37a")),o=i("604c"),s=i("8547"),r=i("58df"),c=Object(r["a"])(s["a"],o["a"],a["a"]);e["a"]=c.extend({name:"v-radio-group",provide:function(){return{radioGroup:this}},props:{column:{type:Boolean,default:!0},height:{type:[Number,String],default:"auto"},name:String,row:Boolean,value:null},computed:{classes:function(){return Object(n["a"])(Object(n["a"])({},a["a"].options.computed.classes.call(this)),{},{"v-input--selection-controls v-input--radio-group":!0,"v-input--radio-group--column":this.column&&!this.row,"v-input--radio-group--row":this.row})}},methods:{genDefaultSlot:function(){return this.$createElement("div",{staticClass:"v-input--radio-group__input",attrs:{id:this.id,role:"radiogroup","aria-labelledby":this.computedId}},a["a"].options.methods.genDefaultSlot.call(this))},genInputSlot:function(){var t=a["a"].options.methods.genInputSlot.call(this);return delete t.data.on.click,t},genLabel:function(){var t=a["a"].options.methods.genLabel.call(this);return t?(t.data.attrs.id=this.computedId,delete t.data.attrs.for,t.tag="legend",t):null},onClick:o["a"].options.methods.onClick}})},"464b":function(t,e,i){},"480e":function(t,e,i){"use strict";i("7db0");var n=i("7560");e["a"]=n["a"].extend({name:"v-theme-provider",props:{root:Boolean},computed:{isDark:function(){return this.root?this.rootIsDark:n["a"].options.computed.isDark.call(this)}},render:function(){return this.$slots.default&&this.$slots.default.find((function(t){return!t.isComment&&" "!==t.text}))}})},"4ad4":function(t,e,i){"use strict";var n=i("53ca"),a=(i("caad"),i("b64b"),i("b0c0"),i("16b7")),o=i("f2e7"),s=i("58df"),r=i("80d2"),c=i("d9bd"),l=Object(s["a"])(a["a"],o["a"]);e["a"]=l.extend({name:"activatable",props:{activator:{default:null,validator:function(t){return["string","object"].includes(Object(n["a"])(t))}},disabled:Boolean,internalActivator:Boolean,openOnHover:Boolean,openOnFocus:Boolean},data:function(){return{activatorElement:null,activatorNode:[],events:["click","mouseenter","mouseleave","focus"],listeners:{}}},watch:{activator:"resetActivator",openOnFocus:"resetActivator",openOnHover:"resetActivator"},mounted:function(){var t=Object(r["p"])(this,"activator",!0);t&&["v-slot","normal"].includes(t)&&Object(c["b"])('The activator slot must be bound, try \'<template v-slot:activator="{ on }"><v-btn v-on="on">\'',this),this.addActivatorEvents()},beforeDestroy:function(){this.removeActivatorEvents()},methods:{addActivatorEvents:function(){if(this.activator&&!this.disabled&&this.getActivator()){this.listeners=this.genActivatorListeners();for(var t=Object.keys(this.listeners),e=0,i=t;e<i.length;e++){var n=i[e];this.getActivator().addEventListener(n,this.listeners[n])}}},genActivator:function(){var t=Object(r["o"])(this,"activator",Object.assign(this.getValueProxy(),{on:this.genActivatorListeners(),attrs:this.genActivatorAttributes()}))||[];return this.activatorNode=t,t},genActivatorAttributes:function(){return{role:"button","aria-haspopup":!0,"aria-expanded":String(this.isActive)}},genActivatorListeners:function(){var t=this;if(this.disabled)return{};var e={};return this.openOnHover?(e.mouseenter=function(e){t.getActivator(e),t.runDelay("open")},e.mouseleave=function(e){t.getActivator(e),t.runDelay("close")}):e.click=function(e){var i=t.getActivator(e);i&&i.focus(),e.stopPropagation(),t.isActive=!t.isActive},this.openOnFocus&&(e.focus=function(e){t.getActivator(e),e.stopPropagation(),t.isActive=!t.isActive}),e},getActivator:function(t){var e;if(this.activatorElement)return this.activatorElement;var i=null;if(this.activator){var n=this.internalActivator?this.$el:document;i="string"===typeof this.activator?n.querySelector(this.activator):this.activator.$el?this.activator.$el:this.activator}else if(1===this.activatorNode.length||this.activatorNode.length&&!t){var a=this.activatorNode[0].componentInstance;i=a&&a.$options.mixins&&a.$options.mixins.some((function(t){return t.options&&["activatable","menuable"].includes(t.options.name)}))?a.getActivator():this.activatorNode[0].elm}else t&&(i=t.currentTarget||t.target);return this.activatorElement=(null==(e=i)?void 0:e.nodeType)===Node.ELEMENT_NODE?i:null,this.activatorElement},getContentSlot:function(){return Object(r["o"])(this,"default",this.getValueProxy(),!0)},getValueProxy:function(){var t=this;return{get value(){return t.isActive},set value(e){t.isActive=e}}},removeActivatorEvents:function(){if(this.activator&&this.activatorElement){for(var t=Object.keys(this.listeners),e=0,i=t;e<i.length;e++){var n=i[e];this.activatorElement.removeEventListener(n,this.listeners[n])}this.listeners={}}},resetActivator:function(){this.removeActivatorEvents(),this.activatorElement=null,this.getActivator(),this.addActivatorEvents()}}})},"583c":function(t,e,i){},"67b6":function(t,e,i){"use strict";var n=i("15fd"),a=i("5530"),o=(i("b0c0"),i("2c64"),i("ba87")),s=i("9d26"),r=i("c37a"),c=i("7e2b"),l=i("a9ad"),d=i("4e82"),u=i("5311"),h=i("7560"),v=i("fe09"),f=i("80d2"),p=i("58df"),m=i("d9f7"),b=["title"],g=Object(p["a"])(c["a"],l["a"],u["a"],Object(d["a"])("radioGroup"),h["a"]);e["a"]=g.extend().extend({name:"v-radio",inheritAttrs:!1,props:{disabled:Boolean,id:String,label:String,name:String,offIcon:{type:String,default:"$radioOff"},onIcon:{type:String,default:"$radioOn"},readonly:Boolean,value:{default:null}},data:function(){return{isFocused:!1}},computed:{classes:function(){return Object(a["a"])(Object(a["a"])({"v-radio--is-disabled":this.isDisabled,"v-radio--is-focused":this.isFocused},this.themeClasses),this.groupClasses)},computedColor:function(){return v["a"].options.computed.computedColor.call(this)},computedIcon:function(){return this.isActive?this.onIcon:this.offIcon},computedId:function(){return r["a"].options.computed.computedId.call(this)},hasLabel:r["a"].options.computed.hasLabel,hasState:function(){return(this.radioGroup||{}).hasState},isDisabled:function(){return this.disabled||!!this.radioGroup&&this.radioGroup.isDisabled},isReadonly:function(){return this.readonly||!!this.radioGroup&&this.radioGroup.isReadonly},computedName:function(){return this.name||!this.radioGroup?this.name:this.radioGroup.name||"radio-".concat(this.radioGroup._uid)},rippleState:function(){return v["a"].options.computed.rippleState.call(this)},validationState:function(){return(this.radioGroup||{}).validationState||this.computedColor}},methods:{genInput:function(t){return v["a"].options.methods.genInput.call(this,"radio",t)},genLabel:function(){return this.hasLabel?this.$createElement(o["a"],{on:{click:v["b"]},attrs:{for:this.computedId},props:{color:this.validationState,focused:this.hasState}},Object(f["o"])(this,"label")||this.label):null},genRadio:function(){var t=this.attrs$,e=(t.title,Object(n["a"])(t,b));return this.$createElement("div",{staticClass:"v-input--selection-controls__input"},[this.$createElement(s["a"],this.setTextColor(this.validationState,{props:{dense:this.radioGroup&&this.radioGroup.dense}}),this.computedIcon),this.genInput(Object(a["a"])({name:this.computedName,value:this.value},e)),this.genRipple(this.setTextColor(this.rippleState))])},onFocus:function(t){this.isFocused=!0,this.$emit("focus",t)},onBlur:function(t){this.isFocused=!1,this.$emit("blur",t)},onChange:function(){this.isDisabled||this.isReadonly||this.isActive||this.toggle()},onKeydown:function(){}},render:function(t){var e={staticClass:"v-radio",class:this.classes,on:Object(m["b"])({click:this.onChange},this.listeners$),attrs:{title:this.attrs$.title}};return t("div",e,[this.genRadio(),this.genLabel()])}})},"697a":function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"floating-action-buttons"},[i("h1",[t._v("Floating Action Buttons")]),i("FloatingButton"),i("DisplayAnimation"),i("LateralScreens"),i("SmallVariant"),i("SpeedDial")],1)},a=[],o=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("h2",[t._v("Floating Button")]),i("v-btn",{staticClass:"mx-2",attrs:{id:"fb-heart",fab:"",dark:"",small:"",color:"pink"},on:{click:t.click_fb_heart}},[i("v-icon",{attrs:{dark:""}},[t._v(" mdi-heart ")])],1),i("v-btn",{staticClass:"mx-2",attrs:{id:"fb-plus",fab:"",dark:"",color:"indigo"},on:{click:t.click_fb_plus}},[i("v-icon",{attrs:{dark:""}},[t._v(" mdi-plus ")])],1),i("v-btn",{staticClass:"mx-2",attrs:{id:"fb-pencil",fab:"",dark:"",large:"",color:"cyan"},on:{click:t.click_fb_pencil}},[i("v-icon",{attrs:{dark:""}},[t._v(" mdi-pencil ")])],1),i("v-text-field",{attrs:{id:"fb-state",textarea:"",readonly:""},model:{value:t.state,callback:function(e){t.state=e},expression:"state"}})],1)},s=[],r={data:function(){return{state:""}},methods:{click_fb_heart:function(){this.state="Floating button clicked: heart"},click_fb_plus:function(){this.state="Floating button clicked: plus"},click_fb_pencil:function(){this.state="Floating button clicked: pencil"}}},c=r,l=i("2877"),d=i("6544"),u=i.n(d),h=i("8336"),v=i("a523"),f=i("132d"),p=i("8654"),m=Object(l["a"])(c,o,s,!1,null,null,null),b=m.exports;u()(m,{VBtn:h["a"],VContainer:v["a"],VIcon:f["a"],VTextField:p["a"]});var g=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("h2",[t._v("Display Animation")]),i("v-container",{attrs:{fluid:""}},[i("v-row",[i("v-col",{attrs:{cols:"12",sm:"12",md:"6","offset-md":"3"}},[i("v-card",[i("v-toolbar",{attrs:{extended:""},scopedSlots:t._u([{key:"extension",fn:function(){return[i("v-fab-transition",[i("v-btn",{directives:[{name:"show",rawName:"v-show",value:!t.hidden,expression:"!hidden"}],attrs:{color:"pink",fab:"",dark:"",small:"",absolute:"",bottom:"",left:""},on:{click:t.click_top}},[i("v-icon",[t._v("mdi-plus")])],1)],1)]},proxy:!0}])},[i("v-app-bar-nav-icon")],1),i("v-card-text",{staticClass:"grey lighten-5 text-center",staticStyle:{height:"300px"}},[i("v-btn",{attrs:{color:"primary"},on:{click:function(e){t.hidden=!t.hidden}}},[t._v(" "+t._s(t.hidden?"Show":"Hide")+" ")])],1),i("v-card-text",{staticStyle:{height:"100px",position:"relative"}},[i("v-fab-transition",[i("v-btn",{directives:[{name:"show",rawName:"v-show",value:!t.hidden,expression:"!hidden"}],attrs:{color:"pink",dark:"",absolute:"",top:"",right:"",fab:""},on:{click:t.click_bottom}},[i("v-icon",[t._v("mdi-plus")])],1)],1)],1)],1)],1)],1)],1),i("v-text-field",{attrs:{id:"da-state",textarea:"",readonly:""},model:{value:t.state,callback:function(e){t.state=e},expression:"state"}})],1)},x=[],k={data:function(){return{hidden:!1,state:""}},methods:{click_top:function(){this.state="Last clicked: top plus"},click_bottom:function(){this.state="Last clicked: bottom plus"}}},y=k,_=i("5bc1"),w=i("b0af"),C=i("99d9"),A=i("62ad"),O=i("0789"),T=i("0fd9"),S=i("71d9"),V=Object(l["a"])(y,g,x,!1,null,null,null),$=V.exports;u()(V,{VAppBarNavIcon:_["a"],VBtn:h["a"],VCard:w["a"],VCardText:C["c"],VCol:A["a"],VContainer:v["a"],VFabTransition:O["c"],VIcon:f["a"],VRow:T["a"],VTextField:p["a"],VToolbar:S["a"]});var j=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("h2",[t._v("Lateral Screens")]),i("v-card",{attrs:{id:"lateral"}},[i("v-toolbar",{attrs:{dark:"",tabs:"",flat:"",color:"indigo"},scopedSlots:t._u([{key:"extension",fn:function(){return[i("v-tabs",{attrs:{"align-with-title":""},model:{value:t.tabs,callback:function(e){t.tabs=e},expression:"tabs"}},[i("v-tab",{attrs:{href:"#one"}},[t._v(" Item One ")]),i("v-tab",{attrs:{href:"#two"}},[t._v(" Item Two ")]),i("v-tab",{attrs:{href:"#three"}},[t._v(" Item Three ")]),i("v-tabs-slider",{attrs:{color:"pink"}})],1)]},proxy:!0}])},[i("v-app-bar-nav-icon"),i("v-toolbar-title",[t._v("Page title")]),i("v-spacer"),i("v-btn",{attrs:{icon:""}},[i("v-icon",[t._v("mdi-magnify")])],1),i("v-btn",{attrs:{icon:""}},[i("v-icon",[t._v("mdi-dots-vertical")])],1)],1),i("v-card-text",[i("v-tabs-items",{model:{value:t.tabs,callback:function(e){t.tabs=e},expression:"tabs"}},t._l(["one","two","three"],(function(t){return i("v-tab-item",{key:t,attrs:{value:t}},[i("v-card",{attrs:{height:"200px",flat:""}})],1)})),1)],1),i("v-fab-transition",[i("v-btn",{key:t.activeFab.icon,staticClass:"v-btn--example",attrs:{color:t.activeFab.color,fab:"",large:"",dark:"",bottom:"",left:""},on:{click:t.click}},[i("v-icon",[t._v(t._s(t.activeFab.icon))])],1)],1)],1),i("v-text-field",{attrs:{id:"ls-state",textarea:"",readonly:""},model:{value:t.state,callback:function(e){t.state=e},expression:"state"}})],1)},E=[],I={data:function(){return{fab:!1,hidden:!1,tabs:null,state:""}},computed:{activeFab:function(){switch(this.tabs){case"one":return{color:"success",icon:"mdi-share-variant"};case"two":return{color:"red",icon:"mdi-pencil"};case"three":return{color:"green",icon:"mdi-chevron-up"};default:return{}}}},methods:{click:function(){switch(this.tabs){case"one":this.state="Last clicked: Share";break;case"two":this.state="Last clicked: Pencil";break;case"three":this.state="Last clicked: Chevron up";break;default:break}}}},B=I,D=(i("d15f"),i("2fa4")),N=i("71a3"),L=i("1e6c"),F=L["a"].extend({name:"v-tab-item",props:{id:String},methods:{genWindowItem:function(){var t=L["a"].options.methods.genWindowItem.call(this);return t.data.domProps=t.data.domProps||{},t.data.domProps.id=this.id||this.value,t}}}),G=i("fe57"),R=i("aac8"),M=i("9a96"),P=i("2a7f"),H=Object(l["a"])(B,j,E,!1,null,null,null),Z=H.exports;u()(H,{VAppBarNavIcon:_["a"],VBtn:h["a"],VCard:w["a"],VCardText:C["c"],VContainer:v["a"],VFabTransition:O["c"],VIcon:f["a"],VSpacer:D["a"],VTab:N["a"],VTabItem:F,VTabs:G["a"],VTabsItems:R["a"],VTabsSlider:M["a"],VTextField:p["a"],VToolbar:S["a"],VToolbarTitle:P["b"]});var W=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("h2",[t._v("Small Variant")]),i("v-row",[i("v-col",{attrs:{cols:"12",sm:"6","offset-sm":"3"}},[i("v-card",[i("v-toolbar",{attrs:{color:"light-blue",light:"",extended:""},scopedSlots:t._u([{key:"extension",fn:function(){return[i("v-btn",{attrs:{fab:"",color:"cyan accent-2",bottom:"",left:"",absolute:""},on:{click:function(e){t.dialog=!t.dialog}}},[i("v-icon",[t._v("mdi-plus")])],1)]},proxy:!0}])},[i("v-app-bar-nav-icon"),i("v-toolbar-title",{staticClass:"white--text"},[t._v(" My files ")]),i("v-spacer"),i("v-btn",{attrs:{icon:""}},[i("v-icon",[t._v("mdi-magnify")])],1),i("v-btn",{attrs:{icon:""}},[i("v-icon",[t._v("mdi-view-module")])],1)],1),i("v-list",{attrs:{"two-line":"",subheader:""}},[i("v-subheader",{attrs:{inset:""}},[t._v(" Folders ")]),t._l(t.items,(function(e){return i("v-list-item",{key:e.title,attrs:{link:""}},[i("v-list-item-avatar",[i("v-icon",{class:[e.iconClass]},[t._v(" "+t._s(e.icon)+" ")])],1),i("v-list-item-content",[i("v-list-item-title",[t._v(t._s(e.title))]),i("v-list-item-subtitle",[t._v(t._s(e.subtitle))])],1),i("v-list-item-action",[i("v-btn",{attrs:{icon:""}},[i("v-icon",{attrs:{color:"grey lighten-1"}},[t._v(" mdi-information ")])],1)],1)],1)})),i("v-divider",{attrs:{inset:""}}),i("v-subheader",{attrs:{inset:""}},[t._v(" Files ")]),t._l(t.items2,(function(e){return i("v-list-item",{key:e.title,attrs:{link:""}},[i("v-list-item-avatar",[i("v-icon",{class:[e.iconClass]},[t._v(" "+t._s(e.icon)+" ")])],1),i("v-list-item-content",[i("v-list-item-title",[t._v(t._s(e.title))]),i("v-list-item-subtitle",[t._v(t._s(e.subtitle))])],1),i("v-list-item-action",[i("v-btn",{attrs:{icon:"",ripple:""}},[i("v-icon",{attrs:{color:"grey lighten-1"}},[t._v(" mdi-information ")])],1)],1)],1)}))],2),i("v-dialog",{attrs:{"max-width":"500px"},model:{value:t.dialog,callback:function(e){t.dialog=e},expression:"dialog"}},[i("v-card",[i("v-card-text",[i("v-text-field",{attrs:{label:"File name"}}),i("small",{staticClass:"grey--text"},[t._v("* This doesn't actually save.")])],1),i("v-card-actions",[i("v-spacer"),i("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(e){t.dialog=!1}}},[t._v(" Submit ")])],1)],1)],1)],1)],1)],1)],1)},q=[],J={data:function(){return{dialog:!1,items:[{icon:"mdi-folder",iconClass:"grey lighten-1 white--text",title:"Photos",subtitle:"Jan 9, 2014"},{icon:"mdi-folder",iconClass:"grey lighten-1 white--text",title:"Recipes",subtitle:"Jan 17, 2014"},{icon:"mdi-folder",iconClass:"grey lighten-1 white--text",title:"Work",subtitle:"Jan 28, 2014"}],items2:[{icon:"mdi-clipboard-text",iconClass:"blue white--text",title:"Vacation itinerary",subtitle:"Jan 20, 2014"},{icon:"mdi-gesture-tap-button",iconClass:"amber white--text",title:"Kitchen remodel",subtitle:"Jan 10, 2014"}]}}},z=J,K=i("169a"),U=i("ce7e"),Q=i("8860"),X=i("da13"),Y=i("1800"),tt=i("8270"),et=i("5d23"),it=i("e0c7"),nt=Object(l["a"])(z,W,q,!1,null,null,null),at=nt.exports;u()(nt,{VAppBarNavIcon:_["a"],VBtn:h["a"],VCard:w["a"],VCardActions:C["a"],VCardText:C["c"],VCol:A["a"],VContainer:v["a"],VDialog:K["a"],VDivider:U["a"],VIcon:f["a"],VList:Q["a"],VListItem:X["a"],VListItemAction:Y["a"],VListItemAvatar:tt["a"],VListItemContent:et["a"],VListItemSubtitle:et["b"],VListItemTitle:et["c"],VRow:T["a"],VSpacer:D["a"],VSubheader:it["a"],VTextField:p["a"],VToolbar:S["a"],VToolbarTitle:P["b"]});var ot=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("h2",[t._v("Speed Dial")]),i("v-card",{attrs:{id:"create"}},[i("v-container",{attrs:{fluid:""}},[i("v-row",{staticClass:"child-flex"},[i("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[i("v-subheader",[t._v("Options")]),i("v-checkbox",{attrs:{label:"Open on hover","hide-details":""},model:{value:t.hover,callback:function(e){t.hover=e},expression:"hover"}})],1),i("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[i("v-subheader",[t._v("FAB location")]),i("v-checkbox",{attrs:{label:"Top","hide-details":""},model:{value:t.top,callback:function(e){t.top=e},expression:"top"}}),i("v-checkbox",{attrs:{label:"Right","hide-details":""},model:{value:t.right,callback:function(e){t.right=e},expression:"right"}}),i("v-checkbox",{attrs:{label:"Bottom","hide-details":""},model:{value:t.bottom,callback:function(e){t.bottom=e},expression:"bottom"}}),i("v-checkbox",{attrs:{label:"Left","hide-details":""},model:{value:t.left,callback:function(e){t.left=e},expression:"left"}})],1),i("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[i("v-subheader",[t._v("Speed dial direction")]),i("v-radio-group",{attrs:{"hide-details":""},model:{value:t.direction,callback:function(e){t.direction=e},expression:"direction"}},[i("v-radio",{attrs:{value:"top",label:"Top"}}),i("v-radio",{attrs:{value:"right",label:"Right"}}),i("v-radio",{attrs:{value:"bottom",label:"Bottom"}}),i("v-radio",{attrs:{value:"left",label:"Left"}})],1)],1),i("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[i("v-subheader",[t._v("Transition")]),i("v-radio-group",{attrs:{"hide-details":""},model:{value:t.transition,callback:function(e){t.transition=e},expression:"transition"}},[i("v-radio",{attrs:{value:"slide-y-transition",label:"Slide y"}}),i("v-radio",{attrs:{value:"slide-y-reverse-transition",label:"Slide y reverse"}}),i("v-radio",{attrs:{value:"slide-x-transition",label:"Slide x"}}),i("v-radio",{attrs:{value:"slide-x-reverse-transition",label:"Slide x reverse"}}),i("v-radio",{attrs:{value:"scale-transition",label:"Scale"}})],1)],1)],1)],1),i("v-speed-dial",{attrs:{top:t.top,bottom:t.bottom,right:t.right,left:t.left,direction:t.direction,"open-on-hover":t.hover,transition:t.transition},scopedSlots:t._u([{key:"activator",fn:function(){return[i("v-btn",{attrs:{color:"blue darken-2",dark:"",fab:""},model:{value:t.fab,callback:function(e){t.fab=e},expression:"fab"}},[t.fab?i("v-icon",[t._v(" mdi-close ")]):i("v-icon",[t._v(" mdi-account-circle ")])],1)]},proxy:!0}]),model:{value:t.fab,callback:function(e){t.fab=e},expression:"fab"}},[i("v-btn",{attrs:{fab:"",dark:"",small:"",color:"green"}},[i("v-icon",[t._v("mdi-pencil")])],1),i("v-btn",{attrs:{fab:"",dark:"",small:"",color:"indigo"}},[i("v-icon",[t._v("mdi-plus")])],1),i("v-btn",{attrs:{fab:"",dark:"",small:"",color:"red"}},[i("v-icon",[t._v("mdi-delete")])],1)],1)],1)],1)},st=[],rt={data:function(){return{direction:"top",fab:!1,fling:!1,hover:!1,tabs:null,top:!1,right:!0,bottom:!0,left:!1,transition:"slide-y-reverse-transition"}},watch:{top:function(t){this.bottom=!t},right:function(t){this.left=!t},bottom:function(t){this.top=!t},left:function(t){this.right=!t}}},ct=rt,lt=(i("a651"),i("ac7c")),dt=i("67b6"),ut=i("43a6"),ht=i("ade3"),vt=(i("caad"),i("c7cd"),i("d81d"),i("b0c0"),i("8cd0"),i("f2e7")),ft=i("fe6c"),pt=i("f40d"),mt=i("a293"),bt=i("58df"),gt=Object(bt["a"])(ft["a"],vt["a"],pt["a"]).extend({name:"v-speed-dial",directives:{ClickOutside:mt["a"]},props:{direction:{type:String,default:"top",validator:function(t){return["top","right","bottom","left"].includes(t)}},openOnHover:Boolean,transition:{type:String,default:"scale-transition"}},computed:{classes:function(){var t;return t={"v-speed-dial":!0,"v-speed-dial--top":this.top,"v-speed-dial--right":this.right,"v-speed-dial--bottom":this.bottom,"v-speed-dial--left":this.left,"v-speed-dial--absolute":this.absolute,"v-speed-dial--fixed":this.fixed},Object(ht["a"])(t,"v-speed-dial--direction-".concat(this.direction),!0),Object(ht["a"])(t,"v-speed-dial--is-active",this.isActive),t}},render:function(t){var e=this,i=[],n={class:this.classes,directives:[{name:"click-outside",value:function(){return e.isActive=!1}}],on:{click:function(){return e.isActive=!e.isActive}}};if(this.openOnHover&&(n.on.mouseenter=function(){return e.isActive=!0},n.on.mouseleave=function(){return e.isActive=!1}),this.isActive){var a=0;i=(this.$slots.default||[]).map((function(e,i){return!e.tag||"undefined"===typeof e.componentOptions||"v-btn"!==e.componentOptions.Ctor.options.name&&"v-tooltip"!==e.componentOptions.Ctor.options.name?(e.key=i,e):(a++,t("div",{style:{transitionDelay:.05*a+"s"},key:i},[e]))}))}var o=t("transition-group",{class:"v-speed-dial__list",props:{name:this.transition,mode:this.mode,origin:this.origin,tag:"div"}},i);return t("div",n,[this.$slots.activator,o])}}),xt=Object(l["a"])(ct,ot,st,!1,null,null,null),kt=xt.exports;u()(xt,{VBtn:h["a"],VCard:w["a"],VCheckbox:lt["a"],VCol:A["a"],VContainer:v["a"],VIcon:f["a"],VRadio:dt["a"],VRadioGroup:ut["a"],VRow:T["a"],VSpeedDial:gt,VSubheader:it["a"]});var yt={name:"FloatingActionButtons",components:{FloatingButton:b,DisplayAnimation:$,LateralScreens:Z,SmallVariant:at,SpeedDial:kt}},_t=yt,wt=(i("ffd0"),Object(l["a"])(_t,n,a,!1,null,null,null));e["default"]=wt.exports},"71ac":function(t,e,i){},"75eb":function(t,e,i){"use strict";var n=i("ade3"),a=i("53ca"),o=(i("159b"),i("9d65")),s=i("80d2"),r=i("58df"),c=i("d9bd");function l(t){var e=Object(a["a"])(t);return"boolean"===e||"string"===e||t.nodeType===Node.ELEMENT_NODE}e["a"]=Object(r["a"])(o["a"]).extend({name:"detachable",props:{attach:{default:!1,validator:l},contentClass:{type:String,default:""}},data:function(){return{activatorNode:null,hasDetached:!1}},watch:{attach:function(){this.hasDetached=!1,this.initDetach()},hasContent:function(){this.$nextTick(this.initDetach)}},beforeMount:function(){var t=this;this.$nextTick((function(){if(t.activatorNode){var e=Array.isArray(t.activatorNode)?t.activatorNode:[t.activatorNode];e.forEach((function(e){if(e.elm&&t.$el.parentNode){var i=t.$el===t.$el.parentNode.firstChild?t.$el:t.$el.nextSibling;t.$el.parentNode.insertBefore(e.elm,i)}}))}}))},mounted:function(){this.hasContent&&this.initDetach()},deactivated:function(){this.isActive=!1},beforeDestroy:function(){try{if(this.$refs.content&&this.$refs.content.parentNode&&this.$refs.content.parentNode.removeChild(this.$refs.content),this.activatorNode){var t=Array.isArray(this.activatorNode)?this.activatorNode:[this.activatorNode];t.forEach((function(t){t.elm&&t.elm.parentNode&&t.elm.parentNode.removeChild(t.elm)}))}}catch(e){console.log(e)}},methods:{getScopeIdAttrs:function(){var t=Object(s["m"])(this.$vnode,"context.$options._scopeId");return t&&Object(n["a"])({},t,"")},initDetach:function(){var t;this._isDestroyed||!this.$refs.content||this.hasDetached||""===this.attach||!0===this.attach||"attach"===this.attach||(t=!1===this.attach?document.querySelector("[data-app]"):"string"===typeof this.attach?document.querySelector(this.attach):this.attach,t?(t.appendChild(this.$refs.content),this.hasDetached=!0):Object(c["c"])("Unable to locate target ".concat(this.attach||"[data-app]"),this))}}})},"8cd0":function(t,e,i){},"8ce9":function(t,e,i){},"99d9":function(t,e,i){"use strict";i.d(e,"a",(function(){return o})),i.d(e,"b",(function(){return s})),i.d(e,"c",(function(){return r})),i.d(e,"d",(function(){return c}));var n=i("b0af"),a=i("80d2"),o=Object(a["h"])("v-card__actions"),s=Object(a["h"])("v-card__subtitle"),r=Object(a["h"])("v-card__text"),c=Object(a["h"])("v-card__title");n["a"]},a651:function(t,e,i){"use strict";i("464b")},ce7e:function(t,e,i){"use strict";var n=i("5530"),a=(i("8ce9"),i("7560"));e["a"]=a["a"].extend({name:"v-divider",props:{inset:Boolean,vertical:Boolean},render:function(t){var e;return this.$attrs.role&&"separator"!==this.$attrs.role||(e=this.vertical?"vertical":"horizontal"),t("hr",{class:Object(n["a"])({"v-divider":!0,"v-divider--inset":this.inset,"v-divider--vertical":this.vertical},this.themeClasses),attrs:Object(n["a"])({role:"separator","aria-orientation":e},this.$attrs),on:this.$listeners})}})},d15f:function(t,e,i){"use strict";i("583c")},e0c7:function(t,e,i){"use strict";var n=i("5530"),a=(i("0bc6"),i("7560")),o=i("58df");e["a"]=Object(o["a"])(a["a"]).extend({name:"v-subheader",props:{inset:Boolean},render:function(t){return t("div",{staticClass:"v-subheader",class:Object(n["a"])({"v-subheader--inset":this.inset},this.themeClasses),attrs:this.$attrs,on:this.$listeners},this.$slots.default)}})},e4d3:function(t,e,i){"use strict";var n=i("2b0e");e["a"]=n["a"].extend({name:"returnable",props:{returnValue:null},data:function(){return{isActive:!1,originalValue:null}},watch:{isActive:function(t){t?this.originalValue=this.returnValue:this.$emit("update:return-value",this.originalValue)}},methods:{save:function(t){var e=this;this.originalValue=t,setTimeout((function(){e.isActive=!1}))}}})},f40d:function(t,e,i){"use strict";var n=i("2b0e");e["a"]=n["a"].extend({name:"transitionable",props:{mode:String,origin:String,transition:String}})},ffd0:function(t,e,i){"use strict";i("71ac")}}]);
//# sourceMappingURL=chunk-5eec2b91.6482c6cc.js.map