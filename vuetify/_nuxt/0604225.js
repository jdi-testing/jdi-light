(window.webpackJsonp=window.webpackJsonp||[]).push([[22],{1077:function(t,e,n){"use strict";n.r(e);var r=n(1017),o=n(1104),c=(n(16),n(11),n(15),n(5),n(19),n(10),n(20),n(3)),l=(n(842),n(414)),v=n(127),h=n(192),d=n(194),f=n(160),m=n(83),_=n(12),x=n(2);function y(object,t){var e=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),e.push.apply(e,n)}return e}function w(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?y(Object(source),!0).forEach((function(e){Object(c.a)(t,e,source[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):y(Object(source)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(source,e))}))}return t}var O=Object(_.a)(l.a,f.a,m.a).extend({name:"v-banner",inheritAttrs:!1,props:{app:Boolean,icon:String,iconColor:String,singleLine:Boolean,sticky:Boolean,value:{type:Boolean,default:!0}},computed:{classes:function(){return w(w({},l.a.options.computed.classes.call(this)),{},{"v-banner--has-icon":this.hasIcon,"v-banner--is-mobile":this.isMobile,"v-banner--single-line":this.singleLine,"v-banner--sticky":this.isSticky})},hasIcon:function(){return Boolean(this.icon||this.$slots.icon)},isSticky:function(){return this.sticky||this.app},styles:function(){var t=w({},l.a.options.computed.styles.call(this));if(this.isSticky){var e=this.app?this.$vuetify.application.bar+this.$vuetify.application.top:0;t.top=Object(x.i)(e),t.position="sticky",t.zIndex=1}return t}},methods:{toggle:function(){this.isActive=!this.isActive},iconClick:function(t){this.$emit("click:icon",t)},genIcon:function(){var content;if(this.hasIcon)return content=this.icon?this.$createElement(h.a,{props:{color:this.iconColor,size:28}},[this.icon]):this.$slots.icon,this.$createElement(v.a,{staticClass:"v-banner__icon",props:{color:this.color,size:40},on:{click:this.iconClick}},[content])},genText:function(){return this.$createElement("div",{staticClass:"v-banner__text"},this.$slots.default)},genActions:function(){var t=this,e=Object(x.u)(this,"actions",{dismiss:function(){return t.isActive=!1}});if(e)return this.$createElement("div",{staticClass:"v-banner__actions"},e)},genContent:function(){return this.$createElement("div",{staticClass:"v-banner__content"},[this.genIcon(),this.genText()])},genWrapper:function(){return this.$createElement("div",{staticClass:"v-banner__wrapper"},[this.genContent(),this.genActions()])}},render:function(t){var data={staticClass:"v-banner",attrs:this.attrs$,class:this.classes,style:this.styles,directives:[{name:"show",value:this.isActive}]};return t(d.a,[t("div",this.outlined?data:this.setBackgroundColor(this.color,data),[this.genWrapper()])])}}),k=n(445),j=n(431),S=n(412),B=n(157),C=n(495),I=n(610),P=n(562),$=n(467),E=n(430),A={data:function(){return{sticky:!1}}},D=n(82),T=Object(D.a)(A,(function(){var t=this,e=t._self._c;return e(j.a,[e(P.a),t._v(" "),e($.a,{attrs:{flat:""}},[e(E.b,[t._v("My Document")]),t._v(" "),e(C.a),t._v(" "),e("div",[e(I.a,{attrs:{label:"Sticky Banner","hide-details":""},model:{value:t.sticky,callback:function(e){t.sticky=e},expression:"sticky"}})],1)],1),t._v(" "),e(O,{attrs:{"single-line":"",sticky:t.sticky},scopedSlots:t._u([{key:"actions",fn:function(){return[e(k.a,{attrs:{text:"",color:"deep-purple accent-4"}},[t._v("\n        Get Online\n      ")])]},proxy:!0}])},[t._v("\n    We can't save your edits while you are in offline mode.\n\n    ")]),t._v(" "),e(S.c,{staticClass:"grey lighten-4"},[e(B.a,{staticClass:"mx-auto",attrs:{"max-width":"800",height:"300"}})],1)],1)}),[],!1,null,null,null).exports,z=n(178),M=(n(75),{methods:{alert:function(t){function e(){return t.apply(this,arguments)}return e.toString=function(){return t.toString()},e}((function(){alert("Hello, World!")}))}}),L=M,H=Object(D.a)(L,(function(){var t=this,e=t._self._c;return e(O,{attrs:{"single-line":""},on:{"click:icon":t.alert},scopedSlots:t._u([{key:"actions",fn:function(){return[e(k.a,{attrs:{color:"primary",text:""}},[t._v("\n      Connection Settings\n    ")])]},proxy:!0}])},[e(z.a,{attrs:{slot:"icon",color:"warning",size:"36"},slot:"icon"},[t._v("\n    mdi-wifi-strength-alert-outline\n  ")]),t._v("\n  Unable to verify your Internet connection\n\n  ")],1)}),[],!1,null,null,null).exports,N=n(526),W={data:function(){return{v0:!0}}},R=Object(D.a)(W,(function(){var t=this,e=t._self._c;return e("div",[e(N.a,{attrs:{label:"Visible"},model:{value:t.v0,callback:function(e){t.v0=e},expression:"v0"}}),t._v(" "),e(O,{attrs:{"single-line":"",transition:"slide-y-transition"},scopedSlots:t._u([{key:"actions",fn:function(n){var r=n.dismiss;return[e(k.a,{attrs:{text:"",color:"primary"},on:{click:r}},[t._v("\n        Dismiss\n      ")]),t._v(" "),e(k.a,{attrs:{text:"",color:"primary"}},[t._v("\n        Retry\n      ")])]}}]),model:{value:t.v0,callback:function(e){t.v0=e},expression:"v0"}},[t._v("\n    No Internet connection\n    ")])],1)}),[],!1,null,null,null).exports,J=n(186),V={name:"Banners",components:{SingleBanner:T,EventsBanner:H,ActionsBanner:R,IconBanner:Object(D.a)({},(function(){var t=this,e=t._self._c;return e(O,{attrs:{"two-line":""},scopedSlots:t._u([{key:"actions",fn:function(){return[e(k.a,{attrs:{text:"",color:"deep-purple accent-4"}},[t._v("\n      Action\n    ")]),t._v(" "),e(k.a,{attrs:{text:"",color:"deep-purple accent-4"}},[t._v("\n      Action\n    ")])]},proxy:!0}])},[e(J.a,{attrs:{slot:"icon",color:"deep-purple accent-4",size:"40"},slot:"icon"},[e(z.a,{attrs:{icon:"mdi-lock",color:"white"}},[t._v("\n      mdi-lock\n    ")])],1),t._v("\n\n  Three line text string example with two actions. One to two lines is preferable. \n  Three lines should be considered the maximum string length on desktop in order to keep messages short and actionable.\n\n  ")],1)}),[],!1,null,null,null).exports,TwoLineBanner:Object(D.a)({},(function(){var t=this,e=t._self._c;return e(O,{scopedSlots:t._u([{key:"actions",fn:function(){return[e(k.a,{attrs:{text:"",color:"primary"}},[t._v("\n      Dismiss\n    ")]),t._v(" "),e(k.a,{attrs:{text:"",color:"primary"}},[t._v("\n      Retry\n    ")])]},proxy:!0}])},[t._v("\n  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent cursus nec sem id malesuada.\n  Curabitur lacinia sem et turpis euismod, eget elementum ex pretium.\n  ")])}),[],!1,null,null,null).exports}},G=Object(D.a)(V,(function(){var t=this,e=t._self._c;return e(o.a,[e(r.a,[e("h1",[t._v("Banner")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),e("code",[t._v("v-banner")]),t._v(" component is used as middle-interruptive message to user with 1-2 actions. \n            It comes in 2 variations single-line and multi-line (implicit). \n            These can have icons which you can use with your message and actions.\n        ")])]),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Single Banner\n        ")]),t._v(" "),e("SingleBanner",{attrs:{id:"SingleBanner"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Events Banner (icon click)\n        ")]),t._v(" "),e("EventsBanner",{attrs:{id:"EventsBanner"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Actions Banner\n        ")]),t._v(" "),e("ActionsBanner",{attrs:{id:"ActionsBanner"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Icon Banner\n        ")]),t._v(" "),e("IconBanner",{attrs:{id:"IconBanner"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Two line Banner\n        ")]),t._v(" "),e("TwoLineBanner",{attrs:{id:"TwoLineBanner"}})],1)],1)}),[],!1,null,null,null);e.default=G.exports},412:function(t,e,n){"use strict";n.d(e,"a",(function(){return c})),n.d(e,"b",(function(){return l})),n.d(e,"c",(function(){return v})),n.d(e,"d",(function(){return h}));var r=n(431),o=n(2),c=Object(o.k)("v-card__actions"),l=Object(o.k)("v-card__subtitle"),v=Object(o.k)("v-card__text"),h=Object(o.k)("v-card__title");r.a},414:function(t,e,n){"use strict";var r=n(157);e.a=r.a},430:function(t,e,n){"use strict";n.d(e,"a",(function(){return l})),n.d(e,"b",(function(){return c}));var r=n(467),o=n(2),c=Object(o.k)("v-toolbar__title"),l=Object(o.k)("v-toolbar__items");r.a},493:function(t,e,n){var content=n(494);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,n(27).default)("12a190a6",content,!0,{sourceMap:!1})},494:function(t,e,n){var r=n(26)(!1);r.push([t.i,".v-input--checkbox.v-input--indeterminate.v-input--is-disabled{opacity:.6}.v-input--checkbox.v-input--dense{margin-top:4px}",""]),t.exports=r},519:function(t,e,n){var content=n(520);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,n(27).default)("dd2325f0",content,!0,{sourceMap:!1})},520:function(t,e,n){var r=n(26)(!1);r.push([t.i,".theme--light.v-system-bar{background-color:#e0e0e0;color:rgba(0,0,0,.6)}.theme--light.v-system-bar .v-icon{color:rgba(0,0,0,.6)}.theme--light.v-system-bar--lights-out{background-color:hsla(0,0%,100%,.7)!important}.theme--dark.v-system-bar{background-color:#000;color:hsla(0,0%,100%,.7)}.theme--dark.v-system-bar .v-icon{color:hsla(0,0%,100%,.7)}.theme--dark.v-system-bar--lights-out{background-color:rgba(0,0,0,.2)!important}.v-system-bar{align-items:center;display:flex;font-size:.875rem;font-weight:400;padding:0 8px}.v-system-bar .v-icon{font-size:1rem;margin-right:4px}.v-system-bar--absolute,.v-system-bar--fixed{left:0;top:0;width:100%;z-index:3}.v-system-bar--fixed{position:fixed}.v-system-bar--absolute{position:absolute}.v-system-bar--window .v-icon{font-size:1.25rem;margin-right:8px}",""]),t.exports=r},526:function(t,e,n){"use strict";n(16),n(11),n(15),n(19),n(10),n(20);var r=n(105),o=n(3),c=(n(5),n(75),n(493),n(471),n(192)),l=n(448),v=n(472),h=["title"];function d(object,t){var e=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),e.push.apply(e,n)}return e}function f(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?d(Object(source),!0).forEach((function(e){Object(o.a)(t,e,source[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):d(Object(source)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(source,e))}))}return t}e.a=v.a.extend({name:"v-checkbox",props:{indeterminate:Boolean,indeterminateIcon:{type:String,default:"$checkboxIndeterminate"},offIcon:{type:String,default:"$checkboxOff"},onIcon:{type:String,default:"$checkboxOn"}},data:function(){return{inputIndeterminate:this.indeterminate}},computed:{classes:function(){return f(f({},l.a.options.computed.classes.call(this)),{},{"v-input--selection-controls":!0,"v-input--checkbox":!0,"v-input--indeterminate":this.inputIndeterminate})},computedIcon:function(){return this.inputIndeterminate?this.indeterminateIcon:this.isActive?this.onIcon:this.offIcon},validationState:function(){if(!this.isDisabled||this.inputIndeterminate)return this.hasError&&this.shouldValidate?"error":this.hasSuccess?"success":null!==this.hasColor?this.computedColor:void 0}},watch:{indeterminate:function(t){var e=this;this.$nextTick((function(){return e.inputIndeterminate=t}))},inputIndeterminate:function(t){this.$emit("update:indeterminate",t)},isActive:function(){this.indeterminate&&(this.inputIndeterminate=!1)}},methods:{genCheckbox:function(){var t=this.attrs$,e=(t.title,Object(r.a)(t,h));return this.$createElement("div",{staticClass:"v-input--selection-controls__input"},[this.$createElement(c.a,this.setTextColor(this.validationState,{props:{dense:this.dense,dark:this.dark,light:this.light}}),this.computedIcon),this.genInput("checkbox",f(f({},e),{},{"aria-checked":this.inputIndeterminate?"mixed":this.isActive.toString()})),this.genRipple(this.setTextColor(this.rippleState))])},genDefaultSlot:function(){return[this.genCheckbox(),this.genLabel()]}}})},562:function(t,e,n){"use strict";n(16),n(11),n(15),n(5),n(19),n(10),n(20);var r=n(3),o=(n(42),n(275),n(519),n(213)),c=n(36),l=n(35),v=n(12),h=n(2);function d(object,t){var e=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),e.push.apply(e,n)}return e}e.a=Object(v.a)(Object(o.a)("bar",["height","window"]),c.a,l.a).extend({name:"v-system-bar",props:{height:[Number,String],lightsOut:Boolean,window:Boolean},computed:{classes:function(){return function(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?d(Object(source),!0).forEach((function(e){Object(r.a)(t,e,source[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):d(Object(source)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(source,e))}))}return t}({"v-system-bar--lights-out":this.lightsOut,"v-system-bar--absolute":this.absolute,"v-system-bar--fixed":!this.absolute&&(this.app||this.fixed),"v-system-bar--window":this.window},this.themeClasses)},computedHeight:function(){return this.height?isNaN(parseInt(this.height))?this.height:parseInt(this.height):this.window?32:24},styles:function(){return{height:Object(h.i)(this.computedHeight)}}},methods:{updateApplication:function(){return this.$el?this.$el.clientHeight:this.computedHeight}},render:function(t){var data={staticClass:"v-system-bar",class:this.classes,style:this.styles,on:this.$listeners};return t("div",this.setBackgroundColor(this.color,data),Object(h.u)(this))}})},842:function(t,e,n){var content=n(843);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,n(27).default)("238c91c4",content,!0,{sourceMap:!1})},843:function(t,e,n){var r=n(26)(!1);r.push([t.i,".theme--light.v-banner.v-sheet{background-color:transparent}.theme--light.v-banner.v-sheet:not(.v-sheet--outlined):not(.v-sheet--shaped) .v-banner__wrapper{border-bottom:thin solid rgba(0,0,0,.12)}.theme--dark.v-banner.v-sheet{background-color:transparent}.theme--dark.v-banner.v-sheet:not(.v-sheet--outlined):not(.v-sheet--shaped) .v-banner__wrapper{border-bottom:thin solid hsla(0,0%,100%,.12)}.v-sheet.v-banner{border-radius:0}.v-sheet.v-banner:not(.v-sheet--outlined){box-shadow:0 0 0 0 rgba(0,0,0,.2),0 0 0 0 rgba(0,0,0,.14),0 0 0 0 rgba(0,0,0,.12)}.v-sheet.v-banner.v-sheet--shaped{border-radius:24px 0}.v-banner{position:relative;transition:box-shadow .28s cubic-bezier(.4,0,.2,1)}.v-banner__actions{align-items:center;align-self:flex-end;display:flex;flex:1 0 auto;justify-content:flex-end;margin-bottom:-8px}.v-application--is-ltr .v-banner__actions{margin-left:90px}.v-application--is-rtl .v-banner__actions{margin-right:90px}.v-application--is-ltr .v-banner__actions>*{margin-left:8px}.v-application--is-rtl .v-banner__actions>*{margin-right:8px}.v-banner__content{align-items:center;display:flex;flex:1 1 auto;overflow:hidden}.v-banner__text{flex:1 1 auto;line-height:20px;max-width:100%}.v-banner__icon{display:inline-flex;flex:0 0 auto}.v-application--is-ltr .v-banner__icon{margin-right:24px}.v-application--is-rtl .v-banner__icon{margin-left:24px}.v-banner__wrapper{align-items:center;display:flex;flex:1 1 auto}.v-application--is-ltr .v-banner__wrapper{padding:16px 8px 16px 24px}.v-application--is-rtl .v-banner__wrapper{padding:16px 24px 16px 8px}.v-banner--single-line .v-banner__actions{margin-bottom:0;align-self:center}.v-banner--single-line .v-banner__text{white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.v-banner--single-line .v-banner__wrapper{padding-top:8px;padding-bottom:8px}.v-application--is-ltr .v-banner--has-icon .v-banner__wrapper{padding-left:16px}.v-application--is-rtl .v-banner--has-icon .v-banner__wrapper{padding-right:16px}.v-banner--is-mobile .v-banner__actions{flex:1 0 100%;margin-left:0;margin-right:0;padding-top:12px}.v-banner--is-mobile .v-banner__wrapper{flex-wrap:wrap;padding-top:16px}.v-application--is-ltr .v-banner--is-mobile .v-banner__wrapper{padding-left:16px}.v-application--is-rtl .v-banner--is-mobile .v-banner__wrapper{padding-right:16px}.v-banner--is-mobile.v-banner--has-icon .v-banner__wrapper{padding-top:24px}.v-banner--is-mobile.v-banner--single-line .v-banner__actions{flex:initial;padding-top:0}.v-application--is-ltr .v-banner--is-mobile.v-banner--single-line .v-banner__actions{margin-left:36px}.v-application--is-rtl .v-banner--is-mobile.v-banner--single-line .v-banner__actions{margin-right:36px}.v-banner--is-mobile.v-banner--single-line .v-banner__wrapper{flex-wrap:nowrap;padding-top:10px}.v-application--is-ltr .v-banner--is-mobile .v-banner__icon{margin-right:16px}.v-application--is-rtl .v-banner--is-mobile .v-banner__icon{margin-left:16px}.v-application--is-ltr .v-banner--is-mobile .v-banner__content{padding-right:8px}.v-application--is-rtl .v-banner--is-mobile .v-banner__content{padding-left:8px}.v-banner--is-mobile .v-banner__content .v-banner__wrapper{flex-wrap:nowrap;padding-top:10px}",""]),t.exports=r}}]);