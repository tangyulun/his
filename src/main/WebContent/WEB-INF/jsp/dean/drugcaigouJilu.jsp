<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<title>药品采购查询</title>
</head>
<body>
	<div class="easyui-layout" title="药品采购记录汇总" data-options="fit : true,border:false">
		<div data-options="region : 'north',border:false"  style="height : 45%">
			<table data-options="
					fit : true,
					border:false,
					rownumbers:true,
					singleSelect : true,
					fitColumns: true,
					method : 'get',
					toolbar : '#caigou_jilu_tb',
					pagination: true,
	                pageSize: 5,
	                pageList: [5, 10, 15, 20],
					url : 'select_caigouJilu_all'" class="easyui-datagrid" id="caigou_jilu_table">
				<thead>
					<tr>
						<th data-options="field:'drugPurchaseId',width:100,align:'center'">采购订单号</th>
						<th data-options="field:'drugPurchaseDhdate',width:100,align:'center' , formatter : date">订货日期</th>
						<th data-options="field:'drugPurchaseGhdate',width:100,align:'center' , formatter : date">到货日期</th>
						<th data-options="field:'drugPurchaseMoney',width:100,align:'center'">采购金额</th>
						<th data-options="field:'drugPurchaseJhdz',width:100,align:'center'">交货地址</th>
						<th data-options="field:'emp',width:100,align:'center',
							formatter(value , row ,index){
									return row.emp == null ? null : row.emp.empLoginName;
							}">采购员</th>
						<th data-options="field:'supplier',width:100,align:'center',
							formatter(value , row ,index){
								return row.supplier == null ? null : row.supplier.supplierName;
							}">供应商</th>
						<th data-options="field:'drugPurchaseZt',width:100,align:'center'">状态</th>
					</tr>
				</thead>
			</table>
		</div>
		
		<div data-options="region : 'center',border:false" style="height : 55%">
			<table class="easyui-datagrid" data-options="fit : true,
					rownumbers : true,
					singleSelect : true,
					border:false,
					fitColumns : true,
					method : 'get'" id="caigou_jilu_xq_table">
				<thead>
					<tr>
						<th data-options="field : 'drugId' , width : 100 , align : 'center',
							formatter(value , row ,index){
									return row.drug == null ? null : row.drug.drugId;
							}">药品编号</th>
						<th data-options="field : 'drugName' , width : 100 , align : 'center',
							formatter(value , row ,index){
									return row.drug == null ? null : row.drug.drugName;
							}">药品名称</th>
						<th data-options="field : 'drugPurchaseDetailsDj' , width : 100 , align : 'center'">采购单价</th>
						<th data-options="field : 'drugPurchaseDetailsJe' , width : 100 , align : 'center'">采购金额</th>
						<th data-options="field : 'drugPurchaseDetailsNum' , width : 100 , align : 'center'">采购数量</th>
						<th data-options="field : 'drugPurchaseDetailsPh' , width : 100 , align : 'center'">批号</th>
						<th data-options="field : 'drugPurchaseDetailsBz' , width : 100 , align : 'center'">备注</th>
					</tr>
				</thead>
			</table>
		</div>
		
		<div id="caigou_jilu_tb">
			<a style="margin-left: 20px">
					<input class="easyui-searchbox" id="drugPurchaseId_caigou" 
					 data-options="label : '采购单号/供应商' , labelAlign : 'right' , labelWidth :100, width:230,
					 searcher : function(value,name){
						if(!value){
							$('#caigou_jilu_table').datagrid('reload','select_caigouJilu_all');
							return;
						}
						$('#caigou_jilu_table').datagrid({url : 'to_select_By_IdAndSup'});
						$('#caigou_jilu_table').datagrid('load', {supplierName : value , drugPurchaseId : value});
					}">
				</a>
			<a style="margin-left: 20px"><input class="easyui-datebox" id="startTime" value="new Date()" data-options="width:150,labelAlign:'right',editable : false"></a> 至
			<a><input class="easyui-datebox" value="new Date()" id="endTime" data-options="width:150,labelAlign:'right',editable : false"></a>
			
			<a>
				<select class="easyui-combobox" id="start" name="" 
					data-options="required:true,editable:false,label:'状态',width:180,labelAlign:'right'" >   
				   <option value="全部">全部</option>   
				    <option value="未处理">未处理</option>   
				    <option value="已处理">已处理</option>  
				     <option value="未验收">未验收</option>   
				    <option value="已验收">已验收</option>  
				     <option value="已入库">已入库</option>   
				    <option value="已退货">已退货</option>   
				    <option value="已出库">已出库</option>   
				    <option value="已盘点">已盘点</option>   
				</select> 
			</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" id="gaoji_find_caigou" style="width:80px; margin-left :　25px">搜索</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" id="gaoji_find_sousuo_all" style="width:80px;">显示所有</a>
		</div>
		
	</div>
	
	
	<script type="text/javascript">
		$(function(){
			$("#caigou_jilu_table").datagrid({onClickRow : function(){
				var rows = $("#caigou_jilu_table").datagrid("getSelected");
				$("#caigou_jilu_xq_table").datagrid({url : 'to_select_xq_by_drugPurchaseId'});
				$("#caigou_jilu_xq_table").datagrid('load' , {drugPurchaseId : rows.drugPurchaseId});
				/* $("#caigou_jilu_table").datagrid({url : 'select_caigouJilu_all'}); */
			}});
			
			$("#gaoji_find_caigou").linkbutton({onClick : function(){
				var startTime = $("#startTime").datebox("getValue");
				var endTime = $("#endTime").datebox("getValue");
				var drugPurchaseZt = $("#start").combobox("getValue");
				var drugPurchaseId = $("#drugPurchaseId_caigou").textbox("getValue");
				/* alert(endTime);
				alert(drugPurchaseZt);
				alert(drugPurchaseId); */
				$("#caigou_jilu_table").datagrid({url : 'to_gaoji_find_by_time_id_zt'});
				$("#caigou_jilu_table").datagrid('load' , {startTime : startTime , endTime : endTime ,
					drugPurchaseId : drugPurchaseId , drugPurchaseZt : drugPurchaseZt});
			}});
			
			$("#gaoji_find_sousuo_all").linkbutton({onClick : function(){
				$('#caigou_jilu_table').datagrid({url : 'select_caigouJilu_all'});
				$('#caigou_jilu_xq_table').datagrid('reload');
			}});
		});
	</script>
	
	
	
</body>
</html>