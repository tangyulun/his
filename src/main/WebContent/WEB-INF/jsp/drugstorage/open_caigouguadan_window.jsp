<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购挂单</title>
</head>
<body>
		 	<div class="easyui-layout" data-options="fit : true">
		 		<div data-options="region:'north',split:true" style="height:50px;padding-top:10px;padding-left:30px">
		 			<a><input class="easyui-datebox" name="" id="startdate" value="new Data()" data-options="width:120,labelAlign:'right',editable : false"> 至</a>
		 			<a><input class="easyui-datebox" name="" id="enddate" value="new Data()" data-options="width:120,labelAlign:'right',editable : false"></a>
		 			<a style="margin-left:15px"><input class="easyui-searchbox" id="drugPurchaseId" style="width:200px" data-options="
		 				searcher : function(value,name){
		 						if(!value){
		 							$('#dingdan_table').datagrid('reload','to_find_caigou_dingdan_fenye');
		 							return;
		 						}
		 						$('#dingdan_table').datagrid({url : 'to_mohu_find_dingdan'});
		 						$('#dingdan_table').datagrid('load', {drugPurchaseId : value});
		 					}
		 			"></a>
		 			<a class="easyui-linkbutton" name="" data-options="iconCls:'icon-search',plain:true" id="gaoji_find" style="width:80px;margin-left:10px">搜索</a>
		 			<a class="easyui-linkbutton" name=""  data-options="iconCls:'icon-reload',plain:true" id="showAll" style="width:80px;margin-left:10px">显示所有</a>
		 			<a class="easyui-linkbutton guadan_queding" name="" data-options="iconCls:'icon-ok',plain:true" id="guadan_queding" style="width:80px;margin-left:10px">确定</a>
		 		</div>
		 		<div data-options="region : 'center' , split : true" style="width : 350px ; height : 350px">
		 			<table class="easyui-datagrid dingdan_table" id="dingdan_table" data-options="fit:true , singleSelect:true , fitColumns: true ,
		 				rownumbers:true, method : 'get',url : 'to_find_caigou_dingdan_fenye',pageSize: 15,pagination: true,
			                pageList: [15, 30, 45, 60]" style="width:100%">
		 				<thead>
		 					<tr>
		 						<th data-options="field:'drugPurchaseId',width:13,align:'center'">采购单号</th>
		 						<th data-options="field:'drugPurchaseMoney',width:8,align:'center'">金额</th>
		 						<th data-options="field:'drugPurchaseDhdate',width:10,align:'center' , formatter : date">订货日期</th>
		 						<th data-options="field:'drugPurchaseGhdate',width:10,align:'center' , formatter : date">供货日期</th>
		 						<th data-options="field:'drugPurchaseJhdz',width:10,align:'center'">交货地点</th>
		 						<th data-options="field:'emp',width:10,align:'center',
		 							formatter(value , row ,index){
 										return row.emp == null ? null : row.emp.empLoginName;
 									}
		 						">采购员</th>
		 						<th data-options="field:'supplier',width:10,align:'center',
		 							formatter(value , row ,index){
 										return row.supplier == null ? null : row.supplier.supplierName;
 									}
		 						">供应商</th>
		 						<th data-options="field:'drugPurchaseZt',width:10,align:'center'">状态</th>
		 					</tr>
		 				</thead>
		 			</table>
		 		</div>
		 	</div>
		 	
		 	<script type="text/javascript">
		 	$(function(){
		 		//点击按钮显示所有
		 		$("#showAll").linkbutton({onClick : function(){
		 			$("#dingdan_table").datagrid('reload','to_find_caigou_dingdan_fenye');
		 		}});
		 		
		 		$("#gaoji_find").linkbutton({onClick : function(){
		 			var startTime = $("#startdate").datebox('getValue');
		 			var endTime = $("#enddate").datebox('getValue');
		 			var drugPurchaseId = $("#drugPurchaseId").textbox('getValue');
		 			$("#dingdan_table").datagrid({url : 'to_select_startToend_gaoji'});
		 			$("#dingdan_table").datagrid('load' , {startTime : startTime , endTime : endTime , drugPurchaseId : drugPurchaseId});
		 		}});
		 	});
		 	</script>
</body>
</html>