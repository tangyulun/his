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
	 		<!-- <div data-options="region:'north',split:true" style="height:50px;padding-top:10px;padding-left:30px">
	 			<a><input class="easyui-datebox" name="" id="" value="new Data()" data-options="width:120,labelAlign:'right',editable : false"> 至</a>
	 			<a><input class="easyui-datebox" name="" id="" value="new Data()" data-options="width:120,labelAlign:'right',editable : false"></a>
	 			<a style="margin-left:15px"><input class="easyui-searchbox" id="" style="width:200px" data-options=""></a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" name="" id="" style="width:80px;margin-left:10px">搜索</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" name="" id="" style="width:80px;margin-left:10px">显示所有</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" name="" id="tuihuo-yanshou-window-button" style="width:80px;margin-left:10px">确定</a>
	 		</div> -->
	 		<div data-options="region : 'center' , split : true" style="width : 350px ; height : 350px">
	 			<table class="easyui-datagrid " id="tuihuo-table" data-options="fit:true , 
	 			singleSelect:true , fitColumns: true ,rownumbers:true,
	 				 method : 'get',url : 'to_find_Nohege_jilu',pageSize: 15,pagination: true,
		                pageList: [15, 30, 45, 60]" style="width:100%">
	 				<thead style="margin-left:10px;">
						<tr>
							<th data-options="field:'drugAcceptanceId',width:10,align:'center'">验收单号</th>
							<th data-options="field:'drugAcceptanceShdate',width:10,align:'center', formatter : date">收货日期</th>
							<th data-options="field:'drugAcceptancePzdh',width:10,align:'center'">凭证单号</th>
	 						<th data-options="field:'drugAcceptanceZt',width:10,align:'center'">验收状态</th>
						</tr>
					</thead>
	 			</table>
	 		</div>
</body>
</html>