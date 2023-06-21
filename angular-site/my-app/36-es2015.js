(window.webpackJsonp=window.webpackJsonp||[]).push([[36],{Zml3:function(t,e,o){"use strict";o.r(e),o.d(e,"FormFieldsModule",(function(){return q}));var n=o("ofXK"),a=o("tyNb"),i=o("fXoL"),r=o("kmnG"),l=o("qFsG"),s=o("NFeN");let c=(()=>{class t{}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-appearance-example"]],decls:39,vars:0,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview#form-field-appearance-variants"],["appearance","legacy","id","form-field-appearance-input-legacy"],["matInput","","placeholder","Placeholder"],["matSuffix",""],["appearance","standard","id","form-field-appearance-input-standard"],["appearance","fill","id","form-field-appearance-input-fill"],["appearance","outline","id","form-field-appearance-input-outline"]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Form field appearance variants "),i.Tb(),i.Tb(),i.Ub(3,"p"),i.Ub(4,"mat-form-field",2),i.Ub(5,"mat-label"),i.Cc(6,"Legacy form field"),i.Tb(),i.Pb(7,"input",3),i.Ub(8,"mat-icon",4),i.Cc(9,"sentiment_very_satisfied"),i.Tb(),i.Ub(10,"mat-hint"),i.Cc(11,"Hint"),i.Tb(),i.Tb(),i.Tb(),i.Ub(12,"p"),i.Ub(13,"mat-form-field",5),i.Ub(14,"mat-label"),i.Cc(15,"Standard form field"),i.Tb(),i.Pb(16,"input",3),i.Ub(17,"mat-icon",4),i.Cc(18,"sentiment_very_satisfied"),i.Tb(),i.Ub(19,"mat-hint"),i.Cc(20,"Hint"),i.Tb(),i.Tb(),i.Tb(),i.Ub(21,"p"),i.Ub(22,"mat-form-field",6),i.Ub(23,"mat-label"),i.Cc(24,"Fill form field"),i.Tb(),i.Pb(25,"input",3),i.Ub(26,"mat-icon",4),i.Cc(27,"sentiment_very_satisfied"),i.Tb(),i.Ub(28,"mat-hint"),i.Cc(29,"Hint"),i.Tb(),i.Tb(),i.Tb(),i.Ub(30,"p"),i.Ub(31,"mat-form-field",7),i.Ub(32,"mat-label"),i.Cc(33,"Outline form field"),i.Tb(),i.Pb(34,"input",3),i.Ub(35,"mat-icon",4),i.Cc(36,"sentiment_very_satisfied"),i.Tb(),i.Ub(37,"mat-hint"),i.Cc(38,"Hint"),i.Tb(),i.Tb(),i.Tb())},directives:[r.d,r.h,l.b,s.a,r.j,r.g],encapsulation:2}),t})();var b=o("3Pt+");function m(t,e){if(1&t&&(i.Ub(0,"mat-error"),i.Cc(1),i.Tb()),2&t){const t=i.gc();i.Bb(1),i.Dc(t.getErrorMessage())}}let u=(()=>{class t{constructor(){this.email=new b.e("",[b.w.required,b.w.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+[.]{1}[a-z]+$")])}getErrorMessage(){return this.email.hasError("required")?"You must enter a value":this.email.hasError("pattern")?"Not a valid email":""}}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-error-example"]],decls:9,vars:2,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview#error-messages"],[1,"example-container"],["appearance","fill","id","form-field-email-input"],["matInput","","type","email","placeholder","pat@example.com","ngModel","","email","","required","",3,"formControl"],[4,"ngIf"]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Form field with error messages "),i.Tb(),i.Tb(),i.Ub(3,"div",2),i.Ub(4,"mat-form-field",3),i.Ub(5,"mat-label"),i.Cc(6,"Enter your email"),i.Tb(),i.Pb(7,"input",4),i.Bc(8,m,2,1,"mat-error",5),i.Tb(),i.Tb()),2&t&&(i.Bb(7),i.mc("formControl",e.email),i.Bb(1),i.mc("ngIf",e.email.invalid))},directives:[r.d,r.h,l.b,b.b,b.n,b.c,b.u,b.f,n.m,r.c],styles:[".example-container[_ngcontent-%COMP%]   .mat-form-field[_ngcontent-%COMP%] + .mat-form-field[_ngcontent-%COMP%]{margin-left:8px}"]}),t})();var d=o("d3UM"),p=o("FKr1");let f=(()=>{class t{}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-hint-example"]],decls:19,vars:1,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview#hint-labels"],[1,"example-container"],["hintLabel","Max 10 characters","appearance","fill","id","form-field-example-container-input-limited"],["matInput","","maxlength","10","placeholder","Ex. Nougat"],["input",""],["align","end"],["appearance","fill","id","form-field-example-container-dropdown"],["value","option"]],template:function(t,e){if(1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Form field with hints "),i.Tb(),i.Tb(),i.Ub(3,"div",2),i.Ub(4,"mat-form-field",3),i.Ub(5,"mat-label"),i.Cc(6,"Enter some input"),i.Tb(),i.Pb(7,"input",4,5),i.Ub(9,"mat-hint",6),i.Cc(10),i.Tb(),i.Tb(),i.Ub(11,"mat-form-field",7),i.Ub(12,"mat-label"),i.Cc(13,"Select me"),i.Tb(),i.Ub(14,"mat-select"),i.Ub(15,"mat-option",8),i.Cc(16,"Option"),i.Tb(),i.Tb(),i.Ub(17,"mat-hint",6),i.Cc(18,"Here's the dropdown arrow ^"),i.Tb(),i.Tb(),i.Tb()),2&t){const t=i.tc(8);i.Bb(10),i.Ec("",(null==t.value?null:t.value.length)||0,"/10")}},directives:[r.d,r.h,l.b,r.g,d.a,p.n],styles:[".example-container[_ngcontent-%COMP%]   .mat-form-field[_ngcontent-%COMP%] + .mat-form-field[_ngcontent-%COMP%]{margin-left:8px}"]}),t})();var h=o("bSwM"),g=o("QibW");let x=(()=>{class t{constructor(t){this.hideRequiredControl=new b.e(!1),this.floatLabelControl=new b.e("auto"),this.options=t.group({hideRequired:this.hideRequiredControl,floatLabel:this.floatLabelControl})}}return t.\u0275fac=function(e){return new(e||t)(i.Ob(b.d))},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-label-example"]],decls:34,vars:8,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview#floating-label"],[1,"example-container"],["id","form-field-with-label",3,"formGroup"],[3,"formControl"],["id","form-field-with-label-radio",3,"formControl"],["value","auto"],["value","always"],["appearance","fill","id","form-field-with-label-input-simple-placeholder",3,"hideRequiredMarker","floatLabel"],["matInput","","placeholder","Simple placeholder","required",""],["appearance","fill","id","form-field-with-label-input-simple-placeholder-and-label",3,"floatLabel"],["matInput","","placeholder","Simple placeholder"],["appearance","fill","id","form-field-with-label-select",3,"hideRequiredMarker","floatLabel"],["required",""],["value","option"]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Form field with label "),i.Tb(),i.Tb(),i.Ub(3,"div",2),i.Ub(4,"form",3),i.Ub(5,"mat-checkbox",4),i.Cc(6,"Hide required marker"),i.Tb(),i.Ub(7,"div"),i.Ub(8,"label"),i.Cc(9,"Float label: "),i.Tb(),i.Ub(10,"mat-radio-group",5),i.Ub(11,"mat-radio-button",6),i.Cc(12,"Auto"),i.Tb(),i.Ub(13,"mat-radio-button",7),i.Cc(14,"Always"),i.Tb(),i.Tb(),i.Tb(),i.Ub(15,"mat-form-field",8),i.Pb(16,"input",9),i.Tb(),i.Ub(17,"mat-form-field",10),i.Ub(18,"mat-label"),i.Cc(19,"Both a label and a placeholder"),i.Tb(),i.Pb(20,"input",11),i.Tb(),i.Ub(21,"mat-form-field",12),i.Ub(22,"mat-select",13),i.Ub(23,"mat-option"),i.Cc(24,"-- None --"),i.Tb(),i.Ub(25,"mat-option",14),i.Cc(26,"Option"),i.Tb(),i.Tb(),i.Ub(27,"mat-label"),i.Ub(28,"mat-icon"),i.Cc(29,"favorite"),i.Tb(),i.Ub(30,"b"),i.Cc(31," Fancy"),i.Tb(),i.Ub(32,"i"),i.Cc(33," label"),i.Tb(),i.Tb(),i.Tb(),i.Tb(),i.Tb()),2&t&&(i.Bb(4),i.mc("formGroup",e.options),i.Bb(1),i.mc("formControl",e.hideRequiredControl),i.Bb(5),i.mc("formControl",e.floatLabelControl),i.Bb(5),i.mc("hideRequiredMarker",e.hideRequiredControl.value)("floatLabel",e.floatLabelControl.value),i.Bb(2),i.mc("floatLabel",e.floatLabelControl.value),i.Bb(4),i.mc("hideRequiredMarker",e.hideRequiredControl.value)("floatLabel",e.floatLabelControl.value))},directives:[b.y,b.o,b.i,h.a,b.n,b.f,g.b,g.a,r.d,l.b,r.h,d.a,p.n,s.a],styles:[".example-container[_ngcontent-%COMP%]   .mat-form-field[_ngcontent-%COMP%] + .mat-form-field[_ngcontent-%COMP%]{margin-left:8px}.example-container[_ngcontent-%COMP%]   .mat-form-field[_ngcontent-%COMP%]{width:220px}.example-container[_ngcontent-%COMP%]   form[_ngcontent-%COMP%]{margin-bottom:20px}.example-container[_ngcontent-%COMP%]   form[_ngcontent-%COMP%] > *[_ngcontent-%COMP%]{margin:5px 0}.example-container[_ngcontent-%COMP%]   .mat-radio-button[_ngcontent-%COMP%]{margin:0 12px}"]}),t})(),v=(()=>{class t{}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-overview-example"]],decls:20,vars:0,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview"],[1,"example-container"],["appearance","fill","id","simple-form-field-input"],["matInput",""],["appearance","fill","id","simple-form-field-select"],["value","option"],["appearance","fill","id","simple-form-field-textarea"]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Simple form field "),i.Tb(),i.Tb(),i.Ub(3,"div",2),i.Ub(4,"mat-form-field",3),i.Ub(5,"mat-label"),i.Cc(6,"Input"),i.Tb(),i.Pb(7,"input",4),i.Tb(),i.Pb(8,"br"),i.Ub(9,"mat-form-field",5),i.Ub(10,"mat-label"),i.Cc(11,"Select"),i.Tb(),i.Ub(12,"mat-select"),i.Ub(13,"mat-option",6),i.Cc(14,"Option"),i.Tb(),i.Tb(),i.Tb(),i.Pb(15,"br"),i.Ub(16,"mat-form-field",7),i.Ub(17,"mat-label"),i.Cc(18,"Textarea"),i.Tb(),i.Pb(19,"textarea",4),i.Tb(),i.Tb())},directives:[r.d,r.h,l.b,d.a,p.n],encapsulation:2}),t})();var y=o("bTqV");let w=(()=>{class t{constructor(){this.hide=!0}}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-prefix-suffix-example"]],decls:19,vars:4,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview#prefix-amp-suffix"],[1,"example-container"],["appearance","fill","id","prefix-suffix-form-field-password"],["matInput","",3,"type"],["mat-icon-button","","matSuffix","",3,"click"],["appearance","fill","id","prefix-suffix-form-field-amount"],["matInput","","type","number",1,"example-right-align"],["matPrefix",""],["matSuffix",""]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Form field with prefix & suffix "),i.Tb(),i.Tb(),i.Ub(3,"div",2),i.Ub(4,"mat-form-field",3),i.Ub(5,"mat-label"),i.Cc(6,"Enter your password"),i.Tb(),i.Pb(7,"input",4),i.Ub(8,"button",5),i.cc("click",(function(){return e.hide=!e.hide})),i.Ub(9,"mat-icon"),i.Cc(10),i.Tb(),i.Tb(),i.Tb(),i.Ub(11,"mat-form-field",6),i.Ub(12,"mat-label"),i.Cc(13,"Amount"),i.Tb(),i.Pb(14,"input",7),i.Ub(15,"span",8),i.Cc(16,"$\xa0"),i.Tb(),i.Ub(17,"span",9),i.Cc(18,".00"),i.Tb(),i.Tb(),i.Tb()),2&t&&(i.Bb(7),i.mc("type",e.hide?"password":"text"),i.Bb(1),i.Cb("aria-label","Hide password")("aria-pressed",e.hide),i.Bb(2),i.Dc(e.hide?"visibility_off":"visibility"))},directives:[r.d,r.h,l.b,y.b,r.j,s.a,r.i],styles:[".example-container[_ngcontent-%COMP%]   .mat-form-field[_ngcontent-%COMP%] + .mat-form-field[_ngcontent-%COMP%]{margin-left:8px}.example-right-align[_ngcontent-%COMP%]{text-align:right}input.example-right-align[_ngcontent-%COMP%]::-webkit-inner-spin-button, input.example-right-align[_ngcontent-%COMP%]::-webkit-outer-spin-button{display:none}input.example-right-align[_ngcontent-%COMP%]{-moz-appearance:textfield}"]}),t})();function k(t,e){1&t&&(i.Ub(0,"mat-error"),i.Cc(1,"Min size: 10px"),i.Tb())}let C=(()=>{class t{constructor(t){this.colorControl=new b.e("primary"),this.fontSizeControl=new b.e(16,b.w.min(10)),this.options=t.group({color:this.colorControl,fontSize:this.fontSizeControl})}getFontSize(){return Math.max(10,this.fontSizeControl.value)}}return t.\u0275fac=function(e){return new(e||t)(i.Ob(b.d))},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-theming-example"]],decls:21,vars:8,consts:[[1,"example-h2"],["href","https://material.angular.io/components/form-field/overview#theming"],[1,"example-container",3,"formGroup"],["appearance","fill","id","modified-layout-form-field-color",3,"color"],[3,"formControl"],["value","primary"],["value","accent"],["value","warn"],["appearance","fill","id","modified-layout-form-field-size",3,"color"],["matInput","","type","number","placeholder","Ex. 12","min","10",3,"formControl"],["matSuffix",""],[4,"ngIf"]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Ub(1,"a",1),i.Cc(2," Form field theming "),i.Tb(),i.Tb(),i.Ub(3,"form",2),i.Ub(4,"mat-form-field",3),i.Ub(5,"mat-label"),i.Cc(6,"Color"),i.Tb(),i.Ub(7,"mat-select",4),i.Ub(8,"mat-option",5),i.Cc(9,"Primary"),i.Tb(),i.Ub(10,"mat-option",6),i.Cc(11,"Accent"),i.Tb(),i.Ub(12,"mat-option",7),i.Cc(13,"Warn"),i.Tb(),i.Tb(),i.Tb(),i.Ub(14,"mat-form-field",8),i.Ub(15,"mat-label"),i.Cc(16,"Font size"),i.Tb(),i.Pb(17,"input",9),i.Ub(18,"span",10),i.Cc(19,"px"),i.Tb(),i.Bc(20,k,2,0,"mat-error",11),i.Tb(),i.Tb()),2&t&&(i.Bb(3),i.Ac("font-size",e.getFontSize(),"px"),i.mc("formGroup",e.options),i.Bb(1),i.mc("color",e.colorControl.value),i.Bb(3),i.mc("formControl",e.colorControl),i.Bb(7),i.mc("color",e.colorControl.value),i.Bb(3),i.mc("formControl",e.fontSizeControl),i.Bb(3),i.mc("ngIf",e.fontSizeControl.invalid))},directives:[b.y,b.o,b.i,r.d,r.h,d.a,b.n,b.f,p.n,l.b,b.s,b.b,r.j,n.m,r.c],styles:[".example-container[_ngcontent-%COMP%]   .mat-form-field[_ngcontent-%COMP%] + .mat-form-field[_ngcontent-%COMP%]{margin-left:8px}"]}),t})();var T=o("8LU1"),U=o("XNiG"),_=o("u47x");const z=["area"],P=["exchange"],M=["subscriber"];let O=(()=>{class t{constructor(){this.form=new b.h({tel:new b.e(new I("","",""))})}}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["form-field-custom-control-example"]],decls:10,vars:0,consts:[[1,"example-h2"],["appearance","fill","id","form-field-phone-number-id"],["required",""],["matSuffix",""]],template:function(t,e){1&t&&(i.Ub(0,"h2",0),i.Cc(1,"Form field with custom telephone number input control"),i.Tb(),i.Ub(2,"mat-form-field",1),i.Ub(3,"mat-label"),i.Cc(4,"Phone number"),i.Tb(),i.Pb(5,"example-tel-input",2),i.Ub(6,"mat-icon",3),i.Cc(7,"phone"),i.Tb(),i.Ub(8,"mat-hint"),i.Cc(9,"Include area code"),i.Tb(),i.Tb())},directives:function(){return[r.d,r.h,R,s.a,r.j,r.g]},encapsulation:2}),t})();class I{constructor(t,e,o){this.area=t,this.exchange=e,this.subscriber=o}}let R=(()=>{class t{constructor(e,o,n,a){this._focusMonitor=o,this._elementRef=n,this.ngControl=a,this.stateChanges=new U.a,this.focused=!1,this.errorState=!1,this.controlType="example-tel-input",this.id="example-tel-input-"+t.nextId++,this.describedBy="",this.onChange=t=>{},this.onTouched=()=>{},this._required=!1,this._disabled=!1,this.parts=e.group({area:[null,[b.w.required,b.w.minLength(3),b.w.maxLength(3)]],exchange:[null,[b.w.required,b.w.minLength(3),b.w.maxLength(3)]],subscriber:[null,[b.w.required,b.w.minLength(4),b.w.maxLength(4)]]}),o.monitor(n,!0).subscribe(t=>{this.focused&&!t&&this.onTouched(),this.focused=!!t,this.stateChanges.next()}),null!=this.ngControl&&(this.ngControl.valueAccessor=this)}get empty(){const{value:{area:t,exchange:e,subscriber:o}}=this.parts;return!t&&!e&&!o}get shouldLabelFloat(){return this.focused||!this.empty}get placeholder(){return this._placeholder}set placeholder(t){this._placeholder=t,this.stateChanges.next()}get required(){return this._required}set required(t){this._required=Object(T.c)(t),this.stateChanges.next()}get disabled(){return this._disabled}set disabled(t){this._disabled=Object(T.c)(t),this._disabled?this.parts.disable():this.parts.enable(),this.stateChanges.next()}get value(){if(this.parts.valid){const{value:{area:t,exchange:e,subscriber:o}}=this.parts;return new I(t,e,o)}return null}set value(t){const{area:e,exchange:o,subscriber:n}=t||new I("","","");this.parts.setValue({area:e,exchange:o,subscriber:n}),this.stateChanges.next()}autoFocusNext(t,e){!t.errors&&e&&this._focusMonitor.focusVia(e,"program")}autoFocusPrev(t,e){t.value.length<1&&this._focusMonitor.focusVia(e,"program")}ngOnDestroy(){this.stateChanges.complete(),this._focusMonitor.stopMonitoring(this._elementRef)}setDescribedByIds(t){this.describedBy=t.join(" ")}onContainerClick(t){this._focusMonitor.focusVia(this.parts.controls.subscriber.valid||this.parts.controls.exchange.valid?this.subscriberInput:this.parts.controls.area.valid?this.exchangeInput:this.areaInput,"program")}writeValue(t){this.value=t}registerOnChange(t){this.onChange=t}registerOnTouched(t){this.onTouched=t}setDisabledState(t){this.disabled=t}_handleInput(t,e){this.autoFocusNext(t,e),this.onChange(this.value)}}return t.nextId=0,t.\u0275fac=function(e){return new(e||t)(i.Ob(b.d),i.Ob(_.h),i.Ob(i.l),i.Ob(b.m,10))},t.\u0275cmp=i.Ib({type:t,selectors:[["example-tel-input"]],viewQuery:function(t,e){var o;1&t&&(i.Hc(z,!0),i.Hc(P,!0),i.Hc(M,!0)),2&t&&(i.sc(o=i.dc())&&(e.areaInput=o.first),i.sc(o=i.dc())&&(e.exchangeInput=o.first),i.sc(o=i.dc())&&(e.subscriberInput=o.first))},hostVars:4,hostBindings:function(t,e){2&t&&(i.Xb("id",e.id),i.Cb("aria-describedby",e.describedBy),i.Eb("example-floating",e.shouldLabelFloat))},inputs:{placeholder:"placeholder",required:"required",disabled:"disabled",value:"value"},features:[i.Ab([{provide:r.e,useExisting:t}])],decls:11,vars:1,consts:[[1,"example-tel-input-container",3,"formGroup"],["formControlName","area","size","3","maxLength","3","aria-label","Area code","numbersOnly","",1,"example-tel-input-element",3,"input"],["area",""],[1,"example-tel-input-spacer"],["formControlName","exchange","maxLength","3","size","3","aria-label","Exchange code","numbersOnly","",1,"example-tel-input-element",3,"input","keyup.backspace"],["exchange",""],["formControlName","subscriber","maxLength","4","size","4","aria-label","Subscriber number","numbersOnly","",1,"example-tel-input-element",3,"input","keyup.backspace"],["subscriber",""]],template:function(t,e){if(1&t){const t=i.Vb();i.Ub(0,"div",0),i.Ub(1,"input",1,2),i.cc("input",(function(){i.vc(t);const o=i.tc(6);return e._handleInput(e.parts.controls.area,o)})),i.Tb(),i.Ub(3,"span",3),i.Cc(4,"\u2013"),i.Tb(),i.Ub(5,"input",4,5),i.cc("input",(function(){i.vc(t);const o=i.tc(10);return e._handleInput(e.parts.controls.exchange,o)}))("keyup.backspace",(function(){i.vc(t);const o=i.tc(2);return e.autoFocusPrev(e.parts.controls.exchange,o)})),i.Tb(),i.Ub(7,"span",3),i.Cc(8,"\u2013"),i.Tb(),i.Ub(9,"input",6,7),i.cc("input",(function(){return e._handleInput(e.parts.controls.subscriber)}))("keyup.backspace",(function(){i.vc(t);const o=i.tc(6);return e.autoFocusPrev(e.parts.controls.subscriber,o)})),i.Tb(),i.Tb()}2&t&&i.mc("formGroup",e.parts)},directives:[b.o,b.i,b.b,b.n,b.g],styles:[".example-tel-input-container[_ngcontent-%COMP%]{display:flex}.example-tel-input-element[_ngcontent-%COMP%]{border:none;background:none;padding:0;outline:none;font:inherit;text-align:center}.example-tel-input-spacer[_ngcontent-%COMP%]{opacity:0;transition:opacity .2s}.example-floating[_nghost-%COMP%]   .example-tel-input-spacer[_ngcontent-%COMP%]{opacity:1}"]}),t})();const B=[{path:"",component:(()=>{class t{}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=i.Ib({type:t,selectors:[["app-form-fields"]],decls:8,vars:0,template:function(t,e){1&t&&(i.Pb(0,"form-field-appearance-example"),i.Pb(1,"form-field-error-example"),i.Pb(2,"form-field-hint-example"),i.Pb(3,"form-field-label-example"),i.Pb(4,"form-field-overview-example"),i.Pb(5,"form-field-prefix-suffix-example"),i.Pb(6,"form-field-theming-example"),i.Pb(7,"form-field-custom-control-example"))},directives:[c,u,f,x,v,w,C,O],encapsulation:2}),t})()}];let L=(()=>{class t{}return t.\u0275mod=i.Mb({type:t}),t.\u0275inj=i.Lb({factory:function(e){return new(e||t)},imports:[[a.b.forChild(B)],a.b]}),t})(),q=(()=>{class t{}return t.\u0275mod=i.Mb({type:t}),t.\u0275inj=i.Lb({factory:function(e){return new(e||t)},imports:[[n.c,L,r.f,s.b,l.c,d.b,b.t,h.b,g.c,y.c]]}),t})()},bTqV:function(t,e,o){"use strict";o.d(e,"a",(function(){return d})),o.d(e,"b",(function(){return u})),o.d(e,"c",(function(){return p}));var n=o("FKr1"),a=o("R1ws"),i=o("fXoL"),r=o("u47x");const l=["mat-button",""],s=["*"],c=["mat-button","mat-flat-button","mat-icon-button","mat-raised-button","mat-stroked-button","mat-mini-fab","mat-fab"];class b{constructor(t){this._elementRef=t}}const m=Object(n.x)(Object(n.z)(Object(n.y)(b)));let u=(()=>{class t extends m{constructor(t,e,o){super(t),this._focusMonitor=e,this._animationMode=o,this.isRoundButton=this._hasHostAttributes("mat-fab","mat-mini-fab"),this.isIconButton=this._hasHostAttributes("mat-icon-button");for(const n of c)this._hasHostAttributes(n)&&this._getHostElement().classList.add(n);t.nativeElement.classList.add("mat-button-base"),this._focusMonitor.monitor(this._elementRef,!0),this.isRoundButton&&(this.color="accent")}ngOnDestroy(){this._focusMonitor.stopMonitoring(this._elementRef)}focus(t="program",e){this._focusMonitor.focusVia(this._getHostElement(),t,e)}_getHostElement(){return this._elementRef.nativeElement}_isRippleDisabled(){return this.disableRipple||this.disabled}_hasHostAttributes(...t){return t.some(t=>this._getHostElement().hasAttribute(t))}}return t.\u0275fac=function(e){return new(e||t)(i.Ob(i.l),i.Ob(r.h),i.Ob(a.a,8))},t.\u0275cmp=i.Ib({type:t,selectors:[["button","mat-button",""],["button","mat-raised-button",""],["button","mat-icon-button",""],["button","mat-fab",""],["button","mat-mini-fab",""],["button","mat-stroked-button",""],["button","mat-flat-button",""]],viewQuery:function(t,e){var o;1&t&&i.Hc(n.s,!0),2&t&&i.sc(o=i.dc())&&(e.ripple=o.first)},hostAttrs:[1,"mat-focus-indicator"],hostVars:3,hostBindings:function(t,e){2&t&&(i.Cb("disabled",e.disabled||null),i.Eb("_mat-animation-noopable","NoopAnimations"===e._animationMode))},inputs:{disabled:"disabled",disableRipple:"disableRipple",color:"color"},exportAs:["matButton"],features:[i.yb],attrs:l,ngContentSelectors:s,decls:4,vars:5,consts:[[1,"mat-button-wrapper"],["matRipple","",1,"mat-button-ripple",3,"matRippleDisabled","matRippleCentered","matRippleTrigger"],[1,"mat-button-focus-overlay"]],template:function(t,e){1&t&&(i.lc(),i.Ub(0,"span",0),i.kc(1),i.Tb(),i.Pb(2,"div",1),i.Pb(3,"div",2)),2&t&&(i.Bb(2),i.Eb("mat-button-ripple-round",e.isRoundButton||e.isIconButton),i.mc("matRippleDisabled",e._isRippleDisabled())("matRippleCentered",e.isIconButton)("matRippleTrigger",e._getHostElement()))},directives:[n.s],styles:[".mat-button .mat-button-focus-overlay,.mat-icon-button .mat-button-focus-overlay{opacity:0}.mat-button:hover .mat-button-focus-overlay,.mat-stroked-button:hover .mat-button-focus-overlay{opacity:.04}@media(hover: none){.mat-button:hover .mat-button-focus-overlay,.mat-stroked-button:hover .mat-button-focus-overlay{opacity:0}}.mat-button,.mat-icon-button,.mat-stroked-button,.mat-flat-button{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible}.mat-button::-moz-focus-inner,.mat-icon-button::-moz-focus-inner,.mat-stroked-button::-moz-focus-inner,.mat-flat-button::-moz-focus-inner{border:0}.mat-button[disabled],.mat-icon-button[disabled],.mat-stroked-button[disabled],.mat-flat-button[disabled]{cursor:default}.mat-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-button.cdk-program-focused .mat-button-focus-overlay,.mat-icon-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-icon-button.cdk-program-focused .mat-button-focus-overlay,.mat-stroked-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-stroked-button.cdk-program-focused .mat-button-focus-overlay,.mat-flat-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-flat-button.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-button::-moz-focus-inner,.mat-icon-button::-moz-focus-inner,.mat-stroked-button::-moz-focus-inner,.mat-flat-button::-moz-focus-inner{border:0}.mat-raised-button{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible;transform:translate3d(0, 0, 0);transition:background 400ms cubic-bezier(0.25, 0.8, 0.25, 1),box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1)}.mat-raised-button::-moz-focus-inner{border:0}.mat-raised-button[disabled]{cursor:default}.mat-raised-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-raised-button.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-raised-button::-moz-focus-inner{border:0}._mat-animation-noopable.mat-raised-button{transition:none;animation:none}.mat-stroked-button{border:1px solid currentColor;padding:0 15px;line-height:34px}.mat-stroked-button .mat-button-ripple.mat-ripple,.mat-stroked-button .mat-button-focus-overlay{top:-1px;left:-1px;right:-1px;bottom:-1px}.mat-fab{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible;transform:translate3d(0, 0, 0);transition:background 400ms cubic-bezier(0.25, 0.8, 0.25, 1),box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1);min-width:0;border-radius:50%;width:56px;height:56px;padding:0;flex-shrink:0}.mat-fab::-moz-focus-inner{border:0}.mat-fab[disabled]{cursor:default}.mat-fab.cdk-keyboard-focused .mat-button-focus-overlay,.mat-fab.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-fab::-moz-focus-inner{border:0}._mat-animation-noopable.mat-fab{transition:none;animation:none}.mat-fab .mat-button-wrapper{padding:16px 0;display:inline-block;line-height:24px}.mat-mini-fab{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible;transform:translate3d(0, 0, 0);transition:background 400ms cubic-bezier(0.25, 0.8, 0.25, 1),box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1);min-width:0;border-radius:50%;width:40px;height:40px;padding:0;flex-shrink:0}.mat-mini-fab::-moz-focus-inner{border:0}.mat-mini-fab[disabled]{cursor:default}.mat-mini-fab.cdk-keyboard-focused .mat-button-focus-overlay,.mat-mini-fab.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-mini-fab::-moz-focus-inner{border:0}._mat-animation-noopable.mat-mini-fab{transition:none;animation:none}.mat-mini-fab .mat-button-wrapper{padding:8px 0;display:inline-block;line-height:24px}.mat-icon-button{padding:0;min-width:0;width:40px;height:40px;flex-shrink:0;line-height:40px;border-radius:50%}.mat-icon-button i,.mat-icon-button .mat-icon{line-height:24px}.mat-button-ripple.mat-ripple,.mat-button-focus-overlay{top:0;left:0;right:0;bottom:0;position:absolute;pointer-events:none;border-radius:inherit}.mat-button-ripple.mat-ripple:not(:empty){transform:translateZ(0)}.mat-button-focus-overlay{opacity:0;transition:opacity 200ms cubic-bezier(0.35, 0, 0.25, 1),background-color 200ms cubic-bezier(0.35, 0, 0.25, 1)}._mat-animation-noopable .mat-button-focus-overlay{transition:none}.cdk-high-contrast-active .mat-button-focus-overlay{background-color:#fff}.cdk-high-contrast-black-on-white .mat-button-focus-overlay{background-color:#000}.mat-button-ripple-round{border-radius:50%;z-index:1}.mat-button .mat-button-wrapper>*,.mat-flat-button .mat-button-wrapper>*,.mat-stroked-button .mat-button-wrapper>*,.mat-raised-button .mat-button-wrapper>*,.mat-icon-button .mat-button-wrapper>*,.mat-fab .mat-button-wrapper>*,.mat-mini-fab .mat-button-wrapper>*{vertical-align:middle}.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-prefix .mat-icon-button,.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-suffix .mat-icon-button{display:block;font-size:inherit;width:2.5em;height:2.5em}.cdk-high-contrast-active .mat-button,.cdk-high-contrast-active .mat-flat-button,.cdk-high-contrast-active .mat-raised-button,.cdk-high-contrast-active .mat-icon-button,.cdk-high-contrast-active .mat-fab,.cdk-high-contrast-active .mat-mini-fab{outline:solid 1px}\n"],encapsulation:2,changeDetection:0}),t})(),d=(()=>{class t extends u{constructor(t,e,o){super(e,t,o)}_haltDisabledEvents(t){this.disabled&&(t.preventDefault(),t.stopImmediatePropagation())}}return t.\u0275fac=function(e){return new(e||t)(i.Ob(r.h),i.Ob(i.l),i.Ob(a.a,8))},t.\u0275cmp=i.Ib({type:t,selectors:[["a","mat-button",""],["a","mat-raised-button",""],["a","mat-icon-button",""],["a","mat-fab",""],["a","mat-mini-fab",""],["a","mat-stroked-button",""],["a","mat-flat-button",""]],hostAttrs:[1,"mat-focus-indicator"],hostVars:5,hostBindings:function(t,e){1&t&&i.cc("click",(function(t){return e._haltDisabledEvents(t)})),2&t&&(i.Cb("tabindex",e.disabled?-1:e.tabIndex||0)("disabled",e.disabled||null)("aria-disabled",e.disabled.toString()),i.Eb("_mat-animation-noopable","NoopAnimations"===e._animationMode))},inputs:{disabled:"disabled",disableRipple:"disableRipple",color:"color",tabIndex:"tabIndex"},exportAs:["matButton","matAnchor"],features:[i.yb],attrs:l,ngContentSelectors:s,decls:4,vars:5,consts:[[1,"mat-button-wrapper"],["matRipple","",1,"mat-button-ripple",3,"matRippleDisabled","matRippleCentered","matRippleTrigger"],[1,"mat-button-focus-overlay"]],template:function(t,e){1&t&&(i.lc(),i.Ub(0,"span",0),i.kc(1),i.Tb(),i.Pb(2,"div",1),i.Pb(3,"div",2)),2&t&&(i.Bb(2),i.Eb("mat-button-ripple-round",e.isRoundButton||e.isIconButton),i.mc("matRippleDisabled",e._isRippleDisabled())("matRippleCentered",e.isIconButton)("matRippleTrigger",e._getHostElement()))},directives:[n.s],styles:[".mat-button .mat-button-focus-overlay,.mat-icon-button .mat-button-focus-overlay{opacity:0}.mat-button:hover .mat-button-focus-overlay,.mat-stroked-button:hover .mat-button-focus-overlay{opacity:.04}@media(hover: none){.mat-button:hover .mat-button-focus-overlay,.mat-stroked-button:hover .mat-button-focus-overlay{opacity:0}}.mat-button,.mat-icon-button,.mat-stroked-button,.mat-flat-button{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible}.mat-button::-moz-focus-inner,.mat-icon-button::-moz-focus-inner,.mat-stroked-button::-moz-focus-inner,.mat-flat-button::-moz-focus-inner{border:0}.mat-button[disabled],.mat-icon-button[disabled],.mat-stroked-button[disabled],.mat-flat-button[disabled]{cursor:default}.mat-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-button.cdk-program-focused .mat-button-focus-overlay,.mat-icon-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-icon-button.cdk-program-focused .mat-button-focus-overlay,.mat-stroked-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-stroked-button.cdk-program-focused .mat-button-focus-overlay,.mat-flat-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-flat-button.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-button::-moz-focus-inner,.mat-icon-button::-moz-focus-inner,.mat-stroked-button::-moz-focus-inner,.mat-flat-button::-moz-focus-inner{border:0}.mat-raised-button{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible;transform:translate3d(0, 0, 0);transition:background 400ms cubic-bezier(0.25, 0.8, 0.25, 1),box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1)}.mat-raised-button::-moz-focus-inner{border:0}.mat-raised-button[disabled]{cursor:default}.mat-raised-button.cdk-keyboard-focused .mat-button-focus-overlay,.mat-raised-button.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-raised-button::-moz-focus-inner{border:0}._mat-animation-noopable.mat-raised-button{transition:none;animation:none}.mat-stroked-button{border:1px solid currentColor;padding:0 15px;line-height:34px}.mat-stroked-button .mat-button-ripple.mat-ripple,.mat-stroked-button .mat-button-focus-overlay{top:-1px;left:-1px;right:-1px;bottom:-1px}.mat-fab{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible;transform:translate3d(0, 0, 0);transition:background 400ms cubic-bezier(0.25, 0.8, 0.25, 1),box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1);min-width:0;border-radius:50%;width:56px;height:56px;padding:0;flex-shrink:0}.mat-fab::-moz-focus-inner{border:0}.mat-fab[disabled]{cursor:default}.mat-fab.cdk-keyboard-focused .mat-button-focus-overlay,.mat-fab.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-fab::-moz-focus-inner{border:0}._mat-animation-noopable.mat-fab{transition:none;animation:none}.mat-fab .mat-button-wrapper{padding:16px 0;display:inline-block;line-height:24px}.mat-mini-fab{box-sizing:border-box;position:relative;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:pointer;outline:none;border:none;-webkit-tap-highlight-color:transparent;display:inline-block;white-space:nowrap;text-decoration:none;vertical-align:baseline;text-align:center;margin:0;min-width:64px;line-height:36px;padding:0 16px;border-radius:4px;overflow:visible;transform:translate3d(0, 0, 0);transition:background 400ms cubic-bezier(0.25, 0.8, 0.25, 1),box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1);min-width:0;border-radius:50%;width:40px;height:40px;padding:0;flex-shrink:0}.mat-mini-fab::-moz-focus-inner{border:0}.mat-mini-fab[disabled]{cursor:default}.mat-mini-fab.cdk-keyboard-focused .mat-button-focus-overlay,.mat-mini-fab.cdk-program-focused .mat-button-focus-overlay{opacity:.12}.mat-mini-fab::-moz-focus-inner{border:0}._mat-animation-noopable.mat-mini-fab{transition:none;animation:none}.mat-mini-fab .mat-button-wrapper{padding:8px 0;display:inline-block;line-height:24px}.mat-icon-button{padding:0;min-width:0;width:40px;height:40px;flex-shrink:0;line-height:40px;border-radius:50%}.mat-icon-button i,.mat-icon-button .mat-icon{line-height:24px}.mat-button-ripple.mat-ripple,.mat-button-focus-overlay{top:0;left:0;right:0;bottom:0;position:absolute;pointer-events:none;border-radius:inherit}.mat-button-ripple.mat-ripple:not(:empty){transform:translateZ(0)}.mat-button-focus-overlay{opacity:0;transition:opacity 200ms cubic-bezier(0.35, 0, 0.25, 1),background-color 200ms cubic-bezier(0.35, 0, 0.25, 1)}._mat-animation-noopable .mat-button-focus-overlay{transition:none}.cdk-high-contrast-active .mat-button-focus-overlay{background-color:#fff}.cdk-high-contrast-black-on-white .mat-button-focus-overlay{background-color:#000}.mat-button-ripple-round{border-radius:50%;z-index:1}.mat-button .mat-button-wrapper>*,.mat-flat-button .mat-button-wrapper>*,.mat-stroked-button .mat-button-wrapper>*,.mat-raised-button .mat-button-wrapper>*,.mat-icon-button .mat-button-wrapper>*,.mat-fab .mat-button-wrapper>*,.mat-mini-fab .mat-button-wrapper>*{vertical-align:middle}.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-prefix .mat-icon-button,.mat-form-field:not(.mat-form-field-appearance-legacy) .mat-form-field-suffix .mat-icon-button{display:block;font-size:inherit;width:2.5em;height:2.5em}.cdk-high-contrast-active .mat-button,.cdk-high-contrast-active .mat-flat-button,.cdk-high-contrast-active .mat-raised-button,.cdk-high-contrast-active .mat-icon-button,.cdk-high-contrast-active .mat-fab,.cdk-high-contrast-active .mat-mini-fab{outline:solid 1px}\n"],encapsulation:2,changeDetection:0}),t})(),p=(()=>{class t{}return t.\u0275mod=i.Mb({type:t}),t.\u0275inj=i.Lb({factory:function(e){return new(e||t)},imports:[[n.t,n.j],n.j]}),t})()}}]);