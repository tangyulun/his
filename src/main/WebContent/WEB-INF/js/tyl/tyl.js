//选择住院门诊号打开窗口
var beMenZhen = function(rollback){
	var win = connWindowP('href_address?myValue=behospitalized/guahaojilu_window' ,"选择挂号" , 800 , 500 );
	rollbackResultH("#clinic-table" , win , rollback ,"#regist-queding");
}

//获取参数
function rollbackResultH(datagridId , win , rollback , buttonId){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onDblClickRow : function(index , row){
			$.getJSON("query_prescrition",{outpaitentRegistId : row.outpaitentRegistId},function(data){
				if(data.error){
					$.messager.alert('提示' , '该门诊号已在别处办理业务！不能重复办理！');
				}else{
					rollback(row);
					win.window('destroy');
				}
			});
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$(buttonId).linkbutton({onClick : function(){
			var row = $(datagridId).datagrid('getSelected');
			$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
				if(data.error){
					$.messager.alert('提示' , '该门诊号已存在处方记录，不得重复处理！');
				}else{
					rollback(row);
					win.window('destroy');
				}
			});
		}});
	}})
	win.window({onClose : function(){
		win.window('destroy');
	}});
}

//打开住院通知选择窗口
var zhuyuantongzhiwindow = function(rollback , state){
	var win = connWindowP('href_address?myValue=/behospitalized/zhuyuantongzhi_window' ,"选择通知" , 800 , 460 );
	rollbackResultTongzhi("#zytz-table" , win , rollback ,"#zhuyuantongzhi-queding" , state);
	
}

//打开床位安排
var bedanpai = function(rollback){
	var win = connWindowP('href_address?myValue=/behospitalized/bed_window' ,"选择病床" , 800 , 500 );
	rollbackResultBed("#select_bed_type" , win , rollback ,"#win_bed-btn_ok");
}


//查询查询住院登记记录
var selectZhuyuanJilu = function(rollback){
	var win = connWindowP('href_address?myValue=/behospitalized/zhuyuandengji_window' ,"选择住院登记" , 800 , 460 );
	rollbackResult("#zydj-table" , win , rollback ,"#zhuyuandengji-queding");
}

//获取参数
function rollbackResultBed(datagridId , win , rollback , buttonId){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onDblClickRow : function(index , row){
			if(row.houseState== '未占用'){
				rollback(row);
				win.window('destroy');
			}else{
				$.messager.alert("提示" , "该床位已占用！");
			}
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$(buttonId).linkbutton({onClick : function(){
			var row = $(datagridId).datagrid('getSelected');
			if(row.houseState== '未占用'){
				rollback(row);
				win.window('destroy');
			}else{
				$.messager.alert("提示" , "该床位已占用！");
			}
		}});
	}})
	win.window({onClose : function(){
		win.window('destroy');
	}});
}

//护院通知获取参数
function rollbackResultTongzhi(datagridId , win , rollback2 , buttonId , state){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onLoadSuccess : function(){
			var rows = $(datagridId).datagrid("getRows");
			for (var i = rows.length-1; i >=0; i--) {
				if(rows[i].hospitalNotifyState != state){
					$(datagridId).datagrid("deleteRow" , i);
				}
			}								
		}});
		
		$(datagridId).datagrid({onDblClickRow : function(index , row){
			rollback2(row);
			win.window('destroy');
		}});
		//点击选择收费项目的某一行数据，传入收费记录文本框
		$(buttonId).linkbutton({onClick : function(){
			var row = $(datagridId).datagrid('getSelected');
				rollback2(row);
				win.window('destroy');
		}});
	}})
	win.window({onClose : function(){
		win.window('destroy');
	}});
}