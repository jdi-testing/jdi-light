(window.webpackJsonp=window.webpackJsonp||[]).push([[52],{1095:function(t,e,o){"use strict";o.r(e);var n=o(1040),r=o(1130),l=o(435),c=o(178),d=o(182),m=o(121),v=o(52),_=o(187),f=o(101),x={data:function(){return{items:[{icon:"mdi-wifi",text:"Wifi"},{icon:"mdi-bluetooth",text:"Bluetooth"},{icon:"mdi-chart-donut",text:"Data Usage"}],model:1}}},h=(o(965),o(967),o(82)),C=Object(h.a)(x,(function(){var t=this,e=t._self._c;return e(l.a,{staticClass:"mx-auto",attrs:{"max-width":"400"}},[e(d.a,[e(_.a,{attrs:{dark:"","active-class":"border",color:"blue"},model:{value:t.model,callback:function(e){t.model=e},expression:"model"}},t._l(t.items,(function(o,i){return e(m.a,{key:i},[e(f.a,[e(c.a,{domProps:{textContent:t._s(o.icon)}})],1),t._v(" "),e(v.b,[e(v.d,{domProps:{textContent:t._s(o.text)}})],1)],1)})),1)],1)],1)}),[],!1,null,"9e631034",null).exports,y={data:function(){return{items:[{icon:"mdi-wifi",text:"Wifi"},{icon:"mdi-bluetooth",text:"Bluetooth"},{icon:"mdi-chart-donut",text:"Data Usage"}],model:1}}},L=Object(h.a)(y,(function(){var t=this,e=t._self._c;return e(l.a,{staticClass:"mx-auto",attrs:{"max-width":"400"}},[e(d.a,[e(_.a,{attrs:{mandatory:"",color:"indigo"},model:{value:t.model,callback:function(e){t.model=e},expression:"model"}},t._l(t.items,(function(o,i){return e(m.a,{key:i},[e(f.a,[e(c.a,{domProps:{textContent:t._s(o.icon)}})],1),t._v(" "),e(v.b,[e(v.d,{domProps:{textContent:t._s(o.text)}})],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,k={data:function(){return{items:[{icon:"mdi-wifi",text:"Wifi"},{icon:"mdi-bluetooth",text:"Bluetooth"},{icon:"mdi-chart-donut",text:"Data Usage"}],model:[1]}}},G=Object(h.a)(k,(function(){var t=this,e=t._self._c;return e(l.a,{staticClass:"mx-auto",attrs:{"max-width":"400"}},[e(d.a,[e(_.a,{attrs:{multiple:"",color:"indigo"},model:{value:t.model,callback:function(e){t.model=e},expression:"model"}},t._l(t.items,(function(o,i){return e(m.a,{key:i},[e(f.a,[e(c.a,{domProps:{textContent:t._s(o.icon)}})],1),t._v(" "),e(v.b,[e(v.d,{domProps:{textContent:t._s(o.text)}})],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,I={data:function(){return{items:[{icon:"mdi-wifi",text:"Wifi"},{icon:"mdi-bluetooth",text:"Bluetooth"},{icon:"mdi-chart-donut",text:"Data Usage"}],model:1}}},w=Object(h.a)(I,(function(){var t=this,e=t._self._c;return e(l.a,{staticClass:"mx-auto",attrs:{"max-width":"400"}},[e(d.a,{attrs:{flat:""}},[e(_.a,{attrs:{color:"indigo"},model:{value:t.model,callback:function(e){t.model=e},expression:"model"}},t._l(t.items,(function(o,i){return e(m.a,{key:i},[e(f.a,[e(c.a,{domProps:{textContent:t._s(o.icon)}})],1),t._v(" "),e(v.b,[e(v.d,{domProps:{textContent:t._s(o.text)}})],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,P=o(529),M=o(454),S=o(184),j={data:function(){return{items:["Dog Photos","Cat Photos","","Potatoes","Carrots"],model:["Carrots"]}}},O=Object(h.a)(j,(function(){var t=this,e=t._self._c;return e(l.a,{staticClass:"mx-auto",attrs:{"max-width":"500"}},[e(d.a,{attrs:{shaped:""}},[e(_.a,{attrs:{multiple:""},model:{value:t.model,callback:function(e){t.model=e},expression:"model"}},[t._l(t.items,(function(o,i){return[o?e(m.a,{key:"item-".concat(i),attrs:{value:o,"active-class":"deep-purple--text text--accent-4"},scopedSlots:t._u([{key:"default",fn:function(n){var r=n.active;return[e(v.b,[e(v.d,{domProps:{textContent:t._s(o)}})],1),t._v(" "),e(S.a,[e(P.a,{attrs:{"input-value":r,color:"deep-purple accent-4"}})],1)]}}],null,!0)}):e(M.a,{key:"divider-".concat(i)})]}))],2)],1)],1)}),[],!1,null,null,null).exports,A=o(183),W=o(18),D={data:function(){return{admins:[["Management","mdi-account-multiple-outline"],["Settings","mdi-cog-outline"]],cruds:[["Create","mdi-plus-outline"],["Read","mdi-file-outline"],["Update","mdi-update"],["Delete","mdi-delete"]]}}},U={name:"ListItemGroups",components:{ActiveClassListItemGroup:C,MandatoryListItemGroup:L,MultipleListItemGroup:G,FlatListListItemGroup:w,SelectionControlsListItemGroup:O,WithSubgroupListItemGroup:Object(h.a)(D,(function(){var t=this,e=t._self._c;return e(l.a,{staticClass:"mx-auto",attrs:{width:"300"}},[e(d.a,[e(m.a,[e(f.a,[e(c.a,[t._v("mdi-home")])],1),t._v(" "),e(v.d,[t._v("Home")])],1),t._v(" "),e(A.a,{attrs:{value:!0,"prepend-icon":"mdi-account-circle"},scopedSlots:t._u([{key:"activator",fn:function(){return[e(v.d,[t._v("Users")])]},proxy:!0}])},[t._v(" "),e(A.a,{attrs:{value:!0,"no-action":"","sub-group":""},scopedSlots:t._u([{key:"activator",fn:function(){return[e(v.b,[e(v.d,[t._v("Admin")])],1)]},proxy:!0}])},[t._v(" "),t._l(t.admins,(function(o,i){var n=Object(W.a)(o,2),title=n[0],r=n[1];return e(m.a,{key:i,attrs:{link:""}},[e(v.d,{domProps:{textContent:t._s(title)}}),t._v(" "),e(f.a,[e(c.a,{domProps:{textContent:t._s(r)}})],1)],1)}))],2),t._v(" "),e(A.a,{attrs:{"no-action":"","sub-group":""},scopedSlots:t._u([{key:"activator",fn:function(){return[e(v.b,[e(v.d,[t._v("Actions")])],1)]},proxy:!0}])},[t._v(" "),t._l(t.cruds,(function(o,i){var n=Object(W.a)(o,2),title=n[0],r=n[1];return e(m.a,{key:i,attrs:{link:""}},[e(v.d,{domProps:{textContent:t._s(title)}}),t._v(" "),e(f.a,[e(c.a,{domProps:{textContent:t._s(r)}})],1)],1)}))],2)],1)],1)],1)}),[],!1,null,null,null).exports}},B=Object(h.a)(U,(function(){var t=this,e=t._self._c;return e(r.a,[e(n.a,[e("h1",[t._v("List item groups")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),e("code",[t._v("v-list-item-group")]),t._v(" provides the ability to create a group of selectable "),e("code",[t._v("v-list-items")]),t._v(". \n            The "),e("code",[t._v("v-list-item-group")]),t._v(" component utilizes v-item-group at its core to provide a clean interface for interactive lists.\n        ")])]),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Active class list item group\n        ")]),t._v(" "),e("ActiveClassListItemGroup",{attrs:{id:"ActiveClassListItemGroup"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Mandatory list item group\n        ")]),t._v(" "),e("MandatoryListItemGroup",{attrs:{id:"MandatoryListItemGroup"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Multiple list item group\n        ")]),t._v(" "),e("MultipleListItemGroup",{attrs:{id:"MultipleListItemGroup"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Flat list list item group\n        ")]),t._v(" "),e("FlatListListItemGroup",{attrs:{id:"FlatListListItemGroup"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Selection controls list item group\n        ")]),t._v(" "),e("SelectionControlsListItemGroup",{attrs:{id:"SelectionControlsListItemGroup"}})],1),t._v(" "),e(n.a,[e("p",{staticClass:"text-h5"},[t._v("\n            No-action list item group with subgroup\n        ")]),t._v(" "),e("WithSubgroupListItemGroup",{attrs:{id:"WithSubgroupListItemGroup"}})],1)],1)}),[],!1,null,null,null);e.default=B.exports},821:function(t,e,o){var content=o(966);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,o(27).default)("0260b121",content,!0,{sourceMap:!1})},822:function(t,e,o){var content=o(968);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,o(27).default)("28a3366b",content,!0,{sourceMap:!1})},965:function(t,e,o){"use strict";o(821)},966:function(t,e,o){var n=o(26)(!1);n.push([t.i,".border[data-v-9e631034]{border:2px dashed orange}",""]),t.exports=n},967:function(t,e,o){"use strict";o(822)},968:function(t,e,o){var n=o(26)(!1);n.push([t.i,"#ActiveClassListItemGroup .v-item-group{background-color:#000}",""]),t.exports=n}}]);