(window.webpackJsonp=window.webpackJsonp||[]).push([[21],{1108:function(t,e,n){"use strict";n.r(e);var r=n(1037),o=n(1125),l=(n(16),n(11),n(15),n(5),n(19),n(10),n(20),n(105)),c=n(3),d=(n(42),n(861),n(178)),v=n(36),h=n(35),f=n(83),m=n(564),_=n(196),x=n(12),y=n(2),O=["aria-atomic","aria-label","aria-live","role","title"];function C(object,t){var e=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),e.push.apply(e,n)}return e}var w=Object(x.a)(v.a,Object(_.b)(["left","bottom"]),h.a,f.a,m.a).extend({name:"v-badge",props:{avatar:Boolean,bordered:Boolean,color:{type:String,default:"primary"},content:{required:!1},dot:Boolean,label:{type:String,default:"$vuetify.badge"},icon:String,inline:Boolean,offsetX:[Number,String],offsetY:[Number,String],overlap:Boolean,tile:Boolean,transition:{type:String,default:"scale-rotate-transition"},value:{default:!0}},computed:{classes:function(){return function(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?C(Object(source),!0).forEach((function(e){Object(c.a)(t,e,source[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):C(Object(source)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(source,e))}))}return t}({"v-badge--avatar":this.avatar,"v-badge--bordered":this.bordered,"v-badge--bottom":this.bottom,"v-badge--dot":this.dot,"v-badge--icon":null!=this.icon,"v-badge--inline":this.inline,"v-badge--left":this.left,"v-badge--overlap":this.overlap,"v-badge--tile":this.tile},this.themeClasses)},computedBottom:function(){return this.bottom?"auto":this.computedYOffset},computedLeft:function(){return this.isRtl?this.left?this.computedXOffset:"auto":this.left?"auto":this.computedXOffset},computedRight:function(){return this.isRtl?this.left?"auto":this.computedXOffset:this.left?this.computedXOffset:"auto"},computedTop:function(){return this.bottom?this.computedYOffset:"auto"},computedXOffset:function(){return this.calcPosition(this.offsetX)},computedYOffset:function(){return this.calcPosition(this.offsetY)},isRtl:function(){return this.$vuetify.rtl},offset:function(){return this.overlap?this.dot?8:12:this.dot?2:4},styles:function(){return this.inline?{}:{bottom:this.computedBottom,left:this.computedLeft,right:this.computedRight,top:this.computedTop}}},methods:{calcPosition:function(t){return"calc(100% - ".concat(Object(y.i)(t||this.offset),")")},genBadge:function(){var t=this.$vuetify.lang,label=this.$attrs["aria-label"]||t.t(this.label),data=this.setBackgroundColor(this.color,{staticClass:"v-badge__badge",style:this.styles,attrs:{"aria-atomic":this.$attrs["aria-atomic"]||"true","aria-label":label,"aria-live":this.$attrs["aria-live"]||"polite",title:this.$attrs.title,role:this.$attrs.role||"status"},directives:[{name:"show",value:this.isActive}]}),e=this.$createElement("span",data,[this.genBadgeContent()]);return this.transition?this.$createElement("transition",{props:{name:this.transition,origin:this.origin,mode:this.mode}},[e]):e},genBadgeContent:function(){if(!this.dot){var slot=Object(y.u)(this,"badge");return slot||(this.content?String(this.content):this.icon?this.$createElement(d.a,this.icon):void 0)}},genBadgeWrapper:function(){return this.$createElement("span",{staticClass:"v-badge__wrapper"},[this.genBadge()])}},render:function(t){var e=[this.genBadgeWrapper()],n=[Object(y.u)(this)],r=this.$attrs,o=(r["aria-atomic"],r["aria-label"],r["aria-live"],r.role,r.title,Object(l.a)(r,O));return this.inline&&this.left?n.unshift(e):n.push(e),t("span",{staticClass:"v-badge",attrs:o,class:this.classes},n)}}),j=n(466),B=n(82),k=Object(B.a)({},(function(){var t=this,e=t._self._c;return e("div",[e(j.a,{staticClass:"ma-2"},[e("div",{staticClass:"ma-5"},[e(w,{attrs:{content:1}},[e(d.a,{attrs:{large:""}},[t._v("\n                    mdi-email\n                ")])],1)],1),t._v(" "),e("div",{staticClass:"ma-5"},[e(w,{attrs:{bottom:"",content:1,color:"warning"}},[e(d.a,{attrs:{large:""}},[t._v("\n                    mdi-email\n                ")])],1)],1),t._v(" "),e("div",{staticClass:"ma-5"},[e(w,{attrs:{left:"",content:1,color:"purple"}},[e(d.a,{attrs:{large:""}},[t._v("\n                    mdi-email\n                ")])],1)],1),t._v(" "),e("div",{staticClass:"ma-5"},[e(w,{attrs:{left:"",bottom:"",content:1,color:"success"}},[e(d.a,{attrs:{large:""}},[t._v("\n                    mdi-email\n                ")])],1)],1),t._v(" "),e("div",{staticClass:"ma-5"},[e(w,{attrs:{inline:"",content:1,color:"pink"}},[e(d.a,{attrs:{large:""}},[t._v("\n                    mdi-email\n                ")])],1)],1),t._v(" "),e("div",{staticClass:"ma-5"},[e(w,{attrs:{inline:"",left:"",content:1,color:"lime"}},[e(d.a,{attrs:{large:""}},[t._v("\n                    mdi-email\n                ")])],1)],1)])],1)}),[],!1,null,null,null).exports,S=n(186),$=n(446),P=n(214),D={data:function(){return{locked:!0}}},X=Object(B.a)(D,(function(){var t=this,e=t._self._c;return e("div",[e(j.a,{staticClass:"ma-2"},[e("div",{staticClass:"mx-3"},[t.locked?e(w,{attrs:{bordered:"",color:"error",icon:"mdi-lock",overlap:""}},[e($.a,{staticClass:"white--text",attrs:{color:"error",depressed:""},on:{click:function(e){t.locked=!1}}},[t._v("\n                    Unlock Account\n                ")])],1):e(w,{attrs:{bordered:"",color:"error",icon:"mdi-lock-open-variant",overlap:""}},[e($.a,{staticClass:"white--text",attrs:{color:"error",depressed:""},on:{click:function(e){t.locked=!0}}},[t._v("\n                    Lock account\n                ")])],1)],1),t._v(" "),e("div",{staticClass:"mx-3"},[e(w,{attrs:{bordered:"",bottom:"",color:"deep-purple accent-4",dot:"","offset-x":"10","offset-y":"10"}},[e(S.a,{attrs:{size:"40"}},[e(P.a,{attrs:{src:"https://cdn.vuetifyjs.com/images/lists/2.jpg"}})],1)],1)],1),t._v(" "),e("div",{staticClass:"mx-3"},[e(w,{attrs:{avatar:"",bordered:"",overlap:""},scopedSlots:t._u([{key:"badge",fn:function(){return[e(S.a,[e(P.a,{attrs:{src:"https://cdn.vuetifyjs.com/images/logos/v.png"}})],1)]},proxy:!0}])},[t._v(" "),e(S.a,{attrs:{size:"40"}},[e(P.a,{attrs:{src:"https://cdn.vuetifyjs.com/images/john.png"}})],1)],1)],1)])],1)}),[],!1,null,null,null).exports,E={data:function(){return{messages:0}}},z=Object(B.a)(E,(function(){var t=this,e=t._self._c;return e("div",[e(j.a,{staticClass:"ma-2"},[e($.a,{staticClass:"mx-3",attrs:{color:"primary"},on:{click:function(e){t.messages++}}},[t._v("\n            Send Message\n        ")]),t._v(" "),e($.a,{staticClass:"mx-3",attrs:{color:"error"},on:{click:function(e){t.messages=0}}},[t._v("\n            Clear Notifications\n        ")]),t._v(" "),e(w,{staticClass:"mx-3",attrs:{content:t.messages,value:t.messages,color:"green",overlap:"",tile:""}},[e(d.a,{attrs:{large:""}},[t._v("\n                mdi-vuetify\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports,R=n(1038),Y={data:function(){return{hover:!1}}},H={name:"Badges",components:{SimpleBadge:k,CustomBadge:X,DynamicBadge:z,HoverBadge:Object(B.a)(Y,(function(){var t=this,e=t._self._c;return e("div",[e(w,{staticClass:"ma-3",attrs:{value:t.hover,color:"deep-purple accent-4",content:"9999+",transition:"slide-x-transition"}},[e(R.a,{model:{value:t.hover,callback:function(e){t.hover=e},expression:"hover"}},[e(d.a,{attrs:{color:"grey lighten-1",large:""}},[t._v("\n                mdi-account\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports}},L=Object(B.a)(H,(function(){var t=this,e=t._self._c;return e(o.a,[e(r.a,[e("h1",[t._v("Badges")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),e("code",[t._v("v-badge")]),t._v(" component superscripts or subscripts an avatar-like icon or text onto \n            content to highlight information to a user or to just draw attention to a specific element. \n            Content within the badge usually contains numbers or icons.\n        ")])]),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Simple badge\n        ")]),t._v(" "),e("SimpleBadge",{attrs:{id:"simpleBadges"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Custom badge\n        ")]),t._v(" "),e("CustomBadge",{attrs:{id:"customBadges"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Dynamic badge\n        ")]),t._v(" "),e("DynamicBadge",{attrs:{id:"dynamicBadge"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Hover badge\n        ")]),t._v(" "),e("HoverBadge",{attrs:{id:"hoverBadge"}})],1)],1)}),[],!1,null,null,null);e.default=L.exports},564:function(t,e,n){"use strict";var r=n(1);e.a=r.a.extend({name:"transitionable",props:{mode:String,origin:String,transition:String}})},861:function(t,e,n){var content=n(862);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,n(27).default)("5276b867",content,!0,{sourceMap:!1})},862:function(t,e,n){var r=n(26)(!1);r.push([t.i,'.theme--light.v-badge .v-badge__badge:after{border-color:#fff}.theme--dark.v-badge .v-badge__badge:after{border-color:#1e1e1e}.v-badge{position:relative}.v-badge,.v-badge__badge{display:inline-block;line-height:1}.v-badge__badge{border-radius:10px;color:#fff;font-size:12px;height:20px;letter-spacing:0;min-width:20px;padding:4px 6px;pointer-events:auto;position:absolute;text-align:center;text-indent:0;top:auto;transition:.3s cubic-bezier(.25,.8,.5,1);white-space:nowrap}.v-application--is-ltr .v-badge__badge{right:auto}.v-application--is-rtl .v-badge__badge{left:auto}.v-badge__badge .v-icon{color:inherit;font-size:12px;height:12px;margin:0 -2px;width:12px}.v-badge__badge .v-img{height:12px;width:12px}.v-badge__wrapper{flex:0 1;height:100%;left:0;pointer-events:none;position:absolute;top:0;width:100%}.v-badge--avatar .v-badge__badge{padding:0}.v-badge--avatar .v-badge__badge .v-avatar{height:20px!important;min-width:0!important;max-width:20px!important}.v-badge--bordered .v-badge__badge:after{border-radius:inherit;border-width:2px;border-style:solid;bottom:0;content:"";left:0;position:absolute;right:0;top:0;transform:scale(1.15)}.v-badge--dot .v-badge__badge{border-radius:4.5px;height:9px;min-width:0;padding:0;width:9px}.v-badge--dot .v-badge__badge:after{border-width:1.5px}.v-badge--icon .v-badge__badge{padding:4px 6px}.v-badge--inline{align-items:center;display:inline-flex;justify-content:center}.v-badge--inline .v-badge__badge,.v-badge--inline .v-badge__wrapper{position:relative}.v-badge--inline .v-badge__wrapper{margin:0 4px}.v-badge--tile .v-badge__badge{border-radius:0}',""]),t.exports=r}}]);