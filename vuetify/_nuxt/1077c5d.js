(window.webpackJsonp=window.webpackJsonp||[]).push([[5],{413:function(t,e,n){var r=n(17);t.exports=function(t){return r(Map.prototype.entries,t)}},419:function(t,e,n){n(438)},420:function(t,e,n){"use strict";n(4)({target:"Map",proto:!0,real:!0,forced:!0},{deleteAll:n(437)})},421:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(75),l=n(413),h=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{every:function(t){var map=o(this),e=l(map),n=c(t,arguments.length>1?arguments[1]:void 0);return!h(e,(function(t,e,r){if(!n(e,t,map))return r()}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).stopped}})},422:function(t,e,n){"use strict";var r=n(4),o=n(45),c=n(75),l=n(17),h=n(57),v=n(21),d=n(156),f=n(413),_=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{filter:function(t){var map=v(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0),r=new(d(map,o("Map"))),w=h(r.set);return _(e,(function(t,e){n(e,t,map)&&l(w,r,t,e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),r}})},423:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(75),l=n(413),h=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{find:function(t){var map=o(this),e=l(map),n=c(t,arguments.length>1?arguments[1]:void 0);return h(e,(function(t,e,r){if(n(e,t,map))return r(e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).result}})},424:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(75),l=n(413),h=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{findKey:function(t){var map=o(this),e=l(map),n=c(t,arguments.length>1?arguments[1]:void 0);return h(e,(function(t,e,r){if(n(e,t,map))return r(t)}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).result}})},425:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(413),l=n(439),h=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{includes:function(t){return h(c(o(this)),(function(e,n,r){if(l(n,t))return r()}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).stopped}})},426:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(413),l=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{keyOf:function(t){return l(c(o(this)),(function(e,n,r){if(n===t)return r(e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).result}})},427:function(t,e,n){"use strict";var r=n(4),o=n(45),c=n(75),l=n(17),h=n(57),v=n(21),d=n(156),f=n(413),_=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{mapKeys:function(t){var map=v(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0),r=new(d(map,o("Map"))),w=h(r.set);return _(e,(function(t,e){l(w,r,n(e,t,map),e)}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),r}})},428:function(t,e,n){"use strict";var r=n(4),o=n(45),c=n(75),l=n(17),h=n(57),v=n(21),d=n(156),f=n(413),_=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{mapValues:function(t){var map=v(this),e=f(map),n=c(t,arguments.length>1?arguments[1]:void 0),r=new(d(map,o("Map"))),w=h(r.set);return _(e,(function(t,e){l(w,r,t,n(e,t,map))}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),r}})},429:function(t,e,n){"use strict";var r=n(4),o=n(57),c=n(21),l=n(192);r({target:"Map",proto:!0,real:!0,arity:1,forced:!0},{merge:function(t){for(var map=c(this),e=o(map.set),n=arguments.length,i=0;i<n;)l(arguments[i++],e,{that:map,AS_ENTRIES:!0});return map}})},430:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(57),l=n(413),h=n(192),v=TypeError;r({target:"Map",proto:!0,real:!0,forced:!0},{reduce:function(t){var map=o(this),e=l(map),n=arguments.length<2,r=n?void 0:arguments[1];if(c(t),h(e,(function(e,o){n?(n=!1,r=o):r=t(r,o,e,map)}),{AS_ENTRIES:!0,IS_ITERATOR:!0}),n)throw v("Reduce of empty map with no initial value");return r}})},431:function(t,e,n){"use strict";var r=n(4),o=n(21),c=n(75),l=n(413),h=n(192);r({target:"Map",proto:!0,real:!0,forced:!0},{some:function(t){var map=o(this),e=l(map),n=c(t,arguments.length>1?arguments[1]:void 0);return h(e,(function(t,e,r){if(n(e,t,map))return r()}),{AS_ENTRIES:!0,IS_ITERATOR:!0,INTERRUPTED:!0}).stopped}})},432:function(t,e,n){"use strict";var r=n(4),o=n(17),c=n(21),l=n(57),h=TypeError;r({target:"Map",proto:!0,real:!0,forced:!0},{update:function(t,e){var map=c(this),n=l(map.get),r=l(map.has),v=l(map.set),d=arguments.length;l(e);var f=o(r,map,t);if(!f&&d<3)throw h("Updating absent value");var _=f?o(n,map,t):l(d>2?arguments[2]:void 0)(t,map);return o(v,map,t,e(_,t,map)),map}})},435:function(t,e,n){"use strict";var r=n(4),o=n(8),c=n(7),l=n(126),h=n(41),v=n(275),d=n(192),f=n(194),_=n(13),w=n(66),m=n(29),x=n(6),y=n(200),E=n(106),S=n(203);t.exports=function(t,e,n){var R=-1!==t.indexOf("Map"),T=-1!==t.indexOf("Weak"),k=R?"set":"add",I=o[t],A=I&&I.prototype,O=I,C={},M=function(t){var e=c(A[t]);h(A,t,"add"==t?function(t){return e(this,0===t?0:t),this}:"delete"==t?function(t){return!(T&&!m(t))&&e(this,0===t?0:t)}:"get"==t?function(t){return T&&!m(t)?void 0:e(this,0===t?0:t)}:"has"==t?function(t){return!(T&&!m(t))&&e(this,0===t?0:t)}:function(t,n){return e(this,0===t?0:t,n),this})};if(l(t,!_(I)||!(T||A.forEach&&!x((function(){(new I).entries().next()})))))O=n.getConstructor(e,t,R,k),v.enable();else if(l(t,!0)){var V=new O,D=V[k](T?{}:-0,1)!=V,z=x((function(){V.has(1)})),N=y((function(t){new I(t)})),j=!T&&x((function(){for(var t=new I,e=5;e--;)t[k](e,e);return!t.has(-0)}));N||((O=e((function(t,e){f(t,A);var n=S(new I,t,O);return w(e)||d(e,n[k],{that:n,AS_ENTRIES:R}),n}))).prototype=A,A.constructor=O),(z||j)&&(M("delete"),M("has"),R&&M("get")),(j||D)&&M(k),T&&A.clear&&delete A.clear}return C[t]=O,r({global:!0,constructor:!0,forced:O!=I},C),E(O,t),T||n.setStrong(O,t,R),O}},436:function(t,e,n){"use strict";var r=n(37).f,o=n(78),c=n(279),l=n(75),h=n(194),v=n(66),d=n(192),f=n(201),_=n(202),w=n(23),m=n(275).fastKey,x=n(67),y=x.set,E=x.getterFor;t.exports={getConstructor:function(t,e,n,f){var _=t((function(t,r){h(t,x),y(t,{type:e,index:o(null),first:void 0,last:void 0,size:0}),w||(t.size=0),v(r)||d(r,t[f],{that:t,AS_ENTRIES:n})})),x=_.prototype,S=E(e),R=function(t,e,n){var r,o,c=S(t),l=T(t,e);return l?l.value=n:(c.last=l={index:o=m(e,!0),key:e,value:n,previous:r=c.last,next:void 0,removed:!1},c.first||(c.first=l),r&&(r.next=l),w?c.size++:t.size++,"F"!==o&&(c.index[o]=l)),t},T=function(t,e){var n,r=S(t),o=m(e);if("F"!==o)return r.index[o];for(n=r.first;n;n=n.next)if(n.key==e)return n};return c(x,{clear:function(){for(var t=S(this),data=t.index,e=t.first;e;)e.removed=!0,e.previous&&(e.previous=e.previous.next=void 0),delete data[e.index],e=e.next;t.first=t.last=void 0,w?t.size=0:this.size=0},delete:function(t){var e=this,n=S(e),r=T(e,t);if(r){var o=r.next,c=r.previous;delete n.index[r.index],r.removed=!0,c&&(c.next=o),o&&(o.previous=c),n.first==r&&(n.first=o),n.last==r&&(n.last=c),w?n.size--:e.size--}return!!r},forEach:function(t){for(var e,n=S(this),r=l(t,arguments.length>1?arguments[1]:void 0);e=e?e.next:n.first;)for(r(e.value,e.key,this);e&&e.removed;)e=e.previous},has:function(t){return!!T(this,t)}}),c(x,n?{get:function(t){var e=T(this,t);return e&&e.value},set:function(t,e){return R(this,0===t?0:t,e)}}:{add:function(t){return R(this,t=0===t?0:t,t)}}),w&&r(x,"size",{get:function(){return S(this).size}}),_},setStrong:function(t,e,n){var r=e+" Iterator",o=E(e),c=E(r);f(t,e,(function(t,e){y(this,{type:r,target:t,state:o(t),kind:e,last:void 0})}),(function(){for(var t=c(this),e=t.kind,n=t.last;n&&n.removed;)n=n.previous;return t.target&&(t.last=n=n?n.next:t.state.first)?"keys"==e?{value:n.key,done:!1}:"values"==e?{value:n.value,done:!1}:{value:[n.key,n.value],done:!1}:(t.target=void 0,{value:void 0,done:!0})}),n?"entries":"values",!n,!0),_(e)}}},437:function(t,e,n){"use strict";var r=n(17),o=n(57),c=n(21);t.exports=function(){for(var t,e=c(this),n=o(e.delete),l=!0,h=0,v=arguments.length;h<v;h++)t=r(n,e,arguments[h]),l=l&&t;return!!l}},438:function(t,e,n){"use strict";n(435)("Map",(function(t){return function(){return t(this,arguments.length?arguments[0]:void 0)}}),n(436))},439:function(t,e){t.exports=function(t,e){return t===e||t!=t&&e!=e}},468:function(t,e,n){"use strict";var r=n(85),o=n(1);e.a=o.a.extend({name:"rippleable",directives:{ripple:r.a},props:{ripple:{type:[Boolean,Object],default:!0}},methods:{genRipple:function(){var data=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};return this.ripple?(data.staticClass="v-input--selection-controls__ripple",data.directives=data.directives||[],data.directives.push({name:"ripple",value:{center:!0}}),this.$createElement("div",data)):null}}})},473:function(t,e,n){var content=n(478);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,n(28).default)("2e2bc7da",content,!0,{sourceMap:!1})},474:function(t,e,n){"use strict";n.d(e,"b",(function(){return h}));n(5),n(76),n(15);var r=n(450),o=n(468),c=n(206),l=n(12);function h(t){t.preventDefault()}e.a=Object(l.a)(r.a,o.a,c.a).extend({name:"selectable",model:{prop:"inputValue",event:"change"},props:{id:String,inputValue:null,falseValue:null,trueValue:null,multiple:{type:Boolean,default:null},label:String},data:function(){return{hasColor:this.inputValue,lazyValue:this.inputValue}},computed:{computedColor:function(){if(this.isActive)return this.color?this.color:this.isDark&&!this.appIsDark?"white":"primary"},isMultiple:function(){return!0===this.multiple||null===this.multiple&&Array.isArray(this.internalValue)},isActive:function(){var t=this,e=this.value,input=this.internalValue;return this.isMultiple?!!Array.isArray(input)&&input.some((function(n){return t.valueComparator(n,e)})):void 0===this.trueValue||void 0===this.falseValue?e?this.valueComparator(e,input):Boolean(input):this.valueComparator(input,this.trueValue)},isDirty:function(){return this.isActive},rippleState:function(){return this.isDisabled||this.validationState?this.validationState:void 0}},watch:{inputValue:function(t){this.lazyValue=t,this.hasColor=t}},methods:{genLabel:function(){var label=r.a.options.methods.genLabel.call(this);return label?(label.data.on={click:h},label):label},genInput:function(t,e){return this.$createElement("input",{attrs:Object.assign({"aria-checked":this.isActive.toString(),disabled:this.isDisabled,id:this.computedId,role:t,type:t},e),domProps:{value:this.value,checked:this.isActive},on:{blur:this.onBlur,change:this.onChange,focus:this.onFocus,keydown:this.onKeydown,click:h},ref:"input"})},onClick:function(t){this.onChange(),this.$emit("click",t)},onChange:function(){var t=this;if(this.isInteractive){var e=this.value,input=this.internalValue;if(this.isMultiple){Array.isArray(input)||(input=[]);var n=input.length;(input=input.filter((function(n){return!t.valueComparator(n,e)}))).length===n&&input.push(e)}else input=void 0!==this.trueValue&&void 0!==this.falseValue?this.valueComparator(input,this.trueValue)?this.falseValue:this.trueValue:e?this.valueComparator(input,e)?null:e:!input;this.validate(!0,input),this.internalValue=input,this.hasColor=input}},onFocus:function(t){this.isFocused=!0,this.$emit("focus",t)},onBlur:function(t){this.isFocused=!1,this.$emit("blur",t)},onKeydown:function(t){}}})},478:function(t,e,n){var r=n(27)(!1);r.push([t.i,'.v-input--selection-controls{margin-top:16px;padding-top:4px}.v-input--selection-controls>.v-input__append-outer,.v-input--selection-controls>.v-input__prepend-outer{margin-top:0;margin-bottom:0}.v-input--selection-controls:not(.v-input--hide-details)>.v-input__slot{margin-bottom:12px}.v-input--selection-controls .v-input__slot,.v-input--selection-controls .v-radio{cursor:pointer}.v-input--selection-controls .v-input__slot>.v-label,.v-input--selection-controls .v-radio>.v-label{align-items:center;display:inline-flex;flex:1 1 auto;height:auto}.v-input--selection-controls__input{color:inherit;display:inline-flex;flex:0 0 auto;height:24px;position:relative;transition:.3s cubic-bezier(.25,.8,.5,1);transition-property:transform;width:24px;-webkit-user-select:none;-moz-user-select:none;user-select:none}.v-input--selection-controls__input .v-icon{width:100%}.v-application--is-ltr .v-input--selection-controls__input{margin-right:8px}.v-application--is-rtl .v-input--selection-controls__input{margin-left:8px}.v-input--selection-controls__input input[role=checkbox],.v-input--selection-controls__input input[role=radio],.v-input--selection-controls__input input[role=switch]{position:absolute;opacity:0;width:100%;height:100%;cursor:pointer;-webkit-user-select:none;-moz-user-select:none;user-select:none}.v-input--selection-controls__input+.v-label{cursor:pointer;-webkit-user-select:none;-moz-user-select:none;user-select:none}.v-input--selection-controls__ripple{border-radius:50%;cursor:pointer;height:34px;position:absolute;transition:inherit;width:34px;left:-12px;top:calc(50% - 24px);margin:7px}.v-input--selection-controls__ripple:before{border-radius:inherit;bottom:0;content:"";position:absolute;opacity:.2;left:0;right:0;top:0;transform-origin:center center;transform:scale(.2);transition:inherit}.v-input--selection-controls__ripple>.v-ripple__container{transform:scale(1.2)}.v-input--selection-controls.v-input--dense .v-input--selection-controls__ripple{width:28px;height:28px;left:-9px}.v-input--selection-controls.v-input--dense:not(.v-input--switch) .v-input--selection-controls__ripple{top:calc(50% - 21px)}.v-input--selection-controls.v-input{flex:0 1 auto}.v-input--selection-controls.v-input--is-focused .v-input--selection-controls__ripple:before,.v-input--selection-controls .v-radio--is-focused .v-input--selection-controls__ripple:before{background:currentColor;transform:scale(1.2)}.v-input--selection-controls.v-input--is-disabled:not(.v-input--indeterminate) .v-icon{color:inherit}.v-input--selection-controls.v-input--is-disabled:not(.v-input--is-readonly){pointer-events:none}.v-input--selection-controls__input:hover .v-input--selection-controls__ripple:before{background:currentColor;transform:scale(1.2);transition:none}',""]),t.exports=r},546:function(t,e,n){var content=n(547);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,n(28).default)("beda1088",content,!0,{sourceMap:!1})},547:function(t,e,n){var r=n(27)(!1);r.push([t.i,".theme--light.v-input--switch .v-input--switch__thumb{color:#fff}.theme--light.v-input--switch .v-input--switch__track{color:rgba(0,0,0,.38)}.theme--light.v-input--switch.v-input--is-disabled:not(.v-input--is-dirty) .v-input--switch__thumb{color:#fafafa!important}.theme--light.v-input--switch.v-input--is-disabled:not(.v-input--is-dirty) .v-input--switch__track{color:rgba(0,0,0,.12)!important}.theme--dark.v-input--switch .v-input--switch__thumb{color:#bdbdbd}.theme--dark.v-input--switch .v-input--switch__track{color:hsla(0,0%,100%,.3)}.theme--dark.v-input--switch.v-input--is-disabled:not(.v-input--is-dirty) .v-input--switch__thumb{color:#424242!important}.theme--dark.v-input--switch.v-input--is-disabled:not(.v-input--is-dirty) .v-input--switch__track{color:hsla(0,0%,100%,.1)!important}.v-input--switch__thumb,.v-input--switch__track{background-color:currentColor;pointer-events:none;transition:inherit}.v-input--switch__track{border-radius:8px;width:36px;height:14px;left:2px;position:absolute;opacity:.6;right:2px;top:calc(50% - 7px)}.v-input--switch__thumb{border-radius:50%;top:calc(50% - 10px);height:20px;position:relative;width:20px;display:flex;justify-content:center;align-items:center;transition:.3s cubic-bezier(.25,.8,.5,1)}.v-input--switch .v-input--selection-controls__input{width:38px;transition:opacity .3s cubic-bezier(.25,.8,.5,1)}.v-input--switch .v-input--selection-controls__ripple{top:calc(50% - 24px)}.v-input--switch.v-input--dense .v-input--switch__thumb{width:18px;height:18px}.v-input--switch.v-input--dense .v-input--switch__track{height:12px;width:32px}.v-input--switch.v-input--dense.v-input--switch--inset .v-input--switch__track{height:22px;width:44px;top:calc(50% - 12px);left:-3px}.v-input--switch.v-input--dense .v-input--selection-controls__ripple{top:calc(50% - 22px)}.v-input--switch.v-input--is-dirty.v-input--is-disabled .v-input--selection-controls__input{opacity:.6}.v-application--is-ltr .v-input--switch .v-input--selection-controls__ripple{left:-14px}.v-application--is-ltr .v-input--switch.v-input--dense .v-input--selection-controls__ripple{left:-12px}.v-application--is-ltr .v-input--switch.v-input--is-dirty .v-input--selection-controls__ripple,.v-application--is-ltr .v-input--switch.v-input--is-dirty .v-input--switch__thumb{transform:translate(20px)}.v-application--is-rtl .v-input--switch .v-input--selection-controls__ripple{right:-14px}.v-application--is-rtl .v-input--switch.v-input--dense .v-input--selection-controls__ripple{right:-12px}.v-application--is-rtl .v-input--switch.v-input--is-dirty .v-input--selection-controls__ripple,.v-application--is-rtl .v-input--switch.v-input--is-dirty .v-input--switch__thumb{transform:translate(-20px)}.v-input--switch:not(.v-input--switch--flat):not(.v-input--switch--inset) .v-input--switch__thumb{box-shadow:0 2px 4px -1px rgba(0,0,0,.2),0 4px 5px 0 rgba(0,0,0,.14),0 1px 10px 0 rgba(0,0,0,.12)}.v-input--switch--inset .v-input--selection-controls__input,.v-input--switch--inset .v-input--switch__track{width:48px}.v-input--switch--inset .v-input--switch__track{border-radius:14px;height:28px;left:-4px;opacity:.32;top:calc(50% - 14px)}.v-application--is-ltr .v-input--switch--inset .v-input--selection-controls__ripple,.v-application--is-ltr .v-input--switch--inset .v-input--switch__thumb{transform:translate(0)!important}.v-application--is-rtl .v-input--switch--inset .v-input--selection-controls__ripple,.v-application--is-rtl .v-input--switch--inset .v-input--switch__thumb{transform:translate(-6px)!important}.v-application--is-ltr .v-input--switch--inset.v-input--is-dirty .v-input--selection-controls__ripple,.v-application--is-ltr .v-input--switch--inset.v-input--is-dirty .v-input--switch__thumb{transform:translate(20px)!important}.v-application--is-rtl .v-input--switch--inset.v-input--is-dirty .v-input--selection-controls__ripple,.v-application--is-rtl .v-input--switch--inset.v-input--is-dirty .v-input--switch__thumb{transform:translate(-26px)!important}",""]),t.exports=r},612:function(t,e,n){"use strict";n(16),n(11),n(15),n(5),n(19),n(10),n(20);var r=n(107),o=n(3),c=(n(277),n(278),n(473),n(546),n(474)),l=n(450),h=n(210),v=n(195),d=n(434),f=n(2),_=["title"];function w(object,t){var e=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),e.push.apply(e,n)}return e}function m(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?w(Object(source),!0).forEach((function(e){Object(o.a)(t,e,source[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):w(Object(source)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(source,e))}))}return t}e.a=c.a.extend({name:"v-switch",directives:{Touch:h.a},props:{inset:Boolean,loading:{type:[Boolean,String],default:!1},flat:{type:Boolean,default:!1}},computed:{classes:function(){return m(m({},l.a.options.computed.classes.call(this)),{},{"v-input--selection-controls v-input--switch":!0,"v-input--switch--flat":this.flat,"v-input--switch--inset":this.inset})},attrs:function(){return{"aria-checked":String(this.isActive),"aria-disabled":String(this.isDisabled),role:"switch"}},validationState:function(){return this.hasError&&this.shouldValidate?"error":this.hasSuccess?"success":null!==this.hasColor?this.computedColor:void 0},switchData:function(){return this.setTextColor(this.loading?void 0:this.validationState,{class:this.themeClasses})}},methods:{genDefaultSlot:function(){return[this.genSwitch(),this.genLabel()]},genSwitch:function(){var t=this.attrs$,e=(t.title,Object(r.a)(t,_));return this.$createElement("div",{staticClass:"v-input--selection-controls__input"},[this.genInput("checkbox",m(m({},this.attrs),e)),this.genRipple(this.setTextColor(this.validationState,{directives:[{name:"touch",value:{left:this.onSwipeLeft,right:this.onSwipeRight}}]})),this.$createElement("div",m({staticClass:"v-input--switch__track"},this.switchData)),this.$createElement("div",m({staticClass:"v-input--switch__thumb"},this.switchData),[this.genProgress()])])},genProgress:function(){return this.$createElement(v.c,{},[!1===this.loading?null:this.$slots.progress||this.$createElement(d.a,{props:{color:!0===this.loading||""===this.loading?this.color||"primary":this.loading,size:16,width:2,indeterminate:!0}})])},onSwipeLeft:function(){this.isActive&&this.onChange()},onSwipeRight:function(){this.isActive||this.onChange()},onKeydown:function(t){(t.keyCode===f.A.left&&this.isActive||t.keyCode===f.A.right&&!this.isActive)&&this.onChange()}}})}}]);