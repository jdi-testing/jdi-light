(window.webpackJsonp=window.webpackJsonp||[]).push([[56],{1112:function(t,n,e){"use strict";e.r(n);var l=e(1040),o=e(1130),r=e(1049),c={data:function(){return{otp:""}}},d=e(82),v={data:function(){return{otp:""}}},_={data:function(){return{otp:""}}},O={data:function(){return{otp:"111"}}},f={name:"OtpInput",components:{HiddenOtpInput:Object(d.a)(c,(function(){var t=this,n=t._self._c;return n("div",{staticClass:"ma-auto",staticStyle:{"max-width":"260px"}},[n(r.a,{attrs:{type:"password",length:"5",dark:""},model:{value:t.otp,callback:function(n){t.otp=n},expression:"otp"}})],1)}),[],!1,null,null,null).exports,DisabledOtpInput:Object(d.a)(v,(function(){var t=this,n=t._self._c;return n("div",{staticClass:"ma-auto",staticStyle:{"max-width":"260px"}},[n(r.a,{attrs:{type:"password",length:"7",disabled:""},model:{value:t.otp,callback:function(n){t.otp=n},expression:"otp"}})],1)}),[],!1,null,null,null).exports,PlainOtpInput:Object(d.a)(_,(function(){var t=this,n=t._self._c;return n("div",{staticClass:"ma-auto",staticStyle:{"max-width":"260px"}},[n(r.a,{attrs:{type:"text",length:"5",plain:"",dark:""},model:{value:t.otp,callback:function(n){t.otp=n},expression:"otp"}})],1)}),[],!1,null,null,null).exports,ReadOnlyOtpInput:Object(d.a)(O,(function(){var t=this,n=t._self._c;return n("div",{staticClass:"ma-auto",staticStyle:{"max-width":"260px"}},[n(r.a,{attrs:{type:"number",length:"3",readonly:""},model:{value:t.otp,callback:function(n){t.otp=n},expression:"otp"}})],1)}),[],!1,null,null,null).exports}},x=Object(d.a)(f,(function(){var t=this,n=t._self._c;return n(o.a,[n(l.a,[n("h1",[t._v("OTP Input")]),t._v(" "),n("p",{staticClass:"body-1 mt-2"},[t._v("\n            The "),n("code",[t._v("OTP input")]),t._v(" is used for MFA procedure of authenticating users by a one-time password.\n        ")])]),t._v(" "),n(l.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Hidden input\n        ")]),t._v(" "),n("HiddenOtpInput",{attrs:{id:"HiddenOtpInput"}})],1),t._v(" "),n(l.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Disabled input\n        ")]),t._v(" "),n("DisabledOtpInput",{attrs:{id:"DisabledOtpInput"}})],1),t._v(" "),n(l.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Plain input\n        ")]),t._v(" "),n("PlainOtpInput",{attrs:{id:"PlainOtpInput"}})],1),t._v(" "),n(l.a,[n("p",{staticClass:"text-h5"},[t._v("\n            Read-only input\n        ")]),t._v(" "),n("ReadOnlyOtpInput",{attrs:{id:"ReadOnlyOtpInput"}})],1)],1)}),[],!1,null,null,null);n.default=x.exports}}]);