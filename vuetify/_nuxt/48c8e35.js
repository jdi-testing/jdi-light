(window.webpackJsonp=window.webpackJsonp||[]).push([[62],{1073:function(e,t,r){"use strict";r.r(t);var n=r(1037),o=r(1127),l=r(464),c=(r(55),{data:function(){return{value:10,bufferValue:20,interval:0}},watch:{value:function(e){e<100||(this.value=0,this.bufferValue=10,this.startBuffer())}},mounted:function(){this.startBuffer()},beforeDestroy:function(){clearInterval(this.interval)},methods:{startBuffer:function(){var e=this;clearInterval(this.interval),this.interval=setInterval((function(){e.value+=10*Math.random()+5,e.bufferValue+=10*Math.random()+6}),2e3)}}}),v=r(82),h=Object(v.a)(c,(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{"buffer-value":e.bufferValue},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"buffer-value":e.bufferValue,color:"purple"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"buffer-value":e.bufferValue,color:"red lighten-2"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"buffer-value":e.bufferValue,color:"black"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}})],1)}),[],!1,null,null,null).exports,d=Object(v.a)({},(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{"background-color":"pink lighten-3",color:"pink lighten-1",value:"15"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"background-color":"blue-grey",color:"lime",value:"30"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"background-color":"success",color:"error",value:"45"}})],1)}),[],!1,null,null,null).exports,f=Object(v.a)({},(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{indeterminate:"",color:"yellow darken-2"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{indeterminate:"",color:"green"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{indeterminate:"",color:"teal"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{indeterminate:"",color:"cyan"}})],1)}),[],!1,null,null,null).exports,m={data:function(){return{value:0,query:!1,show:!0,interval:0}},mounted:function(){this.queryAndIndeterminate()},beforeDestroy:function(){clearInterval(this.interval)},methods:{queryAndIndeterminate:function(){var e=this;this.query=!0,this.show=!0,this.value=0,setTimeout((function(){e.query=!1,e.interval=setInterval((function(){if(100===e.value)return clearInterval(e.interval),e.show=!1,setTimeout(e.queryAndIndeterminate,2e3);e.value+=25}),2e3)}),2500)}}},_=Object(v.a)(m,(function(){var e=this,t=e._self._c;return t("div",{staticStyle:{"min-height":"4px"}},[t(l.a,{attrs:{active:e.show,indeterminate:e.query,query:!0},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}})],1)}),[],!1,null,null,null).exports,y=r(458),k=Object(v.a)({},(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{color:"pink",value:"15",reverse:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"lime",indeterminate:"",reverse:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"buffer-value":"55",color:"success",reverse:"",stream:"",value:"30"}}),e._v(" "),t("br"),e._v(" "),t(y.a,[e._v("In specific cases you may want progress to display in left-to-right mode regardless of the \n      application direction (LTR or RTL):")]),e._v(" "),t(l.a,{attrs:{reverse:e.$vuetify.rtl,value:"15"}})],1)}),[],!1,null,null,null).exports,w=Object(v.a)({},(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{color:"red darken-2",rounded:"",value:"100"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"indigo",rounded:"",value:"100"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"teal",rounded:"",value:"100"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"cyan darken-2",rounded:"",value:"100"}})],1)}),[],!1,null,null,null).exports,x=Object(v.a)({},(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{color:"red lighten-2","buffer-value":"0",stream:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"teal","buffer-value":"0",value:"20",stream:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"buffer-value":"50",stream:"",color:"cyan"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{"buffer-value":"60",value:"40",stream:"",color:"orange"}})],1)}),[],!1,null,null,null).exports,O=Object(v.a)({},(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{color:"light-blue",height:"10",value:"10",striped:"",dark:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"light-green darken-4",height:"10",value:"20",striped:"",dark:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"lime",height:"10",value:"45",striped:"",dark:""}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"deep-orange",value:"60",height:"10",striped:"",dark:""}})],1)}),[],!1,null,null,null).exports,j={data:function(){return{skill:20,knowledge:33,power:78}}},P=Object(v.a)(j,(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{color:"amber",height:"25"},model:{value:e.power,callback:function(t){e.power=t},expression:"power"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"blue-grey",height:"25"},scopedSlots:e._u([{key:"default",fn:function(r){var n=r.value;return[t("strong",[e._v(e._s(Math.ceil(n))+"%")])]}}]),model:{value:e.skill,callback:function(t){e.skill=t},expression:"skill"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{height:"25"},model:{value:e.knowledge,callback:function(t){e.knowledge=t},expression:"knowledge"}},[t("strong",[e._v(e._s(Math.ceil(e.knowledge))+"%")])])],1)}),[],!1,null,null,null).exports,C={data:function(){return{valueDeterminate:50}}},B=Object(v.a)(C,(function(){var e=this,t=e._self._c;return t("div",[t(l.a,{attrs:{color:"deep-purple accent-4"},model:{value:e.valueDeterminate,callback:function(t){e.valueDeterminate=t},expression:"valueDeterminate"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"pink"},model:{value:e.valueDeterminate,callback:function(t){e.valueDeterminate=t},expression:"valueDeterminate"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"indigo darken-2"},model:{value:e.valueDeterminate,callback:function(t){e.valueDeterminate=t},expression:"valueDeterminate"}}),e._v(" "),t("br"),e._v(" "),t(l.a,{attrs:{color:"amber"},model:{value:e.valueDeterminate,callback:function(t){e.valueDeterminate=t},expression:"valueDeterminate"}})],1)}),[],!1,null,null,null).exports,D=r(596),S=r(445),z=r(437),V=r(178),$=r(465),I=r(494),E=r(467),R=r(416),T=Object(v.a)({},(function(){var e=this,t=e._self._c;return t(z.a,{staticClass:"mx-auto",attrs:{"max-width":"344"}},[t(E.a,{attrs:{color:"deep-purple accent-4",dark:"",prominent:""}},[t(D.a),e._v(" "),t(R.b,[e._v("My Files")]),e._v(" "),t(S.a,{attrs:{absolute:"",bottom:"",color:"white",fab:"",left:"",light:""}},[t(V.a,[e._v("mdi-plus")])],1),e._v(" "),t(I.a),e._v(" "),t(S.a,{attrs:{icon:""}},[t(V.a,[e._v("mdi-share-variant")])],1),e._v(" "),t(S.a,{attrs:{icon:""}},[t(V.a,[e._v("mdi-magnify")])],1),e._v(" "),t(S.a,{attrs:{icon:""}},[t(V.a,[e._v("mdi-dots-vertical")])],1)],1),e._v(" "),t(o.a,{staticStyle:{height:"400px"}},[t($.a,{staticClass:"fill-height",attrs:{"align-content":"center",justify:"center"}},[t(n.a,{staticClass:"text-subtitle-1 text-center",attrs:{cols:"12"}},[e._v("\n        Getting your files\n      ")]),e._v(" "),t(n.a,{attrs:{cols:"6"}},[t(l.a,{attrs:{color:"deep-purple accent-4",indeterminate:"",rounded:"",height:"6"}})],1)],1)],1)],1)}),[],!1,null,null,null).exports,M=r(194),L=r(570),F={data:function(){return{loading:!1}},watch:{loading:function(e){var t=this;e&&setTimeout((function(){return t.loading=!1}),3e4)}}},N={name:"ProgressLinear",components:{BufferValueProgress:h,ColorsProgress:d,IndeterminateProgress:f,QueryProgress:_,ReversedProgress:k,RoundedProgress:w,StreamProgress:x,StripedProgress:O,DefaultProgress:P,DeterminateProgress:B,FileLoaderProgress:T,ToolbarProgress:Object(v.a)(F,(function(){var e=this,t=e._self._c;return t(z.a,{staticClass:"mx-auto mt-6",attrs:{width:"344"}},[t(L.a,[t(I.a),e._v(" "),t(V.a,[e._v("mdi-square")]),e._v(" "),t(V.a,[e._v("mdi-circle")]),e._v(" "),t(V.a,[e._v("mdi-triangle")])],1),e._v(" "),t(E.a,[t(S.a,{attrs:{icon:""}},[t(V.a,[e._v("mdi-arrow-left")])],1),e._v(" "),t(R.b,[e._v("My Recipes")]),e._v(" "),t(l.a,{attrs:{active:e.loading,indeterminate:e.loading,absolute:"",bottom:"",color:"deep-purple accent-4"}}),e._v(" "),t(I.a),e._v(" "),t(S.a,{attrs:{icon:""}},[t(V.a,[e._v("mdi-magnify")])],1),e._v(" "),t(S.a,{attrs:{icon:""}},[t(V.a,[e._v("mdi-dots-vertical")])],1)],1),e._v(" "),t(o.a,{staticStyle:{height:"282px"}},[t($.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[t(M.e,[e.loading?e._e():t("div",{staticClass:"text-center"},[t(S.a,{attrs:{color:"primary"},on:{click:function(t){e.loading=!0}}},[e._v("\n            Start loading\n          ")])],1)])],1)],1)],1)}),[],!1,null,null,null).exports}},H=Object(v.a)(N,(function(){var e=this,t=e._self._c;return t(o.a,[t(n.a,[t("h1",[e._v("Progress linear")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n        The "),t("code",[e._v("v-progress-linear")]),e._v(" component will be responsive to user input when using v-model. \n        You can use the default slot or bind a local model to display inside of the progress.           \n        ")])]),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Buffer value\n        ")]),e._v(" "),t("BufferValueProgress",{attrs:{id:"BufferValueProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Colors\n        ")]),e._v(" "),t("ColorsProgress",{attrs:{id:"ColorsProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Indeterminate\n        ")]),e._v(" "),t("IndeterminateProgress",{attrs:{id:"IndeterminateProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Query\n        ")]),e._v(" "),t("QueryProgress",{attrs:{id:"QueryProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Reversed\n        ")]),e._v(" "),t("ReversedProgress",{attrs:{id:"ReversedProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Rounded\n        ")]),e._v(" "),t("RoundedProgress",{attrs:{id:"RoundedProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Stream\n        ")]),e._v(" "),t("StreamProgress",{attrs:{id:"StreamProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Striped\n        ")]),e._v(" "),t("StripedProgress",{attrs:{id:"StripedProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Default\n        ")]),e._v(" "),t("DefaultProgress",{attrs:{id:"DefaultProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Determinate\n        ")]),e._v(" "),t("DeterminateProgress",{attrs:{id:"DeterminateProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            File Loader\n        ")]),e._v(" "),t("FileLoaderProgress",{attrs:{id:"FileLoaderProgress"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Toolbar\n        ")]),e._v(" "),t("ToolbarProgress",{attrs:{id:"ToolbarProgress"}})],1)],1)}),[],!1,null,null,null);t.default=H.exports},415:function(e,t,r){"use strict";var n=r(157);t.a=n.a},455:function(e,t,r){"use strict";r(42);var n=r(1),o=r(463);t.a=n.a.extend().extend({name:"loadable",props:{loading:{type:[Boolean,String],default:!1},loaderHeight:{type:[Number,String],default:2}},methods:{genProgress:function(){return!1===this.loading?null:this.$slots.progress||this.$createElement(o.a,{props:{absolute:!0,color:!0===this.loading||""===this.loading?this.color||"primary":this.loading,height:this.loaderHeight,indeterminate:!0}})}}})},458:function(e,t,r){"use strict";r(16),r(11),r(15),r(5),r(19),r(10),r(20);var n=r(3),o=(r(460),r(35)),l=r(12);function c(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(object);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,r)}return t}function v(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?c(Object(source),!0).forEach((function(t){Object(n.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):c(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}t.a=Object(l.a)(o.a).extend({name:"v-subheader",props:{inset:Boolean},render:function(e){return e("div",{staticClass:"v-subheader",class:v({"v-subheader--inset":this.inset},this.themeClasses),attrs:this.$attrs,on:this.$listeners},this.$slots.default)}})},460:function(e,t,r){var content=r(461);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,r(27).default)("e8b41e5e",content,!0,{sourceMap:!1})},461:function(e,t,r){var n=r(26)(!1);n.push([e.i,".theme--light.v-subheader{color:rgba(0,0,0,.6)}.theme--dark.v-subheader{color:hsla(0,0%,100%,.7)}.v-subheader{align-items:center;display:flex;height:48px;font-size:.875rem;font-weight:400;padding:0 16px}.v-subheader--inset{margin-left:56px}",""]),e.exports=n},463:function(e,t,r){"use strict";var n=r(464);t.a=n.a},464:function(e,t,r){"use strict";r(16),r(11),r(15),r(5),r(19),r(10),r(20);var n=r(3),o=(r(42),r(277),r(480),r(194)),l=r(197),c=r(36),v=r(196),h=r(209),d=r(35),f=r(2),m=r(12);function _(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(object);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,r)}return t}var y=Object(m.a)(c.a,Object(v.b)(["absolute","fixed","top","bottom"]),h.a,d.a);t.a=y.extend({name:"v-progress-linear",directives:{intersect:l.a},props:{active:{type:Boolean,default:!0},backgroundColor:{type:String,default:null},backgroundOpacity:{type:[Number,String],default:null},bufferValue:{type:[Number,String],default:100},color:{type:String,default:"primary"},height:{type:[Number,String],default:4},indeterminate:Boolean,query:Boolean,reverse:Boolean,rounded:Boolean,stream:Boolean,striped:Boolean,value:{type:[Number,String],default:0}},data:function(){return{internalLazyValue:this.value||0,isVisible:!0}},computed:{__cachedBackground:function(){return this.$createElement("div",this.setBackgroundColor(this.backgroundColor||this.color,{staticClass:"v-progress-linear__background",style:this.backgroundStyle}))},__cachedBar:function(){return this.$createElement(this.computedTransition,[this.__cachedBarType])},__cachedBarType:function(){return this.indeterminate?this.__cachedIndeterminate:this.__cachedDeterminate},__cachedBuffer:function(){return this.$createElement("div",{staticClass:"v-progress-linear__buffer",style:this.styles})},__cachedDeterminate:function(){return this.$createElement("div",this.setBackgroundColor(this.color,{staticClass:"v-progress-linear__determinate",style:{width:Object(f.i)(this.normalizedValue,"%")}}))},__cachedIndeterminate:function(){return this.$createElement("div",{staticClass:"v-progress-linear__indeterminate",class:{"v-progress-linear__indeterminate--active":this.active}},[this.genProgressBar("long"),this.genProgressBar("short")])},__cachedStream:function(){return this.stream?this.$createElement("div",this.setTextColor(this.color,{staticClass:"v-progress-linear__stream",style:{width:Object(f.i)(100-this.normalizedBuffer,"%")}})):null},backgroundStyle:function(){var e;return e={opacity:null==this.backgroundOpacity?this.backgroundColor?1:.3:parseFloat(this.backgroundOpacity)},Object(n.a)(e,this.isReversed?"right":"left",Object(f.i)(this.normalizedValue,"%")),Object(n.a)(e,"width",Object(f.i)(Math.max(0,this.normalizedBuffer-this.normalizedValue),"%")),e},classes:function(){return function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?_(Object(source),!0).forEach((function(t){Object(n.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):_(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({"v-progress-linear--absolute":this.absolute,"v-progress-linear--fixed":this.fixed,"v-progress-linear--query":this.query,"v-progress-linear--reactive":this.reactive,"v-progress-linear--reverse":this.isReversed,"v-progress-linear--rounded":this.rounded,"v-progress-linear--striped":this.striped,"v-progress-linear--visible":this.isVisible},this.themeClasses)},computedTransition:function(){return this.indeterminate?o.d:o.i},isReversed:function(){return this.$vuetify.rtl!==this.reverse},normalizedBuffer:function(){return this.normalize(this.bufferValue)},normalizedValue:function(){return this.normalize(this.internalLazyValue)},reactive:function(){return Boolean(this.$listeners.change)},styles:function(){var e={};return this.active||(e.height=0),this.indeterminate||100===parseFloat(this.normalizedBuffer)||(e.width=Object(f.i)(this.normalizedBuffer,"%")),e}},methods:{genContent:function(){var slot=Object(f.u)(this,"default",{value:this.internalLazyValue});return slot?this.$createElement("div",{staticClass:"v-progress-linear__content"},slot):null},genListeners:function(){var e=this.$listeners;return this.reactive&&(e.click=this.onClick),e},genProgressBar:function(e){return this.$createElement("div",this.setBackgroundColor(this.color,{staticClass:"v-progress-linear__indeterminate",class:Object(n.a)({},e,!0)}))},onClick:function(e){if(this.reactive){var t=this.$el.getBoundingClientRect().width;this.internalValue=e.offsetX/t*100}},onObserve:function(e,t,r){this.isVisible=r},normalize:function(e){return e<0?0:e>100?100:parseFloat(e)}},render:function(e){return e("div",{staticClass:"v-progress-linear",attrs:{role:"progressbar","aria-valuemin":0,"aria-valuemax":this.normalizedBuffer,"aria-valuenow":this.indeterminate?void 0:this.normalizedValue},class:this.classes,directives:[{name:"intersect",value:this.onObserve}],style:{bottom:this.bottom?0:void 0,height:this.active?Object(f.i)(this.height):0,top:this.top?0:void 0},on:this.genListeners()},[this.__cachedStream,this.__cachedBackground,this.__cachedBuffer,this.__cachedBar,this.genContent()])}})},480:function(e,t,r){var content=r(481);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,r(27).default)("cf87dc84",content,!0,{sourceMap:!1})},481:function(e,t,r){var n=r(26)(!1);n.push([e.i,".theme--light.v-progress-linear{color:rgba(0,0,0,.87)}.theme--dark.v-progress-linear{color:#fff}.v-progress-linear{background:transparent;overflow:hidden;position:relative;transition:.2s cubic-bezier(.4,0,.6,1);width:100%}.v-progress-linear__buffer{height:inherit;left:0;position:absolute;top:0;transition:inherit;width:100%}.v-progress-linear--reverse .v-progress-linear__buffer{left:auto;right:0}.v-progress-linear__background{bottom:0;left:0;position:absolute;top:0;transition:inherit}.v-progress-linear--reverse .v-progress-linear__background{left:auto;right:0}.v-progress-linear__content{align-items:center;display:flex;height:100%;left:0;justify-content:center;position:absolute;top:0;width:100%}.v-progress-linear--reverse .v-progress-linear__content{left:auto;right:0}.v-progress-linear__determinate{height:inherit;left:0;position:absolute;transition:inherit}.v-progress-linear--reverse .v-progress-linear__determinate{left:auto;right:0}.v-progress-linear .v-progress-linear__indeterminate .long,.v-progress-linear .v-progress-linear__indeterminate .short{-webkit-animation-play-state:paused;animation-play-state:paused;background-color:inherit;bottom:0;height:inherit;left:0;position:absolute;right:auto;top:0;width:auto;will-change:left,right}.v-progress-linear .v-progress-linear__indeterminate--active .long{-webkit-animation-name:indeterminate-ltr;animation-name:indeterminate-ltr;-webkit-animation-duration:2.2s;animation-duration:2.2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear .v-progress-linear__indeterminate--active .short{-webkit-animation-name:indeterminate-short-ltr;animation-name:indeterminate-short-ltr;-webkit-animation-duration:2.2s;animation-duration:2.2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear--reverse .v-progress-linear__indeterminate .long,.v-progress-linear--reverse .v-progress-linear__indeterminate .short{left:auto;right:0}.v-progress-linear--reverse .v-progress-linear__indeterminate--active .long{-webkit-animation-name:indeterminate-rtl;animation-name:indeterminate-rtl}.v-progress-linear--reverse .v-progress-linear__indeterminate--active .short{-webkit-animation-name:indeterminate-short-rtl;animation-name:indeterminate-short-rtl}.v-progress-linear__stream{-webkit-animation:stream-ltr .25s linear infinite;animation:stream-ltr .25s linear infinite;-webkit-animation-play-state:paused;animation-play-state:paused;border-color:currentColor;border-top:4px dotted;bottom:0;left:auto;right:-8px;opacity:.3;pointer-events:none;position:absolute;top:calc(50% - 2px);transition:inherit}.v-progress-linear--reverse .v-progress-linear__stream{-webkit-animation:stream-rtl .25s linear infinite;animation:stream-rtl .25s linear infinite;left:-8px;right:auto}.v-progress-linear__wrapper{overflow:hidden;position:relative;transition:inherit}.v-progress-linear--absolute,.v-progress-linear--fixed{left:0;z-index:1}.v-progress-linear--absolute{position:absolute}.v-progress-linear--fixed{position:fixed}.v-progress-linear--reactive .v-progress-linear__content{pointer-events:none}.v-progress-linear--rounded{border-radius:4px}.v-progress-linear--striped .v-progress-linear__determinate{background-image:linear-gradient(135deg,hsla(0,0%,100%,.25) 25%,transparent 0,transparent 50%,hsla(0,0%,100%,.25) 0,hsla(0,0%,100%,.25) 75%,transparent 0,transparent);background-size:40px 40px;background-repeat:repeat}.v-progress-linear--query .v-progress-linear__indeterminate--active .long{-webkit-animation-name:query-ltr;animation-name:query-ltr;-webkit-animation-duration:2s;animation-duration:2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear--query .v-progress-linear__indeterminate--active .short{-webkit-animation-name:query-short-ltr;animation-name:query-short-ltr;-webkit-animation-duration:2s;animation-duration:2s;-webkit-animation-iteration-count:infinite;animation-iteration-count:infinite}.v-progress-linear--query.v-progress-linear--reverse .v-progress-linear__indeterminate--active .long{-webkit-animation-name:query-rtl;animation-name:query-rtl}.v-progress-linear--query.v-progress-linear--reverse .v-progress-linear__indeterminate--active .short{-webkit-animation-name:query-short-rtl;animation-name:query-short-rtl}.v-progress-linear--visible .v-progress-linear__indeterminate--active .long,.v-progress-linear--visible .v-progress-linear__indeterminate--active .short,.v-progress-linear--visible .v-progress-linear__stream{-webkit-animation-play-state:running;animation-play-state:running}@-webkit-keyframes indeterminate-ltr{0%{left:-90%;right:100%}60%{left:-90%;right:100%}to{left:100%;right:-35%}}@keyframes indeterminate-ltr{0%{left:-90%;right:100%}60%{left:-90%;right:100%}to{left:100%;right:-35%}}@-webkit-keyframes indeterminate-rtl{0%{left:100%;right:-90%}60%{left:100%;right:-90%}to{left:-35%;right:100%}}@keyframes indeterminate-rtl{0%{left:100%;right:-90%}60%{left:100%;right:-90%}to{left:-35%;right:100%}}@-webkit-keyframes indeterminate-short-ltr{0%{left:-200%;right:100%}60%{left:107%;right:-8%}to{left:107%;right:-8%}}@keyframes indeterminate-short-ltr{0%{left:-200%;right:100%}60%{left:107%;right:-8%}to{left:107%;right:-8%}}@-webkit-keyframes indeterminate-short-rtl{0%{left:100%;right:-200%}60%{left:-8%;right:107%}to{left:-8%;right:107%}}@keyframes indeterminate-short-rtl{0%{left:100%;right:-200%}60%{left:-8%;right:107%}to{left:-8%;right:107%}}@-webkit-keyframes query-ltr{0%{right:-90%;left:100%}60%{right:-90%;left:100%}to{right:100%;left:-35%}}@keyframes query-ltr{0%{right:-90%;left:100%}60%{right:-90%;left:100%}to{right:100%;left:-35%}}@-webkit-keyframes query-rtl{0%{right:100%;left:-90%}60%{right:100%;left:-90%}to{right:-35%;left:100%}}@keyframes query-rtl{0%{right:100%;left:-90%}60%{right:100%;left:-90%}to{right:-35%;left:100%}}@-webkit-keyframes query-short-ltr{0%{right:-200%;left:100%}60%{right:107%;left:-8%}to{right:107%;left:-8%}}@keyframes query-short-ltr{0%{right:-200%;left:100%}60%{right:107%;left:-8%}to{right:107%;left:-8%}}@-webkit-keyframes query-short-rtl{0%{right:100%;left:-200%}60%{right:-8%;left:107%}to{right:-8%;left:107%}}@keyframes query-short-rtl{0%{right:100%;left:-200%}60%{right:-8%;left:107%}to{right:-8%;left:107%}}@-webkit-keyframes stream-ltr{to{transform:translateX(-8px)}}@keyframes stream-ltr{to{transform:translateX(-8px)}}@-webkit-keyframes stream-rtl{to{transform:translateX(8px)}}@keyframes stream-rtl{to{transform:translateX(8px)}}",""]),e.exports=n},525:function(e,t,r){var content=r(526);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,r(27).default)("dd2325f0",content,!0,{sourceMap:!1})},526:function(e,t,r){var n=r(26)(!1);n.push([e.i,".theme--light.v-system-bar{background-color:#e0e0e0;color:rgba(0,0,0,.6)}.theme--light.v-system-bar .v-icon{color:rgba(0,0,0,.6)}.theme--light.v-system-bar--lights-out{background-color:hsla(0,0%,100%,.7)!important}.theme--dark.v-system-bar{background-color:#000;color:hsla(0,0%,100%,.7)}.theme--dark.v-system-bar .v-icon{color:hsla(0,0%,100%,.7)}.theme--dark.v-system-bar--lights-out{background-color:rgba(0,0,0,.2)!important}.v-system-bar{align-items:center;display:flex;font-size:.875rem;font-weight:400;padding:0 8px}.v-system-bar .v-icon{font-size:1rem;margin-right:4px}.v-system-bar--absolute,.v-system-bar--fixed{left:0;top:0;width:100%;z-index:3}.v-system-bar--fixed{position:fixed}.v-system-bar--absolute{position:absolute}.v-system-bar--window .v-icon{font-size:1.25rem;margin-right:8px}",""]),e.exports=n},570:function(e,t,r){"use strict";r(16),r(11),r(15),r(5),r(19),r(10),r(20);var n=r(3),o=(r(42),r(277),r(525),r(213)),l=r(36),c=r(35),v=r(12),h=r(2);function d(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(object);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,r)}return t}t.a=Object(v.a)(Object(o.a)("bar",["height","window"]),l.a,c.a).extend({name:"v-system-bar",props:{height:[Number,String],lightsOut:Boolean,window:Boolean},computed:{classes:function(){return function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?d(Object(source),!0).forEach((function(t){Object(n.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):d(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({"v-system-bar--lights-out":this.lightsOut,"v-system-bar--absolute":this.absolute,"v-system-bar--fixed":!this.absolute&&(this.app||this.fixed),"v-system-bar--window":this.window},this.themeClasses)},computedHeight:function(){return this.height?isNaN(parseInt(this.height))?this.height:parseInt(this.height):this.window?32:24},styles:function(){return{height:Object(h.i)(this.computedHeight)}}},methods:{updateApplication:function(){return this.$el?this.$el.clientHeight:this.computedHeight}},render:function(e){var data={staticClass:"v-system-bar",class:this.classes,style:this.styles,on:this.$listeners};return e("div",this.setBackgroundColor(this.color,data),Object(h.u)(this))}})}}]);