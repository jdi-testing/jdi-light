(window.webpackJsonp=window.webpackJsonp||[]).push([[86],{1122:function(e,t,n){"use strict";n.r(t);var r=n(1039),l=n(1129),o=n(447),c=n(439),m=n(456),d=n(179),h=n(122),v=n(185),_=n(52),f=n(182),y=n(480),w=n(1051),C=(n(61),n(54),{data:function(){return{benched:0}},computed:{items:function(){return Array.from({length:this.length},(function(e,t){return t+1}))},length:function(){return 7e3}}}),x=n(83),k=Object(x.a)(C,(function(){var e=this,t=e._self._c;return t("div",[t(f.a,{staticClass:"mx-auto mb-4",attrs:{"max-width":"400"}},[t(y.a,{attrs:{type:"number",label:"Total Benched",min:"0",max:"10"},model:{value:e.benched,callback:function(t){e.benched=t},expression:"benched"}})],1),e._v(" "),t(c.a,{staticClass:"mx-auto",attrs:{elevation:"16","max-width":"400"}},[t(w.a,{attrs:{bench:e.benched,items:e.items,height:"300","item-height":"64"},scopedSlots:e._u([{key:"default",fn:function(n){var r=n.item;return[t(h.a,{key:r},[t(v.a,[t(o.a,{attrs:{fab:"",small:"",depressed:"",color:"primary"}},[e._v("\n              "+e._s(r)+"\n            ")])],1),e._v(" "),t(_.b,[t(_.d,[e._v("\n              User Database Record "),t("strong",[e._v("ID "+e._s(r))])])],1),e._v(" "),t(v.a,[t(d.a,{attrs:{small:""}},[e._v("\n              mdi-open-in-new\n            ")])],1)],1),e._v(" "),t(m.a)]}}])})],1)],1)}),[],!1,null,null,null).exports,J=n(187),S=n(414),D=n(186),F=n(496),M=(n(40),{data:function(){return{colors:["#2196F3","#90CAF9","#64B5F6","#42A5F5","#1E88E5","#1976D2","#1565C0","#0D47A1","#82B1FF","#448AFF","#2979FF","#2962FF"],names:["Oliver","Jake","Noah","James","Jack","Connor","Liam","John","Harry","Callum","Mason","Robert","Jacob","Jacob","Jacob","Michael","Charlie","Kyle","William","William","Thomas","Joe","Ethan","David","George","Reece","Michael","Richard","Oscar","Rhys","Alexander","Joseph","James","Charlie","James","Charles","William","Damian","Daniel","Thomas","Amelia","Margaret","Emma","Mary","Olivia","Samantha","Olivia","Patricia","Isla","Bethany"],surnames:["Smith","Anderson","Clark","Wright","Mitchell","Johnson","Thomas","Rodriguez","Lopez","Perez","Williams","Jackson","Lewis","Hill","Roberts","Jones","White","Lee","Scott","Turner","Brown","Harris","Walker","Green","Phillips","Davis","Martin","Hall","Adams","Campbell","Miller","Thompson","Allen","Baker","Parker","Wilson","Garcia","Young","Gonzalez","Evans","Moore","Martinez","Hernandez","Nelson","Edwards","Taylor","Robinson","King","Carter","Collins"]}},computed:{items:function(){var e=this,t=this.names.length,n=this.surnames.length,r=this.colors.length;return Array.from({length:1e4},(function(l,o){var c=e.names[e.genRandomIndex(t)],m=e.surnames[e.genRandomIndex(n)];return{color:e.colors[e.genRandomIndex(r)],fullName:"".concat(c," ").concat(m),initials:"".concat(c[0]," ").concat(m[0])}}))}},methods:{genRandomIndex:function(e){return Math.ceil(Math.random()*(e-1))}}}),R={name:"VirtualScroller",components:{BenchVirtualScroller:k,UserDirectoryVirtualScroller:Object(x.a)(M,(function(){var e=this,t=e._self._c;return t(c.a,{staticClass:"mx-auto",attrs:{"max-width":"400"}},[t(S.d,{staticClass:"white--text orange darken-4"},[e._v("\n    User Directory\n\n    "),t(F.a),e._v(" "),t(o.a,{staticClass:"text--primary",attrs:{color:"white",fab:"",small:""}},[t(d.a,[e._v("mdi-plus")])],1)],1),e._v(" "),t(S.c,{staticClass:"pt-4"},[e._v("\n    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quasi nobis a at voluptates culpa optio amet! Inventore deserunt voluptatem maxime a veniam placeat, eos impedit nulla quos? Officiis, aperiam ducimus.\n  ")]),e._v(" "),t(m.a),e._v(" "),t(w.a,{attrs:{items:e.items,"item-height":50,height:"300"},scopedSlots:e._u([{key:"default",fn:function(n){var r=n.item;return[t(h.a,[t(D.a,[t(J.a,{staticClass:"white--text",attrs:{color:r.color,size:"56"}},[e._v("\n            "+e._s(r.initials)+"\n          ")])],1),e._v(" "),t(_.b,[t(_.d,[e._v(e._s(r.fullName))])],1),e._v(" "),t(v.a,[t(o.a,{attrs:{depressed:"",small:""}},[e._v("\n            View User\n\n            "),t(d.a,{attrs:{color:"orange darken-4",right:""}},[e._v("\n              mdi-open-in-new\n            ")])],1)],1)],1)]}}])})],1)}),[],!1,null,null,null).exports}},A=Object(x.a)(R,(function(){var e=this,t=e._self._c;return t(l.a,[t(r.a,[t("h1",[e._v("Virtual Scroller")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n        The "),t("code",[e._v("v-virtual-scroll")]),e._v(" component displays a virtual, infinite list. It supports dynamic height and scrolling vertically.\n        ")])]),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Bench\n        ")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n        By default the v-virtual-scroll does not pre-render additional items outside of the viewport. \n        Using the bench prop will have the scroller render additional items as padding. \n        It is recommended to keep this number as low as possible for the best possible performance.            \n        ")]),e._v(" "),t("BenchVirtualScroller",{attrs:{id:"BenchVirtualScroller"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            User directory\n        ")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n        The "),t("code",[e._v("v-virtual-scroll")]),e._v(" component can render an unlimited amount of items by rendering only \n        what it needs to fill the scroller’s viewport.            \n        ")]),e._v(" "),t("UserDirectoryVirtualScroller",{attrs:{id:"UserDirectoryVirtualScroller"}})],1)],1)}),[],!1,null,null,null);t.default=A.exports}}]);