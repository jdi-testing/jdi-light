(window.webpackJsonp=window.webpackJsonp||[]).push([[52],{1046:function(t,e,n){"use strict";n.r(e);var o={name:"Lazy",data:function(){return{isActive:!1}}},l=n(75),r=n(173),v=n.n(r),c=n(389),d=n(366),m=n(962),h=n(1049),_=n(970),C=n(169),component=Object(l.a)(o,(function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-container",[n("v-col",[n("h1",[t._v("Lazy")]),t._v(" "),n("p",{staticClass:"body-1 mt-2"},[t._v("\n        The "),n("code",[t._v("v-lazy")]),t._v(" component is used to dynamically load components based upon an elements visibility.\n      ")])]),t._v(" "),n("v-responsive",{staticClass:"overflow-y-auto",attrs:{"max-height":"400"}},[n("div",{staticClass:"pa-6 text-center"},[t._v("\n      Scroll down\n    ")]),t._v(" "),n("v-responsive",{staticClass:"text-center pa-2",attrs:{height:"200vh"}},[n("v-responsive",{attrs:{"min-height":"50vh"}}),t._v(" "),n("div",{staticClass:"text-center text-body-2 mb-12"},[t._v("\n        The card will appear below:\n      ")]),t._v(" "),n("v-lazy",{attrs:{options:{threshold:.5},"min-height":"200",transition:"fade-transition"},model:{value:t.isActive,callback:function(e){t.isActive=e},expression:"isActive"}},[n("v-card",{staticClass:"mx-auto",attrs:{"max-width":"336"}},[n("v-card-title",[t._v("Card title")]),t._v(" "),n("v-card-text",[t._v("\n            Phasellus magna. Quisque rutrum. Nunc egestas, augue at pellentesque laoreet, felis eros vehicula leo, \n            at malesuada velit leo quis pede. Aliquam lobortis. Quisque libero metus, condimentum nec, tempor a, commodo mollis, magna.\n\n            In turpis. In dui magna, posuere eget, vestibulum et, tempor auctor, justo. In turpis. Pellentesque dapibus \n            hendrerit tortor. Ut varius tincidunt libero.\n          ")])],1)],1)],1)],1)],1)}),[],!1,null,null,null);e.default=component.exports;v()(component,{VCard:c.a,VCardText:d.c,VCardTitle:d.d,VCol:m.a,VContainer:h.a,VLazy:_.a,VResponsive:C.a})}}]);