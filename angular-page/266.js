"use strict";(self.webpackChunkmy_app=self.webpackChunkmy_app||[]).push([[266],{266:(j,A,l)=>{l.d(A,{AV:()=>$,Jm:()=>I,gM:()=>W});var c=l(7625),x=l(2986),m=l(1281),E=l(9521),o=l(4650),u=l(6895),D=l(3353),g=l(2687),L=l(445),v=l(8184),O=l(7376),S=l(4080),P=l(5529),w=(l(7340),l(3238));const Y=["tooltip"],C=new o.OlP("mat-tooltip-scroll-strategy"),N={provide:C,deps:[v.aV],useFactory:function k(n){return()=>n.scrollStrategies.reposition({scrollThrottle:20})}},I=new o.OlP("mat-tooltip-default-options",{providedIn:"root",factory:function U(){return{showDelay:0,hideDelay:0,touchendHideDelay:1500}}}),M="tooltip-panel",R=(0,D.i$)({passive:!0});let F=(()=>{class n{get position(){return this._position}set position(t){t!==this._position&&(this._position=t,this._overlayRef&&(this._updatePosition(this._overlayRef),this._tooltipInstance?.show(0),this._overlayRef.updatePosition()))}get positionAtOrigin(){return this._positionAtOrigin}set positionAtOrigin(t){this._positionAtOrigin=(0,m.Ig)(t),this._detach(),this._overlayRef=null}get disabled(){return this._disabled}set disabled(t){this._disabled=(0,m.Ig)(t),this._disabled?this.hide(0):this._setupPointerEnterEventsIfNeeded()}get showDelay(){return this._showDelay}set showDelay(t){this._showDelay=(0,m.su)(t)}get hideDelay(){return this._hideDelay}set hideDelay(t){this._hideDelay=(0,m.su)(t),this._tooltipInstance&&(this._tooltipInstance._mouseLeaveHideDelay=this._hideDelay)}get message(){return this._message}set message(t){this._ariaDescriber.removeDescription(this._elementRef.nativeElement,this._message,"tooltip"),this._message=null!=t?String(t).trim():"",!this._message&&this._isTooltipVisible()?this.hide(0):(this._setupPointerEnterEventsIfNeeded(),this._updateTooltipMessage(),this._ngZone.runOutsideAngular(()=>{Promise.resolve().then(()=>{this._ariaDescriber.describe(this._elementRef.nativeElement,this.message,"tooltip")})}))}get tooltipClass(){return this._tooltipClass}set tooltipClass(t){this._tooltipClass=t,this._tooltipInstance&&this._setTooltipClass(this._tooltipClass)}constructor(t,i,e,s,a,d,p,y,T,f,h,b){this._overlay=t,this._elementRef=i,this._scrollDispatcher=e,this._viewContainerRef=s,this._ngZone=a,this._platform=d,this._ariaDescriber=p,this._focusMonitor=y,this._dir=f,this._defaultOptions=h,this._position="below",this._positionAtOrigin=!1,this._disabled=!1,this._viewInitialized=!1,this._pointerExitEventsInitialized=!1,this._viewportMargin=8,this._cssClassPrefix="mat",this._showDelay=this._defaultOptions.showDelay,this._hideDelay=this._defaultOptions.hideDelay,this.touchGestures="auto",this._message="",this._passiveListeners=[],this._destroyed=new P.xQ,this._scrollStrategy=T,this._document=b,h&&(h.position&&(this.position=h.position),h.positionAtOrigin&&(this.positionAtOrigin=h.positionAtOrigin),h.touchGestures&&(this.touchGestures=h.touchGestures)),f.change.pipe((0,c.R)(this._destroyed)).subscribe(()=>{this._overlayRef&&this._updatePosition(this._overlayRef)})}ngAfterViewInit(){this._viewInitialized=!0,this._setupPointerEnterEventsIfNeeded(),this._focusMonitor.monitor(this._elementRef).pipe((0,c.R)(this._destroyed)).subscribe(t=>{t?"keyboard"===t&&this._ngZone.run(()=>this.show()):this._ngZone.run(()=>this.hide(0))})}ngOnDestroy(){const t=this._elementRef.nativeElement;clearTimeout(this._touchstartTimeout),this._overlayRef&&(this._overlayRef.dispose(),this._tooltipInstance=null),this._passiveListeners.forEach(([i,e])=>{t.removeEventListener(i,e,R)}),this._passiveListeners.length=0,this._destroyed.next(),this._destroyed.complete(),this._ariaDescriber.removeDescription(t,this.message,"tooltip"),this._focusMonitor.stopMonitoring(t)}show(t=this.showDelay,i){if(this.disabled||!this.message||this._isTooltipVisible())return void this._tooltipInstance?._cancelPendingAnimations();const e=this._createOverlay(i);this._detach(),this._portal=this._portal||new S.C5(this._tooltipComponent,this._viewContainerRef);const s=this._tooltipInstance=e.attach(this._portal).instance;s._triggerElement=this._elementRef.nativeElement,s._mouseLeaveHideDelay=this._hideDelay,s.afterHidden().pipe((0,c.R)(this._destroyed)).subscribe(()=>this._detach()),this._setTooltipClass(this._tooltipClass),this._updateTooltipMessage(),s.show(t)}hide(t=this.hideDelay){const i=this._tooltipInstance;i&&(i.isVisible()?i.hide(t):(i._cancelPendingAnimations(),this._detach()))}toggle(t){this._isTooltipVisible()?this.hide():this.show(void 0,t)}_isTooltipVisible(){return!!this._tooltipInstance&&this._tooltipInstance.isVisible()}_createOverlay(t){if(this._overlayRef){const s=this._overlayRef.getConfig().positionStrategy;if((!this.positionAtOrigin||!t)&&s._origin instanceof o.SBq)return this._overlayRef;this._detach()}const i=this._scrollDispatcher.getAncestorScrollContainers(this._elementRef),e=this._overlay.position().flexibleConnectedTo(this.positionAtOrigin&&t||this._elementRef).withTransformOriginOn(`.${this._cssClassPrefix}-tooltip`).withFlexibleDimensions(!1).withViewportMargin(this._viewportMargin).withScrollableContainers(i);return e.positionChanges.pipe((0,c.R)(this._destroyed)).subscribe(s=>{this._updateCurrentPositionClass(s.connectionPair),this._tooltipInstance&&s.scrollableViewProperties.isOverlayClipped&&this._tooltipInstance.isVisible()&&this._ngZone.run(()=>this.hide(0))}),this._overlayRef=this._overlay.create({direction:this._dir,positionStrategy:e,panelClass:`${this._cssClassPrefix}-${M}`,scrollStrategy:this._scrollStrategy()}),this._updatePosition(this._overlayRef),this._overlayRef.detachments().pipe((0,c.R)(this._destroyed)).subscribe(()=>this._detach()),this._overlayRef.outsidePointerEvents().pipe((0,c.R)(this._destroyed)).subscribe(()=>this._tooltipInstance?._handleBodyInteraction()),this._overlayRef.keydownEvents().pipe((0,c.R)(this._destroyed)).subscribe(s=>{this._isTooltipVisible()&&s.keyCode===E.hY&&!(0,E.Vb)(s)&&(s.preventDefault(),s.stopPropagation(),this._ngZone.run(()=>this.hide(0)))}),this._defaultOptions?.disableTooltipInteractivity&&this._overlayRef.addPanelClass(`${this._cssClassPrefix}-tooltip-panel-non-interactive`),this._overlayRef}_detach(){this._overlayRef&&this._overlayRef.hasAttached()&&this._overlayRef.detach(),this._tooltipInstance=null}_updatePosition(t){const i=t.getConfig().positionStrategy,e=this._getOrigin(),s=this._getOverlayPosition();i.withPositions([this._addOffset({...e.main,...s.main}),this._addOffset({...e.fallback,...s.fallback})])}_addOffset(t){return t}_getOrigin(){const t=!this._dir||"ltr"==this._dir.value,i=this.position;let e;"above"==i||"below"==i?e={originX:"center",originY:"above"==i?"top":"bottom"}:"before"==i||"left"==i&&t||"right"==i&&!t?e={originX:"start",originY:"center"}:("after"==i||"right"==i&&t||"left"==i&&!t)&&(e={originX:"end",originY:"center"});const{x:s,y:a}=this._invertPosition(e.originX,e.originY);return{main:e,fallback:{originX:s,originY:a}}}_getOverlayPosition(){const t=!this._dir||"ltr"==this._dir.value,i=this.position;let e;"above"==i?e={overlayX:"center",overlayY:"bottom"}:"below"==i?e={overlayX:"center",overlayY:"top"}:"before"==i||"left"==i&&t||"right"==i&&!t?e={overlayX:"end",overlayY:"center"}:("after"==i||"right"==i&&t||"left"==i&&!t)&&(e={overlayX:"start",overlayY:"center"});const{x:s,y:a}=this._invertPosition(e.overlayX,e.overlayY);return{main:e,fallback:{overlayX:s,overlayY:a}}}_updateTooltipMessage(){this._tooltipInstance&&(this._tooltipInstance.message=this.message,this._tooltipInstance._markForCheck(),this._ngZone.onMicrotaskEmpty.pipe((0,x.q)(1),(0,c.R)(this._destroyed)).subscribe(()=>{this._tooltipInstance&&this._overlayRef.updatePosition()}))}_setTooltipClass(t){this._tooltipInstance&&(this._tooltipInstance.tooltipClass=t,this._tooltipInstance._markForCheck())}_invertPosition(t,i){return"above"===this.position||"below"===this.position?"top"===i?i="bottom":"bottom"===i&&(i="top"):"end"===t?t="start":"start"===t&&(t="end"),{x:t,y:i}}_updateCurrentPositionClass(t){const{overlayY:i,originX:e,originY:s}=t;let a;if(a="center"===i?this._dir&&"rtl"===this._dir.value?"end"===e?"left":"right":"start"===e?"left":"right":"bottom"===i&&"top"===s?"above":"below",a!==this._currentPosition){const d=this._overlayRef;if(d){const p=`${this._cssClassPrefix}-${M}-`;d.removePanelClass(p+this._currentPosition),d.addPanelClass(p+a)}this._currentPosition=a}}_setupPointerEnterEventsIfNeeded(){this._disabled||!this.message||!this._viewInitialized||this._passiveListeners.length||(this._platformSupportsMouseEvents()?this._passiveListeners.push(["mouseenter",t=>{let i;this._setupPointerExitEventsIfNeeded(),void 0!==t.x&&void 0!==t.y&&(i=t),this.show(void 0,i)}]):"off"!==this.touchGestures&&(this._disableNativeGesturesIfNecessary(),this._passiveListeners.push(["touchstart",t=>{const i=t.targetTouches?.[0],e=i?{x:i.clientX,y:i.clientY}:void 0;this._setupPointerExitEventsIfNeeded(),clearTimeout(this._touchstartTimeout),this._touchstartTimeout=setTimeout(()=>this.show(void 0,e),500)}])),this._addListeners(this._passiveListeners))}_setupPointerExitEventsIfNeeded(){if(this._pointerExitEventsInitialized)return;this._pointerExitEventsInitialized=!0;const t=[];if(this._platformSupportsMouseEvents())t.push(["mouseleave",i=>{const e=i.relatedTarget;(!e||!this._overlayRef?.overlayElement.contains(e))&&this.hide()}],["wheel",i=>this._wheelListener(i)]);else if("off"!==this.touchGestures){this._disableNativeGesturesIfNecessary();const i=()=>{clearTimeout(this._touchstartTimeout),this.hide(this._defaultOptions.touchendHideDelay)};t.push(["touchend",i],["touchcancel",i])}this._addListeners(t),this._passiveListeners.push(...t)}_addListeners(t){t.forEach(([i,e])=>{this._elementRef.nativeElement.addEventListener(i,e,R)})}_platformSupportsMouseEvents(){return!this._platform.IOS&&!this._platform.ANDROID}_wheelListener(t){if(this._isTooltipVisible()){const i=this._document.elementFromPoint(t.clientX,t.clientY),e=this._elementRef.nativeElement;i!==e&&!e.contains(i)&&this.hide()}}_disableNativeGesturesIfNecessary(){const t=this.touchGestures;if("off"!==t){const i=this._elementRef.nativeElement,e=i.style;("on"===t||"INPUT"!==i.nodeName&&"TEXTAREA"!==i.nodeName)&&(e.userSelect=e.msUserSelect=e.webkitUserSelect=e.MozUserSelect="none"),("on"===t||!i.draggable)&&(e.webkitUserDrag="none"),e.touchAction="none",e.webkitTapHighlightColor="transparent"}}}return n.\u0275fac=function(t){o.$Z()},n.\u0275dir=o.lG2({type:n,inputs:{position:["matTooltipPosition","position"],positionAtOrigin:["matTooltipPositionAtOrigin","positionAtOrigin"],disabled:["matTooltipDisabled","disabled"],showDelay:["matTooltipShowDelay","showDelay"],hideDelay:["matTooltipHideDelay","hideDelay"],touchGestures:["matTooltipTouchGestures","touchGestures"],message:["matTooltip","message"],tooltipClass:["matTooltipClass","tooltipClass"]}}),n})(),W=(()=>{class n extends F{constructor(t,i,e,s,a,d,p,y,T,f,h,b){super(t,i,e,s,a,d,p,y,T,f,h,b),this._tooltipComponent=Z,this._cssClassPrefix="mat-mdc",this._viewportMargin=8}_addOffset(t){const e=!this._dir||"ltr"==this._dir.value;return"top"===t.originY?t.offsetY=-8:"bottom"===t.originY?t.offsetY=8:"start"===t.originX?t.offsetX=e?-8:8:"end"===t.originX&&(t.offsetX=e?8:-8),t}}return n.\u0275fac=function(t){return new(t||n)(o.Y36(v.aV),o.Y36(o.SBq),o.Y36(O.mF),o.Y36(o.s_b),o.Y36(o.R0b),o.Y36(D.t4),o.Y36(g.$s),o.Y36(g.tE),o.Y36(C),o.Y36(L.Is,8),o.Y36(I,8),o.Y36(u.K0))},n.\u0275dir=o.lG2({type:n,selectors:[["","matTooltip",""]],hostAttrs:[1,"mat-mdc-tooltip-trigger"],exportAs:["matTooltip"],features:[o.qOj]}),n})(),K=(()=>{class n{constructor(t,i){this._changeDetectorRef=t,this._closeOnInteraction=!1,this._isVisible=!1,this._onHide=new P.xQ,this._animationsDisabled="NoopAnimations"===i}show(t){clearTimeout(this._hideTimeoutId),this._showTimeoutId=setTimeout(()=>{this._toggleVisibility(!0),this._showTimeoutId=void 0},t)}hide(t){clearTimeout(this._showTimeoutId),this._hideTimeoutId=setTimeout(()=>{this._toggleVisibility(!1),this._hideTimeoutId=void 0},t)}afterHidden(){return this._onHide}isVisible(){return this._isVisible}ngOnDestroy(){this._cancelPendingAnimations(),this._onHide.complete(),this._triggerElement=null}_handleBodyInteraction(){this._closeOnInteraction&&this.hide(0)}_markForCheck(){this._changeDetectorRef.markForCheck()}_handleMouseLeave({relatedTarget:t}){(!t||!this._triggerElement.contains(t))&&(this.isVisible()?this.hide(this._mouseLeaveHideDelay):this._finalizeAnimation(!1))}_onShow(){}_handleAnimationEnd({animationName:t}){(t===this._showAnimation||t===this._hideAnimation)&&this._finalizeAnimation(t===this._showAnimation)}_cancelPendingAnimations(){clearTimeout(this._showTimeoutId),clearTimeout(this._hideTimeoutId),this._showTimeoutId=this._hideTimeoutId=void 0}_finalizeAnimation(t){t?this._closeOnInteraction=!0:this.isVisible()||this._onHide.next()}_toggleVisibility(t){const i=this._tooltip.nativeElement,e=this._showAnimation,s=this._hideAnimation;if(i.classList.remove(t?s:e),i.classList.add(t?e:s),this._isVisible=t,t&&!this._animationsDisabled&&"function"==typeof getComputedStyle){const a=getComputedStyle(i);("0s"===a.getPropertyValue("animation-duration")||"none"===a.getPropertyValue("animation-name"))&&(this._animationsDisabled=!0)}t&&this._onShow(),this._animationsDisabled&&(i.classList.add("_mat-animation-noopable"),this._finalizeAnimation(t))}}return n.\u0275fac=function(t){return new(t||n)(o.Y36(o.sBO),o.Y36(o.QbO,8))},n.\u0275dir=o.lG2({type:n}),n})(),Z=(()=>{class n extends K{constructor(t,i,e){super(t,e),this._elementRef=i,this._isMultiline=!1,this._showAnimation="mat-mdc-tooltip-show",this._hideAnimation="mat-mdc-tooltip-hide"}_onShow(){this._isMultiline=this._isTooltipMultiline(),this._markForCheck()}_isTooltipMultiline(){const t=this._elementRef.nativeElement.getBoundingClientRect();return t.height>24&&t.width>=200}}return n.\u0275fac=function(t){return new(t||n)(o.Y36(o.sBO),o.Y36(o.SBq),o.Y36(o.QbO,8))},n.\u0275cmp=o.Xpm({type:n,selectors:[["mat-tooltip-component"]],viewQuery:function(t,i){if(1&t&&o.Gf(Y,7),2&t){let e;o.iGM(e=o.CRH())&&(i._tooltip=e.first)}},hostAttrs:["aria-hidden","true"],hostVars:2,hostBindings:function(t,i){1&t&&o.NdJ("mouseleave",function(s){return i._handleMouseLeave(s)}),2&t&&o.Udp("zoom",i.isVisible()?1:null)},features:[o.qOj],decls:4,vars:4,consts:[[1,"mdc-tooltip","mdc-tooltip--shown","mat-mdc-tooltip",3,"ngClass","animationend"],["tooltip",""],[1,"mdc-tooltip__surface","mdc-tooltip__surface-animation"]],template:function(t,i){1&t&&(o.TgZ(0,"div",0,1),o.NdJ("animationend",function(s){return i._handleAnimationEnd(s)}),o.TgZ(2,"div",2),o._uU(3),o.qZA()()),2&t&&(o.ekj("mdc-tooltip--multiline",i._isMultiline),o.Q6J("ngClass",i.tooltipClass),o.xp6(3),o.Oqu(i.message))},dependencies:[u.mk],styles:['.mdc-tooltip__surface{word-break:var(--mdc-tooltip-word-break, normal);overflow-wrap:anywhere}.mdc-tooltip{position:fixed;display:none;z-index:9}.mdc-tooltip-wrapper--rich{position:relative}.mdc-tooltip--shown,.mdc-tooltip--showing,.mdc-tooltip--hide{display:inline-flex}.mdc-tooltip--shown.mdc-tooltip--rich,.mdc-tooltip--showing.mdc-tooltip--rich,.mdc-tooltip--hide.mdc-tooltip--rich{display:inline-block;left:-320px;position:absolute}.mdc-tooltip__surface{line-height:16px;padding:4px 8px;min-width:40px;max-width:200px;min-height:24px;max-height:40vh;box-sizing:border-box;overflow:hidden;text-align:center}.mdc-tooltip__surface::before{position:absolute;box-sizing:border-box;width:100%;height:100%;top:0;left:0;border:1px solid rgba(0,0,0,0);border-radius:inherit;content:"";pointer-events:none}@media screen and (forced-colors: active){.mdc-tooltip__surface::before{border-color:CanvasText}}.mdc-tooltip--rich .mdc-tooltip__surface{align-items:flex-start;display:flex;flex-direction:column;min-height:24px;min-width:40px;max-width:320px;position:relative}.mdc-tooltip--multiline .mdc-tooltip__surface{text-align:left}[dir=rtl] .mdc-tooltip--multiline .mdc-tooltip__surface,.mdc-tooltip--multiline .mdc-tooltip__surface[dir=rtl]{text-align:right}.mdc-tooltip__surface .mdc-tooltip__title{margin:0 8px}.mdc-tooltip__surface .mdc-tooltip__content{max-width:calc(200px - (2 * 8px));margin:8px;text-align:left}[dir=rtl] .mdc-tooltip__surface .mdc-tooltip__content,.mdc-tooltip__surface .mdc-tooltip__content[dir=rtl]{text-align:right}.mdc-tooltip--rich .mdc-tooltip__surface .mdc-tooltip__content{max-width:calc(320px - (2 * 8px));align-self:stretch}.mdc-tooltip__surface .mdc-tooltip__content-link{text-decoration:none}.mdc-tooltip--rich-actions,.mdc-tooltip__content,.mdc-tooltip__title{z-index:1}.mdc-tooltip__surface-animation{opacity:0;transform:scale(0.8);will-change:transform,opacity}.mdc-tooltip--shown .mdc-tooltip__surface-animation{transform:scale(1);opacity:1}.mdc-tooltip--hide .mdc-tooltip__surface-animation{transform:scale(1)}.mdc-tooltip__caret-surface-top,.mdc-tooltip__caret-surface-bottom{position:absolute;height:24px;width:24px;transform:rotate(35deg) skewY(20deg) scaleX(0.9396926208)}.mdc-tooltip__caret-surface-top .mdc-elevation-overlay,.mdc-tooltip__caret-surface-bottom .mdc-elevation-overlay{width:100%;height:100%;top:0;left:0}.mdc-tooltip__caret-surface-bottom{outline:1px solid rgba(0,0,0,0);z-index:-1}@media screen and (forced-colors: active){.mdc-tooltip__caret-surface-bottom{outline-color:CanvasText}}.mdc-tooltip__surface{background-color:var(--mdc-plain-tooltip-container-color, #fff)}.mdc-tooltip__surface{border-radius:var(--mdc-plain-tooltip-container-shape, var(--mdc-shape-small, 4px))}.mdc-tooltip__caret-surface-top,.mdc-tooltip__caret-surface-bottom{border-radius:var(--mdc-plain-tooltip-container-shape, var(--mdc-shape-small, 4px))}.mdc-tooltip__surface{color:var(--mdc-plain-tooltip-supporting-text-color, #000)}.mdc-tooltip__surface{font-family:var(--mdc-plain-tooltip-supporting-text-font, inherit);font-size:var(--mdc-plain-tooltip-supporting-text-size, inherit);font-weight:var(--mdc-plain-tooltip-supporting-text-weight, inherit);letter-spacing:var(--mdc-plain-tooltip-supporting-text-tracking, inherit)}.mat-mdc-tooltip{position:relative;transform:scale(0)}.mat-mdc-tooltip::before{content:"";top:0;right:0;bottom:0;left:0;z-index:-1;position:absolute}.mat-mdc-tooltip-panel-below .mat-mdc-tooltip::before{top:-8px}.mat-mdc-tooltip-panel-above .mat-mdc-tooltip::before{bottom:-8px}.mat-mdc-tooltip-panel-right .mat-mdc-tooltip::before{left:-8px}.mat-mdc-tooltip-panel-left .mat-mdc-tooltip::before{right:-8px}.mat-mdc-tooltip._mat-animation-noopable{animation:none;transform:scale(1)}.mat-mdc-tooltip-panel-non-interactive{pointer-events:none}@keyframes mat-mdc-tooltip-show{0%{opacity:0;transform:scale(0.8)}100%{opacity:1;transform:scale(1)}}@keyframes mat-mdc-tooltip-hide{0%{opacity:1;transform:scale(1)}100%{opacity:0;transform:scale(0.8)}}.mat-mdc-tooltip-show{animation:mat-mdc-tooltip-show 150ms cubic-bezier(0, 0, 0.2, 1) forwards}.mat-mdc-tooltip-hide{animation:mat-mdc-tooltip-hide 75ms cubic-bezier(0.4, 0, 1, 1) forwards}'],encapsulation:2,changeDetection:0}),n})(),$=(()=>{class n{}return n.\u0275fac=function(t){return new(t||n)},n.\u0275mod=o.oAB({type:n}),n.\u0275inj=o.cJS({providers:[N],imports:[g.rt,u.ez,v.U8,w.BQ,w.BQ,O.ZD]}),n})()}}]);