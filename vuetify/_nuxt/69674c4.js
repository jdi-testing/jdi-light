(window.webpackJsonp=window.webpackJsonp||[]).push([[23],{1053:function(t,e,o){"use strict";o.r(e);var n=o(1017),l=o(1104),r=o(1019),v=o(445),c=o(178),_={data:function(){return{value:1}}},d=o(82),h=Object(d.a)(_,(function(){var t=this,e=t._self._c;return e(r.a,{attrs:{value:t.value,color:"primary"}},[e(v.a,[e("span",[t._v("Recents")]),t._v(" "),e(c.a,[t._v("mdi-history")])],1),t._v(" "),e(v.a,[e("span",[t._v("Favorites")]),t._v(" "),e(c.a,[t._v("mdi-heart")])],1),t._v(" "),e(v.a,[e("span",[t._v("Nearby")]),t._v(" "),e(c.a,[t._v("mdi-map-marker")])],1)],1)}),[],!1,null,null,null).exports,m={data:function(){return{value:1}}},f=Object(d.a)(m,(function(){var t=this,e=t._self._c;return e(r.a,{attrs:{value:t.value,color:"teal",grow:""}},[e(v.a,[e("span",[t._v("Recents")]),t._v(" "),e(c.a,[t._v("mdi-history")])],1),t._v(" "),e(v.a,[e("span",[t._v("Favorites")]),t._v(" "),e(c.a,[t._v("mdi-heart")])],1),t._v(" "),e(v.a,[e("span",[t._v("Nearby")]),t._v(" "),e(c.a,[t._v("mdi-map-marker")])],1)],1)}),[],!1,null,null,null).exports,x=o(431),N=o(181),B={data:function(){return{selected:null}}},y=Object(d.a)(B,(function(){var t=this,e=t._self._c;return e(x.a,{staticClass:"overflow-hidden mx-auto",attrs:{height:"200","max-width":"500"}},[e(r.a,{attrs:{absolute:"","hide-on-scroll":"",horizontal:"","scroll-target":"#hide-on-scroll-example"},on:{change:function(e){t.selected=e}}},[e(v.a,{attrs:{color:"deep-purple accent-4",text:"",value:"Recents"}},[e("span",[t._v("Recents")]),t._v(" "),e(c.a,[t._v("mdi-history")])],1),t._v(" "),e(v.a,{attrs:{color:"deep-purple accent-4",text:"",value:"Favorites"}},[e("span",[t._v("Favorites")]),t._v(" "),e(c.a,[t._v("mdi-heart")])],1),t._v(" "),e(v.a,{attrs:{color:"deep-purple accent-4",text:"",value:"Nearby"}},[e("span",[t._v("Nearby")]),t._v(" "),e(c.a,[t._v("mdi-map-marker")])],1)],1),t._v(" "),e(N.a,{staticClass:"overflow-y-auto",attrs:{id:"hide-on-scroll-example","max-height":"600"}},[e(N.a,{attrs:{height:"1500"}},[t._v(t._s(t.selected))])],1)],1)}),[],!1,null,null,null).exports,w={data:function(){return{value:1}}},C=Object(d.a)(w,(function(){var t=this,e=t._self._c;return e(r.a,{attrs:{value:t.value,color:"primary",horizontal:""}},[e(v.a,[e("span",[t._v("Recents")]),t._v(" "),e(c.a,[t._v("mdi-history")])],1),t._v(" "),e(v.a,[e("span",[t._v("Favorites")]),t._v(" "),e(c.a,[t._v("mdi-heart")])],1),t._v(" "),e(v.a,[e("span",[t._v("Nearby")]),t._v(" "),e(c.a,[t._v("mdi-map-marker")])],1)],1)}),[],!1,null,null,null).exports,k=o(157),O={data:function(){return{selected:null}}},S={data:function(){return{value:1}},computed:{color:function(){switch(this.value){case 0:default:return"blue-grey";case 1:return"teal";case 2:return"brown";case 3:return"indigo"}}}},j={data:function(){return{value:1,active:!0}}},z={name:"BottomNavigation",components:{ColorBottomNavigation:h,GrowBottomNavigation:f,HideOnScrollBottomNavigation:y,HorizontalBottomNavigation:C,ScrollThresholdBottomNavigation:Object(d.a)(O,(function(){var t=this,e=t._self._c;return e(x.a,{staticClass:"mx-auto overflow-hidden",attrs:{height:"200","max-width":"500"}},[e(r.a,{attrs:{absolute:"",color:"white","hide-on-scroll":"",horizontal:"","scroll-target":"#scroll-threshold-example","scroll-threshold":"500"},on:{change:function(e){t.selected=e}}},[e(v.a,{attrs:{value:"Recents"}},[e("span",[t._v("Recents")]),t._v(" "),e(c.a,[t._v("mdi-history")])],1),t._v(" "),e(v.a,{attrs:{value:"Favorites"}},[e("span",[t._v("Favorites")]),t._v(" "),e(c.a,[t._v("mdi-heart")])],1),t._v(" "),e(v.a,{attrs:{value:"Nearby"}},[e("span",[t._v("Nearby")]),t._v(" "),e(c.a,[t._v("mdi-map-marker")])],1)],1),t._v(" "),e(k.a,{staticClass:"overflow-y-auto pb-16",attrs:{id:"scroll-threshold-example","max-height":"600"}},[e(N.a,{attrs:{height:"1500"}},[t._v(t._s(t.selected))])],1)],1)}),[],!1,null,null,null).exports,ShiftBottomNavigation:Object(d.a)(S,(function(){var t=this,e=t._self._c;return e(r.a,{attrs:{"background-color":t.color,dark:"",shift:""},model:{value:t.value,callback:function(e){t.value=e},expression:"value"}},[e(v.a,[e("span",[t._v("Video")]),t._v(" "),e(c.a,[t._v("mdi-television-play")])],1),t._v(" "),e(v.a,[e("span",[t._v("Music")]),t._v(" "),e(c.a,[t._v("mdi-music-note")])],1),t._v(" "),e(v.a,[e("span",[t._v("Book")]),t._v(" "),e(c.a,[t._v("mdi-book")])],1),t._v(" "),e(v.a,[e("span",[t._v("Image")]),t._v(" "),e(c.a,[t._v("mdi-image")])],1)],1)}),[],!1,null,null,null).exports,ToggleBottomNavigation:Object(d.a)(j,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"overflow-hidden"},[e("div",{staticClass:"text-center mb-8"},[e(v.a,{attrs:{color:"deep-purple",outlined:""},on:{click:function(e){t.active=!t.active}}},[t._v("\n      Toggle Navigation\n    ")])],1),t._v(" "),e(r.a,{attrs:{"input-value":t.active,color:"indigo"},model:{value:t.value,callback:function(e){t.value=e},expression:"value"}},[e(v.a,[e("span",[t._v("Recents")]),t._v(" "),e(c.a,[t._v("mdi-history")])],1),t._v(" "),e(v.a,[e("span",[t._v("Favorites")]),t._v(" "),e(c.a,[t._v("mdi-heart")])],1),t._v(" "),e(v.a,[e("span",[t._v("Nearby")]),t._v(" "),e(c.a,[t._v("mdi-map-marker")])],1)],1)],1)}),[],!1,null,null,null).exports}},F=(o(846),Object(d.a)(z,(function(){var t=this,e=t._self._c;return e(l.a,[e(n.a,[e("h1",[t._v("Bottom navigation")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),e("code",[t._v("v-bottom-navigation")]),t._v(" component is an alternative to the sidebar. \n            It is primarily used for mobile applications and comes in three variants, icons and text, and shift.\n        ")])]),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Color\n        ")]),t._v(" "),e("ColorBottomNavigation",{attrs:{id:"colorBottomNavigation"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Grow\n        ")]),t._v(" "),e("GrowBottomNavigation",{attrs:{id:"growBottomNavigation"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Hide on scroll\n        ")]),t._v(" "),e("HideOnScrollBottomNavigation",{attrs:{id:"hideOnScrollBottomNavigation"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Horizontal\n        ")]),t._v(" "),e("HorizontalBottomNavigation",{attrs:{id:"horizontalBottomNavigation"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Scroll threshold\n        ")]),t._v(" "),e("ScrollThresholdBottomNavigation",{attrs:{id:"scrollThresholdBottomNavigation"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Shift\n        ")]),t._v(" "),e("ShiftBottomNavigation",{attrs:{id:"shiftBottomNavigation"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Toggle\n        ")]),t._v(" "),e("ToggleBottomNavigation",{attrs:{id:"toggleBottomNavigation"}})],1)],1)}),[],!1,null,null,null));e.default=F.exports},646:function(t,e,o){var content=o(847);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,o(27).default)("77fbc800",content,!0,{sourceMap:!1})},846:function(t,e,o){"use strict";o(646)},847:function(t,e,o){var n=o(26)(!1);n.push([t.i,".v-item-group.v-bottom-navigation .v-btn.v-size--default{height:inherit;background:transparent}",""]),t.exports=n}}]);