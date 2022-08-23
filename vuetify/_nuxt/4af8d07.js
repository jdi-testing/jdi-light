(window.webpackJsonp=window.webpackJsonp||[]).push([[43],{1052:function(e,t,l){"use strict";l.r(t);var n=l(1017),r=l(1104),c=l(1024),o=l(82),_=Object(o.a)({},(function(){return(0,this._self._c)(c.a,{attrs:{accept:"image/*",label:"File input"}})}),[],!1,null,null,null).exports,d=Object(o.a)({},(function(){var e=this._self._c;return e("div",[e(c.a,{attrs:{chips:"",multiple:"",label:"File input w/ chips"}}),this._v(" "),e(c.a,{attrs:{"small-chips":"",multiple:"",label:"File input w/ small chips"}})],1)}),[],!1,null,null,null).exports,f=Object(o.a)({},(function(){return(0,this._self._c)(c.a,{attrs:{"show-size":"",counter:"",multiple:"",label:"File input"}})}),[],!1,null,null,null).exports,v=Object(o.a)({},(function(){return(0,this._self._c)(c.a,{attrs:{label:"File input",outlined:"",dense:""}})}),[],!1,null,null,null).exports,h=Object(o.a)({},(function(){return(0,this._self._c)(c.a,{attrs:{multiple:"",label:"File input"}})}),[],!1,null,null,null).exports,F=Object(o.a)({},(function(){return(0,this._self._c)(c.a,{attrs:{label:"File input",filled:"","prepend-icon":"mdi-camera"}})}),[],!1,null,null,null).exports,m=Object(o.a)({},(function(){return(0,this._self._c)(c.a,{attrs:{"show-size":"",label:"File input"}})}),[],!1,null,null,null).exports,I={data:function(){return{rules:[function(e){return!e||e.size<2e6||"Avatar size should be less than 2 MB!"}]}}},x=Object(o.a)(I,(function(){return(0,this._self._c)(c.a,{attrs:{rules:this.rules,accept:"image/png, image/jpeg, image/bmp",placeholder:"Pick an avatar","prepend-icon":"mdi-camera",label:"Avatar"}})}),[],!1,null,null,null).exports,C=l(463),S={data:function(){return{files:[]}}},w={data:function(){return{files:[]}}},j={name:"FileInputs",components:{AcceptFileInput:_,ChipsFileInput:d,CounterFileInput:f,DenseFileInput:v,MultipleFileInput:h,PrependIconFileInput:F,ShowSizeFileInput:m,ValidationFileInput:x,SelectionFileInput:Object(o.a)(S,(function(){var e=this,t=e._self._c;return t(c.a,{attrs:{placeholder:"Upload your documents",label:"File input",multiple:"","prepend-icon":"mdi-paperclip"},scopedSlots:e._u([{key:"selection",fn:function(l){var text=l.text;return[t(C.a,{attrs:{small:"",label:"",color:"primary"}},[e._v("\n      "+e._s(text)+"\n    ")])]}}]),model:{value:e.files,callback:function(t){e.files=t},expression:"files"}})}),[],!1,null,null,null).exports,ComplexSelectionSlotFileInput:Object(o.a)(w,(function(){var e=this,t=e._self._c;return t(c.a,{attrs:{color:"deep-purple accent-4",counter:"",label:"File input",multiple:"",placeholder:"Select your files","prepend-icon":"mdi-paperclip",outlined:"","show-size":1e3},scopedSlots:e._u([{key:"selection",fn:function(l){var n=l.index,text=l.text;return[n<2?t(C.a,{attrs:{color:"deep-purple accent-4",dark:"",label:"",small:""}},[e._v("\n      "+e._s(text)+"\n    ")]):2===n?t("span",{staticClass:"text-overline grey--text text--darken-3 mx-2"},[e._v("\n      +"+e._s(e.files.length-2)+" File(s)\n    ")]):e._e()]}}]),model:{value:e.files,callback:function(t){e.files=t},expression:"files"}})}),[],!1,null,null,null).exports}},O=Object(o.a)(j,(function(){var e=this,t=e._self._c;return t(r.a,[t(n.a,[t("h1",[e._v("File inputs")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n            The "),t("code",[e._v("v-file-input")]),e._v(" component is a specialized input that provides a clean interface \n            for selecting files, showing detailed selection information and upload progress. \n            It is meant to be a direct replacement for a standard file input.\n        ")])]),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Accept file input\n        ")]),e._v(" "),t("AcceptFileInput",{attrs:{id:"AcceptFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Chips file input\n        ")]),e._v(" "),t("ChipsFileInput",{attrs:{id:"ChipsFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Counter file input\n        ")]),e._v(" "),t("CounterFileInput",{attrs:{id:"CounterFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Dense file input\n        ")]),e._v(" "),t("DenseFileInput",{attrs:{id:"DenseFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Multiple file input\n        ")]),e._v(" "),t("MultipleFileInput",{attrs:{id:"MultipleFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Prepend icon file input\n        ")]),e._v(" "),t("PrependIconFileInput",{attrs:{id:"PrependIconFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Show size file input\n        ")]),e._v(" "),t("ShowSizeFileInput",{attrs:{id:"ShowSizeFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Validation file input\n        ")]),e._v(" "),t("ValidationFileInput",{attrs:{id:"ValidationFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Selection file input\n        ")]),e._v(" "),t("SelectionFileInput",{attrs:{id:"SelectionFileInput"}})],1),e._v(" "),t(n.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Complex selection slot file input\n        ")]),e._v(" "),t("ComplexSelectionSlotFileInput",{attrs:{id:"ComplexSelectionSlotFileInput"}})],1)],1)}),[],!1,null,null,null);t.default=O.exports}}]);