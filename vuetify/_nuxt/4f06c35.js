(window.webpackJsonp=window.webpackJsonp||[]).push([[84],{1008:function(t,o,r){"use strict";r(835)},1009:function(t,o,r){var n=r(26)(!1);n.push([t.i,"h1{text-align:center}h2{margin-bottom:15px}",""]),t.exports=n},1118:function(t,o,r){"use strict";r.r(o);var n=r(1037),e=r(1127),l=r(445),c=r(178),v=r(756),_=r(82),f=Object(_.a)({},(function(){var t=this,o=t._self._c;return o(e.a,[o("h2",[t._v("Simple Tooltips")]),t._v(" "),o("div",{staticClass:"text-center d-flex align-center justify-space-around"},[o(v.a,{attrs:{bottom:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-btn",e,!1),n),[t._v("\n          Button\n        ")])]}}])},[t._v(" "),o("span",[t._v('Tooltip for "Button"')])]),t._v(" "),o(v.a,{attrs:{bottom:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(c.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-icon",e,!1),n),[t._v("\n          mdi-home\n        ")])]}}])},[t._v(" "),o("span",[t._v('Tooltip for "mdi-home"')])]),t._v(" "),o(v.a,{attrs:{bottom:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o("span",t._g(t._b({},"span",e,!1),n),[t._v("This text has a tooltip")])]}}])},[t._v(" "),o("span",[t._v('Tooltip for "This text has a tooltip"')])])],1)])}),[],!1,null,null,null).exports,m=Object(_.a)({},(function(){var t=this,o=t._self._c;return o(e.a,[o("h2",[t._v("Alignment")]),t._v(" "),o("div",{staticClass:"text-center d-flex align-center justify-space-around"},[o(v.a,{attrs:{left:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-btn",e,!1),n),[t._v("\n          Left\n        ")])]}}])},[t._v(" "),o("span",[t._v("Left tooltip")])]),t._v(" "),o(v.a,{attrs:{top:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-btn",e,!1),n),[t._v("\n          Top\n        ")])]}}])},[t._v(" "),o("span",[t._v("Top tooltip")])]),t._v(" "),o(v.a,{attrs:{bottom:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-btn",e,!1),n),[t._v("\n          Bottom\n        ")])]}}])},[t._v(" "),o("span",[t._v("Bottom tooltip")])]),t._v(" "),o(v.a,{attrs:{right:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-btn",e,!1),n),[t._v("\n          Right\n        ")])]}}])},[t._v(" "),o("span",[t._v("Right tooltip")])])],1)])}),[],!1,null,null,null).exports,d=Object(_.a)({},(function(){var t=this,o=t._self._c;return o(e.a,[o("h2",[t._v("Color")]),t._v(" "),o("div",{staticClass:"text-center d-flex align-center justify-space-around"},[o(v.a,{attrs:{bottom:"",color:"primary"},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"primary",dark:""}},"v-btn",e,!1),n),[t._v("\n          primary\n        ")])]}}])},[t._v(" "),o("span",[t._v("Primary tooltip")])]),t._v(" "),o(v.a,{attrs:{bottom:"",color:"success"},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"success",dark:""}},"v-btn",e,!1),n),[t._v("\n          success\n        ")])]}}])},[t._v(" "),o("span",[t._v("Success tooltip")])]),t._v(" "),o(v.a,{attrs:{bottom:"",color:"warning"},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"warning",dark:""}},"v-btn",e,!1),n),[t._v("\n          warning\n        ")])]}}])},[t._v(" "),o("span",[t._v("Warning tooltip")])]),t._v(" "),o(v.a,{attrs:{bottom:"",color:"error"},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{color:"error",dark:""}},"v-btn",e,!1),n),[t._v("\n          error\n        ")])]}}])},[t._v(" "),o("span",[t._v("Error tooltip")])])],1)])}),[],!1,null,null,null).exports,h=r(465),y={data:function(){return{show:!1}}},k={name:"Tooltips",components:{SimpleTooltip:f,AlignmentTooltips:m,ColorTooltips:d,ProgrammaticTooltip:Object(_.a)(y,(function(){var t=this,o=t._self._c;return o(e.a,[o("h2",[t._v("Programmatic Tooltip")]),t._v(" "),o(e.a,{staticClass:"text-center",attrs:{fluid:""}},[o(h.a,{staticClass:"flex",attrs:{justify:"space-between"}},[o(n.a,{attrs:{cols:"12"}},[o(l.a,{on:{click:function(o){t.show=!t.show}}},[t._v("\n          toggle\n        ")])],1),t._v(" "),o(n.a,{staticClass:"mt-12",attrs:{cols:"12"}},[o(v.a,{attrs:{top:""},scopedSlots:t._u([{key:"activator",fn:function(r){var n=r.on,e=r.attrs;return[o(l.a,t._g(t._b({attrs:{icon:""}},"v-btn",e,!1),n),[o(c.a,{attrs:{color:"grey lighten-1"}},[t._v("\n                mdi-cart\n              ")])],1)]}}]),model:{value:t.show,callback:function(o){t.show=o},expression:"show"}},[t._v(" "),o("span",[t._v("Programmatic tooltip")])])],1)],1)],1)],1)}),[],!1,null,null,null).exports}},x=(r(1008),Object(_.a)(k,(function(){var t=this,o=t._self._c;return o(e.a,{staticClass:"tooltips"},[o(n.a,[o("h1",[t._v("Tooltips")]),t._v(" "),o("p",{staticClass:"body-1 mt-2"},[t._v("\n      The "),o("code",[t._v("v-tooltip")]),t._v(" component is useful for conveying information when a user hovers over an element.\n    ")])]),t._v(" "),o("SimpleTooltip"),t._v(" "),o("AlignmentTooltips"),t._v(" "),o("ColorTooltips"),t._v(" "),o("ProgrammaticTooltip")],1)}),[],!1,null,null,null));o.default=x.exports},835:function(t,o,r){var content=r(1009);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,r(27).default)("24e30a1a",content,!0,{sourceMap:!1})}}]);