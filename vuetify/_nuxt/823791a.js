(window.webpackJsonp=window.webpackJsonp||[]).push([[20],{1078:function(t,n,e){"use strict";e.r(n);var r=e(1040),o=e(1130),l=(e(16),e(11),e(15),e(5),e(19),e(10),e(20),e(3)),c=(e(864),e(415)),v=e(127),h=e(192),d=e(194),f=e(160),_=e(83),m=e(12),x=e(2);function y(object,t){var n=Object.keys(object);if(Object.getOwnPropertySymbols){var e=Object.getOwnPropertySymbols(object);t&&(e=e.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),n.push.apply(n,e)}return n}function O(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?y(Object(source),!0).forEach((function(n){Object(l.a)(t,n,source[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):y(Object(source)).forEach((function(n){Object.defineProperty(t,n,Object.getOwnPropertyDescriptor(source,n))}))}return t}var w=Object(m.a)(c.a,f.a,_.a).extend({name:"v-banner",inheritAttrs:!1,props:{app:Boolean,icon:String,iconColor:String,singleLine:Boolean,sticky:Boolean,value:{type:Boolean,default:!0}},computed:{classes:function(){return O(O({},c.a.options.computed.classes.call(this)),{},{"v-banner--has-icon":this.hasIcon,"v-banner--is-mobile":this.isMobile,"v-banner--single-line":this.singleLine,"v-banner--sticky":this.isSticky})},hasIcon:function(){return Boolean(this.icon||this.$slots.icon)},isSticky:function(){return this.sticky||this.app},styles:function(){var t=O({},c.a.options.computed.styles.call(this));if(this.isSticky){var n=this.app?this.$vuetify.application.bar+this.$vuetify.application.top:0;t.top=Object(x.i)(n),t.position="sticky",t.zIndex=1}return t}},methods:{toggle:function(){this.isActive=!this.isActive},iconClick:function(t){this.$emit("click:icon",t)},genIcon:function(){var content;if(this.hasIcon)return content=this.icon?this.$createElement(h.a,{props:{color:this.iconColor,size:28}},[this.icon]):this.$slots.icon,this.$createElement(v.a,{staticClass:"v-banner__icon",props:{color:this.color,size:40},on:{click:this.iconClick}},[content])},genText:function(){return this.$createElement("div",{staticClass:"v-banner__text"},this.$slots.default)},genActions:function(){var t=this,n=Object(x.u)(this,"actions",{dismiss:function(){return t.isActive=!1}});if(n)return this.$createElement("div",{staticClass:"v-banner__actions"},n)},genContent:function(){return this.$createElement("div",{staticClass:"v-banner__content"},[this.genIcon(),this.genText()])},genWrapper:function(){return this.$createElement("div",{staticClass:"v-banner__wrapper"},[this.genContent(),this.genActions()])}},render:function(t){var data={staticClass:"v-banner",attrs:this.attrs$,class:this.classes,style:this.styles,directives:[{name:"show",value:this.isActive}]};return t(d.a,[t("div",this.outlined?data:this.setBackgroundColor(this.color,data),[this.genWrapper()])])}}),k=e(82),B=Object(k.a)({},(function(){return(0,this._self._c)(w,{attrs:{"single-line":""}},[this._v("\n  Simple Banner\n")])}),[],!1,null,null,null).exports,j=Object(k.a)({},(function(){return(0,this._self._c)(w,{attrs:{rounded:"",color:"yellow"}},[this._v("\n  Rounded Banner\n")])}),[],!1,null,null,null).exports,S=e(529),C={data:function(){return{tile:!1}}},I=Object(k.a)(C,(function(){var t=this,n=t._self._c;return n("div",[n(S.a,{attrs:{label:"enable tile"},model:{value:t.tile,callback:function(n){t.tile=n},expression:"tile"}}),t._v(" "),n(w,{attrs:{color:"green",rounded:"",tile:t.tile}},[t._v("\n        Tile Banner\n    ")])],1)}),[],!1,null,null,null).exports,P=Object(k.a)({},(function(){return(0,this._self._c)(w,{attrs:{color:"red",shaped:""}},[this._v("\n  Shaped Banner\n")])}),[],!1,null,null,null).exports,E=Object(k.a)({},(function(){return(0,this._self._c)(w,{attrs:{"single-line":"",outlined:""}},[this._v("\n  Outlined Banner\n")])}),[],!1,null,null,null).exports,$=Object(k.a)({},(function(){return(0,this._self._c)(w,{attrs:{color:"purple",dark:""}},[this._v("\n    Dark Banner\n")])}),[],!1,null,null,null).exports,D=Object(k.a)({},(function(){return(0,this._self._c)(w,{attrs:{"single-line":"",elevation:"12"}},[this._v("\n  Elevated Banner\n")])}),[],!1,null,null,null).exports,T=e(446),A=e(435),z=e(412),M=e(157),R=e(496),L=e(589),H=e(571),N=e(467),W=e(416),J={data:function(){return{sticky:!1}}},V=Object(k.a)(J,(function(){var t=this,n=t._self._c;return n(A.a,[n(H.a),t._v(" "),n(N.a,{attrs:{flat:""}},[n(W.b,[t._v("My Document")]),t._v(" "),n(R.a),t._v(" "),n("div",[n(L.a,{attrs:{label:"Sticky Banner","hide-details":""},model:{value:t.sticky,callback:function(n){t.sticky=n},expression:"sticky"}})],1)],1),t._v(" "),n(w,{attrs:{"single-line":"",sticky:t.sticky},scopedSlots:t._u([{key:"actions",fn:function(){return[n(T.a,{attrs:{text:"",color:"deep-purple accent-4"}},[t._v("\n        Get Online\n      ")])]},proxy:!0}])},[t._v("\n    We can't save your edits while you are in offline mode.\n\n    ")]),t._v(" "),n(z.c,{staticClass:"grey lighten-4"},[n(M.a,{staticClass:"mx-auto",attrs:{"max-width":"800",height:"300"}})],1)],1)}),[],!1,null,null,null).exports,G=e(178),U=(e(75),{methods:{alert:function(t){function n(){return t.apply(this,arguments)}return n.toString=function(){return t.toString()},n}((function(){alert("Hello, World!")}))}}),F=U,K=Object(k.a)(F,(function(){var t=this,n=t._self._c;return n(w,{attrs:{"single-line":""},on:{"click:icon":t.alert},scopedSlots:t._u([{key:"actions",fn:function(){return[n(T.a,{attrs:{color:"primary",text:""}},[t._v("\n      Connection Settings\n    ")])]},proxy:!0}])},[n(G.a,{attrs:{slot:"icon",color:"warning",size:"36"},slot:"icon"},[t._v("\n    mdi-wifi-strength-alert-outline\n  ")]),t._v("\n  Unable to verify your Internet connection\n\n  ")],1)}),[],!1,null,null,null).exports,Q={data:function(){return{v0:!0}}},X=Object(k.a)(Q,(function(){var t=this,n=t._self._c;return n("div",[n(S.a,{attrs:{label:"Visible"},model:{value:t.v0,callback:function(n){t.v0=n},expression:"v0"}}),t._v(" "),n(w,{attrs:{"single-line":"",transition:"slide-y-transition"},scopedSlots:t._u([{key:"actions",fn:function(e){var r=e.dismiss;return[n(T.a,{attrs:{text:"",color:"primary"},on:{click:r}},[t._v("\n        Dismiss\n      ")]),t._v(" "),n(T.a,{attrs:{text:"",color:"primary"}},[t._v("\n        Retry\n      ")])]}}]),model:{value:t.v0,callback:function(n){t.v0=n},expression:"v0"}},[t._v("\n    No Internet connection\n    ")])],1)}),[],!1,null,null,null).exports,Y=e(186),Z={name:"Banners",components:{SimpleBanner:B,RoundedBanner:j,TileBanner:I,ShapedBanner:P,OutlinedBanner:E,DarkBanner:$,ElevatedBanner:D,SingleBanner:V,EventsBanner:K,ActionsBanner:X,IconBanner:Object(k.a)({},(function(){var t=this,n=t._self._c;return n(w,{attrs:{"two-line":""},scopedSlots:t._u([{key:"actions",fn:function(){return[n(T.a,{attrs:{text:"",color:"deep-purple accent-4"}},[t._v("\n      Action\n    ")]),t._v(" "),n(T.a,{attrs:{text:"",color:"deep-purple accent-4"}},[t._v("\n      Action\n    ")])]},proxy:!0}])},[n(Y.a,{attrs:{slot:"icon",color:"deep-purple accent-4",size:"40"},slot:"icon"},[n(G.a,{attrs:{icon:"mdi-lock",color:"white"}},[t._v("\n      mdi-lock\n    ")])],1),t._v("\n\n  Three line text string example with two actions. One to two lines is preferable. \n  Three lines should be considered the maximum string length on desktop in order to keep messages short and actionable.\n\n  ")],1)}),[],!1,null,null,null).exports,TwoLineBanner:Object(k.a)({},(function(){var t=this,n=t._self._c;return n(w,{scopedSlots:t._u([{key:"actions",fn:function(){return[n(T.a,{attrs:{text:"",color:"primary"}},[t._v("\n      Dismiss\n    ")]),t._v(" "),n(T.a,{attrs:{text:"",color:"primary"}},[t._v("\n      Retry\n    ")])]},proxy:!0}])},[t._v("\n  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent cursus nec sem id malesuada.\n  Curabitur lacinia sem et turpis euismod, eget elementum ex pretium.\n  ")])}),[],!1,null,null,null).exports}},tt=Object(k.a)(Z,(function(){var t=this,n=t._self._c;return n(o.a,[n(r.a,[n("h1",[t._v("Banner")]),t._v(" "),n("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),n("code",[t._v("v-banner")]),t._v(" component is used as middle-interruptive message to user with 1-2 actions.\n            It comes in 2 variations single-line and multi-line (implicit).\n            These can have icons which you can use with your message and actions.\n        ")])]),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Single Banner\n        ")]),t._v(" "),n("SingleBanner",{attrs:{id:"SingleBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Simple Banner\n        ")]),t._v(" "),n("SimpleBanner",{attrs:{id:"SimpleBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Rounded Banner\n        ")]),t._v(" "),n("RoundedBanner",{attrs:{id:"RoundedBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Tile Banner\n        ")]),t._v(" "),n("TileBanner",{attrs:{id:"TileBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Shaped Banner\n        ")]),t._v(" "),n("ShapedBanner",{attrs:{id:"ShapedBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Outlined Banner\n        ")]),t._v(" "),n("OutlinedBanner",{attrs:{id:"OutlinedBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Dark Banner\n        ")]),t._v(" "),n("DarkBanner",{attrs:{id:"DarkBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n          Elevated Banner\n        ")]),t._v(" "),n("ElevatedBanner",{attrs:{id:"ElevatedBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Events Banner (icon click)\n        ")]),t._v(" "),n("EventsBanner",{attrs:{id:"EventsBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Actions Banner\n        ")]),t._v(" "),n("ActionsBanner",{attrs:{id:"ActionsBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Icon Banner\n        ")]),t._v(" "),n("IconBanner",{attrs:{id:"IconBanner"}})],1),t._v(" "),n(r.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Two line Banner\n        ")]),t._v(" "),n("TwoLineBanner",{attrs:{id:"TwoLineBanner"}})],1)],1)}),[],!1,null,null,null);n.default=tt.exports},412:function(t,n,e){"use strict";e.d(n,"a",(function(){return l})),e.d(n,"b",(function(){return c})),e.d(n,"c",(function(){return v})),e.d(n,"d",(function(){return h}));var r=e(435),o=e(2),l=Object(o.k)("v-card__actions"),c=Object(o.k)("v-card__subtitle"),v=Object(o.k)("v-card__text"),h=Object(o.k)("v-card__title");r.a},415:function(t,n,e){"use strict";var r=e(157);n.a=r.a},416:function(t,n,e){"use strict";e.d(n,"a",(function(){return c})),e.d(n,"b",(function(){return l}));var r=e(467),o=e(2),l=Object(o.k)("v-toolbar__title"),c=Object(o.k)("v-toolbar__items");r.a},494:function(t,n,e){var content=e(495);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,e(27).default)("12a190a6",content,!0,{sourceMap:!1})},495:function(t,n,e){var r=e(26)(!1);r.push([t.i,".v-input--checkbox.v-input--indeterminate.v-input--is-disabled{opacity:.6}.v-input--checkbox.v-input--dense{margin-top:4px}",""]),t.exports=r},526:function(t,n,e){var content=e(527);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,e(27).default)("dd2325f0",content,!0,{sourceMap:!1})},527:function(t,n,e){var r=e(26)(!1);r.push([t.i,".theme--light.v-system-bar{background-color:#e0e0e0;color:rgba(0,0,0,.6)}.theme--light.v-system-bar .v-icon{color:rgba(0,0,0,.6)}.theme--light.v-system-bar--lights-out{background-color:hsla(0,0%,100%,.7)!important}.theme--dark.v-system-bar{background-color:#000;color:hsla(0,0%,100%,.7)}.theme--dark.v-system-bar .v-icon{color:hsla(0,0%,100%,.7)}.theme--dark.v-system-bar--lights-out{background-color:rgba(0,0,0,.2)!important}.v-system-bar{align-items:center;display:flex;font-size:.875rem;font-weight:400;padding:0 8px}.v-system-bar .v-icon{font-size:1rem;margin-right:4px}.v-system-bar--absolute,.v-system-bar--fixed{left:0;top:0;width:100%;z-index:3}.v-system-bar--fixed{position:fixed}.v-system-bar--absolute{position:absolute}.v-system-bar--window .v-icon{font-size:1.25rem;margin-right:8px}",""]),t.exports=r},529:function(t,n,e){"use strict";e(16),e(11),e(15),e(19),e(10),e(20);var r=e(105),o=e(3),l=(e(5),e(75),e(494),e(469),e(192)),c=e(445),v=e(470),h=["title"];function d(object,t){var n=Object.keys(object);if(Object.getOwnPropertySymbols){var e=Object.getOwnPropertySymbols(object);t&&(e=e.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),n.push.apply(n,e)}return n}function f(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?d(Object(source),!0).forEach((function(n){Object(o.a)(t,n,source[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):d(Object(source)).forEach((function(n){Object.defineProperty(t,n,Object.getOwnPropertyDescriptor(source,n))}))}return t}n.a=v.a.extend({name:"v-checkbox",props:{indeterminate:Boolean,indeterminateIcon:{type:String,default:"$checkboxIndeterminate"},offIcon:{type:String,default:"$checkboxOff"},onIcon:{type:String,default:"$checkboxOn"}},data:function(){return{inputIndeterminate:this.indeterminate}},computed:{classes:function(){return f(f({},c.a.options.computed.classes.call(this)),{},{"v-input--selection-controls":!0,"v-input--checkbox":!0,"v-input--indeterminate":this.inputIndeterminate})},computedIcon:function(){return this.inputIndeterminate?this.indeterminateIcon:this.isActive?this.onIcon:this.offIcon},validationState:function(){if(!this.isDisabled||this.inputIndeterminate)return this.hasError&&this.shouldValidate?"error":this.hasSuccess?"success":null!==this.hasColor?this.computedColor:void 0}},watch:{indeterminate:function(t){var n=this;this.$nextTick((function(){return n.inputIndeterminate=t}))},inputIndeterminate:function(t){this.$emit("update:indeterminate",t)},isActive:function(){this.indeterminate&&(this.inputIndeterminate=!1)}},methods:{genCheckbox:function(){var t=this.attrs$,n=(t.title,Object(r.a)(t,h));return this.$createElement("div",{staticClass:"v-input--selection-controls__input"},[this.$createElement(l.a,this.setTextColor(this.validationState,{props:{dense:this.dense,dark:this.dark,light:this.light}}),this.computedIcon),this.genInput("checkbox",f(f({},n),{},{"aria-checked":this.inputIndeterminate?"mixed":this.isActive.toString()})),this.genRipple(this.setTextColor(this.rippleState))])},genDefaultSlot:function(){return[this.genCheckbox(),this.genLabel()]}}})},571:function(t,n,e){"use strict";e(16),e(11),e(15),e(5),e(19),e(10),e(20);var r=e(3),o=(e(42),e(277),e(526),e(213)),l=e(36),c=e(35),v=e(12),h=e(2);function d(object,t){var n=Object.keys(object);if(Object.getOwnPropertySymbols){var e=Object.getOwnPropertySymbols(object);t&&(e=e.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),n.push.apply(n,e)}return n}n.a=Object(v.a)(Object(o.a)("bar",["height","window"]),l.a,c.a).extend({name:"v-system-bar",props:{height:[Number,String],lightsOut:Boolean,window:Boolean},computed:{classes:function(){return function(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?d(Object(source),!0).forEach((function(n){Object(r.a)(t,n,source[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):d(Object(source)).forEach((function(n){Object.defineProperty(t,n,Object.getOwnPropertyDescriptor(source,n))}))}return t}({"v-system-bar--lights-out":this.lightsOut,"v-system-bar--absolute":this.absolute,"v-system-bar--fixed":!this.absolute&&(this.app||this.fixed),"v-system-bar--window":this.window},this.themeClasses)},computedHeight:function(){return this.height?isNaN(parseInt(this.height))?this.height:parseInt(this.height):this.window?32:24},styles:function(){return{height:Object(h.i)(this.computedHeight)}}},methods:{updateApplication:function(){return this.$el?this.$el.clientHeight:this.computedHeight}},render:function(t){var data={staticClass:"v-system-bar",class:this.classes,style:this.styles,on:this.$listeners};return t("div",this.setBackgroundColor(this.color,data),Object(h.u)(this))}})},864:function(t,n,e){var content=e(865);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,e(27).default)("238c91c4",content,!0,{sourceMap:!1})},865:function(t,n,e){var r=e(26)(!1);r.push([t.i,".theme--light.v-banner.v-sheet{background-color:transparent}.theme--light.v-banner.v-sheet:not(.v-sheet--outlined):not(.v-sheet--shaped) .v-banner__wrapper{border-bottom:thin solid rgba(0,0,0,.12)}.theme--dark.v-banner.v-sheet{background-color:transparent}.theme--dark.v-banner.v-sheet:not(.v-sheet--outlined):not(.v-sheet--shaped) .v-banner__wrapper{border-bottom:thin solid hsla(0,0%,100%,.12)}.v-sheet.v-banner{border-radius:0}.v-sheet.v-banner:not(.v-sheet--outlined){box-shadow:0 0 0 0 rgba(0,0,0,.2),0 0 0 0 rgba(0,0,0,.14),0 0 0 0 rgba(0,0,0,.12)}.v-sheet.v-banner.v-sheet--shaped{border-radius:24px 0}.v-banner{position:relative;transition:box-shadow .28s cubic-bezier(.4,0,.2,1)}.v-banner__actions{align-items:center;align-self:flex-end;display:flex;flex:1 0 auto;justify-content:flex-end;margin-bottom:-8px}.v-application--is-ltr .v-banner__actions{margin-left:90px}.v-application--is-rtl .v-banner__actions{margin-right:90px}.v-application--is-ltr .v-banner__actions>*{margin-left:8px}.v-application--is-rtl .v-banner__actions>*{margin-right:8px}.v-banner__content{align-items:center;display:flex;flex:1 1 auto;overflow:hidden}.v-banner__text{flex:1 1 auto;line-height:20px;max-width:100%}.v-banner__icon{display:inline-flex;flex:0 0 auto}.v-application--is-ltr .v-banner__icon{margin-right:24px}.v-application--is-rtl .v-banner__icon{margin-left:24px}.v-banner__wrapper{align-items:center;display:flex;flex:1 1 auto}.v-application--is-ltr .v-banner__wrapper{padding:16px 8px 16px 24px}.v-application--is-rtl .v-banner__wrapper{padding:16px 24px 16px 8px}.v-banner--single-line .v-banner__actions{margin-bottom:0;align-self:center}.v-banner--single-line .v-banner__text{white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.v-banner--single-line .v-banner__wrapper{padding-top:8px;padding-bottom:8px}.v-application--is-ltr .v-banner--has-icon .v-banner__wrapper{padding-left:16px}.v-application--is-rtl .v-banner--has-icon .v-banner__wrapper{padding-right:16px}.v-banner--is-mobile .v-banner__actions{flex:1 0 100%;margin-left:0;margin-right:0;padding-top:12px}.v-banner--is-mobile .v-banner__wrapper{flex-wrap:wrap;padding-top:16px}.v-application--is-ltr .v-banner--is-mobile .v-banner__wrapper{padding-left:16px}.v-application--is-rtl .v-banner--is-mobile .v-banner__wrapper{padding-right:16px}.v-banner--is-mobile.v-banner--has-icon .v-banner__wrapper{padding-top:24px}.v-banner--is-mobile.v-banner--single-line .v-banner__actions{flex:initial;padding-top:0}.v-application--is-ltr .v-banner--is-mobile.v-banner--single-line .v-banner__actions{margin-left:36px}.v-application--is-rtl .v-banner--is-mobile.v-banner--single-line .v-banner__actions{margin-right:36px}.v-banner--is-mobile.v-banner--single-line .v-banner__wrapper{flex-wrap:nowrap;padding-top:10px}.v-application--is-ltr .v-banner--is-mobile .v-banner__icon{margin-right:16px}.v-application--is-rtl .v-banner--is-mobile .v-banner__icon{margin-left:16px}.v-application--is-ltr .v-banner--is-mobile .v-banner__content{padding-right:8px}.v-application--is-rtl .v-banner--is-mobile .v-banner__content{padding-left:8px}.v-banner--is-mobile .v-banner__content .v-banner__wrapper{flex-wrap:nowrap;padding-top:10px}",""]),t.exports=r}}]);