(window.webpackJsonp=window.webpackJsonp||[]).push([[75],{1088:function(t,e,n){"use strict";n.r(e);var r=n(1017),l=n(1104),o=n(435),c=n(451),d=n(178),_=n(182),v=n(121),m=n(184),h=n(52),f=n(456),y={data:function(){return{inset:!0,items:[{action:"mdi-label",title:"List item 1"},{divider:!0},{action:"mdi-label",title:"List item 2"},{divider:!0},{action:"mdi-label",title:"List item 3"}]}}},k=n(82),S=Object(k.a)(y,(function(){var t=this,e=t._self._c;return e(r.a,{attrs:{cols:"12",sm:"6","offset-sm":"3"}},[e(o.a,[e(f.a,{attrs:{inset:t.inset}},[t._v("\n      Subheader\n    ")]),t._v(" "),e(_.a,[t._l(t.items,(function(n,r){return[n.action?e(v.a,{key:n.title},[e(m.a,[e(d.a,[t._v(t._s(n.action))])],1),t._v(" "),e(h.b,[e(h.d,[t._v(t._s(n.title))])],1)],1):n.divider?e(c.a,{key:r,attrs:{inset:t.inset}}):t._e()]}))],2)],1)],1)}),[],!1,null,null,null).exports,x=n(445),w=n(913),C=n(465),M=n(495),j=n(467),I=n(430),G=Object(k.a)({},(function(){var t=this,e=t._self._c;return e(C.a,[e(r.a,{attrs:{cols:"12",sm:"6","offset-sm":"3"}},[e(o.a,[e(j.a,{attrs:{color:"white",flat:""}},[e(x.a,{attrs:{icon:"",light:""}},[e(d.a,{attrs:{color:"grey darken-2"}},[t._v("\n            mdi-arrow-left\n          ")])],1),t._v(" "),e(I.b,{staticClass:"grey--text text--darken-4"},[t._v("\n          Albums\n        ")]),t._v(" "),e(M.a),t._v(" "),e(x.a,{attrs:{icon:"",light:""}},[e(d.a,{attrs:{color:"grey darken-2"}},[t._v("\n            mdi-magnify\n          ")])],1)],1),t._v(" "),e(f.a,[t._v("May")]),t._v(" "),e(l.a,{attrs:{fluid:""}},[e(C.a,t._l(6,(function(i){return e(r.a,{key:i,attrs:{cols:"4"}},[e("img",{staticClass:"image",attrs:{src:"https://randomuser.me/api/portraits/men/".concat(i+20,".jpg"),alt:"lorem",height:"100%",width:"100%"}})])})),1)],1),t._v(" "),e(f.a,[t._v("June")]),t._v(" "),e(l.a,{attrs:{fluid:""}},[e(C.a,t._l(6,(function(i){return e(r.a,{key:i,attrs:{cols:"4"}},[e("img",{staticClass:"image",attrs:{src:"https://randomuser.me/api/portraits/women/".concat(i+5,".jpg"),alt:"lorem",height:"100%",width:"100%"}})])})),1)],1),t._v(" "),e(w.a,{staticClass:"mt-12"})],1)],1)],1)}),[],!1,null,null,null).exports,O=n(579),L={data:function(){return{items:[{action:"mdi-inbox-arrow-down",title:"Inbox"},{action:"mdi-send",title:"Sent"},{action:"mdi-delete",title:"Trash"},{action:"mdi-alert-octagon",title:"Spam"},{divider:!0},{header:"Labels"},{action:"mdi-label",title:"Family"},{action:"mdi-label",title:"Friends"},{action:"mdi-label",title:"Work"}]}}},F=Object(k.a)(L,(function(){var t=this,e=t._self._c;return e(C.a,[e(r.a,{attrs:{cols:"12",sm:"6","offset-sm":"3"}},[e(o.a,[e(j.a,{attrs:{color:"teal",dark:""}},[e(O.a),t._v(" "),e(I.b,[t._v("Manage")]),t._v(" "),e(M.a),t._v(" "),e(x.a,{attrs:{icon:""}},[e(d.a,[t._v("mdi-dots-vertical")])],1)],1),t._v(" "),e(_.a,[t._l(t.items,(function(n,r){return[n.action?e(v.a,{key:n.title},[e(m.a,[e(d.a,[t._v(t._s(n.action))])],1),t._v(" "),e(h.b,[e(h.d,[t._v(t._s(n.title))])],1)],1):n.divider?e(c.a,{key:r}):n.header?e(f.a,{key:n.header},[t._v("\n            "+t._s(n.header)+"\n          ")]):t._e()]}))],2)],1)],1)],1)}),[],!1,null,null,null).exports,J=n(412),P=n(215),A={data:function(){return{types:["Places to Be","Places to See"],cards:["Good","Best","Finest"],socials:[{icon:"mdi-facebook",color:"indigo"},{icon:"mdi-linkedin",color:"cyan darken-1"},{icon:"mdi-instagram",color:"red lighten-3"}]}},methods:{getImage:function(){return Math.floor(11*Math.random())+550}}},B={name:"Subheaders",components:{InsetSubheader:S,GridSubheader:G,MenuSubheader:F,SocialMediaSubheader:Object(k.a)(A,(function(){var t=this,e=t._self._c;return e(o.a,{attrs:{flat:"",tile:""}},[e(j.a,{attrs:{color:"cyan",dark:""}},[e(O.a),t._v(" "),e(I.b,[t._v("Application")]),t._v(" "),e(M.a),t._v(" "),e(x.a,{attrs:{icon:""}},[e(d.a,[t._v("mdi-magnify")])],1)],1),t._v(" "),t._l(t.types,(function(n){return e(l.a,{key:n,staticClass:"grey lighten-4",attrs:{fluid:""}},[e(f.a,[t._v(t._s(n))]),t._v(" "),e(C.a,[e(M.a),t._v(" "),t._l(t.cards,(function(n){return e(r.a,{key:n,attrs:{cols:"12",sm:"6",md:"4"}},[e(o.a,[e(P.a,{attrs:{src:"https://picsum.photos/200/300?image=".concat(t.getImage()),height:"300px"}},[e("span",{staticClass:"text-h5 white--text pl-4 pt-4 d-inline-block",domProps:{textContent:t._s(n)}})]),t._v(" "),e(J.a,{staticClass:"white justify-center"},t._l(t.socials,(function(n,i){return e(x.a,{key:i,staticClass:"white--text",attrs:{color:n.color,fab:"",icon:"",small:""}},[e(d.a,[t._v(t._s(n.icon))])],1)})),1)],1)],1)}))],2)],1)}))],2)}),[],!1,null,null,null).exports}},T=Object(k.a)(B,(function(){var t=this,e=t._self._c;return e(l.a,[e(r.a,[e("h1",[t._v("Subheader")]),t._v(" "),e("p",{staticClass:"body-1 mt-2"},[t._v("\n         The "),e("code",[t._v("v-subheader")]),t._v(" component is used to separate sections of lists.\n        ")])]),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Inset\n        ")]),t._v(" "),e("InsetSubheader",{attrs:{id:"InsetSubheader"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Grid\n        ")]),t._v(" "),e("GridSubheader",{attrs:{id:"GridSubheader"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Menu\n        ")]),t._v(" "),e("MenuSubheader",{attrs:{id:"MenuSubheader"}})],1),t._v(" "),e(r.a,[e("p",{staticClass:"text-h5"},[t._v("\n            Social Media\n        ")]),t._v(" "),e("SocialMediaSubheader",{attrs:{id:"SocialMediaSubheader"}})],1)],1)}),[],!1,null,null,null);e.default=T.exports}}]);