(window.webpackJsonp=window.webpackJsonp||[]).push([[55],{1073:function(t,r,n){"use strict";n.r(r);var e=n(1040),o=n(1130),l=n(846),v=n(597),c=n(446),d=n(435),_=n(412),m=n(178),w=n(182),h=n(121),f=n(187),x=n(52),k=n(408),C=n(496),D=n(571),y=n(416),N={data:function(){return{drawer:!1,group:null}},watch:{group:function(){this.drawer=!1}}},j=n(82),O=Object(j.a)(N,(function(){var t=this,r=t._self._c;return r(d.a,{staticClass:"mx-auto overflow-hidden",attrs:{height:"400",width:"344"}},[r(D.a,{attrs:{color:"deep-purple darken-3"}}),t._v(" "),r(l.a,{attrs:{color:"deep-purple accent-4",dark:"",prominent:""}},[r(v.a,{on:{click:function(r){r.stopPropagation(),t.drawer=!t.drawer}}}),t._v(" "),r(y.b,[t._v("My files")]),t._v(" "),r(C.a),t._v(" "),r(c.a,{attrs:{icon:""}},[r(m.a,[t._v("mdi-magnify")])],1),t._v(" "),r(c.a,{attrs:{icon:""}},[r(m.a,[t._v("mdi-filter")])],1),t._v(" "),r(c.a,{attrs:{icon:""}},[r(m.a,[t._v("mdi-dots-vertical")])],1)],1),t._v(" "),r(k.a,{attrs:{absolute:"",bottom:"",temporary:""},model:{value:t.drawer,callback:function(r){t.drawer=r},expression:"drawer"}},[r(w.a,{attrs:{nav:"",dense:""}},[r(f.a,{attrs:{"active-class":"deep-purple--text text--accent-4"},model:{value:t.group,callback:function(r){t.group=r},expression:"group"}},[r(h.a,[r(x.d,[t._v("Foo")])],1),t._v(" "),r(h.a,[r(x.d,[t._v("Bar")])],1),t._v(" "),r(h.a,[r(x.d,[t._v("Fizz")])],1),t._v(" "),r(h.a,[r(x.d,[t._v("Buzz")])],1)],1)],1)],1),t._v(" "),r(_.c,[t._v("\n    The navigation drawer will appear from the bottom on smaller size screens.\n  ")])],1)}),[],!1,null,null,null).exports,A=n(454),H=n(214),P=n(185),S=n(101),M={},T=Object(j.a)(M,(function(){var t=this,r=t._self._c;return r("div",{staticClass:"ma-12 pa-12"},[r(d.a,[r(k.a,{attrs:{permanent:"","expand-on-hover":""}},[r(w.a,[r(h.a,{staticClass:"px-2"},[r(P.a,[r(H.a,{attrs:{src:"https://randomuser.me/api/portraits/women/85.jpg"}})],1)],1),t._v(" "),r(h.a,{attrs:{link:""}},[r(x.b,[r(x.d,{staticClass:"text-h6"},[t._v("\n              Sandra Adams\n            ")]),t._v(" "),r(x.c,[t._v("sandra_a88@gmail.com")])],1)],1)],1),t._v(" "),r(A.a),t._v(" "),r(w.a,{attrs:{nav:"",dense:""}},[r(h.a,{attrs:{link:""}},[r(S.a,[r(m.a,[t._v("mdi-folder")])],1),t._v(" "),r(x.d,[t._v("My Files")])],1),t._v(" "),r(h.a,{attrs:{link:""}},[r(S.a,[r(m.a,[t._v("mdi-account-multiple")])],1),t._v(" "),r(x.d,[t._v("Shared with me")])],1),t._v(" "),r(h.a,{attrs:{link:""}},[r(S.a,[r(m.a,[t._v("mdi-star")])],1),t._v(" "),r(x.d,[t._v("Starred")])],1)],1)],1)],1)],1)}),[],!1,null,null,null).exports,F=n(18),z={data:function(){return{items:[["mdi-email","Inbox"],["mdi-account-supervisor-circle","Supervisors"],["mdi-clock-start","Clock-in"]]}}},B=Object(j.a)(z,(function(){var t=this,r=t._self._c;return r(d.a,{staticClass:"mx-auto",attrs:{height:"300",width:"300"}},[r(k.a,{attrs:{absolute:"",dark:"",src:"https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg",width:"100%",permanent:""}},[r(w.a,t._l(t.items,(function(n,i){var e=Object(F.a)(n,2),o=e[0],text=e[1];return r(h.a,{key:i,attrs:{link:""}},[r(S.a,[r(m.a,[t._v(t._s(o))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(text))])],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,I={data:function(){return{drawer:!0,items:[{title:"Home",icon:"mdi-home-city"},{title:"My Account",icon:"mdi-account"},{title:"Users",icon:"mdi-account-group-outline"}],mini:!0}}},J=Object(j.a)(I,(function(){var t=this,r=t._self._c;return r(d.a,[r(k.a,{attrs:{"mini-variant":t.mini,permanent:""},on:{"update:miniVariant":function(r){t.mini=r},"update:mini-variant":function(r){t.mini=r}},model:{value:t.drawer,callback:function(r){t.drawer=r},expression:"drawer"}},[r(h.a,{staticClass:"px-2"},[r(P.a,[r(H.a,{attrs:{src:"https://randomuser.me/api/portraits/men/85.jpg"}})],1),t._v(" "),r(x.d,[t._v("John Leider")]),t._v(" "),r(c.a,{attrs:{icon:""},on:{click:function(r){r.stopPropagation(),t.mini=!t.mini}}},[r(m.a,[t._v("mdi-chevron-left")])],1)],1),t._v(" "),r(A.a),t._v(" "),r(w.a,{attrs:{dense:""}},t._l(t.items,(function(n){return r(h.a,{key:n.title,attrs:{link:""}},[r(S.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,E={data:function(){return{items:[{title:"Home",icon:"mdi-view-dashboard"},{title:"About",icon:"mdi-forum"}]}}},L=Object(j.a)(E,(function(){var t=this,r=t._self._c;return r(d.a,{staticClass:"pa-12",attrs:{color:"indigo darken-2",flat:""}},[r(d.a,{attrs:{elevation:"12",width:"256"}},[r(k.a,{attrs:{floating:"",permanent:""}},[r(w.a,{attrs:{dense:"",rounded:""}},t._l(t.items,(function(n){return r(h.a,{key:n.title,attrs:{link:""}},[r(S.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1)],1)],1)}),[],!1,null,null,null).exports,R={data:function(){return{items:[{title:"Home",icon:"mdi-home-city"},{title:"My Account",icon:"mdi-account"},{title:"Users",icon:"mdi-account-group-outline"}]}}},V=Object(j.a)(R,(function(){var t=this,r=t._self._c;return r(d.a,{attrs:{height:"350px"}},[r(k.a,{attrs:{absolute:"",permanent:"",right:""},scopedSlots:t._u([{key:"prepend",fn:function(){return[r(h.a,{attrs:{"two-line":""}},[r(P.a,[r("img",{attrs:{src:"https://randomuser.me/api/portraits/women/81.jpg"}})]),t._v(" "),r(x.b,[r(x.d,[t._v("Jane Smith")]),t._v(" "),r(x.c,[t._v("Logged In")])],1)],1)]},proxy:!0}])},[t._v(" "),r(A.a),t._v(" "),r(w.a,{attrs:{dense:""}},t._l(t.items,(function(n){return r(h.a,{key:n.title},[r(S.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,U=n(465),W=n(157),G={data:function(){return{drawer:null,items:[{title:"Home",icon:"mdi-view-dashboard"},{title:"About",icon:"mdi-forum"}]}}},K=Object(j.a)(G,(function(){var t=this,r=t._self._c;return r(W.a,{staticClass:"overflow-hidden",staticStyle:{position:"relative"},attrs:{height:"400"}},[r(o.a,{staticClass:"fill-height"},[r(U.a,{attrs:{align:"center",justify:"center"}},[r(c.a,{attrs:{color:"pink",dark:""},on:{click:function(r){r.stopPropagation(),t.drawer=!t.drawer}}},[t._v("\n        Toggle\n      ")])],1)],1),t._v(" "),r(k.a,{attrs:{absolute:"",temporary:""},model:{value:t.drawer,callback:function(r){t.drawer=r},expression:"drawer"}},[r(h.a,[r(P.a,[r(H.a,{attrs:{src:"https://randomuser.me/api/portraits/men/78.jpg"}})],1),t._v(" "),r(x.b,[r(x.d,[t._v("John Leider")])],1)],1),t._v(" "),r(A.a),t._v(" "),r(w.a,{attrs:{dense:""}},t._l(t.items,(function(n){return r(h.a,{key:n.title,attrs:{link:""}},[r(S.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,Q={data:function(){return{items:[{title:"Dashboard",icon:"mdi-view-dashboard"},{title:"Account",icon:"mdi-account-box"},{title:"Admin",icon:"mdi-gavel"}]}}},X=Object(j.a)(Q,(function(){var t=this,r=t._self._c;return r(d.a,{staticClass:"mx-auto",attrs:{height:"400",width:"256"}},[r(k.a,{staticClass:"deep-purple accent-4",attrs:{dark:"",permanent:""},scopedSlots:t._u([{key:"append",fn:function(){return[r("div",{staticClass:"pa-2"},[r(c.a,{attrs:{block:""}},[t._v("\n          Logout\n        ")])],1)]},proxy:!0}])},[r(w.a,t._l(t.items,(function(n){return r(h.a,{key:n.title,attrs:{link:""}},[r(S.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1)],1)}),[],!1,null,null,null).exports,Y=n(184),Z={data:function(){return{items:[{title:"Home",icon:"mdi-view-dashboard"},{title:"About",icon:"mdi-forum"}],links:["Home","Contacts","Settings"],mini:!0}}},$=Object(j.a)(Z,(function(){var t=this,r=t._self._c;return r(d.a,{staticClass:"mx-auto",attrs:{height:"300",width:"330"}},[r(k.a,{attrs:{permanent:"",width:"100%"}},[r(U.a,{staticClass:"fill-height",attrs:{"no-gutters":""}},[r(k.a,{attrs:{dark:"","mini-variant":"","mini-variant-width":"56",permanent:""}},[r(h.a,{staticClass:"px-2"},[r(P.a,[r(H.a,{attrs:{src:"https://randomuser.me/api/portraits/women/75.jpg"}})],1)],1),t._v(" "),r(A.a),t._v(" "),r(w.a,{attrs:{dense:"",nav:""}},t._l(t.items,(function(n){return r(h.a,{key:n.title},[r(Y.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1),t._v(" "),r(w.a,{staticClass:"grow"},t._l(t.links,(function(link){return r(h.a,{key:link,attrs:{link:""}},[r(x.d,{domProps:{textContent:t._s(link)}})],1)})),1)],1)],1)],1)}),[],!1,null,null,null).exports,tt=n(407),at=n(409),it={data:function(){return{items:[{title:"Dashboard",icon:"mdi-view-dashboard"},{title:"Photos",icon:"mdi-image"},{title:"About",icon:"mdi-help-box"}],right:null}}},nt={name:"NavigationDrawers",components:{BottomDrawerNavigationDrawer:O,ExpandOnHoverNavigationDrawer:T,ImagesNavigationDrawer:B,MiniVariantNavigationDrawer:J,PermanentAndFloatingNavigationDrawer:L,RightNavigationDrawer:V,TemporaryNavigationDrawer:K,ColoredDrawerNavigationDrawer:X,CombinedDrawerNavigationDrawer:$,ClippedNavigationDrawer:Object(j.a)(it,(function(){var t=this,r=t._self._c;return r(d.a,[r(tt.a,[r(at.a,{staticClass:"pl-0"},[r(l.a,{attrs:{absolute:"","clipped-right":"",dense:"",flat:""}}),t._v(" "),r(k.a,{attrs:{clipped:"",permanent:""}},[r(h.a,[r(x.b,[r(x.d,{staticClass:"text-h6"}),t._v(" "),r(x.c)],1)],1),t._v(" "),r(A.a),t._v(" "),r(w.a,{attrs:{dense:"",nav:""}},t._l(t.items,(function(n){return r(h.a,{key:n.title,attrs:{link:""}},[r(S.a,[r(m.a,[t._v(t._s(n.icon))])],1),t._v(" "),r(x.b,[r(x.d,[t._v(t._s(n.title))])],1)],1)})),1)],1)],1)],1)],1)}),[],!1,null,null,null).exports}},et=Object(j.a)(nt,(function(){var t=this,r=t._self._c;return r(o.a,[r(e.a,[r("h1",[t._v("Navigation drawers")]),t._v(" "),r("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),r("code",[t._v("v-navigation-drawer")]),t._v(" component is what your users will utilize to navigate through the application. \n            The navigation-drawer is pre-configured to work with or without vue-router right out the box. \n            For the purpose of display, some examples are wrapped in a "),r("code",[t._v("v-card")]),t._v(" element. \n            Within your application you will generally place the "),r("code",[t._v("v-navigation-drawer")]),t._v(" as a direct child of v-app\n        ")])]),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Bottom drawer navigation drawer\n        ")]),t._v(" "),r("BottomDrawerNavigationDrawer",{attrs:{id:"BottomDrawerNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Expand on hover navigation drawer\n        ")]),t._v(" "),r("ExpandOnHoverNavigationDrawer",{attrs:{id:"ExpandOnHoverNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Images navigation drawer\n        ")]),t._v(" "),r("ImagesNavigationDrawer",{attrs:{id:"ImagesNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Mini variant navigation drawer\n        ")]),t._v(" "),r("MiniVariantNavigationDrawer",{attrs:{id:"MiniVariantNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Permanent and floating navigation drawer\n        ")]),t._v(" "),r("PermanentAndFloatingNavigationDrawer",{attrs:{id:"PermanentAndFloatingNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Right navigation drawer\n        ")]),t._v(" "),r("RightNavigationDrawer",{attrs:{id:"RightNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Temporary navigation drawer\n        ")]),t._v(" "),r("TemporaryNavigationDrawer",{attrs:{id:"TemporaryNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Colored navigation drawer\n        ")]),t._v(" "),r("ColoredDrawerNavigationDrawer",{attrs:{id:"ColoredDrawerNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Combined navigation drawer\n        ")]),t._v(" "),r("CombinedDrawerNavigationDrawer",{attrs:{id:"CombinedDrawerNavigationDrawer"}})],1),t._v(" "),r(e.a,[r("p",{staticClass:"text-h5"},[t._v("\n            Clipped navigation drawer\n        ")]),t._v(" "),r("ClippedNavigationDrawer",{attrs:{id:"ClippedNavigationDrawer"}})],1)],1)}),[],!1,null,null,null);r.default=et.exports}}]);