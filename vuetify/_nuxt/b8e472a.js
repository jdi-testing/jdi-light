(window.webpackJsonp=window.webpackJsonp||[]).push([[44],{1022:function(t,e,n){"use strict";n.r(e);var r=n(74),o=n(169),l=n.n(o),c=n(953),v=n(850),component=Object(r.a)({},(function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-footer",{attrs:{padless:"",id:"footer-padless"}},[n("v-col",{staticClass:"text-center",attrs:{cols:"12"}},[t._v("\n    "+t._s((new Date).getFullYear())+" — "),n("strong",[t._v("Vuetify")])])],1)}),[],!1,null,null,null),d=component.exports;l()(component,{VCol:c.a,VFooter:v.a});var m={data:function(){return{links:["Home","About Us","Team","Services","Blog","Contact Us"]}}},_=n(389),f=n(409),x=Object(r.a)(m,(function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-footer",{attrs:{id:"footer-company",color:"primary lighten-1",padless:""}},[n("v-row",{attrs:{justify:"center","no-gutters":""}},[t._l(t.links,(function(link){return n("v-btn",{key:link,staticClass:"my-2",attrs:{color:"white",text:"",rounded:""}},[t._v("\n      "+t._s(link)+"\n    ")])})),t._v(" "),n("v-col",{staticClass:"primary lighten-2 py-4 text-center white--text",attrs:{cols:"12"}},[t._v("\n      "+t._s((new Date).getFullYear())+" — "),n("strong",[t._v("Vuetify")])])],2)],1)}),[],!1,null,null,null),C=x.exports;l()(x,{VBtn:_.a,VCol:c.a,VFooter:v.a,VRow:f.a});var h={data:function(){return{icons:["mdi-facebook","mdi-twitter","mdi-linkedin","mdi-instagram"]}}},V=n(378),w=n(355),y=n(384),F=n(156),k=Object(r.a)(h,(function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-footer",{attrs:{dark:"",padless:"",id:"footer-indigo"}},[n("v-card",{staticClass:"indigo lighten-1 white--text text-center",attrs:{flat:"",tile:""}},[n("v-card-text",t._l(t.icons,(function(e){return n("v-btn",{key:e,staticClass:"mx-4 white--text",attrs:{icon:""}},[n("v-icon",{attrs:{size:"24px"}},[t._v("\n          "+t._s(e)+"\n        ")])],1)})),1),t._v(" "),n("v-card-text",{staticClass:"white--text pt-0"},[t._v("\n      Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet.\n      Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc.\n      Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus.\n      Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin.\n      Vestibulum eu ipsum vel diam elementum tempor vel ut orci.\n      Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n    ")]),t._v(" "),n("v-divider"),t._v(" "),n("v-card-text",{staticClass:"white--text"},[t._v("\n      "+t._s((new Date).getFullYear())+" — "),n("strong",[t._v("Vuetify")])])],1)],1)}),[],!1,null,null,null),T=k.exports;l()(k,{VBtn:_.a,VCard:V.a,VCardText:w.c,VDivider:y.a,VFooter:v.a,VIcon:F.a});var j={data:function(){return{icons:["mdi-facebook","mdi-twitter","mdi-linkedin","mdi-instagram"]}}},D=n(452),I=Object(r.a)(j,(function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-footer",{attrs:{dark:"",padless:"",id:"footer-teal"}},[n("v-card",{staticClass:"flex",attrs:{flat:"",tile:""}},[n("v-card-title",{staticClass:"teal"},[n("strong",{staticClass:"subheading"},[t._v("Get connected with us on social networks!")]),t._v(" "),n("v-spacer"),t._v(" "),t._l(t.icons,(function(e){return n("v-btn",{key:e,staticClass:"mx-4",attrs:{dark:"",icon:""}},[n("v-icon",{attrs:{size:"24px"}},[t._v("\n          "+t._s(e)+"\n        ")])],1)}))],2),t._v(" "),n("v-card-text",{staticClass:"py-2 white--text text-center"},[t._v("\n      "+t._s((new Date).getFullYear())+" — "),n("strong",[t._v("Vuetify")])])],1)],1)}),[],!1,null,null,null),O=I.exports;l()(I,{VBtn:_.a,VCard:V.a,VCardText:w.c,VCardTitle:w.d,VFooter:v.a,VIcon:F.a,VSpacer:D.a});var P={name:"Footers",components:{PadlessFooter:d,CompanyFooter:C,IndigoFooter:T,TealFooter:O}},E=n(1040),$=Object(r.a)(P,(function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-container",[n("v-col",[n("h1",[t._v("Footers")]),t._v(" "),n("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),n("code",[t._v("v-footer")]),t._v(" component is used for displaying general information that a user might \n            want to access from any page within your site.\n        ")])]),t._v(" "),n("v-col",[n("p",{staticClass:"text-h5"},[t._v("\n            Padless footer\n        ")]),t._v(" "),n("PadlessFooter",{attrs:{id:"PadlessFooter"}})],1),t._v(" "),n("v-col",[n("p",{staticClass:"text-h5"},[t._v("\n            Company footer\n        ")]),t._v(" "),n("CompanyFooter",{attrs:{id:"CompanyFooter"}})],1),t._v(" "),n("v-col",[n("p",{staticClass:"text-h5"},[t._v("\n            Indigo footer\n        ")]),t._v(" "),n("IndigoFooter",{attrs:{id:"IndigoFooter"}})],1),t._v(" "),n("v-col",[n("p",{staticClass:"text-h5"},[t._v("\n            Teal footer\n        ")]),t._v(" "),n("TealFooter",{attrs:{id:"TealFooter"}})],1)],1)}),[],!1,null,null,null);e.default=$.exports;l()($,{VCol:c.a,VContainer:E.a})}}]);