(window.webpackJsonp=window.webpackJsonp||[]).push([[58],{1106:function(e,t,r){"use strict";r.r(t);var n=r(1040),o=r(1130),l=r(446),c=r(435),h=r(179),v=r(465),d={data:function(){return{absolute:!0,overlay:!1}}},f=r(82),m=Object(f.a)(d,(function(){var e=this,t=e._self._c;return t(v.a,{attrs:{align:"center",justify:"center"}},[t(c.a,{attrs:{height:"300",width:"250"}},[t(v.a,{attrs:{justify:"center"}},[t(l.a,{staticClass:"mt-12",attrs:{color:"success"},on:{click:function(t){e.overlay=!e.overlay}}},[e._v("\n        Show Overlay\n      ")]),e._v(" "),t(h.a,{attrs:{absolute:e.absolute,value:e.overlay}},[t(l.a,{attrs:{color:"success"},on:{click:function(t){e.overlay=!1}}},[e._v("\n          Hide Overlay\n        ")])],1)],1)],1)],1)}),[],!1,null,null,null).exports,y={data:function(){return{absolute:!0,opacity:1,overlay:!1}}},_=Object(f.a)(y,(function(){var e=this,t=e._self._c;return t(v.a,{attrs:{align:"center",justify:"center"}},[t(c.a,{attrs:{height:"300",width:"250"}},[t(v.a,{attrs:{justify:"center"}},[t(l.a,{staticClass:"mt-12",attrs:{color:"orange lighten-2"},on:{click:function(t){e.overlay=!e.overlay}}},[e._v("\n        Show Overlay\n      ")]),e._v(" "),t(h.a,{attrs:{absolute:e.absolute,opacity:e.opacity,value:e.overlay}},[t(l.a,{attrs:{color:"orange lighten-2"},on:{click:function(t){e.overlay=!1}}},[e._v("\n          Hide Overlay\n        ")])],1)],1)],1)],1)}),[],!1,null,null,null).exports,k={data:function(){return{overlay:!1,zIndex:0}}},w=Object(f.a)(k,(function(){var e=this,t=e._self._c;return t(v.a,{attrs:{justify:"center"}},[t(l.a,{staticClass:"white--text",attrs:{color:"teal"},on:{click:function(t){e.overlay=!e.overlay}}},[e._v("\n    Show Overlay\n  ")]),e._v(" "),t(h.a,{attrs:{"z-index":e.zIndex,value:e.overlay}},[t(l.a,{staticClass:"white--text",attrs:{color:"teal"},on:{click:function(t){e.overlay=!1}}},[e._v("\n      Hide Overlay\n    ")])],1)],1)}),[],!1,null,null,null).exports,O=r(412),x=r(194),j=r(795),C=r(214),B=r(1044),z={data:function(){return{overlay:!1}}},S=Object(f.a)(z,(function(){var e=this,t=e._self._c;return t(j.a,{scopedSlots:e._u([{key:"default",fn:function(r){var n=r.hover;return[t(c.a,{staticClass:"mx-auto",attrs:{"max-width":"344"}},[t(C.a,{attrs:{src:"https://cdn.vuetifyjs.com/images/cards/forest-art.jpg"}}),e._v(" "),t(O.c,[t("h2",{staticClass:"text-h6 primary--text"},[e._v("\n          Magento Forests\n        ")]),e._v("\n        Travel to the best outdoor experience on planet Earth. A vacation you will never forget!\n      ")]),e._v(" "),t(O.d,[t(B.a,{staticClass:"mr-2",attrs:{value:4,dense:"",color:"orange","background-color":"orange",hover:""}}),e._v(" "),t("span",{staticClass:"primary--text text-subtitle-2"},[e._v("64 Reviews")])],1),e._v(" "),t(x.d,[n?t(h.a,{attrs:{absolute:"",color:"#036358"}},[t(l.a,[e._v("See more info")])],1):e._e()],1)],1)]}}])})}),[],!1,null,null,null).exports,$=r(178),A=r(431),E=(r(55),{data:function(){return{overlay:!1}},watch:{overlay:function(e){var t=this;e&&setTimeout((function(){t.overlay=!1}),3e3)}}}),V={name:"Overlays",components:{AbsoluteOverlay:m,OpacityOverlay:_,ZIndexOverlay:w,AdvancedOverlay:S,LoaderOverlay:Object(f.a)(E,(function(){var e=this,t=e._self._c;return t("div",{staticClass:"text-center"},[t(l.a,{staticClass:"white--text",attrs:{color:"deep-purple accent-4"},on:{click:function(t){e.overlay=!e.overlay}}},[e._v("\n    Launch Application\n    "),t($.a,{attrs:{right:""}},[e._v("\n      mdi-open-in-new\n    ")])],1),e._v(" "),t(h.a,{attrs:{value:e.overlay}},[t(A.a,{attrs:{indeterminate:"",size:"64"}})],1)],1)}),[],!1,null,null,null).exports}},L=Object(f.a)(V,(function(){var e=this,t=e._self._c;return t(o.a,[t(n.a,[t("h1",[e._v("Overlays")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n            The "),t("code",[e._v("v-overlay")]),e._v(" component is used to provide emphasis on a particular element or parts of it. \n            It signals to the user of a state change within the application and can be used for creating loaders, \n            dialogs and more.\n        ")])]),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Absolute overlay\n        ")]),e._v(" "),t("AbsoluteOverlay",{attrs:{id:"AbsoluteOverlay"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Opacity overlay\n        ")]),e._v(" "),t("OpacityOverlay",{attrs:{id:"OpacityOverlay"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Z Index overlay\n        ")]),e._v(" "),t("ZIndexOverlay",{attrs:{id:"ZIndexOverlay"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Advanced overlay\n        ")]),e._v(" "),t("AdvancedOverlay",{attrs:{id:"AdvancedOverlay"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Loader overlay\n        ")]),e._v(" "),t("LoaderOverlay",{attrs:{id:"LoaderOverlay"}})],1)],1)}),[],!1,null,null,null);t.default=L.exports},455:function(e,t,r){"use strict";r(42);var n=r(1),o=r(463);t.a=n.a.extend().extend({name:"loadable",props:{loading:{type:[Boolean,String],default:!1},loaderHeight:{type:[Number,String],default:2}},methods:{genProgress:function(){return!1===this.loading?null:this.$slots.progress||this.$createElement(o.a,{props:{absolute:!0,color:!0===this.loading||""===this.loading?this.color||"primary":this.loading,height:this.loaderHeight,indeterminate:!0}})}}})},463:function(e,t,r){"use strict";var n=r(464);t.a=n.a},464:function(e,t,r){"use strict";r(16),r(11),r(15),r(5),r(19),r(10),r(20);var n=r(3),o=(r(42),r(277),r(480),r(194)),l=r(197),c=r(36),h=r(196),v=r(209),d=r(35),f=r(2),m=r(12);function y(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(object);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,r)}return t}var _=Object(m.a)(c.a,Object(h.b)(["absolute","fixed","top","bottom"]),v.a,d.a);t.a=_.extend({name:"v-progress-linear",directives:{intersect:l.a},props:{active:{type:Boolean,default:!0},backgroundColor:{type:String,default:null},backgroundOpacity:{type:[Number,String],default:null},bufferValue:{type:[Number,String],default:100},color:{type:String,default:"primary"},height:{type:[Number,String],default:4},indeterminate:Boolean,query:Boolean,reverse:Boolean,rounded:Boolean,stream:Boolean,striped:Boolean,value:{type:[Number,String],default:0}},data:function(){return{internalLazyValue:this.value||0,isVisible:!0}},computed:{__cachedBackground:function(){return this.$createElement("div",this.setBackgroundColor(this.backgroundColor||this.color,{staticClass:"v-progress-linear__background",style:this.backgroundStyle}))},__cachedBar:function(){return this.$createElement(this.computedTransition,[this.__cachedBarType])},__cachedBarType:function(){return this.indeterminate?this.__cachedIndeterminate:this.__cachedDeterminate},__cachedBuffer:function(){return this.$createElement("div",{staticClass:"v-progress-linear__buffer",style:this.styles})},__cachedDeterminate:function(){return this.$createElement("div",this.setBackgroundColor(this.color,{staticClass:"v-progress-linear__determinate",style:{width:Object(f.i)(this.normalizedValue,"%")}}))},__cachedIndeterminate:function(){return this.$createElement("div",{staticClass:"v-progress-linear__indeterminate",class:{"v-progress-linear__indeterminate--active":this.active}},[this.genProgressBar("long"),this.genProgressBar("short")])},__cachedStream:function(){return this.stream?this.$createElement("div",this.setTextColor(this.color,{staticClass:"v-progress-linear__stream",style:{width:Object(f.i)(100-this.normalizedBuffer,"%")}})):null},backgroundStyle:function(){var e;return e={opacity:null==this.backgroundOpacity?this.backgroundColor?1:.3:parseFloat(this.backgroundOpacity)},Object(n.a)(e,this.isReversed?"right":"left",Object(f.i)(this.normalizedValue,"%")),Object(n.a)(e,"width",Object(f.i)(Math.max(0,this.normalizedBuffer-this.normalizedValue),"%")),e},classes:function(){return function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?y(Object(source),!0).forEach((function(t){Object(n.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):y(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({"v-progress-linear--absolute":this.absolute,"v-progress-linear--fixed":this.fixed,"v-progress-linear--query":this.query,"v-progress-linear--reactive":this.reactive,"v-progress-linear--reverse":this.isReversed,"v-progress-linear--rounded":this.rounded,"v-progress-linear--striped":this.striped,"v-progress-linear--visible":this.isVisible},this.themeClasses)},computedTransition:function(){return this.indeterminate?o.d:o.i},isReversed:function(){return this.$vuetify.rtl!==this.reverse},normalizedBuffer:function(){return this.normalize(this.bufferValue)},normalizedValue:function(){return this.normalize(this.internalLazyValue)},reactive:function(){return Boolean(this.$listeners.change)},styles:function(){var e={};return this.active||(e.height=0),this.indeterminate||100===parseFloat(this.normalizedBuffer)||(e.width=Object(f.i)(this.normalizedBuffer,"%")),e}},methods:{genContent:function(){var slot=Object(f.u)(this,"default",{value:this.internalLazyValue});return slot?this.$createElement("div",{staticClass:"v-progress-linear__content"},slot):null},genListeners:function(){var e=this.$listeners;return this.reactive&&(e.click=this.onClick),e},genProgressBar:function(e){return this.$createElement("div",this.setBackgroundColor(this.color,{staticClass:"v-progress-linear__indeterminate",class:Object(n.a)({},e,!0)}))},onClick:function(e){if(this.reactive){var t=this.$el.getBoundingClientRect().width;this.internalValue=e.offsetX/t*100}},onObserve:function(e,t,r){this.isVisible=r},normalize:function(e){return e<0?0:e>100?100:parseFloat(e)}},render:function(e){return e("div",{staticClass:"v-progress-linear",attrs:{role:"progressbar","aria-valuemin":0,"aria-valuemax":this.normalizedBuffer,"aria-valuenow":this.indeterminate?void 0:this.normalizedValue},class:this.classes,directives:[{name:"intersect",value:this.onObserve}],style:{bottom:this.bottom?0:void 0,height:this.active?Object(f.i)(this.height):0,top:this.top?0:void 0},on:this.genListeners()},[this.__cachedStream,this.__cachedBackground,this.__cachedBuffer,this.__cachedBar,this.genContent()])}})},480:function(e,t,r){var content=r(481);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,r(27).default)("cf87dc84",content,!0,{sourceMap:!1})},481:function(e,t,r){var n=r(26)(!1);n.push([e.i,".theme--light.v-progress-linear{color:rgba(0,0,0,.87)}.theme--dark.v-progress-linear{color:#fff}.v-progress-linear{background:transparent;overflow:hidden;position:relative;transition:.2s cubic-bezier(.4,0,.6,1);width:100%}.v-progress-linear__buffer{height:inherit;left:0;position:absolute;top:0;transition:inherit;width:100%}.v-progress-linear--reverse .v-progress-linear__buffer{left:auto;right:0}.v-progress-linear__background{bottom:0;left:0;position:absolute;top:0;transition:inherit}.v-progress-linear--reverse .v-progress-linear__background{left:auto;right:0}.v-progress-linear__content{align-items:center;display:flex;height:100%;left:0;justify-content:center;position:absolute;top:0;width:100%}.v-progress-linear--reverse .v-progress-linear__content{left:auto;right:0}.v-progress-linear__determinate{height:inherit;left:0;position:absolute;transition:inherit}.v-progress-linear--reverse .v-progress-linear__determinate{left:auto;right:0}.v-progress-linear .v-progress-linear__indeterminate .long,.v-progress-linear .v-progress-linear__indeterminate .short{-webkit-animation-play-state:paused;animation-play-state:paused;background-color:inherit;bottom:0;height:inherit;left:0;position:absolute;right:auto;top:0;width:auto;will-change:left,right}.v-progress-linear .v-progress-linear__indeterminate--active .long{-webkit-animation-name:indeterminate-ltr;animation-name:indeterminate-ltr;-webkit-animation-duration:2.2s;animation-duration:2.2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear .v-progress-linear__indeterminate--active .short{-webkit-animation-name:indeterminate-short-ltr;animation-name:indeterminate-short-ltr;-webkit-animation-duration:2.2s;animation-duration:2.2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear--reverse .v-progress-linear__indeterminate .long,.v-progress-linear--reverse .v-progress-linear__indeterminate .short{left:auto;right:0}.v-progress-linear--reverse .v-progress-linear__indeterminate--active .long{-webkit-animation-name:indeterminate-rtl;animation-name:indeterminate-rtl}.v-progress-linear--reverse .v-progress-linear__indeterminate--active .short{-webkit-animation-name:indeterminate-short-rtl;animation-name:indeterminate-short-rtl}.v-progress-linear__stream{-webkit-animation:stream-ltr .25s linear infinite;animation:stream-ltr .25s linear infinite;-webkit-animation-play-state:paused;animation-play-state:paused;border-color:currentColor;border-top:4px dotted;bottom:0;left:auto;right:-8px;opacity:.3;pointer-events:none;position:absolute;top:calc(50% - 2px);transition:inherit}.v-progress-linear--reverse .v-progress-linear__stream{-webkit-animation:stream-rtl .25s linear infinite;animation:stream-rtl .25s linear infinite;left:-8px;right:auto}.v-progress-linear__wrapper{overflow:hidden;position:relative;transition:inherit}.v-progress-linear--absolute,.v-progress-linear--fixed{left:0;z-index:1}.v-progress-linear--absolute{position:absolute}.v-progress-linear--fixed{position:fixed}.v-progress-linear--reactive .v-progress-linear__content{pointer-events:none}.v-progress-linear--rounded{border-radius:4px}.v-progress-linear--striped .v-progress-linear__determinate{background-image:linear-gradient(135deg,hsla(0,0%,100%,.25) 25%,transparent 0,transparent 50%,hsla(0,0%,100%,.25) 0,hsla(0,0%,100%,.25) 75%,transparent 0,transparent);background-size:40px 40px;background-repeat:repeat}.v-progress-linear--query .v-progress-linear__indeterminate--active .long{-webkit-animation-name:query-ltr;animation-name:query-ltr;-webkit-animation-duration:2s;animation-duration:2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear--query .v-progress-linear__indeterminate--active .short{-webkit-animation-name:query-short-ltr;animation-name:query-short-ltr;-webkit-animation-duration:2s;animation-duration:2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear--query.v-progress-linear--reverse .v-progress-linear__indeterminate--active .long{-webkit-animation-name:query-rtl;animation-name:query-rtl}.v-progress-linear--query.v-progress-linear--reverse .v-progress-linear__indeterminate--active .short{-webkit-animation-name:query-short-rtl;animation-name:query-short-rtl}.v-progress-linear--visible .v-progress-linear__indeterminate--active .long,.v-progress-linear--visible .v-progress-linear__indeterminate--active .short,.v-progress-linear--visible .v-progress-linear__stream{-webkit-animation-play-state:running;animation-play-state:running}@-webkit-keyframes indeterminate-ltr{0%{left:-90%;right:100%}60%{left:-90%;right:100%}to{left:100%;right:-35%}}@keyframes indeterminate-ltr{0%{left:-90%;right:100%}60%{left:-90%;right:100%}to{left:100%;right:-35%}}@-webkit-keyframes indeterminate-rtl{0%{left:100%;right:-90%}60%{left:100%;right:-90%}to{left:-35%;right:100%}}@keyframes indeterminate-rtl{0%{left:100%;right:-90%}60%{left:100%;right:-90%}to{left:-35%;right:100%}}@-webkit-keyframes indeterminate-short-ltr{0%{left:-200%;right:100%}60%{left:107%;right:-8%}to{left:107%;right:-8%}}@keyframes indeterminate-short-ltr{0%{left:-200%;right:100%}60%{left:107%;right:-8%}to{left:107%;right:-8%}}@-webkit-keyframes indeterminate-short-rtl{0%{left:100%;right:-200%}60%{left:-8%;right:107%}to{left:-8%;right:107%}}@keyframes indeterminate-short-rtl{0%{left:100%;right:-200%}60%{left:-8%;right:107%}to{left:-8%;right:107%}}@-webkit-keyframes query-ltr{0%{right:-90%;left:100%}60%{right:-90%;left:100%}to{right:100%;left:-35%}}@keyframes query-ltr{0%{right:-90%;left:100%}60%{right:-90%;left:100%}to{right:100%;left:-35%}}@-webkit-keyframes query-rtl{0%{right:100%;left:-90%}60%{right:100%;left:-90%}to{right:-35%;left:100%}}@keyframes query-rtl{0%{right:100%;left:-90%}60%{right:100%;left:-90%}to{right:-35%;left:100%}}@-webkit-keyframes query-short-ltr{0%{right:-200%;left:100%}60%{right:107%;left:-8%}to{right:107%;left:-8%}}@keyframes query-short-ltr{0%{right:-200%;left:100%}60%{right:107%;left:-8%}to{right:107%;left:-8%}}@-webkit-keyframes query-short-rtl{0%{right:100%;left:-200%}60%{right:-8%;left:107%}to{right:-8%;left:107%}}@keyframes query-short-rtl{0%{right:100%;left:-200%}60%{right:-8%;left:107%}to{right:-8%;left:107%}}@-webkit-keyframes stream-ltr{to{transform:translateX(-8px)}}@keyframes stream-ltr{to{transform:translateX(-8px)}}@-webkit-keyframes stream-rtl{to{transform:translateX(8px)}}@keyframes stream-rtl{to{transform:translateX(8px)}}",""]),e.exports=n},795:function(e,t,r){"use strict";var n=r(497),o=r(83),l=r(12),c=r(9);t.a=Object(l.a)(n.a,o.a).extend({name:"v-hover",props:{disabled:{type:Boolean,default:!1},value:{type:Boolean,default:void 0}},methods:{onMouseEnter:function(){this.runDelay("open")},onMouseLeave:function(){this.runDelay("close")}},render:function(){return this.$scopedSlots.default||void 0!==this.value?(this.$scopedSlots.default&&(element=this.$scopedSlots.default({hover:this.isActive})),Array.isArray(element)&&1===element.length&&(element=element[0]),element&&!Array.isArray(element)&&element.tag?(this.disabled||(element.data=element.data||{},this._g(element.data,{mouseenter:this.onMouseEnter,mouseleave:this.onMouseLeave})),element):(Object(c.c)("v-hover should only contain a single element",this),element)):(Object(c.c)("v-hover is missing a default scopedSlot or bound value",this),null);var element}})}}]);