
var selectYaoPingAll = function(rollback){
	var win = connWindowP('href_address?myValue=/drugstorage/Drug_window' , "查询所有药品" , 800 , 500);
	rollbackResult("#drug-table-t" , win , rollback ,"#drug_queding");
}


var selectCaigouDingdan = function(rollback){
	var win = connWindowP('href_address?myValue=/drugstorage/open_caigouguadan_window' , "查询所有订单" , 850 , 500);
	rollbackResult("#dingdan_table" , win , rollback ,"#guadan_queding");
}

var selectCaigouDingdantjian = function(rollback , state){
	var win = connWindowP('href_address?myValue=/drugstorage/open_caigouguadan_window' , "查询所有采购单" , 850 , 500);
	rollbackResultTjian("#dingdan_table" , win , rollback ,"#guadan_queding" , state);
}

var selectYanshouRuku = function(rollback , state){
	var win = connWindowP('href_address?myValue=/drugstorage/yanshou_window' , "查询所有验收单" , 850 , 500);
	rollbackResultYanShouruKu("#guadan_table" , win , rollback ,"#yanshou_queding22" , state);
}

//获取参数
function rollbackResultYanShouruKu(datagridId , win , rollback , buttonId , state){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onLoadSuccess : function(){
			var rows = $(datagridId).datagrid("getRows");
			for (var i = rows.length-1; i >=0; i--) {
				if(rows[i].drugAcceptanceZt != state){
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

//获取参数
function rollbackResultTjian(datagridId , win , rollback , buttonId , state){
	win.window({onLoad : function(){
		$(datagridId).datagrid({onLoadSuccess : function(){
			var rows = $(datagridId).datagrid("getRows");
			for (var i = rows.length-1; i >=0; i--) {
				if(rows[i].drugPurchaseZt != state){
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