(window.webpackJsonp=window.webpackJsonp||[]).push([[87],{1103:function(t,n,e){"use strict";e.r(n);var o=e(1040),r=e(1130),l=e(445),c=e(435),d=e(412),v=e(178),h=e(757),_=e(128),f=e(465),w=e(561),m=e(590),x={data:function(){return{length:3,onboarding:0}},methods:{next:function(){this.onboarding=this.onboarding+1===this.length?0:this.onboarding+1},prev:function(){this.onboarding=this.onboarding-1<0?this.length-1:this.onboarding-1}}},y=e(82),C=Object(y.a)(x,(function(){var t=this,n=t._self._c;return n(c.a,{attrs:{flat:"",tile:""}},[n(w.a,{attrs:{reverse:"","show-arrows":""},model:{value:t.onboarding,callback:function(n){t.onboarding=n},expression:"onboarding"}},t._l(t.length,(function(e){return n(m.a,{key:"card-".concat(e),attrs:{eager:""}},[n(c.a,{attrs:{color:"grey",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n("h1",{staticClass:"white--text",staticStyle:{"font-size":"5rem"}},[t._v("\n            Slide "+t._s(e)+"\n          ")])])],1)],1)})),1),t._v(" "),n(d.a,{staticClass:"justify-space-between"},[n(l.a,{attrs:{text:""},on:{click:t.prev}},[n(v.a,[t._v("mdi-chevron-left")])],1),t._v(" "),n(_.b,{staticClass:"text-center",attrs:{mandatory:""},model:{value:t.onboarding,callback:function(n){t.onboarding=n},expression:"onboarding"}},t._l(t.length,(function(e){return n(h.b,{key:"btn-".concat(e),scopedSlots:t._u([{key:"default",fn:function(e){var o=e.active,r=e.toggle;return[n(l.a,{attrs:{"input-value":o,icon:""},on:{click:r}},[n(v.a,[t._v("mdi-record")])],1)]}}],null,!0)})})),1),t._v(" "),n(l.a,{attrs:{text:""},on:{click:t.next}},[n(v.a,[t._v("mdi-chevron-right")])],1)],1)],1)}),[],!1,null,null,null).exports,k={data:function(){return{length:3,onboarding:0}},methods:{next:function(){this.onboarding=this.onboarding+1===this.length?0:this.onboarding+1},prev:function(){this.onboarding=this.onboarding-1<0?this.length-1:this.onboarding-1}}},j=Object(y.a)(k,(function(){var t=this,n=t._self._c;return n(c.a,{attrs:{flat:"",tile:""}},[n(w.a,{attrs:{vertical:"","show-arrows":"","show-arrows-on-hover":""},model:{value:t.onboarding,callback:function(n){t.onboarding=n},expression:"onboarding"}},t._l(t.length,(function(e){return n(m.a,{key:"card-".concat(e)},[n(c.a,{attrs:{color:"grey",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n("h1",{staticClass:"white--text",staticStyle:{"font-size":"5rem"}},[t._v("\n            Slide "+t._s(e)+"\n          ")])])],1)],1)})),1),t._v(" "),n(d.a,{staticClass:"justify-space-between"},[n(l.a,{attrs:{text:""},on:{click:t.prev}},[n(v.a,[t._v("mdi-chevron-left")])],1),t._v(" "),n(_.b,{staticClass:"text-center",attrs:{mandatory:""},model:{value:t.onboarding,callback:function(n){t.onboarding=n},expression:"onboarding"}},t._l(t.length,(function(e){return n(h.b,{key:"btn-".concat(e),scopedSlots:t._u([{key:"default",fn:function(e){var o=e.active,r=e.toggle;return[n(l.a,{attrs:{"input-value":o,icon:""},on:{click:r}},[n(v.a,[t._v("mdi-record")])],1)]}}],null,!0)})})),1),t._v(" "),n(l.a,{attrs:{text:""},on:{click:t.next}},[n(v.a,[t._v("mdi-chevron-right")])],1)],1)],1)}),[],!1,null,null,null).exports,W=Object(y.a)({},(function(){var t=this,n=t._self._c;return n(w.a,{attrs:{"show-arrows":""},scopedSlots:t._u([{key:"prev",fn:function(e){var o=e.on,r=e.attrs;return[n(l.a,t._g(t._b({attrs:{color:"success"}},"v-btn",r,!1),o),[t._v("Previous slide")])]}},{key:"next",fn:function(e){var o=e.on,r=e.attrs;return[n(l.a,t._g(t._b({attrs:{color:"info"}},"v-btn",r,!1),o),[t._v("Next slide")])]}}])},[t._v(" "),t._v(" "),t._l(5,(function(e){return n(m.a,{key:"card-".concat(e)},[n(c.a,{attrs:{color:"grey",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n("h1",{staticClass:"white--text",staticStyle:{"font-size":"5rem"}},[t._v("\n          Slide "+t._s(e)+"\n        ")])])],1)],1)}))],2)}),[],!1,null,null,null).exports,S=e(186),z=e(454),O=e(214),A=e(494),T=e(478),V={data:function(){return{step:1}},computed:{currentTitle:function(){switch(this.step){case 1:return"Sign-up";case 2:return"Create a password";default:return"Account created"}}}},D={data:function(){return{length:3,onboarding:0}},methods:{next:function(){this.onboarding=this.onboarding+1===this.length?0:this.onboarding+1},prev:function(){this.onboarding=this.onboarding-1<0?this.length-1:this.onboarding-1}}},P={name:"Windows",components:{ReverseWindow:C,VerticalWindow:j,CustomizedArrowsWindow:W,AccountCreationWindow:Object(y.a)(V,(function(){var t=this,n=t._self._c;return n(c.a,{staticClass:"mx-auto",attrs:{"max-width":"500"}},[n(d.d,{staticClass:"text-h6 font-weight-regular justify-space-between"},[n("span",[t._v(t._s(t.currentTitle))]),t._v(" "),n(S.a,{staticClass:"subheading white--text",attrs:{color:"primary lighten-2",size:"24"},domProps:{textContent:t._s(t.step)}})],1),t._v(" "),n(w.a,{model:{value:t.step,callback:function(n){t.step=n},expression:"step"}},[n(m.a,{attrs:{value:1}},[n(d.c,[n(T.a,{attrs:{label:"Email",value:"john@vuetifyjs.com"}}),t._v(" "),n("span",{staticClass:"text-caption grey--text text--darken-1"},[t._v("\n          This is the email you will use to login to your Vuetify account\n        ")])],1)],1),t._v(" "),n(m.a,{attrs:{value:2}},[n(d.c,[n(T.a,{attrs:{label:"Password",type:"password"}}),t._v(" "),n(T.a,{attrs:{label:"Confirm Password",type:"password"}}),t._v(" "),n("span",{staticClass:"text-caption grey--text text--darken-1"},[t._v("\n          Please enter a password for your account\n        ")])],1)],1),t._v(" "),n(m.a,{attrs:{value:3}},[n("div",{staticClass:"pa-4 text-center"},[n(O.a,{staticClass:"mb-4",attrs:{contain:"",height:"128",src:"https://cdn.vuetifyjs.com/images/logos/v.svg"}}),t._v(" "),n("h3",{staticClass:"text-h6 font-weight-light mb-2"},[t._v("\n          Welcome to Vuetify\n        ")]),t._v(" "),n("span",{staticClass:"text-caption grey--text"},[t._v("Thanks for signing up!")])],1)])],1),t._v(" "),n(z.a),t._v(" "),n(d.a,[n(l.a,{attrs:{disabled:1===t.step,text:""},on:{click:function(n){t.step--}}},[t._v("\n      Back\n    ")]),t._v(" "),n(A.a),t._v(" "),n(l.a,{attrs:{disabled:3===t.step,color:"primary",depressed:""},on:{click:function(n){t.step++}}},[t._v("\n      Next\n    ")])],1)],1)}),[],!1,null,null,null).exports,OnboardingWindow:Object(y.a)(D,(function(){var t=this,n=t._self._c;return n(c.a,{attrs:{color:"black",dark:"",flat:"",tile:""}},[n(w.a,{model:{value:t.onboarding,callback:function(n){t.onboarding=n},expression:"onboarding"}},t._l(t.length,(function(e){return n(m.a,{key:"card-".concat(e)},[n(c.a,{attrs:{color:"transparent",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n(d.c,[t._v("\n            Transparent themed, for background-imaged slides. Background color black added for demonstration purposes.\n          ")])],1)],1)],1)})),1),t._v(" "),n(d.a,{staticClass:"justify-space-between"},[n(l.a,{attrs:{text:""},on:{click:t.prev}},[n(v.a,[t._v("mdi-chevron-left")])],1),t._v(" "),n(_.b,{staticClass:"text-center",attrs:{mandatory:""},model:{value:t.onboarding,callback:function(n){t.onboarding=n},expression:"onboarding"}},t._l(t.length,(function(e){return n(h.b,{key:"btn-".concat(e),scopedSlots:t._u([{key:"default",fn:function(e){var o=e.active,r=e.toggle;return[n(l.a,{attrs:{"input-value":o,icon:""},on:{click:r}},[n(v.a,[t._v("mdi-record")])],1)]}}],null,!0)})})),1),t._v(" "),n(l.a,{attrs:{text:""},on:{click:t.next}},[n(v.a,[t._v("mdi-chevron-right")])],1)],1)],1)}),[],!1,null,null,null).exports,DisabledWindowItem:Object(y.a)({},(function(){var t=this,n=t._self._c;return n(c.a,{attrs:{flat:"",tile:""}},[n(w.a,{attrs:{"show-arrows":""}},[n(m.a,{attrs:{eager:""}},[n(c.a,{attrs:{color:"grey",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n("h1",{staticClass:"white--text",staticStyle:{"font-size":"5rem"}},[t._v("\n            Slide 1\n          ")])])],1)],1),t._v(" "),n(m.a,{attrs:{disabled:"",eager:""}},[n(c.a,{attrs:{color:"green",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n("h1",{staticClass:"black--text",staticStyle:{"font-size":"5rem"}},[t._v("\n                  Disabled\n                ")])])],1)],1),t._v(" "),n(m.a,{attrs:{eager:""}},[n(c.a,{attrs:{color:"blue",height:"200"}},[n(f.a,{staticClass:"fill-height",attrs:{align:"center",justify:"center"}},[n("h1",{staticClass:"red--text",staticStyle:{"font-size":"5rem"}},[t._v("\n                        Slide 3\n                      ")])])],1)],1)],1)],1)}),[],!1,null,null,null).exports}},R=Object(y.a)(P,(function(){var t=this,n=t._self._c;return n(r.a,[n(o.a,[n("h1",[t._v("Windows")]),t._v(" "),n("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),n("code",[t._v("v-window")]),t._v(" component provides the baseline functionality for transitioning content \n            from 1 pane to another. Other components such as "),n("code",[t._v("v-tabs")]),t._v(", "),n("code",[t._v("v-carousel")]),t._v(" and \n            "),n("code",[t._v("v-stepper")]),t._v(" utilize this component at their core.\n        ")])]),t._v(" "),n(o.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Reverse window\n        ")]),t._v(" "),n("ReverseWindow",{attrs:{id:"ReverseWindow"}})],1),t._v(" "),n(o.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Vertical window\n        ")]),t._v(" "),n("VerticalWindow",{attrs:{id:"VerticalWindow"}})],1),t._v(" "),n(o.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Customized arrows window\n        ")]),t._v(" "),n("CustomizedArrowsWindow",{attrs:{id:"CustomizedArrowsWindow"}})],1),t._v(" "),n(o.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Account creation window\n        ")]),t._v(" "),n("AccountCreationWindow",{attrs:{id:"AccountCreationWindow"}})],1),t._v(" "),n(o.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Onboarding window\n        ")]),t._v(" "),n("OnboardingWindow",{attrs:{id:"OnboardingWindow"}})],1),t._v(" "),n(o.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Disabled window item(№2 is disabled)\n        ")]),t._v(" "),n("DisabledWindowItem",{attrs:{id:"DisabledWindowItem"}})],1)],1)}),[],!1,null,null,null);n.default=R.exports}}]);