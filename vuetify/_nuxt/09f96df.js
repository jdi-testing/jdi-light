(window.webpackJsonp=window.webpackJsonp||[]).push([[25],{1069:function(t,n,e){"use strict";e.r(n);var c=e(1040),o=e(1130),r=e(445),l=e(478),d={data:function(){return{state:""}},methods:{click:function(){this.state="Block button clicked"}}},v=e(82),_=Object(v.a)(d,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Block Button")]),t._v(" "),n(r.a,{attrs:{block:""},on:{click:t.click}},[t._v("\n    Block Button\n  ")]),t._v(" "),n(l.a,{attrs:{id:"block-button-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,f={data:function(){return{state:""}},methods:{click_normal:function(){this.state="Depressed button clicked: Normal"},click_primary:function(){this.state="Depressed button clicked: Primary"},click_error:function(){this.state="Depressed button clicked: Error"}}},k=Object(v.a)(f,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Depressed Buttons")]),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{depressed:""},on:{click:t.click_normal}},[t._v("\n      Normal\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{depressed:"",color:"primary"},on:{click:t.click_primary}},[t._v("\n      Primary\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{depressed:"",color:"error"},on:{click:t.click_error}},[t._v("\n      Error\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{depressed:"",disabled:""}},[t._v("\n      Disabled\n    ")]),t._v(" "),n(l.a,{attrs:{id:"depr-buttons-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,m={data:function(){return{state:""}},methods:{click:function(){this.state="Button clicked"}}},h=Object(v.a)(m,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Common Button")]),t._v(" "),n(r.a,{attrs:{elevation:"2"},on:{click:t.click}},[t._v("\n  Click me!\n  ")]),t._v(" "),n(l.a,{attrs:{id:"button-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,x=e(178),y={data:function(){return{state:""}},methods:{click_heart:function(){this.state="Icon button clicked: heart"},click_star:function(){this.state="Icon button clicked: star"},click_thumb_up:function(){this.state="Icon button clicked: thumb up"},click_cached:function(){this.state="Icon button clicked: cached"}}},B=Object(v.a)(y,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Icon Buttons")]),t._v(" "),n(r.a,{attrs:{icon:"",color:"pink"},on:{click:t.click_heart}},[n(x.a,[t._v("mdi-heart")])],1),t._v(" "),n(r.a,{attrs:{icon:"",color:"indigo"},on:{click:t.click_star}},[n(x.a,[t._v("mdi-star")])],1),t._v(" "),n(r.a,{attrs:{icon:"",color:"green"},on:{click:t.click_cached}},[n(x.a,[t._v("mdi-cached")])],1),t._v(" "),n(r.a,{attrs:{icon:"",color:"deep-orange"},on:{click:t.click_thumb_up}},[n(x.a,[t._v("mdi-thumb-up")])],1),t._v(" "),n(r.a,{attrs:{icon:"",disabled:""}},[n(x.a,[t._v("mdi-heart")])],1),t._v(" "),n(r.a,{attrs:{icon:"",disabled:""}},[n(x.a,[t._v("mdi-star")])],1),t._v(" "),n(r.a,{attrs:{icon:"",disabled:""}},[n(x.a,[t._v("mdi-cached")])],1),t._v(" "),n(r.a,{attrs:{icon:"",disabled:""}},[n(x.a,[t._v("mdi-thumb-up")])],1),t._v(" "),n(l.a,{attrs:{id:"icon-buttons-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,C=e(767),O=(e(55),{data:function(){return{loader:null,acceptTerms:!1,upload:!1,customLoader:!1,iconLoader:!1,cloudIcon:!1,snackbarText:"",snackbarVisible:!1}},watch:{loader:function(){var t=this;if(null!==this.loader){this.snackbarVisible=!1;var n=this.loader;this[n]=!this[n],setTimeout((function(){t[n]=!1,t.snackbarText="".concat(n," finished loading"),t.snackbarVisible=!0}),3e3),this.loader=null}}}}),j=(e(879),Object(v.a)(O,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Loader Buttons")]),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{loading:t.acceptTerms,disabled:t.acceptTerms,color:"secondary"},on:{click:function(n){t.loader="acceptTerms"}}},[t._v("\n    Accept Terms\n  ")]),t._v(" "),n(r.a,{staticClass:"ma-2 white--text",attrs:{loading:t.upload,disabled:t.upload,color:"blue-grey"},on:{click:function(n){t.loader="upload"}}},[t._v("\n    Upload\n    "),n(x.a,{attrs:{right:"",dark:""}},[t._v("\n      mdi-cloud-upload\n    ")])],1),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{loading:t.customLoader,disabled:t.customLoader,color:"success"},on:{click:function(n){t.loader="customLoader"}},scopedSlots:t._u([{key:"loader",fn:function(){return[n("span",[t._v("Loading...")])]},proxy:!0}])},[t._v("\n    Custom Loader\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-2",attrs:{loading:t.iconLoader,disabled:t.iconLoader,color:"info"},on:{click:function(n){t.loader="iconLoader"}},scopedSlots:t._u([{key:"loader",fn:function(){return[n("span",{staticClass:"custom-loader"},[n(x.a,{attrs:{light:""}},[t._v("mdi-cached")])],1)]},proxy:!0}])},[t._v("\n    Icon Loader\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-2 white--text",attrs:{loading:t.cloudIcon,disabled:t.cloudIcon,color:"blue-grey",fab:""},on:{click:function(n){t.loader="cloudIcon"}}},[n(x.a,{attrs:{dark:""}},[t._v("\n      mdi-cloud-upload\n    ")])],1),t._v(" "),n(C.a,{attrs:{timeout:"3000"},scopedSlots:t._u([{key:"action",fn:function(e){var c=e.attrs;return[n(r.a,t._b({attrs:{color:"blue",text:""},on:{click:function(n){t.snackbarVisible=!1}}},"v-btn",c,!1),[t._v("\n        Close\n      ")])]}}]),model:{value:t.snackbarVisible,callback:function(n){t.snackbarVisible=n},expression:"snackbarVisible"}},[t._v("\n    "+t._s(t.snackbarText)+"\n    ")])],1)}),[],!1,null,null,null).exports),w={data:function(){return{state:""}},methods:{click_normal:function(){this.state="Text button clicked: Normal"},click_primary:function(){this.state="Text button clicked: Primary"},click_error:function(){this.state="Text button clicked: Error"}}},T=Object(v.a)(w,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Text Buttons")]),t._v(" "),n(r.a,{attrs:{text:""},on:{click:t.click_normal}},[t._v("\n    Normal\n  ")]),t._v(" "),n(r.a,{attrs:{text:"",color:"primary"},on:{click:t.click_primary}},[t._v("\n    Primary\n  ")]),t._v(" "),n(r.a,{attrs:{text:"",color:"error"},on:{click:t.click_error}},[t._v("\n    Error\n  ")]),t._v(" "),n(r.a,{attrs:{text:"",disabled:""}},[t._v("\n    Disabled\n  ")]),t._v(" "),n(l.a,{attrs:{id:"text-buttons-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,S=e(157),L=e(32),P=(e(106),e(5),{data:function(){return{loading:!1,state:""}},methods:{remove:function(){var t=this;return Object(L.a)(regeneratorRuntime.mark((function n(){return regeneratorRuntime.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return t.state="Plain button clicked: delete",t.loading=!0,n.next=4,new Promise((function(t){return setTimeout(t,3e3)}));case 4:t.loading=!1;case 5:case"end":return n.stop()}}),n)})))()},click_cancel:function(){this.state="Plain button clicked: cancel"}}}),I=Object(v.a)(P,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Plain Buttons")]),t._v(" "),n("div",{staticClass:"text-center"},[n(S.a,{staticClass:"px-7 pt-7 pb-4 mx-auto text-center d-inline-block",attrs:{color:"blue-grey darken-3",dark:""}},[n("div",{staticClass:"grey--text text--lighten-1 text-body-2 mb-4"},[t._v("\n      Are you sure you want to delete this album?\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-1",attrs:{disabled:t.loading,color:"grey",plain:""},on:{click:t.click_cancel}},[t._v("\n      Cancel\n    ")]),t._v(" "),n(r.a,{staticClass:"ma-1",attrs:{loading:t.loading,color:"error",plain:""},on:{click:t.remove}},[t._v("\n      Delete\n    ")])],1)],1),t._v(" "),n(l.a,{attrs:{id:"plain-buttons-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,D={data:function(){return{state:""}},methods:{click:function(){this.state="Outlined button clicked"}}},E=Object(v.a)(D,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Outlined Button")]),t._v(" "),n("div",{staticClass:"text-center"},[n(r.a,{staticClass:"ma-2",attrs:{outlined:"",color:"indigo"},on:{click:t.click}},[t._v("\n    Outlined Button\n  ")])],1),t._v(" "),n(l.a,{attrs:{id:"outline-buttons-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,R={data:function(){return{state:""}},methods:{click:function(){this.state="Rounded button clicked"}}},V=Object(v.a)(R,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Rounded Button")]),t._v(" "),n("div",{staticClass:"text-center"},[n(r.a,{attrs:{rounded:"",color:"primary",dark:""},on:{click:t.click}},[t._v("\n    Rounded Button\n  ")])],1),t._v(" "),n(l.a,{attrs:{id:"rounded-button-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,N={data:function(){return{state:""}},methods:{click:function(){this.state="Tile button clicked"}}},M=Object(v.a)(N,(function(){var t=this,n=t._self._c;return n(o.a,[n("h2",[t._v("Tile Button")]),t._v(" "),n("div",{staticClass:"text-center"},[n(r.a,{attrs:{tile:"",color:"success"},on:{click:t.click}},[n(x.a,{attrs:{left:""}},[t._v("\n      mdi-pencil\n    ")]),t._v("\n    Edit\n  ")],1)],1),t._v(" "),n(l.a,{attrs:{id:"tile-button-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports,z=e(465),A={data:function(){return{state:""}},methods:{click_extraSmall:function(){this.state="Extra small Button clicked"},click_small:function(){this.state="Small Button clicked"},click_normal:function(){this.state="Normal Button clicked"},click_large:function(){this.state="Large Button clicked"},click_extraLarge:function(){this.state="Extra large Button clicked"},click_television:function(){this.state="Icon button is clicked: television"},click_pencil:function(){this.state="Icon button is clicked: pencil"},click_circle:function(){this.state="Icon button is clicked: circle"},click_alarm:function(){this.state="Icon button is clicked: alarm"},click_domain:function(){this.state="Icon button is clicked: domain"}}},J={name:"Buttons",components:{BlockButton:_,DepressedButton:k,CommonButton:h,IconButton:B,LoaderButton:j,TextButton:T,PlainButton:I,OutlinedButton:E,RoundedButton:V,TileButton:M,SizingButton:Object(v.a)(A,(function(){var t=this,n=t._self._c;return n(o.a,{staticClass:"pa-0",attrs:{fluid:""}},[n("h2",[t._v("Sizing Buttons")]),t._v(" "),n(z.a,{attrs:{align:"center"}},[n(c.a,{attrs:{cols:"12",sm:"6"}},[n("div",{staticClass:"text-center"},[n("div",{staticClass:"my-2"},[n(r.a,{attrs:{"x-small":"",color:"secondary",dark:""},on:{click:t.click_extraSmall}},[t._v("\n            Extra small Button\n          ")])],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{small:"",color:"primary",dark:""},on:{click:t.click_small}},[t._v("\n            Small Button\n          ")])],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"warning",dark:""},on:{click:t.click_normal}},[t._v("\n            Normal Button\n          ")])],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"error",dark:"",large:""},on:{click:t.click_large}},[t._v("\n            Large Button\n          ")])],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{"x-large":"",color:"success",dark:""},on:{click:t.click_extraLarge}},[t._v("\n            Extra large Button\n          ")])],1)])]),t._v(" "),n(c.a,{attrs:{cols:"12",sm:"6"}},[n("div",{staticClass:"text-center"},[n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"secondary",fab:"","x-small":"",dark:""},on:{click:t.click_television}},[n(x.a,[t._v("mdi-television")])],1)],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"primary",fab:"",small:"",dark:""},on:{click:t.click_pencil}},[n(x.a,[t._v("mdi-pencil")])],1)],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"warning",fab:"",dark:""},on:{click:t.click_circle}},[n(x.a,[t._v("mdi-account-circle")])],1)],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"error",fab:"",large:"",dark:""},on:{click:t.click_alarm}},[n(x.a,[t._v("mdi-alarm")])],1)],1),t._v(" "),n("div",{staticClass:"my-2"},[n(r.a,{attrs:{color:"success",fab:"","x-large":"",dark:""},on:{click:t.click_domain}},[n(x.a,[t._v("mdi-domain")])],1)],1)])])],1),t._v(" "),n(l.a,{attrs:{id:"sizing-buttons-state",textarea:"",readonly:""},model:{value:t.state,callback:function(n){t.state=n},expression:"state"}})],1)}),[],!1,null,null,null).exports}},G=(e(881),Object(v.a)(J,(function(){var t=this,n=t._self._c;return n(o.a,{staticClass:"buttons"},[n(c.a,[n("h1",[t._v("Buttons")]),t._v(" "),n("p",{staticClass:"body-1 mt-2"},[t._v("\n      The "),n("code",[t._v("v-btn")]),t._v(" component replaces the standard html button with a material design theme and a multitude of options. \n      Any color helper class can be used to alter the background or text color.\n    ")])]),t._v(" "),n("CommonButton"),t._v(" "),n("BlockButton"),t._v(" "),n("DepressedButton"),t._v(" "),n("IconButton"),t._v(" "),n("LoaderButton"),t._v(" "),n("TextButton"),t._v(" "),n("PlainButton"),t._v(" "),n("OutlinedButton"),t._v(" "),n("RoundedButton"),t._v(" "),n("TileButton"),t._v(" "),n("SizingButton")],1)}),[],!1,null,null,null));n.default=G.exports},415:function(t,n,e){"use strict";var c=e(157);n.a=c.a},465:function(t,n,e){"use strict";e(11),e(15),e(19),e(20);var c=e(3),o=(e(5),e(58),e(65),e(40),e(16),e(22),e(60),e(417),e(54),e(418),e(419),e(420),e(421),e(422),e(423),e(424),e(425),e(426),e(427),e(428),e(429),e(430),e(56),e(10),e(462),e(1)),r=e(103),l=e(2);function d(object,t){var n=Object.keys(object);if(Object.getOwnPropertySymbols){var e=Object.getOwnPropertySymbols(object);t&&(e=e.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),n.push.apply(n,e)}return n}function v(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?d(Object(source),!0).forEach((function(n){Object(c.a)(t,n,source[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):d(Object(source)).forEach((function(n){Object.defineProperty(t,n,Object.getOwnPropertyDescriptor(source,n))}))}return t}var _=["sm","md","lg","xl"],f=["start","end","center"];function k(t,n){return _.reduce((function(e,c){return e[t+Object(l.J)(c)]=n(),e}),{})}var m=function(t){return[].concat(f,["baseline","stretch"]).includes(t)},h=k("align",(function(){return{type:String,default:null,validator:m}})),x=function(t){return[].concat(f,["space-between","space-around"]).includes(t)},y=k("justify",(function(){return{type:String,default:null,validator:x}})),B=function(t){return[].concat(f,["space-between","space-around","stretch"]).includes(t)},C=k("alignContent",(function(){return{type:String,default:null,validator:B}})),O={align:Object.keys(h),justify:Object.keys(y),alignContent:Object.keys(C)},j={align:"align",justify:"justify",alignContent:"align-content"};function w(t,n,e){var c=j[t];if(null!=e){if(n){var o=n.replace(t,"");c+="-".concat(o)}return(c+="-".concat(e)).toLowerCase()}}var T=new Map;n.a=o.a.extend({name:"v-row",functional:!0,props:v(v(v({tag:{type:String,default:"div"},dense:Boolean,noGutters:Boolean,align:{type:String,default:null,validator:m}},h),{},{justify:{type:String,default:null,validator:x}},y),{},{alignContent:{type:String,default:null,validator:B}},C),render:function(t,n){var e=n.props,data=n.data,o=n.children,l="";for(var d in e)l+=String(e[d]);var v=T.get(l);return v||function(){var t,n;for(n in v=[],O)O[n].forEach((function(t){var c=e[t],o=w(n,t,c);o&&v.push(o)}));v.push((t={"no-gutters":e.noGutters,"row--dense":e.dense},Object(c.a)(t,"align-".concat(e.align),e.align),Object(c.a)(t,"justify-".concat(e.justify),e.justify),Object(c.a)(t,"align-content-".concat(e.alignContent),e.alignContent),t)),T.set(l,v)}(),t(e.tag,Object(r.a)(data,{staticClass:"row",class:v}),o)}})},479:function(t,n,e){e(4)({target:"Object",stat:!0},{is:e(279)})},800:function(t,n,e){var content=e(880);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,e(27).default)("d0af3f5e",content,!0,{sourceMap:!1})},801:function(t,n,e){var content=e(882);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,e(27).default)("13654533",content,!0,{sourceMap:!1})},879:function(t,n,e){"use strict";e(800)},880:function(t,n,e){var c=e(26)(!1);c.push([t.i,".custom-loader{-webkit-animation:loader 1s infinite;animation:loader 1s infinite;display:flex}@-webkit-keyframes loader{0%{transform:rotate(0)}to{transform:rotate(1turn)}}@keyframes loader{0%{transform:rotate(0)}to{transform:rotate(1turn)}}",""]),t.exports=c},881:function(t,n,e){"use strict";e(801)},882:function(t,n,e){var c=e(26)(!1);c.push([t.i,"h1{text-align:center}h2{margin-bottom:15px}",""]),t.exports=c}}]);