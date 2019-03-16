//打开收费项目窗口
var comm = function(rollback){
	var win = connWindowP('href_address?myValue=outpatient/regist_financialwindow' ,"选择收费项目" , 820 , 500 );
	rollbackResult("#financial-tb" , win , rollback ,"#financial-queding");
}

//打开供应商选择窗口
var gyscomm = function(rollback){
	var win = connWindowP('href_address?myValue=/drugstorage/supplier_window' , "选择供应商" , 900 , 550);
	rollbackResult("#tab" , win , rollback ,"#queding_to_one");
}

//选择器械采购打开
var selectcgopen = function(rollback){
	var win = connWindowP('href_address?myValue=/instrument/instrument_to_window' , "查询采购订单" , 800 , 400);
	rollbackResult("#sb" , win , rollback ,"#registration-sure");
}


//验收器械采购打开
var seelctQxYanshou = function(rollback , state){
	var win = connWindowP('href_address?myValue=/instrument/instrument_to_window' , "查询采购订单" , 800 , 400);
	rollbackQxYanshou("#sb" , win , rollback ,"#registration-sure" , state);
}
//选择要库存打开窗口
var kucunWindow = function(rollback){
	var win = connWindowP('href_address?myValue=drugstorage/yaopinKucun' , "查询药品" , 800 , 500);
	rollbackResult("#drug-xx-table" , win , rollback ,"#drug-kucun-queding");
}
//选择器械
var selectqx = function(rollback){
	var win = connWindowP('href_address?myValue=/instrument/instrumeng_CK_window' , "选择器械" , 800 ,500);
	rollbackResult("#select_instrument_type" , win , rollback ,"#select_qx_name");
}
//门诊窗口
var menzhengh = function(rollback , state , wo){
	var win = $("<div id='windows'>").window({
		width:900,    
	    height:500,    
	    modal:true,
	    title : "选择挂号",
	    collapsible:false,
	 	minimizable:false,
	 	maximizable:false,
	    href : "href_address?myValue=outpatient/regist_datagridselect"
	});
	win.window({onClose : function(){
		win.window('destroy');
	}});
	win.window({onLoad : function(){
		if(state == "已处理" || state == '已划价' || state == '已结算'){
			$("#select_datagrid").datagrid({onLoadSuccess : function(){
				var rows = $(this).datagrid("getRows");
				for (var i = rows.length-1; i >=0; i--) {
					if(rows[i].outpaitentRegistZhuangtai != state){
						$("#select_datagrid").datagrid("deleteRow" , i);
					}
				}								
			}});
		}
		
		$("#select_datagrid").datagrid({onDblClickRow : function(index , row){
			if(wo == 'wo'){
				$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
					if(data.error){
						$.messager.alert('提示' , '该门诊号已存在处方记录，不得重复处理！');
					}else{
						rollback(row);
						win.window('destroy');
					}
				});
			}else{
				rollback(row);
				win.window('destroy');
			}
			
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$("#save-linkbutton").linkbutton({onClick : function(){
			var row = $("#select_datagrid").datagrid('getSelected');
			if(wo == 'wo'){
				$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
					if(data.error){
						$.messager.alert('提示' , '该门诊号已存在处方记录，不得重复处理！');
					}else{
						rollback(row);
						win.window('destroy');
					}
				});
			}else{
				rollback(row);
				win.window('destroy');
			}
		}});
	}})
	win.window("open");
}


//门诊窗口
var menzhengh2 = function(rollback , state){
	var win = $("<div id='windows'>").window({
		width:900,    
	    height:500,    
	    modal:true,
	    title : "选择挂号",
	    collapsible:false,
	 	minimizable:false,
	 	maximizable:false,
	    href : "href_address?myValue=outpatient/regist_datagridselect"
	});
	win.window({onClose : function(){
		win.window('destroy');
	}});
	win.window({onLoad : function(){
		if(state == "已处理"){
			$("#select_datagrid").datagrid({onLoadSuccess : function(){
				var rows = $(this).datagrid("getRows");
				for (var i = rows.length-1; i >=0; i--) {
					if(rows[i].outpaitentRegistZhuangtai != state){
						$("#select_datagrid").datagrid("deleteRow" , i);
					}
				}								
			}});
		}
		$("#select_datagrid").datagrid({onDblClickRow : function(index , row){
			//后台查询
			$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
				if(data.error){
					$("#pricemanagement-eletronic").textbox('setValue' , data.eMessage);
					rollback(row);
					win.window('destroy');
				}else{
					$.messager.alert('提示' , '没有该门诊号的处方记录！');
					return ;
				}
			});
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$("#save-linkbutton").linkbutton({onClick : function(){
			var row = $("#select_datagrid").datagrid('getSelected');
			//后台查询
			$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
				if(data.error){	
					$("#pricemanagement-eletronic").textbox('setValue' , data.eMessage);
					rollback(row);
					win.window('destroy');
				}else{
					$.messager.alert('提示' , '没有该门诊号的处方记录！');
					return ;
				}
			});
		}});
	}})
	win.window("open");
}

//获取共同的窗口对象
function connWindowP(href , title , width , height){
	var win = $("<div id='windows'>").window({
		width:width,    
	    height:height,    
	    modal:true,
	    title : title,
	    href : href,
	    collapsible:false,
	 	minimizable:false,
	 	maximizable:false
	});
	win.window("open");
	return win;
}


//获取参数
function rollbackResult(datagridId , win , rollback , buttonId){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onDblClickRow : function(index , row){
			rollback(row);
			win.window('destroy');
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$(buttonId).linkbutton({onClick : function(){
			var row = $(datagridId).datagrid('getSelected');
			rollback(row);
			win.window('destroy');
		}});
	}})
	win.window({onClose : function(){
		win.window('destroy');
	}});
}


//获取参数
function rollbackQxYanshou(datagridId , win , rollback , buttonId , state){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onLoadSuccess : function(){
			var rows = $(this).datagrid("getRows");
			for (var i = rows.length-1; i >=0; i--) {
				if(rows[i].instrumentCaigouState != state){
					$(datagridId).datagrid("deleteRow" , i);
				}
			}								
		}});
		$(datagridId).datagrid({onDblClickRow : function(index , row){
			rollback(row);
			win.window('destroy');
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$(buttonId).linkbutton({onClick : function(){
			var row = $(datagridId).datagrid('getSelected');
			rollback(row);
			win.window('destroy');
		}});
	}})
	win.window({onClose : function(){
		win.window('destroy');
	}});
}