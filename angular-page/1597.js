"use strict";(self.webpackChunkmy_app=self.webpackChunkmy_app||[]).push([[1597],{1597:(T,m,i)=>{i.r(m),i.d(m,{SortHeaderModule:()=>x});var p=i(6895),v=i(6630),e=i(4650),u=i(6308),c=i(9549),f=i(4385),g=i(3238);function Z(a,l){if(1&a&&(e.TgZ(0,"tr")(1,"td"),e._uU(2),e.qZA(),e.TgZ(3,"td"),e._uU(4),e.qZA(),e.TgZ(5,"td"),e._uU(6),e.qZA(),e.TgZ(7,"td"),e._uU(8),e.qZA(),e.TgZ(9,"td"),e._uU(10),e.qZA()()),2&a){const t=l.$implicit;e.xp6(2),e.Oqu(t.name),e.xp6(2),e.Oqu(t.calories),e.xp6(2),e.Oqu(t.fat),e.xp6(2),e.Oqu(t.carbs),e.xp6(2),e.Oqu(t.protein)}}function n(a,l,t){return(a<l?-1:1)*(t?1:-1)}const b=[{path:"",component:(()=>{class a{constructor(){this.desserts=[{name:"Frozen yogurt",calories:159,fat:6,carbs:24,protein:4},{name:"Ice cream sandwich",calories:237,fat:9,carbs:37,protein:4},{name:"Eclair",calories:262,fat:16,carbs:24,protein:6},{name:"Cupcake",calories:305,fat:4,carbs:67,protein:4},{name:"Gingerbread",calories:356,fat:16,carbs:49,protein:4}],this.sortedData=this.desserts.slice()}sortData(t){const d=this.desserts.slice();this.sortedData=t.active&&""!==t.direction?d.sort((o,r)=>{const s="asc"===t.direction;switch(t.active){case"name":return n(o.name,r.name,s);case"calories":return n(o.calories,r.calories,s);case"fat":return n(o.fat,r.fat,s);case"carbs":return n(o.carbs,r.carbs,s);case"protein":return n(o.protein,r.protein,s);default:return 0}}):d}}return a.\u0275fac=function(t){return new(t||a)},a.\u0275cmp=e.Xpm({type:a,selectors:[["sort-overview-example"]],decls:45,vars:22,consts:[[1,"example-h2"],["href","https://material.angular.io/components/sort/overview"],[1,"control-panel"],["value","after","id","mat-sort-header-arrow-position-select"],["arrowPosition",""],["value","after"],["value","before"],["id","mat-sort-header-disable-sort-select",3,"value"],["isDisabled",""],[3,"value"],["id","mat-sort-header-disable-clear-select",3,"value"],["isDisableClear",""],["matSort","","id","sort-headers",3,"matSortChange"],["mat-sort-header","name",3,"arrowPosition","disabled","disableClear"],["mat-sort-header","calories",3,"arrowPosition","disabled","disableClear"],["mat-sort-header","fat",3,"arrowPosition","disabled","disableClear"],["mat-sort-header","carbs",3,"arrowPosition","disabled","disableClear"],["mat-sort-header","protein",3,"arrowPosition","disabled","disableClear"],[4,"ngFor","ngForOf"]],template:function(t,d){if(1&t&&(e.TgZ(0,"h2",0)(1,"a",1),e._uU(2," Sorting overview "),e.qZA()(),e._UZ(3,"br"),e.TgZ(4,"div",2)(5,"mat-form-field")(6,"mat-label"),e._uU(7,"Arrow Position"),e.qZA(),e.TgZ(8,"mat-select",3,4)(10,"mat-option",5),e._uU(11,"After"),e.qZA(),e.TgZ(12,"mat-option",6),e._uU(13,"Before"),e.qZA()()(),e.TgZ(14,"mat-form-field")(15,"mat-label"),e._uU(16,"Disable Sort"),e.qZA(),e.TgZ(17,"mat-select",7,8)(19,"mat-option",9),e._uU(20,"False"),e.qZA(),e.TgZ(21,"mat-option",9),e._uU(22,"True"),e.qZA()()(),e.TgZ(23,"mat-form-field")(24,"mat-label"),e._uU(25,"Disable Clear"),e.qZA(),e.TgZ(26,"mat-select",10,11)(28,"mat-option",9),e._uU(29,"False"),e.qZA(),e.TgZ(30,"mat-option",9),e._uU(31,"True"),e.qZA()()()(),e.TgZ(32,"table",12),e.NdJ("matSortChange",function(r){return d.sortData(r)}),e.TgZ(33,"tr")(34,"th",13),e._uU(35,"Dessert (100g)"),e.qZA(),e.TgZ(36,"th",14),e._uU(37,"Calories"),e.qZA(),e.TgZ(38,"th",15),e._uU(39,"Fat (g)"),e.qZA(),e.TgZ(40,"th",16),e._uU(41,"Carbs (g)"),e.qZA(),e.TgZ(42,"th",17),e._uU(43,"Protein (g)"),e.qZA()(),e.YNc(44,Z,11,5,"tr",18),e.qZA()),2&t){const o=e.MAs(9),r=e.MAs(18),s=e.MAs(27);e.xp6(17),e.Q6J("value",!1),e.xp6(2),e.Q6J("value",!1),e.xp6(2),e.Q6J("value",!0),e.xp6(5),e.Q6J("value",!1),e.xp6(2),e.Q6J("value",!1),e.xp6(2),e.Q6J("value",!0),e.xp6(4),e.Q6J("arrowPosition",o.value)("disabled",r.value)("disableClear",s.value),e.xp6(2),e.Q6J("arrowPosition",o.value)("disabled",r.value)("disableClear",s.value),e.xp6(2),e.Q6J("arrowPosition",o.value)("disabled",r.value)("disableClear",s.value),e.xp6(2),e.Q6J("arrowPosition",o.value)("disabled",r.value)("disableClear",s.value),e.xp6(2),e.Q6J("arrowPosition",o.value)("disabled",r.value)("disableClear",s.value),e.xp6(2),e.Q6J("ngForOf",d.sortedData)}},dependencies:[p.sg,u.YE,u.nU,c.KE,c.hX,f.gD,g.ey],styles:[".mat-sort-header-container[_ngcontent-%COMP%]{align-items:center}td[_ngcontent-%COMP%]{padding-right:15px}.control-panel[_ngcontent-%COMP%]{display:flex;gap:20px}"]}),a})()}];let A=(()=>{class a{}return a.\u0275fac=function(t){return new(t||a)},a.\u0275mod=e.oAB({type:a}),a.\u0275inj=e.cJS({imports:[v.Bz.forChild(b),v.Bz]}),a})(),x=(()=>{class a{}return a.\u0275fac=function(t){return new(t||a)},a.\u0275mod=e.oAB({type:a}),a.\u0275inj=e.cJS({imports:[p.ez,A,u.JX,c.lN,f.LD]}),a})()}}]);