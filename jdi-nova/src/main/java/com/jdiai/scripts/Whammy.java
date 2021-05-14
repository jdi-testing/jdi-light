package com.jdiai.scripts;

public class Whammy {
    public static final String script =
        "window.jdi = {}\n" +
        "jdi.Whammy=(function(){function toWebM(frames,outputAsArray){var info=checkFrames(frames);var CLUSTER_MAX_DURATION=30000;var EBML=[{\"id\":0x1a45dfa3,\"data\":[{\"data\":1,\"id\":0x4286},{\"data\":1,\"id\":0x42f7},{\"data\":4,\"id\":0x42f2},{\"data\":8,\"id\":0x42f3},{\"data\":\"webm\",\"id\":0x4282},{\"data\":2,\"id\":0x4287},{\"data\":2,\"id\":0x4285}]},{\"id\":0x18538067,\"data\":[{\"id\":0x1549a966,\"data\":[{\"data\":1e6,\"id\":0x2ad7b1},{\"data\":\"whammy\",\"id\":0x4d80},{\"data\":\"whammy\",\"id\":0x5741},{\"data\":doubleToString(info.duration),\"id\":0x4489}]},{\"id\":0x1654ae6b,\"data\":[{\"id\":0xae,\"data\":[{\"data\":1,\"id\":0xd7},{\"data\":1,\"id\":0x73c5},{\"data\":0,\"id\":0x9c},{\"data\":\"und\",\"id\":0x22b59c},{\"data\":\"V_VP8\",\"id\":0x86},{\"data\":\"VP8\",\"id\":0x258688},{\"data\":1,\"id\":0x83},{\"id\":0xe0,\"data\":[{\"data\":info.width,\"id\":0xb0},{\"data\":info.height,\"id\":0xba}]}]}]},{\"id\":0x1c53bb6b,\"data\":[]}]}];var segment=EBML[1];var cues=segment.data[2];var frameNumber=0;var clusterTimecode=0;while(frameNumber<frames.length){var cuePoint={\"id\":0xbb,\"data\":[{\"data\":Math.round(clusterTimecode),\"id\":0xb3},{\"id\":0xb7,\"data\":[{\"data\":1,\"id\":0xf7},{\"data\":0,\"size\":8,\"id\":0xf1}]}]};cues.data.push(cuePoint);var clusterFrames=[];var clusterDuration=0;do{clusterFrames.push(frames[frameNumber]);clusterDuration+=frames[frameNumber].duration;frameNumber++;}while(frameNumber<frames.length&&clusterDuration<CLUSTER_MAX_DURATION);var clusterCounter=0;var cluster={\"id\":0x1f43b675,\"data\":[{\"data\":Math.round(clusterTimecode),\"id\":0xe7}].concat(clusterFrames.map(function(webp){var block=makeSimpleBlock({discardable:0,frame:webp.data.slice(4),invisible:0,keyframe:1,lacing:0,trackNum:1,timecode:Math.round(clusterCounter)});clusterCounter+=webp.duration;return{data:block,id:0xa3};}))}\n" +
        "segment.data.push(cluster);clusterTimecode+=clusterDuration;}\n" +
        "var position=0;for(var i=0;i<segment.data.length;i++){if(i>=3){cues.data[i-3].data[1].data[1].data=position;}\n" +
        "var data=generateEBML([segment.data[i]],outputAsArray);position+=data.size||data.byteLength||data.length;if(i!=2){segment.data[i]=data;}}\n" +
        "return generateEBML(EBML,outputAsArray)}\n" +
        "function checkFrames(frames){var width=frames[0].width,height=frames[0].height,duration=frames[0].duration;for(var i=1;i<frames.length;i++){if(frames[i].width!=width)throw\"Frame \"+(i+1)+\" has a different width\";if(frames[i].height!=height)throw\"Frame \"+(i+1)+\" has a different height\";if(frames[i].duration<0||frames[i].duration>0x7fff)throw\"Frame \"+(i+1)+\" has a weird duration (must be between 0 and 32767)\";duration+=frames[i].duration;}\n" +
        "return{duration:duration,width:width,height:height};}\n" +
        "function numToBuffer(num){var parts=[];while(num>0){parts.push(num&0xff)\n" +
        "num=num>>8}\n" +
        "return new Uint8Array(parts.reverse());}\n" +
        "function numToFixedBuffer(num,size){var parts=new Uint8Array(size);for(var i=size-1;i>=0;i--){parts[i]=num&0xff;num=num>>8;}\n" +
        "return parts;}\n" +
        "function strToBuffer(str){var arr=new Uint8Array(str.length);for(var i=0;i<str.length;i++){arr[i]=str.charCodeAt(i)}\n" +
        "return arr;}\n" +
        "function bitsToBuffer(bits){var data=[];var pad=(bits.length%8)?(new Array(1+8-(bits.length%8))).join('0'):'';bits=pad+bits;for(var i=0;i<bits.length;i+=8){data.push(parseInt(bits.substr(i,8),2))}\n" +
        "return new Uint8Array(data);}\n" +
        "function generateEBML(json,outputAsArray){var ebml=[];for(var i=0;i<json.length;i++){if(!('id'in json[i])){ebml.push(json[i]);continue;}\n" +
        "var data=json[i].data;if(typeof data=='object')data=generateEBML(data,outputAsArray);if(typeof data=='number')data=('size'in json[i])?numToFixedBuffer(data,json[i].size):bitsToBuffer(data.toString(2));if(typeof data=='string')data=strToBuffer(data);if(data.length){var z=z;}\n" +
        "var len=data.size||data.byteLength||data.length;var zeroes=Math.ceil(Math.ceil(Math.log(len)/Math.log(2))/8);var size_str=len.toString(2);var padded=(new Array((zeroes*7+7+1)-size_str.length)).join('0')+size_str;var size=(new Array(zeroes)).join('0')+'1'+padded;ebml.push(numToBuffer(json[i].id));ebml.push(bitsToBuffer(size));ebml.push(data)}\n" +
        "if(outputAsArray){var buffer=toFlatArray(ebml)\n" +
        "return new Uint8Array(buffer);}else{return new Blob(ebml,{type:\"video/webm\"});}}\n" +
        "function toFlatArray(arr,outBuffer){if(outBuffer==null){outBuffer=[];}\n" +
        "for(var i=0;i<arr.length;i++){if(typeof arr[i]=='object'){toFlatArray(arr[i],outBuffer)}else{outBuffer.push(arr[i]);}}\n" +
        "return outBuffer;}\n" +
        "function toBinStr_old(bits){var data='';var pad=(bits.length%8)?(new Array(1+8-(bits.length%8))).join('0'):'';bits=pad+bits;for(var i=0;i<bits.length;i+=8){data+=String.fromCharCode(parseInt(bits.substr(i,8),2))}\n" +
        "return data;}\n" +
        "function generateEBML_old(json){var ebml='';for(var i=0;i<json.length;i++){var data=json[i].data;if(typeof data=='object')data=generateEBML_old(data);if(typeof data=='number')data=toBinStr_old(data.toString(2));var len=data.length;var zeroes=Math.ceil(Math.ceil(Math.log(len)/Math.log(2))/8);var size_str=len.toString(2);var padded=(new Array((zeroes*7+7+1)-size_str.length)).join('0')+size_str;var size=(new Array(zeroes)).join('0')+'1'+padded;ebml+=toBinStr_old(json[i].id.toString(2))+toBinStr_old(size)+data;}\n" +
        "return ebml;}\n" +
        "function makeSimpleBlock(data){var flags=0;if(data.keyframe)flags|=128;if(data.invisible)flags|=8;if(data.lacing)flags|=(data.lacing<<1);if(data.discardable)flags|=1;if(data.trackNum>127){throw\"TrackNumber > 127 not supported\";}\n" +
        "var out=[data.trackNum|0x80,data.timecode>>8,data.timecode&0xff,flags].map(function(e){return String.fromCharCode(e)}).join('')+data.frame;return out;}\n" +
        "function parseWebP(riff){var VP8=riff.RIFF[0].WEBP[0];var frame_start=VP8.indexOf('\\x9d\\x01\\x2a');for(var i=0,c=[];i<4;i++)c[i]=VP8.charCodeAt(frame_start+3+i);var width,horizontal_scale,height,vertical_scale,tmp;tmp=(c[1]<<8)|c[0];width=tmp&0x3FFF;horizontal_scale=tmp>>14;tmp=(c[3]<<8)|c[2];height=tmp&0x3FFF;vertical_scale=tmp>>14;return{width:width,height:height,data:VP8,riff:riff}}\n" +
        "function parseRIFF(string){var offset=0;var chunks={};while(offset<string.length){var id=string.substr(offset,4);var len=parseInt(string.substr(offset+4,4).split('').map(function(i){var unpadded=i.charCodeAt(0).toString(2);return(new Array(8-unpadded.length+1)).join('0')+unpadded}).join(''),2);var data=string.substr(offset+4+4,len);offset+=4+4+len;chunks[id]=chunks[id]||[];if(id=='RIFF'||id=='LIST'){chunks[id].push(parseRIFF(data));}else{chunks[id].push(data);}}\n" +
        "return chunks;}\n" +
        "function doubleToString(num){return[].slice.call(new Uint8Array((new Float64Array([num])).buffer),0).map(function(e){return String.fromCharCode(e)}).reverse().join('')}\n" +
        "function WhammyVideo(speed,quality){this.frames=[];this.duration=1000 / speed;this.quality=quality||0.8;}\n" +
        "WhammyVideo.prototype.add=function(frame,duration){if(typeof duration!='undefined'&&this.duration)throw\"you can't pass a duration if the fps is set\";if(typeof duration=='undefined'&&!this.duration)throw\"if you don't have the fps set, you ned to have durations here.\";if(frame.canvas){frame=frame.canvas;}\n" +
        "if(frame.toDataURL){frame=frame.toDataURL('image/webp',this.quality)}else if(typeof frame!=\"string\"){throw\"frame must be a a HTMLCanvasElement, a CanvasRenderingContext2D or a DataURI formatted string\"}\n" +
        "if(!(/^data:image\\/webp;base64,/ig).test(frame)){throw\"Input must be formatted properly as a base64 encoded DataURI of type image/webp\";}\n" +
        "this.frames.push({image:frame,duration:duration||this.duration})}\n" +
        "WhammyVideo.prototype.compile=function(outputAsArray){return new toWebM(this.frames.map(function(frame){var webp=parseWebP(parseRIFF(atob(frame.image.slice(23))));webp.duration=frame.duration;return webp;}),outputAsArray)}\n" +
        "return{Video:WhammyVideo,fromImageArray:function(images,fps,outputAsArray){return toWebM(images.map(function(image){var webp=parseWebP(parseRIFF(atob(image.slice(23))))\n" +
        "webp.duration=1000 / fps;return webp;}),outputAsArray)},toWebM:toWebM}})();\n" +
        "\n" +
        "jdi.recording = true;\n" +
        "jdi.frames =[];\n" +
        "jdi.addFrame = function() { html2canvas(element).then((canvas) => { jdi.frames.push(canvas.toDataURL('image/webp')); })};\n" +
        "jdi.record = function() { setTimeout(() => { jdi.addFrame(); if (jdi.recording) { jdi.record(); } }, 1)};\n" +
        "jdi.compile = function() { \n" +
        "let reader = new FileReader();\n" +
        "reader.onloadend = () => jdi.videoBase64 = reader.result;\n" +
        "reader.readAsDataURL(jdi.Whammy.fromImageArray(jdi.frames,100));\n" +
        "}\n" +
        "jdi.record();";
}
