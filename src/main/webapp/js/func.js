$.extend($.fn.validatebox.defaults.rules,{
			//长度至少6位
			minLength:{
				validator:function(val,params){
					return val.length>params[0];
				},
				message:"长度至少{0}位"
			},
			//判断是否是数字
			isNumber:{
				validator:function(val){
					return !isNaN(val);
				},
				message:"必须是数字"
			},
			//两次输入必须相同
			isEqual:{
				validator:function(val,params){
					var inputVal = $(params[0]).val();
					return val==inputVal;
				},
				message:"两次输入必须相同"
			},
			//长度区间
			rangeLength:{
				validator:function(val,params){
					return val.length>=params[0] && val.length<=params[1];
				},
				message:"长度必须在{0}到{1}之间"
			}
		});
	//全局日期格式
	$.fn.datebox.defaults.formatter=function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+"/"+m+"/"+d;
	};
	$.fn.datebox.defaults.parser=function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	};
	