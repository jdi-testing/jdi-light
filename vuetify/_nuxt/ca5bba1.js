(window.webpackJsonp=window.webpackJsonp||[]).push([[23],{1071:function(t,e,n){"use strict";n.r(e);var o=n(1017),r=n(1104),l=n(1020),c=n(445),v=n(157),h={data:function(){return{sheet:!1,tiles:[{img:"keep.png",title:"Keep"},{img:"inbox.png",title:"Inbox"},{img:"hangouts.png",title:"Hangouts"},{img:"messenger.png",title:"Messenger"},{img:"google.png",title:"Google+"}]}}},_=n(82),m=Object(_.a)(h,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(c.a,{attrs:{color:"blue",dark:""},on:{click:function(e){t.sheet=!t.sheet}}},[t._v(" Open v-model ")]),t._v(" "),e(l.a,{model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[e(v.a,{staticClass:"text-center",attrs:{height:"200px"}},[e(c.a,{staticClass:"mt-6",attrs:{text:"",color:"red"},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n                close\n            ")]),t._v(" "),e("div",{staticClass:"py-3"},[t._v("\n                This is a bottom sheet using the controlled by v-model\n                instead of activator\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports,d=n(435),f=n(178),x=n(182),k=n(121),C=n(52),y=n(101),O=n(458),S=n(495),B=Object(_.a)({},(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(l.a,{attrs:{inset:""},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,r=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"red",dark:""}},"v-btn",r,!1),o),[t._v("\n        Open Player\n      ")])]}}])},[t._v(" "),e(d.a,{attrs:{tile:""}},[e(O.a,{staticClass:"my-0",attrs:{value:50,height:"3"}}),t._v(" "),e(x.a,[e(k.a,[e(C.b,[e(C.d,[t._v("The Walker")]),t._v(" "),e(C.c,[t._v("Fitz & The Trantrums")])],1),t._v(" "),e(S.a),t._v(" "),e(y.a,[e(c.a,{attrs:{icon:""}},[e(f.a,[t._v("mdi-rewind")])],1)],1),t._v(" "),e(y.a,{class:{"mx-5":t.$vuetify.breakpoint.mdAndUp}},[e(c.a,{attrs:{icon:""}},[e(f.a,[t._v("mdi-pause")])],1)],1),t._v(" "),e(y.a,{staticClass:"ml-0",class:{"mr-3":t.$vuetify.breakpoint.mdAndUp}},[e(c.a,{attrs:{icon:""}},[e(f.a,[t._v("mdi-fast-forward")])],1)],1)],1)],1)],1)],1)],1)}),[],!1,null,null,null).exports,I=n(186),w=n(185),M=n(456),P={data:function(){return{sheet:!1,tiles:[{img:"keep.png",title:"Keep"},{img:"inbox.png",title:"Inbox"},{img:"hangouts.png",title:"Hangouts"},{img:"messenger.png",title:"Messenger"},{img:"google.png",title:"Google+"}]}}},j={data:function(){return{sheet:!1}}},T={data:function(){return{sheet:!1}}},L={name:"BottomSheets",components:{ModelBottomSheet:m,MusicPlayerBottomSheet:B,OpenInListBottomSheet:Object(_.a)(P,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(l.a,{scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,r=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"purple",dark:""}},"v-btn",r,!1),o),[t._v("\n                Open In\n            ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(x.a,[e(M.a,[t._v("Open in")]),t._v(" "),t._l(t.tiles,(function(n){return e(k.a,{key:n.title,on:{click:function(e){t.sheet=!1}}},[e(w.a,[e(I.a,{attrs:{size:"32px",tile:""}},[e("img",{attrs:{src:"https://cdn.vuetifyjs.com/images/bottom-sheets/".concat(n.img),alt:n.title}})])],1),t._v(" "),e(C.d,[t._v(t._s(n.title))])],1)}))],2)],1)],1)}),[],!1,null,null,null).exports,PersistentBottomSheet:Object(_.a)(j,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(l.a,{attrs:{persistent:""},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,r=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"green",dark:""}},"v-btn",r,!1),o),[t._v("\n                Open Persistent\n            ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(v.a,{staticClass:"text-center",attrs:{height:"200px"}},[e(c.a,{staticClass:"mt-6",attrs:{text:"",color:"error"},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n                close\n            ")]),t._v(" "),e("div",{staticClass:"py-3"},[t._v("\n                This is a bottom sheet using the persistent prop\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports,InsetBottomSheet:Object(_.a)(T,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(l.a,{attrs:{inset:""},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,r=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"orange",dark:""}},"v-btn",r,!1),o),[t._v("\n                Open Inset\n            ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(v.a,{staticClass:"text-center",attrs:{height:"200px"}},[e(c.a,{staticClass:"mt-6",attrs:{text:"",color:"error"},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n                close\n            ")]),t._v(" "),e("div",{staticClass:"my-3"},[t._v("\n                This is a bottom sheet using the inset prop\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports}},z=Object(_.a)(L,(function(){var t=this,e=t._self._c;return e(r.a,[e(o.a,[e("h1",[t._v("Bottom sheets")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n            The bottom sheet is a modified "),e("code",[t._v("v-dialog")]),t._v(" that slides from the bottom of the screen, \n            similar to a "),e("code",[t._v("v-bottom-navigation")]),t._v(". Whereas a bottom navigation component is for buttons \n            and specific application level actions, a bottom sheet can contain anything.\n        ")])]),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Inset bottom sheet")]),t._v(" "),e("InsetBottomSheet",{attrs:{id:"inset-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Model bottom sheet")]),t._v(" "),e("ModelBottomSheet",{attrs:{id:"model-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Persistent bottom sheet")]),t._v(" "),e("PersistentBottomSheet",{attrs:{id:"persistent-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Music Player bottom sheet")]),t._v(" "),e("MusicPlayerBottomSheet",{attrs:{id:"music-player-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Open In List bottom sheet")]),t._v(" "),e("OpenInListBottomSheet",{attrs:{id:"open-in-list-bottom-sheet"}})],1)],1)}),[],!1,null,null,null);e.default=z.exports}}]);