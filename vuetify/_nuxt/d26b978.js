(window.webpackJsonp=window.webpackJsonp||[]).push([[22],{1098:function(t,e,n){"use strict";n.r(e);var o=n(1040),l=n(1130),r=n(1043),c=n(446),v=n(157),h={data:function(){return{sheet:!1,tiles:[{img:"keep.png",title:"Keep"},{img:"inbox.png",title:"Inbox"},{img:"hangouts.png",title:"Hangouts"},{img:"messenger.png",title:"Messenger"},{img:"google.png",title:"Google+"}]}}},_=n(82),m=Object(_.a)(h,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(c.a,{attrs:{color:"blue",dark:""},on:{click:function(e){t.sheet=!t.sheet}}},[t._v(" Open v-model ")]),t._v(" "),e(r.a,{attrs:{fullscreen:""},model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[e(v.a,{staticClass:"text-center",attrs:{height:"100%"}},[e(c.a,{staticClass:"mt-6",attrs:{text:"",color:"red"},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n                close\n            ")]),t._v(" "),e("div",{staticClass:"py-3"},[t._v("\n                This is a bottom sheet using the controlled by v-model\n                instead of activator\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports,d=n(435),f=n(178),x=n(182),k=n(121),y=n(52),C=n(101),S=n(464),B=n(496),O=Object(_.a)({},(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(r.a,{attrs:{inset:""},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,l=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"red",dark:""}},"v-btn",l,!1),o),[t._v("\n        Open Player\n      ")])]}}])},[t._v(" "),e(d.a,{attrs:{tile:""}},[e(S.a,{staticClass:"my-0",attrs:{value:50,height:"3"}}),t._v(" "),e(x.a,[e(k.a,[e(y.b,[e(y.d,[t._v("The Walker")]),t._v(" "),e(y.c,[t._v("Fitz & The Trantrums")])],1),t._v(" "),e(B.a),t._v(" "),e(C.a,[e(c.a,{attrs:{icon:""}},[e(f.a,[t._v("mdi-rewind")])],1)],1),t._v(" "),e(C.a,{class:{"mx-5":t.$vuetify.breakpoint.mdAndUp}},[e(c.a,{attrs:{icon:""}},[e(f.a,[t._v("mdi-pause")])],1)],1),t._v(" "),e(C.a,{staticClass:"ml-0",class:{"mr-3":t.$vuetify.breakpoint.mdAndUp}},[e(c.a,{attrs:{icon:""}},[e(f.a,[t._v("mdi-fast-forward")])],1)],1)],1)],1)],1)],1)],1)}),[],!1,null,null,null).exports,I=n(186),w=n(185),j=n(458),M={data:function(){return{sheet:!1,tiles:[{img:"keep.png",title:"Keep"},{img:"inbox.png",title:"Inbox"},{img:"hangouts.png",title:"Hangouts"},{img:"messenger.png",title:"Messenger"},{img:"google.png",title:"Google+"}]}}},P=Object(_.a)(M,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(r.a,{scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,l=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"purple",dark:""}},"v-btn",l,!1),o),[t._v("\n                Open In\n            ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(x.a,[e(j.a,[t._v("Open in")]),t._v(" "),t._l(t.tiles,(function(n){return e(k.a,{key:n.title,on:{click:function(e){t.sheet=!1}}},[e(w.a,[e(I.a,{attrs:{size:"32px",tile:""}},[e("img",{attrs:{src:"https://cdn.vuetifyjs.com/images/bottom-sheets/".concat(n.img),alt:n.title}})])],1),t._v(" "),e(y.d,[t._v(t._s(n.title))])],1)}))],2)],1)],1)}),[],!1,null,null,null).exports,T={data:function(){return{sheet:!1}}},z=Object(_.a)(T,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(r.a,{attrs:{persistent:"","overlay-color":"purple","overlay-opacity":"0.1",width:"500"},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,l=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"green",dark:""}},"v-btn",l,!1),o),[t._v("\n                Open Persistent\n            ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(v.a,{staticClass:"text-center",attrs:{height:"200px"}},[e(c.a,{staticClass:"mt-6",attrs:{text:"",color:"error"},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n                close\n            ")]),t._v(" "),e("div",{staticClass:"py-3"},[t._v("\n                This is a bottom sheet using the persistent prop\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports,L={data:function(){return{sheet:!1}}},A=Object(_.a)(L,(function(){var t=this,e=t._self._c;return e("div",{staticClass:"text-center"},[e(r.a,{attrs:{inset:""},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,l=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"orange",dark:""}},"v-btn",l,!1),o),[t._v("\n                Open Inset\n            ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(v.a,{staticClass:"text-center",attrs:{height:"200px"}},[e(c.a,{staticClass:"mt-6",attrs:{text:"",color:"error"},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n                close\n            ")]),t._v(" "),e("div",{staticClass:"my-3"},[t._v("\n                This is a bottom sheet using the inset prop\n            ")])],1)],1)],1)}),[],!1,null,null,null).exports,G=n(407),H=n(412),J=n(454),K=n(798),U=n(797),W={data:function(){return{sheet:!1}}},$={name:"BottomSheets",components:{ModelBottomSheet:m,MusicPlayerBottomSheet:O,OpenInListBottomSheet:P,PersistentBottomSheet:z,InsetBottomSheet:A,ScrollableBottomSheet:Object(_.a)(W,(function(){var t=this,e=t._self._c;return e("div",{attrs:{id:"app"}},[e(G.a,{attrs:{id:"inspire"}},[e("div",{staticClass:"text-center"},[e(r.a,{attrs:{inset:"",scrollable:"","hide-overlay":""},scopedSlots:t._u([{key:"activator",fn:function(n){var o=n.on,l=n.attrs;return[e(c.a,t._g(t._b({attrs:{color:"orange",dark:""}},"v-btn",l,!1),o),[t._v("\n            Open scrollable dialog in bottom sheet\n          ")])]}}]),model:{value:t.sheet,callback:function(e){t.sheet=e},expression:"sheet"}},[t._v(" "),e(d.a,[e(H.d,[t._v("Select Country")]),t._v(" "),e(J.a),t._v(" "),e(H.c,{staticStyle:{height:"100px"}},[e(U.a,{attrs:{column:""},model:{value:t.dialogm1,callback:function(e){t.dialogm1=e},expression:"dialogm1"}},[e(K.a,{attrs:{label:"Bahamas, The",value:"bahamas"}}),t._v(" "),e(K.a,{attrs:{label:"Belarus",value:"belarus"}}),t._v(" "),e(K.a,{attrs:{label:"Belgium",value:"belgium"}}),t._v(" "),e(K.a,{attrs:{label:"Brazil",value:"brazil"}}),t._v(" "),e(K.a,{attrs:{label:"Bulgaria",value:"bulgaria"}})],1)],1),t._v(" "),e(J.a),t._v(" "),e(H.a,[e(c.a,{attrs:{color:"blue darken-1",text:""},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n              Close\n            ")]),t._v(" "),e(c.a,{attrs:{color:"blue darken-1",text:""},on:{click:function(e){t.sheet=!t.sheet}}},[t._v("\n              Save\n            ")])],1)],1)],1)],1)])],1)}),[],!1,null,null,null).exports}},F=Object(_.a)($,(function(){var t=this,e=t._self._c;return e(l.a,[e(o.a,[e("h1",[t._v("Bottom sheets")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n            The bottom sheet is a modified "),e("code",[t._v("v-dialog")]),t._v(" that slides from the bottom of the screen, \n            similar to a "),e("code",[t._v("v-bottom-navigation")]),t._v(". Whereas a bottom navigation component is for buttons \n            and specific application level actions, a bottom sheet can contain anything.\n        ")])]),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Inset bottom sheet")]),t._v(" "),e("InsetBottomSheet",{attrs:{id:"inset-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Model bottom sheet")]),t._v(" "),e("ModelBottomSheet",{attrs:{id:"model-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Persistent bottom sheet")]),t._v(" "),e("PersistentBottomSheet",{attrs:{id:"persistent-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Music Player bottom sheet")]),t._v(" "),e("MusicPlayerBottomSheet",{attrs:{id:"music-player-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Open In List bottom sheet")]),t._v(" "),e("OpenInListBottomSheet",{attrs:{id:"open-in-list-bottom-sheet"}})],1),t._v(" "),e(o.a,[e("p",{staticClass:"text-h5"},[t._v("Scrollable bottom sheet")]),t._v(" "),e("ScrollableBottomSheet",{attrs:{id:"scrollable-bottom-sheet"}})],1)],1)}),[],!1,null,null,null);e.default=F.exports}}]);