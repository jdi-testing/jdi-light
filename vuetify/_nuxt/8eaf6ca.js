(window.webpackJsonp=window.webpackJsonp||[]).push([[22],{1053:function(t,o,e){"use strict";e.r(o);var n=e(1012),r=e(1099),l=e(1014),v=e(446),_=e(178),c={data:function(){return{value:1}}},d=e(82),m=Object(d.a)(c,(function(){var t=this,o=t._self._c;return o(l.a,{attrs:{value:t.value,color:"primary"}},[o(v.a,[o("span",[t._v("Recents")]),t._v(" "),o(_.a,[t._v("mdi-history")])],1),t._v(" "),o(v.a,[o("span",[t._v("Favorites")]),t._v(" "),o(_.a,[t._v("mdi-heart")])],1),t._v(" "),o(v.a,[o("span",[t._v("Nearby")]),t._v(" "),o(_.a,[t._v("mdi-map-marker")])],1)],1)}),[],!1,null,null,null).exports,h={data:function(){return{value:1}}},f=Object(d.a)(h,(function(){var t=this,o=t._self._c;return o(l.a,{attrs:{value:t.value,color:"teal",grow:""}},[o(v.a,[o("span",[t._v("Recents")]),t._v(" "),o(_.a,[t._v("mdi-history")])],1),t._v(" "),o(v.a,[o("span",[t._v("Favorites")]),t._v(" "),o(_.a,[t._v("mdi-heart")])],1),t._v(" "),o(v.a,[o("span",[t._v("Nearby")]),t._v(" "),o(_.a,[t._v("mdi-map-marker")])],1)],1)}),[],!1,null,null,null).exports,x=e(435),N=e(181),B=Object(d.a)({},(function(){var t=this,o=t._self._c;return o(x.a,{staticClass:"overflow-hidden mx-auto",attrs:{height:"200","max-width":"500"}},[o(l.a,{attrs:{absolute:"","hide-on-scroll":"",horizontal:"","scroll-target":"#hide-on-scroll-example"}},[o(v.a,{attrs:{color:"deep-purple accent-4",text:""}},[o("span",[t._v("Recents")]),t._v(" "),o(_.a,[t._v("mdi-history")])],1),t._v(" "),o(v.a,{attrs:{color:"deep-purple accent-4",text:""}},[o("span",[t._v("Favorites")]),t._v(" "),o(_.a,[t._v("mdi-heart")])],1),t._v(" "),o(v.a,{attrs:{color:"deep-purple accent-4",text:""}},[o("span",[t._v("Nearby")]),t._v(" "),o(_.a,[t._v("mdi-map-marker")])],1)],1),t._v(" "),o(N.a,{staticClass:"overflow-y-auto",attrs:{id:"hide-on-scroll-example","max-height":"600"}},[o(N.a,{attrs:{height:"1500"}})],1)],1)}),[],!1,null,null,null).exports,w={data:function(){return{value:1}}},y=Object(d.a)(w,(function(){var t=this,o=t._self._c;return o(l.a,{attrs:{value:t.value,color:"primary",horizontal:""}},[o(v.a,[o("span",[t._v("Recents")]),t._v(" "),o(_.a,[t._v("mdi-history")])],1),t._v(" "),o(v.a,[o("span",[t._v("Favorites")]),t._v(" "),o(_.a,[t._v("mdi-heart")])],1),t._v(" "),o(v.a,[o("span",[t._v("Nearby")]),t._v(" "),o(_.a,[t._v("mdi-map-marker")])],1)],1)}),[],!1,null,null,null).exports,C=e(156),k={data:function(){return{value:1}},computed:{color:function(){switch(this.value){case 0:default:return"blue-grey";case 1:return"teal";case 2:return"brown";case 3:return"indigo"}}}},O={data:function(){return{value:1,active:!0}}},S={name:"BottomNavigation",components:{ColorBottomNavigation:m,GrowBottomNavigation:f,HideOnScrollBottomNavigation:B,HorizontalBottomNavigation:y,ScrollThresholdBottomNavigation:Object(d.a)({},(function(){var t=this,o=t._self._c;return o(x.a,{staticClass:"mx-auto overflow-hidden",attrs:{height:"200","max-width":"500"}},[o(l.a,{attrs:{absolute:"",color:"white","hide-on-scroll":"",horizontal:"","scroll-target":"#scroll-threshold-example","scroll-threshold":"500"}},[o(v.a,[o("span",[t._v("Recents")]),t._v(" "),o(_.a,[t._v("mdi-history")])],1),t._v(" "),o(v.a,[o("span",[t._v("Favorites")]),t._v(" "),o(_.a,[t._v("mdi-heart")])],1),t._v(" "),o(v.a,[o("span",[t._v("Nearby")]),t._v(" "),o(_.a,[t._v("mdi-map-marker")])],1)],1),t._v(" "),o(C.a,{staticClass:"overflow-y-auto pb-16",attrs:{id:"scroll-threshold-example","max-height":"600"}},[o(N.a,{attrs:{height:"1500"}})],1)],1)}),[],!1,null,null,null).exports,ShiftBottomNavigation:Object(d.a)(k,(function(){var t=this,o=t._self._c;return o(l.a,{attrs:{"background-color":t.color,dark:"",shift:""},model:{value:t.value,callback:function(o){t.value=o},expression:"value"}},[o(v.a,[o("span",[t._v("Video")]),t._v(" "),o(_.a,[t._v("mdi-television-play")])],1),t._v(" "),o(v.a,[o("span",[t._v("Music")]),t._v(" "),o(_.a,[t._v("mdi-music-note")])],1),t._v(" "),o(v.a,[o("span",[t._v("Book")]),t._v(" "),o(_.a,[t._v("mdi-book")])],1),t._v(" "),o(v.a,[o("span",[t._v("Image")]),t._v(" "),o(_.a,[t._v("mdi-image")])],1)],1)}),[],!1,null,null,null).exports,ToggleBottomNavigation:Object(d.a)(O,(function(){var t=this,o=t._self._c;return o("div",{staticClass:"overflow-hidden"},[o("div",{staticClass:"text-center mb-8"},[o(v.a,{attrs:{color:"deep-purple",outlined:""},on:{click:function(o){t.active=!t.active}}},[t._v("\n      Toggle Navigation\n    ")])],1),t._v(" "),o(l.a,{attrs:{"input-value":t.active,color:"indigo"},model:{value:t.value,callback:function(o){t.value=o},expression:"value"}},[o(v.a,[o("span",[t._v("Recents")]),t._v(" "),o(_.a,[t._v("mdi-history")])],1),t._v(" "),o(v.a,[o("span",[t._v("Favorites")]),t._v(" "),o(_.a,[t._v("mdi-heart")])],1),t._v(" "),o(v.a,[o("span",[t._v("Nearby")]),t._v(" "),o(_.a,[t._v("mdi-map-marker")])],1)],1)],1)}),[],!1,null,null,null).exports}},j=(e(839),Object(d.a)(S,(function(){var t=this,o=t._self._c;return o(r.a,[o(n.a,[o("h1",[t._v("Bottom navigation")]),t._v(" "),o("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),o("code",[t._v("v-bottom-navigation")]),t._v(" component is an alternative to the sidebar. \n            It is primarily used for mobile applications and comes in three variants, icons and text, and shift.\n        ")])]),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Color\n        ")]),t._v(" "),o("ColorBottomNavigation",{attrs:{id:"colorBottomNavigation"}})],1),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Grow\n        ")]),t._v(" "),o("GrowBottomNavigation",{attrs:{id:"growBottomNavigation"}})],1),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Hide on scroll\n        ")]),t._v(" "),o("HideOnScrollBottomNavigation",{attrs:{id:"hideOnScrollBottomNavigation"}})],1),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Horizontal\n        ")]),t._v(" "),o("HorizontalBottomNavigation",{attrs:{id:"horizontalBottomNavigation"}})],1),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Scroll threshold\n        ")]),t._v(" "),o("ScrollThresholdBottomNavigation",{attrs:{id:"scrollThresholdBottomNavigation"}})],1),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Shift\n        ")]),t._v(" "),o("ShiftBottomNavigation",{attrs:{id:"shiftBottomNavigation"}})],1),t._v(" "),o(n.a,[o("p",{staticClass:"text-h5"},[t._v("\n            Toggle\n        ")]),t._v(" "),o("ToggleBottomNavigation",{attrs:{id:"toggleBottomNavigation"}})],1)],1)}),[],!1,null,null,null));o.default=j.exports},643:function(t,o,e){var content=e(840);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,e(27).default)("77fbc800",content,!0,{sourceMap:!1})},839:function(t,o,e){"use strict";e(643)},840:function(t,o,e){var n=e(26)(!1);n.push([t.i,".v-item-group.v-bottom-navigation .v-btn.v-size--default{height:inherit;background:transparent}",""]),t.exports=n}}]);