<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<title>药品登入</title>
</head>
<body>
	<div id="" class="easyui-layout" title="药品登入" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
			<a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">处理</a>
		</div>
		<div data-options="region:'center',split:true" style="height:3000px">
			<form action="" method="post" id="">
				<table  width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td colspan="2">
							<input class="easyui-textbox" data-options="label:'药品*',width:200,labelAlign:'right'">
		 					<input name="" class="easyui-textbox" data-options="required:true,width:240">
						    <a id="" href="#" class="easyui-linkbutton" data-options="" style="width:30px;height:22px">…</a> 
						</td>
						<td><input class="easyui-combobox" data-options="label:'仓库',width:240,labelAlign:'right',valueField:'',textField:'',url:''"></td>
						<td><input class="easyui-textbox" data-options="label:'数量',width:240,labelAlign:'right',value:'0'"></td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" data-options="label:'采购单价',width:240,labelAlign:'right',value:'0.00'"></td>
						<td><input class="easyui-datebox" data-options="label:'生产日期',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-datebox" data-options="label:'有效期至',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-datebox" data-options="label:'采购日期',width:240,labelAlign:'right'"></td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" data-options="label:'有效天数',width:240,labelAlign:'right',value:'0'"></td>
						<td><input class="easyui-textbox" data-options="label:'批号',width:240,labelAlign:'right'"></td>
						<td colspan="2">
 							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px;height:22px;margin-left:240px;">加入</a>
 							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px;height:22px;">删除</a>
 						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',split:true" style="height:340px">
			<table class="easyui-datagrid" style="width:100%">
				<thead style="margin-left:10px;height:200px">
					<tr>
						<th data-options="field:'x',width:30,align:'center'">*</th>
						<th data-options="field:'ypbh',width:80,align:'center'">药品编号</th>
						<th data-options="field:'ypmc',width:80,align:'center'">药品名称</th>
						<th data-options="field:'ypfc',width:80,align:'center'">分仓</th>
						<th data-options="field:'ypph',width:80,align:'center'">批号</th>
						<th data-options="field:'ypsl',width:80,align:'center'">数量</th>
						<th data-options="field:'ypdj',width:80,align:'center'">单位</th>
						<th data-options="field:'scrq',width:80,align:'center'">生产日期</th>
						<th data-options="field:'bzqz',width:80,align:'center'">保质期至</th>
						<th data-options="field:'cgrq',width:80,align:'center'">采购日期</th>
						<th data-options="field:'bzts',width:80,align:'center'">保质天数</th>
						<th data-options="field:'cgdj',width:80,align:'center'">采购单价</th>
						<th data-options="field:'txm',width:80,align:'center'">条形码</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>