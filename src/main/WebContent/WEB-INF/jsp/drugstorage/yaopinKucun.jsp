<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true">
			<div data-options="region:'north',split:true" style="height:50px;padding-top:8px">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px;margin-left:20px" href="#" id="">新建药品</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="width:80px" href="#" id="">编辑药品</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" name="drugTypeName" style="width:90px" href="#" id="">新增分类</a>
	 			<a style="margin-left:30px">
	 				<input class="easyui-searchbox" style="width:240px">
	 			</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" style="width:80px;margin-left:15px" href="#" id="">查询所有</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;margin-left:10px" href="#" id="drug-kucun-queding">确定</a>
			</div>
			
			<div data-options="region:'west',split:true" style="width:200px">
	 			<ul id="yaoku_drug_tree" class="easyui-tree" data-options="method:'get',url:'to_select_drugType_tree'"></ul>
	 	</div>
	 	
	 	<div data-options="region:'center',split:true">
	 			<table class="easyui-datagrid"  id="drug-xx-table"
	 			data-options="fit:true,
	 						singleSelect:true,
		 					fitColumns:true,
		 					rownumbers:true,
		 					url:'to_selectDrug_ByKucun',
		 					method:'get',
			                pagination: true,
			                pageSize: 15,
			                pageList: [15, 30, 45, 60]" style="width:100%">
 					<thead>
 						<tr>
 							<th data-options="field:'drugId',width:0,align:'center'">药品编号</th>
 							<th data-options="field:'drugName',width:10,align:'center'">药品名称</th>
 							<th data-options="field:'drugJx',width:10,align:'center'">剂型</th>
 							<th data-options="field:'unit',width:10,align:'center', 
							formatter(value , row ,index){
								return row.unit == null ? null : row.unit.text;
							}">单位</th>
 							<th data-options="field:'drugYf',width:10,align:'center'">默认药房</th>
 							<th data-options="field:'drugType',width:10,align:'center',
								formatter(value , row ,index){
									return row.drugType == null ? null : row.drugType.text;
								} ">分类名称</th>
 							<th data-options="field : 'yaokuKucun' , width:10 , align : 'center',
 								formatter(value , row , index){
 									return row.yaokuKucun == null ? null : row.yaokuKucun.yaokuKucunNum
 								}
 							">库存数量</th>
 						</tr>
 					</thead>
 				</table>
	 		</div>
		</div>
</body>
</html>