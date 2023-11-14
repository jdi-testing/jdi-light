"use strict";(self.webpackChunkmy_app=self.webpackChunkmy_app||[]).push([[1731],{1731:(M,c,n)=>{n.r(c),n.d(c,{ListModule:()=>C});var o=n(6895),u=n(6630),e=n(4650),l=n(6338);let g=(()=>{class t{}return t.\u0275fac=function(i){return new(i||t)},t.\u0275cmp=e.Xpm({type:t,selectors:[["list-overview-example"]],decls:10,vars:0,consts:[[1,"example-h2"],["href","https://material.angular.io/components/list/overview"],["id","basic-list","role","list"],["id","basic-list-item-1","role","listitem"],["id","basic-list-item-2","role","listitem"],["id","basic-list-item-3","role","listitem"]],template:function(i,a){1&i&&(e.TgZ(0,"h2",0)(1,"a",1),e._uU(2," Basic list "),e.qZA()(),e.TgZ(3,"mat-list",2)(4,"mat-list-item",3),e._uU(5,"Item 1"),e.qZA(),e.TgZ(6,"mat-list-item",4),e._uU(7,"Item 2"),e.qZA(),e.TgZ(8,"mat-list-item",5),e._uU(9,"Item 3"),e.qZA()())},dependencies:[l.i$,l.Tg],encapsulation:2}),t})();var h=n(8729),r=n(7392);function T(t,s){if(1&t&&(e.TgZ(0,"mat-list-item",5)(1,"mat-icon",6),e._uU(2,"folder"),e.qZA(),e.TgZ(3,"div",7),e._uU(4),e.qZA(),e.TgZ(5,"div",7),e._uU(6),e.ALo(7,"date"),e.qZA()()),2&t){const i=s.$implicit;e.s9C("id","list-with-section-items-"+i.name.toLowerCase()),e.xp6(4),e.Oqu(i.name),e.xp6(2),e.hij(" ",e.lcZ(7,3,i.updated)," ")}}function f(t,s){if(1&t&&(e.TgZ(0,"mat-list-item",5)(1,"mat-icon",6),e._uU(2,"note"),e.qZA(),e.TgZ(3,"div",7),e._uU(4),e.qZA(),e.TgZ(5,"div",7),e._uU(6),e.ALo(7,"date"),e.qZA()()),2&t){const i=s.$implicit;e.s9C("id","list-with-section-items-"+i.name.toLowerCase().replace(" ","-")),e.xp6(4),e.Oqu(i.name),e.xp6(2),e.hij(" ",e.lcZ(7,3,i.updated)," ")}}let A=(()=>{class t{constructor(){this.folders=[{name:"Photos",updated:new Date("1/1/16")},{name:"Recipes",updated:new Date("1/17/16")},{name:"Work",updated:new Date("1/28/16")}],this.notes=[{name:"Vacation Itinerary",updated:new Date("2/20/16")},{name:"Kitchen Remodel",updated:new Date("1/18/16")}]}}return t.\u0275fac=function(i){return new(i||t)},t.\u0275cmp=e.Xpm({type:t,selectors:[["list-sections-example"]],decls:11,vars:2,consts:[[1,"example-h2"],["href","https://material.angular.io/components/list/overview#lists-with-multiple-sections"],["id","list-with-sections",1,"auto-height"],["mat-subheader",""],[3,"id",4,"ngFor","ngForOf"],[3,"id"],["mat-list-icon",""],["mat-line",""]],template:function(i,a){1&i&&(e.TgZ(0,"h2",0)(1,"a",1),e._uU(2," List with sections "),e.qZA()(),e.TgZ(3,"mat-list",2)(4,"div",3),e._uU(5,"Folders"),e.qZA(),e.YNc(6,T,8,5,"mat-list-item",4),e._UZ(7,"mat-divider"),e.TgZ(8,"div",3),e._uU(9,"Notes"),e.qZA(),e.YNc(10,f,8,5,"mat-list-item",4),e.qZA()),2&i&&(e.xp6(6),e.Q6J("ngForOf",a.folders),e.xp6(4),e.Q6J("ngForOf",a.notes))},dependencies:[o.sg,l.i$,l.Tg,l.gs,h.d,r.Hw,o.uU],styles:[".mat-list-icon[_ngcontent-%COMP%]{color:#0000008a}.auto-height[_ngcontent-%COMP%]   mat-list-item[_ngcontent-%COMP%]{height:auto}"]}),t})();function v(t,s){if(1&t&&(e.TgZ(0,"mat-list-option",5),e._uU(1),e.qZA()),2&t){const i=s.$implicit;e.s9C("id","list-with-selection-option-"+s.index),e.xp6(1),e.Oqu(i)}}let x=(()=>{class t{constructor(){this.typesOfShoes=["Boots","Clogs","Loafers","Moccasins","Sneakers"]}}return t.\u0275fac=function(i){return new(i||t)},t.\u0275cmp=e.Xpm({type:t,selectors:[["list-with-selection-example"]],decls:8,vars:2,consts:[[1,"example-h2"],["href","https://material.angular.io/components/list/examples#list-selection"],["id","list-with-selection"],["shoes",""],[3,"id",4,"ngFor","ngForOf"],[3,"id"]],template:function(i,a){if(1&i&&(e.TgZ(0,"h2",0)(1,"a",1),e._uU(2," List with selection "),e.qZA()(),e.TgZ(3,"mat-selection-list",2,3),e.YNc(5,v,2,2,"mat-list-option",4),e.qZA(),e.TgZ(6,"p"),e._uU(7),e.qZA()),2&i){const p=e.MAs(4);e.xp6(5),e.Q6J("ngForOf",a.typesOfShoes),e.xp6(2),e.hij("Options selected: ",p.selectedOptions.selected.length,"")}},dependencies:[o.sg,l.Ub,l.vS]}),t})();var m=n(9549),d=n(4385),_=n(3238);function U(t,s){if(1&t&&(e.TgZ(0,"mat-list-option",24),e._uU(1),e.qZA()),2&t){const i=s.$implicit;e.Q6J("value",i),e.xp6(1),e.Oqu(i)}}let q=(()=>{class t{constructor(){this.typesOfShoes=["Boots","Clogs","Loafers","Moccasins","Sneakers"]}}return t.\u0275fac=function(i){return new(i||t)},t.\u0275cmp=e.Xpm({type:t,selectors:[["list-with-single-selection-example"]],decls:61,vars:9,consts:[[1,"example-h2"],["href","https://material.angular.io/components/list/examples#list-single-selection"],[1,"control-panel"],["value","false","id","mat-select-disable-ripple"],["disableRipple",""],["value","true"],["value","false"],["value","false","id","mat-select-disabled"],["disabled",""],["value","1","id","mat-select-lines"],["lines",""],["value","1"],["value","2"],["value","3"],["value","false","id","mat-select-is-last-selected"],["isSelected",""],["value","false","id","mat-select-hide-indicator"],["hideIndicator",""],["id","list-with-single-selection",3,"multiple","disableRipple","disabled","hideSingleSelectionIndicator"],["shoes",""],[3,"value",4,"ngFor","ngForOf"],[3,"lines","value","selected"],["matListItemTitle",""],["matListItemLine",""],[3,"value"]],template:function(i,a){if(1&i&&(e.TgZ(0,"h2",0)(1,"a",1),e._uU(2," List with single selection "),e.qZA()(),e.TgZ(3,"div",2)(4,"mat-form-field")(5,"mat-label"),e._uU(6,"Disable Ripple"),e.qZA(),e.TgZ(7,"mat-select",3,4)(9,"mat-option",5),e._uU(10,"True"),e.qZA(),e.TgZ(11,"mat-option",6),e._uU(12,"False"),e.qZA()()(),e.TgZ(13,"mat-form-field")(14,"mat-label"),e._uU(15,"Disabled"),e.qZA(),e.TgZ(16,"mat-select",7,8)(18,"mat-option",5),e._uU(19,"True"),e.qZA(),e.TgZ(20,"mat-option",6),e._uU(21,"False"),e.qZA()()(),e.TgZ(22,"mat-form-field")(23,"mat-label"),e._uU(24,"Lines"),e.qZA(),e.TgZ(25,"mat-select",9,10)(27,"mat-option",11),e._uU(28,"1 Line"),e.qZA(),e.TgZ(29,"mat-option",12),e._uU(30,"2 Lines"),e.qZA(),e.TgZ(31,"mat-option",13),e._uU(32,"3 Lines"),e.qZA()()(),e.TgZ(33,"mat-form-field")(34,"mat-label"),e._uU(35,"Is Custom line selected"),e.qZA(),e.TgZ(36,"mat-select",14,15)(38,"mat-option",6),e._uU(39,"false"),e.qZA(),e.TgZ(40,"mat-option",5),e._uU(41,"true"),e.qZA()()(),e.TgZ(42,"mat-form-field")(43,"mat-label"),e._uU(44,"Hide indicator"),e.qZA(),e.TgZ(45,"mat-select",16,17)(47,"mat-option",6),e._uU(48,"false"),e.qZA(),e.TgZ(49,"mat-option",5),e._uU(50,"true"),e.qZA()()()(),e.TgZ(51,"mat-selection-list",18,19),e.YNc(53,U,2,2,"mat-list-option",20),e.TgZ(54,"mat-list-option",21)(55,"span",22),e._uU(56,"Option with the custom lines"),e.qZA(),e.TgZ(57,"span",23),e._uU(58,"Option for lines, selected"),e.qZA()()(),e.TgZ(59,"p"),e._uU(60),e.qZA()),2&i){const p=e.MAs(8),y=e.MAs(17),O=e.MAs(26),E=e.MAs(37),F=e.MAs(46),Z=e.MAs(52);e.xp6(51),e.Q6J("multiple",!1)("disableRipple",p.value)("disabled",y.value)("hideSingleSelectionIndicator",F.value),e.xp6(2),e.Q6J("ngForOf",a.typesOfShoes),e.xp6(1),e.Q6J("lines",O.value)("value","custom line")("selected",E.value),e.xp6(6),e.hij(" Option selected: ",Z.selectedOptions.hasValue()?Z.selectedOptions.selected[0].value:"None","\n")}},dependencies:[o.sg,l.Ub,l.vS,l.WW,l.sL,m.KE,m.hX,d.gD,_.ey],styles:[".control-panel[_ngcontent-%COMP%]{display:flex;gap:20px}"]}),t})(),L=(()=>{class t{}return t.\u0275fac=function(i){return new(i||t)},t.\u0275cmp=e.Xpm({type:t,selectors:[["list-variants-example"]],decls:63,vars:0,consts:[[1,"example-h2"],["href","https://material.angular.io/components/list/examples#list-variants"],["id","list-variants-single-line"],["matListItemTitle",""],["id","list-variants-two-line-lists"],["matListItemLine",""],["id","list-variants-three-line-lists"],["id","list-variants-three-line-list-with-secondary-text-wrapping",1,"example-list-wrapping"],["lines","3"]],template:function(i,a){1&i&&(e.TgZ(0,"h2",0)(1,"a",1),e._uU(2," List variants "),e.qZA()(),e.TgZ(3,"h2"),e._uU(4,"Single line lists"),e.qZA(),e.TgZ(5,"mat-list",2)(6,"mat-list-item")(7,"span",3),e._uU(8,"This is the title"),e.qZA()(),e.TgZ(9,"mat-list-item"),e._uU(10,"Also the title"),e.qZA()(),e.TgZ(11,"h2"),e._uU(12,"Two line lists"),e.qZA(),e.TgZ(13,"mat-list",4)(14,"mat-list-item")(15,"span",3),e._uU(16,"Title"),e.qZA(),e.TgZ(17,"span",5),e._uU(18,"Second line"),e.qZA()(),e.TgZ(19,"mat-list-item")(20,"span",3),e._uU(21,"Title"),e.qZA(),e.TgZ(22,"span"),e._uU(23,"Second line"),e.qZA()(),e.TgZ(24,"mat-list-item")(25,"span",3),e._uU(26,"Title"),e.qZA(),e._uU(27," Second line "),e.qZA()(),e.TgZ(28,"h2"),e._uU(29,"Three line lists"),e.qZA(),e.TgZ(30,"mat-list",6)(31,"mat-list-item")(32,"span",3),e._uU(33,"Title"),e.qZA(),e.TgZ(34,"span",5),e._uU(35,"Second line"),e.qZA(),e.TgZ(36,"span",5),e._uU(37,"Third line"),e.qZA()(),e.TgZ(38,"mat-list-item")(39,"span",3),e._uU(40,"Title"),e.qZA(),e.TgZ(41,"span",5),e._uU(42,"Second line. This line will truncate."),e.qZA(),e.TgZ(43,"span"),e._uU(44,"Third line"),e.qZA()(),e.TgZ(45,"mat-list-item")(46,"span",3),e._uU(47,"Title"),e.qZA(),e.TgZ(48,"span",5),e._uU(49,"Second line. This line will truncate."),e.qZA(),e._uU(50," Third line "),e.qZA()(),e.TgZ(51,"h2"),e._uU(52,"Three line list with secondary text wrapping"),e.qZA(),e.TgZ(53,"mat-list",7)(54,"mat-list-item",8)(55,"span",3),e._uU(56,"Title"),e.qZA(),e.TgZ(57,"span"),e._uU(58,"Secondary line that will wrap because the list lines is explicitly set to 3 lines. Text inside of a `matListItemTitle` or `matListItemLine` will never wrap. "),e.qZA()(),e.TgZ(59,"mat-list-item",8)(60,"span",3),e._uU(61,"Title"),e.qZA(),e._uU(62," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est "),e.qZA()())},dependencies:[l.i$,l.Tg,l.WW,l.sL],styles:[".example-list-wrapping[_ngcontent-%COMP%]{max-width:500px}"]}),t})();const w=[{path:"",component:(()=>{class t{}return t.\u0275fac=function(i){return new(i||t)},t.\u0275cmp=e.Xpm({type:t,selectors:[["app-list"]],decls:5,vars:0,template:function(i,a){1&i&&e._UZ(0,"list-overview-example")(1,"list-sections-example")(2,"list-with-selection-example")(3,"list-variants-example")(4,"list-with-single-selection-example")},dependencies:[g,A,x,q,L],encapsulation:2}),t})()}];let S=(()=>{class t{}return t.\u0275fac=function(i){return new(i||t)},t.\u0275mod=e.oAB({type:t}),t.\u0275inj=e.cJS({imports:[u.Bz.forChild(w),u.Bz]}),t})(),C=(()=>{class t{}return t.\u0275fac=function(i){return new(i||t)},t.\u0275mod=e.oAB({type:t}),t.\u0275inj=e.cJS({imports:[o.ez,S,l.ie,r.Ps,m.lN,d.LD]}),t})()}}]);