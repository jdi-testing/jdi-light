(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-db4f0ca2"],{"0160":function(t,e,i){},"0798":function(t,e,i){"use strict";var s=i("5530"),a=i("ade3"),n=(i("caad"),i("0c18"),i("10d2")),o=i("afdd"),r=i("9d26"),l=i("f2e7"),c=i("7560"),u=i("f40d"),d=i("58df"),v=i("d9bd");e["a"]=Object(d["a"])(n["a"],l["a"],u["a"]).extend({name:"v-alert",props:{border:{type:String,validator:function(t){return["top","right","bottom","left"].includes(t)}},closeLabel:{type:String,default:"$vuetify.close"},coloredBorder:Boolean,dense:Boolean,dismissible:Boolean,closeIcon:{type:String,default:"$cancel"},icon:{default:"",type:[Boolean,String],validator:function(t){return"string"===typeof t||!1===t}},outlined:Boolean,prominent:Boolean,text:Boolean,type:{type:String,validator:function(t){return["info","error","success","warning"].includes(t)}},value:{type:Boolean,default:!0}},computed:{__cachedBorder:function(){if(!this.border)return null;var t={staticClass:"v-alert__border",class:Object(a["a"])({},"v-alert__border--".concat(this.border),!0)};return this.coloredBorder&&(t=this.setBackgroundColor(this.computedColor,t),t.class["v-alert__border--has-color"]=!0),this.$createElement("div",t)},__cachedDismissible:function(){var t=this;if(!this.dismissible)return null;var e=this.iconColor;return this.$createElement(o["a"],{staticClass:"v-alert__dismissible",props:{color:e,icon:!0,small:!0},attrs:{"aria-label":this.$vuetify.lang.t(this.closeLabel)},on:{click:function(){return t.isActive=!1}}},[this.$createElement(r["a"],{props:{color:e}},this.closeIcon)])},__cachedIcon:function(){return this.computedIcon?this.$createElement(r["a"],{staticClass:"v-alert__icon",props:{color:this.iconColor}},this.computedIcon):null},classes:function(){var t=Object(s["a"])(Object(s["a"])({},n["a"].options.computed.classes.call(this)),{},{"v-alert--border":Boolean(this.border),"v-alert--dense":this.dense,"v-alert--outlined":this.outlined,"v-alert--prominent":this.prominent,"v-alert--text":this.text});return this.border&&(t["v-alert--border-".concat(this.border)]=!0),t},computedColor:function(){return this.color||this.type},computedIcon:function(){return!1!==this.icon&&("string"===typeof this.icon&&this.icon?this.icon:!!["error","info","success","warning"].includes(this.type)&&"$".concat(this.type))},hasColoredIcon:function(){return this.hasText||Boolean(this.border)&&this.coloredBorder},hasText:function(){return this.text||this.outlined},iconColor:function(){return this.hasColoredIcon?this.computedColor:void 0},isDark:function(){return!(!this.type||this.coloredBorder||this.outlined)||c["a"].options.computed.isDark.call(this)}},created:function(){this.$attrs.hasOwnProperty("outline")&&Object(v["a"])("outline","outlined",this)},methods:{genWrapper:function(){var t=[this.$slots.prepend||this.__cachedIcon,this.genContent(),this.__cachedBorder,this.$slots.append,this.$scopedSlots.close?this.$scopedSlots.close({toggle:this.toggle}):this.__cachedDismissible],e={staticClass:"v-alert__wrapper"};return this.$createElement("div",e,t)},genContent:function(){return this.$createElement("div",{staticClass:"v-alert__content"},this.$slots.default)},genAlert:function(){var t={staticClass:"v-alert",attrs:{role:"alert"},on:this.listeners$,class:this.classes,style:this.styles,directives:[{name:"show",value:this.isActive}]};if(!this.coloredBorder){var e=this.hasText?this.setTextColor:this.setBackgroundColor;t=e(this.computedColor,t)}return this.$createElement("div",t,[this.genWrapper()])},toggle:function(){this.isActive=!this.isActive}},render:function(t){var e=this.genAlert();return this.transition?t("transition",{props:{name:this.transition,origin:this.origin,mode:this.mode}},[e]):e}})},"0c18":function(t,e,i){},"2fa4":function(t,e,i){"use strict";i("20f6");var s=i("80d2");e["a"]=Object(s["h"])("spacer","div","v-spacer")},5311:function(t,e,i){"use strict";var s=i("5607"),a=i("2b0e");e["a"]=a["a"].extend({name:"rippleable",directives:{ripple:s["a"]},props:{ripple:{type:[Boolean,Object],default:!0}},methods:{genRipple:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};return this.ripple?(t.staticClass="v-input--selection-controls__ripple",t.directives=t.directives||[],t.directives.push({name:"ripple",value:{center:!0}}),this.$createElement("div",t)):null}}})},"615b":function(t,e,i){},8547:function(t,e,i){"use strict";var s=i("2b0e"),a=i("80d2");e["a"]=s["a"].extend({name:"comparable",props:{valueComparator:{type:Function,default:a["i"]}}})},"8adc":function(t,e,i){},9373:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("v-col",[i("h1",[t._v("Timelines")])]),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Color timeline ")]),i("ColorTimeline",{attrs:{id:"ColorTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Dense timeline ")]),i("DenseTimeline",{attrs:{id:"DenseTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Icon dots timeline ")]),i("IconDotsTimeline",{attrs:{id:"IconDotsTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Reverse timeline ")]),i("ReverseTimeline",{attrs:{id:"ReverseTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Small timeline ")]),i("SmallTimeline",{attrs:{id:"SmallTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Icon timeline ")]),i("IconTimeline",{attrs:{id:"IconTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Opposite timeline ")]),i("OppositeTimeline",{attrs:{id:"OppositeTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Timeline item default timeline ")]),i("TimelineItemDefaultTimeline",{attrs:{id:"TimelineItemDefaultTimeline"}})],1),i("v-col",[i("p",{staticClass:"text-h5"},[t._v(" Advanced timeline ")]),i("AdvancedTimeline",{attrs:{id:"AdvancedTimeline"}})],1)],1)},a=[],n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-card",{staticClass:"mx-auto",attrs:{"max-width":"400"}},[i("v-card",{attrs:{dark:"",flat:""}},[i("v-btn",{attrs:{absolute:"",bottom:"",color:"pink",right:"",fab:""}},[i("v-icon",[t._v("mdi-plus")])],1),i("v-card-title",{staticClass:"pa-2 purple lighten-3"},[i("v-btn",{attrs:{icon:""}},[i("v-icon",[t._v("mdi-menu")])],1),i("h3",{staticClass:"text-h6 font-weight-light text-center grow"},[t._v(" Timeline ")]),i("v-avatar",[i("v-img",{attrs:{src:"https://avataaars.io/?avatarStyle=Circle&topType=LongHairStraight&\n        accessoriesType=Blank&hairColor=BrownDark&facialHairType=Blank&clotheType=BlazerShirt&\n        eyeType=Default&eyebrowType=Default&mouthType=Default&skinColor=Light"}})],1)],1),i("v-img",{attrs:{src:"https://cdn.vuetifyjs.com/images/cards/forest.jpg",gradient:"to top, rgba(0,0,0,.44), rgba(0,0,0,.44)"}},[i("v-container",{staticClass:"fill-height"},[i("v-row",{attrs:{align:"center"}},[i("strong",{staticClass:"text-h1 font-weight-regular mr-6"},[t._v("8")]),i("v-row",{attrs:{justify:"end"}},[i("div",{staticClass:"text-h5 font-weight-light"},[t._v(" Monday ")]),i("div",{staticClass:"text-uppercase font-weight-light"},[t._v(" February 2015 ")])])],1)],1)],1)],1),i("v-card-text",{staticClass:"py-0"},[i("v-timeline",{attrs:{"align-top":"",dense:""}},[i("v-timeline-item",{attrs:{color:"pink",small:""}},[i("v-row",{staticClass:"pt-1"},[i("v-col",{attrs:{cols:"3"}},[i("strong",[t._v("5pm")])]),i("v-col",[i("strong",[t._v("New Icon")]),i("div",{staticClass:"text-caption"},[t._v(" Mobile App ")])])],1)],1),i("v-timeline-item",{attrs:{color:"teal lighten-3",small:""}},[i("v-row",{staticClass:"pt-1"},[i("v-col",{attrs:{cols:"3"}},[i("strong",[t._v("3-4pm")])]),i("v-col",[i("strong",[t._v("Design Stand Up")]),i("div",{staticClass:"text-caption mb-2"},[t._v(" Hangouts ")]),i("v-avatar",[i("v-img",{attrs:{src:"https://avataaars.io/?avatarStyle=Circle&topType=LongHairFrida&accessoriesType=Kurt&\n                hairColor=Red&facialHairType=BeardLight&facialHairColor=BrownDark&clotheType=GraphicShirt&\n                clotheColor=Gray01&graphicType=Skull&eyeType=Wink&eyebrowType=RaisedExcitedNatural&\n                mouthType=Disbelief&skinColor=Brown"}})],1),i("v-avatar",[i("v-img",{attrs:{src:"https://avataaars.io/?avatarStyle=Circle&topType=ShortHairFrizzle&accessoriesType=Prescription02&\n                hairColor=Black&facialHairType=MoustacheMagnum&facialHairColor=BrownDark&clotheType=BlazerSweater&\n                clotheColor=Black&eyeType=Default&eyebrowType=FlatNatural&mouthType=Default&skinColor=Tanned"}})],1),i("v-avatar",[i("v-img",{attrs:{src:"https://avataaars.io/?avatarStyle=Circle&topType=LongHairMiaWallace&accessoriesType=Sunglasses&\n                hairColor=BlondeGolden&facialHairType=Blank&clotheType=BlazerSweater&eyeType=Surprised&\n                eyebrowType=RaisedExcited&mouthType=Smile&skinColor=Pale"}})],1)],1)],1)],1),i("v-timeline-item",{attrs:{color:"pink",small:""}},[i("v-row",{staticClass:"pt-1"},[i("v-col",{attrs:{cols:"3"}},[i("strong",[t._v("12pm")])]),i("v-col",[i("strong",[t._v("Lunch break")])])],1)],1),i("v-timeline-item",{attrs:{color:"teal lighten-3",small:""}},[i("v-row",{staticClass:"pt-1"},[i("v-col",{attrs:{cols:"3"}},[i("strong",[t._v("9-11am")])]),i("v-col",[i("strong",[t._v("Finish Home Screen")]),i("div",{staticClass:"text-caption"},[t._v(" Web App ")])])],1)],1)],1)],1)],1)},o=[],r=i("2877"),l=i("6544"),c=i.n(l),u=i("8212"),d=i("8336"),v=i("b0af"),h=i("99d9"),m=i("62ad"),p=i("a523"),f=i("132d"),g=i("adda"),b=i("0fd9"),C=i("5530"),_=(i("0160"),i("58df")),y=i("7560"),x=Object(_["a"])(y["a"]).extend({name:"v-timeline",provide:function(){return{timeline:this}},props:{alignTop:Boolean,dense:Boolean,reverse:Boolean},computed:{classes:function(){return Object(C["a"])({"v-timeline--align-top":this.alignTop,"v-timeline--dense":this.dense,"v-timeline--reverse":this.reverse},this.themeClasses)}},render:function(t){return t("div",{staticClass:"v-timeline",class:this.classes},this.$slots.default)}}),T=(i("c96a"),i("9d26")),w=i("a9ad"),k=Object(_["a"])(w["a"],y["a"]),V=k.extend().extend({name:"v-timeline-item",inject:["timeline"],props:{color:{type:String,default:"primary"},fillDot:Boolean,hideDot:Boolean,icon:String,iconColor:String,large:Boolean,left:Boolean,right:Boolean,small:Boolean},computed:{hasIcon:function(){return!!this.icon||!!this.$slots.icon}},methods:{genBody:function(){return this.$createElement("div",{staticClass:"v-timeline-item__body"},this.$slots.default)},genIcon:function(){return this.$slots.icon?this.$slots.icon:this.$createElement(T["a"],{props:{color:this.iconColor,dark:!this.theme.isDark,small:this.small}},this.icon)},genInnerDot:function(){var t=this.setBackgroundColor(this.color);return this.$createElement("div",Object(C["a"])({staticClass:"v-timeline-item__inner-dot"},t),[this.hasIcon&&this.genIcon()])},genDot:function(){return this.$createElement("div",{staticClass:"v-timeline-item__dot",class:{"v-timeline-item__dot--small":this.small,"v-timeline-item__dot--large":this.large}},[this.genInnerDot()])},genDivider:function(){var t=[];return this.hideDot||t.push(this.genDot()),this.$createElement("div",{staticClass:"v-timeline-item__divider"},t)},genOpposite:function(){return this.$createElement("div",{staticClass:"v-timeline-item__opposite"},this.$slots.opposite)}},render:function(t){var e=[this.genBody(),this.genDivider()];return this.$slots.opposite&&e.push(this.genOpposite()),t("div",{staticClass:"v-timeline-item",class:Object(C["a"])({"v-timeline-item--fill-dot":this.fillDot,"v-timeline-item--before":this.timeline.reverse?this.right:this.left,"v-timeline-item--after":this.timeline.reverse?this.left:this.right},this.themeClasses)},e)}}),B={},S=Object(r["a"])(B,n,o,!1,null,null,null),$=S.exports;c()(S,{VAvatar:u["a"],VBtn:d["a"],VCard:v["a"],VCardText:h["c"],VCardTitle:h["d"],VCol:m["a"],VContainer:p["a"],VIcon:f["a"],VImg:g["a"],VRow:b["a"],VTimeline:x,VTimelineItem:V});var j=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-card",{staticClass:"mx-auto",attrs:{"max-width":"600"}},[i("v-card-title",{staticClass:"blue-grey white--text"},[i("span",{staticClass:"text-h6"},[t._v("Logs")]),i("v-spacer"),i("v-btn",{attrs:{outlined:null==t.interval,color:null==t.interval?"white":"primary",dark:"",depressed:""},on:{click:function(e){null==t.interval?t.start():t.stop()}}},[t._v(" Realtime Logging ")])],1),i("v-card-text",{staticClass:"py-0"},[i("v-timeline",{attrs:{dense:""}},[i("v-slide-x-reverse-transition",{attrs:{group:"","hide-on-leave":""}},t._l(t.items,(function(e){return i("v-timeline-item",{key:e.id,attrs:{color:e.color,small:"","fill-dot":""}},[i("v-alert",{staticClass:"white--text",attrs:{value:!0,color:e.color,icon:e.icon}},[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae. ")])],1)})),1)],1)],1)],1)},D=[],O=["info","warning","error","success"],E={info:"mdi-information",warning:"mdi-alert",error:"mdi-alert-circle",success:"mdi-check-circle"},I={data:function(){return{interval:null,items:[{id:1,color:"info",icon:E.info}],nonce:2}},beforeDestroy:function(){this.stop()},methods:{addEvent:function(){var t=this.genAlert(),e=t.color,i=t.icon,s=this.items[0].color;while(s===e)e=this.genColor();this.items.unshift({id:this.nonce+=1,color:e,icon:i}),this.nonce>6&&this.items.pop()},genAlert:function(){var t=this.genColor();return{color:t,icon:this.genIcon(t)}},genColor:function(){return O[Math.floor(3*Math.random())]},genIcon:function(t){return E[t]},start:function(){this.interval=setInterval(this.addEvent,3e3)},stop:function(){clearInterval(this.interval),this.interval=null}}},L=I,A=i("0798"),z=i("0789"),q=i("2fa4"),P=Object(r["a"])(L,j,D,!1,null,null,null),R=P.exports;c()(P,{VAlert:A["a"],VBtn:d["a"],VCard:v["a"],VCardText:h["c"],VCardTitle:h["d"],VSlideXReverseTransition:z["f"],VSpacer:q["a"],VTimeline:x,VTimelineItem:V});var F=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-timeline",{attrs:{"align-top":"",dense:t.$vuetify.breakpoint.smAndDown}},t._l(t.items,(function(e,s){return i("v-timeline-item",{key:s,attrs:{color:e.color,icon:e.icon,"fill-dot":""}},[i("v-card",{attrs:{color:e.color,dark:""}},[i("v-card-title",{staticClass:"text-h6"},[t._v(" Lorem Ipsum Dolor ")]),i("v-card-text",{staticClass:"white text--primary"},[i("p",[t._v("Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae.")]),i("v-btn",{staticClass:"mx-0",attrs:{color:e.color,outlined:""}},[t._v(" Button ")])],1)],1)],1)})),1)},H=[],M={data:function(){return{items:[{color:"red lighten-2",icon:"mdi-star"},{color:"purple darken-1",icon:"mdi-book-variant"},{color:"green lighten-1",icon:"mdi-airballoon"},{color:"indigo",icon:"mdi-buffer"}]}}},G=M,J=Object(r["a"])(G,F,H,!1,null,null,null),W=J.exports;c()(J,{VBtn:d["a"],VCard:v["a"],VCardText:h["c"],VCardTitle:h["d"],VTimeline:x,VTimelineItem:V});var K=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("v-switch",{attrs:{label:"Toggle reverse"},model:{value:t.reverse,callback:function(e){t.reverse=e},expression:"reverse"}}),i("v-timeline",{attrs:{reverse:t.reverse,dense:t.$vuetify.breakpoint.smAndDown}},t._l(2,(function(e){return i("v-timeline-item",{key:e},[i("span",{attrs:{slot:"opposite"},slot:"opposite"},[t._v("Tus eu perfecto")]),i("v-card",{staticClass:"elevation-2"},[i("v-card-title",{staticClass:"text-h5"},[t._v(" Lorem ipsum ")]),i("v-card-text",[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae. ")])],1)],1)})),1),i("v-timeline",{attrs:{reverse:t.reverse,dense:""}},t._l(2,(function(e){return i("v-timeline-item",{key:e},[i("span",{attrs:{slot:"opposite"},slot:"opposite"},[t._v("Tus eu perfecto")]),i("v-card",{staticClass:"elevation-2"},[i("v-card-title",{staticClass:"text-h5"},[t._v(" Lorem ipsum ")]),i("v-card-text",[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae. ")])],1)],1)})),1)],1)},N=[],U={data:function(){return{reverse:!0}}},X=U,Y=i("b73d"),Q=Object(r["a"])(X,K,N,!1,null,null,null),Z=Q.exports;c()(Q,{VCard:v["a"],VCardText:h["c"],VCardTitle:h["d"],VSwitch:Y["a"],VTimeline:x,VTimelineItem:V});var tt=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-timeline",{attrs:{dense:t.$vuetify.breakpoint.smAndDown}},[i("v-timeline-item",{attrs:{color:"purple lighten-2","fill-dot":"",right:""}},[i("v-card",[i("v-card-title",{staticClass:"purple lighten-2"},[i("v-icon",{staticClass:"mr-4",attrs:{dark:"",size:"42"}},[t._v(" mdi-magnify ")]),i("h2",{staticClass:"text-h4 white--text font-weight-light"},[t._v(" Title 1 ")])],1),i("v-container",[i("v-row",[i("v-col",{attrs:{cols:"12",md:"10"}},[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit. ")]),i("v-col",{staticClass:"hidden-sm-and-down text-right",attrs:{md:"2"}},[i("v-icon",{attrs:{size:"64"}},[t._v(" mdi-calendar-text ")])],1)],1)],1)],1)],1),i("v-timeline-item",{attrs:{color:"amber lighten-1","fill-dot":"",left:"",small:""}},[i("v-card",[i("v-card-title",{staticClass:"amber lighten-1 justify-end"},[i("h2",{staticClass:"text-h4 mr-4 white--text font-weight-light"},[t._v(" Title 2 ")]),i("v-icon",{attrs:{dark:"",size:"42"}},[t._v(" mdi-home-outline ")])],1),i("v-container",[i("v-row",[i("v-col",{attrs:{cols:"12",md:"8"}},[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit. ")]),i("v-col",{attrs:{cols:"12",md:"4"}},[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. ")])],1)],1)],1)],1),i("v-timeline-item",{attrs:{color:"cyan lighten-1","fill-dot":"",right:""}},[i("v-card",[i("v-card-title",{staticClass:"cyan lighten-1"},[i("v-icon",{staticClass:"mr-4",attrs:{dark:"",size:"42"}},[t._v(" mdi-email-outline ")]),i("h2",{staticClass:"text-h4 white--text font-weight-light"},[t._v(" Title 3 ")])],1),i("v-container",[i("v-row",t._l(3,(function(e){return i("v-col",{key:e,attrs:{cols:"12",md:"4"}},[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus no nam oblique. ")])})),1)],1)],1)],1),i("v-timeline-item",{attrs:{color:"red lighten-1","fill-dot":"",left:"",small:""}},[i("v-card",[i("v-card-title",{staticClass:"red lighten-1 justify-end"},[i("h2",{staticClass:"text-h4 mr-4 white--text font-weight-light"},[t._v(" Title 4 ")]),i("v-icon",{attrs:{dark:"",size:"42"}},[t._v(" mdi-account-multiple-outline ")])],1),i("v-container",[i("v-row",[i("v-col",{staticClass:"hidden-sm-and-down",attrs:{md:"2"}},[i("v-icon",{attrs:{size:"64"}},[t._v(" mdi-server-network ")])],1),i("v-col",{attrs:{cols:"12",md:"10"}},[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus. ")])],1)],1)],1)],1),i("v-timeline-item",{attrs:{color:"green lighten-1","fill-dot":"",right:""}},[i("v-card",[i("v-card-title",{staticClass:"green lighten-1"},[i("v-icon",{staticClass:"mr-4",attrs:{dark:"",size:"42"}},[t._v(" mdi-phone-in-talk ")]),i("h2",{staticClass:"text-h4 white--text font-weight-light"},[t._v(" Title 5 ")])],1),i("v-container",[i("v-row",[i("v-col",[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae. ")])],1)],1)],1)],1)],1)},et=[],it={},st=Object(r["a"])(it,tt,et,!1,null,null,null),at=st.exports;c()(st,{VCard:v["a"],VCardTitle:h["d"],VCol:m["a"],VContainer:p["a"],VIcon:f["a"],VRow:b["a"],VTimeline:x,VTimelineItem:V});var nt=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-timeline",t._l(4,(function(e){return i("v-timeline-item",{key:e,attrs:{large:""},scopedSlots:t._u([{key:"icon",fn:function(){return[i("v-avatar",[i("img",{attrs:{src:"https://i.pravatar.cc/64"}})])]},proxy:!0},{key:"opposite",fn:function(){return[i("span",[t._v("Tus eu perfecto")])]},proxy:!0}],null,!0)},[i("v-card",{staticClass:"elevation-2"},[i("v-card-title",{staticClass:"text-h5"},[t._v(" Lorem ipsum ")]),i("v-card-text",[t._v("Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae.")])],1)],1)})),1)},ot=[],rt={},lt=Object(r["a"])(rt,nt,ot,!1,null,null,null),ct=lt.exports;c()(lt,{VAvatar:u["a"],VCard:v["a"],VCardText:h["c"],VCardTitle:h["d"],VTimeline:x,VTimelineItem:V});var ut=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-timeline",t._l(t.years,(function(e,s){return i("v-timeline-item",{key:s,attrs:{color:e.color,small:""},scopedSlots:t._u([{key:"opposite",fn:function(){return[i("span",{class:"headline font-weight-bold "+e.color+"--text",domProps:{textContent:t._s(e.year)}})]},proxy:!0}],null,!0)},[i("div",{staticClass:"py-4"},[i("h2",{class:"headline font-weight-light mb-4 "+e.color+"--text"},[t._v(" Lorem ipsum ")]),i("div",[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae. ")])])])})),1)},dt=[],vt={data:function(){return{years:[{color:"cyan",year:"1960"},{color:"green",year:"1970"},{color:"pink",year:"1980"},{color:"amber",year:"1990"},{color:"orange",year:"2000"}]}}},ht=vt,mt=Object(r["a"])(ht,ut,dt,!1,null,null,null),pt=mt.exports;c()(mt,{VTimeline:x,VTimelineItem:V});var ft=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-timeline",t._l(3,(function(e){return i("v-timeline-item",{key:e,attrs:{color:"red lighten-2",large:""},scopedSlots:t._u([{key:"opposite",fn:function(){return[i("span",[t._v("Tus eu perfecto")])]},proxy:!0}],null,!0)},[i("v-card",{staticClass:"elevation-2"},[i("v-card-title",{staticClass:"text-h5"},[t._v(" Lorem ipsum ")]),i("v-card-text",[t._v(" Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae. ")])],1)],1)})),1)},gt=[],bt={},Ct=Object(r["a"])(bt,ft,gt,!1,null,null,null),_t=Ct.exports;c()(Ct,{VCard:v["a"],VCardText:h["c"],VCardTitle:h["d"],VTimeline:x,VTimelineItem:V});var yt=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",{staticStyle:{"max-width":"600px"}},[i("v-timeline",{attrs:{dense:"",clipped:""}},[i("v-timeline-item",{staticClass:"white--text mb-12",attrs:{"fill-dot":"",color:"orange",large:""},scopedSlots:t._u([{key:"icon",fn:function(){return[i("span",[t._v("JL")])]},proxy:!0}])},[i("v-text-field",{attrs:{"hide-details":"",flat:"",label:"Leave a comment...",solo:""},on:{keydown:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.comment.apply(null,arguments)}},scopedSlots:t._u([{key:"append",fn:function(){return[i("v-btn",{staticClass:"mx-0",attrs:{depressed:""},on:{click:t.comment}},[t._v(" Post ")])]},proxy:!0}]),model:{value:t.input,callback:function(e){t.input=e},expression:"input"}})],1),i("v-slide-x-transition",{attrs:{group:""}},t._l(t.timeline,(function(e){return i("v-timeline-item",{key:e.id,staticClass:"mb-4",attrs:{color:"pink",small:""}},[i("v-row",{attrs:{justify:"space-between"}},[i("v-col",{attrs:{cols:"7"},domProps:{textContent:t._s(e.text)}}),i("v-col",{staticClass:"text-right",attrs:{cols:"5"},domProps:{textContent:t._s(e.time)}})],1)],1)})),1),i("v-timeline-item",{staticClass:"mb-6",attrs:{"hide-dot":""}},[i("span",[t._v("TODAY")])]),i("v-timeline-item",{staticClass:"mb-4",attrs:{color:"grey","icon-color":"grey lighten-2",small:""}},[i("v-row",{attrs:{justify:"space-between"}},[i("v-col",{attrs:{cols:"7"}},[t._v(" This order was archived. ")]),i("v-col",{staticClass:"text-right",attrs:{cols:"5"}},[t._v(" 15:26 EDT ")])],1)],1),i("v-timeline-item",{staticClass:"mb-4",attrs:{small:""}},[i("v-row",{attrs:{justify:"space-between"}},[i("v-col",{attrs:{cols:"7"}},[i("v-chip",{staticClass:"white--text ml-0",attrs:{color:"purple",label:"",small:""}},[t._v(" APP ")]),t._v(" Digital Downloads fulfilled 1 item. ")],1),i("v-col",{staticClass:"text-right",attrs:{cols:"5"}},[t._v(" 15:25 EDT ")])],1)],1),i("v-timeline-item",{staticClass:"mb-4",attrs:{color:"grey",small:""}},[i("v-row",{attrs:{justify:"space-between"}},[i("v-col",{attrs:{cols:"7"}},[t._v(" Order confirmation email was sent to John Leider (john@vuetifyjs.com). ")]),i("v-col",{staticClass:"text-right",attrs:{cols:"5"}},[t._v(" 15:25 EDT ")])],1)],1),i("v-timeline-item",{staticClass:"mb-4",attrs:{"hide-dot":""}},[i("v-btn",{staticClass:"mx-0"},[t._v(" Resend Email ")])],1),i("v-timeline-item",{staticClass:"mb-4",attrs:{color:"grey",small:""}},[i("v-row",{attrs:{justify:"space-between"}},[i("v-col",{attrs:{cols:"7"}},[t._v(" A $15.00 USD payment was processed on PayPal Express Checkout ")]),i("v-col",{staticClass:"text-right",attrs:{cols:"5"}},[t._v(" 15:25 EDT ")])],1)],1),i("v-timeline-item",{attrs:{color:"grey",small:""}},[i("v-row",{attrs:{justify:"space-between"}},[i("v-col",{attrs:{cols:"7"}},[t._v(" John Leider placed this order on Online Store (checkout #1937432132572). ")]),i("v-col",{staticClass:"text-right",attrs:{cols:"5"}},[t._v(" 15:25 EDT ")])],1)],1)],1)],1)},xt=[],Tt=(i("fb6a"),i("ac1f"),i("5319"),i("a15b"),i("d81d"),i("1276"),{data:function(){return{events:[],input:null,nonce:0}},computed:{timeline:function(){return this.events.slice().reverse()}},methods:{comment:function(){var t=(new Date).toTimeString();this.events.push({id:this.nonce+=1,text:this.input,time:t.replace(/:\d{2}\sGMT-\d{4}\s\((.*)\)/,(function(t,e){return" ".concat(e.split(" ").map((function(t){return t.charAt(0)})).join(""))}))}),this.input=null}}}),wt=Tt,kt=i("cc20"),Vt=i("8654"),Bt=Object(r["a"])(wt,yt,xt,!1,null,null,null),St=Bt.exports;c()(Bt,{VBtn:d["a"],VChip:kt["a"],VCol:m["a"],VContainer:p["a"],VRow:b["a"],VSlideXTransition:z["g"],VTextField:Vt["a"],VTimeline:x,VTimelineItem:V});var $t={name:"Timelines",components:{ColorTimeline:$,DenseTimeline:R,IconDotsTimeline:W,ReverseTimeline:Z,SmallTimeline:at,IconTimeline:ct,OppositeTimeline:pt,TimelineItemDefaultTimeline:_t,AdvancedTimeline:St}},jt=$t,Dt=Object(r["a"])(jt,s,a,!1,null,null,null);e["default"]=Dt.exports;c()(Dt,{VCol:m["a"],VContainer:p["a"]})},"99d9":function(t,e,i){"use strict";i.d(e,"a",(function(){return n})),i.d(e,"b",(function(){return o})),i.d(e,"c",(function(){return r})),i.d(e,"d",(function(){return l}));var s=i("b0af"),a=i("80d2"),n=Object(a["h"])("v-card__actions"),o=Object(a["h"])("v-card__subtitle"),r=Object(a["h"])("v-card__text"),l=Object(a["h"])("v-card__title");s["a"]},"9d01":function(t,e,i){},afdd:function(t,e,i){"use strict";var s=i("8336");e["a"]=s["a"]},b0af:function(t,e,i){"use strict";var s=i("5530"),a=(i("a9e3"),i("0481"),i("615b"),i("10d2")),n=i("297c"),o=i("1c87"),r=i("58df");e["a"]=Object(r["a"])(n["a"],o["a"],a["a"]).extend({name:"v-card",props:{flat:Boolean,hover:Boolean,img:String,link:Boolean,loaderHeight:{type:[Number,String],default:4},raised:Boolean},computed:{classes:function(){return Object(s["a"])(Object(s["a"])({"v-card":!0},o["a"].options.computed.classes.call(this)),{},{"v-card--flat":this.flat,"v-card--hover":this.hover,"v-card--link":this.isClickable,"v-card--loading":this.loading,"v-card--disabled":this.disabled,"v-card--raised":this.raised},a["a"].options.computed.classes.call(this))},styles:function(){var t=Object(s["a"])({},a["a"].options.computed.styles.call(this));return this.img&&(t.background='url("'.concat(this.img,'") center center / cover no-repeat')),t}},methods:{genProgress:function(){var t=n["a"].options.methods.genProgress.call(this);return t?this.$createElement("div",{staticClass:"v-card__progress",key:"progress"},[t]):null}},render:function(t){var e=this.generateRouteLink(),i=e.tag,s=e.data;return s.style=this.styles,this.isClickable&&(s.attrs=s.attrs||{},s.attrs.tabindex=0),t(i,this.setBackgroundColor(this.color,s),[this.genProgress(),this.$slots.default])}})},b73d:function(t,e,i){"use strict";var s=i("15fd"),a=i("5530"),n=(i("0481"),i("ec29"),i("9d01"),i("fe09")),o=i("c37a"),r=i("c3f0"),l=i("0789"),c=i("490a"),u=i("80d2"),d=["title"];e["a"]=n["a"].extend({name:"v-switch",directives:{Touch:r["a"]},props:{inset:Boolean,loading:{type:[Boolean,String],default:!1},flat:{type:Boolean,default:!1}},computed:{classes:function(){return Object(a["a"])(Object(a["a"])({},o["a"].options.computed.classes.call(this)),{},{"v-input--selection-controls v-input--switch":!0,"v-input--switch--flat":this.flat,"v-input--switch--inset":this.inset})},attrs:function(){return{"aria-checked":String(this.isActive),"aria-disabled":String(this.isDisabled),role:"switch"}},validationState:function(){return this.hasError&&this.shouldValidate?"error":this.hasSuccess?"success":null!==this.hasColor?this.computedColor:void 0},switchData:function(){return this.setTextColor(this.loading?void 0:this.validationState,{class:this.themeClasses})}},methods:{genDefaultSlot:function(){return[this.genSwitch(),this.genLabel()]},genSwitch:function(){var t=this.attrs$,e=(t.title,Object(s["a"])(t,d));return this.$createElement("div",{staticClass:"v-input--selection-controls__input"},[this.genInput("checkbox",Object(a["a"])(Object(a["a"])({},this.attrs),e)),this.genRipple(this.setTextColor(this.validationState,{directives:[{name:"touch",value:{left:this.onSwipeLeft,right:this.onSwipeRight}}]})),this.$createElement("div",Object(a["a"])({staticClass:"v-input--switch__track"},this.switchData)),this.$createElement("div",Object(a["a"])({staticClass:"v-input--switch__thumb"},this.switchData),[this.genProgress()])])},genProgress:function(){return this.$createElement(l["c"],{},[!1===this.loading?null:this.$slots.progress||this.$createElement(c["a"],{props:{color:!0===this.loading||""===this.loading?this.color||"primary":this.loading,size:16,width:2,indeterminate:!0}})])},onSwipeLeft:function(){this.isActive&&this.onChange()},onSwipeRight:function(){this.isActive||this.onChange()},onKeydown:function(t){(t.keyCode===u["s"].left&&this.isActive||t.keyCode===u["s"].right&&!this.isActive)&&this.onChange()}}})},cc20:function(t,e,i){"use strict";var s=i("3835"),a=i("5530"),n=(i("4de4"),i("8adc"),i("58df")),o=i("0789"),r=i("9d26"),l=i("a9ad"),c=i("4e82"),u=i("7560"),d=i("f2e7"),v=i("1c87"),h=i("af2b"),m=i("d9bd");e["a"]=Object(n["a"])(l["a"],h["a"],v["a"],u["a"],Object(c["a"])("chipGroup"),Object(d["b"])("inputValue")).extend({name:"v-chip",props:{active:{type:Boolean,default:!0},activeClass:{type:String,default:function(){return this.chipGroup?this.chipGroup.activeClass:""}},close:Boolean,closeIcon:{type:String,default:"$delete"},closeLabel:{type:String,default:"$vuetify.close"},disabled:Boolean,draggable:Boolean,filter:Boolean,filterIcon:{type:String,default:"$complete"},label:Boolean,link:Boolean,outlined:Boolean,pill:Boolean,tag:{type:String,default:"span"},textColor:String,value:null},data:function(){return{proxyClass:"v-chip--active"}},computed:{classes:function(){return Object(a["a"])(Object(a["a"])(Object(a["a"])(Object(a["a"])({"v-chip":!0},v["a"].options.computed.classes.call(this)),{},{"v-chip--clickable":this.isClickable,"v-chip--disabled":this.disabled,"v-chip--draggable":this.draggable,"v-chip--label":this.label,"v-chip--link":this.isLink,"v-chip--no-color":!this.color,"v-chip--outlined":this.outlined,"v-chip--pill":this.pill,"v-chip--removable":this.hasClose},this.themeClasses),this.sizeableClasses),this.groupClasses)},hasClose:function(){return Boolean(this.close)},isClickable:function(){return Boolean(v["a"].options.computed.isClickable.call(this)||this.chipGroup)}},created:function(){var t=this,e=[["outline","outlined"],["selected","input-value"],["value","active"],["@input","@active.sync"]];e.forEach((function(e){var i=Object(s["a"])(e,2),a=i[0],n=i[1];t.$attrs.hasOwnProperty(a)&&Object(m["a"])(a,n,t)}))},methods:{click:function(t){this.$emit("click",t),this.chipGroup&&this.toggle()},genFilter:function(){var t=[];return this.isActive&&t.push(this.$createElement(r["a"],{staticClass:"v-chip__filter",props:{left:!0}},this.filterIcon)),this.$createElement(o["b"],t)},genClose:function(){var t=this;return this.$createElement(r["a"],{staticClass:"v-chip__close",props:{right:!0,size:18},attrs:{"aria-label":this.$vuetify.lang.t(this.closeLabel)},on:{click:function(e){e.stopPropagation(),e.preventDefault(),t.$emit("click:close"),t.$emit("update:active",!1)}}},this.closeIcon)},genContent:function(){return this.$createElement("span",{staticClass:"v-chip__content"},[this.filter&&this.genFilter(),this.$slots.default,this.hasClose&&this.genClose()])}},render:function(t){var e=[this.genContent()],i=this.generateRouteLink(),s=i.tag,n=i.data;n.attrs=Object(a["a"])(Object(a["a"])({},n.attrs),{},{draggable:this.draggable?"true":void 0,tabindex:this.chipGroup&&!this.disabled?0:n.attrs.tabindex}),n.directives.push({name:"show",value:this.active}),n=this.setBackgroundColor(this.color,n);var o=this.textColor||this.outlined&&this.color;return t(s,this.setTextColor(o,n),e)}})},ec29:function(t,e,i){},f40d:function(t,e,i){"use strict";var s=i("2b0e");e["a"]=s["a"].extend({name:"transitionable",props:{mode:String,origin:String,transition:String}})},fe09:function(t,e,i){"use strict";i.d(e,"b",(function(){return r}));i("d3b7"),i("25f0"),i("4de4");var s=i("c37a"),a=i("5311"),n=i("8547"),o=i("58df");function r(t){t.preventDefault()}e["a"]=Object(o["a"])(s["a"],a["a"],n["a"]).extend({name:"selectable",model:{prop:"inputValue",event:"change"},props:{id:String,inputValue:null,falseValue:null,trueValue:null,multiple:{type:Boolean,default:null},label:String},data:function(){return{hasColor:this.inputValue,lazyValue:this.inputValue}},computed:{computedColor:function(){if(this.isActive)return this.color?this.color:this.isDark&&!this.appIsDark?"white":"primary"},isMultiple:function(){return!0===this.multiple||null===this.multiple&&Array.isArray(this.internalValue)},isActive:function(){var t=this,e=this.value,i=this.internalValue;return this.isMultiple?!!Array.isArray(i)&&i.some((function(i){return t.valueComparator(i,e)})):void 0===this.trueValue||void 0===this.falseValue?e?this.valueComparator(e,i):Boolean(i):this.valueComparator(i,this.trueValue)},isDirty:function(){return this.isActive},rippleState:function(){return this.isDisabled||this.validationState?this.validationState:void 0}},watch:{inputValue:function(t){this.lazyValue=t,this.hasColor=t}},methods:{genLabel:function(){var t=s["a"].options.methods.genLabel.call(this);return t?(t.data.on={click:r},t):t},genInput:function(t,e){return this.$createElement("input",{attrs:Object.assign({"aria-checked":this.isActive.toString(),disabled:this.isDisabled,id:this.computedId,role:t,type:t},e),domProps:{value:this.value,checked:this.isActive},on:{blur:this.onBlur,change:this.onChange,focus:this.onFocus,keydown:this.onKeydown,click:r},ref:"input"})},onBlur:function(){this.isFocused=!1},onClick:function(t){this.onChange(),this.$emit("click",t)},onChange:function(){var t=this;if(this.isInteractive){var e=this.value,i=this.internalValue;if(this.isMultiple){Array.isArray(i)||(i=[]);var s=i.length;i=i.filter((function(i){return!t.valueComparator(i,e)})),i.length===s&&i.push(e)}else i=void 0!==this.trueValue&&void 0!==this.falseValue?this.valueComparator(i,this.trueValue)?this.falseValue:this.trueValue:e?this.valueComparator(i,e)?null:e:!i;this.validate(!0,i),this.internalValue=i,this.hasColor=i}},onFocus:function(){this.isFocused=!0},onKeydown:function(t){}}})}}]);
//# sourceMappingURL=chunk-db4f0ca2.f46e2c51.js.map