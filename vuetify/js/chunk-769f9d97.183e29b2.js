(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-769f9d97"],{"31a6":function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",[a("v-col",[a("h1",[t._v("Overlays")])]),a("v-col",[a("p",{staticClass:"text-h5"},[t._v(" Absolute overlay ")]),a("AbsoluteOverlay",{attrs:{id:"AbsoluteOverlay"}})],1),a("v-col",[a("p",{staticClass:"text-h5"},[t._v(" Opacity overlay ")]),a("OpacityOverlay",{attrs:{id:"OpacityOverlay"}})],1),a("v-col",[a("p",{staticClass:"text-h5"},[t._v(" Z Index overlay ")]),a("ZIndexOverlay",{attrs:{id:"ZIndexOverlay"}})],1),a("v-col",[a("p",{staticClass:"text-h5"},[t._v(" Advanced overlay ")]),a("AdvancedOverlay",{attrs:{id:"AdvancedOverlay"}})],1),a("v-col",[a("p",{staticClass:"text-h5"},[t._v(" Loader overlay ")]),a("LoaderOverlay",{attrs:{id:"LoaderOverlay"}})],1)],1)},l=[],o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-row",{attrs:{align:"center",justify:"center"}},[a("v-card",{attrs:{height:"300",width:"250"}},[a("v-row",{attrs:{justify:"center"}},[a("v-btn",{staticClass:"mt-12",attrs:{color:"success"},on:{click:function(e){t.overlay=!t.overlay}}},[t._v(" Show Overlay ")]),a("v-overlay",{attrs:{absolute:t.absolute,value:t.overlay}},[a("v-btn",{attrs:{color:"success"},on:{click:function(e){t.overlay=!1}}},[t._v(" Hide Overlay ")])],1)],1)],1)],1)},n=[],s={data:function(){return{absolute:!0,overlay:!1}}},v=s,c=a("2877"),i=a("6544"),u=a.n(i),d=a("8336"),y=a("b0af"),h=a("a797"),f=a("0fd9"),p=Object(c["a"])(v,o,n,!1,null,null,null),O=p.exports;u()(p,{VBtn:d["a"],VCard:y["a"],VOverlay:h["a"],VRow:f["a"]});var b=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-row",{attrs:{align:"center",justify:"center"}},[a("v-card",{attrs:{height:"300",width:"250"}},[a("v-row",{attrs:{justify:"center"}},[a("v-btn",{staticClass:"mt-12",attrs:{color:"orange lighten-2"},on:{click:function(e){t.overlay=!t.overlay}}},[t._v(" Show Overlay ")]),a("v-overlay",{attrs:{absolute:t.absolute,opacity:t.opacity,value:t.overlay}},[a("v-btn",{attrs:{color:"orange lighten-2"},on:{click:function(e){t.overlay=!1}}},[t._v(" Hide Overlay ")])],1)],1)],1)],1)},_=[],x={data:function(){return{absolute:!0,opacity:1,overlay:!1}}},m=x,g=Object(c["a"])(m,b,_,!1,null,null,null),w=g.exports;u()(g,{VBtn:d["a"],VCard:y["a"],VOverlay:h["a"],VRow:f["a"]});var V=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-row",{attrs:{justify:"center"}},[a("v-btn",{staticClass:"white--text",attrs:{color:"teal"},on:{click:function(e){t.overlay=!t.overlay}}},[t._v(" Show Overlay ")]),a("v-overlay",{attrs:{"z-index":t.zIndex,value:t.overlay}},[a("v-btn",{staticClass:"white--text",attrs:{color:"teal"},on:{click:function(e){t.overlay=!1}}},[t._v(" Hide Overlay ")])],1)],1)},C=[],j={data:function(){return{overlay:!1,zIndex:0}}},A=j,k=Object(c["a"])(A,V,C,!1,null,null,null),E=k.exports;u()(k,{VBtn:d["a"],VOverlay:h["a"],VRow:f["a"]});var S=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-hover",{scopedSlots:t._u([{key:"default",fn:function(e){var r=e.hover;return[a("v-card",{staticClass:"mx-auto",attrs:{"max-width":"344"}},[a("v-img",{attrs:{src:"https://cdn.vuetifyjs.com/images/cards/forest-art.jpg"}}),a("v-card-text",[a("h2",{staticClass:"text-h6 primary--text"},[t._v(" Magento Forests ")]),t._v(" Travel to the best outdoor experience on planet Earth. A vacation you will never forget! ")]),a("v-card-title",[a("v-rating",{staticClass:"mr-2",attrs:{value:4,dense:"",color:"orange","background-color":"orange",hover:""}}),a("span",{staticClass:"primary--text text-subtitle-2"},[t._v("64 Reviews")])],1),a("v-fade-transition",[r?a("v-overlay",{attrs:{absolute:"",color:"#036358"}},[a("v-btn",[t._v("See more info")])],1):t._e()],1)],1)]}}])})},$=[],I={data:function(){return{overlay:!1}}},B=I,L=a("99d9"),M=a("0789"),R=a("ce87"),T=a("adda"),z=a("1d4d"),H=Object(c["a"])(B,S,$,!1,null,null,null),Z=H.exports;u()(H,{VBtn:d["a"],VCard:y["a"],VCardText:L["c"],VCardTitle:L["d"],VFadeTransition:M["d"],VHover:R["a"],VImg:T["a"],VOverlay:h["a"],VRating:z["a"]});var D=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"text-center"},[a("v-btn",{staticClass:"white--text",attrs:{color:"deep-purple accent-4"},on:{click:function(e){t.overlay=!t.overlay}}},[t._v(" Launch Application "),a("v-icon",{attrs:{right:""}},[t._v(" mdi-open-in-new ")])],1),a("v-overlay",{attrs:{value:t.overlay}},[a("v-progress-circular",{attrs:{indeterminate:"",size:"64"}})],1)],1)},F=[],J={data:function(){return{overlay:!1}},watch:{overlay:function(t){var e=this;t&&setTimeout((function(){e.overlay=!1}),3e3)}}},P=J,q=a("132d"),G=a("490a"),K=Object(c["a"])(P,D,F,!1,null,null,null),N=K.exports;u()(K,{VBtn:d["a"],VIcon:q["a"],VOverlay:h["a"],VProgressCircular:G["a"]});var Q={name:"Overlays",components:{AbsoluteOverlay:O,OpacityOverlay:w,ZIndexOverlay:E,AdvancedOverlay:Z,LoaderOverlay:N}},U=Q,W=a("62ad"),X=a("a523"),Y=Object(c["a"])(U,r,l,!1,null,null,null);e["default"]=Y.exports;u()(Y,{VCol:W["a"],VContainer:X["a"]})},ce87:function(t,e,a){"use strict";var r=a("16b7"),l=a("f2e7"),o=a("58df"),n=a("d9bd");e["a"]=Object(o["a"])(r["a"],l["a"]).extend({name:"v-hover",props:{disabled:{type:Boolean,default:!1},value:{type:Boolean,default:void 0}},methods:{onMouseEnter:function(){this.runDelay("open")},onMouseLeave:function(){this.runDelay("close")}},render:function(){return this.$scopedSlots.default||void 0!==this.value?(this.$scopedSlots.default&&(t=this.$scopedSlots.default({hover:this.isActive})),Array.isArray(t)&&1===t.length&&(t=t[0]),t&&!Array.isArray(t)&&t.tag?(this.disabled||(t.data=t.data||{},this._g(t.data,{mouseenter:this.onMouseEnter,mouseleave:this.onMouseLeave})),t):(Object(n["c"])("v-hover should only contain a single element",this),t)):(Object(n["c"])("v-hover is missing a default scopedSlot or bound value",this),null);var t}})}}]);
//# sourceMappingURL=chunk-769f9d97.183e29b2.js.map