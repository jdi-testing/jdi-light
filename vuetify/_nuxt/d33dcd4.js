(window.webpackJsonp=window.webpackJsonp||[]).push([[28],{1059:function(e,t,n){"use strict";n.r(t);var r=n(1022),o=n(1108),l=n(445),c=n(1100),d=n(178),v=n(466),h=n(157),f=n(493),m=n(467),y=n(416),_={data:function(){return{focus:"",events:[],colors:["blue","indigo","deep-purple","cyan","green","orange","grey darken-1"],names:["Meeting","Holiday","PTO","Travel","Event","Birthday","Conference","Party"],categories:["John Smith","Tori Walker"]}},mounted:function(){this.$refs.calendar.checkChange()},methods:{getEventColor:function(e){return e.color},setToday:function(){this.focus=""},prev:function(){this.$refs.calendar.prev()},next:function(){this.$refs.calendar.next()},fetchEvents:function(e){for(var t=e.start,n=e.end,r=[],o=new Date("".concat(t.date,"T00:00:00")),l=new Date("".concat(n.date,"T23:59:59")),c=(l.getTime()-o.getTime())/864e5,d=this.rnd(c,c+20),i=0;i<d;i+=1){var v=0===this.rnd(0,3),h=this.rnd(o.getTime(),l.getTime()),f=new Date(h-h%9e5),m=9e5*this.rnd(2,v?288:8),y=new Date(f.getTime()+m);r.push({name:this.names[this.rnd(0,this.names.length-1)],start:f,end:y,color:this.colors[this.rnd(0,this.colors.length-1)],timed:!v,category:this.categories[this.rnd(0,this.categories.length-1)]})}this.events=r},rnd:function(a,b){return Math.floor((b-a+1)*Math.random())+a}}},T=_,x=n(82),k=Object(x.a)(T,(function(){var e=this,t=e._self._c;return t(v.a,{staticClass:"fill-height"},[t(r.a,[t(h.a,{attrs:{height:"64"}},[t(m.a,{attrs:{flat:""}},[t(l.a,{staticClass:"mr-4",attrs:{outlined:"",color:"grey darken-2"},on:{click:e.setToday}},[e._v("\n          Today\n        ")]),e._v(" "),t(l.a,{attrs:{fab:"",text:"",small:"",color:"grey darken-2"},on:{click:e.prev}},[t(d.a,{attrs:{small:""}},[e._v("\n            mdi-chevron-left\n          ")])],1),e._v(" "),t(l.a,{attrs:{fab:"",text:"",small:"",color:"grey darken-2"},on:{click:e.next}},[t(d.a,{attrs:{small:""}},[e._v("\n            mdi-chevron-right\n          ")])],1),e._v(" "),e.$refs.calendar?t(y.b,[e._v("\n          "+e._s(e.$refs.calendar.title)+"\n        ")]):e._e(),e._v(" "),t(f.a)],1)],1),e._v(" "),t(h.a,{attrs:{height:"600"}},[t(c.a,{ref:"calendar",attrs:{id:"calendar-type-category",color:"primary",type:"category","category-show-all":"",categories:e.categories,events:e.events,"event-color":e.getEventColor},on:{change:e.fetchEvents},model:{value:e.focus,callback:function(t){e.focus=t},expression:"focus"}})],1)],1)],1)}),[],!1,null,null,null).exports,C={data:function(){return{}}},w=Object(x.a)(C,(function(){var e=this,t=e._self._c;return t(v.a,[t(r.a,[t(h.a,{attrs:{height:"400"}},[t(c.a,{attrs:{id:"calendar-type-day",color:"primary",type:"day"},scopedSlots:e._u([{key:"day-header",fn:function(t){return[t.present?[e._v("\n            Today\n          ")]:e._e()]}},{key:"interval",fn:function(n){var r=n.hour;return[t("div",{staticClass:"text-center"},[e._v("\n            "+e._s(r)+" o'clock\n          ")])]}}])})],1)],1)],1)}),[],!1,null,null,null).exports,E={data:function(){return{today:"2019-01-08",events:[{name:"Weekly Meeting",start:"2019-01-07 09:00",end:"2019-01-07 10:00"},{name:"Thomas' Birthday",start:"2019-01-10"},{name:"Mash Potatoes",start:"2019-01-09 12:30",end:"2019-01-09 15:30"}]}},mounted:function(){this.$refs.calendar.scrollToTime("08:00")}},D=(n(882),Object(x.a)(E,(function(){var e=this,t=e._self._c;return t(v.a,[t(r.a,[t(h.a,{attrs:{height:"400"}},[t(c.a,{ref:"calendar",attrs:{id:"calendar-type-week",now:e.today,value:e.today,events:e.events,color:"primary",type:"week"}})],1)],1)],1)}),[],!1,null,"53316f16",null).exports),O=n(432),M=n(412),S=n(182),P=n(121),j=n(52),B=n(477),F=(n(34),{data:function(){return{focus:"",type:"month",typeToLabel:{month:"Month",week:"Week",day:"Day","4day":"4 Days"},selectedEvent:{},selectedElement:null,selectedOpen:!1,events:[],colors:["blue","indigo","deep-purple","cyan","green","orange","grey darken-1"],names:["Meeting","Holiday","PTO","Travel","Event","Birthday","Conference","Party"]}},mounted:function(){this.$refs.calendar.checkChange()},methods:{viewDay:function(e){var t=e.date;this.focus=t,this.type="day"},getEventColor:function(e){return e.color},setToday:function(){this.focus=""},prev:function(){this.$refs.calendar.prev()},next:function(){this.$refs.calendar.next()},showEvent:function(e){var t=this,n=e.nativeEvent,r=e.event,o=function(){t.selectedEvent=r,t.selectedElement=n.target,requestAnimationFrame((function(){return requestAnimationFrame((function(){t.selectedOpen=!0}))}))};this.selectedOpen?(this.selectedOpen=!1,requestAnimationFrame((function(){return requestAnimationFrame((function(){return o()}))}))):o(),n.stopPropagation()},updateRange:function(e){for(var t=e.start,n=e.end,r=[],o=new Date("".concat(t.date,"T00:00:00")),l=new Date("".concat(n.date,"T23:59:59")),c=(l.getTime()-o.getTime())/864e5,d=this.rnd(c,c+20),i=0;i<d;i+=1){var v=0===this.rnd(0,3),h=this.rnd(o.getTime(),l.getTime()),f=new Date(h-h%9e5),m=9e5*this.rnd(2,v?288:8),y=new Date(f.getTime()+m);r.push({name:this.names[this.rnd(0,this.names.length-1)],start:f,end:y,color:this.colors[this.rnd(0,this.colors.length-1)],timed:!v})}this.events=r},rnd:function(a,b){return Math.floor((b-a+1)*Math.random())+a}}}),A=F,$=Object(x.a)(A,(function(){var e=this,t=e._self._c;return t(v.a,{staticClass:"fill-height"},[t(r.a,[t(h.a,{attrs:{height:"64"}},[t(m.a,{attrs:{flat:""}},[t(l.a,{staticClass:"mr-4",attrs:{outlined:"",color:"grey darken-2"},on:{click:e.setToday}},[e._v("\n          Today\n        ")]),e._v(" "),t(l.a,{attrs:{fab:"",text:"",small:"",color:"grey darken-2"},on:{click:e.prev}},[t(d.a,{attrs:{small:""}},[e._v("\n            mdi-chevron-left\n          ")])],1),e._v(" "),t(l.a,{attrs:{fab:"",text:"",small:"",color:"grey darken-2"},on:{click:e.next}},[t(d.a,{attrs:{small:""}},[e._v("\n            mdi-chevron-right\n          ")])],1),e._v(" "),e.$refs.calendar?t(y.b,[e._v("\n          "+e._s(e.$refs.calendar.title)+"\n        ")]):e._e(),e._v(" "),t(f.a),e._v(" "),t(B.a,{attrs:{bottom:"",right:""},scopedSlots:e._u([{key:"activator",fn:function(n){var r=n.on,o=n.attrs;return[t(l.a,e._g(e._b({attrs:{outlined:"",color:"grey darken-2"}},"v-btn",o,!1),r),[t("span",[e._v(e._s(e.typeToLabel[e.type]))]),e._v(" "),t(d.a,{attrs:{right:""}},[e._v("\n                mdi-menu-down\n              ")])],1)]}}])},[e._v(" "),t(S.a,[t(P.a,{on:{click:function(t){e.type="day"}}},[t(j.d,[e._v("Day")])],1),e._v(" "),t(P.a,{on:{click:function(t){e.type="week"}}},[t(j.d,[e._v("Week")])],1),e._v(" "),t(P.a,{on:{click:function(t){e.type="month"}}},[t(j.d,[e._v("Month")])],1),e._v(" "),t(P.a,{on:{click:function(t){e.type="4day"}}},[t(j.d,[e._v("4 days")])],1)],1)],1)],1)],1),e._v(" "),t(h.a,{attrs:{height:"600"}},[t(c.a,{ref:"calendar",attrs:{id:"calendar-events-click",color:"primary",events:e.events,"event-color":e.getEventColor,type:e.type},on:{"click:event":e.showEvent,"click:more":e.viewDay,"click:date":e.viewDay,change:e.updateRange},model:{value:e.focus,callback:function(t){e.focus=t},expression:"focus"}}),e._v(" "),t(B.a,{attrs:{"close-on-content-click":!1,activator:e.selectedElement,"offset-x":""},model:{value:e.selectedOpen,callback:function(t){e.selectedOpen=t},expression:"selectedOpen"}},[t(O.a,{attrs:{color:"grey lighten-4","min-width":"350px",flat:""}},[t(m.a,{attrs:{color:e.selectedEvent.color,dark:""}},[t(l.a,{attrs:{icon:""}},[t(d.a,[e._v("mdi-pencil")])],1),e._v(" "),t(y.b,{domProps:{innerHTML:e._s(e.selectedEvent.name)}}),e._v(" "),t(f.a),e._v(" "),t(l.a,{attrs:{icon:""}},[t(d.a,[e._v("mdi-heart")])],1),e._v(" "),t(l.a,{attrs:{icon:""}},[t(d.a,[e._v("mdi-dots-vertical")])],1)],1),e._v(" "),t(M.c,[t("span",{domProps:{innerHTML:e._s(e.selectedEvent.details)}})]),e._v(" "),t(M.a,[t(l.a,{attrs:{text:"",color:"secondary"},on:{click:function(t){e.selectedOpen=!1}}},[e._v("\n              Cancel\n            ")])],1)],1)],1)],1)],1)],1)}),[],!1,null,null,null).exports,H={data:function(){return{today:"2019-01-10",tracked:{"2019-01-09":[23,45,10],"2019-01-08":[10],"2019-01-07":[0,78,5],"2019-01-06":[0,0,50],"2019-01-05":[0,10,23],"2019-01-04":[2,90],"2019-01-03":[10,32],"2019-01-02":[80,10,10],"2019-01-01":[20,25,10]},colors:["#1867c0","#fb8c00","#000000"],category:["Development","Meetings","Slacking"]}}},W=Object(x.a)(H,(function(){var e=this,t=e._self._c;return t(v.a,[t(r.a,[t(h.a,{attrs:{height:"500"}},[t(c.a,{attrs:{id:"calendar-slots-day",now:e.today,value:e.today,color:"primary"},scopedSlots:e._u([{key:"day",fn:function(n){var r=n.past,o=n.date;return[t(v.a,{staticClass:"fill-height"},[r&&e.tracked[o]?e._l(e.tracked[o],(function(n,i){return t(h.a,{key:i,attrs:{title:e.category[i],color:e.colors[i],width:"".concat(n,"%"),height:"100%",tile:""}})})):e._e()],2)]}}])})],1)],1)],1)}),[],!1,null,null,null).exports,L=(n(54),{data:function(){return{value:"",ready:!1}},computed:{cal:function(){return this.ready?this.$refs.calendar:null},nowY:function(){return this.cal?"".concat(this.cal.timeToY(this.cal.times.now),"px"):"-10px"}},mounted:function(){this.ready=!0,this.scrollToTime(),this.updateTime()},methods:{getCurrentTime:function(){return this.cal?60*this.cal.times.now.hour+this.cal.times.now.minute:0},scrollToTime:function(){var time=this.getCurrentTime(),e=Math.max(0,time-time%30-30);this.cal.scrollToTime(e)},updateTime:function(){var e=this;setInterval((function(){return e.cal.updateTimes()}),6e4)}}}),z=(n(884),Object(x.a)(L,(function(){var e=this,t=e._self._c;return t(v.a,[t(r.a,[t(h.a,{attrs:{height:"500"}},[t(c.a,{ref:"calendar",attrs:{id:"calendar-slots-day-body",type:"week"},scopedSlots:e._u([{key:"day-body",fn:function(n){var r=n.date,o=n.week;return[t("div",{staticClass:"v-current-time",class:{first:r===o[0].date},style:{top:e.nowY}})]}}]),model:{value:e.value,callback:function(t){e.value=t},expression:"value"}})],1)],1)],1)}),[],!1,null,null,null).exports),J=(n(16),n(11),n(15),n(5),n(19),n(10),n(20),n(3)),Y=n(18);n(59),n(159),n(40);function I(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}function R(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?I(Object(source),!0).forEach((function(t){Object(J.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):I(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}var G=(new Date).getDate(),K=function(e,t){var n=Object(Y.a)(t,2),r=n[0],o=n[1],l=new Date;return l.setDate(G+e),l.setHours(r,o,0),l.getTime()},N=[{name:"Conference",color:"#FF9800",start:[4,45],end:[5,30]},{name:"PTO",color:"#00BCD4",start:[10,0],end:[11,15]},{name:"Meeting",color:"#3F51B5",start:[14,0],end:[15,30]},{name:"Meeting",color:"#673AB7",start:[21,15],end:[22,30]},{name:"Holiday",color:"#00BCD4",start:[2,30],end:[3,0]},{name:"Event",color:"#757575",start:[7,45],end:[8,45]},{name:"Birthday",color:"#757575",start:[15,0],end:[16,30]},{name:"Party",color:"#4CAF50",start:[15,15],end:[18,30]},{name:"Travel",color:"#4CAF50",start:[1,15],end:[2,0]},{name:"Event",color:"#673AB7",start:[3,30],end:[5,0]},{name:"Event",color:"#2196F3",start:[16,0],end:[17,0]},{name:"Meeting",color:"#FF9800",start:[18,0],end:[19,0]},{name:"Travel",color:"#673AB7",start:[1,15],end:[2,0]},{name:"PTO",color:"#3F51B5",start:[2,45],end:[4,0]},{name:"Party",color:"#4CAF50",start:[10,0],end:[10,45]},{name:"Holiday",color:"#00BCD4",start:[21,15],end:[22,30]}].map((function(e,i){return R(R({},e),{},{timed:!0,start:K(Math.floor(i/4),e.start),end:K(Math.floor(i/4),e.end)})})),Q={data:function(){return{value:"",events:N,colors:["#2196F3","#3F51B5","#673AB7","#00BCD4","#4CAF50","#FF9800","#757575"],names:["Meeting","Holiday","PTO","Travel","Event","Birthday","Conference","Party"],dragEvent:null,dragStart:null,createEvent:null,createStart:null,extendOriginal:null}},methods:{startDrag:function(e){var t=e.event,n=e.timed;t&&n&&(this.dragEvent=t,this.dragTime=null,this.extendOriginal=null)},startTime:function(e){var t=this.toTime(e);if(this.dragEvent&&null===this.dragTime){var n=this.dragEvent.start;this.dragTime=t-n}else this.createStart=this.roundTime(t),this.createEvent={name:"Event #".concat(this.events.length),color:this.rndElement(this.colors),start:this.createStart,end:this.createStart,timed:!0},this.events.push(this.createEvent)},extendBottom:function(e){this.createEvent=e,this.createStart=e.start,this.extendOriginal=e.end},mouseMove:function(e){var t=this.toTime(e);if(this.dragEvent&&null!==this.dragTime){var n=this.dragEvent.start,r=this.dragEvent.end-n,o=t-this.dragTime,l=this.roundTime(o),c=l+r;this.dragEvent.start=l,this.dragEvent.end=c}else if(this.createEvent&&null!==this.createStart){var d=this.roundTime(t,!1),v=Math.min(d,this.createStart),h=Math.max(d,this.createStart);this.createEvent.start=v,this.createEvent.end=h}},endDrag:function(){this.dragTime=null,this.dragEvent=null,this.createEvent=null,this.createStart=null,this.extendOriginal=null},cancelDrag:function(){if(this.createEvent)if(this.extendOriginal)this.createEvent.end=this.extendOriginal;else{var i=this.events.indexOf(this.createEvent);-1!==i&&this.events.splice(i,1)}this.createEvent=null,this.createStart=null,this.dragTime=null,this.dragEvent=null},roundTime:function(time){var e=!(arguments.length>1&&void 0!==arguments[1])||arguments[1],t=15,n=60*t*1e3;return e?time-time%n:time+(n-time%n)},toTime:function(e){return new Date(e.year,e.month-1,e.day,e.hour,e.minute).getTime()},getEventColor:function(e){var t=parseInt(e.color.substring(1),16),n=t>>16&255,g=t>>8&255,b=t>>0&255;return e===this.dragEvent||e===this.createEvent?"rgba(".concat(n,", ").concat(g,", ").concat(b,", 0.7)"):e.color},getEvents:function(e){for(var t=e.start,n=e.end,r=[],o=new Date("".concat(t.date,"T00:00:00")).getTime(),l=new Date("".concat(n.date,"T23:59:59")).getTime(),c=(l-o)/864e5,d=this.rnd(c,c+20),i=0;i<d;i++){var v=0!==this.rnd(0,3),h=this.rnd(o,l),f=h-h%9e5,m=f+9e5*this.rnd(2,v?8:288);r.push({name:this.rndElement(this.names),color:this.rndElement(this.colors),start:f,end:m,timed:v})}this.events=r},rnd:function(a,b){return Math.floor((b-a+1)*Math.random())+a},rndElement:function(e){return e[this.rnd(0,e.length-1)]}}},U=Q,V=(n(886),Object(x.a)(U,(function(){var e=this,t=e._self._c;return t(v.a,{staticClass:"fill-height"},[t(r.a,[t(h.a,{attrs:{height:"600"}},[t(c.a,{ref:"calendar",attrs:{color:"primary",type:"4day",events:e.events,"event-color":e.getEventColor,"event-ripple":!1},on:{"mousedown:event":e.startDrag,"mousedown:time":e.startTime,"mousemove:time":e.mouseMove,"mouseup:time":e.endDrag},nativeOn:{mouseleave:function(t){return e.cancelDrag.apply(null,arguments)}},scopedSlots:e._u([{key:"event",fn:function(n){var r=n.event,o=n.timed,l=n.eventSummary;return[t("div",{staticClass:"v-event-draggable",domProps:{innerHTML:e._s(l())}}),e._v(" "),o?t("div",{staticClass:"v-event-drag-bottom",on:{mousedown:function(t){return t.stopPropagation(),e.extendBottom(r)}}}):e._e()]}}]),model:{value:e.value,callback:function(t){e.value=t},expression:"value"}})],1)],1)],1)}),[],!1,null,"6f5e95cc",null)),X={name:"Calendars",components:{TypeCategoryCalendar:k,TypeDayCalendar:w,TypeWeekCalendar:D,EventsClickCalendar:$,SlotsDayCalendar:W,SlotsDayBodyCalendar:z,MiscDragAndDropCalendar:V.exports}},Z=Object(x.a)(X,(function(){var e=this,t=e._self._c;return t(o.a,[t(r.a,[t("h1",[e._v("Calendars")]),e._v(" "),t("p",{staticClass:"body-1 mt-2"},[e._v("\n            The "),t("code",[e._v("v-calendar")]),e._v(" component is used to display information in a daily, weekly, monthly, \n            or category view. The daily view has slots for all day or timed elements, and the weekly and monthly \n            view has a slot for each day. The category view has a slot for each category in the day and timed \n            sections based on the categories given or the categories in the given events. \n            Optionally you can pass in an array of events and they will be rendered over the appropriate days and times.\n        ")])]),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Type category calendar\n        ")]),e._v(" "),t("TypeCategoryCalendar",{attrs:{id:"TypeCategoryCalendar"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Type day calendar\n        ")]),e._v(" "),t("TypeDayCalendar",{attrs:{id:"TypeDayCalendar"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Type week calendar\n        ")]),e._v(" "),t("TypeWeekCalendar",{attrs:{id:"TypeWeekCalendar"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Events click calendar\n        ")]),e._v(" "),t("EventsClickCalendar",{attrs:{id:"EventsClickCalendar"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Slots day calendar\n        ")]),e._v(" "),t("SlotsDayCalendar",{attrs:{id:"SlotsDayCalendar"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Slots day body calendar\n        ")]),e._v(" "),t("SlotsDayBodyCalendar",{attrs:{id:"SlotsDayBodyCalendar"}})],1),e._v(" "),t(r.a,[t("p",{staticClass:"text-h5"},[e._v("\n            Misc drag and drop calendar\n        ")]),e._v(" "),t("MiscDragAndDropCalendar",{attrs:{id:"MiscDragAndDropCalendar"}})],1)],1)}),[],!1,null,null,null);t.default=Z.exports},664:function(e,t,n){var content=n(883);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(27).default)("3c4128bc",content,!0,{sourceMap:!1})},665:function(e,t,n){var content=n(885);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(27).default)("0cf38ac8",content,!0,{sourceMap:!1})},666:function(e,t,n){var content=n(887);content.__esModule&&(content=content.default),"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(27).default)("6645fa35",content,!0,{sourceMap:!1})},882:function(e,t,n){"use strict";n(664)},883:function(e,t,n){var r=n(26)(!1);r.push([e.i,".my-event[data-v-53316f16]{overflow:hidden;text-overflow:ellipsis;white-space:nowrap;border-radius:2px;background-color:#1867c0;color:#fff;border:1px solid #1867c0;font-size:12px;padding:3px;cursor:pointer;margin-bottom:1px;left:4px;margin-right:8px;position:relative}.my-event.with-time[data-v-53316f16]{position:absolute;right:4px;margin-right:0}",""]),e.exports=r},884:function(e,t,n){"use strict";n(665)},885:function(e,t,n){var r=n(26)(!1);r.push([e.i,'.v-current-time{height:2px;background-color:#ea4335;position:absolute;left:-1px;right:0;pointer-events:none}.v-current-time.first:before{content:"";position:absolute;background-color:#ea4335;width:12px;height:12px;border-radius:50%;margin-top:-5px;margin-left:-6.5px}',""]),e.exports=r},886:function(e,t,n){"use strict";n(666)},887:function(e,t,n){var r=n(26)(!1);r.push([e.i,'.v-event-draggable[data-v-6f5e95cc]{padding-left:6px}.v-event-timed[data-v-6f5e95cc]{-moz-user-select:none;user-select:none;-webkit-user-select:none}.v-event-drag-bottom[data-v-6f5e95cc]{position:absolute;left:0;right:0;bottom:4px;height:4px;cursor:ns-resize}.v-event-drag-bottom[data-v-6f5e95cc]:after{display:none;position:absolute;left:50%;height:4px;border-top:1px solid #fff;border-bottom:1px solid #fff;width:16px;margin-left:-8px;opacity:.8;content:""}.v-event-drag-bottom[data-v-6f5e95cc]:hover:after{display:block}',""]),e.exports=r}}]);